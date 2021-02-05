#include "jvm_loader.h"

#include <core/engine.h>
#include <core/os/os.h>
#include <core/project_settings.h>

void *jni::JvmLoader::jvmLib = nullptr;

void jni::JvmLoader::loadJvmLib() {
    String libPath = getJvmLibPath();

    if (OS::get_singleton()->open_dynamic_library(libPath, jvmLib) != OK) {
        ERR_PRINT(String("Failed to load the jvm dynamic library from path ") + libPath + "!")
        exit(1);
    }
}

void jni::JvmLoader::closeJvmLib() {
    if (OS::get_singleton()->close_dynamic_library(jvmLib) != OK) {
        ERR_PRINT("Failed to close the jvm dynamic library!")
    }
}

jni::CreateJavaVM jni::JvmLoader::getCreateJvmFunction() {
    if (jvmLib == nullptr) {
        loadJvmLib();
    }
    void *createJavaVMSymbolHandle;
    if (OS::get_singleton()->get_dynamic_library_symbol_handle(jvmLib, "JNI_CreateJavaVM", createJavaVMSymbolHandle) != OK) {
        ERR_PRINT("Failed to get JNI_CreateJavaVM symbol handle")
        exit(1);
    }
    return reinterpret_cast<CreateJavaVM>(createJavaVMSymbolHandle);
}

jni::GetCreatedJavaVMs jni::JvmLoader::getGetCreatedJavaVMsFunction() {
    if (jvmLib == nullptr) {
        loadJvmLib();
    }
    void *getCreatedJavaVMsSymbolHandle;
    if (OS::get_singleton()->get_dynamic_library_symbol_handle(jvmLib, "JNI_GetCreatedJavaVMs", getCreatedJavaVMsSymbolHandle) != OK) {
        ERR_PRINT("Failed to get JNI_GetCreatedJavaVMs symbol handle")
        exit(1);
    }
    return reinterpret_cast<GetCreatedJavaVMs>(getCreatedJavaVMsSymbolHandle);
}

String jni::JvmLoader::getJvmLibPath() {
    if (Engine::get_singleton()->is_editor_hint()) {
        print_line("Godot-JVM: Editor mode, loading jvm from JAVA_HOME");
        return getPathToLocallyInstalledJvm();
    } else {
        String embeddedJrePath = ProjectSettings::get_singleton()->globalize_path("res://jre/") + getRelativePath();
        if (!FileAccess::exists(embeddedJrePath)) {
            WARN_PRINT(vformat("Godot-JVM: No embedded jvm found on path: %s!", embeddedJrePath))
#ifdef DEBUG_ENABLED
            WARN_PRINT(vformat("Godot-JVM: You really should embedd a jre in your game with jlink! See the documentation if you don't know how to do that"))
#endif
            return getPathToLocallyInstalledJvm();
        }
        return embeddedJrePath;
    }
}

String jni::JvmLoader::getPathToLocallyInstalledJvm() {
    String javaHome = getenv("JAVA_HOME");

    if (javaHome.empty()) {
        ERR_PRINT("JAVA_HOME is not defined! Exiting...")
        exit(1);
    }

    String pathToLocallyInstalledJvmLib = javaHome + getFileSeparator() + getRelativePath();

    print_verbose(vformat("Godot-JVM: Trying to use locally installed jdk at %s", pathToLocallyInstalledJvmLib));

    if (!FileAccess::exists(pathToLocallyInstalledJvmLib)) {
        ERR_PRINT(vformat("Godot-JVM: No jvm found at %s! Exiting...", pathToLocallyInstalledJvmLib))
        exit(1);
    }
    return pathToLocallyInstalledJvmLib;
}

String jni::JvmLoader::getRelativePath() {
#ifdef __linux__
    return "lib/server/libjvm.so";
#elif __APPLE__
    #include <TargetConditionals.h>
    #if TARGET_OS_MAC
        return "lib/server/libjvm.dylib";
    #endif
#elif defined _WIN32 || defined _WIN64
    return "bin\\server\\jvm.dll";
#endif
}

String jni::JvmLoader::getFileSeparator() {
#ifdef __linux__
    return "/";
#elif __APPLE__
    #include <TargetConditionals.h>
    #if TARGET_OS_MAC
        return "/";
    #endif
#elif defined _WIN32 || defined _WIN64
    return "\\";
#endif
}
