// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_LONG_STRING
import godot.callMethod_LONG_ret_STRING
import godot.callMethod_STRING_ret_LONG
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_PACKED_INT_32_ARRAY
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_ARRAY
import godot.callPtrMethod_LONG_LONG
import godot.callPtrMethod_LONG_OBJECT
import godot.callPtrMethod_LONG_TRANSFORM3D
import godot.callPtrMethod_LONG_ret_ARRAY
import godot.callPtrMethod_LONG_ret_LONG
import godot.callPtrMethod_LONG_ret_OBJECT_REF
import godot.callPtrMethod_LONG_ret_TRANSFORM3D
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedInt32Array
import godot.core.Transform3D
import godot.core.VariantArray
import kotlin.Any
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * A library of meshes. Contains a list of [Mesh] resources, each with a name and ID. Each item can
 * also include collision and navigation shapes. This resource is used in [GridMap].
 */
@GodotBaseType
public open class MeshLibrary : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(378, scriptPtr)
  }

  /**
   * Creates a new item in the library with the given ID.
   *
   * You can get an unused ID from [getLastUnusedItemId].
   */
  public final fun createItem(id: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.createItemPtr, id.toLong())
  }

  /**
   * Sets the item's name.
   *
   * This name is shown in the editor. It can also be used to look up the item later using
   * [findItemByName].
   */
  public final fun setItemName(id: Int, name: String): Unit {
    TransferContext.callMethod_LONG_STRING(ptr, objectID.id, MethodBindings.setItemNamePtr, id.toLong(), name)
  }

  /**
   * Sets the item's mesh.
   */
  public final fun setItemMesh(id: Int, mesh: Mesh?): Unit {
    TransferContext.callPtrMethod_LONG_OBJECT(ptr, objectID.id, MethodBindings.setItemMeshPtr, id.toLong(), mesh)
  }

  /**
   * Sets the transform to apply to the item's mesh.
   */
  public final fun setItemMeshTransform(id: Int, meshTransform: Transform3D): Unit {
    TransferContext.callPtrMethod_LONG_TRANSFORM3D(ptr, objectID.id, MethodBindings.setItemMeshTransformPtr, id.toLong(), meshTransform)
  }

  /**
   * Sets the item's shadow casting mode to [shadowCastingSetting].
   */
  public final fun setItemMeshCastShadow(id: Int,
      shadowCastingSetting: RenderingServer.ShadowCastingSetting): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setItemMeshCastShadowPtr, id.toLong(), shadowCastingSetting.value)
  }

  /**
   * Sets the item's navigation mesh.
   */
  public final fun setItemNavigationMesh(id: Int, navigationMesh: NavigationMesh?): Unit {
    TransferContext.callPtrMethod_LONG_OBJECT(ptr, objectID.id, MethodBindings.setItemNavigationMeshPtr, id.toLong(), navigationMesh)
  }

  /**
   * Sets the transform to apply to the item's navigation mesh.
   */
  public final fun setItemNavigationMeshTransform(id: Int, navigationMesh: Transform3D): Unit {
    TransferContext.callPtrMethod_LONG_TRANSFORM3D(ptr, objectID.id, MethodBindings.setItemNavigationMeshTransformPtr, id.toLong(), navigationMesh)
  }

  /**
   * Sets the item's navigation layers bitmask.
   */
  public final fun setItemNavigationLayers(id: Int, navigationLayers: Long): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setItemNavigationLayersPtr, id.toLong(), navigationLayers)
  }

  /**
   * Sets an item's collision shapes.
   *
   * The array should consist of [Shape3D] objects, each followed by a [Transform3D] that will be
   * applied to it. For shapes that should not have a transform, use [Transform3D.IDENTITY].
   */
  public final fun setItemShapes(id: Int, shapes: VariantArray<Any?>): Unit {
    TransferContext.callPtrMethod_LONG_ARRAY(ptr, objectID.id, MethodBindings.setItemShapesPtr, id.toLong(), shapes)
  }

  /**
   * Sets a texture to use as the item's preview icon in the editor.
   */
  public final fun setItemPreview(id: Int, texture: Texture2D?): Unit {
    TransferContext.callPtrMethod_LONG_OBJECT(ptr, objectID.id, MethodBindings.setItemPreviewPtr, id.toLong(), texture)
  }

  /**
   * Returns the item's name.
   */
  public final fun getItemName(id: Int): String =
      TransferContext.callMethod_LONG_ret_STRING(ptr, objectID.id, MethodBindings.getItemNamePtr, id.toLong())

  /**
   * Returns the item's mesh.
   */
  public final fun getItemMesh(id: Int): Mesh? =
      (TransferContext.callPtrMethod_LONG_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getItemMeshPtr, id.toLong()) as Mesh?)

  /**
   * Returns the transform applied to the item's mesh.
   */
  public final fun getItemMeshTransform(id: Int): Transform3D =
      TransferContext.callPtrMethod_LONG_ret_TRANSFORM3D(ptr, objectID.id, MethodBindings.getItemMeshTransformPtr, id.toLong())

  /**
   * Returns the item's shadow casting mode.
   */
  public final fun getItemMeshCastShadow(id: Int): RenderingServer.ShadowCastingSetting =
      RenderingServer.ShadowCastingSetting.from(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getItemMeshCastShadowPtr, id.toLong()))

  /**
   * Returns the item's navigation mesh.
   */
  public final fun getItemNavigationMesh(id: Int): NavigationMesh? =
      (TransferContext.callPtrMethod_LONG_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getItemNavigationMeshPtr, id.toLong()) as NavigationMesh?)

  /**
   * Returns the transform applied to the item's navigation mesh.
   */
  public final fun getItemNavigationMeshTransform(id: Int): Transform3D =
      TransferContext.callPtrMethod_LONG_ret_TRANSFORM3D(ptr, objectID.id, MethodBindings.getItemNavigationMeshTransformPtr, id.toLong())

  /**
   * Returns the item's navigation layers bitmask.
   */
  public final fun getItemNavigationLayers(id: Int): Long =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getItemNavigationLayersPtr, id.toLong())

  /**
   * Returns an item's collision shapes.
   *
   * The array consists of each [Shape3D] followed by its [Transform3D].
   */
  public final fun getItemShapes(id: Int): VariantArray<Any?> =
      (TransferContext.callPtrMethod_LONG_ret_ARRAY(ptr, objectID.id, MethodBindings.getItemShapesPtr, id.toLong()) as VariantArray<Any?>)

  /**
   * When running in the editor, returns a generated item preview (a 3D rendering in isometric
   * perspective). When used in a running project, returns the manually-defined item preview which can
   * be set using [setItemPreview]. Returns an empty [Texture2D] if no preview was manually set in a
   * running project.
   */
  public final fun getItemPreview(id: Int): Texture2D? =
      (TransferContext.callPtrMethod_LONG_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getItemPreviewPtr, id.toLong()) as Texture2D?)

  /**
   * Removes the item.
   */
  public final fun removeItem(id: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.removeItemPtr, id.toLong())
  }

  /**
   * Returns the first item with the given name, or `-1` if no item is found.
   */
  public final fun findItemByName(name: String): Int =
      TransferContext.callMethod_STRING_ret_LONG(ptr, objectID.id, MethodBindings.findItemByNamePtr, name).toInt()

  /**
   * Clears the library.
   */
  public final fun clear(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearPtr)
  }

  /**
   * Returns the list of item IDs in use.
   */
  public final fun getItemList(): PackedInt32Array =
      TransferContext.callPtrMethod0_ret_PACKED_INT_32_ARRAY(ptr, objectID.id, MethodBindings.getItemListPtr)

  /**
   * Returns the number of items present in the library.
   */
  public final fun getItemCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getItemCountPtr).toInt()

  /**
   * Gets an unused ID for a new item.
   */
  public final fun getLastUnusedItemId(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getLastUnusedItemIdPtr).toInt()

  public companion object {
    @JvmField
    public val createItemName: MethodStringName1<MeshLibrary, Unit, Int> =
        MethodStringName1<MeshLibrary, Unit, Int>("create_item")

    @JvmField
    public val setItemNameName: MethodStringName2<MeshLibrary, Unit, Int, String> =
        MethodStringName2<MeshLibrary, Unit, Int, String>("set_item_name")

    @JvmField
    public val setItemMeshName: MethodStringName2<MeshLibrary, Unit, Int, Mesh?> =
        MethodStringName2<MeshLibrary, Unit, Int, Mesh?>("set_item_mesh")

    @JvmField
    public val setItemMeshTransformName: MethodStringName2<MeshLibrary, Unit, Int, Transform3D> =
        MethodStringName2<MeshLibrary, Unit, Int, Transform3D>("set_item_mesh_transform")

    @JvmField
    public val setItemMeshCastShadowName:
        MethodStringName2<MeshLibrary, Unit, Int, RenderingServer.ShadowCastingSetting> =
        MethodStringName2<MeshLibrary, Unit, Int, RenderingServer.ShadowCastingSetting>("set_item_mesh_cast_shadow")

    @JvmField
    public val setItemNavigationMeshName: MethodStringName2<MeshLibrary, Unit, Int, NavigationMesh?>
        = MethodStringName2<MeshLibrary, Unit, Int, NavigationMesh?>("set_item_navigation_mesh")

    @JvmField
    public val setItemNavigationMeshTransformName:
        MethodStringName2<MeshLibrary, Unit, Int, Transform3D> =
        MethodStringName2<MeshLibrary, Unit, Int, Transform3D>("set_item_navigation_mesh_transform")

    @JvmField
    public val setItemNavigationLayersName: MethodStringName2<MeshLibrary, Unit, Int, Long> =
        MethodStringName2<MeshLibrary, Unit, Int, Long>("set_item_navigation_layers")

    @JvmField
    public val setItemShapesName: MethodStringName2<MeshLibrary, Unit, Int, VariantArray<Any?>> =
        MethodStringName2<MeshLibrary, Unit, Int, VariantArray<Any?>>("set_item_shapes")

    @JvmField
    public val setItemPreviewName: MethodStringName2<MeshLibrary, Unit, Int, Texture2D?> =
        MethodStringName2<MeshLibrary, Unit, Int, Texture2D?>("set_item_preview")

    @JvmField
    public val getItemNameName: MethodStringName1<MeshLibrary, String, Int> =
        MethodStringName1<MeshLibrary, String, Int>("get_item_name")

    @JvmField
    public val getItemMeshName: MethodStringName1<MeshLibrary, Mesh?, Int> =
        MethodStringName1<MeshLibrary, Mesh?, Int>("get_item_mesh")

    @JvmField
    public val getItemMeshTransformName: MethodStringName1<MeshLibrary, Transform3D, Int> =
        MethodStringName1<MeshLibrary, Transform3D, Int>("get_item_mesh_transform")

    @JvmField
    public val getItemMeshCastShadowName:
        MethodStringName1<MeshLibrary, RenderingServer.ShadowCastingSetting, Int> =
        MethodStringName1<MeshLibrary, RenderingServer.ShadowCastingSetting, Int>("get_item_mesh_cast_shadow")

    @JvmField
    public val getItemNavigationMeshName: MethodStringName1<MeshLibrary, NavigationMesh?, Int> =
        MethodStringName1<MeshLibrary, NavigationMesh?, Int>("get_item_navigation_mesh")

    @JvmField
    public val getItemNavigationMeshTransformName: MethodStringName1<MeshLibrary, Transform3D, Int>
        = MethodStringName1<MeshLibrary, Transform3D, Int>("get_item_navigation_mesh_transform")

    @JvmField
    public val getItemNavigationLayersName: MethodStringName1<MeshLibrary, Long, Int> =
        MethodStringName1<MeshLibrary, Long, Int>("get_item_navigation_layers")

    @JvmField
    public val getItemShapesName: MethodStringName1<MeshLibrary, VariantArray<Any?>, Int> =
        MethodStringName1<MeshLibrary, VariantArray<Any?>, Int>("get_item_shapes")

    @JvmField
    public val getItemPreviewName: MethodStringName1<MeshLibrary, Texture2D?, Int> =
        MethodStringName1<MeshLibrary, Texture2D?, Int>("get_item_preview")

    @JvmField
    public val removeItemName: MethodStringName1<MeshLibrary, Unit, Int> =
        MethodStringName1<MeshLibrary, Unit, Int>("remove_item")

    @JvmField
    public val findItemByNameName: MethodStringName1<MeshLibrary, Int, String> =
        MethodStringName1<MeshLibrary, Int, String>("find_item_by_name")

    @JvmField
    public val clearName: MethodStringName0<MeshLibrary, Unit> =
        MethodStringName0<MeshLibrary, Unit>("clear")

    @JvmField
    public val getItemListName: MethodStringName0<MeshLibrary, PackedInt32Array> =
        MethodStringName0<MeshLibrary, PackedInt32Array>("get_item_list")

    @JvmField
    public val getItemCountName: MethodStringName0<MeshLibrary, Int> =
        MethodStringName0<MeshLibrary, Int>("get_item_count")

    @JvmField
    public val getLastUnusedItemIdName: MethodStringName0<MeshLibrary, Int> =
        MethodStringName0<MeshLibrary, Int>("get_last_unused_item_id")
  }

  public object MethodBindings {
    internal val createItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "create_item", 1286410249)

    internal val setItemNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "set_item_name", 501894301)

    internal val setItemMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "set_item_mesh", 969122797)

    internal val setItemMeshTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "set_item_mesh_transform", 3616898986)

    internal val setItemMeshCastShadowPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "set_item_mesh_cast_shadow", 3923400443)

    internal val setItemNavigationMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "set_item_navigation_mesh", 3483353960)

    internal val setItemNavigationMeshTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "set_item_navigation_mesh_transform", 3616898986)

    internal val setItemNavigationLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "set_item_navigation_layers", 3937882851)

    internal val setItemShapesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "set_item_shapes", 537221740)

    internal val setItemPreviewPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "set_item_preview", 666127730)

    internal val getItemNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "get_item_name", 844755477)

    internal val getItemMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "get_item_mesh", 1576363275)

    internal val getItemMeshTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "get_item_mesh_transform", 1965739696)

    internal val getItemMeshCastShadowPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "get_item_mesh_cast_shadow", 1841766007)

    internal val getItemNavigationMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "get_item_navigation_mesh", 2729647406)

    internal val getItemNavigationMeshTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "get_item_navigation_mesh_transform", 1965739696)

    internal val getItemNavigationLayersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "get_item_navigation_layers", 923996154)

    internal val getItemShapesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "get_item_shapes", 663333327)

    internal val getItemPreviewPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "get_item_preview", 3536238170)

    internal val removeItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "remove_item", 1286410249)

    internal val findItemByNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "find_item_by_name", 1321353865)

    internal val clearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "clear", 3218959716)

    internal val getItemListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "get_item_list", 1930428628)

    internal val getItemCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "get_item_count", 3905245786)

    internal val getLastUnusedItemIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshLibrary", "get_last_unused_item_id", 3905245786)
  }
}
