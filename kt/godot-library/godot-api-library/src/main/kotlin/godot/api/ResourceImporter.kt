// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.PackedStringArray
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit

/**
 * This is the base class for Godot's resource importers. To implement your own resource importers
 * using editor plugins, see [EditorImportPlugin].
 */
@GodotBaseType
public open class ResourceImporter internal constructor() : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(624, scriptPtr)
  }

  /**
   * Called when the engine compilation profile editor wants to check what build options an imported
   * resource needs. For example, [ResourceImporterDynamicFont] has a property called
   * [ResourceImporterDynamicFont.multichannelSignedDistanceField], that depends on the engine to be
   * build with the "msdfgen" module. If that resource happened to be a custom one, it would be handled
   * like this:
   *
   * ```
   * func _get_build_dependencies(path):
   * 	var resource = load(path)
   * 	var dependencies = PackedStringArray()
   *
   * 	if resource.multichannel_signed_distance_field:
   * 		dependencies.push_back("module_msdfgen_enabled")
   *
   * 	return dependencies
   * ```
   */
  public open fun _getBuildDependencies(path: String): PackedStringArray {
    throw NotImplementedError("ResourceImporter::_getBuildDependencies is not implemented.")
  }

  public enum class ImportOrder(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The default import order.
     */
    DEFAULT(0),
    /**
     * The import order for scenes, which ensures scenes are imported *after* all other core
     * resources such as textures. Custom importers should generally have an import order lower than
     * `100` to avoid issues when importing scenes that rely on custom resources.
     */
    SCENE(100),
    ;

    public companion object {
      public fun from(`value`: Long): ImportOrder = entries.first { it.`value` == `value` }
    }
  }

  public companion object

  public object MethodBindings
}
