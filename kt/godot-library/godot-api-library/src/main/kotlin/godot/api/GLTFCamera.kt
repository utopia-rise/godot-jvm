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
import godot.core.Dictionary
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_BOOL
import godot.readReturnValue_DICTIONARY
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DICTIONARY
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_OBJECT
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
  public final fun toNode(): Camera3D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.toNodePtr, 24)
    return (TransferContext.readReturnValue_OBJECT() as Camera3D?)
  }

  /**
   * Serializes this GLTFCamera instance into a [Dictionary].
   */
  public final fun toDictionary(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.toDictionaryPtr, 27)
    return (TransferContext.readReturnValue_DICTIONARY() as Dictionary<Any?, Any?>)
  }

  public final fun getPerspective(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPerspectivePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setPerspective(perspective: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, perspective)
    TransferContext.callPtrMethod(MethodBindings.setPerspectivePtr, 0)
  }

  public final fun getFov(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFovPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setFov(fov: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, fov.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setFovPtr, 0)
  }

  public final fun getSizeMag(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSizeMagPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setSizeMag(sizeMag: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, sizeMag.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setSizeMagPtr, 0)
  }

  public final fun getDepthFar(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDepthFarPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setDepthFar(zdepthFar: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, zdepthFar.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setDepthFarPtr, 0)
  }

  public final fun getDepthNear(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDepthNearPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setDepthNear(zdepthNear: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, zdepthNear.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setDepthNearPtr, 0)
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
    public final fun fromNode(cameraNode: Camera3D?): GLTFCamera? {
      TransferContext.writeMethodArguments_OBJECT(0L, 0L, cameraNode)
      TransferContext.callPtrMethod(MethodBindings.fromNodePtr, 39)
      return (TransferContext.readReturnValue_OBJECT() as GLTFCamera?)
    }

    /**
     * Creates a new GLTFCamera instance by parsing the given [Dictionary].
     */
    @JvmStatic
    public final fun fromDictionary(dictionary: Dictionary<Any?, Any?>): GLTFCamera? {
      TransferContext.writeMethodArguments_DICTIONARY(0L, 0L, dictionary)
      TransferContext.callPtrMethod(MethodBindings.fromDictionaryPtr, 39)
      return (TransferContext.readReturnValue_OBJECT() as GLTFCamera?)
    }
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
