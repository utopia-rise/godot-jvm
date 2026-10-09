package godot.tests.registration

import godot.annotation.Emit
import godot.annotation.Export
import godot.annotation.Register
import godot.annotation.Script
import godot.annotation.Visible
import godot.api.Control
import godot.api.Node
import godot.core.BitField
import godot.core.Callable
import godot.core.lambdaCallable1
import godot.core.signal1

@Script
class TypeRoundTripKotlin : Node() {
    enum class Flag { FIRST, SECOND }

    @Export
    @Visible
    var flagList: List<Flag> = listOf(Flag.FIRST)

    @Visible
    val readOnlyCount: Int = 7

    @Visible
    val readOnlyFlagList: List<Flag> = listOf(Flag.SECOND)

    @Visible
    val readOnlyBitField: BitField<Flag> = BitField(3)

    @Emit
    val bitFieldSignal by signal1<BitField<Flag>>()

    @Visible
    val bitFieldCallable: Callable = lambdaCallable1<Long, BitField<Flag>> { flags -> flags.flag }

    @Register
    fun echoBitField(flags: BitField<Flag>): BitField<Flag> = flags

    @Register
    fun aliasedEngineEnumRoundTrips(): Boolean {
        val control = Control()
        control.setLayoutDirection(Control.LayoutDirection.APPLICATION_LOCALE)
        val roundTrips = control.getLayoutDirection() == Control.LayoutDirection.APPLICATION_LOCALE
        control.free()
        return roundTrips
    }

    @Register
    fun emitBitField(value: Long) {
        bitFieldSignal.emit(BitField(value))
    }
}
