package godot.tests.events

import godot.annotation.{Script, Register, Visible}
import godot.api.Node
import godot.core.{Callable, LambdaCallable0, LambdaCallable1}

@Script
class LambdaCallableScalaTest extends Node {
  @Visible
  var callableNoParamTriggered: Boolean = false

  @Visible
  var callableWithParamTriggered: Boolean = false

  @Visible
  var callableString: String = ""

  @Visible
  var callableProperty: Callable = LambdaCallable1.create(
    classOf[String],
    (value: String) => callableString = value
  )

  @Register
  def markCallableNoParamTriggered(): Unit = {
    callableNoParamTriggered = true
  }

  @Register
  def callCallableNoParam(): Unit = {
    LambdaCallable0.create(() => markCallableNoParamTriggered()).call()
  }

  @Register
  def callCallableNoParamDeferred(): Unit = {
    LambdaCallable0.create(() => markCallableNoParamTriggered()).callDeferred()
  }

  @Register
  def markCallableWithParamTriggered(flag: Boolean): Unit = {
    callableWithParamTriggered = flag
  }

  @Register
  def callCallableWithParam(): Unit = {
    LambdaCallable1.create(classOf[Boolean], (flag: Boolean) => markCallableWithParamTriggered(flag)).call(true)
  }

  @Register
  def callCallableWithParamDeferred(): Unit = {
    LambdaCallable1.create(classOf[Boolean], (flag: Boolean) => markCallableWithParamTriggered(flag)).callDeferred(true)
  }

  @Register
  // ART's verifier rejects the primitive-returning lambda Scala emits for classOf[Int], so the boxed class is used.
  def callPrimitiveReturnCallable(): Int = LambdaCallable0.create(classOf[Integer], () => Integer.valueOf(7)).call()

  @Register
  def callVoidReturnCallable(): Boolean = {
    LambdaCallable0.create(classOf[Unit], () => markCallableNoParamTriggered()).call()
    callableNoParamTriggered
  }
}
