package godot.tests.registration

import godot.annotation.{Emit, Export, Register, Script, Visible}
import godot.api.{Control, Node}
import godot.core.{BitField, Callable, LambdaCallable1, Signal1}
import godot.tests.ScalaEnum

@Script
class TypeRoundTripScala extends Node {
  @Export
  @Visible
  var flagList: java.util.List[ScalaEnum] = new java.util.ArrayList(java.util.List.of(ScalaEnum.SCALA_ENUM_1))

  @Visible
  val readOnlyCount: Int = 7

  @Visible
  val readOnlyFlagList: java.util.List[ScalaEnum] = java.util.List.of(ScalaEnum.SCALA_ENUM_2)

  @Visible
  val readOnlyBitField: BitField[ScalaEnum] = new BitField[ScalaEnum](3)

  @Emit
  val bitFieldSignal: Signal1[BitField[ScalaEnum]] = Signal1.create(this, "bitFieldSignal")

  @Visible
  val bitFieldCallable: Callable = LambdaCallable1.create(
    classOf[java.lang.Long],
    classOf[BitField[ScalaEnum]],
    (flags: BitField[ScalaEnum]) => java.lang.Long.valueOf(flags.getFlag)
  )

  @Register
  def echoBitField(flags: BitField[ScalaEnum]): BitField[ScalaEnum] = flags

  @Register
  def aliasedEngineEnumRoundTrips(): Boolean = {
    val control = new Control()
    control.setLayoutDirection(Control.LayoutDirection.APPLICATION_LOCALE)
    val roundTrips = control.getLayoutDirection() == Control.LayoutDirection.APPLICATION_LOCALE
    control.free()
    roundTrips
  }

  @Register
  def emitBitField(value: Long): Unit = bitFieldSignal.emit(new BitField[ScalaEnum](value))
}
