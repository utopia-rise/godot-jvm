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
 * adopting constructor takes a reference that is already global, strong or weak, for wrappers that pick their initial
 * strength themselves (see KtObject::create_strong / create_weak).
 */
template<class Derived, const char* FqName>
class JvmInstanceWrapper {
protected:
    std::atomic<bool> is_weak = false;
    jni::JObject wrapped;

    explicit JvmInstanceWrapper(jni::Env& p_env, jni::JObject p_wrapped);
    JvmInstanceWrapper(jni::JObject p_global_ref, bool p_is_weak);
    ~JvmInstanceWrapper();

public:
    bool is_ref_weak() const;
    const jni::JObject& get_wrapped() const;
    void swap_to_strong_unsafe(jni::Env& p_env);
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
JvmInstanceWrapper<Derived, FqName>::JvmInstanceWrapper(jni::JObject p_global_ref, bool p_is_weak) :
    is_weak(p_is_weak),
    wrapped(p_global_ref) {}

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
    return new Derived(p_env, instance);
}

template<class Derived, const char* FqName>
void JvmInstanceWrapper<Derived, FqName>::finalize(jni::Env& p_env, ClassLoader* class_loader) {
    Derived::finalize_jni_binding(p_env, class_loader);
}

template<class Derived, const char* FqName>
JvmInstanceWrapper<Derived, FqName>::~JvmInstanceWrapper() {
    jni::Env env = jni::Jvm::current_env();
    if (is_weak) {
        wrapped.delete_weak_ref(env);
    } else {
        wrapped.delete_global_ref(env);
    }
}

template<class Derived, const char* FqName>
bool JvmInstanceWrapper<Derived, FqName>::is_ref_weak() const {
    return is_weak;
}

template<class Derived, const char* FqName>
void JvmInstanceWrapper<Derived, FqName>::swap_to_strong_unsafe(jni::Env& p_env) {
    // Assume the reference is currently weak
    jni::JObject new_ref = wrapped.new_global_ref<jni::JObject>(p_env);
    wrapped.delete_weak_ref(p_env);
    wrapped = new_ref;
    is_weak = false;
}

template<class Derived, const char* FqName>
template<typename Predicate>
bool JvmInstanceWrapper<Derived, FqName>::swap_to_weak_unsafe(jni::Env& p_env, Predicate p_must_stay_strong) {
    // Assume the reference is currently strong
    jni::JObject strong_ref = wrapped;
    wrapped = wrapped.new_weak_ref<jni::JObject>(p_env);
    is_weak = true;

    // Orders the publication of the weak flag before whatever p_must_stay_strong() reads. A thread that gave the owner
    // another user either did so before this fence, and the predicate sees it, or after it, and that thread sees the
    // weak flag and promotes (see JvmInstance::refcount_incremented for the pairing fence).
    std::atomic_thread_fence(std::memory_order_seq_cst);
    if (p_must_stay_strong()) {
        wrapped.delete_weak_ref(p_env);
        wrapped = strong_ref;
        is_weak = false;
        return false;
    }

    strong_ref.delete_global_ref(p_env);
    return true;
}

template<class Derived, const char* FqName>
const jni::JObject& JvmInstanceWrapper<Derived, FqName>::get_wrapped() const {
    return wrapped;
}

#endif // GODOT_JVM_JVM_INSTANCE_WRAPPER_H
