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
import godot.core.StringName
import godot.core.VariantArray
import godot.core.asCachedStringName
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_STRING_NAME
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Represents a class from the Java Native Interface. It is returned from [JavaClassWrapper.wrap].
 *
 * **Note:** This class only works on Android. On any other platform, this class does nothing.
 *
 * **Note:** This class is not to be confused with [JavaScriptObject].
 */
@GodotBaseType
public open class JavaClass : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(334, scriptPtr)
  }

  /**
   * Returns the Java class name.
   */
  public final fun getJavaClassName(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getJavaClassNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the object's Java methods and their signatures as an [VariantArray] of dictionaries, in
   * the same format as [Object.getMethodList].
   */
  public final fun getJavaMethodList(): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getJavaMethodListPtr, 28)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns a [JavaClass] representing the Java parent class of this class.
   */
  public final fun getJavaParentClass(): JavaClass? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getJavaParentClassPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as JavaClass?)
  }

  /**
   * Returns `true` if the given [method] name exists in the object's Java methods.
   */
  public final fun hasJavaMethod(method: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, method)
    TransferContext.callPtrMethod(MethodBindings.hasJavaMethodPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the given [method] name exists in the object's Java methods.
   */
  public final fun hasJavaMethod(method: String): Boolean =
      hasJavaMethod(method.asCachedStringName())

  public companion object {
    @JvmField
    public val getJavaClassNameName: MethodStringName0<JavaClass, String> =
        MethodStringName0<JavaClass, String>("get_java_class_name")

    @JvmField
    public val getJavaMethodListName:
        MethodStringName0<JavaClass, VariantArray<Dictionary<Any?, Any?>>> =
        MethodStringName0<JavaClass, VariantArray<Dictionary<Any?, Any?>>>("get_java_method_list")

    @JvmField
    public val getJavaParentClassName: MethodStringName0<JavaClass, JavaClass?> =
        MethodStringName0<JavaClass, JavaClass?>("get_java_parent_class")

    @JvmField
    public val hasJavaMethodName: MethodStringName1<JavaClass, Boolean, StringName> =
        MethodStringName1<JavaClass, Boolean, StringName>("has_java_method")
  }

  public object MethodBindings {
    internal val getJavaClassNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaClass", "get_java_class_name", 201670096)

    internal val getJavaMethodListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaClass", "get_java_method_list", 3995934104)

    internal val getJavaParentClassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaClass", "get_java_parent_class", 541536347)

    internal val hasJavaMethodPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaClass", "has_java_method", 2619796661)
  }
}
