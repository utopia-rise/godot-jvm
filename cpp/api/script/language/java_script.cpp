#include "java_script.h"

#include "api/language/java_language.h"
#include "api/language/names.h"

using namespace godot;

ScriptLanguage* JavaScript::_get_language() const {
    return JavaLanguage::get_instance();
}

#ifdef TOOLS_ENABLED
void JavaScript::_format_template(const String& p_path) const {
    if (!source.contains(PACKAGE_TEMPLATE)) {
        return;
    }

    String package {p_path.replace("src/main/java/", "")
                      .trim_prefix("res://")
                      .trim_suffix(get_name() + "." + JavaLanguage::get_instance()->_get_extension())
                      .trim_suffix("/")
                      .replace("/", ".")};

    if (!package.is_empty()) { package = "package " + package + ";";}

    source = source.replace(PACKAGE_TEMPLATE, package).strip_edges(true, false);
}
#endif

void JavaScript::_bind_methods() {}