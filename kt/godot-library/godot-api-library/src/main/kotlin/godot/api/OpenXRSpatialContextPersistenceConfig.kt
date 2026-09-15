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
import godot.core.MethodStringName1
import godot.core.RID
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser._RID
import kotlin.Any
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Configuration header for spatial persistence. Pass this to
 * [OpenXRSpatialEntityExtension.createSpatialContext] as the next parameter to create a spatial
 * context with spatial persistence capabilities.
 */
@GodotBaseType
public open class OpenXRSpatialContextPersistenceConfig : OpenXRStructureBase() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(488, scriptPtr)
  }

  /**
   * Adds a persistence context to this configuration. You must add at least one persistence context
   * to create a valid configuration. You can create a persistence context by calling
   * [OpenXRSpatialAnchorCapability.createPersistenceContext].
   */
  public final fun addPersistenceContext(persistenceContext: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to persistenceContext)
    TransferContext.callMethod(MethodBindings.addPersistenceContextPtr)
  }

  /**
   * Removes a persistence context.
   */
  public final fun removePersistenceContext(persistenceContext: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to persistenceContext)
    TransferContext.callMethod(MethodBindings.removePersistenceContextPtr)
  }

  /**
   * Gets the persistence context(s) (as [RID]s) received by [addPersistenceContext].
   */
  public final fun getPersistenceContexts(): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPersistenceContextsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  public companion object {
    @JvmField
    public val addPersistenceContextName:
        MethodStringName1<OpenXRSpatialContextPersistenceConfig, Unit, RID> =
        MethodStringName1<OpenXRSpatialContextPersistenceConfig, Unit, RID>("add_persistence_context")

    @JvmField
    public val removePersistenceContextName:
        MethodStringName1<OpenXRSpatialContextPersistenceConfig, Unit, RID> =
        MethodStringName1<OpenXRSpatialContextPersistenceConfig, Unit, RID>("remove_persistence_context")

    @JvmField
    public val getPersistenceContextsName:
        MethodStringName0<OpenXRSpatialContextPersistenceConfig, VariantArray<Any?>> =
        MethodStringName0<OpenXRSpatialContextPersistenceConfig, VariantArray<Any?>>("get_persistence_contexts")
  }

  public object MethodBindings {
    internal val addPersistenceContextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialContextPersistenceConfig", "add_persistence_context", 2722037293)

    internal val removePersistenceContextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialContextPersistenceConfig", "remove_persistence_context", 2722037293)

    internal val getPersistenceContextsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialContextPersistenceConfig", "get_persistence_contexts", 3995934104)
  }
}
