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
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_STRING
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Base resource type for all video streams. Classes that derive from [VideoStream] can all be used
 * as resource types to play back videos in [VideoStreamPlayer].
 */
@GodotBaseType
public abstract class VideoStream : Resource() {
  /**
   * The video file path or URI that this [VideoStream] resource handles.
   *
   * For [VideoStreamTheora], this filename should be an Ogg Theora video file with the `.ogv`
   * extension.
   */
  public final inline var `file`: String
    @JvmName("fileProperty")
    get() = getFile()
    @JvmName("fileProperty")
    set(`value`) {
      setFile(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(792, scriptPtr)
  }

  /**
   * Called when the video starts playing, to initialize and return a subclass of
   * [VideoStreamPlayback].
   */
  public abstract fun _instantiatePlayback(): VideoStreamPlayback?

  public final fun setFile(`file`: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, file)
    TransferContext.callMethod(MethodBindings.setFilePtr)
  }

  public final fun getFile(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFilePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public companion object {
    @JvmField
    public val setFileName: MethodStringName1<VideoStream, Unit, String> =
        MethodStringName1<VideoStream, Unit, String>("set_file")

    @JvmField
    public val getFileName: MethodStringName0<VideoStream, String> =
        MethodStringName0<VideoStream, String>("get_file")
  }

  public object MethodBindings {
    internal val setFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStream", "set_file", 83702148)

    internal val getFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStream", "get_file", 2841200299)
  }
}

internal class VideoStreamDummy : VideoStream() {
  public override fun _instantiatePlayback(): VideoStreamPlayback? {
    throw NotImplementedError("VideoStream::_instantiatePlayback is only implemented by non-JVM code.")
  }
}
