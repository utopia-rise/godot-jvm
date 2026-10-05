// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import godot.core.Dictionary
import godot.core.Error
import godot.core.NodePath
import godot.core.PackedByteArray
import godot.core.PackedStringArray
import godot.core.VariantArray
import kotlin.Any
import kotlin.Float
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit

/**
 * Extends the functionality of the [GLTFDocument] class by allowing you to run arbitrary code at
 * various stages of glTF import or export.
 *
 * To use, make a new class extending GLTFDocumentExtension, override any methods you need, make an
 * instance of your class, and register it using [GLTFDocument.registerGltfDocumentExtension].
 *
 * **Note:** All GLTFDocumentExtension classes are duplicated when beginning the import or export
 * process. Except for configuration values, these classes must be stateless in order to function
 * properly. If you need to store data, use the `set_additional_data` and `get_additional_data` methods
 * in [GLTFState] or [GLTFNode].
 */
@GodotBaseType
public open class GLTFDocumentExtension : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(243, scriptPtr)
  }

  /**
   * Part of the import process. This method is run first, before all other parts of the import
   * process.
   *
   * The return value is used to determine if this [GLTFDocumentExtension] instance should be used
   * for importing a given glTF file. If [OK], the import will use this [GLTFDocumentExtension]
   * instance. If not overridden, [OK] is returned.
   */
  public open fun _importPreflight(state: GLTFState?, extensions: PackedStringArray): Error {
    throw NotImplementedError("GLTFDocumentExtension::_importPreflight is not implemented.")
  }

  /**
   * Part of the import process. This method is run after [_importPreflight] and before
   * [_parseNodeExtensions].
   *
   * Returns an array of the glTF extensions supported by this GLTFDocumentExtension class. This is
   * used to validate if a glTF file with required extensions can be loaded.
   */
  public open fun _getSupportedExtensions(): PackedStringArray {
    throw NotImplementedError("GLTFDocumentExtension::_getSupportedExtensions is not implemented.")
  }

  /**
   * Part of the import process. This method is run after [_getSupportedExtensions] and before
   * [_importPostParse].
   *
   * Runs when parsing the node extensions of a GLTFNode. This method can be used to process the
   * extension JSON data into a format that can be used by [_generateSceneNode]. The return value
   * should be a member of the [Error] enum.
   */
  public open fun _parseNodeExtensions(
    state: GLTFState?,
    gltfNode: GLTFNode?,
    extensions: Dictionary<Any?, Any?>,
  ): Error {
    throw NotImplementedError("GLTFDocumentExtension::_parseNodeExtensions is not implemented.")
  }

  /**
   * Part of the import process. This method is run after [_parseNodeExtensions] and before
   * [_parseTextureJson].
   *
   * Runs when parsing image data from a glTF file. The data could be sourced from a separate file,
   * a URI, or a buffer, and then is passed as a byte array.
   */
  public open fun _parseImageData(
    state: GLTFState?,
    imageData: PackedByteArray,
    mimeType: String,
    retImage: Image?,
  ): Error {
    throw NotImplementedError("GLTFDocumentExtension::_parseImageData is not implemented.")
  }

  /**
   * Returns the file extension to use for saving image data into, for example, `".png"`. If
   * defined, when this extension is used to handle images, and the images are saved to a separate
   * file, the image bytes will be copied to a file with this extension. If this is set, there should
   * be a [ResourceImporter] class able to import the file. If not defined or empty, Godot will save
   * the image into a PNG file.
   */
  public open fun _getImageFileExtension(): String {
    throw NotImplementedError("GLTFDocumentExtension::_getImageFileExtension is not implemented.")
  }

  /**
   * Part of the import process. This method is run after [_parseImageData] and before
   * [_generateSceneNode].
   *
   * Runs when parsing the texture JSON from the glTF textures array. This can be used to set the
   * source image index to use as the texture.
   */
  public open fun _parseTextureJson(
    state: GLTFState?,
    textureJson: Dictionary<Any?, Any?>,
    retGltfTexture: GLTFTexture?,
  ): Error {
    throw NotImplementedError("GLTFDocumentExtension::_parseTextureJson is not implemented.")
  }

  /**
   * Part of the import process. Allows GLTFDocumentExtension classes to provide mappings for JSON
   * pointers to glTF properties, as defined by the glTF object model, to properties of nodes in the
   * Godot scene tree.
   *
   * Returns a [GLTFObjectModelProperty] instance that defines how the property should be mapped. If
   * your extension can't handle the property, return `null` or an instance without any NodePaths (see
   * [GLTFObjectModelProperty.hasNodePaths]). You should use [GLTFObjectModelProperty.setTypes] to set
   * the types, and [GLTFObjectModelProperty.appendPathToProperty] function is useful for most simple
   * cases.
   *
   * In many cases, [partialPaths] will contain the start of a path, allowing the extension to
   * complete the path. For example, for `/nodes/3/extensions/MY_ext/prop`, Godot will pass you a
   * NodePath that leads to node 3, so the GLTFDocumentExtension class only needs to resolve the last
   * `MY_ext/prop` part of the path. In this example, the extension should check `split.size() > 4 and
   * split[0] == "nodes" and split[2] == "extensions" and split[3] == "MY_ext"` at the start of the
   * function to check if this JSON pointer applies to it, then it can use [partialPaths] and handle
   * `split[4]`.
   */
  public open fun _importObjectModelProperty(
    state: GLTFState?,
    splitJsonPointer: PackedStringArray,
    partialPaths: VariantArray<NodePath>,
  ): GLTFObjectModelProperty? {
    throw NotImplementedError("GLTFDocumentExtension::_importObjectModelProperty is not implemented.")
  }

  /**
   * Part of the import process. This method is run after [_parseNodeExtensions] and before
   * [_importPreGenerate].
   *
   * This method can be used to modify any of the data imported so far after parsing each node, but
   * before generating the scene or any of its nodes.
   */
  public open fun _importPostParse(state: GLTFState?): Error {
    throw NotImplementedError("GLTFDocumentExtension::_importPostParse is not implemented.")
  }

  /**
   * Part of the import process. This method is run after [_importPostParse] and before
   * [_generateSceneNode].
   *
   * This method can be used to modify or read from any of the processed data structures, before
   * generating the nodes and then running the final per-node import step.
   */
  public open fun _importPreGenerate(state: GLTFState?): Error {
    throw NotImplementedError("GLTFDocumentExtension::_importPreGenerate is not implemented.")
  }

  /**
   * Part of the import process. This method is run after [_importPreGenerate] and before
   * [_importNode].
   *
   * Runs when generating a Godot scene node from a GLTFNode. The returned node will be added to the
   * scene tree. Multiple nodes can be generated in this step if they are added as a child of the
   * returned node.
   *
   * **Note:** The [sceneParent] parameter may be `null` if this is the single root node.
   */
  public open fun _generateSceneNode(
    state: GLTFState?,
    gltfNode: GLTFNode?,
    sceneParent: Node?,
  ): Node3D? {
    throw NotImplementedError("GLTFDocumentExtension::_generateSceneNode is not implemented.")
  }

  /**
   * Part of the import process. This method is run after [_generateSceneNode] and before
   * [_importPost].
   *
   * This method can be used to make modifications to each of the generated Godot scene nodes.
   */
  public open fun _importNode(
    state: GLTFState?,
    gltfNode: GLTFNode?,
    json: Dictionary<Any?, Any?>,
    node: Node?,
  ): Error {
    throw NotImplementedError("GLTFDocumentExtension::_importNode is not implemented.")
  }

  /**
   * Part of the import process. This method is run last, after all other parts of the import
   * process.
   *
   * This method can be used to modify the final Godot scene generated by the import process.
   */
  public open fun _importPost(state: GLTFState?, root: Node?): Error {
    throw NotImplementedError("GLTFDocumentExtension::_importPost is not implemented.")
  }

  /**
   * Runs prior to the export process. This method is run before [_exportPreflight] when exporting a
   * scene from the editor, or it may not be run at all in other situations.
   *
   * Unlike the rest of the export methods, this does not run when calling a [GLTFDocument]'s export
   * methods in sequence with everything else, but rather runs before that entire process occurs,
   * allowing configuration to occur beforehand, potentially minutes or hours in advance of
   * [_exportPreflight]. This allows extensions to decide which properties to show in the editor export
   * settings dialog based on the contents of the scene, hiding any settings that are not relevant for
   * that scene. The [rootNode] parameter may be `null`, in which case all properties should be shown.
   */
  public open fun _exportGetPropertyList(rootNode: Node?): VariantArray<Dictionary<Any?, Any?>> {
    throw NotImplementedError("GLTFDocumentExtension::_exportGetPropertyList is not implemented.")
  }

  /**
   * Part of the export process. This method is run first, before all other parts of the export
   * process.
   *
   * The return value is used to determine if this [GLTFDocumentExtension] instance should be used
   * for exporting a given glTF file. If [OK], the export will use this [GLTFDocumentExtension]
   * instance. If not overridden, [OK] is returned.
   */
  public open fun _exportPreflight(state: GLTFState?, root: Node?): Error {
    throw NotImplementedError("GLTFDocumentExtension::_exportPreflight is not implemented.")
  }

  /**
   * Part of the export process. This method is run after [_exportPreflight] and before
   * [_exportPostConvert].
   *
   * Runs when converting the data from a Godot scene node. This method can be used to process the
   * Godot scene node data into a format that can be used by [_exportNode].
   */
  public open fun _convertSceneNode(
    state: GLTFState?,
    gltfNode: GLTFNode?,
    sceneNode: Node?,
  ): Unit {
    throw NotImplementedError("GLTFDocumentExtension::_convertSceneNode is not implemented.")
  }

  /**
   * Part of the export process. This method is run after [_convertSceneNode] and before
   * [_exportPreserialize].
   *
   * This method can be used to modify the converted node data structures before serialization with
   * any additional data from the scene tree.
   */
  public open fun _exportPostConvert(state: GLTFState?, root: Node?): Error {
    throw NotImplementedError("GLTFDocumentExtension::_exportPostConvert is not implemented.")
  }

  /**
   * Part of the export process. This method is run after [_exportPostConvert] and before
   * [_getSaveableImageFormats].
   *
   * This method can be used to alter the state before performing serialization. It runs every time
   * when generating a buffer with [GLTFDocument.generateBuffer] or writing to the file system with
   * [GLTFDocument.writeToFilesystem].
   */
  public open fun _exportPreserialize(state: GLTFState?): Error {
    throw NotImplementedError("GLTFDocumentExtension::_exportPreserialize is not implemented.")
  }

  /**
   * Part of the export process. Allows GLTFDocumentExtension classes to provide mappings for
   * properties of nodes in the Godot scene tree, to JSON pointers to glTF properties, as defined by
   * the glTF object model.
   *
   * Returns a [GLTFObjectModelProperty] instance that defines how the property should be mapped. If
   * your extension can't handle the property, return `null` or an instance without any JSON pointers
   * (see [GLTFObjectModelProperty.hasJsonPointers]). You should use [GLTFObjectModelProperty.setTypes]
   * to set the types, and set the JSON pointer(s) using the [GLTFObjectModelProperty.jsonPointers]
   * property.
   *
   * The parameters provide context for the property, including the NodePath, the Godot node, the
   * GLTF node index, and the target object. The [targetObject] will be equal to [godotNode] if no
   * sub-object can be found, otherwise it will point to a sub-object. For example, if the path is
   * `^"A/B/C/MeshInstance3D:mesh:surface_0/material:emission_intensity"`, it will get the node, then
   * the mesh, and then the material, so [targetObject] will be the [Material] resource, and
   * [targetDepth] will be 2 because 2 levels were traversed to get to the target.
   */
  public open fun _exportObjectModelProperty(
    state: GLTFState?,
    nodePath: NodePath,
    godotNode: Node?,
    gltfNodeIndex: Int,
    targetObject: Object?,
    targetDepth: Int,
  ): GLTFObjectModelProperty? {
    throw NotImplementedError("GLTFDocumentExtension::_exportObjectModelProperty is not implemented.")
  }

  /**
   * Part of the export process. This method is run after [_convertSceneNode] and before
   * [_exportNode].
   *
   * Returns an array of the image formats that can be saved/exported by this extension. This
   * extension will only be selected as the image exporter if the [GLTFDocument]'s
   * [GLTFDocument.imageFormat] is in this array. If this [GLTFDocumentExtension] is selected as the
   * image exporter, one of the [_saveImageAtPath] or [_serializeImageToBytes] methods will run next,
   * otherwise [_exportNode] will run next. If the format name contains `"Lossy"`, the lossy quality
   * slider will be displayed.
   */
  public open fun _getSaveableImageFormats(): PackedStringArray {
    throw NotImplementedError("GLTFDocumentExtension::_getSaveableImageFormats is not implemented.")
  }

  /**
   * Part of the export process. This method is run after [_getSaveableImageFormats] and before
   * [_serializeTextureJson].
   *
   * This method is run when embedding images in the glTF file. When images are saved separately,
   * [_saveImageAtPath] runs instead. Note that these methods only run when this
   * [GLTFDocumentExtension] is selected as the image exporter.
   *
   * This method must set the image MIME type in the [imageDict] with the `"mimeType"` key. For
   * example, for a PNG image, it would be set to `"image/png"`. The return value must be a
   * [PackedByteArray] containing the image data.
   */
  public open fun _serializeImageToBytes(
    state: GLTFState?,
    image: Image?,
    imageDict: Dictionary<Any?, Any?>,
    imageFormat: String,
    lossyQuality: Float,
  ): PackedByteArray {
    throw NotImplementedError("GLTFDocumentExtension::_serializeImageToBytes is not implemented.")
  }

  /**
   * Part of the export process. This method is run after [_getSaveableImageFormats] and before
   * [_serializeTextureJson].
   *
   * This method is run when saving images separately from the glTF file. When images are embedded,
   * [_serializeImageToBytes] runs instead. Note that these methods only run when this
   * [GLTFDocumentExtension] is selected as the image exporter.
   */
  public open fun _saveImageAtPath(
    state: GLTFState?,
    image: Image?,
    filePath: String,
    imageFormat: String,
    lossyQuality: Float,
  ): Error {
    throw NotImplementedError("GLTFDocumentExtension::_saveImageAtPath is not implemented.")
  }

  /**
   * Part of the export process. This method is run after [_saveImageAtPath] or
   * [_serializeImageToBytes], and before [_exportNode]. Note that this method only runs when this
   * [GLTFDocumentExtension] is selected as the image exporter.
   *
   * This method can be used to set up the extensions for the texture JSON by editing [textureJson].
   * The extension must also be added as used extension with [GLTFState.addUsedExtension], be sure to
   * set `required` to `true` if you are not providing a fallback.
   */
  public open fun _serializeTextureJson(
    state: GLTFState?,
    textureJson: Dictionary<Any?, Any?>,
    gltfTexture: GLTFTexture?,
    imageFormat: String,
  ): Error {
    throw NotImplementedError("GLTFDocumentExtension::_serializeTextureJson is not implemented.")
  }

  /**
   * Part of the export process. This method is run after [_getSaveableImageFormats] and before
   * [_exportPost]. If this [GLTFDocumentExtension] is used for exporting images, this runs after
   * [_serializeTextureJson].
   *
   * This method can be used to modify the final JSON of each node. Data should be primarily stored
   * in [gltfNode] prior to serializing the JSON, but the original Godot [Node] is also provided if
   * available. [node] may be `null` if not available, such as when exporting glTF data not generated
   * from a Godot scene.
   */
  public open fun _exportNode(
    state: GLTFState?,
    gltfNode: GLTFNode?,
    json: Dictionary<Any?, Any?>,
    node: Node?,
  ): Error {
    throw NotImplementedError("GLTFDocumentExtension::_exportNode is not implemented.")
  }

  /**
   * Part of the export process. This method is run last, after all other parts of the export
   * process.
   *
   * This method can be used to modify the final JSON of the generated glTF file.
   */
  public open fun _exportPost(state: GLTFState?): Error {
    throw NotImplementedError("GLTFDocumentExtension::_exportPost is not implemented.")
  }

  public companion object

  public object MethodBindings
}
