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
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This node allows you to create a sphere for use with the CSG system.
 *
 * **Note:** CSG nodes are intended to be used for level prototyping. Creating CSG nodes has a
 * significant CPU cost compared to creating a [MeshInstance3D] with a [PrimitiveMesh]. Moving a CSG
 * node within another CSG node also has a significant CPU cost, so it should be avoided during
 * gameplay.
 */
@GodotBaseType
public open class CSGSphere3D : CSGPrimitive3D() {
  /**
   * Radius of the sphere.
   */
  public final inline var radius: Float
    @JvmName("radiusProperty")
    get() = getRadius()
    @JvmName("radiusProperty")
    set(`value`) {
      setRadius(value)
    }

  /**
   * Number of vertical slices for the sphere.
   */
  public final inline var radialSegments: Int
    @JvmName("radialSegmentsProperty")
    get() = getRadialSegments()
    @JvmName("radialSegmentsProperty")
    set(`value`) {
      setRadialSegments(value)
    }

  /**
   * Number of horizontal slices for the sphere.
   */
  public final inline var rings: Int
    @JvmName("ringsProperty")
    get() = getRings()
    @JvmName("ringsProperty")
    set(`value`) {
      setRings(value)
    }

  /**
   * If `true` the normals of the sphere are set to give a smooth effect making the sphere seem
   * rounded. If `false` the sphere will have a flat shaded look.
   */
  public final inline var smoothFaces: Boolean
    @JvmName("smoothFacesProperty")
    get() = getSmoothFaces()
    @JvmName("smoothFacesProperty")
    set(`value`) {
      setSmoothFaces(value)
    }

  /**
   * The material used to render the sphere.
   */
  public final inline var material: Material?
    @JvmName("materialProperty")
    get() = getMaterial()
    @JvmName("materialProperty")
    set(`value`) {
      setMaterial(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(130, scriptPtr)
  }

  public final fun setRadius(radius: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, radius.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setRadiusPtr, 0)
  }

  public final fun getRadius(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRadiusPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setRadialSegments(radialSegments: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, radialSegments.toLong())
    TransferContext.callPtrMethod(MethodBindings.setRadialSegmentsPtr, 0)
  }

  public final fun getRadialSegments(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRadialSegmentsPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setRings(rings: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, rings.toLong())
    TransferContext.callPtrMethod(MethodBindings.setRingsPtr, 0)
  }

  public final fun getRings(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRingsPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setSmoothFaces(smoothFaces: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, smoothFaces)
    TransferContext.callPtrMethod(MethodBindings.setSmoothFacesPtr, 0)
  }

  public final fun getSmoothFaces(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSmoothFacesPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setMaterial(material: Material?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, material)
    TransferContext.callPtrMethod(MethodBindings.setMaterialPtr, 0)
  }

  public final fun getMaterial(): Material? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMaterialPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Material?)
  }

  public companion object {
    @JvmField
    public val setRadiusName: MethodStringName1<CSGSphere3D, Unit, Float> =
        MethodStringName1<CSGSphere3D, Unit, Float>("set_radius")

    @JvmField
    public val getRadiusName: MethodStringName0<CSGSphere3D, Float> =
        MethodStringName0<CSGSphere3D, Float>("get_radius")

    @JvmField
    public val setRadialSegmentsName: MethodStringName1<CSGSphere3D, Unit, Int> =
        MethodStringName1<CSGSphere3D, Unit, Int>("set_radial_segments")

    @JvmField
    public val getRadialSegmentsName: MethodStringName0<CSGSphere3D, Int> =
        MethodStringName0<CSGSphere3D, Int>("get_radial_segments")

    @JvmField
    public val setRingsName: MethodStringName1<CSGSphere3D, Unit, Int> =
        MethodStringName1<CSGSphere3D, Unit, Int>("set_rings")

    @JvmField
    public val getRingsName: MethodStringName0<CSGSphere3D, Int> =
        MethodStringName0<CSGSphere3D, Int>("get_rings")

    @JvmField
    public val setSmoothFacesName: MethodStringName1<CSGSphere3D, Unit, Boolean> =
        MethodStringName1<CSGSphere3D, Unit, Boolean>("set_smooth_faces")

    @JvmField
    public val getSmoothFacesName: MethodStringName0<CSGSphere3D, Boolean> =
        MethodStringName0<CSGSphere3D, Boolean>("get_smooth_faces")

    @JvmField
    public val setMaterialName: MethodStringName1<CSGSphere3D, Unit, Material?> =
        MethodStringName1<CSGSphere3D, Unit, Material?>("set_material")

    @JvmField
    public val getMaterialName: MethodStringName0<CSGSphere3D, Material?> =
        MethodStringName0<CSGSphere3D, Material?>("get_material")
  }

  public object MethodBindings {
    internal val setRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGSphere3D", "set_radius", 373806689)

    internal val getRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGSphere3D", "get_radius", 1740695150)

    internal val setRadialSegmentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGSphere3D", "set_radial_segments", 1286410249)

    internal val getRadialSegmentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGSphere3D", "get_radial_segments", 3905245786)

    internal val setRingsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGSphere3D", "set_rings", 1286410249)

    internal val getRingsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGSphere3D", "get_rings", 3905245786)

    internal val setSmoothFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGSphere3D", "set_smooth_faces", 2586408642)

    internal val getSmoothFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGSphere3D", "get_smooth_faces", 36873697)

    internal val setMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGSphere3D", "set_material", 2757459619)

    internal val getMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGSphere3D", "get_material", 5934680)
  }
}
