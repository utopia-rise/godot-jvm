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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName3
import godot.core.PackedInt32Array
import godot.core.PackedVector2Array
import godot.core.Signal0
import godot.core.Transform3D
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.VariantParser.STRING
import godot.core.VariantParser.TRANSFORM3D
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Float
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * Spatial entity tracker for our OpenXR spatial entity plane tracking extension. These trackers
 * identify entities in our real space such as walls, floors, tables, etc. and map their location to
 * our virtual space.
 */
@GodotBaseType
public open class OpenXRPlaneTracker : OpenXRSpatialEntityTracker() {
  /**
   * Emitted when our mesh data has changed the mesh instance and collision needs to be updated.
   */
  public val meshChanged: Signal0 by Signal0

  /**
   * The bounding size of the plane. This is a 2D size.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var boundsSize: Vector2
    @JvmName("boundsSizeProperty")
    get() = getBoundsSize()
    @JvmName("boundsSizeProperty")
    set(`value`) {
      setBoundsSize(value)
    }

  /**
   * The main alignment in space of this plane.
   */
  public final inline var planeAlignment: OpenXRSpatialComponentPlaneAlignmentList.PlaneAlignment
    @JvmName("planeAlignmentProperty")
    get() = getPlaneAlignment()
    @JvmName("planeAlignmentProperty")
    set(`value`) {
      setPlaneAlignment(value)
    }

  /**
   * The semantic label for this plane.
   */
  public final inline var planeLabel: String
    @JvmName("planeLabelProperty")
    get() = getPlaneLabel()
    @JvmName("planeLabelProperty")
    set(`value`) {
      setPlaneLabel(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(465, scriptPtr)
  }

  /**
   * This is a helper function for [boundsSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = openxrplanetracker.boundsSize
   * //Your changes
   * openxrplanetracker.boundsSize = myCoreType
   * ``````
   *
   * The bounding size of the plane. This is a 2D size.
   */
  @CoreTypeHelper
  public final fun boundsSizeMutate(block: Vector2.() -> Unit): Vector2 = boundsSize.apply {
     block(this)
     boundsSize = this
  }

  public final fun setBoundsSize(boundsSize: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to boundsSize)
    TransferContext.callMethod(MethodBindings.setBoundsSizePtr)
  }

  public final fun getBoundsSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBoundsSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final
      fun setPlaneAlignment(planeAlignment: OpenXRSpatialComponentPlaneAlignmentList.PlaneAlignment):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to planeAlignment.value)
    TransferContext.callMethod(MethodBindings.setPlaneAlignmentPtr)
  }

  public final fun getPlaneAlignment(): OpenXRSpatialComponentPlaneAlignmentList.PlaneAlignment {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPlaneAlignmentPtr)
    return OpenXRSpatialComponentPlaneAlignmentList.PlaneAlignment.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setPlaneLabel(planeLabel: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to planeLabel)
    TransferContext.callMethod(MethodBindings.setPlaneLabelPtr)
  }

  public final fun getPlaneLabel(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPlaneLabelPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets the mesh data for this plane. You should only call this if you are handling your own
   * discovery logic.
   */
  @JvmOverloads
  public final fun setMeshData(
    origin: Transform3D,
    vertices: PackedVector2Array,
    indices: PackedInt32Array = PackedInt32Array(),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM3D to origin, PACKED_VECTOR2_ARRAY to vertices, PACKED_INT_32_ARRAY to indices)
    TransferContext.callMethod(MethodBindings.setMeshDataPtr)
  }

  /**
   * Clears the mesh data for this tracker. You should only call this if you are handling your own
   * discovery logic.
   */
  public final fun clearMeshData(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearMeshDataPtr)
  }

  /**
   * Gets the transform by which to offset the mesh and collision shape from our pose to display
   * these correctly.
   */
  public final fun getMeshOffset(): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMeshOffsetPtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  /**
   * Gets a mesh created from either the mesh data or from our bounding size for this plane.
   */
  public final fun getMesh(): Mesh? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMeshPtr)
    return (TransferContext.readReturnValue(OBJECT) as Mesh?)
  }

  /**
   * Gets a collision shape built either from the mesh data or from our bounding size for this
   * plane.
   */
  @JvmOverloads
  public final fun getShape(thickness: Float = 0.01f): Shape3D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to thickness.toDouble())
    TransferContext.callMethod(MethodBindings.getShapePtr)
    return (TransferContext.readReturnValue(OBJECT) as Shape3D?)
  }

  public companion object {
    @JvmField
    public val setBoundsSizeName: MethodStringName1<OpenXRPlaneTracker, Unit, Vector2> =
        MethodStringName1<OpenXRPlaneTracker, Unit, Vector2>("set_bounds_size")

    @JvmField
    public val getBoundsSizeName: MethodStringName0<OpenXRPlaneTracker, Vector2> =
        MethodStringName0<OpenXRPlaneTracker, Vector2>("get_bounds_size")

    @JvmField
    public val setPlaneAlignmentName:
        MethodStringName1<OpenXRPlaneTracker, Unit, OpenXRSpatialComponentPlaneAlignmentList.PlaneAlignment>
        =
        MethodStringName1<OpenXRPlaneTracker, Unit, OpenXRSpatialComponentPlaneAlignmentList.PlaneAlignment>("set_plane_alignment")

    @JvmField
    public val getPlaneAlignmentName:
        MethodStringName0<OpenXRPlaneTracker, OpenXRSpatialComponentPlaneAlignmentList.PlaneAlignment>
        =
        MethodStringName0<OpenXRPlaneTracker, OpenXRSpatialComponentPlaneAlignmentList.PlaneAlignment>("get_plane_alignment")

    @JvmField
    public val setPlaneLabelName: MethodStringName1<OpenXRPlaneTracker, Unit, String> =
        MethodStringName1<OpenXRPlaneTracker, Unit, String>("set_plane_label")

    @JvmField
    public val getPlaneLabelName: MethodStringName0<OpenXRPlaneTracker, String> =
        MethodStringName0<OpenXRPlaneTracker, String>("get_plane_label")

    @JvmField
    public val setMeshDataName:
        MethodStringName3<OpenXRPlaneTracker, Unit, Transform3D, PackedVector2Array, PackedInt32Array>
        =
        MethodStringName3<OpenXRPlaneTracker, Unit, Transform3D, PackedVector2Array, PackedInt32Array>("set_mesh_data")

    @JvmField
    public val clearMeshDataName: MethodStringName0<OpenXRPlaneTracker, Unit> =
        MethodStringName0<OpenXRPlaneTracker, Unit>("clear_mesh_data")

    @JvmField
    public val getMeshOffsetName: MethodStringName0<OpenXRPlaneTracker, Transform3D> =
        MethodStringName0<OpenXRPlaneTracker, Transform3D>("get_mesh_offset")

    @JvmField
    public val getMeshName: MethodStringName0<OpenXRPlaneTracker, Mesh?> =
        MethodStringName0<OpenXRPlaneTracker, Mesh?>("get_mesh")

    @JvmField
    public val getShapeName: MethodStringName1<OpenXRPlaneTracker, Shape3D?, Float> =
        MethodStringName1<OpenXRPlaneTracker, Shape3D?, Float>("get_shape")
  }

  public object MethodBindings {
    internal val setBoundsSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRPlaneTracker", "set_bounds_size", 743155724)

    internal val getBoundsSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRPlaneTracker", "get_bounds_size", 3341600327)

    internal val setPlaneAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRPlaneTracker", "set_plane_alignment", 1214382230)

    internal val getPlaneAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRPlaneTracker", "get_plane_alignment", 845541441)

    internal val setPlaneLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRPlaneTracker", "set_plane_label", 83702148)

    internal val getPlaneLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRPlaneTracker", "get_plane_label", 201670096)

    internal val setMeshDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRPlaneTracker", "set_mesh_data", 1877193149)

    internal val clearMeshDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRPlaneTracker", "clear_mesh_data", 3218959716)

    internal val getMeshOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRPlaneTracker", "get_mesh_offset", 3229777777)

    internal val getMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRPlaneTracker", "get_mesh", 4081188045)

    internal val getShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRPlaneTracker", "get_shape", 3358509884)
  }
}
