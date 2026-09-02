package godot.tests.core

import godot.annotation.Register
import godot.annotation.Script
import godot.api.Button
import godot.api.Control
import godot.api.Label
import godot.api.Node
import godot.api.Node3D
import godot.api.Panel
import godot.core.Color
import godot.core.Side
import godot.core.StringName
import godot.core.Transform3D
import godot.core.VariantArray
import godot.core.Vector2
import godot.core.Vector3
import godot.core.variantArrayOf

/**
 * Calls plain engine API methods whose parameter lists mix Variant types, then reads the values back
 * through the matching getters. These are the most trivial calls a user makes, and they exercise a
 * path the core round-trip tests do not: arguments marshalled for an engine ptrcall
 * (writeMethodArguments/callMethod) rather than for one of our own registered functions.
 *
 * Methods with defaulted trailing parameters are called both with and without those arguments, since
 * the binding always writes the full argument list and a mismatch there is invisible at the call site.
 */
@Script
class EngineApiCallTest : Node() {

    // Regression cases for engine objects built by InstanceCreator without being postinitialized: a
    // Control subclass that never built its theme item cache crashed on its first resize. Text-drawing
    // controls (Label, Button) read that cache while re-shaping; Control and Panel never touch it, so
    // both sides of that split are covered here.
    @Register
    fun labelTextThenSetSize(): Vector2 {
        val label = Label()
        label.text = "x"
        label.setSize(Vector2(24, 24))
        val size = label.getSize()
        label.free()
        return size
    }

    // Hands a JVM-constructed Control to the caller and takes a caller-constructed one back, so an object
    // that is only half-built by our own construction path fails here even when GDScript makes the call.
    @Register
    fun createLabelForCaller(): Label = Label()

    @Register
    fun setSizeOnGivenControl(control: Control): Vector2 {
        control.setSize(Vector2(24, 24))
        return control.getSize()
    }

    @Register
    fun panelSetSize(): Vector2 {
        val panel = Panel()
        panel.setSize(Vector2(24, 24))
        val size = panel.getSize()
        panel.free()
        return size
    }

    @Register
    fun buttonSetSize(): Vector2 {
        val button = Button()
        button.setSize(Vector2(24, 24))
        val size = button.getSize()
        button.free()
        return size
    }

    @Register
    fun labelSetSizeWithoutText(): Vector2 {
        val label = Label()
        label.setSize(Vector2(24, 24))
        val size = label.getSize()
        label.free()
        return size
    }

    @Register
    fun labelTextOnly(): String {
        val label = Label()
        label.text = "x"
        val text = label.text
        label.free()
        return text
    }

    @Register
    fun controlSetSizeWithDefaultedArgument(): Vector2 {
        val control = Control()
        control.setSize(Vector2(12.5, 34.25))
        val size = control.getSize()
        control.free()
        return size
    }

    @Register
    fun controlSetSizeWithExplicitArgument(): Vector2 {
        val control = Control()
        control.setSize(Vector2(48, 64), false)
        val size = control.getSize()
        control.free()
        return size
    }

    @Register
    fun controlSetPositionWithDefaultedArgument(): Vector2 {
        val control = Control()
        control.setPosition(Vector2(7.5, -3.25))
        val position = control.getPosition()
        control.free()
        return position
    }

    @Register
    fun controlSetCustomMinimumSize(): Vector2 {
        val control = Control()
        control.setCustomMinimumSize(Vector2(5, 6))
        val size = control.getCustomMinimumSize()
        control.free()
        return size
    }

    // (enum, Float, Boolean, Boolean): a Long, a narrowed Double and two bools in one argument list.
    @Register
    fun controlSetAnchorMixedArguments(): Double {
        val control = Control()
        control.setAnchor(Side.LEFT, 0.25f, false, true)
        val anchor = control.getAnchor(Side.LEFT)
        control.free()
        return anchor.toDouble()
    }

    @Register
    fun controlSetAnchorsPresetWithDefaultedArgument(): Double {
        val control = Control()
        control.setAnchorsPreset(Control.LayoutPreset.PRESET_FULL_RECT)
        val anchor = control.getAnchor(Side.RIGHT)
        control.free()
        return anchor.toDouble()
    }

    // (StringName, Color) and (StringName, Int): a core type and a primitive behind a name.
    @Register
    fun controlThemeOverridesMixedArguments(): VariantArray<Any?> {
        val control = Control()
        control.addThemeColorOverride(StringName("font_color"), Color(0.25, 0.5, 0.75, 1.0))
        control.addThemeConstantOverride(StringName("outline_size"), 7)
        control.addThemeFontSizeOverride(StringName("font_size"), 23)

        val color = control.getThemeColor(StringName("font_color"))
        val constant = control.getThemeConstant(StringName("outline_size"))
        control.free()
        return variantArrayOf(color, constant)
    }

    @Register
    fun nodeSetNameThenMultiplayerAuthority(): String {
        val node = Node()
        node.setName("MixedArgumentNode")
        node.setMultiplayerAuthority(1, false)
        val name = node.name.toString()
        node.free()
        return name
    }

    @Register
    fun node3dVector3AndTransformArguments(): Vector3 {
        val node = Node3D()
        node.setPosition(Vector3(1.5, 2.5, 3.5))
        node.setScale(Vector3(2, 2, 2))
        node.setRotation(Vector3(0.0, 0.0, 0.0))
        node.setGlobalTransform(Transform3D())
        node.setPosition(Vector3(4.5, 5.5, 6.5))
        val position = node.getPosition()
        node.free()
        return position
    }

    /**
     * Interleaves calls whose argument lists differ in both arity and Variant types on the same
     * object, so a per-thread buffer that is not reset between calls shows up as a wrong read-back
     * rather than staying hidden behind uniformly shaped calls.
     */
    @Register
    fun interleavedMixedArgumentCalls(): Vector2 {
        val label = Label()
        label.text = "interleaved"
        label.setCustomMinimumSize(Vector2(1, 1))
        label.setAnchor(Side.TOP, 0.5f)
        label.addThemeConstantOverride(StringName("outline_size"), 3)
        label.setPosition(Vector2(10, 20))
        label.addThemeColorOverride(StringName("font_color"), Color(1.0, 0.0, 0.0, 1.0))
        label.setSize(Vector2(101.5, 202.5))
        label.setMultiplayerAuthority(1, false)
        val size = label.getSize()
        label.free()
        return size
    }
}
