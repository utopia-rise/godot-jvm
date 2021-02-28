#include <editor/editor_node.h>
#include <modules/kotlin_jvm/src/kotlin_editor_export_plugin.h>
#include "register_types.h"

#include "src/kotlin_language.h"
#include "src/kotlin_script.h"
#include "src/kt_resource_format_loader.h"
#include "src/kt_resource_format_saver.h"

Ref<KtResourceFormatLoader> resource_format_loader;
Ref<KtResourceFormatSaver> resource_format_saver;

static void editor_init() {
    Ref<KotlinEditorExportPlugin> export_plugin;
    export_plugin.instance();
    EditorExport::get_singleton()->add_export_plugin(export_plugin);
}

void register_kotlin_jvm_types() {
    ClassDB::register_class<KotlinScript>();
    ScriptServer::register_language(&KotlinLanguage::get_instance());
    resource_format_loader.instance();
    ResourceLoader::add_resource_format_loader(resource_format_loader);
    resource_format_saver.instance();
    ResourceSaver::add_resource_format_saver(resource_format_saver);

    EditorNode::add_init_callback(editor_init);
}

void unregister_kotlin_jvm_types() {
    ScriptServer::unregister_language(&KotlinLanguage::get_instance());
    ResourceLoader::remove_resource_format_loader((resource_format_loader));
    ResourceSaver::remove_resource_format_saver(resource_format_saver);
    resource_format_loader.unref();
    resource_format_saver.unref();
}
