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
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.Signal1
import godot.core.Signal2
import godot.core.StringName
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING_NAME
import godot.core.asCachedStringName
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * An animation library stores a set of animations accessible through [StringName] keys, for use
 * with [AnimationPlayer] nodes.
 */
@GodotBaseType
public open class AnimationLibrary : Resource() {
  /**
   * Emitted when an [Animation] is added, under the key [animName].
   */
  public val animationAdded: Signal1<StringName> by Signal1

  /**
   * Emitted when an [Animation] stored with the key [animName] is removed.
   */
  public val animationRemoved: Signal1<StringName> by Signal1

  /**
   * Emitted when the key for an [Animation] is changed, from [oldName] to [newName].
   */
  public val animationRenamed: Signal2<StringName, StringName> by Signal2

  /**
   * Emitted when there's a change in one of the animations, e.g. tracks are added, moved or have
   * changed paths. [animName] is the key of the animation that was changed.
   *
   * See also [signal Resource.changed], which this acts as a relay for.
   */
  public val animationChanged: Signal1<StringName> by Signal1

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(13, scriptPtr)
  }

  /**
   * Adds the [animation] to the library, accessible by the key [name].
   */
  public final fun addAnimation(name: StringName, animation: Animation?): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, OBJECT to animation)
    TransferContext.callMethod(MethodBindings.addAnimationPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Removes the [Animation] with the key [name].
   */
  public final fun removeAnimation(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.removeAnimationPtr)
  }

  /**
   * Changes the key of the [Animation] associated with the key [name] to [newname].
   */
  public final fun renameAnimation(name: StringName, newname: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, STRING_NAME to newname)
    TransferContext.callMethod(MethodBindings.renameAnimationPtr)
  }

  /**
   * Returns `true` if the library stores an [Animation] with [name] as the key.
   */
  public final fun hasAnimation(name: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.hasAnimationPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the [Animation] with the key [name]. If the animation does not exist, `null` is
   * returned and an error is logged.
   */
  public final fun getAnimation(name: StringName): Animation? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.getAnimationPtr)
    return (TransferContext.readReturnValue(OBJECT) as Animation?)
  }

  /**
   * Returns the keys for the [Animation]s stored in the library.
   */
  public final fun getAnimationList(): VariantArray<StringName> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAnimationListPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<StringName>)
  }

  /**
   * Returns the key count for the [Animation]s stored in the library.
   */
  public final fun getAnimationListSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAnimationListSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds the [animation] to the library, accessible by the key [name].
   */
  public final fun addAnimation(name: String, animation: Animation?): Error =
      addAnimation(name.asCachedStringName(), animation)

  /**
   * Removes the [Animation] with the key [name].
   */
  public final fun removeAnimation(name: String) = removeAnimation(name.asCachedStringName())

  /**
   * Changes the key of the [Animation] associated with the key [name] to [newname].
   */
  public final fun renameAnimation(name: String, newname: String) =
      renameAnimation(name.asCachedStringName(), newname.asCachedStringName())

  /**
   * Returns `true` if the library stores an [Animation] with [name] as the key.
   */
  public final fun hasAnimation(name: String): Boolean = hasAnimation(name.asCachedStringName())

  /**
   * Returns the [Animation] with the key [name]. If the animation does not exist, `null` is
   * returned and an error is logged.
   */
  public final fun getAnimation(name: String): Animation? = getAnimation(name.asCachedStringName())

  public companion object {
    @JvmField
    public val addAnimationName: MethodStringName2<AnimationLibrary, Error, StringName, Animation?>
        = MethodStringName2<AnimationLibrary, Error, StringName, Animation?>("add_animation")

    @JvmField
    public val removeAnimationName: MethodStringName1<AnimationLibrary, Unit, StringName> =
        MethodStringName1<AnimationLibrary, Unit, StringName>("remove_animation")

    @JvmField
    public val renameAnimationName:
        MethodStringName2<AnimationLibrary, Unit, StringName, StringName> =
        MethodStringName2<AnimationLibrary, Unit, StringName, StringName>("rename_animation")

    @JvmField
    public val hasAnimationName: MethodStringName1<AnimationLibrary, Boolean, StringName> =
        MethodStringName1<AnimationLibrary, Boolean, StringName>("has_animation")

    @JvmField
    public val getAnimationName: MethodStringName1<AnimationLibrary, Animation?, StringName> =
        MethodStringName1<AnimationLibrary, Animation?, StringName>("get_animation")

    @JvmField
    public val getAnimationListName: MethodStringName0<AnimationLibrary, VariantArray<StringName>> =
        MethodStringName0<AnimationLibrary, VariantArray<StringName>>("get_animation_list")

    @JvmField
    public val getAnimationListSizeName: MethodStringName0<AnimationLibrary, Int> =
        MethodStringName0<AnimationLibrary, Int>("get_animation_list_size")
  }

  public object MethodBindings {
    internal val addAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationLibrary", "add_animation", 1811855551)

    internal val removeAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationLibrary", "remove_animation", 3304788590)

    internal val renameAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationLibrary", "rename_animation", 3740211285)

    internal val hasAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationLibrary", "has_animation", 2619796661)

    internal val getAnimationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationLibrary", "get_animation", 2933122410)

    internal val getAnimationListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationLibrary", "get_animation_list", 3995934104)

    internal val getAnimationListSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AnimationLibrary", "get_animation_list_size", 3905245786)
  }
}
