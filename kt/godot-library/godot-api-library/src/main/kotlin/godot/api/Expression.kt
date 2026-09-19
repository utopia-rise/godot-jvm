// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_STRING
import godot.callMethod_ARRAY_OBJECT_BOOL_BOOL_ret_ANY
import godot.callMethod_STRING_PACKED_STRING_ARRAY_ret_LONG
import godot.callPtrMethod0_ret_BOOL
import godot.common.interop.VoidPtr
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName2
import godot.core.MethodStringName4
import godot.core.PackedStringArray
import godot.core.VariantArray
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * An expression can be made of any arithmetic operation, built-in math function call, method call
 * of a passed instance, or built-in type construction call.
 *
 * An example expression text using the built-in math functions could be `sqrt(pow(3, 2) + pow(4,
 * 2))`.
 *
 * In the following example we use a [LineEdit] node to write our expression and show the result.
 *
 * ```gdscript
 * //gdscript
 * var expression = Expression.new()
 *
 * func _ready():
 * 	$LineEdit.text_submitted.connect(self._on_text_submitted)
 *
 * func _on_text_submitted(command):
 * 	var error = expression.parse(command)
 * 	if error != OK:
 * 		print(expression.get_error_text())
 * 		return
 * 	var result = expression.execute()
 * 	if not expression.has_execute_failed():
 * 		$LineEdit.text = str(result)
 * ```
 *
 * ```csharp
 * //csharp
 * private Expression _expression = new Expression();
 *
 * public override void _Ready()
 * {
 * 	GetNode<LineEdit>("LineEdit").TextSubmitted += OnTextEntered;
 * }
 *
 * private void OnTextEntered(string command)
 * {
 * 	Error error = _expression.Parse(command);
 * 	if (error != Error.Ok)
 * 	{
 * 		GD.Print(_expression.GetErrorText());
 * 		return;
 * 	}
 * 	Variant result = _expression.Execute();
 * 	if (!_expression.HasExecuteFailed())
 * 	{
 * 		GetNode<LineEdit>("LineEdit").Text = result.ToString();
 * 	}
 * }
 * ```
 */
@GodotBaseType
public open class Expression : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(218, scriptPtr)
  }

  /**
   * Parses the expression and returns an [Error] code.
   *
   * You can optionally specify names of variables that may appear in the expression with
   * [inputNames], so that you can bind them when it gets executed.
   */
  @JvmOverloads
  public final fun parse(expression: String, inputNames: PackedStringArray = PackedStringArray()):
      Error =
      Error.from(TransferContext.callMethod_STRING_PACKED_STRING_ARRAY_ret_LONG(ptr, objectID.id, MethodBindings.parsePtr, expression, inputNames))

  /**
   * Executes the expression that was previously parsed by [parse] and returns the result. Before
   * you use the returned object, you should check if the method failed by calling [hasExecuteFailed].
   *
   * If you defined input variables in [parse], you can specify their values in the inputs array, in
   * the same order.
   */
  @JvmOverloads
  public final fun execute(
    inputs: VariantArray<Any?> = godot.core.variantArrayOf(),
    baseInstance: Object? = null,
    showError: Boolean = true,
    constCallsOnly: Boolean = false,
  ): Any? =
      TransferContext.callMethod_ARRAY_OBJECT_BOOL_BOOL_ret_ANY(ptr, objectID.id, MethodBindings.executePtr, inputs, baseInstance, showError, constCallsOnly)

  /**
   * Returns `true` if [execute] has failed.
   */
  public final fun hasExecuteFailed(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.hasExecuteFailedPtr)

  /**
   * Returns the error text if [parse] or [execute] has failed.
   */
  public final fun getErrorText(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getErrorTextPtr)

  public companion object {
    @JvmField
    public val parseName: MethodStringName2<Expression, Error, String, PackedStringArray> =
        MethodStringName2<Expression, Error, String, PackedStringArray>("parse")

    @JvmField
    public val executeName:
        MethodStringName4<Expression, Any?, VariantArray<Any?>, Object?, Boolean, Boolean> =
        MethodStringName4<Expression, Any?, VariantArray<Any?>, Object?, Boolean, Boolean>("execute")

    @JvmField
    public val hasExecuteFailedName: MethodStringName0<Expression, Boolean> =
        MethodStringName0<Expression, Boolean>("has_execute_failed")

    @JvmField
    public val getErrorTextName: MethodStringName0<Expression, String> =
        MethodStringName0<Expression, String>("get_error_text")
  }

  public object MethodBindings {
    internal val parsePtr: VoidPtr = TypeManager.getMethodBindPtr("Expression", "parse", 3069722906)

    internal val executePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Expression", "execute", 3712471238)

    internal val hasExecuteFailedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Expression", "has_execute_failed", 36873697)

    internal val getErrorTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Expression", "get_error_text", 201670096)
  }
}
