package godot.tests.registration;

import godot.annotation.Register;
import godot.annotation.Script;
import godot.api.CanvasItem;
import godot.api.Node;

@Script
public class CanvasItemConstructionJava extends Node {
    @Register
    public String constructCanvasItem() {
        try {
            new CanvasItem();
            return "constructed";
        } catch (IllegalStateException exception) {
            return exception.getMessage();
        }
    }
}
