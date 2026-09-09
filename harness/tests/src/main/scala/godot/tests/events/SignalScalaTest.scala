package godot.tests.events

import godot.annotation.{Script, Register, Visible, Emit}
import godot.api.Node
import godot.core.{MethodCallable1, MethodCallable2, MethodStringName1, MethodStringName2, Signal1, Signal2}

@Script
class SignalScalaTest extends Node {
  // Boxed on purpose: Scala erases `Boolean` type arguments to `Object` in the class file, which would
  // leave the signal argument untyped in Godot.
  @Emit
  val readySignal: Signal1[java.lang.Boolean] = Signal1.create(this, "readySignal")

  @Emit
  val payloadSignal: Signal2[String, Integer] = Signal2.create(this, "payloadSignal")

  @Visible
  var methodSignalTriggered: Boolean = false

  @Visible
  var lambdaSignalTriggered: Boolean = false

  @Visible
  var payloadString: String = ""

  @Visible
  var payloadInt: Int = Int.MinValue

  @Register
  override def _ready(): Unit = {
    readySignal.connect(MethodCallable1.create(
      this,
      new MethodStringName1[SignalScalaTest, Void, java.lang.Boolean]("on_ready_signal")
    ))
    payloadSignal.connect(MethodCallable2.create(
      this,
      new MethodStringName2[SignalScalaTest, Void, String, Integer]("on_payload_signal")
    ))

    readySignal.emit(true)
    payloadSignal.emit("scala-events", 23)
  }

  @Register
  def onReadySignal(value: Boolean): Unit = {
    methodSignalTriggered = value
  }

  @Register
  def onPayloadSignal(text: String, value: Integer): Unit = {
    lambdaSignalTriggered = true
    payloadString = text
    payloadInt = value
  }
}

