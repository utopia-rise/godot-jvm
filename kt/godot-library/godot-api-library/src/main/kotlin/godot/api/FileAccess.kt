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
import godot.core.BitFieldBase
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.PackedByteArray
import godot.core.PackedStringArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_BYTE_ARRAY
import godot.core.VariantParser.PACKED_STRING_ARRAY
import godot.core.VariantParser.STRING
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

public infix fun Long.or(other: FileAccess.UnixPermissionFlags): Long = this.or(other.flag)

public infix fun Long.xor(other: FileAccess.UnixPermissionFlags): Long = this.xor(other.flag)

public infix fun Long.and(other: FileAccess.UnixPermissionFlags): Long = this.and(other.flag)

/**
 * This class can be used to permanently store data in the user device's file system and to read
 * from it. This is useful for storing game save data or player configuration files.
 *
 * **Example:** How to write and read from a file. The file named `"save_game.dat"` will be stored
 * in the user data folder, as specified in the [url=$DOCS_URL/tutorials/io/data_paths.html]Data
 * paths[/url] documentation:
 *
 * ```gdscript
 * //gdscript
 * func save_to_file(content):
 * 	var file = FileAccess.open("user://save_game.dat", FileAccess.WRITE)
 * 	file.store_string(content)
 *
 * func load_from_file():
 * 	var file = FileAccess.open("user://save_game.dat", FileAccess.READ)
 * 	var content = file.get_as_text()
 * 	return content
 * ```
 *
 * ```csharp
 * //csharp
 * public void SaveToFile(string content)
 * {
 * 	using var file = FileAccess.Open("user://save_game.dat", FileAccess.ModeFlags.Write);
 * 	file.StoreString(content);
 * }
 *
 * public string LoadFromFile()
 * {
 * 	using var file = FileAccess.Open("user://save_game.dat", FileAccess.ModeFlags.Read);
 * 	string content = file.GetAsText();
 * 	return content;
 * }
 * ```
 *
 * A [FileAccess] instance has its own file cursor, which is the position in bytes in the file where
 * the next read/write operation will occur. Functions such as [get8], [get16], [store8], and [store16]
 * will move the file cursor forward by the number of bytes read/written. The file cursor can be moved
 * to a specific position using [seek] or [seekEnd], and its position can be retrieved using
 * [getPosition].
 *
 * A [FileAccess] instance will close its file when the instance is freed. Since it inherits
 * [RefCounted], this happens automatically when it is no longer in use. [close] can be called to close
 * it earlier. In C#, the reference must be disposed manually, which can be done with the `using`
 * statement or by calling the `Dispose` method directly.
 *
 * **Note:** To access project resources once exported, it is recommended to use [ResourceLoader]
 * instead of [FileAccess], as some files are converted to engine-specific formats and their original
 * source files might not be present in the exported PCK package. If using [FileAccess], make sure the
 * file is included in the export by changing its import mode to **Keep File (exported as is)** in the
 * Import dock, or, for files where this option is not available, change the non-resource export filter
 * in the Export dialog to include the file's extension (e.g. `*.txt`).
 *
 * **Note:** Files are automatically closed only if the process exits "normally" (such as by
 * clicking the window manager's close button or pressing [kbd]Alt + F4[/kbd]). If you stop the project
 * execution by pressing [kbd]F8[/kbd] while the project is running, the file won't be closed as the
 * game process will be killed. You can work around this by calling [flush] at regular intervals.
 */
@GodotBaseType
public open class FileAccess internal constructor() : RefCounted() {
  /**
   * If `true`, the file is read with big-endian
   * [url=https://en.wikipedia.org/wiki/Endianness]endianness[/url]. If `false`, the file is read with
   * little-endian endianness. If in doubt, leave this to `false` as most files are written with
   * little-endian endianness.
   *
   * **Note:** This is always reset to system endianness, which is little-endian on all supported
   * platforms, whenever you open the file. Therefore, you must set [bigEndian] *after* opening the
   * file, not before.
   */
  public final inline var bigEndian: Boolean
    @JvmName("bigEndianProperty")
    get() = isBigEndian()
    @JvmName("bigEndianProperty")
    set(`value`) {
      setBigEndian(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(226, scriptPtr)
  }

  /**
   * Resizes the file to a specified length. The file must be open in a mode that permits writing.
   * If the file is extended, NUL characters are appended. If the file is truncated, all data from the
   * end file to the original length of the file is lost.
   */
  public final fun resize(length: Long): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to length)
    TransferContext.callMethod(MethodBindings.resizePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Writes the file's buffer to disk. Flushing is automatically performed when the file is closed.
   * This means you don't need to call [flush] manually before closing a file. Still, calling [flush]
   * can be used to ensure the data is safe even if the project crashes instead of being closed
   * gracefully.
   *
   * **Note:** Only call [flush] when you actually need it. Otherwise, it will decrease performance
   * due to constant disk writes.
   */
  public final fun flush(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.flushPtr)
  }

  /**
   * Returns the path as a [String] for the current open file.
   */
  public final fun getPath(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPathPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the absolute path as a [String] for the current open file.
   */
  public final fun getPathAbsolute(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPathAbsolutePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns `true` if the file is currently opened.
   */
  public final fun isOpen(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOpenPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the file cursor to the specified position in bytes, from the beginning of the file. This
   * changes the value returned by [getPosition].
   */
  public final fun seek(position: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to position)
    TransferContext.callMethod(MethodBindings.seekPtr)
  }

  /**
   * Sets the file cursor to the specified position in bytes, from the end of the file. This changes
   * the value returned by [getPosition].
   *
   * **Note:** This is an offset, so you should use negative numbers otherwise the file cursor will
   * move past the end of the file.
   */
  @JvmOverloads
  public final fun seekEnd(position: Long = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to position)
    TransferContext.callMethod(MethodBindings.seekEndPtr)
  }

  /**
   * Returns the file cursor's position in bytes from the beginning of the file. This is the file
   * reading/writing cursor set by [seek] or [seekEnd] and advanced by read/write operations.
   */
  public final fun getPosition(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPositionPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the size of the file in bytes. For a pipe, returns the number of bytes available for
   * reading from the pipe.
   */
  public final fun getLength(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLengthPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if the file cursor has already read past the end of the file.
   *
   * **Note:** `eof_reached() == false` cannot be used to check whether there is more data
   * available. To loop while there is more data available, use:
   *
   * ```gdscript
   * //gdscript
   * while file.get_position() < file.get_length():
   * 	# Read data
   * ```
   *
   * ```csharp
   * //csharp
   * while (file.GetPosition() < file.GetLength())
   * {
   * 	// Read data
   * }
   * ```
   */
  public final fun eofReached(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.eofReachedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the next 8 bits from the file as an integer. This advances the file cursor by 1 byte.
   * See [store8] for details on what values can be stored and retrieved this way.
   */
  public final fun get8(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.get8Ptr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the next 16 bits from the file as an integer. This advances the file cursor by 2 bytes.
   * See [store16] for details on what values can be stored and retrieved this way.
   */
  public final fun get16(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.get16Ptr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the next 32 bits from the file as an integer. This advances the file cursor by 4 bytes.
   * See [store32] for details on what values can be stored and retrieved this way.
   */
  public final fun get32(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.get32Ptr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the next 64 bits from the file as an integer. This advances the file cursor by 8 bytes.
   * See [store64] for details on what values can be stored and retrieved this way.
   */
  public final fun get64(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.get64Ptr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the next 16 bits from the file as a half-precision floating-point number. This advances
   * the file cursor by 2 bytes.
   */
  public final fun getHalf(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHalfPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the next 32 bits from the file as a floating-point number. This advances the file
   * cursor by 4 bytes.
   */
  public final fun getFloat(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFloatPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the next 64 bits from the file as a floating-point number. This advances the file
   * cursor by 8 bytes.
   */
  public final fun getDouble(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDoublePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Returns the next bits from the file as a floating-point number. This advances the file cursor
   * by either 4 or 8 bytes, depending on the precision used by the Godot build that saved the file.
   *
   * If the file was saved by a Godot build compiled with the `precision=single` option (the
   * default), the number of read bits for that file is 32. Otherwise, if compiled with the
   * `precision=double` option, the number of read bits is 64.
   */
  public final fun getReal(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRealPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns next [length] bytes of the file as a [PackedByteArray]. This advances the file cursor
   * by [length] bytes.
   */
  public final fun getBuffer(length: Long): PackedByteArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to length)
    TransferContext.callMethod(MethodBindings.getBufferPtr)
    return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
  }

  /**
   * Returns the next line of the file as a [String]. The returned string doesn't include newline
   * (`\n`) or carriage return (`\r`) characters, but does include any other leading or trailing
   * whitespace. This advances the file cursor to after the newline character at the end of the line.
   *
   * Text is interpreted as being UTF-8 encoded.
   */
  public final fun getLine(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLinePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the next value of the file in CSV (Comma-Separated Values) format. You can pass a
   * different delimiter [delim] to use other than the default `","` (comma). This delimiter must be
   * one-character long, and cannot be a double quotation mark.
   *
   * Text is interpreted as being UTF-8 encoded. Text values must be enclosed in double quotes if
   * they include the delimiter character. Double quotes within a text value can be escaped by doubling
   * their occurrence. This advances the file cursor to after the newline character at the end of the
   * line.
   *
   * For example, the following CSV lines are valid and will be properly parsed as two strings each:
   *
   * [codeblock lang=text]
   *
   * Alice,"Hello, Bob!"
   *
   * Bob,Alice! What a surprise!
   *
   * Alice,"I thought you'd reply with ""Hello, world""."
   *
   * ```
   *
   * Note how the second line can omit the enclosing quotes as it does not include the delimiter.
   * However it *could* very well use quotes, it was only written without for demonstration purposes.
   * The third line must use `""` for each quotation mark that needs to be interpreted as such instead
   * of the end of a text value.
   */
  @JvmOverloads
  public final fun getCsvLine(delim: String = ","): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to delim)
    TransferContext.callMethod(MethodBindings.getCsvLinePtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Returns the whole file as a [String]. Text is interpreted as being UTF-8 encoded. This ignores
   * the file cursor and does not affect it.
   */
  public final fun getAsText(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAsTextPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun isBigEndian(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isBigEndianPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setBigEndian(bigEndian: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to bigEndian)
    TransferContext.callMethod(MethodBindings.setBigEndianPtr)
  }

  /**
   * Returns the last error that happened when trying to perform operations. Compare with the
   * `ERR_FILE_*` constants from [Error].
   */
  public final fun getError(): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getErrorPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the next [Any] value from the file. If [allowObjects] is `true`, decoding objects is
   * allowed. This advances the file cursor by the number of bytes read.
   *
   * Internally, this uses the same decoding mechanism as the [@GlobalScope.bytesToVar] method, as
   * described in the [url=$DOCS_URL/tutorials/io/binary_serialization_api.html]Binary serialization
   * API[/url] documentation.
   *
   * **Warning:** Deserialized objects can contain code which gets executed. Do not use this option
   * if the serialized object comes from untrusted sources to avoid potential security threats such as
   * remote code execution.
   */
  @JvmOverloads
  public final fun getVar(allowObjects: Boolean = false): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to allowObjects)
    TransferContext.callMethod(MethodBindings.getVarPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Stores an integer as 8 bits in the file. This advances the file cursor by 1 byte. Returns
   * `true` if the operation is successful.
   *
   * **Note:** The [value] should lie in the interval `[0, 255]`. Any other value will overflow and
   * wrap around.
   *
   * **Note:** If an error occurs, the resulting value of the file position indicator is
   * indeterminate.
   *
   * To store a signed integer, use [store64], or convert it manually (see [store16] for an
   * example).
   */
  public final fun store8(`value`: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to value.toLong())
    TransferContext.callMethod(MethodBindings.store8Ptr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Stores an integer as 16 bits in the file. This advances the file cursor by 2 bytes. Returns
   * `true` if the operation is successful.
   *
   * **Note:** The [value] should lie in the interval `[0, 2^16 - 1]`. Any other value will overflow
   * and wrap around.
   *
   * **Note:** If an error occurs, the resulting value of the file position indicator is
   * indeterminate.
   *
   * To store a signed integer, use [store64] or store a signed integer from the interval `[-2^15,
   * 2^15 - 1]` (i.e. keeping one bit for the signedness) and compute its sign manually when reading.
   * For example:
   *
   * ```gdscript
   * //gdscript
   * const MAX_15B = 1 << 15
   * const MAX_16B = 1 << 16
   *
   * func unsigned16_to_signed(unsigned):
   * 	return (unsigned + MAX_15B) &#37; MAX_16B - MAX_15B
   *
   * func _ready():
   * 	var f = FileAccess.open("user://file.dat", FileAccess.WRITE_READ)
   * 	f.store_16(-42) # This wraps around and stores 65494 (2^16 - 42).
   * 	f.store_16(121) # In bounds, will store 121.
   * 	f.seek(0) # Go back to start to read the stored value.
   * 	var read1 = f.get_16() # 65494
   * 	var read2 = f.get_16() # 121
   * 	var converted1 = unsigned16_to_signed(read1) # -42
   * 	var converted2 = unsigned16_to_signed(read2) # 121
   * ```
   *
   * ```csharp
   * //csharp
   * public override void _Ready()
   * {
   * 	using var f = FileAccess.Open("user://file.dat", FileAccess.ModeFlags.WriteRead);
   * 	f.Store16(unchecked((ushort)-42)); // This wraps around and stores 65494 (2^16 - 42).
   * 	f.Store16(121); // In bounds, will store 121.
   * 	f.Seek(0); // Go back to start to read the stored value.
   * 	ushort read1 = f.Get16(); // 65494
   * 	ushort read2 = f.Get16(); // 121
   * 	short converted1 = (short)read1; // -42
   * 	short converted2 = (short)read2; // 121
   * }
   * ```
   */
  public final fun store16(`value`: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to value.toLong())
    TransferContext.callMethod(MethodBindings.store16Ptr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Stores an integer as 32 bits in the file. This advances the file cursor by 4 bytes. Returns
   * `true` if the operation is successful.
   *
   * **Note:** The [value] should lie in the interval `[0, 2^32 - 1]`. Any other value will overflow
   * and wrap around.
   *
   * **Note:** If an error occurs, the resulting value of the file position indicator is
   * indeterminate.
   *
   * To store a signed integer, use [store64], or convert it manually (see [store16] for an
   * example).
   */
  public final fun store32(`value`: Long): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to value)
    TransferContext.callMethod(MethodBindings.store32Ptr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Stores an integer as 64 bits in the file. This advances the file cursor by 8 bytes. Returns
   * `true` if the operation is successful.
   *
   * **Note:** The [value] must lie in the interval `[-2^63, 2^63 - 1]` (i.e. be a valid [Long]
   * value).
   *
   * **Note:** If an error occurs, the resulting value of the file position indicator is
   * indeterminate.
   */
  public final fun store64(`value`: Long): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to value)
    TransferContext.callMethod(MethodBindings.store64Ptr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Stores a half-precision floating-point number as 16 bits in the file. This advances the file
   * cursor by 2 bytes. Returns `true` if the operation is successful.
   *
   * **Note:** If an error occurs, the resulting value of the file position indicator is
   * indeterminate.
   */
  public final fun storeHalf(`value`: Float): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.storeHalfPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Stores a floating-point number as 32 bits in the file. This advances the file cursor by 4
   * bytes. Returns `true` if the operation is successful.
   *
   * **Note:** If an error occurs, the resulting value of the file position indicator is
   * indeterminate.
   */
  public final fun storeFloat(`value`: Float): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.storeFloatPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Stores a floating-point number as 64 bits in the file. This advances the file cursor by 8
   * bytes. Returns `true` if the operation is successful.
   *
   * **Note:** If an error occurs, the resulting value of the file position indicator is
   * indeterminate.
   */
  public final fun storeDouble(`value`: Double): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to value)
    TransferContext.callMethod(MethodBindings.storeDoublePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Stores a floating-point number in the file. This advances the file cursor by either 4 or 8
   * bytes, depending on the precision used by the current Godot build.
   *
   * If using a Godot build compiled with the `precision=single` option (the default), this method
   * will save a 32-bit float. Otherwise, if compiled with the `precision=double` option, this will
   * save a 64-bit float. Returns `true` if the operation is successful.
   *
   * **Note:** If an error occurs, the resulting value of the file position indicator is
   * indeterminate.
   */
  public final fun storeReal(`value`: Float): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.storeRealPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Stores the given array of bytes in the file. This advances the file cursor by the number of
   * bytes written. Returns `true` if the operation is successful.
   *
   * **Note:** If an error occurs, the resulting value of the file position indicator is
   * indeterminate.
   */
  public final fun storeBuffer(buffer: PackedByteArray): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_BYTE_ARRAY to buffer)
    TransferContext.callMethod(MethodBindings.storeBufferPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Stores [line] in the file followed by a newline character (`\n`), encoding the text as UTF-8.
   * This advances the file cursor by the length of the line, after the newline character. The amount
   * of bytes written depends on the UTF-8 encoded bytes, which may be different from [String.length]
   * which counts the number of UTF-32 codepoints. Returns `true` if the operation is successful.
   *
   * **Note:** If an error occurs, the resulting value of the file position indicator is
   * indeterminate.
   */
  public final fun storeLine(line: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to line)
    TransferContext.callMethod(MethodBindings.storeLinePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Stores the given [PackedStringArray] in the file as a line formatted in the CSV
   * (Comma-Separated Values) format. You can pass a different delimiter [delim] to use other than the
   * default `","` (comma). This delimiter must be one-character long.
   *
   * Text will be encoded as UTF-8. Returns `true` if the operation is successful.
   *
   * **Note:** If an error occurs, the resulting value of the file position indicator is
   * indeterminate.
   */
  @JvmOverloads
  public final fun storeCsvLine(values: PackedStringArray, delim: String = ","): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_STRING_ARRAY to values, STRING to delim)
    TransferContext.callMethod(MethodBindings.storeCsvLinePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Stores [string] in the file without a newline character (`\n`), encoding the text as UTF-8.
   * This advances the file cursor by the length of the string in UTF-8 encoded bytes, which may be
   * different from [String.length] which counts the number of UTF-32 codepoints. Returns `true` if the
   * operation is successful.
   *
   * **Note:** This method is intended to be used to write text files. The string is stored as a
   * UTF-8 encoded buffer without string length or terminating zero, which means that it can't be
   * loaded back easily. If you want to store a retrievable string in a binary file, consider using
   * [storePascalString] instead. For retrieving strings from a text file, you can use
   * `get_buffer(length).get_string_from_utf8()` (if you know the length) or [getAsText].
   *
   * **Note:** If an error occurs, the resulting value of the file position indicator is
   * indeterminate.
   */
  public final fun storeString(string: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to string)
    TransferContext.callMethod(MethodBindings.storeStringPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Stores any Variant value in the file. If [fullObjects] is `true`, encoding objects is allowed
   * (and can potentially include code). This advances the file cursor by the number of bytes written.
   * Returns `true` if the operation is successful.
   *
   * Internally, this uses the same encoding mechanism as the [@GlobalScope.varToBytes] method, as
   * described in the [url=$DOCS_URL/tutorials/io/binary_serialization_api.html]Binary serialization
   * API[/url] documentation.
   *
   * **Note:** Not all properties are included. Only properties that are configured with the
   * [PROPERTY_USAGE_STORAGE] flag set will be serialized. You can add a new usage flag to a property
   * by overriding the [Object.GetPropertyList] method in your class. You can also check how property
   * usage is configured by calling [Object.GetPropertyList]. See [PropertyUsageFlags] for the possible
   * usage flags.
   *
   * **Note:** If an error occurs, the resulting value of the file position indicator is
   * indeterminate.
   */
  @JvmOverloads
  public final fun storeVar(`value`: Any?, fullObjects: Boolean = false): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, ANY to value, BOOL to fullObjects)
    TransferContext.callMethod(MethodBindings.storeVarPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Stores the given [String] as a line in the file in Pascal format (i.e. also store the length of
   * the string). Text will be encoded as UTF-8. This advances the file cursor by the number of bytes
   * written depending on the UTF-8 encoded bytes, which may be different from [String.length] which
   * counts the number of UTF-32 codepoints. Returns `true` if the operation is successful.
   *
   * **Note:** If an error occurs, the resulting value of the file position indicator is
   * indeterminate.
   */
  public final fun storePascalString(string: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to string)
    TransferContext.callMethod(MethodBindings.storePascalStringPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns a [String] saved in Pascal format from the file, meaning that the length of the string
   * is explicitly stored at the start. See [storePascalString]. This may include newline characters.
   * The file cursor is advanced after the bytes read.
   *
   * Text is interpreted as being UTF-8 encoded.
   */
  public final fun getPascalString(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPascalStringPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Closes the currently opened file and prevents subsequent read/write operations. Use [flush] to
   * persist the data to disk without closing the file.
   *
   * **Note:** [FileAccess] will automatically close when it's freed, which happens when it goes out
   * of scope or when it gets assigned with `null`. In C# the reference must be disposed after we are
   * done using it, this can be done with the `using` statement or calling the `Dispose` method
   * directly.
   */
  public final fun close(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.closePtr)
  }

  public enum class ModeFlags(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Opens the file for read operations. The file cursor is positioned at the beginning of the
     * file.
     */
    READ(1),
    /**
     * Opens the file for write operations. If the file exists, it is truncated to zero length and
     * its contents are cleared. Otherwise, it is created.
     *
     * **Note:** When creating a file it must be in an already existing directory. To recursively
     * create directories for a file path, see [DirAccess.makeDirRecursive].
     */
    WRITE(2),
    /**
     * Opens the file for read and write operations. Does not truncate the file. The file cursor is
     * positioned at the beginning of the file.
     */
    READ_WRITE(3),
    /**
     * Opens the file for read and write operations. If the file exists, it is truncated to zero
     * length and its contents are cleared. Otherwise, it is created. The file cursor is positioned at
     * the beginning of the file.
     *
     * **Note:** When creating a file it must be in an already existing directory. To recursively
     * create directories for a file path, see [DirAccess.makeDirRecursive].
     */
    WRITE_READ(7),
    ;

    public companion object {
      public fun from(`value`: Long): ModeFlags = entries.single { it.`value` == `value` }
    }
  }

  public enum class CompressionMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Uses the [url=https://fastlz.org/]FastLZ[/url] compression method.
     */
    FASTLZ(0),
    /**
     * Uses the [url=https://en.wikipedia.org/wiki/DEFLATE]DEFLATE[/url] compression method.
     */
    DEFLATE(1),
    /**
     * Uses the [url=https://facebook.github.io/zstd/]Zstandard[/url] compression method.
     */
    ZSTD(2),
    /**
     * Uses the [url=https://www.gzip.org/]gzip[/url] compression method.
     */
    GZIP(3),
    /**
     * Uses the [url=https://github.com/google/brotli]brotli[/url] compression method (only
     * decompression is supported).
     */
    BROTLI(4),
    ;

    public companion object {
      public fun from(`value`: Long): CompressionMode = entries.single { it.`value` == `value` }
    }
  }

  public class UnixPermissionFlags(
    flag: Long,
  ) : BitFieldBase<UnixPermissionFlags>(flag) {
    protected override fun wrap(flag: Long): UnixPermissionFlags = UnixPermissionFlags(flag)

    public companion object {
      /**
       * Read for owner bit.
       */
      @JvmField
      public val READ_OWNER: UnixPermissionFlags = UnixPermissionFlags(256)

      /**
       * Write for owner bit.
       */
      @JvmField
      public val WRITE_OWNER: UnixPermissionFlags = UnixPermissionFlags(128)

      /**
       * Execute for owner bit.
       */
      @JvmField
      public val EXECUTE_OWNER: UnixPermissionFlags = UnixPermissionFlags(64)

      /**
       * Read for group bit.
       */
      @JvmField
      public val READ_GROUP: UnixPermissionFlags = UnixPermissionFlags(32)

      /**
       * Write for group bit.
       */
      @JvmField
      public val WRITE_GROUP: UnixPermissionFlags = UnixPermissionFlags(16)

      /**
       * Execute for group bit.
       */
      @JvmField
      public val EXECUTE_GROUP: UnixPermissionFlags = UnixPermissionFlags(8)

      /**
       * Read for other bit.
       */
      @JvmField
      public val READ_OTHER: UnixPermissionFlags = UnixPermissionFlags(4)

      /**
       * Write for other bit.
       */
      @JvmField
      public val WRITE_OTHER: UnixPermissionFlags = UnixPermissionFlags(2)

      /**
       * Execute for other bit.
       */
      @JvmField
      public val EXECUTE_OTHER: UnixPermissionFlags = UnixPermissionFlags(1)

      /**
       * Set user id on execution bit.
       */
      @JvmField
      public val SET_USER_ID: UnixPermissionFlags = UnixPermissionFlags(2048)

      /**
       * Set group id on execution bit.
       */
      @JvmField
      public val SET_GROUP_ID: UnixPermissionFlags = UnixPermissionFlags(1024)

      /**
       * Restricted deletion (sticky) bit.
       */
      @JvmField
      public val RESTRICTED_DELETE: UnixPermissionFlags = UnixPermissionFlags(512)
    }
  }

  public companion object {
    @JvmField
    public val openName: MethodStringName2<FileAccess, FileAccess?, String, ModeFlags> =
        MethodStringName2<FileAccess, FileAccess?, String, ModeFlags>("open")

    @JvmField
    public val openEncryptedName:
        MethodStringName4<FileAccess, FileAccess?, String, ModeFlags, PackedByteArray, PackedByteArray>
        =
        MethodStringName4<FileAccess, FileAccess?, String, ModeFlags, PackedByteArray, PackedByteArray>("open_encrypted")

    @JvmField
    public val openEncryptedWithPassName:
        MethodStringName3<FileAccess, FileAccess?, String, ModeFlags, String> =
        MethodStringName3<FileAccess, FileAccess?, String, ModeFlags, String>("open_encrypted_with_pass")

    @JvmField
    public val openCompressedName:
        MethodStringName3<FileAccess, FileAccess?, String, ModeFlags, CompressionMode> =
        MethodStringName3<FileAccess, FileAccess?, String, ModeFlags, CompressionMode>("open_compressed")

    @JvmField
    public val getOpenErrorName: MethodStringName0<FileAccess, Error> =
        MethodStringName0<FileAccess, Error>("get_open_error")

    @JvmField
    public val createTempName:
        MethodStringName4<FileAccess, FileAccess?, ModeFlags, String, String, Boolean> =
        MethodStringName4<FileAccess, FileAccess?, ModeFlags, String, String, Boolean>("create_temp")

    @JvmField
    public val getFileAsBytesName: MethodStringName1<FileAccess, PackedByteArray, String> =
        MethodStringName1<FileAccess, PackedByteArray, String>("get_file_as_bytes")

    @JvmField
    public val getFileAsStringName: MethodStringName1<FileAccess, String, String> =
        MethodStringName1<FileAccess, String, String>("get_file_as_string")

    @JvmField
    public val resizeName: MethodStringName1<FileAccess, Error, Long> =
        MethodStringName1<FileAccess, Error, Long>("resize")

    @JvmField
    public val flushName: MethodStringName0<FileAccess, Unit> =
        MethodStringName0<FileAccess, Unit>("flush")

    @JvmField
    public val getPathName: MethodStringName0<FileAccess, String> =
        MethodStringName0<FileAccess, String>("get_path")

    @JvmField
    public val getPathAbsoluteName: MethodStringName0<FileAccess, String> =
        MethodStringName0<FileAccess, String>("get_path_absolute")

    @JvmField
    public val isOpenName: MethodStringName0<FileAccess, Boolean> =
        MethodStringName0<FileAccess, Boolean>("is_open")

    @JvmField
    public val seekName: MethodStringName1<FileAccess, Unit, Long> =
        MethodStringName1<FileAccess, Unit, Long>("seek")

    @JvmField
    public val seekEndName: MethodStringName1<FileAccess, Unit, Long> =
        MethodStringName1<FileAccess, Unit, Long>("seek_end")

    @JvmField
    public val getPositionName: MethodStringName0<FileAccess, Long> =
        MethodStringName0<FileAccess, Long>("get_position")

    @JvmField
    public val getLengthName: MethodStringName0<FileAccess, Long> =
        MethodStringName0<FileAccess, Long>("get_length")

    @JvmField
    public val eofReachedName: MethodStringName0<FileAccess, Boolean> =
        MethodStringName0<FileAccess, Boolean>("eof_reached")

    @JvmField
    public val get8Name: MethodStringName0<FileAccess, Int> =
        MethodStringName0<FileAccess, Int>("get_8")

    @JvmField
    public val get16Name: MethodStringName0<FileAccess, Int> =
        MethodStringName0<FileAccess, Int>("get_16")

    @JvmField
    public val get32Name: MethodStringName0<FileAccess, Long> =
        MethodStringName0<FileAccess, Long>("get_32")

    @JvmField
    public val get64Name: MethodStringName0<FileAccess, Long> =
        MethodStringName0<FileAccess, Long>("get_64")

    @JvmField
    public val getHalfName: MethodStringName0<FileAccess, Float> =
        MethodStringName0<FileAccess, Float>("get_half")

    @JvmField
    public val getFloatName: MethodStringName0<FileAccess, Float> =
        MethodStringName0<FileAccess, Float>("get_float")

    @JvmField
    public val getDoubleName: MethodStringName0<FileAccess, Double> =
        MethodStringName0<FileAccess, Double>("get_double")

    @JvmField
    public val getRealName: MethodStringName0<FileAccess, Float> =
        MethodStringName0<FileAccess, Float>("get_real")

    @JvmField
    public val getBufferName: MethodStringName1<FileAccess, PackedByteArray, Long> =
        MethodStringName1<FileAccess, PackedByteArray, Long>("get_buffer")

    @JvmField
    public val getLineName: MethodStringName0<FileAccess, String> =
        MethodStringName0<FileAccess, String>("get_line")

    @JvmField
    public val getCsvLineName: MethodStringName1<FileAccess, PackedStringArray, String> =
        MethodStringName1<FileAccess, PackedStringArray, String>("get_csv_line")

    @JvmField
    public val getAsTextName: MethodStringName0<FileAccess, String> =
        MethodStringName0<FileAccess, String>("get_as_text")

    @JvmField
    public val getMd5Name: MethodStringName1<FileAccess, String, String> =
        MethodStringName1<FileAccess, String, String>("get_md5")

    @JvmField
    public val getSha256Name: MethodStringName1<FileAccess, String, String> =
        MethodStringName1<FileAccess, String, String>("get_sha256")

    @JvmField
    public val isBigEndianName: MethodStringName0<FileAccess, Boolean> =
        MethodStringName0<FileAccess, Boolean>("is_big_endian")

    @JvmField
    public val setBigEndianName: MethodStringName1<FileAccess, Unit, Boolean> =
        MethodStringName1<FileAccess, Unit, Boolean>("set_big_endian")

    @JvmField
    public val getErrorName: MethodStringName0<FileAccess, Error> =
        MethodStringName0<FileAccess, Error>("get_error")

    @JvmField
    public val getVarName: MethodStringName1<FileAccess, Any?, Boolean> =
        MethodStringName1<FileAccess, Any?, Boolean>("get_var")

    @JvmField
    public val store8Name: MethodStringName1<FileAccess, Boolean, Int> =
        MethodStringName1<FileAccess, Boolean, Int>("store_8")

    @JvmField
    public val store16Name: MethodStringName1<FileAccess, Boolean, Int> =
        MethodStringName1<FileAccess, Boolean, Int>("store_16")

    @JvmField
    public val store32Name: MethodStringName1<FileAccess, Boolean, Long> =
        MethodStringName1<FileAccess, Boolean, Long>("store_32")

    @JvmField
    public val store64Name: MethodStringName1<FileAccess, Boolean, Long> =
        MethodStringName1<FileAccess, Boolean, Long>("store_64")

    @JvmField
    public val storeHalfName: MethodStringName1<FileAccess, Boolean, Float> =
        MethodStringName1<FileAccess, Boolean, Float>("store_half")

    @JvmField
    public val storeFloatName: MethodStringName1<FileAccess, Boolean, Float> =
        MethodStringName1<FileAccess, Boolean, Float>("store_float")

    @JvmField
    public val storeDoubleName: MethodStringName1<FileAccess, Boolean, Double> =
        MethodStringName1<FileAccess, Boolean, Double>("store_double")

    @JvmField
    public val storeRealName: MethodStringName1<FileAccess, Boolean, Float> =
        MethodStringName1<FileAccess, Boolean, Float>("store_real")

    @JvmField
    public val storeBufferName: MethodStringName1<FileAccess, Boolean, PackedByteArray> =
        MethodStringName1<FileAccess, Boolean, PackedByteArray>("store_buffer")

    @JvmField
    public val storeLineName: MethodStringName1<FileAccess, Boolean, String> =
        MethodStringName1<FileAccess, Boolean, String>("store_line")

    @JvmField
    public val storeCsvLineName: MethodStringName2<FileAccess, Boolean, PackedStringArray, String> =
        MethodStringName2<FileAccess, Boolean, PackedStringArray, String>("store_csv_line")

    @JvmField
    public val storeStringName: MethodStringName1<FileAccess, Boolean, String> =
        MethodStringName1<FileAccess, Boolean, String>("store_string")

    @JvmField
    public val storeVarName: MethodStringName2<FileAccess, Boolean, Any?, Boolean> =
        MethodStringName2<FileAccess, Boolean, Any?, Boolean>("store_var")

    @JvmField
    public val storePascalStringName: MethodStringName1<FileAccess, Boolean, String> =
        MethodStringName1<FileAccess, Boolean, String>("store_pascal_string")

    @JvmField
    public val getPascalStringName: MethodStringName0<FileAccess, String> =
        MethodStringName0<FileAccess, String>("get_pascal_string")

    @JvmField
    public val closeName: MethodStringName0<FileAccess, Unit> =
        MethodStringName0<FileAccess, Unit>("close")

    @JvmField
    public val fileExistsName: MethodStringName1<FileAccess, Boolean, String> =
        MethodStringName1<FileAccess, Boolean, String>("file_exists")

    @JvmField
    public val getModifiedTimeName: MethodStringName1<FileAccess, Long, String> =
        MethodStringName1<FileAccess, Long, String>("get_modified_time")

    @JvmField
    public val getAccessTimeName: MethodStringName1<FileAccess, Long, String> =
        MethodStringName1<FileAccess, Long, String>("get_access_time")

    @JvmField
    public val getSizeName: MethodStringName1<FileAccess, Long, String> =
        MethodStringName1<FileAccess, Long, String>("get_size")

    @JvmField
    public val getUnixPermissionsName: MethodStringName1<FileAccess, UnixPermissionFlags, String> =
        MethodStringName1<FileAccess, UnixPermissionFlags, String>("get_unix_permissions")

    @JvmField
    public val setUnixPermissionsName:
        MethodStringName2<FileAccess, Error, String, UnixPermissionFlags> =
        MethodStringName2<FileAccess, Error, String, UnixPermissionFlags>("set_unix_permissions")

    @JvmField
    public val getHiddenAttributeName: MethodStringName1<FileAccess, Boolean, String> =
        MethodStringName1<FileAccess, Boolean, String>("get_hidden_attribute")

    @JvmField
    public val setHiddenAttributeName: MethodStringName2<FileAccess, Error, String, Boolean> =
        MethodStringName2<FileAccess, Error, String, Boolean>("set_hidden_attribute")

    @JvmField
    public val setReadOnlyAttributeName: MethodStringName2<FileAccess, Error, String, Boolean> =
        MethodStringName2<FileAccess, Error, String, Boolean>("set_read_only_attribute")

    @JvmField
    public val getReadOnlyAttributeName: MethodStringName1<FileAccess, Boolean, String> =
        MethodStringName1<FileAccess, Boolean, String>("get_read_only_attribute")

    @JvmField
    public val getExtendedAttributeName:
        MethodStringName2<FileAccess, PackedByteArray, String, String> =
        MethodStringName2<FileAccess, PackedByteArray, String, String>("get_extended_attribute")

    @JvmField
    public val getExtendedAttributeStringName: MethodStringName2<FileAccess, String, String, String>
        = MethodStringName2<FileAccess, String, String, String>("get_extended_attribute_string")

    @JvmField
    public val setExtendedAttributeName:
        MethodStringName3<FileAccess, Error, String, String, PackedByteArray> =
        MethodStringName3<FileAccess, Error, String, String, PackedByteArray>("set_extended_attribute")

    @JvmField
    public val setExtendedAttributeStringName:
        MethodStringName3<FileAccess, Error, String, String, String> =
        MethodStringName3<FileAccess, Error, String, String, String>("set_extended_attribute_string")

    @JvmField
    public val removeExtendedAttributeName: MethodStringName2<FileAccess, Error, String, String> =
        MethodStringName2<FileAccess, Error, String, String>("remove_extended_attribute")

    @JvmField
    public val getExtendedAttributesListName:
        MethodStringName1<FileAccess, PackedStringArray, String> =
        MethodStringName1<FileAccess, PackedStringArray, String>("get_extended_attributes_list")

    /**
     * Creates a new [FileAccess] object and opens the file for writing or reading, depending on the
     * flags.
     *
     * Returns `null` if opening the file failed. You can use [getOpenError] to check the error that
     * occurred.
     */
    @JvmStatic
    public final fun `open`(path: String, flags: ModeFlags): FileAccess? {
      TransferContext.writeMethodArguments(0L, 0L, STRING to path, LONG to flags.value)
      TransferContext.callMethod(MethodBindings.openPtr)
      return (TransferContext.readReturnValue(OBJECT) as FileAccess?)
    }

    /**
     * Creates a new [FileAccess] object and opens an encrypted file in write or read mode. You need
     * to pass a binary key to encrypt/decrypt it.
     *
     * **Note:** The provided key must be 32 bytes long.
     *
     * Returns `null` if opening the file failed. You can use [getOpenError] to check the error that
     * occurred.
     */
    @JvmOverloads
    @JvmStatic
    public final fun openEncrypted(
      path: String,
      modeFlags: ModeFlags,
      key: PackedByteArray,
      iv: PackedByteArray = PackedByteArray(),
    ): FileAccess? {
      TransferContext.writeMethodArguments(0L, 0L, STRING to path, LONG to modeFlags.value, PACKED_BYTE_ARRAY to key, PACKED_BYTE_ARRAY to iv)
      TransferContext.callMethod(MethodBindings.openEncryptedPtr)
      return (TransferContext.readReturnValue(OBJECT) as FileAccess?)
    }

    /**
     * Creates a new [FileAccess] object and opens an encrypted file in write or read mode. You need
     * to pass a password to encrypt/decrypt it.
     *
     * Returns `null` if opening the file failed. You can use [getOpenError] to check the error that
     * occurred.
     */
    @JvmStatic
    public final fun openEncryptedWithPass(
      path: String,
      modeFlags: ModeFlags,
      pass: String,
    ): FileAccess? {
      TransferContext.writeMethodArguments(0L, 0L, STRING to path, LONG to modeFlags.value, STRING to pass)
      TransferContext.callMethod(MethodBindings.openEncryptedWithPassPtr)
      return (TransferContext.readReturnValue(OBJECT) as FileAccess?)
    }

    /**
     * Creates a new [FileAccess] object and opens a compressed file for reading or writing.
     *
     * **Note:** [openCompressed] can only read files that were saved by Godot, not third-party
     * compression formats. See [url=https://github.com/godotengine/godot/issues/28999]GitHub issue
     * #28999[/url] for a workaround.
     *
     * Returns `null` if opening the file failed. You can use [getOpenError] to check the error that
     * occurred.
     */
    @JvmOverloads
    @JvmStatic
    public final fun openCompressed(
      path: String,
      modeFlags: ModeFlags,
      compressionMode: CompressionMode = FileAccess.CompressionMode.FASTLZ,
    ): FileAccess? {
      TransferContext.writeMethodArguments(0L, 0L, STRING to path, LONG to modeFlags.value, LONG to compressionMode.value)
      TransferContext.callMethod(MethodBindings.openCompressedPtr)
      return (TransferContext.readReturnValue(OBJECT) as FileAccess?)
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
     * Creates a temporary file. This file will be freed when the returned [FileAccess] is freed.
     *
     * If [prefix] is not empty, it will be prefixed to the file name, separated by a `-`.
     *
     * If [extension] is not empty, it will be appended to the temporary file name.
     *
     * If [keep] is `true`, the file is not deleted when the returned [FileAccess] is freed.
     *
     * Returns `null` if opening the file failed. You can use [getOpenError] to check the error that
     * occurred.
     */
    @JvmOverloads
    @JvmStatic
    public final fun createTemp(
      modeFlags: ModeFlags,
      prefix: String = "",
      extension: String = "",
      keep: Boolean = false,
    ): FileAccess? {
      TransferContext.writeMethodArguments(0L, 0L, LONG to modeFlags.value, STRING to prefix, STRING to extension, BOOL to keep)
      TransferContext.callMethod(MethodBindings.createTempPtr)
      return (TransferContext.readReturnValue(OBJECT) as FileAccess?)
    }

    /**
     * Returns the whole [path] file contents as a [PackedByteArray] without any decoding.
     *
     * Returns an empty [PackedByteArray] if an error occurred while opening the file. You can use
     * [getOpenError] to check the error that occurred.
     */
    @JvmStatic
    public final fun getFileAsBytes(path: String): PackedByteArray {
      TransferContext.writeMethodArguments(0L, 0L, STRING to path)
      TransferContext.callMethod(MethodBindings.getFileAsBytesPtr)
      return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
    }

    /**
     * Returns the whole [path] file contents as a [String]. Text is interpreted as being UTF-8
     * encoded.
     *
     * Returns an empty [String] if an error occurred while opening the file. You can use
     * [getOpenError] to check the error that occurred.
     */
    @JvmStatic
    public final fun getFileAsString(path: String): String {
      TransferContext.writeMethodArguments(0L, 0L, STRING to path)
      TransferContext.callMethod(MethodBindings.getFileAsStringPtr)
      return (TransferContext.readReturnValue(STRING) as String)
    }

    /**
     * Returns an MD5 String representing the file at the given path or an empty [String] on
     * failure.
     */
    @JvmStatic
    public final fun getMd5(path: String): String {
      TransferContext.writeMethodArguments(0L, 0L, STRING to path)
      TransferContext.callMethod(MethodBindings.getMd5Ptr)
      return (TransferContext.readReturnValue(STRING) as String)
    }

    /**
     * Returns an SHA-256 [String] representing the file at the given path or an empty [String] on
     * failure.
     */
    @JvmStatic
    public final fun getSha256(path: String): String {
      TransferContext.writeMethodArguments(0L, 0L, STRING to path)
      TransferContext.callMethod(MethodBindings.getSha256Ptr)
      return (TransferContext.readReturnValue(STRING) as String)
    }

    /**
     * Returns `true` if the file exists in the given path.
     *
     * **Note:** Many resources types are imported (e.g. textures or sound files), and their source
     * asset will not be included in the exported game, as only the imported version is used. See
     * [ResourceLoader.exists] for an alternative approach that takes resource remapping into account.
     *
     * For a non-static, relative equivalent, use [DirAccess.fileExists].
     */
    @JvmStatic
    public final fun fileExists(path: String): Boolean {
      TransferContext.writeMethodArguments(0L, 0L, STRING to path)
      TransferContext.callMethod(MethodBindings.fileExistsPtr)
      return (TransferContext.readReturnValue(BOOL) as Boolean)
    }

    /**
     * Returns the last time the [file] was modified in Unix timestamp format, or `0` on error. This
     * Unix timestamp can be converted to another format using the [Time] singleton.
     */
    @JvmStatic
    public final fun getModifiedTime(`file`: String): Long {
      TransferContext.writeMethodArguments(0L, 0L, STRING to file)
      TransferContext.callMethod(MethodBindings.getModifiedTimePtr)
      return (TransferContext.readReturnValue(LONG) as Long)
    }

    /**
     * Returns the last time the [file] was accessed in Unix timestamp format, or `0` on error. This
     * Unix timestamp can be converted to another format using the [Time] singleton.
     */
    @JvmStatic
    public final fun getAccessTime(`file`: String): Long {
      TransferContext.writeMethodArguments(0L, 0L, STRING to file)
      TransferContext.callMethod(MethodBindings.getAccessTimePtr)
      return (TransferContext.readReturnValue(LONG) as Long)
    }

    /**
     * Returns the size of the file at the given path, in bytes, or `-1` on error.
     */
    @JvmStatic
    public final fun getSize(`file`: String): Long {
      TransferContext.writeMethodArguments(0L, 0L, STRING to file)
      TransferContext.callMethod(MethodBindings.getSizePtr)
      return (TransferContext.readReturnValue(LONG) as Long)
    }

    /**
     * Returns the UNIX permissions of the file at the given path.
     *
     * **Note:** This method is implemented on iOS, Linux/BSD, and macOS.
     */
    @JvmStatic
    public final fun getUnixPermissions(`file`: String): UnixPermissionFlags {
      TransferContext.writeMethodArguments(0L, 0L, STRING to file)
      TransferContext.callMethod(MethodBindings.getUnixPermissionsPtr)
      return UnixPermissionFlags(TransferContext.readReturnValue(LONG) as Long)
    }

    /**
     * Sets file UNIX permissions.
     *
     * **Note:** This method is implemented on iOS, Linux/BSD, and macOS.
     */
    @JvmStatic
    public final fun setUnixPermissions(`file`: String, permissions: UnixPermissionFlags): Error {
      TransferContext.writeMethodArguments(0L, 0L, STRING to file, LONG to permissions.flag)
      TransferContext.callMethod(MethodBindings.setUnixPermissionsPtr)
      return Error.from(TransferContext.readReturnValue(LONG) as Long)
    }

    /**
     * Returns `true` if the **hidden** attribute is set on the file at the given path.
     *
     * **Note:** This method is implemented on iOS, BSD, macOS, and Windows.
     */
    @JvmStatic
    public final fun getHiddenAttribute(`file`: String): Boolean {
      TransferContext.writeMethodArguments(0L, 0L, STRING to file)
      TransferContext.callMethod(MethodBindings.getHiddenAttributePtr)
      return (TransferContext.readReturnValue(BOOL) as Boolean)
    }

    /**
     * Sets file **hidden** attribute.
     *
     * **Note:** This method is implemented on iOS, BSD, macOS, and Windows.
     */
    @JvmStatic
    public final fun setHiddenAttribute(`file`: String, hidden: Boolean): Error {
      TransferContext.writeMethodArguments(0L, 0L, STRING to file, BOOL to hidden)
      TransferContext.callMethod(MethodBindings.setHiddenAttributePtr)
      return Error.from(TransferContext.readReturnValue(LONG) as Long)
    }

    /**
     * Sets file **read only** attribute.
     *
     * **Note:** This method is implemented on iOS, BSD, macOS, and Windows.
     */
    @JvmStatic
    public final fun setReadOnlyAttribute(`file`: String, ro: Boolean): Error {
      TransferContext.writeMethodArguments(0L, 0L, STRING to file, BOOL to ro)
      TransferContext.callMethod(MethodBindings.setReadOnlyAttributePtr)
      return Error.from(TransferContext.readReturnValue(LONG) as Long)
    }

    /**
     * Returns `true` if the **read only** attribute is set on the file at the given path.
     *
     * **Note:** This method is implemented on iOS, BSD, macOS, and Windows.
     */
    @JvmStatic
    public final fun getReadOnlyAttribute(`file`: String): Boolean {
      TransferContext.writeMethodArguments(0L, 0L, STRING to file)
      TransferContext.callMethod(MethodBindings.getReadOnlyAttributePtr)
      return (TransferContext.readReturnValue(BOOL) as Boolean)
    }

    /**
     * Reads the file extended attribute with name [attributeName] as a byte array.
     *
     * **Note:** This method is implemented on Linux, macOS, and Windows.
     *
     * **Note:** Extended attributes support depends on the file system. Attributes will be lost
     * when the file is moved between incompatible file systems.
     *
     * **Note:** On Linux, only "user" namespace attributes are accessible, namespace prefix should
     * not be included.
     *
     * **Note:** On Windows, alternate data streams are used to store extended attributes.
     */
    @JvmStatic
    public final fun getExtendedAttribute(`file`: String, attributeName: String): PackedByteArray {
      TransferContext.writeMethodArguments(0L, 0L, STRING to file, STRING to attributeName)
      TransferContext.callMethod(MethodBindings.getExtendedAttributePtr)
      return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
    }

    /**
     * Reads the file extended attribute with name [attributeName] as a UTF-8 encoded string.
     *
     * **Note:** This method is implemented on Linux, macOS, and Windows.
     *
     * **Note:** Extended attributes support depends on the file system. Attributes will be lost
     * when the file is moved between incompatible file systems.
     *
     * **Note:** On Linux, only "user" namespace attributes are accessible, namespace prefix should
     * not be included.
     *
     * **Note:** On Windows, alternate data streams are used to store extended attributes.
     */
    @JvmStatic
    public final fun getExtendedAttributeString(`file`: String, attributeName: String): String {
      TransferContext.writeMethodArguments(0L, 0L, STRING to file, STRING to attributeName)
      TransferContext.callMethod(MethodBindings.getExtendedAttributeStringPtr)
      return (TransferContext.readReturnValue(STRING) as String)
    }

    /**
     * Writes file extended attribute with name [attributeName] as a byte array.
     *
     * **Note:** This method is implemented on Linux, macOS, and Windows.
     *
     * **Note:** Extended attributes support depends on the file system. Attributes will be lost
     * when the file is moved between incompatible file systems.
     *
     * **Note:** On Linux, only "user" namespace attributes are accessible, namespace prefix should
     * not be included.
     *
     * **Note:** On Windows, alternate data streams are used to store extended attributes.
     */
    @JvmStatic
    public final fun setExtendedAttribute(
      `file`: String,
      attributeName: String,
      `data`: PackedByteArray,
    ): Error {
      TransferContext.writeMethodArguments(0L, 0L, STRING to file, STRING to attributeName, PACKED_BYTE_ARRAY to data)
      TransferContext.callMethod(MethodBindings.setExtendedAttributePtr)
      return Error.from(TransferContext.readReturnValue(LONG) as Long)
    }

    /**
     * Writes file extended attribute with name [attributeName] as a UTF-8 encoded string.
     *
     * **Note:** This method is implemented on Linux, macOS, and Windows.
     *
     * **Note:** Extended attributes support depends on the file system. Attributes will be lost
     * when the file is moved between incompatible file systems.
     *
     * **Note:** On Linux, only "user" namespace attributes are accessible, namespace prefix should
     * not be included.
     *
     * **Note:** On Windows, alternate data streams are used to store extended attributes.
     */
    @JvmStatic
    public final fun setExtendedAttributeString(
      `file`: String,
      attributeName: String,
      `data`: String,
    ): Error {
      TransferContext.writeMethodArguments(0L, 0L, STRING to file, STRING to attributeName, STRING to data)
      TransferContext.callMethod(MethodBindings.setExtendedAttributeStringPtr)
      return Error.from(TransferContext.readReturnValue(LONG) as Long)
    }

    /**
     * Removes file extended attribute with name [attributeName].
     *
     * **Note:** This method is implemented on Linux, macOS, and Windows.
     *
     * **Note:** Extended attributes support depends on the file system. Attributes will be lost
     * when the file is moved between incompatible file systems.
     *
     * **Note:** On Linux, only "user" namespace attributes are accessible, namespace prefix should
     * not be included.
     *
     * **Note:** On Windows, alternate data streams are used to store extended attributes.
     */
    @JvmStatic
    public final fun removeExtendedAttribute(`file`: String, attributeName: String): Error {
      TransferContext.writeMethodArguments(0L, 0L, STRING to file, STRING to attributeName)
      TransferContext.callMethod(MethodBindings.removeExtendedAttributePtr)
      return Error.from(TransferContext.readReturnValue(LONG) as Long)
    }

    /**
     * Returns a list of file extended attributes.
     *
     * **Note:** This method is implemented on Linux, macOS, and Windows.
     *
     * **Note:** Extended attributes support depends on the file system. Attributes will be lost
     * when the file is moved between incompatible file systems.
     *
     * **Note:** On Linux, only "user" namespace attributes are accessible, namespace prefix should
     * not be included.
     *
     * **Note:** On Windows, alternate data streams are used to store extended attributes.
     */
    @JvmStatic
    public final fun getExtendedAttributesList(`file`: String): PackedStringArray {
      TransferContext.writeMethodArguments(0L, 0L, STRING to file)
      TransferContext.callMethod(MethodBindings.getExtendedAttributesListPtr)
      return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
    }
  }

  public object MethodBindings {
    internal val openPtr: VoidPtr = TypeManager.getMethodBindPtr("FileAccess", "open", 1247358404)

    internal val openEncryptedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "open_encrypted", 788003459)

    internal val openEncryptedWithPassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "open_encrypted_with_pass", 790283377)

    internal val openCompressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "open_compressed", 3686439335)

    internal val getOpenErrorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_open_error", 166280745)

    internal val createTempPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "create_temp", 171914364)

    internal val getFileAsBytesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_file_as_bytes", 659035735)

    internal val getFileAsStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_file_as_string", 1703090593)

    internal val resizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "resize", 844576869)

    internal val flushPtr: VoidPtr = TypeManager.getMethodBindPtr("FileAccess", "flush", 3218959716)

    internal val getPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_path", 201670096)

    internal val getPathAbsolutePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_path_absolute", 201670096)

    internal val isOpenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "is_open", 36873697)

    internal val seekPtr: VoidPtr = TypeManager.getMethodBindPtr("FileAccess", "seek", 1286410249)

    internal val seekEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "seek_end", 1995695955)

    internal val getPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_position", 3905245786)

    internal val getLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_length", 3905245786)

    internal val eofReachedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "eof_reached", 36873697)

    internal val get8Ptr: VoidPtr = TypeManager.getMethodBindPtr("FileAccess", "get_8", 3905245786)

    internal val get16Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_16", 3905245786)

    internal val get32Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_32", 3905245786)

    internal val get64Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_64", 3905245786)

    internal val getHalfPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_half", 1740695150)

    internal val getFloatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_float", 1740695150)

    internal val getDoublePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_double", 1740695150)

    internal val getRealPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_real", 1740695150)

    internal val getBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_buffer", 4131300905)

    internal val getLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_line", 201670096)

    internal val getCsvLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_csv_line", 2358116058)

    internal val getAsTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_as_text", 201670096)

    internal val getMd5Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_md5", 1703090593)

    internal val getSha256Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_sha256", 1703090593)

    internal val isBigEndianPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "is_big_endian", 36873697)

    internal val setBigEndianPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "set_big_endian", 2586408642)

    internal val getErrorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_error", 3185525595)

    internal val getVarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_var", 189129690)

    internal val store8Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "store_8", 3067735520)

    internal val store16Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "store_16", 3067735520)

    internal val store32Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "store_32", 3067735520)

    internal val store64Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "store_64", 3067735520)

    internal val storeHalfPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "store_half", 330693286)

    internal val storeFloatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "store_float", 330693286)

    internal val storeDoublePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "store_double", 330693286)

    internal val storeRealPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "store_real", 330693286)

    internal val storeBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "store_buffer", 114037665)

    internal val storeLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "store_line", 2323990056)

    internal val storeCsvLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "store_csv_line", 1611473434)

    internal val storeStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "store_string", 2323990056)

    internal val storeVarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "store_var", 117357437)

    internal val storePascalStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "store_pascal_string", 2323990056)

    internal val getPascalStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_pascal_string", 2841200299)

    internal val closePtr: VoidPtr = TypeManager.getMethodBindPtr("FileAccess", "close", 3218959716)

    internal val fileExistsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "file_exists", 2323990056)

    internal val getModifiedTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_modified_time", 1597066294)

    internal val getAccessTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_access_time", 1597066294)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_size", 1597066294)

    internal val getUnixPermissionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_unix_permissions", 524341837)

    internal val setUnixPermissionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "set_unix_permissions", 846038644)

    internal val getHiddenAttributePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_hidden_attribute", 2323990056)

    internal val setHiddenAttributePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "set_hidden_attribute", 2892558115)

    internal val setReadOnlyAttributePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "set_read_only_attribute", 2892558115)

    internal val getReadOnlyAttributePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_read_only_attribute", 2323990056)

    internal val getExtendedAttributePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_extended_attribute", 955893464)

    internal val getExtendedAttributeStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_extended_attribute_string", 1218461987)

    internal val setExtendedAttributePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "set_extended_attribute", 2643421469)

    internal val setExtendedAttributeStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "set_extended_attribute_string", 699024349)

    internal val removeExtendedAttributePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "remove_extended_attribute", 852856452)

    internal val getExtendedAttributesListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FileAccess", "get_extended_attributes_list", 3538744774)
  }
}
