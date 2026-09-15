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
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.PackedStringArray
import godot.core.StringName
import godot.core.VariantArray
import godot.core.asCachedStringName
import godot.readReturnValue_ANY
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DICTIONARY
import godot.readReturnValue_LONG
import godot.readReturnValue_PACKED_STRING_ARRAY
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_OBJECT_STRING_NAME
import godot.writeMethodArguments_OBJECT_STRING_NAME_ANY
import godot.writeMethodArguments_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_BOOL
import godot.writeMethodArguments_STRING_NAME_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_BOOL
import godot.writeMethodArguments_STRING_NAME_STRING_NAME_VARARG
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * Provides access to metadata stored for every available engine class.
 *
 * **Note:** Script-defined classes with `class_name` are not part of [ClassDB], so they will not
 * return reflection data such as a method or property list. However, [GDExtension]-defined classes
 * *are* part of [ClassDB], so they will return reflection data.
 */
@GodotBaseType
public object ClassDB : Object() {
  @JvmField
  public val getClassListName: MethodStringName0<ClassDB, PackedStringArray> =
      MethodStringName0<ClassDB, PackedStringArray>("get_class_list")

  @JvmField
  public val getInheritersFromClassName: MethodStringName1<ClassDB, PackedStringArray, StringName> =
      MethodStringName1<ClassDB, PackedStringArray, StringName>("get_inheriters_from_class")

  @JvmField
  public val getParentClassName: MethodStringName1<ClassDB, StringName, StringName> =
      MethodStringName1<ClassDB, StringName, StringName>("get_parent_class")

  @JvmField
  public val classExistsName: MethodStringName1<ClassDB, Boolean, StringName> =
      MethodStringName1<ClassDB, Boolean, StringName>("class_exists")

  @JvmField
  public val isParentClassName: MethodStringName2<ClassDB, Boolean, StringName, StringName> =
      MethodStringName2<ClassDB, Boolean, StringName, StringName>("is_parent_class")

  @JvmField
  public val canInstantiateName: MethodStringName1<ClassDB, Boolean, StringName> =
      MethodStringName1<ClassDB, Boolean, StringName>("can_instantiate")

  @JvmField
  public val instantiateName: MethodStringName1<ClassDB, Any?, StringName> =
      MethodStringName1<ClassDB, Any?, StringName>("instantiate")

  @JvmField
  public val classGetApiTypeName: MethodStringName1<ClassDB, APIType, StringName> =
      MethodStringName1<ClassDB, APIType, StringName>("class_get_api_type")

  @JvmField
  public val classHasSignalName: MethodStringName2<ClassDB, Boolean, StringName, StringName> =
      MethodStringName2<ClassDB, Boolean, StringName, StringName>("class_has_signal")

  @JvmField
  public val classGetSignalName:
      MethodStringName2<ClassDB, Dictionary<Any?, Any?>, StringName, StringName> =
      MethodStringName2<ClassDB, Dictionary<Any?, Any?>, StringName, StringName>("class_get_signal")

  @JvmField
  public val classGetSignalListName:
      MethodStringName2<ClassDB, VariantArray<Dictionary<Any?, Any?>>, StringName, Boolean> =
      MethodStringName2<ClassDB, VariantArray<Dictionary<Any?, Any?>>, StringName, Boolean>("class_get_signal_list")

  @JvmField
  public val classGetPropertyListName:
      MethodStringName2<ClassDB, VariantArray<Dictionary<Any?, Any?>>, StringName, Boolean> =
      MethodStringName2<ClassDB, VariantArray<Dictionary<Any?, Any?>>, StringName, Boolean>("class_get_property_list")

  @JvmField
  public val classGetPropertyGetterName:
      MethodStringName2<ClassDB, StringName, StringName, StringName> =
      MethodStringName2<ClassDB, StringName, StringName, StringName>("class_get_property_getter")

  @JvmField
  public val classGetPropertySetterName:
      MethodStringName2<ClassDB, StringName, StringName, StringName> =
      MethodStringName2<ClassDB, StringName, StringName, StringName>("class_get_property_setter")

  @JvmField
  public val classGetPropertyName: MethodStringName2<ClassDB, Any?, Object, StringName> =
      MethodStringName2<ClassDB, Any?, Object, StringName>("class_get_property")

  @JvmField
  public val classSetPropertyName: MethodStringName3<ClassDB, Error, Object, StringName, Any?> =
      MethodStringName3<ClassDB, Error, Object, StringName, Any?>("class_set_property")

  @JvmField
  public val classGetPropertyDefaultValueName:
      MethodStringName2<ClassDB, Any?, StringName, StringName> =
      MethodStringName2<ClassDB, Any?, StringName, StringName>("class_get_property_default_value")

  @JvmField
  public val classHasMethodName:
      MethodStringName3<ClassDB, Boolean, StringName, StringName, Boolean> =
      MethodStringName3<ClassDB, Boolean, StringName, StringName, Boolean>("class_has_method")

  @JvmField
  public val classGetMethodArgumentCountName:
      MethodStringName3<ClassDB, Int, StringName, StringName, Boolean> =
      MethodStringName3<ClassDB, Int, StringName, StringName, Boolean>("class_get_method_argument_count")

  @JvmField
  public val classGetMethodListName:
      MethodStringName2<ClassDB, VariantArray<Dictionary<Any?, Any?>>, StringName, Boolean> =
      MethodStringName2<ClassDB, VariantArray<Dictionary<Any?, Any?>>, StringName, Boolean>("class_get_method_list")

  @JvmField
  public val classGetIntegerConstantListName:
      MethodStringName2<ClassDB, PackedStringArray, StringName, Boolean> =
      MethodStringName2<ClassDB, PackedStringArray, StringName, Boolean>("class_get_integer_constant_list")

  @JvmField
  public val classHasIntegerConstantName:
      MethodStringName2<ClassDB, Boolean, StringName, StringName> =
      MethodStringName2<ClassDB, Boolean, StringName, StringName>("class_has_integer_constant")

  @JvmField
  public val classGetIntegerConstantName: MethodStringName2<ClassDB, Long, StringName, StringName> =
      MethodStringName2<ClassDB, Long, StringName, StringName>("class_get_integer_constant")

  @JvmField
  public val classHasEnumName: MethodStringName3<ClassDB, Boolean, StringName, StringName, Boolean>
      = MethodStringName3<ClassDB, Boolean, StringName, StringName, Boolean>("class_has_enum")

  @JvmField
  public val classGetEnumListName:
      MethodStringName2<ClassDB, PackedStringArray, StringName, Boolean> =
      MethodStringName2<ClassDB, PackedStringArray, StringName, Boolean>("class_get_enum_list")

  @JvmField
  public val classGetEnumConstantsName:
      MethodStringName3<ClassDB, PackedStringArray, StringName, StringName, Boolean> =
      MethodStringName3<ClassDB, PackedStringArray, StringName, StringName, Boolean>("class_get_enum_constants")

  @JvmField
  public val classGetIntegerConstantEnumName:
      MethodStringName3<ClassDB, StringName, StringName, StringName, Boolean> =
      MethodStringName3<ClassDB, StringName, StringName, StringName, Boolean>("class_get_integer_constant_enum")

  @JvmField
  public val isClassEnumBitfieldName:
      MethodStringName3<ClassDB, Boolean, StringName, StringName, Boolean> =
      MethodStringName3<ClassDB, Boolean, StringName, StringName, Boolean>("is_class_enum_bitfield")

  @JvmField
  public val isClassEnabledName: MethodStringName1<ClassDB, Boolean, StringName> =
      MethodStringName1<ClassDB, Boolean, StringName>("is_class_enabled")

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(3)
  }

  /**
   * Returns the names of all engine classes available.
   *
   * **Note:** Script-defined classes with `class_name` are not included in this list. Use
   * [ProjectSettings.getGlobalClassList] to get a list of script-defined classes instead.
   */
  @JvmStatic
  public final fun getClassList(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getClassListPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns the names of all engine classes that directly or indirectly inherit from [class].
   */
  @JvmStatic
  public final fun getInheritersFromClass(`class`: StringName): PackedStringArray {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, `class`)
    TransferContext.callMethod(MethodBindings.getInheritersFromClassPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns the parent class of [class].
   */
  @JvmStatic
  public final fun getParentClass(`class`: StringName): StringName {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, `class`)
    TransferContext.callMethod(MethodBindings.getParentClassPtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns whether the specified [class] is available or not.
   */
  @JvmStatic
  public final fun classExists(`class`: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, `class`)
    TransferContext.callMethod(MethodBindings.classExistsPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns whether [inherits] is an ancestor of [class] or not.
   */
  @JvmStatic
  public final fun isParentClass(`class`: StringName, inherits: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, `class`, inherits)
    TransferContext.callMethod(MethodBindings.isParentClassPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if objects can be instantiated from the specified [class], otherwise returns
   * `false`.
   */
  @JvmStatic
  public final fun canInstantiate(`class`: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, `class`)
    TransferContext.callMethod(MethodBindings.canInstantiatePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Creates an instance of [class].
   */
  @JvmStatic
  public final fun instantiate(`class`: StringName): Any? {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, `class`)
    TransferContext.callMethod(MethodBindings.instantiatePtr)
    return TransferContext.readReturnValue_ANY()
  }

  /**
   * Returns the API type of the specified [class].
   */
  @JvmStatic
  public final fun classGetApiType(`class`: StringName): APIType {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, `class`)
    TransferContext.callMethod(MethodBindings.classGetApiTypePtr)
    return APIType.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns whether [class] or its ancestry has a signal called [signal] or not.
   */
  @JvmStatic
  public final fun classHasSignal(`class`: StringName, signal: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, `class`, signal)
    TransferContext.callMethod(MethodBindings.classHasSignalPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the [signal] data of [class] or its ancestry. The returned value is a [Dictionary] with
   * the following keys: `args`, `default_args`, `flags`, `id`, `name`, `return: (class_name, hint,
   * hint_string, name, type, usage)`.
   */
  @JvmStatic
  public final fun classGetSignal(`class`: StringName, signal: StringName): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, `class`, signal)
    TransferContext.callMethod(MethodBindings.classGetSignalPtr)
    return (TransferContext.readReturnValue_DICTIONARY() as Dictionary<Any?, Any?>)
  }

  /**
   * Returns an array with all the signals of [class] or its ancestry if [noInheritance] is `false`.
   * Every element of the array is a [Dictionary] as described in [classGetSignal].
   */
  @JvmOverloads
  @JvmStatic
  public final fun classGetSignalList(`class`: StringName, noInheritance: Boolean = false):
      VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments_STRING_NAME_BOOL(ptr, objectID.id, `class`, noInheritance)
    TransferContext.callMethod(MethodBindings.classGetSignalListPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns an array with all the properties of [class] or its ancestry if [noInheritance] is
   * `false`.
   */
  @JvmOverloads
  @JvmStatic
  public final fun classGetPropertyList(`class`: StringName, noInheritance: Boolean = false):
      VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments_STRING_NAME_BOOL(ptr, objectID.id, `class`, noInheritance)
    TransferContext.callMethod(MethodBindings.classGetPropertyListPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns the getter method name of [property] of [class].
   */
  @JvmStatic
  public final fun classGetPropertyGetter(`class`: StringName, `property`: StringName): StringName {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, `class`, property)
    TransferContext.callMethod(MethodBindings.classGetPropertyGetterPtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns the setter method name of [property] of [class].
   */
  @JvmStatic
  public final fun classGetPropertySetter(`class`: StringName, `property`: StringName): StringName {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, `class`, property)
    TransferContext.callMethod(MethodBindings.classGetPropertySetterPtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns the value of [property] of [object] or its ancestry.
   */
  @JvmStatic
  public final fun classGetProperty(`object`: Object, `property`: StringName): Any? {
    TransferContext.writeMethodArguments_OBJECT_STRING_NAME(ptr, objectID.id, `object`, property)
    TransferContext.callMethod(MethodBindings.classGetPropertyPtr)
    return TransferContext.readReturnValue_ANY()
  }

  /**
   * Sets [property] value of [object] to [value].
   */
  @JvmStatic
  public final fun classSetProperty(
    `object`: Object,
    `property`: StringName,
    `value`: Any?,
  ): Error {
    TransferContext.writeMethodArguments_OBJECT_STRING_NAME_ANY(ptr, objectID.id, `object`, property, value)
    TransferContext.callMethod(MethodBindings.classSetPropertyPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the default value of [property] of [class] or its ancestor classes.
   */
  @JvmStatic
  public final fun classGetPropertyDefaultValue(`class`: StringName, `property`: StringName): Any? {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, `class`, property)
    TransferContext.callMethod(MethodBindings.classGetPropertyDefaultValuePtr)
    return TransferContext.readReturnValue_ANY()
  }

  /**
   * Returns whether [class] (or its ancestry if [noInheritance] is `false`) has a method called
   * [method] or not.
   */
  @JvmOverloads
  @JvmStatic
  public final fun classHasMethod(
    `class`: StringName,
    method: StringName,
    noInheritance: Boolean = false,
  ): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_BOOL(ptr, objectID.id, `class`, method, noInheritance)
    TransferContext.callMethod(MethodBindings.classHasMethodPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the number of arguments of the method [method] of [class] or its ancestry if
   * [noInheritance] is `false`.
   */
  @JvmOverloads
  @JvmStatic
  public final fun classGetMethodArgumentCount(
    `class`: StringName,
    method: StringName,
    noInheritance: Boolean = false,
  ): Int {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_BOOL(ptr, objectID.id, `class`, method, noInheritance)
    TransferContext.callMethod(MethodBindings.classGetMethodArgumentCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns an array with all the methods of [class] or its ancestry if [noInheritance] is `false`.
   * Every element of the array is a [Dictionary] with the following keys: `args`, `default_args`,
   * `flags`, `id`, `name`, `return: (class_name, hint, hint_string, name, type, usage)`.
   *
   * **Note:** In exported release builds the debug info is not available, so the returned
   * dictionaries will contain only method names.
   */
  @JvmOverloads
  @JvmStatic
  public final fun classGetMethodList(`class`: StringName, noInheritance: Boolean = false):
      VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments_STRING_NAME_BOOL(ptr, objectID.id, `class`, noInheritance)
    TransferContext.callMethod(MethodBindings.classGetMethodListPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Calls a static method on a class.
   */
  @JvmStatic
  public final fun classCallStatic(
    `class`: StringName,
    method: StringName,
    vararg args: Any?,
  ): Any? {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_VARARG(ptr, objectID.id, `class`, method, args)
    TransferContext.callMethod(MethodBindings.classCallStaticPtr)
    return TransferContext.readReturnValue_ANY()
  }

  /**
   * Returns an array with the names all the integer constants of [class] or its ancestry.
   */
  @JvmOverloads
  @JvmStatic
  public final fun classGetIntegerConstantList(`class`: StringName, noInheritance: Boolean = false):
      PackedStringArray {
    TransferContext.writeMethodArguments_STRING_NAME_BOOL(ptr, objectID.id, `class`, noInheritance)
    TransferContext.callMethod(MethodBindings.classGetIntegerConstantListPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns whether [class] or its ancestry has an integer constant called [name] or not.
   */
  @JvmStatic
  public final fun classHasIntegerConstant(`class`: StringName, name: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, `class`, name)
    TransferContext.callMethod(MethodBindings.classHasIntegerConstantPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the value of the integer constant [name] of [class] or its ancestry. Always returns 0
   * when the constant could not be found.
   */
  @JvmStatic
  public final fun classGetIntegerConstant(`class`: StringName, name: StringName): Long {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME(ptr, objectID.id, `class`, name)
    TransferContext.callMethod(MethodBindings.classGetIntegerConstantPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Returns whether [class] or its ancestry has an enum called [name] or not.
   */
  @JvmOverloads
  @JvmStatic
  public final fun classHasEnum(
    `class`: StringName,
    name: StringName,
    noInheritance: Boolean = false,
  ): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_BOOL(ptr, objectID.id, `class`, name, noInheritance)
    TransferContext.callMethod(MethodBindings.classHasEnumPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns an array with all the enums of [class] or its ancestry.
   */
  @JvmOverloads
  @JvmStatic
  public final fun classGetEnumList(`class`: StringName, noInheritance: Boolean = false):
      PackedStringArray {
    TransferContext.writeMethodArguments_STRING_NAME_BOOL(ptr, objectID.id, `class`, noInheritance)
    TransferContext.callMethod(MethodBindings.classGetEnumListPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns an array with all the keys in [enum] of [class] or its ancestry.
   */
  @JvmOverloads
  @JvmStatic
  public final fun classGetEnumConstants(
    `class`: StringName,
    `enum`: StringName,
    noInheritance: Boolean = false,
  ): PackedStringArray {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_BOOL(ptr, objectID.id, `class`, `enum`, noInheritance)
    TransferContext.callMethod(MethodBindings.classGetEnumConstantsPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns which enum the integer constant [name] of [class] or its ancestry belongs to.
   */
  @JvmOverloads
  @JvmStatic
  public final fun classGetIntegerConstantEnum(
    `class`: StringName,
    name: StringName,
    noInheritance: Boolean = false,
  ): StringName {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_BOOL(ptr, objectID.id, `class`, name, noInheritance)
    TransferContext.callMethod(MethodBindings.classGetIntegerConstantEnumPtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns whether [class] (or its ancestor classes if [noInheritance] is `false`) has an enum
   * called [enum] that is a bitfield.
   */
  @JvmOverloads
  @JvmStatic
  public final fun isClassEnumBitfield(
    `class`: StringName,
    `enum`: StringName,
    noInheritance: Boolean = false,
  ): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME_STRING_NAME_BOOL(ptr, objectID.id, `class`, `enum`, noInheritance)
    TransferContext.callMethod(MethodBindings.isClassEnumBitfieldPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns whether this [class] is enabled or not.
   */
  @JvmStatic
  public final fun isClassEnabled(`class`: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, `class`)
    TransferContext.callMethod(MethodBindings.isClassEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the names of all engine classes that directly or indirectly inherit from [class].
   */
  @JvmStatic
  public final fun getInheritersFromClass(`class`: String): PackedStringArray =
      getInheritersFromClass(`class`.asCachedStringName())

  /**
   * Returns the parent class of [class].
   */
  @JvmStatic
  public final fun getParentClass(`class`: String): StringName =
      getParentClass(`class`.asCachedStringName())

  /**
   * Returns whether the specified [class] is available or not.
   */
  @JvmStatic
  public final fun classExists(`class`: String): Boolean = classExists(`class`.asCachedStringName())

  /**
   * Returns whether [inherits] is an ancestor of [class] or not.
   */
  @JvmStatic
  public final fun isParentClass(`class`: String, inherits: String): Boolean =
      isParentClass(`class`.asCachedStringName(), inherits.asCachedStringName())

  /**
   * Returns `true` if objects can be instantiated from the specified [class], otherwise returns
   * `false`.
   */
  @JvmStatic
  public final fun canInstantiate(`class`: String): Boolean =
      canInstantiate(`class`.asCachedStringName())

  /**
   * Creates an instance of [class].
   */
  @JvmStatic
  public final fun instantiate(`class`: String): Any? = instantiate(`class`.asCachedStringName())

  /**
   * Returns the API type of the specified [class].
   */
  @JvmStatic
  public final fun classGetApiType(`class`: String): APIType =
      classGetApiType(`class`.asCachedStringName())

  /**
   * Returns whether [class] or its ancestry has a signal called [signal] or not.
   */
  @JvmStatic
  public final fun classHasSignal(`class`: String, signal: String): Boolean =
      classHasSignal(`class`.asCachedStringName(), signal.asCachedStringName())

  /**
   * Returns the [signal] data of [class] or its ancestry. The returned value is a [Dictionary] with
   * the following keys: `args`, `default_args`, `flags`, `id`, `name`, `return: (class_name, hint,
   * hint_string, name, type, usage)`.
   */
  @JvmStatic
  public final fun classGetSignal(`class`: String, signal: String): Dictionary<Any?, Any?> =
      classGetSignal(`class`.asCachedStringName(), signal.asCachedStringName())

  /**
   * Returns an array with all the signals of [class] or its ancestry if [noInheritance] is `false`.
   * Every element of the array is a [Dictionary] as described in [classGetSignal].
   */
  @JvmOverloads
  @JvmStatic
  public final fun classGetSignalList(`class`: String, noInheritance: Boolean = false):
      VariantArray<Dictionary<Any?, Any?>> =
      classGetSignalList(`class`.asCachedStringName(), noInheritance)

  /**
   * Returns an array with all the properties of [class] or its ancestry if [noInheritance] is
   * `false`.
   */
  @JvmOverloads
  @JvmStatic
  public final fun classGetPropertyList(`class`: String, noInheritance: Boolean = false):
      VariantArray<Dictionary<Any?, Any?>> =
      classGetPropertyList(`class`.asCachedStringName(), noInheritance)

  /**
   * Returns the getter method name of [property] of [class].
   */
  @JvmStatic
  public final fun classGetPropertyGetter(`class`: String, `property`: String): StringName =
      classGetPropertyGetter(`class`.asCachedStringName(), property.asCachedStringName())

  /**
   * Returns the setter method name of [property] of [class].
   */
  @JvmStatic
  public final fun classGetPropertySetter(`class`: String, `property`: String): StringName =
      classGetPropertySetter(`class`.asCachedStringName(), property.asCachedStringName())

  /**
   * Returns the value of [property] of [object] or its ancestry.
   */
  @JvmStatic
  public final fun classGetProperty(`object`: Object, `property`: String): Any? =
      classGetProperty(`object`, property.asCachedStringName())

  /**
   * Sets [property] value of [object] to [value].
   */
  @JvmStatic
  public final fun classSetProperty(
    `object`: Object,
    `property`: String,
    `value`: Any?,
  ): Error = classSetProperty(`object`, property.asCachedStringName(), value)

  /**
   * Returns the default value of [property] of [class] or its ancestor classes.
   */
  @JvmStatic
  public final fun classGetPropertyDefaultValue(`class`: String, `property`: String): Any? =
      classGetPropertyDefaultValue(`class`.asCachedStringName(), property.asCachedStringName())

  /**
   * Returns whether [class] (or its ancestry if [noInheritance] is `false`) has a method called
   * [method] or not.
   */
  @JvmOverloads
  @JvmStatic
  public final fun classHasMethod(
    `class`: String,
    method: String,
    noInheritance: Boolean = false,
  ): Boolean =
      classHasMethod(`class`.asCachedStringName(), method.asCachedStringName(), noInheritance)

  /**
   * Returns the number of arguments of the method [method] of [class] or its ancestry if
   * [noInheritance] is `false`.
   */
  @JvmOverloads
  @JvmStatic
  public final fun classGetMethodArgumentCount(
    `class`: String,
    method: String,
    noInheritance: Boolean = false,
  ): Int =
      classGetMethodArgumentCount(`class`.asCachedStringName(), method.asCachedStringName(), noInheritance)

  /**
   * Returns an array with all the methods of [class] or its ancestry if [noInheritance] is `false`.
   * Every element of the array is a [Dictionary] with the following keys: `args`, `default_args`,
   * `flags`, `id`, `name`, `return: (class_name, hint, hint_string, name, type, usage)`.
   *
   * **Note:** In exported release builds the debug info is not available, so the returned
   * dictionaries will contain only method names.
   */
  @JvmOverloads
  @JvmStatic
  public final fun classGetMethodList(`class`: String, noInheritance: Boolean = false):
      VariantArray<Dictionary<Any?, Any?>> =
      classGetMethodList(`class`.asCachedStringName(), noInheritance)

  /**
   * Calls a static method on a class.
   */
  @JvmStatic
  public final fun classCallStatic(
    `class`: String,
    method: String,
    vararg args: Any?,
  ): Any? = classCallStatic(`class`.asCachedStringName(), method.asCachedStringName(), *args)

  /**
   * Returns an array with the names all the integer constants of [class] or its ancestry.
   */
  @JvmOverloads
  @JvmStatic
  public final fun classGetIntegerConstantList(`class`: String, noInheritance: Boolean = false):
      PackedStringArray = classGetIntegerConstantList(`class`.asCachedStringName(), noInheritance)

  /**
   * Returns whether [class] or its ancestry has an integer constant called [name] or not.
   */
  @JvmStatic
  public final fun classHasIntegerConstant(`class`: String, name: String): Boolean =
      classHasIntegerConstant(`class`.asCachedStringName(), name.asCachedStringName())

  /**
   * Returns the value of the integer constant [name] of [class] or its ancestry. Always returns 0
   * when the constant could not be found.
   */
  @JvmStatic
  public final fun classGetIntegerConstant(`class`: String, name: String): Long =
      classGetIntegerConstant(`class`.asCachedStringName(), name.asCachedStringName())

  /**
   * Returns whether [class] or its ancestry has an enum called [name] or not.
   */
  @JvmOverloads
  @JvmStatic
  public final fun classHasEnum(
    `class`: String,
    name: String,
    noInheritance: Boolean = false,
  ): Boolean = classHasEnum(`class`.asCachedStringName(), name.asCachedStringName(), noInheritance)

  /**
   * Returns an array with all the enums of [class] or its ancestry.
   */
  @JvmOverloads
  @JvmStatic
  public final fun classGetEnumList(`class`: String, noInheritance: Boolean = false):
      PackedStringArray = classGetEnumList(`class`.asCachedStringName(), noInheritance)

  /**
   * Returns an array with all the keys in [enum] of [class] or its ancestry.
   */
  @JvmOverloads
  @JvmStatic
  public final fun classGetEnumConstants(
    `class`: String,
    `enum`: String,
    noInheritance: Boolean = false,
  ): PackedStringArray =
      classGetEnumConstants(`class`.asCachedStringName(), `enum`.asCachedStringName(), noInheritance)

  /**
   * Returns which enum the integer constant [name] of [class] or its ancestry belongs to.
   */
  @JvmOverloads
  @JvmStatic
  public final fun classGetIntegerConstantEnum(
    `class`: String,
    name: String,
    noInheritance: Boolean = false,
  ): StringName =
      classGetIntegerConstantEnum(`class`.asCachedStringName(), name.asCachedStringName(), noInheritance)

  /**
   * Returns whether [class] (or its ancestor classes if [noInheritance] is `false`) has an enum
   * called [enum] that is a bitfield.
   */
  @JvmOverloads
  @JvmStatic
  public final fun isClassEnumBitfield(
    `class`: String,
    `enum`: String,
    noInheritance: Boolean = false,
  ): Boolean =
      isClassEnumBitfield(`class`.asCachedStringName(), `enum`.asCachedStringName(), noInheritance)

  /**
   * Returns whether this [class] is enabled or not.
   */
  @JvmStatic
  public final fun isClassEnabled(`class`: String): Boolean =
      isClassEnabled(`class`.asCachedStringName())

  public enum class APIType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Native Core class type.
     */
    CORE(0),
    /**
     * Native Editor class type.
     */
    EDITOR(1),
    /**
     * GDExtension class type.
     */
    EXTENSION(2),
    /**
     * GDExtension Editor class type.
     */
    EDITOR_EXTENSION(3),
    /**
     * Unknown class type.
     */
    NONE(4),
    ;

    public companion object {
      public fun from(`value`: Long): APIType = entries.single { it.`value` == `value` }
    }
  }

  public object MethodBindings {
    internal val getClassListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "get_class_list", 1139954409)

    internal val getInheritersFromClassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "get_inheriters_from_class", 1761182771)

    internal val getParentClassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "get_parent_class", 1965194235)

    internal val classExistsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_exists", 2619796661)

    internal val isParentClassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "is_parent_class", 471820014)

    internal val canInstantiatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "can_instantiate", 2619796661)

    internal val instantiatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "instantiate", 2760726917)

    internal val classGetApiTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_get_api_type", 2475317043)

    internal val classHasSignalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_has_signal", 471820014)

    internal val classGetSignalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_get_signal", 3061114238)

    internal val classGetSignalListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_get_signal_list", 3504980660)

    internal val classGetPropertyListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_get_property_list", 3504980660)

    internal val classGetPropertyGetterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_get_property_getter", 3770832642)

    internal val classGetPropertySetterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_get_property_setter", 3770832642)

    internal val classGetPropertyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_get_property", 2498641674)

    internal val classSetPropertyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_set_property", 1690314931)

    internal val classGetPropertyDefaultValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_get_property_default_value", 2718203076)

    internal val classHasMethodPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_has_method", 3860701026)

    internal val classGetMethodArgumentCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_get_method_argument_count", 3885694822)

    internal val classGetMethodListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_get_method_list", 3504980660)

    internal val classCallStaticPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_call_static", 3344196419)

    internal val classGetIntegerConstantListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_get_integer_constant_list", 3031669221)

    internal val classHasIntegerConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_has_integer_constant", 471820014)

    internal val classGetIntegerConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_get_integer_constant", 2419549490)

    internal val classHasEnumPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_has_enum", 3860701026)

    internal val classGetEnumListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_get_enum_list", 3031669221)

    internal val classGetEnumConstantsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_get_enum_constants", 661528303)

    internal val classGetIntegerConstantEnumPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "class_get_integer_constant_enum", 2457504236)

    internal val isClassEnumBitfieldPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "is_class_enum_bitfield", 3860701026)

    internal val isClassEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ClassDB", "is_class_enabled", 2619796661)
  }
}
