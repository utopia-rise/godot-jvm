#ifndef GODOT_JVM_INTERNAL_H
#define GODOT_JVM_INTERNAL_H

#include <gdextension_interface.h>

#include <core/object.hpp>
#include <templates/a_hash_map.hpp>
#include <templates/list.hpp>
#include <variant/string_name.hpp>

namespace engine {
    using namespace godot;

    void convert_property_to_c(const PropertyInfo& p_source, GDExtensionPropertyInfo* p_dest);
    GDExtensionMethodInfo* create_c_method_list(List<MethodInfo>* p_list_cpp, uint32_t* r_size);
    void free_c_method_list(GDExtensionMethodInfo* p_list, uint32_t p_count);

    // A StringName is an eight byte handle on a name the engine interns, so two of them holding the same name always
    // hold the same handle. Comparing or hashing them goes through the engine, one ptrcall each; comparing the handles
    // does not, which is what makes these worth having on a path taken once per script call.
    //
    // The engine drops an interned entry once the last StringName on it is gone, and hands the block to the next name.
    // A handle is therefore only meaningful while something holds the name: reading one from a temporary and using it
    // in the same expression is fine, storing one that outlives the name it came from is not, and silently so, because
    // the stale handle goes on comparing equal to whatever was interned next.
    _FORCE_INLINE_ const void* identity(const StringName& p_name) {
        return *reinterpret_cast<const void* const*>(p_name._native_ptr());
    }

    _FORCE_INLINE_ bool same_name(const StringName& p_left, const StringName& p_right) {
        return identity(p_left) == identity(p_right);
    }

    // For a map keyed by StringName that must not go through the engine on lookup. The handle is a unique, 16-byte
    // aligned address, so its own bits spread as well as any hash would and the mixing the default hasher does is only
    // cost; the map needs nothing beyond the shift that drops the alignment zeros. Keying by the StringName itself
    // rather than by the bare handle is what keeps each name interned for as long as the map holds it.
    struct IdentityHasher {
        static _FORCE_INLINE_ uint32_t hash(const StringName& p_name) {
            return static_cast<uint32_t>(reinterpret_cast<uintptr_t>(identity(p_name)) >> 4);
        }
    };

    struct IdentityComparator {
        static _FORCE_INLINE_ bool compare(const StringName& p_left, const StringName& p_right) {
            return same_name(p_left, p_right);
        }
    };

    // A map keyed by StringName that never goes through the engine on lookup: one mask and one probe.
    template<class T>
    using IdentityMap = AHashMap<StringName, T, IdentityHasher, IdentityComparator>;
} // namespace engine

#endif // GODOT_JVM_INTERNAL_H
