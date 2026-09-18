// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.core

import kotlin.Long
import kotlin.Suppress
import kotlin.jvm.JvmField

public infix fun Long.or(other: ConnectFlags): Long = this.or(other.flag)

public infix fun Long.xor(other: ConnectFlags): Long = this.xor(other.flag)

public infix fun Long.and(other: ConnectFlags): Long = this.and(other.flag)

public class ConnectFlags(
  flag: Long,
) : BitFieldBase<ConnectFlags>(flag) {
  protected override fun wrap(flag: Long): ConnectFlags = ConnectFlags(flag)

  public companion object {
    /**
     * Default connections that are immediately emitted
     */
    @JvmField
    public val DEFAULT: ConnectFlags = ConnectFlags(0)

    /**
     * Deferred connections trigger their [Callable]s on idle time (at the end of the frame), rather
     * than instantly.
     */
    @JvmField
    public val DEFERRED: ConnectFlags = ConnectFlags(1)

    /**
     * Persisting connections are stored when the object is serialized (such as when using
     * [PackedScene.pack]). In the editor, connections created through the Signals dock are always
     * persisting.
     *
     * **Note:** Connections to lambda functions (that is, when the function code is embedded in the
     * [connect] call) cannot be made persistent.
     */
    @JvmField
    public val PERSIST: ConnectFlags = ConnectFlags(2)

    /**
     * One-shot connections disconnect themselves after emission.
     */
    @JvmField
    public val ONE_SHOT: ConnectFlags = ConnectFlags(4)

    /**
     * Reference-counted connections can be assigned to the same [Callable] multiple times. Each
     * disconnection decreases the internal counter. The signal fully disconnects only when the counter
     * reaches 0.
     */
    @JvmField
    public val REFERENCE_COUNTED: ConnectFlags = ConnectFlags(8)

    /**
     * On signal emission, the source object is automatically appended after the original arguments
     * of the signal, regardless of the connected [Callable]'s unbinds which affect only the original
     * arguments of the signal (see [Callable.unbind], [Callable.getUnboundArgumentsCount]).
     *
     * ```
     * extends Object
     *
     * signal test_signal
     *
     * func test():
     * 	print(self) # Prints e.g. <Object#35332818393>
     * 	test_signal.connect(prints.unbind(1), CONNECT_APPEND_SOURCE_OBJECT)
     * 	test_signal.emit("emit_arg_1", "emit_arg_2") # Prints emit_arg_1 <Object#35332818393>
     * ```
     */
    @JvmField
    public val APPEND_SOURCE_OBJECT: ConnectFlags = ConnectFlags(16)
  }
}
