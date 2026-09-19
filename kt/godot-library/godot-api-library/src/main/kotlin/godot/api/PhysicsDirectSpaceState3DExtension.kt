// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod_RID_ret_BOOL
import godot.common.interop.VoidPtr
import godot.core.MethodStringName1
import godot.core.RID
import godot.core.Vector3
import kotlin.Boolean
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * This class extends [PhysicsDirectSpaceState3D] by providing additional virtual methods that can
 * be overridden. When these methods are overridden, they will be called instead of the internal
 * methods of the physics server.
 *
 * Intended for use with GDExtension to create custom implementations of
 * [PhysicsDirectSpaceState3D].
 */
@GodotBaseType
public abstract class PhysicsDirectSpaceState3DExtension : PhysicsDirectSpaceState3D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(532, scriptPtr)
  }

  public abstract fun _getClosestPointToObjectVolume(`object`: RID, point: Vector3): Vector3

  public final fun isBodyExcludedFromQuery(body: RID): Boolean =
      TransferContext.callPtrMethod_RID_ret_BOOL(ptr, objectID.id, MethodBindings.isBodyExcludedFromQueryPtr, body)

  public companion object {
    @JvmField
    public val isBodyExcludedFromQueryName:
        MethodStringName1<PhysicsDirectSpaceState3DExtension, Boolean, RID> =
        MethodStringName1<PhysicsDirectSpaceState3DExtension, Boolean, RID>("is_body_excluded_from_query")
  }

  public object MethodBindings {
    internal val isBodyExcludedFromQueryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PhysicsDirectSpaceState3DExtension", "is_body_excluded_from_query", 4155700596)
  }
}

internal class PhysicsDirectSpaceState3DExtensionDummy : PhysicsDirectSpaceState3DExtension() {
  public override fun _getClosestPointToObjectVolume(`object`: RID, point: Vector3): Vector3 {
    throw NotImplementedError("PhysicsDirectSpaceState3DExtension::_getClosestPointToObjectVolume is only implemented by non-JVM code.")
  }
}
