#ifndef GODOT_JVM_VARIANT_ALLOCATOR_H
#define GODOT_JVM_VARIANT_ALLOCATOR_H

#include "engine/paged_allocator.h"

#include <cstring>
#include <templates/local_vector.hpp>
#include <utility>
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

    // Slots whose value is destroyed, waiting for flush() to hand them back. Kept between sweeps so that a sweep
    // costs no allocation once it has run once.
    inline static godot::LocalVector<BucketSmall*> destroyed_small;
    inline static godot::LocalVector<BucketLarge*> destroyed_large;

public:
    static void configure() {
        bucket_small.configure(4096);
        bucket_large.configure(4096);
    }

    static constexpr size_t SMALL_SLOT_SIZE = sizeof(BucketSmall);
    static constexpr size_t MAX_SLOT_SIZE = sizeof(BucketLarge);

    // An empty slot for the engine to assign a returned value into, zeroed rather than constructed: every type held
    // here is a handle on shared data whose assignment releases whatever the slot held first, and reads a null handle
    // as holding nothing, while default construction would allocate that data only for the assignment to drop it.
    // One entry point per bucket rather than one taking a size, so that the caller picks the bucket from what it
    // already knows about the type and neither the choice nor the zeroing costs a runtime test here.
    static void* alloc_small_slot() {
        void* ret = bucket_small.alloc();
        memset(ret, 0, sizeof(BucketSmall));
        return ret;
    }

    static void* alloc_large_slot() {
        void* ret = bucket_large.alloc();
        memset(ret, 0, sizeof(BucketLarge));
        return ret;
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
        memnew_placement(ret, T(std::move(variant)));
        return ret;
    }

    // Destroys a value now and keeps its slot until flush(), which every caller must reach: values are freed a
    // frame's worth at a time by MemoryManager::sync_memory, and this split is what lets a sweep lock the pools once
    // instead of once per value.
    //
    // The destructor is the half that must stay out of the critical section. A ~T() of a shared-data type calls into
    // the engine to drop a reference and, at zero, releases the value's backing storage, which for a Dictionary or an
    // Array cascades through everything it held -- an unbounded amount of work to hold a spin lock across, and a spin
    // lock makes every other thread burn CPU while it waits. Handing the slot back is two stores and no calls, which
    // is what such a lock is for.
    //
    // Deliberately not thread safe: every caller reaches this through MemoryManager::sync_memory, which runs on the
    // thread driving the frame and says so.
    template<typename T>
    static void free(T* variant) {
        static_assert(sizeof(T) <= sizeof(BucketLarge), "Variant doesn't fit inside the VariantAllocator");

        variant->~T();
        if constexpr (sizeof(T) <= sizeof(BucketSmall)) {
            destroyed_small.push_back(reinterpret_cast<BucketSmall*>(variant));
        } else {
            destroyed_large.push_back(reinterpret_cast<BucketLarge*>(variant));
        }
    }

    static void flush() {
        bucket_small.release_slots(destroyed_small.ptr(), destroyed_small.size());
        bucket_large.release_slots(destroyed_large.ptr(), destroyed_large.size());
        destroyed_small.clear();
        destroyed_large.clear();
    }
};

#endif // GODOT_JVM_VARIANT_ALLOCATOR_H
