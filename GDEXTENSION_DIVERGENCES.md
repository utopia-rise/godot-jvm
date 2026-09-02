# Master (module) vs. GDExtension: significant implementation divergences

This documents every place where the GDExtension port (`rework/gdextension`) had to use a
**genuinely different mechanism** than the Godot-module `master` branch — not renames or
signature tweaks, but a different API family, a different control-flow shape, or something with
no public equivalent godot-cpp exposes at all. Compiled from a full master-vs-branch review plus
the build-fix pass that got both `editor` and `template_release` targets compiling and linking.

Two items below were corrected mid-investigation after being challenged — see the "Corrected"
notes. Two items are still open decisions, not yet acted on — see "Open follow-up" at the bottom.

## Script instance ABI (foundational)

- **Whole instance model**: master subclassed Godot's C++ `ScriptInstance` directly (virtual
  dispatch, real C++ types). GDExtension has no such class — instead you populate a
  `GDExtensionScriptInstanceInfo3`, a struct of C function pointers keyed to an opaque
  `GDExtensionScriptInstanceDataPtr`, using raw ABI types (`GDExtensionBool`,
  `GDExtensionVariantPtr`, `GDExtensionPropertyInfo`, `GDExtensionMethodInfo`,
  `GDExtensionCallError`) instead of C++ objects/references.
- **Attaching an instance to an object**: master called `owner->set_script_instance(instance)`
  directly. No such entry point exists for GDExtensions — the port calls `owner->set_script(this)`
  and relies on the engine's own internal machinery to create the instance via the registered
  `GDExtensionScriptInstanceInfo3`. This is a workaround (flagged with a TODO in
  `jvm_script.cpp`), not a full equivalent.
- **RPC config reporting**: master's `ScriptInstance` had a per-instance `get_rpc_config()` the
  engine queried live. `GDExtensionScriptInstanceInfo3` has no RPC-config function pointer at
  all — the capability moved up to the `Script`-level `_get_rpc_config()` virtual instead.
- **Method/property-info marshaling — corrected, prior work already existed**: godot-cpp provides
  a whole-list converter for `PropertyInfo` (`internal::create_c_property_list`/
  `free_c_property_list`) but nothing for `MethodInfo` lists or for converting a single
  `PropertyInfo` in place (needed by `validate_property`, `get_method_list`/`free_method_list`).
  Initially hand-written from scratch into a new file, `src/engine/method_info_conversion.{h,cpp}`,
  believing no prior attempt existed. **This was wrong** — a matching `godot::internal::
  convert_property_to_c`/`create_c_method_list`/`free_c_method_list` implementation already
  existed in `src/engine/internal.{h,cpp}` (same on `origin/rework/gdextension`), but it was
  silently broken in two ways: (1) `internal.cpp` opened `namespace internal { ... }` at *global*
  scope instead of `godot::internal` — `using namespace godot;` earlier in the file does **not**
  make an unqualified `namespace internal {}` block extend `godot::internal`; namespace-reopening
  is purely lexical and ignores using-directives — so it defined a disconnected `::internal::*`
  that could never satisfy the `godot::internal::*` declarations the rest of the code calls, and
  would never have linked; (2) `create_c_method_list`'s loop never incremented its index, so every
  method overwrote array slot 0 and the rest of the array was uninitialized garbage. Because that
  file was dead code, the new from-scratch file accidentally became the one satisfying the
  linker — duplicating the same three declarations under two names. Consolidated: fixed both bugs
  in `src/engine/internal.{h,cpp}` (the intended, pre-existing location) and deleted
  `method_info_conversion.{h,cpp}` entirely, updating the two call sites'
  (`jvm_instance.cpp`/`jvm_placeholder_instance.cpp`) includes accordingly.
- **`Object::get_class_name()`**: master's virtual, dynamic-dispatch class-name lookup has no
  direct analog. The similarly-named `get_class_static()` is a **non-virtual, compile-time-per-type
  static method** that silently returns the wrong answer through a base pointer (always
  `"Object"`). The real equivalent is the differently-named `get_class()` (confirmed: it ptrcalls
  the engine's own `get_class` method-bind). Fixed in `src/core/jvm_binding.cpp`.

- **Calling a built-in engine method from `TransferContext::icall` (game-mode-only bug, fixed)**:
  master's `TransferContext::icall` casts the cached pointer to the engine's real `MethodBind*` and
  calls `->call(Object*, ...)` — a genuine C++ virtual call, since master's `MethodBind` is the
  engine's own class. The port copied this pattern verbatim, but `ClassDB::classdb_get_method_bind`
  on the GDExtension side returns an opaque `GDExtensionMethodBindPtr` handle with **no C++ object
  behind it at all** — reinterpret-casting it to `godot::MethodBind*` and calling through it is
  undefined behavior (it happened to run once before corrupting memory and crashing on the next use
  of the bogus return `Variant`). The only correct way to invoke it is
  `internal::gdextension_interface_object_method_bind_call(method_bind, raw_object_ptr, args,
  arg_count, &ret, &error)` — passing the raw `GDExtensionObjectPtr`, no godot-cpp wrapper needed at
  all. This went unnoticed for a long time because it only triggers when a script instance calls a
  built-in method on itself (e.g. `Label.setText()` from `_ready()`), and `_ready()` never runs for
  ordinary scene nodes in editor mode — only in exported/game-mode runs. Fixed in
  `src/jvm/wrapper/memory/transfer_context.cpp`.
- **Pre-existing scene node script instantiation sent the wrapper's address, not the raw pointer
  (game-mode-only bug, fixed)**: for a script attached to an already-existing scene node,
  `KtConstructor::create_instance` (`src/jvm/wrapper/registration/kt_constructor.cpp`) passed
  `to_jni_arg(p_owner)` to Kotlin as the instance's "native self pointer" — `p_owner` being the
  godot-cpp *wrapper* `Object*`, whose address has nothing to do with the real engine object. Master
  has no such distinction (its `Object*` already *is* the raw engine pointer), so this only affects
  the port. Kotlin stores whatever it's given and hands it straight back on every subsequent
  self-call, so every such call decoded a wrapper address as if it were the raw `GodotObject*` — the
  fix is to pass `p_owner->_owner` instead. Same "only exercised in game mode" blind spot as above.

## Variant / Callable / packed-array bridging

- **Packed array backing type**: master could use the generic `Vector<T>` directly as bridge
  storage with free implicit conversion to/from `Variant`. GDExtension's `Variant` has no
  conversion to/from generic `Vector<T>` at all — only to the concrete `Packed*Array` types. The
  whole bridge template (`src/jvm/wrapper/bridge/packed_array_bridge.h`) was restructured around a
  compile-time trait mapping each element type to its real `Packed*Array` type. Files touched:
  `packed_array_bridge.h` (core rewrite) plus `packed_byte_array_bridge.cpp`,
  `packed_float_32/64_array_bridge.cpp`, `packed_int_32/64_array_bridge.cpp`,
  `packed_color_array_bridge.cpp` (each had their own separate leftover `Vector<T>` in their
  per-type conversion methods). `packed_string/vector2/3/4_array_bridge.cpp` needed no direct
  edits — they already used the concrete type in their own conversion methods.
- **Dynamic-arity deferred calls**: `call_deferred()` is a variadic-template-only signature (no
  Array/pointer-array overload) — bridging a JNI call with a runtime-determined argument count
  requires a hand-written 17-way `switch` unpacking 0–16 positional arguments into the template
  call. (An alternative was investigated — `callable->bindv(args_array).call_deferred()`, binding
  the dynamic Array first since `bindv()` is real and Array-based, then deferring with zero further
  arguments — and it does work and compiles. Deliberately kept as the explicit switch instead, by
  request, rather than switched to the `bindv` composition.) Implemented in
  `src/jvm/wrapper/bridge/callable_bridge.cpp`.
- **Dynamic-arity call/bind**: similarly, master's `callp`/`bindp` (pointer array + count) and
  `Callable::CallError` don't exist in godot-cpp; only the Array-based `callv`/`bindv` do, and
  error reporting is the raw `GDExtensionCallError` struct instead of a C++ type.
- **Cancellable-callable + Signal connect**: master connected a custom Callable to a Signal with
  `CONNECT_ONE_SHOT`, special-casing `Node` targets via `call_thread_safe` to force the connect
  onto the main thread. `call_thread_safe` doesn't exist anywhere in godot-cpp's public API — that
  thread-safety mechanism was dropped outright, not replaced.
- **`WeakRef` construction**: master built a `Ref<WeakRef>` and called `->set_obj(target)`
  directly. godot-cpp's `WeakRef` exposes only `get_ref()` — no setter. The only public path to a
  populated `WeakRef` is the free function `UtilityFunctions::weakref(variant)`.
- **`duplicate_deep()` signature**: master took a `ResourceDeepDuplicateMode` enum. godot-cpp's
  real signature takes a raw `int64_t` — no enum type exists in the public API for this at all.
- **`printRaw()`**: master used `OS::print(...)` (no forced newline). godot-cpp exposes no
  `OS::print` — only `print_line()`, which always appends `\n`.

## Registration / engine wiring

- **Script language registration**: master's `ScriptServer::register_language/unregister_language`
  (a static registry class) doesn't exist in godot-cpp — the equivalent is an instance method on
  the `Engine` singleton, `Engine::get_singleton()->register_script_language(...)`.
- **Resource loader/saver registration**: same shape — `ResourceLoader::add_resource_format_loader`
  went from a static-style call to an instance method on `ResourceLoader::get_singleton()`.
- **Custom EditorPlugin registration**: master used `EditorPlugins::add_create_func(factory)`.
  godot-cpp only exposes the template-based `EditorPlugins::add_by_type<T>()` — the factory
  function pattern is gone entirely.
- **Deferred editor-plugin init timing**: master used `EditorNode::add_init_callback(callback)` to
  defer work until the editor UI existed. `EditorNode` isn't exposed to GDExtensions at all — the
  logic now runs synchronously inside the `MODULE_INITIALIZATION_LEVEL_EDITOR` callback instead.
- **`Engine::is_project_manager_hint()` — reframed after user correction**: no equivalent exists
  in godot-cpp's `Engine` (only the semantically different `is_editor_hint()`). Initially framed
  as "a dropped capability." **Corrected**: it isn't a gap at all — a GDExtension is never loaded
  by the bare project manager in the first place (unlike a module, which is compiled into the
  binary and always initializes), so the guard had nothing to protect against here. The check was
  removed and `src/register_types.cpp` documents this explicitly instead of carrying a TODO.
- **JVM stacktrace surfaced to the debugger**: master fed live JVM call-stack frames into Godot's
  debugger via `debug_get_current_stack_info()`. No GDExtension path exists for this currently —
  dropped, not reimplemented (the surviving TODO cites upstream Godot issue #91006).

## Dynamic library / JVM lifecycle

- **JVM shared-library loading**: master used `OS::open_dynamic_library`/`close_dynamic_library`/
  `get_dynamic_library_symbol_handle`. None of these exist in godot-cpp's `OS` binding at all. Had
  to hand-implement raw native `LoadLibrary`/`FreeLibrary`/`GetProcAddress` (Windows) and
  `dlopen`/`dlclose`/`dlsym` (POSIX) — new `src/engine/dynamic_library.{h,cpp}`, bypassing Godot's
  API entirely for this one need.
- **Android JVM discovery**: master used Godot's own internal `platform/android/...` headers and a
  `get_jni_env()` helper to reuse the JNIEnv/JavaVM the engine's Android activity already created.
  Nothing in godot-cpp exposes this — unresolved gap, documented with a TODO, no substitute
  written.

## Editor/project settings & I/O

- **`_GLOBAL_DEF`/`_EDITOR_DEF` — corrected after user-prompted investigation**: master's macros
  atomically "create this setting with a default if missing, and record the reset value." No
  single godot-cpp equivalent exists — but a real dedicated `set_setting(name, value)` method
  **does** exist on both `ProjectSettings` and `EditorSettings` (confirmed by checking
  `utopia-rise/fmod-gdextension`, a sibling project on the same godot-cpp version, which uses
  exactly this pattern in `src/tools/fmod_editor_plugin.cpp`). The first pass in this repo used the
  generic `Object::set()` instead of the dedicated `set_setting()`, and was missing
  `set_initial_value()`/`set_as_basic()` for the `gradle_dir` project setting. Fixed in
  `src/editor/godot_jvm_editor.cpp` to match the proven pattern: `has_setting()` check →
  `set_setting()` → `add_property_info()` → `set_as_basic()` → `set_initial_value()`.
- **Package-substitution trigger point**: master hooked the per-language `Script::set_path()`
  override to substitute `%PACKAGE%` the first time a templated script's path was set. Initially
  claimed `ScriptExtension` has no path hook at all — **wrong**: `godot::Resource` (base of
  `Script`) exposes a real virtual, `virtual void _set_path_cache(const String &p_path) const;`,
  confirmed to fire from the engine's own `set_path()`/`take_over_path()`/`set_path_cache()` flow
  (`gen/src/classes/resource.cpp`). Now implemented: `JvmScript::_set_path_cache()` (TOOLS_ENABLED
  only, matching master) calls the existing per-language `_format_template()` virtual, restoring
  master's exact trigger timing — substitution happens once, at path assignment, not just at save
  time. Required marking `JvmScript::source` (`src/api/script/jvm_script.h`) `mutable` and
  `_format_template()` `const` throughout, since `_set_path_cache` is `const`. The one remaining
  divergence is just the mechanism name/shape (`_set_path_cache` on `Resource`, no `p_take_over`
  parameter, `const`-qualified) vs. master's non-const `Script::set_path(path, take_over)` — no
  longer a behavioral gap.
- **Editor syntax highlighting**: master subclassed the engine-internal
  `EditorStandardSyntaxHighlighter`, inheriting generic keyword/comment/string highlighting for
  free. godot-cpp only exposes the much lower-level base `EditorSyntaxHighlighter` (different
  virtual: `_get_line_syntax_highlighting`) — the highlighting logic had to be rewritten from
  scratch, and the rewrite is a materially simpler approximation (no multiline block-comment
  tracking, hardcoded colors, no per-language keyword source).
- **`FileAccess::open` with inline error**: master's `open(path, mode, &err)` overload doesn't
  exist — godot-cpp requires a separate `FileAccess::get_open_error()` call immediately after a
  plain `open()`, a two-step pattern instead of one (a source of a real null-deref bug in the
  port's first pass).
- **UTF-8 validity checking**: master's `get_as_utf8_string()` + `String::is_valid_string()` combo
  detected and rejected malformed file content, failing the load with `ERR_INVALID_DATA`.
  godot-cpp only exposes `get_as_text()`, which silently replaces invalid byte sequences (typically
  with U+FFFD) instead of signaling failure — you still always get a `String` back, there's just no
  way to detect/report that the input was malformed anymore, so a bad file loads as garbled text
  instead of failing outright.
- **Resource loader `_load()` error signaling**: master's `load()` had explicit `Error*`/`float*`
  out-parameters. GDExtension's `_load()` virtual returns a bare `Variant` where an `Error` value
  doubles as the failure signal — an out-param vs. tagged-return-value shape change.
- **Editor filesystem refresh**: master's incremental `scan_changes()` has no godot-cpp
  equivalent — only the heavier full `scan()` is exposed.
- **Blocking subprocess execution**: master's `OS::execute(...)` overload took an explicit
  `Mutex*` to synchronize concurrent pipe reads. `execute()` itself is still used identically in
  the port (there's no other way to run Gradle) — only the mutex parameter is gone; godot-cpp's
  public `OS::execute()` binding has no such parameter slot, so that synchronization primitive
  can't be expressed through the public API at all and was dropped rather than replaced.
- **Recursive directory copy** (export plugin, JRE bundling): godot-cpp's `DirAccess` has no
  `copy_dir` — hand-rolled from `list_dir_begin`/`get_next`/`copy`/`make_dir_recursive`.
- **Export-preset exclude filtering**: master could set the preset's exclude filter directly.
  godot-cpp's `EditorExportPreset` only exposes a getter — achieved the same practical effect via
  a per-file `should_skip_export()`/`skip()` check inside `_export_file()` instead.

## Instance bindings outliving the library (shutdown segfault, fixed)

- **Never materialize a godot-cpp wrapper for an engine-owned object you only need to identify.**
  master had no such concept: an `Object*` there *is* the engine object. In the port, every way of
  turning a raw pointer or `ObjectID` into a `godot::Object*` — `ObjectDB::get_instance()`,
  `internal::get_object_instance_binding()`, any godot-cpp API returning an `Object*` — goes through
  `object_get_instance_binding`, which **permanently attaches godot-cpp's instance binding to that
  object**. Godot only clears instance bindings on editor hot-reload
  (`GDExtension::clear_instance_bindings()`); on shutdown it just unloads the library. Anything
  destroyed after that point (`Main::cleanup()` closes libraries inside
  `memdelete(gdextension_manager)`, which runs *before* `memdelete(_time)`, `ObjectDB::cleanup()`
  and `ResourceCache::clear()`) then reaches `Object::~Object()`, calls its binding's
  `free_callback` — which lives in unmapped memory — and the process segfaults on exit with no
  backtrace (the JVM has replaced Godot's unhandled-exception filter, so the crash handler never
  prints).
  The concrete offender was `MemoryManager::release_binding()`/`sync_memory()`/`check_instance()`
  (`src/jvm/wrapper/memory/memory_manager.cpp`) resolving their `ObjectID` with
  `godot::ObjectDB::get_instance()`. Perversely, `release_binding()`'s entire job is to *drop* the
  object's binding, and it created a fresh one on the way in. The victim in the test harness was the
  engine's `GDExtensionManager` singleton, whose leftover binding crashed the whole `runGDTests` run
  at exit even though all 111 tests passed. Fixed by resolving the id with
  `internal::gdextension_interface_object_get_instance_from_id()` and doing every subsequent step on
  the raw `GodotObject*`: `object_free_instance_binding` (already wrapped as
  `JvmBindingManager::free_binding`), the `RefCounted::unreference` method bind, and
  `object_destroy`. The shared raw-`RefCounted` call helpers (`ref_counted_method_bind`,
  `call_ref_counted_bool_method`), previously private to `jvm_binding_manager.cpp`, moved to
  `src/engine/utilities.h`.
  `KtObject::get_singleton()` (`src/jvm/wrapper/registration/kt_object.cpp`) had the same latent
  problem via `Engine::get_singleton()->get_singleton(name)` — it now uses
  `internal::gdextension_interface_global_get_singleton()`, which is exactly what that binding
  ptrcalls anyway, minus the wrapper. Same class of bug would hit `Time`, `ResourceUID` and `IP`,
  all of which Godot destroys after unloading extensions.
- **Standing rule that fell out of this: the JVM runtime path is wrapper-free; only the skeleton uses
  godot-cpp.** Engine-facing virtuals, registration, editor plugin and resource loaders keep using
  godot-cpp normally — but anything an object flows through at runtime (creation, refcounting,
  freeing, calling, Variant marshalling) works on `GodotObject*`. `JvmInstance::JvmInstanceData::owner`
  is a raw `GodotObject*`; refcount reads go through `raw_ref_counted::get_reference_count()`
  (`src/engine/utilities.h`) instead of `reinterpret_cast<RefCounted*>(owner)->get_reference_count()`;
  `is_ref_counted()` has no `Object*` overload at all, so a caller holding a wrapper must spell out
  `->_owner`. `JvmScript::_instance_create(Object*)` stays as godot-cpp's virtual but only unwraps
  once and delegates to `create_jvm_instance(GodotObject*)`; `_object_create()` returns a raw pointer
  and `_new()` builds its `Variant` with `make_object_variant()`. This removed the last wrapper
  materialization for JVM-created objects — they now carry only our own `JvmBinding`.
  Two helpers exist because godot-cpp's constructors take a wrapper purely to read `_owner` off it
  (`variant.cpp:189`, `signal.cpp:105`): `make_object_variant()` and `make_signal()` issue the same
  engine constructor with the raw pointer.
  Deliberately still wrapper-based, all editor-only: `JvmPlaceHolderInstanceData::owner` (it really
  calls `notify_property_list_changed()`), the two `Object::cast_to<ScriptExtension>`, and
  `jvm_script.cpp`'s `cast_to<Node>`. Note `Variant::get_validated_object()` is
  `ObjectDB::get_instance()` under the hood (`variant.cpp:516`) and so creates a binding too — the one
  use, in `jvm_placeholder_instance.cpp`, is editor-only.
  The shared-buffer marshalling is included: `append_object()` used to take a `godot::Object*`, which
  is what made `Variant::operator Object*()` fire implicitly — it resolves the raw pointer, discards
  it, and builds a wrapper (`variant.cpp:439`) that `append_object` then unwrapped again via
  `->_owner`. It now takes a `GodotObject*`, fed by `variant_to_raw_object()` (the first half of that
  operator, and nothing more). `to_godot_object()` became `to_raw_object()` and simply returns the
  pointer the buffer already holds; `read_object()`/`read_signal()` build their values with
  `make_object_variant()`/`make_signal()`, `write_signal()` uses `Signal::get_object_id()` instead of
  `get_object()`, and `CallableBridge::engine_call_constructor_object_string_name()` uses
  `make_callable()`. Since godot-cpp's conversion operator is a member of its own `Variant` and can be
  neither replaced nor deleted, the only durable defence is to never declare a `godot::Object*`
  parameter on this path — that is why `is_ref_counted()` has no such overload either.
  Residual, harmless: `ERR_PRINT`s of the form `BUG: Unreferenced static string to 0: KotlinScript`
  used to appear at exit and are now gone. They were **ours**, not godot-cpp's: `SNAME()` in
  `src/engine/utilities.h` copied the upstream engine macro verbatim, including its
  `StringName(m_arg, true)` static flag. That flag promises the engine the name lives until
  `StringName::cleanup()`, which is false for a function-local static inside an unloadable library —
  and since `static_count` lives on the shared refcounted `StringName` data rather than on our
  instance, marking a common name like `Script` or `_set` static made the engine report the BUG for
  its *own* later release of that name too. Dropping the flag keeps the caching (one hash per call
  site) without the false lifetime promise. Only the `SNAME()`s that actually executed ever appeared,
  since function-local statics initialize lazily.

## Open follow-up (not yet acted on)

- **`KtFunction::get_parameter_count()`**: the C++ side (`kt_function.h/.cpp`) is wired up, but
  no Kotlin-side `getParameterCount()` exists anywhere in `kt/godot-library/...` — this will throw
  `NoSuchMethodError` at runtime the first time it's invoked. Needs a Kotlin-side addition, outside
  this C++-only pass's scope.
- **Custom-Callable JNI surface**: the real compiled Kotlin classes backing the callable bridge are
  `godot.core.Callable$Bridge`/`LambdaContainer` (per `Callable.kt`/`LambdaCallable.kt`), not the
  `NativeCallable$Bridge`/`LambdaCallable$Bridge` names the current C++ code (`kotlin_callable_custom.h`)
  expects. This is a real, larger mismatch needing a coordinated C++ + Kotlin redesign, not covered
  by this pass.
- **`TransferContext::icall` debug-mode safety check**: master decoded the receiver's `ObjectID`
  and checked liveness before dereferencing, throwing a clean JVM exception on a freed object
  instead of dereferencing a dangling pointer. The redesigned `icall` (now
  `gdextension_interface_object_method_bind_call`-based, see below) never restored this check. Not
  yet fixed.
- **Editor-mode heap corruption on `Object::_extension` (fixed)**: the root cause was
  `JvmPlaceHolderInstance::call()` reusing the public `get_script()` ABI callback internally.
  That callback correctly returns a raw `GDExtensionObjectPtr`, but the caller reinterpreted it as
  a godot-cpp `JvmScript*` wrapper and constructed a `Ref<JvmScript>` from it. The resulting
  reference operation read a bogus `_owner` and could reference or destroy unrelated engine
  memory. The fix uses the wrapper already held by `JvmPlaceHolderInstanceData::script`. A debugger
  run through the delayed `EditorNode::gather_resources()`/`_get_configuration_warnings` path
  confirmed the wrapper and raw pointers differ and that the loaded `GDExtension` object's
  `_extension` remained null before and after the callback. The investigation history follows;
  its JVM heap-race conclusion was disproven by this pointer-path finding.

  Discovered while chasing a separate, now-fixed game-mode crash. The engine's own
  `GDExtension` singleton (the descriptor for our loaded `jvm.gdextension`) gets a corrupted
  `Object::_extension` field — should always be null for this built-in class — causing a
  jump-to-invalid-memory crash inside `RefCounted::reference()`. **Confirmed 100% reproducible**:
  triggered every time by opening Project Settings > Extensions tab (`TabBar::gui_input` →
  `ProjectSettingsGDExtension::_update_extension_tree` → `GDExtensionManager::get_extension`,
  `core/extension/gdextension_manager.cpp:247`) — a plain headless/scripted launch never reproduces
  it because nothing generates that tab-click UI event. Caught live with a breakpoint one line
  *before* the crashing statement (`gdextension_manager.cpp:247`, right before `return E->value;`
  calls `reference()`): `_extension` is already corrupted at that point, so the actual corrupting
  write happens earlier, not during this call. A raw memory dump at the corrupted `_extension`
  pointer shows a mixed pattern — the first 8 bytes decode as a plausible real pointer (matching the
  struct's own `library` field elsewhere), followed by all-zero padding, then clearly-garbage values
  (tiny "function pointers" like `0x90`, `0x34`, `0x11` that no real code address could ever be) —
  consistent with either an undersized allocation read past its end, or (more likely, given the two
  confirmed wrong/dangling-raw-pointer bugs found in the same session, see above) a stale pointer
  from one of our own objects aliasing this engine object's memory after being freed. Leading
  hypothesis, not yet confirmed: this happens during **hot-reload** of the `.dll` — the editor
  detects the file changed on disk and reloads the extension live, destroying/recreating engine-side
  `GDExtension`/`ObjectGDExtension` state; if one of our own objects is freed with a stale pointer
  around the same time, it could land on that freshly-recycled memory. Fits the "always crashes
  when the user opens it, sometimes when launched fresh via automation" pattern, since the DLL was
  rebuilt/redeployed repeatedly during this session.
  **Ruled out by direct bisection**: the entire `GodotJvm` state machine (`src/godot_jvm.h`'s
  `initialize_up_to()` levels — `JVM_STARTED`/`BOOTSTRAP_LOADED`/`CORE_LIBRARY_INITIALIZED`/
  `ENGINE_TYPES_INITIALIZED`/`JVM_SCRIPTS_INITIALIZED`) is **not** the cause. Tested by temporarily
  capping `GdjLanguage::_init()`'s target state at each level (also had to temporarily neutralize
  `GodotJvmEditor::on_filesystem_change()`, which independently re-escalates to the full level on
  the filesystem-changed signal that always fires once at startup — otherwise every test silently
  ran at full level regardless of the cap) and, at each level, evaluating
  `GDExtensionManager::get_singleton()->gdextension_map`'s entry directly in the debugger — no UI
  interaction needed at all, since the corruption is already present before any UI event, as
  established above. `_extension` was already corrupted at `JVM_SCRIPTS_INITIALIZED` (full),
  `CORE_LIBRARY_INITIALIZED`, and `JVM_STARTED` (the lowest level reachable at all — the first
  `SET_LOADING_STATE` macro step always runs unconditionally regardless of requested target).
  Whatever corrupts this memory runs **unconditionally**, independent of JVM lifecycle state.
  **Pinned down by bisecting `register_types.cpp` itself** (same technique — no UI interaction,
  just evaluate `GDExtensionManager::get_singleton()->gdextension_map`'s entry directly in the
  debugger after each rebuild): the entire `MODULE_INITIALIZATION_LEVEL_EDITOR` block (our own
  `GodotJvmEditor` plugin, export plugin, syntax highlighter — none of it) is **not** the cause;
  disabling it entirely, corruption persisted. The entire `MODULE_INITIALIZATION_LEVEL_SCENE` block
  **is** — disabling it entirely, `_extension` came back `NULL` (healthy) for the first time.
  Narrowed further within that block: `JavaArchiveFormatLoader`/`JavaArchive` (JAR loading) is
  *not* the cause — disabled, corruption persisted. **`JvmResourceFormatLoader` alone reproduces
  it, and disabling only it (everything else enabled) eliminates it** — confirmed both directions,
  so it's necessary and sufficient on its own.
  **Narrowed further to invocation, not registration**: with the loader registered completely
  normally but temporarily made to never match anything (`_get_recognized_extensions()` returns
  empty, `_handles_type()` returns false — present but the editor never calls `_load()` on it for
  the scene's `.kt`/`.java`/`.scala` files), `_extension` stayed `NULL`. So it's specifically the
  editor *invoking* `_load()` while opening `main.tscn`'s scripts, not the mere registration.
  **Narrowed further inside `_load()` itself** by progressively short-circuiting it earlier and
  earlier and rebuilding each time: healthy with `_load()` doing nothing at all; healthy after just
  `read_source_script_file()`; healthy after `parse_source_script_fqname()` +
  `create_and_bind_physical_script()` + `set_source_code()` + `set_last_source_modified_time()` —
  **only when `JvmScriptManager::update_physical_script()` (the last call in `_load()`, `src/api/
  script/jvm_script_manager.cpp:197`) runs does the corruption appear.**
  Attempted to narrow further with live single-stepping (breaking at `update_physical_script`'s
  entry for each of the 3 scripts in turn) but hit a tooling wall: checking the corrupted object
  requires being paused in an *engine* stack frame (cross-module symbol resolution in the LLDB
  expression evaluator fails for our own DLL's symbols and vice versa), so confirming the corrupted
  object's state requires stepping out through several frames back into engine code after every
  single step inside our own function — slow, and made the exact moment of corruption during the
  third (Scala) load ambiguous (one breakpoint hit had an unexpectedly null script/empty fqdn,
  possibly an unrelated resource, not confirmed). What is confirmed: individually, after the first
  (Java) and second (Kotlin) scripts' `update_physical_script()` calls completed, `_extension` was
  still `NULL` — corruption appears sometime after that, during or after the Scala load.
  **One specific hypothesis tested and disproven**: disabled only the `set_script_for_fqdn(p_fqdn,
  p_script)` call in `update_physical_script()`'s plain `else` branch (the one both the Java and
  Kotlin calls were observed taking) while leaving everything else — including every other call
  site of `set_script_for_fqdn`/`UtilityFunctions::weakref()` — untouched. Corruption persisted, so
  that specific call isn't the (sole) cause.
  **Redid the per-script live-debugger check properly** (previous attempt's third result was
  ambiguous) — confirmed all three scripts (Java, Kotlin, Scala) take the *identical* plain `else`
  code path (none hit `replace_virtual_script()` or the JNI reassignment branch), ruling both of
  those out as the cause for any of the three individual calls. Went further and checked
  immediately after all three `update_physical_script()` calls *and* all three
  `_placeholder_instance_create()` calls (editor mode uses placeholders, not real instances, since
  `_can_instantiate()` returns false under `Engine::is_editor_hint()`) — every one of these
  individually confirmed healthy. The corruption only appears sometime *after* all of that, during
  the general "let it run for a bit" window — confirmed by catching it live during a *second*
  `Object::get_property_list()` call from `EditorNode::gather_resources()` (populating the Scene
  dock's resource list on scene open, an entirely different call site than script loading).
  **Disproven intermediate conclusion:** this was initially attributed to a cross-thread heap race.
  At the moment corruption was caught live, the corrupted `ObjectGDExtension` struct's function
  pointers (`create_instance2`, `get_virtual_call_data`, `recreate_instance`) pointed into
  `jvm.dll` — the actual Java HotSpot VM's native library — at vtables for `ParseGenerator`,
  `UncommonTrapCallGenerator`, `PredictedCallGenerator`: internal class names from HotSpot's C2 JIT
  compiler. The JVM's own background JIT-compilation thread is writing its internal data into a
  heap block the engine still holds as `GDExtension::_extension` — i.e., a genuine heap-buffer
  overflow (source not yet identified) whose *victim* is whatever happens to be adjacent in memory
  that particular run (explaining why every corrupted dump this session showed a different
  unrelated vtable — `RichTextLabel::ItemTable`, `JavaScript`, `spv::Instruction`, now JIT-compiler
  internals — pure chance of heap layout, not a fixed target), and whose *timing* is asynchronous
  (explaining why every single-threaded, single-stepped check immediately after a specific call
  came back healthy — the corrupting write happens on a separate thread, not synchronously in our
  own call sequence, so it can't be pinned to one line by single-stepping the main thread).
  Retroactively explains why disabling `update_physical_script()` earlier "fixed" it: not because
  that code is the bug, but because skipping it means less class-binding work happens overall, so
  the JVM's background compiler thread has less queued up and the race window is less likely to be
  hit that particular run — consistent with a timing-dependent race, not a deterministic cause.
  **Stopped the single-step bisection here** (per explicit instruction to stop once out of options
  for the technique in use) — a cross-thread race needs a heap-corruption detector (Application
  Verifier's heap checks, or an ASan build covering both the JVM's native allocations and our own)
  to catch the actual overflow at the moment either side writes past a buffer; further single-
  stepping the main thread cannot reliably catch it.
  One suspect was investigated and ruled out: `MemoryManager`'s
  `if (ref->unreference()) { memdelete(ref); }` pattern (`memory_manager.cpp`) looked wrong at first
  (`ref` is the godot-cpp wrapper, not the raw object) but is actually correct — godot-cpp's own
  `memdelete<T>` is template-specialized for `Wrapped`-derived types to call
  `gdextension_interface_object_destroy(p_class->_owner)` rather than freeing the wrapper directly
  (`godot-cpp/include/godot_cpp/core/memory.hpp:113-116`), matching this exact idiom.
