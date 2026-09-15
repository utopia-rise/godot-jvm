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
import godot.readReturnValue_BOOL
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_STRING
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This is an internal editor class intended for keeping data of nodes of unknown type (most likely
 * this type was supplied by an extension that is no longer loaded). It can't be manually instantiated
 * or placed in a scene.
 *
 * **Warning:** Ignore missing nodes unless you know what you are doing. Existing properties on a
 * missing node can be freely modified in code, regardless of the type they are intended to be.
 */
@GodotBaseType
public open class MissingNode : Node() {
  /**
   * The name of the class this node was supposed to be (see [Object.getClass]).
   */
  public final inline var originalClass: String
    @JvmName("originalClassProperty")
    get() = getOriginalClass()
    @JvmName("originalClassProperty")
    set(`value`) {
      setOriginalClass(value)
    }

  /**
   * Returns the path of the scene this node was instance of originally.
   */
  public final inline var originalScene: String
    @JvmName("originalSceneProperty")
    get() = getOriginalScene()
    @JvmName("originalSceneProperty")
    set(`value`) {
      setOriginalScene(value)
    }

  /**
   * If `true`, allows new properties to be set along with existing ones. If `false`, only existing
   * properties' values can be set, and new properties cannot be added.
   */
  public final inline var recordingProperties: Boolean
    @JvmName("recordingPropertiesProperty")
    get() = isRecordingProperties()
    @JvmName("recordingPropertiesProperty")
    set(`value`) {
      setRecordingProperties(value)
    }

  /**
   * If `true`, allows new signals to be connected to along with existing ones. If `false`, only
   * existing signals can be connected to, and new signals cannot be added.
   */
  public final inline var recordingSignals: Boolean
    @JvmName("recordingSignalsProperty")
    get() = isRecordingSignals()
    @JvmName("recordingSignalsProperty")
    set(`value`) {
      setRecordingSignals(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(381, scriptPtr)
  }

  public final fun setOriginalClass(name: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.setOriginalClassPtr)
  }

  public final fun getOriginalClass(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOriginalClassPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setOriginalScene(name: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.setOriginalScenePtr)
  }

  public final fun getOriginalScene(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOriginalScenePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setRecordingProperties(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callMethod(MethodBindings.setRecordingPropertiesPtr)
  }

  public final fun isRecordingProperties(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isRecordingPropertiesPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setRecordingSignals(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callMethod(MethodBindings.setRecordingSignalsPtr)
  }

  public final fun isRecordingSignals(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isRecordingSignalsPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val setOriginalClassName: MethodStringName1<MissingNode, Unit, String> =
        MethodStringName1<MissingNode, Unit, String>("set_original_class")

    @JvmField
    public val getOriginalClassName: MethodStringName0<MissingNode, String> =
        MethodStringName0<MissingNode, String>("get_original_class")

    @JvmField
    public val setOriginalSceneName: MethodStringName1<MissingNode, Unit, String> =
        MethodStringName1<MissingNode, Unit, String>("set_original_scene")

    @JvmField
    public val getOriginalSceneName: MethodStringName0<MissingNode, String> =
        MethodStringName0<MissingNode, String>("get_original_scene")

    @JvmField
    public val setRecordingPropertiesName: MethodStringName1<MissingNode, Unit, Boolean> =
        MethodStringName1<MissingNode, Unit, Boolean>("set_recording_properties")

    @JvmField
    public val isRecordingPropertiesName: MethodStringName0<MissingNode, Boolean> =
        MethodStringName0<MissingNode, Boolean>("is_recording_properties")

    @JvmField
    public val setRecordingSignalsName: MethodStringName1<MissingNode, Unit, Boolean> =
        MethodStringName1<MissingNode, Unit, Boolean>("set_recording_signals")

    @JvmField
    public val isRecordingSignalsName: MethodStringName0<MissingNode, Boolean> =
        MethodStringName0<MissingNode, Boolean>("is_recording_signals")
  }

  public object MethodBindings {
    internal val setOriginalClassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MissingNode", "set_original_class", 83702148)

    internal val getOriginalClassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MissingNode", "get_original_class", 201670096)

    internal val setOriginalScenePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MissingNode", "set_original_scene", 83702148)

    internal val getOriginalScenePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MissingNode", "get_original_scene", 201670096)

    internal val setRecordingPropertiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MissingNode", "set_recording_properties", 2586408642)

    internal val isRecordingPropertiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MissingNode", "is_recording_properties", 36873697)

    internal val setRecordingSignalsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MissingNode", "set_recording_signals", 2586408642)

    internal val isRecordingSignalsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MissingNode", "is_recording_signals", 36873697)
  }
}
