#ifndef GODOT_JVM_JAVA_SCRIPT_H
#define GODOT_JVM_JAVA_SCRIPT_H

#include "api/script/jvm_script.h"

namespace godot {
class JavaScript : public JvmScript {
    GDCLASS(JavaScript, JvmScript);

    public:
        JavaScript() = default;
        ~JavaScript() override = default;

        ScriptLanguage* _get_language() const override;

#ifdef TOOLS_ENABLED
        void _format_template(const String& p_path) const override;
#endif

    protected:
        static void _bind_methods();
    };
} // namespace godot
#endif // GODOT_JVM_JAVA_SCRIPT_H
