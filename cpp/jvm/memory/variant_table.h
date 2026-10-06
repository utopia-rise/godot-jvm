#ifndef GODOT_JVM_VARIANT_TABLE_H
#define GODOT_JVM_VARIANT_TABLE_H

#include "core/variant_allocator.h"
#include "jvm/memory/variant_type.h"

#include <array>
#include <core/defs.hpp>
#include <cstdint>
#include <utility>
#include <variant/variant.hpp>

// REF_COUNTED_RETURN is a special case because Godot actually return a Ref and not a raw Refcounted
// so we have to make it its own separate type, which default to the max variant ordinal
constexpr godot::Variant::Type REF_COUNTED_RETURN = godot::Variant::VARIANT_MAX;

// Where a ptrcall argument of one Variant type sits: the stride from its slot to the next argument, and whether the
// slot holds the value itself or a pointer to it. A stride of zero marks a type that has no ptrcall form at all.
struct ArgFormat {
    static constexpr uint32_t INDIRECT = 1u << 31;

    uint32_t packed;

    _FORCE_INLINE_ bool is_ptrcallable() const { return packed != 0; }

    // INDIRECT is the sign bit, so the test is one compare against the packed word rather than a masked load.
    _FORCE_INLINE_ bool is_indirect() const { return static_cast<int32_t>(packed) < 0; }

    _FORCE_INLINE_ uint32_t stride() const { return packed & ~INDIRECT; }
};

static_assert(
    sizeof(ArgFormat) == 4,
    "An argument format is indexed by shifting, so its size must stay a power of two."
);

enum class ReturnInto : uint8_t {
    SLOT,
    OBJECT_RECORD,
    SMALL_ALLOCATION,
    LARGE_ALLOCATION,
    NOWHERE
};

struct ReturnFormat {
    uint32_t slot_size;
    ReturnInto into;
};

static_assert(
    sizeof(ReturnFormat) == 8,
    "A return format is indexed by shifting, so its size must stay a power of two."
);

// Frees the native instance the JVM owned at this address. Null for a type that owns none, which is what the sweep
// tests instead of carrying a case per type.
using Releaser = void (*)(uintptr_t);

template<godot::Variant::Type TYPE>
constexpr ArgFormat arg_format() {
    constexpr Shape SHAPE = Wire<TYPE>::SHAPE;
    if constexpr (SHAPE == Shape::POINTER) {
        return {sizeof(uint64_t) | ArgFormat::INDIRECT};
    } else if constexpr (SHAPE == Shape::CUSTOM) {
        return {0};
    } else {
        return {sizeof(typename Wire<TYPE>::Native)};
    }
}

template<godot::Variant::Type TYPE>
constexpr ReturnFormat return_format() {
    constexpr Shape SHAPE = Wire<TYPE>::SHAPE;
    if constexpr (SHAPE == Shape::INLINE) {
        return {sizeof(typename Wire<TYPE>::Native), ReturnInto::SLOT};
    } else if constexpr (SHAPE == Shape::POINTER) {
        constexpr size_t INSTANCE_SIZE = sizeof(typename Wire<TYPE>::Native);
        static_assert(
            INSTANCE_SIZE <= VariantAllocator::MAX_SLOT_SIZE,
            "A returned value must fit in a VariantAllocator slot."
        );
        return {
            sizeof(uint64_t),
            INSTANCE_SIZE <= VariantAllocator::SMALL_SLOT_SIZE ? ReturnInto::SMALL_ALLOCATION
                                                               : ReturnInto::LARGE_ALLOCATION
        };
    } else if constexpr (SHAPE == Shape::OBJECT) {
        return {OBJECT_RECORD_SIZE, ReturnInto::OBJECT_RECORD};
    } else {
        return {0, ReturnInto::NOWHERE};
    }
}

template<godot::Variant::Type TYPE>
void release_native(uintptr_t p_ptr) {
    VariantAllocator::free(reinterpret_cast<typename Wire<TYPE>::Native*>(p_ptr));
}

template<godot::Variant::Type TYPE>
constexpr Releaser releaser() {
    if constexpr (Wire<TYPE>::OWNS_NATIVE_INSTANCE) {
        return &release_native<TYPE>;
    } else {
        return nullptr;
    }
}

template<size_t... I>
constexpr auto make_arg_formats(std::index_sequence<I...>) {
    return std::array<ArgFormat, sizeof...(I)> {arg_format<static_cast<godot::Variant::Type>(I)>()...};
}

template<size_t... I>
constexpr auto make_return_formats(std::index_sequence<I...>) {
    return std::array<ReturnFormat, sizeof...(I) + 1> {
        return_format<static_cast<godot::Variant::Type>(I)>()...,
        ReturnFormat {OBJECT_RECORD_SIZE, ReturnInto::OBJECT_RECORD}
    };
}

template<size_t... I>
constexpr auto make_releasers(std::index_sequence<I...>) {
    return std::array<Releaser, sizeof...(I)> {releaser<static_cast<godot::Variant::Type>(I)>()...};
}

template<size_t... I>
constexpr auto make_decoders(std::index_sequence<I...>) {
    return std::array {&Wire<static_cast<godot::Variant::Type>(I)>::decode...};
}

template<size_t... I>
constexpr auto make_encoders(std::index_sequence<I...>) {
    return std::array {&Wire<static_cast<godot::Variant::Type>(I)>::encode...};
}

using VariantTypes = std::make_index_sequence<godot::Variant::VARIANT_MAX>;

inline constexpr auto ARG_FORMATS = make_arg_formats(VariantTypes());
inline constexpr auto RETURN_FORMATS = make_return_formats(VariantTypes());
inline constexpr auto DECODERS = make_decoders(VariantTypes());
inline constexpr auto ENCODERS = make_encoders(VariantTypes());
inline constexpr auto RELEASERS = make_releasers(VariantTypes());

#endif // GODOT_JVM_VARIANT_TABLE_H
