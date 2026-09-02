#ifndef GODOT_JVM_JVM_BINDING_H
#define GODOT_JVM_JVM_BINDING_H

#include "jvm/wrapper/registration/kt_object.h"

#include <atomic>
#include <classes/wrapped.hpp>

namespace godot {
    class JvmBinding {
        int constructor_id = -1;
        ObjectID object_id;
        // Using std directly because Godot SafeFlag doesn't provide the right methods (despite wrapping the same std atomic).
        std::atomic_flag is_incremented = ATOMIC_FLAG_INIT;
    private:
        void init_from_class_name(ObjectID p_object_id, const StringName& p_class_name);

    public:
        JvmBinding() = default;
        ~JvmBinding() = default;

        // Called from the reentrant instance-binding-creation callback (see JvmBindingManager) — must stick to raw GDExtension calls only, no godot-cpp wrapper.
        void init(GodotObject* obj);
        int get_constructor_id() const;
        ObjectID get_object_id() const;
        bool test_and_set_incremented();
    };

}

#endif // GODOT_JVM_JVM_BINDING_H
