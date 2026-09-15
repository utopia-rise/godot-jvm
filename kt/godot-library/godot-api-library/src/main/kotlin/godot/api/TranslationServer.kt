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
import godot.core.PackedStringArray
import godot.core.StringName
import godot.core.VariantArray
import godot.core.asCachedStringName
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_PACKED_STRING_ARRAY
import godot.readReturnValue_STRING
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_STRING_BOOL
import godot.writeMethodArguments_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_LONG_STRING_NAME
import godot.writeMethodArguments_STRING_STRING
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * The translation server is the API backend that manages all language translations.
 *
 * Translations are stored in [TranslationDomain]s, which can be accessed by name. The most commonly
 * used translation domain is the main translation domain. It always exists and can be accessed using
 * an empty [StringName]. The translation server provides wrapper methods for accessing the main
 * translation domain directly, without having to fetch the translation domain first. Custom
 * translation domains are mainly for advanced usages like editor plugins. Names starting with `godot.`
 * are reserved for engine internals.
 */
@GodotBaseType
public object TranslationServer : Object() {
  @JvmField
  public val setLocaleName: MethodStringName1<TranslationServer, Unit, String> =
      MethodStringName1<TranslationServer, Unit, String>("set_locale")

  @JvmField
  public val getLocaleName: MethodStringName0<TranslationServer, String> =
      MethodStringName0<TranslationServer, String>("get_locale")

  @JvmField
  public val getToolLocaleName: MethodStringName0<TranslationServer, String> =
      MethodStringName0<TranslationServer, String>("get_tool_locale")

  @JvmField
  public val compareLocalesName: MethodStringName2<TranslationServer, Int, String, String> =
      MethodStringName2<TranslationServer, Int, String, String>("compare_locales")

  @JvmField
  public val standardizeLocaleName: MethodStringName2<TranslationServer, String, String, Boolean> =
      MethodStringName2<TranslationServer, String, String, Boolean>("standardize_locale")

  @JvmField
  public val getAllLanguagesName: MethodStringName0<TranslationServer, PackedStringArray> =
      MethodStringName0<TranslationServer, PackedStringArray>("get_all_languages")

  @JvmField
  public val getLanguageNameName: MethodStringName1<TranslationServer, String, String> =
      MethodStringName1<TranslationServer, String, String>("get_language_name")

  @JvmField
  public val getAllScriptsName: MethodStringName0<TranslationServer, PackedStringArray> =
      MethodStringName0<TranslationServer, PackedStringArray>("get_all_scripts")

  @JvmField
  public val getScriptNameName: MethodStringName1<TranslationServer, String, String> =
      MethodStringName1<TranslationServer, String, String>("get_script_name")

  @JvmField
  public val getAllCountriesName: MethodStringName0<TranslationServer, PackedStringArray> =
      MethodStringName0<TranslationServer, PackedStringArray>("get_all_countries")

  @JvmField
  public val getCountryNameName: MethodStringName1<TranslationServer, String, String> =
      MethodStringName1<TranslationServer, String, String>("get_country_name")

  @JvmField
  public val getLocaleNameName: MethodStringName1<TranslationServer, String, String> =
      MethodStringName1<TranslationServer, String, String>("get_locale_name")

  @JvmField
  public val getPluralRulesName: MethodStringName1<TranslationServer, String, String> =
      MethodStringName1<TranslationServer, String, String>("get_plural_rules")

  @JvmField
  public val translateName: MethodStringName2<TranslationServer, StringName, StringName, StringName>
      = MethodStringName2<TranslationServer, StringName, StringName, StringName>("translate")

  @JvmField
  public val translatePluralName:
      MethodStringName4<TranslationServer, StringName, StringName, StringName, Int, StringName> =
      MethodStringName4<TranslationServer, StringName, StringName, StringName, Int, StringName>("translate_plural")

  @JvmField
  public val addTranslationName: MethodStringName1<TranslationServer, Unit, Translation?> =
      MethodStringName1<TranslationServer, Unit, Translation?>("add_translation")

  @JvmField
  public val removeTranslationName: MethodStringName1<TranslationServer, Unit, Translation?> =
      MethodStringName1<TranslationServer, Unit, Translation?>("remove_translation")

  @JvmField
  public val getTranslationObjectName: MethodStringName1<TranslationServer, Translation?, String> =
      MethodStringName1<TranslationServer, Translation?, String>("get_translation_object")

  @JvmField
  public val getTranslationsName: MethodStringName0<TranslationServer, VariantArray<Translation>> =
      MethodStringName0<TranslationServer, VariantArray<Translation>>("get_translations")

  @JvmField
  public val findTranslationsName:
      MethodStringName2<TranslationServer, VariantArray<Translation>, String, Boolean> =
      MethodStringName2<TranslationServer, VariantArray<Translation>, String, Boolean>("find_translations")

  @JvmField
  public val hasTranslationForLocaleName:
      MethodStringName2<TranslationServer, Boolean, String, Boolean> =
      MethodStringName2<TranslationServer, Boolean, String, Boolean>("has_translation_for_locale")

  @JvmField
  public val hasTranslationName: MethodStringName1<TranslationServer, Boolean, Translation?> =
      MethodStringName1<TranslationServer, Boolean, Translation?>("has_translation")

  @JvmField
  public val hasDomainName: MethodStringName1<TranslationServer, Boolean, StringName> =
      MethodStringName1<TranslationServer, Boolean, StringName>("has_domain")

  @JvmField
  public val getOrAddDomainName:
      MethodStringName1<TranslationServer, TranslationDomain?, StringName> =
      MethodStringName1<TranslationServer, TranslationDomain?, StringName>("get_or_add_domain")

  @JvmField
  public val removeDomainName: MethodStringName1<TranslationServer, Unit, StringName> =
      MethodStringName1<TranslationServer, Unit, StringName>("remove_domain")

  @JvmField
  public val clearName: MethodStringName0<TranslationServer, Unit> =
      MethodStringName0<TranslationServer, Unit>("clear")

  @JvmField
  public val getLoadedLocalesName: MethodStringName0<TranslationServer, PackedStringArray> =
      MethodStringName0<TranslationServer, PackedStringArray>("get_loaded_locales")

  @JvmField
  public val formatNumberName: MethodStringName2<TranslationServer, String, String, String> =
      MethodStringName2<TranslationServer, String, String, String>("format_number")

  @JvmField
  public val getPercentSignName: MethodStringName1<TranslationServer, String, String> =
      MethodStringName1<TranslationServer, String, String>("get_percent_sign")

  @JvmField
  public val parseNumberName: MethodStringName2<TranslationServer, String, String, String> =
      MethodStringName2<TranslationServer, String, String, String>("parse_number")

  @JvmField
  public val isPseudolocalizationEnabledName: MethodStringName0<TranslationServer, Boolean> =
      MethodStringName0<TranslationServer, Boolean>("is_pseudolocalization_enabled")

  @JvmField
  public val setPseudolocalizationEnabledName: MethodStringName1<TranslationServer, Unit, Boolean> =
      MethodStringName1<TranslationServer, Unit, Boolean>("set_pseudolocalization_enabled")

  @JvmField
  public val reloadPseudolocalizationName: MethodStringName0<TranslationServer, Unit> =
      MethodStringName0<TranslationServer, Unit>("reload_pseudolocalization")

  @JvmField
  public val pseudolocalizeName: MethodStringName1<TranslationServer, StringName, StringName> =
      MethodStringName1<TranslationServer, StringName, StringName>("pseudolocalize")

  /**
   * If `true`, enables the use of pseudolocalization on the main translation domain. See
   * [ProjectSettings.internationalization/pseudolocalization/usePseudolocalization] for details.
   */
  @JvmStatic
  public final inline var pseudolocalizationEnabled: Boolean
    @JvmName("pseudolocalizationEnabledProperty")
    get() = isPseudolocalizationEnabled()
    @JvmName("pseudolocalizationEnabledProperty")
    set(`value`) {
      setPseudolocalizationEnabled(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(36)
  }

  /**
   * Sets the locale of the project. The [locale] string will be standardized to match known locales
   * (e.g. `en-US` would be matched to `en_US`).
   *
   * If translations have been loaded beforehand for the new locale, they will be applied.
   */
  @JvmStatic
  public final fun setLocale(locale: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, locale)
    TransferContext.callMethod(MethodBindings.setLocalePtr)
  }

  /**
   * Returns the current locale of the project.
   *
   * See also [OS.getLocale] and [OS.getLocaleLanguage] to query the locale of the user system.
   */
  @JvmStatic
  public final fun getLocale(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLocalePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the current locale of the editor.
   *
   * **Note:** When called from an exported project returns the same value as [getLocale].
   */
  @JvmStatic
  public final fun getToolLocale(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getToolLocalePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Compares two locales and returns a similarity score between `0` (no match) and `10` (full
   * match).
   */
  @JvmStatic
  public final fun compareLocales(localeA: String, localeB: String): Int {
    TransferContext.writeMethodArguments_STRING_STRING(ptr, objectID.id, localeA, localeB)
    TransferContext.callMethod(MethodBindings.compareLocalesPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns a [locale] string standardized to match known locales (e.g. `en-US` would be matched to
   * `en_US`). If [addDefaults] is `true`, the locale may have a default script or country added.
   */
  @JvmOverloads
  @JvmStatic
  public final fun standardizeLocale(locale: String, addDefaults: Boolean = false): String {
    TransferContext.writeMethodArguments_STRING_BOOL(ptr, objectID.id, locale, addDefaults)
    TransferContext.callMethod(MethodBindings.standardizeLocalePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns array of known language codes.
   */
  @JvmStatic
  public final fun getAllLanguages(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAllLanguagesPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns a readable language name for the [language] code.
   */
  @JvmStatic
  public final fun getLanguageName(language: String): String {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, language)
    TransferContext.callMethod(MethodBindings.getLanguageNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns an array of known script codes.
   */
  @JvmStatic
  public final fun getAllScripts(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAllScriptsPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns a readable script name for the [script] code.
   */
  @JvmStatic
  public final fun getScriptName(script: String): String {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, script)
    TransferContext.callMethod(MethodBindings.getScriptNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns an array of known country codes.
   */
  @JvmStatic
  public final fun getAllCountries(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAllCountriesPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns a readable country name for the [country] code.
   */
  @JvmStatic
  public final fun getCountryName(country: String): String {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, country)
    TransferContext.callMethod(MethodBindings.getCountryNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns a locale's language and its variant (e.g. `"en_US"` would return `"English (United
   * States)"`).
   */
  @JvmStatic
  public final fun getLocaleName(locale: String): String {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, locale)
    TransferContext.callMethod(MethodBindings.getLocaleNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the default plural rules for the [locale].
   */
  @JvmStatic
  public final fun getPluralRules(locale: String): String {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, locale)
    TransferContext.callMethod(MethodBindings.getPluralRulesPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the current locale's translation for the given message and context.
   *
   * **Note:** This method always uses the main translation domain.
   */
  @JvmStatic
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
   *
   * **Note:** This method always uses the main translation domain.
   */
  @JvmStatic
  public final fun translatePlural(
    message: StringName,
    pluralMessage: StringName,
    n: Int,
    context: StringName = StringName(""),
  ): StringName {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_LONG_STRING_NAME(ptr, objectID.id, message, pluralMessage, n.toLong(), context)
    TransferContext.callMethod(MethodBindings.translatePluralPtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Adds a translation to the main translation domain.
   */
  @JvmStatic
  public final fun addTranslation(translation: Translation?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, translation)
    TransferContext.callMethod(MethodBindings.addTranslationPtr)
  }

  /**
   * Removes the given translation from the main translation domain.
   */
  @JvmStatic
  public final fun removeTranslation(translation: Translation?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, translation)
    TransferContext.callMethod(MethodBindings.removeTranslationPtr)
  }

  /**
   * Returns the [Translation] instance that best matches [locale] in the main translation domain.
   * Returns `null` if there are no matches.
   */
  @JvmStatic
  public final fun getTranslationObject(locale: String): Translation? {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, locale)
    TransferContext.callMethod(MethodBindings.getTranslationObjectPtr)
    return (TransferContext.readReturnValue_OBJECT() as Translation?)
  }

  /**
   * Returns all available [Translation] instances in the main translation domain as added by
   * [addTranslation].
   */
  @JvmStatic
  public final fun getTranslations(): VariantArray<Translation> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTranslationsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Translation>)
  }

  /**
   * Returns the [Translation] instances in the main translation domain that match [locale] (see
   * [compareLocales]). If [exact] is `true`, only instances whose locale exactly equals [locale] will
   * be returned.
   */
  @JvmStatic
  public final fun findTranslations(locale: String, exact: Boolean): VariantArray<Translation> {
    TransferContext.writeMethodArguments_STRING_BOOL(ptr, objectID.id, locale, exact)
    TransferContext.callMethod(MethodBindings.findTranslationsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Translation>)
  }

  /**
   * Returns `true` if there are any [Translation] instances in the main translation domain that
   * match [locale] (see [compareLocales]). If [exact] is `true`, only instances whose locale exactly
   * equals [locale] are considered.
   */
  @JvmStatic
  public final fun hasTranslationForLocale(locale: String, exact: Boolean): Boolean {
    TransferContext.writeMethodArguments_STRING_BOOL(ptr, objectID.id, locale, exact)
    TransferContext.callMethod(MethodBindings.hasTranslationForLocalePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the main translation domain contains the given [translation].
   */
  @JvmStatic
  public final fun hasTranslation(translation: Translation?): Boolean {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, translation)
    TransferContext.callMethod(MethodBindings.hasTranslationPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if a translation domain with the specified name exists.
   */
  @JvmStatic
  public final fun hasDomain(domain: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, domain)
    TransferContext.callMethod(MethodBindings.hasDomainPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the translation domain with the specified name. An empty translation domain will be
   * created and added if it does not exist.
   */
  @JvmStatic
  public final fun getOrAddDomain(domain: StringName): TranslationDomain? {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, domain)
    TransferContext.callMethod(MethodBindings.getOrAddDomainPtr)
    return (TransferContext.readReturnValue_OBJECT() as TranslationDomain?)
  }

  /**
   * Removes the translation domain with the specified name.
   *
   * **Note:** Trying to remove the main translation domain is an error.
   */
  @JvmStatic
  public final fun removeDomain(domain: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, domain)
    TransferContext.callMethod(MethodBindings.removeDomainPtr)
  }

  /**
   * Removes all translations from the main translation domain.
   */
  @JvmStatic
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPtr)
  }

  /**
   * Returns an array of all loaded locales of the project.
   */
  @JvmStatic
  public final fun getLoadedLocales(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLoadedLocalesPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Converts a number from Western Arabic (0..9) to the numeral system used in the given [locale].
   */
  @JvmStatic
  public final fun formatNumber(number: String, locale: String): String {
    TransferContext.writeMethodArguments_STRING_STRING(ptr, objectID.id, number, locale)
    TransferContext.callMethod(MethodBindings.formatNumberPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the percent sign used in the given [locale].
   */
  @JvmStatic
  public final fun getPercentSign(locale: String): String {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, locale)
    TransferContext.callMethod(MethodBindings.getPercentSignPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Converts [number] from the numeral system used in the given [locale] to Western Arabic (0..9).
   */
  @JvmStatic
  public final fun parseNumber(number: String, locale: String): String {
    TransferContext.writeMethodArguments_STRING_STRING(ptr, objectID.id, number, locale)
    TransferContext.callMethod(MethodBindings.parseNumberPtr)
    return TransferContext.readReturnValue_STRING()
  }

  @JvmStatic
  public final fun isPseudolocalizationEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPseudolocalizationEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  @JvmStatic
  public final fun setPseudolocalizationEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setPseudolocalizationEnabledPtr)
  }

  /**
   * Reparses the pseudolocalization options and reloads the translation for the main translation
   * domain.
   */
  @JvmStatic
  public final fun reloadPseudolocalization(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.reloadPseudolocalizationPtr)
  }

  /**
   * Returns the pseudolocalized string based on the [message] passed in.
   *
   * **Note:** This method always uses the main translation domain.
   */
  @JvmStatic
  public final fun pseudolocalize(message: StringName): StringName {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, message)
    TransferContext.callMethod(MethodBindings.pseudolocalizePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns the current locale's translation for the given message and context.
   *
   * **Note:** This method always uses the main translation domain.
   */
  @JvmStatic
  public final fun translate(message: String, context: String): StringName =
      translate(message.asCachedStringName(), context.asCachedStringName())

  /**
   * Returns the current locale's translation for the given message, plural message and context.
   *
   * The number [n] is the number or quantity of the plural object. It will be used to guide the
   * translation system to fetch the correct plural form for the selected language.
   *
   * **Note:** This method always uses the main translation domain.
   */
  @JvmStatic
  public final fun translatePlural(
    message: String,
    pluralMessage: String,
    n: Int,
    context: String,
  ): StringName =
      translatePlural(message.asCachedStringName(), pluralMessage.asCachedStringName(), n, context.asCachedStringName())

  /**
   * Returns `true` if a translation domain with the specified name exists.
   */
  @JvmStatic
  public final fun hasDomain(domain: String): Boolean = hasDomain(domain.asCachedStringName())

  /**
   * Returns the translation domain with the specified name. An empty translation domain will be
   * created and added if it does not exist.
   */
  @JvmStatic
  public final fun getOrAddDomain(domain: String): TranslationDomain? =
      getOrAddDomain(domain.asCachedStringName())

  /**
   * Removes the translation domain with the specified name.
   *
   * **Note:** Trying to remove the main translation domain is an error.
   */
  @JvmStatic
  public final fun removeDomain(domain: String) = removeDomain(domain.asCachedStringName())

  /**
   * Returns the pseudolocalized string based on the [message] passed in.
   *
   * **Note:** This method always uses the main translation domain.
   */
  @JvmStatic
  public final fun pseudolocalize(message: String): StringName =
      pseudolocalize(message.asCachedStringName())

  public object MethodBindings {
    internal val setLocalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "set_locale", 83702148)

    internal val getLocalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "get_locale", 201670096)

    internal val getToolLocalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "get_tool_locale", 2841200299)

    internal val compareLocalesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "compare_locales", 2878152881)

    internal val standardizeLocalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "standardize_locale", 4216441673)

    internal val getAllLanguagesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "get_all_languages", 1139954409)

    internal val getLanguageNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "get_language_name", 3135753539)

    internal val getAllScriptsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "get_all_scripts", 1139954409)

    internal val getScriptNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "get_script_name", 3135753539)

    internal val getAllCountriesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "get_all_countries", 1139954409)

    internal val getCountryNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "get_country_name", 3135753539)

    internal val getLocaleNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "get_locale_name", 3135753539)

    internal val getPluralRulesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "get_plural_rules", 3135753539)

    internal val translatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "translate", 1829228469)

    internal val translatePluralPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "translate_plural", 229954002)

    internal val addTranslationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "add_translation", 1466479800)

    internal val removeTranslationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "remove_translation", 1466479800)

    internal val getTranslationObjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "get_translation_object", 2065240175)

    internal val getTranslationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "get_translations", 3995934104)

    internal val findTranslationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "find_translations", 2109650934)

    internal val hasTranslationForLocalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "has_translation_for_locale", 2034713381)

    internal val hasTranslationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "has_translation", 2696976312)

    internal val hasDomainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "has_domain", 2619796661)

    internal val getOrAddDomainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "get_or_add_domain", 397200075)

    internal val removeDomainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "remove_domain", 3304788590)

    internal val clearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "clear", 3218959716)

    internal val getLoadedLocalesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "get_loaded_locales", 1139954409)

    internal val formatNumberPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "format_number", 315676799)

    internal val getPercentSignPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "get_percent_sign", 3135753539)

    internal val parseNumberPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "parse_number", 315676799)

    internal val isPseudolocalizationEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "is_pseudolocalization_enabled", 36873697)

    internal val setPseudolocalizationEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "set_pseudolocalization_enabled", 2586408642)

    internal val reloadPseudolocalizationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "reload_pseudolocalization", 3218959716)

    internal val pseudolocalizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TranslationServer", "pseudolocalize", 1965194235)
  }
}
