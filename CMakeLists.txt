cmake_minimum_required(VERSION 3.13)
project(godot_jvm)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)


# Uncomment to pass auto completion in TOOLS mode
#add_compile_definitions(MONO_GLUE_ENABLED)
add_compile_definitions(TOOLS_ENABLED)
add_compile_definitions(DEBUG_ENABLED)
add_compile_definitions(DEV_ENABLED)

# platforms
#add_compile_definitions(WINDOWS_ENABLED)
add_compile_definitions(LINUX_ENABLED)
#add_compile_definitions(MACOS_ENABLED)
#add_compile_definitions(IOS_ENABLED)
#add_compile_definitions(ANDROID_ENABLED)


# Project
file(GLOB_RECURSE SOURCES cpp/*.c**)
file(GLOB_RECURSE HEADERS cpp/*.h**)

add_library(${PROJECT_NAME} SHARED ${SOURCES} ${HEADERS})

include_directories(cpp)
include_directories(
        SYSTEM
        godot-cpp/include
        godot-cpp/include/godot_cpp
        godot-cpp/gen/include
        godot-cpp/gen/include/godot_cpp
        godot-cpp/gdextension
)

find_package(JNI REQUIRED)
include_directories(
        SYSTEM
        ${JNI_INCLUDE_DIRS}
)

