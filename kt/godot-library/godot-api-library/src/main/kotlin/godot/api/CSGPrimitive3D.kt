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
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Parent class for various CSG primitives. It contains code and functionality that is common
 * between them. It cannot be used directly. Instead use one of the various classes that inherit from
 * it.
 *
 * **Note:** CSG nodes are intended to be used for level prototyping. Creating CSG nodes has a
 * significant CPU cost compared to creating a [MeshInstance3D] with a [PrimitiveMesh]. Moving a CSG
 * node within another CSG node also has a significant CPU cost, so it should be avoided during
 * gameplay.
 */
@GodotBaseType
public open class CSGPrimitive3D internal constructor() : CSGShape3D() {
  /**
   * If set, the order of the vertices in each triangle are reversed resulting in the backside of
   * the mesh being drawn.
   */
  public final inline var flipFaces: Boolean
    @JvmName("flipFacesProperty")
    get() = getFlipFaces()
    @JvmName("flipFacesProperty")
    set(`value`) {
      setFlipFaces(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(128, scriptPtr)
  }

  public final fun setFlipFaces(flipFaces: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to flipFaces)
    TransferContext.callMethod(MethodBindings.setFlipFacesPtr)
  }

  public final fun getFlipFaces(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFlipFacesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val setFlipFacesName: MethodStringName1<CSGPrimitive3D, Unit, Boolean> =
        MethodStringName1<CSGPrimitive3D, Unit, Boolean>("set_flip_faces")

    @JvmField
    public val getFlipFacesName: MethodStringName0<CSGPrimitive3D, Boolean> =
        MethodStringName0<CSGPrimitive3D, Boolean>("get_flip_faces")
  }

  public object MethodBindings {
    internal val setFlipFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGPrimitive3D", "set_flip_faces", 2586408642)

    internal val getFlipFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGPrimitive3D", "get_flip_faces", 2240911060)
  }
}
