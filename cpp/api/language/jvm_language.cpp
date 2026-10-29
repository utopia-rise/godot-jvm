#include "jvm_language.h"

#include "api/script/jvm_script.h"
#include "engine/ustring.h"

#ifdef TOOLS_ENABLED
#include "api/script/jvm_script_manager.h"
#endif

#include <classes/resource_loader.hpp>
#include <classes/script_language_extension.hpp>

using namespace godot;

Dictionary JvmLanguage::_validate(
    const String& p_script,
    const String& p_path,
    bool p_validate_functions,
    bool p_validate_errors,
    bool p_validate_warnings,
    bool p_validate_safe_lines
) const {
    Dictionary ret;
    ret["valid"] = true;
    return ret;
}

String JvmLanguage::_validate_path(const String& p_path) const {
    PackedStringArray keywords = _get_reserved_words();
    if (keywords.find(p_path.get_file().get_basename()) != -1) {
        String alert = "Please don't use reserved keywords as file name.";
        return
#ifdef TOOLS_ENABLED
            TTR(alert)
#else
            RTR(alert)
#endif
                ;
    }
    return "";
}

Dictionary JvmLanguage::_get_global_class_name(const String& p_path) const {
    Ref<JvmScript> script = ResourceLoader::get_singleton()->load(p_path);
    if (script.is_null()) { return Dictionary(); }

    StringName name;
    StringName base_type;
    bool is_abstract = false;
    bool is_tool = false;
    if (script->_is_valid()) {
        Ref<Script> base_script = script->_get_base_script();
        name = script->_get_global_name();
        base_type = base_script.is_valid() ? base_script->get_global_name() : script->_get_instance_base_type();
        is_abstract = script->_is_abstract();
        is_tool = script->_is_tool();
    }
#ifdef TOOLS_ENABLED
    else {
        // Without the debug jars, the index written by every build still gives Godot's global class cache its entries.
        IndexedScriptClass indexed = JvmScriptManager::get_instance()->get_indexed_script_class(script.ptr());
        name = indexed.name;
        base_type = indexed.base;
    }
#endif

    // An empty name tells Godot the script declares no global class.
    Dictionary result;
    result["base_type"] = base_type;
    result["is_abstract"] = is_abstract;
    result["is_tool"] = is_tool;
    result["name"] = name;
    return result;
}

// Dummy Implementations

bool JvmLanguage::_has_named_classes() const {
    return true;
}

Error JvmLanguage::_open_in_external_editor(const Ref<Script>& p_script, int p_line, int p_col) {
    return Error::ERR_UNAVAILABLE;
}

bool JvmLanguage::_overrides_external_editor() {
    return false;
}

ScriptLanguage::ScriptNameCasing JvmLanguage::_preferred_file_name_casing() const {
    return ScriptLanguage::SCRIPT_NAME_CASING_PASCAL_CASE;
}

bool JvmLanguage::_can_inherit_from_file() const {
    return false;
}

int32_t JvmLanguage::_find_function(const String&, const String&) const {
    return -1;
}

String JvmLanguage::_make_function(const String&, const String&, const PackedStringArray&) const {
    return String();
}

bool JvmLanguage::_can_make_function() const {
    return false;
}

Dictionary JvmLanguage::_complete_code(const String&, const String&, Object*) const {
    Dictionary result;
    result["result"] = Error::ERR_UNAVAILABLE;
    result["force"] = false;
    result["call_hint"] = "";
    return result;
}

Dictionary JvmLanguage::_lookup_code(const String&, const String&, const String&, Object*) const {
    Dictionary result;
    result["result"] = Error::ERR_UNAVAILABLE;
    result["type"] = ScriptLanguageExtension::LOOKUP_RESULT_SCRIPT_LOCATION;
    return result;
}

String JvmLanguage::_auto_indent_code(const String& p_code, int32_t p_from_line, int32_t p_to_line) const {
    return p_code;
}

void JvmLanguage::_init() {}

void JvmLanguage::_frame() {}

void JvmLanguage::_finish() {}

void JvmLanguage::_thread_enter() {}

void JvmLanguage::_thread_exit() {}

TypedArray<Dictionary> JvmLanguage::_debug_get_current_stack_info() {
    return TypedArray<Dictionary>();
}

String JvmLanguage::_debug_get_error() const {
    return String();
}

int32_t JvmLanguage::_debug_get_stack_level_count() const {
    return 0;
}

int32_t JvmLanguage::_debug_get_stack_level_line(int32_t) const {
    return 0;
}

String JvmLanguage::_debug_get_stack_level_function(int32_t) const {
    return String();
}

String JvmLanguage::_debug_get_stack_level_source(int32_t) const {
    return String();
}

Dictionary JvmLanguage::_debug_get_stack_level_locals(int32_t, int32_t, int32_t) {
    return Dictionary();
}

Dictionary JvmLanguage::_debug_get_stack_level_members(int32_t, int32_t, int32_t) {
    return Dictionary();
}

void* JvmLanguage::_debug_get_stack_level_instance(int32_t) {
    return nullptr;
}

Dictionary JvmLanguage::_debug_get_globals(int32_t, int32_t) {
    return Dictionary();
}

String JvmLanguage::_debug_parse_stack_level_expression(int32_t, const String&, int32_t, int32_t) {
    return String();
}

void JvmLanguage::_reload_all_scripts() {}

void JvmLanguage::_reload_scripts(const Array& p_scripts, bool) {
    for (int i = 0; i < p_scripts.size(); ++i) {
        ResourceLoader::get_singleton()
            ->load(Ref<Script>(p_scripts[i])->get_path(), "", ResourceLoader::CACHE_MODE_IGNORE);
    }
}

void JvmLanguage::_reload_tool_script(const Ref<Script>&, bool) {}

void JvmLanguage::_add_global_constant(const StringName&, const Variant&) {}

void JvmLanguage::_add_named_global_constant(const StringName&, const Variant&) {}

void JvmLanguage::_remove_named_global_constant(const StringName&) {}

void JvmLanguage::_profiling_start() {}

void JvmLanguage::_profiling_stop() {}

void JvmLanguage::_profiling_set_save_native_calls(bool) {}

int32_t JvmLanguage::_profiling_get_accumulated_data(ScriptLanguageExtensionProfilingInfo*, int32_t) {
    return 0;
}

int32_t JvmLanguage::_profiling_get_frame_data(ScriptLanguageExtensionProfilingInfo*, int32_t) {
    return 0;
}

TypedArray<Dictionary> JvmLanguage::_get_built_in_templates(const StringName&) const {
    return TypedArray<Dictionary>();
}

static Dictionary built_in_template(
    const String& p_inherit,
    const String& p_name,
    const String& p_description,
    const String& p_content
) {
    Dictionary script_template;
    script_template["inherit"] = p_inherit;
    script_template["name"] = p_name;
    script_template["description"] = p_description;
    script_template["content"] = p_content;
    script_template["id"] = 0;
    script_template["origin"] = 0; // ScriptLanguage::TEMPLATE_BUILT_IN
    return script_template;
}

TypedArray<Dictionary> JvmLanguage::node_and_object_templates(
    const StringName& p_object,
    const char* p_node_template,
    const char* p_object_template
) {
    TypedArray<Dictionary> templates;
    if (p_object == StringName("Node")) {
        templates.append(built_in_template(
            "Node",
            "Default",
            "Base template for Node based scripts with default Godot cycle methods",
            p_node_template
        ));
    } else if (p_object == StringName("Object")) {
        templates.append(
            built_in_template("Object", "Empty", "Empty template suitable for all Objects", p_object_template)
        );
    }
    return templates;
}

bool JvmLanguage::_is_using_templates() {
    return false;
}

TypedArray<Dictionary> JvmLanguage::_get_public_functions() const {
    return TypedArray<Dictionary>();
}

Dictionary JvmLanguage::_get_public_constants() const {
    return Dictionary();
}

TypedArray<Dictionary> JvmLanguage::_get_public_annotations() const {
    return TypedArray<Dictionary>();
}

// TODO: Dummy to make reloading work again because of https://github.com/godotengine/godot/issues/104540. Should still
// be truly implemented at some point
bool JvmLanguage::_supports_documentation() const {
    return true;
}
