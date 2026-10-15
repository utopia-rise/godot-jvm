#include "godot_jvm_editor.h"

#include "api/script/jvm_script_manager.h"
#include "editor/build/gradle_task_runner.h"
#include "editor/export/godot_jvm_editor_export_plugin.h"
#include "editor/jvm_syntax_highlighter.h"
#include "editor/strings.h"
#include "godot_jvm.h"
#include "logging.h"
#include "paths.h"
#include "project/project_generator.h"

#include <classes/accept_dialog.hpp>
#include <classes/button.hpp>
#include <classes/editor_file_system.hpp>
#include <classes/editor_interface.hpp>
#include <classes/editor_settings.hpp>
#include <classes/editor_toaster.hpp>
#include <classes/engine.hpp>
#include <classes/file_access.hpp>
#include <classes/input.hpp>
#include <classes/popup_menu.hpp>
#include <classes/project_settings.hpp>
#include <classes/script_editor.hpp>
#include <classes/theme.hpp>

using namespace godot;

#ifdef MACOS_ENABLED
static constexpr Key BUILD_ANYWAY_KEY = KEY_META;
static constexpr const char* BUILD_ANYWAY_KEY_NAME = "Cmd";
#else
static constexpr Key BUILD_ANYWAY_KEY = KEY_CTRL;
static constexpr const char* BUILD_ANYWAY_KEY_NAME = "Ctrl";
#endif

void GodotJvmEditor::on_menu_option_pressed(int option_id) {
    if (option_id == GENERATE_PROJECT) { project_dialog->popup_centered(); }
}

void GodotJvmEditor::on_generate_project(bool erase_existing) {
    ProjectGenerator::generate_jvm_files(erase_existing);
    get_editor_interface()->get_resource_filesystem()->scan();
    project_dialog->hide();
}

void GodotJvmEditor::on_gradle_task_pressed() {
    if (GradleTaskRunner::get_instance().is_task_started()) { return; }
    String log;
    if (GradleTaskRunner::get_instance().run_task(tool_bar_gradle_task_choice->get_selected_id(), log, false) != OK) {
        return;
    }

    task_dialog_make_appear(task_dialog);
    JVM_LOG_INFO(log);
}

void GodotJvmEditor::on_build_on_run_pressed() {
    build_on_run_mode = (build_on_run_mode + 1) % BUILD_ON_RUN_MODE_COUNT;
    get_editor_interface()->get_editor_settings()->set_project_metadata(
        BUILD_ON_RUN_METADATA_SECTION,
        BUILD_ON_RUN_METADATA_KEY,
        build_on_run_mode
    );
    update_build_on_run_display();
}

void GodotJvmEditor::update_build_on_run_display() {
    StringName icon = build_on_run_mode == BUILD_ON_RUN_ALWAYS ? SNAME("Reload") : SNAME("Tools");
    build_on_run_button->set_button_icon(
        get_editor_interface()->get_editor_theme()->get_icon(icon, SNAME("EditorIcons"))
    );
    build_on_run_button->set_self_modulate(Color(1, 1, 1, build_on_run_mode == BUILD_ON_RUN_NEVER ? 0.35 : 1));
    build_on_run_button->set_tooltip_text(
        String("Build on Run: ")
        + build_on_run_mode_names[build_on_run_mode]
        + "\n\n"
        + vformat(build_on_run_tooltip, BUILD_ANYWAY_KEY_NAME)
    );
}

bool GodotJvmEditor::_build() {
    Input* input = Input::get_singleton();
    int mode = build_on_run_mode;
    if (input->is_key_pressed(KEY_SHIFT)) { mode = BUILD_ON_RUN_WHEN_STALE; }
    if (input->is_key_pressed(BUILD_ANYWAY_KEY)) { mode = BUILD_ON_RUN_ALWAYS; }
    if (mode == BUILD_ON_RUN_NEVER) { return true; }
    if (mode == BUILD_ON_RUN_WHEN_STALE && !JvmScriptManager::get_instance()->is_user_code_outdated()) { return true; }
    if (GradleTaskRunner::get_instance().is_task_started()) {
        get_editor_interface()->get_editor_toaster()->push_toast(
            "A Gradle task is running. Run the project again once it has finished.",
            EditorToaster::SEVERITY_WARNING
        );
        return false;
    }

    String log;
    Error error = GradleTaskRunner::get_instance().run_task(GradleTaskRunner::Task::BUILD_DEBUG, log, true);
    print_line(log);
    get_editor_interface()->get_resource_filesystem()->scan_sources();
    if (error == OK) { return true; }

    task_dialog_make_appear(task_dialog);
    task_dialog_update_state(task_dialog, log + "Gradle task failed.\n");
    task_dialog_stop(task_dialog);
    return false;
}

void GodotJvmEditor::on_filesystem_change() {
    check_addon_replaced();
    if (GodotJvm::get_instance().state == GodotJvm::State::JVM_SCRIPTS_INITIALIZED) { return; }

    if (GodotJvm::get_instance().state == GodotJvm::State::JVM_STARTED) {
        String bootstrap = String(RES_DIRECTORY).path_join(BOOTSTRAP_FILE);
        if (FileAccess::file_exists(bootstrap)) {
            GodotJvm::get_instance().initialize_up_to(GodotJvm::State::JVM_SCRIPTS_INITIALIZED);
        }
    }
}

void GodotJvmEditor::check_addon_replaced() {
    if (FileAccess::get_modified_time(ADDON_MANIFEST_FILE) != addon_manifest_time) { addon_outdated = true; }
}

void GodotJvmEditor::update_jvm_status(bool force) {
    GodotJvm::State state = GodotJvm::get_instance().state;
    bool bootstrap_outdated = GodotJvm::get_instance().bootstrap_outdated;
    if (!force
        && displayed_jvm_state == state
        && displayed_bootstrap_outdated == bootstrap_outdated
        && displayed_addon_outdated == addon_outdated) {
        return;
    }

    if (addon_outdated && !displayed_addon_outdated) {
        get_editor_interface()->get_editor_toaster()->push_toast(
            "The Godot-JVM addon changed. Restart the editor to load it (Project > Reload Current Project).",
            EditorToaster::SEVERITY_WARNING
        );
    }

    if (bootstrap_outdated && !displayed_bootstrap_outdated) {
        get_editor_interface()->get_editor_toaster()->push_toast(
            "The JVM bootstrap archive changed. Restart the editor to load it (Project > Reload Current Project).",
            EditorToaster::SEVERITY_WARNING
        );
    }

    displayed_jvm_state = state;
    displayed_bootstrap_outdated = bootstrap_outdated;
    displayed_addon_outdated = addon_outdated;

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

    if (bootstrap_outdated) {
        icon = SNAME("StatusWarning");
        label = "Bootstrap modified, restart the editor to load it";
    }
    if (addon_outdated) {
        icon = SNAME("StatusWarning");
        label = "Addon modified, restart the editor to load it";
    }

    jvm_status_light->set_texture(get_editor_interface()->get_editor_theme()->get_icon(icon, SNAME("EditorIcons")));
    jvm_status_light->set_tooltip_text("JVM status: " + label);
}

void GodotJvmEditor::_notification(int notification) {
    if (!Engine::get_singleton()->is_editor_hint()) { return; }

    Control* editor_base_control = get_editor_interface()->get_base_control();
    ProjectSettings* project_settings = ProjectSettings::get_singleton();

    switch (notification) {
        case NOTIFICATION_ENTER_TREE:
            editor_scale = get_editor_interface()->get_editor_scale();
            task_dialog = create_task_dialog(editor_scale);

            if (!project_settings->has_setting(GRADLE_DIR)) { project_settings->set_setting(GRADLE_DIR, "res://"); }
            // Not PropertyInfo's own operator Dictionary(): that always includes a "usage" key, which
            // add_property_info() explicitly doesn't support (ProjectSettings::_add_property_info_bind warns and
            // ignores it otherwise) — build the dictionary with...
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
            project_dialog->get_ok_button()->connect(
                "pressed",
                callable_mp(this, &GodotJvmEditor::on_generate_project).bind(false)
            );
            project_dialog->add_button(generate_all)
                ->connect("pressed", callable_mp(this, &GodotJvmEditor::on_generate_project).bind(true));
            project_dialog->add_cancel_button(generate_nothing);

            tool_pop_menu->hide();
            tool_pop_menu->connect(SNAME("id_pressed"), callable_mp(this, &GodotJvmEditor::on_menu_option_pressed));
            tool_pop_menu->add_item("Generate JVM project", GENERATE_PROJECT);
            add_tool_submenu_item("Kotlin/JVM", tool_pop_menu);

            add_control_to_container(CustomControlContainer::CONTAINER_TOOLBAR, separator);

            tool_bar_gradle_task_choice->set_flat(true);
            tool_bar_gradle_task_choice->add_item("Build", GradleTaskRunner::Task::BUILD_DEBUG);
            tool_bar_gradle_task_choice->add_item("Fast Build", GradleTaskRunner::Task::FAST_BUILD);
            tool_bar_gradle_task_choice->add_item("Build Release", GradleTaskRunner::Task::BUILD_RELEASE);
            tool_bar_gradle_task_choice->add_item("Build Android", GradleTaskRunner::Task::BUILD_ANDROID_DEBUG);
            tool_bar_gradle_task_choice->add_item(
                "Build Android Release",
                GradleTaskRunner::Task::BUILD_ANDROID_RELEASE
            );
#ifdef MACOS_ENABLED
            // The iOS tasks need Xcode, so they can only succeed on a macOS host.
            tool_bar_gradle_task_choice->add_item("Build iOS", GradleTaskRunner::Task::BUILD_IOS_DEBUG);
            tool_bar_gradle_task_choice->add_item("Build iOS Release", GradleTaskRunner::Task::BUILD_IOS_RELEASE);
#endif
            tool_bar_gradle_task_choice->add_item(
                "Build Graal Native Image",
                GradleTaskRunner::Task::BUILD_GRAAL_NATIVE_IMAGE_DEBUG
            );
            tool_bar_gradle_task_choice->add_item(
                "Build Graal Native Image Release",
                GradleTaskRunner::Task::BUILD_GRAAL_NATIVE_IMAGE_RELEASE
            );
#ifdef MACOS_ENABLED
            tool_bar_gradle_task_choice->add_item(
                "Generate JRE (arm64)",
                GradleTaskRunner::Task::GENERATE_EMBEDDED_JVM_ARM64
            );
            tool_bar_gradle_task_choice->add_item(
                "Generate JRE (x86_64)",
                GradleTaskRunner::Task::GENERATE_EMBEDDED_JVM_AMD64
            );
            tool_bar_gradle_task_choice->add_item(
                "Generate JRE (universal)",
                GradleTaskRunner::Task::GENERATE_EMBEDDED_JVM_UNIVERSAL
            );
#else
            tool_bar_gradle_task_choice->add_item("Generate JRE", GradleTaskRunner::Task::GENERATE_EMBEDDED_JVM);
#endif
            tool_bar_gradle_task_choice->add_item("Sync Addon Version", GradleTaskRunner::Task::SYNC_ADDON_VERSION);
            tool_bar_gradle_task_choice->select(GradleTaskRunner::Task::BUILD_DEBUG);
            tool_bar_gradle_task_choice->set_fit_to_longest_item(false);
            add_control_to_container(CustomControlContainer::CONTAINER_TOOLBAR, tool_bar_gradle_task_choice);

            tool_bar_gradle_task_button->set_text("Run Gradle");
            tool_bar_gradle_task_button->set_tooltip_text("Run the selected Gradle task");
            tool_bar_gradle_task_button->set_focus_mode(Control::FOCUS_NONE);
            tool_bar_gradle_task_button->connect(
                SNAME("pressed"),
                callable_mp(this, &GodotJvmEditor::on_gradle_task_pressed)
            );
            add_control_to_container(CustomControlContainer::CONTAINER_TOOLBAR, tool_bar_gradle_task_button);

            build_on_run_mode = get_editor_interface()->get_editor_settings()->get_project_metadata(
                BUILD_ON_RUN_METADATA_SECTION,
                BUILD_ON_RUN_METADATA_KEY,
                BUILD_ON_RUN_NEVER
            );
            if (build_on_run_mode < 0 || build_on_run_mode >= BUILD_ON_RUN_MODE_COUNT) {
                build_on_run_mode = BUILD_ON_RUN_NEVER;
            }
            build_on_run_button->set_flat(true);
            build_on_run_button->set_focus_mode(Control::FOCUS_NONE);
            build_on_run_button->connect(SNAME("pressed"), callable_mp(this, &GodotJvmEditor::on_build_on_run_pressed));
            update_build_on_run_display();
            add_control_to_container(CustomControlContainer::CONTAINER_TOOLBAR, build_on_run_button);

            addon_manifest_time = FileAccess::get_modified_time(ADDON_MANIFEST_FILE);
            jvm_status_light->set_stretch_mode(TextureRect::STRETCH_KEEP_ASPECT_CENTERED);
            jvm_status_light->set_self_modulate(Color(1, 1, 1, 0.5));
            add_control_to_container(CustomControlContainer::CONTAINER_TOOLBAR, jvm_status_light);
            update_jvm_status(true);

            editor_base_control->add_child(task_dialog.dialog);
            editor_base_control->add_child(project_dialog);

            get_editor_interface()->get_resource_filesystem()->connect(
                SNAME("filesystem_changed"),
                callable_mp(this, &GodotJvmEditor::on_filesystem_change)
            );
            set_process(true);

            // Instantiating these at NOTIFICATION_ENTER_TREE (once the engine has actually added this plugin to the
            // tree) rather than eagerly during static extension registration — constructing UI-adjacent Wrapped objects
            // that early crashes, since the...
            export_plugin.instantiate();
            add_export_plugin(export_plugin);

            syntax_highlighter.instantiate();
            get_editor_interface()->get_script_editor()->register_syntax_highlighter(syntax_highlighter);

            break;

        case NOTIFICATION_PROCESS:
            update_jvm_status();

            if (GradleTaskRunner::get_instance().is_task_started()) {
                // Checked before draining the pipes so the lines written right before the process exited are not lost.
                bool running = GradleTaskRunner::get_instance().is_task_running();
                String log;
                String error;
                GradleTaskRunner::get_instance().get_task_output(log, error);
                task_dialog_update_state(task_dialog, log + error);

                // Streamed with the regular Godot print to avoid repeating the JVM prefix. Gradle also writes its
                // warnings to stderr, so stderr is not an error by itself: a failure is reported from the exit code.
                if (!log.is_empty()) { print_line(log); }
                if (!error.is_empty()) { print_line(error); }

                if (!running) {
                    int exit_code = GradleTaskRunner::get_instance().finish_task();
                    task_dialog_stop(task_dialog);
                    get_editor_interface()->get_resource_filesystem()->scan_sources();
                    check_addon_replaced();
                    if (exit_code == 0) {
                        task_dialog_update_state(task_dialog, "Gradle task succeeded.\n");
                        JVM_LOG_INFO("Gradle task succeeded.");
                    } else {
                        task_dialog_update_state(
                            task_dialog,
                            vformat("Gradle task failed with exit code %d.\n", exit_code)
                        );
                        JVM_ERR_PRINT("Gradle task failed with exit code %d.", exit_code);
                    }
                }
            }
            break;

        case NOTIFICATION_EXIT_TREE:
            editor_base_control->remove_child(task_dialog.dialog);
            editor_base_control->remove_child(project_dialog);
            remove_tool_menu_item("Kotlin/JVM");
            remove_control_from_container(CustomControlContainer::CONTAINER_TOOLBAR, jvm_status_light);
            remove_control_from_container(CustomControlContainer::CONTAINER_TOOLBAR, separator);
            remove_control_from_container(CustomControlContainer::CONTAINER_TOOLBAR, tool_bar_gradle_task_choice);
            remove_control_from_container(CustomControlContainer::CONTAINER_TOOLBAR, tool_bar_gradle_task_button);
            remove_control_from_container(CustomControlContainer::CONTAINER_TOOLBAR, build_on_run_button);

            remove_export_plugin(export_plugin);
            export_plugin.unref();

            get_editor_interface()->get_script_editor()->unregister_syntax_highlighter(syntax_highlighter);
            syntax_highlighter.unref();

            break;
    }
}

GodotJvmEditor::GodotJvmEditor() :
    tool_pop_menu(memnew(PopupMenu)),
    project_dialog(memnew(AcceptDialog)),
    jvm_status_light(memnew(TextureRect)),
    tool_bar_gradle_task_button(memnew(Button)),
    tool_bar_gradle_task_choice(memnew(OptionButton)),
    build_on_run_button(memnew(Button)),
    separator(memnew(VSeparator)) {}

GodotJvmEditor::~GodotJvmEditor() {
    GradleTaskRunner::get_instance().cleanup();
    memdelete(task_dialog.dialog);
    memdelete(project_dialog);
    memdelete(jvm_status_light);
    memdelete(tool_bar_gradle_task_button);
    memdelete(tool_bar_gradle_task_choice);
    memdelete(build_on_run_button);
    memdelete(separator);
}

void GodotJvmEditor::_bind_methods() {}
