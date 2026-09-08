#ifndef GODOT_JVM_GODOT_JVM_EDITOR_H
#define GODOT_JVM_GODOT_JVM_EDITOR_H

#include "godot_jvm.h"
#include "ui/about_dialog.h"
#include "ui/task_dialog.h"

#include <classes/accept_dialog.hpp>
#include <classes/editor_plugin.hpp>
#include <classes/editor_settings.hpp>
#include <classes/option_button.hpp>
#include <classes/texture_rect.hpp>
#include <classes/v_separator.hpp>

namespace godot {
    class GodotJvmEditorExportPlugin;
    class JvmStandardSyntaxHighlighter;

    class GodotJvmEditor : public EditorPlugin {
        GDCLASS(GodotJvmEditor, EditorPlugin)
        enum KOTLIN_JVM_MENU_OPTIONS {
            GENERATE_PROJECT,
            ABOUT
        };

        PopupMenu* about_pop_menu;
        // Built in NOTIFICATION_ENTER_TREE, not the constructor: both read editor_settings/ editor_scale below, which are only populated once this plugin has actually entered the tree — constructing them any earlier crashes on a null editor_settin...
        AcceptDialog* about_dialog = nullptr;
        TaskDialogControls task_dialog = TaskDialogControls();

        AcceptDialog* project_dialog;

        VSeparator* separator;
        TextureRect* jvm_status_light;
        Button* tool_bar_gradle_task_button;
        OptionButton* tool_bar_gradle_task_choice;

        GodotJvm::State displayed_jvm_state = GodotJvm::State::NOT_STARTED;

        Ref<GodotJvmEditorExportPlugin> export_plugin;
        Ref<JvmStandardSyntaxHighlighter> syntax_highlighter;
        // Deliberately an instance member, not static: a static Ref's destructor only runs at true process exit(),
        // after Main::cleanup() has already torn down the engine's method-bind tables, and unreference()-ing an
        // EditorSettings at that point dereferences a stale method-bind pointer into freed memory (confirmed with a
        // live debugger: SIGSEGV inside RefCounted::unreference(), called from this Ref's static destructor after
        // exit()). As an instance member it destructs with the object itself, when the engine deletes this plugin
        // during "deinit extensions EDITOR" -- well before that teardown -- so it never had to be static in the
        // first place: every use of it below goes through `this`, never a bare class-name access.
        Ref<EditorSettings> editor_settings;

        GodotJvmEditor();
        ~GodotJvmEditor();

        void on_gradle_task_pressed();
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
