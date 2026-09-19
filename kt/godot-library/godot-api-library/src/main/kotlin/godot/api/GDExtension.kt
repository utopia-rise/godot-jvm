// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_LONG
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import kotlin.Boolean
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * The [GDExtension] resource type represents a
 * [url=https://en.wikipedia.org/wiki/Shared_library]shared library[/url] which can expand the
 * functionality of the engine. The [GDExtensionManager] singleton is responsible for loading,
 * reloading, and unloading [GDExtension] resources.
 *
 * **Note:** GDExtension itself is not a scripting language and has no relation to [GDScript]
 * resources.
 */
@GodotBaseType
public open class GDExtension : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(235, scriptPtr)
  }

  /**
   * Returns `true` if this extension's library has been opened.
   */
  public final fun isLibraryOpen(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isLibraryOpenPtr)

  /**
   * Returns the lowest level required for this extension to be properly initialized (see the
   * [InitializationLevel] enum).
   */
  public final fun getMinimumLibraryInitializationLevel(): InitializationLevel =
      InitializationLevel.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getMinimumLibraryInitializationLevelPtr))

  public enum class InitializationLevel(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The library is initialized at the same time as the core features of the engine.
     */
    CORE(0),
    /**
     * The library is initialized at the same time as the engine's servers (such as
     * [RenderingServer] or [PhysicsServer3D]).
     */
    SERVERS(1),
    /**
     * The library is initialized at the same time as the engine's scene-related classes.
     */
    SCENE(2),
    /**
     * The library is initialized at the same time as the engine's editor classes. Only happens when
     * loading the GDExtension in the editor.
     */
    EDITOR(3),
    ;

    public companion object {
      public fun from(`value`: Long): InitializationLevel = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val isLibraryOpenName: MethodStringName0<GDExtension, Boolean> =
        MethodStringName0<GDExtension, Boolean>("is_library_open")

    @JvmField
    public val getMinimumLibraryInitializationLevelName:
        MethodStringName0<GDExtension, InitializationLevel> =
        MethodStringName0<GDExtension, InitializationLevel>("get_minimum_library_initialization_level")
  }

  public object MethodBindings {
    internal val isLibraryOpenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GDExtension", "is_library_open", 36873697)

    internal val getMinimumLibraryInitializationLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GDExtension", "get_minimum_library_initialization_level", 964858755)
  }
}
