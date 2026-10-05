// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Boolean
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [RDPipelineDepthStencilState] controls the way depth and stencil comparisons are performed when
 * sampling those values using [RenderingDevice].
 */
@GodotBaseType
public open class RDPipelineDepthStencilState : RefCounted() {
  /**
   * If `true`, enables depth testing which allows objects to be automatically occluded by other
   * objects based on their depth. This also allows objects to be partially occluded by other objects.
   * If `false`, objects will appear in the order they were drawn (like in Godot's 2D renderer).
   */
  public final inline var enableDepthTest: Boolean
    @JvmName("enableDepthTestProperty")
    get() = getEnableDepthTest()
    @JvmName("enableDepthTestProperty")
    set(`value`) {
      setEnableDepthTest(value)
    }

  /**
   * If `true`, writes to the depth buffer whenever the depth test returns `true`. Only works when
   * enable_depth_test is also `true`.
   */
  public final inline var enableDepthWrite: Boolean
    @JvmName("enableDepthWriteProperty")
    get() = getEnableDepthWrite()
    @JvmName("enableDepthWriteProperty")
    set(`value`) {
      setEnableDepthWrite(value)
    }

  /**
   * The method used for comparing the previous and current depth values.
   */
  public final inline var depthCompareOperator: RenderingDevice.CompareOperator
    @JvmName("depthCompareOperatorProperty")
    get() = getDepthCompareOperator()
    @JvmName("depthCompareOperatorProperty")
    set(`value`) {
      setDepthCompareOperator(value)
    }

  /**
   * If `true`, each depth value will be tested to see if it is between [depthRangeMin] and
   * [depthRangeMax]. If it is outside of these values, it is discarded.
   */
  public final inline var enableDepthRange: Boolean
    @JvmName("enableDepthRangeProperty")
    get() = getEnableDepthRange()
    @JvmName("enableDepthRangeProperty")
    set(`value`) {
      setEnableDepthRange(value)
    }

  /**
   * The minimum depth that returns `true` for [enableDepthRange].
   */
  public final inline var depthRangeMin: Float
    @JvmName("depthRangeMinProperty")
    get() = getDepthRangeMin()
    @JvmName("depthRangeMinProperty")
    set(`value`) {
      setDepthRangeMin(value)
    }

  /**
   * The maximum depth that returns `true` for [enableDepthRange].
   */
  public final inline var depthRangeMax: Float
    @JvmName("depthRangeMaxProperty")
    get() = getDepthRangeMax()
    @JvmName("depthRangeMaxProperty")
    set(`value`) {
      setDepthRangeMax(value)
    }

  /**
   * If `true`, enables stencil testing. There are separate stencil buffers for front-facing
   * triangles and back-facing triangles. See properties that begin with "front_op" and properties with
   * "back_op" for each.
   */
  public final inline var enableStencil: Boolean
    @JvmName("enableStencilProperty")
    get() = getEnableStencil()
    @JvmName("enableStencilProperty")
    set(`value`) {
      setEnableStencil(value)
    }

  /**
   * The operation to perform on the stencil buffer for front pixels that fail the stencil test.
   */
  public final inline var frontOpFail: RenderingDevice.StencilOperation
    @JvmName("frontOpFailProperty")
    get() = getFrontOpFail()
    @JvmName("frontOpFailProperty")
    set(`value`) {
      setFrontOpFail(value)
    }

  /**
   * The operation to perform on the stencil buffer for front pixels that pass the stencil test.
   */
  public final inline var frontOpPass: RenderingDevice.StencilOperation
    @JvmName("frontOpPassProperty")
    get() = getFrontOpPass()
    @JvmName("frontOpPassProperty")
    set(`value`) {
      setFrontOpPass(value)
    }

  /**
   * The operation to perform on the stencil buffer for front pixels that pass the stencil test but
   * fail the depth test.
   */
  public final inline var frontOpDepthFail: RenderingDevice.StencilOperation
    @JvmName("frontOpDepthFailProperty")
    get() = getFrontOpDepthFail()
    @JvmName("frontOpDepthFailProperty")
    set(`value`) {
      setFrontOpDepthFail(value)
    }

  /**
   * The method used for comparing the previous front stencil value and [frontOpReference].
   */
  public final inline var frontOpCompare: RenderingDevice.CompareOperator
    @JvmName("frontOpCompareProperty")
    get() = getFrontOpCompare()
    @JvmName("frontOpCompareProperty")
    set(`value`) {
      setFrontOpCompare(value)
    }

  /**
   * Selects which bits from the front stencil value will be compared.
   */
  public final inline var frontOpCompareMask: Long
    @JvmName("frontOpCompareMaskProperty")
    get() = getFrontOpCompareMask()
    @JvmName("frontOpCompareMaskProperty")
    set(`value`) {
      setFrontOpCompareMask(value)
    }

  /**
   * Selects which bits from the front stencil value will be changed.
   */
  public final inline var frontOpWriteMask: Long
    @JvmName("frontOpWriteMaskProperty")
    get() = getFrontOpWriteMask()
    @JvmName("frontOpWriteMaskProperty")
    set(`value`) {
      setFrontOpWriteMask(value)
    }

  /**
   * The value the previous front stencil value will be compared to.
   */
  public final inline var frontOpReference: Long
    @JvmName("frontOpReferenceProperty")
    get() = getFrontOpReference()
    @JvmName("frontOpReferenceProperty")
    set(`value`) {
      setFrontOpReference(value)
    }

  /**
   * The operation to perform on the stencil buffer for back pixels that fail the stencil test.
   */
  public final inline var backOpFail: RenderingDevice.StencilOperation
    @JvmName("backOpFailProperty")
    get() = getBackOpFail()
    @JvmName("backOpFailProperty")
    set(`value`) {
      setBackOpFail(value)
    }

  /**
   * The operation to perform on the stencil buffer for back pixels that pass the stencil test.
   */
  public final inline var backOpPass: RenderingDevice.StencilOperation
    @JvmName("backOpPassProperty")
    get() = getBackOpPass()
    @JvmName("backOpPassProperty")
    set(`value`) {
      setBackOpPass(value)
    }

  /**
   * The operation to perform on the stencil buffer for back pixels that pass the stencil test but
   * fail the depth test.
   */
  public final inline var backOpDepthFail: RenderingDevice.StencilOperation
    @JvmName("backOpDepthFailProperty")
    get() = getBackOpDepthFail()
    @JvmName("backOpDepthFailProperty")
    set(`value`) {
      setBackOpDepthFail(value)
    }

  /**
   * The method used for comparing the previous back stencil value and [backOpReference].
   */
  public final inline var backOpCompare: RenderingDevice.CompareOperator
    @JvmName("backOpCompareProperty")
    get() = getBackOpCompare()
    @JvmName("backOpCompareProperty")
    set(`value`) {
      setBackOpCompare(value)
    }

  /**
   * Selects which bits from the back stencil value will be compared.
   */
  public final inline var backOpCompareMask: Long
    @JvmName("backOpCompareMaskProperty")
    get() = getBackOpCompareMask()
    @JvmName("backOpCompareMaskProperty")
    set(`value`) {
      setBackOpCompareMask(value)
    }

  /**
   * Selects which bits from the back stencil value will be changed.
   */
  public final inline var backOpWriteMask: Long
    @JvmName("backOpWriteMaskProperty")
    get() = getBackOpWriteMask()
    @JvmName("backOpWriteMaskProperty")
    set(`value`) {
      setBackOpWriteMask(value)
    }

  /**
   * The value the previous back stencil value will be compared to.
   */
  public final inline var backOpReference: Long
    @JvmName("backOpReferenceProperty")
    get() = getBackOpReference()
    @JvmName("backOpReferenceProperty")
    set(`value`) {
      setBackOpReference(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(584, scriptPtr)
  }

  public final fun setEnableDepthTest(pMember: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setEnableDepthTestPtr, pMember)
  }

  public final fun getEnableDepthTest(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getEnableDepthTestPtr)

  public final fun setEnableDepthWrite(pMember: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setEnableDepthWritePtr, pMember)
  }

  public final fun getEnableDepthWrite(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getEnableDepthWritePtr)

  public final fun setDepthCompareOperator(pMember: RenderingDevice.CompareOperator): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setDepthCompareOperatorPtr, pMember.value)
  }

  public final fun getDepthCompareOperator(): RenderingDevice.CompareOperator =
      RenderingDevice.CompareOperator.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getDepthCompareOperatorPtr))

  public final fun setEnableDepthRange(pMember: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setEnableDepthRangePtr, pMember)
  }

  public final fun getEnableDepthRange(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getEnableDepthRangePtr)

  public final fun setDepthRangeMin(pMember: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setDepthRangeMinPtr, pMember.toDouble())
  }

  public final fun getDepthRangeMin(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDepthRangeMinPtr).toFloat()

  public final fun setDepthRangeMax(pMember: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setDepthRangeMaxPtr, pMember.toDouble())
  }

  public final fun getDepthRangeMax(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDepthRangeMaxPtr).toFloat()

  public final fun setEnableStencil(pMember: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setEnableStencilPtr, pMember)
  }

  public final fun getEnableStencil(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getEnableStencilPtr)

  public final fun setFrontOpFail(pMember: RenderingDevice.StencilOperation): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setFrontOpFailPtr, pMember.value)
  }

  public final fun getFrontOpFail(): RenderingDevice.StencilOperation =
      RenderingDevice.StencilOperation.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getFrontOpFailPtr))

  public final fun setFrontOpPass(pMember: RenderingDevice.StencilOperation): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setFrontOpPassPtr, pMember.value)
  }

  public final fun getFrontOpPass(): RenderingDevice.StencilOperation =
      RenderingDevice.StencilOperation.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getFrontOpPassPtr))

  public final fun setFrontOpDepthFail(pMember: RenderingDevice.StencilOperation): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setFrontOpDepthFailPtr, pMember.value)
  }

  public final fun getFrontOpDepthFail(): RenderingDevice.StencilOperation =
      RenderingDevice.StencilOperation.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getFrontOpDepthFailPtr))

  public final fun setFrontOpCompare(pMember: RenderingDevice.CompareOperator): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setFrontOpComparePtr, pMember.value)
  }

  public final fun getFrontOpCompare(): RenderingDevice.CompareOperator =
      RenderingDevice.CompareOperator.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getFrontOpComparePtr))

  public final fun setFrontOpCompareMask(pMember: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setFrontOpCompareMaskPtr, pMember)
  }

  public final fun getFrontOpCompareMask(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getFrontOpCompareMaskPtr)

  public final fun setFrontOpWriteMask(pMember: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setFrontOpWriteMaskPtr, pMember)
  }

  public final fun getFrontOpWriteMask(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getFrontOpWriteMaskPtr)

  public final fun setFrontOpReference(pMember: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setFrontOpReferencePtr, pMember)
  }

  public final fun getFrontOpReference(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getFrontOpReferencePtr)

  public final fun setBackOpFail(pMember: RenderingDevice.StencilOperation): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setBackOpFailPtr, pMember.value)
  }

  public final fun getBackOpFail(): RenderingDevice.StencilOperation =
      RenderingDevice.StencilOperation.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBackOpFailPtr))

  public final fun setBackOpPass(pMember: RenderingDevice.StencilOperation): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setBackOpPassPtr, pMember.value)
  }

  public final fun getBackOpPass(): RenderingDevice.StencilOperation =
      RenderingDevice.StencilOperation.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBackOpPassPtr))

  public final fun setBackOpDepthFail(pMember: RenderingDevice.StencilOperation): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setBackOpDepthFailPtr, pMember.value)
  }

  public final fun getBackOpDepthFail(): RenderingDevice.StencilOperation =
      RenderingDevice.StencilOperation.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBackOpDepthFailPtr))

  public final fun setBackOpCompare(pMember: RenderingDevice.CompareOperator): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setBackOpComparePtr, pMember.value)
  }

  public final fun getBackOpCompare(): RenderingDevice.CompareOperator =
      RenderingDevice.CompareOperator.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBackOpComparePtr))

  public final fun setBackOpCompareMask(pMember: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setBackOpCompareMaskPtr, pMember)
  }

  public final fun getBackOpCompareMask(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBackOpCompareMaskPtr)

  public final fun setBackOpWriteMask(pMember: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setBackOpWriteMaskPtr, pMember)
  }

  public final fun getBackOpWriteMask(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBackOpWriteMaskPtr)

  public final fun setBackOpReference(pMember: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setBackOpReferencePtr, pMember)
  }

  public final fun getBackOpReference(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBackOpReferencePtr)

  public companion object {
    @JvmField
    public val setEnableDepthTestName: MethodStringName1<RDPipelineDepthStencilState, Unit, Boolean>
        = MethodStringName1<RDPipelineDepthStencilState, Unit, Boolean>("set_enable_depth_test")

    @JvmField
    public val getEnableDepthTestName: MethodStringName0<RDPipelineDepthStencilState, Boolean> =
        MethodStringName0<RDPipelineDepthStencilState, Boolean>("get_enable_depth_test")

    @JvmField
    public val setEnableDepthWriteName:
        MethodStringName1<RDPipelineDepthStencilState, Unit, Boolean> =
        MethodStringName1<RDPipelineDepthStencilState, Unit, Boolean>("set_enable_depth_write")

    @JvmField
    public val getEnableDepthWriteName: MethodStringName0<RDPipelineDepthStencilState, Boolean> =
        MethodStringName0<RDPipelineDepthStencilState, Boolean>("get_enable_depth_write")

    @JvmField
    public val setDepthCompareOperatorName:
        MethodStringName1<RDPipelineDepthStencilState, Unit, RenderingDevice.CompareOperator> =
        MethodStringName1<RDPipelineDepthStencilState, Unit, RenderingDevice.CompareOperator>("set_depth_compare_operator")

    @JvmField
    public val getDepthCompareOperatorName:
        MethodStringName0<RDPipelineDepthStencilState, RenderingDevice.CompareOperator> =
        MethodStringName0<RDPipelineDepthStencilState, RenderingDevice.CompareOperator>("get_depth_compare_operator")

    @JvmField
    public val setEnableDepthRangeName:
        MethodStringName1<RDPipelineDepthStencilState, Unit, Boolean> =
        MethodStringName1<RDPipelineDepthStencilState, Unit, Boolean>("set_enable_depth_range")

    @JvmField
    public val getEnableDepthRangeName: MethodStringName0<RDPipelineDepthStencilState, Boolean> =
        MethodStringName0<RDPipelineDepthStencilState, Boolean>("get_enable_depth_range")

    @JvmField
    public val setDepthRangeMinName: MethodStringName1<RDPipelineDepthStencilState, Unit, Float> =
        MethodStringName1<RDPipelineDepthStencilState, Unit, Float>("set_depth_range_min")

    @JvmField
    public val getDepthRangeMinName: MethodStringName0<RDPipelineDepthStencilState, Float> =
        MethodStringName0<RDPipelineDepthStencilState, Float>("get_depth_range_min")

    @JvmField
    public val setDepthRangeMaxName: MethodStringName1<RDPipelineDepthStencilState, Unit, Float> =
        MethodStringName1<RDPipelineDepthStencilState, Unit, Float>("set_depth_range_max")

    @JvmField
    public val getDepthRangeMaxName: MethodStringName0<RDPipelineDepthStencilState, Float> =
        MethodStringName0<RDPipelineDepthStencilState, Float>("get_depth_range_max")

    @JvmField
    public val setEnableStencilName: MethodStringName1<RDPipelineDepthStencilState, Unit, Boolean> =
        MethodStringName1<RDPipelineDepthStencilState, Unit, Boolean>("set_enable_stencil")

    @JvmField
    public val getEnableStencilName: MethodStringName0<RDPipelineDepthStencilState, Boolean> =
        MethodStringName0<RDPipelineDepthStencilState, Boolean>("get_enable_stencil")

    @JvmField
    public val setFrontOpFailName:
        MethodStringName1<RDPipelineDepthStencilState, Unit, RenderingDevice.StencilOperation> =
        MethodStringName1<RDPipelineDepthStencilState, Unit, RenderingDevice.StencilOperation>("set_front_op_fail")

    @JvmField
    public val getFrontOpFailName:
        MethodStringName0<RDPipelineDepthStencilState, RenderingDevice.StencilOperation> =
        MethodStringName0<RDPipelineDepthStencilState, RenderingDevice.StencilOperation>("get_front_op_fail")

    @JvmField
    public val setFrontOpPassName:
        MethodStringName1<RDPipelineDepthStencilState, Unit, RenderingDevice.StencilOperation> =
        MethodStringName1<RDPipelineDepthStencilState, Unit, RenderingDevice.StencilOperation>("set_front_op_pass")

    @JvmField
    public val getFrontOpPassName:
        MethodStringName0<RDPipelineDepthStencilState, RenderingDevice.StencilOperation> =
        MethodStringName0<RDPipelineDepthStencilState, RenderingDevice.StencilOperation>("get_front_op_pass")

    @JvmField
    public val setFrontOpDepthFailName:
        MethodStringName1<RDPipelineDepthStencilState, Unit, RenderingDevice.StencilOperation> =
        MethodStringName1<RDPipelineDepthStencilState, Unit, RenderingDevice.StencilOperation>("set_front_op_depth_fail")

    @JvmField
    public val getFrontOpDepthFailName:
        MethodStringName0<RDPipelineDepthStencilState, RenderingDevice.StencilOperation> =
        MethodStringName0<RDPipelineDepthStencilState, RenderingDevice.StencilOperation>("get_front_op_depth_fail")

    @JvmField
    public val setFrontOpCompareName:
        MethodStringName1<RDPipelineDepthStencilState, Unit, RenderingDevice.CompareOperator> =
        MethodStringName1<RDPipelineDepthStencilState, Unit, RenderingDevice.CompareOperator>("set_front_op_compare")

    @JvmField
    public val getFrontOpCompareName:
        MethodStringName0<RDPipelineDepthStencilState, RenderingDevice.CompareOperator> =
        MethodStringName0<RDPipelineDepthStencilState, RenderingDevice.CompareOperator>("get_front_op_compare")

    @JvmField
    public val setFrontOpCompareMaskName: MethodStringName1<RDPipelineDepthStencilState, Unit, Long>
        = MethodStringName1<RDPipelineDepthStencilState, Unit, Long>("set_front_op_compare_mask")

    @JvmField
    public val getFrontOpCompareMaskName: MethodStringName0<RDPipelineDepthStencilState, Long> =
        MethodStringName0<RDPipelineDepthStencilState, Long>("get_front_op_compare_mask")

    @JvmField
    public val setFrontOpWriteMaskName: MethodStringName1<RDPipelineDepthStencilState, Unit, Long> =
        MethodStringName1<RDPipelineDepthStencilState, Unit, Long>("set_front_op_write_mask")

    @JvmField
    public val getFrontOpWriteMaskName: MethodStringName0<RDPipelineDepthStencilState, Long> =
        MethodStringName0<RDPipelineDepthStencilState, Long>("get_front_op_write_mask")

    @JvmField
    public val setFrontOpReferenceName: MethodStringName1<RDPipelineDepthStencilState, Unit, Long> =
        MethodStringName1<RDPipelineDepthStencilState, Unit, Long>("set_front_op_reference")

    @JvmField
    public val getFrontOpReferenceName: MethodStringName0<RDPipelineDepthStencilState, Long> =
        MethodStringName0<RDPipelineDepthStencilState, Long>("get_front_op_reference")

    @JvmField
    public val setBackOpFailName:
        MethodStringName1<RDPipelineDepthStencilState, Unit, RenderingDevice.StencilOperation> =
        MethodStringName1<RDPipelineDepthStencilState, Unit, RenderingDevice.StencilOperation>("set_back_op_fail")

    @JvmField
    public val getBackOpFailName:
        MethodStringName0<RDPipelineDepthStencilState, RenderingDevice.StencilOperation> =
        MethodStringName0<RDPipelineDepthStencilState, RenderingDevice.StencilOperation>("get_back_op_fail")

    @JvmField
    public val setBackOpPassName:
        MethodStringName1<RDPipelineDepthStencilState, Unit, RenderingDevice.StencilOperation> =
        MethodStringName1<RDPipelineDepthStencilState, Unit, RenderingDevice.StencilOperation>("set_back_op_pass")

    @JvmField
    public val getBackOpPassName:
        MethodStringName0<RDPipelineDepthStencilState, RenderingDevice.StencilOperation> =
        MethodStringName0<RDPipelineDepthStencilState, RenderingDevice.StencilOperation>("get_back_op_pass")

    @JvmField
    public val setBackOpDepthFailName:
        MethodStringName1<RDPipelineDepthStencilState, Unit, RenderingDevice.StencilOperation> =
        MethodStringName1<RDPipelineDepthStencilState, Unit, RenderingDevice.StencilOperation>("set_back_op_depth_fail")

    @JvmField
    public val getBackOpDepthFailName:
        MethodStringName0<RDPipelineDepthStencilState, RenderingDevice.StencilOperation> =
        MethodStringName0<RDPipelineDepthStencilState, RenderingDevice.StencilOperation>("get_back_op_depth_fail")

    @JvmField
    public val setBackOpCompareName:
        MethodStringName1<RDPipelineDepthStencilState, Unit, RenderingDevice.CompareOperator> =
        MethodStringName1<RDPipelineDepthStencilState, Unit, RenderingDevice.CompareOperator>("set_back_op_compare")

    @JvmField
    public val getBackOpCompareName:
        MethodStringName0<RDPipelineDepthStencilState, RenderingDevice.CompareOperator> =
        MethodStringName0<RDPipelineDepthStencilState, RenderingDevice.CompareOperator>("get_back_op_compare")

    @JvmField
    public val setBackOpCompareMaskName: MethodStringName1<RDPipelineDepthStencilState, Unit, Long>
        = MethodStringName1<RDPipelineDepthStencilState, Unit, Long>("set_back_op_compare_mask")

    @JvmField
    public val getBackOpCompareMaskName: MethodStringName0<RDPipelineDepthStencilState, Long> =
        MethodStringName0<RDPipelineDepthStencilState, Long>("get_back_op_compare_mask")

    @JvmField
    public val setBackOpWriteMaskName: MethodStringName1<RDPipelineDepthStencilState, Unit, Long> =
        MethodStringName1<RDPipelineDepthStencilState, Unit, Long>("set_back_op_write_mask")

    @JvmField
    public val getBackOpWriteMaskName: MethodStringName0<RDPipelineDepthStencilState, Long> =
        MethodStringName0<RDPipelineDepthStencilState, Long>("get_back_op_write_mask")

    @JvmField
    public val setBackOpReferenceName: MethodStringName1<RDPipelineDepthStencilState, Unit, Long> =
        MethodStringName1<RDPipelineDepthStencilState, Unit, Long>("set_back_op_reference")

    @JvmField
    public val getBackOpReferenceName: MethodStringName0<RDPipelineDepthStencilState, Long> =
        MethodStringName0<RDPipelineDepthStencilState, Long>("get_back_op_reference")
  }

  public object MethodBindings {
    internal val setEnableDepthTestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_enable_depth_test", 2586408642)

    internal val getEnableDepthTestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_enable_depth_test", 36873697)

    internal val setEnableDepthWritePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_enable_depth_write", 2586408642)

    internal val getEnableDepthWritePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_enable_depth_write", 36873697)

    internal val setDepthCompareOperatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_depth_compare_operator", 2573711505)

    internal val getDepthCompareOperatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_depth_compare_operator", 269730778)

    internal val setEnableDepthRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_enable_depth_range", 2586408642)

    internal val getEnableDepthRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_enable_depth_range", 36873697)

    internal val setDepthRangeMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_depth_range_min", 373806689)

    internal val getDepthRangeMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_depth_range_min", 1740695150)

    internal val setDepthRangeMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_depth_range_max", 373806689)

    internal val getDepthRangeMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_depth_range_max", 1740695150)

    internal val setEnableStencilPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_enable_stencil", 2586408642)

    internal val getEnableStencilPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_enable_stencil", 36873697)

    internal val setFrontOpFailPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_front_op_fail", 2092799566)

    internal val getFrontOpFailPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_front_op_fail", 1714732389)

    internal val setFrontOpPassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_front_op_pass", 2092799566)

    internal val getFrontOpPassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_front_op_pass", 1714732389)

    internal val setFrontOpDepthFailPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_front_op_depth_fail", 2092799566)

    internal val getFrontOpDepthFailPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_front_op_depth_fail", 1714732389)

    internal val setFrontOpComparePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_front_op_compare", 2573711505)

    internal val getFrontOpComparePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_front_op_compare", 269730778)

    internal val setFrontOpCompareMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_front_op_compare_mask", 1286410249)

    internal val getFrontOpCompareMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_front_op_compare_mask", 3905245786)

    internal val setFrontOpWriteMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_front_op_write_mask", 1286410249)

    internal val getFrontOpWriteMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_front_op_write_mask", 3905245786)

    internal val setFrontOpReferencePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_front_op_reference", 1286410249)

    internal val getFrontOpReferencePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_front_op_reference", 3905245786)

    internal val setBackOpFailPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_back_op_fail", 2092799566)

    internal val getBackOpFailPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_back_op_fail", 1714732389)

    internal val setBackOpPassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_back_op_pass", 2092799566)

    internal val getBackOpPassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_back_op_pass", 1714732389)

    internal val setBackOpDepthFailPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_back_op_depth_fail", 2092799566)

    internal val getBackOpDepthFailPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_back_op_depth_fail", 1714732389)

    internal val setBackOpComparePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_back_op_compare", 2573711505)

    internal val getBackOpComparePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_back_op_compare", 269730778)

    internal val setBackOpCompareMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_back_op_compare_mask", 1286410249)

    internal val getBackOpCompareMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_back_op_compare_mask", 3905245786)

    internal val setBackOpWriteMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_back_op_write_mask", 1286410249)

    internal val getBackOpWriteMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_back_op_write_mask", 3905245786)

    internal val setBackOpReferencePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "set_back_op_reference", 1286410249)

    internal val getBackOpReferencePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineDepthStencilState", "get_back_op_reference", 3905245786)
  }
}
