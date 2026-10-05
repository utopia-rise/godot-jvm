// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_STRING_BOOL_ret_BOOL
import godot.callMethod_STRING_BOOL_ret_LONG
import godot.callMethod_STRING_BOOL_ret_PACKED_BYTE_ARRAY
import godot.callMethod_STRING_ret_LONG
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_PACKED_STRING_ARRAY
import godot.common.interop.VoidPtr
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedByteArray
import godot.core.PackedStringArray
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * This class implements a reader that can extract the content of individual files inside a ZIP
 * archive. See also [ZIPPacker].
 *
 * ```
 * # Read a single file from a ZIP archive.
 * func read_zip_file():
 * 	var reader = ZIPReader.new()
 * 	var err = reader.open("user://archive.zip")
 * 	if err != OK:
 * 		return PackedByteArray()
 * 	var res = reader.read_file("hello.txt")
 * 	reader.close()
 * 	return res
 *
 * # Extract all files from a ZIP archive, preserving the directories within.
 * # This acts like the "Extract all" functionality from most archive managers.
 * func extract_all_from_zip():
 * 	var reader = ZIPReader.new()
 * 	reader.open("res://archive.zip")
 *
 * 	# Destination directory for the extracted files (this folder must exist before extraction).
 * 	# Not all ZIP archives put everything in a single root folder,
 * 	# which means several files/folders may be created in `root_dir` after extraction.
 * 	var root_dir = DirAccess.open("user://")
 *
 * 	var files = reader.get_files()
 * 	for file_path in files:
 * 		# If the current entry is a directory.
 * 		if file_path.ends_with("/"):
 * 			root_dir.make_dir_recursive(file_path)
 * 			continue
 *
 * 		# Write file contents, creating folders automatically when needed.
 * 		# Not all ZIP archives are strictly ordered, so we need to do this in case
 * 		# the file entry comes before the folder entry.
 * 		root_dir.make_dir_recursive(root_dir.get_current_dir().path_join(file_path).get_base_dir())
 * 		var file = FileAccess.open(root_dir.get_current_dir().path_join(file_path), FileAccess.WRITE)
 * 		var buffer = reader.read_file(file_path)
 * 		file.store_buffer(buffer)
 * ```
 */
@GodotBaseType
public open class ZIPReader : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(956, scriptPtr)
  }

  /**
   * Opens the zip archive at the given [path] and reads its file index.
   */
  public final fun `open`(path: String): Error =
      Error.from(TransferContext.callMethod_STRING_ret_LONG(ptr, objectID.id, MethodBindings.openPtr, path))

  /**
   * Closes the underlying resources used by this instance.
   */
  public final fun close(): Error =
      Error.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.closePtr))

  /**
   * Returns the list of names of all files in the loaded archive.
   *
   * Must be called after [open].
   */
  public final fun getFiles(): PackedStringArray =
      TransferContext.callPtrMethod0_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getFilesPtr)

  /**
   * Loads the whole content of a file in the loaded zip archive into memory and returns it.
   *
   * Must be called after [open].
   */
  @JvmOverloads
  public final fun readFile(path: String, caseSensitive: Boolean = true): PackedByteArray =
      TransferContext.callMethod_STRING_BOOL_ret_PACKED_BYTE_ARRAY(ptr, objectID.id, MethodBindings.readFilePtr, path, caseSensitive)

  /**
   * Returns `true` if the file exists in the loaded zip archive.
   *
   * Must be called after [open].
   */
  @JvmOverloads
  public final fun fileExists(path: String, caseSensitive: Boolean = true): Boolean =
      TransferContext.callMethod_STRING_BOOL_ret_BOOL(ptr, objectID.id, MethodBindings.fileExistsPtr, path, caseSensitive)

  /**
   * Returns the compression level of the file in the loaded zip archive. Returns `-1` if the file
   * doesn't exist or any other error occurs. Must be called after [open].
   */
  @JvmOverloads
  public final fun getCompressionLevel(path: String, caseSensitive: Boolean = true): Int =
      TransferContext.callMethod_STRING_BOOL_ret_LONG(ptr, objectID.id, MethodBindings.getCompressionLevelPtr, path, caseSensitive).toInt()

  public companion object {
    @JvmField
    public val openName: MethodStringName1<ZIPReader, Error, String> =
        MethodStringName1<ZIPReader, Error, String>("open")

    @JvmField
    public val closeName: MethodStringName0<ZIPReader, Error> =
        MethodStringName0<ZIPReader, Error>("close")

    @JvmField
    public val getFilesName: MethodStringName0<ZIPReader, PackedStringArray> =
        MethodStringName0<ZIPReader, PackedStringArray>("get_files")

    @JvmField
    public val readFileName: MethodStringName2<ZIPReader, PackedByteArray, String, Boolean> =
        MethodStringName2<ZIPReader, PackedByteArray, String, Boolean>("read_file")

    @JvmField
    public val fileExistsName: MethodStringName2<ZIPReader, Boolean, String, Boolean> =
        MethodStringName2<ZIPReader, Boolean, String, Boolean>("file_exists")

    @JvmField
    public val getCompressionLevelName: MethodStringName2<ZIPReader, Int, String, Boolean> =
        MethodStringName2<ZIPReader, Int, String, Boolean>("get_compression_level")
  }

  public object MethodBindings {
    internal val openPtr: VoidPtr = TypeManager.getMethodBindPtr("ZIPReader", "open", 166001499)

    internal val closePtr: VoidPtr = TypeManager.getMethodBindPtr("ZIPReader", "close", 166280745)

    internal val getFilesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ZIPReader", "get_files", 2981934095)

    internal val readFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ZIPReader", "read_file", 740857591)

    internal val fileExistsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ZIPReader", "file_exists", 35364943)

    internal val getCompressionLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ZIPReader", "get_compression_level", 3694577386)
  }
}
