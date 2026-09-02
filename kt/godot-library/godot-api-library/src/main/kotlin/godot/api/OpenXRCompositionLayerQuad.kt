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
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * An OpenXR composition layer that allows rendering a [SubViewport] on a quad.
 */
@GodotBaseType
public open class OpenXRCompositionLayerQuad : OpenXRCompositionLayer() {
  /**
   * The dimensions of the quad.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var quadSize: Vector2
    @JvmName("quadSizeProperty")
    get() = getQuadSize()
    @JvmName("quadSizeProperty")
    set(`value`) {
      setQuadSize(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(449, scriptPtr)
  }

  /**
   * This is a helper function for [quadSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = openxrcompositionlayerquad.quadSize
   * //Your changes
   * openxrcompositionlayerquad.quadSize = myCoreType
   * ``````
   *
   * The dimensions of the quad.
   */
  @CoreTypeHelper
  public final fun quadSizeMutate(block: Vector2.() -> Unit): Vector2 = quadSize.apply {
     block(this)
     quadSize = this
  }

  public final fun setQuadSize(size: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to size)
    TransferContext.callMethod(MethodBindings.setQuadSizePtr)
  }

  public final fun getQuadSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getQuadSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public companion object {
    @JvmField
    public val setQuadSizeName: MethodStringName1<OpenXRCompositionLayerQuad, Unit, Vector2> =
        MethodStringName1<OpenXRCompositionLayerQuad, Unit, Vector2>("set_quad_size")

    @JvmField
    public val getQuadSizeName: MethodStringName0<OpenXRCompositionLayerQuad, Vector2> =
        MethodStringName0<OpenXRCompositionLayerQuad, Vector2>("get_quad_size")
  }

  public object MethodBindings {
    internal val setQuadSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerQuad", "set_quad_size", 743155724)

    internal val getQuadSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRCompositionLayerQuad", "get_quad_size", 3341600327)
  }
}
