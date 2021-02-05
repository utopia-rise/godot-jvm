//
// Created by cedric on 19.08.20.
//

#ifndef GODOT_LOADER_JVM_LOADER_H
#define GODOT_LOADER_JVM_LOADER_H

#include "jvm.h"

#ifdef __linux__
#define LIB_JVM_RELATIVE_PATH "lib/server/libjvm.so"
#define FILE_SEPARATOR "/"
#elif __APPLE__
#include <TargetConditionals.h>
    #if TARGET_OS_MAC
        #define LIB_JVM_RELATIVE_PATH "lib/server/libjvm.dylib"
        #define FILE_SEPARATOR "/"
    #endif
#elif defined _WIN32 || defined _WIN64
#define FILE_SEPARATOR "\\"
#define LIB_JVM_RELATIVE_PATH "bin\\server\\jvm.dll"
#endif

namespace jni {
    class JvmLoader {
    public:
        static CreateJavaVM getCreateJvmFunction();
        static GetCreatedJavaVMs getGetCreatedJavaVMsFunction();
        static void closeJvmLib();

    private:
        static void *jvmLib;
        static void loadJvmLib();
        static String getJvmLibPath();
        static String getPathToLocallyInstalledJvm();
    };
}


#endif //GODOT_LOADER_JVM_LOADER_H
