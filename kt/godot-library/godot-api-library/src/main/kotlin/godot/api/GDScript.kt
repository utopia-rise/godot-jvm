// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_VARARG_ret_ANY
import godot.common.interop.VoidPtr
import kotlin.Any
import kotlin.Suppress
import kotlin.Unit

/**
 * A script implemented in the GDScript programming language, saved with the `.gd` extension. The
 * script extends the functionality of all objects that instantiate it.
 *
 * Calling [new] creates a new instance of the script. [Object.setScript] extends an existing
 * object, if that object's class matches one of the script's base classes.
 *
 * If you are looking for GDScript's built-in functions, see [@GDScript] instead.
 */
@GodotBaseType
public open class GDScript : Script() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(237, scriptPtr)
  }

  /**
   * Returns a new instance of the script.
   *
   * ```
   * var MyClass = load("myclass.gd")
   * var instance = MyClass.new()
   * print(instance.get_script() == MyClass) # Prints true
   * ```
   */
  public final fun new(vararg args: Any?): Any? =
      TransferContext.callMethod_VARARG_ret_ANY(ptr, objectID.id, MethodBindings.newPtr, args)

  public companion object

  public object MethodBindings {
    internal val newPtr: VoidPtr = TypeManager.getMethodBindPtr("GDScript", "new", 1545262638)
  }
}
