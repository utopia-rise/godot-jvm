package godot.annotation


/**
 * Define function's RPC (networking) capabilities.
 *
 * @param rpcMode see: [RpcMode]. Defaults to [RpcMode.AUTHORITY]
 * @param sync see: [Sync]. Defaults to [Sync.NO_SYNC]
 * @param transferMode see: [TransferMode]. Defaults to [TransferMode.RELIABLE]
 * @param transferChannel Should only be used in conjunction with [TransferMode.UNRELIABLE_ORDERED]! Will be ignored otherwise. Defaults to `0`
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Register
annotation class Rpc(
    val rpcMode: RpcMode = RpcMode.AUTHORITY,
    val sync: Sync = Sync.NO_SYNC,
    val transferMode: TransferMode = TransferMode.RELIABLE,
    val transferChannel: Int = 0
)

// the reason for not using the generated enums for RPCMode or TransferMode directly is the naming is inconsistent with the one, users are used to from GDScript and thus the documentation
/**
 * Defines the targets for rpc calls
 *
 * See: [RpcMode.DISABLED], [RpcMode.ANY], [RpcMode.AUTHORITY] for configuration information
 */
enum class RpcMode {
    /**
     * Rpc capabilities are disabled for this function
     */
    DISABLED,

    /**
     * Rpc calls for this function are sent to any connected peer
     */
    ANY,

    /**
     * Rpc calls for this function are only sent to the authority instance the connected peers (either a server or the host)
     */
    AUTHORITY
}

/**
 * Defines whether the local function should be called as well upon calling `rpc(my_function)` or if only remote peer functions should be called
 */
enum class Sync {
    /**
     * Call both local and remote peer functions upon invocation of `rpc(my_function)`
     */
    SYNC,

    /**
     * Call only remote peer functions upon invocation of `rpc(my_function)`
     */
    NO_SYNC
}

/**
 * Defines the transfer mode with which remote functions are called.
 *
 * See: [TransferMode.RELIABLE], [TransferMode.UNRELIABLE], [TransferMode.UNRELIABLE_ORDERED] for configuration information
 */
enum class TransferMode {
    /**
     * Slowest, most reliable
     *
     * Uses a TCP call under the hood which guarantees in-order arrival
     */
    RELIABLE,

    /**
     * Fastest, least reliable
     *
     * Uses a UDP call under the hood which is fast but does neither guarantee arrival nor the order of arrival
     */
    UNRELIABLE,

    /**
     * Fast, while guaranteeing order of arrival in same channel
     *
     * Uses a UDP call under the hood which is fast but does not guarantee arrival but guarantees arrival in order for specified channel.
     *
     * To be used in conjunction with `transferChannel` in [Rpc] annotation
     */
    UNRELIABLE_ORDERED
}
