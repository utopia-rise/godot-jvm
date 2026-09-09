package godot.tests.syntax;

import godot.api.Node;
import godot.annotation.Export;
import godot.annotation.Notification;
import godot.annotation.Script;
import godot.annotation.Register;
import godot.annotation.Visible;

@Script
public class JavaTestClass extends Node {
    @Export
    @Visible
    public int exportedInt = 1;

    @Visible
    public boolean enteredTree = false;

    @Visible
    public boolean notificationTriggered = false;

    @Register
    public String greeting() {
        return "Hello from java";
    }

    @Register
    @Override
    public void _enterTree() {
        enteredTree = true;
    }

    @Notification(0)
    public void onNotification() {
        notificationTriggered = true;
    }
}
