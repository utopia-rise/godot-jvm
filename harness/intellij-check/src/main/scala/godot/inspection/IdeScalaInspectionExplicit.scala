package godot.inspection.explicit

// Manual review mode: Explicit.
// This same source is exercised by the IntelliJ CodeInsight fixture test.
// Inline expectation comments describe what this mode reports and must match the test.

import godot.annotation._
import godot.api.InputEvent
import godot.api.Node
import godot.core.{Callable0, Signal0, Signal1, StringNames}

class ScalaUnsupportedType

// Class-level registration checks.

// Expected red: `@Tool` requires the class itself to be registered.
@Tool
class ScalaNotRegisteredButToolFixtureExplicit extends Node

// Expected red on the class: it is not `@Script`, but it contains
// registered properties, signals, and functions.
class ScalaNotRegisteredButMembersFixtureExplicit extends Node {
  // Expected red via the containing class: registered property inside a
  // non-registered class.
  @Export
  @Visible
  var propertyShouldStayRed = 1

  // Expected red via the containing class: registered signal inside a
  // non-registered class.
  @Emit
  val signalShouldStayRed = new Signal0(this, StringNames.asStringName("signalShouldStayRed"))

  // Expected red via the containing class: registered function inside a
  // non-registered class.
  @Register
  def functionShouldStayRed(): Int = propertyShouldStayRed
}

// Expected red: `@Script` is present, but the class does not inherit a
// Godot object type.
@Script
class ScalaGodotScriptWithoutGodotBaseFixtureExplicit

// Expected no issue: the IDE does not check constructors.
@Script
class ScalaGodotScriptWithoutDefaultConstructorFixtureExplicit(number: Int) extends Node

// Expected red on both duplicate declarations: they register the same custom
// Godot class name.
@Script(className = "DuplicateScalaInspectionNameExplicit")
class ScalaDuplicateRegisteredNameFixtureOneExplicit extends Node

@Script(className = "DuplicateScalaInspectionNameExplicit")
class ScalaDuplicateRegisteredNameFixtureTwoExplicit extends Node

// Expected red: generic classes cannot be registered.
@Script
class ScalaGenericRegisteredClassFixtureExplicit[T] extends Node

// Method registration checks.
@Script
class IdeScalaInspectionExplicit extends Node {
  // Expected red: notification callbacks like `_ready` must also carry
  // `@Register` inside a registered class.
  override def _ready(): Unit = {
  }

  // Expected red: `_shortcutInput` is a Godot virtual function too, so it must also carry
  // `@Register` inside a registered class.
  override def _shortcutInput(event: InputEvent): Unit = {
  }

  // Expected red: a `@Notification` function cannot have parameters.
  @Notification(1)
  def notificationWithParameter(value: Int): Unit = {
  }

  // Expected red: a `@Notification` function must return Unit.
  @Notification(2)
  def notificationWithReturnValue(): Int = 0

  // Expected red: generic functions cannot be registered.
  @Register
  def genericRegisteredFunction[T](value: T): Unit = {
  }

  // Expected red: registered functions may not exceed the max supported
  // parameter count.
  @Register
  def tooManyParameters(
                         p01: Int,
                         p02: Int,
                         p03: Int,
                         p04: Int,
                         p05: Int,
                         p06: Int,
                         p07: Int,
                         p08: Int,
                         p09: Int,
                         p10: Int,
                         p11: Int,
                         p12: Int,
                         p13: Int,
                         p14: Int,
                         p15: Int,
                         p16: Int,
                         p17: Int
                       ): Unit = {
  }

  // Expected red: parameter and return types must be representable by Godot.
  @Register
  def unsupportedParameterType(value: ScalaUnsupportedType): Unit = {
  }

  @Register
  def unsupportedReturnType(): ScalaUnsupportedType = new ScalaUnsupportedType

  // Expected red: typed callables and signals must be declared as the base `Callable` or `Signal`.
  @Register
  def typedSignalParameter(signal: Signal1[Integer]): Unit = {
  }

  @Register
  def typedCallableReturn(): Callable0[Integer] = null
}


