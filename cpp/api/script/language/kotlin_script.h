#ifndef GODOT_JVM_KOTLIN_SCRIPT_H
#define GODOT_JVM_KOTLIN_SCRIPT_H

#include "api/script/jvm_script.h"

namespace godot {
    class KotlinScript : public JvmScript {
        GDCLASS(KotlinScript, JvmScript);

    public:
        KotlinScript() = default;
        ~KotlinScript() override = default;

        ScriptLanguage* _get_language() const override;

#ifdef TOOLS_ENABLED
        void _format_template(const String& p_path) const override;
#endif

    protected:
        static void _bind_methods();
    };
}
#endif// GODOT_JVM_KOTLIN_SCRIPT_H
