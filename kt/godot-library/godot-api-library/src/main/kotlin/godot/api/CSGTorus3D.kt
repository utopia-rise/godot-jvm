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
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_OBJECT
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This node allows you to create a torus for use with the CSG system.
 *
 * **Note:** CSG nodes are intended to be used for level prototyping. Creating CSG nodes has a
 * significant CPU cost compared to creating a [MeshInstance3D] with a [PrimitiveMesh]. Moving a CSG
 * node within another CSG node also has a significant CPU cost, so it should be avoided during
 * gameplay.
 */
@GodotBaseType
public open class CSGTorus3D : CSGPrimitive3D() {
  /**
   * The inner radius of the torus.
   */
  public final inline var innerRadius: Float
    @JvmName("innerRadiusProperty")
    get() = getInnerRadius()
    @JvmName("innerRadiusProperty")
    set(`value`) {
      setInnerRadius(value)
    }

  /**
   * The outer radius of the torus.
   */
  public final inline var outerRadius: Float
    @JvmName("outerRadiusProperty")
    get() = getOuterRadius()
    @JvmName("outerRadiusProperty")
    set(`value`) {
      setOuterRadius(value)
    }

  /**
   * The number of slices the torus is constructed of.
   */
  public final inline var sides: Int
    @JvmName("sidesProperty")
    get() = getSides()
    @JvmName("sidesProperty")
    set(`value`) {
      setSides(value)
    }

  /**
   * The number of edges each ring of the torus is constructed of.
   */
  public final inline var ringSides: Int
    @JvmName("ringSidesProperty")
    get() = getRingSides()
    @JvmName("ringSidesProperty")
    set(`value`) {
      setRingSides(value)
    }

  /**
   * If `true` the normals of the torus are set to give a smooth effect making the torus seem
   * rounded. If `false` the torus will have a flat shaded look.
   */
  public final inline var smoothFaces: Boolean
    @JvmName("smoothFacesProperty")
    get() = getSmoothFaces()
    @JvmName("smoothFacesProperty")
    set(`value`) {
      setSmoothFaces(value)
    }

  /**
   * The material used to render the torus.
   */
  public final inline var material: Material?
    @JvmName("materialProperty")
    get() = getMaterial()
    @JvmName("materialProperty")
    set(`value`) {
      setMaterial(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(131, scriptPtr)
  }

  public final fun setInnerRadius(radius: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setInnerRadiusPtr, radius.toDouble())
  }

  public final fun getInnerRadius(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getInnerRadiusPtr).toFloat()

  public final fun setOuterRadius(radius: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setOuterRadiusPtr, radius.toDouble())
  }

  public final fun getOuterRadius(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getOuterRadiusPtr).toFloat()

  public final fun setSides(sides: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setSidesPtr, sides.toLong())
  }

  public final fun getSides(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getSidesPtr).toInt()

  public final fun setRingSides(sides: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setRingSidesPtr, sides.toLong())
  }

  public final fun getRingSides(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getRingSidesPtr).toInt()

  public final fun setMaterial(material: Material?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setMaterialPtr, material)
  }

  public final fun getMaterial(): Material? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getMaterialPtr) as Material?)

  public final fun setSmoothFaces(smoothFaces: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setSmoothFacesPtr, smoothFaces)
  }

  public final fun getSmoothFaces(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getSmoothFacesPtr)

  public companion object {
    @JvmField
    public val setInnerRadiusName: MethodStringName1<CSGTorus3D, Unit, Float> =
        MethodStringName1<CSGTorus3D, Unit, Float>("set_inner_radius")

    @JvmField
    public val getInnerRadiusName: MethodStringName0<CSGTorus3D, Float> =
        MethodStringName0<CSGTorus3D, Float>("get_inner_radius")

    @JvmField
    public val setOuterRadiusName: MethodStringName1<CSGTorus3D, Unit, Float> =
        MethodStringName1<CSGTorus3D, Unit, Float>("set_outer_radius")

    @JvmField
    public val getOuterRadiusName: MethodStringName0<CSGTorus3D, Float> =
        MethodStringName0<CSGTorus3D, Float>("get_outer_radius")

    @JvmField
    public val setSidesName: MethodStringName1<CSGTorus3D, Unit, Int> =
        MethodStringName1<CSGTorus3D, Unit, Int>("set_sides")

    @JvmField
    public val getSidesName: MethodStringName0<CSGTorus3D, Int> =
        MethodStringName0<CSGTorus3D, Int>("get_sides")

    @JvmField
    public val setRingSidesName: MethodStringName1<CSGTorus3D, Unit, Int> =
        MethodStringName1<CSGTorus3D, Unit, Int>("set_ring_sides")

    @JvmField
    public val getRingSidesName: MethodStringName0<CSGTorus3D, Int> =
        MethodStringName0<CSGTorus3D, Int>("get_ring_sides")

    @JvmField
    public val setMaterialName: MethodStringName1<CSGTorus3D, Unit, Material?> =
        MethodStringName1<CSGTorus3D, Unit, Material?>("set_material")

    @JvmField
    public val getMaterialName: MethodStringName0<CSGTorus3D, Material?> =
        MethodStringName0<CSGTorus3D, Material?>("get_material")

    @JvmField
    public val setSmoothFacesName: MethodStringName1<CSGTorus3D, Unit, Boolean> =
        MethodStringName1<CSGTorus3D, Unit, Boolean>("set_smooth_faces")

    @JvmField
    public val getSmoothFacesName: MethodStringName0<CSGTorus3D, Boolean> =
        MethodStringName0<CSGTorus3D, Boolean>("get_smooth_faces")
  }

  public object MethodBindings {
    internal val setInnerRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGTorus3D", "set_inner_radius", 373806689)

    internal val getInnerRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGTorus3D", "get_inner_radius", 1740695150)

    internal val setOuterRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGTorus3D", "set_outer_radius", 373806689)

    internal val getOuterRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGTorus3D", "get_outer_radius", 1740695150)

    internal val setSidesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGTorus3D", "set_sides", 1286410249)

    internal val getSidesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGTorus3D", "get_sides", 3905245786)

    internal val setRingSidesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGTorus3D", "set_ring_sides", 1286410249)

    internal val getRingSidesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGTorus3D", "get_ring_sides", 3905245786)

    internal val setMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGTorus3D", "set_material", 2757459619)

    internal val getMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGTorus3D", "get_material", 5934680)

    internal val setSmoothFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGTorus3D", "set_smooth_faces", 2586408642)

    internal val getSmoothFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGTorus3D", "get_smooth_faces", 36873697)
  }
}
