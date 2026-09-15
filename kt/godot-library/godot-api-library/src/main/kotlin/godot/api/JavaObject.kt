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
import godot.core.StringName
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING_NAME
import godot.core.asCachedStringName
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Represents an object from the Java Native Interface. It can be returned from Java methods called
 * on [JavaClass] or other [JavaObject]s. See [JavaClassWrapper] for an example.
 *
 * **Note:** This class only works on Android. On any other platform, this class does nothing.
 *
 * **Note:** This class is not to be confused with [JavaScriptObject].
 */
@GodotBaseType
public open class JavaObject : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(336, scriptPtr)
  }

  /**
   * Returns the [JavaClass] that this object is an instance of.
   */
  public final fun getJavaClass(): JavaClass? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getJavaClassPtr)
    return (TransferContext.readReturnValue(OBJECT) as JavaClass?)
  }

  /**
   * Returns `true` if the given [method] name exists in the object's Java methods.
   */
  public final fun hasJavaMethod(method: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to method)
    TransferContext.callMethod(MethodBindings.hasJavaMethodPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the given [method] name exists in the object's Java methods.
   */
  public final fun hasJavaMethod(method: String): Boolean =
      hasJavaMethod(method.asCachedStringName())

  public companion object {
    @JvmField
    public val getJavaClassName: MethodStringName0<JavaObject, JavaClass?> =
        MethodStringName0<JavaObject, JavaClass?>("get_java_class")

    @JvmField
    public val hasJavaMethodName: MethodStringName1<JavaObject, Boolean, StringName> =
        MethodStringName1<JavaObject, Boolean, StringName>("has_java_method")
  }

  public object MethodBindings {
    internal val getJavaClassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaObject", "get_java_class", 541536347)

    internal val hasJavaMethodPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaObject", "has_java_method", 2619796661)
  }
}
