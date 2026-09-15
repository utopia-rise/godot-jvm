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
import godot.core.Signal0
import godot.core.StringName
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING_NAME
import godot.core.asCachedStringName
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This class contains a dictionary that uses a list of bone names in [SkeletonProfile] as key
 * names.
 *
 * By assigning the actual [Skeleton3D] bone name as the key value, it maps the [Skeleton3D] to the
 * [SkeletonProfile].
 */
@GodotBaseType
public open class BoneMap : Resource() {
  /**
   * This signal is emitted when change the key value in the [BoneMap]. This is used to validate
   * mapping and to update [BoneMap] editor.
   */
  public val boneMapUpdated: Signal0 by Signal0

  /**
   * This signal is emitted when change the value in profile or change the reference of profile.
   * This is used to update key names in the [BoneMap] and to redraw the [BoneMap] editor.
   */
  public val profileUpdated: Signal0 by Signal0

  /**
   * A [SkeletonProfile] of the mapping target. Key names in the [BoneMap] are synchronized with it.
   */
  public final inline var profile: SkeletonProfile?
    @JvmName("profileProperty")
    get() = getProfile()
    @JvmName("profileProperty")
    set(`value`) {
      setProfile(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(112, scriptPtr)
  }

  public final fun getProfile(): SkeletonProfile? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProfilePtr)
    return (TransferContext.readReturnValue(OBJECT) as SkeletonProfile?)
  }

  public final fun setProfile(profile: SkeletonProfile?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to profile)
    TransferContext.callMethod(MethodBindings.setProfilePtr)
  }

  /**
   * Returns a skeleton bone name is mapped to [profileBoneName].
   *
   * In the retargeting process, the returned bone name is the bone name of the source skeleton.
   */
  public final fun getSkeletonBoneName(profileBoneName: StringName): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to profileBoneName)
    TransferContext.callMethod(MethodBindings.getSkeletonBoneNamePtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  /**
   * Maps a skeleton bone name to [profileBoneName].
   *
   * In the retargeting process, the setting bone name is the bone name of the source skeleton.
   */
  public final fun setSkeletonBoneName(profileBoneName: StringName, skeletonBoneName: StringName):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to profileBoneName, STRING_NAME to skeletonBoneName)
    TransferContext.callMethod(MethodBindings.setSkeletonBoneNamePtr)
  }

  /**
   * Returns a profile bone name having [skeletonBoneName]. If not found, an empty [StringName] will
   * be returned.
   *
   * In the retargeting process, the returned bone name is the bone name of the target skeleton.
   */
  public final fun findProfileBoneName(skeletonBoneName: StringName): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to skeletonBoneName)
    TransferContext.callMethod(MethodBindings.findProfileBoneNamePtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  /**
   * Returns a skeleton bone name is mapped to [profileBoneName].
   *
   * In the retargeting process, the returned bone name is the bone name of the source skeleton.
   */
  public final fun getSkeletonBoneName(profileBoneName: String): StringName =
      getSkeletonBoneName(profileBoneName.asCachedStringName())

  /**
   * Maps a skeleton bone name to [profileBoneName].
   *
   * In the retargeting process, the setting bone name is the bone name of the source skeleton.
   */
  public final fun setSkeletonBoneName(profileBoneName: String, skeletonBoneName: String) =
      setSkeletonBoneName(profileBoneName.asCachedStringName(), skeletonBoneName.asCachedStringName())

  /**
   * Returns a profile bone name having [skeletonBoneName]. If not found, an empty [StringName] will
   * be returned.
   *
   * In the retargeting process, the returned bone name is the bone name of the target skeleton.
   */
  public final fun findProfileBoneName(skeletonBoneName: String): StringName =
      findProfileBoneName(skeletonBoneName.asCachedStringName())

  public companion object {
    @JvmField
    public val getProfileName: MethodStringName0<BoneMap, SkeletonProfile?> =
        MethodStringName0<BoneMap, SkeletonProfile?>("get_profile")

    @JvmField
    public val setProfileName: MethodStringName1<BoneMap, Unit, SkeletonProfile?> =
        MethodStringName1<BoneMap, Unit, SkeletonProfile?>("set_profile")

    @JvmField
    public val getSkeletonBoneNameName: MethodStringName1<BoneMap, StringName, StringName> =
        MethodStringName1<BoneMap, StringName, StringName>("get_skeleton_bone_name")

    @JvmField
    public val setSkeletonBoneNameName: MethodStringName2<BoneMap, Unit, StringName, StringName> =
        MethodStringName2<BoneMap, Unit, StringName, StringName>("set_skeleton_bone_name")

    @JvmField
    public val findProfileBoneNameName: MethodStringName1<BoneMap, StringName, StringName> =
        MethodStringName1<BoneMap, StringName, StringName>("find_profile_bone_name")
  }

  public object MethodBindings {
    internal val getProfilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneMap", "get_profile", 4291782652)

    internal val setProfilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneMap", "set_profile", 3870374136)

    internal val getSkeletonBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneMap", "get_skeleton_bone_name", 1965194235)

    internal val setSkeletonBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneMap", "set_skeleton_bone_name", 3740211285)

    internal val findProfileBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneMap", "find_profile_bone_name", 1965194235)
  }
}
