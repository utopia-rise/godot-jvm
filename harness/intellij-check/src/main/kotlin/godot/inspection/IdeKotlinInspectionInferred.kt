package godot.inspection.inferred

// Manual review mode: Inferred.
// This same source is exercised by the IntelliJ CodeInsight fixture test.
// Inline expectation comments describe what this mode reports and must match the test.

import godot.annotation.*
import godot.annotation.IntRange
import godot.annotation.LongRange
import godot.api.Node
import godot.core.*
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

// Expected no issue: `@Tool` carries `@Script`, so the class is registered.
@Tool
class NotRegisteredButToolFixtureInferred : Node()

// Expected red on the class: it is not `@Script`, but it contains
// registered properties, signals, and functions.
class NotRegisteredButMembersFixtureInferred : Node() {
    // Expected red via the containing class: registered property inside a
    // non-registered class.
    @Export
    @Visible
    var propertyShouldStayRed = 1

    // Expected red via the containing class: registered signal inside a
    // non-registered class.
    @Emit
    val signalShouldStayRed by signal0()

    // Expected red via the containing class: registered function inside a
    // non-registered class.
    @Register
    fun functionShouldStayRed() = propertyShouldStayRed
}

// Expected red: `@Script` is present, but the class does not inherit a
// Godot object type.
@Script
class GodotScriptWithoutGodotBaseFixtureInferred

// Expected no issue: the IDE does not check constructors.
@Script
class GodotScriptWithoutDefaultConstructorFixtureInferred(val number: Int) : Node()

// Expected red on both duplicate declarations: they register the same custom
// Godot class name.
@Script(className = "DuplicateIdeRegistrationNameInferred")
class DuplicateRegisteredNameFixtureOneInferred : Node()

@Script(className = "DuplicateIdeRegistrationNameInferred")
class DuplicateRegisteredNameFixtureTwoInferred : Node()

// Expected red: generic classes cannot be registered.
@Script
class GenericRegisteredClassFixtureInferred<T> : Node()

// Method registration checks.
@Script
class NotificationFunctionWithoutRegisterFixtureInferred : Node() {
    // Expected no issue: lifecycle overrides are registered without `@Register` in this mode.
    override fun _ready() {
    }
}

@Script
abstract class RegisteredAbstractBaseFixtureInferred : Node() {
    @Register
    abstract fun mustStayRegistered()
}

@Script
class OverriddenRegisteredFunctionMissingAnnotationFixtureInferred : RegisteredAbstractBaseFixtureInferred() {
    // Expected red: this overrides an abstract registered function, but the override itself is
    // missing `@Register`.
    override fun mustStayRegistered() {
    }
}

@Script
class RegisterProblemFixtureInferred : Node() {
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

    // Expected no issue: Godot sees an enum as an int.
    @Register
    fun enumParameter(value: SmallEnum): SmallEnum = value
}

// Property registration checks.
@Script
class VisibleProblemFixtureInferred : Node() {
    // Expected no issue: immutable registered properties are exposed as read-only.
    @Visible
    val immutableRegisteredProperty = 1

    // Expected red: core types are not allowed as `lateinit` registered
    // properties.
    @Visible
    lateinit var lateinitCoreTypeProperty: Vector2

    // Expected red: core types are not allowed as nullable registered
    // properties.
    @Visible
    var nullableCoreTypeProperty: Vector2? = null

    // Expected red: this type is neither a supported JVM type nor a Godot/core
    // type, so it cannot be exported/registered.
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
}

// Property hint checks.
@Script
class PropertyHintProblemFixtureInferred : Node() {
    // Expected red: `@IntRange` only makes sense on `Int` properties.
    @IntRange(min = 0, max = 1)
    var intRangeWrongType = ""

    // Expected red: `@LongRange` only makes sense on `Long` properties.
    @LongRange(min = 0, max = 1)
    var longRangeWrongType = 1

    // Expected red: `@FloatRange` only makes sense on `Float` properties.
    @FloatRange(min = 0f, max = 1f)
    var floatRangeWrongType = 1

    // Expected red: `@DoubleRange` only makes sense on `Double` properties.
    @DoubleRange(min = 0.0, max = 1.0)
    var doubleRangeWrongType = 1

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
class EmitProblemFixtureInferred : Node() {
    // Expected red: registered signals have to be immutable `val`.
    @Emit
    var mutableSignal = Signal0("mutableSignal")

    // Expected red: a registered signal must actually have signal type.
    @Emit
    val signalWrongType = 1

    // Expected red: signal arguments must be representable by Godot.
    @Emit
    val signalUnsupportedArgument by signal1<UnsupportedExportedType>()

    // Expected no issue: Godot sees an enum as an int.
    @Emit
    val signalEnumArgument by signal1<SmallEnum>()
}

// RPC annotation checks.
@Script
class RpcAnnotationProblemFixtureInferred : Node() {
    // Expected weak warning: non-zero transfer channels are ignored unless the
    // transfer mode is `UNRELIABLE_ORDERED`.
    @Rpc(transferMode = TransferMode.RELIABLE, transferChannel = 1)
    @Register
    fun rpcChannelIgnored() {
    }
}

// Callable-reference registration checks.
@Script
class CallableReferenceProblemFixtureInferred : Node() {
    @Emit
    val localSignal by signal0()

    @Register
    override fun _ready() {
        // Expected red on the callable reference: connected signal targets must
        // be registered functions.
        localSignal.connectMethod(this, CallableReferenceProblemFixtureInferred::signalTargetNotRegistered)
        // Expected red on the callable reference: Godot callable targets must
        // be registered functions.
        lambdaCallable0(this::callTargetNotRegistered).call()
        // Expected red on the callable reference: RPC targets must be
        // registered functions.
        rpc(::rpcTargetNotRegistered)
        // Expected red on the callable reference: RPC targets also need the
        // `@Rpc` annotation.
        rpc(::rpcTargetMissingRpc)
        // Expected red on the callable reference: the target has `@Rpc`, but it
        // is explicitly disabled via `RpcMode.DISABLED`.
        rpc(::rpcTargetDisabled)
    }

    // Expected red when referenced from `connectMethod`: missing
    // `@Register`.
    fun signalTargetNotRegistered() {
    }

    // Expected red when referenced from `call()`: missing `@Register`.
    fun callTargetNotRegistered() {
    }

    // Expected red when referenced from `rpc()`: missing `@Register`.
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


