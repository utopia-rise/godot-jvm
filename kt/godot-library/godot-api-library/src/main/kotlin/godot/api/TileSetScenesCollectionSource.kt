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
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_OBJECT
import godot.writeMethodArguments_OBJECT_LONG
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * When placed on a [TileMapLayer], tiles from [TileSetScenesCollectionSource] will automatically
 * instantiate an associated scene at the cell's position in the TileMapLayer.
 *
 * Scenes are instantiated as children of the [TileMapLayer] after it enters the tree, at the end of
 * the frame (their creation is deferred). If you add/remove a scene tile in the [TileMapLayer] that is
 * already inside the tree, the [TileMapLayer] will automatically instantiate/free the scene
 * accordingly.
 *
 * **Note:** Scene tiles all occupy one tile slot and instead use alternate tile ID to identify
 * scene index. [TileSetSource.getTilesCount] will always return `1`. Use [getSceneTilesCount] to get a
 * number of scenes in a [TileSetScenesCollectionSource].
 *
 * Use this code if you want to find the scene path at a given tile in [TileMapLayer]:
 *
 * ```gdscript
 * //gdscript
 * var source_id = tile_map_layer.get_cell_source_id(Vector2i(x, y))
 * if source_id > -1:
 * 	var scene_source = tile_map_layer.tile_set.get_source(source_id)
 * 	if scene_source is TileSetScenesCollectionSource:
 * 		var alt_id = tile_map_layer.get_cell_alternative_tile(Vector2i(x, y))
 * 		# The assigned PackedScene.
 * 		var scene = scene_source.get_scene_tile_scene(alt_id)
 * ```
 *
 * ```csharp
 * //csharp
 * int sourceId = tileMapLayer.GetCellSourceId(new Vector2I(x, y));
 * if (sourceId > -1)
 * {
 * 	TileSetSource source = tileMapLayer.TileSet.GetSource(sourceId);
 * 	if (source is TileSetScenesCollectionSource sceneSource)
 * 	{
 * 		int altId = tileMapLayer.GetCellAlternativeTile(new Vector2I(x, y));
 * 		// The assigned PackedScene.
 * 		PackedScene scene = sceneSource.GetSceneTileScene(altId);
 * 	}
 * }
 * ```
 */
@GodotBaseType
public open class TileSetScenesCollectionSource : TileSetSource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(762, scriptPtr)
  }

  /**
   * Returns the number or scene tiles this TileSet source has.
   */
  public final fun getSceneTilesCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSceneTilesCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the scene tile ID of the scene tile at [index].
   */
  public final fun getSceneTileId(index: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getSceneTileIdPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns whether this TileSet source has a scene tile with [id].
   */
  public final fun hasSceneTileId(id: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, id.toLong())
    TransferContext.callMethod(MethodBindings.hasSceneTileIdPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Creates a scene-based tile out of the given scene.
   *
   * Returns a newly generated unique ID.
   */
  @JvmOverloads
  public final fun createSceneTile(packedScene: PackedScene?, idOverride: Int = -1): Int {
    TransferContext.writeMethodArguments_OBJECT_LONG(ptr, objectID.id, packedScene, idOverride.toLong())
    TransferContext.callMethod(MethodBindings.createSceneTilePtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Changes a scene tile's ID from [id] to [newId]. This will fail if there is already a tile with
   * an ID equal to [newId].
   */
  public final fun setSceneTileId(id: Int, newId: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, id.toLong(), newId.toLong())
    TransferContext.callMethod(MethodBindings.setSceneTileIdPtr)
  }

  /**
   * Assigns a [PackedScene] resource to the scene tile with [id]. This will fail if the scene does
   * not extend [CanvasItem], as positioning properties are needed to place the scene on the
   * [TileMapLayer].
   */
  public final fun setSceneTileScene(id: Int, packedScene: PackedScene?): Unit {
    TransferContext.writeMethodArguments_LONG_OBJECT(ptr, objectID.id, id.toLong(), packedScene)
    TransferContext.callMethod(MethodBindings.setSceneTileScenePtr)
  }

  /**
   * Returns the [PackedScene] resource of scene tile with [id].
   */
  public final fun getSceneTileScene(id: Int): PackedScene? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, id.toLong())
    TransferContext.callMethod(MethodBindings.getSceneTileScenePtr)
    return (TransferContext.readReturnValue_OBJECT() as PackedScene?)
  }

  /**
   * Sets whether or not the scene tile with [id] should display a placeholder in the editor. This
   * might be useful for scenes that are not visible.
   */
  public final fun setSceneTileDisplayPlaceholder(id: Int, displayPlaceholder: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, id.toLong(), displayPlaceholder)
    TransferContext.callMethod(MethodBindings.setSceneTileDisplayPlaceholderPtr)
  }

  /**
   * Returns whether the scene tile with [id] displays a placeholder in the editor.
   */
  public final fun getSceneTileDisplayPlaceholder(id: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, id.toLong())
    TransferContext.callMethod(MethodBindings.getSceneTileDisplayPlaceholderPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Remove the scene tile with [id].
   */
  public final fun removeSceneTile(id: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, id.toLong())
    TransferContext.callMethod(MethodBindings.removeSceneTilePtr)
  }

  /**
   * Returns the scene ID a following call to [createSceneTile] would return.
   */
  public final fun getNextSceneTileId(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNextSceneTileIdPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public companion object {
    @JvmField
    public val getSceneTilesCountName: MethodStringName0<TileSetScenesCollectionSource, Int> =
        MethodStringName0<TileSetScenesCollectionSource, Int>("get_scene_tiles_count")

    @JvmField
    public val getSceneTileIdName: MethodStringName1<TileSetScenesCollectionSource, Int, Int> =
        MethodStringName1<TileSetScenesCollectionSource, Int, Int>("get_scene_tile_id")

    @JvmField
    public val hasSceneTileIdName: MethodStringName1<TileSetScenesCollectionSource, Boolean, Int> =
        MethodStringName1<TileSetScenesCollectionSource, Boolean, Int>("has_scene_tile_id")

    @JvmField
    public val createSceneTileName:
        MethodStringName2<TileSetScenesCollectionSource, Int, PackedScene?, Int> =
        MethodStringName2<TileSetScenesCollectionSource, Int, PackedScene?, Int>("create_scene_tile")

    @JvmField
    public val setSceneTileIdName: MethodStringName2<TileSetScenesCollectionSource, Unit, Int, Int>
        = MethodStringName2<TileSetScenesCollectionSource, Unit, Int, Int>("set_scene_tile_id")

    @JvmField
    public val setSceneTileSceneName:
        MethodStringName2<TileSetScenesCollectionSource, Unit, Int, PackedScene?> =
        MethodStringName2<TileSetScenesCollectionSource, Unit, Int, PackedScene?>("set_scene_tile_scene")

    @JvmField
    public val getSceneTileSceneName:
        MethodStringName1<TileSetScenesCollectionSource, PackedScene?, Int> =
        MethodStringName1<TileSetScenesCollectionSource, PackedScene?, Int>("get_scene_tile_scene")

    @JvmField
    public val setSceneTileDisplayPlaceholderName:
        MethodStringName2<TileSetScenesCollectionSource, Unit, Int, Boolean> =
        MethodStringName2<TileSetScenesCollectionSource, Unit, Int, Boolean>("set_scene_tile_display_placeholder")

    @JvmField
    public val getSceneTileDisplayPlaceholderName:
        MethodStringName1<TileSetScenesCollectionSource, Boolean, Int> =
        MethodStringName1<TileSetScenesCollectionSource, Boolean, Int>("get_scene_tile_display_placeholder")

    @JvmField
    public val removeSceneTileName: MethodStringName1<TileSetScenesCollectionSource, Unit, Int> =
        MethodStringName1<TileSetScenesCollectionSource, Unit, Int>("remove_scene_tile")

    @JvmField
    public val getNextSceneTileIdName: MethodStringName0<TileSetScenesCollectionSource, Int> =
        MethodStringName0<TileSetScenesCollectionSource, Int>("get_next_scene_tile_id")
  }

  public object MethodBindings {
    internal val getSceneTilesCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetScenesCollectionSource", "get_scene_tiles_count", 2455072627)

    internal val getSceneTileIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetScenesCollectionSource", "get_scene_tile_id", 3744713108)

    internal val hasSceneTileIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetScenesCollectionSource", "has_scene_tile_id", 3067735520)

    internal val createSceneTilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetScenesCollectionSource", "create_scene_tile", 1117465415)

    internal val setSceneTileIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetScenesCollectionSource", "set_scene_tile_id", 3937882851)

    internal val setSceneTileScenePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetScenesCollectionSource", "set_scene_tile_scene", 3435852839)

    internal val getSceneTileScenePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetScenesCollectionSource", "get_scene_tile_scene", 511017218)

    internal val setSceneTileDisplayPlaceholderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetScenesCollectionSource", "set_scene_tile_display_placeholder", 300928843)

    internal val getSceneTileDisplayPlaceholderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetScenesCollectionSource", "get_scene_tile_display_placeholder", 1116898809)

    internal val removeSceneTilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetScenesCollectionSource", "remove_scene_tile", 1286410249)

    internal val getNextSceneTileIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TileSetScenesCollectionSource", "get_next_scene_tile_id", 3905245786)
  }
}
