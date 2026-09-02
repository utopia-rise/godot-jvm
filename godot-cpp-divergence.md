# godot-cpp divergence log

This project vendors `godot-cpp` as a submodule pointed at the
[`utopia-rise/godot-cpp`](https://github.com/utopia-rise/godot-cpp) fork,
branch `godot-jvm`, instead of upstream `godotengine/godot-cpp` directly.

The branch is rebased/rebuilt from the same upstream tag the submodule would
otherwise track (currently `godot-4.5-stable`). Every commit added on top of
that tag on `godot-jvm` must be logged here, in commit order, with its hash
and a short explanation of what it changes and why.

The branch is based on upstream `godot-4.5-stable`
(`60b5a4196de8442b43b32ba68ebe1e79cfcb762f`).

## Commits on `godot-jvm`

### `43234d42749378830bff939b41aa52adf2c70d39` — expose ScriptExtension's instance-create virtuals as raw object pointers

Adds a `VIRTUAL_RAW_OBJECT_ARGS` opt-out set to `binding_generator.py` and
honours it in `make_signature()`, so `ScriptExtension::_instance_create` and
`_placeholder_instance_create` are generated taking `GodotObject *` instead
of `Object *`.

`Object::set_script()` is the only caller of those virtuals, so every object
that ever gets a JVM script attached — including every node of every scene
loaded at runtime — passes through them. Decoding an `Object *` parameter
runs `PtrToArg<T *>::convert()`, which calls `get_object_instance_binding()`
and therefore builds, and permanently registers, a godot-cpp wrapper for an
object this module already tracks itself (see `RawObject` in
`cpp/engine/godot_object.h`); `JvmScript` unwrapped it again on the very next
line.

Nothing else in godot-cpp needed changing: `GodotObject` is `typedef void`,
so `PtrToArg<GodotObject *>` resolves to the `PtrToArg<void *>`
specialization from `GDVIRTUAL_NATIVE_PTR(void)`, which reads the pointer
straight out of the argument slot, and `BIND_VIRTUAL_METHOD` keeps working
untouched. It is an explicit per-method opt-out rather than a blanket rule,
because everywhere else the wrapper is what makes the C++ API usable.

Regenerate (`gen/` is gitignored, so a clean build picks this up
automatically) after changing the set.
