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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import kotlin.Boolean
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Parameters to be used with a [Mesh] convex decomposition operation.
 */
@GodotBaseType
public open class MeshConvexDecompositionSettings : RefCounted() {
  /**
   * Maximum concavity. Ranges from `0.0` to `1.0`.
   */
  public final inline var maxConcavity: Float
    @JvmName("maxConcavityProperty")
    get() = getMaxConcavity()
    @JvmName("maxConcavityProperty")
    set(`value`) {
      setMaxConcavity(value)
    }

  /**
   * Controls the bias toward clipping along symmetry planes. Ranges from `0.0` to `1.0`.
   */
  public final inline var symmetryPlanesClippingBias: Float
    @JvmName("symmetryPlanesClippingBiasProperty")
    get() = getSymmetryPlanesClippingBias()
    @JvmName("symmetryPlanesClippingBiasProperty")
    set(`value`) {
      setSymmetryPlanesClippingBias(value)
    }

  /**
   * Controls the bias toward clipping along revolution axes. Ranges from `0.0` to `1.0`.
   */
  public final inline var revolutionAxesClippingBias: Float
    @JvmName("revolutionAxesClippingBiasProperty")
    get() = getRevolutionAxesClippingBias()
    @JvmName("revolutionAxesClippingBiasProperty")
    set(`value`) {
      setRevolutionAxesClippingBias(value)
    }

  /**
   * Controls the adaptive sampling of the generated convex-hulls. Ranges from `0.0` to `0.01`.
   */
  public final inline var minVolumePerConvexHull: Float
    @JvmName("minVolumePerConvexHullProperty")
    get() = getMinVolumePerConvexHull()
    @JvmName("minVolumePerConvexHullProperty")
    set(`value`) {
      setMinVolumePerConvexHull(value)
    }

  /**
   * Maximum number of voxels generated during the voxelization stage.
   */
  public final inline var resolution: Long
    @JvmName("resolutionProperty")
    get() = getResolution()
    @JvmName("resolutionProperty")
    set(`value`) {
      setResolution(value)
    }

  /**
   * Controls the maximum number of triangles per convex-hull. Ranges from `4` to `1024`.
   */
  public final inline var maxNumVerticesPerConvexHull: Long
    @JvmName("maxNumVerticesPerConvexHullProperty")
    get() = getMaxNumVerticesPerConvexHull()
    @JvmName("maxNumVerticesPerConvexHullProperty")
    set(`value`) {
      setMaxNumVerticesPerConvexHull(value)
    }

  /**
   * Controls the granularity of the search for the "best" clipping plane. Ranges from `1` to `16`.
   */
  public final inline var planeDownsampling: Long
    @JvmName("planeDownsamplingProperty")
    get() = getPlaneDownsampling()
    @JvmName("planeDownsamplingProperty")
    set(`value`) {
      setPlaneDownsampling(value)
    }

  /**
   * Controls the precision of the convex-hull generation process during the clipping plane
   * selection stage. Ranges from `1` to `16`.
   */
  public final inline var convexHullDownsampling: Long
    @JvmName("convexHullDownsamplingProperty")
    get() = getConvexHullDownsampling()
    @JvmName("convexHullDownsamplingProperty")
    set(`value`) {
      setConvexHullDownsampling(value)
    }

  /**
   * If `true`, normalizes the mesh before applying the convex decomposition.
   */
  public final inline var normalizeMesh: Boolean
    @JvmName("normalizeMeshProperty")
    get() = getNormalizeMesh()
    @JvmName("normalizeMeshProperty")
    set(`value`) {
      setNormalizeMesh(value)
    }

  /**
   * Mode for the approximate convex decomposition.
   */
  public final inline var mode: Mode
    @JvmName("modeProperty")
    get() = getMode()
    @JvmName("modeProperty")
    set(`value`) {
      setMode(value)
    }

  /**
   * If `true`, uses approximation for computing convex hulls.
   */
  public final inline var convexHullApproximation: Boolean
    @JvmName("convexHullApproximationProperty")
    get() = getConvexHullApproximation()
    @JvmName("convexHullApproximationProperty")
    set(`value`) {
      setConvexHullApproximation(value)
    }

  /**
   * The maximum number of convex hulls to produce from the merge operation.
   */
  public final inline var maxConvexHulls: Long
    @JvmName("maxConvexHullsProperty")
    get() = getMaxConvexHulls()
    @JvmName("maxConvexHullsProperty")
    set(`value`) {
      setMaxConvexHulls(value)
    }

  /**
   * If `true`, projects output convex hull vertices onto the original source mesh to increase
   * floating-point accuracy of the results.
   */
  public final inline var projectHullVertices: Boolean
    @JvmName("projectHullVerticesProperty")
    get() = getProjectHullVertices()
    @JvmName("projectHullVerticesProperty")
    set(`value`) {
      setProjectHullVertices(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(374, scriptPtr)
  }

  public final fun setMaxConcavity(maxConcavity: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, maxConcavity.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setMaxConcavityPtr, 0)
  }

  public final fun getMaxConcavity(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMaxConcavityPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setSymmetryPlanesClippingBias(symmetryPlanesClippingBias: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, symmetryPlanesClippingBias.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setSymmetryPlanesClippingBiasPtr, 0)
  }

  public final fun getSymmetryPlanesClippingBias(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSymmetryPlanesClippingBiasPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setRevolutionAxesClippingBias(revolutionAxesClippingBias: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, revolutionAxesClippingBias.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setRevolutionAxesClippingBiasPtr, 0)
  }

  public final fun getRevolutionAxesClippingBias(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRevolutionAxesClippingBiasPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setMinVolumePerConvexHull(minVolumePerConvexHull: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, minVolumePerConvexHull.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setMinVolumePerConvexHullPtr, 0)
  }

  public final fun getMinVolumePerConvexHull(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMinVolumePerConvexHullPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setResolution(minVolumePerConvexHull: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, minVolumePerConvexHull)
    TransferContext.callPtrMethod(MethodBindings.setResolutionPtr, 0)
  }

  public final fun getResolution(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getResolutionPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setMaxNumVerticesPerConvexHull(maxNumVerticesPerConvexHull: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, maxNumVerticesPerConvexHull)
    TransferContext.callPtrMethod(MethodBindings.setMaxNumVerticesPerConvexHullPtr, 0)
  }

  public final fun getMaxNumVerticesPerConvexHull(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMaxNumVerticesPerConvexHullPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setPlaneDownsampling(planeDownsampling: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, planeDownsampling)
    TransferContext.callPtrMethod(MethodBindings.setPlaneDownsamplingPtr, 0)
  }

  public final fun getPlaneDownsampling(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPlaneDownsamplingPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setConvexHullDownsampling(convexHullDownsampling: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, convexHullDownsampling)
    TransferContext.callPtrMethod(MethodBindings.setConvexHullDownsamplingPtr, 0)
  }

  public final fun getConvexHullDownsampling(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getConvexHullDownsamplingPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setNormalizeMesh(normalizeMesh: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, normalizeMesh)
    TransferContext.callPtrMethod(MethodBindings.setNormalizeMeshPtr, 0)
  }

  public final fun getNormalizeMesh(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getNormalizeMeshPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setMode(mode: Mode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callPtrMethod(MethodBindings.setModePtr, 0)
  }

  public final fun getMode(): Mode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getModePtr, 2)
    return Mode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setConvexHullApproximation(convexHullApproximation: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, convexHullApproximation)
    TransferContext.callPtrMethod(MethodBindings.setConvexHullApproximationPtr, 0)
  }

  public final fun getConvexHullApproximation(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getConvexHullApproximationPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setMaxConvexHulls(maxConvexHulls: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, maxConvexHulls)
    TransferContext.callPtrMethod(MethodBindings.setMaxConvexHullsPtr, 0)
  }

  public final fun getMaxConvexHulls(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMaxConvexHullsPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setProjectHullVertices(projectHullVertices: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, projectHullVertices)
    TransferContext.callPtrMethod(MethodBindings.setProjectHullVerticesPtr, 0)
  }

  public final fun getProjectHullVertices(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getProjectHullVerticesPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public enum class Mode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Constant for voxel-based approximate convex decomposition.
     */
    CONVEX_DECOMPOSITION_VOXEL(0),
    /**
     * Constant for tetrahedron-based approximate convex decomposition.
     */
    CONVEX_DECOMPOSITION_TETRAHEDRON(1),
    ;

    public companion object {
      public fun from(`value`: Long): Mode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setMaxConcavityName: MethodStringName1<MeshConvexDecompositionSettings, Unit, Float>
        = MethodStringName1<MeshConvexDecompositionSettings, Unit, Float>("set_max_concavity")

    @JvmField
    public val getMaxConcavityName: MethodStringName0<MeshConvexDecompositionSettings, Float> =
        MethodStringName0<MeshConvexDecompositionSettings, Float>("get_max_concavity")

    @JvmField
    public val setSymmetryPlanesClippingBiasName:
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Float> =
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Float>("set_symmetry_planes_clipping_bias")

    @JvmField
    public val getSymmetryPlanesClippingBiasName:
        MethodStringName0<MeshConvexDecompositionSettings, Float> =
        MethodStringName0<MeshConvexDecompositionSettings, Float>("get_symmetry_planes_clipping_bias")

    @JvmField
    public val setRevolutionAxesClippingBiasName:
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Float> =
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Float>("set_revolution_axes_clipping_bias")

    @JvmField
    public val getRevolutionAxesClippingBiasName:
        MethodStringName0<MeshConvexDecompositionSettings, Float> =
        MethodStringName0<MeshConvexDecompositionSettings, Float>("get_revolution_axes_clipping_bias")

    @JvmField
    public val setMinVolumePerConvexHullName:
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Float> =
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Float>("set_min_volume_per_convex_hull")

    @JvmField
    public val getMinVolumePerConvexHullName:
        MethodStringName0<MeshConvexDecompositionSettings, Float> =
        MethodStringName0<MeshConvexDecompositionSettings, Float>("get_min_volume_per_convex_hull")

    @JvmField
    public val setResolutionName: MethodStringName1<MeshConvexDecompositionSettings, Unit, Long> =
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Long>("set_resolution")

    @JvmField
    public val getResolutionName: MethodStringName0<MeshConvexDecompositionSettings, Long> =
        MethodStringName0<MeshConvexDecompositionSettings, Long>("get_resolution")

    @JvmField
    public val setMaxNumVerticesPerConvexHullName:
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Long> =
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Long>("set_max_num_vertices_per_convex_hull")

    @JvmField
    public val getMaxNumVerticesPerConvexHullName:
        MethodStringName0<MeshConvexDecompositionSettings, Long> =
        MethodStringName0<MeshConvexDecompositionSettings, Long>("get_max_num_vertices_per_convex_hull")

    @JvmField
    public val setPlaneDownsamplingName:
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Long> =
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Long>("set_plane_downsampling")

    @JvmField
    public val getPlaneDownsamplingName: MethodStringName0<MeshConvexDecompositionSettings, Long> =
        MethodStringName0<MeshConvexDecompositionSettings, Long>("get_plane_downsampling")

    @JvmField
    public val setConvexHullDownsamplingName:
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Long> =
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Long>("set_convex_hull_downsampling")

    @JvmField
    public val getConvexHullDownsamplingName:
        MethodStringName0<MeshConvexDecompositionSettings, Long> =
        MethodStringName0<MeshConvexDecompositionSettings, Long>("get_convex_hull_downsampling")

    @JvmField
    public val setNormalizeMeshName:
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Boolean> =
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Boolean>("set_normalize_mesh")

    @JvmField
    public val getNormalizeMeshName: MethodStringName0<MeshConvexDecompositionSettings, Boolean> =
        MethodStringName0<MeshConvexDecompositionSettings, Boolean>("get_normalize_mesh")

    @JvmField
    public val setModeName: MethodStringName1<MeshConvexDecompositionSettings, Unit, Mode> =
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Mode>("set_mode")

    @JvmField
    public val getModeName: MethodStringName0<MeshConvexDecompositionSettings, Mode> =
        MethodStringName0<MeshConvexDecompositionSettings, Mode>("get_mode")

    @JvmField
    public val setConvexHullApproximationName:
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Boolean> =
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Boolean>("set_convex_hull_approximation")

    @JvmField
    public val getConvexHullApproximationName:
        MethodStringName0<MeshConvexDecompositionSettings, Boolean> =
        MethodStringName0<MeshConvexDecompositionSettings, Boolean>("get_convex_hull_approximation")

    @JvmField
    public val setMaxConvexHullsName: MethodStringName1<MeshConvexDecompositionSettings, Unit, Long>
        = MethodStringName1<MeshConvexDecompositionSettings, Unit, Long>("set_max_convex_hulls")

    @JvmField
    public val getMaxConvexHullsName: MethodStringName0<MeshConvexDecompositionSettings, Long> =
        MethodStringName0<MeshConvexDecompositionSettings, Long>("get_max_convex_hulls")

    @JvmField
    public val setProjectHullVerticesName:
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Boolean> =
        MethodStringName1<MeshConvexDecompositionSettings, Unit, Boolean>("set_project_hull_vertices")

    @JvmField
    public val getProjectHullVerticesName:
        MethodStringName0<MeshConvexDecompositionSettings, Boolean> =
        MethodStringName0<MeshConvexDecompositionSettings, Boolean>("get_project_hull_vertices")
  }

  public object MethodBindings {
    internal val setMaxConcavityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "set_max_concavity", 373806689)

    internal val getMaxConcavityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "get_max_concavity", 1740695150)

    internal val setSymmetryPlanesClippingBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "set_symmetry_planes_clipping_bias", 373806689)

    internal val getSymmetryPlanesClippingBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "get_symmetry_planes_clipping_bias", 1740695150)

    internal val setRevolutionAxesClippingBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "set_revolution_axes_clipping_bias", 373806689)

    internal val getRevolutionAxesClippingBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "get_revolution_axes_clipping_bias", 1740695150)

    internal val setMinVolumePerConvexHullPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "set_min_volume_per_convex_hull", 373806689)

    internal val getMinVolumePerConvexHullPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "get_min_volume_per_convex_hull", 1740695150)

    internal val setResolutionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "set_resolution", 1286410249)

    internal val getResolutionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "get_resolution", 3905245786)

    internal val setMaxNumVerticesPerConvexHullPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "set_max_num_vertices_per_convex_hull", 1286410249)

    internal val getMaxNumVerticesPerConvexHullPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "get_max_num_vertices_per_convex_hull", 3905245786)

    internal val setPlaneDownsamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "set_plane_downsampling", 1286410249)

    internal val getPlaneDownsamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "get_plane_downsampling", 3905245786)

    internal val setConvexHullDownsamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "set_convex_hull_downsampling", 1286410249)

    internal val getConvexHullDownsamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "get_convex_hull_downsampling", 3905245786)

    internal val setNormalizeMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "set_normalize_mesh", 2586408642)

    internal val getNormalizeMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "get_normalize_mesh", 36873697)

    internal val setModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "set_mode", 1668072869)

    internal val getModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "get_mode", 23479454)

    internal val setConvexHullApproximationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "set_convex_hull_approximation", 2586408642)

    internal val getConvexHullApproximationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "get_convex_hull_approximation", 36873697)

    internal val setMaxConvexHullsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "set_max_convex_hulls", 1286410249)

    internal val getMaxConvexHullsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "get_max_convex_hulls", 3905245786)

    internal val setProjectHullVerticesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "set_project_hull_vertices", 2586408642)

    internal val getProjectHullVerticesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshConvexDecompositionSettings", "get_project_hull_vertices", 36873697)
  }
}
