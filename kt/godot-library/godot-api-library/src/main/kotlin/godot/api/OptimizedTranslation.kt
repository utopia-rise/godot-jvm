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
import godot.core.MethodStringName1
import godot.readReturnValue_BOOL
import godot.writeMethodArguments_OBJECT
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * An optimized translation. Uses real-time compressed translations, which results in very small
 * dictionaries.
 *
 * This class does not store the untranslated strings for optimization purposes. Therefore,
 * [Translation.getMessageList] always returns an empty array, and [Translation.getMessageCount] always
 * returns `0`.
 */
@GodotBaseType
public open class OptimizedTranslation : Translation() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(496, scriptPtr)
  }

  /**
   * Generates and sets an optimized translation from the given [Translation] resource. Returns
   * `true` if successful.
   *
   * **Note:** Messages in [from] should not use context or plural forms.
   *
   * **Note:** This method is intended to be used in the editor. It does nothing when called from an
   * exported project.
   */
  public final fun generate(from: Translation?): Boolean {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, from)
    TransferContext.callMethod(MethodBindings.generatePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val generateName: MethodStringName1<OptimizedTranslation, Boolean, Translation?> =
        MethodStringName1<OptimizedTranslation, Boolean, Translation?>("generate")
  }

  public object MethodBindings {
    internal val generatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptimizedTranslation", "generate", 2141509306)
  }
}
