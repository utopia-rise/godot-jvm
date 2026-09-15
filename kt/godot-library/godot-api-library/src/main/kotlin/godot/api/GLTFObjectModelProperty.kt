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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.NodePath
import godot.core.PackedStringArray
import godot.core.StringName
import godot.core.VariantArray
import godot.core.VariantType
import godot.core.asCachedNodePath
import godot.core.asCachedStringName
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_ARRAY
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_NODE_PATH
import godot.writeMethodArguments_NODE_PATH_STRING_NAME
import godot.writeMethodArguments_OBJECT
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * GLTFObjectModelProperty defines a mapping between a property in the glTF object model and a
 * NodePath in the Godot scene tree. This can be used to animate properties in a glTF file using the
 * `KHR_animation_pointer` extension, or to access them through an engine-agnostic script such as a
 * behavior graph as defined by the `KHR_interactivity` extension.
 *
 * The glTF property is identified by JSON pointer(s) stored in [jsonPointers], while the Godot
 * property it maps to is defined by [nodePaths]. In most cases [jsonPointers] and [nodePaths] will
 * each only have one item, but in some cases a single glTF JSON pointer will map to multiple Godot
 * properties, or a single Godot property will be mapped to multiple glTF JSON pointers, or it might be
 * a many-to-many relationship.
 *
 * [Expression] objects can be used to define conversions between the data, such as when glTF
 * defines an angle in radians and Godot uses degrees. The [objectModelType] property defines the type
 * of data stored in the glTF file as defined by the object model, see [GLTFObjectModelType] for
 * possible values.
 */
@GodotBaseType
public open class GLTFObjectModelProperty : RefCounted() {
  /**
   * If set, this [Expression] will be used to convert the property value from the glTF object model
   * to the value expected by the Godot property. This is useful when the glTF object model uses a
   * different unit system, or when the data needs to be transformed in some way. If `null`, the value
   * will be copied as-is.
   */
  public final inline var gltfToGodotExpression: Expression?
    @JvmName("gltfToGodotExpressionProperty")
    get() = getGltfToGodotExpression()
    @JvmName("gltfToGodotExpressionProperty")
    set(`value`) {
      setGltfToGodotExpression(value)
    }

  /**
   * If set, this [Expression] will be used to convert the property value from the Godot property to
   * the value expected by the glTF object model. This is useful when the glTF object model uses a
   * different unit system, or when the data needs to be transformed in some way. If `null`, the value
   * will be copied as-is.
   */
  public final inline var godotToGltfExpression: Expression?
    @JvmName("godotToGltfExpressionProperty")
    get() = getGodotToGltfExpression()
    @JvmName("godotToGltfExpressionProperty")
    set(`value`) {
      setGodotToGltfExpression(value)
    }

  /**
   * An array of [NodePath]s that point to a property, or multiple properties, in the Godot scene
   * tree. On import, this will either be set by [GLTFDocument], or by a [GLTFDocumentExtension] class.
   * For simple cases, use [appendPathToProperty] to add properties to this array.
   *
   * In most cases [nodePaths] will only have one item, but in some cases a single glTF JSON pointer
   * will map to multiple Godot properties. For example, a [GLTFCamera] or [GLTFLight] used on multiple
   * glTF nodes will be represented by multiple Godot nodes.
   */
  public final inline var nodePaths: VariantArray<NodePath>
    @JvmName("nodePathsProperty")
    get() = getNodePaths()
    @JvmName("nodePathsProperty")
    set(`value`) {
      setNodePaths(value)
    }

  /**
   * The type of data stored in the glTF file as defined by the object model. This is a superset of
   * the available accessor types, and determines the accessor type.
   */
  public final inline var objectModelType: GLTFObjectModelType
    @JvmName("objectModelTypeProperty")
    get() = getObjectModelType()
    @JvmName("objectModelTypeProperty")
    set(`value`) {
      setObjectModelType(value)
    }

  /**
   * The glTF object model JSON pointers used to identify the property in the glTF object model. In
   * most cases, there will be only one item in this array, but specific cases may require multiple
   * pointers. The items are themselves arrays which represent the JSON pointer split into its
   * components.
   */
  public final inline var jsonPointers: VariantArray<PackedStringArray>
    @JvmName("jsonPointersProperty")
    get() = getJsonPointers()
    @JvmName("jsonPointersProperty")
    set(`value`) {
      setJsonPointers(value)
    }

  /**
   * The type of data stored in the Godot property. This is the type of the property that the
   * [nodePaths] point to.
   */
  public final inline var variantType: VariantType
    @JvmName("variantTypeProperty")
    get() = getVariantType()
    @JvmName("variantTypeProperty")
    set(`value`) {
      setVariantType(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(248, scriptPtr)
  }

  /**
   * Appends a [NodePath] to [nodePaths]. This can be used by [GLTFDocumentExtension] classes to
   * define how a glTF object model property maps to a Godot property, or multiple Godot properties.
   * Prefer using [appendPathToProperty] for simple cases. Be sure to also call [setTypes] once (the
   * order does not matter).
   */
  public final fun appendNodePath(nodePath: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, nodePath)
    TransferContext.callPtrMethod(MethodBindings.appendNodePathPtr, 0)
  }

  /**
   * High-level wrapper over [appendNodePath] that handles the most common cases. It constructs a
   * new [NodePath] using [nodePath] as a base and appends [propName] to the subpath. Be sure to also
   * call [setTypes] once (the order does not matter).
   */
  public final fun appendPathToProperty(nodePath: NodePath, propName: StringName): Unit {
    TransferContext.writeMethodArguments_NODE_PATH_STRING_NAME(ptr, objectID.id, nodePath, propName)
    TransferContext.callPtrMethod(MethodBindings.appendPathToPropertyPtr, 0)
  }

  /**
   * The GLTF accessor type associated with this property's [objectModelType]. See
   * [GLTFAccessor.accessorType] for possible values, and see [GLTFObjectModelType] for how the object
   * model type maps to accessor types.
   */
  public final fun getAccessorType(): GLTFAccessor.GLTFAccessorType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAccessorTypePtr, 2)
    return GLTFAccessor.GLTFAccessorType.from(TransferContext.readReturnValue_LONG())
  }

  public final fun getGltfToGodotExpression(): Expression? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getGltfToGodotExpressionPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Expression?)
  }

  public final fun setGltfToGodotExpression(gltfToGodotExpr: Expression?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, gltfToGodotExpr)
    TransferContext.callPtrMethod(MethodBindings.setGltfToGodotExpressionPtr, 0)
  }

  public final fun getGodotToGltfExpression(): Expression? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getGodotToGltfExpressionPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Expression?)
  }

  public final fun setGodotToGltfExpression(godotToGltfExpr: Expression?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, godotToGltfExpr)
    TransferContext.callPtrMethod(MethodBindings.setGodotToGltfExpressionPtr, 0)
  }

  public final fun getNodePaths(): VariantArray<NodePath> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNodePathsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<NodePath>)
  }

  /**
   * Returns `true` if [nodePaths] is not empty. This is used during import to determine if a
   * [GLTFObjectModelProperty] can handle converting a glTF object model property to a Godot property.
   */
  public final fun hasNodePaths(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.hasNodePathsPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setNodePaths(nodePaths: VariantArray<NodePath>): Unit {
    TransferContext.writeMethodArguments_ARRAY(ptr, objectID.id, nodePaths)
    TransferContext.callPtrMethod(MethodBindings.setNodePathsPtr, 0)
  }

  public final fun getObjectModelType(): GLTFObjectModelType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getObjectModelTypePtr, 2)
    return GLTFObjectModelType.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setObjectModelType(type: GLTFObjectModelType): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, type.value)
    TransferContext.callPtrMethod(MethodBindings.setObjectModelTypePtr, 0)
  }

  public final fun getJsonPointers(): VariantArray<PackedStringArray> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getJsonPointersPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<PackedStringArray>)
  }

  /**
   * Returns `true` if [jsonPointers] is not empty. This is used during export to determine if a
   * [GLTFObjectModelProperty] can handle converting a Godot property to a glTF object model property.
   */
  public final fun hasJsonPointers(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.hasJsonPointersPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setJsonPointers(jsonPointers: VariantArray<PackedStringArray>): Unit {
    TransferContext.writeMethodArguments_ARRAY(ptr, objectID.id, jsonPointers)
    TransferContext.callPtrMethod(MethodBindings.setJsonPointersPtr, 0)
  }

  public final fun getVariantType(): VariantType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getVariantTypePtr, 2)
    return VariantType.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setVariantType(variantType: VariantType): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, variantType.value)
    TransferContext.callPtrMethod(MethodBindings.setVariantTypePtr, 0)
  }

  /**
   * Sets the [variantType] and [objectModelType] properties. This is a convenience method to set
   * both properties at once, since they are almost always known at the same time. This method should
   * be called once. Calling it again with the same values will have no effect.
   */
  public final fun setTypes(variantType: VariantType, objModelType: GLTFObjectModelType): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, variantType.value, objModelType.value)
    TransferContext.callPtrMethod(MethodBindings.setTypesPtr, 0)
  }

  /**
   * Appends a [NodePath] to [nodePaths]. This can be used by [GLTFDocumentExtension] classes to
   * define how a glTF object model property maps to a Godot property, or multiple Godot properties.
   * Prefer using [appendPathToProperty] for simple cases. Be sure to also call [setTypes] once (the
   * order does not matter).
   */
  public final fun appendNodePath(nodePath: String) = appendNodePath(nodePath.asCachedNodePath())

  /**
   * High-level wrapper over [appendNodePath] that handles the most common cases. It constructs a
   * new [NodePath] using [nodePath] as a base and appends [propName] to the subpath. Be sure to also
   * call [setTypes] once (the order does not matter).
   */
  public final fun appendPathToProperty(nodePath: String, propName: String) =
      appendPathToProperty(nodePath.asCachedNodePath(), propName.asCachedStringName())

  public enum class GLTFObjectModelType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Unknown or not set object model type. If the object model type is set to this value, the real
     * type still needs to be determined.
     */
    UNKNOWN(0),
    /**
     * Object model type "bool". Represented in the glTF JSON as a boolean, and encoded in a
     * [GLTFAccessor] as "SCALAR". When encoded in an accessor, a value of `0` is `false`, and any
     * other value is `true`.
     */
    BOOL(1),
    /**
     * Object model type "float". Represented in the glTF JSON as a number, and encoded in a
     * [GLTFAccessor] as "SCALAR".
     */
    FLOAT(2),
    /**
     * Object model type "float[lb][rb]". Represented in the glTF JSON as an array of numbers, and
     * encoded in a [GLTFAccessor] as "SCALAR".
     */
    FLOAT_ARRAY(3),
    /**
     * Object model type "float2". Represented in the glTF JSON as an array of two numbers, and
     * encoded in a [GLTFAccessor] as "VEC2".
     */
    FLOAT2(4),
    /**
     * Object model type "float3". Represented in the glTF JSON as an array of three numbers, and
     * encoded in a [GLTFAccessor] as "VEC3".
     */
    FLOAT3(5),
    /**
     * Object model type "float4". Represented in the glTF JSON as an array of four numbers, and
     * encoded in a [GLTFAccessor] as "VEC4".
     */
    FLOAT4(6),
    /**
     * Object model type "float2x2". Represented in the glTF JSON as an array of four numbers, and
     * encoded in a [GLTFAccessor] as "MAT2".
     */
    FLOAT2X2(7),
    /**
     * Object model type "float3x3". Represented in the glTF JSON as an array of nine numbers, and
     * encoded in a [GLTFAccessor] as "MAT3".
     */
    FLOAT3X3(8),
    /**
     * Object model type "float4x4". Represented in the glTF JSON as an array of sixteen numbers,
     * and encoded in a [GLTFAccessor] as "MAT4".
     */
    FLOAT4X4(9),
    /**
     * Object model type "int". Represented in the glTF JSON as a number, and encoded in a
     * [GLTFAccessor] as "SCALAR". The range of values is limited to signed integers. For
     * `KHR_interactivity`, only 32-bit integers are supported.
     */
    INT(10),
    ;

    public companion object {
      public fun from(`value`: Long): GLTFObjectModelType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val appendNodePathName: MethodStringName1<GLTFObjectModelProperty, Unit, NodePath> =
        MethodStringName1<GLTFObjectModelProperty, Unit, NodePath>("append_node_path")

    @JvmField
    public val appendPathToPropertyName:
        MethodStringName2<GLTFObjectModelProperty, Unit, NodePath, StringName> =
        MethodStringName2<GLTFObjectModelProperty, Unit, NodePath, StringName>("append_path_to_property")

    @JvmField
    public val getAccessorTypeName:
        MethodStringName0<GLTFObjectModelProperty, GLTFAccessor.GLTFAccessorType> =
        MethodStringName0<GLTFObjectModelProperty, GLTFAccessor.GLTFAccessorType>("get_accessor_type")

    @JvmField
    public val getGltfToGodotExpressionName: MethodStringName0<GLTFObjectModelProperty, Expression?>
        = MethodStringName0<GLTFObjectModelProperty, Expression?>("get_gltf_to_godot_expression")

    @JvmField
    public val setGltfToGodotExpressionName:
        MethodStringName1<GLTFObjectModelProperty, Unit, Expression?> =
        MethodStringName1<GLTFObjectModelProperty, Unit, Expression?>("set_gltf_to_godot_expression")

    @JvmField
    public val getGodotToGltfExpressionName: MethodStringName0<GLTFObjectModelProperty, Expression?>
        = MethodStringName0<GLTFObjectModelProperty, Expression?>("get_godot_to_gltf_expression")

    @JvmField
    public val setGodotToGltfExpressionName:
        MethodStringName1<GLTFObjectModelProperty, Unit, Expression?> =
        MethodStringName1<GLTFObjectModelProperty, Unit, Expression?>("set_godot_to_gltf_expression")

    @JvmField
    public val getNodePathsName: MethodStringName0<GLTFObjectModelProperty, VariantArray<NodePath>>
        = MethodStringName0<GLTFObjectModelProperty, VariantArray<NodePath>>("get_node_paths")

    @JvmField
    public val hasNodePathsName: MethodStringName0<GLTFObjectModelProperty, Boolean> =
        MethodStringName0<GLTFObjectModelProperty, Boolean>("has_node_paths")

    @JvmField
    public val setNodePathsName:
        MethodStringName1<GLTFObjectModelProperty, Unit, VariantArray<NodePath>> =
        MethodStringName1<GLTFObjectModelProperty, Unit, VariantArray<NodePath>>("set_node_paths")

    @JvmField
    public val getObjectModelTypeName:
        MethodStringName0<GLTFObjectModelProperty, GLTFObjectModelType> =
        MethodStringName0<GLTFObjectModelProperty, GLTFObjectModelType>("get_object_model_type")

    @JvmField
    public val setObjectModelTypeName:
        MethodStringName1<GLTFObjectModelProperty, Unit, GLTFObjectModelType> =
        MethodStringName1<GLTFObjectModelProperty, Unit, GLTFObjectModelType>("set_object_model_type")

    @JvmField
    public val getJsonPointersName:
        MethodStringName0<GLTFObjectModelProperty, VariantArray<PackedStringArray>> =
        MethodStringName0<GLTFObjectModelProperty, VariantArray<PackedStringArray>>("get_json_pointers")

    @JvmField
    public val hasJsonPointersName: MethodStringName0<GLTFObjectModelProperty, Boolean> =
        MethodStringName0<GLTFObjectModelProperty, Boolean>("has_json_pointers")

    @JvmField
    public val setJsonPointersName:
        MethodStringName1<GLTFObjectModelProperty, Unit, VariantArray<PackedStringArray>> =
        MethodStringName1<GLTFObjectModelProperty, Unit, VariantArray<PackedStringArray>>("set_json_pointers")

    @JvmField
    public val getVariantTypeName: MethodStringName0<GLTFObjectModelProperty, VariantType> =
        MethodStringName0<GLTFObjectModelProperty, VariantType>("get_variant_type")

    @JvmField
    public val setVariantTypeName: MethodStringName1<GLTFObjectModelProperty, Unit, VariantType> =
        MethodStringName1<GLTFObjectModelProperty, Unit, VariantType>("set_variant_type")

    @JvmField
    public val setTypesName:
        MethodStringName2<GLTFObjectModelProperty, Unit, VariantType, GLTFObjectModelType> =
        MethodStringName2<GLTFObjectModelProperty, Unit, VariantType, GLTFObjectModelType>("set_types")
  }

  public object MethodBindings {
    internal val appendNodePathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFObjectModelProperty", "append_node_path", 1348162250)

    internal val appendPathToPropertyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFObjectModelProperty", "append_path_to_property", 1331931644)

    internal val getAccessorTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFObjectModelProperty", "get_accessor_type", 1998183368)

    internal val getGltfToGodotExpressionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFObjectModelProperty", "get_gltf_to_godot_expression", 2240072449)

    internal val setGltfToGodotExpressionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFObjectModelProperty", "set_gltf_to_godot_expression", 1815845073)

    internal val getGodotToGltfExpressionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFObjectModelProperty", "get_godot_to_gltf_expression", 2240072449)

    internal val setGodotToGltfExpressionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFObjectModelProperty", "set_godot_to_gltf_expression", 1815845073)

    internal val getNodePathsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFObjectModelProperty", "get_node_paths", 3995934104)

    internal val hasNodePathsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFObjectModelProperty", "has_node_paths", 36873697)

    internal val setNodePathsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFObjectModelProperty", "set_node_paths", 381264803)

    internal val getObjectModelTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFObjectModelProperty", "get_object_model_type", 1094778507)

    internal val setObjectModelTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFObjectModelProperty", "set_object_model_type", 4108684086)

    internal val getJsonPointersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFObjectModelProperty", "get_json_pointers", 3995934104)

    internal val hasJsonPointersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFObjectModelProperty", "has_json_pointers", 36873697)

    internal val setJsonPointersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFObjectModelProperty", "set_json_pointers", 381264803)

    internal val getVariantTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFObjectModelProperty", "get_variant_type", 3416842102)

    internal val setVariantTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFObjectModelProperty", "set_variant_type", 2887708385)

    internal val setTypesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFObjectModelProperty", "set_types", 4150728237)
  }
}
