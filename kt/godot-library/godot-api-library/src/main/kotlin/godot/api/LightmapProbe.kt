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
 * [LightmapProbe] represents the position of a single manually placed probe for dynamic object
 * lighting with [LightmapGI]. Lightmap probes affect the lighting of [GeometryInstance3D]-derived
 * nodes that have their [GeometryInstance3D.giMode] set to [GeometryInstance3D.GI_MODE_DYNAMIC].
 *
 * Typically, [LightmapGI] probes are placed automatically by setting
 * [LightmapGI.generateProbesSubdiv] to a value other than [LightmapGI.GENERATE_PROBES_DISABLED]. By
 * creating [LightmapProbe] nodes before baking lightmaps, you can add more probes in specific areas
 * for greater detail, or disable automatic generation and rely only on manually placed probes instead.
 *
 * **Note:** [LightmapProbe] nodes that are placed after baking lightmaps are ignored by dynamic
 * objects. You must bake lightmaps again after creating or modifying [LightmapProbe]s for the probes
 * to be effective.
 */
@GodotBaseType
public open class LightmapProbe : Node3D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(356, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
