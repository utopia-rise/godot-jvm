package godot.inspection.automatic

// Manual review mode: Automatic.
// This same source is exercised by the IntelliJ CodeInsight fixture test.
// Inline expectation comments describe what this mode reports and must match the test.

import godot.annotation._
import godot.api.InputEvent
import godot.api.Node
import godot.core.{Callable0, Signal0, Signal1, StringNames}

class ScalaUnsupportedType

// Class-level registration checks.

// Expected no issue: the class is registered automatically.
@Tool
class ScalaNotRegisteredButToolFixtureAutomatic extends Node

// Expected no issue: the class is registered automatically, and its members with it.
class ScalaNotRegisteredButMembersFixtureAutomatic extends Node {
  // Expected no issue: registered with its automatically registered class.
  @Export
  @Visible
  var propertyShouldStayRed = 1

  // Expected no issue: registered with its automatically registered class.
  @Emit
  val signalShouldStayRed = new Signal0(this, StringNames.asStringName("signalShouldStayRed"))

  // Expected no issue: registered with its automatically registered class.
  def functionShouldStayRed(): Int = propertyShouldStayRed
}

// Expected no issue: only Godot subclasses are script candidates in this mode, so the class is
// ignored.
@Script
class ScalaGodotScriptWithoutGodotBaseFixtureAutomatic

// Expected no issue: the IDE does not check constructors.
@Script
class ScalaGodotScriptWithoutDefaultConstructorFixtureAutomatic(number: Int) extends Node

// Expected red on both duplicate declarations: they register the same custom
// Godot class name.
@Script(className = "DuplicateScalaInspectionNameAutomatic")
class ScalaDuplicateRegisteredNameFixtureOneAutomatic extends Node

@Script(className = "DuplicateScalaInspectionNameAutomatic")
class ScalaDuplicateRegisteredNameFixtureTwoAutomatic extends Node

// Expected red: generic classes cannot be registered.
@Script
class ScalaGenericRegisteredClassFixtureAutomatic[T] extends Node

// Method registration checks.
@Script
class IdeScalaInspectionAutomatic extends Node {
  // Expected no issue: lifecycle overrides are registered without `@Register` in this mode.
  override def _ready(): Unit = {
  }

  // Expected no issue: Godot virtual function overrides are registered without `@Register` in this mode.
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


