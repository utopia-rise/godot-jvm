// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit

@GodotBaseType
public open class ScriptLanguage internal constructor() : Object() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(645, scriptPtr)
  }

  public enum class ScriptNameCasing(
    public override val `value`: Long,
  ) : GodotEnum {
    AUTO(0),
    PASCAL_CASE(1),
    SNAKE_CASE(2),
    KEBAB_CASE(3),
    CAMEL_CASE(4),
    ;

    public companion object {
      public fun from(`value`: Long): ScriptNameCasing = entries.first { it.`value` == `value` }
    }
  }

  public companion object

  public object MethodBindings
}
