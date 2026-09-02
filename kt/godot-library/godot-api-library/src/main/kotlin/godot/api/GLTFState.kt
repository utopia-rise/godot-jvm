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
import godot.core.Dictionary
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.PackedByteArray
import godot.core.PackedInt32Array
import godot.core.StringName
import godot.core.VariantArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_BYTE_ARRAY
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.STRING
import godot.core.VariantParser.STRING_NAME
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Boolean
import kotlin.Byte
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Contains all nodes and resources of a glTF file. This is used by [GLTFDocument] as data storage,
 * which allows [GLTFDocument] and all [GLTFDocumentExtension] classes to remain stateless.
 *
 * GLTFState can be populated by [GLTFDocument] reading a file or by converting a Godot scene. Then
 * the data can either be used to create a Godot scene or save to a glTF file. The code that converts
 * to/from a Godot scene can be intercepted at arbitrary points by [GLTFDocumentExtension] classes.
 * This allows for custom data to be stored in the glTF file or for custom data to be converted to/from
 * Godot nodes.
 */
@GodotBaseType
public open class GLTFState : Resource() {
  /**
   * The original raw JSON document corresponding to this GLTFState.
   */
  public final inline var json: Dictionary<Any?, Any?>
    @JvmName("jsonProperty")
    get() = getJson()
    @JvmName("jsonProperty")
    set(`value`) {
      setJson(value)
    }

  public final inline var majorVersion: Int
    @JvmName("majorVersionProperty")
    get() = getMajorVersion()
    @JvmName("majorVersionProperty")
    set(`value`) {
      setMajorVersion(value)
    }

  public final inline var minorVersion: Int
    @JvmName("minorVersionProperty")
    get() = getMinorVersion()
    @JvmName("minorVersionProperty")
    set(`value`) {
      setMinorVersion(value)
    }

  /**
   * The copyright string in the asset header of the glTF file. This is set during import if present
   * and export if non-empty. See the glTF asset header documentation for more information.
   */
  public final inline var copyright: String
    @JvmName("copyrightProperty")
    get() = getCopyright()
    @JvmName("copyrightProperty")
    set(`value`) {
      setCopyright(value)
    }

  /**
   * The binary buffer attached to a .glb file.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var glbData: PackedByteArray
    @JvmName("glbDataProperty")
    get() = getGlbData()
    @JvmName("glbDataProperty")
    set(`value`) {
      setGlbData(value)
    }

  public final inline var useNamedSkinBinds: Boolean
    @JvmName("useNamedSkinBindsProperty")
    get() = getUseNamedSkinBinds()
    @JvmName("useNamedSkinBindsProperty")
    set(`value`) {
      setUseNamedSkinBinds(value)
    }

  public final inline var nodes: VariantArray<GLTFNode>
    @JvmName("nodesProperty")
    get() = getNodes()
    @JvmName("nodesProperty")
    set(`value`) {
      setNodes(value)
    }

  public final inline var buffers: VariantArray<PackedByteArray>
    @JvmName("buffersProperty")
    get() = getBuffers()
    @JvmName("buffersProperty")
    set(`value`) {
      setBuffers(value)
    }

  public final inline var bufferViews: VariantArray<GLTFBufferView>
    @JvmName("bufferViewsProperty")
    get() = getBufferViews()
    @JvmName("bufferViewsProperty")
    set(`value`) {
      setBufferViews(value)
    }

  public final inline var accessors: VariantArray<GLTFAccessor>
    @JvmName("accessorsProperty")
    get() = getAccessors()
    @JvmName("accessorsProperty")
    set(`value`) {
      setAccessors(value)
    }

  public final inline var meshes: VariantArray<GLTFMesh>
    @JvmName("meshesProperty")
    get() = getMeshes()
    @JvmName("meshesProperty")
    set(`value`) {
      setMeshes(value)
    }

  public final inline var materials: VariantArray<Material>
    @JvmName("materialsProperty")
    get() = getMaterials()
    @JvmName("materialsProperty")
    set(`value`) {
      setMaterials(value)
    }

  /**
   * The name of the scene. When importing, if not specified, this will be the file name. When
   * exporting, if specified, the scene name will be saved to the glTF file.
   */
  public final inline var sceneName: String
    @JvmName("sceneNameProperty")
    get() = getSceneName()
    @JvmName("sceneNameProperty")
    set(`value`) {
      setSceneName(value)
    }

  /**
   * The folder path associated with this glTF data. This is used to find other files the glTF file
   * references, like images or binary buffers. This will be set during import when appending from a
   * file, and will be set during export when writing to a file.
   */
  public final inline var basePath: String
    @JvmName("basePathProperty")
    get() = getBasePath()
    @JvmName("basePathProperty")
    set(`value`) {
      setBasePath(value)
    }

  /**
   * The file name associated with this glTF data. If it ends with `.gltf`, this is text-based glTF,
   * otherwise this is binary GLB. This will be set during import when appending from a file, and will
   * be set during export when writing to a file. If writing to a buffer, this will be an empty string.
   */
  public final inline var filename: String
    @JvmName("filenameProperty")
    get() = getFilename()
    @JvmName("filenameProperty")
    set(`value`) {
      setFilename(value)
    }

  /**
   * The root nodes of the glTF file. Typically, a glTF file will only have one scene, and therefore
   * one root node. However, a glTF file may have multiple scenes and therefore multiple root nodes,
   * which will be generated as siblings of each other and as children of the root node of the
   * generated Godot scene.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var rootNodes: PackedInt32Array
    @JvmName("rootNodesProperty")
    get() = getRootNodes()
    @JvmName("rootNodesProperty")
    set(`value`) {
      setRootNodes(value)
    }

  public final inline var textures: VariantArray<GLTFTexture>
    @JvmName("texturesProperty")
    get() = getTextures()
    @JvmName("texturesProperty")
    set(`value`) {
      setTextures(value)
    }

  public final inline var textureSamplers: VariantArray<GLTFTextureSampler>
    @JvmName("textureSamplersProperty")
    get() = getTextureSamplers()
    @JvmName("textureSamplersProperty")
    set(`value`) {
      setTextureSamplers(value)
    }

  public final inline var images: VariantArray<Texture2D>
    @JvmName("imagesProperty")
    get() = getImages()
    @JvmName("imagesProperty")
    set(`value`) {
      setImages(value)
    }

  public final inline var skins: VariantArray<GLTFSkin>
    @JvmName("skinsProperty")
    get() = getSkins()
    @JvmName("skinsProperty")
    set(`value`) {
      setSkins(value)
    }

  public final inline var cameras: VariantArray<GLTFCamera>
    @JvmName("camerasProperty")
    get() = getCameras()
    @JvmName("camerasProperty")
    set(`value`) {
      setCameras(value)
    }

  public final inline var lights: VariantArray<GLTFLight>
    @JvmName("lightsProperty")
    get() = getLights()
    @JvmName("lightsProperty")
    set(`value`) {
      setLights(value)
    }

  public final inline var uniqueNames: VariantArray<String>
    @JvmName("uniqueNamesProperty")
    get() = getUniqueNames()
    @JvmName("uniqueNamesProperty")
    set(`value`) {
      setUniqueNames(value)
    }

  public final inline var uniqueAnimationNames: VariantArray<String>
    @JvmName("uniqueAnimationNamesProperty")
    get() = getUniqueAnimationNames()
    @JvmName("uniqueAnimationNamesProperty")
    set(`value`) {
      setUniqueAnimationNames(value)
    }

  public final inline var skeletons: VariantArray<GLTFSkeleton>
    @JvmName("skeletonsProperty")
    get() = getSkeletons()
    @JvmName("skeletonsProperty")
    set(`value`) {
      setSkeletons(value)
    }

  public final inline var createAnimations: Boolean
    @JvmName("createAnimationsProperty")
    get() = getCreateAnimations()
    @JvmName("createAnimationsProperty")
    set(`value`) {
      setCreateAnimations(value)
    }

  /**
   * If `true`, forces all GLTFNodes in the document to be bones of a single [Skeleton3D] Godot
   * node.
   */
  public final inline var importAsSkeletonBones: Boolean
    @JvmName("importAsSkeletonBonesProperty")
    get() = getImportAsSkeletonBones()
    @JvmName("importAsSkeletonBonesProperty")
    set(`value`) {
      setImportAsSkeletonBones(value)
    }

  public final inline var animations: VariantArray<GLTFAnimation>
    @JvmName("animationsProperty")
    get() = getAnimations()
    @JvmName("animationsProperty")
    set(`value`) {
      setAnimations(value)
    }

  /**
   * When importing a glTF file with unimported raw binary images embedded inside of binary blob
   * buffers, in data URIs, or separate files not imported by Godot, this controls how the images are
   * handled. Images can be discarded, saved as separate files, or embedded in the scene lossily or
   * losslessly. See [HandleBinaryImageMode] for options.
   *
   * This property does nothing for image files in the `res://` folder imported by Godot, as those
   * are handled by Godot's image importer directly, and then the Godot scene generated from the glTF
   * file will use the images as Godot imported them.
   */
  public final inline var handleBinaryImageMode: HandleBinaryImageMode
    @JvmName("handleBinaryImageModeProperty")
    get() = getHandleBinaryImageMode()
    @JvmName("handleBinaryImageModeProperty")
    set(`value`) {
      setHandleBinaryImageMode(value)
    }

  /**
   * The baking fps of the animation for either import or export.
   */
  public final inline var bakeFps: Double
    @JvmName("bakeFpsProperty")
    get() = getBakeFps()
    @JvmName("bakeFpsProperty")
    set(`value`) {
      setBakeFps(value)
    }

  public final inline var handleBinaryImage: Int
    @JvmName("handleBinaryImageProperty")
    get() = getHandleBinaryImage()
    @JvmName("handleBinaryImageProperty")
    set(`value`) {
      setHandleBinaryImage(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(256, scriptPtr)
  }

  /**
   * This is a helper function for [glbData] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfstate.glbData
   * //Your changes
   * gltfstate.glbData = myCoreType
   * ``````
   *
   * The binary buffer attached to a .glb file.
   */
  @CoreTypeHelper
  public final fun glbDataMutate(block: PackedByteArray.() -> Unit): PackedByteArray =
      glbData.apply {
     block(this)
     glbData = this
  }

  /**
   * This is a helper function for [glbData] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The binary buffer attached to a .glb file.
   */
  @CoreTypeHelper
  public final fun glbDataMutateEach(block: (index: Int, `value`: Byte) -> Unit): PackedByteArray =
      glbData.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     glbData = this
  }

  /**
   * This is a helper function for [rootNodes] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfstate.rootNodes
   * //Your changes
   * gltfstate.rootNodes = myCoreType
   * ``````
   *
   * The root nodes of the glTF file. Typically, a glTF file will only have one scene, and therefore
   * one root node. However, a glTF file may have multiple scenes and therefore multiple root nodes,
   * which will be generated as siblings of each other and as children of the root node of the
   * generated Godot scene.
   */
  @CoreTypeHelper
  public final fun rootNodesMutate(block: PackedInt32Array.() -> Unit): PackedInt32Array =
      rootNodes.apply {
     block(this)
     rootNodes = this
  }

  /**
   * This is a helper function for [rootNodes] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The root nodes of the glTF file. Typically, a glTF file will only have one scene, and therefore
   * one root node. However, a glTF file may have multiple scenes and therefore multiple root nodes,
   * which will be generated as siblings of each other and as children of the root node of the
   * generated Godot scene.
   */
  @CoreTypeHelper
  public final fun rootNodesMutateEach(block: (index: Int, `value`: Int) -> Unit): PackedInt32Array
      = rootNodes.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     rootNodes = this
  }

  /**
   * Appends an extension to the list of extensions used by this glTF file during serialization. If
   * [required] is `true`, the extension will also be added to the list of required extensions. Do not
   * run this in [GLTFDocumentExtension.ExportPost], as that stage is too late to add extensions. The
   * final list is sorted alphabetically.
   */
  public final fun addUsedExtension(extensionName: String, required: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to extensionName, BOOL to required)
    TransferContext.callMethod(MethodBindings.addUsedExtensionPtr)
  }

  /**
   * Appends the given byte array [data] to the buffers and creates a [GLTFBufferView] for it. The
   * index of the destination [GLTFBufferView] is returned. If [deduplication] is `true`, the buffers
   * are first searched for duplicate data, otherwise new bytes are always appended.
   */
  public final fun appendDataToBuffers(`data`: PackedByteArray, deduplication: Boolean): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_BYTE_ARRAY to data, BOOL to deduplication)
    TransferContext.callMethod(MethodBindings.appendDataToBuffersPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Appends the given [GLTFNode] to the state, and returns its new index. This can be used to
   * export one Godot node as multiple glTF nodes, or inject new glTF nodes at import time. On import,
   * this must be called before [GLTFDocumentExtension.GenerateSceneNode] finishes for the parent node.
   * On export, this must be called before [GLTFDocumentExtension.ExportNode] runs for the parent node.
   *
   * The [godotSceneNode] parameter is the Godot scene node that corresponds to this glTF node. This
   * is highly recommended to be set to a valid node, but may be `null` if there is no corresponding
   * Godot scene node. One Godot scene node may be used for multiple glTF nodes, so if exporting
   * multiple glTF nodes for one Godot scene node, use the same Godot scene node for each.
   *
   * The [parentNodeIndex] parameter is the index of the parent [GLTFNode] in the state. If `-1`,
   * the node will be a root node, otherwise the new node will be added to the parent's list of
   * children. The index will also be written to the [GLTFNode.parent] property of the new node.
   */
  public final fun appendGltfNode(
    gltfNode: GLTFNode?,
    godotSceneNode: Node?,
    parentNodeIndex: Int,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to gltfNode, OBJECT to godotSceneNode, LONG to parentNodeIndex.toLong())
    TransferContext.callMethod(MethodBindings.appendGltfNodePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun getJson(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getJsonPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  public final fun setJson(json: Dictionary<Any?, Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DICTIONARY to json)
    TransferContext.callMethod(MethodBindings.setJsonPtr)
  }

  public final fun getMajorVersion(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMajorVersionPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setMajorVersion(majorVersion: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to majorVersion.toLong())
    TransferContext.callMethod(MethodBindings.setMajorVersionPtr)
  }

  public final fun getMinorVersion(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMinorVersionPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setMinorVersion(minorVersion: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to minorVersion.toLong())
    TransferContext.callMethod(MethodBindings.setMinorVersionPtr)
  }

  public final fun getCopyright(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCopyrightPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setCopyright(copyright: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to copyright)
    TransferContext.callMethod(MethodBindings.setCopyrightPtr)
  }

  public final fun getGlbData(): PackedByteArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlbDataPtr)
    return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
  }

  public final fun setGlbData(glbData: PackedByteArray): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_BYTE_ARRAY to glbData)
    TransferContext.callMethod(MethodBindings.setGlbDataPtr)
  }

  public final fun getUseNamedSkinBinds(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUseNamedSkinBindsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setUseNamedSkinBinds(useNamedSkinBinds: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to useNamedSkinBinds)
    TransferContext.callMethod(MethodBindings.setUseNamedSkinBindsPtr)
  }

  /**
   * Returns an array of all [GLTFNode]s in the glTF file. These are the nodes that
   * [GLTFNode.children] and [rootNodes] refer to. This includes nodes that may not be generated in the
   * Godot scene, or nodes that may generate multiple Godot scene nodes.
   */
  public final fun getNodes(): VariantArray<GLTFNode> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNodesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<GLTFNode>)
  }

  /**
   * Sets the [GLTFNode]s in the state. These are the nodes that [GLTFNode.children] and [rootNodes]
   * refer to. Some of the nodes set here may not be generated in the Godot scene, or may generate
   * multiple Godot scene nodes.
   */
  public final fun setNodes(nodes: VariantArray<GLTFNode>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to nodes)
    TransferContext.callMethod(MethodBindings.setNodesPtr)
  }

  public final fun getBuffers(): VariantArray<PackedByteArray> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBuffersPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<PackedByteArray>)
  }

  public final fun setBuffers(buffers: VariantArray<PackedByteArray>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to buffers)
    TransferContext.callMethod(MethodBindings.setBuffersPtr)
  }

  public final fun getBufferViews(): VariantArray<GLTFBufferView> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBufferViewsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<GLTFBufferView>)
  }

  public final fun setBufferViews(bufferViews: VariantArray<GLTFBufferView>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to bufferViews)
    TransferContext.callMethod(MethodBindings.setBufferViewsPtr)
  }

  public final fun getAccessors(): VariantArray<GLTFAccessor> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAccessorsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<GLTFAccessor>)
  }

  public final fun setAccessors(accessors: VariantArray<GLTFAccessor>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to accessors)
    TransferContext.callMethod(MethodBindings.setAccessorsPtr)
  }

  /**
   * Returns an array of all [GLTFMesh]es in the glTF file. These are the meshes that the
   * [GLTFNode.mesh] index refers to.
   */
  public final fun getMeshes(): VariantArray<GLTFMesh> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMeshesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<GLTFMesh>)
  }

  /**
   * Sets the [GLTFMesh]es in the state. These are the meshes that the [GLTFNode.mesh] index refers
   * to.
   */
  public final fun setMeshes(meshes: VariantArray<GLTFMesh>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to meshes)
    TransferContext.callMethod(MethodBindings.setMeshesPtr)
  }

  /**
   * Returns the number of [AnimationPlayer] nodes in this [GLTFState]. These nodes are only used
   * during the export process when converting Godot [AnimationPlayer] nodes to glTF animations.
   */
  public final fun getAnimationPlayersCount(animPlayerIndex: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to animPlayerIndex.toLong())
    TransferContext.callMethod(MethodBindings.getAnimationPlayersCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the [AnimationPlayer] node with the given index. These nodes are only used during the
   * export process when converting Godot [AnimationPlayer] nodes to glTF animations.
   */
  public final fun getAnimationPlayer(animPlayerIndex: Int): AnimationPlayer? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to animPlayerIndex.toLong())
    TransferContext.callMethod(MethodBindings.getAnimationPlayerPtr)
    return (TransferContext.readReturnValue(OBJECT) as AnimationPlayer?)
  }

  public final fun getMaterials(): VariantArray<Material> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaterialsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Material>)
  }

  public final fun setMaterials(materials: VariantArray<Material>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to materials)
    TransferContext.callMethod(MethodBindings.setMaterialsPtr)
  }

  public final fun getSceneName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSceneNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setSceneName(sceneName: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to sceneName)
    TransferContext.callMethod(MethodBindings.setSceneNamePtr)
  }

  public final fun getBasePath(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBasePathPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setBasePath(basePath: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to basePath)
    TransferContext.callMethod(MethodBindings.setBasePathPtr)
  }

  public final fun getFilename(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFilenamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setFilename(filename: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to filename)
    TransferContext.callMethod(MethodBindings.setFilenamePtr)
  }

  public final fun getRootNodes(): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRootNodesPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  public final fun setRootNodes(rootNodes: PackedInt32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_INT_32_ARRAY to rootNodes)
    TransferContext.callMethod(MethodBindings.setRootNodesPtr)
  }

  public final fun getTextures(): VariantArray<GLTFTexture> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTexturesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<GLTFTexture>)
  }

  public final fun setTextures(textures: VariantArray<GLTFTexture>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to textures)
    TransferContext.callMethod(MethodBindings.setTexturesPtr)
  }

  /**
   * Retrieves the array of texture samplers that are used by the textures contained in the glTF.
   */
  public final fun getTextureSamplers(): VariantArray<GLTFTextureSampler> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureSamplersPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<GLTFTextureSampler>)
  }

  /**
   * Sets the array of texture samplers that are used by the textures contained in the glTF.
   */
  public final fun setTextureSamplers(textureSamplers: VariantArray<GLTFTextureSampler>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to textureSamplers)
    TransferContext.callMethod(MethodBindings.setTextureSamplersPtr)
  }

  /**
   * Gets the images of the glTF file as an array of [Texture2D]s. These are the images that the
   * [GLTFTexture.srcImage] index refers to.
   */
  public final fun getImages(): VariantArray<Texture2D> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getImagesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Texture2D>)
  }

  /**
   * Sets the images in the state stored as an array of [Texture2D]s. This can be used during
   * export. These are the images that the [GLTFTexture.srcImage] index refers to.
   */
  public final fun setImages(images: VariantArray<Texture2D>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to images)
    TransferContext.callMethod(MethodBindings.setImagesPtr)
  }

  /**
   * Returns an array of all [GLTFSkin]s in the glTF file. These are the skins that the
   * [GLTFNode.skin] index refers to.
   */
  public final fun getSkins(): VariantArray<GLTFSkin> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkinsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<GLTFSkin>)
  }

  /**
   * Sets the [GLTFSkin]s in the state. These are the skins that the [GLTFNode.skin] index refers
   * to.
   */
  public final fun setSkins(skins: VariantArray<GLTFSkin>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to skins)
    TransferContext.callMethod(MethodBindings.setSkinsPtr)
  }

  /**
   * Returns an array of all [GLTFCamera]s in the glTF file. These are the cameras that the
   * [GLTFNode.camera] index refers to.
   */
  public final fun getCameras(): VariantArray<GLTFCamera> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCamerasPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<GLTFCamera>)
  }

  /**
   * Sets the [GLTFCamera]s in the state. These are the cameras that the [GLTFNode.camera] index
   * refers to.
   */
  public final fun setCameras(cameras: VariantArray<GLTFCamera>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to cameras)
    TransferContext.callMethod(MethodBindings.setCamerasPtr)
  }

  /**
   * Returns an array of all [GLTFLight]s in the glTF file. These are the lights that the
   * [GLTFNode.light] index refers to.
   */
  public final fun getLights(): VariantArray<GLTFLight> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLightsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<GLTFLight>)
  }

  /**
   * Sets the [GLTFLight]s in the state. These are the lights that the [GLTFNode.light] index refers
   * to.
   */
  public final fun setLights(lights: VariantArray<GLTFLight>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to lights)
    TransferContext.callMethod(MethodBindings.setLightsPtr)
  }

  /**
   * Returns an array of unique node names. This is used in both the import process and export
   * process.
   */
  public final fun getUniqueNames(): VariantArray<String> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUniqueNamesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<String>)
  }

  /**
   * Sets the unique node names in the state. This is used in both the import process and export
   * process.
   */
  public final fun setUniqueNames(uniqueNames: VariantArray<String>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to uniqueNames)
    TransferContext.callMethod(MethodBindings.setUniqueNamesPtr)
  }

  /**
   * Returns an array of unique animation names. This is only used during the import process.
   */
  public final fun getUniqueAnimationNames(): VariantArray<String> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUniqueAnimationNamesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<String>)
  }

  /**
   * Sets the unique animation names in the state. This is only used during the import process.
   */
  public final fun setUniqueAnimationNames(uniqueAnimationNames: VariantArray<String>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to uniqueAnimationNames)
    TransferContext.callMethod(MethodBindings.setUniqueAnimationNamesPtr)
  }

  /**
   * Returns an array of all [GLTFSkeleton]s in the glTF file. These are the skeletons that the
   * [GLTFNode.skeleton] index refers to.
   */
  public final fun getSkeletons(): VariantArray<GLTFSkeleton> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkeletonsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<GLTFSkeleton>)
  }

  /**
   * Sets the [GLTFSkeleton]s in the state. These are the skeletons that the [GLTFNode.skeleton]
   * index refers to.
   */
  public final fun setSkeletons(skeletons: VariantArray<GLTFSkeleton>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to skeletons)
    TransferContext.callMethod(MethodBindings.setSkeletonsPtr)
  }

  public final fun getCreateAnimations(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCreateAnimationsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCreateAnimations(createAnimations: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to createAnimations)
    TransferContext.callMethod(MethodBindings.setCreateAnimationsPtr)
  }

  public final fun getImportAsSkeletonBones(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getImportAsSkeletonBonesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setImportAsSkeletonBones(importAsSkeletonBones: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to importAsSkeletonBones)
    TransferContext.callMethod(MethodBindings.setImportAsSkeletonBonesPtr)
  }

  /**
   * Returns an array of all [GLTFAnimation]s in the glTF file. When importing, these will be
   * generated as animations in an [AnimationPlayer] node. When exporting, these will be generated from
   * Godot [AnimationPlayer] nodes.
   */
  public final fun getAnimations(): VariantArray<GLTFAnimation> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAnimationsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<GLTFAnimation>)
  }

  /**
   * Sets the [GLTFAnimation]s in the state. When importing, these will be generated as animations
   * in an [AnimationPlayer] node. When exporting, these will be generated from Godot [AnimationPlayer]
   * nodes.
   */
  public final fun setAnimations(animations: VariantArray<GLTFAnimation>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to animations)
    TransferContext.callMethod(MethodBindings.setAnimationsPtr)
  }

  /**
   * Returns the Godot scene node that corresponds to the same index as the [GLTFNode] it was
   * generated from. This is the inverse of [getNodeIndex]. Useful during the import process.
   *
   * **Note:** Not every [GLTFNode] will have a scene node generated, and not every generated scene
   * node will have a corresponding [GLTFNode]. If there is no scene node for this [GLTFNode] index,
   * `null` is returned.
   */
  public final fun getSceneNode(gltfNodeIndex: Int): Node? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to gltfNodeIndex.toLong())
    TransferContext.callMethod(MethodBindings.getSceneNodePtr)
    return (TransferContext.readReturnValue(OBJECT) as Node?)
  }

  /**
   * Returns the index of the [GLTFNode] corresponding to this Godot scene node. This is the inverse
   * of [getSceneNode]. Useful during the export process.
   *
   * **Note:** Not every Godot scene node will have a corresponding [GLTFNode], and not every
   * [GLTFNode] will have a scene node generated. If there is no [GLTFNode] index for this scene node,
   * `-1` is returned.
   */
  public final fun getNodeIndex(sceneNode: Node?): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to sceneNode)
    TransferContext.callMethod(MethodBindings.getNodeIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Gets additional arbitrary data in this [GLTFState] instance. This can be used to keep per-file
   * state data in [GLTFDocumentExtension] classes, which is important because they are stateless.
   *
   * The argument should be the [GLTFDocumentExtension] name (does not have to match the extension
   * name in the glTF file), and the return value can be anything you set. If nothing was set, the
   * return value is `null`.
   */
  public final fun getAdditionalData(extensionName: StringName): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to extensionName)
    TransferContext.callMethod(MethodBindings.getAdditionalDataPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Sets additional arbitrary data in this [GLTFState] instance. This can be used to keep per-file
   * state data in [GLTFDocumentExtension] classes, which is important because they are stateless.
   *
   * The first argument should be the [GLTFDocumentExtension] name (does not have to match the
   * extension name in the glTF file), and the second argument can be anything you want.
   */
  public final fun setAdditionalData(extensionName: StringName, additionalData: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to extensionName, ANY to additionalData)
    TransferContext.callMethod(MethodBindings.setAdditionalDataPtr)
  }

  public final fun getHandleBinaryImageMode(): HandleBinaryImageMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHandleBinaryImageModePtr)
    return HandleBinaryImageMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setHandleBinaryImageMode(method: HandleBinaryImageMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to method.value)
    TransferContext.callMethod(MethodBindings.setHandleBinaryImageModePtr)
  }

  public final fun setBakeFps(`value`: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to value)
    TransferContext.callMethod(MethodBindings.setBakeFpsPtr)
  }

  public final fun getBakeFps(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBakeFpsPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Deprecated untyped alias for [handleBinaryImageMode]. When importing a glTF file with
   * unimported raw binary images embedded inside of binary blob buffers, in data URIs, or separate
   * files not imported by Godot, this controls how the images are handled.
   */
  public final fun getHandleBinaryImage(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHandleBinaryImagePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Deprecated untyped alias for [handleBinaryImageMode]. When importing a glTF file with
   * unimported raw binary images embedded inside of binary blob buffers, in data URIs, or separate
   * files not imported by Godot, this controls how the images are handled.
   */
  public final fun setHandleBinaryImage(method: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to method.toLong())
    TransferContext.callMethod(MethodBindings.setHandleBinaryImagePtr)
  }

  /**
   * Gets additional arbitrary data in this [GLTFState] instance. This can be used to keep per-file
   * state data in [GLTFDocumentExtension] classes, which is important because they are stateless.
   *
   * The argument should be the [GLTFDocumentExtension] name (does not have to match the extension
   * name in the glTF file), and the return value can be anything you set. If nothing was set, the
   * return value is `null`.
   */
  public final fun getAdditionalData(extensionName: String): Any? =
      getAdditionalData(extensionName.asCachedStringName())

  /**
   * Sets additional arbitrary data in this [GLTFState] instance. This can be used to keep per-file
   * state data in [GLTFDocumentExtension] classes, which is important because they are stateless.
   *
   * The first argument should be the [GLTFDocumentExtension] name (does not have to match the
   * extension name in the glTF file), and the second argument can be anything you want.
   */
  public final fun setAdditionalData(extensionName: String, additionalData: Any?) =
      setAdditionalData(extensionName.asCachedStringName(), additionalData)

  public enum class HandleBinaryImageMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * When importing a glTF file with embedded binary images, discards all images and uses
     * untextured materials in their place. Images stored as separate files in the `res://` folder are
     * not affected by this; those will be used as Godot imported them.
     */
    DISCARD_TEXTURES(0),
    /**
     * When importing a glTF file with embedded binary images, extracts them and saves them to their
     * own files. This allows the image to be imported by Godot's image importer, which can then have
     * their import options customized by the user, including optionally compressing the image to VRAM
     * texture formats.
     *
     * This will save the images's bytes exactly as-is, without recompression. For image formats
     * supplied by glTF extensions, the file will have a filename ending with the file extension
     * supplied by [GLTFDocumentExtension.GetImageFileExtension] of the extension class.
     *
     * **Note:** This option is editor-only. At runtime, this acts the same as
     * [HANDLE_BINARY_IMAGE_MODE_EMBED_AS_UNCOMPRESSED].
     */
    EXTRACT_TEXTURES(1),
    /**
     * When importing a glTF file with embedded binary images, embeds textures VRAM compressed with
     * Basis Universal into the generated scene. Images stored as separate files in the `res://` folder
     * are not affected by this; those will be used as Godot imported them.
     */
    EMBED_AS_BASISU(2),
    /**
     * When importing a glTF file with embedded binary images, embeds textures compressed losslessly
     * into the generated scene. Images stored as separate files in the `res://` folder are not
     * affected by this; those will be used as Godot imported them.
     */
    EMBED_AS_UNCOMPRESSED(3),
    ;

    public companion object {
      public fun from(`value`: Long): HandleBinaryImageMode =
          entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val addUsedExtensionName: MethodStringName2<GLTFState, Unit, String, Boolean> =
        MethodStringName2<GLTFState, Unit, String, Boolean>("add_used_extension")

    @JvmField
    public val appendDataToBuffersName: MethodStringName2<GLTFState, Int, PackedByteArray, Boolean>
        = MethodStringName2<GLTFState, Int, PackedByteArray, Boolean>("append_data_to_buffers")

    @JvmField
    public val appendGltfNodeName: MethodStringName3<GLTFState, Int, GLTFNode?, Node?, Int> =
        MethodStringName3<GLTFState, Int, GLTFNode?, Node?, Int>("append_gltf_node")

    @JvmField
    public val getJsonName: MethodStringName0<GLTFState, Dictionary<Any?, Any?>> =
        MethodStringName0<GLTFState, Dictionary<Any?, Any?>>("get_json")

    @JvmField
    public val setJsonName: MethodStringName1<GLTFState, Unit, Dictionary<Any?, Any?>> =
        MethodStringName1<GLTFState, Unit, Dictionary<Any?, Any?>>("set_json")

    @JvmField
    public val getMajorVersionName: MethodStringName0<GLTFState, Int> =
        MethodStringName0<GLTFState, Int>("get_major_version")

    @JvmField
    public val setMajorVersionName: MethodStringName1<GLTFState, Unit, Int> =
        MethodStringName1<GLTFState, Unit, Int>("set_major_version")

    @JvmField
    public val getMinorVersionName: MethodStringName0<GLTFState, Int> =
        MethodStringName0<GLTFState, Int>("get_minor_version")

    @JvmField
    public val setMinorVersionName: MethodStringName1<GLTFState, Unit, Int> =
        MethodStringName1<GLTFState, Unit, Int>("set_minor_version")

    @JvmField
    public val getCopyrightName: MethodStringName0<GLTFState, String> =
        MethodStringName0<GLTFState, String>("get_copyright")

    @JvmField
    public val setCopyrightName: MethodStringName1<GLTFState, Unit, String> =
        MethodStringName1<GLTFState, Unit, String>("set_copyright")

    @JvmField
    public val getGlbDataName: MethodStringName0<GLTFState, PackedByteArray> =
        MethodStringName0<GLTFState, PackedByteArray>("get_glb_data")

    @JvmField
    public val setGlbDataName: MethodStringName1<GLTFState, Unit, PackedByteArray> =
        MethodStringName1<GLTFState, Unit, PackedByteArray>("set_glb_data")

    @JvmField
    public val getUseNamedSkinBindsName: MethodStringName0<GLTFState, Boolean> =
        MethodStringName0<GLTFState, Boolean>("get_use_named_skin_binds")

    @JvmField
    public val setUseNamedSkinBindsName: MethodStringName1<GLTFState, Unit, Boolean> =
        MethodStringName1<GLTFState, Unit, Boolean>("set_use_named_skin_binds")

    @JvmField
    public val getNodesName: MethodStringName0<GLTFState, VariantArray<GLTFNode>> =
        MethodStringName0<GLTFState, VariantArray<GLTFNode>>("get_nodes")

    @JvmField
    public val setNodesName: MethodStringName1<GLTFState, Unit, VariantArray<GLTFNode>> =
        MethodStringName1<GLTFState, Unit, VariantArray<GLTFNode>>("set_nodes")

    @JvmField
    public val getBuffersName: MethodStringName0<GLTFState, VariantArray<PackedByteArray>> =
        MethodStringName0<GLTFState, VariantArray<PackedByteArray>>("get_buffers")

    @JvmField
    public val setBuffersName: MethodStringName1<GLTFState, Unit, VariantArray<PackedByteArray>> =
        MethodStringName1<GLTFState, Unit, VariantArray<PackedByteArray>>("set_buffers")

    @JvmField
    public val getBufferViewsName: MethodStringName0<GLTFState, VariantArray<GLTFBufferView>> =
        MethodStringName0<GLTFState, VariantArray<GLTFBufferView>>("get_buffer_views")

    @JvmField
    public val setBufferViewsName: MethodStringName1<GLTFState, Unit, VariantArray<GLTFBufferView>>
        = MethodStringName1<GLTFState, Unit, VariantArray<GLTFBufferView>>("set_buffer_views")

    @JvmField
    public val getAccessorsName: MethodStringName0<GLTFState, VariantArray<GLTFAccessor>> =
        MethodStringName0<GLTFState, VariantArray<GLTFAccessor>>("get_accessors")

    @JvmField
    public val setAccessorsName: MethodStringName1<GLTFState, Unit, VariantArray<GLTFAccessor>> =
        MethodStringName1<GLTFState, Unit, VariantArray<GLTFAccessor>>("set_accessors")

    @JvmField
    public val getMeshesName: MethodStringName0<GLTFState, VariantArray<GLTFMesh>> =
        MethodStringName0<GLTFState, VariantArray<GLTFMesh>>("get_meshes")

    @JvmField
    public val setMeshesName: MethodStringName1<GLTFState, Unit, VariantArray<GLTFMesh>> =
        MethodStringName1<GLTFState, Unit, VariantArray<GLTFMesh>>("set_meshes")

    @JvmField
    public val getAnimationPlayersCountName: MethodStringName1<GLTFState, Int, Int> =
        MethodStringName1<GLTFState, Int, Int>("get_animation_players_count")

    @JvmField
    public val getAnimationPlayerName: MethodStringName1<GLTFState, AnimationPlayer?, Int> =
        MethodStringName1<GLTFState, AnimationPlayer?, Int>("get_animation_player")

    @JvmField
    public val getMaterialsName: MethodStringName0<GLTFState, VariantArray<Material>> =
        MethodStringName0<GLTFState, VariantArray<Material>>("get_materials")

    @JvmField
    public val setMaterialsName: MethodStringName1<GLTFState, Unit, VariantArray<Material>> =
        MethodStringName1<GLTFState, Unit, VariantArray<Material>>("set_materials")

    @JvmField
    public val getSceneNameName: MethodStringName0<GLTFState, String> =
        MethodStringName0<GLTFState, String>("get_scene_name")

    @JvmField
    public val setSceneNameName: MethodStringName1<GLTFState, Unit, String> =
        MethodStringName1<GLTFState, Unit, String>("set_scene_name")

    @JvmField
    public val getBasePathName: MethodStringName0<GLTFState, String> =
        MethodStringName0<GLTFState, String>("get_base_path")

    @JvmField
    public val setBasePathName: MethodStringName1<GLTFState, Unit, String> =
        MethodStringName1<GLTFState, Unit, String>("set_base_path")

    @JvmField
    public val getFilenameName: MethodStringName0<GLTFState, String> =
        MethodStringName0<GLTFState, String>("get_filename")

    @JvmField
    public val setFilenameName: MethodStringName1<GLTFState, Unit, String> =
        MethodStringName1<GLTFState, Unit, String>("set_filename")

    @JvmField
    public val getRootNodesName: MethodStringName0<GLTFState, PackedInt32Array> =
        MethodStringName0<GLTFState, PackedInt32Array>("get_root_nodes")

    @JvmField
    public val setRootNodesName: MethodStringName1<GLTFState, Unit, PackedInt32Array> =
        MethodStringName1<GLTFState, Unit, PackedInt32Array>("set_root_nodes")

    @JvmField
    public val getTexturesName: MethodStringName0<GLTFState, VariantArray<GLTFTexture>> =
        MethodStringName0<GLTFState, VariantArray<GLTFTexture>>("get_textures")

    @JvmField
    public val setTexturesName: MethodStringName1<GLTFState, Unit, VariantArray<GLTFTexture>> =
        MethodStringName1<GLTFState, Unit, VariantArray<GLTFTexture>>("set_textures")

    @JvmField
    public val getTextureSamplersName:
        MethodStringName0<GLTFState, VariantArray<GLTFTextureSampler>> =
        MethodStringName0<GLTFState, VariantArray<GLTFTextureSampler>>("get_texture_samplers")

    @JvmField
    public val setTextureSamplersName:
        MethodStringName1<GLTFState, Unit, VariantArray<GLTFTextureSampler>> =
        MethodStringName1<GLTFState, Unit, VariantArray<GLTFTextureSampler>>("set_texture_samplers")

    @JvmField
    public val getImagesName: MethodStringName0<GLTFState, VariantArray<Texture2D>> =
        MethodStringName0<GLTFState, VariantArray<Texture2D>>("get_images")

    @JvmField
    public val setImagesName: MethodStringName1<GLTFState, Unit, VariantArray<Texture2D>> =
        MethodStringName1<GLTFState, Unit, VariantArray<Texture2D>>("set_images")

    @JvmField
    public val getSkinsName: MethodStringName0<GLTFState, VariantArray<GLTFSkin>> =
        MethodStringName0<GLTFState, VariantArray<GLTFSkin>>("get_skins")

    @JvmField
    public val setSkinsName: MethodStringName1<GLTFState, Unit, VariantArray<GLTFSkin>> =
        MethodStringName1<GLTFState, Unit, VariantArray<GLTFSkin>>("set_skins")

    @JvmField
    public val getCamerasName: MethodStringName0<GLTFState, VariantArray<GLTFCamera>> =
        MethodStringName0<GLTFState, VariantArray<GLTFCamera>>("get_cameras")

    @JvmField
    public val setCamerasName: MethodStringName1<GLTFState, Unit, VariantArray<GLTFCamera>> =
        MethodStringName1<GLTFState, Unit, VariantArray<GLTFCamera>>("set_cameras")

    @JvmField
    public val getLightsName: MethodStringName0<GLTFState, VariantArray<GLTFLight>> =
        MethodStringName0<GLTFState, VariantArray<GLTFLight>>("get_lights")

    @JvmField
    public val setLightsName: MethodStringName1<GLTFState, Unit, VariantArray<GLTFLight>> =
        MethodStringName1<GLTFState, Unit, VariantArray<GLTFLight>>("set_lights")

    @JvmField
    public val getUniqueNamesName: MethodStringName0<GLTFState, VariantArray<String>> =
        MethodStringName0<GLTFState, VariantArray<String>>("get_unique_names")

    @JvmField
    public val setUniqueNamesName: MethodStringName1<GLTFState, Unit, VariantArray<String>> =
        MethodStringName1<GLTFState, Unit, VariantArray<String>>("set_unique_names")

    @JvmField
    public val getUniqueAnimationNamesName: MethodStringName0<GLTFState, VariantArray<String>> =
        MethodStringName0<GLTFState, VariantArray<String>>("get_unique_animation_names")

    @JvmField
    public val setUniqueAnimationNamesName: MethodStringName1<GLTFState, Unit, VariantArray<String>>
        = MethodStringName1<GLTFState, Unit, VariantArray<String>>("set_unique_animation_names")

    @JvmField
    public val getSkeletonsName: MethodStringName0<GLTFState, VariantArray<GLTFSkeleton>> =
        MethodStringName0<GLTFState, VariantArray<GLTFSkeleton>>("get_skeletons")

    @JvmField
    public val setSkeletonsName: MethodStringName1<GLTFState, Unit, VariantArray<GLTFSkeleton>> =
        MethodStringName1<GLTFState, Unit, VariantArray<GLTFSkeleton>>("set_skeletons")

    @JvmField
    public val getCreateAnimationsName: MethodStringName0<GLTFState, Boolean> =
        MethodStringName0<GLTFState, Boolean>("get_create_animations")

    @JvmField
    public val setCreateAnimationsName: MethodStringName1<GLTFState, Unit, Boolean> =
        MethodStringName1<GLTFState, Unit, Boolean>("set_create_animations")

    @JvmField
    public val getImportAsSkeletonBonesName: MethodStringName0<GLTFState, Boolean> =
        MethodStringName0<GLTFState, Boolean>("get_import_as_skeleton_bones")

    @JvmField
    public val setImportAsSkeletonBonesName: MethodStringName1<GLTFState, Unit, Boolean> =
        MethodStringName1<GLTFState, Unit, Boolean>("set_import_as_skeleton_bones")

    @JvmField
    public val getAnimationsName: MethodStringName0<GLTFState, VariantArray<GLTFAnimation>> =
        MethodStringName0<GLTFState, VariantArray<GLTFAnimation>>("get_animations")

    @JvmField
    public val setAnimationsName: MethodStringName1<GLTFState, Unit, VariantArray<GLTFAnimation>> =
        MethodStringName1<GLTFState, Unit, VariantArray<GLTFAnimation>>("set_animations")

    @JvmField
    public val getSceneNodeName: MethodStringName1<GLTFState, Node?, Int> =
        MethodStringName1<GLTFState, Node?, Int>("get_scene_node")

    @JvmField
    public val getNodeIndexName: MethodStringName1<GLTFState, Int, Node?> =
        MethodStringName1<GLTFState, Int, Node?>("get_node_index")

    @JvmField
    public val getAdditionalDataName: MethodStringName1<GLTFState, Any?, StringName> =
        MethodStringName1<GLTFState, Any?, StringName>("get_additional_data")

    @JvmField
    public val setAdditionalDataName: MethodStringName2<GLTFState, Unit, StringName, Any?> =
        MethodStringName2<GLTFState, Unit, StringName, Any?>("set_additional_data")

    @JvmField
    public val getHandleBinaryImageModeName: MethodStringName0<GLTFState, HandleBinaryImageMode> =
        MethodStringName0<GLTFState, HandleBinaryImageMode>("get_handle_binary_image_mode")

    @JvmField
    public val setHandleBinaryImageModeName:
        MethodStringName1<GLTFState, Unit, HandleBinaryImageMode> =
        MethodStringName1<GLTFState, Unit, HandleBinaryImageMode>("set_handle_binary_image_mode")

    @JvmField
    public val setBakeFpsName: MethodStringName1<GLTFState, Unit, Double> =
        MethodStringName1<GLTFState, Unit, Double>("set_bake_fps")

    @JvmField
    public val getBakeFpsName: MethodStringName0<GLTFState, Double> =
        MethodStringName0<GLTFState, Double>("get_bake_fps")

    @JvmField
    public val getHandleBinaryImageName: MethodStringName0<GLTFState, Int> =
        MethodStringName0<GLTFState, Int>("get_handle_binary_image")

    @JvmField
    public val setHandleBinaryImageName: MethodStringName1<GLTFState, Unit, Int> =
        MethodStringName1<GLTFState, Unit, Int>("set_handle_binary_image")

    /**
     * Discards all embedded textures and uses untextured materials.
     */
    public final const val HANDLE_BINARY_DISCARD_TEXTURES: Long = 0

    /**
     * Extracts embedded textures to be reimported and compressed. Editor only. Acts as uncompressed
     * at runtime.
     */
    public final const val HANDLE_BINARY_EXTRACT_TEXTURES: Long = 1

    /**
     * Embeds textures VRAM compressed with Basis Universal into the generated scene.
     */
    public final const val HANDLE_BINARY_EMBED_AS_BASISU: Long = 2

    /**
     * Embeds textures compressed losslessly into the generated scene, matching old behavior.
     */
    public final const val HANDLE_BINARY_EMBED_AS_UNCOMPRESSED: Long = 3
  }

  public object MethodBindings {
    internal val addUsedExtensionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "add_used_extension", 2678287736)

    internal val appendDataToBuffersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "append_data_to_buffers", 1460416665)

    internal val appendGltfNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "append_gltf_node", 3562288551)

    internal val getJsonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_json", 3102165223)

    internal val setJsonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_json", 4155329257)

    internal val getMajorVersionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_major_version", 3905245786)

    internal val setMajorVersionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_major_version", 1286410249)

    internal val getMinorVersionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_minor_version", 3905245786)

    internal val setMinorVersionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_minor_version", 1286410249)

    internal val getCopyrightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_copyright", 201670096)

    internal val setCopyrightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_copyright", 83702148)

    internal val getGlbDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_glb_data", 2362200018)

    internal val setGlbDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_glb_data", 2971499966)

    internal val getUseNamedSkinBindsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_use_named_skin_binds", 36873697)

    internal val setUseNamedSkinBindsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_use_named_skin_binds", 2586408642)

    internal val getNodesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_nodes", 3995934104)

    internal val setNodesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_nodes", 381264803)

    internal val getBuffersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_buffers", 3995934104)

    internal val setBuffersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_buffers", 381264803)

    internal val getBufferViewsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_buffer_views", 3995934104)

    internal val setBufferViewsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_buffer_views", 381264803)

    internal val getAccessorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_accessors", 3995934104)

    internal val setAccessorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_accessors", 381264803)

    internal val getMeshesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_meshes", 3995934104)

    internal val setMeshesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_meshes", 381264803)

    internal val getAnimationPlayersCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_animation_players_count", 923996154)

    internal val getAnimationPlayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_animation_player", 1550200483)

    internal val getMaterialsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_materials", 3995934104)

    internal val setMaterialsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_materials", 381264803)

    internal val getSceneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_scene_name", 201670096)

    internal val setSceneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_scene_name", 83702148)

    internal val getBasePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_base_path", 201670096)

    internal val setBasePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_base_path", 83702148)

    internal val getFilenamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_filename", 201670096)

    internal val setFilenamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_filename", 83702148)

    internal val getRootNodesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_root_nodes", 1930428628)

    internal val setRootNodesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_root_nodes", 3614634198)

    internal val getTexturesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_textures", 3995934104)

    internal val setTexturesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_textures", 381264803)

    internal val getTextureSamplersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_texture_samplers", 3995934104)

    internal val setTextureSamplersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_texture_samplers", 381264803)

    internal val getImagesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_images", 3995934104)

    internal val setImagesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_images", 381264803)

    internal val getSkinsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_skins", 3995934104)

    internal val setSkinsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_skins", 381264803)

    internal val getCamerasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_cameras", 3995934104)

    internal val setCamerasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_cameras", 381264803)

    internal val getLightsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_lights", 3995934104)

    internal val setLightsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_lights", 381264803)

    internal val getUniqueNamesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_unique_names", 3995934104)

    internal val setUniqueNamesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_unique_names", 381264803)

    internal val getUniqueAnimationNamesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_unique_animation_names", 3995934104)

    internal val setUniqueAnimationNamesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_unique_animation_names", 381264803)

    internal val getSkeletonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_skeletons", 3995934104)

    internal val setSkeletonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_skeletons", 381264803)

    internal val getCreateAnimationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_create_animations", 36873697)

    internal val setCreateAnimationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_create_animations", 2586408642)

    internal val getImportAsSkeletonBonesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_import_as_skeleton_bones", 36873697)

    internal val setImportAsSkeletonBonesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_import_as_skeleton_bones", 2586408642)

    internal val getAnimationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_animations", 3995934104)

    internal val setAnimationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_animations", 381264803)

    internal val getSceneNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_scene_node", 539202265)

    internal val getNodeIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_node_index", 3810805390)

    internal val getAdditionalDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_additional_data", 2760726917)

    internal val setAdditionalDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_additional_data", 3776071444)

    internal val getHandleBinaryImageModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_handle_binary_image_mode", 1363384196)

    internal val setHandleBinaryImageModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_handle_binary_image_mode", 854676334)

    internal val setBakeFpsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_bake_fps", 373806689)

    internal val getBakeFpsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_bake_fps", 1740695150)

    internal val getHandleBinaryImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "get_handle_binary_image", 3905245786)

    internal val setHandleBinaryImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFState", "set_handle_binary_image", 1286410249)
  }
}
