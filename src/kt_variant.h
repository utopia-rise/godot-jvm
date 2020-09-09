#ifndef GODOT_JVM_KT_VARIANT_H
#define GODOT_JVM_KT_VARIANT_H
#include "wire/wire.pb.h"
#include "core/variant.h"
#include "jni/wrapper.h"
#include "java_instance_wrapper.h"

class KtVariant {
private:
    wire::Value value;

public:
    KtVariant() = default;
    KtVariant(wire::Value value);
    KtVariant(const Variant& variant);
    ~KtVariant() = default;

    static void initMethodArray();
    static Variant::Type fromWireTypeToVariantType(wire::Value::TypeCase typeCase);
    static String fromVariantTypeToJvmString(Variant::Type type);

    const wire::Value& get_value() const;
    Variant to_godot_variant() const;
};


#endif //GODOT_JVM_KT_VARIANT_H
