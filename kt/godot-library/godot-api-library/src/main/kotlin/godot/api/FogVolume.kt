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
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [FogVolume]s are used to add localized fog into the global volumetric fog effect. [FogVolume]s
 * can also remove volumetric fog from specific areas if using a [FogMaterial] with a negative
 * [FogMaterial.density].
 *
 * Performance of [FogVolume]s is directly related to their relative size on the screen and the
 * complexity of their attached [FogMaterial]. It is best to keep [FogVolume]s relatively small and
 * simple where possible.
 *
 * **Note:** [FogVolume]s only have a visible effect if [Environment.volumetricFogEnabled] is
 * `true`. If you don't want fog to be globally visible (but only within [FogVolume] nodes), set
 * [Environment.volumetricFogDensity] to `0.0`.
 */
@GodotBaseType
public open class FogVolume : VisualInstance3D() {
  /**
   * The size of the [FogVolume] when [shape] is [RenderingServer.FOG_VOLUME_SHAPE_ELLIPSOID],
   * [RenderingServer.FOG_VOLUME_SHAPE_CONE], [RenderingServer.FOG_VOLUME_SHAPE_CYLINDER] or
   * [RenderingServer.FOG_VOLUME_SHAPE_BOX].
   *
   * **Note:** Thin fog volumes may appear to flicker when the camera moves or rotates. This can be
   * alleviated by increasing [ProjectSettings.rendering/environment/volumetricFog/volumeDepth] (at a
   * performance cost) or by decreasing [Environment.volumetricFogLength] (at no performance cost, but
   * at the cost of lower fog range). Alternatively, the [FogVolume] can be made thicker and use a
   * lower density in the [material].
   *
   * **Note:** If [shape] is [RenderingServer.FOG_VOLUME_SHAPE_CONE] or
   * [RenderingServer.FOG_VOLUME_SHAPE_CYLINDER], the cone/cylinder will be adjusted to fit within the
   * size. Non-uniform scaling of cone/cylinder shapes via the [size] property is not supported, but
   * you can scale the [FogVolume] node instead.
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
   * The shape of the [FogVolume]. This can be set to either
   * [RenderingServer.FOG_VOLUME_SHAPE_ELLIPSOID], [RenderingServer.FOG_VOLUME_SHAPE_CONE],
   * [RenderingServer.FOG_VOLUME_SHAPE_CYLINDER], [RenderingServer.FOG_VOLUME_SHAPE_BOX] or
   * [RenderingServer.FOG_VOLUME_SHAPE_WORLD].
   */
  public final inline var shape: RenderingServer.FogVolumeShape
    @JvmName("shapeProperty")
    get() = getShape()
    @JvmName("shapeProperty")
    set(`value`) {
      setShape(value)
    }

  /**
   * The [Material] used by the [FogVolume]. Can be either a built-in [FogMaterial] or a custom
   * [ShaderMaterial].
   */
  public final inline var material: Material?
    @JvmName("materialProperty")
    get() = getMaterial()
    @JvmName("materialProperty")
    set(`value`) {
      setMaterial(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(230, scriptPtr)
  }

  /**
   * This is a helper function for [size] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = fogvolume.size
   * //Your changes
   * fogvolume.size = myCoreType
   * ``````
   *
   * The size of the [FogVolume] when [shape] is [RenderingServer.FOG_VOLUME_SHAPE_ELLIPSOID],
   * [RenderingServer.FOG_VOLUME_SHAPE_CONE], [RenderingServer.FOG_VOLUME_SHAPE_CYLINDER] or
   * [RenderingServer.FOG_VOLUME_SHAPE_BOX].
   *
   * **Note:** Thin fog volumes may appear to flicker when the camera moves or rotates. This can be
   * alleviated by increasing [ProjectSettings.rendering/environment/volumetricFog/volumeDepth] (at a
   * performance cost) or by decreasing [Environment.volumetricFogLength] (at no performance cost, but
   * at the cost of lower fog range). Alternatively, the [FogVolume] can be made thicker and use a
   * lower density in the [material].
   *
   * **Note:** If [shape] is [RenderingServer.FOG_VOLUME_SHAPE_CONE] or
   * [RenderingServer.FOG_VOLUME_SHAPE_CYLINDER], the cone/cylinder will be adjusted to fit within the
   * size. Non-uniform scaling of cone/cylinder shapes via the [size] property is not supported, but
   * you can scale the [FogVolume] node instead.
   */
  @CoreTypeHelper
  public final fun sizeMutate(block: Vector3.() -> Unit): Vector3 = size.apply {
     block(this)
     size = this
  }

  public final fun setSize(size: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to size)
    TransferContext.callMethod(MethodBindings.setSizePtr)
  }

  public final fun getSize(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSizePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setShape(shape: RenderingServer.FogVolumeShape): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to shape.value)
    TransferContext.callMethod(MethodBindings.setShapePtr)
  }

  public final fun getShape(): RenderingServer.FogVolumeShape {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShapePtr)
    return RenderingServer.FogVolumeShape.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setMaterial(material: Material?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to material)
    TransferContext.callMethod(MethodBindings.setMaterialPtr)
  }

  public final fun getMaterial(): Material? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaterialPtr)
    return (TransferContext.readReturnValue(OBJECT) as Material?)
  }

  public companion object {
    @JvmField
    public val setSizeName: MethodStringName1<FogVolume, Unit, Vector3> =
        MethodStringName1<FogVolume, Unit, Vector3>("set_size")

    @JvmField
    public val getSizeName: MethodStringName0<FogVolume, Vector3> =
        MethodStringName0<FogVolume, Vector3>("get_size")

    @JvmField
    public val setShapeName: MethodStringName1<FogVolume, Unit, RenderingServer.FogVolumeShape> =
        MethodStringName1<FogVolume, Unit, RenderingServer.FogVolumeShape>("set_shape")

    @JvmField
    public val getShapeName: MethodStringName0<FogVolume, RenderingServer.FogVolumeShape> =
        MethodStringName0<FogVolume, RenderingServer.FogVolumeShape>("get_shape")

    @JvmField
    public val setMaterialName: MethodStringName1<FogVolume, Unit, Material?> =
        MethodStringName1<FogVolume, Unit, Material?>("set_material")

    @JvmField
    public val getMaterialName: MethodStringName0<FogVolume, Material?> =
        MethodStringName0<FogVolume, Material?>("get_material")
  }

  public object MethodBindings {
    internal val setSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FogVolume", "set_size", 3460891852)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FogVolume", "get_size", 3360562783)

    internal val setShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FogVolume", "set_shape", 1416323362)

    internal val getShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FogVolume", "get_shape", 3920334604)

    internal val setMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FogVolume", "set_material", 2757459619)

    internal val getMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FogVolume", "get_material", 5934680)
  }
}
