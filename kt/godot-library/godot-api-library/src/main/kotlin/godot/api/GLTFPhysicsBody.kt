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
import godot.core.Basis
import godot.core.Dictionary
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.Quaternion
import godot.core.VariantParser.BASIS
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.QUATERNION
import godot.core.VariantParser.STRING
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import kotlin.Any
import kotlin.Double
import kotlin.Float
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmStatic

/**
 * Represents a physics body as an intermediary between the `OMI_physics_body` glTF data and Godot's
 * nodes, and it's abstracted in a way that allows adding support for different glTF physics extensions
 * in the future.
 */
@GodotBaseType
public open class GLTFPhysicsBody : Resource() {
  /**
   * The type of the body.
   *
   * When importing, this controls what type of [CollisionObject3D] node Godot should generate.
   * Valid values are `"static"`, `"animatable"`, `"character"`, `"rigid"`, `"vehicle"`, and
   * `"trigger"`.
   *
   * When exporting, this will be squashed down to one of `"static"`, `"kinematic"`, or `"dynamic"`
   * motion types, or the `"trigger"` property.
   */
  public final inline var bodyType: String
    @JvmName("bodyTypeProperty")
    get() = getBodyType()
    @JvmName("bodyTypeProperty")
    set(`value`) {
      setBodyType(value)
    }

  /**
   * The mass of the physics body, in kilograms. This is only used when the body type is "rigid" or
   * "vehicle".
   */
  public final inline var mass: Float
    @JvmName("massProperty")
    get() = getMass()
    @JvmName("massProperty")
    set(`value`) {
      setMass(value)
    }

  /**
   * The linear velocity of the physics body, in meters per second. This is only used when the body
   * type is "rigid" or "vehicle".
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var linearVelocity: Vector3
    @JvmName("linearVelocityProperty")
    get() = getLinearVelocity()
    @JvmName("linearVelocityProperty")
    set(`value`) {
      setLinearVelocity(value)
    }

  /**
   * The angular velocity of the physics body, in radians per second. This is only used when the
   * body type is "rigid" or "vehicle".
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var angularVelocity: Vector3
    @JvmName("angularVelocityProperty")
    get() = getAngularVelocity()
    @JvmName("angularVelocityProperty")
    set(`value`) {
      setAngularVelocity(value)
    }

  /**
   * The center of mass of the body, in meters. This is in local space relative to the body. By
   * default, the center of the mass is the body's origin.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var centerOfMass: Vector3
    @JvmName("centerOfMassProperty")
    get() = getCenterOfMass()
    @JvmName("centerOfMassProperty")
    set(`value`) {
      setCenterOfMass(value)
    }

  /**
   * The inertia strength of the physics body, in kilogram meter squared (kg⋅m²). This represents
   * the inertia around the principle axes, the diagonal of the inertia tensor matrix. This is only
   * used when the body type is "rigid" or "vehicle".
   *
   * When converted to a Godot [RigidBody3D] node, if this value is zero, then the inertia will be
   * calculated automatically.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var inertiaDiagonal: Vector3
    @JvmName("inertiaDiagonalProperty")
    get() = getInertiaDiagonal()
    @JvmName("inertiaDiagonalProperty")
    set(`value`) {
      setInertiaDiagonal(value)
    }

  /**
   * The inertia orientation of the physics body. This defines the rotation of the inertia's
   * principle axes relative to the object's local axes. This is only used when the body type is
   * "rigid" or "vehicle" and [inertiaDiagonal] is set to a non-zero value.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var inertiaOrientation: Quaternion
    @JvmName("inertiaOrientationProperty")
    get() = getInertiaOrientation()
    @JvmName("inertiaOrientationProperty")
    set(`value`) {
      setInertiaOrientation(value)
    }

  /**
   * The inertia tensor of the physics body, in kilogram meter squared (kg⋅m²). This is only used
   * when the body type is "rigid" or "vehicle".
   *
   * When converted to a Godot [RigidBody3D] node, if this value is zero, then the inertia will be
   * calculated automatically.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var inertiaTensor: Basis
    @JvmName("inertiaTensorProperty")
    get() = getInertiaTensor()
    @JvmName("inertiaTensorProperty")
    set(`value`) {
      setInertiaTensor(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(251, scriptPtr)
  }

  /**
   * This is a helper function for [linearVelocity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfphysicsbody.linearVelocity
   * //Your changes
   * gltfphysicsbody.linearVelocity = myCoreType
   * ``````
   *
   * The linear velocity of the physics body, in meters per second. This is only used when the body
   * type is "rigid" or "vehicle".
   */
  @CoreTypeHelper
  public final fun linearVelocityMutate(block: Vector3.() -> Unit): Vector3 = linearVelocity.apply {
     block(this)
     linearVelocity = this
  }

  /**
   * This is a helper function for [angularVelocity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfphysicsbody.angularVelocity
   * //Your changes
   * gltfphysicsbody.angularVelocity = myCoreType
   * ``````
   *
   * The angular velocity of the physics body, in radians per second. This is only used when the
   * body type is "rigid" or "vehicle".
   */
  @CoreTypeHelper
  public final fun angularVelocityMutate(block: Vector3.() -> Unit): Vector3 =
      angularVelocity.apply {
     block(this)
     angularVelocity = this
  }

  /**
   * This is a helper function for [centerOfMass] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfphysicsbody.centerOfMass
   * //Your changes
   * gltfphysicsbody.centerOfMass = myCoreType
   * ``````
   *
   * The center of mass of the body, in meters. This is in local space relative to the body. By
   * default, the center of the mass is the body's origin.
   */
  @CoreTypeHelper
  public final fun centerOfMassMutate(block: Vector3.() -> Unit): Vector3 = centerOfMass.apply {
     block(this)
     centerOfMass = this
  }

  /**
   * This is a helper function for [inertiaDiagonal] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfphysicsbody.inertiaDiagonal
   * //Your changes
   * gltfphysicsbody.inertiaDiagonal = myCoreType
   * ``````
   *
   * The inertia strength of the physics body, in kilogram meter squared (kg⋅m²). This represents
   * the inertia around the principle axes, the diagonal of the inertia tensor matrix. This is only
   * used when the body type is "rigid" or "vehicle".
   *
   * When converted to a Godot [RigidBody3D] node, if this value is zero, then the inertia will be
   * calculated automatically.
   */
  @CoreTypeHelper
  public final fun inertiaDiagonalMutate(block: Vector3.() -> Unit): Vector3 =
      inertiaDiagonal.apply {
     block(this)
     inertiaDiagonal = this
  }

  /**
   * This is a helper function for [inertiaOrientation] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfphysicsbody.inertiaOrientation
   * //Your changes
   * gltfphysicsbody.inertiaOrientation = myCoreType
   * ``````
   *
   * The inertia orientation of the physics body. This defines the rotation of the inertia's
   * principle axes relative to the object's local axes. This is only used when the body type is
   * "rigid" or "vehicle" and [inertiaDiagonal] is set to a non-zero value.
   */
  @CoreTypeHelper
  public final fun inertiaOrientationMutate(block: Quaternion.() -> Unit): Quaternion =
      inertiaOrientation.apply {
     block(this)
     inertiaOrientation = this
  }

  /**
   * This is a helper function for [inertiaTensor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfphysicsbody.inertiaTensor
   * //Your changes
   * gltfphysicsbody.inertiaTensor = myCoreType
   * ``````
   *
   * The inertia tensor of the physics body, in kilogram meter squared (kg⋅m²). This is only used
   * when the body type is "rigid" or "vehicle".
   *
   * When converted to a Godot [RigidBody3D] node, if this value is zero, then the inertia will be
   * calculated automatically.
   */
  @CoreTypeHelper
  public final fun inertiaTensorMutate(block: Basis.() -> Unit): Basis = inertiaTensor.apply {
     block(this)
     inertiaTensor = this
  }

  /**
   * Converts this GLTFPhysicsBody instance into a Godot [CollisionObject3D] node.
   */
  public final fun toNode(): CollisionObject3D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.toNodePtr)
    return (TransferContext.readReturnValue(OBJECT) as CollisionObject3D?)
  }

  /**
   * Serializes this GLTFPhysicsBody instance into a [Dictionary]. It will be in the format expected
   * by the `OMI_physics_body` glTF extension.
   */
  public final fun toDictionary(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.toDictionaryPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  public final fun getBodyType(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBodyTypePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setBodyType(bodyType: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to bodyType)
    TransferContext.callMethod(MethodBindings.setBodyTypePtr)
  }

  public final fun getMass(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMassPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMass(mass: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to mass.toDouble())
    TransferContext.callMethod(MethodBindings.setMassPtr)
  }

  public final fun getLinearVelocity(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLinearVelocityPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setLinearVelocity(linearVelocity: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to linearVelocity)
    TransferContext.callMethod(MethodBindings.setLinearVelocityPtr)
  }

  public final fun getAngularVelocity(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAngularVelocityPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setAngularVelocity(angularVelocity: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to angularVelocity)
    TransferContext.callMethod(MethodBindings.setAngularVelocityPtr)
  }

  public final fun getCenterOfMass(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCenterOfMassPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setCenterOfMass(centerOfMass: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to centerOfMass)
    TransferContext.callMethod(MethodBindings.setCenterOfMassPtr)
  }

  public final fun getInertiaDiagonal(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInertiaDiagonalPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setInertiaDiagonal(inertiaDiagonal: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to inertiaDiagonal)
    TransferContext.callMethod(MethodBindings.setInertiaDiagonalPtr)
  }

  public final fun getInertiaOrientation(): Quaternion {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInertiaOrientationPtr)
    return (TransferContext.readReturnValue(QUATERNION) as Quaternion)
  }

  public final fun setInertiaOrientation(inertiaOrientation: Quaternion): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, QUATERNION to inertiaOrientation)
    TransferContext.callMethod(MethodBindings.setInertiaOrientationPtr)
  }

  public final fun getInertiaTensor(): Basis {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInertiaTensorPtr)
    return (TransferContext.readReturnValue(BASIS) as Basis)
  }

  public final fun setInertiaTensor(inertiaTensor: Basis): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BASIS to inertiaTensor)
    TransferContext.callMethod(MethodBindings.setInertiaTensorPtr)
  }

  public companion object {
    @JvmField
    public val fromNodeName:
        MethodStringName1<GLTFPhysicsBody, GLTFPhysicsBody?, CollisionObject3D?> =
        MethodStringName1<GLTFPhysicsBody, GLTFPhysicsBody?, CollisionObject3D?>("from_node")

    @JvmField
    public val toNodeName: MethodStringName0<GLTFPhysicsBody, CollisionObject3D?> =
        MethodStringName0<GLTFPhysicsBody, CollisionObject3D?>("to_node")

    @JvmField
    public val fromDictionaryName:
        MethodStringName1<GLTFPhysicsBody, GLTFPhysicsBody?, Dictionary<Any?, Any?>> =
        MethodStringName1<GLTFPhysicsBody, GLTFPhysicsBody?, Dictionary<Any?, Any?>>("from_dictionary")

    @JvmField
    public val toDictionaryName: MethodStringName0<GLTFPhysicsBody, Dictionary<Any?, Any?>> =
        MethodStringName0<GLTFPhysicsBody, Dictionary<Any?, Any?>>("to_dictionary")

    @JvmField
    public val getBodyTypeName: MethodStringName0<GLTFPhysicsBody, String> =
        MethodStringName0<GLTFPhysicsBody, String>("get_body_type")

    @JvmField
    public val setBodyTypeName: MethodStringName1<GLTFPhysicsBody, Unit, String> =
        MethodStringName1<GLTFPhysicsBody, Unit, String>("set_body_type")

    @JvmField
    public val getMassName: MethodStringName0<GLTFPhysicsBody, Float> =
        MethodStringName0<GLTFPhysicsBody, Float>("get_mass")

    @JvmField
    public val setMassName: MethodStringName1<GLTFPhysicsBody, Unit, Float> =
        MethodStringName1<GLTFPhysicsBody, Unit, Float>("set_mass")

    @JvmField
    public val getLinearVelocityName: MethodStringName0<GLTFPhysicsBody, Vector3> =
        MethodStringName0<GLTFPhysicsBody, Vector3>("get_linear_velocity")

    @JvmField
    public val setLinearVelocityName: MethodStringName1<GLTFPhysicsBody, Unit, Vector3> =
        MethodStringName1<GLTFPhysicsBody, Unit, Vector3>("set_linear_velocity")

    @JvmField
    public val getAngularVelocityName: MethodStringName0<GLTFPhysicsBody, Vector3> =
        MethodStringName0<GLTFPhysicsBody, Vector3>("get_angular_velocity")

    @JvmField
    public val setAngularVelocityName: MethodStringName1<GLTFPhysicsBody, Unit, Vector3> =
        MethodStringName1<GLTFPhysicsBody, Unit, Vector3>("set_angular_velocity")

    @JvmField
    public val getCenterOfMassName: MethodStringName0<GLTFPhysicsBody, Vector3> =
        MethodStringName0<GLTFPhysicsBody, Vector3>("get_center_of_mass")

    @JvmField
    public val setCenterOfMassName: MethodStringName1<GLTFPhysicsBody, Unit, Vector3> =
        MethodStringName1<GLTFPhysicsBody, Unit, Vector3>("set_center_of_mass")

    @JvmField
    public val getInertiaDiagonalName: MethodStringName0<GLTFPhysicsBody, Vector3> =
        MethodStringName0<GLTFPhysicsBody, Vector3>("get_inertia_diagonal")

    @JvmField
    public val setInertiaDiagonalName: MethodStringName1<GLTFPhysicsBody, Unit, Vector3> =
        MethodStringName1<GLTFPhysicsBody, Unit, Vector3>("set_inertia_diagonal")

    @JvmField
    public val getInertiaOrientationName: MethodStringName0<GLTFPhysicsBody, Quaternion> =
        MethodStringName0<GLTFPhysicsBody, Quaternion>("get_inertia_orientation")

    @JvmField
    public val setInertiaOrientationName: MethodStringName1<GLTFPhysicsBody, Unit, Quaternion> =
        MethodStringName1<GLTFPhysicsBody, Unit, Quaternion>("set_inertia_orientation")

    @JvmField
    public val getInertiaTensorName: MethodStringName0<GLTFPhysicsBody, Basis> =
        MethodStringName0<GLTFPhysicsBody, Basis>("get_inertia_tensor")

    @JvmField
    public val setInertiaTensorName: MethodStringName1<GLTFPhysicsBody, Unit, Basis> =
        MethodStringName1<GLTFPhysicsBody, Unit, Basis>("set_inertia_tensor")

    /**
     * Creates a new GLTFPhysicsBody instance from the given Godot [CollisionObject3D] node.
     */
    @JvmStatic
    public final fun fromNode(bodyNode: CollisionObject3D?): GLTFPhysicsBody? {
      TransferContext.writeMethodArguments(0L, 0L, OBJECT to bodyNode)
      TransferContext.callMethod(MethodBindings.fromNodePtr)
      return (TransferContext.readReturnValue(OBJECT) as GLTFPhysicsBody?)
    }

    /**
     * Creates a new GLTFPhysicsBody instance by parsing the given [Dictionary] in the
     * `OMI_physics_body` glTF extension format.
     */
    @JvmStatic
    public final fun fromDictionary(dictionary: Dictionary<Any?, Any?>): GLTFPhysicsBody? {
      TransferContext.writeMethodArguments(0L, 0L, DICTIONARY to dictionary)
      TransferContext.callMethod(MethodBindings.fromDictionaryPtr)
      return (TransferContext.readReturnValue(OBJECT) as GLTFPhysicsBody?)
    }
  }

  public object MethodBindings {
    internal val fromNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "from_node", 420544174)

    internal val toNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "to_node", 3224013656)

    internal val fromDictionaryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "from_dictionary", 1177544336)

    internal val toDictionaryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "to_dictionary", 3102165223)

    internal val getBodyTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "get_body_type", 201670096)

    internal val setBodyTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "set_body_type", 83702148)

    internal val getMassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "get_mass", 1740695150)

    internal val setMassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "set_mass", 373806689)

    internal val getLinearVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "get_linear_velocity", 3360562783)

    internal val setLinearVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "set_linear_velocity", 3460891852)

    internal val getAngularVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "get_angular_velocity", 3360562783)

    internal val setAngularVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "set_angular_velocity", 3460891852)

    internal val getCenterOfMassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "get_center_of_mass", 3360562783)

    internal val setCenterOfMassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "set_center_of_mass", 3460891852)

    internal val getInertiaDiagonalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "get_inertia_diagonal", 3360562783)

    internal val setInertiaDiagonalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "set_inertia_diagonal", 3460891852)

    internal val getInertiaOrientationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "get_inertia_orientation", 1222331677)

    internal val setInertiaOrientationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "set_inertia_orientation", 1727505552)

    internal val getInertiaTensorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "get_inertia_tensor", 2716978435)

    internal val setInertiaTensorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFPhysicsBody", "set_inertia_tensor", 1055510324)
  }
}
