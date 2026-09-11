#ifndef GODOT_JVM_PATHS_H
#define GODOT_JVM_PATHS_H

// The Gradle plugin writes these locations (godot.tools.common.constants.Paths and ArtifactNames). Keep both in sync.

// Macros so they can be concatenated into the other paths.
#define JVM_DIRECTORY "jvm/"
#define JVM_DEBUG_DIRECTORY JVM_DIRECTORY "debug/"
#define JVM_RELEASE_DIRECTORY JVM_DIRECTORY "release/"

static constexpr const char* USER_DIRECTORY = "user://";
static constexpr const char* RES_DIRECTORY = "res://";

static constexpr const char* BUILD_DIRECTORY = "res://build";
static constexpr const char* JVM_CONFIGURATION_PATH = "res://godot_jvm_configuration.json";

// Shared by both variants.
static constexpr const char* LINUX_EMBEDDED_JRE_ARM_DIRECTORY = JVM_DIRECTORY "jre-arm64-linux";
static constexpr const char* LINUX_EMBEDDED_JRE_AMD_DIRECTORY = JVM_DIRECTORY "jre-amd64-linux";
static constexpr const char* LINUX_RELATIVE_JVM_LIB_PATH = "lib/server/libjvm.so";

static constexpr const char* WINDOWS_EMBEDDED_JRE_ARM_DIRECTORY = JVM_DIRECTORY "jre-arm64-windows";
static constexpr const char* WINDOWS_EMBEDDED_JRE_AMD_DIRECTORY = JVM_DIRECTORY "jre-amd64-windows";
static constexpr const char* WINDOWS_RELATIVE_JVM_LIB_PATH = "bin/server/jvm.dll";

static constexpr const char* MACOS_EMBEDDED_JRE_ARM_DIRECTORY = JVM_DIRECTORY "jre-arm64-macos";
static constexpr const char* MACOS_EMBEDDED_JRE_AMD_DIRECTORY = JVM_DIRECTORY "jre-amd64-macos";
static constexpr const char* MACOS_RELATIVE_JVM_LIB_PATH = "lib/server/libjvm.dylib";

static constexpr const char* ANDROID_RELATIVE_JVM_LIB_PATH = "";

static constexpr const char* IOS_RELATIVE_JVM_LIB_PATH = "";
static constexpr const char* IOS_JAVA_STATIC_LIBRARY = JVM_DIRECTORY "ios/ios-jdk/libjava-release.a";
static constexpr const char* IOS_JVM_STATIC_LIBRARY = JVM_DIRECTORY "ios/ios-jdk/libjvm-release.a";

// Debug builds ship bootstrap and user code as two archives so the editor can reload user code; release builds
// merge both into one.
static constexpr const char* DESKTOP_DEBUG_BOOTSTRAP_FILE = JVM_DEBUG_DIRECTORY "godot-bootstrap.jar";
static constexpr const char* DESKTOP_DEBUG_USER_CODE_FILE = JVM_DEBUG_DIRECTORY "usercode.jar";
static constexpr const char* DESKTOP_RELEASE_USER_CODE_FILE = JVM_RELEASE_DIRECTORY "game.jar";
static constexpr const char* DEBUG_EXTERNAL_JARS_DIRECTORY = JVM_DEBUG_DIRECTORY "external/";
static constexpr const char* RELEASE_EXTERNAL_JARS_DIRECTORY = JVM_RELEASE_DIRECTORY "external/";

static constexpr const char* LINUX_DEBUG_GRAAL_NATIVE_IMAGE_FILE = JVM_DEBUG_DIRECTORY "game.so";
static constexpr const char* LINUX_RELEASE_GRAAL_NATIVE_IMAGE_FILE = JVM_RELEASE_DIRECTORY "game.so";
static constexpr const char* WINDOWS_DEBUG_GRAAL_NATIVE_IMAGE_FILE = JVM_DEBUG_DIRECTORY "game.dll";
static constexpr const char* WINDOWS_RELEASE_GRAAL_NATIVE_IMAGE_FILE = JVM_RELEASE_DIRECTORY "game.dll";
static constexpr const char* MACOS_DEBUG_GRAAL_NATIVE_IMAGE_FILE = JVM_DEBUG_DIRECTORY "game.dylib";
static constexpr const char* MACOS_RELEASE_GRAAL_NATIVE_IMAGE_FILE = JVM_RELEASE_DIRECTORY "game.dylib";

static constexpr const char* ANDROID_DEBUG_BOOTSTRAP_FILE = JVM_DEBUG_DIRECTORY "godot-bootstrap-dex.jar";
static constexpr const char* ANDROID_DEBUG_USER_CODE_FILE = JVM_DEBUG_DIRECTORY "usercode-dex.jar";
static constexpr const char* ANDROID_RELEASE_USER_CODE_FILE = JVM_RELEASE_DIRECTORY "game-dex.jar";

static constexpr const char* IOS_GRAAL_NATIVE_IMAGE_FILE = "game.a";
static constexpr const char* IOS_DEBUG_GRAAL_NATIVE_IMAGE_ARCHIVE = JVM_DEBUG_DIRECTORY "game.a";
static constexpr const char* IOS_RELEASE_GRAAL_NATIVE_IMAGE_ARCHIVE = JVM_RELEASE_DIRECTORY "game.a";

// The editor and template_debug load the debug variant, template_release the release variant.
#ifdef DEBUG_ENABLED
static constexpr bool MERGED_USER_CODE = false;
static constexpr const char* DESKTOP_BOOTSTRAP_FILE = DESKTOP_DEBUG_BOOTSTRAP_FILE;
static constexpr const char* DESKTOP_USER_CODE_FILE = DESKTOP_DEBUG_USER_CODE_FILE;
static constexpr const char* EXTERNAL_JARS_DIRECTORY = DEBUG_EXTERNAL_JARS_DIRECTORY;
static constexpr const char* LINUX_GRAAL_NATIVE_IMAGE_FILE = LINUX_DEBUG_GRAAL_NATIVE_IMAGE_FILE;
static constexpr const char* WINDOWS_GRAAL_NATIVE_IMAGE_FILE = WINDOWS_DEBUG_GRAAL_NATIVE_IMAGE_FILE;
static constexpr const char* MACOS_GRAAL_NATIVE_IMAGE_FILE = MACOS_DEBUG_GRAAL_NATIVE_IMAGE_FILE;
static constexpr const char* ANDROID_BOOTSTRAP_FILE = ANDROID_DEBUG_BOOTSTRAP_FILE;
static constexpr const char* ANDROID_USER_CODE_FILE = ANDROID_DEBUG_USER_CODE_FILE;
#else
// The merged release archive is both the bootstrap and the user code archive.
static constexpr bool MERGED_USER_CODE = true;
static constexpr const char* DESKTOP_BOOTSTRAP_FILE = DESKTOP_RELEASE_USER_CODE_FILE;
static constexpr const char* DESKTOP_USER_CODE_FILE = DESKTOP_RELEASE_USER_CODE_FILE;
static constexpr const char* EXTERNAL_JARS_DIRECTORY = RELEASE_EXTERNAL_JARS_DIRECTORY;
static constexpr const char* LINUX_GRAAL_NATIVE_IMAGE_FILE = LINUX_RELEASE_GRAAL_NATIVE_IMAGE_FILE;
static constexpr const char* WINDOWS_GRAAL_NATIVE_IMAGE_FILE = WINDOWS_RELEASE_GRAAL_NATIVE_IMAGE_FILE;
static constexpr const char* MACOS_GRAAL_NATIVE_IMAGE_FILE = MACOS_RELEASE_GRAAL_NATIVE_IMAGE_FILE;
static constexpr const char* ANDROID_BOOTSTRAP_FILE = ANDROID_RELEASE_USER_CODE_FILE;
static constexpr const char* ANDROID_USER_CODE_FILE = ANDROID_RELEASE_USER_CODE_FILE;
#endif

static constexpr const char* ANDROID_GRAAL_NATIVE_IMAGE_FILE = "";

static constexpr const char* IOS_BOOTSTRAP_FILE = "";
static constexpr const char* IOS_USER_CODE_FILE = "";

#ifdef LINUX_ENABLED
#ifdef __arm64__
static constexpr const char* HOST_EMBEDDED_JRE_DIRECTORY = LINUX_EMBEDDED_JRE_ARM_DIRECTORY;
#else
static constexpr const char* HOST_EMBEDDED_JRE_DIRECTORY = LINUX_EMBEDDED_JRE_AMD_DIRECTORY;
#endif

static constexpr const char* BOOTSTRAP_FILE = DESKTOP_BOOTSTRAP_FILE;
static constexpr const char* USER_CODE_FILE = DESKTOP_USER_CODE_FILE;
static constexpr const char* GRAAL_NATIVE_IMAGE_FILE = LINUX_GRAAL_NATIVE_IMAGE_FILE;
static constexpr const char* RELATIVE_JVM_LIB_PATH = LINUX_RELATIVE_JVM_LIB_PATH;

#elif WINDOWS_ENABLED
#ifdef __arm64__
static constexpr const char* HOST_EMBEDDED_JRE_DIRECTORY = WINDOWS_EMBEDDED_JRE_ARM_DIRECTORY;
#else
static constexpr const char* HOST_EMBEDDED_JRE_DIRECTORY = WINDOWS_EMBEDDED_JRE_AMD_DIRECTORY;
#endif

static constexpr const char* BOOTSTRAP_FILE = DESKTOP_BOOTSTRAP_FILE;
static constexpr const char* USER_CODE_FILE = DESKTOP_USER_CODE_FILE;
static constexpr const char* GRAAL_NATIVE_IMAGE_FILE = WINDOWS_GRAAL_NATIVE_IMAGE_FILE;
static constexpr const char* RELATIVE_JVM_LIB_PATH = WINDOWS_RELATIVE_JVM_LIB_PATH;

#elif MACOS_ENABLED
#ifdef __arm64__
static constexpr const char* HOST_EMBEDDED_JRE_DIRECTORY = MACOS_EMBEDDED_JRE_ARM_DIRECTORY;
#else
static constexpr const char* HOST_EMBEDDED_JRE_DIRECTORY = MACOS_EMBEDDED_JRE_AMD_DIRECTORY;
#endif

static constexpr const char* BOOTSTRAP_FILE = DESKTOP_BOOTSTRAP_FILE;
static constexpr const char* USER_CODE_FILE = DESKTOP_USER_CODE_FILE;
static constexpr const char* GRAAL_NATIVE_IMAGE_FILE = MACOS_GRAAL_NATIVE_IMAGE_FILE;
static constexpr const char* RELATIVE_JVM_LIB_PATH = MACOS_RELATIVE_JVM_LIB_PATH;

#elif ANDROID_ENABLED
static constexpr const char* BOOTSTRAP_FILE = ANDROID_BOOTSTRAP_FILE;
static constexpr const char* USER_CODE_FILE = ANDROID_USER_CODE_FILE;
static constexpr const char* GRAAL_NATIVE_IMAGE_FILE = ANDROID_GRAAL_NATIVE_IMAGE_FILE;
static constexpr const char* RELATIVE_JVM_LIB_PATH = ANDROID_RELATIVE_JVM_LIB_PATH;

#elif IOS_ENABLED

static constexpr const char* BOOTSTRAP_FILE = IOS_BOOTSTRAP_FILE;
static constexpr const char* USER_CODE_FILE = IOS_USER_CODE_FILE;
static constexpr const char* GRAAL_NATIVE_IMAGE_FILE = IOS_GRAAL_NATIVE_IMAGE_FILE;
static constexpr const char* RELATIVE_JVM_LIB_PATH = IOS_RELATIVE_JVM_LIB_PATH;

#endif

#endif // GODOT_JVM_PATHS_H
