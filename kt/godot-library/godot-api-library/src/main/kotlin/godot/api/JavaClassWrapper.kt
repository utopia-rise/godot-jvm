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
import godot.core.Callable
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedStringArray
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_OBJECT_PACKED_STRING_ARRAY
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_STRING_CALLABLE
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic

/**
 * The JavaClassWrapper singleton provides a way for the Godot application to send and receive data
 * through the [url=https://developer.android.com/training/articles/perf-jni]Java Native
 * Interface[/url] (JNI).
 *
 * **Note:** This singleton is only available in Android builds.
 *
 * ```
 * var LocalDateTime = JavaClassWrapper.wrap("java.time.LocalDateTime")
 * var DateTimeFormatter = JavaClassWrapper.wrap("java.time.format.DateTimeFormatter")
 *
 * var datetime = LocalDateTime.now()
 * var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
 *
 * print(datetime.format(formatter))
 * ```
 *
 * **Warning:** When calling Java methods, be sure to check [JavaClassWrapper.getException] to check
 * if the method threw an exception.
 */
@GodotBaseType
public object JavaClassWrapper : Object() {
  @JvmField
  public val wrapName: MethodStringName1<JavaClassWrapper, JavaClass?, String> =
      MethodStringName1<JavaClassWrapper, JavaClass?, String>("wrap")

  @JvmField
  public val getExceptionName: MethodStringName0<JavaClassWrapper, JavaObject?> =
      MethodStringName0<JavaClassWrapper, JavaObject?>("get_exception")

  @JvmField
  public val createSamCallbackName:
      MethodStringName2<JavaClassWrapper, JavaObject?, String, Callable> =
      MethodStringName2<JavaClassWrapper, JavaObject?, String, Callable>("create_sam_callback")

  @JvmField
  public val createProxyName:
      MethodStringName2<JavaClassWrapper, JavaObject?, Object?, PackedStringArray> =
      MethodStringName2<JavaClassWrapper, JavaObject?, Object?, PackedStringArray>("create_proxy")

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(13)
  }

  /**
   * Wraps a class defined in Java, and returns it as a [JavaClass] [Object] type that Godot can
   * interact with.
   *
   * When wrapping inner (nested) classes, use `$` instead of `.` to separate them. For example,
   * `JavaClassWrapper.wrap("android.view.WindowManager$LayoutParams")` wraps the
   * **WindowManager.LayoutParams** class.
   *
   * **Note:** To invoke a constructor, call a method with the same name as the class. For example:
   *
   * ```
   * var Intent = JavaClassWrapper.wrap("android.content.Intent")
   * var intent = Intent.Intent()
   * ```
   *
   * **Note:** This method only works on Android. On every other platform, this method does nothing
   * and returns an empty [JavaClass].
   */
  @JvmStatic
  public final fun wrap(name: String): JavaClass? {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.wrapPtr)
    return (TransferContext.readReturnValue_OBJECT() as JavaClass?)
  }

  /**
   * Returns the Java exception from the last call into a Java class. If there was no exception, it
   * will return `null`.
   *
   * **Note:** This method only works on Android. On every other platform, this method will always
   * return `null`.
   */
  @JvmStatic
  public final fun getException(): JavaObject? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getExceptionPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as JavaObject?)
  }

  /**
   * Creates a [JavaObject] implementing the Java Single Abstract Method (SAM) interface using the
   * Godot [Callable] as the implementation.
   *
   * The [samInterface] **must be** a Java SAM interface, meaning it must only have a single
   * abstract method to implement.
   *
   * The [callable] must be able to handle the same parameter types as the SAM interface method, and
   * must provide the same return type. The [callable] will be invoked as a callback, passing the
   * arguments from the Java SAM interface method.
   *
   * ```
   * var cb = func (content: String) -> void:
   * 	print(content)
   * var callback = JavaClassWrapper.create_sam_callback("android.util.Printer", cb)
   * callback.println("Hello Godot World!")
   * ```
   *
   * **Note:** This method only works on Android. On every other platform, this method will always
   * return `null`.
   */
  @JvmStatic
  public final fun createSamCallback(samInterface: String, callable: Callable): JavaObject? {
    TransferContext.writeMethodArguments_STRING_CALLABLE(ptr, objectID.id, samInterface, callable)
    TransferContext.callMethod(MethodBindings.createSamCallbackPtr)
    return (TransferContext.readReturnValue_OBJECT() as JavaObject?)
  }

  /**
   * Creates a [JavaObject] implementing the given Java interfaces using the given [Object] as the
   * implementation.
   *
   * The [object] must contain methods signatures matching the methods signatures from the passed
   * Java [interfaces]. Invoking methods from the Java [interfaces] will route to the matching [object]
   * method.
   *
   * ```
   * class PrintProxy:
   * 	func println(content: String) -> void:
   * 		print(content)
   *
   * var print_proxy = PrintProxy.new()
   * var printer_object = JavaClassWrapper.create_proxy(print_proxy, ["android.util.Printer"])
   * printer_object.println("Hello Godot World!")
   * ```
   *
   * **Note:** This method only works on Android. On every other platform, this method will always
   * return `null`.
   */
  @JvmStatic
  public final fun createProxy(`object`: Object?, interfaces: PackedStringArray): JavaObject? {
    TransferContext.writeMethodArguments_OBJECT_PACKED_STRING_ARRAY(ptr, objectID.id, `object`, interfaces)
    TransferContext.callPtrMethod(MethodBindings.createProxyPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as JavaObject?)
  }

  public object MethodBindings {
    internal val wrapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaClassWrapper", "wrap", 1124367868)

    internal val getExceptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaClassWrapper", "get_exception", 3277089691)

    internal val createSamCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaClassWrapper", "create_sam_callback", 2479014754)

    internal val createProxyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaClassWrapper", "create_proxy", 2694931752)
  }
}
