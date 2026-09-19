// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_STRING
import godot.callMethod_OBJECT_STRING_ret_LONG
import godot.callMethod_OBJECT_STRING_ret_OBJECT_REF
import godot.callMethod_PACKED_BYTE_ARRAY_STRING_OBJECT_LONG_ret_LONG
import godot.callMethod_STRING
import godot.callMethod_STRING_OBJECT_LONG_STRING_ret_LONG
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_PACKED_STRING_ARRAY
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_OBJECT
import godot.callPtrMethod_OBJECT_BOOL
import godot.callPtrMethod_OBJECT_DOUBLE_BOOL_BOOL_ret_OBJECT
import godot.callPtrMethod_OBJECT_NODE_PATH_OBJECT_LONG_ret_OBJECT_REF
import godot.callPtrMethod_OBJECT_OBJECT_LONG_ret_LONG
import godot.callPtrMethod_OBJECT_ret_PACKED_BYTE_ARRAY
import godot.common.interop.VoidPtr
import godot.core.BitFieldBase
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.NodePath
import godot.core.PackedByteArray
import godot.core.PackedStringArray
import godot.core.asCachedNodePath
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

public infix fun Long.or(other: GLTFDocument.ImportFlags): Long = this.or(other.flag)

public infix fun Long.xor(other: GLTFDocument.ImportFlags): Long = this.xor(other.flag)

public infix fun Long.and(other: GLTFDocument.ImportFlags): Long = this.and(other.flag)

/**
 * GLTFDocument supports reading data from a glTF file, buffer, or Godot scene. This data can then
 * be written to the filesystem, buffer, or used to create a Godot scene.
 *
 * All of the data in a glTF scene is stored in the [GLTFState] class. GLTFDocument processes state
 * objects, but does not contain any scene data itself. GLTFDocument has member variables to store
 * export configuration settings such as the image format, but is otherwise stateless. Multiple scenes
 * can be processed with the same settings using the same GLTFDocument object and different [GLTFState]
 * objects.
 *
 * GLTFDocument can be extended with arbitrary functionality by extending the
 * [GLTFDocumentExtension] class and registering it with GLTFDocument via
 * [registerGltfDocumentExtension]. This allows for custom data to be imported and exported.
 */
@GodotBaseType
public open class GLTFDocument : Resource() {
  /**
   * The user-friendly name of the export image format. This is used when exporting the glTF file,
   * including writing to a file and writing to a byte array.
   *
   * By default, Godot allows the following options: "None", "PNG", "JPEG", "Lossless WebP", and
   * "Lossy WebP". Support for more image formats can be added in [GLTFDocumentExtension] classes. A
   * single extension class can provide multiple options for the specific format to use, or even an
   * option that uses multiple formats at once.
   */
  public final inline var imageFormat: String
    @JvmName("imageFormatProperty")
    get() = getImageFormat()
    @JvmName("imageFormatProperty")
    set(`value`) {
      setImageFormat(value)
    }

  /**
   * If [imageFormat] is a lossy image format, this determines the lossy quality of the image. On a
   * range of `0.0` to `1.0`, where `0.0` is the lowest quality and `1.0` is the highest quality. A
   * lossy quality of `1.0` is not the same as lossless.
   */
  public final inline var lossyQuality: Float
    @JvmName("lossyQualityProperty")
    get() = getLossyQuality()
    @JvmName("lossyQualityProperty")
    set(`value`) {
      setLossyQuality(value)
    }

  /**
   * The user-friendly name of the fallback image format. This is used when exporting the glTF file,
   * including writing to a file and writing to a byte array.
   *
   * This property may only be one of "None", "PNG", or "JPEG", and is only used when the
   * [imageFormat] is not one of "None", "PNG", or "JPEG". If having multiple extension image formats
   * is desired, that can be done using a [GLTFDocumentExtension] class - this property only covers the
   * use case of providing a base glTF fallback image when using a custom image format.
   */
  public final inline var fallbackImageFormat: String
    @JvmName("fallbackImageFormatProperty")
    get() = getFallbackImageFormat()
    @JvmName("fallbackImageFormatProperty")
    set(`value`) {
      setFallbackImageFormat(value)
    }

  /**
   * The quality of the fallback image, if any. For PNG files, this downscales the image on both
   * dimensions by this factor. For JPEG files, this is the lossy quality of the image. A low value is
   * recommended, since including multiple high quality images in a glTF file defeats the file size
   * gains of using a more efficient image format.
   */
  public final inline var fallbackImageQuality: Float
    @JvmName("fallbackImageQualityProperty")
    get() = getFallbackImageQuality()
    @JvmName("fallbackImageQualityProperty")
    set(`value`) {
      setFallbackImageQuality(value)
    }

  /**
   * How to process the root node during export. The default and recommended value is
   * [ROOT_NODE_MODE_SINGLE_ROOT].
   *
   * **Note:** Regardless of how the glTF file is exported, when importing, the root node type and
   * name can be overridden in the scene import settings tab.
   */
  public final inline var rootNodeMode: RootNodeMode
    @JvmName("rootNodeModeProperty")
    get() = getRootNodeMode()
    @JvmName("rootNodeModeProperty")
    set(`value`) {
      setRootNodeMode(value)
    }

  /**
   * How to handle texture maps during import. The default and recommended value is
   * [TEXTURE_MAP_MODE_REMAP_TO_STANDARD_MATERIAL], which automatically remaps from glTF's flexible
   * texture map system to the more specific texture map slots in Godot's [StandardMaterial3D] class.
   * Alternatively, [TEXTURE_MAP_MODE_DO_NOT_REMAP] can be used to preserve the original texture maps
   * from the glTF file, which may be desirable if using the glTF file with custom shaders, but may not
   * display correctly with Godot's built-in materials.
   */
  public final inline var textureMapMode: TextureMapMode
    @JvmName("textureMapModeProperty")
    get() = getTextureMapMode()
    @JvmName("textureMapModeProperty")
    set(`value`) {
      setTextureMapMode(value)
    }

  /**
   * How to deal with node visibility during export. This setting does nothing if all nodes are
   * visible. The default and recommended value is [VISIBILITY_MODE_INCLUDE_REQUIRED], which uses the
   * `KHR_node_visibility` extension.
   */
  public final inline var visibilityMode: VisibilityMode
    @JvmName("visibilityModeProperty")
    get() = getVisibilityMode()
    @JvmName("visibilityModeProperty")
    set(`value`) {
      setVisibilityMode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(242, scriptPtr)
  }

  public final fun setImageFormat(imageFormat: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setImageFormatPtr, imageFormat)
  }

  public final fun getImageFormat(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getImageFormatPtr)

  public final fun setLossyQuality(lossyQuality: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setLossyQualityPtr, lossyQuality.toDouble())
  }

  public final fun getLossyQuality(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getLossyQualityPtr).toFloat()

  public final fun setFallbackImageFormat(fallbackImageFormat: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setFallbackImageFormatPtr, fallbackImageFormat)
  }

  public final fun getFallbackImageFormat(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getFallbackImageFormatPtr)

  public final fun setFallbackImageQuality(fallbackImageQuality: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setFallbackImageQualityPtr, fallbackImageQuality.toDouble())
  }

  public final fun getFallbackImageQuality(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getFallbackImageQualityPtr).toFloat()

  public final fun setRootNodeMode(rootNodeMode: RootNodeMode): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setRootNodeModePtr, rootNodeMode.value)
  }

  public final fun getRootNodeMode(): RootNodeMode =
      RootNodeMode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getRootNodeModePtr))

  public final fun setTextureMapMode(textureMapMode: TextureMapMode): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setTextureMapModePtr, textureMapMode.value)
  }

  public final fun getTextureMapMode(): TextureMapMode =
      TextureMapMode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getTextureMapModePtr))

  public final fun setVisibilityMode(visibilityMode: VisibilityMode): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setVisibilityModePtr, visibilityMode.value)
  }

  public final fun getVisibilityMode(): VisibilityMode =
      VisibilityMode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getVisibilityModePtr))

  /**
   * Takes a path to a glTF file and imports the data at that file path to the given [GLTFState]
   * object through the [state] parameter.
   *
   * **Note:** The [basePath] tells [appendFromFile] where to find dependencies and can be empty.
   */
  @JvmOverloads
  public final fun appendFromFile(
    path: String,
    state: GLTFState?,
    flags: Long = 0,
    basePath: String = "",
  ): Error =
      Error.from(TransferContext.callMethod_STRING_OBJECT_LONG_STRING_ret_LONG(ptr, objectID.id, MethodBindings.appendFromFilePtr, path, state, flags, basePath))

  /**
   * Takes a [PackedByteArray] defining a glTF and imports the data to the given [GLTFState] object
   * through the [state] parameter.
   *
   * **Note:** The [basePath] tells [appendFromBuffer] where to find dependencies and can be empty.
   */
  @JvmOverloads
  public final fun appendFromBuffer(
    bytes: PackedByteArray,
    basePath: String,
    state: GLTFState?,
    flags: Long = 0,
  ): Error =
      Error.from(TransferContext.callMethod_PACKED_BYTE_ARRAY_STRING_OBJECT_LONG_ret_LONG(ptr, objectID.id, MethodBindings.appendFromBufferPtr, bytes, basePath, state, flags))

  /**
   * Takes a Godot Engine scene node and exports it and its descendants to the given [GLTFState]
   * object through the [state] parameter.
   */
  @JvmOverloads
  public final fun appendFromScene(
    node: Node?,
    state: GLTFState?,
    flags: Long = 0,
  ): Error =
      Error.from(TransferContext.callPtrMethod_OBJECT_OBJECT_LONG_ret_LONG(ptr, objectID.id, MethodBindings.appendFromScenePtr, node, state, flags))

  /**
   * Takes a [GLTFState] object through the [state] parameter and returns a Godot Engine scene node.
   *
   * The [bakeFps] parameter overrides the bake_fps in [state].
   */
  @JvmOverloads
  public final fun generateScene(
    state: GLTFState?,
    bakeFps: Float = 30.0f,
    trimming: Boolean = false,
    removeImmutableTracks: Boolean = true,
  ): Node? =
      (TransferContext.callPtrMethod_OBJECT_DOUBLE_BOOL_BOOL_ret_OBJECT(ptr, objectID.id, MethodBindings.generateScenePtr, state, bakeFps.toDouble(), trimming, removeImmutableTracks) as Node?)

  /**
   * Takes a [GLTFState] object through the [state] parameter and returns a glTF [PackedByteArray].
   */
  public final fun generateBuffer(state: GLTFState?): PackedByteArray =
      TransferContext.callPtrMethod_OBJECT_ret_PACKED_BYTE_ARRAY(ptr, objectID.id, MethodBindings.generateBufferPtr, state)

  /**
   * Takes a [GLTFState] object through the [state] parameter and writes a glTF file to the
   * filesystem.
   *
   * **Note:** The extension of the glTF file determines if it is a .glb binary file or a .gltf text
   * file.
   */
  public final fun writeToFilesystem(state: GLTFState?, path: String): Error =
      Error.from(TransferContext.callMethod_OBJECT_STRING_ret_LONG(ptr, objectID.id, MethodBindings.writeToFilesystemPtr, state, path))

  public enum class RootNodeMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Treat the Godot scene's root node as the root node of the glTF file, and mark it as the
     * single root node via the `GODOT_single_root` glTF extension. This will be parsed the same as
     * [ROOT_NODE_MODE_KEEP_ROOT] if the implementation does not support `GODOT_single_root`.
     */
    SINGLE_ROOT(0),
    /**
     * Treat the Godot scene's root node as the root node of the glTF file, but do not mark it as
     * anything special. An extra root node will be generated when importing into Godot. This uses only
     * vanilla glTF features. This is equivalent to the behavior in Godot 4.1 and earlier.
     */
    KEEP_ROOT(1),
    /**
     * Treat the Godot scene's root node as the name of the glTF scene, and add all of its children
     * as root nodes of the glTF file. This uses only vanilla glTF features. This avoids an extra root
     * node, but only the name of the Godot scene's root node will be preserved, as it will not be
     * saved as a node.
     */
    MULTI_ROOT(2),
    ;

    public companion object {
      public fun from(`value`: Long): RootNodeMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class TextureMapMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Import the texture maps in the glTF file as they are, without trying to fit them into
     * specific texture slots suitable for Godot's built-in materials. This may be desirable if using
     * the glTF file with custom shaders, but may not display correctly with Godot's built-in
     * materials. This is equivalent to the behavior in Godot 4.6 and earlier.
     */
    DO_NOT_REMAP(0),
    /**
     * Import the texture maps in the glTF file remapped to the most suitable texture slots based on
     * Godot's [StandardMaterial3D] class. This is the default behavior.
     */
    REMAP_TO_STANDARD_MATERIAL(1),
    ;

    public companion object {
      public fun from(`value`: Long): TextureMapMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class VisibilityMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * If the scene contains any non-visible nodes, include them, mark them as non-visible with
     * `KHR_node_visibility`, and require that importers respect their non-visibility. Downside: If the
     * importer does not support `KHR_node_visibility`, the file cannot be imported.
     */
    INCLUDE_REQUIRED(0),
    /**
     * If the scene contains any non-visible nodes, include them, mark them as non-visible with
     * `KHR_node_visibility`, and do not impose any requirements on importers. Downside: If the
     * importer does not support `KHR_node_visibility`, invisible objects will be visible.
     */
    INCLUDE_OPTIONAL(1),
    /**
     * If the scene contains any non-visible nodes, do not include them in the export. This is the
     * same as the behavior in Godot 4.4 and earlier. Downside: Invisible nodes will not exist in the
     * exported file.
     */
    EXCLUDE(2),
    ;

    public companion object {
      public fun from(`value`: Long): VisibilityMode = entries.single { it.`value` == `value` }
    }
  }

  public class ImportFlags(
    flag: Long,
  ) : BitFieldBase<ImportFlags>(flag) {
    protected override fun wrap(flag: Long): ImportFlags = ImportFlags(flag)

    public companion object {
      /**
       * If `true`, generate vertex tangents using [url=http://www.mikktspace.com/]Mikktspace[/url]
       * if the input meshes don't have tangent data. When possible, it's recommended to let the 3D
       * modeling software generate tangents on export instead of relying on this option. Tangents are
       * required for correct display of normal and height maps, along with any material/shader
       * features that require tangents.
       *
       * If you don't need material features that require tangents, disabling this can reduce output
       * file size and speed up importing if the source 3D file doesn't contain tangents.
       */
      @JvmField
      public val GENERATE_TANGENT_ARRAYS: ImportFlags = ImportFlags(8)

      /**
       * If checked, use named [Skin]s for animation. The [MeshInstance3D] node contains 3
       * properties of relevance here: a skeleton [NodePath] pointing to the [Skeleton3D] node (usually
       * `..`), a mesh, and a skin:
       *
       * - The [Skeleton3D] node contains a list of bones with names, their pose and rest, a name,
       * and a parent bone.
       *
       * - The mesh is all of the raw vertex data needed to display a mesh. In terms of the mesh, it
       * knows how vertices are weight-painted and uses some internal numbering often imported from 3D
       * modeling software.
       *
       * - The skin contains the information necessary to bind this mesh onto this Skeleton3D. For
       * each of the internal bone IDs chosen by the 3D modeling software, it contains two things.
       * Firstly, a matrix known as the Bind Pose Matrix, Inverse Bind Matrix, or IBM for short.
       * Secondly, the [Skin] contains each bone's name (if this flag is enabled), or the bone's index
       * within the [Skeleton3D] list (if this flag is disabled).
       *
       * Together, this information is enough to tell Godot how to use the bone poses in the
       * [Skeleton3D] node to render the mesh from each [MeshInstance3D]. Note that each
       * [MeshInstance3D] may share binds, as is common in models exported from Blender, or each
       * [MeshInstance3D] may use a separate [Skin] object, as is common in models exported from other
       * tools such as Maya.
       */
      @JvmField
      public val USE_NAMED_SKIN_BINDS: ImportFlags = ImportFlags(16)

      /**
       * Ignore meshes and materials on import. When importing a scene as an [AnimationLibrary],
       * this flag is always enabled.
       */
      @JvmField
      public val DISCARD_MESHES_AND_MATERIALS: ImportFlags = ImportFlags(32)

      /**
       * If `true`, mesh compression will not be used. Consider enabling if you notice blocky
       * artifacts in your mesh normals or UVs, or if you have meshes that are larger than a few
       * thousand meters in each direction.
       */
      @JvmField
      public val FORCE_DISABLE_MESH_COMPRESSION: ImportFlags = ImportFlags(64)
    }
  }

  public companion object {
    @JvmField
    public val setImageFormatName: MethodStringName1<GLTFDocument, Unit, String> =
        MethodStringName1<GLTFDocument, Unit, String>("set_image_format")

    @JvmField
    public val getImageFormatName: MethodStringName0<GLTFDocument, String> =
        MethodStringName0<GLTFDocument, String>("get_image_format")

    @JvmField
    public val setLossyQualityName: MethodStringName1<GLTFDocument, Unit, Float> =
        MethodStringName1<GLTFDocument, Unit, Float>("set_lossy_quality")

    @JvmField
    public val getLossyQualityName: MethodStringName0<GLTFDocument, Float> =
        MethodStringName0<GLTFDocument, Float>("get_lossy_quality")

    @JvmField
    public val setFallbackImageFormatName: MethodStringName1<GLTFDocument, Unit, String> =
        MethodStringName1<GLTFDocument, Unit, String>("set_fallback_image_format")

    @JvmField
    public val getFallbackImageFormatName: MethodStringName0<GLTFDocument, String> =
        MethodStringName0<GLTFDocument, String>("get_fallback_image_format")

    @JvmField
    public val setFallbackImageQualityName: MethodStringName1<GLTFDocument, Unit, Float> =
        MethodStringName1<GLTFDocument, Unit, Float>("set_fallback_image_quality")

    @JvmField
    public val getFallbackImageQualityName: MethodStringName0<GLTFDocument, Float> =
        MethodStringName0<GLTFDocument, Float>("get_fallback_image_quality")

    @JvmField
    public val setRootNodeModeName: MethodStringName1<GLTFDocument, Unit, RootNodeMode> =
        MethodStringName1<GLTFDocument, Unit, RootNodeMode>("set_root_node_mode")

    @JvmField
    public val getRootNodeModeName: MethodStringName0<GLTFDocument, RootNodeMode> =
        MethodStringName0<GLTFDocument, RootNodeMode>("get_root_node_mode")

    @JvmField
    public val setTextureMapModeName: MethodStringName1<GLTFDocument, Unit, TextureMapMode> =
        MethodStringName1<GLTFDocument, Unit, TextureMapMode>("set_texture_map_mode")

    @JvmField
    public val getTextureMapModeName: MethodStringName0<GLTFDocument, TextureMapMode> =
        MethodStringName0<GLTFDocument, TextureMapMode>("get_texture_map_mode")

    @JvmField
    public val setVisibilityModeName: MethodStringName1<GLTFDocument, Unit, VisibilityMode> =
        MethodStringName1<GLTFDocument, Unit, VisibilityMode>("set_visibility_mode")

    @JvmField
    public val getVisibilityModeName: MethodStringName0<GLTFDocument, VisibilityMode> =
        MethodStringName0<GLTFDocument, VisibilityMode>("get_visibility_mode")

    @JvmField
    public val appendFromFileName:
        MethodStringName4<GLTFDocument, Error, String, GLTFState?, Long, String> =
        MethodStringName4<GLTFDocument, Error, String, GLTFState?, Long, String>("append_from_file")

    @JvmField
    public val appendFromBufferName:
        MethodStringName4<GLTFDocument, Error, PackedByteArray, String, GLTFState?, Long> =
        MethodStringName4<GLTFDocument, Error, PackedByteArray, String, GLTFState?, Long>("append_from_buffer")

    @JvmField
    public val appendFromSceneName: MethodStringName3<GLTFDocument, Error, Node?, GLTFState?, Long>
        = MethodStringName3<GLTFDocument, Error, Node?, GLTFState?, Long>("append_from_scene")

    @JvmField
    public val generateSceneName:
        MethodStringName4<GLTFDocument, Node?, GLTFState?, Float, Boolean, Boolean> =
        MethodStringName4<GLTFDocument, Node?, GLTFState?, Float, Boolean, Boolean>("generate_scene")

    @JvmField
    public val generateBufferName: MethodStringName1<GLTFDocument, PackedByteArray, GLTFState?> =
        MethodStringName1<GLTFDocument, PackedByteArray, GLTFState?>("generate_buffer")

    @JvmField
    public val writeToFilesystemName: MethodStringName2<GLTFDocument, Error, GLTFState?, String> =
        MethodStringName2<GLTFDocument, Error, GLTFState?, String>("write_to_filesystem")

    @JvmField
    public val importObjectModelPropertyName:
        MethodStringName2<GLTFDocument, GLTFObjectModelProperty?, GLTFState?, String> =
        MethodStringName2<GLTFDocument, GLTFObjectModelProperty?, GLTFState?, String>("import_object_model_property")

    @JvmField
    public val exportObjectModelPropertyName:
        MethodStringName4<GLTFDocument, GLTFObjectModelProperty?, GLTFState?, NodePath, Node?, Int>
        =
        MethodStringName4<GLTFDocument, GLTFObjectModelProperty?, GLTFState?, NodePath, Node?, Int>("export_object_model_property")

    @JvmField
    public val registerGltfDocumentExtensionName:
        MethodStringName2<GLTFDocument, Unit, GLTFDocumentExtension?, Boolean> =
        MethodStringName2<GLTFDocument, Unit, GLTFDocumentExtension?, Boolean>("register_gltf_document_extension")

    @JvmField
    public val unregisterGltfDocumentExtensionName:
        MethodStringName1<GLTFDocument, Unit, GLTFDocumentExtension?> =
        MethodStringName1<GLTFDocument, Unit, GLTFDocumentExtension?>("unregister_gltf_document_extension")

    @JvmField
    public val getSupportedGltfExtensionsName: MethodStringName0<GLTFDocument, PackedStringArray> =
        MethodStringName0<GLTFDocument, PackedStringArray>("get_supported_gltf_extensions")

    /**
     * Determines a mapping between the given glTF Object Model [jsonPointer] and the corresponding
     * Godot node path(s) in the generated Godot scene. The details of this mapping are returned in a
     * [GLTFObjectModelProperty] object. Additional mappings can be supplied via the
     * [GLTFDocumentExtension.ExportObjectModelProperty] callback method.
     */
    @JvmStatic
    public final fun importObjectModelProperty(state: GLTFState?, jsonPointer: String):
        GLTFObjectModelProperty? =
        (TransferContext.callMethod_OBJECT_STRING_ret_OBJECT_REF(0L, 0L, MethodBindings.importObjectModelPropertyPtr, state, jsonPointer) as GLTFObjectModelProperty?)

    /**
     * Determines a mapping between the given Godot [nodePath] and the corresponding glTF Object
     * Model JSON pointer(s) in the generated glTF file. The details of this mapping are returned in a
     * [GLTFObjectModelProperty] object. Additional mappings can be supplied via the
     * [GLTFDocumentExtension.ImportObjectModelProperty] callback method.
     */
    @JvmStatic
    public final fun exportObjectModelProperty(
      state: GLTFState?,
      nodePath: NodePath,
      godotNode: Node?,
      gltfNodeIndex: Int,
    ): GLTFObjectModelProperty? =
        (TransferContext.callPtrMethod_OBJECT_NODE_PATH_OBJECT_LONG_ret_OBJECT_REF(0L, 0L, MethodBindings.exportObjectModelPropertyPtr, state, nodePath, godotNode, gltfNodeIndex.toLong()) as GLTFObjectModelProperty?)

    /**
     * Registers the given [GLTFDocumentExtension] instance with GLTFDocument. If [firstPriority] is
     * `true`, this extension will be run first. Otherwise, it will be run last.
     *
     * **Note:** Like GLTFDocument itself, all GLTFDocumentExtension classes must be stateless in
     * order to function properly. If you need to store data, use the `set_additional_data` and
     * `get_additional_data` methods in [GLTFState] or [GLTFNode].
     */
    @JvmOverloads
    @JvmStatic
    public final fun registerGltfDocumentExtension(extension: GLTFDocumentExtension?,
        firstPriority: Boolean = false): Unit {
      TransferContext.callPtrMethod_OBJECT_BOOL(0L, 0L, MethodBindings.registerGltfDocumentExtensionPtr, extension, firstPriority)
    }

    /**
     * Unregisters the given [GLTFDocumentExtension] instance.
     */
    @JvmStatic
    public final fun unregisterGltfDocumentExtension(extension: GLTFDocumentExtension?): Unit {
      TransferContext.callPtrMethod_OBJECT(0L, 0L, MethodBindings.unregisterGltfDocumentExtensionPtr, extension)
    }

    /**
     * Returns a list of all support glTF extensions, including extensions supported directly by the
     * engine, and extensions supported by user plugins registering [GLTFDocumentExtension] classes.
     *
     * **Note:** If this method is run before a GLTFDocumentExtension is registered, its extensions
     * won't be included in the list. Be sure to only run this method after all extensions are
     * registered. If you run this when the engine starts, consider waiting a frame before calling this
     * method to ensure all extensions are registered.
     */
    @JvmStatic
    public final fun getSupportedGltfExtensions(): PackedStringArray =
        TransferContext.callPtrMethod0_ret_PACKED_STRING_ARRAY(0L, 0L, MethodBindings.getSupportedGltfExtensionsPtr)

    /**
     * Determines a mapping between the given Godot [nodePath] and the corresponding glTF Object
     * Model JSON pointer(s) in the generated glTF file. The details of this mapping are returned in a
     * [GLTFObjectModelProperty] object. Additional mappings can be supplied via the
     * [GLTFDocumentExtension.ImportObjectModelProperty] callback method.
     */
    @JvmStatic
    public final fun exportObjectModelProperty(
      state: GLTFState?,
      nodePath: String,
      godotNode: Node?,
      gltfNodeIndex: Int,
    ): GLTFObjectModelProperty? =
        exportObjectModelProperty(state, nodePath.asCachedNodePath(), godotNode, gltfNodeIndex)
  }

  public object MethodBindings {
    internal val setImageFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "set_image_format", 83702148)

    internal val getImageFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "get_image_format", 201670096)

    internal val setLossyQualityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "set_lossy_quality", 373806689)

    internal val getLossyQualityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "get_lossy_quality", 1740695150)

    internal val setFallbackImageFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "set_fallback_image_format", 83702148)

    internal val getFallbackImageFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "get_fallback_image_format", 201670096)

    internal val setFallbackImageQualityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "set_fallback_image_quality", 373806689)

    internal val getFallbackImageQualityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "get_fallback_image_quality", 1740695150)

    internal val setRootNodeModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "set_root_node_mode", 463633402)

    internal val getRootNodeModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "get_root_node_mode", 948057992)

    internal val setTextureMapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "set_texture_map_mode", 3144426102)

    internal val getTextureMapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "get_texture_map_mode", 2113256994)

    internal val setVisibilityModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "set_visibility_mode", 2803579218)

    internal val getVisibilityModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "get_visibility_mode", 3885445962)

    internal val appendFromFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "append_from_file", 866380864)

    internal val appendFromBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "append_from_buffer", 1616081266)

    internal val appendFromScenePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "append_from_scene", 1622574258)

    internal val generateScenePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "generate_scene", 596118388)

    internal val generateBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "generate_buffer", 741783455)

    internal val writeToFilesystemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "write_to_filesystem", 1784551478)

    internal val importObjectModelPropertyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "import_object_model_property", 1206708632)

    internal val exportObjectModelPropertyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "export_object_model_property", 314209806)

    internal val registerGltfDocumentExtensionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "register_gltf_document_extension", 3752678331)

    internal val unregisterGltfDocumentExtensionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "unregister_gltf_document_extension", 2684415758)

    internal val getSupportedGltfExtensionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFDocument", "get_supported_gltf_extensions", 2981934095)
  }
}
