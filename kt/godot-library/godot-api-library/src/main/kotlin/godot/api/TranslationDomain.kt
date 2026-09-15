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
import godot.core.MethodStringName4
import godot.core.StringName
import godot.core.VariantArray
import godot.core.asCachedStringName
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_STRING_BOOL
import godot.writeMethodArguments_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_LONG_STRING_NAME
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [TranslationDomain] is a self-contained collection of [Translation] resources. Translations can
 * be added to or removed from it.
 *
 * If you're working with the main translation domain, it is more convenient to use the wrap methods
 * on [TranslationServer].
 */
@GodotBaseType
public open class TranslationDomain : RefCounted() {
  /**
   * If `true`, translation is enabled. Otherwise, [translate] and [translatePlural] will return the
   * input message unchanged regardless of the current locale.
   */
  public final inline var enabled: Boolean
    @JvmName("enabledProperty")
    get() = isEnabled()
    @JvmName("enabledProperty")
    set(`value`) {
      setEnabled(value)
    }

  /**
   * If `true`, enables pseudolocalization for the project. This can be used to spot untranslatable
   * strings or layout issues that may occur once the project is localized to languages that have
   * longer strings than the source language.
   *
   * **Note:** Updating this property does not automatically update texts in the scene tree. Please
   * propagate the [MainLoop.NOTIFICATION_TRANSLATION_CHANGED] notification manually after you have
   * finished modifying pseudolocalization related options.
   */
  public final inline var pseudolocalizationEnabled: Boolean
    @JvmName("pseudolocalizationEnabledProperty")
    get() = isPseudolocalizationEnabled()
    @JvmName("pseudolocalizationEnabledProperty")
    set(`value`) {
      setPseudolocalizationEnabled(value)
    }

  /**
   * Replace all characters with their accented variants during pseudolocalization.
   *
   * **Note:** Updating this property does not automatically update texts in the scene tree. Please
   * propagate the [MainLoop.NOTIFICATION_TRANSLATION_CHANGED] notification manually after you have
   * finished modifying pseudolocalization related options.
   */
  public final inline var pseudolocalizationAccentsEnabled: Boolean
    @JvmName("pseudolocalizationAccentsEnabledProperty")
    get() = isPseudolocalizationAccentsEnabled()
    @JvmName("pseudolocalizationAccentsEnabledProperty")
    set(`value`) {
      setPseudolocalizationAccentsEnabled(value)
    }

  /**
   * Double vowels in strings during pseudolocalization to simulate the lengthening of text due to
   * localization.
   *
   * **Note:** Updating this property does not automatically update texts in the scene tree. Please
   * propagate the [MainLoop.NOTIFICATION_TRANSLATION_CHANGED] notification manually after you have
   * finished modifying pseudolocalization related options.
   */
  public final inline var pseudolocalizationDoubleVowelsEnabled: Boolean
    @JvmName("pseudolocalizationDoubleVowelsEnabledProperty")
    get() = isPseudolocalizationDoubleVowelsEnabled()
    @JvmName("pseudolocalizationDoubleVowelsEnabledProperty")
    set(`value`) {
      setPseudolocalizationDoubleVowelsEnabled(value)
    }

  /**
   * If `true`, emulate bidirectional (right-to-left) text when pseudolocalization is enabled. This
   * can be used to spot issues with RTL layout and UI mirroring that will crop up if the project is
   * localized to RTL languages such as Arabic or Hebrew.
   *
   * **Note:** Updating this property does not automatically update texts in the scene tree. Please
   * propagate the [MainLoop.NOTIFICATION_TRANSLATION_CHANGED] notification manually after you have
   * finished modifying pseudolocalization related options.
   */
  public final inline var pseudolocalizationFakeBidiEnabled: Boolean
    @JvmName("pseudolocalizationFakeBidiEnabledProperty")
    get() = isPseudolocalizationFakeBidiEnabled()
    @JvmName("pseudolocalizationFakeBidiEnabledProperty")
    set(`value`) {
      setPseudolocalizationFakeBidiEnabled(value)
    }

  /**
   * Replace all characters in the string with `*`. Useful for finding non-localizable strings.
   *
   * **Note:** Updating this property does not automatically update texts in the scene tree. Please
   * propagate the [MainLoop.NOTIFICATION_TRANSLATION_CHANGED] notification manually after you have
   * finished modifying pseudolocalization related options.
   */
  public final inline var pseudolocalizationOverrideEnabled: Boolean
    @JvmName("pseudolocalizationOverrideEnabledProperty")
    get() = isPseudolocalizationOverrideEnabled()
    @JvmName("pseudolocalizationOverrideEnabledProperty")
    set(`value`) {
      setPseudolocalizationOverrideEnabled(value)
    }

  /**
   * Skip placeholders for string formatting like `&#37;s` or `&#37;f` during pseudolocalization.
   * Useful to identify strings which need additional control characters to display correctly.
   *
   * **Note:** Updating this property does not automatically update texts in the scene tree. Please
   * propagate the [MainLoop.NOTIFICATION_TRANSLATION_CHANGED] notification manually after you have
   * finished modifying pseudolocalization related options.
   */
  public final inline var pseudolocalizationSkipPlaceholdersEnabled: Boolean
    @JvmName("pseudolocalizationSkipPlaceholdersEnabledProperty")
    get() = isPseudolocalizationSkipPlaceholdersEnabled()
    @JvmName("pseudolocalizationSkipPlaceholdersEnabledProperty")
    set(`value`) {
      setPseudolocalizationSkipPlaceholdersEnabled(value)
    }

  /**
   * The expansion ratio to use during pseudolocalization. A value of `0.3` is sufficient for most
   * practical purposes, and will increase the length of each string by 30&#37;.
   *
   * **Note:** Updating this property does not automatically update texts in the scene tree. Please
   * propagate the [MainLoop.NOTIFICATION_TRANSLATION_CHANGED] notification manually after you have
   * finished modifying pseudolocalization related options.
   */
  public final inline var pseudolocalizationExpansionRatio: Float
    @JvmName("pseudolocalizationExpansionRatioProperty")
    get() = getPseudolocalizationExpansionRatio()
    @JvmName("pseudolocalizationExpansionRatioProperty")
    set(`value`) {
      setPseudolocalizationExpansionRatio(value)
    }

  /**
   * Prefix that will be prepended to the pseudolocalized string.
   *
   * **Note:** Updating this property does not automatically update texts in the scene tree. Please
   * propagate the [MainLoop.NOTIFICATION_TRANSLATION_CHANGED] notification manually after you have
   * finished modifying pseudolocalization related options.
   */
  public final inline var pseudolocalizationPrefix: String
    @JvmName("pseudolocalizationPrefixProperty")
    get() = getPseudolocalizationPrefix()
    @JvmName("pseudolocalizationPrefixProperty")
    set(`value`) {
      setPseudolocalizationPrefix(value)
    }

  /**
   * Suffix that will be appended to the pseudolocalized string.
   *
   * **Note:** Updating this property does not automatically update texts in the scene tree. Please
   * propagate the [MainLoop.NOTIFICATION_TRANSLATION_CHANGED] notification manually after you have
   * finished modifying pseudolocalization related options.
   */
  public final inline var pseudolocalizationSuffix: String
    @JvmName("pseudolocalizationSuffixProperty")
    get() = getPseudolocalizationSuffix()
    @JvmName("pseudolocalizationSuffixProperty")
    set(`value`) {
      setPseudolocalizationSuffix(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(769, scriptPtr)
  }

  /**
   * Returns the [Translation] instance that best matches [locale]. Returns `null` if there are no
   * matches.
   */
  public final fun getTranslationObject(locale: String): Translation? {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, locale)
    TransferContext.callMethod(MethodBindings.getTranslationObjectPtr)
    return (TransferContext.readReturnValue_OBJECT() as Translation?)
  }

  /**
   * Adds a translation.
   */
  public final fun addTranslation(translation: Translation?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, translation)
    TransferContext.callPtrMethod(MethodBindings.addTranslationPtr, 0)
  }

  /**
   * Removes the given translation.
   */
  public final fun removeTranslation(translation: Translation?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, translation)
    TransferContext.callPtrMethod(MethodBindings.removeTranslationPtr, 0)
  }

  /**
   * Removes all translations.
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearPtr, 0)
  }

  /**
   * Returns all available [Translation] instances as added by [addTranslation].
   */
  public final fun getTranslations(): VariantArray<Translation> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTranslationsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Translation>)
  }

  /**
   * Returns `true` if there are any [Translation] instances that match [locale] (see
   * [TranslationServer.compareLocales]). If [exact] is `true`, only instances whose locale exactly
   * equals [locale] are considered.
   */
  public final fun hasTranslationForLocale(locale: String, exact: Boolean): Boolean {
    TransferContext.writeMethodArguments_STRING_BOOL(ptr, objectID.id, locale, exact)
    TransferContext.callMethod(MethodBindings.hasTranslationForLocalePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if this translation domain contains the given [translation].
   */
  public final fun hasTranslation(translation: Translation?): Boolean {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, translation)
    TransferContext.callPtrMethod(MethodBindings.hasTranslationPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the [Translation] instances that match [locale] (see
   * [TranslationServer.compareLocales]). If [exact] is `true`, only instances whose locale exactly
   * equals [locale] will be returned.
   */
  public final fun findTranslations(locale: String, exact: Boolean): VariantArray<Translation> {
    TransferContext.writeMethodArguments_STRING_BOOL(ptr, objectID.id, locale, exact)
    TransferContext.callMethod(MethodBindings.findTranslationsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Translation>)
  }

  /**
   * Returns the current locale's translation for the given message and context.
   */
  public final fun translate(message: StringName, context: StringName = StringName("")):
      StringName {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, message, context)
    TransferContext.callMethod(MethodBindings.translatePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns the current locale's translation for the given message, plural message and context.
   *
   * The number [n] is the number or quantity of the plural object. It will be used to guide the
   * translation system to fetch the correct plural form for the selected language.
   */
  public final fun translatePlural(
    message: StringName,
    messagePlural: StringName,
    n: Int,
    context: StringName = StringName(""),
  ): StringName {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_LONG_STRING_NAME(ptr, objectID.id, message, messagePlural, n.toLong(), context)
    TransferContext.callMethod(MethodBindings.translatePluralPtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns the locale override of the domain. Returns an empty string if locale override is
   * disabled.
   */
  public final fun getLocaleOverride(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLocaleOverridePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Sets the locale override of the domain.
   *
   * If [locale] is an empty string, locale override is disabled. Otherwise, [locale] will be
   * standardized to match known locales (e.g. `en-US` would be matched to `en_US`).
   *
   * **Note:** Calling this method does not automatically update texts in the scene tree. Please
   * propagate the [MainLoop.NOTIFICATION_TRANSLATION_CHANGED] signal manually.
   */
  public final fun setLocaleOverride(locale: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, locale)
    TransferContext.callMethod(MethodBindings.setLocaleOverridePtr)
  }

  public final fun isEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setEnabledPtr, 0)
  }

  public final fun isPseudolocalizationEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isPseudolocalizationEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setPseudolocalizationEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setPseudolocalizationEnabledPtr, 0)
  }

  public final fun isPseudolocalizationAccentsEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isPseudolocalizationAccentsEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setPseudolocalizationAccentsEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setPseudolocalizationAccentsEnabledPtr, 0)
  }

  public final fun isPseudolocalizationDoubleVowelsEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isPseudolocalizationDoubleVowelsEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setPseudolocalizationDoubleVowelsEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setPseudolocalizationDoubleVowelsEnabledPtr, 0)
  }

  public final fun isPseudolocalizationFakeBidiEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isPseudolocalizationFakeBidiEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setPseudolocalizationFakeBidiEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setPseudolocalizationFakeBidiEnabledPtr, 0)
  }

  public final fun isPseudolocalizationOverrideEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isPseudolocalizationOverrideEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setPseudolocalizationOverrideEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setPseudolocalizationOverrideEnabledPtr, 0)
  }

  public final fun isPseudolocalizationSkipPlaceholdersEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isPseudolocalizationSkipPlaceholdersEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setPseudolocalizationSkipPlaceholdersEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setPseudolocalizationSkipPlaceholdersEnabledPtr, 0)
  }

  public final fun getPseudolocalizationExpansionRatio(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPseudolocalizationExpansionRatioPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setPseudolocalizationExpansionRatio(ratio: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, ratio.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setPseudolocalizationExpansionRatioPtr, 0)
  }

  public final fun getPseudolocalizationPrefix(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPseudolocalizationPrefixPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setPseudolocalizationPrefix(prefix: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, prefix)
    TransferContext.callMethod(MethodBindings.setPseudolocalizationPrefixPtr)
  }

  public final fun getPseudolocalizationSuffix(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPseudolocalizationSuffixPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setPseudolocalizationSuffix(suffix: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, suffix)
    TransferContext.callMethod(MethodBindings.setPseudolocalizationSuffixPtr)
  }

  /**
   * Returns the pseudolocalized string based on the [message] passed in.
   */
  public final fun pseudolocalize(message: StringName): StringName {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, message)
    TransferContext.callMethod(MethodBindings.pseudolocalizePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns the current locale's translation for the given message and context.
   */
  public final fun translate(message: String, context: String): StringName =
      translate(message.asCachedStringName(), context.asCachedStringName())

  /**
   * Returns the current locale's translation for the given message, plural message and context.
   *
   * The number [n] is the number or quantity of the plural object. It will be used to guide the
   * translation system to fetch the correct plural form for the selected language.
   */
  public final fun translatePlural(
    message: String,
    messagePlural: String,
    n: Int,
    context: String,
  ): StringName =
      translatePlural(message.asCachedStringName(), messagePlural.asCachedStringName(), n, context.asCachedStringName())

  /**
   * Returns the pseudolocalized string based on the [message] passed in.
   */
  public final fun pseudolocalize(message: String): StringName =
      pseudolocalize(message.asCachedStringName())

  public companion object {
    @JvmField
    public val getTranslationObjectName: MethodStringName1<TranslationDomain, Translation?, String>
        = MethodStringName1<TranslationDomain, Translation?, String>("get_translation_object")

    @JvmField
    public val addTranslationName: MethodStringName1<TranslationDomain, Unit, Translation?> =
        MethodStringName1<TranslationDomain, Unit, Translation?>("add_translation")

    @JvmField
    public val removeTranslationName: MethodStringName1<TranslationDomain, Unit, Translation?> =
        MethodStringName1<TranslationDomain, Unit, Translation?>("remove_translation")

    @JvmField
    public val clearName: MethodStringName0<TranslationDomain, Unit> =
        MethodStringName0<TranslationDomain, Unit>("clear")

    @JvmField
    public val getTranslationsName: MethodStringName0<TranslationDomain, VariantArray<Translation>>
        = MethodStringName0<TranslationDomain, VariantArray<Translation>>("get_translations")

    @JvmField
    public val hasTranslationForLocaleName:
        MethodStringName2<TranslationDomain, Boolean, String, Boolean> =
        MethodStringName2<TranslationDomain, Boolean, String, Boolean>("has_translation_for_locale")

    @JvmField
    public val hasTranslationName: MethodStringName1<TranslationDomain, Boolean, Translation?> =
        MethodStringName1<TranslationDomain, Boolean, Translation?>("has_translation")

    @JvmField
    public val findTranslationsName:
        MethodStringName2<TranslationDomain, VariantArray<Translation>, String, Boolean> =
        MethodStringName2<TranslationDomain, VariantArray<Translation>, String, Boolean>("find_translations")

    @JvmField
    public val translateName:
        MethodStringName2<TranslationDomain, StringName, StringName, StringName> =
        MethodStringName2<TranslationDomain, StringName, StringName, StringName>("translate")

    @JvmField
    public val translatePluralName:
        MethodStringName4<TranslationDomain, StringName, StringName, StringName, Int, StringName> =
        MethodStringName4<TranslationDomain, StringName, StringName, StringName, Int, StringName>("translate_plural")

    @JvmField
    public val getLocaleOverrideName: MethodStringName0<TranslationDomain, String> =
        MethodStringName0<TranslationDomain, String>("get_locale_override")

    @JvmField
    public val setLocaleOverrideName: MethodStringName1<TranslationDomain, Unit, String> =
        MethodStringName1<TranslationDomain, Unit, String>("set_locale_override")

    @JvmField
    public val isEnabledName: MethodStringName0<TranslationDomain, Boolean> =
        MethodStringName0<TranslationDomain, Boolean>("is_enabled")

    @JvmField
    public val setEnabledName: MethodStringName1<TranslationDomain, Unit, Boolean> =
        MethodStringName1<TranslationDomain, Unit, Boolean>("set_enabled")

    @JvmField
    public val isPseudolocalizationEnabledName: MethodStringName0<TranslationDomain, Boolean> =
        MethodStringName0<TranslationDomain, Boolean>("is_pseudolocalization_enabled")

    @JvmField
    public val setPseudolocalizationEnabledName: MethodStringName1<TranslationDomain, Unit, Boolean>
        = MethodStringName1<TranslationDomain, Unit, Boolean>("set_pseudolocalization_enabled")

    @JvmField
    public val isPseudolocalizationAccentsEnabledName: MethodStringName0<TranslationDomain, Boolean>
        = MethodStringName0<TranslationDomain, Boolean>("is_pseudolocalization_accents_enabled")

    @JvmField
    public val setPseudolocalizationAccentsEnabledName:
        MethodStringName1<TranslationDomain, Unit, Boolean> =
        MethodStringName1<TranslationDomain, Unit, Boolean>("set_pseudolocalization_accents_enabled")

    @JvmField
    public val isPseudolocalizationDoubleVowelsEnabledName:
        MethodStringName0<TranslationDomain, Boolean> =
        MethodStringName0<TranslationDomain, Boolean>("is_pseudolocalization_double_vowels_enabled")

    @JvmField
    public val setPseudolocalizationDoubleVowelsEnabledName:
        MethodStringName1<TranslationDomain, Unit, Boolean> =
        MethodStringName1<TranslationDomain, Unit, Boolean>("set_pseudolocalization_double_vowels_enabled")

    @JvmField
    public val isPseudolocalizationFakeBidiEnabledName:
        MethodStringName0<TranslationDomain, Boolean> =
        MethodStringName0<TranslationDomain, Boolean>("is_pseudolocalization_fake_bidi_enabled")

    @JvmField
    public val setPseudolocalizationFakeBidiEnabledName:
        MethodStringName1<TranslationDomain, Unit, Boolean> =
        MethodStringName1<TranslationDomain, Unit, Boolean>("set_pseudolocalization_fake_bidi_enabled")

    @JvmField
    public val isPseudolocalizationOverrideEnabledName:
        MethodStringName0<TranslationDomain, Boolean> =
        MethodStringName0<TranslationDomain, Boolean>("is_pseudolocalization_override_enabled")

    @JvmField
    public val setPseudolocalizationOverrideEnabledName:
        MethodStringName1<TranslationDomain, Unit, Boolean> =
        MethodStringName1<TranslationDomain, Unit, Boolean>("set_pseudolocalization_override_enabled")

    @JvmField
    public val isPseudolocalizationSkipPlaceholdersEnabledName:
        MethodStringName0<TranslationDomain, Boolean> =
        MethodStringName0<TranslationDomain, Boolean>("is_pseudolocalization_skip_placeholders_enabled")

    @JvmField
    public val setPseudolocalizationSkipPlaceholdersEnabledName:
        MethodStringName1<TranslationDomain, Unit, Boolean> =
        MethodStringName1<TranslationDomain, Unit, Boolean>("set_pseudolocalization_skip_placeholders_enabled")

    @JvmField
    public val getPseudolocalizationExpansionRatioName: MethodStringName0<TranslationDomain, Float>
        = MethodStringName0<TranslationDomain, Float>("get_pseudolocalization_expansion_ratio")

    @JvmField
    public val setPseudolocalizationExpansionRatioName:
        MethodStringName1<TranslationDomain, Unit, Float> =
        MethodStringName1<TranslationDomain, Unit, Float>("set_pseudolocalization_expansion_ratio")

    @JvmField
    public val getPseudolocalizationPrefixName: MethodStringName0<TranslationDomain, String> =
        MethodStringName0<TranslationDomain, String>("get_pseudolocalization_prefix")

    @JvmField
    public val setPseudolocalizationPrefixName: MethodStringName1<TranslationDomain, Unit, String> =
        MethodStringName1<TranslationDomain, Unit, String>("set_pseudolocalization_prefix")

    @JvmField
    public val getPseudolocalizationSuffixName: MethodStringName0<TranslationDomain, String> =
        MethodStringName0<TranslationDomain, String>("get_pseudolocalization_suffix")

    @JvmField
    public val setPseudolocalizationSuffixName: MethodStringName1<TranslationDomain, Unit, String> =
        MethodStringName1<TranslationDomain, Unit, String>("set_pseudolocalization_suffix")

    @JvmField
    public val pseudolocalizeName: MethodStringName1<TranslationDomain, StringName, StringName> =
        MethodStringName1<TranslationDomain, StringName, StringName>("pseudolocalize")
  }

  public object MethodBindings {
    internal val getTranslationObjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "get_translation_object", 606768082)

    internal val addTranslationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "add_translation", 1466479800)

    internal val removeTranslationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "remove_translation", 1466479800)

    internal val clearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "clear", 3218959716)

    internal val getTranslationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "get_translations", 3995934104)

    internal val hasTranslationForLocalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "has_translation_for_locale", 2034713381)

    internal val hasTranslationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "has_translation", 2696976312)

    internal val findTranslationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "find_translations", 2109650934)

    internal val translatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "translate", 1829228469)

    internal val translatePluralPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "translate_plural", 229954002)

    internal val getLocaleOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "get_locale_override", 201670096)

    internal val setLocaleOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "set_locale_override", 83702148)

    internal val isEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "is_enabled", 36873697)

    internal val setEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "set_enabled", 2586408642)

    internal val isPseudolocalizationEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "is_pseudolocalization_enabled", 36873697)

    internal val setPseudolocalizationEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "set_pseudolocalization_enabled", 2586408642)

    internal val isPseudolocalizationAccentsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "is_pseudolocalization_accents_enabled", 36873697)

    internal val setPseudolocalizationAccentsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "set_pseudolocalization_accents_enabled", 2586408642)

    internal val isPseudolocalizationDoubleVowelsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "is_pseudolocalization_double_vowels_enabled", 36873697)

    internal val setPseudolocalizationDoubleVowelsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "set_pseudolocalization_double_vowels_enabled", 2586408642)

    internal val isPseudolocalizationFakeBidiEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "is_pseudolocalization_fake_bidi_enabled", 36873697)

    internal val setPseudolocalizationFakeBidiEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "set_pseudolocalization_fake_bidi_enabled", 2586408642)

    internal val isPseudolocalizationOverrideEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "is_pseudolocalization_override_enabled", 36873697)

    internal val setPseudolocalizationOverrideEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "set_pseudolocalization_override_enabled", 2586408642)

    internal val isPseudolocalizationSkipPlaceholdersEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "is_pseudolocalization_skip_placeholders_enabled", 36873697)

    internal val setPseudolocalizationSkipPlaceholdersEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "set_pseudolocalization_skip_placeholders_enabled", 2586408642)

    internal val getPseudolocalizationExpansionRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "get_pseudolocalization_expansion_ratio", 1740695150)

    internal val setPseudolocalizationExpansionRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "set_pseudolocalization_expansion_ratio", 373806689)

    internal val getPseudolocalizationPrefixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "get_pseudolocalization_prefix", 201670096)

    internal val setPseudolocalizationPrefixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "set_pseudolocalization_prefix", 83702148)

    internal val getPseudolocalizationSuffixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "get_pseudolocalization_suffix", 201670096)

    internal val setPseudolocalizationSuffixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "set_pseudolocalization_suffix", 83702148)

    internal val pseudolocalizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationDomain", "pseudolocalize", 1965194235)
  }
}
