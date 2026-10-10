package godot.tests.registration;

import godot.annotation.Register;
import godot.annotation.Script;
import godot.api.Texture2D;

@Script
public class Texture2DInheritanceJava extends Texture2D {
    @Register
    @Override
    public int _getWidth() {
        return 7;
    }

    @Register
    @Override
    public int _getHeight() {
        return 3;
    }
}
