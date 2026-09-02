#include "godot_jvm_editor.h"

#include "editor/build/gradle_task_runner.h"
#include "editor/export/godot_jvm_editor_export_plugin.h"
#include "editor/jvm_syntax_highlighter.h"
#include "engine/godot_object.h"
#include "godot_jvm.h"
#include "paths.h"
#include "project/project_generator.h"
#include "strings.h"

#include <classes/accept_dialog.hpp>
#include <classes/button.hpp>
#include <classes/editor_file_system.hpp>
#include <classes/editor_interface.hpp>
#include <classes/engine.hpp>
#include <classes/file_access.hpp>
#include <classes/popup_menu.hpp>
#include <classes/project_settings.hpp>
#include <classes/script_editor.hpp>
#include <classes/theme.hpp>

using namespace godot;

void GodotJvmEditor::on_menu_option_pressed(int option_id) {
    switch (option_id) {
        case GENERATE_PROJECT:
            project_dialog->popup_centered();
            break;
        case ABOUT:
            about_dialog->popup_centered();
            break;
    }
}

void GodotJvmEditor::on_generate_project(bool erase_existing) {
    ProjectGenerator::generate_jvm_files(erase_existing);
    get_editor_interface()->get_resource_filesystem()->scan();
    project_dialog->hide();
}

void GodotJvmEditor::on_gradle_task_pressed() {
    if (GradleTaskRunner::get_instance().is_task_started()) { return; }
    task_dialog_make_appear(task_dialog);
    String log;

    GradleTaskRunner::get_instance().run_task(tool_bar_gradle_task_choice->get_selected_id(), log, false);
    JVM_LOG_INFO(log);
}

void GodotJvmEditor::on_filesystem_change() {
    if (GodotJvm::get_instance().state == GodotJvm::State::JVM_SCRIPTS_INITIALIZED) { return; }

    if (GodotJvm::get_instance().state == GodotJvm::State::JVM_STARTED) {
        String bootstrap {String(RES_DIRECTORY).path_join(BOOTSTRAP_FILE)};
        if (FileAccess::file_exists(bootstrap)) {
            GodotJvm::get_instance().initialize_up_to(GodotJvm::State::JVM_SCRIPTS_INITIALIZED);
        }
    }
}

void GodotJvmEditor::update_jvm_status(bool force) {
    GodotJvm::State state = GodotJvm::get_instance().state;
    if (!force && displayed_jvm_state == state) { return; }

    displayed_jvm_state = state;

    StringName icon;
    String label;
    switch (state) {
        case GodotJvm::State::NOT_STARTED:
            icon = SNAME("StatusError");
            label = "JVM not started";
            break;
        case GodotJvm::State::JVM_LIBRARY_LOADED:
            icon = SNAME("StatusWarning");
            label = "JVM not started";
            break;
        case GodotJvm::State::JVM_STARTED:
            icon = SNAME("StatusWarning");
            label = "Bootstrap not loaded";
            break;
        case GodotJvm::State::BOOTSTRAP_LOADED:
            icon = SNAME("StatusWarning");
            label = "Core not initialized";
            break;
        case GodotJvm::State::CORE_LIBRARY_INITIALIZED:
            icon = SNAME("StatusWarning");
            label = "Engine types not initialized";
            break;
        case GodotJvm::State::ENGINE_TYPES_INITIALIZED:
            icon = SNAME("StatusWarning");
            label = "User code not loaded";
            break;
        case GodotJvm::State::JVM_SCRIPTS_INITIALIZED:
            icon = SNAME("StatusSuccess");
            label = "Ready";
            break;
        default:
            return;
    }

    jvm_status_light->set_texture(get_editor_interface()->get_editor_theme()->get_icon(icon, SNAME("EditorIcons")));
    jvm_status_light->set_tooltip_text("JVM status: " + label);
}

bool GodotJvmEditor::_build() {
    bool build_gradle_before_start = editor_settings->get_setting(BUILD_BEFORE_START);

    if (build_gradle_before_start) {
        String log;
        Error error = GradleTaskRunner::get_instance().run_task(GradleTaskRunner::Task::BUILD_DEBUG, log, true);

        if (error != OK) { JVM_ERR_FAIL_V_MSG(false, log); }
        JVM_LOG_INFO(log);
    }
    return true;
}

void GodotJvmEditor::_notification(int notification) {
    if (!Engine::get_singleton()->is_editor_hint()) { return; }

    Control* editor_base_control = get_editor_interface()->get_base_control();
    ProjectSettings* project_settings = ProjectSettings::get_singleton();

    switch (notification) {
        case NOTIFICATION_ENTER_TREE:
            editor_scale = get_editor_interface()->get_editor_scale();
            editor_settings = get_editor_interface()->get_editor_settings();

            if (!editor_settings->has_setting(BUILD_BEFORE_START)) { editor_settings->set_setting(BUILD_BEFORE_START, false); }
            editor_settings->set_initial_value(BUILD_BEFORE_START, false, false);

            if (!editor_settings->has_setting(SHOW_INFO_ON_START)) { editor_settings->set_setting(SHOW_INFO_ON_START, true); }
            editor_settings->set_initial_value(SHOW_INFO_ON_START, true, false);

            about_dialog = create_about_dialog(editor_settings, editor_scale);
            task_dialog = create_task_dialog(editor_scale);

            if (!project_settings->has_setting(GRADLE_DIR)) { project_settings->set_setting(GRADLE_DIR, "res://"); }
            // Not PropertyInfo's own operator Dictionary(): that always includes a "usage" key, which add_property_info() explicitly doesn't support (ProjectSettings::_add_property_info_bind warns and ignores it otherwise) — build the dictionary with...
            {
                Dictionary gradle_dir_property_info;
                gradle_dir_property_info["name"] = GRADLE_DIR;
                gradle_dir_property_info["type"] = Variant::STRING;
                gradle_dir_property_info["hint"] = PROPERTY_HINT_GLOBAL_DIR;
                gradle_dir_property_info["hint_string"] = "";
                project_settings->add_property_info(gradle_dir_property_info);
            }
            project_settings->set_as_basic(GRADLE_DIR, true);
            project_settings->set_initial_value(GRADLE_DIR, "res://");

            project_dialog->set_title("JVM project generation");
            project_dialog->set_text(generate_project);

            project_dialog->get_ok_button()->set_text(generate_missing);
            project_dialog->get_ok_button()->connect("pressed", callable_mp(this, &GodotJvmEditor::on_generate_project).bind(false));
            project_dialog->add_button(generate_all)
              ->connect("pressed", callable_mp(this, &GodotJvmEditor::on_generate_project).bind(true));
            project_dialog->add_cancel_button(generate_nothing);

            about_pop_menu->hide();
            about_pop_menu->connect(SNAME("id_pressed"), callable_mp(this, &GodotJvmEditor::on_menu_option_pressed));
            about_pop_menu->add_item("Generate JVM project", GENERATE_PROJECT);
            about_pop_menu->add_item("About Godot-JVM", ABOUT);
            add_tool_submenu_item("Kotlin/JVM", about_pop_menu);

            add_control_to_container(CustomControlContainer::CONTAINER_TOOLBAR, separator);

            tool_bar_gradle_task_choice->set_flat(true);
            tool_bar_gradle_task_choice->add_item("Build", GradleTaskRunner::Task::BUILD_DEBUG);
            tool_bar_gradle_task_choice->add_item("Fast Build", GradleTaskRunner::Task::FAST_BUILD);
            tool_bar_gradle_task_choice->add_item("Build Release", GradleTaskRunner::Task::BUILD_RELEASE);
            tool_bar_gradle_task_choice->add_item("Build Android", GradleTaskRunner::Task::BUILD_ANDROID_DEBUG);
            tool_bar_gradle_task_choice->add_item("Build Android Release", GradleTaskRunner::Task::BUILD_ANDROID_RELEASE);
            tool_bar_gradle_task_choice->add_item("Build iOS", GradleTaskRunner::Task::BUILD_IOS_DEBUG);
            tool_bar_gradle_task_choice->add_item("Build iOS Release", GradleTaskRunner::Task::BUILD_IOS_RELEASE);
            tool_bar_gradle_task_choice->add_item("Build Graal Native Image", GradleTaskRunner::Task::BUILD_GRAAL_NATIVE_IMAGE_DEBUG);
            tool_bar_gradle_task_choice->add_item("Build Graal Native Image Release", GradleTaskRunner::Task::BUILD_GRAAL_NATIVE_IMAGE_RELEASE);
            tool_bar_gradle_task_choice->add_item("Generate JRE", GradleTaskRunner::Task::GENERATE_EMBEDDED_JVM);
            tool_bar_gradle_task_choice->select(GradleTaskRunner::Task::BUILD_DEBUG);
            tool_bar_gradle_task_choice->set_fit_to_longest_item(false);
            add_control_to_container(CustomControlContainer::CONTAINER_TOOLBAR, tool_bar_gradle_task_choice);

            tool_bar_gradle_task_button->set_text("Run Gradle");
            tool_bar_gradle_task_button->set_tooltip_text("Run the selected Gradle task");
            tool_bar_gradle_task_button->set_focus_mode(Control::FOCUS_NONE);
            tool_bar_gradle_task_button->connect(SNAME("pressed"), callable_mp(this, &GodotJvmEditor::on_gradle_task_pressed));
            add_control_to_container(CustomControlContainer::CONTAINER_TOOLBAR, tool_bar_gradle_task_button);

            jvm_status_light->set_stretch_mode(TextureRect::STRETCH_KEEP_ASPECT_CENTERED);
            add_control_to_container(CustomControlContainer::CONTAINER_TOOLBAR, jvm_status_light);
            update_jvm_status(true);

            editor_base_control->add_child(task_dialog.dialog);
            editor_base_control->add_child(about_dialog);
            show_about_dialog_if_configured(about_dialog, editor_settings);
            editor_base_control->add_child(project_dialog);

            get_editor_interface()->get_resource_filesystem()->connect(
              SNAME("filesystem_changed"),
              callable_mp(this, &GodotJvmEditor::on_filesystem_change)
            );
            set_process(true);

            // Instantiating these at NOTIFICATION_ENTER_TREE (once the engine has actually added this plugin to the tree) rather than eagerly during static extension registration — constructing UI-adjacent Wrapped objects that early crashes, since the...
            export_plugin.instantiate();
            add_export_plugin(export_plugin);

            syntax_highlighter.instantiate();
            get_editor_interface()->get_script_editor()->register_syntax_highlighter(syntax_highlighter);

            break;

        case NOTIFICATION_PROCESS:
            update_jvm_status();

            if (GradleTaskRunner::get_instance().is_task_started()) {
                String log;
                String error;
                GradleTaskRunner::get_instance().get_task_output(log, error);
                task_dialog_update_state(task_dialog, log + error);

                if (!log.is_empty()) {
                    // We are streaming the output, we use the regular Godot print to avoid spamming the JVM prefix.
                    print_line(log);
                }
                if (!error.is_empty()) { JVM_ERR_FAIL_MSG(error); }

                if (GradleTaskRunner::get_instance().is_task_terminated()) {
                    task_dialog_stop(task_dialog);
                    get_editor_interface()->get_resource_filesystem()->scan_sources();
                    JVM_LOG_INFO("Gradle Task terminated");
                }
            }
            break;

        case NOTIFICATION_EXIT_TREE:
            editor_base_control->remove_child(task_dialog.dialog);
            editor_base_control->remove_child(about_dialog);
            editor_base_control->remove_child(project_dialog);
            remove_tool_menu_item("Kotlin/JVM");
            remove_control_from_container(CustomControlContainer::CONTAINER_TOOLBAR, jvm_status_light);
            remove_control_from_container(CustomControlContainer::CONTAINER_TOOLBAR, separator);
            remove_control_from_container(CustomControlContainer::CONTAINER_TOOLBAR, tool_bar_gradle_task_choice);
            remove_control_from_container(CustomControlContainer::CONTAINER_TOOLBAR, tool_bar_gradle_task_button);

            remove_export_plugin(export_plugin);
            export_plugin.unref();

            get_editor_interface()->get_script_editor()->unregister_syntax_highlighter(syntax_highlighter);
            syntax_highlighter.unref();

            break;
    }
}

GodotJvmEditor::GodotJvmEditor() :
  about_pop_menu(memnew(PopupMenu)),
  project_dialog(memnew(AcceptDialog)),
  jvm_status_light(memnew(TextureRect)),
  tool_bar_gradle_task_button(memnew(Button)),
  tool_bar_gradle_task_choice(memnew(OptionButton)),
  separator(memnew(VSeparator)) {}

GodotJvmEditor::~GodotJvmEditor() {
    GradleTaskRunner::get_instance().cleanup();
    memdelete(about_dialog);
    memdelete(task_dialog.dialog);
    memdelete(project_dialog);
    memdelete(jvm_status_light);
    memdelete(tool_bar_gradle_task_button);
    memdelete(tool_bar_gradle_task_choice);
    memdelete(separator);
}

void GodotJvmEditor::_bind_methods() {}
