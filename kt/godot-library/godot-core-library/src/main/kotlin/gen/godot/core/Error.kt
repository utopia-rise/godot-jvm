// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.core

import kotlin.Long
import kotlin.Suppress

public enum class Error(
  public override val `value`: Long,
) : GodotEnum {
  /**
   * Methods that return [Error] return [OK] when no error occurred.
   *
   * Since [OK] has value `0`, and all other error constants are positive integers, it can also be
   * used in boolean checks.
   *
   * ```
   * var error = method_that_returns_error()
   * if error != OK:
   * 	printerr("Failure!")
   *
   * # Or, alternatively:
   * if error:
   * 	printerr("Still failing!")
   * ```
   *
   * **Note:** Many functions do not return an error code, but will print error messages to standard
   * output.
   */
  OK(0),
  /**
   * Generic error.
   */
  FAILED(1),
  /**
   * Unavailable error.
   */
  UNAVAILABLE(2),
  /**
   * Unconfigured error.
   */
  UNCONFIGURED(3),
  /**
   * Unauthorized error.
   */
  UNAUTHORIZED(4),
  /**
   * Parameter range error.
   */
  PARAMETER_RANGE(5),
  /**
   * Out of memory (OOM) error.
   */
  OUT_OF_MEMORY(6),
  /**
   * File: Not found error.
   */
  FILE_NOT_FOUND(7),
  /**
   * File: Bad drive error.
   */
  FILE_BAD_DRIVE(8),
  /**
   * File: Bad path error.
   */
  FILE_BAD_PATH(9),
  /**
   * File: No permission error.
   */
  FILE_NO_PERMISSION(10),
  /**
   * File: Already in use error.
   */
  FILE_ALREADY_IN_USE(11),
  /**
   * File: Can't open error.
   */
  FILE_CANT_OPEN(12),
  /**
   * File: Can't write error.
   */
  FILE_CANT_WRITE(13),
  /**
   * File: Can't read error.
   */
  FILE_CANT_READ(14),
  /**
   * File: Unrecognized error.
   */
  FILE_UNRECOGNIZED(15),
  /**
   * File: Corrupt error.
   */
  FILE_CORRUPT(16),
  /**
   * File: Missing dependencies error.
   */
  FILE_MISSING_DEPENDENCIES(17),
  /**
   * File: End of file (EOF) error.
   */
  FILE_EOF(18),
  /**
   * Can't open error.
   */
  CANT_OPEN(19),
  /**
   * Can't create error.
   */
  CANT_CREATE(20),
  /**
   * Query failed error.
   */
  QUERY_FAILED(21),
  /**
   * Already in use error.
   */
  ALREADY_IN_USE(22),
  /**
   * Locked error.
   */
  LOCKED(23),
  /**
   * Timeout error.
   */
  TIMEOUT(24),
  /**
   * Can't connect error.
   */
  CANT_CONNECT(25),
  /**
   * Can't resolve error.
   */
  CANT_RESOLVE(26),
  /**
   * Connection error.
   */
  CONNECTION(27),
  /**
   * Can't acquire resource error.
   */
  CANT_ACQUIRE_RESOURCE(28),
  /**
   * Can't fork process error.
   */
  CANT_FORK(29),
  /**
   * Invalid data error.
   */
  INVALID_DATA(30),
  /**
   * Invalid parameter error.
   */
  INVALID_PARAMETER(31),
  /**
   * Already exists error.
   */
  ALREADY_EXISTS(32),
  /**
   * Does not exist error.
   */
  DOES_NOT_EXIST(33),
  /**
   * Database: Read error.
   */
  DATABASE_CANT_READ(34),
  /**
   * Database: Write error.
   */
  DATABASE_CANT_WRITE(35),
  /**
   * Compilation failed error.
   */
  COMPILATION_FAILED(36),
  /**
   * Method not found error.
   */
  METHOD_NOT_FOUND(37),
  /**
   * Linking failed error.
   */
  LINK_FAILED(38),
  /**
   * Script failed error.
   */
  SCRIPT_FAILED(39),
  /**
   * Cycling link (import cycle) error.
   */
  CYCLIC_LINK(40),
  /**
   * Invalid declaration error.
   */
  INVALID_DECLARATION(41),
  /**
   * Duplicate symbol error.
   */
  DUPLICATE_SYMBOL(42),
  /**
   * Parse error.
   */
  PARSE(43),
  /**
   * Busy error.
   */
  BUSY(44),
  /**
   * Skip error.
   */
  SKIP(45),
  /**
   * Help error. Used internally when passing `--version` or `--help` as executable options.
   */
  HELP(46),
  /**
   * Bug error, caused by an implementation issue in the method.
   *
   * **Note:** If a built-in method returns this code, please open an issue on
   * [url=https://github.com/godotengine/godot/issues]the GitHub Issue Tracker[/url].
   */
  BUG(47),
  /**
   * Printer on fire error (this is an easter egg, no built-in methods return this error code).
   */
  PRINTER_ON_FIRE(48),
  ;

  public companion object {
    public fun from(`value`: Long): Error = entries.first { it.`value` == `value` }
  }
}
