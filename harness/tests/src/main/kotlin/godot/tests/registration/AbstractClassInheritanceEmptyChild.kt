package godot.tests.registration

import godot.annotation.Script
import godot.api.CharacterBody3D

// issue: https://github.com/utopia-rise/godot-jvm/issues/365
abstract class AbstractClassInheritanceEmptyParent : CharacterBody3D()

// issue: https://github.com/utopia-rise/godot-jvm/issues/365
@Script
class AbstractClassInheritanceEmptyChild : AbstractClassInheritanceEmptyParent()
