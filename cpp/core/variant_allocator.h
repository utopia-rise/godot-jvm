#ifndef GODOT_JVM_VARIANT_ALLOCATOR_H
#define GODOT_JVM_VARIANT_ALLOCATOR_H

#include "engine/paged_allocator.h"

#include <variant/variant.hpp>

class VariantAllocator {
    union BucketSmall {
        BucketSmall() {}

        ~BucketSmall() {}

        godot::StringName string_name;
        godot::NodePath node_path;
        godot::Array array;
        godot::Dictionary dictionary;
    };

    union BucketLarge {
        BucketLarge() {}

        ~BucketLarge() {}

        godot::Callable callable;
        godot::PackedByteArray byte_array;
        godot::PackedColorArray color_array;
        godot::PackedInt32Array int32_array;
        godot::PackedInt64Array int64_array;
        godot::PackedFloat32Array float_array;
        godot::PackedFloat64Array double_array;
        godot::PackedVector2Array vector2_array;
        godot::PackedVector3Array vector3_array;
        godot::PackedVector4Array vector4_array;
        godot::PackedStringArray string_array;
    };

    static_assert(sizeof(BucketSmall) <= 8, "BucketSmall should have at most a size of 8 bytes");
    static_assert(sizeof(BucketLarge) <= 16, "BucketLarge should have at most a size of 16 bytes");
    static_assert(sizeof(BucketSmall) < sizeof(BucketLarge), "BucketLarge should be larger than BucketSmall");

    inline static godot::PagedAllocator<BucketSmall, true> bucket_small;
    inline static godot::PagedAllocator<BucketLarge, true> bucket_large;

public:
    static void configure() {
        bucket_small.configure(4096);
        bucket_large.configure(4096);
    }

    template<typename T>
    static T* alloc(T&& variant) {
        static_assert(sizeof(T) <= sizeof(BucketLarge), "Variant doesn't fit inside the VariantAllocator");

        T* ret;
        if constexpr (sizeof(T) <= sizeof(BucketSmall)) {
            ret = reinterpret_cast<T*>(bucket_small.alloc());
        } else {
            ret = reinterpret_cast<T*>(bucket_large.alloc());
        }
        memnew_placement(ret, T(variant));
        return ret;
    }

    template<typename T>
    static void free(T* variant) {
        static_assert(sizeof(T) <= sizeof(BucketLarge), "Variant doesn't fit inside the VariantAllocator");

        variant->~T();
        if constexpr (sizeof(T) <= sizeof(BucketSmall)) {
            bucket_small.free(reinterpret_cast<BucketSmall*>(variant));
        } else {
            bucket_large.free(reinterpret_cast<BucketLarge*>(variant));
        }
    }
};

#endif // GODOT_JVM_VARIANT_ALLOCATOR_H
