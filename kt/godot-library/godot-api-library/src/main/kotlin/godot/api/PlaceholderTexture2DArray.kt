// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import kotlin.Suppress
import kotlin.Unit

/**
 * This class is used when loading a project that uses a [Texture2D] subclass in 2 conditions:
 *
 * - When running the project exported in dedicated server mode, only the texture's dimensions are
 * kept (as they may be relied upon for gameplay purposes or positioning of other elements). This
 * allows reducing the exported PCK's size significantly.
 *
 * - When this subclass is missing due to using a different engine version or build (e.g. modules
 * disabled).
 *
 * **Note:** This is not intended to be used as an actual texture for rendering. It is not
 * guaranteed to work like one in shaders or materials (for example when calculating UV).
 */
@GodotBaseType
public open class PlaceholderTexture2DArray : PlaceholderTextureLayered() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(556, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
