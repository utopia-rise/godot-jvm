// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.Color
import godot.core.Dictionary
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName4
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.STRING
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * By adjusting various properties of this resource, you can change the colors of strings, comments,
 * numbers, and other text patterns inside a [TextEdit] control.
 */
@GodotBaseType
public open class CodeHighlighter : SyntaxHighlighter() {
  /**
   * Sets the color for numbers.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var numberColor: Color
    @JvmName("numberColorProperty")
    get() = getNumberColor()
    @JvmName("numberColorProperty")
    set(`value`) {
      setNumberColor(value)
    }

  /**
   * Sets the color for symbols.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var symbolColor: Color
    @JvmName("symbolColorProperty")
    get() = getSymbolColor()
    @JvmName("symbolColorProperty")
    set(`value`) {
      setSymbolColor(value)
    }

  /**
   * Sets color for functions. A function is a non-keyword string followed by a '('.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var functionColor: Color
    @JvmName("functionColorProperty")
    get() = getFunctionColor()
    @JvmName("functionColorProperty")
    set(`value`) {
      setFunctionColor(value)
    }

  /**
   * Sets color for member variables. A member variable is non-keyword, non-function string
   * proceeded with a '.'.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var memberVariableColor: Color
    @JvmName("memberVariableColorProperty")
    get() = getMemberVariableColor()
    @JvmName("memberVariableColorProperty")
    set(`value`) {
      setMemberVariableColor(value)
    }

  /**
   * Sets the keyword colors. All existing keywords will be removed. The [Dictionary] key is the
   * keyword. The value is the keyword color.
   */
  public final inline var keywordColors: Dictionary<Any?, Any?>
    @JvmName("keywordColorsProperty")
    get() = getKeywordColors()
    @JvmName("keywordColorsProperty")
    set(`value`) {
      setKeywordColors(value)
    }

  /**
   * Sets the member keyword colors. All existing member keyword will be removed. The [Dictionary]
   * key is the member keyword. The value is the member keyword color.
   */
  public final inline var memberKeywordColors: Dictionary<Any?, Any?>
    @JvmName("memberKeywordColorsProperty")
    get() = getMemberKeywordColors()
    @JvmName("memberKeywordColorsProperty")
    set(`value`) {
      setMemberKeywordColors(value)
    }

  /**
   * Sets the color regions. All existing regions will be removed. The [Dictionary] key is the
   * region start and end key, separated by a space. The value is the region color.
   */
  public final inline var colorRegions: Dictionary<Any?, Any?>
    @JvmName("colorRegionsProperty")
    get() = getColorRegions()
    @JvmName("colorRegionsProperty")
    set(`value`) {
      setColorRegions(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(162, scriptPtr)
  }

  /**
   * This is a helper function for [numberColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = codehighlighter.numberColor
   * //Your changes
   * codehighlighter.numberColor = myCoreType
   * ``````
   *
   * Sets the color for numbers.
   */
  @CoreTypeHelper
  public final fun numberColorMutate(block: Color.() -> Unit): Color = numberColor.apply {
     block(this)
     numberColor = this
  }

  /**
   * This is a helper function for [symbolColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = codehighlighter.symbolColor
   * //Your changes
   * codehighlighter.symbolColor = myCoreType
   * ``````
   *
   * Sets the color for symbols.
   */
  @CoreTypeHelper
  public final fun symbolColorMutate(block: Color.() -> Unit): Color = symbolColor.apply {
     block(this)
     symbolColor = this
  }

  /**
   * This is a helper function for [functionColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = codehighlighter.functionColor
   * //Your changes
   * codehighlighter.functionColor = myCoreType
   * ``````
   *
   * Sets color for functions. A function is a non-keyword string followed by a '('.
   */
  @CoreTypeHelper
  public final fun functionColorMutate(block: Color.() -> Unit): Color = functionColor.apply {
     block(this)
     functionColor = this
  }

  /**
   * This is a helper function for [memberVariableColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = codehighlighter.memberVariableColor
   * //Your changes
   * codehighlighter.memberVariableColor = myCoreType
   * ``````
   *
   * Sets color for member variables. A member variable is non-keyword, non-function string
   * proceeded with a '.'.
   */
  @CoreTypeHelper
  public final fun memberVariableColorMutate(block: Color.() -> Unit): Color =
      memberVariableColor.apply {
     block(this)
     memberVariableColor = this
  }

  /**
   * Sets the color for a keyword.
   *
   * The keyword cannot contain any symbols except '_'.
   */
  public final fun addKeywordColor(keyword: String, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to keyword, COLOR to color)
    TransferContext.callMethod(MethodBindings.addKeywordColorPtr)
  }

  /**
   * Removes the keyword.
   */
  public final fun removeKeywordColor(keyword: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to keyword)
    TransferContext.callMethod(MethodBindings.removeKeywordColorPtr)
  }

  /**
   * Returns `true` if the keyword exists, else `false`.
   */
  public final fun hasKeywordColor(keyword: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to keyword)
    TransferContext.callMethod(MethodBindings.hasKeywordColorPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the color for a keyword.
   */
  public final fun getKeywordColor(keyword: String): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to keyword)
    TransferContext.callMethod(MethodBindings.getKeywordColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setKeywordColors(keywords: Dictionary<Any?, Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DICTIONARY to keywords)
    TransferContext.callMethod(MethodBindings.setKeywordColorsPtr)
  }

  /**
   * Removes all keywords.
   */
  public final fun clearKeywordColors(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearKeywordColorsPtr)
  }

  public final fun getKeywordColors(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getKeywordColorsPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Sets the color for a member keyword.
   *
   * The member keyword cannot contain any symbols except '_'.
   *
   * It will not be highlighted if preceded by a '.'.
   */
  public final fun addMemberKeywordColor(memberKeyword: String, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to memberKeyword, COLOR to color)
    TransferContext.callMethod(MethodBindings.addMemberKeywordColorPtr)
  }

  /**
   * Removes the member keyword.
   */
  public final fun removeMemberKeywordColor(memberKeyword: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to memberKeyword)
    TransferContext.callMethod(MethodBindings.removeMemberKeywordColorPtr)
  }

  /**
   * Returns `true` if the member keyword exists, else `false`.
   */
  public final fun hasMemberKeywordColor(memberKeyword: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to memberKeyword)
    TransferContext.callMethod(MethodBindings.hasMemberKeywordColorPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the color for a member keyword.
   */
  public final fun getMemberKeywordColor(memberKeyword: String): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to memberKeyword)
    TransferContext.callMethod(MethodBindings.getMemberKeywordColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setMemberKeywordColors(memberKeyword: Dictionary<Any?, Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DICTIONARY to memberKeyword)
    TransferContext.callMethod(MethodBindings.setMemberKeywordColorsPtr)
  }

  /**
   * Removes all member keywords.
   */
  public final fun clearMemberKeywordColors(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearMemberKeywordColorsPtr)
  }

  public final fun getMemberKeywordColors(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMemberKeywordColorsPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Adds a color region (such as for comments or strings) from [startKey] to [endKey]. Both keys
   * should be symbols, and [startKey] must not be shared with other delimiters.
   *
   * If [lineOnly] is `true` or [endKey] is an empty [String], the region does not carry over to the
   * next line.
   */
  @JvmOverloads
  public final fun addColorRegion(
    startKey: String,
    endKey: String,
    color: Color,
    lineOnly: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to startKey, STRING to endKey, COLOR to color, BOOL to lineOnly)
    TransferContext.callMethod(MethodBindings.addColorRegionPtr)
  }

  /**
   * Removes the color region that uses that start key.
   */
  public final fun removeColorRegion(startKey: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to startKey)
    TransferContext.callMethod(MethodBindings.removeColorRegionPtr)
  }

  /**
   * Returns `true` if the start key exists, else `false`.
   */
  public final fun hasColorRegion(startKey: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to startKey)
    TransferContext.callMethod(MethodBindings.hasColorRegionPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setColorRegions(colorRegions: Dictionary<Any?, Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DICTIONARY to colorRegions)
    TransferContext.callMethod(MethodBindings.setColorRegionsPtr)
  }

  /**
   * Removes all color regions.
   */
  public final fun clearColorRegions(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearColorRegionsPtr)
  }

  public final fun getColorRegions(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getColorRegionsPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  public final fun setFunctionColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setFunctionColorPtr)
  }

  public final fun getFunctionColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFunctionColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setNumberColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setNumberColorPtr)
  }

  public final fun getNumberColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNumberColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setSymbolColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setSymbolColorPtr)
  }

  public final fun getSymbolColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSymbolColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setMemberVariableColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setMemberVariableColorPtr)
  }

  public final fun getMemberVariableColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMemberVariableColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public companion object {
    @JvmField
    public val addKeywordColorName: MethodStringName2<CodeHighlighter, Unit, String, Color> =
        MethodStringName2<CodeHighlighter, Unit, String, Color>("add_keyword_color")

    @JvmField
    public val removeKeywordColorName: MethodStringName1<CodeHighlighter, Unit, String> =
        MethodStringName1<CodeHighlighter, Unit, String>("remove_keyword_color")

    @JvmField
    public val hasKeywordColorName: MethodStringName1<CodeHighlighter, Boolean, String> =
        MethodStringName1<CodeHighlighter, Boolean, String>("has_keyword_color")

    @JvmField
    public val getKeywordColorName: MethodStringName1<CodeHighlighter, Color, String> =
        MethodStringName1<CodeHighlighter, Color, String>("get_keyword_color")

    @JvmField
    public val setKeywordColorsName:
        MethodStringName1<CodeHighlighter, Unit, Dictionary<Any?, Any?>> =
        MethodStringName1<CodeHighlighter, Unit, Dictionary<Any?, Any?>>("set_keyword_colors")

    @JvmField
    public val clearKeywordColorsName: MethodStringName0<CodeHighlighter, Unit> =
        MethodStringName0<CodeHighlighter, Unit>("clear_keyword_colors")

    @JvmField
    public val getKeywordColorsName: MethodStringName0<CodeHighlighter, Dictionary<Any?, Any?>> =
        MethodStringName0<CodeHighlighter, Dictionary<Any?, Any?>>("get_keyword_colors")

    @JvmField
    public val addMemberKeywordColorName: MethodStringName2<CodeHighlighter, Unit, String, Color> =
        MethodStringName2<CodeHighlighter, Unit, String, Color>("add_member_keyword_color")

    @JvmField
    public val removeMemberKeywordColorName: MethodStringName1<CodeHighlighter, Unit, String> =
        MethodStringName1<CodeHighlighter, Unit, String>("remove_member_keyword_color")

    @JvmField
    public val hasMemberKeywordColorName: MethodStringName1<CodeHighlighter, Boolean, String> =
        MethodStringName1<CodeHighlighter, Boolean, String>("has_member_keyword_color")

    @JvmField
    public val getMemberKeywordColorName: MethodStringName1<CodeHighlighter, Color, String> =
        MethodStringName1<CodeHighlighter, Color, String>("get_member_keyword_color")

    @JvmField
    public val setMemberKeywordColorsName:
        MethodStringName1<CodeHighlighter, Unit, Dictionary<Any?, Any?>> =
        MethodStringName1<CodeHighlighter, Unit, Dictionary<Any?, Any?>>("set_member_keyword_colors")

    @JvmField
    public val clearMemberKeywordColorsName: MethodStringName0<CodeHighlighter, Unit> =
        MethodStringName0<CodeHighlighter, Unit>("clear_member_keyword_colors")

    @JvmField
    public val getMemberKeywordColorsName:
        MethodStringName0<CodeHighlighter, Dictionary<Any?, Any?>> =
        MethodStringName0<CodeHighlighter, Dictionary<Any?, Any?>>("get_member_keyword_colors")

    @JvmField
    public val addColorRegionName:
        MethodStringName4<CodeHighlighter, Unit, String, String, Color, Boolean> =
        MethodStringName4<CodeHighlighter, Unit, String, String, Color, Boolean>("add_color_region")

    @JvmField
    public val removeColorRegionName: MethodStringName1<CodeHighlighter, Unit, String> =
        MethodStringName1<CodeHighlighter, Unit, String>("remove_color_region")

    @JvmField
    public val hasColorRegionName: MethodStringName1<CodeHighlighter, Boolean, String> =
        MethodStringName1<CodeHighlighter, Boolean, String>("has_color_region")

    @JvmField
    public val setColorRegionsName: MethodStringName1<CodeHighlighter, Unit, Dictionary<Any?, Any?>>
        = MethodStringName1<CodeHighlighter, Unit, Dictionary<Any?, Any?>>("set_color_regions")

    @JvmField
    public val clearColorRegionsName: MethodStringName0<CodeHighlighter, Unit> =
        MethodStringName0<CodeHighlighter, Unit>("clear_color_regions")

    @JvmField
    public val getColorRegionsName: MethodStringName0<CodeHighlighter, Dictionary<Any?, Any?>> =
        MethodStringName0<CodeHighlighter, Dictionary<Any?, Any?>>("get_color_regions")

    @JvmField
    public val setFunctionColorName: MethodStringName1<CodeHighlighter, Unit, Color> =
        MethodStringName1<CodeHighlighter, Unit, Color>("set_function_color")

    @JvmField
    public val getFunctionColorName: MethodStringName0<CodeHighlighter, Color> =
        MethodStringName0<CodeHighlighter, Color>("get_function_color")

    @JvmField
    public val setNumberColorName: MethodStringName1<CodeHighlighter, Unit, Color> =
        MethodStringName1<CodeHighlighter, Unit, Color>("set_number_color")

    @JvmField
    public val getNumberColorName: MethodStringName0<CodeHighlighter, Color> =
        MethodStringName0<CodeHighlighter, Color>("get_number_color")

    @JvmField
    public val setSymbolColorName: MethodStringName1<CodeHighlighter, Unit, Color> =
        MethodStringName1<CodeHighlighter, Unit, Color>("set_symbol_color")

    @JvmField
    public val getSymbolColorName: MethodStringName0<CodeHighlighter, Color> =
        MethodStringName0<CodeHighlighter, Color>("get_symbol_color")

    @JvmField
    public val setMemberVariableColorName: MethodStringName1<CodeHighlighter, Unit, Color> =
        MethodStringName1<CodeHighlighter, Unit, Color>("set_member_variable_color")

    @JvmField
    public val getMemberVariableColorName: MethodStringName0<CodeHighlighter, Color> =
        MethodStringName0<CodeHighlighter, Color>("get_member_variable_color")
  }

  public object MethodBindings {
    internal val addKeywordColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "add_keyword_color", 1636512886)

    internal val removeKeywordColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "remove_keyword_color", 83702148)

    internal val hasKeywordColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "has_keyword_color", 3927539163)

    internal val getKeywordColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "get_keyword_color", 3855908743)

    internal val setKeywordColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "set_keyword_colors", 4155329257)

    internal val clearKeywordColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "clear_keyword_colors", 3218959716)

    internal val getKeywordColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "get_keyword_colors", 3102165223)

    internal val addMemberKeywordColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "add_member_keyword_color", 1636512886)

    internal val removeMemberKeywordColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "remove_member_keyword_color", 83702148)

    internal val hasMemberKeywordColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "has_member_keyword_color", 3927539163)

    internal val getMemberKeywordColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "get_member_keyword_color", 3855908743)

    internal val setMemberKeywordColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "set_member_keyword_colors", 4155329257)

    internal val clearMemberKeywordColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "clear_member_keyword_colors", 3218959716)

    internal val getMemberKeywordColorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "get_member_keyword_colors", 3102165223)

    internal val addColorRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "add_color_region", 2924977451)

    internal val removeColorRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "remove_color_region", 83702148)

    internal val hasColorRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "has_color_region", 3927539163)

    internal val setColorRegionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "set_color_regions", 4155329257)

    internal val clearColorRegionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "clear_color_regions", 3218959716)

    internal val getColorRegionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "get_color_regions", 3102165223)

    internal val setFunctionColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "set_function_color", 2920490490)

    internal val getFunctionColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "get_function_color", 3444240500)

    internal val setNumberColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "set_number_color", 2920490490)

    internal val getNumberColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "get_number_color", 3444240500)

    internal val setSymbolColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "set_symbol_color", 2920490490)

    internal val getSymbolColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "get_symbol_color", 3444240500)

    internal val setMemberVariableColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "set_member_variable_color", 2920490490)

    internal val getMemberVariableColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeHighlighter", "get_member_variable_color", 3444240500)
  }
}
