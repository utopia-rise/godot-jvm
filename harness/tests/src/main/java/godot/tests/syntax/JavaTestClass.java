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

    @Visible
    public double processDelta = 0.0;

    @Visible
    public double physicsProcessDelta = 0.0;

    @Register
    public String greeting() {
        return "Hello from java";
    }

    @Register
    @Override
    public void _enterTree() {
        enteredTree = true;
    }

    @Register
    @Override
    public void _process(double delta) {
        processDelta += delta;
    }

    @Register
    @Override
    public void _physicsProcess(double delta) {
        physicsProcessDelta += delta;
    }

    @Notification(0)
    public void onNotification() {
        notificationTriggered = true;
    }
}
