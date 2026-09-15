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
import godot.core.MethodStringName1
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.PackedByteArray
import godot.readReturnValue_LONG
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_STRING_LONG_STRING_BOOL
import godot.writeMethodArguments_STRING_PACKED_BYTE_ARRAY_BOOL
import godot.writeMethodArguments_STRING_STRING_BOOL
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * The [PCKPacker] is used to create packages that can be loaded into a running project using
 * [ProjectSettings.loadResourcePack].
 *
 * ```gdscript
 * //gdscript
 * var packer = PCKPacker.new()
 * packer.pck_start("test.pck")
 * packer.add_file("res://text.txt", "text.txt")
 * packer.flush()
 * ```
 *
 * ```csharp
 * //csharp
 * var packer = new PckPacker();
 * packer.PckStart("test.pck");
 * packer.AddFile("res://text.txt", "text.txt");
 * packer.Flush();
 * ```
 *
 * The above [PCKPacker] creates package `test.pck`, then adds a file named `text.txt` at the root
 * of the package.
 *
 * **Note:** PCK is Godot's own pack file format. To create ZIP archives that can be read by any
 * program, use [ZIPPacker] instead.
 */
@GodotBaseType
public open class PCKPacker : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(498, scriptPtr)
  }

  /**
   * Creates a new PCK file at the file path [pckPath]. The `.pck` file extension isn't added
   * automatically, so it should be part of [pckPath] (even though it's not required).
   */
  @JvmOverloads
  public final fun pckStart(
    pckPath: String,
    alignment: Int = 32,
    key: String = "0000000000000000000000000000000000000000000000000000000000000000",
    encryptDirectory: Boolean = false,
  ): Error {
    TransferContext.writeMethodArguments_STRING_LONG_STRING_BOOL(ptr, objectID.id, pckPath, alignment.toLong(), key, encryptDirectory)
    TransferContext.callMethod(MethodBindings.pckStartPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Adds the [sourcePath] file to the current PCK package at the [targetPath] internal path. The
   * `res://` prefix for [targetPath] is optional and stripped internally. File content is immediately
   * written to the PCK.
   */
  @JvmOverloads
  public final fun addFile(
    targetPath: String,
    sourcePath: String,
    encrypt: Boolean = false,
  ): Error {
    TransferContext.writeMethodArguments_STRING_STRING_BOOL(ptr, objectID.id, targetPath, sourcePath, encrypt)
    TransferContext.callMethod(MethodBindings.addFilePtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Adds the [data] to the current PCK package at the [targetPath] internal path. The `res://`
   * prefix for [targetPath] is optional and stripped internally. File content is immediately written
   * to the PCK.
   */
  @JvmOverloads
  public final fun addFileFromBuffer(
    targetPath: String,
    `data`: PackedByteArray,
    encrypt: Boolean = false,
  ): Error {
    TransferContext.writeMethodArguments_STRING_PACKED_BYTE_ARRAY_BOOL(ptr, objectID.id, targetPath, data, encrypt)
    TransferContext.callMethod(MethodBindings.addFileFromBufferPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Registers a file removal of the [targetPath] internal path to the PCK. This is mainly used for
   * patches. If the file at this path has been loaded from a previous PCK, it will be removed. The
   * `res://` prefix for [targetPath] is optional and stripped internally.
   */
  public final fun addFileRemoval(targetPath: String): Error {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, targetPath)
    TransferContext.callMethod(MethodBindings.addFileRemovalPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Writes the file directory and closes the PCK. If [verbose] is `true`, a list of files added
   * will be printed to the console for easier debugging.
   *
   * **Note:** [PCKPacker] will automatically flush when it's freed, which happens when it goes out
   * of scope or when it gets assigned with `null`. In C# the reference must be disposed after use,
   * either with the `using` statement or by calling the `Dispose` method directly.
   */
  @JvmOverloads
  public final fun flush(verbose: Boolean = false): Error {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, verbose)
    TransferContext.callMethod(MethodBindings.flushPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  public companion object {
    @JvmField
    public val pckStartName: MethodStringName4<PCKPacker, Error, String, Int, String, Boolean> =
        MethodStringName4<PCKPacker, Error, String, Int, String, Boolean>("pck_start")

    @JvmField
    public val addFileName: MethodStringName3<PCKPacker, Error, String, String, Boolean> =
        MethodStringName3<PCKPacker, Error, String, String, Boolean>("add_file")

    @JvmField
    public val addFileFromBufferName:
        MethodStringName3<PCKPacker, Error, String, PackedByteArray, Boolean> =
        MethodStringName3<PCKPacker, Error, String, PackedByteArray, Boolean>("add_file_from_buffer")

    @JvmField
    public val addFileRemovalName: MethodStringName1<PCKPacker, Error, String> =
        MethodStringName1<PCKPacker, Error, String>("add_file_removal")

    @JvmField
    public val flushName: MethodStringName1<PCKPacker, Error, Boolean> =
        MethodStringName1<PCKPacker, Error, Boolean>("flush")
  }

  public object MethodBindings {
    internal val pckStartPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PCKPacker", "pck_start", 508410629)

    internal val addFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PCKPacker", "add_file", 2215643711)

    internal val addFileFromBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PCKPacker", "add_file_from_buffer", 1131482346)

    internal val addFileRemovalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PCKPacker", "add_file_removal", 166001499)

    internal val flushPtr: VoidPtr = TypeManager.getMethodBindPtr("PCKPacker", "flush", 1633102583)
  }
}
