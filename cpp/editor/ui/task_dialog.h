#ifndef GODOT_JVM_TASK_DIALOG_H
#define GODOT_JVM_TASK_DIALOG_H

#include "engine/godot_object.h"

#include <classes/accept_dialog.hpp>
#include <classes/label.hpp>
#include <classes/progress_bar.hpp>
#include <classes/scroll_container.hpp>
#include <classes/v_box_container.hpp>
#include <classes/v_scroll_bar.hpp>
#include <variant/callable_method_pointer.hpp>

// Plain data holder, not a Wrapped-derived class — see about_dialog.h's header comment for why. Pairs the AcceptDialog with the specific children make_appear()/update_state()/stop() below need direct access to.
struct TaskDialogControls {
    godot::AcceptDialog* dialog;
    godot::ScrollContainer* scroll_container;
    godot::Label* log_label;
    godot::ProgressBar* progress_bar;
};

namespace {
    void on_task_dialog_scroll_container_draw(godot::ScrollContainer* scroll_container) {
        scroll_container->set_v_scroll(static_cast<int>(scroll_container->get_v_scroll_bar()->get_max()));
    }
} // namespace

inline TaskDialogControls create_task_dialog(float editor_scale) {
    using namespace godot;

    AcceptDialog* dialog = memnew(AcceptDialog);
    dialog->set_title("Gradle Task Runner");

    VBoxContainer* vertical_container = memnew(VBoxContainer);
    dialog->add_child(vertical_container);

    ScrollContainer* scroll_container = memnew(ScrollContainer);
    scroll_container->set_custom_minimum_size(Size2 {600, 400} * editor_scale);
    vertical_container->add_child(scroll_container);

    Label* log_label = memnew(Label);
    log_label->set_h_size_flags(Control::SizeFlags::SIZE_EXPAND_FILL);
    scroll_container->add_child(log_label);

    ProgressBar* progress_bar = memnew(ProgressBar);
    progress_bar->set_editor_preview_indeterminate(true);
    progress_bar->set_indeterminate(true);
    vertical_container->add_child(progress_bar);

    return TaskDialogControls {dialog, scroll_container, log_label, progress_bar};
}

inline void task_dialog_make_appear(const TaskDialogControls& controls) {
    controls.log_label->set_text("");
    controls.dialog->set_transient(true);
    controls.dialog->set_exclusive(true);
    controls.progress_bar->show();
    controls.dialog->popup_centered();
}

inline void task_dialog_update_state(const TaskDialogControls& controls, godot::String log) {
    using namespace godot;

    if (log.is_empty()) { return; }
    controls.log_label->set_text(controls.log_label->get_text() + log);

    StringName signal = SNAME("draw");
    Callable callback = callable_mp_static(&on_task_dialog_scroll_container_draw).bind(controls.scroll_container);

    if (!controls.scroll_container->is_connected(signal, callback)) {
        controls.scroll_container->connect(signal, callback, Object::CONNECT_ONE_SHOT);
    }
}

inline void task_dialog_stop(const TaskDialogControls& controls) {
    controls.progress_bar->hide();
    controls.dialog->set_exclusive(false);
}

#endif // GODOT_JVM_TASK_DIALOG_H
