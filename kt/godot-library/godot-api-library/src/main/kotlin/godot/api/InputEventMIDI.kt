// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.MIDIMessage
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * InputEventMIDI stores information about messages from
 * [url=https://en.wikipedia.org/wiki/MIDI]MIDI[/url] (Musical Instrument Digital Interface) devices.
 * These may include musical keyboards, synthesizers, and drum machines.
 *
 * MIDI messages can be received over a 5-pin MIDI connector or over USB. If your device supports
 * both be sure to check the settings in the device to see which output it is using.
 *
 * By default, Godot does not detect MIDI devices. You need to call [OS.openMidiInputs], first. You
 * can check which devices are detected with [OS.getConnectedMidiInputs], and close the connection with
 * [OS.closeMidiInputs].
 *
 * ```gdscript
 * //gdscript
 * func _ready():
 * 	OS.open_midi_inputs()
 * 	print(OS.get_connected_midi_inputs())
 *
 * func _input(input_event):
 * 	if input_event is InputEventMIDI:
 * 		_print_midi_info(input_event)
 *
 * func _print_midi_info(midi_event):
 * 	print(midi_event)
 * 	print("Channel ", midi_event.channel)
 * 	print("Message ", midi_event.message)
 * 	print("Pitch ", midi_event.pitch)
 * 	print("Velocity ", midi_event.velocity)
 * 	print("Instrument ", midi_event.instrument)
 * 	print("Pressure ", midi_event.pressure)
 * 	print("Controller number: ", midi_event.controller_number)
 * 	print("Controller value: ", midi_event.controller_value)
 * ```
 *
 * ```csharp
 * //csharp
 * public override void _Ready()
 * {
 * 	OS.OpenMidiInputs();
 * 	GD.Print(OS.GetConnectedMidiInputs());
 * }
 *
 * public override void _Input(InputEvent inputEvent)
 * {
 * 	if (inputEvent is InputEventMidi midiEvent)
 * 	{
 * 		PrintMIDIInfo(midiEvent);
 * 	}
 * }
 *
 * private void PrintMIDIInfo(InputEventMidi midiEvent)
 * {
 * 	GD.Print(midiEvent);
 * 	GD.Print($"Channel {midiEvent.Channel}");
 * 	GD.Print($"Message {midiEvent.Message}");
 * 	GD.Print($"Pitch {midiEvent.Pitch}");
 * 	GD.Print($"Velocity {midiEvent.Velocity}");
 * 	GD.Print($"Instrument {midiEvent.Instrument}");
 * 	GD.Print($"Pressure {midiEvent.Pressure}");
 * 	GD.Print($"Controller number: {midiEvent.ControllerNumber}");
 * 	GD.Print($"Controller value: {midiEvent.ControllerValue}");
 * }
 * ```
 *
 * **Note:** Godot does not support MIDI output, so there is no way to emit MIDI messages from
 * Godot. Only MIDI input is supported.
 *
 * **Note:** On the Web platform, using MIDI input requires a browser permission to be granted
 * first. This permission request is performed when calling [OS.openMidiInputs]. MIDI input will not
 * work until the user accepts the permission request.
 */
@GodotBaseType
public open class InputEventMIDI : InputEvent() {
  /**
   * The MIDI channel of this message, ranging from `0` to `15`. MIDI channel `9` is reserved for
   * percussion instruments.
   */
  public final inline var channel: Int
    @JvmName("channelProperty")
    get() = getChannel()
    @JvmName("channelProperty")
    set(`value`) {
      setChannel(value)
    }

  /**
   * Represents the type of MIDI message (see the [MIDIMessage] enum).
   *
   * For more information, see the
   * [url=https://www.midi.org/specifications-old/item/table-2-expanded-messages-list-status-bytes]MIDI
   * message status byte list chart[/url].
   */
  public final inline var message: MIDIMessage
    @JvmName("messageProperty")
    get() = getMessage()
    @JvmName("messageProperty")
    set(`value`) {
      setMessage(value)
    }

  /**
   * The pitch index number of this MIDI message. This value ranges from `0` to `127`.
   *
   * On a piano, the **middle C** is `60`, followed by a **C-sharp** (`61`), then a **D** (`62`),
   * and so on. Each octave is split in offsets of 12. See the "MIDI note number" column of the
   * [url=https://en.wikipedia.org/wiki/Piano_key_frequencies]piano key frequency chart[/url] a full
   * list.
   */
  public final inline var pitch: Int
    @JvmName("pitchProperty")
    get() = getPitch()
    @JvmName("pitchProperty")
    set(`value`) {
      setPitch(value)
    }

  /**
   * The velocity of the MIDI message. This value ranges from `0` to `127`. For a musical keyboard,
   * this corresponds to how quickly the key was pressed, and is rarely above `110` in practice.
   *
   * **Note:** Some MIDI devices may send a [MIDI_MESSAGE_NOTE_ON] message with `0` velocity and
   * expect it to be treated the same as a [MIDI_MESSAGE_NOTE_OFF] message. If necessary, this can be
   * handled with a few lines of code:
   *
   * ```
   * func _input(event):
   * 	if event is InputEventMIDI:
   * 		if event.message == MIDI_MESSAGE_NOTE_ON and event.velocity > 0:
   * 			print("Note pressed!")
   * ```
   */
  public final inline var velocity: Int
    @JvmName("velocityProperty")
    get() = getVelocity()
    @JvmName("velocityProperty")
    set(`value`) {
      setVelocity(value)
    }

  /**
   * The instrument (also called *program* or *preset*) used on this MIDI message. This value ranges
   * from `0` to `127`.
   *
   * To see what each value means, refer to the
   * [url=https://en.wikipedia.org/wiki/General_MIDI#Program_change_events]General MIDI's instrument
   * list[/url]. Keep in mind that the list is off by 1 because it does not begin from 0. A value of
   * `0` corresponds to the acoustic grand piano.
   */
  public final inline var instrument: Int
    @JvmName("instrumentProperty")
    get() = getInstrument()
    @JvmName("instrumentProperty")
    set(`value`) {
      setInstrument(value)
    }

  /**
   * The strength of the key being pressed. This value ranges from `0` to `127`.
   *
   * **Note:** For many devices, this value is always `0`. Other devices such as musical keyboards
   * may simulate pressure by changing the [velocity], instead.
   */
  public final inline var pressure: Int
    @JvmName("pressureProperty")
    get() = getPressure()
    @JvmName("pressureProperty")
    set(`value`) {
      setPressure(value)
    }

  /**
   * The unique number of the controller, if [message] is [MIDI_MESSAGE_CONTROL_CHANGE], otherwise
   * this is `0`. This value can be used to identify sliders for volume, balance, and panning, as well
   * as switches and pedals on the MIDI device. See the
   * [url=https://en.wikipedia.org/wiki/General_MIDI#Controller_events]General MIDI specification[/url]
   * for a small list.
   */
  public final inline var controllerNumber: Int
    @JvmName("controllerNumberProperty")
    get() = getControllerNumber()
    @JvmName("controllerNumberProperty")
    set(`value`) {
      setControllerNumber(value)
    }

  /**
   * The value applied to the controller. If [message] is [MIDI_MESSAGE_CONTROL_CHANGE], this value
   * ranges from `0` to `127`, otherwise it is `0`. See also [controllerValue].
   */
  public final inline var controllerValue: Int
    @JvmName("controllerValueProperty")
    get() = getControllerValue()
    @JvmName("controllerValueProperty")
    set(`value`) {
      setControllerValue(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(315, scriptPtr)
  }

  public final fun setChannel(channel: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setChannelPtr, channel.toLong())
  }

  public final fun getChannel(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getChannelPtr).toInt()

  public final fun setMessage(message: MIDIMessage): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setMessagePtr, message.value)
  }

  public final fun getMessage(): MIDIMessage =
      MIDIMessage.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getMessagePtr))

  public final fun setPitch(pitch: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setPitchPtr, pitch.toLong())
  }

  public final fun getPitch(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getPitchPtr).toInt()

  public final fun setVelocity(velocity: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setVelocityPtr, velocity.toLong())
  }

  public final fun getVelocity(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getVelocityPtr).toInt()

  public final fun setInstrument(instrument: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setInstrumentPtr, instrument.toLong())
  }

  public final fun getInstrument(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getInstrumentPtr).toInt()

  public final fun setPressure(pressure: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setPressurePtr, pressure.toLong())
  }

  public final fun getPressure(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getPressurePtr).toInt()

  public final fun setControllerNumber(controllerNumber: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setControllerNumberPtr, controllerNumber.toLong())
  }

  public final fun getControllerNumber(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getControllerNumberPtr).toInt()

  public final fun setControllerValue(controllerValue: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setControllerValuePtr, controllerValue.toLong())
  }

  public final fun getControllerValue(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getControllerValuePtr).toInt()

  public companion object {
    @JvmField
    public val setChannelName: MethodStringName1<InputEventMIDI, Unit, Int> =
        MethodStringName1<InputEventMIDI, Unit, Int>("set_channel")

    @JvmField
    public val getChannelName: MethodStringName0<InputEventMIDI, Int> =
        MethodStringName0<InputEventMIDI, Int>("get_channel")

    @JvmField
    public val setMessageName: MethodStringName1<InputEventMIDI, Unit, MIDIMessage> =
        MethodStringName1<InputEventMIDI, Unit, MIDIMessage>("set_message")

    @JvmField
    public val getMessageName: MethodStringName0<InputEventMIDI, MIDIMessage> =
        MethodStringName0<InputEventMIDI, MIDIMessage>("get_message")

    @JvmField
    public val setPitchName: MethodStringName1<InputEventMIDI, Unit, Int> =
        MethodStringName1<InputEventMIDI, Unit, Int>("set_pitch")

    @JvmField
    public val getPitchName: MethodStringName0<InputEventMIDI, Int> =
        MethodStringName0<InputEventMIDI, Int>("get_pitch")

    @JvmField
    public val setVelocityName: MethodStringName1<InputEventMIDI, Unit, Int> =
        MethodStringName1<InputEventMIDI, Unit, Int>("set_velocity")

    @JvmField
    public val getVelocityName: MethodStringName0<InputEventMIDI, Int> =
        MethodStringName0<InputEventMIDI, Int>("get_velocity")

    @JvmField
    public val setInstrumentName: MethodStringName1<InputEventMIDI, Unit, Int> =
        MethodStringName1<InputEventMIDI, Unit, Int>("set_instrument")

    @JvmField
    public val getInstrumentName: MethodStringName0<InputEventMIDI, Int> =
        MethodStringName0<InputEventMIDI, Int>("get_instrument")

    @JvmField
    public val setPressureName: MethodStringName1<InputEventMIDI, Unit, Int> =
        MethodStringName1<InputEventMIDI, Unit, Int>("set_pressure")

    @JvmField
    public val getPressureName: MethodStringName0<InputEventMIDI, Int> =
        MethodStringName0<InputEventMIDI, Int>("get_pressure")

    @JvmField
    public val setControllerNumberName: MethodStringName1<InputEventMIDI, Unit, Int> =
        MethodStringName1<InputEventMIDI, Unit, Int>("set_controller_number")

    @JvmField
    public val getControllerNumberName: MethodStringName0<InputEventMIDI, Int> =
        MethodStringName0<InputEventMIDI, Int>("get_controller_number")

    @JvmField
    public val setControllerValueName: MethodStringName1<InputEventMIDI, Unit, Int> =
        MethodStringName1<InputEventMIDI, Unit, Int>("set_controller_value")

    @JvmField
    public val getControllerValueName: MethodStringName0<InputEventMIDI, Int> =
        MethodStringName0<InputEventMIDI, Int>("get_controller_value")
  }

  public object MethodBindings {
    internal val setChannelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMIDI", "set_channel", 1286410249)

    internal val getChannelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMIDI", "get_channel", 3905245786)

    internal val setMessagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMIDI", "set_message", 1064271510)

    internal val getMessagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMIDI", "get_message", 1936512097)

    internal val setPitchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMIDI", "set_pitch", 1286410249)

    internal val getPitchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMIDI", "get_pitch", 3905245786)

    internal val setVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMIDI", "set_velocity", 1286410249)

    internal val getVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMIDI", "get_velocity", 3905245786)

    internal val setInstrumentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMIDI", "set_instrument", 1286410249)

    internal val getInstrumentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMIDI", "get_instrument", 3905245786)

    internal val setPressurePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMIDI", "set_pressure", 1286410249)

    internal val getPressurePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMIDI", "get_pressure", 3905245786)

    internal val setControllerNumberPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMIDI", "set_controller_number", 1286410249)

    internal val getControllerNumberPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMIDI", "get_controller_number", 3905245786)

    internal val setControllerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMIDI", "set_controller_value", 1286410249)

    internal val getControllerValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMIDI", "get_controller_value", 3905245786)
  }
}
