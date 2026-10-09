// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.core

import kotlin.Long
import kotlin.Suppress

public enum class MIDIMessage(
  public override val `value`: Long,
) : GodotEnum {
  /**
   * Does not correspond to any MIDI message. This is the default value of [InputEventMIDI.message].
   */
  NONE(0),
  /**
   * MIDI message sent when a note is released.
   *
   * **Note:** Not all MIDI devices send this message; some may send [MIDI_MESSAGE_NOTE_ON] with
   * [InputEventMIDI.velocity] set to `0`.
   */
  NOTE_OFF(8),
  /**
   * MIDI message sent when a note is pressed.
   */
  NOTE_ON(9),
  /**
   * MIDI message sent to indicate a change in pressure while a note is being pressed down, also
   * called aftertouch.
   */
  AFTERTOUCH(10),
  /**
   * MIDI message sent when a controller value changes. In a MIDI device, a controller is any input
   * that doesn't play notes. These may include sliders for volume, balance, and panning, as well as
   * switches and pedals. See the
   * [url=https://en.wikipedia.org/wiki/General_MIDI#Controller_events]General MIDI specification[/url]
   * for a small list.
   */
  CONTROL_CHANGE(11),
  /**
   * MIDI message sent when the MIDI device changes its current instrument (also called *program* or
   * *preset*).
   */
  PROGRAM_CHANGE(12),
  /**
   * MIDI message sent to indicate a change in pressure for the whole channel. Some MIDI devices may
   * send this instead of [MIDI_MESSAGE_AFTERTOUCH].
   */
  CHANNEL_PRESSURE(13),
  /**
   * MIDI message sent when the value of the pitch bender changes, usually a wheel on the MIDI
   * device.
   */
  PITCH_BEND(14),
  /**
   * MIDI system exclusive (SysEx) message. This type of message is not standardized and it's highly
   * dependent on the MIDI device sending it.
   *
   * **Note:** Getting this message's data from [InputEventMIDI] is not implemented.
   */
  SYSTEM_EXCLUSIVE(240),
  /**
   * MIDI message sent every quarter frame to keep connected MIDI devices synchronized. Related to
   * [MIDI_MESSAGE_TIMING_CLOCK].
   *
   * **Note:** Getting this message's data from [InputEventMIDI] is not implemented.
   */
  QUARTER_FRAME(241),
  /**
   * MIDI message sent to jump onto a new position in the current sequence or song.
   *
   * **Note:** Getting this message's data from [InputEventMIDI] is not implemented.
   */
  SONG_POSITION_POINTER(242),
  /**
   * MIDI message sent to select a sequence or song to play.
   *
   * **Note:** Getting this message's data from [InputEventMIDI] is not implemented.
   */
  SONG_SELECT(243),
  /**
   * MIDI message sent to request a tuning calibration. Used on analog synthesizers. Most modern
   * MIDI devices do not need this message.
   */
  TUNE_REQUEST(246),
  /**
   * MIDI message sent 24 times after [MIDI_MESSAGE_QUARTER_FRAME], to keep connected MIDI devices
   * synchronized.
   */
  TIMING_CLOCK(248),
  /**
   * MIDI message sent to start the current sequence or song from the beginning.
   */
  START(250),
  /**
   * MIDI message sent to resume from the point the current sequence or song was paused.
   */
  CONTINUE(251),
  /**
   * MIDI message sent to pause the current sequence or song.
   */
  STOP(252),
  /**
   * MIDI message sent repeatedly while the MIDI device is idle, to tell the receiver that the
   * connection is alive. Most MIDI devices do not send this message.
   */
  ACTIVE_SENSING(254),
  /**
   * MIDI message sent to reset a MIDI device to its default state, as if it was just turned on. It
   * should not be sent when the MIDI device is being turned on.
   */
  SYSTEM_RESET(255),
  ;

  public companion object {
    public fun from(`value`: Long): MIDIMessage = entries.first { it.`value` == `value` }
  }
}
