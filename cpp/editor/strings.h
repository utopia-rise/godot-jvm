#ifndef GODOT_JVM_STRINGS_H
#define GODOT_JVM_STRINGS_H

constexpr const char* GRADLE_DIR = "kotlin_jvm/gradle/gradle_wrapper_dir";
constexpr const char* BUILD_BEFORE_START = "kotlin_jvm/editor/build_gradle_before_start";

constexpr const char* start_build = "Building JVM project...";

constexpr const char* VERSION_TEMPLATE = "GODOT_JVM_VERSION";
constexpr const char* PROJECT_NAME_TEMPLATE = "PROJECT_NAME";

constexpr const char* generate_project = "This will generate the files necessary to build a JVM project.\n"
                                         "This includes Gradle files, a new gitignore, and a basic Kotlin script.\n"
                                         "What do you want to do ?";

constexpr const char* generate_all = "Generate all files";
constexpr const char* generate_missing = "Only generate missing files";
constexpr const char* generate_nothing = "Don't generate anything";

constexpr const char* missing_gradle_project =
  "Gradle project can't be found. Make sure to create one before building.\n"
  "You can use Project/Tools/Kotlin/JVM/Generate JVM project in the Godot editor or use our Intellij plugin.";

#endif // GODOT_JVM_STRINGS_H
