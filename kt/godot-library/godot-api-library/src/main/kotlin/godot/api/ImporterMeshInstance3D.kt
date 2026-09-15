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
import godot.core.NodePath
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.NODE_PATH
import godot.core.VariantParser.OBJECT
import godot.core.asCachedNodePath
import kotlin.Double
import kotlin.Float
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

@GodotBaseType
public open class ImporterMeshInstance3D : Node3D() {
  public final inline var mesh: ImporterMesh?
    @JvmName("meshProperty")
    get() = getMesh()
    @JvmName("meshProperty")
    set(`value`) {
      setMesh(value)
    }

  public final inline var skin: Skin?
    @JvmName("skinProperty")
    get() = getSkin()
    @JvmName("skinProperty")
    set(`value`) {
      setSkin(value)
    }

  public final inline var skeletonPath: NodePath
    @JvmName("skeletonPathProperty")
    get() = getSkeletonPath()
    @JvmName("skeletonPathProperty")
    set(`value`) {
      setSkeletonPath(value)
    }

  public final inline var layerMask: Long
    @JvmName("layerMaskProperty")
    get() = getLayerMask()
    @JvmName("layerMaskProperty")
    set(`value`) {
      setLayerMask(value)
    }

  public final inline var castShadow: GeometryInstance3D.ShadowCastingSetting
    @JvmName("castShadowProperty")
    get() = getCastShadowsSetting()
    @JvmName("castShadowProperty")
    set(`value`) {
      setCastShadowsSetting(value)
    }

  public final inline var visibilityRangeBegin: Float
    @JvmName("visibilityRangeBeginProperty")
    get() = getVisibilityRangeBegin()
    @JvmName("visibilityRangeBeginProperty")
    set(`value`) {
      setVisibilityRangeBegin(value)
    }

  public final inline var visibilityRangeBeginMargin: Float
    @JvmName("visibilityRangeBeginMarginProperty")
    get() = getVisibilityRangeBeginMargin()
    @JvmName("visibilityRangeBeginMarginProperty")
    set(`value`) {
      setVisibilityRangeBeginMargin(value)
    }

  public final inline var visibilityRangeEnd: Float
    @JvmName("visibilityRangeEndProperty")
    get() = getVisibilityRangeEnd()
    @JvmName("visibilityRangeEndProperty")
    set(`value`) {
      setVisibilityRangeEnd(value)
    }

  public final inline var visibilityRangeEndMargin: Float
    @JvmName("visibilityRangeEndMarginProperty")
    get() = getVisibilityRangeEndMargin()
    @JvmName("visibilityRangeEndMarginProperty")
    set(`value`) {
      setVisibilityRangeEndMargin(value)
    }

  public final inline var visibilityRangeFadeMode: GeometryInstance3D.VisibilityRangeFadeMode
    @JvmName("visibilityRangeFadeModeProperty")
    get() = getVisibilityRangeFadeMode()
    @JvmName("visibilityRangeFadeModeProperty")
    set(`value`) {
      setVisibilityRangeFadeMode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(306, scriptPtr)
  }

  public final fun setMesh(mesh: ImporterMesh?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to mesh)
    TransferContext.callMethod(MethodBindings.setMeshPtr)
  }

  public final fun getMesh(): ImporterMesh? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMeshPtr)
    return (TransferContext.readReturnValue(OBJECT) as ImporterMesh?)
  }

  public final fun setSkin(skin: Skin?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to skin)
    TransferContext.callMethod(MethodBindings.setSkinPtr)
  }

  public final fun getSkin(): Skin? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkinPtr)
    return (TransferContext.readReturnValue(OBJECT) as Skin?)
  }

  public final fun setSkeletonPath(skeletonPath: NodePath): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, NODE_PATH to skeletonPath)
    TransferContext.callMethod(MethodBindings.setSkeletonPathPtr)
  }

  public final fun getSkeletonPath(): NodePath {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkeletonPathPtr)
    return (TransferContext.readReturnValue(NODE_PATH) as NodePath)
  }

  public final fun setLayerMask(layerMask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layerMask)
    TransferContext.callMethod(MethodBindings.setLayerMaskPtr)
  }

  public final fun getLayerMask(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLayerMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final
      fun setCastShadowsSetting(shadowCastingSetting: GeometryInstance3D.ShadowCastingSetting):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to shadowCastingSetting.value)
    TransferContext.callMethod(MethodBindings.setCastShadowsSettingPtr)
  }

  public final fun getCastShadowsSetting(): GeometryInstance3D.ShadowCastingSetting {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCastShadowsSettingPtr)
    return GeometryInstance3D.ShadowCastingSetting.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setVisibilityRangeEndMargin(distance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to distance.toDouble())
    TransferContext.callMethod(MethodBindings.setVisibilityRangeEndMarginPtr)
  }

  public final fun getVisibilityRangeEndMargin(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibilityRangeEndMarginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVisibilityRangeEnd(distance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to distance.toDouble())
    TransferContext.callMethod(MethodBindings.setVisibilityRangeEndPtr)
  }

  public final fun getVisibilityRangeEnd(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibilityRangeEndPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVisibilityRangeBeginMargin(distance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to distance.toDouble())
    TransferContext.callMethod(MethodBindings.setVisibilityRangeBeginMarginPtr)
  }

  public final fun getVisibilityRangeBeginMargin(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibilityRangeBeginMarginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVisibilityRangeBegin(distance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to distance.toDouble())
    TransferContext.callMethod(MethodBindings.setVisibilityRangeBeginPtr)
  }

  public final fun getVisibilityRangeBegin(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibilityRangeBeginPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVisibilityRangeFadeMode(mode: GeometryInstance3D.VisibilityRangeFadeMode):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setVisibilityRangeFadeModePtr)
  }

  public final fun getVisibilityRangeFadeMode(): GeometryInstance3D.VisibilityRangeFadeMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibilityRangeFadeModePtr)
    return GeometryInstance3D.VisibilityRangeFadeMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSkeletonPath(skeletonPath: String) =
      setSkeletonPath(skeletonPath.asCachedNodePath())

  public companion object {
    @JvmField
    public val setMeshName: MethodStringName1<ImporterMeshInstance3D, Unit, ImporterMesh?> =
        MethodStringName1<ImporterMeshInstance3D, Unit, ImporterMesh?>("set_mesh")

    @JvmField
    public val getMeshName: MethodStringName0<ImporterMeshInstance3D, ImporterMesh?> =
        MethodStringName0<ImporterMeshInstance3D, ImporterMesh?>("get_mesh")

    @JvmField
    public val setSkinName: MethodStringName1<ImporterMeshInstance3D, Unit, Skin?> =
        MethodStringName1<ImporterMeshInstance3D, Unit, Skin?>("set_skin")

    @JvmField
    public val getSkinName: MethodStringName0<ImporterMeshInstance3D, Skin?> =
        MethodStringName0<ImporterMeshInstance3D, Skin?>("get_skin")

    @JvmField
    public val setSkeletonPathName: MethodStringName1<ImporterMeshInstance3D, Unit, NodePath> =
        MethodStringName1<ImporterMeshInstance3D, Unit, NodePath>("set_skeleton_path")

    @JvmField
    public val getSkeletonPathName: MethodStringName0<ImporterMeshInstance3D, NodePath> =
        MethodStringName0<ImporterMeshInstance3D, NodePath>("get_skeleton_path")

    @JvmField
    public val setLayerMaskName: MethodStringName1<ImporterMeshInstance3D, Unit, Long> =
        MethodStringName1<ImporterMeshInstance3D, Unit, Long>("set_layer_mask")

    @JvmField
    public val getLayerMaskName: MethodStringName0<ImporterMeshInstance3D, Long> =
        MethodStringName0<ImporterMeshInstance3D, Long>("get_layer_mask")

    @JvmField
    public val setCastShadowsSettingName:
        MethodStringName1<ImporterMeshInstance3D, Unit, GeometryInstance3D.ShadowCastingSetting> =
        MethodStringName1<ImporterMeshInstance3D, Unit, GeometryInstance3D.ShadowCastingSetting>("set_cast_shadows_setting")

    @JvmField
    public val getCastShadowsSettingName:
        MethodStringName0<ImporterMeshInstance3D, GeometryInstance3D.ShadowCastingSetting> =
        MethodStringName0<ImporterMeshInstance3D, GeometryInstance3D.ShadowCastingSetting>("get_cast_shadows_setting")

    @JvmField
    public val setVisibilityRangeEndMarginName:
        MethodStringName1<ImporterMeshInstance3D, Unit, Float> =
        MethodStringName1<ImporterMeshInstance3D, Unit, Float>("set_visibility_range_end_margin")

    @JvmField
    public val getVisibilityRangeEndMarginName: MethodStringName0<ImporterMeshInstance3D, Float> =
        MethodStringName0<ImporterMeshInstance3D, Float>("get_visibility_range_end_margin")

    @JvmField
    public val setVisibilityRangeEndName: MethodStringName1<ImporterMeshInstance3D, Unit, Float> =
        MethodStringName1<ImporterMeshInstance3D, Unit, Float>("set_visibility_range_end")

    @JvmField
    public val getVisibilityRangeEndName: MethodStringName0<ImporterMeshInstance3D, Float> =
        MethodStringName0<ImporterMeshInstance3D, Float>("get_visibility_range_end")

    @JvmField
    public val setVisibilityRangeBeginMarginName:
        MethodStringName1<ImporterMeshInstance3D, Unit, Float> =
        MethodStringName1<ImporterMeshInstance3D, Unit, Float>("set_visibility_range_begin_margin")

    @JvmField
    public val getVisibilityRangeBeginMarginName: MethodStringName0<ImporterMeshInstance3D, Float> =
        MethodStringName0<ImporterMeshInstance3D, Float>("get_visibility_range_begin_margin")

    @JvmField
    public val setVisibilityRangeBeginName: MethodStringName1<ImporterMeshInstance3D, Unit, Float> =
        MethodStringName1<ImporterMeshInstance3D, Unit, Float>("set_visibility_range_begin")

    @JvmField
    public val getVisibilityRangeBeginName: MethodStringName0<ImporterMeshInstance3D, Float> =
        MethodStringName0<ImporterMeshInstance3D, Float>("get_visibility_range_begin")

    @JvmField
    public val setVisibilityRangeFadeModeName:
        MethodStringName1<ImporterMeshInstance3D, Unit, GeometryInstance3D.VisibilityRangeFadeMode>
        =
        MethodStringName1<ImporterMeshInstance3D, Unit, GeometryInstance3D.VisibilityRangeFadeMode>("set_visibility_range_fade_mode")

    @JvmField
    public val getVisibilityRangeFadeModeName:
        MethodStringName0<ImporterMeshInstance3D, GeometryInstance3D.VisibilityRangeFadeMode> =
        MethodStringName0<ImporterMeshInstance3D, GeometryInstance3D.VisibilityRangeFadeMode>("get_visibility_range_fade_mode")
  }

  public object MethodBindings {
    internal val setMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "set_mesh", 2255166972)

    internal val getMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "get_mesh", 3161779525)

    internal val setSkinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "set_skin", 3971435618)

    internal val getSkinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "get_skin", 2074563878)

    internal val setSkeletonPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "set_skeleton_path", 1348162250)

    internal val getSkeletonPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "get_skeleton_path", 4075236667)

    internal val setLayerMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "set_layer_mask", 1286410249)

    internal val getLayerMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "get_layer_mask", 3905245786)

    internal val setCastShadowsSettingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "set_cast_shadows_setting", 856677339)

    internal val getCastShadowsSettingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "get_cast_shadows_setting", 3383019359)

    internal val setVisibilityRangeEndMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "set_visibility_range_end_margin", 373806689)

    internal val getVisibilityRangeEndMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "get_visibility_range_end_margin", 1740695150)

    internal val setVisibilityRangeEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "set_visibility_range_end", 373806689)

    internal val getVisibilityRangeEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "get_visibility_range_end", 1740695150)

    internal val setVisibilityRangeBeginMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "set_visibility_range_begin_margin", 373806689)

    internal val getVisibilityRangeBeginMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "get_visibility_range_begin_margin", 1740695150)

    internal val setVisibilityRangeBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "set_visibility_range_begin", 373806689)

    internal val getVisibilityRangeBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "get_visibility_range_begin", 1740695150)

    internal val setVisibilityRangeFadeModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "set_visibility_range_fade_mode", 1440117808)

    internal val getVisibilityRangeFadeModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImporterMeshInstance3D", "get_visibility_range_fade_mode", 2067221882)
  }
}
