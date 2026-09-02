#ifndef GODOT_JVM_GODOT_OBJECT_H
#define GODOT_JVM_GODOT_OBJECT_H

#include <classes/object.hpp>
#include <classes/ref_counted.hpp>
#include <core/builtin_ptrcall.hpp>
#include <core/engine_ptrcall.hpp>
#include <core/error_macros.hpp>
#include <godot.hpp>
#include <variant/callable.hpp>
#include <variant/signal.hpp>
#include <variant/string_name.hpp>
#include <variant/variant.hpp>

#include <array>

// The engine's SNAME without its `p_static` flag: that flag promises the name outlives the process, which is false
// for a static inside an unloadable library and makes Godot report "Unreferenced static string" for it at exit.
#define SNAME(m_arg) ([]() -> const godot::StringName & { static godot::StringName sname = godot::StringName(m_arg); return sname; })()

#define RAW_GODOT_METHOD_BIND(m_class, m_method, m_hash) \
    godot::internal::gdextension_interface_classdb_get_method_bind( \
      godot::StringName(m_class)._native_ptr(), \
      godot::StringName(m_method)._native_ptr(), \
      m_hash \
    )

// Engine entry points the JVM hot path uses, resolved once by configure() into plain globals. Function-local statics
// would cost a guard-variable check on every single call instead.
namespace raw_godot {
    using namespace godot;
    inline GDExtensionMethodBindPtr init_ref_bind {nullptr};
    inline GDExtensionMethodBindPtr reference_bind {nullptr};
    inline GDExtensionMethodBindPtr unreference_bind {nullptr};
    inline GDExtensionMethodBindPtr reference_count_bind {nullptr};
    inline GDExtensionMethodBindPtr notification_bind {nullptr};
    inline GDExtensionMethodBindPtr notify_property_list_changed_bind {nullptr};
    inline GDExtensionMethodBindPtr is_class_bind {nullptr};
    inline GDExtensionMethodBindPtr set_bind {nullptr};
    inline GDExtensionMethodBindPtr set_script_bind {nullptr};
    inline GDExtensionMethodBindPtr call_thread_safe_bind {nullptr};
    inline GDExtensionMethodBindPtr update_configuration_warnings_bind {nullptr};
    inline GDExtensionVariantFromTypeConstructorFunc variant_from_object {nullptr};
    inline GDExtensionTypeFromVariantConstructorFunc object_from_variant {nullptr};
    inline GDExtensionPtrConstructor signal_constructor {nullptr};
    inline GDExtensionPtrConstructor callable_constructor {nullptr};

    inline void configure_core() {
        init_ref_bind = RAW_GODOT_METHOD_BIND("RefCounted", "init_ref", 2240911060);
        reference_bind = RAW_GODOT_METHOD_BIND("RefCounted", "reference", 2240911060);
        unreference_bind = RAW_GODOT_METHOD_BIND("RefCounted", "unreference", 2240911060);
        reference_count_bind = RAW_GODOT_METHOD_BIND("RefCounted", "get_reference_count", 3905245786);
        notification_bind = RAW_GODOT_METHOD_BIND("Object", "notification", 4023243586);
        notify_property_list_changed_bind = RAW_GODOT_METHOD_BIND("Object", "notify_property_list_changed", 3218959716);
        is_class_bind = RAW_GODOT_METHOD_BIND("Object", "is_class", 3927539163);
        set_bind = RAW_GODOT_METHOD_BIND("Object", "set", 3776071444);
        set_script_bind = RAW_GODOT_METHOD_BIND("Object", "set_script", 1114965689);
        variant_from_object = godot::internal::gdextension_interface_get_variant_from_type_constructor(GDEXTENSION_VARIANT_TYPE_OBJECT);
        object_from_variant = godot::internal::gdextension_interface_get_variant_to_type_constructor(GDEXTENSION_VARIANT_TYPE_OBJECT);
        // Index 2 is the (Object, StringName) constructor of each — godot-cpp caches the same one as `constructor_2`.
        signal_constructor = godot::internal::gdextension_interface_variant_get_ptr_constructor(GDEXTENSION_VARIANT_TYPE_SIGNAL, 2);
        callable_constructor = godot::internal::gdextension_interface_variant_get_ptr_constructor(GDEXTENSION_VARIANT_TYPE_CALLABLE, 2);

        ERR_FAIL_NULL_MSG(init_ref_bind, "Failed to resolve RefCounted::init_ref.");
        ERR_FAIL_NULL_MSG(reference_bind, "Failed to resolve RefCounted::reference.");
        ERR_FAIL_NULL_MSG(unreference_bind, "Failed to resolve RefCounted::unreference.");
        ERR_FAIL_NULL_MSG(reference_count_bind, "Failed to resolve RefCounted::get_reference_count.");
        ERR_FAIL_NULL_MSG(notification_bind, "Failed to resolve Object::notification.");
        ERR_FAIL_NULL_MSG(notify_property_list_changed_bind, "Failed to resolve Object::notify_property_list_changed.");
        ERR_FAIL_NULL_MSG(is_class_bind, "Failed to resolve Object::is_class.");
        ERR_FAIL_NULL_MSG(set_bind, "Failed to resolve Object::set.");
        ERR_FAIL_NULL_MSG(set_script_bind, "Failed to resolve Object::set_script.");
        ERR_FAIL_NULL_MSG(variant_from_object, "Failed to resolve the Object-to-Variant constructor.");
        ERR_FAIL_NULL_MSG(object_from_variant, "Failed to resolve the Variant-to-Object constructor.");
        ERR_FAIL_NULL_MSG(signal_constructor, "Failed to resolve the Signal(Object, StringName) constructor.");
        ERR_FAIL_NULL_MSG(callable_constructor, "Failed to resolve the Callable(Object, StringName) constructor.");
    }

    inline void configure_scene() {
        call_thread_safe_bind = RAW_GODOT_METHOD_BIND("Node", "call_thread_safe", 3400424181);
        update_configuration_warnings_bind = RAW_GODOT_METHOD_BIND("Node", "update_configuration_warnings", 3218959716);

        ERR_FAIL_NULL_MSG(call_thread_safe_bind, "Failed to resolve Node::call_thread_safe.");
        ERR_FAIL_NULL_MSG(update_configuration_warnings_bind, "Failed to resolve Node::update_configuration_warnings.");
    }

    // A raw engine object pointer, plus the operations that belong to it.
    //
    // This is deliberately *not* godot-cpp's Object: taking an `Object *` anywhere on the JVM path makes godot-cpp
    // decode it through PtrToArg<T *>::convert(), which calls get_object_instance_binding() and so builds -- and
    // permanently registers -- a C++ wrapper for an object the JVM already tracks itself. Every operation below issues
    // the engine call straight from the pointer instead, so nothing is allocated and nothing is registered.
    //
    // It stays pointer-sized and trivially copyable, and converts to and from GodotObject * implicitly, so it passes
    // through the GDExtension C boundary and godot-cpp's own raw entry points unchanged. Treat it as the pointer, not
    // as a wrapper around one: copying it copies a pointer, and destroying it does nothing.
    class RawObject {
        GodotObject* _ptr {nullptr};

    public:
        RawObject() = default;
        RawObject(GodotObject* p_ptr) : _ptr(p_ptr) {}

        operator GodotObject*() const { return _ptr; }
        _ALWAYS_INLINE_ GodotObject* ptr() const { return _ptr; }
        _ALWAYS_INLINE_ explicit operator bool() const { return _ptr != nullptr; }
        _ALWAYS_INLINE_ bool is_null() const { return _ptr == nullptr; }

        _ALWAYS_INLINE_ bool operator==(const RawObject& p_other) const { return _ptr == p_other._ptr; }
        _ALWAYS_INLINE_ bool operator!=(const RawObject& p_other) const { return _ptr != p_other._ptr; }

        // --- creation and lookup -------------------------------------------------------------------------------

        // GDExtension equivalent of the engine-internal ClassDB::instantiate().
        //
        // classdb_construct_object2() maps to ClassDB::instantiate_without_postinitialization(), and its contract in
        // gdextension_interface.h is explicit: "NOTIFICATION_POSTINITIALIZE must be sent after construction."
        // godot-cpp honours that in memnew() via Wrapped::_postinitialize(); we construct raw objects, so we send it
        // ourselves. Skipping it leaves anything that sets itself up there half-initialized -- Control subclasses
        // never build their theme item cache (control.cpp even warns to prefer NOTIFICATION_POSTINITIALIZE for theme
        // items), so the first resize of a text-drawing control such as Label or Button crashes on it.
        //
        // When migrating to classdb_construct_object3 (ClassDB::instantiate_without_postinitialization_with_refcount):
        //  - keep the notification. That variant also passes p_notify_postinitialize = false; the only thing it adds
        //    is returning RefCounted instances already at refcount 1.
        //  - drop the init_ref() call in JvmBindingManager::set_instance_binding(), which exists purely because
        //    object2 hands back a genuinely-zero refcount. Keeping both would land the object at 2 and leak it.
        // It is not reachable yet: godot-cpp's vendored gdextension_interface.h does not declare object3 at all, even
        // though the engine implements it, so there is no gdextension_interface_classdb_construct_object3 to call.
        _ALWAYS_INLINE_ static RawObject instantiate(const StringName& p_class_name) {
            RawObject object {internal::gdextension_interface_classdb_construct_object2(
              reinterpret_cast<GDExtensionConstStringNamePtr>(p_class_name._native_ptr())
            )};
            if (unlikely(object.is_null())) { return {}; }

            object.notification(Object::NOTIFICATION_POSTINITIALIZE);
            return object;
        }

        // Deliberately not godot-cpp's ObjectDB::get_instance(): that creates a godot-cpp wrapper and its instance
        // binding. Godot does not clear those bindings when an extension unloads, but can destroy engine-owned
        // objects afterwards; their free callback would then point into unmapped extension memory. None of this raw
        // API needs a wrapper.
        _ALWAYS_INLINE_ static RawObject from_instance_id(uint64_t p_instance_id) {
            return internal::gdextension_interface_object_get_instance_from_id(static_cast<GDObjectInstanceID>(p_instance_id));
        }

        // The first half of Variant::operator Object*(), without the wrapper it then builds.
        _ALWAYS_INLINE_ static RawObject from_variant(const Variant& p_variant) {
            GodotObject* raw_object {nullptr};
            object_from_variant(&raw_object, p_variant._native_ptr());
            return raw_object;
        }

        _ALWAYS_INLINE_ void destroy() const { internal::gdextension_interface_object_destroy(_ptr); }

        // --- identity ------------------------------------------------------------------------------------------

        _ALWAYS_INLINE_ uint64_t get_instance_id() const {
            return internal::gdextension_interface_object_get_instance_id(_ptr);
        }

        // An ObjectID's high bit flags a RefCounted.
        _ALWAYS_INLINE_ bool is_ref_counted() const {
            return (get_instance_id() & (uint64_t(1) << 63)) != 0;
        }

        _ALWAYS_INLINE_ bool is_class(const StringName& p_class_name) const {
            String class_name {p_class_name};
            return internal::_call_native_mb_ret<int8_t>(is_class_bind, _ptr, class_name._native_ptr());
        }

        // --- lifecycle -----------------------------------------------------------------------------------------

        _ALWAYS_INLINE_ void notification(int32_t p_what, bool p_reversed = false) const {
            int64_t what {p_what};
            int8_t reversed {static_cast<int8_t>(p_reversed)};
            internal::_call_native_mb_no_ret(notification_bind, _ptr, &what, &reversed);
        }

        _ALWAYS_INLINE_ void notify_property_list_changed() const {
            internal::_call_native_mb_no_ret(notify_property_list_changed_bind, _ptr);
        }

        _ALWAYS_INLINE_ void set(const StringName& p_property, const Variant& p_value) const {
            internal::_call_native_mb_no_ret(set_bind, _ptr, &p_property, &p_value);
        }

        _ALWAYS_INLINE_ void set_script(const Variant& p_script) const {
            internal::_call_native_mb_no_ret(set_script_bind, _ptr, &p_script);
        }

        _ALWAYS_INLINE_ void update_configuration_warnings() const {
            internal::_call_native_mb_no_ret(update_configuration_warnings_bind, _ptr);
        }

        _ALWAYS_INLINE_ void set_script_instance(GDExtensionScriptInstancePtr p_script_instance) const {
            internal::gdextension_interface_object_set_script_instance(_ptr, p_script_instance);
        }

    private:
        template <typename... Args>
        _ALWAYS_INLINE_ void call_vararg(GDExtensionMethodBindPtr p_bind, const StringName& p_method, const Args&... p_args) const {
            Variant args[] {p_method, p_args...};
            std::array<GDExtensionConstVariantPtr, sizeof...(Args) + 1> args_ptr;
            for (size_t i = 0; i < args_ptr.size(); ++i) {
                args_ptr[i] = args[i]._native_ptr();
            }
            Variant result;
            GDExtensionCallError error;
            internal::gdextension_interface_object_method_bind_call(
              p_bind,
              _ptr,
              args_ptr.data(),
              args_ptr.size(),
              result._native_ptr(),
              &error
            );
        }

    public:
        template <typename... Args>
        _ALWAYS_INLINE_ void call_thread_safe(const StringName& p_method, const Args&... p_args) const {
            call_vararg(call_thread_safe_bind, p_method, p_args...);
        }

        _ALWAYS_INLINE_ bool init_ref() const {
            return internal::_call_native_mb_ret<int8_t>(init_ref_bind, _ptr);
        }

        _ALWAYS_INLINE_ bool reference() const {
            return internal::_call_native_mb_ret<int8_t>(reference_bind, _ptr);
        }

        _ALWAYS_INLINE_ bool unreference() const {
            return internal::_call_native_mb_ret<int8_t>(unreference_bind, _ptr);
        }

        _ALWAYS_INLINE_ void unreference_and_destroy() const {
            if (unreference()) { destroy(); }
        }

        _ALWAYS_INLINE_ int32_t get_reference_count() const {
            return internal::_call_native_mb_ret<int64_t>(reference_count_bind, _ptr);
        }

        // --- conversions ---------------------------------------------------------------------------------------
        // godot-cpp's Variant(Object*), Signal(Object*, StringName) and Callable(Object*, StringName) only read
        // `_owner` off the wrapper, so these issue the identical engine constructors straight from the pointer. Each
        // writes over a freshly default-constructed value, which owns nothing, so there is nothing to destruct first.

        _ALWAYS_INLINE_ Variant to_variant() const {
            // These take the address of the pointer, so they need a mutable copy of it in a const method.
            GodotObject* ptr {_ptr};
            Variant variant;
            variant_from_object(variant._native_ptr(), &ptr);
            return variant;
        }

        _ALWAYS_INLINE_ Signal to_signal(const StringName& p_name) const {
            GodotObject* ptr {_ptr};
            Signal signal;
            internal::_call_builtin_constructor(signal_constructor, signal._native_ptr(), &ptr, &p_name);
            return signal;
        }

        _ALWAYS_INLINE_ Callable to_callable(const StringName& p_method) const {
            GodotObject* ptr {_ptr};
            Callable callable;
            internal::_call_builtin_constructor(callable_constructor, callable._native_ptr(), &ptr, &p_method);
            return callable;
        }
    };

    static_assert(sizeof(RawObject) == sizeof(GodotObject*), "RawObject must stay pointer-sized.");
    static_assert(std::is_trivially_copyable_v<RawObject>, "RawObject must stay trivially copyable.");
} // namespace raw_godot

#endif // GODOT_JVM_GODOT_OBJECT_H
