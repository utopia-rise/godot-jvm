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
import godot.core.PackedByteArray
import godot.core.PackedStringArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.PACKED_BYTE_ARRAY
import godot.core.VariantParser.PACKED_STRING_ARRAY
import godot.core.VariantParser.STRING
import kotlin.Any
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * This helper class can be used to store [Any] values on the filesystem using INI-style formatting.
 * The stored values are identified by a section and a key:
 *
 * [codeblock lang=text]
 *
 * [section]
 *
 * some_key=42
 *
 * string_example="Hello World3D!"
 *
 * a_vector=Vector3(1, 0, 2)
 *
 * ```
 * The stored data can be saved to or parsed from a file, though ConfigFile objects can also be used
 * directly without accessing the filesystem.
 * The following example shows how to create a simple [ConfigFile] and save it on disc:
 *
 * ```gdscript
 *
 * //gdscript
 *
 * # Create new ConfigFile object.
 *
 * var config = ConfigFile.new()
 *
 * # Store some values.
 *
 * config.set_value("Player1", "player_name", "Steve")
 *
 * config.set_value("Player1", "best_score", 10)
 *
 * config.set_value("Player2", "player_name", "V3geta")
 *
 * config.set_value("Player2", "best_score", 9001)
 *
 * # Save it to a file (overwrite if already exists).
 *
 * config.save("user://scores.cfg")
 *
 * ```
 * ```csharp
 *
 * //csharp
 *
 * // Create new ConfigFile object.
 *
 * var config = new ConfigFile();
 *
 * // Store some values.
 *
 * config.SetValue("Player1", "player_name", "Steve");
 *
 * config.SetValue("Player1", "best_score", 10);
 *
 * config.SetValue("Player2", "player_name", "V3geta");
 *
 * config.SetValue("Player2", "best_score", 9001);
 *
 * // Save it to a file (overwrite if already exists).
 *
 * config.Save("user://scores.cfg");
 *
 * ```
 *
 * This example shows how the above file could be loaded:
 *
 * ```gdscript
 *
 * //gdscript
 *
 * var score_data = {}
 *
 * var config = ConfigFile.new()
 *
 * # Load data from a file.
 *
 * var err = config.load("user://scores.cfg")
 *
 * # If the file didn't load, ignore it.
 *
 * if err != OK:
 *
 * 	return
 *
 * # Iterate over all sections.
 *
 * for player in config.get_sections():
 *
 * 	# Fetch the data for each section.
 *
 * 	var player_name = config.get_value(player, "player_name")
 *
 * 	var player_score = config.get_value(player, "best_score")
 *
 * 	score_data[player_name] = player_score
 *
 * ```
 * ```csharp
 *
 * //csharp
 *
 * var score_data = new Godot.Collections.Dictionary();
 *
 * var config = new ConfigFile();
 *
 * // Load data from a file.
 *
 * Error err = config.Load("user://scores.cfg");
 *
 * // If the file didn't load, ignore it.
 *
 * if (err != Error.Ok)
 *
 * {
 *
 * 	return;
 *
 * }
 *
 * // Iterate over all sections.
 *
 * foreach (String player in config.GetSections())
 *
 * {
 *
 * 	// Fetch the data for each section.
 *
 * 	var player_name = (String)config.GetValue(player, "player_name");
 *
 * 	var player_score = (int)config.GetValue(player, "best_score");
 *
 * 	score_data[player_name] = player_score;
 *
 * }
 *
 * ```
 *
 * Any operation that mutates the ConfigFile such as [setValue], [clear], or [eraseSection], only
 * changes what is loaded in memory. If you want to write the change to a file, you have to save the
 * changes with [save], [saveEncrypted], or [saveEncryptedPass].
 *
 * Keep in mind that section and property names can't contain spaces. Anything after a space will be
 * ignored on save and on load.
 *
 * ConfigFiles can also contain manually written comment lines starting with a semicolon (`;`).
 * Those lines will be ignored when parsing the file. Note that comments will be lost when saving the
 * ConfigFile. This can still be useful for dedicated server configuration files, which are typically
 * never overwritten without explicit user action.
 *
 * **Note:** The file extension given to a ConfigFile does not have any impact on its formatting or
 * behavior. By convention, the `.cfg` extension is used here, but any other extension such as `.ini`
 * is also valid. Since neither `.cfg` nor `.ini` are standardized, Godot's ConfigFile formatting may
 * differ from files written by other programs.
 */
@GodotBaseType
public open class ConfigFile : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(184, scriptPtr)
  }

  /**
   * Assigns a value to the specified key of the specified section. If either the section or the key
   * do not exist, they are created. Passing a `null` value deletes the specified key if it exists, and
   * deletes the section if it ends up empty once the key has been removed.
   */
  public final fun setValue(
    section: String,
    key: String,
    `value`: Any?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to section, STRING to key, ANY to value)
    TransferContext.callMethod(MethodBindings.setValuePtr)
  }

  /**
   * Returns the current value for the specified section and key. If either the section or the key
   * do not exist, the method returns the fallback [default] value. If [default] is not specified or
   * set to `null`, an error is also raised.
   */
  @JvmOverloads
  public final fun getValue(
    section: String,
    key: String,
    default: Any? = null,
  ): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to section, STRING to key, ANY to default)
    TransferContext.callMethod(MethodBindings.getValuePtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns `true` if the specified section exists.
   */
  public final fun hasSection(section: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to section)
    TransferContext.callMethod(MethodBindings.hasSectionPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the specified section-key pair exists.
   */
  public final fun hasSectionKey(section: String, key: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to section, STRING to key)
    TransferContext.callMethod(MethodBindings.hasSectionKeyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns an array of all defined section identifiers.
   */
  public final fun getSections(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSectionsPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Returns an array of all defined key identifiers in the specified section. Raises an error and
   * returns an empty array if the section does not exist.
   */
  public final fun getSectionKeys(section: String): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to section)
    TransferContext.callMethod(MethodBindings.getSectionKeysPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  /**
   * Deletes the specified section along with all the key-value pairs inside. Raises an error if the
   * section does not exist.
   */
  public final fun eraseSection(section: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to section)
    TransferContext.callMethod(MethodBindings.eraseSectionPtr)
  }

  /**
   * Deletes the specified key in a section. Raises an error if either the section or the key do not
   * exist.
   */
  public final fun eraseSectionKey(section: String, key: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to section, STRING to key)
    TransferContext.callMethod(MethodBindings.eraseSectionKeyPtr)
  }

  /**
   * Loads the config file specified as a parameter. The file's contents are parsed and loaded in
   * the [ConfigFile] object which the method was called on.
   *
   * Returns [OK] on success, or one of the other [Error] values if the operation failed.
   */
  public final fun load(path: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.loadPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Parses the passed string as the contents of a config file. The string is parsed and loaded in
   * the ConfigFile object which the method was called on.
   *
   * Returns [OK] on success, or one of the other [Error] values if the operation failed.
   */
  public final fun parse(`data`: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to data)
    TransferContext.callMethod(MethodBindings.parsePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Saves the contents of the [ConfigFile] object to the file specified as a parameter. The output
   * file uses an INI-style structure.
   *
   * Returns [OK] on success, or one of the other [Error] values if the operation failed.
   */
  public final fun save(path: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path)
    TransferContext.callMethod(MethodBindings.savePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Obtain the text version of this config file (the same text that would be written to a file).
   */
  public final fun encodeToText(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.encodeToTextPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Loads the encrypted config file specified as a parameter, using the provided [key] to decrypt
   * it. The file's contents are parsed and loaded in the [ConfigFile] object which the method was
   * called on.
   *
   * Returns [OK] on success, or one of the other [Error] values if the operation failed.
   */
  public final fun loadEncrypted(path: String, key: PackedByteArray): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path, PACKED_BYTE_ARRAY to key)
    TransferContext.callMethod(MethodBindings.loadEncryptedPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Loads the encrypted config file specified as a parameter, using the provided [password] to
   * decrypt it. The file's contents are parsed and loaded in the [ConfigFile] object which the method
   * was called on.
   *
   * Returns [OK] on success, or one of the other [Error] values if the operation failed.
   */
  public final fun loadEncryptedPass(path: String, password: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path, STRING to password)
    TransferContext.callMethod(MethodBindings.loadEncryptedPassPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Saves the contents of the [ConfigFile] object to the AES-256 encrypted file specified as a
   * parameter, using the provided [key] to encrypt it. The output file uses an INI-style structure.
   *
   * Returns [OK] on success, or one of the other [Error] values if the operation failed.
   */
  public final fun saveEncrypted(path: String, key: PackedByteArray): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path, PACKED_BYTE_ARRAY to key)
    TransferContext.callMethod(MethodBindings.saveEncryptedPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Saves the contents of the [ConfigFile] object to the AES-256 encrypted file specified as a
   * parameter, using the provided [password] to encrypt it. The output file uses an INI-style
   * structure.
   *
   * Returns [OK] on success, or one of the other [Error] values if the operation failed.
   */
  public final fun saveEncryptedPass(path: String, password: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to path, STRING to password)
    TransferContext.callMethod(MethodBindings.saveEncryptedPassPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Removes the entire contents of the config.
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPtr)
  }

  public companion object {
    @JvmField
    public val setValueName: MethodStringName3<ConfigFile, Unit, String, String, Any?> =
        MethodStringName3<ConfigFile, Unit, String, String, Any?>("set_value")

    @JvmField
    public val getValueName: MethodStringName3<ConfigFile, Any?, String, String, Any?> =
        MethodStringName3<ConfigFile, Any?, String, String, Any?>("get_value")

    @JvmField
    public val hasSectionName: MethodStringName1<ConfigFile, Boolean, String> =
        MethodStringName1<ConfigFile, Boolean, String>("has_section")

    @JvmField
    public val hasSectionKeyName: MethodStringName2<ConfigFile, Boolean, String, String> =
        MethodStringName2<ConfigFile, Boolean, String, String>("has_section_key")

    @JvmField
    public val getSectionsName: MethodStringName0<ConfigFile, PackedStringArray> =
        MethodStringName0<ConfigFile, PackedStringArray>("get_sections")

    @JvmField
    public val getSectionKeysName: MethodStringName1<ConfigFile, PackedStringArray, String> =
        MethodStringName1<ConfigFile, PackedStringArray, String>("get_section_keys")

    @JvmField
    public val eraseSectionName: MethodStringName1<ConfigFile, Unit, String> =
        MethodStringName1<ConfigFile, Unit, String>("erase_section")

    @JvmField
    public val eraseSectionKeyName: MethodStringName2<ConfigFile, Unit, String, String> =
        MethodStringName2<ConfigFile, Unit, String, String>("erase_section_key")

    @JvmField
    public val loadName: MethodStringName1<ConfigFile, Error, String> =
        MethodStringName1<ConfigFile, Error, String>("load")

    @JvmField
    public val parseName: MethodStringName1<ConfigFile, Error, String> =
        MethodStringName1<ConfigFile, Error, String>("parse")

    @JvmField
    public val saveName: MethodStringName1<ConfigFile, Error, String> =
        MethodStringName1<ConfigFile, Error, String>("save")

    @JvmField
    public val encodeToTextName: MethodStringName0<ConfigFile, String> =
        MethodStringName0<ConfigFile, String>("encode_to_text")

    @JvmField
    public val loadEncryptedName: MethodStringName2<ConfigFile, Error, String, PackedByteArray> =
        MethodStringName2<ConfigFile, Error, String, PackedByteArray>("load_encrypted")

    @JvmField
    public val loadEncryptedPassName: MethodStringName2<ConfigFile, Error, String, String> =
        MethodStringName2<ConfigFile, Error, String, String>("load_encrypted_pass")

    @JvmField
    public val saveEncryptedName: MethodStringName2<ConfigFile, Error, String, PackedByteArray> =
        MethodStringName2<ConfigFile, Error, String, PackedByteArray>("save_encrypted")

    @JvmField
    public val saveEncryptedPassName: MethodStringName2<ConfigFile, Error, String, String> =
        MethodStringName2<ConfigFile, Error, String, String>("save_encrypted_pass")

    @JvmField
    public val clearName: MethodStringName0<ConfigFile, Unit> =
        MethodStringName0<ConfigFile, Unit>("clear")
  }

  public object MethodBindings {
    internal val setValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConfigFile", "set_value", 2504492430)

    internal val getValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConfigFile", "get_value", 89809366)

    internal val hasSectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConfigFile", "has_section", 3927539163)

    internal val hasSectionKeyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConfigFile", "has_section_key", 820780508)

    internal val getSectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConfigFile", "get_sections", 1139954409)

    internal val getSectionKeysPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConfigFile", "get_section_keys", 4291131558)

    internal val eraseSectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConfigFile", "erase_section", 83702148)

    internal val eraseSectionKeyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConfigFile", "erase_section_key", 3186203200)

    internal val loadPtr: VoidPtr = TypeManager.getMethodBindPtr("ConfigFile", "load", 166001499)

    internal val parsePtr: VoidPtr = TypeManager.getMethodBindPtr("ConfigFile", "parse", 166001499)

    internal val savePtr: VoidPtr = TypeManager.getMethodBindPtr("ConfigFile", "save", 166001499)

    internal val encodeToTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConfigFile", "encode_to_text", 201670096)

    internal val loadEncryptedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConfigFile", "load_encrypted", 887037711)

    internal val loadEncryptedPassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConfigFile", "load_encrypted_pass", 852856452)

    internal val saveEncryptedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConfigFile", "save_encrypted", 887037711)

    internal val saveEncryptedPassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConfigFile", "save_encrypted_pass", 852856452)

    internal val clearPtr: VoidPtr = TypeManager.getMethodBindPtr("ConfigFile", "clear", 3218959716)
  }
}
