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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.PackedByteArray
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_PACKED_BYTE_ARRAY
import godot.writeMethodArguments_STRING_LONG
import godot.writeMethodArguments_STRING_LONG_LONG
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * This class implements a writer that allows storing the multiple blobs in a ZIP archive. See also
 * [ZIPReader] and [PCKPacker].
 *
 * ```
 * # Create a ZIP archive with a single file at its root.
 * func write_zip_file():
 * 	var writer = ZIPPacker.new()
 * 	var err = writer.open("user://archive.zip")
 * 	if err != OK:
 * 		return err
 * 	writer.start_file("hello.txt")
 * 	writer.write_file("Hello World".to_utf8_buffer())
 * 	writer.close_file()
 *
 * 	writer.close()
 * 	return OK
 * ```
 */
@GodotBaseType
public open class ZIPPacker : RefCounted() {
  /**
   * The compression level used when [startFile] is called. Use [ZIPPacker.CompressionLevel] as a
   * reference.
   */
  public final inline var compressionLevel: Int
    @JvmName("compressionLevelProperty")
    get() = getCompressionLevel()
    @JvmName("compressionLevelProperty")
    set(`value`) {
      setCompressionLevel(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(955, scriptPtr)
  }

  /**
   * Opens a zip file for writing at the given path using the specified write mode.
   *
   * This must be called before everything else.
   */
  @JvmOverloads
  public final fun `open`(path: String, append: ZipAppend = ZIPPacker.ZipAppend.APPEND_CREATE):
      Error {
    TransferContext.writeMethodArguments_STRING_LONG(ptr, objectID.id, path, append.value)
    TransferContext.callMethod(MethodBindings.openPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setCompressionLevel(compressionLevel: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, compressionLevel.toLong())
    TransferContext.callMethod(MethodBindings.setCompressionLevelPtr)
  }

  public final fun getCompressionLevel(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCompressionLevelPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Adds directory to the archive. If [modifiedTime] is set to `0`, current system time is used.
   *
   * **Note:** Directories are automatically created when [startFile] is called, use this function
   * before adding files to create directories with custom permissions and modification time.
   */
  @JvmOverloads
  public final fun addDirectory(
    path: String,
    permissions: FileAccess.UnixPermissionFlags = FileAccess.UnixPermissionFlags(493),
    modifiedTime: Long = 0,
  ): Error {
    TransferContext.writeMethodArguments_STRING_LONG_LONG(ptr, objectID.id, path, permissions.flag, modifiedTime)
    TransferContext.callMethod(MethodBindings.addDirectoryPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Starts writing to a file within the archive. Only one file can be written at the same time. If
   * [modifiedTime] is set to `0`, current system time is used.
   *
   * Must be called after [open].
   */
  @JvmOverloads
  public final fun startFile(
    path: String,
    permissions: FileAccess.UnixPermissionFlags = FileAccess.UnixPermissionFlags(420),
    modifiedTime: Long = 0,
  ): Error {
    TransferContext.writeMethodArguments_STRING_LONG_LONG(ptr, objectID.id, path, permissions.flag, modifiedTime)
    TransferContext.callMethod(MethodBindings.startFilePtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Write the given [data] to the file.
   *
   * Needs to be called after [startFile].
   */
  public final fun writeFile(`data`: PackedByteArray): Error {
    TransferContext.writeMethodArguments_PACKED_BYTE_ARRAY(ptr, objectID.id, data)
    TransferContext.callMethod(MethodBindings.writeFilePtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Stops writing to a file within the archive.
   *
   * It will fail if there is no open file.
   */
  public final fun closeFile(): Error {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.closeFilePtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Closes the underlying resources used by this instance.
   */
  public final fun close(): Error {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.closePtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  public enum class ZipAppend(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Create a new zip archive at the given path.
     */
    APPEND_CREATE(0),
    /**
     * Append a new zip archive to the end of the already existing file at the given path.
     */
    APPEND_CREATEAFTER(1),
    /**
     * Add new files to the existing zip archive at the given path.
     */
    APPEND_ADDINZIP(2),
    ;

    public companion object {
      public fun from(`value`: Long): ZipAppend = entries.single { it.`value` == `value` }
    }
  }

  public enum class CompressionLevel(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Start a file with the default Deflate compression level (`6`). This is a good compromise
     * between speed and file size.
     */
    DEFAULT(-1),
    /**
     * Start a file with no compression. This is also known as the "Store" compression mode and is
     * the fastest method of packing files inside a ZIP archive. Consider using this mode for files
     * that are already compressed (such as JPEG, PNG, MP3, or Ogg Vorbis files).
     */
    NONE(0),
    /**
     * Start a file with the fastest Deflate compression level (`1`). This is fast to compress, but
     * results in larger file sizes than [COMPRESSION_DEFAULT]. Decompression speed is generally
     * unaffected by the chosen compression level.
     */
    FAST(1),
    /**
     * Start a file with the best Deflate compression level (`9`). This is slow to compress, but
     * results in smaller file sizes than [COMPRESSION_DEFAULT]. Decompression speed is generally
     * unaffected by the chosen compression level.
     */
    BEST(9),
    ;

    public companion object {
      public fun from(`value`: Long): CompressionLevel = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val openName: MethodStringName2<ZIPPacker, Error, String, ZipAppend> =
        MethodStringName2<ZIPPacker, Error, String, ZipAppend>("open")

    @JvmField
    public val setCompressionLevelName: MethodStringName1<ZIPPacker, Unit, Int> =
        MethodStringName1<ZIPPacker, Unit, Int>("set_compression_level")

    @JvmField
    public val getCompressionLevelName: MethodStringName0<ZIPPacker, Int> =
        MethodStringName0<ZIPPacker, Int>("get_compression_level")

    @JvmField
    public val addDirectoryName:
        MethodStringName3<ZIPPacker, Error, String, FileAccess.UnixPermissionFlags, Long> =
        MethodStringName3<ZIPPacker, Error, String, FileAccess.UnixPermissionFlags, Long>("add_directory")

    @JvmField
    public val startFileName:
        MethodStringName3<ZIPPacker, Error, String, FileAccess.UnixPermissionFlags, Long> =
        MethodStringName3<ZIPPacker, Error, String, FileAccess.UnixPermissionFlags, Long>("start_file")

    @JvmField
    public val writeFileName: MethodStringName1<ZIPPacker, Error, PackedByteArray> =
        MethodStringName1<ZIPPacker, Error, PackedByteArray>("write_file")

    @JvmField
    public val closeFileName: MethodStringName0<ZIPPacker, Error> =
        MethodStringName0<ZIPPacker, Error>("close_file")

    @JvmField
    public val closeName: MethodStringName0<ZIPPacker, Error> =
        MethodStringName0<ZIPPacker, Error>("close")
  }

  public object MethodBindings {
    internal val openPtr: VoidPtr = TypeManager.getMethodBindPtr("ZIPPacker", "open", 1936816515)

    internal val setCompressionLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ZIPPacker", "set_compression_level", 1286410249)

    internal val getCompressionLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ZIPPacker", "get_compression_level", 3905245786)

    internal val addDirectoryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ZIPPacker", "add_directory", 934773537)

    internal val startFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ZIPPacker", "start_file", 4260848715)

    internal val writeFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ZIPPacker", "write_file", 680677267)

    internal val closeFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ZIPPacker", "close_file", 166280745)

    internal val closePtr: VoidPtr = TypeManager.getMethodBindPtr("ZIPPacker", "close", 166280745)
  }
}
