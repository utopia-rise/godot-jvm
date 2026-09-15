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
import godot.core.AABB
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.RID
import godot.readReturnValue_AABB
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_RID
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_RID
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * The [VisualInstance3D] is used to connect a resource to a visual representation. All visual 3D
 * nodes inherit from the [VisualInstance3D]. In general, you should not access the [VisualInstance3D]
 * properties directly as they are accessed and managed by the nodes that inherit from
 * [VisualInstance3D]. [VisualInstance3D] is the node representation of the [RenderingServer] instance.
 */
@GodotBaseType
public open class VisualInstance3D : Node3D() {
  /**
   * The render layer(s) this [VisualInstance3D] is drawn on.
   *
   * This object will only be visible for [Camera3D]s whose cull mask includes any of the render
   * layers this [VisualInstance3D] is set to.
   *
   * For [Light3D]s, this can be used to control which [VisualInstance3D]s are affected by a
   * specific light. For [GPUParticles3D], this can be used to control which particles are effected by
   * a specific attractor. For [Decal]s, this can be used to control which [VisualInstance3D]s are
   * affected by a specific decal.
   *
   * To adjust [layers] more easily using a script, use [getLayerMaskValue] and [setLayerMaskValue].
   *
   * **Note:** [VoxelGI], SDFGI and [LightmapGI] will always take all layers into account to
   * determine what contributes to global illumination. If this is an issue, set
   * [GeometryInstance3D.giMode] to [GeometryInstance3D.GI_MODE_DISABLED] for meshes and
   * [Light3D.lightBakeMode] to [Light3D.BAKE_DISABLED] for lights to exclude them from global
   * illumination.
   */
  public final inline var layers: Long
    @JvmName("layersProperty")
    get() = getLayerMask()
    @JvmName("layersProperty")
    set(`value`) {
      setLayerMask(value)
    }

  /**
   * The amount by which the depth of this [VisualInstance3D] will be adjusted when sorting by
   * depth. Uses the same units as the engine (which are typically meters). Adjusting it to a higher
   * value will make the [VisualInstance3D] reliably draw on top of other [VisualInstance3D]s that are
   * otherwise positioned at the same spot. To ensure it always draws on top of other objects around it
   * (not positioned at the same spot), set the value to be greater than the distance between this
   * [VisualInstance3D] and the other nearby [VisualInstance3D]s.
   */
  public final inline var sortingOffset: Float
    @JvmName("sortingOffsetProperty")
    get() = getSortingOffset()
    @JvmName("sortingOffsetProperty")
    set(`value`) {
      setSortingOffset(value)
    }

  /**
   * If `true`, the object is sorted based on the [AABB] center. The object will be sorted based on
   * the global position otherwise.
   *
   * The [AABB] center based sorting is generally more accurate for 3D models. The position based
   * sorting instead allows to better control the drawing order when working with [GPUParticles3D] and
   * [CPUParticles3D].
   */
  public final inline var sortingUseAabbCenter: Boolean
    @JvmName("sortingUseAabbCenterProperty")
    get() = isSortingUseAabbCenter()
    @JvmName("sortingUseAabbCenterProperty")
    set(`value`) {
      setSortingUseAabbCenter(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(803, scriptPtr)
  }

  public open fun _getAabb(): AABB {
    throw NotImplementedError("VisualInstance3D::_getAabb is not implemented.")
  }

  /**
   * Sets the resource that is instantiated by this [VisualInstance3D], which changes how the engine
   * handles the [VisualInstance3D] under the hood. Equivalent to [RenderingServer.instanceSetBase].
   */
  public final fun setBase(base: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, base)
    TransferContext.callMethod(MethodBindings.setBasePtr)
  }

  /**
   * Returns the RID of the resource associated with this [VisualInstance3D]. For example, if the
   * Node is a [MeshInstance3D], this will return the RID of the associated [Mesh].
   */
  public final fun getBase(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBasePtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the RID of this instance. This RID is the same as the RID returned by
   * [RenderingServer.instanceCreate]. This RID is needed if you want to call [RenderingServer]
   * functions directly on this [VisualInstance3D].
   */
  public final fun getInstance(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInstancePtr)
    return TransferContext.readReturnValue_RID()
  }

  public final fun setLayerMask(mask: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mask)
    TransferContext.callMethod(MethodBindings.setLayerMaskPtr)
  }

  public final fun getLayerMask(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLayerMaskPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Based on [value], enables or disables the specified layer in the [layers], given a
   * [layerNumber] between 1 and 20.
   */
  public final fun setLayerMaskValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, layerNumber.toLong(), value)
    TransferContext.callMethod(MethodBindings.setLayerMaskValuePtr)
  }

  /**
   * Returns whether or not the specified layer of the [layers] is enabled, given a [layerNumber]
   * between 1 and 20.
   */
  public final fun getLayerMaskValue(layerNumber: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, layerNumber.toLong())
    TransferContext.callMethod(MethodBindings.getLayerMaskValuePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setSortingOffset(offset: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, offset.toDouble())
    TransferContext.callMethod(MethodBindings.setSortingOffsetPtr)
  }

  public final fun getSortingOffset(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSortingOffsetPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setSortingUseAabbCenter(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setSortingUseAabbCenterPtr)
  }

  public final fun isSortingUseAabbCenter(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSortingUseAabbCenterPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the [AABB] (also known as the bounding box) for this [VisualInstance3D].
   */
  public final fun getAabb(): AABB {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAabbPtr)
    return TransferContext.readReturnValue_AABB()
  }

  public companion object {
    @JvmField
    public val setBaseName: MethodStringName1<VisualInstance3D, Unit, RID> =
        MethodStringName1<VisualInstance3D, Unit, RID>("set_base")

    @JvmField
    public val getBaseName: MethodStringName0<VisualInstance3D, RID> =
        MethodStringName0<VisualInstance3D, RID>("get_base")

    @JvmField
    public val getInstanceName: MethodStringName0<VisualInstance3D, RID> =
        MethodStringName0<VisualInstance3D, RID>("get_instance")

    @JvmField
    public val setLayerMaskName: MethodStringName1<VisualInstance3D, Unit, Long> =
        MethodStringName1<VisualInstance3D, Unit, Long>("set_layer_mask")

    @JvmField
    public val getLayerMaskName: MethodStringName0<VisualInstance3D, Long> =
        MethodStringName0<VisualInstance3D, Long>("get_layer_mask")

    @JvmField
    public val setLayerMaskValueName: MethodStringName2<VisualInstance3D, Unit, Int, Boolean> =
        MethodStringName2<VisualInstance3D, Unit, Int, Boolean>("set_layer_mask_value")

    @JvmField
    public val getLayerMaskValueName: MethodStringName1<VisualInstance3D, Boolean, Int> =
        MethodStringName1<VisualInstance3D, Boolean, Int>("get_layer_mask_value")

    @JvmField
    public val setSortingOffsetName: MethodStringName1<VisualInstance3D, Unit, Float> =
        MethodStringName1<VisualInstance3D, Unit, Float>("set_sorting_offset")

    @JvmField
    public val getSortingOffsetName: MethodStringName0<VisualInstance3D, Float> =
        MethodStringName0<VisualInstance3D, Float>("get_sorting_offset")

    @JvmField
    public val setSortingUseAabbCenterName: MethodStringName1<VisualInstance3D, Unit, Boolean> =
        MethodStringName1<VisualInstance3D, Unit, Boolean>("set_sorting_use_aabb_center")

    @JvmField
    public val isSortingUseAabbCenterName: MethodStringName0<VisualInstance3D, Boolean> =
        MethodStringName0<VisualInstance3D, Boolean>("is_sorting_use_aabb_center")

    @JvmField
    public val getAabbName: MethodStringName0<VisualInstance3D, AABB> =
        MethodStringName0<VisualInstance3D, AABB>("get_aabb")
  }

  public object MethodBindings {
    internal val setBasePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualInstance3D", "set_base", 2722037293)

    internal val getBasePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualInstance3D", "get_base", 2944877500)

    internal val getInstancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualInstance3D", "get_instance", 2944877500)

    internal val setLayerMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualInstance3D", "set_layer_mask", 1286410249)

    internal val getLayerMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualInstance3D", "get_layer_mask", 3905245786)

    internal val setLayerMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualInstance3D", "set_layer_mask_value", 300928843)

    internal val getLayerMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualInstance3D", "get_layer_mask_value", 1116898809)

    internal val setSortingOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualInstance3D", "set_sorting_offset", 373806689)

    internal val getSortingOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualInstance3D", "get_sorting_offset", 1740695150)

    internal val setSortingUseAabbCenterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualInstance3D", "set_sorting_use_aabb_center", 2586408642)

    internal val isSortingUseAabbCenterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualInstance3D", "is_sorting_use_aabb_center", 36873697)

    internal val getAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualInstance3D", "get_aabb", 1068685055)
  }
}
