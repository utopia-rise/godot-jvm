#include "gdj_script.h"

#include "api/language/gdj_language.h"

using namespace godot;

ScriptLanguage* GdjScript::_get_language() const {
    return GdjLanguage::get_instance();
}

StringName GdjScript::_get_global_name() const {
    return _is_valid() ? JvmScript::_get_global_name() : StringName(get_script_file_name(get_path()));
}

void GdjScript::_bind_methods() {}
