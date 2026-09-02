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
import godot.core.MethodStringName2
import godot.core.NodePath
import godot.core.PackedInt32Array
import godot.core.Quaternion
import godot.core.StringName
import godot.core.Transform3D
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.NODE_PATH
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.QUATERNION
import godot.core.VariantParser.STRING
import godot.core.VariantParser.STRING_NAME
import godot.core.VariantParser.TRANSFORM3D
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * Represents a glTF node. glTF nodes may have names, transforms, children (other glTF nodes), and
 * more specialized properties (represented by their own classes).
 *
 * glTF nodes generally exist inside of [GLTFState] which represents all data of a glTF file. Most
 * of GLTFNode's properties are indices of other data in the glTF file. You can extend a glTF node with
 * additional properties by using [getAdditionalData] and [setAdditionalData].
 */
@GodotBaseType
public open class GLTFNode : Resource() {
  /**
   * The original name of the node.
   */
  public final inline var originalName: String
    @JvmName("originalNameProperty")
    get() = getOriginalName()
    @JvmName("originalNameProperty")
    set(`value`) {
      setOriginalName(value)
    }

  /**
   * The index of the parent node in the [GLTFState]. If -1, this node is a root node.
   */
  public final inline var parent: Int
    @JvmName("parentProperty")
    get() = getParent()
    @JvmName("parentProperty")
    set(`value`) {
      setParent(value)
    }

  /**
   * How deep into the node hierarchy this node is. A root node will have a height of 0, its
   * children will have a height of 1, and so on. If -1, the height has not been calculated.
   */
  public final inline var height: Int
    @JvmName("heightProperty")
    get() = getHeight()
    @JvmName("heightProperty")
    set(`value`) {
      setHeight(value)
    }

  /**
   * The transform of the glTF node relative to its parent. This property is usually unused since
   * the position, rotation, and scale properties are preferred.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var xform: Transform3D
    @JvmName("xformProperty")
    get() = getXform()
    @JvmName("xformProperty")
    set(`value`) {
      setXform(value)
    }

  /**
   * If this glTF node is a mesh, the index of the [GLTFMesh] in the [GLTFState] that describes the
   * mesh's properties. If -1, this node is not a mesh.
   */
  public final inline var mesh: Int
    @JvmName("meshProperty")
    get() = getMesh()
    @JvmName("meshProperty")
    set(`value`) {
      setMesh(value)
    }

  /**
   * If this glTF node is a camera, the index of the [GLTFCamera] in the [GLTFState] that describes
   * the camera's properties. If `-1`, this node is not a camera.
   */
  public final inline var camera: Int
    @JvmName("cameraProperty")
    get() = getCamera()
    @JvmName("cameraProperty")
    set(`value`) {
      setCamera(value)
    }

  /**
   * If this glTF node has a skin, the index of the [GLTFSkin] in the [GLTFState] that describes the
   * skin's properties. If -1, this node does not have a skin.
   */
  public final inline var skin: Int
    @JvmName("skinProperty")
    get() = getSkin()
    @JvmName("skinProperty")
    set(`value`) {
      setSkin(value)
    }

  /**
   * If this glTF node has a skeleton, the index of the [GLTFSkeleton] in the [GLTFState] that
   * describes the skeleton's properties. If -1, this node does not have a skeleton.
   */
  public final inline var skeleton: Int
    @JvmName("skeletonProperty")
    get() = getSkeleton()
    @JvmName("skeletonProperty")
    set(`value`) {
      setSkeleton(value)
    }

  /**
   * The position of the glTF node relative to its parent.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var position: Vector3
    @JvmName("positionProperty")
    get() = getPosition()
    @JvmName("positionProperty")
    set(`value`) {
      setPosition(value)
    }

  /**
   * The rotation of the glTF node relative to its parent.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var rotation: Quaternion
    @JvmName("rotationProperty")
    get() = getRotation()
    @JvmName("rotationProperty")
    set(`value`) {
      setRotation(value)
    }

  /**
   * The scale of the glTF node relative to its parent.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var scale: Vector3
    @JvmName("scaleProperty")
    get() = getScale()
    @JvmName("scaleProperty")
    set(`value`) {
      setScale(value)
    }

  /**
   * The indices of the child nodes in the [GLTFState]. If this glTF node has no children, this will
   * be an empty array.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var children: PackedInt32Array
    @JvmName("childrenProperty")
    get() = getChildren()
    @JvmName("childrenProperty")
    set(`value`) {
      setChildren(value)
    }

  /**
   * If this glTF node is a light, the index of the [GLTFLight] in the [GLTFState] that describes
   * the light's properties. If -1, this node is not a light.
   */
  public final inline var light: Int
    @JvmName("lightProperty")
    get() = getLight()
    @JvmName("lightProperty")
    set(`value`) {
      setLight(value)
    }

  /**
   * If `true`, the GLTF node is visible. If `false`, the GLTF node is not visible. This is
   * converted to the [Node3D.visible] property in the Godot scene, and is exported to
   * `KHR_node_visibility` when `false`.
   */
  public final inline var visible: Boolean
    @JvmName("visibleProperty")
    get() = getVisible()
    @JvmName("visibleProperty")
    set(`value`) {
      setVisible(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(249, scriptPtr)
  }

  /**
   * This is a helper function for [xform] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfnode.xform
   * //Your changes
   * gltfnode.xform = myCoreType
   * ``````
   *
   * The transform of the glTF node relative to its parent. This property is usually unused since
   * the position, rotation, and scale properties are preferred.
   */
  @CoreTypeHelper
  public final fun xformMutate(block: Transform3D.() -> Unit): Transform3D = xform.apply {
     block(this)
     xform = this
  }

  /**
   * This is a helper function for [position] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfnode.position
   * //Your changes
   * gltfnode.position = myCoreType
   * ``````
   *
   * The position of the glTF node relative to its parent.
   */
  @CoreTypeHelper
  public final fun positionMutate(block: Vector3.() -> Unit): Vector3 = position.apply {
     block(this)
     position = this
  }

  /**
   * This is a helper function for [rotation] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfnode.rotation
   * //Your changes
   * gltfnode.rotation = myCoreType
   * ``````
   *
   * The rotation of the glTF node relative to its parent.
   */
  @CoreTypeHelper
  public final fun rotationMutate(block: Quaternion.() -> Unit): Quaternion = rotation.apply {
     block(this)
     rotation = this
  }

  /**
   * This is a helper function for [scale] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfnode.scale
   * //Your changes
   * gltfnode.scale = myCoreType
   * ``````
   *
   * The scale of the glTF node relative to its parent.
   */
  @CoreTypeHelper
  public final fun scaleMutate(block: Vector3.() -> Unit): Vector3 = scale.apply {
     block(this)
     scale = this
  }

  /**
   * This is a helper function for [children] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfnode.children
   * //Your changes
   * gltfnode.children = myCoreType
   * ``````
   *
   * The indices of the child nodes in the [GLTFState]. If this glTF node has no children, this will
   * be an empty array.
   */
  @CoreTypeHelper
  public final fun childrenMutate(block: PackedInt32Array.() -> Unit): PackedInt32Array =
      children.apply {
     block(this)
     children = this
  }

  /**
   * This is a helper function for [children] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The indices of the child nodes in the [GLTFState]. If this glTF node has no children, this will
   * be an empty array.
   */
  @CoreTypeHelper
  public final fun childrenMutateEach(block: (index: Int, `value`: Int) -> Unit): PackedInt32Array =
      children.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     children = this
  }

  public final fun getOriginalName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOriginalNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setOriginalName(originalName: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to originalName)
    TransferContext.callMethod(MethodBindings.setOriginalNamePtr)
  }

  public final fun getParent(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getParentPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setParent(parent: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to parent.toLong())
    TransferContext.callMethod(MethodBindings.setParentPtr)
  }

  public final fun getHeight(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHeightPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setHeight(height: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to height.toLong())
    TransferContext.callMethod(MethodBindings.setHeightPtr)
  }

  public final fun getXform(): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getXformPtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  public final fun setXform(xform: Transform3D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM3D to xform)
    TransferContext.callMethod(MethodBindings.setXformPtr)
  }

  public final fun getMesh(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMeshPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setMesh(mesh: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mesh.toLong())
    TransferContext.callMethod(MethodBindings.setMeshPtr)
  }

  public final fun getCamera(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCameraPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setCamera(camera: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to camera.toLong())
    TransferContext.callMethod(MethodBindings.setCameraPtr)
  }

  public final fun getSkin(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkinPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setSkin(skin: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to skin.toLong())
    TransferContext.callMethod(MethodBindings.setSkinPtr)
  }

  public final fun getSkeleton(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkeletonPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setSkeleton(skeleton: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to skeleton.toLong())
    TransferContext.callMethod(MethodBindings.setSkeletonPtr)
  }

  public final fun getPosition(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPositionPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setPosition(position: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to position)
    TransferContext.callMethod(MethodBindings.setPositionPtr)
  }

  public final fun getRotation(): Quaternion {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRotationPtr)
    return (TransferContext.readReturnValue(QUATERNION) as Quaternion)
  }

  public final fun setRotation(rotation: Quaternion): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, QUATERNION to rotation)
    TransferContext.callMethod(MethodBindings.setRotationPtr)
  }

  public final fun getScale(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScalePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setScale(scale: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to scale)
    TransferContext.callMethod(MethodBindings.setScalePtr)
  }

  public final fun getChildren(): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getChildrenPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  public final fun setChildren(children: PackedInt32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_INT_32_ARRAY to children)
    TransferContext.callMethod(MethodBindings.setChildrenPtr)
  }

  /**
   * Appends the given child node index to the [children] array.
   */
  public final fun appendChildIndex(childIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to childIndex.toLong())
    TransferContext.callMethod(MethodBindings.appendChildIndexPtr)
  }

  public final fun getLight(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLightPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setLight(light: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to light.toLong())
    TransferContext.callMethod(MethodBindings.setLightPtr)
  }

  public final fun getVisible(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisiblePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setVisible(visible: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to visible)
    TransferContext.callMethod(MethodBindings.setVisiblePtr)
  }

  /**
   * Gets additional arbitrary data in this [GLTFNode] instance. This can be used to keep per-node
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
   * Sets additional arbitrary data in this [GLTFNode] instance. This can be used to keep per-node
   * state data in [GLTFDocumentExtension] classes, which is important because they are stateless.
   *
   * The first argument should be the [GLTFDocumentExtension] name (does not have to match the
   * extension name in the glTF file), and the second argument can be anything you want.
   */
  public final fun setAdditionalData(extensionName: StringName, additionalData: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to extensionName, ANY to additionalData)
    TransferContext.callMethod(MethodBindings.setAdditionalDataPtr)
  }

  /**
   * Returns the [NodePath] that this GLTF node will have in the Godot scene tree after being
   * imported. This is useful when importing glTF object model pointers with [GLTFObjectModelProperty],
   * for handling extensions such as `KHR_animation_pointer` or `KHR_interactivity`.
   *
   * If [handleSkeletons] is `true`, paths to skeleton bone glTF nodes will be resolved properly.
   * For example, a path that would be `^"A/B/C/Bone1/Bone2/Bone3"` if `false` will become
   * `^"A/B/C/Skeleton3D:Bone3"`.
   */
  @JvmOverloads
  public final fun getSceneNodePath(gltfState: GLTFState?, handleSkeletons: Boolean = true):
      NodePath {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to gltfState, BOOL to handleSkeletons)
    TransferContext.callMethod(MethodBindings.getSceneNodePathPtr)
    return (TransferContext.readReturnValue(NODE_PATH) as NodePath)
  }

  /**
   * Gets additional arbitrary data in this [GLTFNode] instance. This can be used to keep per-node
   * state data in [GLTFDocumentExtension] classes, which is important because they are stateless.
   *
   * The argument should be the [GLTFDocumentExtension] name (does not have to match the extension
   * name in the glTF file), and the return value can be anything you set. If nothing was set, the
   * return value is `null`.
   */
  public final fun getAdditionalData(extensionName: String): Any? =
      getAdditionalData(extensionName.asCachedStringName())

  /**
   * Sets additional arbitrary data in this [GLTFNode] instance. This can be used to keep per-node
   * state data in [GLTFDocumentExtension] classes, which is important because they are stateless.
   *
   * The first argument should be the [GLTFDocumentExtension] name (does not have to match the
   * extension name in the glTF file), and the second argument can be anything you want.
   */
  public final fun setAdditionalData(extensionName: String, additionalData: Any?) =
      setAdditionalData(extensionName.asCachedStringName(), additionalData)

  public companion object {
    @JvmField
    public val getOriginalNameName: MethodStringName0<GLTFNode, String> =
        MethodStringName0<GLTFNode, String>("get_original_name")

    @JvmField
    public val setOriginalNameName: MethodStringName1<GLTFNode, Unit, String> =
        MethodStringName1<GLTFNode, Unit, String>("set_original_name")

    @JvmField
    public val getParentName: MethodStringName0<GLTFNode, Int> =
        MethodStringName0<GLTFNode, Int>("get_parent")

    @JvmField
    public val setParentName: MethodStringName1<GLTFNode, Unit, Int> =
        MethodStringName1<GLTFNode, Unit, Int>("set_parent")

    @JvmField
    public val getHeightName: MethodStringName0<GLTFNode, Int> =
        MethodStringName0<GLTFNode, Int>("get_height")

    @JvmField
    public val setHeightName: MethodStringName1<GLTFNode, Unit, Int> =
        MethodStringName1<GLTFNode, Unit, Int>("set_height")

    @JvmField
    public val getXformName: MethodStringName0<GLTFNode, Transform3D> =
        MethodStringName0<GLTFNode, Transform3D>("get_xform")

    @JvmField
    public val setXformName: MethodStringName1<GLTFNode, Unit, Transform3D> =
        MethodStringName1<GLTFNode, Unit, Transform3D>("set_xform")

    @JvmField
    public val getMeshName: MethodStringName0<GLTFNode, Int> =
        MethodStringName0<GLTFNode, Int>("get_mesh")

    @JvmField
    public val setMeshName: MethodStringName1<GLTFNode, Unit, Int> =
        MethodStringName1<GLTFNode, Unit, Int>("set_mesh")

    @JvmField
    public val getCameraName: MethodStringName0<GLTFNode, Int> =
        MethodStringName0<GLTFNode, Int>("get_camera")

    @JvmField
    public val setCameraName: MethodStringName1<GLTFNode, Unit, Int> =
        MethodStringName1<GLTFNode, Unit, Int>("set_camera")

    @JvmField
    public val getSkinName: MethodStringName0<GLTFNode, Int> =
        MethodStringName0<GLTFNode, Int>("get_skin")

    @JvmField
    public val setSkinName: MethodStringName1<GLTFNode, Unit, Int> =
        MethodStringName1<GLTFNode, Unit, Int>("set_skin")

    @JvmField
    public val getSkeletonName: MethodStringName0<GLTFNode, Int> =
        MethodStringName0<GLTFNode, Int>("get_skeleton")

    @JvmField
    public val setSkeletonName: MethodStringName1<GLTFNode, Unit, Int> =
        MethodStringName1<GLTFNode, Unit, Int>("set_skeleton")

    @JvmField
    public val getPositionName: MethodStringName0<GLTFNode, Vector3> =
        MethodStringName0<GLTFNode, Vector3>("get_position")

    @JvmField
    public val setPositionName: MethodStringName1<GLTFNode, Unit, Vector3> =
        MethodStringName1<GLTFNode, Unit, Vector3>("set_position")

    @JvmField
    public val getRotationName: MethodStringName0<GLTFNode, Quaternion> =
        MethodStringName0<GLTFNode, Quaternion>("get_rotation")

    @JvmField
    public val setRotationName: MethodStringName1<GLTFNode, Unit, Quaternion> =
        MethodStringName1<GLTFNode, Unit, Quaternion>("set_rotation")

    @JvmField
    public val getScaleName: MethodStringName0<GLTFNode, Vector3> =
        MethodStringName0<GLTFNode, Vector3>("get_scale")

    @JvmField
    public val setScaleName: MethodStringName1<GLTFNode, Unit, Vector3> =
        MethodStringName1<GLTFNode, Unit, Vector3>("set_scale")

    @JvmField
    public val getChildrenName: MethodStringName0<GLTFNode, PackedInt32Array> =
        MethodStringName0<GLTFNode, PackedInt32Array>("get_children")

    @JvmField
    public val setChildrenName: MethodStringName1<GLTFNode, Unit, PackedInt32Array> =
        MethodStringName1<GLTFNode, Unit, PackedInt32Array>("set_children")

    @JvmField
    public val appendChildIndexName: MethodStringName1<GLTFNode, Unit, Int> =
        MethodStringName1<GLTFNode, Unit, Int>("append_child_index")

    @JvmField
    public val getLightName: MethodStringName0<GLTFNode, Int> =
        MethodStringName0<GLTFNode, Int>("get_light")

    @JvmField
    public val setLightName: MethodStringName1<GLTFNode, Unit, Int> =
        MethodStringName1<GLTFNode, Unit, Int>("set_light")

    @JvmField
    public val getVisibleName: MethodStringName0<GLTFNode, Boolean> =
        MethodStringName0<GLTFNode, Boolean>("get_visible")

    @JvmField
    public val setVisibleName: MethodStringName1<GLTFNode, Unit, Boolean> =
        MethodStringName1<GLTFNode, Unit, Boolean>("set_visible")

    @JvmField
    public val getAdditionalDataName: MethodStringName1<GLTFNode, Any?, StringName> =
        MethodStringName1<GLTFNode, Any?, StringName>("get_additional_data")

    @JvmField
    public val setAdditionalDataName: MethodStringName2<GLTFNode, Unit, StringName, Any?> =
        MethodStringName2<GLTFNode, Unit, StringName, Any?>("set_additional_data")

    @JvmField
    public val getSceneNodePathName: MethodStringName2<GLTFNode, NodePath, GLTFState?, Boolean> =
        MethodStringName2<GLTFNode, NodePath, GLTFState?, Boolean>("get_scene_node_path")
  }

  public object MethodBindings {
    internal val getOriginalNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "get_original_name", 2841200299)

    internal val setOriginalNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "set_original_name", 83702148)

    internal val getParentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "get_parent", 2455072627)

    internal val setParentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "set_parent", 1286410249)

    internal val getHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "get_height", 2455072627)

    internal val setHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "set_height", 1286410249)

    internal val getXformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "get_xform", 4183770049)

    internal val setXformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "set_xform", 2952846383)

    internal val getMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "get_mesh", 2455072627)

    internal val setMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "set_mesh", 1286410249)

    internal val getCameraPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "get_camera", 2455072627)

    internal val setCameraPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "set_camera", 1286410249)

    internal val getSkinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "get_skin", 2455072627)

    internal val setSkinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "set_skin", 1286410249)

    internal val getSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "get_skeleton", 2455072627)

    internal val setSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "set_skeleton", 1286410249)

    internal val getPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "get_position", 3783033775)

    internal val setPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "set_position", 3460891852)

    internal val getRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "get_rotation", 2916281908)

    internal val setRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "set_rotation", 1727505552)

    internal val getScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "get_scale", 3783033775)

    internal val setScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "set_scale", 3460891852)

    internal val getChildrenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "get_children", 969006518)

    internal val setChildrenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "set_children", 3614634198)

    internal val appendChildIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "append_child_index", 1286410249)

    internal val getLightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "get_light", 2455072627)

    internal val setLightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "set_light", 1286410249)

    internal val getVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "get_visible", 2240911060)

    internal val setVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "set_visible", 2586408642)

    internal val getAdditionalDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "get_additional_data", 2138907829)

    internal val setAdditionalDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "set_additional_data", 3776071444)

    internal val getSceneNodePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFNode", "get_scene_node_path", 573359477)
  }
}
