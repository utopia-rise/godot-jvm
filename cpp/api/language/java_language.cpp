#include "java_language.h"

#include "names.h"
#include "api/script/language/java_script.h"

#include <classes/resource_loader.hpp>

using namespace godot;

constexpr const char* JAVA_TEMPLATE = PACKAGE_TEMPLATE
  "\n"
  "\n"
  "import " GODOT_KOTLIN_PACKAGE "." BASE_TEMPLATE ";\n"
  "import godot.annotation.Script;\n"
  "\n"
  "@Script\n"
  "public class " CLASS_TEMPLATE " extends " BASE_TEMPLATE " {\n"
  "\n"
  "    // Declare member variables here. Examples:\n"
  "    // private int a = 2;\n"
  "    // private String b = \"text\";\n"
  "\n"
  "    // Called when the node enters the scene tree for the first time.\n"
  "    @Override\n"
  "    public void _ready() {\n"
  "        \n"
  "    }\n"
  "\n"
  "    // Called every frame. 'delta' is the elapsed time since the previous frame.\n"
  "    @Override\n"
  "    public void _process(double delta) {\n"
  "        \n"
  "    }\n"
  "}\n";

JavaLanguage* JavaLanguage::get_instance() {
    static JavaLanguage* instance {memnew(JavaLanguage)};
    return instance;
}

String JavaLanguage::_get_name() const {
    return GODOT_JAVA_LANGUAGE_NAME;
}

String JavaLanguage::_get_type() const {
    return GODOT_JAVA_SCRIPT_NAME;
}

String JavaLanguage::_get_extension() const {
    return GODOT_JAVA_SCRIPT_EXTENSION;
}

PackedStringArray JavaLanguage::_get_recognized_extensions() const {
    static PackedStringArray extensions {
      GODOT_JAVA_SCRIPT_EXTENSION
    };
    return extensions;
}

PackedStringArray JavaLanguage::_get_reserved_words() const {
    static PackedStringArray reserved_words {
        "abstract",
        "assert",
        "boolean",
        "break",
        "byte",
        "case",
        "catch",
        "char",
        "class",
        "const",
        "continue",
        "default",
        "do",
        "double",
        "else",
        "enum",
        "extends",
        "final",
        "finally",
        "float",
        "for",
        "if",
        "implements",
        "import",
        "instanceof",
        "int",
        "interface",
        "long",
        "native",
        "new",
        "package",
        "private",
        "protected",
        "public",
        "return",
        "short",
        "static",
        "strictfp",
        "super",
        "switch",
        "synchronized",
        "this",
        "throw",
        "throws",
        "transient",
        "try",
        "void",
        "volatile",
        "while"
    };
    return reserved_words;
}

bool JavaLanguage::_is_control_flow_keyword(const String& p_keyword) const {
    return p_keyword == "break" || p_keyword == "catch" || p_keyword == "continue" || p_keyword == "do"
        || p_keyword == "else" || p_keyword == "finally" || p_keyword == "for" || p_keyword == "if" || p_keyword == "return"
        || p_keyword == "when" || p_keyword == "throw" || p_keyword == "try" || p_keyword == "while";
}

PackedStringArray JavaLanguage::_get_comment_delimiters() const {
    static PackedStringArray delimiters {
      "//",
      "/* */"
    };
    return delimiters;
}

PackedStringArray JavaLanguage::_get_doc_comment_delimiters() const {
    PackedStringArray delimiters {
      "/** */"
    };
    return delimiters;
}

PackedStringArray JavaLanguage::_get_string_delimiters() const {
    PackedStringArray delimiters {
      "' '",
      "\" \""
    };
    return delimiters;
}

Ref<Script> JavaLanguage::_make_template(const String& p_template, const String& p_class_name, const String& p_base_class_name) const {
    Ref<JavaScript> java_script;
    java_script.instantiate();
    String processed_template {p_template.replace(CLASS_TEMPLATE, p_class_name.to_pascal_case())};
    java_script->set_source_code(processed_template);
    java_script->set_name(p_class_name);
    return java_script;
}

TypedArray<Dictionary> JavaLanguage::_get_built_in_templates(const StringName& p_object) const {
    TypedArray<Dictionary> templates;
    if (ClassDB::is_parent_class(p_object, "Node")) {
        Dictionary script_template;
        script_template["inherit"] = String(p_object);
        script_template["name"] = "Default";
        script_template["description"] = "Base template for Node based scripts with default Godot cycle methods";
        script_template["content"] = String(JAVA_TEMPLATE).replace(BASE_TEMPLATE, p_object);
        script_template["id"] = 0;
        script_template["origin"] = 0; // ScriptLanguage::TEMPLATE_BUILT_IN
        templates.append(script_template);
    }
    return templates;
}

bool JavaLanguage::_is_using_templates() {
    return true;
}

Object* JavaLanguage::_create_script() const {
    return memnew(JavaScript);
}

bool JavaLanguage::_handles_global_class_type(const String& p_type) const {
    return p_type == GODOT_JAVA_SCRIPT_NAME;
}

bool JavaLanguage::_supports_builtin_mode() const {
    return false;
}
