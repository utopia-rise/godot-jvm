package godot.inspection.inferred;

// Manual review mode: Inferred.
// This same source is exercised by the IntelliJ CodeInsight fixture test.
// Inline expectation comments describe what this mode reports and must match the test.

import godot.annotation.*;
import godot.api.Node;
import godot.core.Signal0;
import godot.core.StringNames;

class JvmUnsupportedType {
}

// Class-level registration checks.

// Expected no issue: `@Tool` carries `@Script`, so the class is registered.
@Tool
class JvmNotRegisteredButToolFixtureInferred extends Node {
}

// Expected red on the class: it is not `@Script`, but it contains
// registered properties, signals, and functions.
class JvmNotRegisteredButMembersFixtureInferred extends Node {
    // Expected red via the containing class: registered property inside a
    // non-registered class.
    @Export
    @Visible
    public int propertyShouldStayRed = 1;

    // Expected red via the containing class: registered signal inside a
    // non-registered class.
    @Emit
    public Signal0 signalShouldStayRed = new Signal0(this, StringNames.asStringName("signalShouldStayRed"));

    // Expected red via the containing class: registered function inside a
    // non-registered class.
    @Register
    public int functionShouldStayRed() {
        return propertyShouldStayRed;
    }
}

// Expected red: `@Script` is present, but the class does not inherit a
// Godot object type.
@Script
class JvmGodotScriptWithoutGodotBaseFixtureInferred {
}

// Expected no issue: the IDE does not check constructors.
@Script
class JvmGodotScriptWithoutDefaultConstructorFixtureInferred extends Node {
    public JvmGodotScriptWithoutDefaultConstructorFixtureInferred(int number) {
    }
}

// Expected red on both duplicate declarations: they register the same custom
// Godot class name.
@Script(className = "DuplicateJvmInspectionNameInferred")
class JvmDuplicateRegisteredNameFixtureOneInferred extends Node {
}

@Script(className = "DuplicateJvmInspectionNameInferred")
class JvmDuplicateRegisteredNameFixtureTwoInferred extends Node {
}

// Expected red: generic classes cannot be registered.
@Script
class JvmGenericRegisteredClassFixtureInferred<T> extends Node {
}

// Method registration checks.
@Script
public class IdeJavaInspectionInferred extends Node {
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


