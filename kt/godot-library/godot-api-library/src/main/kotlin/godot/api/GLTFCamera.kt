// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DICTIONARY
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_OBJECT
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DICTIONARY_ret_OBJECT_REF
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_OBJECT_ret_OBJECT_REF
import godot.common.interop.VoidPtr
import godot.core.Dictionary
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Any
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmStatic

/**
 * Represents a camera as defined by the base glTF spec.
 */
@GodotBaseType
public open class GLTFCamera : Resource() {
  /**
   * If `true`, the camera is in perspective mode. Otherwise, the camera is in
   * orthographic/orthogonal mode. This maps to glTF's camera `type` property. See
   * [Camera3D.projection] and the glTF spec for more information.
   */
  public final inline var perspective: Boolean
    @JvmName("perspectiveProperty")
    get() = getPerspective()
    @JvmName("perspectiveProperty")
    set(`value`) {
      setPerspective(value)
    }

  /**
   * The FOV of the camera. This class and glTF define the camera FOV in radians, while Godot uses
   * degrees. This maps to glTF's `yfov` property. This value is only used for perspective cameras,
   * when [perspective] is `true`.
   */
  public final inline var fov: Float
    @JvmName("fovProperty")
    get() = getFov()
    @JvmName("fovProperty")
    set(`value`) {
      setFov(value)
    }

  /**
   * The size of the camera. This class and glTF define the camera size magnitude as a radius in
   * meters, while Godot defines it as a diameter in meters. This maps to glTF's `ymag` property. This
   * value is only used for orthographic/orthogonal cameras, when [perspective] is `false`.
   */
  public final inline var sizeMag: Float
    @JvmName("sizeMagProperty")
    get() = getSizeMag()
    @JvmName("sizeMagProperty")
    set(`value`) {
      setSizeMag(value)
    }

  /**
   * The distance to the far culling boundary for this camera relative to its local Z axis, in
   * meters. This maps to glTF's `zfar` property.
   */
  public final inline var depthFar: Float
    @JvmName("depthFarProperty")
    get() = getDepthFar()
    @JvmName("depthFarProperty")
    set(`value`) {
      setDepthFar(value)
    }

  /**
   * The distance to the near culling boundary for this camera relative to its local Z axis, in
   * meters. This maps to glTF's `znear` property.
   */
  public final inline var depthNear: Float
    @JvmName("depthNearProperty")
    get() = getDepthNear()
    @JvmName("depthNearProperty")
    set(`value`) {
      setDepthNear(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(241, scriptPtr)
  }

  /**
   * Converts this GLTFCamera instance into a Godot [Camera3D] node.
   */
  public final fun toNode(): Camera3D? =
      (TransferContext.callPtrMethod0_ret_OBJECT(ptr, objectID.id, MethodBindings.toNodePtr) as Camera3D?)

  /**
   * Serializes this GLTFCamera instance into a [Dictionary].
   */
  public final fun toDictionary(): Dictionary<Any?, Any?> =
      (TransferContext.callPtrMethod0_ret_DICTIONARY(ptr, objectID.id, MethodBindings.toDictionaryPtr) as Dictionary<Any?, Any?>)

  public final fun getPerspective(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getPerspectivePtr)

  public final fun setPerspective(perspective: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setPerspectivePtr, perspective)
  }

  public final fun getFov(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getFovPtr).toFloat()

  public final fun setFov(fov: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setFovPtr, fov.toDouble())
  }

  public final fun getSizeMag(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getSizeMagPtr).toFloat()

  public final fun setSizeMag(sizeMag: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setSizeMagPtr, sizeMag.toDouble())
  }

  public final fun getDepthFar(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDepthFarPtr).toFloat()

  public final fun setDepthFar(zdepthFar: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setDepthFarPtr, zdepthFar.toDouble())
  }

  public final fun getDepthNear(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDepthNearPtr).toFloat()

  public final fun setDepthNear(zdepthNear: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setDepthNearPtr, zdepthNear.toDouble())
  }

  public companion object {
    @JvmField
    public val fromNodeName: MethodStringName1<GLTFCamera, GLTFCamera?, Camera3D?> =
        MethodStringName1<GLTFCamera, GLTFCamera?, Camera3D?>("from_node")

    @JvmField
    public val toNodeName: MethodStringName0<GLTFCamera, Camera3D?> =
        MethodStringName0<GLTFCamera, Camera3D?>("to_node")

    @JvmField
    public val fromDictionaryName:
        MethodStringName1<GLTFCamera, GLTFCamera?, Dictionary<Any?, Any?>> =
        MethodStringName1<GLTFCamera, GLTFCamera?, Dictionary<Any?, Any?>>("from_dictionary")

    @JvmField
    public val toDictionaryName: MethodStringName0<GLTFCamera, Dictionary<Any?, Any?>> =
        MethodStringName0<GLTFCamera, Dictionary<Any?, Any?>>("to_dictionary")

    @JvmField
    public val getPerspectiveName: MethodStringName0<GLTFCamera, Boolean> =
        MethodStringName0<GLTFCamera, Boolean>("get_perspective")

    @JvmField
    public val setPerspectiveName: MethodStringName1<GLTFCamera, Unit, Boolean> =
        MethodStringName1<GLTFCamera, Unit, Boolean>("set_perspective")

    @JvmField
    public val getFovName: MethodStringName0<GLTFCamera, Float> =
        MethodStringName0<GLTFCamera, Float>("get_fov")

    @JvmField
    public val setFovName: MethodStringName1<GLTFCamera, Unit, Float> =
        MethodStringName1<GLTFCamera, Unit, Float>("set_fov")

    @JvmField
    public val getSizeMagName: MethodStringName0<GLTFCamera, Float> =
        MethodStringName0<GLTFCamera, Float>("get_size_mag")

    @JvmField
    public val setSizeMagName: MethodStringName1<GLTFCamera, Unit, Float> =
        MethodStringName1<GLTFCamera, Unit, Float>("set_size_mag")

    @JvmField
    public val getDepthFarName: MethodStringName0<GLTFCamera, Float> =
        MethodStringName0<GLTFCamera, Float>("get_depth_far")

    @JvmField
    public val setDepthFarName: MethodStringName1<GLTFCamera, Unit, Float> =
        MethodStringName1<GLTFCamera, Unit, Float>("set_depth_far")

    @JvmField
    public val getDepthNearName: MethodStringName0<GLTFCamera, Float> =
        MethodStringName0<GLTFCamera, Float>("get_depth_near")

    @JvmField
    public val setDepthNearName: MethodStringName1<GLTFCamera, Unit, Float> =
        MethodStringName1<GLTFCamera, Unit, Float>("set_depth_near")

    /**
     * Create a new GLTFCamera instance from the given Godot [Camera3D] node.
     */
    @JvmStatic
    public final fun fromNode(cameraNode: Camera3D?): GLTFCamera? =
        (TransferContext.callPtrMethod_OBJECT_ret_OBJECT_REF(0L, 0L, MethodBindings.fromNodePtr, cameraNode) as GLTFCamera?)

    /**
     * Creates a new GLTFCamera instance by parsing the given [Dictionary].
     */
    @JvmStatic
    public final fun fromDictionary(dictionary: Dictionary<Any?, Any?>): GLTFCamera? =
        (TransferContext.callPtrMethod_DICTIONARY_ret_OBJECT_REF(0L, 0L, MethodBindings.fromDictionaryPtr, dictionary) as GLTFCamera?)
  }

  public object MethodBindings {
    internal val fromNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFCamera", "from_node", 237784)

    internal val toNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFCamera", "to_node", 2285090890)

    internal val fromDictionaryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFCamera", "from_dictionary", 2495512509)

    internal val toDictionaryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFCamera", "to_dictionary", 3102165223)

    internal val getPerspectivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFCamera", "get_perspective", 36873697)

    internal val setPerspectivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFCamera", "set_perspective", 2586408642)

    internal val getFovPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFCamera", "get_fov", 1740695150)

    internal val setFovPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFCamera", "set_fov", 373806689)

    internal val getSizeMagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFCamera", "get_size_mag", 1740695150)

    internal val setSizeMagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFCamera", "set_size_mag", 373806689)

    internal val getDepthFarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFCamera", "get_depth_far", 1740695150)

    internal val setDepthFarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFCamera", "set_depth_far", 373806689)

    internal val getDepthNearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFCamera", "get_depth_near", 1740695150)

    internal val setDepthNearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFCamera", "set_depth_near", 373806689)
  }
}
