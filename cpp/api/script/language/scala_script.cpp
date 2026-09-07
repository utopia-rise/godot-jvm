#include "scala_script.h"
#include "api/language/names.h"
#include "api/language/scala_language.h"

using namespace godot;

ScriptLanguage* ScalaScript::_get_language() const {
    return ScalaLanguage::get_instance();
}

#ifdef TOOLS_ENABLED
void ScalaScript::_format_template(const String& p_path) const {
    if (!source.contains(PACKAGE_TEMPLATE)) {
        return;
    }

    String package = p_path.replace("src/main/scala/", "")
                      .trim_prefix("res://")
                      .trim_suffix(get_name() + "." + ScalaLanguage::get_instance()->_get_extension())
                      .trim_suffix("/")
                      .replace("/", ".");

    if (!package.is_empty()) { package = "package " + package + ";";}

    source = source.replace(PACKAGE_TEMPLATE, package).strip_edges(true, false);
}
#endif

void ScalaScript::_bind_methods() {}
