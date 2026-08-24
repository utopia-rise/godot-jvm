#include "jvm_script_manager.h"

#include "api/language/names.h"
#include "api/script/language/gdj_script.h"
#include "api/script/language/java_script.h"
#include "api/script/language/kotlin_script.h"
#include "api/script/language/scala_script.h"
#include "jvm/wrapper/memory/type_manager.h"

#include <classes/file_access.hpp>
#include <classes/time.hpp>
#include <variant/utility_functions.hpp>
#include "engine/utilities.h"

using namespace godot;

JvmScriptManager* JvmScriptManager::singleton = nullptr;

namespace {
Ref<JvmScript> create_script_for_extension(const String& p_extension) {
    const String extension = p_extension.to_lower();
    if (extension == GODOT_KOTLIN_SCRIPT_EXTENSION) {
        Ref<KotlinScript> script;
        script.instantiate();
        return script;
    } else if (extension == GODOT_JAVA_SCRIPT_EXTENSION) {
        Ref<JavaScript> script;
        script.instantiate();
        return script;
    } else if (extension == GODOT_SCALA_SCRIPT_EXTENSION) {
        Ref<ScalaScript> script;
        script.instantiate();
        return script;
    } else if (extension == GODOT_JVM_REGISTRATION_FILE_EXTENSION) {
        Ref<GdjScript> script;
        script.instantiate();
        return script;
    } else {
        JVM_ERR_FAIL_V_MSG({}, vformat("Unsupported JVM script extension: %s", extension));
    }
    return {};
}
} // namespace

JvmScriptManager* JvmScriptManager::get_instance() {
    if (!singleton) { singleton = memnew(JvmScriptManager); }
    return singleton;
}

void JvmScriptManager::finalize() {
    JvmScriptManager* manager = singleton;
    singleton = nullptr;
    memdelete(manager);
}

Ref<JvmScript> JvmScriptManager::get_script_from_fqdn(const StringName& p_fqdn) const {
    if (const HashMap<StringName, Ref<WeakRef>>::ConstIterator script = fqdn_to_script.find(p_fqdn)) {
        return script->value->get_ref();
    }
    return {};
}

void JvmScriptManager::set_script_for_fqdn(const StringName& p_fqdn, JvmScript* p_script) {
    // godot-cpp's WeakRef exposes no set_obj(); UtilityFunctions::weakref() is the only
    // GDExtension-accessible way to construct a populated WeakRef.
    fqdn_to_script[p_fqdn] = UtilityFunctions::weakref(p_script);
}

Ref<JvmScript> JvmScriptManager::get_script_from_registered_name(const StringName& p_name) const {
    const HashMap<StringName, Ref<JvmScript>>::ConstIterator script = registered_name_to_script.find(p_name);
    return script ? script->value : Ref<JvmScript>();
}

Ref<JvmScript> JvmScriptManager::create_virtual_script(KtClass* p_kotlin_class) {
    const String extension = p_kotlin_class->source_file_name.is_empty()
      ? GODOT_JVM_REGISTRATION_FILE_EXTENSION
      : p_kotlin_class->source_file_name.get_extension().to_lower();
    Ref<JvmScript> script = create_script_for_extension(extension);
    script->take_over_path(String(GODOT_JVM_VIRTUAL_PATH_PREFIX) + String(p_kotlin_class->registered_class_name) + "." + extension);
    script->kotlin_class = p_kotlin_class;

    registered_name_to_script[p_kotlin_class->registered_class_name] = script;
    set_script_for_fqdn(p_kotlin_class->fqdn, script.ptr());
    JVM_DEV_VERBOSE("JVM Script created: %s", p_kotlin_class->registered_class_name);
    return script;
}

#ifdef TOOLS_ENABLED
void JvmScriptManager::update_script(JvmScript* p_script, KtClass* p_kotlin_class) {
    p_script->kotlin_class = p_kotlin_class;
    p_script->export_dirty_flag = true;
    registered_name_to_script[p_kotlin_class->registered_class_name] = Ref<JvmScript>(p_script);
    set_script_for_fqdn(p_kotlin_class->fqdn, p_script);
}
#endif

void JvmScriptManager::initialize_scripts(const Vector<KtClass*>& p_classes) {
#ifdef TOOLS_ENABLED
    last_jar_modified_time = static_cast<uint64_t>(Time::get_singleton()->get_unix_time_from_system());
    registered_name_to_script.clear();
    fqdn_to_class_index.clear();

    for (const KeyValue<StringName, Ref<WeakRef>>& entry : fqdn_to_script) {
        Ref<JvmScript> script = entry.value->get_ref();
        if (script.is_valid()) {
            delete script->kotlin_class;
            script->kotlin_class = nullptr;
        }
    }
#endif

    JVM_DEV_LOG("Loading JVM Scripts...");
    jni::Env env {jni::Jvm::current_env()};
    int class_index = 0;
    for (KtClass* kotlin_class : p_classes) {
        Ref<JvmScript> script;
#ifdef TOOLS_ENABLED
        fqdn_to_class_index[kotlin_class->fqdn] = class_index;
        script = get_script_from_fqdn(kotlin_class->fqdn);
        if (script.is_valid()) {
            update_script(script.ptr(), kotlin_class);
        } else
#endif
        {
            script = create_virtual_script(kotlin_class);
        }
        TypeManager::get_instance().assign_script_to_class(env, class_index++, script);
    }

#ifdef TOOLS_ENABLED
    Vector<StringName> dead_fqdns;
    for (const KeyValue<StringName, Ref<WeakRef>>& entry : fqdn_to_script) {
        if (entry.value->get_ref().get_type() == Variant::NIL) { dead_fqdns.append(entry.key); }
    }
    for (const StringName& fqdn : dead_fqdns) { fqdn_to_script.erase(fqdn); }
    callable_mp(this, &JvmScriptManager::update_all_scripts).call_deferred();
#endif
    JVM_DEV_LOG("JVM scripts are now loaded.");
}

#ifdef TOOLS_ENABLED
void JvmScriptManager::update_all_scripts() {
    for (const KeyValue<StringName, Ref<WeakRef>>& entry : fqdn_to_script) {
        Ref<JvmScript> script = entry.value->get_ref();
        if (script.is_null()) { continue; }

        if (script->_is_valid()) { script->update_script_exports(); }
        script->update_source_sync_warning();
    }
}

uint64_t JvmScriptManager::get_last_jar_modified_time() const { return last_jar_modified_time; }
#endif

Ref<JvmScript> JvmScriptManager::create_and_bind_physical_script(const String& p_path, const StringName& p_fqdn) {
    Ref<JvmScript> script;
    if (!p_fqdn.is_empty()) {
        script = get_script_from_fqdn(p_fqdn);
        if (script.is_valid()) {
#ifdef TOOLS_ENABLED
            const String existing_path = script->get_path();
            if (!existing_path.begins_with(GODOT_JVM_VIRTUAL_PATH_PREFIX) && existing_path != p_path && FileAccess::file_exists(existing_path)) {
                JVM_ERR_FAIL_V_MSG({}, vformat(
                  "JVM script %s is already associated with physical file %s and cannot also use %s.",
                  p_fqdn,
                  existing_path,
                  p_path
                ));
            }
#endif
        }
    }

#ifdef TOOLS_ENABLED
    if (script.is_null()) { script = create_script_for_extension(p_path.get_extension()); }
    script->last_physical_fqdn = p_fqdn;
    if (!p_fqdn.is_empty()) { set_script_for_fqdn(p_fqdn, script.ptr()); }
#endif
    return script;
}

#ifdef TOOLS_ENABLED
void JvmScriptManager::replace_virtual_script(JvmScript* p_physical_script, JvmScript* p_virtual_script) {
    p_physical_script->kotlin_class = p_virtual_script->kotlin_class;
    p_virtual_script->kotlin_class = nullptr;
    p_physical_script->export_dirty_flag = true;
    p_virtual_script->move_placeholders_to(p_physical_script);

    const StringName fqdn = p_physical_script->last_physical_fqdn;
    registered_name_to_script[p_physical_script->kotlin_class->registered_class_name] = Ref<JvmScript>(p_physical_script);
    set_script_for_fqdn(fqdn, p_physical_script);

    const HashMap<StringName, int>::ConstIterator class_index = fqdn_to_class_index.find(fqdn);
    if (class_index) {
        jni::Env env {jni::Jvm::current_env()};
        TypeManager::get_instance().assign_script_to_class(env, class_index->value, Ref<JvmScript>(p_physical_script));
    }
}

void JvmScriptManager::update_physical_script(JvmScript* p_script, const StringName& p_fqdn) {
    if (p_script->last_physical_fqdn == p_fqdn
        && (p_fqdn.is_empty() || get_script_from_fqdn(p_fqdn).ptr() == p_script)) {
        return;
    }

    if (!p_script->last_physical_fqdn.is_empty() && get_script_from_fqdn(p_script->last_physical_fqdn).ptr() == p_script) {
        fqdn_to_script.erase(p_script->last_physical_fqdn);
    }

    if (p_script->kotlin_class && p_script->kotlin_class->fqdn != p_fqdn) {
        KtClass* kotlin_class = p_script->kotlin_class;
        p_script->kotlin_class = nullptr;
        const HashMap<StringName, int>::ConstIterator class_index = fqdn_to_class_index.find(kotlin_class->fqdn);
        Ref<JvmScript> virtual_script = create_virtual_script(kotlin_class);
        if (class_index) {
            jni::Env env {jni::Jvm::current_env()};
            TypeManager::get_instance().assign_script_to_class(env, class_index->value, virtual_script);
        }
    }

    p_script->last_physical_fqdn = p_fqdn;
    if (p_fqdn.is_empty()) { return; }

    Ref<JvmScript> existing = get_script_from_fqdn(p_fqdn);
    if (existing.is_valid() && existing.ptr() != p_script
        && !existing->get_path().begins_with(GODOT_JVM_VIRTUAL_PATH_PREFIX)
        && FileAccess::file_exists(existing->get_path())) {
        ERR_PRINT(vformat(
          "JVM script %s is already associated with physical file %s and cannot also use %s.",
          p_fqdn,
          existing->get_path(),
          p_script->get_path()
        ));
        return;
    }
    if (existing.is_valid() && existing.ptr() != p_script && existing->kotlin_class
        && existing->get_path().begins_with(GODOT_JVM_VIRTUAL_PATH_PREFIX)) {
        replace_virtual_script(p_script, existing.ptr());
    } else {
        set_script_for_fqdn(p_fqdn, p_script);
    }
}

void JvmScriptManager::untrack_physical_script(JvmScript* p_script) {
    if (singleton && !p_script->last_physical_fqdn.is_empty()
        && singleton->get_script_from_fqdn(p_script->last_physical_fqdn).ptr() == p_script) {
        singleton->fqdn_to_script.erase(p_script->last_physical_fqdn);
    }
}
#endif
