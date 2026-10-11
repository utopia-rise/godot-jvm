#include "scala_language.h"

#include "api/script/language/scala_script.h"
#include "names.h"

using namespace godot;

// clang-format off
constexpr const char* SCALA_TEMPLATE = PACKAGE_TEMPLATE
    "\n"
    "\n"
    "import " GODOT_KOTLIN_PACKAGE "." BASE_TEMPLATE "\n"
    "import godot.annotation.Script\n"
    "\n"
    "@Script\n"
    "class " CLASS_TEMPLATE " extends " BASE_TEMPLATE " {\n"
    "\n"
    "    // Declare member variables here. Examples:\n"
    "    // val a: Int = 2;\n"
    "    // val b: String = \"text\";\n"
    "\n"
    "    // Called when the node enters the scene tree for the first time.\n"
    "    override def _ready(): Unit = {\n"
    "        \n"
    "    }\n"
    "\n"
    "    // Called every frame. 'delta' is the elapsed time since the previous frame.\n"
    "    override def _process(delta: Double): Unit = {\n"
    "        \n"
    "    }\n"
    "}\n";

constexpr const char* SCALA_EMPTY_TEMPLATE = PACKAGE_TEMPLATE
    "\n"
    "\n"
    "import " GODOT_KOTLIN_PACKAGE "." BASE_TEMPLATE "\n"
    "import godot.annotation.Script\n"
    "\n"
    "@Script\n"
    "class " CLASS_TEMPLATE " extends " BASE_TEMPLATE "\n";
// clang-format on

ScalaLanguage* ScalaLanguage::get_instance() {
    static ScalaLanguage* instance = memnew(ScalaLanguage);
    return instance;
}

String ScalaLanguage::_get_name() const {
    return GODOT_SCALA_LANGUAGE_NAME;
}

String ScalaLanguage::_get_type() const {
    return GODOT_SCALA_SCRIPT_NAME;
}

String ScalaLanguage::_get_extension() const {
    return GODOT_SCALA_SCRIPT_EXTENSION;
}

PackedStringArray ScalaLanguage::_get_recognized_extensions() const {
    static PackedStringArray extensions = {GODOT_SCALA_SCRIPT_EXTENSION};
    return extensions;
}

PackedStringArray ScalaLanguage::_get_reserved_words() const {
    static PackedStringArray reserved_words = {
        "abstract", "case",     "catch",   "class",   "def",       "do",     "else",   "extends", "false", "final",
        "finally",  "for",      "forSome", "if",      "implicit",  "import", "lazy",   "match",   "new",   "null",
        "object",   "override", "package", "private", "protected", "return", "sealed", "super",   "this",  "throw",
        "trait",    "try",      "true",    "type",    "val",       "var",    "while",  "with",    "yield"
    };

    return reserved_words;
}

bool ScalaLanguage::_is_control_flow_keyword(const String& p_keyword) const {
    return p_keyword == "break"
        || p_keyword == "catch"
        || p_keyword == "continue"
        || p_keyword == "do"
        || p_keyword == "else"
        || p_keyword == "finally"
        || p_keyword == "for"
        || p_keyword == "if"
        || p_keyword == "return"
        || p_keyword == "match"
        || p_keyword == "throw"
        || p_keyword == "try"
        || p_keyword == "while"
        || p_keyword == "yield";
}

PackedStringArray ScalaLanguage::_get_comment_delimiters() const {
    static PackedStringArray delimiters = {"//", "/* */"};
    return delimiters;
}

PackedStringArray ScalaLanguage::_get_doc_comment_delimiters() const {
    static PackedStringArray delimiters = {"/** */"};
    return delimiters;
}

PackedStringArray ScalaLanguage::_get_string_delimiters() const {
    static PackedStringArray delimiters = {"' '", "\" \"", R"(""" """)"};
    return delimiters;
}

Ref<Script> ScalaLanguage::_make_template(
    const String& p_template,
    const String& p_class_name,
    const String& p_base_class_name
) const {
    Ref<ScalaScript> scala_script;
    scala_script.instantiate();
    String processed_template =
        p_template.replace(CLASS_TEMPLATE, p_class_name.to_pascal_case()).replace(BASE_TEMPLATE, p_base_class_name);
    scala_script->set_source_code(processed_template);
    scala_script->set_name(p_class_name);
    return scala_script;
}

TypedArray<Dictionary> ScalaLanguage::_get_built_in_templates(const StringName& p_object) const {
    return node_and_object_templates(p_object, SCALA_TEMPLATE, SCALA_EMPTY_TEMPLATE);
}

bool ScalaLanguage::_is_using_templates() {
    return true;
}

Object* ScalaLanguage::_create_script() const {
    return memnew(ScalaScript);
}

bool ScalaLanguage::_handles_global_class_type(const String& p_type) const {
    return p_type == GODOT_SCALA_SCRIPT_NAME;
}

bool ScalaLanguage::_supports_builtin_mode() const {
    return false;
}
