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
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName2
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL_LONG
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * This class allows to compress or decompress data using GZIP/deflate in a streaming fashion. This
 * is particularly useful when compressing or decompressing files that have to be sent through the
 * network without needing to allocate them all in memory.
 *
 * After starting the stream via [startCompression] (or [startDecompression]), calling
 * [StreamPeer.putPartialData] on this stream will compress (or decompress) the data, writing it to the
 * internal buffer. Calling [StreamPeer.getAvailableBytes] will return the pending bytes in the
 * internal buffer, and [StreamPeer.getPartialData] will retrieve the compressed (or decompressed)
 * bytes from it. When the stream is over, you must call [finish] to ensure the internal buffer is
 * properly flushed (make sure to call [StreamPeer.getAvailableBytes] on last time to check if more
 * data needs to be read after that).
 */
@GodotBaseType
public open class StreamPeerGZIP : StreamPeer() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(710, scriptPtr)
  }

  /**
   * Start the stream in compression mode with the given [bufferSize], if [useDeflate] is `true`
   * uses deflate instead of GZIP.
   */
  @JvmOverloads
  public final fun startCompression(useDeflate: Boolean = false, bufferSize: Int = 65535): Error {
    TransferContext.writeMethodArguments_BOOL_LONG(ptr, objectID.id, useDeflate, bufferSize.toLong())
    TransferContext.callPtrMethod(MethodBindings.startCompressionPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Start the stream in decompression mode with the given [bufferSize], if [useDeflate] is `true`
   * uses deflate instead of GZIP.
   */
  @JvmOverloads
  public final fun startDecompression(useDeflate: Boolean = false, bufferSize: Int = 65535): Error {
    TransferContext.writeMethodArguments_BOOL_LONG(ptr, objectID.id, useDeflate, bufferSize.toLong())
    TransferContext.callPtrMethod(MethodBindings.startDecompressionPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Finalizes the stream, compressing any buffered chunk left.
   *
   * You must call it only when you are compressing.
   */
  public final fun finish(): Error {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.finishPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Clears this stream, resetting the internal state.
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearPtr, 0)
  }

  public companion object {
    @JvmField
    public val startCompressionName: MethodStringName2<StreamPeerGZIP, Error, Boolean, Int> =
        MethodStringName2<StreamPeerGZIP, Error, Boolean, Int>("start_compression")

    @JvmField
    public val startDecompressionName: MethodStringName2<StreamPeerGZIP, Error, Boolean, Int> =
        MethodStringName2<StreamPeerGZIP, Error, Boolean, Int>("start_decompression")

    @JvmField
    public val finishName: MethodStringName0<StreamPeerGZIP, Error> =
        MethodStringName0<StreamPeerGZIP, Error>("finish")

    @JvmField
    public val clearName: MethodStringName0<StreamPeerGZIP, Unit> =
        MethodStringName0<StreamPeerGZIP, Unit>("clear")
  }

  public object MethodBindings {
    internal val startCompressionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerGZIP", "start_compression", 781582770)

    internal val startDecompressionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerGZIP", "start_decompression", 781582770)

    internal val finishPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerGZIP", "finish", 166280745)

    internal val clearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerGZIP", "clear", 3218959716)
  }
}
