#include "kotlin_script.h"

#include "api/language/kotlin_language.h"
#include "api/language/names.h"

using namespace godot;

ScriptLanguage* KotlinScript::_get_language() const {
    return KotlinLanguage::get_instance();
}

#ifdef TOOLS_ENABLED
void KotlinScript::_format_template(const String& p_path) const {
    if (!source.contains(PACKAGE_TEMPLATE)) {
        return;
    }

    String package {p_path.replace("src/main/kotlin/", "")
                      .trim_prefix("res://")
                      .trim_suffix(get_name() + "." + KotlinLanguage::get_instance()->_get_extension())
                      .trim_suffix("/")
                      .replace("/", ".")};

    if (!package.is_empty()) { package = "package " + package; }

    source = source.replace(PACKAGE_TEMPLATE, package).strip_edges(true, false);
}
#endif

void KotlinScript::_bind_methods() {}