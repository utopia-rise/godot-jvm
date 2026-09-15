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
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.PackedStringArray
import godot.core.StringName
import godot.core.asCachedStringName
import godot.readReturnValue_LONG
import godot.readReturnValue_PACKED_STRING_ARRAY
import godot.readReturnValue_STRING
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_STRING_NAME_PACKED_STRING_ARRAY_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_LONG_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [Translation] maps a collection of strings to their individual translations, and also provides
 * convenience methods for pluralization.
 *
 * A [Translation] consists of messages. A message is identified by its context and untranslated
 * string. Unlike [url=https://www.gnu.org/software/gettext/]gettext[/url], using an empty context
 * string in Godot means not using any context.
 */
@GodotBaseType
public open class Translation : Resource() {
  /**
   * The locale of the translation.
   */
  public final inline var locale: String
    @JvmName("localeProperty")
    get() = getLocale()
    @JvmName("localeProperty")
    set(`value`) {
      setLocale(value)
    }

  /**
   * The plural rules string to enforce. See
   * [url=https://www.gnu.org/software/gettext/manual/html_node/Plural-forms.html]GNU gettext[/url] for
   * examples and more info.
   *
   * If empty or invalid, default plural rules from [TranslationServer.getPluralRules] are used. The
   * English plural rules are used as a fallback.
   */
  public final inline var pluralRulesOverride: String
    @JvmName("pluralRulesOverrideProperty")
    get() = getPluralRulesOverride()
    @JvmName("pluralRulesOverrideProperty")
    set(`value`) {
      setPluralRulesOverride(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(768, scriptPtr)
  }

  /**
   * Virtual method to override [getPluralMessage].
   */
  public open fun _getPluralMessage(
    srcMessage: StringName,
    srcPluralMessage: StringName,
    n: Int,
    context: StringName,
  ): StringName {
    throw NotImplementedError("Translation::_getPluralMessage is not implemented.")
  }

  /**
   * Virtual method to override [getMessage].
   */
  public open fun _getMessage(srcMessage: StringName, context: StringName): StringName {
    throw NotImplementedError("Translation::_getMessage is not implemented.")
  }

  public final fun setLocale(locale: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, locale)
    TransferContext.callMethod(MethodBindings.setLocalePtr)
  }

  public final fun getLocale(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLocalePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Adds a message if nonexistent, followed by its translation.
   *
   * An additional context could be used to specify the translation context or differentiate
   * polysemic words.
   */
  public final fun addMessage(
    srcMessage: StringName,
    xlatedMessage: StringName,
    context: StringName = StringName(""),
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_STRING_NAME(ptr, objectID.id, srcMessage, xlatedMessage, context)
    TransferContext.callPtrMethod(MethodBindings.addMessagePtr, 0)
  }

  /**
   * Adds a message involving plural translation if nonexistent, followed by its translation.
   *
   * An additional context could be used to specify the translation context or differentiate
   * polysemic words.
   */
  public final fun addPluralMessage(
    srcMessage: StringName,
    xlatedMessages: PackedStringArray,
    context: StringName = StringName(""),
  ): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_PACKED_STRING_ARRAY_STRING_NAME(ptr, objectID.id, srcMessage, xlatedMessages, context)
    TransferContext.callPtrMethod(MethodBindings.addPluralMessagePtr, 0)
  }

  /**
   * Returns a message's translation.
   */
  public final fun getMessage(srcMessage: StringName, context: StringName = StringName("")):
      StringName {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, srcMessage, context)
    TransferContext.callMethod(MethodBindings.getMessagePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns a message's translation involving plurals.
   *
   * The number [n] is the number or quantity of the plural object. It will be used to guide the
   * translation system to fetch the correct plural form for the selected language.
   *
   * **Note:** Plurals are only supported in
   * [url=$DOCS_URL/tutorials/i18n/localization_using_gettext.html]gettext-based translations
   * (PO)[/url], not CSV.
   */
  public final fun getPluralMessage(
    srcMessage: StringName,
    srcPluralMessage: StringName,
    n: Int,
    context: StringName = StringName(""),
  ): StringName {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_LONG_STRING_NAME(ptr, objectID.id, srcMessage, srcPluralMessage, n.toLong(), context)
    TransferContext.callMethod(MethodBindings.getPluralMessagePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Erases a message.
   */
  public final fun eraseMessage(srcMessage: StringName, context: StringName = StringName("")):
      Unit {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, srcMessage, context)
    TransferContext.callPtrMethod(MethodBindings.eraseMessagePtr, 0)
  }

  /**
   * Returns the keys of all messages, that is, the context and untranslated strings of each
   * message.
   *
   * **Note:** If a message does not use a context, the corresponding element is the untranslated
   * string. Otherwise, the corresponding element is the context and untranslated string separated by
   * the EOT character (`U+0004`). This is done for compatibility purposes.
   *
   * ```
   * for key in translation.get_message_list():
   * 	var p = key.find("\u0004")
   * 	if p == -1:
   * 		var untranslated = key
   * 		print("Message &#37;s" &#37; untranslated)
   * 	else:
   * 		var context = key.substr(0, p)
   * 		var untranslated = key.substr(p + 1)
   * 		print("Message &#37;s with context &#37;s" &#37; [untranslated, context])
   * ```
   */
  public final fun getMessageList(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMessageListPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns all the translated strings.
   */
  public final fun getTranslatedMessageList(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTranslatedMessageListPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns the number of existing messages.
   */
  public final fun getMessageCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMessageCountPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setPluralRulesOverride(rules: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, rules)
    TransferContext.callMethod(MethodBindings.setPluralRulesOverridePtr)
  }

  public final fun getPluralRulesOverride(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPluralRulesOverridePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Adds a message if nonexistent, followed by its translation.
   *
   * An additional context could be used to specify the translation context or differentiate
   * polysemic words.
   */
  public final fun addMessage(
    srcMessage: String,
    xlatedMessage: String,
    context: String,
  ) =
      addMessage(srcMessage.asCachedStringName(), xlatedMessage.asCachedStringName(), context.asCachedStringName())

  /**
   * Adds a message involving plural translation if nonexistent, followed by its translation.
   *
   * An additional context could be used to specify the translation context or differentiate
   * polysemic words.
   */
  public final fun addPluralMessage(
    srcMessage: String,
    xlatedMessages: PackedStringArray,
    context: String,
  ) =
      addPluralMessage(srcMessage.asCachedStringName(), xlatedMessages, context.asCachedStringName())

  /**
   * Returns a message's translation.
   */
  public final fun getMessage(srcMessage: String, context: String): StringName =
      getMessage(srcMessage.asCachedStringName(), context.asCachedStringName())

  /**
   * Returns a message's translation involving plurals.
   *
   * The number [n] is the number or quantity of the plural object. It will be used to guide the
   * translation system to fetch the correct plural form for the selected language.
   *
   * **Note:** Plurals are only supported in
   * [url=$DOCS_URL/tutorials/i18n/localization_using_gettext.html]gettext-based translations
   * (PO)[/url], not CSV.
   */
  public final fun getPluralMessage(
    srcMessage: String,
    srcPluralMessage: String,
    n: Int,
    context: String,
  ): StringName =
      getPluralMessage(srcMessage.asCachedStringName(), srcPluralMessage.asCachedStringName(), n, context.asCachedStringName())

  /**
   * Erases a message.
   */
  public final fun eraseMessage(srcMessage: String, context: String) =
      eraseMessage(srcMessage.asCachedStringName(), context.asCachedStringName())

  public companion object {
    @JvmField
    public val setLocaleName: MethodStringName1<Translation, Unit, String> =
        MethodStringName1<Translation, Unit, String>("set_locale")

    @JvmField
    public val getLocaleName: MethodStringName0<Translation, String> =
        MethodStringName0<Translation, String>("get_locale")

    @JvmField
    public val addMessageName:
        MethodStringName3<Translation, Unit, StringName, StringName, StringName> =
        MethodStringName3<Translation, Unit, StringName, StringName, StringName>("add_message")

    @JvmField
    public val addPluralMessageName:
        MethodStringName3<Translation, Unit, StringName, PackedStringArray, StringName> =
        MethodStringName3<Translation, Unit, StringName, PackedStringArray, StringName>("add_plural_message")

    @JvmField
    public val getMessageName: MethodStringName2<Translation, StringName, StringName, StringName> =
        MethodStringName2<Translation, StringName, StringName, StringName>("get_message")

    @JvmField
    public val getPluralMessageName:
        MethodStringName4<Translation, StringName, StringName, StringName, Int, StringName> =
        MethodStringName4<Translation, StringName, StringName, StringName, Int, StringName>("get_plural_message")

    @JvmField
    public val eraseMessageName: MethodStringName2<Translation, Unit, StringName, StringName> =
        MethodStringName2<Translation, Unit, StringName, StringName>("erase_message")

    @JvmField
    public val getMessageListName: MethodStringName0<Translation, PackedStringArray> =
        MethodStringName0<Translation, PackedStringArray>("get_message_list")

    @JvmField
    public val getTranslatedMessageListName: MethodStringName0<Translation, PackedStringArray> =
        MethodStringName0<Translation, PackedStringArray>("get_translated_message_list")

    @JvmField
    public val getMessageCountName: MethodStringName0<Translation, Int> =
        MethodStringName0<Translation, Int>("get_message_count")

    @JvmField
    public val setPluralRulesOverrideName: MethodStringName1<Translation, Unit, String> =
        MethodStringName1<Translation, Unit, String>("set_plural_rules_override")

    @JvmField
    public val getPluralRulesOverrideName: MethodStringName0<Translation, String> =
        MethodStringName0<Translation, String>("get_plural_rules_override")
  }

  public object MethodBindings {
    internal val setLocalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Translation", "set_locale", 83702148)

    internal val getLocalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Translation", "get_locale", 201670096)

    internal val addMessagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Translation", "add_message", 3898530326)

    internal val addPluralMessagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Translation", "add_plural_message", 2356982266)

    internal val getMessagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Translation", "get_message", 1829228469)

    internal val getPluralMessagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Translation", "get_plural_message", 229954002)

    internal val eraseMessagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Translation", "erase_message", 3959009644)

    internal val getMessageListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Translation", "get_message_list", 1139954409)

    internal val getTranslatedMessageListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Translation", "get_translated_message_list", 1139954409)

    internal val getMessageCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Translation", "get_message_count", 3905245786)

    internal val setPluralRulesOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Translation", "set_plural_rules_override", 83702148)

    internal val getPluralRulesOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Translation", "get_plural_rules_override", 201670096)
  }
}
