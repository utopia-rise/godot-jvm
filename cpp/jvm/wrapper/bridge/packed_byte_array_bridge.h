#ifndef GODOT_JVM_PACKED_BYTE_ARRAY_BRIDGE_H
#define GODOT_JVM_PACKED_BYTE_ARRAY_BRIDGE_H

#include "packed_array_bridge.h"

namespace bridges {

    PACKED_ARRAY_BRIDGE(PackedByteArrayBridge, uint8_t, "godot.core.PackedByteArray$Bridge") {
        PACKED_ARRAY_BRIDGE_CLASS(PackedByteArrayBridge, uint8_t)

        // clang-format off
        INIT_JNI_BINDINGS(
            PackedArrayBridge<PackedByteArrayBridge, uint8_t, PackedByteArrayBridgeQualifiedName>::initialize_jni_binding(p_env, class_loader);

            INIT_NATIVE_METHOD("engine_call_compress", "(J)V", PackedByteArrayBridge::engine_call_compress)
            INIT_NATIVE_METHOD("engine_call_decode_double", "(J)V", PackedByteArrayBridge::engine_call_decode_double)
            INIT_NATIVE_METHOD("engine_call_decode_float", "(J)V", PackedByteArrayBridge::engine_call_decode_float)
            INIT_NATIVE_METHOD("engine_call_decode_half", "(J)V", PackedByteArrayBridge::engine_call_decode_half)
            INIT_NATIVE_METHOD("engine_call_decode_s16", "(J)V", PackedByteArrayBridge::engine_call_decode_s16)
            INIT_NATIVE_METHOD("engine_call_decode_s32", "(J)V", PackedByteArrayBridge::engine_call_decode_s32)
            INIT_NATIVE_METHOD("engine_call_decode_s64", "(J)V", PackedByteArrayBridge::engine_call_decode_s64)
            INIT_NATIVE_METHOD("engine_call_decode_s8", "(J)V", PackedByteArrayBridge::engine_call_decode_s8)
            INIT_NATIVE_METHOD("engine_call_decode_u16", "(J)V", PackedByteArrayBridge::engine_call_decode_u16)
            INIT_NATIVE_METHOD("engine_call_decode_u32", "(J)V", PackedByteArrayBridge::engine_call_decode_u32)
            INIT_NATIVE_METHOD("engine_call_decode_u64", "(J)V", PackedByteArrayBridge::engine_call_decode_u64)
            INIT_NATIVE_METHOD("engine_call_decode_u8", "(J)V", PackedByteArrayBridge::engine_call_decode_u8)
            INIT_NATIVE_METHOD("engine_call_decode_var", "(J)V", PackedByteArrayBridge::engine_call_decode_var)
            INIT_NATIVE_METHOD("engine_call_decode_var_size", "(J)V", PackedByteArrayBridge::engine_call_decode_var_size)
            INIT_NATIVE_METHOD("engine_call_decompress", "(J)V", PackedByteArrayBridge::engine_call_decompress)
            INIT_NATIVE_METHOD("engine_call_decompress_dynamic", "(J)V", PackedByteArrayBridge::engine_call_decompress_dynamic)
            INIT_NATIVE_METHOD("engine_call_encode_double", "(J)V", PackedByteArrayBridge::engine_call_encode_double)
            INIT_NATIVE_METHOD("engine_call_encode_float", "(J)V", PackedByteArrayBridge::engine_call_encode_float)
            INIT_NATIVE_METHOD("engine_call_encode_half", "(J)V", PackedByteArrayBridge::engine_call_encode_half)
            INIT_NATIVE_METHOD("engine_call_encode_s16", "(J)V", PackedByteArrayBridge::engine_call_encode_s16)
            INIT_NATIVE_METHOD("engine_call_encode_s32", "(J)V", PackedByteArrayBridge::engine_call_encode_s32)
            INIT_NATIVE_METHOD("engine_call_encode_s64", "(J)V", PackedByteArrayBridge::engine_call_encode_s64)
            INIT_NATIVE_METHOD("engine_call_encode_s8", "(J)V", PackedByteArrayBridge::engine_call_encode_s8)
            INIT_NATIVE_METHOD("engine_call_encode_u16", "(J)V", PackedByteArrayBridge::engine_call_encode_u16)
            INIT_NATIVE_METHOD("engine_call_encode_u32", "(J)V", PackedByteArrayBridge::engine_call_encode_u32)
            INIT_NATIVE_METHOD("engine_call_encode_u64", "(J)V", PackedByteArrayBridge::engine_call_encode_u64)
            INIT_NATIVE_METHOD("engine_call_encode_u8", "(J)V", PackedByteArrayBridge::engine_call_encode_u8)
            INIT_NATIVE_METHOD("engine_call_encode_var", "(J)V", PackedByteArrayBridge::engine_call_encode_var)
            INIT_NATIVE_METHOD("engine_call_get_string_from_ascii", "(J)V", PackedByteArrayBridge::engine_call_get_string_from_ascii)
            INIT_NATIVE_METHOD("engine_call_get_string_from_utf16", "(J)V", PackedByteArrayBridge::engine_call_get_string_from_utf16)
            INIT_NATIVE_METHOD("engine_call_get_string_from_utf32", "(J)V", PackedByteArrayBridge::engine_call_get_string_from_utf32)
            INIT_NATIVE_METHOD("engine_call_get_string_from_wchar", "(J)V", PackedByteArrayBridge::engine_call_get_string_from_wchar)
            INIT_NATIVE_METHOD("engine_call_get_string_from_utf8", "(J)V", PackedByteArrayBridge::engine_call_get_string_from_utf8)
            INIT_NATIVE_METHOD("engine_call_has_encoded_var", "(J)V", PackedByteArrayBridge::engine_call_has_encoded_var)
            INIT_NATIVE_METHOD("engine_call_hex_encode", "(J)V", PackedByteArrayBridge::engine_call_hex_encode)
            INIT_NATIVE_METHOD("engine_call_rfind", "(J)V", PackedByteArrayBridge::engine_call_rfind)
            INIT_NATIVE_METHOD("engine_call_to_float32_array", "(J)V", PackedByteArrayBridge::engine_call_to_float32_array)
            INIT_NATIVE_METHOD("engine_call_to_float64_array", "(J)V", PackedByteArrayBridge::engine_call_to_float64_array)
            INIT_NATIVE_METHOD("engine_call_to_int32_array", "(J)V", PackedByteArrayBridge::engine_call_to_int32_array)
            INIT_NATIVE_METHOD("engine_call_to_int64_array", "(J)V", PackedByteArrayBridge::engine_call_to_int64_array)

            INIT_NATIVE_METHOD("engine_convert_to_godot", "([B)J", PackedByteArrayBridge::engine_convert_to_godot)
            INIT_NATIVE_METHOD("engine_convert_to_jvm", "(J)[B", PackedByteArrayBridge::engine_convert_to_jvm)
        )
        // clang-format on

    public:
        static void engine_call_compress(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_decode_double(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_decode_float(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_decode_half(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_decode_s16(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_decode_s32(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_decode_s64(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_decode_s8(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_decode_u16(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_decode_u32(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_decode_u64(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_decode_u8(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);

        static void engine_call_decode_var(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_decode_var_size(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_decompress(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);

        static void engine_call_decompress_dynamic(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_encode_double(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_encode_float(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_encode_half(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_encode_s16(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_encode_s32(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_encode_s64(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_encode_s8(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_encode_u16(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_encode_u32(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_encode_u64(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_encode_u8(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);

        static void engine_call_encode_var(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_get_string_from_utf16(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);

        static void engine_call_get_string_from_utf32(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_get_string_from_wchar(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_get_string_from_ascii(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_get_string_from_utf8(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_has_encoded_var(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_hex_encode(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);

        static void engine_call_to_float32_array(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_to_float64_array(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_to_int32_array(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
        static void engine_call_to_int64_array(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);

        static uintptr_t engine_convert_to_godot(JNIEnv * p_raw_env, jobject p_instance, jbyteArray p_array);
        static jbyteArray engine_convert_to_jvm(JNIEnv * p_raw_env, jobject p_instance, jlong p_raw_ptr);
    };

} // namespace bridges

#endif
