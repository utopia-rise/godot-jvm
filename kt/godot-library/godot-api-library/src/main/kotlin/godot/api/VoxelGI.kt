// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * [VoxelGI]s are used to provide high-quality real-time indirect light and reflections to scenes.
 * They precompute the effect of objects that emit light and the effect of static geometry to simulate
 * the behavior of complex light in real-time. [VoxelGI]s need to be baked before having a visible
 * effect. However, once baked, dynamic objects will receive light from them. Furthermore, lights can
 * be fully dynamic or baked.
 *
 * **Note:** [VoxelGI] is only supported in the Forward+ rendering method, not Mobile or
 * Compatibility.
 *
 * **Procedural generation:** [VoxelGI] can be baked in an exported project, which makes it suitable
 * for procedurally generated or user-built levels as long as all the geometry is generated in advance.
 * For games where geometry is generated at any time during gameplay, SDFGI is more suitable (see
 * [Environment.sdfgiEnabled]).
 *
 * **Performance:** [VoxelGI] is relatively demanding on the GPU and is not suited to low-end
 * hardware such as integrated graphics (consider [LightmapGI] instead). To improve performance, adjust
 * [ProjectSettings.rendering/globalIllumination/voxelGi/quality] and enable
 * [ProjectSettings.rendering/globalIllumination/gi/useHalfResolution] in the Project Settings. To
 * provide a fallback for low-end hardware, consider adding an option to disable [VoxelGI] in your
 * project's options menus. A [VoxelGI] node can be disabled by hiding it.
 *
 * **Note:** Meshes should have sufficiently thick walls to avoid light leaks (avoid one-sided
 * walls). For interior levels, enclose your level geometry in a sufficiently large box and bridge the
 * loops to close the mesh. To further prevent light leaks, you can also strategically place temporary
 * [MeshInstance3D] nodes with their [GeometryInstance3D.giMode] set to
 * [GeometryInstance3D.GI_MODE_STATIC]. These temporary nodes can then be hidden after baking the
 * [VoxelGI] node.
 */
@GodotBaseType
public open class VoxelGI : VisualInstance3D() {
  /**
   * Number of times to subdivide the grid that the [VoxelGI] operates on. A higher number results
   * in finer detail and thus higher visual quality, while lower numbers result in better performance.
   */
  public final inline var subdiv: Subdiv
    @JvmName("subdivProperty")
    get() = getSubdiv()
    @JvmName("subdivProperty")
    set(`value`) {
      setSubdiv(value)
    }

  /**
   * The size of the area covered by the [VoxelGI]. This must be `1.0` or greater on each axis.
   *
   * **Note:** If you make the size larger without increasing the number of subdivisions with
   * [subdiv], the size of each cell will increase and result in less detailed lighting.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var size: Vector3
    @JvmName("sizeProperty")
    get() = getSize()
    @JvmName("sizeProperty")
    set(`value`) {
      setSize(value)
    }

  /**
   * The [CameraAttributes] resource that specifies exposure levels to bake at. Auto-exposure and
   * non exposure properties will be ignored. Exposure settings should be used to reduce the dynamic
   * range present when baking. If exposure is too high, the [VoxelGI] will have banding artifacts or
   * may have over-exposure artifacts.
   */
  public final inline var cameraAttributes: CameraAttributes?
    @JvmName("cameraAttributesProperty")
    get() = getCameraAttributes()
    @JvmName("cameraAttributesProperty")
    set(`value`) {
      setCameraAttributes(value)
    }

  /**
   * The [VoxelGIData] resource that holds the data for this [VoxelGI].
   */
  public final inline var `data`: VoxelGIData?
    @JvmName("dataProperty")
    get() = getProbeData()
    @JvmName("dataProperty")
    set(`value`) {
      setProbeData(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(916, scriptPtr)
  }

  /**
   * This is a helper function for [size] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = voxelgi.size
   * //Your changes
   * voxelgi.size = myCoreType
   * ``````
   *
   * The size of the area covered by the [VoxelGI]. This must be `1.0` or greater on each axis.
   *
   * **Note:** If you make the size larger without increasing the number of subdivisions with
   * [subdiv], the size of each cell will increase and result in less detailed lighting.
   */
  @CoreTypeHelper
  public final fun sizeMutate(block: Vector3.() -> Unit): Vector3 = size.apply {
     block(this)
     size = this
  }

  public final fun setProbeData(`data`: VoxelGIData?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to data)
    TransferContext.callMethod(MethodBindings.setProbeDataPtr)
  }

  public final fun getProbeData(): VoxelGIData? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProbeDataPtr)
    return (TransferContext.readReturnValue(OBJECT) as VoxelGIData?)
  }

  public final fun setSubdiv(subdiv: Subdiv): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to subdiv.value)
    TransferContext.callMethod(MethodBindings.setSubdivPtr)
  }

  public final fun getSubdiv(): Subdiv {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSubdivPtr)
    return Subdiv.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSize(size: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to size)
    TransferContext.callMethod(MethodBindings.setSizePtr)
  }

  public final fun getSize(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSizePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setCameraAttributes(cameraAttributes: CameraAttributes?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to cameraAttributes)
    TransferContext.callMethod(MethodBindings.setCameraAttributesPtr)
  }

  public final fun getCameraAttributes(): CameraAttributes? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCameraAttributesPtr)
    return (TransferContext.readReturnValue(OBJECT) as CameraAttributes?)
  }

  /**
   * Bakes the effect from all [GeometryInstance3D]s marked with [GeometryInstance3D.GI_MODE_STATIC]
   * and [Light3D]s marked with either [Light3D.BAKE_STATIC] or [Light3D.BAKE_DYNAMIC]. If
   * [createVisualDebug] is `true`, after baking the light, this will generate a [MultiMesh] that has a
   * cube representing each solid cell with each cube colored to the cell's albedo color. This can be
   * used to visualize the [VoxelGI]'s data and debug any issues that may be occurring.
   *
   * **Note:** [bake] works from the editor and in exported projects. This makes it suitable for
   * procedurally generated or user-built levels. Baking a [VoxelGI] node generally takes from 5 to 20
   * seconds in most scenes. Reducing [subdiv] can speed up baking.
   *
   * **Note:** [GeometryInstance3D]s and [Light3D]s must be fully ready before [bake] is called. If
   * you are procedurally creating those and some meshes or lights are missing from your baked
   * [VoxelGI], use `call_deferred("bake")` instead of calling [bake] directly.
   */
  @JvmOverloads
  public final fun bake(fromNode: Node? = null, createVisualDebug: Boolean = false): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to fromNode, BOOL to createVisualDebug)
    TransferContext.callMethod(MethodBindings.bakePtr)
  }

  /**
   * Calls [bake] with `create_visual_debug` enabled.
   */
  public final fun debugBake(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.debugBakePtr)
  }

  public enum class Subdiv(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use 64 subdivisions. This is the lowest quality setting, but the fastest. Use it if you can,
     * but especially use it on lower-end hardware.
     */
    SUBDIV_64(0),
    /**
     * Use 128 subdivisions. This is the default quality setting.
     */
    SUBDIV_128(1),
    /**
     * Use 256 subdivisions.
     */
    SUBDIV_256(2),
    /**
     * Use 512 subdivisions. This is the highest quality setting, but the slowest. On lower-end
     * hardware, this could cause the GPU to stall.
     */
    SUBDIV_512(3),
    /**
     * Represents the size of the [Subdiv] enum.
     */
    MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): Subdiv = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setProbeDataName: MethodStringName1<VoxelGI, Unit, VoxelGIData?> =
        MethodStringName1<VoxelGI, Unit, VoxelGIData?>("set_probe_data")

    @JvmField
    public val getProbeDataName: MethodStringName0<VoxelGI, VoxelGIData?> =
        MethodStringName0<VoxelGI, VoxelGIData?>("get_probe_data")

    @JvmField
    public val setSubdivName: MethodStringName1<VoxelGI, Unit, Subdiv> =
        MethodStringName1<VoxelGI, Unit, Subdiv>("set_subdiv")

    @JvmField
    public val getSubdivName: MethodStringName0<VoxelGI, Subdiv> =
        MethodStringName0<VoxelGI, Subdiv>("get_subdiv")

    @JvmField
    public val setSizeName: MethodStringName1<VoxelGI, Unit, Vector3> =
        MethodStringName1<VoxelGI, Unit, Vector3>("set_size")

    @JvmField
    public val getSizeName: MethodStringName0<VoxelGI, Vector3> =
        MethodStringName0<VoxelGI, Vector3>("get_size")

    @JvmField
    public val setCameraAttributesName: MethodStringName1<VoxelGI, Unit, CameraAttributes?> =
        MethodStringName1<VoxelGI, Unit, CameraAttributes?>("set_camera_attributes")

    @JvmField
    public val getCameraAttributesName: MethodStringName0<VoxelGI, CameraAttributes?> =
        MethodStringName0<VoxelGI, CameraAttributes?>("get_camera_attributes")

    @JvmField
    public val bakeName: MethodStringName2<VoxelGI, Unit, Node?, Boolean> =
        MethodStringName2<VoxelGI, Unit, Node?, Boolean>("bake")

    @JvmField
    public val debugBakeName: MethodStringName0<VoxelGI, Unit> =
        MethodStringName0<VoxelGI, Unit>("debug_bake")
  }

  public object MethodBindings {
    internal val setProbeDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGI", "set_probe_data", 1637849675)

    internal val getProbeDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGI", "get_probe_data", 1730645405)

    internal val setSubdivPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGI", "set_subdiv", 2240898472)

    internal val getSubdivPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGI", "get_subdiv", 4261647950)

    internal val setSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGI", "set_size", 3460891852)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGI", "get_size", 3360562783)

    internal val setCameraAttributesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGI", "set_camera_attributes", 2817810567)

    internal val getCameraAttributesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGI", "get_camera_attributes", 3921283215)

    internal val bakePtr: VoidPtr = TypeManager.getMethodBindPtr("VoxelGI", "bake", 2781551026)

    internal val debugBakePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VoxelGI", "debug_bake", 3218959716)
  }
}
