#include "jvm_manager.h"

#include "engine/dynamic_library.h"
#include "jvm/wrapper/bootstrap.h"
#include "jvm/wrapper/bridge/callable_bridge.h"
#include "jvm/wrapper/bridge/dictionary_bridge.h"
#include "jvm/wrapper/bridge/godot_print_bridge.h"
#include "jvm/wrapper/bridge/node_path_bridge.h"
#include "jvm/wrapper/bridge/packed_array_bridge.h"
#include "jvm/wrapper/bridge/packed_byte_array_bridge.h"
#include "jvm/wrapper/bridge/packed_color_array_bridge.h"
#include "jvm/wrapper/bridge/packed_float_32_array_bridge.h"
#include "jvm/wrapper/bridge/packed_float_64_array_bridge.h"
#include "jvm/wrapper/bridge/packed_int_32_array_bridge.h"
#include "jvm/wrapper/bridge/packed_int_64_array_bridge.h"
#include "jvm/wrapper/bridge/packed_string_array_bridge.h"
#include "jvm/wrapper/bridge/packed_vector2_array_bridge.h"
#include "jvm/wrapper/bridge/packed_vector3_array_bridge.h"
#include "jvm/wrapper/bridge/packed_vector4_array_bridge.h"
#include "jvm/wrapper/bridge/string_name_bridge.h"
#include "jvm/wrapper/bridge/variant_array_bridge.h"
#include "jvm/wrapper/kotlin_callable_custom.h"
#include "jvm/wrapper/memory/memory_manager.h"

#include <jni.h>

#include <locale>

#ifdef ANDROID_ENABLED
#include "jvm/android/android_jvm_context.h"
#endif

typedef jint(JNICALL* CreateJavaVM)(JavaVM**, void**, void*);

CreateJavaVM get_create_jvm_function(void* lib_handle) {
#ifdef DYNAMIC_JVM
    void* createJavaVMSymbolHandle;
    if (godot_jvm_native::get_dynamic_library_symbol_handle(lib_handle, "JNI_CreateJavaVM", createJavaVMSymbolHandle) != godot::OK) {
        return nullptr;
    }
    return reinterpret_cast<CreateJavaVM>(createJavaVMSymbolHandle);
#elif defined STATIC_JVM
    return &JNI_CreateJavaVM;
#else
    // Sanity check in case we mess up preprocessors
    JVM_DEV_ASSERT(false, "Current configuration doesn't provide a way to create a JVM!");
    return nullptr;
#endif
}

bool JvmManager::initialize_or_get_jvm(void* lib_handle, JvmUserConfiguration& user_configuration, JvmOptions& jvm_options) {
    JavaVM* java_vm {nullptr};

#if defined DYNAMIC_JVM || defined STATIC_JVM
    uint32_t nOptions {jvm_options.options.size()};
    auto* options = new JavaVMOption[nOptions];
    JavaVMInitArgs args;
    args.version = jvm_options.version;
    args.nOptions = static_cast<jint>(nOptions);
    args.options = options;

    for (auto i = 0; i < static_cast<int>(nOptions); i++) {
        args.options[i].optionString = jvm_options.options[i].ptrw();
        JVM_DEV_VERBOSE("JVM argument %s: %s", i, args.options[i].optionString);
    }

    std::locale global;

    JVM_LOG_VERBOSE("Starting JVM ...");
    JNIEnv* jni_env {nullptr};

    CreateJavaVM func {get_create_jvm_function(lib_handle)};
    JVM_ERR_FAIL_COND_V_MSG(func == nullptr, false, "Failed to obtain JNI_CreateJavaVM symbol!");
    jint result {func(&java_vm, reinterpret_cast<void**>(&jni_env), &args)};

    // Set std::local::global to value it was before creating JVM. See https://github.com/utopia-rise/godot-jvm/issues/166 and https://github.com/utopia-rise/godot-jvm/issues/170

    std::locale::global(global);

    delete[] options;
    JVM_ERR_FAIL_COND_V_MSG(result != JNI_OK, false, "Failed to create a new vm!");

#elif defined PROVIDED_JVM
    JVM_LOG_VERBOSE("Retrieving existing JVM ...");
    java_vm = AndroidJvmContext::get_java_vm();
    JVM_ERR_FAIL_COND_V_MSG(
      java_vm == nullptr,
      false,
      "Android JVM context was not provided. Make sure the Godot-JVM Android plugin AAR is enabled."
    );
#else
    // Sanity check in case we mess up preprocessors
    JVM_DEV_ASSERT(java_vm, "Current configuration doesn't allow to create or fetch a JVM.");
#endif

    jni::Jvm::initialize(java_vm, user_configuration.vm_type, jvm_options.version);
    return true;
}

bool JvmManager::initialize_jvm_wrappers(jni::Env& p_env, ClassLoader* class_loader) {

    bool ret = KtObject::initialize(p_env, class_loader)
            && KtPropertyInfo::initialize(p_env, class_loader)
            && KtProperty::initialize(p_env, class_loader)
            && KtConstructor::initialize(p_env, class_loader)
            && KtSignalInfo::initialize(p_env, class_loader)
            && KtRpcConfig::initialize(p_env, class_loader)
            && KtFunctionInfo::initialize(p_env, class_loader)
            && KtFunction::initialize(p_env, class_loader)
            && KtClass::initialize(p_env, class_loader)
            && TransferContext::initialize(p_env, class_loader)
            && TypeManager::initialize(p_env, class_loader)
            && LongStringQueue::initialize(p_env, class_loader)
            && MemoryManager::initialize(p_env, class_loader)
            && LambdaContainer::initialize(p_env, class_loader)
            && bridges::GodotPrintBridge::initialize(p_env, class_loader)
            && bridges::CallableBridge::initialize(p_env, class_loader)
            && bridges::DictionaryBridge::initialize(p_env, class_loader)
            && bridges::StringNameBridge::initialize(p_env, class_loader)
            && bridges::NodePathBridge::initialize(p_env, class_loader)
            && bridges::VariantArrayBridge::initialize(p_env, class_loader)
            && bridges::PackedByteArrayBridge::initialize(p_env, class_loader)
            && bridges::PackedColorArrayBridge::initialize(p_env, class_loader)
            && bridges::PackedFloat32ArrayBridge::initialize(p_env, class_loader)
            && bridges::PackedFloat64ArrayBridge::initialize(p_env, class_loader)
            && bridges::PackedInt32ArrayBridge::initialize(p_env, class_loader)
            && bridges::PackedInt64ArrayBridge::initialize(p_env, class_loader)
            && bridges::PackedStringArrayBridge::initialize(p_env, class_loader)
            && bridges::PackedVector2ArrayBridge::initialize(p_env, class_loader)
            && bridges::PackedVector3ArrayBridge::initialize(p_env, class_loader)
            && bridges::PackedVector4ArrayBridge::initialize(p_env, class_loader);

    jni::Env::set_exception_handler(&bridges::GodotPrintBridge::print_exception_stacktrace);

    return ret;
}

void JvmManager::finalize_jvm_wrappers(jni::Env& p_env, ClassLoader* class_loader) {
    jni::Env::set_exception_handler(nullptr);

    TransferContext::finalize(p_env, class_loader);
    TypeManager::finalize(p_env, class_loader);
    LongStringQueue::finalize(p_env, class_loader);
    MemoryManager::finalize(p_env, class_loader);
    LambdaContainer::finalize(p_env, class_loader);
    bridges::GodotPrintBridge::finalize(p_env, class_loader);
    bridges::CallableBridge::finalize(p_env, class_loader);
    bridges::DictionaryBridge::finalize(p_env, class_loader);
    bridges::StringNameBridge::finalize(p_env, class_loader);
    bridges::NodePathBridge::finalize(p_env, class_loader);
    bridges::VariantArrayBridge::finalize(p_env, class_loader);
    bridges::PackedByteArrayBridge::finalize(p_env, class_loader);
    bridges::PackedColorArrayBridge::finalize(p_env, class_loader);
    bridges::PackedFloat32ArrayBridge::finalize(p_env, class_loader);
    bridges::PackedFloat64ArrayBridge::finalize(p_env, class_loader);
    bridges::PackedInt32ArrayBridge::finalize(p_env, class_loader);
    bridges::PackedInt64ArrayBridge::finalize(p_env, class_loader);
    bridges::PackedStringArrayBridge::finalize(p_env, class_loader);
    bridges::PackedVector2ArrayBridge::finalize(p_env, class_loader);
    bridges::PackedVector3ArrayBridge::finalize(p_env, class_loader);
    bridges::PackedVector4ArrayBridge::finalize(p_env, class_loader);
    KtObject::finalize(p_env, class_loader);
    KtPropertyInfo::finalize(p_env, class_loader);
    KtProperty::finalize(p_env, class_loader);
    KtConstructor::finalize(p_env, class_loader);
    KtSignalInfo::finalize(p_env, class_loader);
    KtRpcConfig::finalize(p_env, class_loader);
    KtFunctionInfo::finalize(p_env, class_loader);
    KtFunction::finalize(p_env, class_loader);
    KtClass::finalize(p_env, class_loader);
}

bool JvmManager::close_jvm() {
#if defined DYNAMIC_JVM || defined STATIC_JVM
    JVM_LOG_VERBOSE("Shutting down JVM ...");
    return jni::Jvm::destroy();
#else
    return true;
#endif
}
