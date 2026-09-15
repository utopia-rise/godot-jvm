// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit

/**
 * The base [Resource] for every audio effect. In the editor, an audio effect can be added to the
 * current bus layout through the Audio panel. At run-time, it is also possible to manipulate audio
 * effects through [AudioServer.addBusEffect], [AudioServer.removeBusEffect], and
 * [AudioServer.getBusEffect].
 *
 * When applied on a bus, an audio effect creates a corresponding [AudioEffectInstance]. The
 * instance is directly responsible for manipulating sound, based on the original audio effect's
 * properties.
 */
@GodotBaseType
public abstract class AudioEffect : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(46, scriptPtr)
  }

  /**
   * Override this method to customize the [AudioEffectInstance] created when this effect is applied
   * on a bus in the editor's Audio panel, or through [AudioServer.addBusEffect].
   *
   * ```
   * extends AudioEffect
   *
   * @export var strength = 4.0
   *
   * func _instantiate():
   * 	var effect = CustomAudioEffectInstance.new()
   * 	effect.base = self
   *
   * 	return effect
   * ```
   *
   * **Note:** It is recommended to keep a reference to the original [AudioEffect] in the new
   * instance. Depending on the implementation this allows the effect instance to listen for changes at
   * run-time and be modified accordingly.
   */
  public abstract fun _instantiate(): AudioEffectInstance?

  public companion object

  public object MethodBindings
}

internal class AudioEffectDummy : AudioEffect() {
  public override fun _instantiate(): AudioEffectInstance? {
    throw NotImplementedError("AudioEffect::_instantiate is only implemented by non-JVM code.")
  }
}
