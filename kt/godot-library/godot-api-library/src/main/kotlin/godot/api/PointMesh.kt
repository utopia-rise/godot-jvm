// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import kotlin.Suppress
import kotlin.Unit

/**
 * A [PointMesh] is a primitive mesh composed of a single point. Instead of relying on triangles,
 * points are rendered as a single rectangle on the screen with a constant size. They are intended to
 * be used with particle systems, but can also be used as a cheap way to render billboarded sprites
 * (for example in a point cloud).
 *
 * In order to be displayed, point meshes must be used with a material that has a point size. The
 * point size can be accessed in a shader with the `POINT_SIZE` built-in, or in a [BaseMaterial3D] by
 * setting the [BaseMaterial3D.usePointSize] and [BaseMaterial3D.pointSize] properties.
 *
 * **Note:** When using point meshes, properties that normally affect vertices will be ignored,
 * including [BaseMaterial3D.billboardMode], [BaseMaterial3D.grow], and [BaseMaterial3D.cullMode].
 */
@GodotBaseType
public open class PointMesh : PrimitiveMesh() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(561, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
