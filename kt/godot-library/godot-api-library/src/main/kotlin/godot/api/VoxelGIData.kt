// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_AABB
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_PACKED_BYTE_ARRAY
import godot.callPtrMethod0_ret_PACKED_INT_32_ARRAY
import godot.callPtrMethod0_ret_TRANSFORM3D
import godot.callPtrMethod0_ret_VECTOR3
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_TRANSFORM3D_AABB_VECTOR3_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_PACKED_INT_32_ARRAY
import godot.common.interop.VoidPtr
import godot.core.AABB
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName7
import godot.core.PackedByteArray
import godot.core.PackedInt32Array
import godot.core.Transform3D
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [VoxelGIData] contains baked voxel global illumination for use in a [VoxelGI] node. [VoxelGIData]
 * also offers several properties to adjust the final appearance of the global illumination. These
 * properties can be adjusted at run-time without having to bake the [VoxelGI] node again.
 *
 * **Note:** To prevent text-based scene files (`.tscn`) from growing too much and becoming slow to
 * load and save, always save [VoxelGIData] to an external binary resource file (`.res`) instead of
 * embedding it within the scene. This can be done by clicking the dropdown arrow next to the
 * [VoxelGIData] resource, choosing **Edit**, clicking the floppy disk icon at the top of the Inspector
 * then choosing **Save As...**.
 */
@GodotBaseType
public open class VoxelGIData : Resource() {
  /**
   * The dynamic range to use (`1.0` represents a low dynamic range scene brightness). Higher values
   * can be used to provide brighter indirect lighting, at the cost of more visible color banding in
   * dark areas (both in indirect lighting and reflections). To avoid color banding, it's recommended
   * to use the lowest value that does not result in visible light clipping.
   */
  public final inline var dynamicRange: Float
    @JvmName("dynamicRangeProperty")
    get() = getDynamicRange()
    @JvmName("dynamicRangeProperty")
    set(`value`) {
      setDynamicRange(value)
    }

  /**
   * The energy of the indirect lighting and reflections produced by the [VoxelGI] node. Higher
   * values result in brighter indirect lighting. If indirect lighting looks too flat, try decreasing
   * [propagation] while increasing [energy] at the same time. See also [useTwoBounces] which
   * influences the indirect lighting's effective brightness.
   */
  public final inline var energy: Float
    @JvmName("energyProperty")
    get() = getEnergy()
    @JvmName("energyProperty")
    set(`value`) {
      setEnergy(value)
    }

  /**
   * The normal bias to use for indirect lighting and reflections. Higher values reduce
   * self-reflections visible in non-rough materials, at the cost of more visible light leaking and
   * flatter-looking indirect lighting. To prioritize hiding self-reflections over lighting quality,
   * set [bias] to `0.0` and [normalBias] to a value between `1.0` and `2.0`.
   */
  public final inline var bias: Float
    @JvmName("biasProperty")
    get() = getBias()
    @JvmName("biasProperty")
    set(`value`) {
      setBias(value)
    }

  /**
   * The normal bias to use for indirect lighting and reflections. Higher values reduce
   * self-reflections visible in non-rough materials, at the cost of more visible light leaking and
   * flatter-looking indirect lighting. See also [bias]. To prioritize hiding self-reflections over
   * lighting quality, set [bias] to `0.0` and [normalBias] to a value between `1.0` and `2.0`.
   */
  public final inline var normalBias: Float
    @JvmName("normalBiasProperty")
    get() = getNormalBias()
    @JvmName("normalBiasProperty")
    set(`value`) {
      setNormalBias(value)
    }

  /**
   * The multiplier to use when light bounces off a surface. Higher values result in brighter
   * indirect lighting. If indirect lighting looks too flat, try decreasing [propagation] while
   * increasing [energy] at the same time. See also [useTwoBounces] which influences the indirect
   * lighting's effective brightness.
   */
  public final inline var propagation: Float
    @JvmName("propagationProperty")
    get() = getPropagation()
    @JvmName("propagationProperty")
    set(`value`) {
      setPropagation(value)
    }

  /**
   * If `true`, performs two bounces of indirect lighting instead of one. This makes indirect
   * lighting look more natural and brighter at a small performance cost. The second bounce is also
   * visible in reflections. If the scene appears too bright after enabling [useTwoBounces], adjust
   * [propagation] and [energy].
   */
  public final inline var useTwoBounces: Boolean
    @JvmName("useTwoBouncesProperty")
    get() = isUsingTwoBounces()
    @JvmName("useTwoBouncesProperty")
    set(`value`) {
      setUseTwoBounces(value)
    }

  /**
   * If `true`, [Environment] lighting is ignored by the [VoxelGI] node. If `false`, [Environment]
   * lighting is taken into account by the [VoxelGI] node. [Environment] lighting updates in real-time,
   * which means it can be changed without having to bake the [VoxelGI] node again.
   */
  public final inline var interior: Boolean
    @JvmName("interiorProperty")
    get() = isInterior()
    @JvmName("interiorProperty")
    set(`value`) {
      setInterior(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(917, scriptPtr)
  }

  /**
   * Initializes this [VoxelGIData] with the specified data. [octreeCells] must be a multiple of 32.
   * [octreeCells] must be double the size of [dataCells]. The allocated data can be retrieved later
   * using the various getter methods.
   */
  public final fun allocate(
    toCellXform: Transform3D,
    aabb: AABB,
    octreeSize: Vector3,
    octreeCells: PackedByteArray,
    dataCells: PackedByteArray,
    distanceField: PackedByteArray,
    levelCounts: PackedInt32Array,
  ): Unit {
    TransferContext.callPtrMethod_TRANSFORM3D_AABB_VECTOR3_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_PACKED_BYTE_ARRAY_PACKED_INT_32_ARRAY(ptr, objectID.id, MethodBindings.allocatePtr, toCellXform, aabb, octreeSize, octreeCells, dataCells, distanceField, levelCounts)
  }

  /**
   * Returns the bounds of the baked voxel data as an [AABB], which should match [VoxelGI.size]
   * after being baked (which only contains the size as a [Vector3]).
   *
   * **Note:** If the size was modified without baking the VoxelGI data, then the value of
   * [getBounds] and [VoxelGI.size] will not match.
   */
  public final fun getBounds(): AABB =
      TransferContext.callPtrMethod0_ret_AABB(ptr, objectID.id, MethodBindings.getBoundsPtr)

  /**
   * Returns the baked octree size for this [VoxelGIData], which corresponds to the number of
   * subdivisions per axis. This can be viewed in the editor by hovering the **Bake VoxelGI** button at
   * the top of the 3D editor viewport when a [VoxelGI] node is selected and looking at the
   * **Subdivisions** field in the tooltip.
   */
  public final fun getOctreeSize(): Vector3 =
      TransferContext.callPtrMethod0_ret_VECTOR3(ptr, objectID.id, MethodBindings.getOctreeSizePtr)

  /**
   * Returns the baked cell transform for this [VoxelGIData].
   */
  public final fun getToCellXform(): Transform3D =
      TransferContext.callPtrMethod0_ret_TRANSFORM3D(ptr, objectID.id, MethodBindings.getToCellXformPtr)

  /**
   * Returns the baked octree cell data for this [VoxelGIData].
   */
  public final fun getOctreeCells(): PackedByteArray =
      TransferContext.callPtrMethod0_ret_PACKED_BYTE_ARRAY(ptr, objectID.id, MethodBindings.getOctreeCellsPtr)

  /**
   * Returns the baked cell data for this [VoxelGIData].
   */
  public final fun getDataCells(): PackedByteArray =
      TransferContext.callPtrMethod0_ret_PACKED_BYTE_ARRAY(ptr, objectID.id, MethodBindings.getDataCellsPtr)

  /**
   * Returns the baked level counts for this [VoxelGIData].
   */
  public final fun getLevelCounts(): PackedInt32Array =
      TransferContext.callPtrMethod0_ret_PACKED_INT_32_ARRAY(ptr, objectID.id, MethodBindings.getLevelCountsPtr)

  public final fun setDynamicRange(dynamicRange: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setDynamicRangePtr, dynamicRange.toDouble())
  }

  public final fun getDynamicRange(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDynamicRangePtr).toFloat()

  public final fun setEnergy(energy: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setEnergyPtr, energy.toDouble())
  }

  public final fun getEnergy(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getEnergyPtr).toFloat()

  public final fun setBias(bias: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setBiasPtr, bias.toDouble())
  }

  public final fun getBias(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getBiasPtr).toFloat()

  public final fun setNormalBias(bias: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setNormalBiasPtr, bias.toDouble())
  }

  public final fun getNormalBias(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getNormalBiasPtr).toFloat()

  public final fun setPropagation(propagation: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setPropagationPtr, propagation.toDouble())
  }

  public final fun getPropagation(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getPropagationPtr).toFloat()

  public final fun setInterior(interior: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setInteriorPtr, interior)
  }

  public final fun isInterior(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isInteriorPtr)

  public final fun setUseTwoBounces(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setUseTwoBouncesPtr, enable)
  }

  public final fun isUsingTwoBounces(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isUsingTwoBouncesPtr)

  public companion object {
    @JvmField
    public val allocateName:
        MethodStringName7<VoxelGIData, Unit, Transform3D, AABB, Vector3, PackedByteArray, PackedByteArray, PackedByteArray, PackedInt32Array>
        =
        MethodStringName7<VoxelGIData, Unit, Transform3D, AABB, Vector3, PackedByteArray, PackedByteArray, PackedByteArray, PackedInt32Array>("allocate")

    @JvmField
    public val getBoundsName: MethodStringName0<VoxelGIData, AABB> =
        MethodStringName0<VoxelGIData, AABB>("get_bounds")

    @JvmField
    public val getOctreeSizeName: MethodStringName0<VoxelGIData, Vector3> =
        MethodStringName0<VoxelGIData, Vector3>("get_octree_size")

    @JvmField
    public val getToCellXformName: MethodStringName0<VoxelGIData, Transform3D> =
        MethodStringName0<VoxelGIData, Transform3D>("get_to_cell_xform")

    @JvmField
    public val getOctreeCellsName: MethodStringName0<VoxelGIData, PackedByteArray> =
        MethodStringName0<VoxelGIData, PackedByteArray>("get_octree_cells")

    @JvmField
    public val getDataCellsName: MethodStringName0<VoxelGIData, PackedByteArray> =
        MethodStringName0<VoxelGIData, PackedByteArray>("get_data_cells")

    @JvmField
    public val getLevelCountsName: MethodStringName0<VoxelGIData, PackedInt32Array> =
        MethodStringName0<VoxelGIData, PackedInt32Array>("get_level_counts")

    @JvmField
    public val setDynamicRangeName: MethodStringName1<VoxelGIData, Unit, Float> =
        MethodStringName1<VoxelGIData, Unit, Float>("set_dynamic_range")

    @JvmField
    public val getDynamicRangeName: MethodStringName0<VoxelGIData, Float> =
        MethodStringName0<VoxelGIData, Float>("get_dynamic_range")

    @JvmField
    public val setEnergyName: MethodStringName1<VoxelGIData, Unit, Float> =
        MethodStringName1<VoxelGIData, Unit, Float>("set_energy")

    @JvmField
    public val getEnergyName: MethodStringName0<VoxelGIData, Float> =
        MethodStringName0<VoxelGIData, Float>("get_energy")

    @JvmField
    public val setBiasName: MethodStringName1<VoxelGIData, Unit, Float> =
        MethodStringName1<VoxelGIData, Unit, Float>("set_bias")

    @JvmField
    public val getBiasName: MethodStringName0<VoxelGIData, Float> =
        MethodStringName0<VoxelGIData, Float>("get_bias")

    @JvmField
    public val setNormalBiasName: MethodStringName1<VoxelGIData, Unit, Float> =
        MethodStringName1<VoxelGIData, Unit, Float>("set_normal_bias")

    @JvmField
    public val getNormalBiasName: MethodStringName0<VoxelGIData, Float> =
        MethodStringName0<VoxelGIData, Float>("get_normal_bias")

    @JvmField
    public val setPropagationName: MethodStringName1<VoxelGIData, Unit, Float> =
        MethodStringName1<VoxelGIData, Unit, Float>("set_propagation")

    @JvmField
    public val getPropagationName: MethodStringName0<VoxelGIData, Float> =
        MethodStringName0<VoxelGIData, Float>("get_propagation")

    @JvmField
    public val setInteriorName: MethodStringName1<VoxelGIData, Unit, Boolean> =
        MethodStringName1<VoxelGIData, Unit, Boolean>("set_interior")

    @JvmField
    public val isInteriorName: MethodStringName0<VoxelGIData, Boolean> =
        MethodStringName0<VoxelGIData, Boolean>("is_interior")

    @JvmField
    public val setUseTwoBouncesName: MethodStringName1<VoxelGIData, Unit, Boolean> =
        MethodStringName1<VoxelGIData, Unit, Boolean>("set_use_two_bounces")

    @JvmField
    public val isUsingTwoBouncesName: MethodStringName0<VoxelGIData, Boolean> =
        MethodStringName0<VoxelGIData, Boolean>("is_using_two_bounces")
  }

  public object MethodBindings {
    internal val allocatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "allocate", 4041601946)

    internal val getBoundsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "get_bounds", 1068685055)

    internal val getOctreeSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "get_octree_size", 3360562783)

    internal val getToCellXformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "get_to_cell_xform", 3229777777)

    internal val getOctreeCellsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "get_octree_cells", 2362200018)

    internal val getDataCellsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "get_data_cells", 2362200018)

    internal val getLevelCountsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "get_level_counts", 1930428628)

    internal val setDynamicRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "set_dynamic_range", 373806689)

    internal val getDynamicRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "get_dynamic_range", 1740695150)

    internal val setEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "set_energy", 373806689)

    internal val getEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "get_energy", 1740695150)

    internal val setBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "set_bias", 373806689)

    internal val getBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "get_bias", 1740695150)

    internal val setNormalBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "set_normal_bias", 373806689)

    internal val getNormalBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "get_normal_bias", 1740695150)

    internal val setPropagationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "set_propagation", 373806689)

    internal val getPropagationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "get_propagation", 1740695150)

    internal val setInteriorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "set_interior", 2586408642)

    internal val isInteriorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "is_interior", 36873697)

    internal val setUseTwoBouncesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "set_use_two_bounces", 2586408642)

    internal val isUsingTwoBouncesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGIData", "is_using_two_bounces", 36873697)
  }
}
