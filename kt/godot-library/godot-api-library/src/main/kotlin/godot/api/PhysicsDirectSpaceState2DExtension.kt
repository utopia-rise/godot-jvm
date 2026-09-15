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
import godot.core.MethodStringName1
import godot.core.RID
import godot.readReturnValue_BOOL
import godot.writeMethodArguments_RID
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * This class extends [PhysicsDirectSpaceState2D] by providing additional virtual methods that can
 * be overridden. When these methods are overridden, they will be called instead of the internal
 * methods of the physics server.
 *
 * Intended for use with GDExtension to create custom implementations of
 * [PhysicsDirectSpaceState2D].
 */
@GodotBaseType
public abstract class PhysicsDirectSpaceState2DExtension : PhysicsDirectSpaceState2D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(530, scriptPtr)
  }

  public final fun isBodyExcludedFromQuery(body: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, body)
    TransferContext.callMethod(MethodBindings.isBodyExcludedFromQueryPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val isBodyExcludedFromQueryName:
        MethodStringName1<PhysicsDirectSpaceState2DExtension, Boolean, RID> =
        MethodStringName1<PhysicsDirectSpaceState2DExtension, Boolean, RID>("is_body_excluded_from_query")
  }

  public object MethodBindings {
    internal val isBodyExcludedFromQueryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectSpaceState2DExtension", "is_body_excluded_from_query", 4155700596)
  }
}

internal class PhysicsDirectSpaceState2DExtensionDummy : PhysicsDirectSpaceState2DExtension()
