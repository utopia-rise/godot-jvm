cmake_minimum_required(VERSION 3.13)
project(godot_jvm)

set(CMAKE_CXX_STANDARD 14)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

set(GODOT_ROOT_DIR ../../)

# Get sources
file(GLOB_RECURSE SOURCES CONFIGURE_DEPENDS src/*.cpp)

add_library(${PROJECT_NAME} SHARED register_types.cpp ${SOURCES} src/gd_kotlin.cpp src/gd_kotlin.h src/godotkotlin_defs.h src/jni/wrapper.h src/kt_function.cpp src/kt_function.h src/kt_property.cpp src/kt_property.h src/jni/local_frame.cpp src/jni/local_frame.h src/kt_signal_info.cpp src/kt_signal_info.h src/bridges/memory_bridge.cpp src/bridges/memory_bridge.h src/jni/java_method_signature.cpp src/jni/java_method_signature.h src/java_instance_wrapper.h src/shared_buffer.h src/shared_buffer.cpp src/type_manager.cpp src/type_manager.h src/bridges_manager.cpp src/bridges_manager.h src/bridges/variant_array_bridge.cpp src/bridges/variant_array_bridge.h src/bridges/constants.h src/bridges/dictionary_bridge.cpp src/bridges/dictionary_bridge.h src/bridges/bridges_utils.h src/bridges/rid_bridge.cpp src/bridges/rid_bridge.h src/bridges/node_path_bridge.cpp src/bridges/node_path_bridge.h src/bridges/pool_byte_array_bridge.h src/bridges/pool_byte_array_bridge.cpp src/bridges/pool_color_array_bridge.h src/bridges/pool_color_array_bridge.cpp src/bridges/pool_int_array_bridge.h src/bridges/pool_int_array_bridge.cpp src/bridges/pool_real_array_bridge.h src/bridges/pool_real_array_bridge.cpp src/bridges/pool_string_array_bridge.h src/bridges/pool_string_array_bridge.cpp src/bridges/pool_vector2_array_bridge.h src/bridges/pool_vector2_array_bridge.cpp src/bridges/pool_vector3_array_bridge.h src/bridges/pool_vector3_array_bridge.cpp)

# JNI
find_package(JNI REQUIRED)
target_include_directories(${PROJECT_NAME} PUBLIC ${JNI_INCLUDE_DIRS})

target_include_directories(${PROJECT_NAME}
        PUBLIC ${GODOT_ROOT_DIR}
)

# Uncomment to pass auto completion in TOOLS mode
add_compile_definitions(TOOLS_ENABLED)