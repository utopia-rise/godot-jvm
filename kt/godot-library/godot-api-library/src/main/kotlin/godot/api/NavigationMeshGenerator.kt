// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_OBJECT_OBJECT_CALLABLE
import godot.callMethod_OBJECT_OBJECT_OBJECT_CALLABLE
import godot.callPtrMethod_OBJECT
import godot.callPtrMethod_OBJECT_OBJECT
import godot.common.interop.VoidPtr
import godot.core.Callable
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.VariantCallable
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * This class is responsible for creating and clearing 3D navigation meshes used as [NavigationMesh]
 * resources inside [NavigationRegion3D]. The [NavigationMeshGenerator] has very limited to no use for
 * 2D as the navigation mesh baking process expects 3D node types and 3D source geometry to parse.
 *
 * The entire navigation mesh baking is best done in a separate thread as the voxelization,
 * collision tests and mesh optimization steps involved are very slow and performance-intensive
 * operations.
 *
 * Navigation mesh baking happens in multiple steps and the result depends on 3D source geometry and
 * properties of the [NavigationMesh] resource. In the first step, starting from a root node and
 * depending on [NavigationMesh] properties all valid 3D source geometry nodes are collected from the
 * [SceneTree]. Second, all collected nodes are parsed for their relevant 3D geometry data and a
 * combined 3D mesh is build. Due to the many different types of parsable objects, from normal
 * [MeshInstance3D]s to [CSGShape3D]s or various [CollisionObject3D]s, some operations to collect
 * geometry data can trigger [RenderingServer] and [PhysicsServer3D] synchronizations. Server
 * synchronization can have a negative effect on baking time or framerate as it often involves [Mutex]
 * locking for thread security. Many parsable objects and the continuous synchronization with other
 * threaded Servers can increase the baking time significantly. On the other hand only a few but very
 * large and complex objects will take some time to prepare for the Servers which can noticeably stall
 * the next frame render. As a general rule the total number of parsable objects and their individual
 * size and complexity should be balanced to avoid framerate issues or very long baking times. The
 * combined mesh is then passed to the Recast Navigation Object to test the source geometry for
 * walkable terrain suitable to [NavigationMesh] agent properties by creating a voxel world around the
 * meshes bounding area.
 *
 * The finalized navigation mesh is then returned and stored inside the [NavigationMesh] for use as
 * a resource inside [NavigationRegion3D] nodes.
 *
 * **Note:** Using meshes to not only define walkable surfaces but also obstruct navigation baking
 * does not always work. The navigation baking has no concept of what is a geometry "inside" when
 * dealing with mesh source geometry and this is intentional. Depending on current baking parameters,
 * as soon as the obstructing mesh is large enough to fit a navigation mesh area inside, the baking
 * will generate navigation mesh areas that are inside the obstructing source geometry mesh.
 */
@GodotBaseType
public object NavigationMeshGenerator : Object() {
  @JvmField
  public val bakeName: MethodStringName2<NavigationMeshGenerator, Unit, NavigationMesh?, Node?> =
      MethodStringName2<NavigationMeshGenerator, Unit, NavigationMesh?, Node?>("bake")

  @JvmField
  public val clearName: MethodStringName1<NavigationMeshGenerator, Unit, NavigationMesh?> =
      MethodStringName1<NavigationMeshGenerator, Unit, NavigationMesh?>("clear")

  @JvmField
  public val parseSourceGeometryDataName:
      MethodStringName4<NavigationMeshGenerator, Unit, NavigationMesh?, NavigationMeshSourceGeometryData3D?, Node?, Callable>
      =
      MethodStringName4<NavigationMeshGenerator, Unit, NavigationMesh?, NavigationMeshSourceGeometryData3D?, Node?, Callable>("parse_source_geometry_data")

  @JvmField
  public val bakeFromSourceGeometryDataName:
      MethodStringName3<NavigationMeshGenerator, Unit, NavigationMesh?, NavigationMeshSourceGeometryData3D?, Callable>
      =
      MethodStringName3<NavigationMeshGenerator, Unit, NavigationMesh?, NavigationMeshSourceGeometryData3D?, Callable>("bake_from_source_geometry_data")

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(17)
  }

  /**
   * Bakes the [navigationMesh] with source geometry collected starting from the [rootNode].
   */
  @JvmStatic
  public final fun bake(navigationMesh: NavigationMesh?, rootNode: Node?): Unit {
    TransferContext.callPtrMethod_OBJECT_OBJECT(ptr, objectID.id, MethodBindings.bakePtr, navigationMesh, rootNode)
  }

  /**
   * Removes all polygons and vertices from the provided [navigationMesh] resource.
   */
  @JvmStatic
  public final fun clear(navigationMesh: NavigationMesh?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.clearPtr, navigationMesh)
  }

  /**
   * Parses the [SceneTree] for source geometry according to the properties of [navigationMesh].
   * Updates the provided [sourceGeometryData] resource with the resulting data. The resource can then
   * be used to bake a navigation mesh with [bakeFromSourceGeometryData]. After the process is finished
   * the optional [callback] will be called.
   *
   * **Note:** This function needs to run on the main thread or with a deferred call as the
   * SceneTree is not thread-safe.
   *
   * **Performance:** While convenient, reading data arrays from [Mesh] resources can affect the
   * frame rate negatively. The data needs to be received from the GPU, stalling the [RenderingServer]
   * in the process. For performance prefer the use of e.g. collision shapes or creating the data
   * arrays entirely in code.
   */
  @JvmOverloads
  @JvmStatic
  public final fun parseSourceGeometryData(
    navigationMesh: NavigationMesh?,
    sourceGeometryData: NavigationMeshSourceGeometryData3D?,
    rootNode: Node?,
    callback: Callable = VariantCallable(),
  ): Unit {
    TransferContext.callMethod_OBJECT_OBJECT_OBJECT_CALLABLE(ptr, objectID.id, MethodBindings.parseSourceGeometryDataPtr, navigationMesh, sourceGeometryData, rootNode, callback)
  }

  /**
   * Bakes the provided [navigationMesh] with the data from the provided [sourceGeometryData]. After
   * the process is finished the optional [callback] will be called.
   */
  @JvmOverloads
  @JvmStatic
  public final fun bakeFromSourceGeometryData(
    navigationMesh: NavigationMesh?,
    sourceGeometryData: NavigationMeshSourceGeometryData3D?,
    callback: Callable = VariantCallable(),
  ): Unit {
    TransferContext.callMethod_OBJECT_OBJECT_CALLABLE(ptr, objectID.id, MethodBindings.bakeFromSourceGeometryDataPtr, navigationMesh, sourceGeometryData, callback)
  }

  public object MethodBindings {
    internal val bakePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshGenerator", "bake", 1401173477)

    internal val clearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshGenerator", "clear", 2923361153)

    internal val parseSourceGeometryDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshGenerator", "parse_source_geometry_data", 3172802542)

    internal val bakeFromSourceGeometryDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationMeshGenerator", "bake_from_source_geometry_data", 1286748856)
  }
}
