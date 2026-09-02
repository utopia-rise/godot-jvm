#ifdef TOOLS_ENABLED
#include "editor/godot_jvm_editor.h"
#include "editor/export/godot_jvm_editor_export_plugin.h"
#include "editor/jvm_syntax_highlighter.h"

#include <classes/editor_export_plugin.hpp>
#include <classes/editor_interface.hpp>
#include <classes/editor_plugin_registration.hpp>
#include <classes/script_editor.hpp>
#endif

#include "api/language/gdj_language.h"
#include "api/language/java_language.h"
#include "api/language/jvm_language.h"
#include "api/language/kotlin_language.h"
#include "api/language/scala_language.h"
#include "api/resource_format/java_archive.h"
#include "api/resource_format/java_archive_resource_format_loader.h"
#include "api/resource_format/jvm_resource_format_loader.h"
#include "api/resource_format/jvm_resource_format_saver.h"
#include "api/script/jvm_script.h"
#include "api/script/jvm_script_manager.h"
#include "api/script/language/gdj_script.h"
#include "api/script/language/java_script.h"
#include "api/script/language/kotlin_script.h"
#include "api/script/language/scala_script.h"
#include "core/variant_allocator.h"
#include "engine/godot_object.h"
#include "godot_jvm.h"
#include "logging.h"
#include "register_types.h"

#include <classes/engine.hpp>
#include <classes/resource_format_loader.hpp>
#include <classes/resource_loader.hpp>
#include <classes/resource_saver.hpp>


Ref<JvmResourceFormatLoader> resource_format_loader;
Ref<JvmResourceFormatSaver> resource_format_saver;
Ref<JavaArchiveFormatLoader> java_archive_format_loader;

void initialize_godot_jvm_library(ModuleInitializationLevel p_level) {
    if (p_level == MODULE_INITIALIZATION_LEVEL_SERVERS) {
        // Configure phase: one-time setup for globals that need godot-cpp's GDExtension interface to be ready (populated by GDExtensionBinding::InitObject, already run by this point — this function is only ever reached via that object's registered...
        configure_logging();
        VariantAllocator::configure();
        raw_godot::configure_core();

        GDREGISTER_ABSTRACT_CLASS(JvmScript);
        GDREGISTER_CLASS(GdjScript);
        GDREGISTER_CLASS(KotlinScript);
        GDREGISTER_CLASS(JavaScript);
        GDREGISTER_CLASS(ScalaScript);
        // JvmScriptManager::get_instance() does memnew(JvmScriptManager) — same memnew()-requires-ClassDB-registration requirement as everything else here.
        GDREGISTER_INTERNAL_CLASS(JvmScriptManager);
        GDREGISTER_INTERNAL_CLASS(JavaArchive);

        GDREGISTER_ABSTRACT_CLASS(JvmLanguage);
        GDREGISTER_INTERNAL_CLASS(GdjLanguage);
        GDREGISTER_INTERNAL_CLASS(KotlinLanguage);
        GDREGISTER_INTERNAL_CLASS(JavaLanguage);
        GDREGISTER_INTERNAL_CLASS(ScalaLanguage);

        Engine::get_singleton()->register_script_language(GdjLanguage::get_instance());
        Engine::get_singleton()->register_script_language(KotlinLanguage::get_instance());
        Engine::get_singleton()->register_script_language(JavaLanguage::get_instance());
        Engine::get_singleton()->register_script_language(ScalaLanguage::get_instance());
    }

    // ResourceLoader/ResourceSaver aren't registered as engine singletons yet at SERVERS level (Engine::get_singleton_object("ResourceLoader") returns null there) — SCENE level is the earliest point they're guaranteed to exist for a GDExtension.
    if (p_level == MODULE_INITIALIZATION_LEVEL_SCENE) {
        raw_godot::configure_scene();

        GDREGISTER_INTERNAL_CLASS(JvmResourceFormatLoader);
        GDREGISTER_INTERNAL_CLASS(JvmResourceFormatSaver);
        GDREGISTER_INTERNAL_CLASS(JavaArchiveFormatLoader);

        resource_format_loader.instantiate();
        ResourceLoader::get_singleton()->add_resource_format_loader(resource_format_loader);
        resource_format_saver.instantiate();
        ResourceSaver::get_singleton()->add_resource_format_saver(resource_format_saver);

        java_archive_format_loader.instantiate();
        ResourceLoader::get_singleton()->add_resource_format_loader(java_archive_format_loader);
    }

#ifdef TOOLS_ENABLED
    if (p_level == MODULE_INITIALIZATION_LEVEL_EDITOR) {
        GDREGISTER_INTERNAL_CLASS(JvmStandardSyntaxHighlighter);
        // Actual ScriptEditor::register_syntax_highlighter() call lives in GodotJvmEditor::_notification(NOTIFICATION_ENTER_TREE) — ScriptEditor isn't guaranteed to exist yet at MODULE_INITIALIZATION_LEVEL_EDITOR (crashes with a null-pointer acces...
        GDREGISTER_INTERNAL_CLASS(GodotJvmEditor);
        GDREGISTER_INTERNAL_CLASS(GodotJvmEditorExportPlugin);
        EditorPlugins::add_by_type<GodotJvmEditor>();
    }
#endif
}

void uninitialize_godot_jvm_library(ModuleInitializationLevel p_level) {
    if (p_level != MODULE_INITIALIZATION_LEVEL_SCENE) { return; }

    GodotJvm::get_instance().finalize_down_to(GodotJvm::State::NOT_STARTED);

    ResourceLoader::get_singleton()->remove_resource_format_loader(java_archive_format_loader);
    ResourceLoader::get_singleton()->remove_resource_format_loader(resource_format_loader);
    ResourceSaver::get_singleton()->remove_resource_format_saver(resource_format_saver);
    java_archive_format_loader.unref();
    resource_format_loader.unref();
    resource_format_saver.unref();

    JavaLanguage* java_language {JavaLanguage::get_instance()};
    Engine::get_singleton()->unregister_script_language(java_language);
    memdelete(java_language);

    KotlinLanguage* kotlin_language {KotlinLanguage::get_instance()};
    Engine::get_singleton()->unregister_script_language(kotlin_language);
    memdelete(kotlin_language);

    ScalaLanguage* scala_language {ScalaLanguage::get_instance()};
    Engine::get_singleton()->unregister_script_language(scala_language);
    memdelete(scala_language);

    JvmLanguage* jvm_language {GdjLanguage::get_instance()};
    Engine::get_singleton()->unregister_script_language(jvm_language);
    memdelete(jvm_language);
}


extern "C" {
// Godot resolves this by its plain (non-mangled) name via GetProcAddress/dlsym, matching entry_symbol in jvm.gdextension — without extern "C" it's exported C++-mangled and Godot's lookup fails with "procedure not found".
GDExtensionBool GDE_EXPORT
godot_jvm_library_init(GDExtensionInterfaceGetProcAddress p_get_proc_address, GDExtensionClassLibraryPtr p_library, GDExtensionInitialization *r_initialization) {
    GDExtensionBinding::InitObject init_obj(p_get_proc_address, p_library, r_initialization);

    init_obj.register_initializer(initialize_godot_jvm_library);
    init_obj.register_terminator(uninitialize_godot_jvm_library);
    init_obj.set_minimum_library_initialization_level(MODULE_INITIALIZATION_LEVEL_CORE);

    return init_obj.init();
}
}
