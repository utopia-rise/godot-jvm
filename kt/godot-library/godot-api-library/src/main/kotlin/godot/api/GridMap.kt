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
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_ARRAY
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod0_ret_RID
import godot.callPtrMethod0_ret_VECTOR3
import godot.callPtrMethod_AABB_ret_ARRAY
import godot.callPtrMethod_BASIS_ret_LONG
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_BOOL_DOUBLE
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_BOOL
import godot.callPtrMethod_LONG_ret_ARRAY
import godot.callPtrMethod_LONG_ret_BASIS
import godot.callPtrMethod_LONG_ret_BOOL
import godot.callPtrMethod_LONG_ret_RID
import godot.callPtrMethod_OBJECT
import godot.callPtrMethod_RID
import godot.callPtrMethod_VECTOR3
import godot.callPtrMethod_VECTOR3I_LONG_LONG
import godot.callPtrMethod_VECTOR3I_LONG_ret_ARRAY
import godot.callPtrMethod_VECTOR3I_ret_ARRAY
import godot.callPtrMethod_VECTOR3I_ret_BASIS
import godot.callPtrMethod_VECTOR3I_ret_LONG
import godot.callPtrMethod_VECTOR3I_ret_VECTOR3
import godot.callPtrMethod_VECTOR3I_ret_VECTOR3I
import godot.callPtrMethod_VECTOR3_ret_VECTOR3I
import godot.common.interop.VoidPtr
import godot.core.AABB
import godot.core.Basis
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.RID
import godot.core.Signal0
import godot.core.Signal1
import godot.core.Transform3D
import godot.core.VariantArray
import godot.core.Vector3
import godot.core.Vector3i
import kotlin.Any
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * GridMap lets you place meshes on a grid interactively. It works both from the editor and from
 * scripts, which can help you create in-game level editors.
 *
 * GridMaps use a [MeshLibrary] which contains a list of tiles. Each tile is a mesh with materials
 * plus optional collision and navigation shapes.
 *
 * A GridMap contains a collection of cells. Each grid cell refers to a tile in the [MeshLibrary].
 * All cells in the map have the same dimensions.
 *
 * Internally, a GridMap is split into a sparse collection of octants for efficient rendering and
 * physics processing. Every octant has the same dimensions and can contain several cells.
 *
 * **Note:** GridMap doesn't extend [VisualInstance3D] and therefore can't be hidden or cull masked
 * based on [VisualInstance3D.layers]. If you make a light not affect the first layer, the whole
 * GridMap won't be lit by the light in question.
 */
@GodotBaseType
public open class GridMap : Node3D() {
  /**
   * Emitted when [cellSize] changes.
   */
  public val cellSizeChanged: Signal1<Vector3> by Signal1

  /**
   * Emitted when the [MeshLibrary] of this GridMap changes.
   */
  public val changed: Signal0 by Signal0

  /**
   * The assigned [MeshLibrary].
   */
  public final inline var meshLibrary: MeshLibrary?
    @JvmName("meshLibraryProperty")
    get() = getMeshLibrary()
    @JvmName("meshLibraryProperty")
    set(`value`) {
      setMeshLibrary(value)
    }

  /**
   * Overrides the default friction and bounce physics properties for the whole [GridMap].
   */
  public final inline var physicsMaterial: PhysicsMaterial?
    @JvmName("physicsMaterialProperty")
    get() = getPhysicsMaterial()
    @JvmName("physicsMaterialProperty")
    set(`value`) {
      setPhysicsMaterial(value)
    }

  /**
   * The dimensions of the grid's cells.
   *
   * This does not affect the size of the meshes. See [cellScale].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var cellSize: Vector3
    @JvmName("cellSizeProperty")
    get() = getCellSize()
    @JvmName("cellSizeProperty")
    set(`value`) {
      setCellSize(value)
    }

  /**
   * The size of each octant measured in number of cells. This applies to all three axis.
   */
  public final inline var cellOctantSize: Int
    @JvmName("cellOctantSizeProperty")
    get() = getOctantSize()
    @JvmName("cellOctantSizeProperty")
    set(`value`) {
      setOctantSize(value)
    }

  /**
   * If `true`, grid items are centered on the X axis.
   */
  public final inline var cellCenterX: Boolean
    @JvmName("cellCenterXProperty")
    get() = getCenterX()
    @JvmName("cellCenterXProperty")
    set(`value`) {
      setCenterX(value)
    }

  /**
   * If `true`, grid items are centered on the Y axis.
   */
  public final inline var cellCenterY: Boolean
    @JvmName("cellCenterYProperty")
    get() = getCenterY()
    @JvmName("cellCenterYProperty")
    set(`value`) {
      setCenterY(value)
    }

  /**
   * If `true`, grid items are centered on the Z axis.
   */
  public final inline var cellCenterZ: Boolean
    @JvmName("cellCenterZProperty")
    get() = getCenterZ()
    @JvmName("cellCenterZProperty")
    set(`value`) {
      setCenterZ(value)
    }

  /**
   * The scale of the cell items.
   *
   * This does not affect the size of the grid cells themselves, only the items in them. This can be
   * used to make cell items overlap their neighbors.
   */
  public final inline var cellScale: Float
    @JvmName("cellScaleProperty")
    get() = getCellScale()
    @JvmName("cellScaleProperty")
    set(`value`) {
      setCellScale(value)
    }

  /**
   * The physics layers this GridMap is in.
   *
   * GridMaps act as static bodies, meaning they aren't affected by gravity or other forces. They
   * only affect other physics bodies that collide with them.
   */
  public final inline var collisionLayer: Long
    @JvmName("collisionLayerProperty")
    get() = getCollisionLayer()
    @JvmName("collisionLayerProperty")
    set(`value`) {
      setCollisionLayer(value)
    }

  /**
   * The physics layers this GridMap detects collisions in. See
   * [url=$DOCS_URL/tutorials/physics/physics_introduction.html#collision-layers-and-masks]Collision
   * layers and masks[/url] in the documentation for more information.
   */
  public final inline var collisionMask: Long
    @JvmName("collisionMaskProperty")
    get() = getCollisionMask()
    @JvmName("collisionMaskProperty")
    set(`value`) {
      setCollisionMask(value)
    }

  /**
   * The priority used to solve colliding when occurring penetration. The higher the priority is,
   * the lower the penetration into the object will be. This can for example be used to prevent the
   * player from breaking through the boundaries of a level.
   */
  public final inline var collisionPriority: Float
    @JvmName("collisionPriorityProperty")
    get() = getCollisionPriority()
    @JvmName("collisionPriorityProperty")
    set(`value`) {
      setCollisionPriority(value)
    }

  /**
   * Show or hide the [GridMap]'s collision shapes. If set to [DEBUG_VISIBILITY_MODE_DEFAULT], this
   * depends on the show collision debug settings.
   */
  public final inline var collisionVisibilityMode: DebugVisibilityMode
    @JvmName("collisionVisibilityModeProperty")
    get() = getCollisionVisibilityMode()
    @JvmName("collisionVisibilityModeProperty")
    set(`value`) {
      setCollisionVisibilityMode(value)
    }

  /**
   * If `true`, this GridMap creates a navigation region for each cell that uses a [meshLibrary]
   * item with a navigation mesh. The created navigation region will use the navigation layers bitmask
   * assigned to the [MeshLibrary]'s item.
   */
  public final inline var bakeNavigation: Boolean
    @JvmName("bakeNavigationProperty")
    get() = isBakingNavigation()
    @JvmName("bakeNavigationProperty")
    set(`value`) {
      setBakeNavigation(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(282, scriptPtr)
  }

  /**
   * This is a helper function for [cellSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gridmap.cellSize
   * //Your changes
   * gridmap.cellSize = myCoreType
   * ``````
   *
   * The dimensions of the grid's cells.
   *
   * This does not affect the size of the meshes. See [cellScale].
   */
  @CoreTypeHelper
  public final fun cellSizeMutate(block: Vector3.() -> Unit): Vector3 = cellSize.apply {
     block(this)
     cellSize = this
  }

  public final fun setCollisionLayer(layer: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setCollisionLayerPtr, layer)
  }

  public final fun getCollisionLayer(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getCollisionLayerPtr)

  public final fun setCollisionMask(mask: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setCollisionMaskPtr, mask)
  }

  public final fun getCollisionMask(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getCollisionMaskPtr)

  /**
   * Based on [value], enables or disables the specified layer in the [collisionMask], given a
   * [layerNumber] between 1 and 32.
   */
  public final fun setCollisionMaskValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setCollisionMaskValuePtr, layerNumber.toLong(), value)
  }

  /**
   * Returns whether or not the specified layer of the [collisionMask] is enabled, given a
   * [layerNumber] between 1 and 32.
   */
  public final fun getCollisionMaskValue(layerNumber: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.getCollisionMaskValuePtr, layerNumber.toLong())

  /**
   * Based on [value], enables or disables the specified layer in the [collisionLayer], given a
   * [layerNumber] between 1 and 32.
   */
  public final fun setCollisionLayerValue(layerNumber: Int, `value`: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setCollisionLayerValuePtr, layerNumber.toLong(), value)
  }

  /**
   * Returns whether or not the specified layer of the [collisionLayer] is enabled, given a
   * [layerNumber] between 1 and 32.
   */
  public final fun getCollisionLayerValue(layerNumber: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.getCollisionLayerValuePtr, layerNumber.toLong())

  public final fun setCollisionPriority(priority: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setCollisionPriorityPtr, priority.toDouble())
  }

  public final fun getCollisionPriority(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getCollisionPriorityPtr).toFloat()

  public final fun setCollisionVisibilityMode(visibilityMode: DebugVisibilityMode): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setCollisionVisibilityModePtr, visibilityMode.value)
  }

  public final fun getCollisionVisibilityMode(): DebugVisibilityMode =
      DebugVisibilityMode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getCollisionVisibilityModePtr))

  public final fun setPhysicsMaterial(material: PhysicsMaterial?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setPhysicsMaterialPtr, material)
  }

  public final fun getPhysicsMaterial(): PhysicsMaterial? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getPhysicsMaterialPtr) as PhysicsMaterial?)

  public final fun setBakeNavigation(bakeNavigation: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setBakeNavigationPtr, bakeNavigation)
  }

  public final fun isBakingNavigation(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isBakingNavigationPtr)

  /**
   * Sets the [RID] of the navigation map this GridMap node should use for its cell baked navigation
   * meshes.
   */
  public final fun setNavigationMap(navigationMap: RID): Unit {
    TransferContext.callPtrMethod_RID(ptr, objectID.id, MethodBindings.setNavigationMapPtr, navigationMap)
  }

  /**
   * Returns the [RID] of the navigation map this GridMap node uses for its cell baked navigation
   * meshes.
   *
   * This function returns always the map set on the GridMap node and not the map on the
   * NavigationServer. If the map is changed directly with the NavigationServer API the GridMap node
   * will not be aware of the map change.
   */
  public final fun getNavigationMap(): RID =
      TransferContext.callPtrMethod0_ret_RID(ptr, objectID.id, MethodBindings.getNavigationMapPtr)

  public final fun setMeshLibrary(meshLibrary: MeshLibrary?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setMeshLibraryPtr, meshLibrary)
  }

  public final fun getMeshLibrary(): MeshLibrary? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getMeshLibraryPtr) as MeshLibrary?)

  public final fun setCellSize(size: Vector3): Unit {
    TransferContext.callPtrMethod_VECTOR3(ptr, objectID.id, MethodBindings.setCellSizePtr, size)
  }

  public final fun getCellSize(): Vector3 =
      TransferContext.callPtrMethod0_ret_VECTOR3(ptr, objectID.id, MethodBindings.getCellSizePtr)

  public final fun setCellScale(scale: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setCellScalePtr, scale.toDouble())
  }

  public final fun getCellScale(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getCellScalePtr).toFloat()

  public final fun setOctantSize(size: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setOctantSizePtr, size.toLong())
  }

  public final fun getOctantSize(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getOctantSizePtr).toInt()

  /**
   * Sets the mesh index for the cell referenced by its grid coordinates.
   *
   * A negative item index such as [INVALID_CELL_ITEM] will clear the cell.
   *
   * Optionally, the item's orientation can be passed. For valid orientation values, see
   * [getOrthogonalIndexFromBasis].
   */
  @JvmOverloads
  public final fun setCellItem(
    position: Vector3i,
    item: Int,
    orientation: Int = 0,
  ): Unit {
    TransferContext.callPtrMethod_VECTOR3I_LONG_LONG(ptr, objectID.id, MethodBindings.setCellItemPtr, position, item.toLong(), orientation.toLong())
  }

  /**
   * The [MeshLibrary] item index located at the given grid coordinates. If the cell is empty,
   * [INVALID_CELL_ITEM] will be returned.
   */
  public final fun getCellItem(position: Vector3i): Int =
      TransferContext.callPtrMethod_VECTOR3I_ret_LONG(ptr, objectID.id, MethodBindings.getCellItemPtr, position).toInt()

  /**
   * The orientation of the cell at the given grid coordinates. `-1` is returned if the cell is
   * empty.
   */
  public final fun getCellItemOrientation(position: Vector3i): Int =
      TransferContext.callPtrMethod_VECTOR3I_ret_LONG(ptr, objectID.id, MethodBindings.getCellItemOrientationPtr, position).toInt()

  /**
   * Returns the basis that gives the specified cell its orientation.
   */
  public final fun getCellItemBasis(position: Vector3i): Basis =
      TransferContext.callPtrMethod_VECTOR3I_ret_BASIS(ptr, objectID.id, MethodBindings.getCellItemBasisPtr, position)

  /**
   * Returns one of 24 possible rotations that lie along the vectors (x,y,z) with each component
   * being either -1, 0, or 1. For further details, refer to the Godot source code.
   */
  public final fun getBasisWithOrthogonalIndex(index: Int): Basis =
      TransferContext.callPtrMethod_LONG_ret_BASIS(ptr, objectID.id, MethodBindings.getBasisWithOrthogonalIndexPtr, index.toLong())

  /**
   * This function considers a discretization of rotations into 24 points on unit sphere, lying
   * along the vectors (x,y,z) with each component being either -1, 0, or 1, and returns the index (in
   * the range from 0 to 23) of the point best representing the orientation of the object. For further
   * details, refer to the Godot source code.
   */
  public final fun getOrthogonalIndexFromBasis(basis: Basis): Int =
      TransferContext.callPtrMethod_BASIS_ret_LONG(ptr, objectID.id, MethodBindings.getOrthogonalIndexFromBasisPtr, basis).toInt()

  /**
   * Returns the map coordinates of the cell containing the given [localPosition]. If
   * [localPosition] is in global coordinates, consider using [Node3D.toLocal] before passing it to
   * this method. See also [mapToLocal].
   */
  public final fun localToMap(localPosition: Vector3): Vector3i =
      TransferContext.callPtrMethod_VECTOR3_ret_VECTOR3I(ptr, objectID.id, MethodBindings.localToMapPtr, localPosition)

  /**
   * Returns the position of a grid cell in the GridMap's local coordinate space. To convert the
   * returned value into global coordinates, use [Node3D.toGlobal]. See also [localToMap].
   */
  public final fun mapToLocal(mapPosition: Vector3i): Vector3 =
      TransferContext.callPtrMethod_VECTOR3I_ret_VECTOR3(ptr, objectID.id, MethodBindings.mapToLocalPtr, mapPosition)

  /**
   * This method does nothing.
   */
  public final fun resourceChanged(resource: Resource?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.resourceChangedPtr, resource)
  }

  public final fun setCenterX(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setCenterXPtr, enable)
  }

  public final fun getCenterX(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getCenterXPtr)

  public final fun setCenterY(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setCenterYPtr, enable)
  }

  public final fun getCenterY(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getCenterYPtr)

  public final fun setCenterZ(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setCenterZPtr, enable)
  }

  public final fun getCenterZ(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getCenterZPtr)

  /**
   * Clear all cells.
   */
  public final fun clear(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearPtr)
  }

  /**
   * Returns an array of [Vector3] with the non-empty cell coordinates in the grid map.
   */
  public final fun getUsedCells(): VariantArray<Vector3i> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.getUsedCellsPtr) as VariantArray<Vector3i>)

  /**
   * Returns an array of all cells with the given item index specified in [item].
   */
  public final fun getUsedCellsByItem(item: Int): VariantArray<Vector3i> =
      (TransferContext.callPtrMethod_LONG_ret_ARRAY(ptr, objectID.id, MethodBindings.getUsedCellsByItemPtr, item.toLong()) as VariantArray<Vector3i>)

  /**
   * Returns an array of [Vector3i]s with the octant coordinates of the non-empty octants in the
   * grid map.
   */
  public final fun getUsedOctants(): VariantArray<Vector3i> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.getUsedOctantsPtr) as VariantArray<Vector3i>)

  /**
   * Returns an array of [Vector3i]s with the octant coordinates of the octants that use the
   * specified [item] in the grid map.
   */
  public final fun getUsedOctantsByItem(item: Int): VariantArray<Vector3i> =
      (TransferContext.callPtrMethod_LONG_ret_ARRAY(ptr, objectID.id, MethodBindings.getUsedOctantsByItemPtr, item.toLong()) as VariantArray<Vector3i>)

  /**
   * Returns an array of [Vector3i]s with the cell coordinates of non-empty cells inside the octant
   * at [octantCoords].
   */
  public final fun getUsedCellsInOctant(octantCoords: Vector3i): VariantArray<Vector3i> =
      (TransferContext.callPtrMethod_VECTOR3I_ret_ARRAY(ptr, objectID.id, MethodBindings.getUsedCellsInOctantPtr, octantCoords) as VariantArray<Vector3i>)

  /**
   * Returns an array of [Vector3i]s with the cell coordinates of cells inside the octant at
   * [octantCoords] that use the specified cell [item].
   */
  public final fun getUsedCellsInOctantByItem(octantCoords: Vector3i, item: Int):
      VariantArray<Vector3i> =
      (TransferContext.callPtrMethod_VECTOR3I_LONG_ret_ARRAY(ptr, objectID.id, MethodBindings.getUsedCellsInOctantByItemPtr, octantCoords, item.toLong()) as VariantArray<Vector3i>)

  /**
   * Returns an array of [Vector3i] octant coordinates that are inside the given [bounds], including
   * octants that have no cells in use.
   */
  public final fun getOctantsInBounds(bounds: AABB): VariantArray<Vector3i> =
      (TransferContext.callPtrMethod_AABB_ret_ARRAY(ptr, objectID.id, MethodBindings.getOctantsInBoundsPtr, bounds) as VariantArray<Vector3i>)

  /**
   * Returns an array of [Vector3i]s with the octant coordinates of non-empty octants that are
   * inside the local [bounds].
   */
  public final fun getUsedOctantsInBounds(bounds: AABB): VariantArray<Vector3i> =
      (TransferContext.callPtrMethod_AABB_ret_ARRAY(ptr, objectID.id, MethodBindings.getUsedOctantsInBoundsPtr, bounds) as VariantArray<Vector3i>)

  /**
   * Returns the [Vector3i] octant coordinates of the octant that the cell at [cellCoords] belongs
   * to.
   */
  public final fun getOctantCoordsFromCellCoords(cellCoords: Vector3i): Vector3i =
      TransferContext.callPtrMethod_VECTOR3I_ret_VECTOR3I(ptr, objectID.id, MethodBindings.getOctantCoordsFromCellCoordsPtr, cellCoords)

  /**
   * Returns an array of [Transform3D] and [Mesh] references corresponding to the non-empty cells in
   * the grid. The transforms are specified in local space. Even indices contain [Transform3D]s, while
   * odd indices contain [Mesh]es related to the [Transform3D] in the index preceding it.
   */
  public final fun getMeshes(): VariantArray<Any?> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.getMeshesPtr) as VariantArray<Any?>)

  /**
   * Returns an array of [ArrayMesh]es and [Transform3D] references of all bake meshes that exist
   * within the current GridMap. Even indices contain [ArrayMesh]es, while odd indices contain
   * [Transform3D]s that are always equal to [Transform3D.IDENTITY].
   *
   * This method relies on the output of [makeBakedMeshes], which will be called with
   * `gen_lightmap_uv` set to `true` and `lightmap_uv_texel_size` set to `0.1` if it hasn't been called
   * yet.
   */
  public final fun getBakeMeshes(): VariantArray<Any?> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.getBakeMeshesPtr) as VariantArray<Any?>)

  /**
   * Returns [RID] of a baked mesh with the given [idx].
   */
  public final fun getBakeMeshInstance(idx: Int): RID =
      TransferContext.callPtrMethod_LONG_ret_RID(ptr, objectID.id, MethodBindings.getBakeMeshInstancePtr, idx.toLong())

  /**
   * Clears all baked meshes. See [makeBakedMeshes].
   */
  public final fun clearBakedMeshes(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearBakedMeshesPtr)
  }

  /**
   * Generates a baked mesh that represents all meshes in the assigned [MeshLibrary] for use with
   * [LightmapGI]. If [genLightmapUv] is `true`, UV2 data will be generated for each mesh currently
   * used in the [GridMap]. Otherwise, only meshes that already have UV2 data present will be able to
   * use baked lightmaps. When generating UV2, [lightmapUvTexelSize] controls the texel density for
   * lightmaps, with lower values resulting in more detailed lightmaps. [lightmapUvTexelSize] is
   * ignored if [genLightmapUv] is `false`. See also [getBakeMeshes], which relies on the output of
   * this method.
   *
   * **Note:** Calling this method will not actually bake lightmaps, as lightmap baking is performed
   * using the [LightmapGI] node.
   */
  @JvmOverloads
  public final fun makeBakedMeshes(genLightmapUv: Boolean = false, lightmapUvTexelSize: Float =
      0.1f): Unit {
    TransferContext.callPtrMethod_BOOL_DOUBLE(ptr, objectID.id, MethodBindings.makeBakedMeshesPtr, genLightmapUv, lightmapUvTexelSize.toDouble())
  }

  public enum class DebugVisibilityMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Hide the collisions debug shapes in the editor, and use the debug settings to determine their
     * visibility in game (i.e. [SceneTree.debugCollisionsHint] or [SceneTree.debugNavigationHint]).
     */
    DEFAULT(0),
    /**
     * Always show the collisions debug shapes.
     */
    FORCE_SHOW(1),
    /**
     * Always hide the collisions debug shapes.
     */
    FORCE_HIDE(2),
    ;

    public companion object {
      public fun from(`value`: Long): DebugVisibilityMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setCollisionLayerName: MethodStringName1<GridMap, Unit, Long> =
        MethodStringName1<GridMap, Unit, Long>("set_collision_layer")

    @JvmField
    public val getCollisionLayerName: MethodStringName0<GridMap, Long> =
        MethodStringName0<GridMap, Long>("get_collision_layer")

    @JvmField
    public val setCollisionMaskName: MethodStringName1<GridMap, Unit, Long> =
        MethodStringName1<GridMap, Unit, Long>("set_collision_mask")

    @JvmField
    public val getCollisionMaskName: MethodStringName0<GridMap, Long> =
        MethodStringName0<GridMap, Long>("get_collision_mask")

    @JvmField
    public val setCollisionMaskValueName: MethodStringName2<GridMap, Unit, Int, Boolean> =
        MethodStringName2<GridMap, Unit, Int, Boolean>("set_collision_mask_value")

    @JvmField
    public val getCollisionMaskValueName: MethodStringName1<GridMap, Boolean, Int> =
        MethodStringName1<GridMap, Boolean, Int>("get_collision_mask_value")

    @JvmField
    public val setCollisionLayerValueName: MethodStringName2<GridMap, Unit, Int, Boolean> =
        MethodStringName2<GridMap, Unit, Int, Boolean>("set_collision_layer_value")

    @JvmField
    public val getCollisionLayerValueName: MethodStringName1<GridMap, Boolean, Int> =
        MethodStringName1<GridMap, Boolean, Int>("get_collision_layer_value")

    @JvmField
    public val setCollisionPriorityName: MethodStringName1<GridMap, Unit, Float> =
        MethodStringName1<GridMap, Unit, Float>("set_collision_priority")

    @JvmField
    public val getCollisionPriorityName: MethodStringName0<GridMap, Float> =
        MethodStringName0<GridMap, Float>("get_collision_priority")

    @JvmField
    public val setCollisionVisibilityModeName: MethodStringName1<GridMap, Unit, DebugVisibilityMode>
        = MethodStringName1<GridMap, Unit, DebugVisibilityMode>("set_collision_visibility_mode")

    @JvmField
    public val getCollisionVisibilityModeName: MethodStringName0<GridMap, DebugVisibilityMode> =
        MethodStringName0<GridMap, DebugVisibilityMode>("get_collision_visibility_mode")

    @JvmField
    public val setPhysicsMaterialName: MethodStringName1<GridMap, Unit, PhysicsMaterial?> =
        MethodStringName1<GridMap, Unit, PhysicsMaterial?>("set_physics_material")

    @JvmField
    public val getPhysicsMaterialName: MethodStringName0<GridMap, PhysicsMaterial?> =
        MethodStringName0<GridMap, PhysicsMaterial?>("get_physics_material")

    @JvmField
    public val setBakeNavigationName: MethodStringName1<GridMap, Unit, Boolean> =
        MethodStringName1<GridMap, Unit, Boolean>("set_bake_navigation")

    @JvmField
    public val isBakingNavigationName: MethodStringName0<GridMap, Boolean> =
        MethodStringName0<GridMap, Boolean>("is_baking_navigation")

    @JvmField
    public val setNavigationMapName: MethodStringName1<GridMap, Unit, RID> =
        MethodStringName1<GridMap, Unit, RID>("set_navigation_map")

    @JvmField
    public val getNavigationMapName: MethodStringName0<GridMap, RID> =
        MethodStringName0<GridMap, RID>("get_navigation_map")

    @JvmField
    public val setMeshLibraryName: MethodStringName1<GridMap, Unit, MeshLibrary?> =
        MethodStringName1<GridMap, Unit, MeshLibrary?>("set_mesh_library")

    @JvmField
    public val getMeshLibraryName: MethodStringName0<GridMap, MeshLibrary?> =
        MethodStringName0<GridMap, MeshLibrary?>("get_mesh_library")

    @JvmField
    public val setCellSizeName: MethodStringName1<GridMap, Unit, Vector3> =
        MethodStringName1<GridMap, Unit, Vector3>("set_cell_size")

    @JvmField
    public val getCellSizeName: MethodStringName0<GridMap, Vector3> =
        MethodStringName0<GridMap, Vector3>("get_cell_size")

    @JvmField
    public val setCellScaleName: MethodStringName1<GridMap, Unit, Float> =
        MethodStringName1<GridMap, Unit, Float>("set_cell_scale")

    @JvmField
    public val getCellScaleName: MethodStringName0<GridMap, Float> =
        MethodStringName0<GridMap, Float>("get_cell_scale")

    @JvmField
    public val setOctantSizeName: MethodStringName1<GridMap, Unit, Int> =
        MethodStringName1<GridMap, Unit, Int>("set_octant_size")

    @JvmField
    public val getOctantSizeName: MethodStringName0<GridMap, Int> =
        MethodStringName0<GridMap, Int>("get_octant_size")

    @JvmField
    public val setCellItemName: MethodStringName3<GridMap, Unit, Vector3i, Int, Int> =
        MethodStringName3<GridMap, Unit, Vector3i, Int, Int>("set_cell_item")

    @JvmField
    public val getCellItemName: MethodStringName1<GridMap, Int, Vector3i> =
        MethodStringName1<GridMap, Int, Vector3i>("get_cell_item")

    @JvmField
    public val getCellItemOrientationName: MethodStringName1<GridMap, Int, Vector3i> =
        MethodStringName1<GridMap, Int, Vector3i>("get_cell_item_orientation")

    @JvmField
    public val getCellItemBasisName: MethodStringName1<GridMap, Basis, Vector3i> =
        MethodStringName1<GridMap, Basis, Vector3i>("get_cell_item_basis")

    @JvmField
    public val getBasisWithOrthogonalIndexName: MethodStringName1<GridMap, Basis, Int> =
        MethodStringName1<GridMap, Basis, Int>("get_basis_with_orthogonal_index")

    @JvmField
    public val getOrthogonalIndexFromBasisName: MethodStringName1<GridMap, Int, Basis> =
        MethodStringName1<GridMap, Int, Basis>("get_orthogonal_index_from_basis")

    @JvmField
    public val localToMapName: MethodStringName1<GridMap, Vector3i, Vector3> =
        MethodStringName1<GridMap, Vector3i, Vector3>("local_to_map")

    @JvmField
    public val mapToLocalName: MethodStringName1<GridMap, Vector3, Vector3i> =
        MethodStringName1<GridMap, Vector3, Vector3i>("map_to_local")

    @JvmField
    public val resourceChangedName: MethodStringName1<GridMap, Unit, Resource?> =
        MethodStringName1<GridMap, Unit, Resource?>("resource_changed")

    @JvmField
    public val setCenterXName: MethodStringName1<GridMap, Unit, Boolean> =
        MethodStringName1<GridMap, Unit, Boolean>("set_center_x")

    @JvmField
    public val getCenterXName: MethodStringName0<GridMap, Boolean> =
        MethodStringName0<GridMap, Boolean>("get_center_x")

    @JvmField
    public val setCenterYName: MethodStringName1<GridMap, Unit, Boolean> =
        MethodStringName1<GridMap, Unit, Boolean>("set_center_y")

    @JvmField
    public val getCenterYName: MethodStringName0<GridMap, Boolean> =
        MethodStringName0<GridMap, Boolean>("get_center_y")

    @JvmField
    public val setCenterZName: MethodStringName1<GridMap, Unit, Boolean> =
        MethodStringName1<GridMap, Unit, Boolean>("set_center_z")

    @JvmField
    public val getCenterZName: MethodStringName0<GridMap, Boolean> =
        MethodStringName0<GridMap, Boolean>("get_center_z")

    @JvmField
    public val clearName: MethodStringName0<GridMap, Unit> =
        MethodStringName0<GridMap, Unit>("clear")

    @JvmField
    public val getUsedCellsName: MethodStringName0<GridMap, VariantArray<Vector3i>> =
        MethodStringName0<GridMap, VariantArray<Vector3i>>("get_used_cells")

    @JvmField
    public val getUsedCellsByItemName: MethodStringName1<GridMap, VariantArray<Vector3i>, Int> =
        MethodStringName1<GridMap, VariantArray<Vector3i>, Int>("get_used_cells_by_item")

    @JvmField
    public val getUsedOctantsName: MethodStringName0<GridMap, VariantArray<Vector3i>> =
        MethodStringName0<GridMap, VariantArray<Vector3i>>("get_used_octants")

    @JvmField
    public val getUsedOctantsByItemName: MethodStringName1<GridMap, VariantArray<Vector3i>, Int> =
        MethodStringName1<GridMap, VariantArray<Vector3i>, Int>("get_used_octants_by_item")

    @JvmField
    public val getUsedCellsInOctantName:
        MethodStringName1<GridMap, VariantArray<Vector3i>, Vector3i> =
        MethodStringName1<GridMap, VariantArray<Vector3i>, Vector3i>("get_used_cells_in_octant")

    @JvmField
    public val getUsedCellsInOctantByItemName:
        MethodStringName2<GridMap, VariantArray<Vector3i>, Vector3i, Int> =
        MethodStringName2<GridMap, VariantArray<Vector3i>, Vector3i, Int>("get_used_cells_in_octant_by_item")

    @JvmField
    public val getOctantsInBoundsName: MethodStringName1<GridMap, VariantArray<Vector3i>, AABB> =
        MethodStringName1<GridMap, VariantArray<Vector3i>, AABB>("get_octants_in_bounds")

    @JvmField
    public val getUsedOctantsInBoundsName: MethodStringName1<GridMap, VariantArray<Vector3i>, AABB>
        = MethodStringName1<GridMap, VariantArray<Vector3i>, AABB>("get_used_octants_in_bounds")

    @JvmField
    public val getOctantCoordsFromCellCoordsName: MethodStringName1<GridMap, Vector3i, Vector3i> =
        MethodStringName1<GridMap, Vector3i, Vector3i>("get_octant_coords_from_cell_coords")

    @JvmField
    public val getMeshesName: MethodStringName0<GridMap, VariantArray<Any?>> =
        MethodStringName0<GridMap, VariantArray<Any?>>("get_meshes")

    @JvmField
    public val getBakeMeshesName: MethodStringName0<GridMap, VariantArray<Any?>> =
        MethodStringName0<GridMap, VariantArray<Any?>>("get_bake_meshes")

    @JvmField
    public val getBakeMeshInstanceName: MethodStringName1<GridMap, RID, Int> =
        MethodStringName1<GridMap, RID, Int>("get_bake_mesh_instance")

    @JvmField
    public val clearBakedMeshesName: MethodStringName0<GridMap, Unit> =
        MethodStringName0<GridMap, Unit>("clear_baked_meshes")

    @JvmField
    public val makeBakedMeshesName: MethodStringName2<GridMap, Unit, Boolean, Float> =
        MethodStringName2<GridMap, Unit, Boolean, Float>("make_baked_meshes")

    /**
     * Invalid cell item that can be used in [setCellItem] to clear cells (or represent an empty
     * cell in [getCellItem]).
     */
    public final const val INVALID_CELL_ITEM: Long = -1
  }

  public object MethodBindings {
    internal val setCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "set_collision_layer", 1286410249)

    internal val getCollisionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_collision_layer", 3905245786)

    internal val setCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "set_collision_mask", 1286410249)

    internal val getCollisionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_collision_mask", 3905245786)

    internal val setCollisionMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "set_collision_mask_value", 300928843)

    internal val getCollisionMaskValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_collision_mask_value", 1116898809)

    internal val setCollisionLayerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "set_collision_layer_value", 300928843)

    internal val getCollisionLayerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_collision_layer_value", 1116898809)

    internal val setCollisionPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "set_collision_priority", 373806689)

    internal val getCollisionPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_collision_priority", 1740695150)

    internal val setCollisionVisibilityModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "set_collision_visibility_mode", 4160694578)

    internal val getCollisionVisibilityModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_collision_visibility_mode", 3729798365)

    internal val setPhysicsMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "set_physics_material", 1784508650)

    internal val getPhysicsMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_physics_material", 2521850424)

    internal val setBakeNavigationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "set_bake_navigation", 2586408642)

    internal val isBakingNavigationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "is_baking_navigation", 2240911060)

    internal val setNavigationMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "set_navigation_map", 2722037293)

    internal val getNavigationMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_navigation_map", 2944877500)

    internal val setMeshLibraryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "set_mesh_library", 1488083439)

    internal val getMeshLibraryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_mesh_library", 3350993772)

    internal val setCellSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "set_cell_size", 3460891852)

    internal val getCellSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_cell_size", 3360562783)

    internal val setCellScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "set_cell_scale", 373806689)

    internal val getCellScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_cell_scale", 1740695150)

    internal val setOctantSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "set_octant_size", 1286410249)

    internal val getOctantSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_octant_size", 3905245786)

    internal val setCellItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "set_cell_item", 3449088946)

    internal val getCellItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_cell_item", 3724960147)

    internal val getCellItemOrientationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_cell_item_orientation", 3724960147)

    internal val getCellItemBasisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_cell_item_basis", 3493604918)

    internal val getBasisWithOrthogonalIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_basis_with_orthogonal_index", 2816196998)

    internal val getOrthogonalIndexFromBasisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_orthogonal_index_from_basis", 4210359952)

    internal val localToMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "local_to_map", 1257687843)

    internal val mapToLocalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "map_to_local", 1088329196)

    internal val resourceChangedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "resource_changed", 968641751)

    internal val setCenterXPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "set_center_x", 2586408642)

    internal val getCenterXPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_center_x", 36873697)

    internal val setCenterYPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "set_center_y", 2586408642)

    internal val getCenterYPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_center_y", 36873697)

    internal val setCenterZPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "set_center_z", 2586408642)

    internal val getCenterZPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_center_z", 36873697)

    internal val clearPtr: VoidPtr = TypeManager.getMethodBindPtr("GridMap", "clear", 3218959716)

    internal val getUsedCellsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_used_cells", 3995934104)

    internal val getUsedCellsByItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_used_cells_by_item", 663333327)

    internal val getUsedOctantsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_used_octants", 3995934104)

    internal val getUsedOctantsByItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_used_octants_by_item", 663333327)

    internal val getUsedCellsInOctantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_used_cells_in_octant", 2658725580)

    internal val getUsedCellsInOctantByItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_used_cells_in_octant_by_item", 2384667821)

    internal val getOctantsInBoundsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_octants_in_bounds", 2489849902)

    internal val getUsedOctantsInBoundsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_used_octants_in_bounds", 2489849902)

    internal val getOctantCoordsFromCellCoordsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_octant_coords_from_cell_coords", 2075501597)

    internal val getMeshesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_meshes", 3995934104)

    internal val getBakeMeshesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_bake_meshes", 2915620761)

    internal val getBakeMeshInstancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "get_bake_mesh_instance", 937000113)

    internal val clearBakedMeshesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "clear_baked_meshes", 3218959716)

    internal val makeBakedMeshesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GridMap", "make_baked_meshes", 3609286057)
  }
}
