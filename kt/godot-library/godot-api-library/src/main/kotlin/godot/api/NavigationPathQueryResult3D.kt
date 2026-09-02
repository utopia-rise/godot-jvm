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
import godot.core.PackedInt32Array
import godot.core.PackedInt64Array
import godot.core.PackedVector3Array
import godot.core.RID
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.PACKED_INT_64_ARRAY
import godot.core.VariantParser.PACKED_VECTOR3_ARRAY
import godot.core.Vector3
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This class stores the result of a 3D navigation path query from the [NavigationServer3D].
 */
@GodotBaseType
public open class NavigationPathQueryResult3D : RefCounted() {
  /**
   * The resulting path array from the navigation query. All path array positions are in global
   * coordinates. Without customized query parameters this is the same path as returned by
   * [NavigationServer3D.mapGetPath].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var path: PackedVector3Array
    @JvmName("pathProperty")
    get() = getPath()
    @JvmName("pathProperty")
    set(`value`) {
      setPath(value)
    }

  /**
   * The type of navigation primitive (region or link) that each point of the path goes through.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var pathTypes: PackedInt32Array
    @JvmName("pathTypesProperty")
    get() = getPathTypes()
    @JvmName("pathTypesProperty")
    set(`value`) {
      setPathTypes(value)
    }

  /**
   * The [RID]s of the regions and links that each point of the path goes through.
   */
  public final inline var pathRids: VariantArray<RID>
    @JvmName("pathRidsProperty")
    get() = getPathRids()
    @JvmName("pathRidsProperty")
    set(`value`) {
      setPathRids(value)
    }

  /**
   * The `ObjectID`s of the [Object]s which manage the regions and links each point of the path goes
   * through.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var pathOwnerIds: PackedInt64Array
    @JvmName("pathOwnerIdsProperty")
    get() = getPathOwnerIds()
    @JvmName("pathOwnerIdsProperty")
    set(`value`) {
      setPathOwnerIds(value)
    }

  /**
   * Returns the length of the path.
   */
  public final inline var pathLength: Float
    @JvmName("pathLengthProperty")
    get() = getPathLength()
    @JvmName("pathLengthProperty")
    set(`value`) {
      setPathLength(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(412, scriptPtr)
  }

  /**
   * This is a helper function for [path] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = navigationpathqueryresult3d.path
   * //Your changes
   * navigationpathqueryresult3d.path = myCoreType
   * ``````
   *
   * The resulting path array from the navigation query. All path array positions are in global
   * coordinates. Without customized query parameters this is the same path as returned by
   * [NavigationServer3D.mapGetPath].
   */
  @CoreTypeHelper
  public final fun pathMutate(block: PackedVector3Array.() -> Unit): PackedVector3Array =
      path.apply {
     block(this)
     path = this
  }

  /**
   * This is a helper function for [path] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The resulting path array from the navigation query. All path array positions are in global
   * coordinates. Without customized query parameters this is the same path as returned by
   * [NavigationServer3D.mapGetPath].
   */
  @CoreTypeHelper
  public final fun pathMutateEach(block: (index: Int, `value`: Vector3) -> Unit): PackedVector3Array
      = path.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     path = this
  }

  /**
   * This is a helper function for [pathTypes] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = navigationpathqueryresult3d.pathTypes
   * //Your changes
   * navigationpathqueryresult3d.pathTypes = myCoreType
   * ``````
   *
   * The type of navigation primitive (region or link) that each point of the path goes through.
   */
  @CoreTypeHelper
  public final fun pathTypesMutate(block: PackedInt32Array.() -> Unit): PackedInt32Array =
      pathTypes.apply {
     block(this)
     pathTypes = this
  }

  /**
   * This is a helper function for [pathTypes] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The type of navigation primitive (region or link) that each point of the path goes through.
   */
  @CoreTypeHelper
  public final fun pathTypesMutateEach(block: (index: Int, `value`: Int) -> Unit): PackedInt32Array
      = pathTypes.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     pathTypes = this
  }

  /**
   * This is a helper function for [pathOwnerIds] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = navigationpathqueryresult3d.pathOwnerIds
   * //Your changes
   * navigationpathqueryresult3d.pathOwnerIds = myCoreType
   * ``````
   *
   * The `ObjectID`s of the [Object]s which manage the regions and links each point of the path goes
   * through.
   */
  @CoreTypeHelper
  public final fun pathOwnerIdsMutate(block: PackedInt64Array.() -> Unit): PackedInt64Array =
      pathOwnerIds.apply {
     block(this)
     pathOwnerIds = this
  }

  /**
   * This is a helper function for [pathOwnerIds] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The `ObjectID`s of the [Object]s which manage the regions and links each point of the path goes
   * through.
   */
  @CoreTypeHelper
  public final fun pathOwnerIdsMutateEach(block: (index: Int, `value`: Long) -> Unit):
      PackedInt64Array = pathOwnerIds.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     pathOwnerIds = this
  }

  public final fun setPath(path: PackedVector3Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR3_ARRAY to path)
    TransferContext.callMethod(MethodBindings.setPathPtr)
  }

  public final fun getPath(): PackedVector3Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPathPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR3_ARRAY) as PackedVector3Array)
  }

  public final fun setPathTypes(pathTypes: PackedInt32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_INT_32_ARRAY to pathTypes)
    TransferContext.callMethod(MethodBindings.setPathTypesPtr)
  }

  public final fun getPathTypes(): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPathTypesPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  public final fun setPathRids(pathRids: VariantArray<RID>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to pathRids)
    TransferContext.callMethod(MethodBindings.setPathRidsPtr)
  }

  public final fun getPathRids(): VariantArray<RID> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPathRidsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<RID>)
  }

  public final fun setPathOwnerIds(pathOwnerIds: PackedInt64Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_INT_64_ARRAY to pathOwnerIds)
    TransferContext.callMethod(MethodBindings.setPathOwnerIdsPtr)
  }

  public final fun getPathOwnerIds(): PackedInt64Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPathOwnerIdsPtr)
    return (TransferContext.readReturnValue(PACKED_INT_64_ARRAY) as PackedInt64Array)
  }

  public final fun setPathLength(length: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to length.toDouble())
    TransferContext.callMethod(MethodBindings.setPathLengthPtr)
  }

  public final fun getPathLength(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPathLengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Reset the result object to its initial state. This is useful to reuse the object across
   * multiple queries.
   */
  public final fun reset(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.resetPtr)
  }

  public enum class PathSegmentType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * This segment of the path goes through a region.
     */
    REGION(0),
    /**
     * This segment of the path goes through a link.
     */
    LINK(1),
    ;

    public companion object {
      public fun from(`value`: Long): PathSegmentType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setPathName: MethodStringName1<NavigationPathQueryResult3D, Unit, PackedVector3Array>
        = MethodStringName1<NavigationPathQueryResult3D, Unit, PackedVector3Array>("set_path")

    @JvmField
    public val getPathName: MethodStringName0<NavigationPathQueryResult3D, PackedVector3Array> =
        MethodStringName0<NavigationPathQueryResult3D, PackedVector3Array>("get_path")

    @JvmField
    public val setPathTypesName:
        MethodStringName1<NavigationPathQueryResult3D, Unit, PackedInt32Array> =
        MethodStringName1<NavigationPathQueryResult3D, Unit, PackedInt32Array>("set_path_types")

    @JvmField
    public val getPathTypesName: MethodStringName0<NavigationPathQueryResult3D, PackedInt32Array> =
        MethodStringName0<NavigationPathQueryResult3D, PackedInt32Array>("get_path_types")

    @JvmField
    public val setPathRidsName:
        MethodStringName1<NavigationPathQueryResult3D, Unit, VariantArray<RID>> =
        MethodStringName1<NavigationPathQueryResult3D, Unit, VariantArray<RID>>("set_path_rids")

    @JvmField
    public val getPathRidsName: MethodStringName0<NavigationPathQueryResult3D, VariantArray<RID>> =
        MethodStringName0<NavigationPathQueryResult3D, VariantArray<RID>>("get_path_rids")

    @JvmField
    public val setPathOwnerIdsName:
        MethodStringName1<NavigationPathQueryResult3D, Unit, PackedInt64Array> =
        MethodStringName1<NavigationPathQueryResult3D, Unit, PackedInt64Array>("set_path_owner_ids")

    @JvmField
    public val getPathOwnerIdsName: MethodStringName0<NavigationPathQueryResult3D, PackedInt64Array>
        = MethodStringName0<NavigationPathQueryResult3D, PackedInt64Array>("get_path_owner_ids")

    @JvmField
    public val setPathLengthName: MethodStringName1<NavigationPathQueryResult3D, Unit, Float> =
        MethodStringName1<NavigationPathQueryResult3D, Unit, Float>("set_path_length")

    @JvmField
    public val getPathLengthName: MethodStringName0<NavigationPathQueryResult3D, Float> =
        MethodStringName0<NavigationPathQueryResult3D, Float>("get_path_length")

    @JvmField
    public val resetName: MethodStringName0<NavigationPathQueryResult3D, Unit> =
        MethodStringName0<NavigationPathQueryResult3D, Unit>("reset")
  }

  public object MethodBindings {
    internal val setPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryResult3D", "set_path", 334873810)

    internal val getPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryResult3D", "get_path", 497664490)

    internal val setPathTypesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryResult3D", "set_path_types", 3614634198)

    internal val getPathTypesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryResult3D", "get_path_types", 1930428628)

    internal val setPathRidsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryResult3D", "set_path_rids", 381264803)

    internal val getPathRidsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryResult3D", "get_path_rids", 3995934104)

    internal val setPathOwnerIdsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryResult3D", "set_path_owner_ids", 3709968205)

    internal val getPathOwnerIdsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryResult3D", "get_path_owner_ids", 235988956)

    internal val setPathLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryResult3D", "set_path_length", 373806689)

    internal val getPathLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryResult3D", "get_path_length", 1740695150)

    internal val resetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NavigationPathQueryResult3D", "reset", 3218959716)
  }
}
