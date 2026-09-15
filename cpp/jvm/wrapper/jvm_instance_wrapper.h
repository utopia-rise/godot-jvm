#ifndef GODOT_JVM_JVM_INSTANCE_WRAPPER_H
#define GODOT_JVM_JVM_INSTANCE_WRAPPER_H

#include "jvm/jni/methods.h"
#include "jvm/jni/wrapper.h"
#include "jvm/lifecycle/class_loader.h"

#include <atomic>
#include <templates/vector.hpp>

#define JVM_INSTANCE_WRAPPER(NAME, FQNAME)                \
    inline constexpr char NAME##QualifiedName[] = FQNAME; \
    class NAME : public JvmInstanceWrapper<NAME, NAME##QualifiedName>

#define JVM_CLASS(NAME)                                         \
    friend class JvmInstanceWrapper<NAME, NAME##QualifiedName>; \
    static inline constexpr const char* fq_name = NAME##QualifiedName;

#define JNI_VOID_METHOD(var_name) inline static jni::VoidMethodID var_name;
#define JNI_BOOLEAN_METHOD(var_name) inline static jni::BooleanMethodID var_name;
#define JNI_INT_METHOD(var_name) inline static jni::IntMethodID var_name;
#define JNI_LONG_METHOD(var_name) inline static jni::LongMethodID var_name;
#define JNI_FLOAT_METHOD(var_name) inline static jni::FloatMethodID var_name;
#define JNI_DOUBLE_METHOD(var_name) inline static jni::DoubleMethodID var_name;
#define JNI_OBJECT_METHOD(var_name) inline static jni::ObjectMethodID var_name;

#define INIT_JNI_METHOD(var_name, name, signature) var_name.methodId = clazz.get_method_id(p_env, name, signature);

#define INIT_NATIVE_METHOD(string_name, signature, function) \
    methods.push_back({const_cast<char*>(string_name), const_cast<char*>(signature), (void*) function});

#define INIT_JNI_BINDINGS(...)                                                       \
                                                                                     \
public:                                                                              \
    static void initialize_jni_binding(jni::Env& p_env, ClassLoader* class_loader) { \
        godot::Vector<jni::JNativeMethod> methods;                                   \
        jni::JClass clazz;                                                           \
        if (class_loader) {                                                          \
            clazz = class_loader->load_class(p_env, fq_name);                        \
        } else {                                                                     \
            clazz = p_env.find_class(fq_name);                                       \
        }                                                                            \
                                                                                     \
        __VA_ARGS__                                                                  \
        if (methods.size() > 0) { clazz.register_natives(p_env, methods); }          \
        clazz.delete_local_ref(p_env);                                               \
    }                                                                                \
                                                                                     \
    static void finalize_jni_binding(jni::Env& p_env, ClassLoader* class_loader) {   \
        jni::JClass clazz;                                                           \
        if (class_loader) {                                                          \
            clazz = class_loader->load_class(p_env, fq_name);                        \
        } else {                                                                     \
            clazz = p_env.find_class(fq_name);                                       \
        }                                                                            \
                                                                                     \
        clazz.unregister_natives(p_env);                                             \
        clazz.delete_local_ref(p_env);                                               \
    }                                                                                \
                                                                                     \
private:

/**
 * This class wraps a JObject representing a JVM instance.
 * This class is a base that allows to setup JavaToNative and NativeToJava call easily.
 * One implementation must be provided for every JVM class you wish to use.
 * Use INIT_JNI_BINDINGS macro to create a static instance that will handle the JNI setup for that class.
 * The (env, local) constructor takes a local reference, promotes it to a strong global one and deletes the local. The
 * adopting constructors take references that are already global: either a strong one whose strength never changes, or
 * a permanent weak one plus the pin that makes it strong while something else owns the object too (see the KtObject
 * factories).
 */
template<class Derived, const char* FqName>
class JvmInstanceWrapper {
protected:
    jni::JObject wrapped;
    bool wrapped_is_weak = false;
    std::atomic<jobject> pin = nullptr;

    explicit JvmInstanceWrapper(jni::Env& p_env, jni::JObject p_wrapped);
    explicit JvmInstanceWrapper(jni::JObject p_global_ref);
    JvmInstanceWrapper(jni::JObject p_weak_ref, jni::JObject p_pin);
    // Empties the source, so a wrapper can be returned from a factory and settled into whatever owns it. The atomic
    // pin suppresses the implicit move and copying altogether, which is why this one is written out.
    JvmInstanceWrapper(JvmInstanceWrapper&& p_other) noexcept;
    ~JvmInstanceWrapper();

public:
    bool is_ref_weak() const;
    bool is_collected(jni::Env& p_env) const;
    const jni::JObject& get_wrapped() const;
    // Returns false when the JVM object is already collected, in which case the reference stays weak.
    bool swap_to_strong_unsafe(jni::Env& p_env);
    // Publishes a weak reference in place of the strong one, then asks p_must_stay_strong() whether the owner gained
    // another user in the meantime and cancels the swap if so. The strong reference is only released after that
    // decision, so the JVM instance cannot be collected in between. Returns whether the reference is weak afterwards.
    template<typename Predicate>
    bool swap_to_weak_unsafe(jni::Env& p_env, Predicate p_must_stay_strong);

    static bool initialize(jni::Env& p_env, ClassLoader* class_loader);
    static Derived* create_instance(jni::Env& p_env, ClassLoader* class_loader);
    static void finalize(jni::Env& p_env, ClassLoader* class_loader);
};

template<class Derived, const char* FqName>
JvmInstanceWrapper<Derived, FqName>::JvmInstanceWrapper(jni::Env& p_env, jni::JObject p_wrapped) {
    // When created, it's a strong reference by default
    wrapped = p_wrapped.new_global_ref<jni::JObject>(p_env);
    p_wrapped.delete_local_ref(p_env);
}

template<class Derived, const char* FqName>
JvmInstanceWrapper<Derived, FqName>::JvmInstanceWrapper(jni::JObject p_global_ref) : wrapped(p_global_ref) {}

template<class Derived, const char* FqName>
JvmInstanceWrapper<Derived, FqName>::JvmInstanceWrapper(jni::JObject p_weak_ref, jni::JObject p_pin) :
    wrapped(p_weak_ref),
    wrapped_is_weak(true),
    pin(p_pin.obj) {}

template<class Derived, const char* FqName>
JvmInstanceWrapper<Derived, FqName>::JvmInstanceWrapper(JvmInstanceWrapper&& p_other) noexcept :
    wrapped(p_other.wrapped),
    wrapped_is_weak(p_other.wrapped_is_weak),
    pin(p_other.pin.exchange(nullptr)) {
    p_other.wrapped = jni::JObject();
}

template<class Derived, const char* FqName>
bool JvmInstanceWrapper<Derived, FqName>::initialize(jni::Env& p_env, ClassLoader* class_loader) {
    Derived::initialize_jni_binding(p_env, class_loader);
    return true;
}

template<class Derived, const char* FqName>
Derived* JvmInstanceWrapper<Derived, FqName>::create_instance(jni::Env& p_env, ClassLoader* class_loader) {
    jni::JClass cls;
    if (class_loader) {
        cls = class_loader->load_class(p_env, FqName);
    } else {
        cls = p_env.find_class(FqName);
    }
    jni::MethodID ctor = cls.get_constructor_method_id(p_env, "()V");
    jni::JObject instance = cls.new_instance(p_env, ctor);
    cls.delete_local_ref(p_env);
    // The instance is a local reference too, but the constructor below promotes it and drops it.
    return new Derived(p_env, instance);
}

template<class Derived, const char* FqName>
void JvmInstanceWrapper<Derived, FqName>::finalize(jni::Env& p_env, ClassLoader* class_loader) {
    Derived::finalize_jni_binding(p_env, class_loader);
}

template<class Derived, const char* FqName>
JvmInstanceWrapper<Derived, FqName>::~JvmInstanceWrapper() {
    // Empty once moved from, and when the reference could not be created in the first place.
    if (wrapped.is_null()) { return; }

    jni::Env env = jni::Jvm::current_env();

    // The pin is released last so the instance is still strongly reachable while its weak reference is deleted.
    if (wrapped_is_weak) {
        wrapped.delete_weak_ref(env);
    } else {
        wrapped.delete_global_ref(env);
    }
    if (jobject strong = pin.load(std::memory_order_acquire)) { jni::JObject(strong).delete_global_ref(env); }
}

template<class Derived, const char* FqName>
bool JvmInstanceWrapper<Derived, FqName>::is_ref_weak() const {
    return wrapped_is_weak && pin.load(std::memory_order_acquire) == nullptr;
}

template<class Derived, const char* FqName>
bool JvmInstanceWrapper<Derived, FqName>::is_collected(jni::Env& p_env) const {
    return is_ref_weak() && wrapped.is_same_object(p_env, jni::JObject());
}

template<class Derived, const char* FqName>
bool JvmInstanceWrapper<Derived, FqName>::swap_to_strong_unsafe(jni::Env& p_env) {
    jni::JObject strong = wrapped.new_global_ref<jni::JObject>(p_env);
    if (strong.is_null()) { return false; }
    pin.store(strong.obj, std::memory_order_release);
    return true;
}

template<class Derived, const char* FqName>
template<typename Predicate>
bool JvmInstanceWrapper<Derived, FqName>::swap_to_weak_unsafe(jni::Env& p_env, Predicate p_must_stay_strong) {
    jobject strong = pin.exchange(nullptr);

    // Orders the publication of the weak state before whatever p_must_stay_strong() reads, pairing with the fence in
    // JvmInstance::refcount_incremented.
    std::atomic_thread_fence(std::memory_order_seq_cst);
    if (p_must_stay_strong()) {
        pin.store(strong);
        return false;
    }

    jni::JObject(strong).delete_global_ref(p_env);
    return true;
}

template<class Derived, const char* FqName>
const jni::JObject& JvmInstanceWrapper<Derived, FqName>::get_wrapped() const {
    return wrapped;
}

#endif // GODOT_JVM_JVM_INSTANCE_WRAPPER_H
