#include "memory_manager.h"

#include "api/script/jvm_script_manager.h"
#include "core/jvm_binding_manager.h"
#include "core/variant_allocator.h"
#include "engine/godot_object.h"
#include "logging.h"

#include <classes/os.hpp>
#include <core/object.hpp>

// Release report layout, mirrored from MemoryManager.kt.
static constexpr uint32_t CONFIRMED_COUNT_INDEX = 0;
static constexpr uint32_t CANDIDATE_COUNT_INDEX = 1;
static constexpr uint32_t IDS_START_INDEX = 2;

static godot::LocalVector<uint64_t> ids;
static godot::LocalVector<uintptr_t> pointers;
static godot::LocalVector<uint32_t> variant_types;

bool MemoryManager::check_instance(JNIEnv*, jobject, jlong p_raw_ptr, jlong instance_id) {
    godot::GodotObject* instance = raw_godot::RawObject::from_instance_id(instance_id);
    return instance != nullptr && instance == reinterpret_cast<godot::GodotObject*>(static_cast<uintptr_t>(p_raw_ptr));
}

void MemoryManager::release_binding(JNIEnv*, jobject, jlong instance_id) {
    godot::GodotObject* obj = raw_godot::RawObject::from_instance_id(instance_id);
    if (obj == nullptr) { return; }

    ::godot::JvmBindingManager::unbind(obj);
}

void MemoryManager::unref_native_core_types(JNIEnv* p_raw_env, jobject, jobject p_ptr_array, jobject p_var_type_array) {
    jni::Env env(p_raw_env);
    jni::JLongArray ptr_array(p_ptr_array);
    jni::JIntArray var_type_array(p_var_type_array);

    jint size = ptr_array.length(env);
    pointers.resize(size);
    variant_types.resize(size);

    ptr_array.get_array_elements(env, reinterpret_cast<jlong*>(pointers.ptr()), size);
    var_type_array.get_array_elements(env, reinterpret_cast<jint*>(variant_types.ptr()), size);

    for (int i = 0; i < size; ++i) {
        uintptr_t p_raw_ptr = pointers[i];
        uint32_t var_type = variant_types[i];

        godot::Variant::Type variant_type = static_cast<godot::Variant::Type>(var_type);
        switch (variant_type) {
            case godot::Variant::CALLABLE:
                VariantAllocator::free(reinterpret_cast<godot::Callable*>(p_raw_ptr));
                break;
            case godot::Variant::DICTIONARY:
                VariantAllocator::free(reinterpret_cast<godot::Dictionary*>(p_raw_ptr));
                break;
            case godot::Variant::ARRAY:
                VariantAllocator::free(reinterpret_cast<godot::Array*>(p_raw_ptr));
                break;
            case godot::Variant::STRING_NAME:
                VariantAllocator::free(reinterpret_cast<godot::StringName*>(p_raw_ptr));
                break;
            case godot::Variant::NODE_PATH:
                VariantAllocator::free(reinterpret_cast<godot::NodePath*>(p_raw_ptr));
                break;
            case godot::Variant::PACKED_BYTE_ARRAY:
                VariantAllocator::free(reinterpret_cast<godot::PackedByteArray*>(p_raw_ptr));
                break;
            case godot::Variant::PACKED_INT32_ARRAY:
                VariantAllocator::free(reinterpret_cast<godot::PackedInt32Array*>(p_raw_ptr));
                break;
            case godot::Variant::PACKED_INT64_ARRAY:
                VariantAllocator::free(reinterpret_cast<godot::PackedInt64Array*>(p_raw_ptr));
                break;
            case godot::Variant::PACKED_FLOAT32_ARRAY:
                VariantAllocator::free(reinterpret_cast<godot::PackedFloat32Array*>(p_raw_ptr));
                break;
            case godot::Variant::PACKED_FLOAT64_ARRAY:
                VariantAllocator::free(reinterpret_cast<godot::PackedFloat64Array*>(p_raw_ptr));
                break;
            case godot::Variant::PACKED_STRING_ARRAY:
                VariantAllocator::free(reinterpret_cast<godot::PackedStringArray*>(p_raw_ptr));
                break;
            case godot::Variant::PACKED_VECTOR2_ARRAY:
                VariantAllocator::free(reinterpret_cast<godot::PackedVector2Array*>(p_raw_ptr));
                break;
            case godot::Variant::PACKED_VECTOR3_ARRAY:
                VariantAllocator::free(reinterpret_cast<godot::PackedVector3Array*>(p_raw_ptr));
                break;
            case godot::Variant::PACKED_VECTOR4_ARRAY:
                VariantAllocator::free(reinterpret_cast<godot::PackedVector4Array*>(p_raw_ptr));
                break;
            case godot::Variant::PACKED_COLOR_ARRAY:
                VariantAllocator::free(reinterpret_cast<godot::PackedColorArray*>(p_raw_ptr));
                break;
            default:
                break;
        }
    }

    pointers.clear();
    variant_types.clear();
}

void MemoryManager::query_sync(JNIEnv* p_raw_env, jobject) {
    godot::OS* os = godot::OS::get_singleton();
    JVM_ERR_FAIL_COND_MSG(
        os->get_thread_caller_id() != os->get_main_thread_id(),
        "GD.syncMemory() must be called from the main thread."
    );

    jni::Env env(p_raw_env);
    MemoryManager::get_instance().sync_memory(env);
}

void MemoryManager::sync_memory(jni::Env& p_env) {
    // Read the list of references to demote, we do it at the end of a frame instead of the constant ping-pong happening
    // each call.
    to_demote_mutex.lock();
    for (::godot::JvmInstance::JvmInstanceData* script_instance : to_demote_objects) {
        ::godot::JvmInstance::demote_reference(script_instance);
    }
    to_demote_objects.clear();
    to_demote_mutex.unlock();

    // Read the list of dead objects and copy them to the JVM.
    dead_objects_mutex.lock();
    jint size = static_cast<jsize>(dead_objects.size());
    jni::JLongArray arr(p_env, size);
    arr.set_array_elements(p_env, reinterpret_cast<const jlong*>(dead_objects.ptr()), size);
    dead_objects.clear();
    dead_objects_mutex.unlock();

    jvalue args[1] = {jni::to_jni_arg(arr)};
    jni::JLongArray release_report(wrapped.call_object_method(p_env, SYNC_MEMORY, args));
    arr.delete_local_ref(p_env);

    // Layout: [confirmed count, candidate count, confirmed ids..., candidate ids...], see
    // MemoryManager.buildReleaseReport on the JVM side. A wrapper's death only makes its object a candidate: its
    // binding's delivery count is recorded here, and the reference is released at the next sync if the JVM confirms no
    // wrapper reappeared and the count did not move. A delivery in flight across either sync thus keeps the reference
    // for the wrapper it creates instead of having it released underneath.
    jlong header[IDS_START_INDEX];
    release_report.get_array_region(p_env, 0, header, IDS_START_INDEX);
    uint32_t candidates_start = IDS_START_INDEX + static_cast<uint32_t>(header[CONFIRMED_COUNT_INDEX]);
    uint32_t report_size = candidates_start + static_cast<uint32_t>(header[CANDIDATE_COUNT_INDEX]);
    ids.resize(report_size);
    release_report.get_array_region(p_env, 0, reinterpret_cast<jlong*>(ids.ptr()), report_size);
    release_report.delete_local_ref(p_env);

    for (uint32_t i = IDS_START_INDEX; i < candidates_start; ++i) {
        godot::ObjectID id(ids[i]);
        uint32_t* deliveries_at_death = release_candidates.getptr(id);
        if (deliveries_at_death == nullptr) { continue; }
        uint32_t deliveries = *deliveries_at_death;
        release_candidates.erase(id);

        godot::GodotObject* ref = raw_godot::RawObject::from_instance_id(id);
        if (likely(ref != nullptr)) {
            ::godot::JvmBindingManager::unbind_unless_delivered_since(ref, deliveries);
        } else {
#ifdef DEBUG_ENABLED
            JVM_ERR_PRINT(
                "RefCounted %d was destroyed while the JVM still held a reference to it. Something released it without "
                "going through the binding.",
                static_cast<uint64_t>(id)
            );
#endif
        }
    }
    for (uint32_t i = candidates_start; i < report_size; ++i) {
        godot::ObjectID id(ids[i]);
        godot::GodotObject* ref = raw_godot::RawObject::from_instance_id(id);
        if (likely(ref != nullptr)) {
            release_candidates.insert(id, ::godot::JvmBindingManager::get_deliveries(ref));
        } else {
#ifdef DEBUG_ENABLED
            JVM_ERR_PRINT(
                "RefCounted %d died before its JVM wrapper's death was processed; the JVM's reference should have kept "
                "it alive.",
                static_cast<uint64_t>(id)
            );
#endif
        }
    }

    ids.clear();
}

void MemoryManager::clean_up(jni::Env& p_env) {
    JVM_LOG_VERBOSE("Cleaning JVM Memory...");
    sync_memory(p_env);
    wrapped.call_void_method(p_env, CLEAN_UP);
    release_candidates.clear();
    JVM_LOG_VERBOSE("JVM Memory cleaned!");
}

void MemoryManager::queue_dead_object(godot::ObjectID p_object_id) {
    dead_objects_mutex.lock();
    dead_objects.push_back(p_object_id);
    dead_objects_mutex.unlock();
}

void MemoryManager::queue_demotion(::godot::JvmInstance::JvmInstanceData* script_instance) {
    to_demote_mutex.lock();
    to_demote_objects.insert(script_instance);
    to_demote_mutex.unlock();
}

void MemoryManager::cancel_demotion(::godot::JvmInstance::JvmInstanceData* script_instance) {
    to_demote_mutex.lock();
    to_demote_objects.erase(script_instance);
    to_demote_mutex.unlock();
}

void MemoryManager::try_promotion(::godot::JvmInstance::JvmInstanceData* script_instance) {
    to_demote_mutex.lock();
    ::godot::JvmInstance::promote_reference(script_instance);
    to_demote_mutex.unlock();
}

void MemoryManager::direct_object_deletion(jni::Env& p_env, godot::GodotObject* p_obj) {
    raw_godot::RawObject object = p_obj;
    jvalue args[1] = {jni::to_jni_arg(object.get_instance_id())};
    wrapped.call_void_method(p_env, DELETE_OBJECT, args);
    object.destroy();
}

MemoryManager::~MemoryManager() = default;
