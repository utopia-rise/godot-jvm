#ifndef GODOT_JVM_ABOUT_DIALOG_H
#define GODOT_JVM_ABOUT_DIALOG_H

#include "editor/strings.h"
#include "engine/godot_object.h"

#include <classes/accept_dialog.hpp>
#include <classes/check_box.hpp>
#include <classes/editor_settings.hpp>
#include <classes/os.hpp>
#include <classes/rich_text_label.hpp>
#include <classes/v_box_container.hpp>
#include <variant/callable_method_pointer.hpp>

// Builds the "About Godot-JVM" dialog as a plain AcceptDialog rather than a custom subclass — AcceptDialog is already a registered engine class, so this needs no GDCLASS/ GDREGISTER_INTERNAL_CLASS at all. Special behavior (checkbox...

namespace {
    // Anonymous namespace, not `inline`: each translation unit including this header gets its own private copy — the standard idiom for header-local helpers, no ODR concern either way.
    void on_about_checkbox_toggled(bool is_selected, godot::Ref<godot::EditorSettings> editor_settings) {
        editor_settings->set_setting(SHOW_INFO_ON_START, is_selected);
    }

    void on_about_url_clicked(const godot::String& url) {
        godot::OS::get_singleton()->shell_open(url);
    }
} // namespace

inline godot::AcceptDialog* create_about_dialog(const godot::Ref<godot::EditorSettings>& editor_settings, float editor_scale) {
    using namespace godot;

    AcceptDialog* dialog {memnew(AcceptDialog)};
    dialog->set_title("About Godot-JVM");

    VBoxContainer* about_vbox {memnew(VBoxContainer)};
    dialog->add_child(about_vbox);

    RichTextLabel* about_label {memnew(RichTextLabel)};
    about_label->set_custom_minimum_size(Size2 {600, 150} * editor_scale);
    about_label->set_v_size_flags(Control::SizeFlags::SIZE_EXPAND_FILL);
    about_label->set_text(about_text);
    about_label->set_scroll_active(false);
    about_label->set_use_bbcode(true);
    about_label->connect(SNAME("meta_clicked"), callable_mp_static(&on_about_url_clicked));
    about_vbox->add_child(about_label);

    CheckBox* about_dialog_check_box {memnew(CheckBox)};
    about_dialog_check_box->set_text("Show this info when starting the editor");
    about_dialog_check_box->set_h_size_flags(Control::SizeFlags::SIZE_SHRINK_CENTER);
    about_dialog_check_box->connect(SNAME("toggled"), callable_mp_static(&on_about_checkbox_toggled).bind(editor_settings));

    bool show_on_start = editor_settings->get_setting(SHOW_INFO_ON_START);
    about_dialog_check_box->set_pressed(show_on_start);

    about_vbox->add_child(about_dialog_check_box);

    return dialog;
}

inline void show_about_dialog_if_configured(godot::AcceptDialog* dialog, const godot::Ref<godot::EditorSettings>& editor_settings) {
    bool show_on_start = editor_settings->get_setting(SHOW_INFO_ON_START);
    if (!show_on_start) { return; }

    // Once shown a first time, it can be seen again via the Kotlin JVM menu - it doesn't have to be exclusive from that time on.
    dialog->set_exclusive(true);
    dialog->popup_centered();
    dialog->set_exclusive(false);
}

#endif // GODOT_JVM_ABOUT_DIALOG_H
