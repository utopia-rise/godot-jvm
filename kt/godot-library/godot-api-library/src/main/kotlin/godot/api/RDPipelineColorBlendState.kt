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
import godot.callPtrMethod0_ret_ARRAY
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_COLOR
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_ARRAY
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_COLOR
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.Color
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantArray
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This object is used by [RenderingDevice].
 */
@GodotBaseType
public open class RDPipelineColorBlendState : RefCounted() {
  /**
   * If `true`, performs the logic operation defined in [logicOp].
   */
  public final inline var enableLogicOp: Boolean
    @JvmName("enableLogicOpProperty")
    get() = getEnableLogicOp()
    @JvmName("enableLogicOpProperty")
    set(`value`) {
      setEnableLogicOp(value)
    }

  /**
   * The logic operation to perform for blending. Only effective if [enableLogicOp] is `true`.
   */
  public final inline var logicOp: RenderingDevice.LogicOperation
    @JvmName("logicOpProperty")
    get() = getLogicOp()
    @JvmName("logicOpProperty")
    set(`value`) {
      setLogicOp(value)
    }

  /**
   * The constant color to blend with. See also [RenderingDevice.drawListSetBlendConstants].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var blendConstant: Color
    @JvmName("blendConstantProperty")
    get() = getBlendConstant()
    @JvmName("blendConstantProperty")
    set(`value`) {
      setBlendConstant(value)
    }

  /**
   * The attachments that are blended together.
   */
  public final inline var attachments: VariantArray<RDPipelineColorBlendStateAttachment>
    @JvmName("attachmentsProperty")
    get() = getAttachments()
    @JvmName("attachmentsProperty")
    set(`value`) {
      setAttachments(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(582, scriptPtr)
  }

  /**
   * This is a helper function for [blendConstant] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = rdpipelinecolorblendstate.blendConstant
   * //Your changes
   * rdpipelinecolorblendstate.blendConstant = myCoreType
   * ``````
   *
   * The constant color to blend with. See also [RenderingDevice.drawListSetBlendConstants].
   */
  @CoreTypeHelper
  public final fun blendConstantMutate(block: Color.() -> Unit): Color = blendConstant.apply {
     block(this)
     blendConstant = this
  }

  public final fun setEnableLogicOp(pMember: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setEnableLogicOpPtr, pMember)
  }

  public final fun getEnableLogicOp(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getEnableLogicOpPtr)

  public final fun setLogicOp(pMember: RenderingDevice.LogicOperation): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setLogicOpPtr, pMember.value)
  }

  public final fun getLogicOp(): RenderingDevice.LogicOperation =
      RenderingDevice.LogicOperation.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getLogicOpPtr))

  public final fun setBlendConstant(pMember: Color): Unit {
    TransferContext.callPtrMethod_COLOR(ptr, objectID.id, MethodBindings.setBlendConstantPtr, pMember)
  }

  public final fun getBlendConstant(): Color =
      TransferContext.callPtrMethod0_ret_COLOR(ptr, objectID.id, MethodBindings.getBlendConstantPtr)

  public final fun setAttachments(attachments: VariantArray<RDPipelineColorBlendStateAttachment>):
      Unit {
    TransferContext.callPtrMethod_ARRAY(ptr, objectID.id, MethodBindings.setAttachmentsPtr, attachments)
  }

  public final fun getAttachments(): VariantArray<RDPipelineColorBlendStateAttachment> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.getAttachmentsPtr) as VariantArray<RDPipelineColorBlendStateAttachment>)

  public companion object {
    @JvmField
    public val setEnableLogicOpName: MethodStringName1<RDPipelineColorBlendState, Unit, Boolean> =
        MethodStringName1<RDPipelineColorBlendState, Unit, Boolean>("set_enable_logic_op")

    @JvmField
    public val getEnableLogicOpName: MethodStringName0<RDPipelineColorBlendState, Boolean> =
        MethodStringName0<RDPipelineColorBlendState, Boolean>("get_enable_logic_op")

    @JvmField
    public val setLogicOpName:
        MethodStringName1<RDPipelineColorBlendState, Unit, RenderingDevice.LogicOperation> =
        MethodStringName1<RDPipelineColorBlendState, Unit, RenderingDevice.LogicOperation>("set_logic_op")

    @JvmField
    public val getLogicOpName:
        MethodStringName0<RDPipelineColorBlendState, RenderingDevice.LogicOperation> =
        MethodStringName0<RDPipelineColorBlendState, RenderingDevice.LogicOperation>("get_logic_op")

    @JvmField
    public val setBlendConstantName: MethodStringName1<RDPipelineColorBlendState, Unit, Color> =
        MethodStringName1<RDPipelineColorBlendState, Unit, Color>("set_blend_constant")

    @JvmField
    public val getBlendConstantName: MethodStringName0<RDPipelineColorBlendState, Color> =
        MethodStringName0<RDPipelineColorBlendState, Color>("get_blend_constant")

    @JvmField
    public val setAttachmentsName:
        MethodStringName1<RDPipelineColorBlendState, Unit, VariantArray<RDPipelineColorBlendStateAttachment>>
        =
        MethodStringName1<RDPipelineColorBlendState, Unit, VariantArray<RDPipelineColorBlendStateAttachment>>("set_attachments")

    @JvmField
    public val getAttachmentsName:
        MethodStringName0<RDPipelineColorBlendState, VariantArray<RDPipelineColorBlendStateAttachment>>
        =
        MethodStringName0<RDPipelineColorBlendState, VariantArray<RDPipelineColorBlendStateAttachment>>("get_attachments")
  }

  public object MethodBindings {
    internal val setEnableLogicOpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendState", "set_enable_logic_op", 2586408642)

    internal val getEnableLogicOpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendState", "get_enable_logic_op", 36873697)

    internal val setLogicOpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendState", "set_logic_op", 3610841058)

    internal val getLogicOpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendState", "get_logic_op", 988254690)

    internal val setBlendConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendState", "set_blend_constant", 2920490490)

    internal val getBlendConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendState", "get_blend_constant", 3444240500)

    internal val setAttachmentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendState", "set_attachments", 381264803)

    internal val getAttachmentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendState", "get_attachments", 3995934104)
  }
}
