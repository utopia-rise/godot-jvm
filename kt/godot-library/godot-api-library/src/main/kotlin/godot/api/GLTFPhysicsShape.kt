// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.Dictionary
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * Represents a physics shape as defined by the `OMI_physics_shape` or `OMI_collider` glTF
 * extensions. This class is an intermediary between the glTF data and Godot's nodes, and it's
 * abstracted in a way that allows adding support for different glTF physics extensions in the future.
 */
@GodotBaseType
public open class GLTFPhysicsShape : Resource() {
  /**
   * The type of shape this shape represents. Valid values are `"box"`, `"capsule"`, `"cylinder"`,
   * `"sphere"`, `"hull"`, and `"trimesh"`.
   */
  public final inline var shapeType: String
    @JvmName("shapeTypeProperty")
    get() = getShapeType()
    @JvmName("shapeTypeProperty")
    set(`value`) {
      setShapeType(value)
    }

  /**
   * The size of the shape, in meters. This is only used when the shape type is `"box"`, and it
   * represents the `"diameter"` of the box. This value should not be negative.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var size: Vector3
    @JvmName("sizeProperty")
    get() = getSize()
    @JvmName("sizeProperty")
    set(`value`) {
      setSize(value)
    }

  /**
   * The radius of the shape, in meters. This is only used when the shape type is `"capsule"`,
   * `"cylinder"`, or `"sphere"`. This value should not be negative.
   */
  public final inline var radius: Float
    @JvmName("radiusProperty")
    get() = getRadius()
    @JvmName("radiusProperty")
    set(`value`) {
      setRadius(value)
    }

  /**
   * The height of the shape, in meters. This is only used when the shape type is `"capsule"` or
   * `"cylinder"`. This value should not be negative, and for `"capsule"` it should be at least twice
   * the radius.
   */
  public final inline var height: Float
    @JvmName("heightProperty")
    get() = getHeight()
    @JvmName("heightProperty")
    set(`value`) {
      setHeight(value)
    }

  /**
   * If `true`, indicates that this shape is a trigger. For Godot, this means that the shape should
   * be a child of an [Area3D] node.
   *
   * This is the only variable not used in the [toNode] method, it's intended to be used alongside
   * when deciding where to add the generated node as a child.
   */
  public final inline var isTrigger: Boolean
    @JvmName("isTriggerProperty")
    get() = getIsTrigger()
    @JvmName("isTriggerProperty")
    set(`value`) {
      setIsTrigger(value)
    }

  /**
   * The index of the shape's mesh in the glTF file. This is only used when the shape type is
   * `"hull"` (convex hull) or `"trimesh"` (concave trimesh).
   */
  public final inline var meshIndex: Int
    @JvmName("meshIndexProperty")
    get() = getMeshIndex()
    @JvmName("meshIndexProperty")
    set(`value`) {
      setMeshIndex(value)
    }

  /**
   * The [ImporterMesh] resource of the shape. This is only used when the shape type is `"hull"`
   * (convex hull) or `"trimesh"` (concave trimesh).
   */
  public final inline var importerMesh: ImporterMesh?
    @JvmName("importerMeshProperty")
    get() = getImporterMesh()
    @JvmName("importerMeshProperty")
    set(`value`) {
      setImporterMesh(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(252, scriptPtr)
  }

  /**
   * This is a helper function for [size] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfphysicsshape.size
   * //Your changes
   * gltfphysicsshape.size = myCoreType
   * ``````
   *
   * The size of the shape, in meters. This is only used when the shape type is `"box"`, and it
   * represents the `"diameter"` of the box. This value should not be negative.
   */
  @CoreTypeHelper
  public final fun sizeMutate(block: Vector3.() -> Unit): Vector3 = size.apply {
     block(this)
     size = this
  }

  /**
   * Converts this GLTFPhysicsShape instance into a Godot [CollisionShape3D] node.
   */
  @JvmOverloads
  public final fun toNode(cacheShapes: Boolean = false): CollisionShape3D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to cacheShapes)
    TransferContext.callMethod(MethodBindings.toNodePtr)
    return (TransferContext.readReturnValue(OBJECT) as CollisionShape3D?)
  }

  /**
   * Converts this GLTFPhysicsShape instance into a Godot [Shape3D] resource.
   */
  @JvmOverloads
  public final fun toResource(cacheShapes: Boolean = false): Shape3D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to cacheShapes)
    TransferContext.callMethod(MethodBindings.toResourcePtr)
    return (TransferContext.readReturnValue(OBJECT) as Shape3D?)
  }

  /**
   * Serializes this GLTFPhysicsShape instance into a [Dictionary] in the format defined by
   * `OMI_physics_shape`.
   */
  public final fun toDictionary(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.toDictionaryPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  public final fun getShapeType(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShapeTypePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setShapeType(shapeType: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to shapeType)
    TransferContext.callMethod(MethodBindings.setShapeTypePtr)
  }

  public final fun getSize(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSizePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setSize(size: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to size)
    TransferContext.callMethod(MethodBindings.setSizePtr)
  }

  public final fun getRadius(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRadiusPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setRadius(radius: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to radius.toDouble())
    TransferContext.callMethod(MethodBindings.setRadiusPtr)
  }

  public final fun getHeight(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHeightPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setHeight(height: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to height.toDouble())
    TransferContext.callMethod(MethodBindings.setHeightPtr)
  }

  public final fun getIsTrigger(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIsTriggerPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setIsTrigger(isTrigger: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to isTrigger)
    TransferContext.callMethod(MethodBindings.setIsTriggerPtr)
  }

  public final fun getMeshIndex(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMeshIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setMeshIndex(meshIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to meshIndex.toLong())
    TransferContext.callMethod(MethodBindings.setMeshIndexPtr)
  }

  public final fun getImporterMesh(): ImporterMesh? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getImporterMeshPtr)
    return (TransferContext.readReturnValue(OBJECT) as ImporterMesh?)
  }

  public final fun setImporterMesh(importerMesh: ImporterMesh?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to importerMesh)
    TransferContext.callMethod(MethodBindings.setImporterMeshPtr)
  }

  public companion object {
    @JvmField
    public val fromNodeName:
        MethodStringName1<GLTFPhysicsShape, GLTFPhysicsShape?, CollisionShape3D?> =
        MethodStringName1<GLTFPhysicsShape, GLTFPhysicsShape?, CollisionShape3D?>("from_node")

    @JvmField
    public val toNodeName: MethodStringName1<GLTFPhysicsShape, CollisionShape3D?, Boolean> =
        MethodStringName1<GLTFPhysicsShape, CollisionShape3D?, Boolean>("to_node")

    @JvmField
    public val fromResourceName: MethodStringName1<GLTFPhysicsShape, GLTFPhysicsShape?, Shape3D?> =
        MethodStringName1<GLTFPhysicsShape, GLTFPhysicsShape?, Shape3D?>("from_resource")

    @JvmField
    public val toResourceName: MethodStringName1<GLTFPhysicsShape, Shape3D?, Boolean> =
        MethodStringName1<GLTFPhysicsShape, Shape3D?, Boolean>("to_resource")

    @JvmField
    public val fromDictionaryName:
        MethodStringName1<GLTFPhysicsShape, GLTFPhysicsShape?, Dictionary<Any?, Any?>> =
        MethodStringName1<GLTFPhysicsShape, GLTFPhysicsShape?, Dictionary<Any?, Any?>>("from_dictionary")

    @JvmField
    public val toDictionaryName: MethodStringName0<GLTFPhysicsShape, Dictionary<Any?, Any?>> =
        MethodStringName0<GLTFPhysicsShape, Dictionary<Any?, Any?>>("to_dictionary")

    @JvmField
    public val getShapeTypeName: MethodStringName0<GLTFPhysicsShape, String> =
        MethodStringName0<GLTFPhysicsShape, String>("get_shape_type")

    @JvmField
    public val setShapeTypeName: MethodStringName1<GLTFPhysicsShape, Unit, String> =
        MethodStringName1<GLTFPhysicsShape, Unit, String>("set_shape_type")

    @JvmField
    public val getSizeName: MethodStringName0<GLTFPhysicsShape, Vector3> =
        MethodStringName0<GLTFPhysicsShape, Vector3>("get_size")

    @JvmField
    public val setSizeName: MethodStringName1<GLTFPhysicsShape, Unit, Vector3> =
        MethodStringName1<GLTFPhysicsShape, Unit, Vector3>("set_size")

    @JvmField
    public val getRadiusName: MethodStringName0<GLTFPhysicsShape, Float> =
        MethodStringName0<GLTFPhysicsShape, Float>("get_radius")

    @JvmField
    public val setRadiusName: MethodStringName1<GLTFPhysicsShape, Unit, Float> =
        MethodStringName1<GLTFPhysicsShape, Unit, Float>("set_radius")

    @JvmField
    public val getHeightName: MethodStringName0<GLTFPhysicsShape, Float> =
        MethodStringName0<GLTFPhysicsShape, Float>("get_height")

    @JvmField
    public val setHeightName: MethodStringName1<GLTFPhysicsShape, Unit, Float> =
        MethodStringName1<GLTFPhysicsShape, Unit, Float>("set_height")

    @JvmField
    public val getIsTriggerName: MethodStringName0<GLTFPhysicsShape, Boolean> =
        MethodStringName0<GLTFPhysicsShape, Boolean>("get_is_trigger")

    @JvmField
    public val setIsTriggerName: MethodStringName1<GLTFPhysicsShape, Unit, Boolean> =
        MethodStringName1<GLTFPhysicsShape, Unit, Boolean>("set_is_trigger")

    @JvmField
    public val getMeshIndexName: MethodStringName0<GLTFPhysicsShape, Int> =
        MethodStringName0<GLTFPhysicsShape, Int>("get_mesh_index")

    @JvmField
    public val setMeshIndexName: MethodStringName1<GLTFPhysicsShape, Unit, Int> =
        MethodStringName1<GLTFPhysicsShape, Unit, Int>("set_mesh_index")

    @JvmField
    public val getImporterMeshName: MethodStringName0<GLTFPhysicsShape, ImporterMesh?> =
        MethodStringName0<GLTFPhysicsShape, ImporterMesh?>("get_importer_mesh")

    @JvmField
    public val setImporterMeshName: MethodStringName1<GLTFPhysicsShape, Unit, ImporterMesh?> =
        MethodStringName1<GLTFPhysicsShape, Unit, ImporterMesh?>("set_importer_mesh")

    /**
     * Creates a new GLTFPhysicsShape instance from the given Godot [CollisionShape3D] node.
     */
    @JvmStatic
    public final fun fromNode(shapeNode: CollisionShape3D?): GLTFPhysicsShape? {
      TransferContext.writeMethodArguments(0L, 0L, OBJECT to shapeNode)
      TransferContext.callMethod(MethodBindings.fromNodePtr)
      return (TransferContext.readReturnValue(OBJECT) as GLTFPhysicsShape?)
    }

    /**
     * Creates a new GLTFPhysicsShape instance from the given Godot [Shape3D] resource.
     */
    @JvmStatic
    public final fun fromResource(shapeResource: Shape3D?): GLTFPhysicsShape? {
      TransferContext.writeMethodArguments(0L, 0L, OBJECT to shapeResource)
      TransferContext.callMethod(MethodBindings.fromResourcePtr)
      return (TransferContext.readReturnValue(OBJECT) as GLTFPhysicsShape?)
    }

    /**
     * Creates a new GLTFPhysicsShape instance by parsing the given [Dictionary].
     */
    @JvmStatic
    public final fun fromDictionary(dictionary: Dictionary<Any?, Any?>): GLTFPhysicsShape? {
      TransferContext.writeMethodArguments(0L, 0L, DICTIONARY to dictionary)
      TransferContext.callMethod(MethodBindings.fromDictionaryPtr)
      return (TransferContext.readReturnValue(OBJECT) as GLTFPhysicsShape?)
    }
  }

  public object MethodBindings {
    internal val fromNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "from_node", 3613751275)

    internal val toNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "to_node", 563689933)

    internal val fromResourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "from_resource", 3845569786)

    internal val toResourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "to_resource", 1913542110)

    internal val fromDictionaryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "from_dictionary", 2390691823)

    internal val toDictionaryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "to_dictionary", 3102165223)

    internal val getShapeTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "get_shape_type", 201670096)

    internal val setShapeTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "set_shape_type", 83702148)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "get_size", 3360562783)

    internal val setSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "set_size", 3460891852)

    internal val getRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "get_radius", 1740695150)

    internal val setRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "set_radius", 373806689)

    internal val getHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "get_height", 1740695150)

    internal val setHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "set_height", 373806689)

    internal val getIsTriggerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "get_is_trigger", 36873697)

    internal val setIsTriggerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "set_is_trigger", 2586408642)

    internal val getMeshIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "get_mesh_index", 3905245786)

    internal val setMeshIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "set_mesh_index", 1286410249)

    internal val getImporterMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "get_importer_mesh", 3161779525)

    internal val setImporterMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsShape", "set_importer_mesh", 2255166972)
  }
}
