#ifndef GODOT_JVM_KT_PROPERTY_H
#define GODOT_JVM_KT_PROPERTY_H

#include "jvm/jni/wrapper.h"
#include "jvm/wrapper/jvm_instance_wrapper.h"
#include "kt_object.h"

#include <classes/object.hpp>

JVM_INSTANCE_WRAPPER(KtPropertyInfo, "godot.registration.KtPropertyInfo") {
    JVM_CLASS(KtPropertyInfo)

    // clang-format off
    JNI_INT_METHOD(GET_TYPE)
    JNI_OBJECT_METHOD(GET_NAME)
    JNI_OBJECT_METHOD(GET_CLASS_NAME)
    JNI_INT_METHOD(GET_HINT)
    JNI_OBJECT_METHOD(GET_HINT_STRING)
    JNI_LONG_METHOD(GET_USAGE)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(GET_TYPE, "getType", "()I")
        INIT_JNI_METHOD(GET_NAME, "getName", "()Ljava/lang/String;")
        INIT_JNI_METHOD(GET_CLASS_NAME, "getClassName", "()Ljava/lang/String;")
        INIT_JNI_METHOD(GET_HINT, "getHint", "()I")
        INIT_JNI_METHOD(GET_HINT_STRING, "getHintString", "()Ljava/lang/String;")
        INIT_JNI_METHOD(GET_USAGE, "getUsage", "()J")
    )
    // clang-format on

public:
    explicit KtPropertyInfo(jni::Env & p_env, jni::JObject p_wrapped);
    ~KtPropertyInfo() = default;

    godot::Variant::Type type;
    godot::String name;
    godot::StringName class_name;
    godot::PropertyHint hint;
    godot::String hint_string;
    godot::PropertyUsageFlags usage;

    godot::PropertyInfo toPropertyInfo() const;
};

JVM_INSTANCE_WRAPPER(KtProperty, "godot.registration.KtProperty") {
    JVM_CLASS(KtProperty)

    // clang-format off
    JNI_OBJECT_METHOD(GET_KT_PROPERTY_INFO)
    JNI_VOID_METHOD(CALL_GET)
    JNI_VOID_METHOD(CALL_SET)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(GET_KT_PROPERTY_INFO, "getKtPropertyInfo", "()Lgodot/registration/KtPropertyInfo;")
        INIT_JNI_METHOD(CALL_GET, "callGet", "(Lgodot/core/KtObject;)V")
        INIT_JNI_METHOD(CALL_SET, "callSet", "(Lgodot/core/KtObject;)V")
    )
    // clang-format on

    KtPropertyInfo* propertyInfo;

public:
    explicit KtProperty(jni::Env & p_env, jni::JObject p_wrapped);
    ~KtProperty();

    godot::StringName get_name() const;

    bool is_property_list_marker() const;

    godot::PropertyInfo get_member_info();

    void call_get(jni::Env & p_env, KtObject * instance, godot::Variant & r_ret);
    void call_set(jni::Env & p_env, KtObject * instance, const godot::Variant& p_value);
};

#endif // GODOT_JVM_KT_PROPERTY_H
