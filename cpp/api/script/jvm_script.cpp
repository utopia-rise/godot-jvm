#include "jvm_script.h"

#include "engine/godot_object.h"

#include "api/language/gdj_language.h"
#include "api/script/jvm_script_manager.h"
#include "classes/engine.hpp"
#include "core/jvm_binding_manager.h"
#include "jvm/wrapper/memory/memory_manager.h"
#include "jvm_instance.h"
#include "jvm_placeholder_instance.h"
#include <classes/node.hpp>
#include <core/object.hpp>

using namespace godot;

Variant JvmScript::_new() {
    if (GodotObject* obj = _object_create()) { return RawObject(obj).to_variant(); }
    return {};
}

GodotObject* JvmScript::_object_create() const {
#ifdef DEBUG_ENABLED
    if (!validate_instance_creation()) { return nullptr; }
#endif

    // Not godot::ClassDB::instantiate(): that forwards to the script-facing ClassDB singleton, which boxes a RefCounted result in a Ref<RefCounted> inside a Variant — converting that straight to Object* and letting the Variant go out of scope...
    GodotObject* raw_owner {RawObject::instantiate(kotlin_class->base_godot_class)};
    JVM_ERR_FAIL_COND_V_MSG(
      raw_owner == nullptr,
      nullptr,
      "Cannot instantiate JVM script %s: failed to instantiate base Godot class %s.",
      kotlin_class->registered_class_name,
      kotlin_class->base_godot_class
    );

    // Establishes the object's real refcount (if any) and our own binding before anything else touches it — see JvmBindingManager::set_instance_binding()'s own comment.
    JvmBindingManager::set_instance_binding(raw_owner);

    // Attaching directly via object_set_script_instance, not owner->set_script(this): set_script() re-enters the engine's can-instantiate/placeholder decision, and _can_instantiate() is unconditionally false in the editor (see below) — that re...
    void* instance {create_jvm_instance(raw_owner)};
    if (instance == nullptr) { return nullptr; }
    internal::gdextension_interface_object_set_script_instance(raw_owner, instance);
    return raw_owner;
}

bool JvmScript::_can_instantiate() const {
    if (!_is_valid() || kotlin_class->is_abstract) { return false; }

#ifdef TOOLS_ENABLED
    return !Engine::get_singleton()->is_editor_hint();
#else
    return true;
#endif
}

bool JvmScript::_inherits_script(const Ref<Script>& p_script) const {
    Ref<JvmScript> kotlin_script {p_script};
    if (kotlin_script.is_null()) { return false; }
    if (!_is_valid() || !kotlin_script->_is_valid()) { return false; }

    KtClass* parent_class {kotlin_script->kotlin_class};
    if (kotlin_class == parent_class) { return true; }

    Ref<Script> current = _get_base_script();
    while (current.is_valid()) {
        Ref<JvmScript> current_script {current};
        if (current_script.is_null() || !current_script->_is_valid()) { return false; }
        if (current_script->kotlin_class == parent_class) { return true; }
        current = current_script->_get_base_script();
    }
    return false;
}

Ref<Script> JvmScript::_get_base_script() const {
    if (!_is_valid() || kotlin_class->registered_supertypes.size() == 0) { return {}; }
    StringName parent_name = kotlin_class->registered_supertypes[0];
    return JvmScriptManager::get_instance()->get_script_from_registered_name(parent_name);
}

StringName JvmScript::_get_instance_base_type() const {
    if (_is_valid()) { return kotlin_class->base_godot_class; }
    // not found
    return {};
}

StringName JvmScript::_get_global_name() const {
    return _is_valid() ? kotlin_class->registered_class_name : StringName();
}

// Receives the raw engine pointer rather than an Object *: godot-cpp's generator is patched to expose this virtual
// that way (see VIRTUAL_RAW_OBJECT_ARGS there), because decoding an Object * would build and permanently register a
// C++ wrapper for every object a JVM script is ever attached to, only for us to unwrap it again on the next line.
void* JvmScript::_instance_create(GodotObject* p_for_object) const {
#ifdef DEBUG_ENABLED
    if (!validate_instance_creation()) { return nullptr; }
#endif
    return create_jvm_instance(p_for_object);
}

#ifdef DEBUG_ENABLED
bool JvmScript::validate_instance_creation() const {
    JVM_ERR_FAIL_COND_V_MSG(!_is_valid(), false, "Invalid script %s was attempted to be used. Make sure you have properly built your project.", get_path());
    JVM_ERR_FAIL_COND_V_MSG(
      !kotlin_class->can_zero_init(),
      false,
      "Cannot instantiate JVM script %s: no public zero-argument constructor is registered.",
      kotlin_class->registered_class_name
    );
    return true;
}
#endif

void* JvmScript::create_jvm_instance(GodotObject* p_raw_owner) const {
    // Assumes validate_instance_creation() has succeeded.
    //TODO: Check if creator when set_script_instance is implemented in engine.
    JvmBindingManager::get_instance_binding(p_raw_owner);

    JVM_DEV_VERBOSE("Try to create %s instance.", kotlin_class->registered_class_name);

    jni::Env env = jni::Jvm::current_env();
    KtObject* wrapped = kotlin_class->create_instance(env, p_raw_owner);

    JvmInstance::JvmInstanceData* instance_data = JvmInstance::create_instance_data(
      env,
      p_raw_owner,
      wrapped,
      this
    );

    return internal::gdextension_interface_script_instance_create3(
      &JvmInstance::jvm_script_instance_info,
      instance_data
    );
}

bool JvmScript::_has_source_code() const {
    return !source.is_empty();
}

String JvmScript::_get_source_code() const {
    return source;
}

void JvmScript::_set_source_code(const String& p_code) {
    source = p_code;
    // TODO : deal with tool mode
}

Error JvmScript::_reload(bool p_keep_state) {
    return Error::ERR_UNAVAILABLE;
}

bool JvmScript::_has_method(const StringName& p_method) const {
    return _is_valid() && kotlin_class->get_method(p_method) != nullptr;
}

Dictionary JvmScript::_get_method_info(const StringName& p_method) const {
    if (_is_valid()) {
        if (KtFunction * method {kotlin_class->get_method(p_method)}) {
            return method->get_member_info();
        }
    }
    return {};
}

bool JvmScript::_is_tool() const {
    // TODO: When implementing tool classes
    return false;
}

bool JvmScript::_is_valid() const {
    return kotlin_class != nullptr;
}

bool JvmScript::_is_placeholder_fallback_enabled() const {
    return kotlin_class == nullptr;
}

bool JvmScript::_is_abstract() const {
    return _is_valid() && kotlin_class->is_abstract;
}

bool JvmScript::_has_script_signal(const StringName& p_signal) const {
    return _is_valid() && kotlin_class->get_signal(p_signal) != nullptr;
}

TypedArray<Dictionary> JvmScript::_get_script_signal_list() const {
    TypedArray<Dictionary> ret;

    if (_is_valid()) {
        List<MethodInfo> info_list;
        kotlin_class->get_signal_list(&info_list);
        for (const MethodInfo& info : info_list) {
            Dictionary info_as_dict = info;
            ret.append(info_as_dict);
        }
    }

    return ret;
}

bool JvmScript::_has_property_default_value(const StringName& p_property) const {
#ifdef TOOLS_ENABLED
    return exported_members_default_value_cache.has(p_property);
#else
    return false;
#endif
}

Variant JvmScript::_get_property_default_value(const StringName& p_property) const {
#ifdef TOOLS_ENABLED
    HashMap<StringName, Variant>::ConstIterator it {exported_members_default_value_cache.find(p_property)};
    if (it) {
        return it->value;
    }
#endif

    return {};
}

TypedArray<Dictionary> JvmScript::_get_script_method_list() const {
    TypedArray<Dictionary> ret;

    if (_is_valid()) {
        List<MethodInfo> info_list;
        kotlin_class->get_method_list(&info_list);
        for (const MethodInfo& info : info_list) {
            Dictionary info_as_dict = info;
            ret.append(info_as_dict);
        }
    }

    return ret;
}

void JvmScript::_get_script_property_info_list(List<PropertyInfo>* p_list) const {
    if (_is_valid()) {
        kotlin_class->get_property_list(p_list);
    }
}

TypedArray<Dictionary> JvmScript::_get_script_property_list() const {
    TypedArray<Dictionary> ret;

    List<PropertyInfo> info_list;
    _get_script_property_info_list(&info_list);

    for (const PropertyInfo& info : info_list) {
        Dictionary info_as_dict = info;
        ret.append(info_as_dict);
    }

    return ret;
}

TypedArray<StringName> JvmScript::_get_members() const {
    TypedArray<StringName> ret;
#ifdef TOOLS_ENABLED
    List<PropertyInfo> exported_properties;
    get_script_exported_property_list(&exported_properties);
    for (const PropertyInfo& property : exported_properties) {
        ret.append(property.name);
    }
#endif // TOOLS_ENABLED
    return ret;
}

Dictionary JvmScript::_get_constants() const {
    return {};
}

// Variant is of type Dictionary
Variant JvmScript::_get_rpc_config() const {
    if (_is_valid()) { return kotlin_class->get_rpc_config(); }
    return Dictionary();
}

bool JvmScript::_has_static_method(const StringName& p_method) const {
    return false;
}

void JvmScript::_update_exports() {
#ifdef TOOLS_ENABLED
    update_script_exports();
#endif
}

#ifdef TOOLS_ENABLED

void JvmScript::get_script_exported_property_list(List<PropertyInfo>* p_list) const {
    List<PropertyInfo> all_properties;
    _get_script_property_info_list(&all_properties);

    p_list->push_back(PropertyInfo(Variant::NIL, _get_global_name(), PROPERTY_HINT_NONE, String(), PROPERTY_USAGE_CATEGORY));
    for (const PropertyInfo& property_info : all_properties) {
        if (property_info.usage & PropertyUsageFlags::PROPERTY_USAGE_EDITOR) {
            p_list->push_back(property_info);
        }
    }
}

TypedArray<Dictionary> JvmScript::_get_documentation() const {
    // TODO: Add ability to register documentation to Godot
    return {};
}

String JvmScript::_get_class_icon_path() const {
    // TODO: Add ability to register an icon to Godot
    return {};
}

StringName JvmScript::_get_doc_class_name() const {
    String class_name = get_global_name();
    if (class_name.is_empty()) {
        return get_path().get_file();
    }
    return class_name;
}

void* JvmScript::_placeholder_instance_create(GodotObject* p_for_object) const {
    JvmPlaceHolderInstance::JvmPlaceHolderInstanceData* placeholder_data = memnew(JvmPlaceHolderInstance::JvmPlaceHolderInstanceData);
    placeholder_data->language = GdjLanguage::get_instance();
    placeholder_data->script = Ref<Script>(this);
    placeholder_data->owner = p_for_object;

    GDExtensionScriptInstancePtr placeholder = internal::gdextension_interface_script_instance_create3(
      &JvmPlaceHolderInstance::jvm_placeholder_script_instance_info,
      placeholder_data
    );

    update_script_exports();// Update in case this method is called between the (re)loading and the delayed update_script_exports().

    List<PropertyInfo> exported_properties;
    get_script_exported_property_list(&exported_properties);
    JvmPlaceHolderInstance::update(placeholder_data, exported_properties, exported_members_default_value_cache);

    placeholders.insert(placeholder, placeholder_data);
    return placeholder;
}

void JvmScript::move_placeholders_to(JvmScript* p_script) {
    Vector<JvmPlaceHolderInstance::JvmPlaceHolderInstanceData*> current_placeholders;
    for (const KeyValue<GDExtensionScriptInstancePtr, JvmPlaceHolderInstance::JvmPlaceHolderInstanceData*>& entry : placeholders) {
        current_placeholders.append(entry.value);
    }

    for (JvmPlaceHolderInstance::JvmPlaceHolderInstanceData* placeholder : current_placeholders) {
        if (!placeholder->owner) { continue; }

        HashMap<StringName, Variant> values = placeholder->values;
        Object* owner {placeholder->owner.to_wrapper()};
        owner->set_script(Ref<Script>(p_script));
        for (const KeyValue<StringName, Variant>& value : values) {
            owner->set(value.key, value.value);
        }
    }
}

uint64_t JvmScript::get_last_source_modified_time() const {
    return last_source_modified_time;
}

void JvmScript::set_last_source_modified_time(uint64_t p_time) {
    last_source_modified_time = p_time;
    update_source_sync_warning();
}

void JvmScript::update_source_sync_warning() {
    for (const KeyValue<GDExtensionScriptInstancePtr, JvmPlaceHolderInstance::JvmPlaceHolderInstanceData*>& placeholder : placeholders) {
        if (Node* node = Object::cast_to<Node>(placeholder.value->owner.to_wrapper())) {
            node->update_configuration_warnings();
        }
    }
}

bool JvmScript::_editor_can_reload_from_file() {
    return true;
}

void JvmScript::update_script_exports() const {
    if (!export_dirty_flag) { return; }

    exported_members_default_value_cache.clear();
    if (!_is_valid() || kotlin_class->is_abstract || !kotlin_class->can_zero_init()) {
        export_dirty_flag = false;
        return;
    }

    GodotObject* tmp_object = _object_create();
    ERR_FAIL_NULL(tmp_object);
    auto* instance_data = reinterpret_cast<JvmInstance::JvmInstanceData*>(
      internal::gdextension_interface_object_get_script_instance(
        tmp_object,
        _get_language()->_owner
      )
    );

    List<PropertyInfo> exported_properties;
    get_script_exported_property_list(&exported_properties);

    for (auto& exported_property : exported_properties) {
        Variant default_value;
        const String& property_name {exported_property.name};

        if (exported_property.type != Variant::OBJECT) {
            JvmInstance::get_or_default(instance_data, property_name, default_value);
            JVM_DEV_VERBOSE(
              "Get default value for %s property from %s: %s",
              exported_property.name,
              kotlin_class->registered_class_name,
              default_value.stringify()
            );
        }
        exported_members_default_value_cache[property_name] = default_value;
    }

    for (const KeyValue<GDExtensionScriptInstancePtr, JvmPlaceHolderInstance::JvmPlaceHolderInstanceData*>& placeholder : placeholders) {
        JvmPlaceHolderInstance::update(placeholder.value, exported_properties, exported_members_default_value_cache);
    }

    jni::Env env = jni::Jvm::current_env();
    MemoryManager::get_instance().direct_object_deletion(env, tmp_object);
    export_dirty_flag = false;
}

void JvmScript::_placeholder_erased(void* p_placeholder) {
    placeholders.erase(p_placeholder);
}

void JvmScript::_format_template(const String& p_path) const {}

void JvmScript::_set_path_cache(const String& p_path) const {
    Resource::_set_path_cache(p_path);
    _format_template(p_path);
}

#endif

JvmScript::JvmScript() : kotlin_class(nullptr) {}

JvmScript::~JvmScript() {
#ifdef TOOLS_ENABLED
    JvmScriptManager::untrack_physical_script(this);
    exported_members_default_value_cache.clear();
#endif
    delete kotlin_class;
    kotlin_class = nullptr;
}

#if 0 // Legacy source-script hierarchy replaced by JvmScript's FQCN reconciliation.
StringName SourceScript::parse_source_to_fqdn(const String& p_path, String& r_source, Error* r_error) {
    String source;
    *r_error = JvmResourceFormatLoader::read_all_file_utf8(p_path, source);
    r_source = source;

#ifdef TOOLS_ENABLED
    static String package_keyword { PACKAGE_KEYWORD };
    static int64_t package_keyword_size { package_keyword.length() };

    int64_t initial_start_index = 0;
    while (skip_comments(source, p_path, initial_start_index) || skip_spaces_and_newlines(source, initial_start_index)) {}

    int64_t package_keyword_index { source.find(package_keyword, initial_start_index) };

    String package_name;
    if (package_keyword_index != -1) {
        int64_t package_start_index = package_keyword_index + package_keyword_size - 1;

        while (skip_comments(source, p_path, package_start_index) || skip_spaces_and_newlines(source, package_start_index)) {}

        char32_t next_character = source[package_start_index];
        int64_t package_end_index = package_start_index;
        while (package_end_index < source.length() && !is_package_end(next_character)) {
            next_character = source[++package_end_index];
        }

        package_name = source.substr(package_start_index, package_end_index - package_start_index);
    }

    static String register_class_annotation { REGISTER_CLASS_ANNOTATION };
    static int64_t register_class_annotation_size { register_class_annotation.length() };
    int64_t register_class_search_start = package_keyword_index == -1 ? 0 : package_keyword_index;

    while (skip_comments(source, p_path, register_class_search_start) || skip_spaces_and_newlines(source, register_class_search_start)) {}

    int64_t register_class_index { source.find(register_class_annotation, register_class_search_start) };

    if (register_class_index == -1) {
        return {};
    }

    int64_t class_search_start_index = register_class_index + register_class_annotation_size - 1;

    while (skip_comments(source, p_path, class_search_start_index) || skip_spaces_and_newlines(source, class_search_start_index)) {}

    char32_t next_character = source[class_search_start_index];
    if (next_character == U'(') {
        next_character = source[++class_search_start_index];

        while (class_search_start_index < source.length() && next_character != U')') {
            next_character = source[++class_search_start_index];
        }

        while (class_search_start_index < source.length() && next_character == U')') {
            ++class_search_start_index;
            while (skip_comments(source, p_path, class_search_start_index) || skip_spaces_and_newlines(source, class_search_start_index)) {}
            next_character = source[class_search_start_index];
        }
    }

    while (skip_comments(source, p_path, class_search_start_index) || skip_spaces_and_newlines(source, class_search_start_index)) {}

    static String class_keyword { CLASS_KEYWORD };
    static int64_t class_keyword_size { class_keyword.length() };
    int64_t class_keyword_index { source.find(class_keyword, class_search_start_index) };

    if (class_keyword_index == -1) {
        JVM_LOG_WARNING(vformat("Cannot find class declaration in %s", p_path));
        return {};
    }

    int64_t class_start_index = class_keyword_index + class_keyword_size - 1;

    while (skip_comments(source, p_path, class_start_index) || skip_spaces_and_newlines(source, class_start_index)) {}

    next_character = source[class_start_index];
    int64_t class_end_index = class_start_index;
    while (class_end_index < source.length() && !is_class_name_end(next_character)) {
        next_character = source[++class_end_index];
    }

    String class_name { source.substr(class_start_index, class_end_index - class_start_index) };

    if (package_name.is_empty()) {
        return class_name;
    }

    return vformat("%s.%s", package_name, class_name);
#else
    return source;
#endif
}

StringName SourceScript::get_functional_name() const {
    return _functional_name;
}


StringName SourceScript::_get_global_name() const {
    return {};
}
//
bool SourceScript::is_whitespace_or_linebreak(char32_t character) {
    return is_whitespace(character) || is_linebreak(character);
}

bool SourceScript::is_package_end(char32_t character) {
    return is_whitespace_or_linebreak(character) || character == U';' || character == U'/';
}

bool SourceScript::is_class_name_end(char32_t character) {
    return is_whitespace_or_linebreak(character) ||
           character == U':' ||
           character == U'{' ||
           character == U'<' ||
           character == U'[' ||
           character == U'(' ||
           character == U'/';
}

bool SourceScript::skip_spaces_and_newlines(const String& source, int64_t& start_index) {
    int64_t initial_index = start_index;
    char32_t next_character = source[start_index];

    while (start_index < source.length() && is_whitespace_or_linebreak(next_character)) {
        next_character = source[++start_index];
    }

    return start_index != initial_index;
}

bool SourceScript::skip_comments(const String& source, const String& p_path, int64_t& start_index) {
    char32_t next_character = source[start_index];

    if (next_character != U'/') {
        return false;
    }

    bool isLineComment = false;
    bool isMultilineComment = false;
    if (start_index < source.length() - 1) {
        next_character = source[++start_index];

        isLineComment = next_character == U'/';
        isMultilineComment = next_character == U'*';
    }

    if (!isLineComment && !isMultilineComment) {
        JVM_LOG_WARNING(vformat("Cannot parse %s, found unexpected '/' character", p_path));
    }

    if (isLineComment) {
        while (start_index < source.length() && !is_linebreak(next_character)) {
            next_character = source[++start_index];
        }
    }

    if (isMultilineComment) {
        while (start_index < source.length()) {
            bool isCommentEnd = next_character == U'*';
            next_character = source[++start_index];

            if (start_index == source.length()) {
                JVM_LOG_WARNING(vformat("Cannot parse %s, found unclosed multiline comment", p_path));
            }

            isCommentEnd = isCommentEnd && next_character == U'/';

            if (isCommentEnd) {
                ++start_index;
                break;
            }
        }
    }

    return true;
}

NamedScript::~NamedScript() {
    // The named script is the one that should delete the KtClass as its existence is guaranteed unlike its path based twin.
    delete kotlin_class;
}

StringName NamedScript::_get_global_name() const {
    if (_is_valid()) { return kotlin_class->registered_class_name; }
    // Scripts are either (valid and loaded from .jar) or (placeholders and loaded from path scripts) Even in the case of an invalid file, we can then use its path to find the right name.
    String path = get_path();
    return get_script_file_name(path);
}

#endif

void JvmScript::_bind_methods() {
    ClassDB::bind_method(D_METHOD("new"), &JvmScript::_new);
}
