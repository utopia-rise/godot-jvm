#include "kotlin_language.h"

#include "api/script/language/kotlin_script.h"
#include "names.h"

using namespace godot;

// clang-format off
constexpr const char* KOTLIN_TEMPLATE = PACKAGE_TEMPLATE
    "\n"
    "\n"
    "import " GODOT_KOTLIN_PACKAGE "." BASE_TEMPLATE "\n"
    "import godot.annotation.Script\n"
    "\n"
    "@Script\n"
    "class " CLASS_TEMPLATE ": " BASE_TEMPLATE "() {\n"
    "\n"
    "    // Declare member variables here. Examples:\n"
    "    // val a = 2\n"
    "    // val b = \"text\"\n"
    "\n"
    "    // Called when the node enters the scene tree for the first time.\n"
    "    override fun _ready() {\n"
    "        \n"
    "    }\n"
    "\n"
    "    // Called every frame. 'delta' is the elapsed time since the previous frame.\n"
    "    override fun _process(delta: Double) {\n"
    "        \n"
    "    }\n"
    "}\n";

constexpr const char* KOTLIN_EMPTY_TEMPLATE = PACKAGE_TEMPLATE
    "\n"
    "\n"
    "import " GODOT_KOTLIN_PACKAGE "." BASE_TEMPLATE "\n"
    "import godot.annotation.Script\n"
    "\n"
    "@Script\n"
    "class " CLASS_TEMPLATE ": " BASE_TEMPLATE "()\n";
// clang-format on

KotlinLanguage* KotlinLanguage::get_instance() {
    static KotlinLanguage* instance = memnew(KotlinLanguage);
    return instance;
}

String KotlinLanguage::_get_name() const {
    return GODOT_KOTLIN_LANGUAGE_NAME;
}

String KotlinLanguage::_get_type() const {
    return GODOT_KOTLIN_SCRIPT_NAME;
}

String KotlinLanguage::_get_extension() const {
    return GODOT_KOTLIN_SCRIPT_EXTENSION;
}

PackedStringArray KotlinLanguage::_get_recognized_extensions() const {
    PackedStringArray extensions = {GODOT_KOTLIN_SCRIPT_EXTENSION};
    return extensions;
}

PackedStringArray KotlinLanguage::_get_reserved_words() const {
    static PackedStringArray reserved_words = {
        // RESERVED KEYWORDS
        "as",
        "as?",
        "break",
        "class",
        "continue",
        "do",
        "else",
        "false",
        "for",
        "fun",
        "if",
        "in",
        "!in",
        "interface",
        "is",
        "!is",
        "null",
        "object",
        "package",
        "return",
        "super",
        "this",
        "throw",
        "true",
        "try",
        "typealias",
        "typeof",
        "val",
        "var",
        "when",
        "while",

        // SOFT KEYWORDS
        "by",
        "catch",
        "constructor",
        "delegate",
        "dynamic",
        "field",
        "file",
        "finally",
        "get",
        "import",
        "init",
        "param",
        "property",
        "receiveris",
        "set",
        "setparam",
        "where",

        // MODIFIERS KEYWORDS
        "actual",
        "abstract",
        "annotation",
        "companion",
        "const",
        "crossinline",
        "data",
        "enum",
        "expect",
        "external",
        "final",
        "infix",
        "inline",
        "inner",
        "internal",
        "lateinit",
        "noinline",
        "open",
        "operator",
        "out",
        "override",
        "private",
        "protected",
        "public",
        "reified",
        "sealed",
        "suspend",
        "tailrec",
        "vararg",

        // SPECIAL IDENTIFIERS
        "it",
    };
    return reserved_words;
}

bool KotlinLanguage::_is_control_flow_keyword(const String& p_keyword) const {
    return p_keyword == "break"
        || p_keyword == "catch"
        || p_keyword == "continue"
        || p_keyword == "do"
        || p_keyword == "else"
        || p_keyword == "finally"
        || p_keyword == "for"
        || p_keyword == "if"
        || p_keyword == "return"
        || p_keyword == "when"
        || p_keyword == "throw"
        || p_keyword == "try"
        || p_keyword == "while";
}

PackedStringArray KotlinLanguage::_get_comment_delimiters() const {
    static PackedStringArray delimiters = {"//", "/* */"};
    return delimiters;
}

PackedStringArray KotlinLanguage::_get_doc_comment_delimiters() const {
    static PackedStringArray delimiters = {"/** */"};
    return delimiters;
}

PackedStringArray KotlinLanguage::_get_string_delimiters() const {
    static PackedStringArray delimiters = {"' '", "\" \""};
    return delimiters;
}

Ref<Script> KotlinLanguage::_make_template(
    const String& p_template,
    const String& p_class_name,
    const String& p_base_class_name
) const {
    Ref<KotlinScript> kotlin_script;
    kotlin_script.instantiate();
    String processed_template =
        p_template.replace(CLASS_TEMPLATE, p_class_name.to_pascal_case()).replace(BASE_TEMPLATE, p_base_class_name);
    kotlin_script->set_source_code(processed_template);
    kotlin_script->set_name(p_class_name);
    return kotlin_script;
}

TypedArray<Dictionary> KotlinLanguage::_get_built_in_templates(const StringName& p_object) const {
    return node_and_object_templates(p_object, KOTLIN_TEMPLATE, KOTLIN_EMPTY_TEMPLATE);
}

bool KotlinLanguage::_is_using_templates() {
    return true;
}

Object* KotlinLanguage::_create_script() const {
    return memnew(KotlinScript);
}

bool KotlinLanguage::_handles_global_class_type(const String& p_type) const {
    return p_type == GODOT_KOTLIN_SCRIPT_NAME;
}

bool KotlinLanguage::_supports_builtin_mode() const {
    return false;
}
