#include "packed_byte_array_bridge.h"

#include "bridges_utils.h"
#include "engine/godot_object.h"
#include "jvm/wrapper/memory/transfer_context.h"

using namespace bridges;

void PackedByteArrayBridge::engine_call_compress(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->compress(args[0].operator int64_t());
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_decode_double(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->decode_double(args[0].operator int64_t());
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_decode_float(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->decode_float(args[0].operator int64_t());
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_decode_half(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->decode_half(args[0].operator int64_t());
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_decode_s16(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->decode_s16(args[0].operator int64_t());
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_decode_s32(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->decode_s32(args[0].operator int64_t());
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_decode_s64(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->decode_s64(args[0].operator int64_t());
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_decode_s8(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->decode_s8(args[0].operator int64_t());
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_decode_u16(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->decode_u16(args[0].operator int64_t());
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_decode_u32(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->decode_u32(args[0].operator int64_t());
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_decode_u64(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->decode_u64(args[0].operator int64_t());
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_decode_u8(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[1] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->decode_u8(args[0].operator int64_t());
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_decode_var(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->decode_var(args[0].operator int64_t(), args[1].operator bool());
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_decode_var_size(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->decode_var_size(args[0].operator int64_t(), args[1].operator bool());
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_decompress(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->decompress(args[0].operator int64_t(), args[1].operator int64_t());
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_decompress_dynamic(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->decompress_dynamic(args[0].operator int64_t(), args[1].operator int64_t());
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_encode_double(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->encode_double(args[0].operator int64_t(), args[1].operator double());
}

void PackedByteArrayBridge::engine_call_encode_float(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->encode_float(args[0].operator int64_t(), args[1].operator double());
}

void PackedByteArrayBridge::engine_call_encode_half(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->encode_half(args[0].operator int64_t(), args[1].operator double());
}

void PackedByteArrayBridge::engine_call_encode_s16(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->encode_s16(args[0].operator int64_t(), args[1].operator int64_t());
}

void PackedByteArrayBridge::engine_call_encode_s32(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->encode_s32(args[0].operator int64_t(), args[1].operator int64_t());
}

void PackedByteArrayBridge::engine_call_encode_s64(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->encode_s64(args[0].operator int64_t(), args[1].operator int64_t());
}

void PackedByteArrayBridge::engine_call_encode_s8(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->encode_s8(args[0].operator int64_t(), args[1].operator int64_t());
}

void PackedByteArrayBridge::engine_call_encode_u16(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->encode_u16(args[0].operator int64_t(), args[1].operator int64_t());
}

void PackedByteArrayBridge::engine_call_encode_u32(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->encode_u32(args[0].operator int64_t(), args[1].operator int64_t());
}

void PackedByteArrayBridge::engine_call_encode_u64(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->encode_u64(args[0].operator int64_t(), args[1].operator int64_t());
}

void PackedByteArrayBridge::engine_call_encode_u8(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->encode_u8(args[0].operator int64_t(), args[1].operator int64_t());
}

void PackedByteArrayBridge::engine_call_encode_var(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[3] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->encode_var(args[0].operator int64_t(), args[1], args[2].operator bool());
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_get_string_from_ascii(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->get_string_from_ascii();
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_get_string_from_utf16(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->get_string_from_utf16();
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_get_string_from_utf32(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->get_string_from_utf32();
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_get_string_from_wchar(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->get_string_from_wchar();
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_get_string_from_utf8(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->get_string_from_utf8();
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_has_encoded_var(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant args[2] = {};
    TransferContext::get_instance().read_args(env, args);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->has_encoded_var(args[0].operator int64_t(), args[1].operator bool());
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_hex_encode(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->hex_encode();
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_to_float32_array(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->to_float32_array();
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_to_float64_array(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->to_float64_array();
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_to_int32_array(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->to_int32_array();
    TransferContext::get_instance().write_return_value(env, ret);
}

void PackedByteArrayBridge::engine_call_to_int64_array(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    jni::Env env(p_raw_env);
    godot::Variant ret = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr)->to_int64_array();
    TransferContext::get_instance().write_return_value(env, ret);
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

jbyteArray PackedByteArrayBridge::engine_convert_to_jvm(JNIEnv* p_raw_env, jobject, jlong p_raw_ptr) {
    godot::PackedByteArray* packed = from_uint_to_ptr<godot::PackedByteArray>(p_raw_ptr);
    auto size = static_cast<int>(packed->size());

    jni::Env env(p_raw_env);
    jni::JByteArray arr(env, size);
    arr.set_array_elements(env, reinterpret_cast<const jbyte*>(packed->ptr()), size);
    return reinterpret_cast<jbyteArray>(arr.get_wrapped());
}

PackedByteArrayBridge::~PackedByteArrayBridge() = default;
