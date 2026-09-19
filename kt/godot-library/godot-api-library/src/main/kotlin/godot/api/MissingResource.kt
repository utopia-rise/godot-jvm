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
import godot.callMethod_STRING
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod_BOOL
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This is an internal editor class intended for keeping data of resources of unknown type (most
 * likely this type was supplied by an extension that is no longer loaded). It can't be manually
 * instantiated or placed in a scene.
 *
 * **Warning:** Ignore missing resources unless you know what you are doing. Existing properties on
 * a missing resource can be freely modified in code, regardless of the type they are intended to be.
 */
@GodotBaseType
public open class MissingResource : Resource() {
  /**
   * The name of the class this resource was supposed to be (see [Object.getClass]).
   */
  public final inline var originalClass: String
    @JvmName("originalClassProperty")
    get() = getOriginalClass()
    @JvmName("originalClassProperty")
    set(`value`) {
      setOriginalClass(value)
    }

  /**
   * If set to `true`, allows new properties to be added on top of the existing ones with
   * [Object.set].
   */
  public final inline var recordingProperties: Boolean
    @JvmName("recordingPropertiesProperty")
    get() = isRecordingProperties()
    @JvmName("recordingPropertiesProperty")
    set(`value`) {
      setRecordingProperties(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(382, scriptPtr)
  }

  public final fun setOriginalClass(name: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setOriginalClassPtr, name)
  }

  public final fun getOriginalClass(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getOriginalClassPtr)

  public final fun setRecordingProperties(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setRecordingPropertiesPtr, enable)
  }

  public final fun isRecordingProperties(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isRecordingPropertiesPtr)

  public companion object {
    @JvmField
    public val setOriginalClassName: MethodStringName1<MissingResource, Unit, String> =
        MethodStringName1<MissingResource, Unit, String>("set_original_class")

    @JvmField
    public val getOriginalClassName: MethodStringName0<MissingResource, String> =
        MethodStringName0<MissingResource, String>("get_original_class")

    @JvmField
    public val setRecordingPropertiesName: MethodStringName1<MissingResource, Unit, Boolean> =
        MethodStringName1<MissingResource, Unit, Boolean>("set_recording_properties")

    @JvmField
    public val isRecordingPropertiesName: MethodStringName0<MissingResource, Boolean> =
        MethodStringName0<MissingResource, Boolean>("is_recording_properties")
  }

  public object MethodBindings {
    internal val setOriginalClassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MissingResource", "set_original_class", 83702148)

    internal val getOriginalClassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MissingResource", "get_original_class", 201670096)

    internal val setRecordingPropertiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MissingResource", "set_recording_properties", 2586408642)

    internal val isRecordingPropertiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MissingResource", "is_recording_properties", 36873697)
  }
}
