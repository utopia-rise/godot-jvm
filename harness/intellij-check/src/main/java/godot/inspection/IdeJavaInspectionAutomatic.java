package godot.inspection.automatic;

// Manual review mode: Automatic.
// This same source is exercised by the IntelliJ CodeInsight fixture test.
// Inline expectation comments describe what this mode reports and must match the test.

import godot.annotation.*;
import godot.api.Node;
import godot.core.Signal0;
import godot.core.StringNames;

class JvmUnsupportedType {
}

// Class-level registration checks.

// Expected no issue: the class is registered automatically.
@Tool
class JvmNotRegisteredButToolFixtureAutomatic extends Node {
}

// Expected no issue: the class is registered automatically, and its members with it.
class JvmNotRegisteredButMembersFixtureAutomatic extends Node {
    // Expected no issue: registered with its automatically registered class.
    @Export
    @Visible
    public int propertyShouldStayRed = 1;

    // Expected no issue: registered with its automatically registered class.
    @Emit
    public Signal0 signalShouldStayRed = new Signal0(this, StringNames.asStringName("signalShouldStayRed"));

    // Expected no issue: registered with its automatically registered class.
    public int functionShouldStayRed() {
        return propertyShouldStayRed;
    }
}

// Expected no issue: only Godot subclasses are script candidates in this mode, so the class is
// ignored.
@Script
class JvmGodotScriptWithoutGodotBaseFixtureAutomatic {
}

// Expected no issue: the IDE does not check constructors.
@Script
class JvmGodotScriptWithoutDefaultConstructorFixtureAutomatic extends Node {
    public JvmGodotScriptWithoutDefaultConstructorFixtureAutomatic(int number) {
    }
}

// Expected red on both duplicate declarations: they register the same custom
// Godot class name.
@Script(className = "DuplicateJvmInspectionNameAutomatic")
class JvmDuplicateRegisteredNameFixtureOneAutomatic extends Node {
}

@Script(className = "DuplicateJvmInspectionNameAutomatic")
class JvmDuplicateRegisteredNameFixtureTwoAutomatic extends Node {
}

// Expected red: generic classes cannot be registered.
@Script
class JvmGenericRegisteredClassFixtureAutomatic<T> extends Node {
}

// Method registration checks.
@Script
public class IdeJavaInspectionAutomatic extends Node {
    // Expected no issue: lifecycle overrides are registered without `@Register` in this mode.
    @Override
    public void _ready() {
    }

    // Expected red: generic functions cannot be registered.
    @Register
    public <T> void genericRegisteredFunction(T value) {
    }

    // Expected red: registered functions may not exceed the max supported
    // parameter count.
    @Register
    public void tooManyParameters(
            int p01,
            int p02,
            int p03,
            int p04,
            int p05,
            int p06,
            int p07,
            int p08,
            int p09,
            int p10,
            int p11,
            int p12,
            int p13,
            int p14,
            int p15,
            int p16,
            int p17
    ) {
    }

    // Expected red: parameter and return types must be representable by Godot.
    @Register
    public void unsupportedParameterType(JvmUnsupportedType value) {
    }

    @Register
    public JvmUnsupportedType unsupportedReturnType() {
        return new JvmUnsupportedType();
    }
}


