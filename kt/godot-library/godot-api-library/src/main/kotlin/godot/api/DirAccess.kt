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
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.PackedStringArray
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_STRING_ARRAY
import godot.core.VariantParser.STRING
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * This class is used to manage directories and their content, even outside of the project folder.
 *
 * [DirAccess] can't be instantiated directly. Instead it is created with a static method that takes
 * a path for which it will be opened.
 *
 * Most of the methods have a static alternative that can be used without creating a [DirAccess].
 * Static methods only support absolute paths (including `res://` and `user://`).
 *
 * ```
 * # Standard
 * var dir = DirAccess.open("user://levels")
 * dir.make_dir("world1")
 * # Static
 * DirAccess.make_dir_absolute("user://levels/world1")
 * ```
 *
 * **Note:** Accessing project ("res://") directories once exported may behave unexpectedly as some
 * files are converted to engine-specific formats and their original source files may not be present in
 * the expected PCK package. Because of this, to access resources in an exported project, it is
 * recommended to use [ResourceLoader] instead of [FileAccess].
 *
 * Here is an example on how to iterate through the files of a directory:
 *
 * ```gdscript
 * //gdscript
 * func dir_contents(path):
 * 	var dir = DirAccess.open(path)
 * 	if dir:
 * 		dir.list_dir_begin()
 * 		var file_name = dir.get_next()
 * 		while file_name != "":
 * 			if dir.current_is_dir():
 * 				print("Found directory: " + file_name)
 * 			else:
 * 				print("Found file: " + file_name)
 * 			file_name = dir.get_next()
 * 	else:
 * 		print("An error occurred when trying to access the path.")
 * ```
 *
 * ```csharp
 * //csharp
 * public void DirContents(string path)
 * {
 * 	using var dir = DirAccess.Open(path);
 * 	if (dir != null)
 * 	{
 * 		dir.ListDirBegin();
 * 		string fileName = dir.GetNext();
 * 		while (fileName != "")
 * 		{
 * 			if (dir.CurrentIsDir())
 * 			{
 * 				GD.Print($"Found directory: {fileName}");
 * 			}
 * 			else
 * 			{
 * 				GD.Print($"Found file: {fileName}");
 * 			}
 * 			fileName = dir.GetNext();
 * 		}
 * 	}
 * 	else
 * 	{
 * 		GD.Print("An error occurred when trying to access the path.");
 * 	}
 * }
 * ```
 *
 * Keep in mind that file names may change or be remapped after export. If you want to see the
 * actual resource file list as it appears in the editor, use [ResourceLoader.listDirectory] instead.
 */
@GodotBaseType
public open class DirAccess internal constructor() : RefCounted() {
  /**
   * If `true`, `.` and `..` are included when navigating the directory.
   *
   * Affects [listDirBegin] and [getDirectories].
   */
  public final inline var includeNavigational: Boolean
    @JvmName("includeNavigationalProperty")
    get() = getIncludeNavigational()
    @JvmName("includeNavigationalProperty")
    set(`value`) {
      setIncludeNavigational(value)
    }

  /**
   * If `true`, hidden files are included when navigating the directory.
   *
   * Affects [listDirBegin], [getDirectories] and [getFiles].
   */
  public final inline var includeHidden: Boolean
    @JvmName("includeHiddenProperty")
    get() = getIncludeHidden()
    @JvmName("includeHiddenProperty")
    set(`value`) {
      setIncludeHidden(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(207, scriptPtr)
  }

  /**
   * Initializes the stream used to list all files and directories using the [getNext] function,
   * closing the currently opened stream if needed. Once the stream has been processed, it should
   * typically be closed with [listDirEnd].
   *
   * Affected by [includeHidden] and [includeNavigational].
   *
   * **Note:** The order of files and directories returned by this method is not deterministic, and
   * can vary between operating systems. If you want a list of all files or folders sorted
   * alphabetically, use [getFiles] or [getDirectories].
   */
  public final fun listDirBegin(): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.listDirBeginPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the next element (file or directory) in the current directory.
   *
   * The name of the file or directory is returned (and not its full path). Once the stream has been
   * fully processed, the method returns an empty [String] and closes the stream automatically (i.e.
   * [listDirEnd] would not be mandatory in such a case).
   */
  public final fun getNext(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNextPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns whether the current item processed with the last [getNext] call is a directory (`.` and
   * `..` are considered directories).
   */
  public final fun currentIsDir(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.currentIsDirPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Closes the current stream opened with [listDirBegin] (whether it has been fully processed with
   * [getNext] does not matter).
   */
  public final fun listDirEnd(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.listDirEndPtr)
  }

  /**
   * Returns a [PackedStringArray] containing filenames of the directory contents, excluding
   * directories. The array is sorted alphabetically.
   *
   * Affected by [includeHidden].
   *
   * **Note:** When used on a `res://` path in an exported project, only the files actually included
   * in the PCK at the given folder level are returned. In practice, this means that since imported
   * resources are stored in a top-level `.godot/` folder, only paths to `*.gd` and `*.import` files
   * are returned (plus a few files such as `project.godot` or `project.binary` and the project icon).
   * In an exported project, the list of returned files will also vary depending on whether
   * [ProjectSettings.editor/export/convertTextResourcesToBinary] is `true`.
   */
  public final fun getFiles(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFilesPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Returns a [PackedStringArray] containing filenames of the directory contents, excluding files.
   * The array is sorted alphabetically.
   *
   * Affected by [includeHidden] and [includeNavigational].
   *
   * **Note:** The returned directories in the editor and after exporting in the `res://` directory
   * may differ as some files are converted to engine-specific formats when exported.
   */
  public final fun getDirectories(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDirectoriesPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Returns the currently opened directory's drive index. See [getDriveName] to convert returned
   * index to the name of the drive.
   */
  public final fun getCurrentDrive(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentDrivePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Changes the currently opened directory to the one passed as an argument. The argument can be
   * relative to the current directory (e.g. `newdir` or `../newdir`), or an absolute path (e.g.
   * `/tmp/newdir` or `res://somedir/newdir`).
   *
   * Returns one of the [Error] code constants ([OK] on success).
   *
   * **Note:** The new directory must be within the same scope, e.g. when you had opened a directory
   * inside `res://`, you can't change it to `user://` directory. If you need to open a directory in
   * another access scope, use [open] to create a new instance instead.
   */
  public final fun changeDir(toDir: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to toDir)
    TransferContext.callMethod(MethodBindings.changeDirPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the absolute path to the currently opened directory (e.g. `res://folder` or
   * `C:\tmp\folder`).
   */
  @JvmOverloads
  public final fun getCurrentDir(includeDrive: Boolean = true): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to includeDrive)
    TransferContext.callMethod(MethodBindings.getCurrentDirPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Creates a directory. The argument can be relative to the current directory, or an absolute
   * path. The target directory should be placed in an already existing directory (to create the full
   * path recursively, see [makeDirRecursive]).
   *
   * Returns one of the [Error] code constants ([OK] on success).
   */
  public final fun makeDir(path: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.makeDirPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Creates a target directory and all necessary intermediate directories in its path, by calling
   * [makeDir] recursively. The argument can be relative to the current directory, or an absolute path.
   *
   * Returns one of the [Error] code constants ([OK] on success).
   */
  public final fun makeDirRecursive(path: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.makeDirRecursivePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns whether the target file exists. The argument can be relative to the current directory,
   * or an absolute path.
   *
   * For a static equivalent, use [FileAccess.fileExists].
   *
   * **Note:** Many resources types are imported (e.g. textures or sound files), and their source
   * asset will not be included in the exported game, as only the imported version is used. See
   * [ResourceLoader.exists] for an alternative approach that takes resource remapping into account.
   */
  public final fun fileExists(path: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.fileExistsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns whether the target directory exists. The argument can be relative to the current
   * directory, or an absolute path.
   *
   * **Note:** The returned [Boolean] in the editor and after exporting when used on a path in the
   * `res://` directory may be different. Some files are converted to engine-specific formats when
   * exported, potentially changing the directory structure.
   */
  public final fun dirExists(path: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.dirExistsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the available space on the current directory's disk, in bytes. Returns `0` if the
   * platform-specific method to query the available space fails.
   */
  public final fun getSpaceLeft(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpaceLeftPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Copies the [from] file to the [to] destination. Both arguments should be paths to files, either
   * relative or absolute. If the destination file exists and is not access-protected, it will be
   * overwritten.
   *
   * If [chmodFlags] is different than `-1`, the Unix permissions for the destination path will be
   * set to the provided value, if available on the current operating system.
   *
   * Returns one of the [Error] code constants ([OK] on success).
   */
  @JvmOverloads
  public final fun copy(
    from: String,
    to: String,
    chmodFlags: Int = -1,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to from, STRING to to, LONG to chmodFlags.toLong())
    TransferContext.callMethod(MethodBindings.copyPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Renames (move) the [from] file or directory to the [to] destination. Both arguments should be
   * paths to files or directories, either relative or absolute. If the destination file or directory
   * exists and is not access-protected, it will be overwritten.
   *
   * Returns one of the [Error] code constants ([OK] on success).
   */
  public final fun rename(from: String, to: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to from, STRING to to)
    TransferContext.callMethod(MethodBindings.renamePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Permanently deletes the target file or an empty directory. The argument can be relative to the
   * current directory, or an absolute path. If the target directory is not empty, the operation will
   * fail.
   *
   * If you don't want to delete the file/directory permanently, use [OS.moveToTrash] instead.
   *
   * Returns one of the [Error] code constants ([OK] on success).
   */
  public final fun remove(path: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.removePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if the file or directory is a symbolic link, directory junction, or other
   * reparse point.
   *
   * **Note:** This method is implemented on macOS, Linux, and Windows.
   */
  public final fun isLink(path: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.isLinkPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns target of the symbolic link.
   *
   * **Note:** This method is implemented on macOS, Linux, and Windows.
   */
  public final fun readLink(path: String): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.readLinkPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Creates symbolic link between files or folders.
   *
   * **Note:** On Windows, this method works only if the application is running with elevated
   * privileges or Developer Mode is enabled.
   *
   * **Note:** This method is implemented on macOS, Linux, and Windows.
   */
  public final fun createLink(source: String, target: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to source, STRING to target)
    TransferContext.callMethod(MethodBindings.createLinkPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if the directory is a macOS bundle.
   *
   * **Note:** This method is implemented on macOS.
   */
  public final fun isBundle(path: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.isBundlePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setIncludeNavigational(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setIncludeNavigationalPtr)
  }

  public final fun getIncludeNavigational(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIncludeNavigationalPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setIncludeHidden(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setIncludeHiddenPtr)
  }

  public final fun getIncludeHidden(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIncludeHiddenPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns file system type name of the current directory's disk. Returned values are uppercase
   * strings like `NTFS`, `FAT32`, `EXFAT`, `APFS`, `EXT4`, `BTRFS`, and so on.
   *
   * **Note:** This method is implemented on macOS, Linux, Windows and for PCK virtual file system.
   */
  public final fun getFilesystemType(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFilesystemTypePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns `true` if the file system or directory use case sensitive file names.
   *
   * **Note:** This method is implemented on macOS, Linux (for EXT4 and F2FS filesystems only) and
   * Windows. On other platforms, it always returns `true`.
   */
  public final fun isCaseSensitive(path: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.isCaseSensitivePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if paths [pathA] and [pathB] resolve to the same file system object. Returns
   * `false` otherwise, even if the files are bit-for-bit identical (e.g., identical copies of the file
   * that are not symbolic links).
   */
  public final fun isEquivalent(pathA: String, pathB: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to pathA, STRING to pathB)
    TransferContext.callMethod(MethodBindings.isEquivalentPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val openName: MethodStringName1<DirAccess, DirAccess?, String> =
        MethodStringName1<DirAccess, DirAccess?, String>("open")

    @JvmField
    public val getOpenErrorName: MethodStringName0<DirAccess, Error> =
        MethodStringName0<DirAccess, Error>("get_open_error")

    @JvmField
    public val createTempName: MethodStringName2<DirAccess, DirAccess?, String, Boolean> =
        MethodStringName2<DirAccess, DirAccess?, String, Boolean>("create_temp")

    @JvmField
    public val listDirBeginName: MethodStringName0<DirAccess, Error> =
        MethodStringName0<DirAccess, Error>("list_dir_begin")

    @JvmField
    public val getNextName: MethodStringName0<DirAccess, String> =
        MethodStringName0<DirAccess, String>("get_next")

    @JvmField
    public val currentIsDirName: MethodStringName0<DirAccess, Boolean> =
        MethodStringName0<DirAccess, Boolean>("current_is_dir")

    @JvmField
    public val listDirEndName: MethodStringName0<DirAccess, Unit> =
        MethodStringName0<DirAccess, Unit>("list_dir_end")

    @JvmField
    public val getFilesName: MethodStringName0<DirAccess, PackedStringArray> =
        MethodStringName0<DirAccess, PackedStringArray>("get_files")

    @JvmField
    public val getFilesAtName: MethodStringName1<DirAccess, PackedStringArray, String> =
        MethodStringName1<DirAccess, PackedStringArray, String>("get_files_at")

    @JvmField
    public val getDirectoriesName: MethodStringName0<DirAccess, PackedStringArray> =
        MethodStringName0<DirAccess, PackedStringArray>("get_directories")

    @JvmField
    public val getDirectoriesAtName: MethodStringName1<DirAccess, PackedStringArray, String> =
        MethodStringName1<DirAccess, PackedStringArray, String>("get_directories_at")

    @JvmField
    public val getDriveCountName: MethodStringName0<DirAccess, Int> =
        MethodStringName0<DirAccess, Int>("get_drive_count")

    @JvmField
    public val getDriveNameName: MethodStringName1<DirAccess, String, Int> =
        MethodStringName1<DirAccess, String, Int>("get_drive_name")

    @JvmField
    public val getDriveLabelName: MethodStringName1<DirAccess, String, Int> =
        MethodStringName1<DirAccess, String, Int>("get_drive_label")

    @JvmField
    public val getCurrentDriveName: MethodStringName0<DirAccess, Int> =
        MethodStringName0<DirAccess, Int>("get_current_drive")

    @JvmField
    public val changeDirName: MethodStringName1<DirAccess, Error, String> =
        MethodStringName1<DirAccess, Error, String>("change_dir")

    @JvmField
    public val getCurrentDirName: MethodStringName1<DirAccess, String, Boolean> =
        MethodStringName1<DirAccess, String, Boolean>("get_current_dir")

    @JvmField
    public val makeDirName: MethodStringName1<DirAccess, Error, String> =
        MethodStringName1<DirAccess, Error, String>("make_dir")

    @JvmField
    public val makeDirAbsoluteName: MethodStringName1<DirAccess, Error, String> =
        MethodStringName1<DirAccess, Error, String>("make_dir_absolute")

    @JvmField
    public val makeDirRecursiveName: MethodStringName1<DirAccess, Error, String> =
        MethodStringName1<DirAccess, Error, String>("make_dir_recursive")

    @JvmField
    public val makeDirRecursiveAbsoluteName: MethodStringName1<DirAccess, Error, String> =
        MethodStringName1<DirAccess, Error, String>("make_dir_recursive_absolute")

    @JvmField
    public val fileExistsName: MethodStringName1<DirAccess, Boolean, String> =
        MethodStringName1<DirAccess, Boolean, String>("file_exists")

    @JvmField
    public val dirExistsName: MethodStringName1<DirAccess, Boolean, String> =
        MethodStringName1<DirAccess, Boolean, String>("dir_exists")

    @JvmField
    public val dirExistsAbsoluteName: MethodStringName1<DirAccess, Boolean, String> =
        MethodStringName1<DirAccess, Boolean, String>("dir_exists_absolute")

    @JvmField
    public val getSpaceLeftName: MethodStringName0<DirAccess, Long> =
        MethodStringName0<DirAccess, Long>("get_space_left")

    @JvmField
    public val copyName: MethodStringName3<DirAccess, Error, String, String, Int> =
        MethodStringName3<DirAccess, Error, String, String, Int>("copy")

    @JvmField
    public val copyAbsoluteName: MethodStringName3<DirAccess, Error, String, String, Int> =
        MethodStringName3<DirAccess, Error, String, String, Int>("copy_absolute")

    @JvmField
    public val renameName: MethodStringName2<DirAccess, Error, String, String> =
        MethodStringName2<DirAccess, Error, String, String>("rename")

    @JvmField
    public val renameAbsoluteName: MethodStringName2<DirAccess, Error, String, String> =
        MethodStringName2<DirAccess, Error, String, String>("rename_absolute")

    @JvmField
    public val removeName: MethodStringName1<DirAccess, Error, String> =
        MethodStringName1<DirAccess, Error, String>("remove")

    @JvmField
    public val removeAbsoluteName: MethodStringName1<DirAccess, Error, String> =
        MethodStringName1<DirAccess, Error, String>("remove_absolute")

    @JvmField
    public val isLinkName: MethodStringName1<DirAccess, Boolean, String> =
        MethodStringName1<DirAccess, Boolean, String>("is_link")

    @JvmField
    public val readLinkName: MethodStringName1<DirAccess, String, String> =
        MethodStringName1<DirAccess, String, String>("read_link")

    @JvmField
    public val createLinkName: MethodStringName2<DirAccess, Error, String, String> =
        MethodStringName2<DirAccess, Error, String, String>("create_link")

    @JvmField
    public val isBundleName: MethodStringName1<DirAccess, Boolean, String> =
        MethodStringName1<DirAccess, Boolean, String>("is_bundle")

    @JvmField
    public val setIncludeNavigationalName: MethodStringName1<DirAccess, Unit, Boolean> =
        MethodStringName1<DirAccess, Unit, Boolean>("set_include_navigational")

    @JvmField
    public val getIncludeNavigationalName: MethodStringName0<DirAccess, Boolean> =
        MethodStringName0<DirAccess, Boolean>("get_include_navigational")

    @JvmField
    public val setIncludeHiddenName: MethodStringName1<DirAccess, Unit, Boolean> =
        MethodStringName1<DirAccess, Unit, Boolean>("set_include_hidden")

    @JvmField
    public val getIncludeHiddenName: MethodStringName0<DirAccess, Boolean> =
        MethodStringName0<DirAccess, Boolean>("get_include_hidden")

    @JvmField
    public val getFilesystemTypeName: MethodStringName0<DirAccess, String> =
        MethodStringName0<DirAccess, String>("get_filesystem_type")

    @JvmField
    public val isCaseSensitiveName: MethodStringName1<DirAccess, Boolean, String> =
        MethodStringName1<DirAccess, Boolean, String>("is_case_sensitive")

    @JvmField
    public val isEquivalentName: MethodStringName2<DirAccess, Boolean, String, String> =
        MethodStringName2<DirAccess, Boolean, String, String>("is_equivalent")

    /**
     * Creates a new [DirAccess] object and opens an existing directory of the filesystem. The
     * [path] argument can be within the project tree (`res://folder`), the user directory
     * (`user://folder`) or an absolute path of the user filesystem (e.g. `/tmp/folder` or
     * `C:\tmp\folder`).
     *
     * Returns `null` if opening the directory failed. You can use [getOpenError] to check the error
     * that occurred.
     */
    @JvmStatic
    public final fun `open`(path: String): DirAccess? {
      TransferContext.writeMethodArguments(0L, 0L, STRING to path)
      TransferContext.callMethod(MethodBindings.openPtr)
      return (TransferContext.readReturnValue(OBJECT) as DirAccess?)
    }

    /**
     * Returns the result of the last [open] call in the current thread.
     */
    @JvmStatic
    public final fun getOpenError(): Error {
      TransferContext.writeMethodArguments(0L, 0L)
      TransferContext.callMethod(MethodBindings.getOpenErrorPtr)
      return Error.from(TransferContext.readReturnValue(LONG) as Long)
    }

    /**
     * Creates a temporary directory. This directory will be freed when the returned [DirAccess] is
     * freed.
     *
     * If [prefix] is not empty, it will be prefixed to the directory name, separated by a `-`.
     *
     * If [keep] is `true`, the directory is not deleted when the returned [DirAccess] is freed.
     *
     * Returns `null` if opening the directory failed. You can use [getOpenError] to check the error
     * that occurred.
     */
    @JvmOverloads
    @JvmStatic
    public final fun createTemp(prefix: String = "", keep: Boolean = false): DirAccess? {
      TransferContext.writeMethodArguments(0L, 0L, STRING to prefix, BOOL to keep)
      TransferContext.callMethod(MethodBindings.createTempPtr)
      return (TransferContext.readReturnValue(OBJECT) as DirAccess?)
    }

    /**
     * Returns a [PackedStringArray] containing filenames of the directory contents, excluding
     * directories, at the given [path]. The array is sorted alphabetically.
     *
     * Use [getFiles] if you want more control of what gets included.
     *
     * **Note:** When used on a `res://` path in an exported project, only the files included in the
     * PCK at the given folder level are returned. In practice, this means that since imported
     * resources are stored in a top-level `.godot/` folder, only paths to `.gd` and `.import` files
     * are returned (plus a few other files, such as `project.godot` or `project.binary` and the
     * project icon). In an exported project, the list of returned files will also vary depending on
     * [ProjectSettings.editor/export/convertTextResourcesToBinary].
     */
    @JvmStatic
    public final fun getFilesAt(path: String): PackedStringArray {
      TransferContext.writeMethodArguments(0L, 0L, STRING to path)
      TransferContext.callMethod(MethodBindings.getFilesAtPtr)
      return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
    }

    /**
     * Returns a [PackedStringArray] containing filenames of the directory contents, excluding
     * files, at the given [path]. The array is sorted alphabetically.
     *
     * Use [getDirectories] if you want more control of what gets included.
     *
     * **Note:** The returned directories in the editor and after exporting in the `res://`
     * directory may differ as some files are converted to engine-specific formats when exported.
     */
    @JvmStatic
    public final fun getDirectoriesAt(path: String): PackedStringArray {
      TransferContext.writeMethodArguments(0L, 0L, STRING to path)
      TransferContext.callMethod(MethodBindings.getDirectoriesAtPtr)
      return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
    }

    /**
     * On Windows, returns the number of drives (partitions) mounted on the current filesystem.
     *
     * On macOS and Android, returns the number of mounted volumes.
     *
     * On Linux, returns the number of mounted volumes and GTK 3 bookmarks.
     *
     * On other platforms, the method returns 0.
     */
    @JvmStatic
    public final fun getDriveCount(): Int {
      TransferContext.writeMethodArguments(0L, 0L)
      TransferContext.callMethod(MethodBindings.getDriveCountPtr)
      return (TransferContext.readReturnValue(LONG) as Long).toInt()
    }

    /**
     * On Windows, returns the name of the drive (partition) passed as an argument (e.g. `C:`).
     *
     * On macOS, returns the path to the mounted volume passed as an argument.
     *
     * On Linux, returns the path to the mounted volume or GTK 3 bookmark passed as an argument.
     *
     * On Android (API level 30+), returns the path to the mounted volume as an argument.
     *
     * On other platforms, or if the requested drive does not exist, returns an empty String.
     */
    @JvmStatic
    public final fun getDriveName(idx: Int): String {
      TransferContext.writeMethodArguments(0L, 0L, LONG to idx.toLong())
      TransferContext.callMethod(MethodBindings.getDriveNamePtr)
      return (TransferContext.readReturnValue(STRING) as String)
    }

    /**
     * On Windows, returns the label of the drive (partition) passed as an argument.
     *
     * On other platforms, or if the requested drive does not exist, returns an empty String.
     */
    @JvmStatic
    public final fun getDriveLabel(idx: Int): String {
      TransferContext.writeMethodArguments(0L, 0L, LONG to idx.toLong())
      TransferContext.callMethod(MethodBindings.getDriveLabelPtr)
      return (TransferContext.readReturnValue(STRING) as String)
    }

    /**
     * Static version of [makeDir]. Supports only absolute paths.
     */
    @JvmStatic
    public final fun makeDirAbsolute(path: String): Error {
      TransferContext.writeMethodArguments(0L, 0L, STRING to path)
      TransferContext.callMethod(MethodBindings.makeDirAbsolutePtr)
      return Error.from(TransferContext.readReturnValue(LONG) as Long)
    }

    /**
     * Static version of [makeDirRecursive]. Supports only absolute paths.
     */
    @JvmStatic
    public final fun makeDirRecursiveAbsolute(path: String): Error {
      TransferContext.writeMethodArguments(0L, 0L, STRING to path)
      TransferContext.callMethod(MethodBindings.makeDirRecursiveAbsolutePtr)
      return Error.from(TransferContext.readReturnValue(LONG) as Long)
    }

    /**
     * Static version of [dirExists]. Supports only absolute paths.
     *
     * **Note:** The returned [Boolean] in the editor and after exporting when used on a path in the
     * `res://` directory may be different. Some files are converted to engine-specific formats when
     * exported, potentially changing the directory structure.
     */
    @JvmStatic
    public final fun dirExistsAbsolute(path: String): Boolean {
      TransferContext.writeMethodArguments(0L, 0L, STRING to path)
      TransferContext.callMethod(MethodBindings.dirExistsAbsolutePtr)
      return (TransferContext.readReturnValue(BOOL) as Boolean)
    }

    /**
     * Static version of [copy]. Supports only absolute paths.
     */
    @JvmOverloads
    @JvmStatic
    public final fun copyAbsolute(
      from: String,
      to: String,
      chmodFlags: Int = -1,
    ): Error {
      TransferContext.writeMethodArguments(0L, 0L, STRING to from, STRING to to, LONG to chmodFlags.toLong())
      TransferContext.callMethod(MethodBindings.copyAbsolutePtr)
      return Error.from(TransferContext.readReturnValue(LONG) as Long)
    }

    /**
     * Static version of [rename]. Supports only absolute paths.
     */
    @JvmStatic
    public final fun renameAbsolute(from: String, to: String): Error {
      TransferContext.writeMethodArguments(0L, 0L, STRING to from, STRING to to)
      TransferContext.callMethod(MethodBindings.renameAbsolutePtr)
      return Error.from(TransferContext.readReturnValue(LONG) as Long)
    }

    /**
     * Static version of [remove]. Supports only absolute paths.
     */
    @JvmStatic
    public final fun removeAbsolute(path: String): Error {
      TransferContext.writeMethodArguments(0L, 0L, STRING to path)
      TransferContext.callMethod(MethodBindings.removeAbsolutePtr)
      return Error.from(TransferContext.readReturnValue(LONG) as Long)
    }
  }

  public object MethodBindings {
    internal val openPtr: VoidPtr = TypeManager.getMethodBindPtr("DirAccess", "open", 1923528528)

    internal val getOpenErrorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "get_open_error", 166280745)

    internal val createTempPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "create_temp", 812913566)

    internal val listDirBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "list_dir_begin", 166280745)

    internal val getNextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "get_next", 2841200299)

    internal val currentIsDirPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "current_is_dir", 36873697)

    internal val listDirEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "list_dir_end", 3218959716)

    internal val getFilesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "get_files", 2981934095)

    internal val getFilesAtPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "get_files_at", 3538744774)

    internal val getDirectoriesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "get_directories", 2981934095)

    internal val getDirectoriesAtPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "get_directories_at", 3538744774)

    internal val getDriveCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "get_drive_count", 2455072627)

    internal val getDriveNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "get_drive_name", 990163283)

    internal val getDriveLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "get_drive_label", 990163283)

    internal val getCurrentDrivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "get_current_drive", 2455072627)

    internal val changeDirPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "change_dir", 166001499)

    internal val getCurrentDirPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "get_current_dir", 1287308131)

    internal val makeDirPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "make_dir", 166001499)

    internal val makeDirAbsolutePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "make_dir_absolute", 166001499)

    internal val makeDirRecursivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "make_dir_recursive", 166001499)

    internal val makeDirRecursiveAbsolutePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "make_dir_recursive_absolute", 166001499)

    internal val fileExistsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "file_exists", 2323990056)

    internal val dirExistsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "dir_exists", 2323990056)

    internal val dirExistsAbsolutePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "dir_exists_absolute", 2323990056)

    internal val getSpaceLeftPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "get_space_left", 2455072627)

    internal val copyPtr: VoidPtr = TypeManager.getMethodBindPtr("DirAccess", "copy", 1063198817)

    internal val copyAbsolutePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "copy_absolute", 1063198817)

    internal val renamePtr: VoidPtr = TypeManager.getMethodBindPtr("DirAccess", "rename", 852856452)

    internal val renameAbsolutePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "rename_absolute", 852856452)

    internal val removePtr: VoidPtr = TypeManager.getMethodBindPtr("DirAccess", "remove", 166001499)

    internal val removeAbsolutePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "remove_absolute", 166001499)

    internal val isLinkPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "is_link", 2323990056)

    internal val readLinkPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "read_link", 1703090593)

    internal val createLinkPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "create_link", 852856452)

    internal val isBundlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "is_bundle", 3927539163)

    internal val setIncludeNavigationalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "set_include_navigational", 2586408642)

    internal val getIncludeNavigationalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "get_include_navigational", 36873697)

    internal val setIncludeHiddenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "set_include_hidden", 2586408642)

    internal val getIncludeHiddenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "get_include_hidden", 36873697)

    internal val getFilesystemTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "get_filesystem_type", 201670096)

    internal val isCaseSensitivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "is_case_sensitive", 3927539163)

    internal val isEquivalentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("DirAccess", "is_equivalent", 820780508)
  }
}
