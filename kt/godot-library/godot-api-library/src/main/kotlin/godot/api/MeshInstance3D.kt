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
import godot.core.MethodStringName2
import godot.core.NodePath
import godot.core.RID
import godot.core.StringName
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.NODE_PATH
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING_NAME
import godot.core.asCachedNodePath
import godot.core.asCachedStringName
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * MeshInstance3D is a node that takes a [Mesh] resource and adds it to the current scenario by
 * creating an instance of it. This is the class most often used to render 3D geometry and can be used
 * to instance a single [Mesh] in many places. This allows reusing geometry, which can save on
 * resources. When a [Mesh] has to be instantiated more than thousands of times at close proximity,
 * consider using a [MultiMesh] in a [MultiMeshInstance3D] instead.
 */
@GodotBaseType
public open class MeshInstance3D : GeometryInstance3D() {
  /**
   * The [Mesh] resource for the instance.
   */
  public final inline var mesh: Mesh?
    @JvmName("meshProperty")
    get() = getMesh()
    @JvmName("meshProperty")
    set(`value`) {
      setMesh(value)
    }

  /**
   * The [Skin] to be used by this instance.
   */
  public final inline var skin: Skin?
    @JvmName("skinProperty")
    get() = getSkin()
    @JvmName("skinProperty")
    set(`value`) {
      setSkin(value)
    }

  /**
   * [NodePath] to the [Skeleton3D] associated with the instance.
   *
   * **Note:** The default value of this property has changed in Godot 4.6. Enable
   * [ProjectSettings.animation/compatibility/defaultParentSkeletonInMeshInstance3d] if the old
   * behavior is needed for compatibility.
   */
  public final inline var skeleton: NodePath
    @JvmName("skeletonProperty")
    get() = getSkeletonPath()
    @JvmName("skeletonProperty")
    set(`value`) {
      setSkeletonPath(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(379, scriptPtr)
  }

  public final fun setMesh(mesh: Mesh?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to mesh)
    TransferContext.callMethod(MethodBindings.setMeshPtr)
  }

  public final fun getMesh(): Mesh? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMeshPtr)
    return (TransferContext.readReturnValue(OBJECT) as Mesh?)
  }

  public final fun setSkeletonPath(skeletonPath: NodePath): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, NODE_PATH to skeletonPath)
    TransferContext.callMethod(MethodBindings.setSkeletonPathPtr)
  }

  public final fun getSkeletonPath(): NodePath {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkeletonPathPtr)
    return (TransferContext.readReturnValue(NODE_PATH) as NodePath)
  }

  public final fun setSkin(skin: Skin?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to skin)
    TransferContext.callMethod(MethodBindings.setSkinPtr)
  }

  public final fun getSkin(): Skin? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkinPtr)
    return (TransferContext.readReturnValue(OBJECT) as Skin?)
  }

  /**
   * Returns the internal [SkinReference] containing the skeleton's [RID] attached to this RID. See
   * also [Resource.getRid], [SkinReference.getSkeleton], and [RenderingServer.instanceAttachSkeleton].
   */
  public final fun getSkinReference(): SkinReference? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkinReferencePtr)
    return (TransferContext.readReturnValue(OBJECT) as SkinReference?)
  }

  /**
   * Returns the number of surface override materials. This is equivalent to [Mesh.getSurfaceCount].
   * See also [getSurfaceOverrideMaterial].
   */
  public final fun getSurfaceOverrideMaterialCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSurfaceOverrideMaterialCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the override [material] for the specified [surface] of the [Mesh] resource. This material
   * is associated with this [MeshInstance3D] rather than with [mesh].
   *
   * **Note:** This assigns the [Material] associated to the [MeshInstance3D]'s Surface Material
   * Override properties, not the material within the [Mesh] resource. To set the material within the
   * [Mesh] resource, use [Mesh.surfaceSetMaterial] instead.
   */
  public final fun setSurfaceOverrideMaterial(surface: Int, material: Material?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to surface.toLong(), OBJECT to material)
    TransferContext.callMethod(MethodBindings.setSurfaceOverrideMaterialPtr)
  }

  /**
   * Returns the override [Material] for the specified [surface] of the [Mesh] resource. See also
   * [getSurfaceOverrideMaterialCount].
   *
   * **Note:** This returns the [Material] associated to the [MeshInstance3D]'s Surface Material
   * Override properties, not the material within the [Mesh] resource. To get the material within the
   * [Mesh] resource, use [Mesh.surfaceGetMaterial] instead.
   */
  public final fun getSurfaceOverrideMaterial(surface: Int): Material? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to surface.toLong())
    TransferContext.callMethod(MethodBindings.getSurfaceOverrideMaterialPtr)
    return (TransferContext.readReturnValue(OBJECT) as Material?)
  }

  /**
   * Returns the [Material] that will be used by the [Mesh] when drawing. This can return the
   * [GeometryInstance3D.materialOverride], the surface override [Material] defined in this
   * [MeshInstance3D], or the surface [Material] defined in the [mesh]. For example, if
   * [GeometryInstance3D.materialOverride] is used, all surfaces will return the override material.
   *
   * Returns `null` if no material is active, including when [mesh] is `null`.
   */
  public final fun getActiveMaterial(surface: Int): Material? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to surface.toLong())
    TransferContext.callMethod(MethodBindings.getActiveMaterialPtr)
    return (TransferContext.readReturnValue(OBJECT) as Material?)
  }

  /**
   * This helper creates a [StaticBody3D] child node with a [ConcavePolygonShape3D] collision shape
   * calculated from the mesh geometry. It's mainly used for testing.
   */
  public final fun createTrimeshCollision(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.createTrimeshCollisionPtr)
  }

  /**
   * This helper creates a [StaticBody3D] child node with a [ConvexPolygonShape3D] collision shape
   * calculated from the mesh geometry. It's mainly used for testing.
   *
   * If [clean] is `true` (default), duplicate and interior vertices are removed automatically. You
   * can set it to `false` to make the process faster if not needed.
   *
   * If [simplify] is `true`, the geometry can be further simplified to reduce the number of
   * vertices. Disabled by default.
   */
  @JvmOverloads
  public final fun createConvexCollision(clean: Boolean = true, simplify: Boolean = false): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to clean, BOOL to simplify)
    TransferContext.callMethod(MethodBindings.createConvexCollisionPtr)
  }

  /**
   * This helper creates a [StaticBody3D] child node with multiple [ConvexPolygonShape3D] collision
   * shapes calculated from the mesh geometry via convex decomposition. The convex decomposition
   * operation can be controlled with parameters from the optional [settings].
   */
  @JvmOverloads
  public final fun createMultipleConvexCollisions(settings: MeshConvexDecompositionSettings? =
      null): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to settings)
    TransferContext.callMethod(MethodBindings.createMultipleConvexCollisionsPtr)
  }

  /**
   * Returns the number of blend shapes available. Produces an error if [mesh] is `null`.
   */
  public final fun getBlendShapeCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBlendShapeCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the index of the blend shape with the given [name]. Returns `-1` if no blend shape with
   * this name exists, including when [mesh] is `null`.
   */
  public final fun findBlendShapeByName(name: StringName): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.findBlendShapeByNamePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the value of the blend shape at the given [blendShapeIdx]. Returns `0.0` and produces
   * an error if [mesh] is `null` or doesn't have a blend shape at that index.
   */
  public final fun getBlendShapeValue(blendShapeIdx: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to blendShapeIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBlendShapeValuePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the value of the blend shape at [blendShapeIdx] to [value]. Produces an error if [mesh] is
   * `null` or doesn't have a blend shape at that index.
   */
  public final fun setBlendShapeValue(blendShapeIdx: Int, `value`: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to blendShapeIdx.toLong(), DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.setBlendShapeValuePtr)
  }

  /**
   * This helper creates a [MeshInstance3D] child node with gizmos at every vertex calculated from
   * the mesh geometry. It's mainly used for testing.
   */
  public final fun createDebugTangents(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.createDebugTangentsPtr)
  }

  /**
   * Takes a snapshot from the current [ArrayMesh] with all blend shapes applied according to their
   * current weights and bakes it to the provided [existing] mesh. If no [existing] mesh is provided a
   * new [ArrayMesh] is created, baked and returned. Mesh surface materials are not copied.
   *
   * **Performance:** [Mesh] data needs to be received from the GPU, stalling the [RenderingServer]
   * in the process.
   */
  @JvmOverloads
  public final fun bakeMeshFromCurrentBlendShapeMix(existing: ArrayMesh? = null): ArrayMesh? {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to existing)
    TransferContext.callMethod(MethodBindings.bakeMeshFromCurrentBlendShapeMixPtr)
    return (TransferContext.readReturnValue(OBJECT) as ArrayMesh?)
  }

  /**
   * Takes a snapshot of the current animated skeleton pose of the skinned mesh and bakes it to the
   * provided [existing] mesh. If no [existing] mesh is provided a new [ArrayMesh] is created, baked,
   * and returned. Requires a skeleton with a registered skin to work. Blendshapes are ignored. Mesh
   * surface materials are not copied.
   *
   * **Performance:** [Mesh] data needs to be retrieved from the GPU, stalling the [RenderingServer]
   * in the process.
   */
  @JvmOverloads
  public final fun bakeMeshFromCurrentSkeletonPose(existing: ArrayMesh? = null): ArrayMesh? {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to existing)
    TransferContext.callMethod(MethodBindings.bakeMeshFromCurrentSkeletonPosePtr)
    return (TransferContext.readReturnValue(OBJECT) as ArrayMesh?)
  }

  public final fun setSkeletonPath(skeletonPath: String) =
      setSkeletonPath(skeletonPath.asCachedNodePath())

  /**
   * Returns the index of the blend shape with the given [name]. Returns `-1` if no blend shape with
   * this name exists, including when [mesh] is `null`.
   */
  public final fun findBlendShapeByName(name: String): Int =
      findBlendShapeByName(name.asCachedStringName())

  public companion object {
    @JvmField
    public val setMeshName: MethodStringName1<MeshInstance3D, Unit, Mesh?> =
        MethodStringName1<MeshInstance3D, Unit, Mesh?>("set_mesh")

    @JvmField
    public val getMeshName: MethodStringName0<MeshInstance3D, Mesh?> =
        MethodStringName0<MeshInstance3D, Mesh?>("get_mesh")

    @JvmField
    public val setSkeletonPathName: MethodStringName1<MeshInstance3D, Unit, NodePath> =
        MethodStringName1<MeshInstance3D, Unit, NodePath>("set_skeleton_path")

    @JvmField
    public val getSkeletonPathName: MethodStringName0<MeshInstance3D, NodePath> =
        MethodStringName0<MeshInstance3D, NodePath>("get_skeleton_path")

    @JvmField
    public val setSkinName: MethodStringName1<MeshInstance3D, Unit, Skin?> =
        MethodStringName1<MeshInstance3D, Unit, Skin?>("set_skin")

    @JvmField
    public val getSkinName: MethodStringName0<MeshInstance3D, Skin?> =
        MethodStringName0<MeshInstance3D, Skin?>("get_skin")

    @JvmField
    public val getSkinReferenceName: MethodStringName0<MeshInstance3D, SkinReference?> =
        MethodStringName0<MeshInstance3D, SkinReference?>("get_skin_reference")

    @JvmField
    public val getSurfaceOverrideMaterialCountName: MethodStringName0<MeshInstance3D, Int> =
        MethodStringName0<MeshInstance3D, Int>("get_surface_override_material_count")

    @JvmField
    public val setSurfaceOverrideMaterialName:
        MethodStringName2<MeshInstance3D, Unit, Int, Material?> =
        MethodStringName2<MeshInstance3D, Unit, Int, Material?>("set_surface_override_material")

    @JvmField
    public val getSurfaceOverrideMaterialName: MethodStringName1<MeshInstance3D, Material?, Int> =
        MethodStringName1<MeshInstance3D, Material?, Int>("get_surface_override_material")

    @JvmField
    public val getActiveMaterialName: MethodStringName1<MeshInstance3D, Material?, Int> =
        MethodStringName1<MeshInstance3D, Material?, Int>("get_active_material")

    @JvmField
    public val createTrimeshCollisionName: MethodStringName0<MeshInstance3D, Unit> =
        MethodStringName0<MeshInstance3D, Unit>("create_trimesh_collision")

    @JvmField
    public val createConvexCollisionName: MethodStringName2<MeshInstance3D, Unit, Boolean, Boolean>
        = MethodStringName2<MeshInstance3D, Unit, Boolean, Boolean>("create_convex_collision")

    @JvmField
    public val createMultipleConvexCollisionsName:
        MethodStringName1<MeshInstance3D, Unit, MeshConvexDecompositionSettings?> =
        MethodStringName1<MeshInstance3D, Unit, MeshConvexDecompositionSettings?>("create_multiple_convex_collisions")

    @JvmField
    public val getBlendShapeCountName: MethodStringName0<MeshInstance3D, Int> =
        MethodStringName0<MeshInstance3D, Int>("get_blend_shape_count")

    @JvmField
    public val findBlendShapeByNameName: MethodStringName1<MeshInstance3D, Int, StringName> =
        MethodStringName1<MeshInstance3D, Int, StringName>("find_blend_shape_by_name")

    @JvmField
    public val getBlendShapeValueName: MethodStringName1<MeshInstance3D, Float, Int> =
        MethodStringName1<MeshInstance3D, Float, Int>("get_blend_shape_value")

    @JvmField
    public val setBlendShapeValueName: MethodStringName2<MeshInstance3D, Unit, Int, Float> =
        MethodStringName2<MeshInstance3D, Unit, Int, Float>("set_blend_shape_value")

    @JvmField
    public val createDebugTangentsName: MethodStringName0<MeshInstance3D, Unit> =
        MethodStringName0<MeshInstance3D, Unit>("create_debug_tangents")

    @JvmField
    public val bakeMeshFromCurrentBlendShapeMixName:
        MethodStringName1<MeshInstance3D, ArrayMesh?, ArrayMesh?> =
        MethodStringName1<MeshInstance3D, ArrayMesh?, ArrayMesh?>("bake_mesh_from_current_blend_shape_mix")

    @JvmField
    public val bakeMeshFromCurrentSkeletonPoseName:
        MethodStringName1<MeshInstance3D, ArrayMesh?, ArrayMesh?> =
        MethodStringName1<MeshInstance3D, ArrayMesh?, ArrayMesh?>("bake_mesh_from_current_skeleton_pose")
  }

  public object MethodBindings {
    internal val setMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "set_mesh", 194775623)

    internal val getMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "get_mesh", 1808005922)

    internal val setSkeletonPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "set_skeleton_path", 1348162250)

    internal val getSkeletonPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "get_skeleton_path", 277076166)

    internal val setSkinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "set_skin", 3971435618)

    internal val getSkinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "get_skin", 2074563878)

    internal val getSkinReferencePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "get_skin_reference", 2060603409)

    internal val getSurfaceOverrideMaterialCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "get_surface_override_material_count", 3905245786)

    internal val setSurfaceOverrideMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "set_surface_override_material", 3671737478)

    internal val getSurfaceOverrideMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "get_surface_override_material", 2897466400)

    internal val getActiveMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "get_active_material", 2897466400)

    internal val createTrimeshCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "create_trimesh_collision", 3218959716)

    internal val createConvexCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "create_convex_collision", 2751962654)

    internal val createMultipleConvexCollisionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "create_multiple_convex_collisions", 628789669)

    internal val getBlendShapeCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "get_blend_shape_count", 3905245786)

    internal val findBlendShapeByNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "find_blend_shape_by_name", 4150868206)

    internal val getBlendShapeValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "get_blend_shape_value", 2339986948)

    internal val setBlendShapeValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "set_blend_shape_value", 1602489585)

    internal val createDebugTangentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "create_debug_tangents", 3218959716)

    internal val bakeMeshFromCurrentBlendShapeMixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "bake_mesh_from_current_blend_shape_mix", 1457573577)

    internal val bakeMeshFromCurrentSkeletonPosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshInstance3D", "bake_mesh_from_current_skeleton_pose", 1457573577)
  }
}
