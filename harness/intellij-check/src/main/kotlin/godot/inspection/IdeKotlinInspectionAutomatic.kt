package godot.inspection.automatic

// Manual review mode: Automatic.
// This same source is exercised by the IntelliJ CodeInsight fixture test.
// Inline expectation comments describe what this mode reports and must match the test.

import godot.annotation.*
import godot.annotation.IntRange
import godot.api.InputEvent
import godot.api.Node
import godot.core.*
import godot.extension.connectLambda
import godot.extension.connectMethod

class UnsupportedExportedType

enum class SmallEnum {
    A,
    B,
}

enum class LargeEnum {
    E01, E02, E03, E04, E05, E06, E07, E08, E09, E10, E11,
    E12, E13, E14, E15, E16, E17, E18, E19, E20, E21, E22,
    E23, E24, E25, E26, E27, E28, E29, E30, E31, E32, E33,
}

// Expected warning: registration ignores a class that is not public.
@Script
private class PrivateScriptFixtureAutomatic : Node()

// Expected no issue: the class is registered automatically.
@Tool
class NotRegisteredButToolFixtureAutomatic : Node()

// Expected no issue: the class is registered automatically, and its members with it.
class NotRegisteredButMembersFixtureAutomatic : Node() {
    // Expected no issue: registered with its automatically registered class.
    @Export
    @Visible
    var propertyShouldStayRed = 1

    // Expected no issue: registered with its automatically registered class.
    @Emit
    val signalShouldStayRed by signal0()

    // Expected no issue: registered with its automatically registered class.
    fun functionShouldStayRed() = propertyShouldStayRed
}

// Expected red: `@Script` is written, so the class is registered although it does not inherit a
// Godot object type.
@Script
class GodotScriptWithoutGodotBaseFixtureAutomatic

// Expected no issue: the IDE does not check constructors.
@Script
class GodotScriptWithoutDefaultConstructorFixtureAutomatic(val number: Int) : Node()

// Expected red on both duplicate declarations: they register the same custom
// Godot class name.
@Script(className = "DuplicateIdeRegistrationNameAutomatic")
class DuplicateRegisteredNameFixtureOneAutomatic : Node()

@Script(className = "DuplicateIdeRegistrationNameAutomatic")
class DuplicateRegisteredNameFixtureTwoAutomatic : Node()

// Expected red: generic classes cannot be registered.
@Script
class GenericRegisteredClassFixtureAutomatic<T> : Node()

// Method registration checks.
@Script
class NotificationFunctionWithoutRegisterFixtureAutomatic : Node() {
    // Expected no issue: lifecycle overrides are registered without `@Register` in this mode.
    override fun _ready() {
    }

    // Expected no issue: Godot virtual function overrides are registered without `@Register` in this mode.
    override fun _shortcutInput(event: InputEvent) {
    }

    // Expected red: a `@Notification` function cannot have parameters.
    @Notification(1)
    fun notificationWithParameter(value: Int) {
    }

    // Expected red: a `@Notification` function must return Unit.
    @Notification(2)
    fun notificationWithReturnValue(): Int = 0
}

@Script
abstract class RegisteredAbstractBaseFixtureAutomatic : Node() {
    @Register
    abstract fun mustStayRegistered()

    // Expected red: parameter and return types must be representable by Godot.
    @Register
    abstract fun mustStayRegisteredWithUnsupportedType(value: UnsupportedExportedType)
}

@Script
class OverriddenRegisteredFunctionMissingAnnotationFixtureAutomatic : RegisteredAbstractBaseFixtureAutomatic() {
    // Expected no issue: the override inherits its registration in this mode.
    override fun mustStayRegistered() {
    }

    // Expected no issue: the parameter type keeps this override out of automatic registration, and
    // missing registration is never reported in this mode.
    override fun mustStayRegisteredWithUnsupportedType(value: UnsupportedExportedType) {
    }
}

@Script
class RegisterProblemFixtureAutomatic : Node() {
    // Expected red: generic functions cannot be registered.
    @Register
    fun <T> genericRegisteredFunction(value: T) {
    }

    // Expected red: registered functions may not exceed the max supported
    // parameter count.
    @Register
    fun tooManyParameters(
        p01: Int, p02: Int, p03: Int, p04: Int, p05: Int, p06: Int,
        p07: Int, p08: Int, p09: Int, p10: Int, p11: Int, p12: Int,
        p13: Int, p14: Int, p15: Int, p16: Int, p17: Int,
    ) {
    }

    // Expected red: parameter and return types must be representable by Godot.
    @Register
    fun unsupportedParameterType(value: UnsupportedExportedType) {
    }

    @Register
    fun unsupportedReturnType(): UnsupportedExportedType = UnsupportedExportedType()

    // Expected red: typed callables and signals must be declared as the base `Callable` or `Signal`.
    @Register
    fun typedSignalParameter(signal: Signal1<Int>) {
    }

    @Register
    fun typedCallableReturn(): Callable0<Int> = lambdaCallable0 { 0 }

    // Expected no issue: Godot sees an enum as an int.
    @Register
    fun enumParameter(value: SmallEnum): SmallEnum = value
}

// Property registration checks.
@Script
class VisibleProblemFixtureAutomatic : Node() {
    // Expected no issue: immutable registered properties are exposed as read-only.
    @Visible
    val immutableRegisteredProperty = 1

    // Expected no issue: a `@JvmField` property is registered through its field.
    @JvmField
    @Visible
    var jvmFieldProperty = 1

    // Expected red: core types are not allowed as `lateinit` registered
    // properties.
    @Visible
    lateinit var lateinitCoreTypeProperty: Vector2

    // Expected red: core types are not allowed as nullable registered
    // properties.
    @Visible
    var nullableCoreTypeProperty: Vector2? = null

    // Expected red: the annotation registers the property in this mode too, and this type cannot be
    // registered.
    @Visible
    var unsupportedExportedType = UnsupportedExportedType()

    // Expected red: `VariantArray<Enum>` is explicitly rejected by the
    // inspection.
    @Visible
    var enumVariantArray = VariantArray<SmallEnum>()

    // Expected no issue: `@Export` registers the property in this mode.
    @Export
    var exportWithoutVisible = 1

    // Expected no issue: `@Storage` registers the property in this mode.
    @Storage
    var storageWithoutVisible = 1

    // Expected warning: registration ignores a property that is not public.
    @Visible
    private var privateRegisteredProperty = 1

    // Expected no issue: companion and nested object members belong to other
    // JVM classes, so they are never registered with this script.
    companion object {
        var companionNullableProperty: Int? = null
        const val COMPANION_CONSTANT = 1
        var companionMutableSignal: Signal0? = null
    }

    object NestedObject {
        var nestedNullableProperty: Int? = null
        var nestedMutableSignal: Signal0? = null
    }
}

// Property hint checks.
@Script
class PropertyHintProblemFixtureAutomatic : Node() {
    // Expected red: `@IntRange` only makes sense on integer properties.
    @IntRange(min = 0, max = 1)
    var intRangeWrongType = ""

    // Expected red: an integer range does not apply to a float property.
    @IntRange(min = 0, max = 1)
    var intRangeOnDouble = 1.0

    // Expected red: a float range does not apply to an integer property.
    @FloatRange(min = 0.0, max = 1.0)
    var floatRangeWrongType = 1

    // Expected no issue: `@IntRange` applies to every integer type.
    @Export
    @Visible
    @IntRange(min = 0, max = 1)
    var intRangeOnLong = 1L

    // Expected no issue: `@FloatRange` applies to `Float` and `Double`.
    @Export
    @Visible
    @FloatRange(min = 0.0, max = 1.0)
    var floatRangeOnDouble = 1.0

    // Expected red: `@ExpEasing` only makes sense on `Float` or `Double`
    // properties.
    @ExpEasing
    var expEasingWrongType = 1

    // Expected red: `@IntFlag` only makes sense on `Int` properties.
    @IntFlag("a")
    var intFlagWrongType = ""

    // Expected red: a bitfield is capped at 32 entries, and this enum is
    // intentionally larger.
    @Export
    @Visible
    var bitFlagTooManyEntries: BitField<LargeEnum> = BitField.of(LargeEnum.E01)

    // Expected red: `@File` only makes sense on `String` properties.
    @File
    var fileWrongType = 1

    // Expected red: `@Dir` only makes sense on `String` properties.
    @Dir
    var dirWrongType = 1

    // Expected red: `@MultilineText` only makes sense on `String` properties.
    @MultilineText
    var multilineTextWrongType = 1

    // Expected red: `@PlaceHolderText` only makes sense on `String`
    // properties.
    @PlaceHolderText
    var placeholderTextWrongType = 1

    // Expected red: `@ColorNoAlpha` only makes sense on `Color` properties.
    @ColorNoAlpha
    var colorNoAlphaWrongType = 1
}

// Signal registration checks.
@Script
class EmitProblemFixtureAutomatic : Node() {
    // Expected red: registered signals have to be immutable `val`.
    @Emit
    var mutableSignal = Signal0("mutableSignal")

    // Expected red: a registered signal must actually have signal type.
    @Emit
    val signalWrongType = 1

    // Expected red: signal arguments must be representable by Godot.
    @Emit
    val signalUnsupportedArgument by signal1<UnsupportedExportedType>()

    // Expected red: typed callables and signals must be declared as the base `Callable` or `Signal`.
    @Emit
    val signalTypedCallableArgument by signal1<Callable0<Int>>()

    // Expected no issue: Godot sees an enum as an int.
    @Emit
    val signalEnumArgument by signal1<SmallEnum>()

    // Expected no issue: a `@JvmField` signal is registered through its field.
    @JvmField
    @Emit
    val jvmFieldSignal = Signal0("jvmFieldSignal")
}

// Declaration shape checks: registration only reaches public instance members of a public class.
// Expected warning: an object cannot be registered.
@Script
object ObjectScriptFixtureAutomatic : Node()

@Script
class ShapeProblemFixtureAutomatic : Node() {
    // Expected warning: a private function is ignored by registration.
    @Register
    private fun privateRegisteredFunction() {
    }

    // Expected warning: an extension function is ignored by registration.
    @Register
    fun Node.extensionRegisteredFunction() {
    }

    // Expected warning on both: registered functions cannot share a name.
    @Register
    fun overloadedRegisteredFunction() {
    }

    @Register
    fun overloadedRegisteredFunction(value: Int) {
    }
}

// RPC annotation checks.
@Script
class RpcAnnotationProblemFixtureAutomatic : Node() {
    // Expected weak warning: non-zero transfer channels are ignored unless the
    // transfer mode is `UNRELIABLE_ORDERED`.
    @Rpc(transferMode = TransferMode.RELIABLE, transferChannel = 1)
    @Register
    fun rpcChannelIgnored() {
    }
}

// Callable-reference registration checks.
@Script
class CallableReferenceProblemFixtureAutomatic : Node() {
    @Emit
    val localSignal by signal0()

    @Register
    override fun _ready() {
        // Expected no issue: the target is registered automatically.
        localSignal.connectMethod(this, CallableReferenceProblemFixtureAutomatic::signalTargetNotRegistered)
        // Expected no issue: the target is registered automatically.
        methodCallable0(this, CallableReferenceProblemFixtureAutomatic::callTargetNotRegistered).call()
        // Expected no issue: a lambda callable runs the function on the JVM, so it needs no registration.
        lambdaCallable0(this::lambdaTarget).call()
        // Expected red on the callable reference: the target is registered automatically but still
        // needs `@Rpc`.
        rpc(::rpcTargetNotRegistered)
        // Expected red on the callable reference: RPC targets also need the
        // `@Rpc` annotation.
        rpc(::rpcTargetMissingRpc)
        // Expected red on the callable reference: the target has `@Rpc`, but it
        // is explicitly disabled via `RpcMode.DISABLED`.
        rpc(::rpcTargetDisabled)
        // Expected no issue: none of these function references is called by name.
        localSignal.connectLambda { runCallback(::plainHelper) }
        localSignal.connectLambda(method = ::plainHelper)
        rpc(::rpcTargetWithArgument, describe(::plainHelper))
    }

    private fun runCallback(callback: () -> Unit) = callback()

    private fun describe(callback: () -> Unit) = callback.toString()

    @Rpc
    @Register
    fun rpcTargetWithArgument(value: String) {
    }

    private fun plainHelper() {
    }

    // Expected no issue: registered automatically.
    fun signalTargetNotRegistered() {
    }

    // Expected no issue: registered automatically.
    fun callTargetNotRegistered() {
    }

    private fun lambdaTarget() {
    }

    // Expected red when referenced from `rpc()`: registered automatically, but missing `@Rpc`.
    fun rpcTargetNotRegistered() {
    }

    // Expected red when referenced from `rpc()`: registered, but missing
    // `@Rpc`.
    @Register
    fun rpcTargetMissingRpc() {
    }

    // Expected red when referenced from `rpc()`: RPC-enabled, but explicitly
    // disabled for network access.
    @Rpc(rpcMode = RpcMode.DISABLED)
    @Register
    fun rpcTargetDisabled() {
    }
}


