#ifndef GODOT_JVM_KT_VARIANT_H
#define GODOT_JVM_KT_VARIANT_H
#include "wire/wire.pb.h"
#include "core/variant.h"

// must match the value order of godot_variant_type
static void(*TO_KT_VARIANT_FROM[27 /* Variant::Type count */])(wire::Value&, const Variant&);
static Variant(*TO_GODOT_VARIANT_FROM[27 /* KVariant::TypeCase count */])(const wire::Value&);

class KtVariant {
private:
    wire::Value value;

public:
    KtVariant() = default;
    KtVariant(wire::Value value);
    KtVariant(const Variant& variant);
    ~KtVariant() = default;

    static void initMethodArray();
    const wire::Value& get_value() const;
    Variant to_godot_variant() const;
};


#endif //GODOT_JVM_KT_VARIANT_H
