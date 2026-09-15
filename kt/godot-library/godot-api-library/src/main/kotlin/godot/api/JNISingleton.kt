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
import godot.core.StringName
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.STRING_NAME
import godot.core.asCachedStringName
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * The JNISingleton is implemented only in the Android export. It's used to call methods and connect
 * signals from an Android plugin written in Java or Kotlin. Methods and signals can be called and
 * connected to the JNISingleton as if it is a Node. See
 * [url=https://en.wikipedia.org/wiki/Java_Native_Interface]Java Native Interface - Wikipedia[/url] for
 * more information.
 */
@GodotBaseType
public open class JNISingleton : Object() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(330, scriptPtr)
  }

  /**
   * Returns `true` if the given [method] name exists in the JNISingleton's Java methods.
   */
  public final fun hasJavaMethod(method: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to method)
    TransferContext.callMethod(MethodBindings.hasJavaMethodPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the given [method] name exists in the JNISingleton's Java methods.
   */
  public final fun hasJavaMethod(method: String): Boolean =
      hasJavaMethod(method.asCachedStringName())

  public companion object {
    @JvmField
    public val hasJavaMethodName: MethodStringName1<JNISingleton, Boolean, StringName> =
        MethodStringName1<JNISingleton, Boolean, StringName>("has_java_method")
  }

  public object MethodBindings {
    internal val hasJavaMethodPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JNISingleton", "has_java_method", 2619796661)
  }
}
