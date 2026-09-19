// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_ANY_BOOL_ret_STRING
import godot.callMethod_PACKED_BYTE_ARRAY_ret_STRING
import godot.callMethod_STRING_BOOL_ret_ANY
import godot.callMethod_STRING_ret_PACKED_BYTE_ARRAY
import godot.callMethod_STRING_ret_STRING
import godot.common.interop.VoidPtr
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedByteArray
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * Provides data transformation and encoding utility functions.
 */
@GodotBaseType
public object Marshalls : Object() {
  @JvmField
  public val variantToBase64Name: MethodStringName2<Marshalls, String, Any?, Boolean> =
      MethodStringName2<Marshalls, String, Any?, Boolean>("variant_to_base64")

  @JvmField
  public val base64ToVariantName: MethodStringName2<Marshalls, Any?, String, Boolean> =
      MethodStringName2<Marshalls, Any?, String, Boolean>("base64_to_variant")

  @JvmField
  public val rawToBase64Name: MethodStringName1<Marshalls, String, PackedByteArray> =
      MethodStringName1<Marshalls, String, PackedByteArray>("raw_to_base64")

  @JvmField
  public val base64ToRawName: MethodStringName1<Marshalls, PackedByteArray, String> =
      MethodStringName1<Marshalls, PackedByteArray, String>("base64_to_raw")

  @JvmField
  public val utf8ToBase64Name: MethodStringName1<Marshalls, String, String> =
      MethodStringName1<Marshalls, String, String>("utf8_to_base64")

  @JvmField
  public val base64ToUtf8Name: MethodStringName1<Marshalls, String, String> =
      MethodStringName1<Marshalls, String, String>("base64_to_utf8")

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(15)
  }

  /**
   * Returns a Base64-encoded string of the [Any] [variant]. If [fullObjects] is `true`, encoding
   * objects is allowed (and can potentially include code).
   *
   * Internally, this uses the same encoding mechanism as the [@GlobalScope.varToBytes] method.
   */
  @JvmOverloads
  @JvmStatic
  public final fun variantToBase64(variant: Any?, fullObjects: Boolean = false): String =
      TransferContext.callMethod_ANY_BOOL_ret_STRING(ptr, objectID.id, MethodBindings.variantToBase64Ptr, variant, fullObjects)

  /**
   * Returns a decoded [Any] corresponding to the Base64-encoded string [base64Str]. If
   * [allowObjects] is `true`, decoding objects is allowed.
   *
   * Internally, this uses the same decoding mechanism as the [@GlobalScope.bytesToVar] method.
   *
   * **Warning:** Deserialized objects can contain code which gets executed. Do not use this option
   * if the serialized object comes from untrusted sources to avoid potential security threats such as
   * remote code execution.
   */
  @JvmOverloads
  @JvmStatic
  public final fun base64ToVariant(base64Str: String, allowObjects: Boolean = false): Any? =
      TransferContext.callMethod_STRING_BOOL_ret_ANY(ptr, objectID.id, MethodBindings.base64ToVariantPtr, base64Str, allowObjects)

  /**
   * Returns a Base64-encoded string of a given [PackedByteArray].
   */
  @JvmStatic
  public final fun rawToBase64(array: PackedByteArray): String =
      TransferContext.callMethod_PACKED_BYTE_ARRAY_ret_STRING(ptr, objectID.id, MethodBindings.rawToBase64Ptr, array)

  /**
   * Returns a decoded [PackedByteArray] corresponding to the Base64-encoded string [base64Str].
   */
  @JvmStatic
  public final fun base64ToRaw(base64Str: String): PackedByteArray =
      TransferContext.callMethod_STRING_ret_PACKED_BYTE_ARRAY(ptr, objectID.id, MethodBindings.base64ToRawPtr, base64Str)

  /**
   * Returns a Base64-encoded string of the UTF-8 string [utf8Str].
   */
  @JvmStatic
  public final fun utf8ToBase64(utf8Str: String): String =
      TransferContext.callMethod_STRING_ret_STRING(ptr, objectID.id, MethodBindings.utf8ToBase64Ptr, utf8Str)

  /**
   * Returns a decoded string corresponding to the Base64-encoded string [base64Str].
   */
  @JvmStatic
  public final fun base64ToUtf8(base64Str: String): String =
      TransferContext.callMethod_STRING_ret_STRING(ptr, objectID.id, MethodBindings.base64ToUtf8Ptr, base64Str)

  public object MethodBindings {
    internal val variantToBase64Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("Marshalls", "variant_to_base64", 3876248563)

    internal val base64ToVariantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Marshalls", "base64_to_variant", 218087648)

    internal val rawToBase64Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("Marshalls", "raw_to_base64", 3999417757)

    internal val base64ToRawPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Marshalls", "base64_to_raw", 659035735)

    internal val utf8ToBase64Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("Marshalls", "utf8_to_base64", 1703090593)

    internal val base64ToUtf8Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("Marshalls", "base64_to_utf8", 1703090593)
  }
}
