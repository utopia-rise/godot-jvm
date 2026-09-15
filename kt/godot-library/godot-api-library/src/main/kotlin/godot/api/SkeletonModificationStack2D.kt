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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_DOUBLE_LONG
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_OBJECT
import godot.writeMethodArguments_OBJECT
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This resource is used by the Skeleton and holds a stack of [SkeletonModification2D]s.
 *
 * This controls the order of the modifications and how they are applied. Modification order is
 * especially important for full-body IK setups, as you need to execute the modifications in the
 * correct order to get the desired results. For example, you want to execute a modification on the
 * spine *before* the arms on a humanoid skeleton.
 *
 * This resource also controls how strongly all of the modifications are applied to the
 * [Skeleton2D].
 */
@GodotBaseType
public open class SkeletonModificationStack2D : Resource() {
  /**
   * If `true`, the modification's in the stack will be called. This is handled automatically
   * through the [Skeleton2D] node.
   */
  public final inline var enabled: Boolean
    @JvmName("enabledProperty")
    get() = getEnabled()
    @JvmName("enabledProperty")
    set(`value`) {
      setEnabled(value)
    }

  /**
   * The interpolation strength of the modifications in stack. A value of `0` will make it where the
   * modifications are not applied, a strength of `0.5` will be half applied, and a strength of `1`
   * will allow the modifications to be fully applied and override the [Skeleton2D] [Bone2D] poses.
   */
  public final inline var strength: Float
    @JvmName("strengthProperty")
    get() = getStrength()
    @JvmName("strengthProperty")
    set(`value`) {
      setStrength(value)
    }

  /**
   * The number of modifications in the stack.
   */
  public final inline var modificationCount: Int
    @JvmName("modificationCountProperty")
    get() = getModificationCount()
    @JvmName("modificationCountProperty")
    set(`value`) {
      setModificationCount(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(675, scriptPtr)
  }

  /**
   * Sets up the modification stack so it can execute. This function should be called by
   * [Skeleton2D] and shouldn't be manually called unless you know what you are doing.
   */
  public final fun setup(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.setupPtr)
  }

  /**
   * Executes all of the [SkeletonModification2D]s in the stack that use the same execution mode as
   * the passed-in [executionMode], starting from index `0` to [modificationCount].
   *
   * **Note:** The order of the modifications can matter depending on the modifications. For
   * example, modifications on a spine should operate before modifications on the arms in order to get
   * proper results.
   */
  public final fun execute(delta: Float, executionMode: Int): Unit {
    TransferContext.writeMethodArguments_DOUBLE_LONG(ptr, objectID.id, delta.toDouble(), executionMode.toLong())
    TransferContext.callMethod(MethodBindings.executePtr)
  }

  /**
   * Enables all [SkeletonModification2D]s in the stack.
   */
  public final fun enableAllModifications(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.enableAllModificationsPtr)
  }

  /**
   * Returns the [SkeletonModification2D] at the passed-in index, [modIdx].
   */
  public final fun getModification(modIdx: Int): SkeletonModification2D? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, modIdx.toLong())
    TransferContext.callMethod(MethodBindings.getModificationPtr)
    return (TransferContext.readReturnValue_OBJECT() as SkeletonModification2D?)
  }

  /**
   * Adds the passed-in [SkeletonModification2D] to the stack.
   */
  public final fun addModification(modification: SkeletonModification2D?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, modification)
    TransferContext.callMethod(MethodBindings.addModificationPtr)
  }

  /**
   * Deletes the [SkeletonModification2D] at the index position [modIdx], if it exists.
   */
  public final fun deleteModification(modIdx: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, modIdx.toLong())
    TransferContext.callMethod(MethodBindings.deleteModificationPtr)
  }

  /**
   * Sets the modification at [modIdx] to the passed-in modification, [modification].
   */
  public final fun setModification(modIdx: Int, modification: SkeletonModification2D?): Unit {
    TransferContext.writeMethodArguments_LONG_OBJECT(ptr, objectID.id, modIdx.toLong(), modification)
    TransferContext.callMethod(MethodBindings.setModificationPtr)
  }

  public final fun setModificationCount(count: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, count.toLong())
    TransferContext.callMethod(MethodBindings.setModificationCountPtr)
  }

  public final fun getModificationCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getModificationCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns a boolean that indicates whether the modification stack is setup and can execute.
   */
  public final fun getIsSetup(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIsSetupPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setEnabledPtr)
  }

  public final fun getEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setStrength(strength: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, strength.toDouble())
    TransferContext.callMethod(MethodBindings.setStrengthPtr)
  }

  public final fun getStrength(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStrengthPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the [Skeleton2D] node that the SkeletonModificationStack2D is bound to.
   */
  public final fun getSkeleton(): Skeleton2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkeletonPtr)
    return (TransferContext.readReturnValue_OBJECT() as Skeleton2D?)
  }

  public companion object {
    @JvmField
    public val setupName: MethodStringName0<SkeletonModificationStack2D, Unit> =
        MethodStringName0<SkeletonModificationStack2D, Unit>("setup")

    @JvmField
    public val executeName: MethodStringName2<SkeletonModificationStack2D, Unit, Float, Int> =
        MethodStringName2<SkeletonModificationStack2D, Unit, Float, Int>("execute")

    @JvmField
    public val enableAllModificationsName:
        MethodStringName1<SkeletonModificationStack2D, Unit, Boolean> =
        MethodStringName1<SkeletonModificationStack2D, Unit, Boolean>("enable_all_modifications")

    @JvmField
    public val getModificationName:
        MethodStringName1<SkeletonModificationStack2D, SkeletonModification2D?, Int> =
        MethodStringName1<SkeletonModificationStack2D, SkeletonModification2D?, Int>("get_modification")

    @JvmField
    public val addModificationName:
        MethodStringName1<SkeletonModificationStack2D, Unit, SkeletonModification2D?> =
        MethodStringName1<SkeletonModificationStack2D, Unit, SkeletonModification2D?>("add_modification")

    @JvmField
    public val deleteModificationName: MethodStringName1<SkeletonModificationStack2D, Unit, Int> =
        MethodStringName1<SkeletonModificationStack2D, Unit, Int>("delete_modification")

    @JvmField
    public val setModificationName:
        MethodStringName2<SkeletonModificationStack2D, Unit, Int, SkeletonModification2D?> =
        MethodStringName2<SkeletonModificationStack2D, Unit, Int, SkeletonModification2D?>("set_modification")

    @JvmField
    public val setModificationCountName: MethodStringName1<SkeletonModificationStack2D, Unit, Int> =
        MethodStringName1<SkeletonModificationStack2D, Unit, Int>("set_modification_count")

    @JvmField
    public val getModificationCountName: MethodStringName0<SkeletonModificationStack2D, Int> =
        MethodStringName0<SkeletonModificationStack2D, Int>("get_modification_count")

    @JvmField
    public val getIsSetupName: MethodStringName0<SkeletonModificationStack2D, Boolean> =
        MethodStringName0<SkeletonModificationStack2D, Boolean>("get_is_setup")

    @JvmField
    public val setEnabledName: MethodStringName1<SkeletonModificationStack2D, Unit, Boolean> =
        MethodStringName1<SkeletonModificationStack2D, Unit, Boolean>("set_enabled")

    @JvmField
    public val getEnabledName: MethodStringName0<SkeletonModificationStack2D, Boolean> =
        MethodStringName0<SkeletonModificationStack2D, Boolean>("get_enabled")

    @JvmField
    public val setStrengthName: MethodStringName1<SkeletonModificationStack2D, Unit, Float> =
        MethodStringName1<SkeletonModificationStack2D, Unit, Float>("set_strength")

    @JvmField
    public val getStrengthName: MethodStringName0<SkeletonModificationStack2D, Float> =
        MethodStringName0<SkeletonModificationStack2D, Float>("get_strength")

    @JvmField
    public val getSkeletonName: MethodStringName0<SkeletonModificationStack2D, Skeleton2D?> =
        MethodStringName0<SkeletonModificationStack2D, Skeleton2D?>("get_skeleton")
  }

  public object MethodBindings {
    internal val setupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModificationStack2D", "setup", 3218959716)

    internal val executePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModificationStack2D", "execute", 1005356550)

    internal val enableAllModificationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModificationStack2D", "enable_all_modifications", 2586408642)

    internal val getModificationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModificationStack2D", "get_modification", 2570274329)

    internal val addModificationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModificationStack2D", "add_modification", 354162120)

    internal val deleteModificationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModificationStack2D", "delete_modification", 1286410249)

    internal val setModificationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModificationStack2D", "set_modification", 1098262544)

    internal val setModificationCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModificationStack2D", "set_modification_count", 1286410249)

    internal val getModificationCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModificationStack2D", "get_modification_count", 3905245786)

    internal val getIsSetupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModificationStack2D", "get_is_setup", 36873697)

    internal val setEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModificationStack2D", "set_enabled", 2586408642)

    internal val getEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModificationStack2D", "get_enabled", 36873697)

    internal val setStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModificationStack2D", "set_strength", 373806689)

    internal val getStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModificationStack2D", "get_strength", 1740695150)

    internal val getSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModificationStack2D", "get_skeleton", 1697361217)
  }
}
