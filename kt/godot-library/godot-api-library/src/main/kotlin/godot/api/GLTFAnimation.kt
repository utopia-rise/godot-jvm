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
import godot.core.StringName
import godot.core.asCachedStringName
import godot.readReturnValue_ANY
import godot.readReturnValue_BOOL
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_ANY
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

@GodotBaseType
public open class GLTFAnimation : Resource() {
  /**
   * The original name of the animation.
   */
  public final inline var originalName: String
    @JvmName("originalNameProperty")
    get() = getOriginalName()
    @JvmName("originalNameProperty")
    set(`value`) {
      setOriginalName(value)
    }

  public final inline var loop: Boolean
    @JvmName("loopProperty")
    get() = getLoop()
    @JvmName("loopProperty")
    set(`value`) {
      setLoop(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(239, scriptPtr)
  }

  public final fun getOriginalName(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOriginalNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setOriginalName(originalName: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, originalName)
    TransferContext.callMethod(MethodBindings.setOriginalNamePtr)
  }

  public final fun getLoop(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getLoopPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setLoop(loop: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, loop)
    TransferContext.callPtrMethod(MethodBindings.setLoopPtr, 0)
  }

  /**
   * Gets additional arbitrary data in this [GLTFAnimation] instance. This can be used to keep
   * per-node state data in [GLTFDocumentExtension] classes, which is important because they are
   * stateless.
   *
   * The argument should be the [GLTFDocumentExtension] name (does not have to match the extension
   * name in the glTF file), and the return value can be anything you set. If nothing was set, the
   * return value is `null`.
   */
  public final fun getAdditionalData(extensionName: StringName): Any? {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, extensionName)
    TransferContext.callMethod(MethodBindings.getAdditionalDataPtr)
    return TransferContext.readReturnValue_ANY()
  }

  /**
   * Sets additional arbitrary data in this [GLTFAnimation] instance. This can be used to keep
   * per-node state data in [GLTFDocumentExtension] classes, which is important because they are
   * stateless.
   *
   * The first argument should be the [GLTFDocumentExtension] name (does not have to match the
   * extension name in the glTF file), and the second argument can be anything you want.
   */
  public final fun setAdditionalData(extensionName: StringName, additionalData: Any?): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_ANY(ptr, objectID.id, extensionName, additionalData)
    TransferContext.callMethod(MethodBindings.setAdditionalDataPtr)
  }

  /**
   * Gets additional arbitrary data in this [GLTFAnimation] instance. This can be used to keep
   * per-node state data in [GLTFDocumentExtension] classes, which is important because they are
   * stateless.
   *
   * The argument should be the [GLTFDocumentExtension] name (does not have to match the extension
   * name in the glTF file), and the return value can be anything you set. If nothing was set, the
   * return value is `null`.
   */
  public final fun getAdditionalData(extensionName: String): Any? =
      getAdditionalData(extensionName.asCachedStringName())

  /**
   * Sets additional arbitrary data in this [GLTFAnimation] instance. This can be used to keep
   * per-node state data in [GLTFDocumentExtension] classes, which is important because they are
   * stateless.
   *
   * The first argument should be the [GLTFDocumentExtension] name (does not have to match the
   * extension name in the glTF file), and the second argument can be anything you want.
   */
  public final fun setAdditionalData(extensionName: String, additionalData: Any?) =
      setAdditionalData(extensionName.asCachedStringName(), additionalData)

  public companion object {
    @JvmField
    public val getOriginalNameName: MethodStringName0<GLTFAnimation, String> =
        MethodStringName0<GLTFAnimation, String>("get_original_name")

    @JvmField
    public val setOriginalNameName: MethodStringName1<GLTFAnimation, Unit, String> =
        MethodStringName1<GLTFAnimation, Unit, String>("set_original_name")

    @JvmField
    public val getLoopName: MethodStringName0<GLTFAnimation, Boolean> =
        MethodStringName0<GLTFAnimation, Boolean>("get_loop")

    @JvmField
    public val setLoopName: MethodStringName1<GLTFAnimation, Unit, Boolean> =
        MethodStringName1<GLTFAnimation, Unit, Boolean>("set_loop")

    @JvmField
    public val getAdditionalDataName: MethodStringName1<GLTFAnimation, Any?, StringName> =
        MethodStringName1<GLTFAnimation, Any?, StringName>("get_additional_data")

    @JvmField
    public val setAdditionalDataName: MethodStringName2<GLTFAnimation, Unit, StringName, Any?> =
        MethodStringName2<GLTFAnimation, Unit, StringName, Any?>("set_additional_data")
  }

  public object MethodBindings {
    internal val getOriginalNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAnimation", "get_original_name", 2841200299)

    internal val setOriginalNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAnimation", "set_original_name", 83702148)

    internal val getLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAnimation", "get_loop", 36873697)

    internal val setLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAnimation", "set_loop", 2586408642)

    internal val getAdditionalDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAnimation", "get_additional_data", 2138907829)

    internal val setAdditionalDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFAnimation", "set_additional_data", 3776071444)
  }
}
