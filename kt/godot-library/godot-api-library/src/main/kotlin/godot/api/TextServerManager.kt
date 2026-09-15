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
import godot.core.Dictionary
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.Signal1
import godot.core.StringName
import godot.core.VariantArray
import godot.readReturnValue_ARRAY
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_STRING
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic

/**
 * [TextServerManager] is the API backend for loading, enumerating, and switching [TextServer]s.
 *
 * **Note:** Switching text server at runtime is possible, but will invalidate all fonts and text
 * buffers. Make sure to unload all controls, fonts, and themes before doing so.
 */
@GodotBaseType
public object TextServerManager : Object() {
  @JvmField
  public val addInterfaceName: MethodStringName1<TextServerManager, Unit, TextServer?> =
      MethodStringName1<TextServerManager, Unit, TextServer?>("add_interface")

  @JvmField
  public val getInterfaceCountName: MethodStringName0<TextServerManager, Int> =
      MethodStringName0<TextServerManager, Int>("get_interface_count")

  @JvmField
  public val removeInterfaceName: MethodStringName1<TextServerManager, Unit, TextServer?> =
      MethodStringName1<TextServerManager, Unit, TextServer?>("remove_interface")

  @JvmField
  public val getInterfaceName: MethodStringName1<TextServerManager, TextServer?, Int> =
      MethodStringName1<TextServerManager, TextServer?, Int>("get_interface")

  @JvmField
  public val getInterfacesName:
      MethodStringName0<TextServerManager, VariantArray<Dictionary<Any?, Any?>>> =
      MethodStringName0<TextServerManager, VariantArray<Dictionary<Any?, Any?>>>("get_interfaces")

  @JvmField
  public val findInterfaceName: MethodStringName1<TextServerManager, TextServer?, String> =
      MethodStringName1<TextServerManager, TextServer?, String>("find_interface")

  @JvmField
  public val setPrimaryInterfaceName: MethodStringName1<TextServerManager, Unit, TextServer?> =
      MethodStringName1<TextServerManager, Unit, TextServer?>("set_primary_interface")

  @JvmField
  public val getPrimaryInterfaceName: MethodStringName0<TextServerManager, TextServer?> =
      MethodStringName0<TextServerManager, TextServer?>("get_primary_interface")

  /**
   * Emitted when a new interface has been added.
   */
  @JvmStatic
  public val interfaceAdded: Signal1<StringName> by Signal1

  /**
   * Emitted when an interface is removed.
   */
  @JvmStatic
  public val interfaceRemoved: Signal1<StringName> by Signal1

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(33)
  }

  /**
   * Registers a [TextServer] interface.
   */
  @JvmStatic
  public final fun addInterface(`interface`: TextServer?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, `interface`)
    TransferContext.callMethod(MethodBindings.addInterfacePtr)
  }

  /**
   * Returns the number of interfaces currently registered.
   */
  @JvmStatic
  public final fun getInterfaceCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInterfaceCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Removes an interface. All fonts and shaped text caches should be freed before removing an
   * interface.
   */
  @JvmStatic
  public final fun removeInterface(`interface`: TextServer?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, `interface`)
    TransferContext.callMethod(MethodBindings.removeInterfacePtr)
  }

  /**
   * Returns the interface registered at a given index.
   */
  @JvmStatic
  public final fun getInterface(idx: Int): TextServer? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getInterfacePtr)
    return (TransferContext.readReturnValue_OBJECT() as TextServer?)
  }

  /**
   * Returns a list of available interfaces, with the index and name of each interface.
   */
  @JvmStatic
  public final fun getInterfaces(): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInterfacesPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Finds an interface by its [name].
   */
  @JvmStatic
  public final fun findInterface(name: String): TextServer? {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.findInterfacePtr)
    return (TransferContext.readReturnValue_OBJECT() as TextServer?)
  }

  /**
   * Sets the primary [TextServer] interface.
   */
  @JvmStatic
  public final fun setPrimaryInterface(index: TextServer?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, index)
    TransferContext.callMethod(MethodBindings.setPrimaryInterfacePtr)
  }

  /**
   * Returns the primary [TextServer] interface currently in use.
   */
  @JvmStatic
  public final fun getPrimaryInterface(): TextServer? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPrimaryInterfacePtr)
    return (TransferContext.readReturnValue_OBJECT() as TextServer?)
  }

  public object MethodBindings {
    internal val addInterfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServerManager", "add_interface", 1799689403)

    internal val getInterfaceCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServerManager", "get_interface_count", 3905245786)

    internal val removeInterfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServerManager", "remove_interface", 1799689403)

    internal val getInterfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServerManager", "get_interface", 1672475555)

    internal val getInterfacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServerManager", "get_interfaces", 3995934104)

    internal val findInterfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServerManager", "find_interface", 2240905781)

    internal val setPrimaryInterfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServerManager", "set_primary_interface", 1799689403)

    internal val getPrimaryInterfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextServerManager", "get_primary_interface", 905850878)
  }
}
