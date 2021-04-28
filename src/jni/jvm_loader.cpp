#include "jvm_loader.h"

#include <core/os/os.h>
#include <core/project_settings.h>

#ifndef __ANDROID__

void* jni::JvmLoader::jvmLib{nullptr};

void jni::JvmLoader::load_jvm_lib() {
    String libPath{get_jvm_lib_path()};

    if (OS::get_singleton()->open_dynamic_library(libPath, jvmLib) != OK) {
        LOG_ERROR(String("Failed to load the jvm dynamic library from path ") + libPath + "!")
        exit(1);
    }
}

void jni::JvmLoader::close_jvm_lib() {
    if (OS::get_singleton()->close_dynamic_library(jvmLib) != OK) {
        LOG_ERROR("Failed to close the jvm dynamic library!")
    }
}

jni::CreateJavaVM jni::JvmLoader::get_create_jvm_function() {
    if (jvmLib == nullptr) {
        load_jvm_lib();
    }
    void* createJavaVMSymbolHandle;
    if (OS::get_singleton()->get_dynamic_library_symbol_handle(jvmLib, "JNI_CreateJavaVM", createJavaVMSymbolHandle) !=
        OK) {
        LOG_ERROR("Failed to get JNI_CreateJavaVM symbol handle")
        exit(1);
    }
    return reinterpret_cast<CreateJavaVM>(createJavaVMSymbolHandle);
}

jni::GetCreatedJavaVMs jni::JvmLoader::get_get_created_java_vm_function() {
    if (jvmLib == nullptr) {
        load_jvm_lib();
    }
    void* getCreatedJavaVMsSymbolHandle;
    if (OS::get_singleton()->get_dynamic_library_symbol_handle(jvmLib, "JNI_GetCreatedJavaVMs",
                                                               getCreatedJavaVMsSymbolHandle) != OK) {
        LOG_ERROR("Failed to get JNI_GetCreatedJavaVMs symbol handle")
        exit(1);
    }
    return reinterpret_cast<GetCreatedJavaVMs>(getCreatedJavaVMsSymbolHandle);
}

String jni::JvmLoader::get_jvm_lib_path() {
#ifdef __GRAAL__
    return ProjectSettings::get_singleton()->globalize_path("res://build/libs/usercode.dylib");
#endif
    if (Engine::get_singleton()->is_editor_hint()) {
        LOG_INFO("Godot-JVM: Editor mode, loading jvm from JAVA_HOME")
        return get_path_to_locally_installed_jvm();
    } else {
        String embeddedJrePath{
                ProjectSettings::get_singleton()->globalize_path(vformat("res://jre/%s", LIB_JVM_RELATIVE_PATH))};
        if (!FileAccess::exists(embeddedJrePath)) {
            LOG_WARNING(vformat("Godot-JVM: No embedded jvm found on path: %s!", embeddedJrePath))
#ifdef DEBUG_ENABLED
            LOG_WARNING(vformat("Godot-JVM: You really should embedd a jre in your game with jlink! See the documentation if you don't know how to do that"))
#endif
            return get_path_to_locally_installed_jvm();
        }
        return embeddedJrePath;
    }
}

String jni::JvmLoader::get_path_to_locally_installed_jvm() {
    String javaHome{OS::get_singleton()->get_environment("JAVA_HOME")};

    if (javaHome.empty()) {
        LOG_ERROR("JAVA_HOME is not defined! Exiting...")
        exit(1);
    }

    String pathToLocallyInstalledJvmLib{javaHome + FILE_SEPARATOR + LIB_JVM_RELATIVE_PATH};

#ifdef DEBUG_ENABLED
    LOG_VERBOSE(vformat("Godot-JVM: Trying to use locally installed jdk at %s", pathToLocallyInstalledJvmLib))
#endif

    if (!FileAccess::exists(pathToLocallyInstalledJvmLib)) {
        LOG_ERROR(vformat("Godot-JVM: No jvm found at %s! Exiting...", pathToLocallyInstalledJvmLib))
        exit(1);
    }
    return pathToLocallyInstalledJvmLib;
}

#endif
