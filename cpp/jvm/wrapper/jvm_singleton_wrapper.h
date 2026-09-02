#ifndef GODOT_JVM_JVM_SINGLETON_WRAPPER_H
#define GODOT_JVM_JVM_SINGLETON_WRAPPER_H

#include "jvm_instance_wrapper.h"

#define JVM_SINGLETON_WRAPPER(NAME, FQNAME)               \
    inline constexpr char NAME##QualifiedName[] = FQNAME; \
    class NAME : public JvmSingletonWrapper<NAME, NAME##QualifiedName>

#define SINGLETON_CLASS(NAME)                                             \
    friend class JvmSingletonWrapper<NAME, NAME##QualifiedName>;          \
    JVM_CLASS(NAME)                                                       \
                                                                          \
public:                                                                   \
    NAME(const NAME&) = delete;                                           \
    void operator=(const NAME&) = delete;                                 \
    NAME& operator=(NAME&&) noexcept = delete;                            \
    NAME(NAME&&) noexcept = delete;                                       \
                                                                          \
protected:                                                                \
    explicit NAME(jni::Env& p_env, jni::JObject p_wrapped) :              \
      JvmSingletonWrapper<NAME, NAME##QualifiedName>(p_env, p_wrapped) {} \
    ~NAME();

/**
 * JvmSingletonWrapper CRTP. Inherits from JvmInstanceWrapper CRTP.
 * This implements singleton pattern in order to wrap jvm singletons to cpp singletons.
 * Each inheriting class Derived define a method called "initialize" that must be called at least once
 * This instance will be deleted when calling destroy method.
 *
 * @tparam Derived
 * @tparam FqName
 */
template<class Derived, const char* FqName>
class JvmSingletonWrapper : public JvmInstanceWrapper<Derived, FqName> {
    static Derived* _instance;

protected:
    JvmSingletonWrapper(jni::Env& p_env, jni::JObject p_wrapped);
    ~JvmSingletonWrapper() = default;

public:
    static Derived& get_instance();

    JvmSingletonWrapper(const JvmSingletonWrapper<Derived, FqName>&) = delete;
    void operator=(const JvmSingletonWrapper<Derived, FqName>&) = delete;
    JvmSingletonWrapper<Derived, FqName>& operator=(JvmSingletonWrapper<Derived, FqName>&&) noexcept = delete;
    JvmSingletonWrapper(JvmSingletonWrapper<Derived, FqName>&& instance) noexcept = delete;

    static bool initialize(jni::Env& p_env, ClassLoader* class_loader);
    static Derived* create_instance(jni::Env& p_env, ClassLoader* class_loader);
    static void finalize(jni::Env& p_env, ClassLoader* class_loader);
};

template<class Derived, const char* FqName>
bool JvmSingletonWrapper<Derived, FqName>::initialize(jni::Env& p_env, ClassLoader* class_loader) {
    JVM_DEV_ASSERT(!_instance, godot::String(FqName) + godot::String(" singleton is already initialized."));

    jni::JClass singleton_cls;
    if (class_loader) {
        singleton_cls = class_loader->load_class(p_env, FqName);
    } else {
        singleton_cls = p_env.find_class(FqName);
    }
    jni::FieldID singleton_instance_field =
      singleton_cls.get_static_field_id(p_env, "INSTANCE", godot::vformat("L%s;", FqName).replace(".", "/").utf8().ptr());
    jni::JObject singleton_instance = singleton_cls.get_static_object_field(p_env, singleton_instance_field);

    JVM_ERR_FAIL_COND_V_MSG(singleton_instance.is_null(), false, godot::String("Failed to retrieve ") + godot::String(FqName) + godot::String(" singleton"));

    _instance = new Derived(p_env, singleton_instance);

    Derived::initialize_jni_binding(p_env, class_loader);
    return true;
}

template<class Derived, const char* FqName>
Derived* JvmSingletonWrapper<Derived, FqName>::create_instance(jni::Env&, ClassLoader*) {
    JVM_DEV_ASSERT(true, "Can't create a new instance of a this class. Returning the singleton instead");
    return _instance;
}

template<class Derived, const char* FqName>
void JvmSingletonWrapper<Derived, FqName>::finalize(jni::Env& p_env, ClassLoader* class_loader) {
    JVM_DEV_ASSERT(_instance, godot::String(FqName) + " singleton is not initialized.");
    delete _instance;
    _instance = nullptr;
    Derived::finalize_jni_binding(p_env, class_loader);
}

template<class Derived, const char* FqName>
Derived* JvmSingletonWrapper<Derived, FqName>::_instance {nullptr};

template<class Derived, const char* FqName>
Derived& JvmSingletonWrapper<Derived, FqName>::get_instance() {
    JVM_DEV_ASSERT(_instance, godot::String(FqName) + " singleton is not initialized.");
    return *_instance;
}

template<class Derived, const char* FqName>
JvmSingletonWrapper<Derived, FqName>::JvmSingletonWrapper(jni::Env& p_env, jni::JObject p_wrapped) :
  JvmInstanceWrapper<Derived, FqName>(p_env, p_wrapped) {}

#endif // GODOT_JVM_JVM_SINGLETON_WRAPPER_H
