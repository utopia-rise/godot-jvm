// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_STRING
import godot.callMethod_STRING
import godot.callMethod_STRING_BOOL_ret_ARRAY
import godot.callMethod_STRING_BOOL_ret_BOOL
import godot.callMethod_STRING_BOOL_ret_STRING
import godot.callMethod_STRING_STRING_ret_LONG
import godot.callMethod_STRING_STRING_ret_STRING
import godot.callMethod_STRING_ret_OBJECT_REF
import godot.callMethod_STRING_ret_STRING
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_ARRAY
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_PACKED_STRING_ARRAY
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_OBJECT
import godot.callPtrMethod_OBJECT_ret_BOOL
import godot.callPtrMethod_STRING_NAME
import godot.callPtrMethod_STRING_NAME_STRING_NAME_LONG_STRING_NAME_ret_STRING_NAME
import godot.callPtrMethod_STRING_NAME_STRING_NAME_ret_STRING_NAME
import godot.callPtrMethod_STRING_NAME_ret_BOOL
import godot.callPtrMethod_STRING_NAME_ret_OBJECT_REF
import godot.callPtrMethod_STRING_NAME_ret_STRING_NAME
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName4
import godot.core.PackedStringArray
import godot.core.StringName
import godot.core.VariantArray
import godot.core.asCachedStringName
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
    callMethod_STRING(MethodBindings.setLocalePtr, locale)
  }

  /**
   * Returns the current locale of the project.
   *
   * See also [OS.getLocale] and [OS.getLocaleLanguage] to query the locale of the user system.
   */
  @JvmStatic
  public final fun getLocale(): String = callMethod0_ret_STRING(MethodBindings.getLocalePtr)

  /**
   * Returns the current locale of the editor.
   *
   * **Note:** When called from an exported project returns the same value as [getLocale].
   */
  @JvmStatic
  public final fun getToolLocale(): String = callMethod0_ret_STRING(MethodBindings.getToolLocalePtr)

  /**
   * Compares two locales and returns a similarity score between `0` (no match) and `10` (full
   * match).
   */
  @JvmStatic
  public final fun compareLocales(localeA: String, localeB: String): Int =
      callMethod_STRING_STRING_ret_LONG(MethodBindings.compareLocalesPtr, localeA, localeB).toInt()

  /**
   * Returns a [locale] string standardized to match known locales (e.g. `en-US` would be matched to
   * `en_US`). If [addDefaults] is `true`, the locale may have a default script or country added.
   */
  @JvmOverloads
  @JvmStatic
  public final fun standardizeLocale(locale: String, addDefaults: Boolean = false): String =
      callMethod_STRING_BOOL_ret_STRING(MethodBindings.standardizeLocalePtr, locale, addDefaults)

  /**
   * Returns array of known language codes.
   */
  @JvmStatic
  public final fun getAllLanguages(): PackedStringArray =
      callPtrMethod0_ret_PACKED_STRING_ARRAY(MethodBindings.getAllLanguagesPtr)

  /**
   * Returns a readable language name for the [language] code.
   */
  @JvmStatic
  public final fun getLanguageName(language: String): String =
      callMethod_STRING_ret_STRING(MethodBindings.getLanguageNamePtr, language)

  /**
   * Returns an array of known script codes.
   */
  @JvmStatic
  public final fun getAllScripts(): PackedStringArray =
      callPtrMethod0_ret_PACKED_STRING_ARRAY(MethodBindings.getAllScriptsPtr)

  /**
   * Returns a readable script name for the [script] code.
   */
  @JvmStatic
  public final fun getScriptName(script: String): String =
      callMethod_STRING_ret_STRING(MethodBindings.getScriptNamePtr, script)

  /**
   * Returns an array of known country codes.
   */
  @JvmStatic
  public final fun getAllCountries(): PackedStringArray =
      callPtrMethod0_ret_PACKED_STRING_ARRAY(MethodBindings.getAllCountriesPtr)

  /**
   * Returns a readable country name for the [country] code.
   */
  @JvmStatic
  public final fun getCountryName(country: String): String =
      callMethod_STRING_ret_STRING(MethodBindings.getCountryNamePtr, country)

  /**
   * Returns a locale's language and its variant (e.g. `"en_US"` would return `"English (United
   * States)"`).
   */
  @JvmStatic
  public final fun getLocaleName(locale: String): String =
      callMethod_STRING_ret_STRING(MethodBindings.getLocaleNamePtr, locale)

  /**
   * Returns the default plural rules for the [locale].
   */
  @JvmStatic
  public final fun getPluralRules(locale: String): String =
      callMethod_STRING_ret_STRING(MethodBindings.getPluralRulesPtr, locale)

  /**
   * Returns the current locale's translation for the given message and context.
   *
   * **Note:** This method always uses the main translation domain.
   */
  @JvmStatic
  public final fun translate(message: StringName, context: StringName = StringName("")): StringName
      =
      callPtrMethod_STRING_NAME_STRING_NAME_ret_STRING_NAME(MethodBindings.translatePtr, message, context)

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
  ): StringName =
      callPtrMethod_STRING_NAME_STRING_NAME_LONG_STRING_NAME_ret_STRING_NAME(MethodBindings.translatePluralPtr, message, pluralMessage, n.toLong(), context)

  /**
   * Adds a translation to the main translation domain.
   */
  @JvmStatic
  public final fun addTranslation(translation: Translation?): Unit {
    callPtrMethod_OBJECT(MethodBindings.addTranslationPtr, translation)
  }

  /**
   * Removes the given translation from the main translation domain.
   */
  @JvmStatic
  public final fun removeTranslation(translation: Translation?): Unit {
    callPtrMethod_OBJECT(MethodBindings.removeTranslationPtr, translation)
  }

  /**
   * Returns the [Translation] instance that best matches [locale] in the main translation domain.
   * Returns `null` if there are no matches.
   */
  @JvmStatic
  public final fun getTranslationObject(locale: String): Translation? =
      (callMethod_STRING_ret_OBJECT_REF(MethodBindings.getTranslationObjectPtr, locale) as Translation?)

  /**
   * Returns all available [Translation] instances in the main translation domain as added by
   * [addTranslation].
   */
  @JvmStatic
  public final fun getTranslations(): VariantArray<Translation> =
      (callPtrMethod0_ret_ARRAY(MethodBindings.getTranslationsPtr) as VariantArray<Translation>)

  /**
   * Returns the [Translation] instances in the main translation domain that match [locale] (see
   * [compareLocales]). If [exact] is `true`, only instances whose locale exactly equals [locale] will
   * be returned.
   */
  @JvmStatic
  public final fun findTranslations(locale: String, exact: Boolean): VariantArray<Translation> =
      (callMethod_STRING_BOOL_ret_ARRAY(MethodBindings.findTranslationsPtr, locale, exact) as VariantArray<Translation>)

  /**
   * Returns `true` if there are any [Translation] instances in the main translation domain that
   * match [locale] (see [compareLocales]). If [exact] is `true`, only instances whose locale exactly
   * equals [locale] are considered.
   */
  @JvmStatic
  public final fun hasTranslationForLocale(locale: String, exact: Boolean): Boolean =
      callMethod_STRING_BOOL_ret_BOOL(MethodBindings.hasTranslationForLocalePtr, locale, exact)

  /**
   * Returns `true` if the main translation domain contains the given [translation].
   */
  @JvmStatic
  public final fun hasTranslation(translation: Translation?): Boolean =
      callPtrMethod_OBJECT_ret_BOOL(MethodBindings.hasTranslationPtr, translation)

  /**
   * Returns `true` if a translation domain with the specified name exists.
   */
  @JvmStatic
  public final fun hasDomain(domain: StringName): Boolean =
      callPtrMethod_STRING_NAME_ret_BOOL(MethodBindings.hasDomainPtr, domain)

  /**
   * Returns the translation domain with the specified name. An empty translation domain will be
   * created and added if it does not exist.
   */
  @JvmStatic
  public final fun getOrAddDomain(domain: StringName): TranslationDomain? =
      (callPtrMethod_STRING_NAME_ret_OBJECT_REF(MethodBindings.getOrAddDomainPtr, domain) as TranslationDomain?)

  /**
   * Removes the translation domain with the specified name.
   *
   * **Note:** Trying to remove the main translation domain is an error.
   */
  @JvmStatic
  public final fun removeDomain(domain: StringName): Unit {
    callPtrMethod_STRING_NAME(MethodBindings.removeDomainPtr, domain)
  }

  /**
   * Removes all translations from the main translation domain.
   */
  @JvmStatic
  public final fun clear(): Unit {
    callPtrMethod0(MethodBindings.clearPtr)
  }

  /**
   * Returns an array of all loaded locales of the project.
   */
  @JvmStatic
  public final fun getLoadedLocales(): PackedStringArray =
      callPtrMethod0_ret_PACKED_STRING_ARRAY(MethodBindings.getLoadedLocalesPtr)

  /**
   * Converts a number from Western Arabic (0..9) to the numeral system used in the given [locale].
   */
  @JvmStatic
  public final fun formatNumber(number: String, locale: String): String =
      callMethod_STRING_STRING_ret_STRING(MethodBindings.formatNumberPtr, number, locale)

  /**
   * Returns the percent sign used in the given [locale].
   */
  @JvmStatic
  public final fun getPercentSign(locale: String): String =
      callMethod_STRING_ret_STRING(MethodBindings.getPercentSignPtr, locale)

  /**
   * Converts [number] from the numeral system used in the given [locale] to Western Arabic (0..9).
   */
  @JvmStatic
  public final fun parseNumber(number: String, locale: String): String =
      callMethod_STRING_STRING_ret_STRING(MethodBindings.parseNumberPtr, number, locale)

  @JvmStatic
  public final fun isPseudolocalizationEnabled(): Boolean =
      callPtrMethod0_ret_BOOL(MethodBindings.isPseudolocalizationEnabledPtr)

  @JvmStatic
  public final fun setPseudolocalizationEnabled(enabled: Boolean): Unit {
    callPtrMethod_BOOL(MethodBindings.setPseudolocalizationEnabledPtr, enabled)
  }

  /**
   * Reparses the pseudolocalization options and reloads the translation for the main translation
   * domain.
   */
  @JvmStatic
  public final fun reloadPseudolocalization(): Unit {
    callPtrMethod0(MethodBindings.reloadPseudolocalizationPtr)
  }

  /**
   * Returns the pseudolocalized string based on the [message] passed in.
   *
   * **Note:** This method always uses the main translation domain.
   */
  @JvmStatic
  public final fun pseudolocalize(message: StringName): StringName =
      callPtrMethod_STRING_NAME_ret_STRING_NAME(MethodBindings.pseudolocalizePtr, message)

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
