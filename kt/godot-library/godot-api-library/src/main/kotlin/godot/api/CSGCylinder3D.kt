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
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This node allows you to create a cylinder (or cone) for use with the CSG system.
 *
 * **Note:** CSG nodes are intended to be used for level prototyping. Creating CSG nodes has a
 * significant CPU cost compared to creating a [MeshInstance3D] with a [PrimitiveMesh]. Moving a CSG
 * node within another CSG node also has a significant CPU cost, so it should be avoided during
 * gameplay.
 */
@GodotBaseType
public open class CSGCylinder3D : CSGPrimitive3D() {
  /**
   * The radius of the cylinder.
   */
  public final inline var radius: Float
    @JvmName("radiusProperty")
    get() = getRadius()
    @JvmName("radiusProperty")
    set(`value`) {
      setRadius(value)
    }

  /**
   * The height of the cylinder.
   */
  public final inline var height: Float
    @JvmName("heightProperty")
    get() = getHeight()
    @JvmName("heightProperty")
    set(`value`) {
      setHeight(value)
    }

  /**
   * The number of sides of the cylinder, the higher this number the more detail there will be in
   * the cylinder.
   */
  public final inline var sides: Int
    @JvmName("sidesProperty")
    get() = getSides()
    @JvmName("sidesProperty")
    set(`value`) {
      setSides(value)
    }

  /**
   * If `true` a cone is created, the [radius] will only apply to one side.
   */
  public final inline var cone: Boolean
    @JvmName("coneProperty")
    get() = isCone()
    @JvmName("coneProperty")
    set(`value`) {
      setCone(value)
    }

  /**
   * If `true` the normals of the cylinder are set to give a smooth effect making the cylinder seem
   * rounded. If `false` the cylinder will have a flat shaded look.
   */
  public final inline var smoothFaces: Boolean
    @JvmName("smoothFacesProperty")
    get() = getSmoothFaces()
    @JvmName("smoothFacesProperty")
    set(`value`) {
      setSmoothFaces(value)
    }

  /**
   * The material used to render the cylinder.
   */
  public final inline var material: Material?
    @JvmName("materialProperty")
    get() = getMaterial()
    @JvmName("materialProperty")
    set(`value`) {
      setMaterial(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(125, scriptPtr)
  }

  public final fun setRadius(radius: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to radius.toDouble())
    TransferContext.callMethod(MethodBindings.setRadiusPtr)
  }

  public final fun getRadius(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRadiusPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setHeight(height: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to height.toDouble())
    TransferContext.callMethod(MethodBindings.setHeightPtr)
  }

  public final fun getHeight(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHeightPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSides(sides: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to sides.toLong())
    TransferContext.callMethod(MethodBindings.setSidesPtr)
  }

  public final fun getSides(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSidesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setCone(cone: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to cone)
    TransferContext.callMethod(MethodBindings.setConePtr)
  }

  public final fun isCone(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isConePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
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

  public final fun setSmoothFaces(smoothFaces: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to smoothFaces)
    TransferContext.callMethod(MethodBindings.setSmoothFacesPtr)
  }

  public final fun getSmoothFaces(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSmoothFacesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val setRadiusName: MethodStringName1<CSGCylinder3D, Unit, Float> =
        MethodStringName1<CSGCylinder3D, Unit, Float>("set_radius")

    @JvmField
    public val getRadiusName: MethodStringName0<CSGCylinder3D, Float> =
        MethodStringName0<CSGCylinder3D, Float>("get_radius")

    @JvmField
    public val setHeightName: MethodStringName1<CSGCylinder3D, Unit, Float> =
        MethodStringName1<CSGCylinder3D, Unit, Float>("set_height")

    @JvmField
    public val getHeightName: MethodStringName0<CSGCylinder3D, Float> =
        MethodStringName0<CSGCylinder3D, Float>("get_height")

    @JvmField
    public val setSidesName: MethodStringName1<CSGCylinder3D, Unit, Int> =
        MethodStringName1<CSGCylinder3D, Unit, Int>("set_sides")

    @JvmField
    public val getSidesName: MethodStringName0<CSGCylinder3D, Int> =
        MethodStringName0<CSGCylinder3D, Int>("get_sides")

    @JvmField
    public val setConeName: MethodStringName1<CSGCylinder3D, Unit, Boolean> =
        MethodStringName1<CSGCylinder3D, Unit, Boolean>("set_cone")

    @JvmField
    public val isConeName: MethodStringName0<CSGCylinder3D, Boolean> =
        MethodStringName0<CSGCylinder3D, Boolean>("is_cone")

    @JvmField
    public val setMaterialName: MethodStringName1<CSGCylinder3D, Unit, Material?> =
        MethodStringName1<CSGCylinder3D, Unit, Material?>("set_material")

    @JvmField
    public val getMaterialName: MethodStringName0<CSGCylinder3D, Material?> =
        MethodStringName0<CSGCylinder3D, Material?>("get_material")

    @JvmField
    public val setSmoothFacesName: MethodStringName1<CSGCylinder3D, Unit, Boolean> =
        MethodStringName1<CSGCylinder3D, Unit, Boolean>("set_smooth_faces")

    @JvmField
    public val getSmoothFacesName: MethodStringName0<CSGCylinder3D, Boolean> =
        MethodStringName0<CSGCylinder3D, Boolean>("get_smooth_faces")
  }

  public object MethodBindings {
    internal val setRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGCylinder3D", "set_radius", 373806689)

    internal val getRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGCylinder3D", "get_radius", 1740695150)

    internal val setHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGCylinder3D", "set_height", 373806689)

    internal val getHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGCylinder3D", "get_height", 1740695150)

    internal val setSidesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGCylinder3D", "set_sides", 1286410249)

    internal val getSidesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGCylinder3D", "get_sides", 3905245786)

    internal val setConePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGCylinder3D", "set_cone", 2586408642)

    internal val isConePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGCylinder3D", "is_cone", 36873697)

    internal val setMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGCylinder3D", "set_material", 2757459619)

    internal val getMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGCylinder3D", "get_material", 5934680)

    internal val setSmoothFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGCylinder3D", "set_smooth_faces", 2586408642)

    internal val getSmoothFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGCylinder3D", "get_smooth_faces", 36873697)
  }
}
