#ifndef GODOT_JVM_MEMORY_MANAGER_H
#define GODOT_JVM_MEMORY_MANAGER_H

#include "api/script/jvm_instance.h"
#include "jvm/jni/types.h"
#include "jvm/wrapper/jvm_singleton_wrapper.h"

#include <jni.h>

#include <templates/hash_set.hpp>
#include <templates/local_vector.hpp>

#include <mutex>

// clang-format off
JVM_SINGLETON_WRAPPER(MemoryManager, "godot.internal.memory.MemoryManager") {
    SINGLETON_CLASS(MemoryManager)

    JNI_OBJECT_METHOD(SYNC_MEMORY)
    JNI_VOID_METHOD(CLEAN_UP)
    JNI_VOID_METHOD(DELETE_OBJECT)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(SYNC_MEMORY, "syncMemory", "([J)[J")
        INIT_JNI_METHOD(CLEAN_UP, "cleanUp", "()V")
        INIT_JNI_METHOD(DELETE_OBJECT, "deleteObject", "(J)V")
        INIT_NATIVE_METHOD("checkInstance", "(JJ)Z", MemoryManager::check_instance)
        INIT_NATIVE_METHOD("unrefNativeCoreTypes", "([J[I)V", MemoryManager::unref_native_core_types)
        INIT_NATIVE_METHOD("querySync", "()V", MemoryManager::query_sync)
        INIT_NATIVE_METHOD("releaseBinding", "(J)V", MemoryManager::release_binding)
      )

    std::mutex dead_objects_mutex;
    godot::LocalVector<godot::ObjectID> dead_objects;

    std::mutex to_demote_mutex;
    godot::HashSet<::godot::JvmInstance::JvmInstanceData*> to_demote_objects;

    static bool check_instance(JNIEnv* p_raw_env, jobject p_instance, jlong p_raw_ptr, jlong instance_id);
    static void unref_native_core_types(JNIEnv* p_raw_env, jobject p_instance, jobject p_ptr_array, jobject p_var_type_array);
    static void query_sync(JNIEnv* p_raw_env, jobject p_instance);
    static void release_binding(JNIEnv* p_raw_env, jobject p_instance, jlong instance_id);

public:
    void direct_object_deletion(jni::Env& p_env, godot::GodotObject* obj);
    void queue_dead_object(godot::ObjectID p_object_id);
    void queue_demotion(::godot::JvmInstance::JvmInstanceData* script_instance);
    void cancel_demotion(::godot::JvmInstance::JvmInstanceData* script_instance);
    void try_promotion(::godot::JvmInstance::JvmInstanceData* script_instance);
    void sync_memory(jni::Env& p_env);
    void clean_up(jni::Env& p_env);
};

// clang-format on
#endif // GODOT_JVM_MEMORY_MANAGER_H
