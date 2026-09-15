#ifndef GODOT_JVM_PTR_CONVERTER_H
#define GODOT_JVM_PTR_CONVERTER_H

#include "engine/marshalls.h"
#include "logging.h"
#include "shared_buffer.h"

#include <cstring>
#include <variant/variant.hpp>

// The ptrcall counterpart of BufferToVariant. A ptrcall takes a pointer to each argument's native value, and the
// buffer already holds such values for two kinds of types: the ones the JVM writes inline with the engine's own
// layout, and the native core types it sends as a pointer to an object it owns. A bool is the one inline value whose
// wire size differs from the engine's, so it is converted while being copied. Every other type (String, Callable,
// Signal, Variant) stays on the Variant call; the generator only emits a ptrcall for methods whose arguments and
// return are all in this table.
//
// Nothing handed to the engine points into the buffer. An engine call can re-enter the JVM (a signal or callable
// fired along the way), and that nested call rewrites the same thread-local buffer, so inline values are copied
// into the caller's own stack storage first and the return value travels through a local as well.
class BufferToPtr {
    enum Kind : uint8_t {
        UNSUPPORTED,
        INLINE,
        BOOL, // 4 bytes on the wire, sizeof(bool) for the engine
        POINTER
    };

    struct Layout {
        Kind kind;
        uint32_t size;
    };

    // Indexed by Variant::Type.
    static constexpr Layout LAYOUTS[godot::Variant::VARIANT_MAX] = {
        {UNSUPPORTED, 0}, // NIL
        {BOOL, 4},
        {INLINE, 8},     // INT
        {INLINE, 8},     // FLOAT
        {UNSUPPORTED, 0}, // STRING
        {INLINE, sizeof(godot::Vector2)},
        {INLINE, sizeof(godot::Vector2i)},
        {INLINE, sizeof(godot::Rect2)},
        {INLINE, sizeof(godot::Rect2i)},
        {INLINE, sizeof(godot::Vector3)},
        {INLINE, sizeof(godot::Vector3i)},
        {INLINE, sizeof(godot::Transform2D)},
        {INLINE, sizeof(godot::Vector4)},
        {INLINE, sizeof(godot::Vector4i)},
        {INLINE, sizeof(godot::Plane)},
        {INLINE, sizeof(godot::Quaternion)},
        {INLINE, sizeof(godot::AABB)},
        {INLINE, sizeof(godot::Basis)},
        {INLINE, sizeof(godot::Transform3D)},
        {INLINE, sizeof(godot::Projection)},
        {INLINE, sizeof(godot::Color)},
        {POINTER, 0}, // STRING_NAME
        {POINTER, 0}, // NODE_PATH
        {INLINE, sizeof(godot::RID)},
        {INLINE, 8},     // OBJECT: the engine wants a pointer to the object pointer, which is the buffer slot itself
        {UNSUPPORTED, 0}, // CALLABLE
        {UNSUPPORTED, 0}, // SIGNAL
        {POINTER, 0},     // DICTIONARY
        {POINTER, 0},     // ARRAY
        {POINTER, 0},     // PACKED_BYTE_ARRAY
        {POINTER, 0},     // PACKED_INT32_ARRAY
        {POINTER, 0},     // PACKED_INT64_ARRAY
        {POINTER, 0},     // PACKED_FLOAT32_ARRAY
        {POINTER, 0},     // PACKED_FLOAT64_ARRAY
        {POINTER, 0},     // PACKED_STRING_ARRAY
        {POINTER, 0},     // PACKED_VECTOR2_ARRAY
        {POINTER, 0},     // PACKED_VECTOR3_ARRAY
        {POINTER, 0},     // PACKED_COLOR_ARRAY
        {POINTER, 0},     // PACKED_VECTOR4_ARRAY
    };

public:
    // Storage for one inline value, sized for the largest of them.
    struct InlineValue {
        alignas(8) uint8_t bytes[sizeof(godot::Projection)];
    };

    static void read_args(SharedBuffer* p_buffer, uint32_t p_args_size, const void** r_args, InlineValue* r_storage) {
        for (uint32_t i = 0; i < p_args_size; ++i) {
            uint32_t type = godot::decode_uint32(p_buffer->get_cursor());
            p_buffer->increment_position(4);
            JVM_DEV_ASSERT(type < godot::Variant::VARIANT_MAX, "Argument %s has an invalid type tag %s.", i, type);
            const Layout& layout = LAYOUTS[type];
            JVM_DEV_ASSERT(layout.kind != UNSUPPORTED, "Argument %s cannot be passed to a ptrcall.", i);
            if (layout.kind == INLINE) {
                memcpy(r_storage[i].bytes, p_buffer->get_cursor(), layout.size);
                r_args[i] = r_storage[i].bytes;
                p_buffer->increment_position(layout.size);
            } else if (layout.kind == BOOL) {
                *reinterpret_cast<bool*>(r_storage[i].bytes) = godot::decode_uint32(p_buffer->get_cursor()) != 0;
                r_args[i] = r_storage[i].bytes;
                p_buffer->increment_position(layout.size);
            } else {
                r_args[i] = reinterpret_cast<const void*>(
                    static_cast<uintptr_t>(godot::decode_uint64(p_buffer->get_cursor()))
                );
                p_buffer->increment_position(8);
            }
        }
    }

    static void write_inline_return(SharedBuffer* p_buffer, godot::Variant::Type p_type, const InlineValue& p_value) {
        const Layout& layout = LAYOUTS[p_type];
        JVM_DEV_ASSERT(layout.kind == INLINE || layout.kind == BOOL, "Return type %s is not an inline value.", p_type);
        p_buffer->increment_position(godot::encode_uint32(p_type, p_buffer->get_cursor()));
        if (layout.kind == BOOL) {
            p_buffer->increment_position(
                godot::encode_uint32(*reinterpret_cast<const bool*>(p_value.bytes), p_buffer->get_cursor())
            );
        } else {
            memcpy(p_buffer->get_cursor(), p_value.bytes, layout.size);
            p_buffer->increment_position(layout.size);
        }
    }
};

#endif // GODOT_JVM_PTR_CONVERTER_H
