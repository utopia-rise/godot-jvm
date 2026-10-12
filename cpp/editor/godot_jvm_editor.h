#ifndef GODOT_JVM_GODOT_JVM_EDITOR_H
#define GODOT_JVM_GODOT_JVM_EDITOR_H

#include "godot_jvm.h"
#include "ui/task_dialog.h"

#include <classes/accept_dialog.hpp>
#include <classes/button.hpp>
#include <classes/editor_plugin.hpp>
#include <classes/option_button.hpp>
#include <classes/texture_rect.hpp>
#include <classes/v_separator.hpp>

namespace godot {
    class GodotJvmEditorExportPlugin;
    class JvmStandardSyntaxHighlighter;

    class GodotJvmEditor : public EditorPlugin {
        GDCLASS(GodotJvmEditor, EditorPlugin)

        enum KOTLIN_JVM_MENU_OPTIONS {
            GENERATE_PROJECT
        };

        enum BuildOnRunMode {
            BUILD_ON_RUN_NEVER,
            BUILD_ON_RUN_WHEN_STALE,
            BUILD_ON_RUN_ALWAYS,
            BUILD_ON_RUN_MODE_COUNT
        };

        PopupMenu* tool_pop_menu;
        // Built in NOTIFICATION_ENTER_TREE, not the constructor: it reads editor_scale below, which is only populated
        // once this plugin has actually entered the tree — constructing it any earlier crashes.
        TaskDialogControls task_dialog = TaskDialogControls();

        AcceptDialog* project_dialog;

        VSeparator* separator;
        TextureRect* jvm_status_light;
        Button* tool_bar_gradle_task_button;
        OptionButton* tool_bar_gradle_task_choice;
        Button* build_on_run_button;
        int build_on_run_mode = BUILD_ON_RUN_NEVER;

        GodotJvm::State displayed_jvm_state = GodotJvm::State::NOT_STARTED;
        bool displayed_bootstrap_outdated = false;

        Ref<GodotJvmEditorExportPlugin> export_plugin;
        Ref<JvmStandardSyntaxHighlighter> syntax_highlighter;

        GodotJvmEditor();
        ~GodotJvmEditor();

        void on_gradle_task_pressed();
        void on_build_on_run_pressed();
        void update_build_on_run_display();
        void on_menu_option_pressed(int option_id);
        void on_generate_project(bool erase_existing);
        void on_filesystem_change();
        void update_jvm_status(bool force = false);

    protected:
        static void _bind_methods();

    public:
        inline static float editor_scale = 1.0f;

        GodotJvmEditor(const GodotJvmEditor&) = delete;

        bool _build() override;
        void _notification(int notification);
    };
} // namespace godot
#endif // GODOT_JVM_GODOT_JVM_EDITOR_H
