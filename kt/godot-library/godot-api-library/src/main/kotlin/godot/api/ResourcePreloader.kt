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
import godot.core.MethodStringName2
import godot.core.PackedStringArray
import godot.core.StringName
import godot.core.asCachedStringName
import godot.readReturnValue_BOOL
import godot.readReturnValue_OBJECT
import godot.readReturnValue_PACKED_STRING_ARRAY
import godot.writeMethodArguments0
import godot.writeMethodArguments_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_OBJECT
import godot.writeMethodArguments_STRING_NAME_STRING_NAME
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * This node is used to preload sub-resources inside a scene, so when the scene is loaded, all the
 * resources are ready to use and can be retrieved from the preloader. You can add the resources using
 * the ResourcePreloader tab when the node is selected.
 *
 * GDScript has a simplified [@GDScript.preload] built-in method which can be used in most
 * situations, leaving the use of [ResourcePreloader] for more advanced scenarios.
 */
@GodotBaseType
public open class ResourcePreloader : Node() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(626, scriptPtr)
  }

  /**
   * Adds a resource to the preloader with the given [name]. If a resource with the given [name]
   * already exists, the new resource will be renamed to "[name] N" where N is an incrementing number
   * starting from 2.
   */
  public final fun addResource(name: StringName, resource: Resource?): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_OBJECT(ptr, objectID.id, name, resource)
    TransferContext.callPtrMethod(MethodBindings.addResourcePtr, 0)
  }

  /**
   * Removes the resource associated to [name] from the preloader.
   */
  public final fun removeResource(name: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, name)
    TransferContext.callPtrMethod(MethodBindings.removeResourcePtr, 0)
  }

  /**
   * Renames a resource inside the preloader from [name] to [newname].
   */
  public final fun renameResource(name: StringName, newname: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, name, newname)
    TransferContext.callPtrMethod(MethodBindings.renameResourcePtr, 0)
  }

  /**
   * Returns `true` if the preloader contains a resource associated to [name].
   */
  public final fun hasResource(name: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, name)
    TransferContext.callPtrMethod(MethodBindings.hasResourcePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the resource associated to [name].
   */
  public final fun getResource(name: StringName): Resource? {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, name)
    TransferContext.callPtrMethod(MethodBindings.getResourcePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Resource?)
  }

  /**
   * Returns the list of resources inside the preloader.
   */
  public final fun getResourceList(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getResourceListPtr, 34)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Adds a resource to the preloader with the given [name]. If a resource with the given [name]
   * already exists, the new resource will be renamed to "[name] N" where N is an incrementing number
   * starting from 2.
   */
  public final fun addResource(name: String, resource: Resource?) =
      addResource(name.asCachedStringName(), resource)

  /**
   * Removes the resource associated to [name] from the preloader.
   */
  public final fun removeResource(name: String) = removeResource(name.asCachedStringName())

  /**
   * Renames a resource inside the preloader from [name] to [newname].
   */
  public final fun renameResource(name: String, newname: String) =
      renameResource(name.asCachedStringName(), newname.asCachedStringName())

  /**
   * Returns `true` if the preloader contains a resource associated to [name].
   */
  public final fun hasResource(name: String): Boolean = hasResource(name.asCachedStringName())

  /**
   * Returns the resource associated to [name].
   */
  public final fun getResource(name: String): Resource? = getResource(name.asCachedStringName())

  public companion object {
    @JvmField
    public val addResourceName: MethodStringName2<ResourcePreloader, Unit, StringName, Resource?> =
        MethodStringName2<ResourcePreloader, Unit, StringName, Resource?>("add_resource")

    @JvmField
    public val removeResourceName: MethodStringName1<ResourcePreloader, Unit, StringName> =
        MethodStringName1<ResourcePreloader, Unit, StringName>("remove_resource")

    @JvmField
    public val renameResourceName:
        MethodStringName2<ResourcePreloader, Unit, StringName, StringName> =
        MethodStringName2<ResourcePreloader, Unit, StringName, StringName>("rename_resource")

    @JvmField
    public val hasResourceName: MethodStringName1<ResourcePreloader, Boolean, StringName> =
        MethodStringName1<ResourcePreloader, Boolean, StringName>("has_resource")

    @JvmField
    public val getResourceName: MethodStringName1<ResourcePreloader, Resource?, StringName> =
        MethodStringName1<ResourcePreloader, Resource?, StringName>("get_resource")

    @JvmField
    public val getResourceListName: MethodStringName0<ResourcePreloader, PackedStringArray> =
        MethodStringName0<ResourcePreloader, PackedStringArray>("get_resource_list")
  }

  public object MethodBindings {
    internal val addResourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourcePreloader", "add_resource", 1168801743)

    internal val removeResourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourcePreloader", "remove_resource", 3304788590)

    internal val renameResourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourcePreloader", "rename_resource", 3740211285)

    internal val hasResourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourcePreloader", "has_resource", 2619796661)

    internal val getResourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourcePreloader", "get_resource", 3742749261)

    internal val getResourceListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ResourcePreloader", "get_resource_list", 1139954409)
  }
}
