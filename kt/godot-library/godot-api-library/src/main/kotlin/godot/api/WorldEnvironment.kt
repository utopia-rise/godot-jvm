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
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_OBJECT
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * The [WorldEnvironment] node is used to configure the default [Environment] for the scene.
 *
 * The parameters defined in the [WorldEnvironment] can be overridden by an [Environment] node set
 * on the current [Camera3D]. Additionally, only one [WorldEnvironment] may be instantiated in a given
 * scene at a time.
 *
 * The [WorldEnvironment] allows the user to specify default lighting parameters (e.g. ambient
 * lighting), various post-processing effects (e.g. SSAO, DOF, Tonemapping), and how to draw the
 * background (e.g. solid color, skybox). Usually, these are added in order to improve the
 * realism/color balance of the scene.
 */
@GodotBaseType
public open class WorldEnvironment : Node() {
  /**
   * The [Environment] resource used by this [WorldEnvironment], defining the default properties.
   */
  public final inline var environment: Environment?
    @JvmName("environmentProperty")
    get() = getEnvironment()
    @JvmName("environmentProperty")
    set(`value`) {
      setEnvironment(value)
    }

  /**
   * The default [CameraAttributes] resource to use if none set on the [Camera3D].
   */
  public final inline var cameraAttributes: CameraAttributes?
    @JvmName("cameraAttributesProperty")
    get() = getCameraAttributes()
    @JvmName("cameraAttributesProperty")
    set(`value`) {
      setCameraAttributes(value)
    }

  /**
   * The default [Compositor] resource to use if none set on the [Camera3D].
   */
  public final inline var compositor: Compositor?
    @JvmName("compositorProperty")
    get() = getCompositor()
    @JvmName("compositorProperty")
    set(`value`) {
      setCompositor(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(933, scriptPtr)
  }

  public final fun setEnvironment(env: Environment?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, env)
    TransferContext.callPtrMethod(MethodBindings.setEnvironmentPtr, 0)
  }

  public final fun getEnvironment(): Environment? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getEnvironmentPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Environment?)
  }

  public final fun setCameraAttributes(cameraAttributes: CameraAttributes?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, cameraAttributes)
    TransferContext.callPtrMethod(MethodBindings.setCameraAttributesPtr, 0)
  }

  public final fun getCameraAttributes(): CameraAttributes? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCameraAttributesPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as CameraAttributes?)
  }

  public final fun setCompositor(compositor: Compositor?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, compositor)
    TransferContext.callPtrMethod(MethodBindings.setCompositorPtr, 0)
  }

  public final fun getCompositor(): Compositor? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCompositorPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Compositor?)
  }

  public companion object {
    @JvmField
    public val setEnvironmentName: MethodStringName1<WorldEnvironment, Unit, Environment?> =
        MethodStringName1<WorldEnvironment, Unit, Environment?>("set_environment")

    @JvmField
    public val getEnvironmentName: MethodStringName0<WorldEnvironment, Environment?> =
        MethodStringName0<WorldEnvironment, Environment?>("get_environment")

    @JvmField
    public val setCameraAttributesName: MethodStringName1<WorldEnvironment, Unit, CameraAttributes?>
        = MethodStringName1<WorldEnvironment, Unit, CameraAttributes?>("set_camera_attributes")

    @JvmField
    public val getCameraAttributesName: MethodStringName0<WorldEnvironment, CameraAttributes?> =
        MethodStringName0<WorldEnvironment, CameraAttributes?>("get_camera_attributes")

    @JvmField
    public val setCompositorName: MethodStringName1<WorldEnvironment, Unit, Compositor?> =
        MethodStringName1<WorldEnvironment, Unit, Compositor?>("set_compositor")

    @JvmField
    public val getCompositorName: MethodStringName0<WorldEnvironment, Compositor?> =
        MethodStringName0<WorldEnvironment, Compositor?>("get_compositor")
  }

  public object MethodBindings {
    internal val setEnvironmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WorldEnvironment", "set_environment", 4143518816)

    internal val getEnvironmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WorldEnvironment", "get_environment", 3082064660)

    internal val setCameraAttributesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WorldEnvironment", "set_camera_attributes", 2817810567)

    internal val getCameraAttributesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WorldEnvironment", "get_camera_attributes", 3921283215)

    internal val setCompositorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WorldEnvironment", "set_compositor", 1586754307)

    internal val getCompositorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WorldEnvironment", "get_compositor", 3647707413)
  }
}
