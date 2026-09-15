package godot.tests.core

import godot.annotation.Emit
import godot.annotation.Register
import godot.annotation.Script
import godot.api.Button
import godot.api.Control
import godot.api.Image
import godot.api.ImageTexture
import godot.api.Label
import godot.api.Node
import godot.api.Node3D
import godot.api.Panel
import godot.api.Sprite2D
import godot.core.Color
import godot.core.Side
import godot.core.StringName
import godot.core.Transform3D
import godot.core.VariantArray
import godot.core.Vector2
import godot.core.Vector3
import godot.core.signal2
import godot.core.variantArrayOf
import godot.extension.connectLambda

/**
 * Calls plain engine API methods and reads the values back, covering both native entry points behind a
 * generated call: the ptrcall (`callPtrMethod`) every fixed-arity method uses, and the checked Variant
 * call (`callMethod`) left to variadic methods and to methods taking or returning a Variant. Each path is
 * exercised with primitives, plain Objects and RefCounted objects, as arguments and as return values.
 *
 * Methods with defaulted trailing parameters are called both with and without those arguments, since
 * the binding always writes the full argument list and a mismatch there is invisible at the call site.
 */
@Script
class IcallTest : Node() {

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

    // --- ptrcall path: booleans, numbers, math types, RID, objects and pointer-backed core types. Methods with a
    // String, Callable, Signal or Variant in their signature are on the Variant call instead. ---

    @Register
    fun ptrcallPrimitiveReturn(): Long = getInstanceId()

    @Register
    fun ptrcallObjectArgumentAndReturn(): Boolean {
        val parent = Node()
        val child = Node()
        parent.addChild(child)
        val returned = child.getParent() === parent
        parent.removeChild(child)
        val detached = child.getParent() == null
        child.free()
        parent.free()
        return returned && detached
    }

    @Register
    fun ptrcallRefCountedArgumentAndReturn(): Boolean {
        val image = Image.createEmpty(2, 2, false, Image.Format.RGBA8)!!
        val texture = ImageTexture.createFromImage(image)!!
        val sprite = Sprite2D()
        sprite.setTexture(texture)
        val sameInstance = sprite.getTexture() === texture
        sprite.free()
        return sameInstance && texture.getWidth() == 2
    }

    // A RefCounted comes out of a ptrcall with a reference the engine hands over, which must be released once the JVM
    // holds its own or every getter call leaks one. Expected: the JVM's reference plus the Sprite2D's.
    @Register
    fun ptrcallRefCountedReturnKeepsReferenceCount(): Int {
        val texture = ImageTexture.createFromImage(Image.createEmpty(2, 2, false, Image.Format.RGBA8))!!
        val sprite = Sprite2D()
        sprite.setTexture(texture)
        repeat(3) { sprite.getTexture() }
        val count = texture.getReferenceCount()
        sprite.free()
        return count
    }

    // --- Variant call path: variadic methods carry their tail as Variants, so the same shapes go through Object.call. ---

    @Register
    fun icallObjectArgumentAndReturn(): Boolean {
        val parent = Node()
        val child = Node()
        parent.call("add_child", child)
        val sameInstance = parent.call("get_child", 0) === child
        parent.free()
        return sameInstance
    }

    @Register
    fun icallRefCountedArgumentAndReturn(): Boolean {
        val texture = ImageTexture.createFromImage(Image.createEmpty(2, 2, false, Image.Format.RGBA8))!!
        val sprite = Sprite2D()
        sprite.call("set_texture", texture)
        val sameInstance = sprite.call("get_texture") === texture
        sprite.free()
        return sameInstance
    }

    @Register
    fun icallRefCountedReturnKeepsReferenceCount(): Int {
        val texture = ImageTexture.createFromImage(Image.createEmpty(2, 2, false, Image.Format.RGBA8))!!
        val sprite = Sprite2D()
        sprite.setTexture(texture)
        repeat(3) { sprite.call("get_texture") }
        val count = texture.getReferenceCount()
        sprite.free()
        return count
    }

    // The three cases below cover a variadic tail of mixed Variant types, an empty tail, and a tail delivered back to
    // the JVM through a signal.
    @Register
    fun callWithVariadicArguments(): Vector2 {
        val control = Control()
        control.call("set_size", Vector2(3.5, 4.5), false)
        val size = control.getSize()
        control.free()
        return size
    }

    @Register
    fun callWithEmptyVariadicTail(): String {
        val label = Label()
        label.text = "variadic"
        val text = label.call("get_text") as String
        label.free()
        return text
    }

    @Emit("count", "label")
    val variadicSignal by signal2<Long, String>()

    @Register
    fun emitSignalWithVariadicArguments(): String {
        var received = ""
        variadicSignal.connectLambda { count, label -> received = "$label:$count" }
        emitSignal("variadic_signal", 7L, "seven")
        return received
    }
}
