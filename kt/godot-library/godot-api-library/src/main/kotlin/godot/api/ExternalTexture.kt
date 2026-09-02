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
import godot.core.VariantParser.LONG
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Displays the content of an external buffer provided by the platform.
 *
 * Requires the
 * [url=https://registry.khronos.org/OpenGL/extensions/OES/OES_EGL_image_external.txt]OES_EGL_image_external[/url]
 * extension (OpenGL) or
 * [url=https://registry.khronos.org/vulkan/specs/1.1-extensions/html/vkspec.html#VK_ANDROID_external_memory_android_hardware_buffer]VK_ANDROID_external_memory_android_hardware_buffer[/url]
 * extension (Vulkan).
 *
 * **Note:** This is currently only supported in Android builds.
 */
@GodotBaseType
public open class ExternalTexture : Texture2D() {
  /**
   * External texture size.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var size: Vector2
    @JvmName("sizeProperty")
    get() = getSize()
    @JvmName("sizeProperty")
    set(`value`) {
      setSize(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(221, scriptPtr)
  }

  /**
   * This is a helper function for [size] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = externaltexture.size
   * //Your changes
   * externaltexture.size = myCoreType
   * ``````
   *
   * External texture size.
   */
  @CoreTypeHelper
  public final fun sizeMutate(block: Vector2.() -> Unit): Vector2 = size.apply {
     block(this)
     size = this
  }

  public final fun setSize(size: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to size)
    TransferContext.callMethod(MethodBindings.setSizePtr)
  }

  /**
   * Returns the external texture ID.
   *
   * Depending on your use case, you may need to pass this to platform APIs, for example, when
   * creating an `android.graphics.SurfaceTexture` on Android.
   */
  public final fun getExternalTextureId(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getExternalTextureIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the external buffer ID.
   *
   * Depending on your use case, you may need to call this with data received from a platform API,
   * for example, `SurfaceTexture.getHardwareBuffer()` on Android.
   */
  public final fun setExternalBufferId(externalBufferId: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to externalBufferId)
    TransferContext.callMethod(MethodBindings.setExternalBufferIdPtr)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("ExternalTexture::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("ExternalTexture::_getHeight can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setSizeName: MethodStringName1<ExternalTexture, Unit, Vector2> =
        MethodStringName1<ExternalTexture, Unit, Vector2>("set_size")

    @JvmField
    public val getExternalTextureIdName: MethodStringName0<ExternalTexture, Long> =
        MethodStringName0<ExternalTexture, Long>("get_external_texture_id")

    @JvmField
    public val setExternalBufferIdName: MethodStringName1<ExternalTexture, Unit, Long> =
        MethodStringName1<ExternalTexture, Unit, Long>("set_external_buffer_id")
  }

  public object MethodBindings {
    internal val setSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ExternalTexture", "set_size", 743155724)

    internal val getExternalTextureIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ExternalTexture", "get_external_texture_id", 3905245786)

    internal val setExternalBufferIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ExternalTexture", "set_external_buffer_id", 1286410249)
  }
}
