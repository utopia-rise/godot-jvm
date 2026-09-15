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
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Object for storing OpenXR spatial entity component data.
 */
@GodotBaseType
public open class OpenXRSpatialComponentData : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(479, scriptPtr)
  }

  /**
   * Sets the expected capacity as provided by the spatial entities query system. Buffers should be
   * initialized with the correct storage.
   */
  public open fun _setCapacity(capacity: Long): Unit {
    throw NotImplementedError("OpenXRSpatialComponentData::_setCapacity is not implemented.")
  }

  /**
   * Return the component type for the component we store data for.
   */
  public open fun _getComponentType(): Long {
    throw NotImplementedError("OpenXRSpatialComponentData::_getComponentType is not implemented.")
  }

  /**
   * Return a pointer to the structure data that will be submitted along with the snapshot query.
   * This pointer must remain valid as long as this object is instantiated.
   */
  public open fun _getStructureData(next: Long): Long {
    throw NotImplementedError("OpenXRSpatialComponentData::_getStructureData is not implemented.")
  }

  /**
   * Sets the expected capacity as provided by the spatial entities query system. Buffers should be
   * initialized with the correct storage.
   */
  public final fun setCapacity(capacity: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, capacity)
    TransferContext.callMethod(MethodBindings.setCapacityPtr)
  }

  /**
   * Gets this [OpenXRSpatialComponentData]'s `XrSpatialComponentTypeEXT`.
   */
  public final fun getComponentType(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getComponentTypePtr)
    return TransferContext.readReturnValue_LONG()
  }

  public companion object {
    @JvmField
    public val setCapacityName: MethodStringName1<OpenXRSpatialComponentData, Unit, Long> =
        MethodStringName1<OpenXRSpatialComponentData, Unit, Long>("set_capacity")

    @JvmField
    public val getComponentTypeName: MethodStringName0<OpenXRSpatialComponentData, Long> =
        MethodStringName0<OpenXRSpatialComponentData, Long>("get_component_type")
  }

  public object MethodBindings {
    internal val setCapacityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialComponentData", "set_capacity", 1286410249)

    internal val getComponentTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRSpatialComponentData", "get_component_type", 3905245786)
  }
}
