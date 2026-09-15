// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.VariantCaster.ANY
import kotlin.Any
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

@GodotBaseType
public open class JvmScript internal constructor() : Script() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(344, scriptPtr)
  }

  public final fun new(): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.newPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  public companion object {
    @JvmField
    public val newName: MethodStringName0<JvmScript, Any?> =
        MethodStringName0<JvmScript, Any?>("new")
  }

  public object MethodBindings {
    internal val newPtr: VoidPtr = TypeManager.getMethodBindPtr("JvmScript", "new", 1460262497)
  }
}
