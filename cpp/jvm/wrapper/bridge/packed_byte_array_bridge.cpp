#include "packed_byte_array_bridge.h"

#include "bridges_utils.h"
#include "core/variant_allocator.h"
#include "engine/godot_object.h"
#include "jvm/wrapper/memory/transfer_context.h"

using namespace bridges;

void PackedByteArrayBridge::engine_call_compress(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t compression_mode;
    TransferContext::read_values(env, compression_mode);
    godot::PackedByteArray compressed = native<godot::PackedByteArray>(p_handle).compress(compression_mode);
    TransferContext::write_value(env, compressed);
}

void PackedByteArrayBridge::engine_call_decode_double(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    TransferContext::read_values(env, byte_offset);
    double value = native<godot::PackedByteArray>(p_handle).decode_double(byte_offset);
    TransferContext::write_value(env, value);
}

void PackedByteArrayBridge::engine_call_decode_float(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    TransferContext::read_values(env, byte_offset);
    double value = native<godot::PackedByteArray>(p_handle).decode_float(byte_offset);
    TransferContext::write_value(env, value);
}

void PackedByteArrayBridge::engine_call_decode_half(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    TransferContext::read_values(env, byte_offset);
    double value = native<godot::PackedByteArray>(p_handle).decode_half(byte_offset);
    TransferContext::write_value(env, value);
}

void PackedByteArrayBridge::engine_call_decode_s16(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    TransferContext::read_values(env, byte_offset);
    int64_t value = native<godot::PackedByteArray>(p_handle).decode_s16(byte_offset);
    TransferContext::write_value(env, value);
}

void PackedByteArrayBridge::engine_call_decode_s32(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    TransferContext::read_values(env, byte_offset);
    int64_t value = native<godot::PackedByteArray>(p_handle).decode_s32(byte_offset);
    TransferContext::write_value(env, value);
}

void PackedByteArrayBridge::engine_call_decode_s64(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    TransferContext::read_values(env, byte_offset);
    int64_t value = native<godot::PackedByteArray>(p_handle).decode_s64(byte_offset);
    TransferContext::write_value(env, value);
}

void PackedByteArrayBridge::engine_call_decode_s8(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    TransferContext::read_values(env, byte_offset);
    int64_t value = native<godot::PackedByteArray>(p_handle).decode_s8(byte_offset);
    TransferContext::write_value(env, value);
}

void PackedByteArrayBridge::engine_call_decode_u16(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    TransferContext::read_values(env, byte_offset);
    int64_t value = native<godot::PackedByteArray>(p_handle).decode_u16(byte_offset);
    TransferContext::write_value(env, value);
}

void PackedByteArrayBridge::engine_call_decode_u32(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    TransferContext::read_values(env, byte_offset);
    int64_t value = native<godot::PackedByteArray>(p_handle).decode_u32(byte_offset);
    TransferContext::write_value(env, value);
}

void PackedByteArrayBridge::engine_call_decode_u64(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    TransferContext::read_values(env, byte_offset);
    int64_t value = native<godot::PackedByteArray>(p_handle).decode_u64(byte_offset);
    TransferContext::write_value(env, value);
}

void PackedByteArrayBridge::engine_call_decode_u8(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    TransferContext::read_values(env, byte_offset);
    int64_t value = native<godot::PackedByteArray>(p_handle).decode_u8(byte_offset);
    TransferContext::write_value(env, value);
}

void PackedByteArrayBridge::engine_call_decode_var(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    bool allow_objects;
    TransferContext::read_values(env, byte_offset, allow_objects);
    godot::Variant value = native<godot::PackedByteArray>(p_handle).decode_var(byte_offset, allow_objects);
    TransferContext::write_value(env, value);
}

void PackedByteArrayBridge::engine_call_decode_var_size(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    bool allow_objects;
    TransferContext::read_values(env, byte_offset, allow_objects);
    int64_t size = native<godot::PackedByteArray>(p_handle).decode_var_size(byte_offset, allow_objects);
    TransferContext::write_value(env, size);
}

void PackedByteArrayBridge::engine_call_decompress(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t buffer_size;
    int64_t compression_mode;
    TransferContext::read_values(env, buffer_size, compression_mode);
    godot::PackedByteArray decompressed =
        native<godot::PackedByteArray>(p_handle).decompress(buffer_size, compression_mode);
    TransferContext::write_value(env, decompressed);
}

void PackedByteArrayBridge::engine_call_decompress_dynamic(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t max_output_size;
    int64_t compression_mode;
    TransferContext::read_values(env, max_output_size, compression_mode);
    godot::PackedByteArray decompressed =
        native<godot::PackedByteArray>(p_handle).decompress_dynamic(max_output_size, compression_mode);
    TransferContext::write_value(env, decompressed);
}

void PackedByteArrayBridge::engine_call_encode_double(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    double value;
    TransferContext::read_values(env, byte_offset, value);
    native<godot::PackedByteArray>(p_handle).encode_double(byte_offset, value);
}

void PackedByteArrayBridge::engine_call_encode_float(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    double value;
    TransferContext::read_values(env, byte_offset, value);
    native<godot::PackedByteArray>(p_handle).encode_float(byte_offset, value);
}

void PackedByteArrayBridge::engine_call_encode_half(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    double value;
    TransferContext::read_values(env, byte_offset, value);
    native<godot::PackedByteArray>(p_handle).encode_half(byte_offset, value);
}

void PackedByteArrayBridge::engine_call_encode_s16(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    int64_t value;
    TransferContext::read_values(env, byte_offset, value);
    native<godot::PackedByteArray>(p_handle).encode_s16(byte_offset, value);
}

void PackedByteArrayBridge::engine_call_encode_s32(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    int64_t value;
    TransferContext::read_values(env, byte_offset, value);
    native<godot::PackedByteArray>(p_handle).encode_s32(byte_offset, value);
}

void PackedByteArrayBridge::engine_call_encode_s64(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    int64_t value;
    TransferContext::read_values(env, byte_offset, value);
    native<godot::PackedByteArray>(p_handle).encode_s64(byte_offset, value);
}

void PackedByteArrayBridge::engine_call_encode_s8(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    int64_t value;
    TransferContext::read_values(env, byte_offset, value);
    native<godot::PackedByteArray>(p_handle).encode_s8(byte_offset, value);
}

void PackedByteArrayBridge::engine_call_encode_u16(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    int64_t value;
    TransferContext::read_values(env, byte_offset, value);
    native<godot::PackedByteArray>(p_handle).encode_u16(byte_offset, value);
}

void PackedByteArrayBridge::engine_call_encode_u32(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    int64_t value;
    TransferContext::read_values(env, byte_offset, value);
    native<godot::PackedByteArray>(p_handle).encode_u32(byte_offset, value);
}

void PackedByteArrayBridge::engine_call_encode_u64(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    int64_t value;
    TransferContext::read_values(env, byte_offset, value);
    native<godot::PackedByteArray>(p_handle).encode_u64(byte_offset, value);
}

void PackedByteArrayBridge::engine_call_encode_u8(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    int64_t value;
    TransferContext::read_values(env, byte_offset, value);
    native<godot::PackedByteArray>(p_handle).encode_u8(byte_offset, value);
}

void PackedByteArrayBridge::engine_call_encode_var(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    godot::Variant value;
    bool allow_objects;
    TransferContext::read_values(env, byte_offset, value, allow_objects);
    int64_t size = native<godot::PackedByteArray>(p_handle).encode_var(byte_offset, value, allow_objects);
    TransferContext::write_value(env, size);
}

void PackedByteArrayBridge::engine_call_get_string_from_ascii(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::String string = native<godot::PackedByteArray>(p_handle).get_string_from_ascii();
    TransferContext::write_value(env, string);
}

void PackedByteArrayBridge::engine_call_get_string_from_utf16(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::String string = native<godot::PackedByteArray>(p_handle).get_string_from_utf16();
    TransferContext::write_value(env, string);
}

void PackedByteArrayBridge::engine_call_get_string_from_utf32(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::String string = native<godot::PackedByteArray>(p_handle).get_string_from_utf32();
    TransferContext::write_value(env, string);
}

void PackedByteArrayBridge::engine_call_get_string_from_wchar(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::String string = native<godot::PackedByteArray>(p_handle).get_string_from_wchar();
    TransferContext::write_value(env, string);
}

void PackedByteArrayBridge::engine_call_get_string_from_utf8(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::String string = native<godot::PackedByteArray>(p_handle).get_string_from_utf8();
    TransferContext::write_value(env, string);
}

void PackedByteArrayBridge::engine_call_has_encoded_var(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    int64_t byte_offset;
    bool allow_objects;
    TransferContext::read_values(env, byte_offset, allow_objects);
    bool found = native<godot::PackedByteArray>(p_handle).has_encoded_var(byte_offset, allow_objects);
    TransferContext::write_value(env, found);
}

void PackedByteArrayBridge::engine_call_hex_encode(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::String hex = native<godot::PackedByteArray>(p_handle).hex_encode();
    TransferContext::write_value(env, hex);
}

void PackedByteArrayBridge::engine_call_to_float32_array(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::PackedFloat32Array converted = native<godot::PackedByteArray>(p_handle).to_float32_array();
    TransferContext::write_value(env, converted);
}

void PackedByteArrayBridge::engine_call_to_float64_array(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::PackedFloat64Array converted = native<godot::PackedByteArray>(p_handle).to_float64_array();
    TransferContext::write_value(env, converted);
}

void PackedByteArrayBridge::engine_call_to_int32_array(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::PackedInt32Array converted = native<godot::PackedByteArray>(p_handle).to_int32_array();
    TransferContext::write_value(env, converted);
}

void PackedByteArrayBridge::engine_call_to_int64_array(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    jni::Env env(p_raw_env);
    godot::PackedInt64Array converted = native<godot::PackedByteArray>(p_handle).to_int64_array();
    TransferContext::write_value(env, converted);
}

uintptr_t PackedByteArrayBridge::engine_convert_to_godot(JNIEnv* p_raw_env, jobject, jbyteArray p_array) {
    jni::Env env(p_raw_env);
    jni::JByteArray arr(p_array);

    jint size = arr.length(env);

    godot::PackedByteArray vec;
    vec.resize(size);
    arr.get_array_elements(env, reinterpret_cast<jbyte*>(vec.ptrw()), size);

    return reinterpret_cast<uintptr_t>(VariantAllocator::alloc(godot::PackedByteArray(vec)));
}

jbyteArray PackedByteArrayBridge::engine_convert_to_jvm(JNIEnv* p_raw_env, jobject, jlong p_handle) {
    godot::PackedByteArray& packed = native<godot::PackedByteArray>(p_handle);
    auto size = static_cast<int>(packed.size());

    jni::Env env(p_raw_env);
    jni::JByteArray arr(env, size);
    arr.set_array_elements(env, reinterpret_cast<const jbyte*>(packed.ptr()), size);
    return reinterpret_cast<jbyteArray>(arr.get_wrapped());
}

PackedByteArrayBridge::~PackedByteArrayBridge() = default;
