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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.RID
import godot.core.Transform3D
import godot.core.VariantParser.LONG
import godot.core.VariantParser.TRANSFORM3D
import godot.core.VariantParser._RID
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [RDAccelerationStructureInstance] describes an instance of a Bottom-Level Acceleration Structure
 * (BLAS) used in the [RenderingDevice.tlasBuild] method.
 */
@GodotBaseType
public open class RDAccelerationStructureInstance : RefCounted() {
  /**
   * Transform applied to the referenced BLAS for this instance.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var transform: Transform3D
    @JvmName("transformProperty")
    get() = getTransform()
    @JvmName("transformProperty")
    set(`value`) {
      setTransform(value)
    }

  /**
   * Custom instance ID that can be accessed in GLSL using `gl_InstanceCustomIndexEXT`.
   */
  public final inline var id: Long
    @JvmName("idProperty")
    get() = getId()
    @JvmName("idProperty")
    set(`value`) {
      setId(value)
    }

  /**
   * Visibility mask used to control which rays can intersect this instance.
   */
  public final inline var mask: Int
    @JvmName("maskProperty")
    get() = getMask()
    @JvmName("maskProperty")
    set(`value`) {
      setMask(value)
    }

  /**
   * Hit shader binding table range used for this instance, allocated using the
   * [RenderingDevice.hitSbtRangeAlloc] method.
   */
  public final inline var hitSbtRange: Long
    @JvmName("hitSbtRangeProperty")
    get() = getHitSbtRange()
    @JvmName("hitSbtRangeProperty")
    set(`value`) {
      setHitSbtRange(value)
    }

  /**
   * Flags for the instance.
   */
  public final inline var flags: RenderingDevice.AccelerationStructureInstanceFlagBits
    @JvmName("flagsProperty")
    get() = getFlags()
    @JvmName("flagsProperty")
    set(`value`) {
      setFlags(value)
    }

  /**
   * The BLAS referenced by this instance. If `null`, the instance is treated as a placeholder but
   * still contributes to `gl_InstanceIndex` in GLSL.
   */
  public final inline var blas: RID
    @JvmName("blasProperty")
    get() = getBlas()
    @JvmName("blasProperty")
    set(`value`) {
      setBlas(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(579, scriptPtr)
  }

  /**
   * This is a helper function for [transform] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = rdaccelerationstructureinstance.transform
   * //Your changes
   * rdaccelerationstructureinstance.transform = myCoreType
   * ``````
   *
   * Transform applied to the referenced BLAS for this instance.
   */
  @CoreTypeHelper
  public final fun transformMutate(block: Transform3D.() -> Unit): Transform3D = transform.apply {
     block(this)
     transform = this
  }

  public final fun setTransform(pMember: Transform3D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM3D to pMember)
    TransferContext.callMethod(MethodBindings.setTransformPtr)
  }

  public final fun getTransform(): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  public final fun setId(pMember: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember)
    TransferContext.callMethod(MethodBindings.setIdPtr)
  }

  public final fun getId(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setMask(pMember: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember.toLong())
    TransferContext.callMethod(MethodBindings.setMaskPtr)
  }

  public final fun getMask(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setHitSbtRange(pMember: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember)
    TransferContext.callMethod(MethodBindings.setHitSbtRangePtr)
  }

  public final fun getHitSbtRange(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHitSbtRangePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setFlags(pMember: RenderingDevice.AccelerationStructureInstanceFlagBits): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember.flag)
    TransferContext.callMethod(MethodBindings.setFlagsPtr)
  }

  public final fun getFlags(): RenderingDevice.AccelerationStructureInstanceFlagBits {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFlagsPtr)
    return RenderingDevice.AccelerationStructureInstanceFlagBits(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setBlas(pMember: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to pMember)
    TransferContext.callMethod(MethodBindings.setBlasPtr)
  }

  public final fun getBlas(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBlasPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  public companion object {
    @JvmField
    public val setTransformName:
        MethodStringName1<RDAccelerationStructureInstance, Unit, Transform3D> =
        MethodStringName1<RDAccelerationStructureInstance, Unit, Transform3D>("set_transform")

    @JvmField
    public val getTransformName: MethodStringName0<RDAccelerationStructureInstance, Transform3D> =
        MethodStringName0<RDAccelerationStructureInstance, Transform3D>("get_transform")

    @JvmField
    public val setIdName: MethodStringName1<RDAccelerationStructureInstance, Unit, Long> =
        MethodStringName1<RDAccelerationStructureInstance, Unit, Long>("set_id")

    @JvmField
    public val getIdName: MethodStringName0<RDAccelerationStructureInstance, Long> =
        MethodStringName0<RDAccelerationStructureInstance, Long>("get_id")

    @JvmField
    public val setMaskName: MethodStringName1<RDAccelerationStructureInstance, Unit, Int> =
        MethodStringName1<RDAccelerationStructureInstance, Unit, Int>("set_mask")

    @JvmField
    public val getMaskName: MethodStringName0<RDAccelerationStructureInstance, Int> =
        MethodStringName0<RDAccelerationStructureInstance, Int>("get_mask")

    @JvmField
    public val setHitSbtRangeName: MethodStringName1<RDAccelerationStructureInstance, Unit, Long> =
        MethodStringName1<RDAccelerationStructureInstance, Unit, Long>("set_hit_sbt_range")

    @JvmField
    public val getHitSbtRangeName: MethodStringName0<RDAccelerationStructureInstance, Long> =
        MethodStringName0<RDAccelerationStructureInstance, Long>("get_hit_sbt_range")

    @JvmField
    public val setFlagsName:
        MethodStringName1<RDAccelerationStructureInstance, Unit, RenderingDevice.AccelerationStructureInstanceFlagBits>
        =
        MethodStringName1<RDAccelerationStructureInstance, Unit, RenderingDevice.AccelerationStructureInstanceFlagBits>("set_flags")

    @JvmField
    public val getFlagsName:
        MethodStringName0<RDAccelerationStructureInstance, RenderingDevice.AccelerationStructureInstanceFlagBits>
        =
        MethodStringName0<RDAccelerationStructureInstance, RenderingDevice.AccelerationStructureInstanceFlagBits>("get_flags")

    @JvmField
    public val setBlasName: MethodStringName1<RDAccelerationStructureInstance, Unit, RID> =
        MethodStringName1<RDAccelerationStructureInstance, Unit, RID>("set_blas")

    @JvmField
    public val getBlasName: MethodStringName0<RDAccelerationStructureInstance, RID> =
        MethodStringName0<RDAccelerationStructureInstance, RID>("get_blas")
  }

  public object MethodBindings {
    internal val setTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureInstance", "set_transform", 2952846383)

    internal val getTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureInstance", "get_transform", 3229777777)

    internal val setIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureInstance", "set_id", 1286410249)

    internal val getIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureInstance", "get_id", 3905245786)

    internal val setMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureInstance", "set_mask", 1286410249)

    internal val getMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureInstance", "get_mask", 3905245786)

    internal val setHitSbtRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureInstance", "set_hit_sbt_range", 1286410249)

    internal val getHitSbtRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureInstance", "get_hit_sbt_range", 3905245786)

    internal val setFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureInstance", "set_flags", 2971840141)

    internal val getFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureInstance", "get_flags", 2410182637)

    internal val setBlasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureInstance", "set_blas", 2722037293)

    internal val getBlasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDAccelerationStructureInstance", "get_blas", 2944877500)
  }
}
