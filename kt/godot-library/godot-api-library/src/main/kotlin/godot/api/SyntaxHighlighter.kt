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
import godot.readReturnValue_DICTIONARY
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import kotlin.Any
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Base class for syntax highlighters. Provides syntax highlighting data to a [TextEdit]. The
 * associated [TextEdit] will call into the [SyntaxHighlighter] on an as-needed basis.
 *
 * **Note:** A [SyntaxHighlighter] instance should not be used across multiple [TextEdit] nodes.
 */
@GodotBaseType
public open class SyntaxHighlighter : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(724, scriptPtr)
  }

  /**
   * Virtual method which can be overridden to return syntax highlighting data.
   *
   * See [getLineSyntaxHighlighting] for more details.
   */
  public open fun _getLineSyntaxHighlighting(line: Int): Dictionary<Any?, Any?> {
    throw NotImplementedError("SyntaxHighlighter::_getLineSyntaxHighlighting is not implemented.")
  }

  /**
   * Virtual method which can be overridden to clear any local caches.
   */
  public open fun _clearHighlightingCache(): Unit {
    throw NotImplementedError("SyntaxHighlighter::_clearHighlightingCache is not implemented.")
  }

  /**
   * Virtual method which can be overridden to update any local caches.
   */
  public open fun _updateCache(): Unit {
    throw NotImplementedError("SyntaxHighlighter::_updateCache is not implemented.")
  }

  /**
   * Returns the syntax highlighting data for the line at index [line]. If the line is not cached,
   * calls [_getLineSyntaxHighlighting] first to calculate the data.
   *
   * Each entry is a column number containing a nested [Dictionary]. The column number denotes the
   * start of a region, the region will end if another region is found, or at the end of the line. The
   * nested [Dictionary] contains the data for that region. Currently only the key `"color"` is
   * supported.
   *
   * **Example:** Possible return value. This means columns `0` to `4` should be red, and columns
   * `5` to the end of the line should be green:
   *
   * ```
   * {
   * 	0: {
   * 		"color": Color(1, 0, 0)
   * 	},
   * 	5: {
   * 		"color": Color(0, 1, 0)
   * 	}
   * }
   * ```
   */
  public final fun getLineSyntaxHighlighting(line: Int): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, line.toLong())
    TransferContext.callPtrMethod(MethodBindings.getLineSyntaxHighlightingPtr, 27)
    return (TransferContext.readReturnValue_DICTIONARY() as Dictionary<Any?, Any?>)
  }

  /**
   * Clears then updates the [SyntaxHighlighter] caches. Override [_updateCache] for a callback.
   *
   * **Note:** This is called automatically when the associated [TextEdit] node, updates its own
   * cache.
   */
  public final fun updateCache(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.updateCachePtr, 0)
  }

  /**
   * Clears all cached syntax highlighting data.
   *
   * Then calls overridable method [_clearHighlightingCache].
   */
  public final fun clearHighlightingCache(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearHighlightingCachePtr, 0)
  }

  /**
   * Returns the associated [TextEdit] node.
   */
  public final fun getTextEdit(): TextEdit? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTextEditPtr, 24)
    return (TransferContext.readReturnValue_OBJECT() as TextEdit?)
  }

  public companion object {
    @JvmField
    public val getLineSyntaxHighlightingName:
        MethodStringName1<SyntaxHighlighter, Dictionary<Any?, Any?>, Int> =
        MethodStringName1<SyntaxHighlighter, Dictionary<Any?, Any?>, Int>("get_line_syntax_highlighting")

    @JvmField
    public val updateCacheName: MethodStringName0<SyntaxHighlighter, Unit> =
        MethodStringName0<SyntaxHighlighter, Unit>("update_cache")

    @JvmField
    public val clearHighlightingCacheName: MethodStringName0<SyntaxHighlighter, Unit> =
        MethodStringName0<SyntaxHighlighter, Unit>("clear_highlighting_cache")

    @JvmField
    public val getTextEditName: MethodStringName0<SyntaxHighlighter, TextEdit?> =
        MethodStringName0<SyntaxHighlighter, TextEdit?>("get_text_edit")
  }

  public object MethodBindings {
    internal val getLineSyntaxHighlightingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SyntaxHighlighter", "get_line_syntax_highlighting", 3554694381)

    internal val updateCachePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SyntaxHighlighter", "update_cache", 3218959716)

    internal val clearHighlightingCachePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SyntaxHighlighter", "clear_highlighting_cache", 3218959716)

    internal val getTextEditPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SyntaxHighlighter", "get_text_edit", 1893027089)
  }
}
