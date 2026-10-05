#ifndef GODOT_JVM_JVM_BINDING_H
#define GODOT_JVM_JVM_BINDING_H

#include <atomic>
#include <classes/wrapped.hpp>

namespace godot {
    class JvmBinding {
        ObjectID object_id;
        std::atomic<uint32_t> deliveries = 0;

    public:
        JvmBinding() = default;
        ~JvmBinding() = default;

        // Called from the reentrant instance-binding-creation callback (see JvmBindingManager) — must stick to raw
        // GDExtension calls only, no godot-cpp wrapper.
        void init(GodotObject* obj);
        ObjectID get_object_id() const;
        // Returns the count before this delivery; 0 means the JVM's native reference is not taken yet.
        uint32_t record_delivery();
        uint32_t get_deliveries() const;
    };

    static_assert(sizeof(JvmBinding) == 16, "One JvmBinding is allocated per object the JVM sees; keep it small.");
} // namespace godot

#endif // GODOT_JVM_JVM_BINDING_H
