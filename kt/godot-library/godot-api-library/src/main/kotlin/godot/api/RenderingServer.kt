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
import godot.core.AABB
import godot.core.Basis
import godot.core.BitFieldBase
import godot.core.Callable
import godot.core.Color
import godot.core.Dictionary
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName10
import godot.core.MethodStringName11
import godot.core.MethodStringName13
import godot.core.MethodStringName14
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.MethodStringName6
import godot.core.MethodStringName7
import godot.core.MethodStringName8
import godot.core.MethodStringName9
import godot.core.PackedByteArray
import godot.core.PackedColorArray
import godot.core.PackedFloat32Array
import godot.core.PackedInt32Array
import godot.core.PackedInt64Array
import godot.core.PackedVector2Array
import godot.core.PackedVector3Array
import godot.core.Plane
import godot.core.RID
import godot.core.Rect2
import godot.core.Rect2i
import godot.core.Signal0
import godot.core.StringName
import godot.core.Transform2D
import godot.core.Transform3D
import godot.core.VariantArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BASIS
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.CALLABLE
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_BYTE_ARRAY
import godot.core.VariantParser.PACKED_COLOR_ARRAY
import godot.core.VariantParser.PACKED_FLOAT_32_ARRAY
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.PACKED_INT_64_ARRAY
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.VariantParser.PACKED_VECTOR3_ARRAY
import godot.core.VariantParser.RECT2
import godot.core.VariantParser.RECT2I
import godot.core.VariantParser.STRING
import godot.core.VariantParser.STRING_NAME
import godot.core.VariantParser.TRANSFORM2D
import godot.core.VariantParser.TRANSFORM3D
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR2I
import godot.core.VariantParser.VECTOR3
import godot.core.VariantParser.VECTOR3I
import godot.core.VariantParser._RID
import godot.core.Vector2
import godot.core.Vector2i
import godot.core.Vector3
import godot.core.Vector3i
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

public infix fun Long.or(other: RenderingServer.ArrayFormat): Long = this.or(other.flag)

public infix fun Long.xor(other: RenderingServer.ArrayFormat): Long = this.xor(other.flag)

public infix fun Long.and(other: RenderingServer.ArrayFormat): Long = this.and(other.flag)

/**
 * The rendering server is the API backend for everything visible. The whole scene system mounts on
 * it to display. The rendering server is completely opaque: the internals are entirely
 * implementation-specific and cannot be accessed.
 *
 * The rendering server can be used to bypass the scene/[Node] system entirely. This can improve
 * performance in cases where the scene system is the bottleneck, but won't improve performance
 * otherwise (for instance, if the GPU is already fully utilized).
 *
 * Resources are created using the `*_create` functions. These functions return [RID]s which are not
 * references to the objects themselves, but opaque *pointers* towards these objects.
 *
 * All objects are drawn to a viewport. You can use the [Viewport] attached to the [SceneTree] or
 * you can create one yourself with [viewportCreate]. When using a custom scenario or canvas, the
 * scenario or canvas needs to be attached to the viewport using [viewportSetScenario] or
 * [viewportAttachCanvas].
 *
 * **Scenarios:** In 3D, all visual objects must be associated with a scenario. The scenario is a
 * visual representation of the world. If accessing the rendering server from a running game, the
 * scenario can be accessed from the scene tree from any [Node3D] node with [Node3D.getWorld3d].
 * Otherwise, a scenario can be created with [scenarioCreate].
 *
 * Similarly, in 2D, a canvas is needed to draw all canvas items.
 *
 * **3D:** In 3D, all visible objects are comprised of a resource and an instance. A resource can be
 * a mesh, a particle system, a light, or any other 3D object. In order to be visible resources must be
 * attached to an instance using [instanceSetBase]. The instance must also be attached to the scenario
 * using [instanceSetScenario] in order to be visible. RenderingServer methods that don't have a prefix
 * are usually 3D-specific (but not always).
 *
 * **2D:** In 2D, all visible objects are some form of canvas item. In order to be visible, a canvas
 * item needs to be the child of a canvas attached to a viewport, or it needs to be the child of
 * another canvas item that is eventually attached to the canvas. 2D-specific RenderingServer methods
 * generally start with `canvas_*`.
 *
 * **Headless mode:** Starting the engine with the `--headless`
 * [url=$DOCS_URL/tutorials/editor/command_line_tutorial.html]command line argument[/url] disables all
 * rendering and window management functions. Most functions from [RenderingServer] will return dummy
 * values in this case.
 */
@GodotBaseType
public object RenderingServer : Object() {
  @JvmField
  public val texture2dCreateName: MethodStringName1<RenderingServer, RID, Image?> =
      MethodStringName1<RenderingServer, RID, Image?>("texture_2d_create")

  @JvmField
  public val texture2dLayeredCreateName:
      MethodStringName2<RenderingServer, RID, VariantArray<Image>, TextureLayeredType> =
      MethodStringName2<RenderingServer, RID, VariantArray<Image>, TextureLayeredType>("texture_2d_layered_create")

  @JvmField
  public val texture3dCreateName:
      MethodStringName6<RenderingServer, RID, Image.Format, Int, Int, Int, Boolean, VariantArray<Image>>
      =
      MethodStringName6<RenderingServer, RID, Image.Format, Int, Int, Int, Boolean, VariantArray<Image>>("texture_3d_create")

  @JvmField
  public val textureProxyCreateName: MethodStringName1<RenderingServer, RID, RID> =
      MethodStringName1<RenderingServer, RID, RID>("texture_proxy_create")

  @JvmField
  public val textureCreateFromNativeHandleName:
      MethodStringName8<RenderingServer, RID, TextureType, Image.Format, Long, Int, Int, Int, Int, TextureLayeredType>
      =
      MethodStringName8<RenderingServer, RID, TextureType, Image.Format, Long, Int, Int, Int, Int, TextureLayeredType>("texture_create_from_native_handle")

  @JvmField
  public val textureDrawableCreateName:
      MethodStringName5<RenderingServer, RID, Int, Int, TextureDrawableFormat, Color, Boolean> =
      MethodStringName5<RenderingServer, RID, Int, Int, TextureDrawableFormat, Color, Boolean>("texture_drawable_create")

  @JvmField
  public val texture2dUpdateName: MethodStringName3<RenderingServer, Unit, RID, Image?, Int> =
      MethodStringName3<RenderingServer, Unit, RID, Image?, Int>("texture_2d_update")

  @JvmField
  public val texture3dUpdateName: MethodStringName2<RenderingServer, Unit, RID, VariantArray<Image>>
      = MethodStringName2<RenderingServer, Unit, RID, VariantArray<Image>>("texture_3d_update")

  @JvmField
  public val textureProxyUpdateName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("texture_proxy_update")

  @JvmField
  public val textureDrawableBlitRectName:
      MethodStringName6<RenderingServer, Unit, VariantArray<RID>, Rect2i, RID, Color, VariantArray<RID>, Int>
      =
      MethodStringName6<RenderingServer, Unit, VariantArray<RID>, Rect2i, RID, Color, VariantArray<RID>, Int>("texture_drawable_blit_rect")

  @JvmField
  public val texture2dPlaceholderCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("texture_2d_placeholder_create")

  @JvmField
  public val texture2dLayeredPlaceholderCreateName:
      MethodStringName1<RenderingServer, RID, TextureLayeredType> =
      MethodStringName1<RenderingServer, RID, TextureLayeredType>("texture_2d_layered_placeholder_create")

  @JvmField
  public val texture3dPlaceholderCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("texture_3d_placeholder_create")

  @JvmField
  public val texture2dGetName: MethodStringName1<RenderingServer, Image?, RID> =
      MethodStringName1<RenderingServer, Image?, RID>("texture_2d_get")

  @JvmField
  public val texture2dLayerGetName: MethodStringName2<RenderingServer, Image?, RID, Int> =
      MethodStringName2<RenderingServer, Image?, RID, Int>("texture_2d_layer_get")

  @JvmField
  public val texture3dGetName: MethodStringName1<RenderingServer, VariantArray<Image>, RID> =
      MethodStringName1<RenderingServer, VariantArray<Image>, RID>("texture_3d_get")

  @JvmField
  public val textureDrawableGenerateMipmapsName: MethodStringName1<RenderingServer, Unit, RID> =
      MethodStringName1<RenderingServer, Unit, RID>("texture_drawable_generate_mipmaps")

  @JvmField
  public val textureDrawableGetDefaultMaterialName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("texture_drawable_get_default_material")

  @JvmField
  public val textureReplaceName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("texture_replace")

  @JvmField
  public val textureSetSizeOverrideName: MethodStringName3<RenderingServer, Unit, RID, Int, Int> =
      MethodStringName3<RenderingServer, Unit, RID, Int, Int>("texture_set_size_override")

  @JvmField
  public val textureSetPathName: MethodStringName2<RenderingServer, Unit, RID, String> =
      MethodStringName2<RenderingServer, Unit, RID, String>("texture_set_path")

  @JvmField
  public val textureGetPathName: MethodStringName1<RenderingServer, String, RID> =
      MethodStringName1<RenderingServer, String, RID>("texture_get_path")

  @JvmField
  public val textureGetFormatName: MethodStringName1<RenderingServer, Image.Format, RID> =
      MethodStringName1<RenderingServer, Image.Format, RID>("texture_get_format")

  @JvmField
  public val textureSetForceRedrawIfVisibleName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("texture_set_force_redraw_if_visible")

  @JvmField
  public val textureRdCreateName: MethodStringName2<RenderingServer, RID, RID, TextureLayeredType> =
      MethodStringName2<RenderingServer, RID, RID, TextureLayeredType>("texture_rd_create")

  @JvmField
  public val textureGetRdTextureName: MethodStringName2<RenderingServer, RID, RID, Boolean> =
      MethodStringName2<RenderingServer, RID, RID, Boolean>("texture_get_rd_texture")

  @JvmField
  public val textureGetNativeHandleName: MethodStringName2<RenderingServer, Long, RID, Boolean> =
      MethodStringName2<RenderingServer, Long, RID, Boolean>("texture_get_native_handle")

  @JvmField
  public val shaderCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("shader_create")

  @JvmField
  public val shaderSetCodeName: MethodStringName2<RenderingServer, Unit, RID, String> =
      MethodStringName2<RenderingServer, Unit, RID, String>("shader_set_code")

  @JvmField
  public val shaderSetPathHintName: MethodStringName2<RenderingServer, Unit, RID, String> =
      MethodStringName2<RenderingServer, Unit, RID, String>("shader_set_path_hint")

  @JvmField
  public val shaderGetCodeName: MethodStringName1<RenderingServer, String, RID> =
      MethodStringName1<RenderingServer, String, RID>("shader_get_code")

  @JvmField
  public val getShaderParameterListName:
      MethodStringName1<RenderingServer, VariantArray<Dictionary<Any?, Any?>>, RID> =
      MethodStringName1<RenderingServer, VariantArray<Dictionary<Any?, Any?>>, RID>("get_shader_parameter_list")

  @JvmField
  public val shaderGetParameterDefaultName:
      MethodStringName2<RenderingServer, Any?, RID, StringName> =
      MethodStringName2<RenderingServer, Any?, RID, StringName>("shader_get_parameter_default")

  @JvmField
  public val shaderSetDefaultTextureParameterName:
      MethodStringName4<RenderingServer, Unit, RID, StringName, RID, Int> =
      MethodStringName4<RenderingServer, Unit, RID, StringName, RID, Int>("shader_set_default_texture_parameter")

  @JvmField
  public val shaderGetDefaultTextureParameterName:
      MethodStringName3<RenderingServer, RID, RID, StringName, Int> =
      MethodStringName3<RenderingServer, RID, RID, StringName, Int>("shader_get_default_texture_parameter")

  @JvmField
  public val materialCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("material_create")

  @JvmField
  public val materialSetShaderName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("material_set_shader")

  @JvmField
  public val materialSetParamName: MethodStringName3<RenderingServer, Unit, RID, StringName, Any?> =
      MethodStringName3<RenderingServer, Unit, RID, StringName, Any?>("material_set_param")

  @JvmField
  public val materialGetParamName: MethodStringName2<RenderingServer, Any?, RID, StringName> =
      MethodStringName2<RenderingServer, Any?, RID, StringName>("material_get_param")

  @JvmField
  public val materialSetRenderPriorityName: MethodStringName2<RenderingServer, Unit, RID, Int> =
      MethodStringName2<RenderingServer, Unit, RID, Int>("material_set_render_priority")

  @JvmField
  public val materialSetNextPassName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("material_set_next_pass")

  @JvmField
  public val materialSetUseDebandingName: MethodStringName1<RenderingServer, Unit, Boolean> =
      MethodStringName1<RenderingServer, Unit, Boolean>("material_set_use_debanding")

  @JvmField
  public val meshCreateFromSurfacesName:
      MethodStringName2<RenderingServer, RID, VariantArray<Dictionary<Any?, Any?>>, Int> =
      MethodStringName2<RenderingServer, RID, VariantArray<Dictionary<Any?, Any?>>, Int>("mesh_create_from_surfaces")

  @JvmField
  public val meshCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("mesh_create")

  @JvmField
  public val meshSurfaceGetFormatOffsetName:
      MethodStringName3<RenderingServer, Long, ArrayFormat, Int, Int> =
      MethodStringName3<RenderingServer, Long, ArrayFormat, Int, Int>("mesh_surface_get_format_offset")

  @JvmField
  public val meshSurfaceGetFormatVertexStrideName:
      MethodStringName2<RenderingServer, Long, ArrayFormat, Int> =
      MethodStringName2<RenderingServer, Long, ArrayFormat, Int>("mesh_surface_get_format_vertex_stride")

  @JvmField
  public val meshSurfaceGetFormatNormalTangentStrideName:
      MethodStringName2<RenderingServer, Long, ArrayFormat, Int> =
      MethodStringName2<RenderingServer, Long, ArrayFormat, Int>("mesh_surface_get_format_normal_tangent_stride")

  @JvmField
  public val meshSurfaceGetFormatAttributeStrideName:
      MethodStringName2<RenderingServer, Long, ArrayFormat, Int> =
      MethodStringName2<RenderingServer, Long, ArrayFormat, Int>("mesh_surface_get_format_attribute_stride")

  @JvmField
  public val meshSurfaceGetFormatSkinStrideName:
      MethodStringName2<RenderingServer, Long, ArrayFormat, Int> =
      MethodStringName2<RenderingServer, Long, ArrayFormat, Int>("mesh_surface_get_format_skin_stride")

  @JvmField
  public val meshSurfaceGetFormatIndexStrideName:
      MethodStringName2<RenderingServer, Long, ArrayFormat, Int> =
      MethodStringName2<RenderingServer, Long, ArrayFormat, Int>("mesh_surface_get_format_index_stride")

  @JvmField
  public val meshAddSurfaceName:
      MethodStringName2<RenderingServer, Unit, RID, Dictionary<Any?, Any?>> =
      MethodStringName2<RenderingServer, Unit, RID, Dictionary<Any?, Any?>>("mesh_add_surface")

  @JvmField
  public val meshAddSurfaceFromArraysName:
      MethodStringName6<RenderingServer, Unit, RID, PrimitiveType, VariantArray<Any?>, VariantArray<Any?>, Dictionary<Any?, Any?>, ArrayFormat>
      =
      MethodStringName6<RenderingServer, Unit, RID, PrimitiveType, VariantArray<Any?>, VariantArray<Any?>, Dictionary<Any?, Any?>, ArrayFormat>("mesh_add_surface_from_arrays")

  @JvmField
  public val meshGetBlendShapeCountName: MethodStringName1<RenderingServer, Int, RID> =
      MethodStringName1<RenderingServer, Int, RID>("mesh_get_blend_shape_count")

  @JvmField
  public val meshSetBlendShapeModeName:
      MethodStringName2<RenderingServer, Unit, RID, BlendShapeMode> =
      MethodStringName2<RenderingServer, Unit, RID, BlendShapeMode>("mesh_set_blend_shape_mode")

  @JvmField
  public val meshGetBlendShapeModeName: MethodStringName1<RenderingServer, BlendShapeMode, RID> =
      MethodStringName1<RenderingServer, BlendShapeMode, RID>("mesh_get_blend_shape_mode")

  @JvmField
  public val meshSurfaceSetMaterialName: MethodStringName3<RenderingServer, Unit, RID, Int, RID> =
      MethodStringName3<RenderingServer, Unit, RID, Int, RID>("mesh_surface_set_material")

  @JvmField
  public val meshSurfaceGetMaterialName: MethodStringName2<RenderingServer, RID, RID, Int> =
      MethodStringName2<RenderingServer, RID, RID, Int>("mesh_surface_get_material")

  @JvmField
  public val meshGetSurfaceName:
      MethodStringName2<RenderingServer, Dictionary<Any?, Any?>, RID, Int> =
      MethodStringName2<RenderingServer, Dictionary<Any?, Any?>, RID, Int>("mesh_get_surface")

  @JvmField
  public val meshSurfaceGetArraysName:
      MethodStringName2<RenderingServer, VariantArray<Any?>, RID, Int> =
      MethodStringName2<RenderingServer, VariantArray<Any?>, RID, Int>("mesh_surface_get_arrays")

  @JvmField
  public val meshSurfaceGetBlendShapeArraysName:
      MethodStringName2<RenderingServer, VariantArray<VariantArray<Any?>>, RID, Int> =
      MethodStringName2<RenderingServer, VariantArray<VariantArray<Any?>>, RID, Int>("mesh_surface_get_blend_shape_arrays")

  @JvmField
  public val meshGetSurfaceCountName: MethodStringName1<RenderingServer, Int, RID> =
      MethodStringName1<RenderingServer, Int, RID>("mesh_get_surface_count")

  @JvmField
  public val meshSetCustomAabbName: MethodStringName2<RenderingServer, Unit, RID, AABB> =
      MethodStringName2<RenderingServer, Unit, RID, AABB>("mesh_set_custom_aabb")

  @JvmField
  public val meshGetCustomAabbName: MethodStringName1<RenderingServer, AABB, RID> =
      MethodStringName1<RenderingServer, AABB, RID>("mesh_get_custom_aabb")

  @JvmField
  public val meshSurfaceRemoveName: MethodStringName2<RenderingServer, Unit, RID, Int> =
      MethodStringName2<RenderingServer, Unit, RID, Int>("mesh_surface_remove")

  @JvmField
  public val meshClearName: MethodStringName1<RenderingServer, Unit, RID> =
      MethodStringName1<RenderingServer, Unit, RID>("mesh_clear")

  @JvmField
  public val meshSurfaceUpdateVertexRegionName:
      MethodStringName4<RenderingServer, Unit, RID, Int, Int, PackedByteArray> =
      MethodStringName4<RenderingServer, Unit, RID, Int, Int, PackedByteArray>("mesh_surface_update_vertex_region")

  @JvmField
  public val meshSurfaceUpdateAttributeRegionName:
      MethodStringName4<RenderingServer, Unit, RID, Int, Int, PackedByteArray> =
      MethodStringName4<RenderingServer, Unit, RID, Int, Int, PackedByteArray>("mesh_surface_update_attribute_region")

  @JvmField
  public val meshSurfaceUpdateSkinRegionName:
      MethodStringName4<RenderingServer, Unit, RID, Int, Int, PackedByteArray> =
      MethodStringName4<RenderingServer, Unit, RID, Int, Int, PackedByteArray>("mesh_surface_update_skin_region")

  @JvmField
  public val meshSurfaceUpdateIndexRegionName:
      MethodStringName4<RenderingServer, Unit, RID, Int, Int, PackedByteArray> =
      MethodStringName4<RenderingServer, Unit, RID, Int, Int, PackedByteArray>("mesh_surface_update_index_region")

  @JvmField
  public val meshSetShadowMeshName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("mesh_set_shadow_mesh")

  @JvmField
  public val multimeshCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("multimesh_create")

  @JvmField
  public val multimeshAllocateDataName:
      MethodStringName6<RenderingServer, Unit, RID, Int, MultimeshTransformFormat, Boolean, Boolean, Boolean>
      =
      MethodStringName6<RenderingServer, Unit, RID, Int, MultimeshTransformFormat, Boolean, Boolean, Boolean>("multimesh_allocate_data")

  @JvmField
  public val multimeshGetInstanceCountName: MethodStringName1<RenderingServer, Int, RID> =
      MethodStringName1<RenderingServer, Int, RID>("multimesh_get_instance_count")

  @JvmField
  public val multimeshSetMeshName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("multimesh_set_mesh")

  @JvmField
  public val multimeshInstanceSetTransformName:
      MethodStringName3<RenderingServer, Unit, RID, Int, Transform3D> =
      MethodStringName3<RenderingServer, Unit, RID, Int, Transform3D>("multimesh_instance_set_transform")

  @JvmField
  public val multimeshInstanceSetTransform2dName:
      MethodStringName3<RenderingServer, Unit, RID, Int, Transform2D> =
      MethodStringName3<RenderingServer, Unit, RID, Int, Transform2D>("multimesh_instance_set_transform_2d")

  @JvmField
  public val multimeshInstanceSetColorName:
      MethodStringName3<RenderingServer, Unit, RID, Int, Color> =
      MethodStringName3<RenderingServer, Unit, RID, Int, Color>("multimesh_instance_set_color")

  @JvmField
  public val multimeshInstanceSetCustomDataName:
      MethodStringName3<RenderingServer, Unit, RID, Int, Color> =
      MethodStringName3<RenderingServer, Unit, RID, Int, Color>("multimesh_instance_set_custom_data")

  @JvmField
  public val multimeshGetMeshName: MethodStringName1<RenderingServer, RID, RID> =
      MethodStringName1<RenderingServer, RID, RID>("multimesh_get_mesh")

  @JvmField
  public val multimeshGetAabbName: MethodStringName1<RenderingServer, AABB, RID> =
      MethodStringName1<RenderingServer, AABB, RID>("multimesh_get_aabb")

  @JvmField
  public val multimeshSetCustomAabbName: MethodStringName2<RenderingServer, Unit, RID, AABB> =
      MethodStringName2<RenderingServer, Unit, RID, AABB>("multimesh_set_custom_aabb")

  @JvmField
  public val multimeshGetCustomAabbName: MethodStringName1<RenderingServer, AABB, RID> =
      MethodStringName1<RenderingServer, AABB, RID>("multimesh_get_custom_aabb")

  @JvmField
  public val multimeshInstanceGetTransformName:
      MethodStringName2<RenderingServer, Transform3D, RID, Int> =
      MethodStringName2<RenderingServer, Transform3D, RID, Int>("multimesh_instance_get_transform")

  @JvmField
  public val multimeshInstanceGetTransform2dName:
      MethodStringName2<RenderingServer, Transform2D, RID, Int> =
      MethodStringName2<RenderingServer, Transform2D, RID, Int>("multimesh_instance_get_transform_2d")

  @JvmField
  public val multimeshInstanceGetColorName: MethodStringName2<RenderingServer, Color, RID, Int> =
      MethodStringName2<RenderingServer, Color, RID, Int>("multimesh_instance_get_color")

  @JvmField
  public val multimeshInstanceGetCustomDataName: MethodStringName2<RenderingServer, Color, RID, Int>
      = MethodStringName2<RenderingServer, Color, RID, Int>("multimesh_instance_get_custom_data")

  @JvmField
  public val multimeshSetVisibleInstancesName: MethodStringName2<RenderingServer, Unit, RID, Int> =
      MethodStringName2<RenderingServer, Unit, RID, Int>("multimesh_set_visible_instances")

  @JvmField
  public val multimeshGetVisibleInstancesName: MethodStringName1<RenderingServer, Int, RID> =
      MethodStringName1<RenderingServer, Int, RID>("multimesh_get_visible_instances")

  @JvmField
  public val multimeshSetBufferName:
      MethodStringName2<RenderingServer, Unit, RID, PackedFloat32Array> =
      MethodStringName2<RenderingServer, Unit, RID, PackedFloat32Array>("multimesh_set_buffer")

  @JvmField
  public val multimeshGetCommandBufferRdRidName: MethodStringName1<RenderingServer, RID, RID> =
      MethodStringName1<RenderingServer, RID, RID>("multimesh_get_command_buffer_rd_rid")

  @JvmField
  public val multimeshGetBufferRdRidName: MethodStringName1<RenderingServer, RID, RID> =
      MethodStringName1<RenderingServer, RID, RID>("multimesh_get_buffer_rd_rid")

  @JvmField
  public val multimeshGetBufferName: MethodStringName1<RenderingServer, PackedFloat32Array, RID> =
      MethodStringName1<RenderingServer, PackedFloat32Array, RID>("multimesh_get_buffer")

  @JvmField
  public val multimeshSetBufferInterpolatedName:
      MethodStringName3<RenderingServer, Unit, RID, PackedFloat32Array, PackedFloat32Array> =
      MethodStringName3<RenderingServer, Unit, RID, PackedFloat32Array, PackedFloat32Array>("multimesh_set_buffer_interpolated")

  @JvmField
  public val multimeshSetPhysicsInterpolatedName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("multimesh_set_physics_interpolated")

  @JvmField
  public val multimeshSetPhysicsInterpolationQualityName:
      MethodStringName2<RenderingServer, Unit, RID, MultimeshPhysicsInterpolationQuality> =
      MethodStringName2<RenderingServer, Unit, RID, MultimeshPhysicsInterpolationQuality>("multimesh_set_physics_interpolation_quality")

  @JvmField
  public val multimeshInstanceResetPhysicsInterpolationName:
      MethodStringName2<RenderingServer, Unit, RID, Int> =
      MethodStringName2<RenderingServer, Unit, RID, Int>("multimesh_instance_reset_physics_interpolation")

  @JvmField
  public val multimeshInstancesResetPhysicsInterpolationName:
      MethodStringName1<RenderingServer, Unit, RID> =
      MethodStringName1<RenderingServer, Unit, RID>("multimesh_instances_reset_physics_interpolation")

  @JvmField
  public val skeletonCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("skeleton_create")

  @JvmField
  public val skeletonAllocateDataName: MethodStringName3<RenderingServer, Unit, RID, Int, Boolean> =
      MethodStringName3<RenderingServer, Unit, RID, Int, Boolean>("skeleton_allocate_data")

  @JvmField
  public val skeletonGetBoneCountName: MethodStringName1<RenderingServer, Int, RID> =
      MethodStringName1<RenderingServer, Int, RID>("skeleton_get_bone_count")

  @JvmField
  public val skeletonBoneSetTransformName:
      MethodStringName3<RenderingServer, Unit, RID, Int, Transform3D> =
      MethodStringName3<RenderingServer, Unit, RID, Int, Transform3D>("skeleton_bone_set_transform")

  @JvmField
  public val skeletonBoneGetTransformName: MethodStringName2<RenderingServer, Transform3D, RID, Int>
      = MethodStringName2<RenderingServer, Transform3D, RID, Int>("skeleton_bone_get_transform")

  @JvmField
  public val skeletonBoneSetTransform2dName:
      MethodStringName3<RenderingServer, Unit, RID, Int, Transform2D> =
      MethodStringName3<RenderingServer, Unit, RID, Int, Transform2D>("skeleton_bone_set_transform_2d")

  @JvmField
  public val skeletonBoneGetTransform2dName:
      MethodStringName2<RenderingServer, Transform2D, RID, Int> =
      MethodStringName2<RenderingServer, Transform2D, RID, Int>("skeleton_bone_get_transform_2d")

  @JvmField
  public val skeletonSetBaseTransform2dName:
      MethodStringName2<RenderingServer, Unit, RID, Transform2D> =
      MethodStringName2<RenderingServer, Unit, RID, Transform2D>("skeleton_set_base_transform_2d")

  @JvmField
  public val directionalLightCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("directional_light_create")

  @JvmField
  public val omniLightCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("omni_light_create")

  @JvmField
  public val spotLightCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("spot_light_create")

  @JvmField
  public val areaLightCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("area_light_create")

  @JvmField
  public val lightSetColorName: MethodStringName2<RenderingServer, Unit, RID, Color> =
      MethodStringName2<RenderingServer, Unit, RID, Color>("light_set_color")

  @JvmField
  public val lightSetParamName: MethodStringName3<RenderingServer, Unit, RID, LightParam, Float> =
      MethodStringName3<RenderingServer, Unit, RID, LightParam, Float>("light_set_param")

  @JvmField
  public val lightSetShadowName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("light_set_shadow")

  @JvmField
  public val lightSetProjectorName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("light_set_projector")

  @JvmField
  public val lightSetNegativeName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("light_set_negative")

  @JvmField
  public val lightSetCullMaskName: MethodStringName2<RenderingServer, Unit, RID, Long> =
      MethodStringName2<RenderingServer, Unit, RID, Long>("light_set_cull_mask")

  @JvmField
  public val lightSetDistanceFadeName:
      MethodStringName5<RenderingServer, Unit, RID, Boolean, Float, Float, Float> =
      MethodStringName5<RenderingServer, Unit, RID, Boolean, Float, Float, Float>("light_set_distance_fade")

  @JvmField
  public val lightSetReverseCullFaceModeName: MethodStringName2<RenderingServer, Unit, RID, Boolean>
      = MethodStringName2<RenderingServer, Unit, RID, Boolean>("light_set_reverse_cull_face_mode")

  @JvmField
  public val lightSetShadowCasterMaskName: MethodStringName2<RenderingServer, Unit, RID, Long> =
      MethodStringName2<RenderingServer, Unit, RID, Long>("light_set_shadow_caster_mask")

  @JvmField
  public val lightSetBakeModeName: MethodStringName2<RenderingServer, Unit, RID, LightBakeMode> =
      MethodStringName2<RenderingServer, Unit, RID, LightBakeMode>("light_set_bake_mode")

  @JvmField
  public val lightSetMaxSdfgiCascadeName: MethodStringName2<RenderingServer, Unit, RID, Long> =
      MethodStringName2<RenderingServer, Unit, RID, Long>("light_set_max_sdfgi_cascade")

  @JvmField
  public val lightOmniSetShadowModeName:
      MethodStringName2<RenderingServer, Unit, RID, LightOmniShadowMode> =
      MethodStringName2<RenderingServer, Unit, RID, LightOmniShadowMode>("light_omni_set_shadow_mode")

  @JvmField
  public val lightDirectionalSetShadowModeName:
      MethodStringName2<RenderingServer, Unit, RID, LightDirectionalShadowMode> =
      MethodStringName2<RenderingServer, Unit, RID, LightDirectionalShadowMode>("light_directional_set_shadow_mode")

  @JvmField
  public val lightDirectionalSetBlendSplitsName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("light_directional_set_blend_splits")

  @JvmField
  public val lightDirectionalSetSkyModeName:
      MethodStringName2<RenderingServer, Unit, RID, LightDirectionalSkyMode> =
      MethodStringName2<RenderingServer, Unit, RID, LightDirectionalSkyMode>("light_directional_set_sky_mode")

  @JvmField
  public val lightAreaSetSizeName: MethodStringName2<RenderingServer, Unit, RID, Vector2> =
      MethodStringName2<RenderingServer, Unit, RID, Vector2>("light_area_set_size")

  @JvmField
  public val lightAreaSetNormalizeEnergyName: MethodStringName2<RenderingServer, Unit, RID, Boolean>
      = MethodStringName2<RenderingServer, Unit, RID, Boolean>("light_area_set_normalize_energy")

  @JvmField
  public val lightProjectorsSetFilterName:
      MethodStringName1<RenderingServer, Unit, LightProjectorFilter> =
      MethodStringName1<RenderingServer, Unit, LightProjectorFilter>("light_projectors_set_filter")

  @JvmField
  public val lightmapsSetBicubicFilterName: MethodStringName1<RenderingServer, Unit, Boolean> =
      MethodStringName1<RenderingServer, Unit, Boolean>("lightmaps_set_bicubic_filter")

  @JvmField
  public val positionalSoftShadowFilterSetQualityName:
      MethodStringName1<RenderingServer, Unit, ShadowQuality> =
      MethodStringName1<RenderingServer, Unit, ShadowQuality>("positional_soft_shadow_filter_set_quality")

  @JvmField
  public val directionalSoftShadowFilterSetQualityName:
      MethodStringName1<RenderingServer, Unit, ShadowQuality> =
      MethodStringName1<RenderingServer, Unit, ShadowQuality>("directional_soft_shadow_filter_set_quality")

  @JvmField
  public val directionalShadowAtlasSetSizeName:
      MethodStringName2<RenderingServer, Unit, Int, Boolean> =
      MethodStringName2<RenderingServer, Unit, Int, Boolean>("directional_shadow_atlas_set_size")

  @JvmField
  public val reflectionProbeCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("reflection_probe_create")

  @JvmField
  public val reflectionProbeSetUpdateModeName:
      MethodStringName2<RenderingServer, Unit, RID, ReflectionProbeUpdateMode> =
      MethodStringName2<RenderingServer, Unit, RID, ReflectionProbeUpdateMode>("reflection_probe_set_update_mode")

  @JvmField
  public val reflectionProbeSetIntensityName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("reflection_probe_set_intensity")

  @JvmField
  public val reflectionProbeSetBlendDistanceName:
      MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("reflection_probe_set_blend_distance")

  @JvmField
  public val reflectionProbeSetAmbientModeName:
      MethodStringName2<RenderingServer, Unit, RID, ReflectionProbeAmbientMode> =
      MethodStringName2<RenderingServer, Unit, RID, ReflectionProbeAmbientMode>("reflection_probe_set_ambient_mode")

  @JvmField
  public val reflectionProbeSetAmbientColorName:
      MethodStringName2<RenderingServer, Unit, RID, Color> =
      MethodStringName2<RenderingServer, Unit, RID, Color>("reflection_probe_set_ambient_color")

  @JvmField
  public val reflectionProbeSetAmbientEnergyName:
      MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("reflection_probe_set_ambient_energy")

  @JvmField
  public val reflectionProbeSetMaxDistanceName: MethodStringName2<RenderingServer, Unit, RID, Float>
      = MethodStringName2<RenderingServer, Unit, RID, Float>("reflection_probe_set_max_distance")

  @JvmField
  public val reflectionProbeSetSizeName: MethodStringName2<RenderingServer, Unit, RID, Vector3> =
      MethodStringName2<RenderingServer, Unit, RID, Vector3>("reflection_probe_set_size")

  @JvmField
  public val reflectionProbeSetOriginOffsetName:
      MethodStringName2<RenderingServer, Unit, RID, Vector3> =
      MethodStringName2<RenderingServer, Unit, RID, Vector3>("reflection_probe_set_origin_offset")

  @JvmField
  public val reflectionProbeSetAsInteriorName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("reflection_probe_set_as_interior")

  @JvmField
  public val reflectionProbeSetEnableBoxProjectionName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("reflection_probe_set_enable_box_projection")

  @JvmField
  public val reflectionProbeSetEnableShadowsName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("reflection_probe_set_enable_shadows")

  @JvmField
  public val reflectionProbeSetCullMaskName: MethodStringName2<RenderingServer, Unit, RID, Long> =
      MethodStringName2<RenderingServer, Unit, RID, Long>("reflection_probe_set_cull_mask")

  @JvmField
  public val reflectionProbeSetReflectionMaskName:
      MethodStringName2<RenderingServer, Unit, RID, Long> =
      MethodStringName2<RenderingServer, Unit, RID, Long>("reflection_probe_set_reflection_mask")

  @JvmField
  public val reflectionProbeSetResolutionName: MethodStringName2<RenderingServer, Unit, RID, Int> =
      MethodStringName2<RenderingServer, Unit, RID, Int>("reflection_probe_set_resolution")

  @JvmField
  public val reflectionProbeSetMeshLodThresholdName:
      MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("reflection_probe_set_mesh_lod_threshold")

  @JvmField
  public val decalCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("decal_create")

  @JvmField
  public val decalSetSizeName: MethodStringName2<RenderingServer, Unit, RID, Vector3> =
      MethodStringName2<RenderingServer, Unit, RID, Vector3>("decal_set_size")

  @JvmField
  public val decalSetTextureName: MethodStringName3<RenderingServer, Unit, RID, DecalTexture, RID> =
      MethodStringName3<RenderingServer, Unit, RID, DecalTexture, RID>("decal_set_texture")

  @JvmField
  public val decalSetEmissionEnergyName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("decal_set_emission_energy")

  @JvmField
  public val decalSetAlbedoMixName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("decal_set_albedo_mix")

  @JvmField
  public val decalSetModulateName: MethodStringName2<RenderingServer, Unit, RID, Color> =
      MethodStringName2<RenderingServer, Unit, RID, Color>("decal_set_modulate")

  @JvmField
  public val decalSetCullMaskName: MethodStringName2<RenderingServer, Unit, RID, Long> =
      MethodStringName2<RenderingServer, Unit, RID, Long>("decal_set_cull_mask")

  @JvmField
  public val decalSetDistanceFadeName:
      MethodStringName4<RenderingServer, Unit, RID, Boolean, Float, Float> =
      MethodStringName4<RenderingServer, Unit, RID, Boolean, Float, Float>("decal_set_distance_fade")

  @JvmField
  public val decalSetFadeName: MethodStringName3<RenderingServer, Unit, RID, Float, Float> =
      MethodStringName3<RenderingServer, Unit, RID, Float, Float>("decal_set_fade")

  @JvmField
  public val decalSetNormalFadeName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("decal_set_normal_fade")

  @JvmField
  public val decalsSetFilterName: MethodStringName1<RenderingServer, Unit, DecalFilter> =
      MethodStringName1<RenderingServer, Unit, DecalFilter>("decals_set_filter")

  @JvmField
  public val giSetUseHalfResolutionName: MethodStringName1<RenderingServer, Unit, Boolean> =
      MethodStringName1<RenderingServer, Unit, Boolean>("gi_set_use_half_resolution")

  @JvmField
  public val voxelGiCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("voxel_gi_create")

  @JvmField
  public val voxelGiAllocateDataName:
      MethodStringName8<RenderingServer, Unit, RID, Transform3D, AABB, Vector3i, PackedByteArray, PackedByteArray, PackedByteArray, PackedInt32Array>
      =
      MethodStringName8<RenderingServer, Unit, RID, Transform3D, AABB, Vector3i, PackedByteArray, PackedByteArray, PackedByteArray, PackedInt32Array>("voxel_gi_allocate_data")

  @JvmField
  public val voxelGiGetOctreeSizeName: MethodStringName1<RenderingServer, Vector3i, RID> =
      MethodStringName1<RenderingServer, Vector3i, RID>("voxel_gi_get_octree_size")

  @JvmField
  public val voxelGiGetOctreeCellsName: MethodStringName1<RenderingServer, PackedByteArray, RID> =
      MethodStringName1<RenderingServer, PackedByteArray, RID>("voxel_gi_get_octree_cells")

  @JvmField
  public val voxelGiGetDataCellsName: MethodStringName1<RenderingServer, PackedByteArray, RID> =
      MethodStringName1<RenderingServer, PackedByteArray, RID>("voxel_gi_get_data_cells")

  @JvmField
  public val voxelGiGetDistanceFieldName: MethodStringName1<RenderingServer, PackedByteArray, RID> =
      MethodStringName1<RenderingServer, PackedByteArray, RID>("voxel_gi_get_distance_field")

  @JvmField
  public val voxelGiGetLevelCountsName: MethodStringName1<RenderingServer, PackedInt32Array, RID> =
      MethodStringName1<RenderingServer, PackedInt32Array, RID>("voxel_gi_get_level_counts")

  @JvmField
  public val voxelGiGetToCellXformName: MethodStringName1<RenderingServer, Transform3D, RID> =
      MethodStringName1<RenderingServer, Transform3D, RID>("voxel_gi_get_to_cell_xform")

  @JvmField
  public val voxelGiSetDynamicRangeName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("voxel_gi_set_dynamic_range")

  @JvmField
  public val voxelGiSetPropagationName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("voxel_gi_set_propagation")

  @JvmField
  public val voxelGiSetEnergyName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("voxel_gi_set_energy")

  @JvmField
  public val voxelGiSetBakedExposureNormalizationName:
      MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("voxel_gi_set_baked_exposure_normalization")

  @JvmField
  public val voxelGiSetBiasName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("voxel_gi_set_bias")

  @JvmField
  public val voxelGiSetNormalBiasName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("voxel_gi_set_normal_bias")

  @JvmField
  public val voxelGiSetInteriorName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("voxel_gi_set_interior")

  @JvmField
  public val voxelGiSetUseTwoBouncesName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("voxel_gi_set_use_two_bounces")

  @JvmField
  public val voxelGiSetQualityName: MethodStringName1<RenderingServer, Unit, VoxelGIQuality> =
      MethodStringName1<RenderingServer, Unit, VoxelGIQuality>("voxel_gi_set_quality")

  @JvmField
  public val lightmapCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("lightmap_create")

  @JvmField
  public val lightmapSetTexturesName: MethodStringName3<RenderingServer, Unit, RID, RID, Boolean> =
      MethodStringName3<RenderingServer, Unit, RID, RID, Boolean>("lightmap_set_textures")

  @JvmField
  public val lightmapSetProbeBoundsName: MethodStringName2<RenderingServer, Unit, RID, AABB> =
      MethodStringName2<RenderingServer, Unit, RID, AABB>("lightmap_set_probe_bounds")

  @JvmField
  public val lightmapSetProbeInteriorName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("lightmap_set_probe_interior")

  @JvmField
  public val lightmapSetProbeCaptureDataName:
      MethodStringName5<RenderingServer, Unit, RID, PackedVector3Array, PackedColorArray, PackedInt32Array, PackedInt32Array>
      =
      MethodStringName5<RenderingServer, Unit, RID, PackedVector3Array, PackedColorArray, PackedInt32Array, PackedInt32Array>("lightmap_set_probe_capture_data")

  @JvmField
  public val lightmapGetProbeCapturePointsName:
      MethodStringName1<RenderingServer, PackedVector3Array, RID> =
      MethodStringName1<RenderingServer, PackedVector3Array, RID>("lightmap_get_probe_capture_points")

  @JvmField
  public val lightmapGetProbeCaptureShName:
      MethodStringName1<RenderingServer, PackedColorArray, RID> =
      MethodStringName1<RenderingServer, PackedColorArray, RID>("lightmap_get_probe_capture_sh")

  @JvmField
  public val lightmapGetProbeCaptureTetrahedraName:
      MethodStringName1<RenderingServer, PackedInt32Array, RID> =
      MethodStringName1<RenderingServer, PackedInt32Array, RID>("lightmap_get_probe_capture_tetrahedra")

  @JvmField
  public val lightmapGetProbeCaptureBspTreeName:
      MethodStringName1<RenderingServer, PackedInt32Array, RID> =
      MethodStringName1<RenderingServer, PackedInt32Array, RID>("lightmap_get_probe_capture_bsp_tree")

  @JvmField
  public val lightmapSetBakedExposureNormalizationName:
      MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("lightmap_set_baked_exposure_normalization")

  @JvmField
  public val lightmapSetProbeCaptureUpdateSpeedName: MethodStringName1<RenderingServer, Unit, Float>
      = MethodStringName1<RenderingServer, Unit, Float>("lightmap_set_probe_capture_update_speed")

  @JvmField
  public val particlesCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("particles_create")

  @JvmField
  public val particlesSetModeName: MethodStringName2<RenderingServer, Unit, RID, ParticlesMode> =
      MethodStringName2<RenderingServer, Unit, RID, ParticlesMode>("particles_set_mode")

  @JvmField
  public val particlesSetEmittingName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("particles_set_emitting")

  @JvmField
  public val particlesGetEmittingName: MethodStringName1<RenderingServer, Boolean, RID> =
      MethodStringName1<RenderingServer, Boolean, RID>("particles_get_emitting")

  @JvmField
  public val particlesSetAmountName: MethodStringName2<RenderingServer, Unit, RID, Int> =
      MethodStringName2<RenderingServer, Unit, RID, Int>("particles_set_amount")

  @JvmField
  public val particlesSetAmountRatioName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("particles_set_amount_ratio")

  @JvmField
  public val particlesSetLifetimeName: MethodStringName2<RenderingServer, Unit, RID, Double> =
      MethodStringName2<RenderingServer, Unit, RID, Double>("particles_set_lifetime")

  @JvmField
  public val particlesSetOneShotName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("particles_set_one_shot")

  @JvmField
  public val particlesSetPreProcessTimeName: MethodStringName2<RenderingServer, Unit, RID, Double> =
      MethodStringName2<RenderingServer, Unit, RID, Double>("particles_set_pre_process_time")

  @JvmField
  public val particlesRequestProcessTimeName:
      MethodStringName3<RenderingServer, Unit, RID, Float, Float> =
      MethodStringName3<RenderingServer, Unit, RID, Float, Float>("particles_request_process_time")

  @JvmField
  public val particlesSetExplosivenessRatioName:
      MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("particles_set_explosiveness_ratio")

  @JvmField
  public val particlesSetRandomnessRatioName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("particles_set_randomness_ratio")

  @JvmField
  public val particlesSetInterpToEndName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("particles_set_interp_to_end")

  @JvmField
  public val particlesSetEmitterVelocityName: MethodStringName2<RenderingServer, Unit, RID, Vector3>
      = MethodStringName2<RenderingServer, Unit, RID, Vector3>("particles_set_emitter_velocity")

  @JvmField
  public val particlesSetCustomAabbName: MethodStringName2<RenderingServer, Unit, RID, AABB> =
      MethodStringName2<RenderingServer, Unit, RID, AABB>("particles_set_custom_aabb")

  @JvmField
  public val particlesSetSpeedScaleName: MethodStringName2<RenderingServer, Unit, RID, Double> =
      MethodStringName2<RenderingServer, Unit, RID, Double>("particles_set_speed_scale")

  @JvmField
  public val particlesSetUseLocalCoordinatesName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("particles_set_use_local_coordinates")

  @JvmField
  public val particlesSetProcessMaterialName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("particles_set_process_material")

  @JvmField
  public val particlesSetFixedFpsName: MethodStringName2<RenderingServer, Unit, RID, Int> =
      MethodStringName2<RenderingServer, Unit, RID, Int>("particles_set_fixed_fps")

  @JvmField
  public val particlesSetInterpolateName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("particles_set_interpolate")

  @JvmField
  public val particlesSetFractionalDeltaName: MethodStringName2<RenderingServer, Unit, RID, Boolean>
      = MethodStringName2<RenderingServer, Unit, RID, Boolean>("particles_set_fractional_delta")

  @JvmField
  public val particlesSetCollisionBaseSizeName: MethodStringName2<RenderingServer, Unit, RID, Float>
      = MethodStringName2<RenderingServer, Unit, RID, Float>("particles_set_collision_base_size")

  @JvmField
  public val particlesSetTransformAlignName:
      MethodStringName2<RenderingServer, Unit, RID, ParticlesTransformAlign> =
      MethodStringName2<RenderingServer, Unit, RID, ParticlesTransformAlign>("particles_set_transform_align")

  @JvmField
  public val particlesSetTransformAlignChannelFilterName:
      MethodStringName2<RenderingServer, Unit, RID, ParticlesTransformAlignCustomSrc> =
      MethodStringName2<RenderingServer, Unit, RID, ParticlesTransformAlignCustomSrc>("particles_set_transform_align_channel_filter")

  @JvmField
  public val particlesSetTransformAlignAxisName:
      MethodStringName2<RenderingServer, Unit, RID, ParticlesTransformAlignAxis> =
      MethodStringName2<RenderingServer, Unit, RID, ParticlesTransformAlignAxis>("particles_set_transform_align_axis")

  @JvmField
  public val particlesSetTrailsName: MethodStringName3<RenderingServer, Unit, RID, Boolean, Float> =
      MethodStringName3<RenderingServer, Unit, RID, Boolean, Float>("particles_set_trails")

  @JvmField
  public val particlesSetTrailBindPosesName:
      MethodStringName2<RenderingServer, Unit, RID, VariantArray<Transform3D>> =
      MethodStringName2<RenderingServer, Unit, RID, VariantArray<Transform3D>>("particles_set_trail_bind_poses")

  @JvmField
  public val particlesIsInactiveName: MethodStringName1<RenderingServer, Boolean, RID> =
      MethodStringName1<RenderingServer, Boolean, RID>("particles_is_inactive")

  @JvmField
  public val particlesRequestProcessName: MethodStringName1<RenderingServer, Unit, RID> =
      MethodStringName1<RenderingServer, Unit, RID>("particles_request_process")

  @JvmField
  public val particlesRestartName: MethodStringName1<RenderingServer, Unit, RID> =
      MethodStringName1<RenderingServer, Unit, RID>("particles_restart")

  @JvmField
  public val particlesSetSubemitterName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("particles_set_subemitter")

  @JvmField
  public val particlesEmitName:
      MethodStringName6<RenderingServer, Unit, RID, Transform3D, Vector3, Color, Color, Long> =
      MethodStringName6<RenderingServer, Unit, RID, Transform3D, Vector3, Color, Color, Long>("particles_emit")

  @JvmField
  public val particlesSetDrawOrderName:
      MethodStringName2<RenderingServer, Unit, RID, ParticlesDrawOrder> =
      MethodStringName2<RenderingServer, Unit, RID, ParticlesDrawOrder>("particles_set_draw_order")

  @JvmField
  public val particlesSetDrawPassesName: MethodStringName2<RenderingServer, Unit, RID, Int> =
      MethodStringName2<RenderingServer, Unit, RID, Int>("particles_set_draw_passes")

  @JvmField
  public val particlesSetDrawPassMeshName: MethodStringName3<RenderingServer, Unit, RID, Int, RID> =
      MethodStringName3<RenderingServer, Unit, RID, Int, RID>("particles_set_draw_pass_mesh")

  @JvmField
  public val particlesGetCurrentAabbName: MethodStringName1<RenderingServer, AABB, RID> =
      MethodStringName1<RenderingServer, AABB, RID>("particles_get_current_aabb")

  @JvmField
  public val particlesSetEmissionTransformName:
      MethodStringName2<RenderingServer, Unit, RID, Transform3D> =
      MethodStringName2<RenderingServer, Unit, RID, Transform3D>("particles_set_emission_transform")

  @JvmField
  public val particlesCollisionCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("particles_collision_create")

  @JvmField
  public val particlesCollisionSetCollisionTypeName:
      MethodStringName2<RenderingServer, Unit, RID, ParticlesCollisionType> =
      MethodStringName2<RenderingServer, Unit, RID, ParticlesCollisionType>("particles_collision_set_collision_type")

  @JvmField
  public val particlesCollisionSetCullMaskName: MethodStringName2<RenderingServer, Unit, RID, Long>
      = MethodStringName2<RenderingServer, Unit, RID, Long>("particles_collision_set_cull_mask")

  @JvmField
  public val particlesCollisionSetSphereRadiusName:
      MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("particles_collision_set_sphere_radius")

  @JvmField
  public val particlesCollisionSetBoxExtentsName:
      MethodStringName2<RenderingServer, Unit, RID, Vector3> =
      MethodStringName2<RenderingServer, Unit, RID, Vector3>("particles_collision_set_box_extents")

  @JvmField
  public val particlesCollisionSetAttractorStrengthName:
      MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("particles_collision_set_attractor_strength")

  @JvmField
  public val particlesCollisionSetAttractorDirectionalityName:
      MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("particles_collision_set_attractor_directionality")

  @JvmField
  public val particlesCollisionSetAttractorAttenuationName:
      MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("particles_collision_set_attractor_attenuation")

  @JvmField
  public val particlesCollisionSetFieldTextureName:
      MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("particles_collision_set_field_texture")

  @JvmField
  public val particlesCollisionHeightFieldUpdateName: MethodStringName1<RenderingServer, Unit, RID>
      = MethodStringName1<RenderingServer, Unit, RID>("particles_collision_height_field_update")

  @JvmField
  public val particlesCollisionSetHeightFieldResolutionName:
      MethodStringName2<RenderingServer, Unit, RID, ParticlesCollisionHeightfieldResolution> =
      MethodStringName2<RenderingServer, Unit, RID, ParticlesCollisionHeightfieldResolution>("particles_collision_set_height_field_resolution")

  @JvmField
  public val particlesCollisionSetHeightFieldMaskName:
      MethodStringName2<RenderingServer, Unit, RID, Long> =
      MethodStringName2<RenderingServer, Unit, RID, Long>("particles_collision_set_height_field_mask")

  @JvmField
  public val fogVolumeCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("fog_volume_create")

  @JvmField
  public val fogVolumeSetShapeName: MethodStringName2<RenderingServer, Unit, RID, FogVolumeShape> =
      MethodStringName2<RenderingServer, Unit, RID, FogVolumeShape>("fog_volume_set_shape")

  @JvmField
  public val fogVolumeSetSizeName: MethodStringName2<RenderingServer, Unit, RID, Vector3> =
      MethodStringName2<RenderingServer, Unit, RID, Vector3>("fog_volume_set_size")

  @JvmField
  public val fogVolumeSetMaterialName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("fog_volume_set_material")

  @JvmField
  public val visibilityNotifierCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("visibility_notifier_create")

  @JvmField
  public val visibilityNotifierSetAabbName: MethodStringName2<RenderingServer, Unit, RID, AABB> =
      MethodStringName2<RenderingServer, Unit, RID, AABB>("visibility_notifier_set_aabb")

  @JvmField
  public val visibilityNotifierSetCallbacksName:
      MethodStringName3<RenderingServer, Unit, RID, Callable, Callable> =
      MethodStringName3<RenderingServer, Unit, RID, Callable, Callable>("visibility_notifier_set_callbacks")

  @JvmField
  public val occluderCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("occluder_create")

  @JvmField
  public val occluderSetMeshName:
      MethodStringName3<RenderingServer, Unit, RID, PackedVector3Array, PackedInt32Array> =
      MethodStringName3<RenderingServer, Unit, RID, PackedVector3Array, PackedInt32Array>("occluder_set_mesh")

  @JvmField
  public val cameraCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("camera_create")

  @JvmField
  public val cameraSetPerspectiveName:
      MethodStringName4<RenderingServer, Unit, RID, Float, Float, Float> =
      MethodStringName4<RenderingServer, Unit, RID, Float, Float, Float>("camera_set_perspective")

  @JvmField
  public val cameraSetOrthogonalName:
      MethodStringName4<RenderingServer, Unit, RID, Float, Float, Float> =
      MethodStringName4<RenderingServer, Unit, RID, Float, Float, Float>("camera_set_orthogonal")

  @JvmField
  public val cameraSetFrustumName:
      MethodStringName5<RenderingServer, Unit, RID, Float, Vector2, Float, Float> =
      MethodStringName5<RenderingServer, Unit, RID, Float, Vector2, Float, Float>("camera_set_frustum")

  @JvmField
  public val cameraSetTransformName: MethodStringName2<RenderingServer, Unit, RID, Transform3D> =
      MethodStringName2<RenderingServer, Unit, RID, Transform3D>("camera_set_transform")

  @JvmField
  public val cameraSetCullMaskName: MethodStringName2<RenderingServer, Unit, RID, Long> =
      MethodStringName2<RenderingServer, Unit, RID, Long>("camera_set_cull_mask")

  @JvmField
  public val cameraSetEnvironmentName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("camera_set_environment")

  @JvmField
  public val cameraSetCameraAttributesName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("camera_set_camera_attributes")

  @JvmField
  public val cameraSetCompositorName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("camera_set_compositor")

  @JvmField
  public val cameraSetUseVerticalAspectName: MethodStringName2<RenderingServer, Unit, RID, Boolean>
      = MethodStringName2<RenderingServer, Unit, RID, Boolean>("camera_set_use_vertical_aspect")

  @JvmField
  public val viewportCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("viewport_create")

  @JvmField
  public val viewportSetUseXrName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("viewport_set_use_xr")

  @JvmField
  public val viewportSetSizeName: MethodStringName4<RenderingServer, Unit, RID, Int, Int, Int> =
      MethodStringName4<RenderingServer, Unit, RID, Int, Int, Int>("viewport_set_size")

  @JvmField
  public val viewportSetActiveName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("viewport_set_active")

  @JvmField
  public val viewportSetParentViewportName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("viewport_set_parent_viewport")

  @JvmField
  public val viewportAttachToScreenName: MethodStringName3<RenderingServer, Unit, RID, Rect2, Int> =
      MethodStringName3<RenderingServer, Unit, RID, Rect2, Int>("viewport_attach_to_screen")

  @JvmField
  public val viewportSetRenderDirectToScreenName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("viewport_set_render_direct_to_screen")

  @JvmField
  public val viewportSetCanvasCullMaskName: MethodStringName2<RenderingServer, Unit, RID, Long> =
      MethodStringName2<RenderingServer, Unit, RID, Long>("viewport_set_canvas_cull_mask")

  @JvmField
  public val viewportSetScaling3dModeName:
      MethodStringName2<RenderingServer, Unit, RID, ViewportScaling3DMode> =
      MethodStringName2<RenderingServer, Unit, RID, ViewportScaling3DMode>("viewport_set_scaling_3d_mode")

  @JvmField
  public val viewportSetScaling3dScaleName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("viewport_set_scaling_3d_scale")

  @JvmField
  public val viewportSetFsrSharpnessName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("viewport_set_fsr_sharpness")

  @JvmField
  public val viewportSetTextureMipmapBiasName: MethodStringName2<RenderingServer, Unit, RID, Float>
      = MethodStringName2<RenderingServer, Unit, RID, Float>("viewport_set_texture_mipmap_bias")

  @JvmField
  public val viewportSetAnisotropicFilteringLevelName:
      MethodStringName2<RenderingServer, Unit, RID, ViewportAnisotropicFiltering> =
      MethodStringName2<RenderingServer, Unit, RID, ViewportAnisotropicFiltering>("viewport_set_anisotropic_filtering_level")

  @JvmField
  public val viewportSetUpdateModeName:
      MethodStringName2<RenderingServer, Unit, RID, ViewportUpdateMode> =
      MethodStringName2<RenderingServer, Unit, RID, ViewportUpdateMode>("viewport_set_update_mode")

  @JvmField
  public val viewportGetUpdateModeName: MethodStringName1<RenderingServer, ViewportUpdateMode, RID>
      = MethodStringName1<RenderingServer, ViewportUpdateMode, RID>("viewport_get_update_mode")

  @JvmField
  public val viewportSetClearModeName:
      MethodStringName2<RenderingServer, Unit, RID, ViewportClearMode> =
      MethodStringName2<RenderingServer, Unit, RID, ViewportClearMode>("viewport_set_clear_mode")

  @JvmField
  public val viewportGetRenderTargetName: MethodStringName1<RenderingServer, RID, RID> =
      MethodStringName1<RenderingServer, RID, RID>("viewport_get_render_target")

  @JvmField
  public val viewportGetTextureName: MethodStringName1<RenderingServer, RID, RID> =
      MethodStringName1<RenderingServer, RID, RID>("viewport_get_texture")

  @JvmField
  public val viewportSetDisable3dName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("viewport_set_disable_3d")

  @JvmField
  public val viewportSetDisable2dName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("viewport_set_disable_2d")

  @JvmField
  public val viewportSetEnvironmentModeName:
      MethodStringName2<RenderingServer, Unit, RID, ViewportEnvironmentMode> =
      MethodStringName2<RenderingServer, Unit, RID, ViewportEnvironmentMode>("viewport_set_environment_mode")

  @JvmField
  public val viewportAttachCameraName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("viewport_attach_camera")

  @JvmField
  public val viewportSetScenarioName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("viewport_set_scenario")

  @JvmField
  public val viewportAttachCanvasName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("viewport_attach_canvas")

  @JvmField
  public val viewportRemoveCanvasName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("viewport_remove_canvas")

  @JvmField
  public val viewportSetSnap2dTransformsToPixelName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("viewport_set_snap_2d_transforms_to_pixel")

  @JvmField
  public val viewportSetSnap2dVerticesToPixelName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("viewport_set_snap_2d_vertices_to_pixel")

  @JvmField
  public val viewportSetDefaultCanvasItemTextureFilterName:
      MethodStringName2<RenderingServer, Unit, RID, CanvasItemTextureFilter> =
      MethodStringName2<RenderingServer, Unit, RID, CanvasItemTextureFilter>("viewport_set_default_canvas_item_texture_filter")

  @JvmField
  public val viewportSetDefaultCanvasItemTextureRepeatName:
      MethodStringName2<RenderingServer, Unit, RID, CanvasItemTextureRepeat> =
      MethodStringName2<RenderingServer, Unit, RID, CanvasItemTextureRepeat>("viewport_set_default_canvas_item_texture_repeat")

  @JvmField
  public val viewportSetCanvasTransformName:
      MethodStringName3<RenderingServer, Unit, RID, RID, Transform2D> =
      MethodStringName3<RenderingServer, Unit, RID, RID, Transform2D>("viewport_set_canvas_transform")

  @JvmField
  public val viewportSetCanvasStackingName:
      MethodStringName4<RenderingServer, Unit, RID, RID, Int, Int> =
      MethodStringName4<RenderingServer, Unit, RID, RID, Int, Int>("viewport_set_canvas_stacking")

  @JvmField
  public val viewportSetTransparentBackgroundName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("viewport_set_transparent_background")

  @JvmField
  public val viewportSetGlobalCanvasTransformName:
      MethodStringName2<RenderingServer, Unit, RID, Transform2D> =
      MethodStringName2<RenderingServer, Unit, RID, Transform2D>("viewport_set_global_canvas_transform")

  @JvmField
  public val viewportSetSdfOversizeAndScaleName:
      MethodStringName3<RenderingServer, Unit, RID, ViewportSDFOversize, ViewportSDFScale> =
      MethodStringName3<RenderingServer, Unit, RID, ViewportSDFOversize, ViewportSDFScale>("viewport_set_sdf_oversize_and_scale")

  @JvmField
  public val viewportSetPositionalShadowAtlasSizeName:
      MethodStringName3<RenderingServer, Unit, RID, Int, Boolean> =
      MethodStringName3<RenderingServer, Unit, RID, Int, Boolean>("viewport_set_positional_shadow_atlas_size")

  @JvmField
  public val viewportSetPositionalShadowAtlasQuadrantSubdivisionName:
      MethodStringName3<RenderingServer, Unit, RID, Int, Int> =
      MethodStringName3<RenderingServer, Unit, RID, Int, Int>("viewport_set_positional_shadow_atlas_quadrant_subdivision")

  @JvmField
  public val viewportSetMsaa3dName: MethodStringName2<RenderingServer, Unit, RID, ViewportMSAA> =
      MethodStringName2<RenderingServer, Unit, RID, ViewportMSAA>("viewport_set_msaa_3d")

  @JvmField
  public val viewportSetMsaa2dName: MethodStringName2<RenderingServer, Unit, RID, ViewportMSAA> =
      MethodStringName2<RenderingServer, Unit, RID, ViewportMSAA>("viewport_set_msaa_2d")

  @JvmField
  public val viewportSetUseHdr2dName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("viewport_set_use_hdr_2d")

  @JvmField
  public val viewportSetScreenSpaceAaName:
      MethodStringName2<RenderingServer, Unit, RID, ViewportScreenSpaceAA> =
      MethodStringName2<RenderingServer, Unit, RID, ViewportScreenSpaceAA>("viewport_set_screen_space_aa")

  @JvmField
  public val viewportSetUseTaaName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("viewport_set_use_taa")

  @JvmField
  public val viewportSetUseDebandingName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("viewport_set_use_debanding")

  @JvmField
  public val viewportSetUseOcclusionCullingName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("viewport_set_use_occlusion_culling")

  @JvmField
  public val viewportSetOcclusionRaysPerThreadName: MethodStringName1<RenderingServer, Unit, Int> =
      MethodStringName1<RenderingServer, Unit, Int>("viewport_set_occlusion_rays_per_thread")

  @JvmField
  public val viewportSetOcclusionCullingBuildQualityName:
      MethodStringName1<RenderingServer, Unit, ViewportOcclusionCullingBuildQuality> =
      MethodStringName1<RenderingServer, Unit, ViewportOcclusionCullingBuildQuality>("viewport_set_occlusion_culling_build_quality")

  @JvmField
  public val viewportGetRenderInfoName:
      MethodStringName3<RenderingServer, Int, RID, ViewportRenderInfoType, ViewportRenderInfo> =
      MethodStringName3<RenderingServer, Int, RID, ViewportRenderInfoType, ViewportRenderInfo>("viewport_get_render_info")

  @JvmField
  public val viewportSetDebugDrawName:
      MethodStringName2<RenderingServer, Unit, RID, ViewportDebugDraw> =
      MethodStringName2<RenderingServer, Unit, RID, ViewportDebugDraw>("viewport_set_debug_draw")

  @JvmField
  public val viewportSetMeasureRenderTimeName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("viewport_set_measure_render_time")

  @JvmField
  public val viewportGetMeasuredRenderTimeCpuName: MethodStringName1<RenderingServer, Double, RID> =
      MethodStringName1<RenderingServer, Double, RID>("viewport_get_measured_render_time_cpu")

  @JvmField
  public val viewportGetMeasuredRenderTimeGpuName: MethodStringName1<RenderingServer, Double, RID> =
      MethodStringName1<RenderingServer, Double, RID>("viewport_get_measured_render_time_gpu")

  @JvmField
  public val viewportSetVrsModeName: MethodStringName2<RenderingServer, Unit, RID, ViewportVRSMode>
      = MethodStringName2<RenderingServer, Unit, RID, ViewportVRSMode>("viewport_set_vrs_mode")

  @JvmField
  public val viewportSetVrsUpdateModeName:
      MethodStringName2<RenderingServer, Unit, RID, ViewportVRSUpdateMode> =
      MethodStringName2<RenderingServer, Unit, RID, ViewportVRSUpdateMode>("viewport_set_vrs_update_mode")

  @JvmField
  public val viewportSetVrsTextureName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("viewport_set_vrs_texture")

  @JvmField
  public val skyCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("sky_create")

  @JvmField
  public val skySetRadianceSizeName: MethodStringName2<RenderingServer, Unit, RID, Int> =
      MethodStringName2<RenderingServer, Unit, RID, Int>("sky_set_radiance_size")

  @JvmField
  public val skySetModeName: MethodStringName2<RenderingServer, Unit, RID, SkyMode> =
      MethodStringName2<RenderingServer, Unit, RID, SkyMode>("sky_set_mode")

  @JvmField
  public val skySetMaterialName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("sky_set_material")

  @JvmField
  public val skyBakePanoramaName:
      MethodStringName4<RenderingServer, Image?, RID, Float, Boolean, Vector2i> =
      MethodStringName4<RenderingServer, Image?, RID, Float, Boolean, Vector2i>("sky_bake_panorama")

  @JvmField
  public val compositorEffectCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("compositor_effect_create")

  @JvmField
  public val compositorEffectSetEnabledName: MethodStringName2<RenderingServer, Unit, RID, Boolean>
      = MethodStringName2<RenderingServer, Unit, RID, Boolean>("compositor_effect_set_enabled")

  @JvmField
  public val compositorEffectSetCallbackName:
      MethodStringName3<RenderingServer, Unit, RID, CompositorEffectCallbackType, Callable> =
      MethodStringName3<RenderingServer, Unit, RID, CompositorEffectCallbackType, Callable>("compositor_effect_set_callback")

  @JvmField
  public val compositorEffectSetFlagName:
      MethodStringName3<RenderingServer, Unit, RID, CompositorEffectFlags, Boolean> =
      MethodStringName3<RenderingServer, Unit, RID, CompositorEffectFlags, Boolean>("compositor_effect_set_flag")

  @JvmField
  public val compositorCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("compositor_create")

  @JvmField
  public val compositorSetCompositorEffectsName:
      MethodStringName2<RenderingServer, Unit, RID, VariantArray<RID>> =
      MethodStringName2<RenderingServer, Unit, RID, VariantArray<RID>>("compositor_set_compositor_effects")

  @JvmField
  public val environmentCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("environment_create")

  @JvmField
  public val environmentSetBackgroundName:
      MethodStringName2<RenderingServer, Unit, RID, EnvironmentBG> =
      MethodStringName2<RenderingServer, Unit, RID, EnvironmentBG>("environment_set_background")

  @JvmField
  public val environmentSetCameraIdName: MethodStringName2<RenderingServer, Unit, RID, Int> =
      MethodStringName2<RenderingServer, Unit, RID, Int>("environment_set_camera_id")

  @JvmField
  public val environmentSetSkyName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("environment_set_sky")

  @JvmField
  public val environmentSetSkyCustomFovName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("environment_set_sky_custom_fov")

  @JvmField
  public val environmentSetSkyOrientationName: MethodStringName2<RenderingServer, Unit, RID, Basis>
      = MethodStringName2<RenderingServer, Unit, RID, Basis>("environment_set_sky_orientation")

  @JvmField
  public val environmentSetBgColorName: MethodStringName2<RenderingServer, Unit, RID, Color> =
      MethodStringName2<RenderingServer, Unit, RID, Color>("environment_set_bg_color")

  @JvmField
  public val environmentSetBgEnergyName: MethodStringName3<RenderingServer, Unit, RID, Float, Float>
      = MethodStringName3<RenderingServer, Unit, RID, Float, Float>("environment_set_bg_energy")

  @JvmField
  public val environmentSetCanvasMaxLayerName: MethodStringName2<RenderingServer, Unit, RID, Int> =
      MethodStringName2<RenderingServer, Unit, RID, Int>("environment_set_canvas_max_layer")

  @JvmField
  public val environmentSetAmbientLightName:
      MethodStringName6<RenderingServer, Unit, RID, Color, EnvironmentAmbientSource, Float, Float, EnvironmentReflectionSource>
      =
      MethodStringName6<RenderingServer, Unit, RID, Color, EnvironmentAmbientSource, Float, Float, EnvironmentReflectionSource>("environment_set_ambient_light")

  @JvmField
  public val environmentSetGlowName:
      MethodStringName13<RenderingServer, Unit, RID, Boolean, PackedFloat32Array, Float, Float, Float, Float, EnvironmentGlowBlendMode, Float, Float, Float, Float, RID>
      =
      MethodStringName13<RenderingServer, Unit, RID, Boolean, PackedFloat32Array, Float, Float, Float, Float, EnvironmentGlowBlendMode, Float, Float, Float, Float, RID>("environment_set_glow")

  @JvmField
  public val environmentSetTonemapName:
      MethodStringName4<RenderingServer, Unit, RID, EnvironmentToneMapper, Float, Float> =
      MethodStringName4<RenderingServer, Unit, RID, EnvironmentToneMapper, Float, Float>("environment_set_tonemap")

  @JvmField
  public val environmentSetTonemapAgxContrastName:
      MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("environment_set_tonemap_agx_contrast")

  @JvmField
  public val environmentSetAdjustmentName:
      MethodStringName7<RenderingServer, Unit, RID, Boolean, Float, Float, Float, Boolean, RID> =
      MethodStringName7<RenderingServer, Unit, RID, Boolean, Float, Float, Float, Boolean, RID>("environment_set_adjustment")

  @JvmField
  public val environmentSetSsrName:
      MethodStringName6<RenderingServer, Unit, RID, Boolean, Int, Float, Float, Float> =
      MethodStringName6<RenderingServer, Unit, RID, Boolean, Int, Float, Float, Float>("environment_set_ssr")

  @JvmField
  public val environmentSetSsaoName:
      MethodStringName10<RenderingServer, Unit, RID, Boolean, Float, Float, Float, Float, Float, Float, Float, Float>
      =
      MethodStringName10<RenderingServer, Unit, RID, Boolean, Float, Float, Float, Float, Float, Float, Float, Float>("environment_set_ssao")

  @JvmField
  public val environmentSetFogName:
      MethodStringName11<RenderingServer, Unit, RID, Boolean, Color, Float, Float, Float, Float, Float, Float, Float, EnvironmentFogMode>
      =
      MethodStringName11<RenderingServer, Unit, RID, Boolean, Color, Float, Float, Float, Float, Float, Float, Float, EnvironmentFogMode>("environment_set_fog")

  @JvmField
  public val environmentSetFogDepthName:
      MethodStringName4<RenderingServer, Unit, RID, Float, Float, Float> =
      MethodStringName4<RenderingServer, Unit, RID, Float, Float, Float>("environment_set_fog_depth")

  @JvmField
  public val environmentSetSdfgiName:
      MethodStringName11<RenderingServer, Unit, RID, Boolean, Int, Float, EnvironmentSDFGIYScale, Boolean, Float, Boolean, Float, Float, Float>
      =
      MethodStringName11<RenderingServer, Unit, RID, Boolean, Int, Float, EnvironmentSDFGIYScale, Boolean, Float, Boolean, Float, Float, Float>("environment_set_sdfgi")

  @JvmField
  public val environmentSetVolumetricFogName:
      MethodStringName14<RenderingServer, Unit, RID, Boolean, Float, Color, Color, Float, Float, Float, Float, Float, Boolean, Float, Float, Float>
      =
      MethodStringName14<RenderingServer, Unit, RID, Boolean, Float, Color, Color, Float, Float, Float, Float, Float, Boolean, Float, Float, Float>("environment_set_volumetric_fog")

  @JvmField
  public val environmentGlowSetUseBicubicUpscaleName:
      MethodStringName1<RenderingServer, Unit, Boolean> =
      MethodStringName1<RenderingServer, Unit, Boolean>("environment_glow_set_use_bicubic_upscale")

  @JvmField
  public val environmentSetSsrHalfSizeName: MethodStringName1<RenderingServer, Unit, Boolean> =
      MethodStringName1<RenderingServer, Unit, Boolean>("environment_set_ssr_half_size")

  @JvmField
  public val environmentSetSsrRoughnessQualityName:
      MethodStringName1<RenderingServer, Unit, EnvironmentSSRRoughnessQuality> =
      MethodStringName1<RenderingServer, Unit, EnvironmentSSRRoughnessQuality>("environment_set_ssr_roughness_quality")

  @JvmField
  public val environmentSetSsaoQualityName:
      MethodStringName6<RenderingServer, Unit, EnvironmentSSAOQuality, Boolean, Float, Int, Float, Float>
      =
      MethodStringName6<RenderingServer, Unit, EnvironmentSSAOQuality, Boolean, Float, Int, Float, Float>("environment_set_ssao_quality")

  @JvmField
  public val environmentSetSsilQualityName:
      MethodStringName6<RenderingServer, Unit, EnvironmentSSILQuality, Boolean, Float, Int, Float, Float>
      =
      MethodStringName6<RenderingServer, Unit, EnvironmentSSILQuality, Boolean, Float, Int, Float, Float>("environment_set_ssil_quality")

  @JvmField
  public val environmentSetSdfgiRayCountName:
      MethodStringName1<RenderingServer, Unit, EnvironmentSDFGIRayCount> =
      MethodStringName1<RenderingServer, Unit, EnvironmentSDFGIRayCount>("environment_set_sdfgi_ray_count")

  @JvmField
  public val environmentSetSdfgiFramesToConvergeName:
      MethodStringName1<RenderingServer, Unit, EnvironmentSDFGIFramesToConverge> =
      MethodStringName1<RenderingServer, Unit, EnvironmentSDFGIFramesToConverge>("environment_set_sdfgi_frames_to_converge")

  @JvmField
  public val environmentSetSdfgiFramesToUpdateLightName:
      MethodStringName1<RenderingServer, Unit, EnvironmentSDFGIFramesToUpdateLight> =
      MethodStringName1<RenderingServer, Unit, EnvironmentSDFGIFramesToUpdateLight>("environment_set_sdfgi_frames_to_update_light")

  @JvmField
  public val environmentSetVolumetricFogVolumeSizeName:
      MethodStringName2<RenderingServer, Unit, Int, Int> =
      MethodStringName2<RenderingServer, Unit, Int, Int>("environment_set_volumetric_fog_volume_size")

  @JvmField
  public val environmentSetVolumetricFogFilterActiveName:
      MethodStringName1<RenderingServer, Unit, Boolean> =
      MethodStringName1<RenderingServer, Unit, Boolean>("environment_set_volumetric_fog_filter_active")

  @JvmField
  public val environmentBakePanoramaName:
      MethodStringName3<RenderingServer, Image?, RID, Boolean, Vector2i> =
      MethodStringName3<RenderingServer, Image?, RID, Boolean, Vector2i>("environment_bake_panorama")

  @JvmField
  public val screenSpaceRoughnessLimiterSetActiveName:
      MethodStringName3<RenderingServer, Unit, Boolean, Float, Float> =
      MethodStringName3<RenderingServer, Unit, Boolean, Float, Float>("screen_space_roughness_limiter_set_active")

  @JvmField
  public val subSurfaceScatteringSetQualityName:
      MethodStringName1<RenderingServer, Unit, SubSurfaceScatteringQuality> =
      MethodStringName1<RenderingServer, Unit, SubSurfaceScatteringQuality>("sub_surface_scattering_set_quality")

  @JvmField
  public val subSurfaceScatteringSetScaleName:
      MethodStringName2<RenderingServer, Unit, Float, Float> =
      MethodStringName2<RenderingServer, Unit, Float, Float>("sub_surface_scattering_set_scale")

  @JvmField
  public val cameraAttributesCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("camera_attributes_create")

  @JvmField
  public val cameraAttributesSetDofBlurQualityName:
      MethodStringName2<RenderingServer, Unit, DOFBlurQuality, Boolean> =
      MethodStringName2<RenderingServer, Unit, DOFBlurQuality, Boolean>("camera_attributes_set_dof_blur_quality")

  @JvmField
  public val cameraAttributesSetDofBlurBokehShapeName:
      MethodStringName1<RenderingServer, Unit, DOFBokehShape> =
      MethodStringName1<RenderingServer, Unit, DOFBokehShape>("camera_attributes_set_dof_blur_bokeh_shape")

  @JvmField
  public val cameraAttributesSetDofBlurName:
      MethodStringName8<RenderingServer, Unit, RID, Boolean, Float, Float, Boolean, Float, Float, Float>
      =
      MethodStringName8<RenderingServer, Unit, RID, Boolean, Float, Float, Boolean, Float, Float, Float>("camera_attributes_set_dof_blur")

  @JvmField
  public val cameraAttributesSetExposureName:
      MethodStringName3<RenderingServer, Unit, RID, Float, Float> =
      MethodStringName3<RenderingServer, Unit, RID, Float, Float>("camera_attributes_set_exposure")

  @JvmField
  public val cameraAttributesSetAutoExposureName:
      MethodStringName6<RenderingServer, Unit, RID, Boolean, Float, Float, Float, Float> =
      MethodStringName6<RenderingServer, Unit, RID, Boolean, Float, Float, Float, Float>("camera_attributes_set_auto_exposure")

  @JvmField
  public val scenarioCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("scenario_create")

  @JvmField
  public val scenarioSetEnvironmentName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("scenario_set_environment")

  @JvmField
  public val scenarioSetFallbackEnvironmentName: MethodStringName2<RenderingServer, Unit, RID, RID>
      = MethodStringName2<RenderingServer, Unit, RID, RID>("scenario_set_fallback_environment")

  @JvmField
  public val scenarioSetCameraAttributesName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("scenario_set_camera_attributes")

  @JvmField
  public val scenarioSetCompositorName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("scenario_set_compositor")

  @JvmField
  public val instanceCreate2Name: MethodStringName2<RenderingServer, RID, RID, RID> =
      MethodStringName2<RenderingServer, RID, RID, RID>("instance_create2")

  @JvmField
  public val instanceCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("instance_create")

  @JvmField
  public val instanceSetBaseName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("instance_set_base")

  @JvmField
  public val instanceSetScenarioName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("instance_set_scenario")

  @JvmField
  public val instanceSetLayerMaskName: MethodStringName2<RenderingServer, Unit, RID, Long> =
      MethodStringName2<RenderingServer, Unit, RID, Long>("instance_set_layer_mask")

  @JvmField
  public val instanceSetPivotDataName: MethodStringName3<RenderingServer, Unit, RID, Float, Boolean>
      = MethodStringName3<RenderingServer, Unit, RID, Float, Boolean>("instance_set_pivot_data")

  @JvmField
  public val instanceSetTransformName: MethodStringName2<RenderingServer, Unit, RID, Transform3D> =
      MethodStringName2<RenderingServer, Unit, RID, Transform3D>("instance_set_transform")

  @JvmField
  public val instanceAttachObjectInstanceIdName: MethodStringName2<RenderingServer, Unit, RID, Long>
      = MethodStringName2<RenderingServer, Unit, RID, Long>("instance_attach_object_instance_id")

  @JvmField
  public val instanceSetBlendShapeWeightName:
      MethodStringName3<RenderingServer, Unit, RID, Int, Float> =
      MethodStringName3<RenderingServer, Unit, RID, Int, Float>("instance_set_blend_shape_weight")

  @JvmField
  public val instanceSetSurfaceOverrideMaterialName:
      MethodStringName3<RenderingServer, Unit, RID, Int, RID> =
      MethodStringName3<RenderingServer, Unit, RID, Int, RID>("instance_set_surface_override_material")

  @JvmField
  public val instanceSetVisibleName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("instance_set_visible")

  @JvmField
  public val instanceGeometrySetTransparencyName:
      MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("instance_geometry_set_transparency")

  @JvmField
  public val instanceTeleportName: MethodStringName1<RenderingServer, Unit, RID> =
      MethodStringName1<RenderingServer, Unit, RID>("instance_teleport")

  @JvmField
  public val instanceSetCustomAabbName: MethodStringName2<RenderingServer, Unit, RID, AABB> =
      MethodStringName2<RenderingServer, Unit, RID, AABB>("instance_set_custom_aabb")

  @JvmField
  public val instanceAttachSkeletonName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("instance_attach_skeleton")

  @JvmField
  public val instanceSetExtraVisibilityMarginName:
      MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("instance_set_extra_visibility_margin")

  @JvmField
  public val instanceSetVisibilityParentName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("instance_set_visibility_parent")

  @JvmField
  public val instanceSetIgnoreCullingName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("instance_set_ignore_culling")

  @JvmField
  public val instanceGeometrySetFlagName:
      MethodStringName3<RenderingServer, Unit, RID, InstanceFlags, Boolean> =
      MethodStringName3<RenderingServer, Unit, RID, InstanceFlags, Boolean>("instance_geometry_set_flag")

  @JvmField
  public val instanceGeometrySetCastShadowsSettingName:
      MethodStringName2<RenderingServer, Unit, RID, ShadowCastingSetting> =
      MethodStringName2<RenderingServer, Unit, RID, ShadowCastingSetting>("instance_geometry_set_cast_shadows_setting")

  @JvmField
  public val instanceGeometrySetMaterialOverrideName:
      MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("instance_geometry_set_material_override")

  @JvmField
  public val instanceGeometrySetMaterialOverlayName:
      MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("instance_geometry_set_material_overlay")

  @JvmField
  public val instanceGeometrySetVisibilityRangeName:
      MethodStringName6<RenderingServer, Unit, RID, Float, Float, Float, Float, VisibilityRangeFadeMode>
      =
      MethodStringName6<RenderingServer, Unit, RID, Float, Float, Float, Float, VisibilityRangeFadeMode>("instance_geometry_set_visibility_range")

  @JvmField
  public val instanceGeometrySetLightmapName:
      MethodStringName4<RenderingServer, Unit, RID, RID, Rect2, Int> =
      MethodStringName4<RenderingServer, Unit, RID, RID, Rect2, Int>("instance_geometry_set_lightmap")

  @JvmField
  public val instanceGeometrySetLodBiasName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("instance_geometry_set_lod_bias")

  @JvmField
  public val instanceGeometrySetShaderParameterName:
      MethodStringName3<RenderingServer, Unit, RID, StringName, Any?> =
      MethodStringName3<RenderingServer, Unit, RID, StringName, Any?>("instance_geometry_set_shader_parameter")

  @JvmField
  public val instanceGeometryGetShaderParameterName:
      MethodStringName2<RenderingServer, Any?, RID, StringName> =
      MethodStringName2<RenderingServer, Any?, RID, StringName>("instance_geometry_get_shader_parameter")

  @JvmField
  public val instanceGeometryGetShaderParameterDefaultValueName:
      MethodStringName2<RenderingServer, Any?, RID, StringName> =
      MethodStringName2<RenderingServer, Any?, RID, StringName>("instance_geometry_get_shader_parameter_default_value")

  @JvmField
  public val instanceGeometryGetShaderParameterListName:
      MethodStringName1<RenderingServer, VariantArray<Dictionary<Any?, Any?>>, RID> =
      MethodStringName1<RenderingServer, VariantArray<Dictionary<Any?, Any?>>, RID>("instance_geometry_get_shader_parameter_list")

  @JvmField
  public val instancesCullAabbName: MethodStringName2<RenderingServer, PackedInt64Array, AABB, RID>
      = MethodStringName2<RenderingServer, PackedInt64Array, AABB, RID>("instances_cull_aabb")

  @JvmField
  public val instancesCullRayName:
      MethodStringName3<RenderingServer, PackedInt64Array, Vector3, Vector3, RID> =
      MethodStringName3<RenderingServer, PackedInt64Array, Vector3, Vector3, RID>("instances_cull_ray")

  @JvmField
  public val instancesCullConvexName:
      MethodStringName2<RenderingServer, PackedInt64Array, VariantArray<Plane>, RID> =
      MethodStringName2<RenderingServer, PackedInt64Array, VariantArray<Plane>, RID>("instances_cull_convex")

  @JvmField
  public val bakeRenderUv2Name:
      MethodStringName3<RenderingServer, VariantArray<Image>, RID, VariantArray<RID>, Vector2i> =
      MethodStringName3<RenderingServer, VariantArray<Image>, RID, VariantArray<RID>, Vector2i>("bake_render_uv2")

  @JvmField
  public val canvasCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("canvas_create")

  @JvmField
  public val canvasSetItemMirroringName: MethodStringName3<RenderingServer, Unit, RID, RID, Vector2>
      = MethodStringName3<RenderingServer, Unit, RID, RID, Vector2>("canvas_set_item_mirroring")

  @JvmField
  public val canvasSetItemRepeatName: MethodStringName3<RenderingServer, Unit, RID, Vector2, Int> =
      MethodStringName3<RenderingServer, Unit, RID, Vector2, Int>("canvas_set_item_repeat")

  @JvmField
  public val canvasSetModulateName: MethodStringName2<RenderingServer, Unit, RID, Color> =
      MethodStringName2<RenderingServer, Unit, RID, Color>("canvas_set_modulate")

  @JvmField
  public val canvasSetDisableScaleName: MethodStringName1<RenderingServer, Unit, Boolean> =
      MethodStringName1<RenderingServer, Unit, Boolean>("canvas_set_disable_scale")

  @JvmField
  public val canvasTextureCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("canvas_texture_create")

  @JvmField
  public val canvasTextureSetChannelName:
      MethodStringName3<RenderingServer, Unit, RID, CanvasTextureChannel, RID> =
      MethodStringName3<RenderingServer, Unit, RID, CanvasTextureChannel, RID>("canvas_texture_set_channel")

  @JvmField
  public val canvasTextureSetShadingParametersName:
      MethodStringName3<RenderingServer, Unit, RID, Color, Float> =
      MethodStringName3<RenderingServer, Unit, RID, Color, Float>("canvas_texture_set_shading_parameters")

  @JvmField
  public val canvasTextureSetTextureFilterName:
      MethodStringName2<RenderingServer, Unit, RID, CanvasItemTextureFilter> =
      MethodStringName2<RenderingServer, Unit, RID, CanvasItemTextureFilter>("canvas_texture_set_texture_filter")

  @JvmField
  public val canvasTextureSetTextureRepeatName:
      MethodStringName2<RenderingServer, Unit, RID, CanvasItemTextureRepeat> =
      MethodStringName2<RenderingServer, Unit, RID, CanvasItemTextureRepeat>("canvas_texture_set_texture_repeat")

  @JvmField
  public val canvasItemCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("canvas_item_create")

  @JvmField
  public val canvasItemSetParentName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("canvas_item_set_parent")

  @JvmField
  public val canvasItemSetDefaultTextureFilterName:
      MethodStringName2<RenderingServer, Unit, RID, CanvasItemTextureFilter> =
      MethodStringName2<RenderingServer, Unit, RID, CanvasItemTextureFilter>("canvas_item_set_default_texture_filter")

  @JvmField
  public val canvasItemSetDefaultTextureRepeatName:
      MethodStringName2<RenderingServer, Unit, RID, CanvasItemTextureRepeat> =
      MethodStringName2<RenderingServer, Unit, RID, CanvasItemTextureRepeat>("canvas_item_set_default_texture_repeat")

  @JvmField
  public val canvasItemSetVisibleName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("canvas_item_set_visible")

  @JvmField
  public val canvasItemSetLightMaskName: MethodStringName2<RenderingServer, Unit, RID, Int> =
      MethodStringName2<RenderingServer, Unit, RID, Int>("canvas_item_set_light_mask")

  @JvmField
  public val canvasItemSetVisibilityLayerName: MethodStringName2<RenderingServer, Unit, RID, Long> =
      MethodStringName2<RenderingServer, Unit, RID, Long>("canvas_item_set_visibility_layer")

  @JvmField
  public val canvasItemSetTransformName: MethodStringName2<RenderingServer, Unit, RID, Transform2D>
      = MethodStringName2<RenderingServer, Unit, RID, Transform2D>("canvas_item_set_transform")

  @JvmField
  public val canvasItemSetClipName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("canvas_item_set_clip")

  @JvmField
  public val canvasItemSetDistanceFieldModeName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("canvas_item_set_distance_field_mode")

  @JvmField
  public val canvasItemSetCustomRectName:
      MethodStringName3<RenderingServer, Unit, RID, Boolean, Rect2> =
      MethodStringName3<RenderingServer, Unit, RID, Boolean, Rect2>("canvas_item_set_custom_rect")

  @JvmField
  public val canvasItemSetModulateName: MethodStringName2<RenderingServer, Unit, RID, Color> =
      MethodStringName2<RenderingServer, Unit, RID, Color>("canvas_item_set_modulate")

  @JvmField
  public val canvasItemSetSelfModulateName: MethodStringName2<RenderingServer, Unit, RID, Color> =
      MethodStringName2<RenderingServer, Unit, RID, Color>("canvas_item_set_self_modulate")

  @JvmField
  public val canvasItemSetDrawBehindParentName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("canvas_item_set_draw_behind_parent")

  @JvmField
  public val canvasItemSetInterpolatedName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("canvas_item_set_interpolated")

  @JvmField
  public val canvasItemResetPhysicsInterpolationName: MethodStringName1<RenderingServer, Unit, RID>
      = MethodStringName1<RenderingServer, Unit, RID>("canvas_item_reset_physics_interpolation")

  @JvmField
  public val canvasItemTransformPhysicsInterpolationName:
      MethodStringName2<RenderingServer, Unit, RID, Transform2D> =
      MethodStringName2<RenderingServer, Unit, RID, Transform2D>("canvas_item_transform_physics_interpolation")

  @JvmField
  public val canvasItemAddLineName:
      MethodStringName6<RenderingServer, Unit, RID, Vector2, Vector2, Color, Float, Boolean> =
      MethodStringName6<RenderingServer, Unit, RID, Vector2, Vector2, Color, Float, Boolean>("canvas_item_add_line")

  @JvmField
  public val canvasItemAddPolylineName:
      MethodStringName5<RenderingServer, Unit, RID, PackedVector2Array, PackedColorArray, Float, Boolean>
      =
      MethodStringName5<RenderingServer, Unit, RID, PackedVector2Array, PackedColorArray, Float, Boolean>("canvas_item_add_polyline")

  @JvmField
  public val canvasItemAddMultilineName:
      MethodStringName5<RenderingServer, Unit, RID, PackedVector2Array, PackedColorArray, Float, Boolean>
      =
      MethodStringName5<RenderingServer, Unit, RID, PackedVector2Array, PackedColorArray, Float, Boolean>("canvas_item_add_multiline")

  @JvmField
  public val canvasItemAddRectName:
      MethodStringName4<RenderingServer, Unit, RID, Rect2, Color, Boolean> =
      MethodStringName4<RenderingServer, Unit, RID, Rect2, Color, Boolean>("canvas_item_add_rect")

  @JvmField
  public val canvasItemAddCircleName:
      MethodStringName5<RenderingServer, Unit, RID, Vector2, Float, Color, Boolean> =
      MethodStringName5<RenderingServer, Unit, RID, Vector2, Float, Color, Boolean>("canvas_item_add_circle")

  @JvmField
  public val canvasItemAddEllipseName:
      MethodStringName6<RenderingServer, Unit, RID, Vector2, Float, Float, Color, Boolean> =
      MethodStringName6<RenderingServer, Unit, RID, Vector2, Float, Float, Color, Boolean>("canvas_item_add_ellipse")

  @JvmField
  public val canvasItemAddTextureRectName:
      MethodStringName6<RenderingServer, Unit, RID, Rect2, RID, Boolean, Color, Boolean> =
      MethodStringName6<RenderingServer, Unit, RID, Rect2, RID, Boolean, Color, Boolean>("canvas_item_add_texture_rect")

  @JvmField
  public val canvasItemAddMsdfTextureRectRegionName:
      MethodStringName8<RenderingServer, Unit, RID, Rect2, RID, Rect2, Color, Int, Float, Float> =
      MethodStringName8<RenderingServer, Unit, RID, Rect2, RID, Rect2, Color, Int, Float, Float>("canvas_item_add_msdf_texture_rect_region")

  @JvmField
  public val canvasItemAddLcdTextureRectRegionName:
      MethodStringName5<RenderingServer, Unit, RID, Rect2, RID, Rect2, Color> =
      MethodStringName5<RenderingServer, Unit, RID, Rect2, RID, Rect2, Color>("canvas_item_add_lcd_texture_rect_region")

  @JvmField
  public val canvasItemAddTextureRectRegionName:
      MethodStringName7<RenderingServer, Unit, RID, Rect2, RID, Rect2, Color, Boolean, Boolean> =
      MethodStringName7<RenderingServer, Unit, RID, Rect2, RID, Rect2, Color, Boolean, Boolean>("canvas_item_add_texture_rect_region")

  @JvmField
  public val canvasItemAddNinePatchName:
      MethodStringName10<RenderingServer, Unit, RID, Rect2, Rect2, RID, Vector2, Vector2, NinePatchAxisMode, NinePatchAxisMode, Boolean, Color>
      =
      MethodStringName10<RenderingServer, Unit, RID, Rect2, Rect2, RID, Vector2, Vector2, NinePatchAxisMode, NinePatchAxisMode, Boolean, Color>("canvas_item_add_nine_patch")

  @JvmField
  public val canvasItemAddPrimitiveName:
      MethodStringName5<RenderingServer, Unit, RID, PackedVector2Array, PackedColorArray, PackedVector2Array, RID>
      =
      MethodStringName5<RenderingServer, Unit, RID, PackedVector2Array, PackedColorArray, PackedVector2Array, RID>("canvas_item_add_primitive")

  @JvmField
  public val canvasItemAddPolygonName:
      MethodStringName5<RenderingServer, Unit, RID, PackedVector2Array, PackedColorArray, PackedVector2Array, RID>
      =
      MethodStringName5<RenderingServer, Unit, RID, PackedVector2Array, PackedColorArray, PackedVector2Array, RID>("canvas_item_add_polygon")

  @JvmField
  public val canvasItemAddTriangleArrayName:
      MethodStringName9<RenderingServer, Unit, RID, PackedInt32Array, PackedVector2Array, PackedColorArray, PackedVector2Array, PackedInt32Array, PackedFloat32Array, RID, Int>
      =
      MethodStringName9<RenderingServer, Unit, RID, PackedInt32Array, PackedVector2Array, PackedColorArray, PackedVector2Array, PackedInt32Array, PackedFloat32Array, RID, Int>("canvas_item_add_triangle_array")

  @JvmField
  public val canvasItemAddMeshName:
      MethodStringName5<RenderingServer, Unit, RID, RID, Transform2D, Color, RID> =
      MethodStringName5<RenderingServer, Unit, RID, RID, Transform2D, Color, RID>("canvas_item_add_mesh")

  @JvmField
  public val canvasItemAddMultimeshName: MethodStringName3<RenderingServer, Unit, RID, RID, RID> =
      MethodStringName3<RenderingServer, Unit, RID, RID, RID>("canvas_item_add_multimesh")

  @JvmField
  public val canvasItemAddParticlesName: MethodStringName3<RenderingServer, Unit, RID, RID, RID> =
      MethodStringName3<RenderingServer, Unit, RID, RID, RID>("canvas_item_add_particles")

  @JvmField
  public val canvasItemAddSetTransformName:
      MethodStringName2<RenderingServer, Unit, RID, Transform2D> =
      MethodStringName2<RenderingServer, Unit, RID, Transform2D>("canvas_item_add_set_transform")

  @JvmField
  public val canvasItemAddClipIgnoreName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("canvas_item_add_clip_ignore")

  @JvmField
  public val canvasItemAddAnimationSliceName:
      MethodStringName5<RenderingServer, Unit, RID, Double, Double, Double, Double> =
      MethodStringName5<RenderingServer, Unit, RID, Double, Double, Double, Double>("canvas_item_add_animation_slice")

  @JvmField
  public val canvasItemSetSortChildrenByYName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("canvas_item_set_sort_children_by_y")

  @JvmField
  public val canvasItemSetZIndexName: MethodStringName2<RenderingServer, Unit, RID, Int> =
      MethodStringName2<RenderingServer, Unit, RID, Int>("canvas_item_set_z_index")

  @JvmField
  public val canvasItemSetZAsRelativeToParentName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("canvas_item_set_z_as_relative_to_parent")

  @JvmField
  public val canvasItemSetCopyToBackbufferName:
      MethodStringName3<RenderingServer, Unit, RID, Boolean, Rect2> =
      MethodStringName3<RenderingServer, Unit, RID, Boolean, Rect2>("canvas_item_set_copy_to_backbuffer")

  @JvmField
  public val canvasItemAttachSkeletonName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("canvas_item_attach_skeleton")

  @JvmField
  public val canvasItemClearName: MethodStringName1<RenderingServer, Unit, RID> =
      MethodStringName1<RenderingServer, Unit, RID>("canvas_item_clear")

  @JvmField
  public val canvasItemSetDrawIndexName: MethodStringName2<RenderingServer, Unit, RID, Int> =
      MethodStringName2<RenderingServer, Unit, RID, Int>("canvas_item_set_draw_index")

  @JvmField
  public val canvasItemSetMaterialName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("canvas_item_set_material")

  @JvmField
  public val canvasItemSetUseParentMaterialName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("canvas_item_set_use_parent_material")

  @JvmField
  public val canvasItemSetInstanceShaderParameterName:
      MethodStringName3<RenderingServer, Unit, RID, StringName, Any?> =
      MethodStringName3<RenderingServer, Unit, RID, StringName, Any?>("canvas_item_set_instance_shader_parameter")

  @JvmField
  public val canvasItemGetInstanceShaderParameterName:
      MethodStringName2<RenderingServer, Any?, RID, StringName> =
      MethodStringName2<RenderingServer, Any?, RID, StringName>("canvas_item_get_instance_shader_parameter")

  @JvmField
  public val canvasItemGetInstanceShaderParameterDefaultValueName:
      MethodStringName2<RenderingServer, Any?, RID, StringName> =
      MethodStringName2<RenderingServer, Any?, RID, StringName>("canvas_item_get_instance_shader_parameter_default_value")

  @JvmField
  public val canvasItemGetInstanceShaderParameterListName:
      MethodStringName1<RenderingServer, VariantArray<Dictionary<Any?, Any?>>, RID> =
      MethodStringName1<RenderingServer, VariantArray<Dictionary<Any?, Any?>>, RID>("canvas_item_get_instance_shader_parameter_list")

  @JvmField
  public val canvasItemSetVisibilityNotifierName:
      MethodStringName5<RenderingServer, Unit, RID, Boolean, Rect2, Callable, Callable> =
      MethodStringName5<RenderingServer, Unit, RID, Boolean, Rect2, Callable, Callable>("canvas_item_set_visibility_notifier")

  @JvmField
  public val canvasItemSetCanvasGroupModeName:
      MethodStringName6<RenderingServer, Unit, RID, CanvasGroupMode, Float, Boolean, Float, Boolean>
      =
      MethodStringName6<RenderingServer, Unit, RID, CanvasGroupMode, Float, Boolean, Float, Boolean>("canvas_item_set_canvas_group_mode")

  @JvmField
  public val debugCanvasItemGetRectName: MethodStringName1<RenderingServer, Rect2, RID> =
      MethodStringName1<RenderingServer, Rect2, RID>("debug_canvas_item_get_rect")

  @JvmField
  public val canvasLightCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("canvas_light_create")

  @JvmField
  public val canvasLightAttachToCanvasName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("canvas_light_attach_to_canvas")

  @JvmField
  public val canvasLightSetEnabledName: MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("canvas_light_set_enabled")

  @JvmField
  public val canvasLightSetTextureScaleName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("canvas_light_set_texture_scale")

  @JvmField
  public val canvasLightSetTransformName: MethodStringName2<RenderingServer, Unit, RID, Transform2D>
      = MethodStringName2<RenderingServer, Unit, RID, Transform2D>("canvas_light_set_transform")

  @JvmField
  public val canvasLightSetTextureName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("canvas_light_set_texture")

  @JvmField
  public val canvasLightSetTextureOffsetName: MethodStringName2<RenderingServer, Unit, RID, Vector2>
      = MethodStringName2<RenderingServer, Unit, RID, Vector2>("canvas_light_set_texture_offset")

  @JvmField
  public val canvasLightSetColorName: MethodStringName2<RenderingServer, Unit, RID, Color> =
      MethodStringName2<RenderingServer, Unit, RID, Color>("canvas_light_set_color")

  @JvmField
  public val canvasLightSetHeightName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("canvas_light_set_height")

  @JvmField
  public val canvasLightSetEnergyName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("canvas_light_set_energy")

  @JvmField
  public val canvasLightSetZRangeName: MethodStringName3<RenderingServer, Unit, RID, Int, Int> =
      MethodStringName3<RenderingServer, Unit, RID, Int, Int>("canvas_light_set_z_range")

  @JvmField
  public val canvasLightSetLayerRangeName: MethodStringName3<RenderingServer, Unit, RID, Int, Int> =
      MethodStringName3<RenderingServer, Unit, RID, Int, Int>("canvas_light_set_layer_range")

  @JvmField
  public val canvasLightSetItemCullMaskName: MethodStringName2<RenderingServer, Unit, RID, Int> =
      MethodStringName2<RenderingServer, Unit, RID, Int>("canvas_light_set_item_cull_mask")

  @JvmField
  public val canvasLightSetItemShadowCullMaskName:
      MethodStringName2<RenderingServer, Unit, RID, Int> =
      MethodStringName2<RenderingServer, Unit, RID, Int>("canvas_light_set_item_shadow_cull_mask")

  @JvmField
  public val canvasLightSetModeName: MethodStringName2<RenderingServer, Unit, RID, CanvasLightMode>
      = MethodStringName2<RenderingServer, Unit, RID, CanvasLightMode>("canvas_light_set_mode")

  @JvmField
  public val canvasLightSetShadowEnabledName: MethodStringName2<RenderingServer, Unit, RID, Boolean>
      = MethodStringName2<RenderingServer, Unit, RID, Boolean>("canvas_light_set_shadow_enabled")

  @JvmField
  public val canvasLightSetShadowFilterName:
      MethodStringName2<RenderingServer, Unit, RID, CanvasLightShadowFilter> =
      MethodStringName2<RenderingServer, Unit, RID, CanvasLightShadowFilter>("canvas_light_set_shadow_filter")

  @JvmField
  public val canvasLightSetShadowColorName: MethodStringName2<RenderingServer, Unit, RID, Color> =
      MethodStringName2<RenderingServer, Unit, RID, Color>("canvas_light_set_shadow_color")

  @JvmField
  public val canvasLightSetShadowSmoothName: MethodStringName2<RenderingServer, Unit, RID, Float> =
      MethodStringName2<RenderingServer, Unit, RID, Float>("canvas_light_set_shadow_smooth")

  @JvmField
  public val canvasLightSetBlendModeName:
      MethodStringName2<RenderingServer, Unit, RID, CanvasLightBlendMode> =
      MethodStringName2<RenderingServer, Unit, RID, CanvasLightBlendMode>("canvas_light_set_blend_mode")

  @JvmField
  public val canvasLightSetInterpolatedName: MethodStringName2<RenderingServer, Unit, RID, Boolean>
      = MethodStringName2<RenderingServer, Unit, RID, Boolean>("canvas_light_set_interpolated")

  @JvmField
  public val canvasLightResetPhysicsInterpolationName: MethodStringName1<RenderingServer, Unit, RID>
      = MethodStringName1<RenderingServer, Unit, RID>("canvas_light_reset_physics_interpolation")

  @JvmField
  public val canvasLightTransformPhysicsInterpolationName:
      MethodStringName2<RenderingServer, Unit, RID, Transform2D> =
      MethodStringName2<RenderingServer, Unit, RID, Transform2D>("canvas_light_transform_physics_interpolation")

  @JvmField
  public val canvasLightOccluderCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("canvas_light_occluder_create")

  @JvmField
  public val canvasLightOccluderAttachToCanvasName:
      MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("canvas_light_occluder_attach_to_canvas")

  @JvmField
  public val canvasLightOccluderSetEnabledName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("canvas_light_occluder_set_enabled")

  @JvmField
  public val canvasLightOccluderSetPolygonName: MethodStringName2<RenderingServer, Unit, RID, RID> =
      MethodStringName2<RenderingServer, Unit, RID, RID>("canvas_light_occluder_set_polygon")

  @JvmField
  public val canvasLightOccluderSetAsSdfCollisionName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("canvas_light_occluder_set_as_sdf_collision")

  @JvmField
  public val canvasLightOccluderSetTransformName:
      MethodStringName2<RenderingServer, Unit, RID, Transform2D> =
      MethodStringName2<RenderingServer, Unit, RID, Transform2D>("canvas_light_occluder_set_transform")

  @JvmField
  public val canvasLightOccluderSetLightMaskName: MethodStringName2<RenderingServer, Unit, RID, Int>
      = MethodStringName2<RenderingServer, Unit, RID, Int>("canvas_light_occluder_set_light_mask")

  @JvmField
  public val canvasLightOccluderSetInterpolatedName:
      MethodStringName2<RenderingServer, Unit, RID, Boolean> =
      MethodStringName2<RenderingServer, Unit, RID, Boolean>("canvas_light_occluder_set_interpolated")

  @JvmField
  public val canvasLightOccluderResetPhysicsInterpolationName:
      MethodStringName1<RenderingServer, Unit, RID> =
      MethodStringName1<RenderingServer, Unit, RID>("canvas_light_occluder_reset_physics_interpolation")

  @JvmField
  public val canvasLightOccluderTransformPhysicsInterpolationName:
      MethodStringName2<RenderingServer, Unit, RID, Transform2D> =
      MethodStringName2<RenderingServer, Unit, RID, Transform2D>("canvas_light_occluder_transform_physics_interpolation")

  @JvmField
  public val canvasOccluderPolygonCreateName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("canvas_occluder_polygon_create")

  @JvmField
  public val canvasOccluderPolygonSetShapeName:
      MethodStringName3<RenderingServer, Unit, RID, PackedVector2Array, Boolean> =
      MethodStringName3<RenderingServer, Unit, RID, PackedVector2Array, Boolean>("canvas_occluder_polygon_set_shape")

  @JvmField
  public val canvasOccluderPolygonSetCullModeName:
      MethodStringName2<RenderingServer, Unit, RID, CanvasOccluderPolygonCullMode> =
      MethodStringName2<RenderingServer, Unit, RID, CanvasOccluderPolygonCullMode>("canvas_occluder_polygon_set_cull_mode")

  @JvmField
  public val canvasSetShadowTextureSizeName: MethodStringName1<RenderingServer, Unit, Int> =
      MethodStringName1<RenderingServer, Unit, Int>("canvas_set_shadow_texture_size")

  @JvmField
  public val globalShaderParameterAddName:
      MethodStringName3<RenderingServer, Unit, StringName, GlobalShaderParameterType, Any?> =
      MethodStringName3<RenderingServer, Unit, StringName, GlobalShaderParameterType, Any?>("global_shader_parameter_add")

  @JvmField
  public val globalShaderParameterRemoveName: MethodStringName1<RenderingServer, Unit, StringName> =
      MethodStringName1<RenderingServer, Unit, StringName>("global_shader_parameter_remove")

  @JvmField
  public val globalShaderParameterGetListName:
      MethodStringName0<RenderingServer, VariantArray<StringName>> =
      MethodStringName0<RenderingServer, VariantArray<StringName>>("global_shader_parameter_get_list")

  @JvmField
  public val globalShaderParameterSetName:
      MethodStringName2<RenderingServer, Unit, StringName, Any?> =
      MethodStringName2<RenderingServer, Unit, StringName, Any?>("global_shader_parameter_set")

  @JvmField
  public val globalShaderParameterSetOverrideName:
      MethodStringName2<RenderingServer, Unit, StringName, Any?> =
      MethodStringName2<RenderingServer, Unit, StringName, Any?>("global_shader_parameter_set_override")

  @JvmField
  public val globalShaderParameterGetName: MethodStringName1<RenderingServer, Any?, StringName> =
      MethodStringName1<RenderingServer, Any?, StringName>("global_shader_parameter_get")

  @JvmField
  public val globalShaderParameterGetTypeName:
      MethodStringName1<RenderingServer, GlobalShaderParameterType, StringName> =
      MethodStringName1<RenderingServer, GlobalShaderParameterType, StringName>("global_shader_parameter_get_type")

  @JvmField
  public val freeRidName: MethodStringName1<RenderingServer, Unit, RID> =
      MethodStringName1<RenderingServer, Unit, RID>("free_rid")

  @JvmField
  public val requestFrameDrawnCallbackName: MethodStringName1<RenderingServer, Unit, Callable> =
      MethodStringName1<RenderingServer, Unit, Callable>("request_frame_drawn_callback")

  @JvmField
  public val hasChangedName: MethodStringName0<RenderingServer, Boolean> =
      MethodStringName0<RenderingServer, Boolean>("has_changed")

  @JvmField
  public val getRenderingInfoName: MethodStringName1<RenderingServer, Long, RenderingInfo> =
      MethodStringName1<RenderingServer, Long, RenderingInfo>("get_rendering_info")

  @JvmField
  public val getVideoAdapterNameName: MethodStringName0<RenderingServer, String> =
      MethodStringName0<RenderingServer, String>("get_video_adapter_name")

  @JvmField
  public val getVideoAdapterVendorName: MethodStringName0<RenderingServer, String> =
      MethodStringName0<RenderingServer, String>("get_video_adapter_vendor")

  @JvmField
  public val getVideoAdapterTypeName: MethodStringName0<RenderingServer, RenderingDevice.DeviceType>
      = MethodStringName0<RenderingServer, RenderingDevice.DeviceType>("get_video_adapter_type")

  @JvmField
  public val getVideoAdapterApiVersionName: MethodStringName0<RenderingServer, String> =
      MethodStringName0<RenderingServer, String>("get_video_adapter_api_version")

  @JvmField
  public val getCurrentRenderingDriverNameName: MethodStringName0<RenderingServer, String> =
      MethodStringName0<RenderingServer, String>("get_current_rendering_driver_name")

  @JvmField
  public val getCurrentRenderingMethodName: MethodStringName0<RenderingServer, String> =
      MethodStringName0<RenderingServer, String>("get_current_rendering_method")

  @JvmField
  public val makeSphereMeshName: MethodStringName3<RenderingServer, RID, Int, Int, Float> =
      MethodStringName3<RenderingServer, RID, Int, Int, Float>("make_sphere_mesh")

  @JvmField
  public val getTestCubeName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("get_test_cube")

  @JvmField
  public val getTestTextureName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("get_test_texture")

  @JvmField
  public val getWhiteTextureName: MethodStringName0<RenderingServer, RID> =
      MethodStringName0<RenderingServer, RID>("get_white_texture")

  @JvmField
  public val setBootImageWithStretchName:
      MethodStringName4<RenderingServer, Unit, Image?, Color, SplashStretchMode, Boolean> =
      MethodStringName4<RenderingServer, Unit, Image?, Color, SplashStretchMode, Boolean>("set_boot_image_with_stretch")

  @JvmField
  public val setBootImageName:
      MethodStringName4<RenderingServer, Unit, Image?, Color, Boolean, Boolean> =
      MethodStringName4<RenderingServer, Unit, Image?, Color, Boolean, Boolean>("set_boot_image")

  @JvmField
  public val getDefaultClearColorName: MethodStringName0<RenderingServer, Color> =
      MethodStringName0<RenderingServer, Color>("get_default_clear_color")

  @JvmField
  public val setDefaultClearColorName: MethodStringName1<RenderingServer, Unit, Color> =
      MethodStringName1<RenderingServer, Unit, Color>("set_default_clear_color")

  @JvmField
  public val hasOsFeatureName: MethodStringName1<RenderingServer, Boolean, String> =
      MethodStringName1<RenderingServer, Boolean, String>("has_os_feature")

  @JvmField
  public val setDebugGenerateWireframesName: MethodStringName1<RenderingServer, Unit, Boolean> =
      MethodStringName1<RenderingServer, Unit, Boolean>("set_debug_generate_wireframes")

  @JvmField
  public val isRenderLoopEnabledName: MethodStringName0<RenderingServer, Boolean> =
      MethodStringName0<RenderingServer, Boolean>("is_render_loop_enabled")

  @JvmField
  public val setRenderLoopEnabledName: MethodStringName1<RenderingServer, Unit, Boolean> =
      MethodStringName1<RenderingServer, Unit, Boolean>("set_render_loop_enabled")

  @JvmField
  public val getFrameSetupTimeCpuName: MethodStringName0<RenderingServer, Double> =
      MethodStringName0<RenderingServer, Double>("get_frame_setup_time_cpu")

  @JvmField
  public val forceSyncName: MethodStringName0<RenderingServer, Unit> =
      MethodStringName0<RenderingServer, Unit>("force_sync")

  @JvmField
  public val forceDrawName: MethodStringName2<RenderingServer, Unit, Boolean, Double> =
      MethodStringName2<RenderingServer, Unit, Boolean, Double>("force_draw")

  @JvmField
  public val getRenderingDeviceName: MethodStringName0<RenderingServer, RenderingDevice?> =
      MethodStringName0<RenderingServer, RenderingDevice?>("get_rendering_device")

  @JvmField
  public val createLocalRenderingDeviceName: MethodStringName0<RenderingServer, RenderingDevice?> =
      MethodStringName0<RenderingServer, RenderingDevice?>("create_local_rendering_device")

  @JvmField
  public val isOnRenderThreadName: MethodStringName0<RenderingServer, Boolean> =
      MethodStringName0<RenderingServer, Boolean>("is_on_render_thread")

  @JvmField
  public val callOnRenderThreadName: MethodStringName1<RenderingServer, Unit, Callable> =
      MethodStringName1<RenderingServer, Unit, Callable>("call_on_render_thread")

  @JvmField
  public val hasFeatureName: MethodStringName1<RenderingServer, Boolean, Features> =
      MethodStringName1<RenderingServer, Boolean, Features>("has_feature")

  /**
   * Emitted at the beginning of the frame, before the RenderingServer updates all the Viewports.
   */
  @JvmStatic
  public val framePreDraw: Signal0 by Signal0

  /**
   * Emitted at the end of the frame, after the RenderingServer has finished updating all the
   * Viewports.
   */
  @JvmStatic
  public val framePostDraw: Signal0 by Signal0

  /**
   * If `false`, disables rendering completely, but the engine logic is still being processed. You
   * can call [forceDraw] to draw a frame even with rendering disabled.
   */
  @JvmStatic
  public final inline var renderLoopEnabled: Boolean
    @JvmName("renderLoopEnabledProperty")
    get() = isRenderLoopEnabled()
    @JvmName("renderLoopEnabledProperty")
    set(`value`) {
      setRenderLoopEnabled(value)
    }

  /**
   * Marks an error that shows that the index array is empty.
   */
  public final const val NO_INDEX_ARRAY: Long = -1

  /**
   * Number of weights/bones per vertex.
   */
  public final const val ARRAY_WEIGHTS_SIZE: Long = 4

  /**
   * The minimum Z-layer for canvas items.
   */
  public final const val CANVAS_ITEM_Z_MIN: Long = -4096

  /**
   * The maximum Z-layer for canvas items.
   */
  public final const val CANVAS_ITEM_Z_MAX: Long = 4096

  /**
   * The minimum canvas layer.
   */
  public final const val CANVAS_LAYER_MIN: Long = -2147483648

  /**
   * The maximum canvas layer.
   */
  public final const val CANVAS_LAYER_MAX: Long = 2147483647

  /**
   * The maximum number of glow levels that can be used with the glow post-processing effect.
   */
  public final const val MAX_GLOW_LEVELS: Long = 7

  public final const val MAX_CURSORS: Long = 8

  /**
   * The maximum number of directional lights that can be rendered at a given time in 2D.
   */
  public final const val MAX_2D_DIRECTIONAL_LIGHTS: Long = 8

  /**
   * The maximum number of surfaces a mesh can have.
   */
  public final const val MAX_MESH_SURFACES: Long = 256

  /**
   * The minimum renderpriority of all materials.
   */
  public final const val MATERIAL_RENDER_PRIORITY_MIN: Long = -128

  /**
   * The maximum renderpriority of all materials.
   */
  public final const val MATERIAL_RENDER_PRIORITY_MAX: Long = 127

  /**
   * The number of custom data arrays available ([ARRAY_CUSTOM0], [ARRAY_CUSTOM1], [ARRAY_CUSTOM2],
   * [ARRAY_CUSTOM3]).
   */
  public final const val ARRAY_CUSTOM_COUNT: Long = 4

  /**
   * Particle starts at the specified position.
   */
  public final const val PARTICLES_EMIT_FLAG_POSITION: Long = 1

  /**
   * Particle starts with specified rotation and scale.
   */
  public final const val PARTICLES_EMIT_FLAG_ROTATION_SCALE: Long = 2

  /**
   * Particle starts with the specified velocity vector, which defines the emission direction and
   * speed.
   */
  public final const val PARTICLES_EMIT_FLAG_VELOCITY: Long = 4

  /**
   * Particle starts with specified color.
   */
  public final const val PARTICLES_EMIT_FLAG_COLOR: Long = 8

  /**
   * Particle starts with specified `CUSTOM` data.
   */
  public final const val PARTICLES_EMIT_FLAG_CUSTOM: Long = 16

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(29)
  }

  /**
   * Creates a 2-dimensional texture and adds it to the RenderingServer. It can be accessed with the
   * RID that is returned. This RID will be used in all `texture_2d_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent resource is [Texture2D].
   *
   * **Note:** Not to be confused with [RenderingDevice.textureCreate], which creates the graphics
   * API's own texture type as opposed to the Godot-specific [Texture2D] resource.
   */
  @JvmStatic
  public final fun texture2dCreate(image: Image?): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to image)
    TransferContext.callMethod(MethodBindings.texture2dCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a 2-dimensional layered texture and adds it to the RenderingServer. It can be accessed
   * with the RID that is returned. This RID will be used in all `texture_2d_layered_*` RenderingServer
   * functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent resource is [TextureLayered].
   */
  @JvmStatic
  public final fun texture2dLayeredCreate(layers: VariantArray<Image>,
      layeredType: TextureLayeredType): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to layers, LONG to layeredType.value)
    TransferContext.callMethod(MethodBindings.texture2dLayeredCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * **Note:** The equivalent resource is [Texture3D].
   */
  @JvmStatic
  public final fun texture3dCreate(
    format: Image.Format,
    width: Int,
    height: Int,
    depth: Int,
    mipmaps: Boolean,
    `data`: VariantArray<Image>,
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to format.value, LONG to width.toLong(), LONG to height.toLong(), LONG to depth.toLong(), BOOL to mipmaps, ARRAY to data)
    TransferContext.callMethod(MethodBindings.texture3dCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * This method does nothing and always returns an invalid [RID].
   */
  @JvmStatic
  public final fun textureProxyCreate(base: RID): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to base)
    TransferContext.callMethod(MethodBindings.textureProxyCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a texture based on a native handle that was created outside of Godot's renderer.
   *
   * **Note:** If using only the rendering device renderer, it's recommend to use
   * [RenderingDevice.textureCreateFromExtension] together with [RenderingServer.textureRdCreate],
   * rather than this method. This way, the texture's format and usage can be controlled more
   * effectively.
   */
  @JvmOverloads
  @JvmStatic
  public final fun textureCreateFromNativeHandle(
    type: TextureType,
    format: Image.Format,
    nativeHandle: Long,
    width: Int,
    height: Int,
    depth: Int,
    layers: Int = 1,
    layeredType: TextureLayeredType = RenderingServer.TextureLayeredType.TEXTURE_LAYERED_2D_ARRAY,
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, LONG to format.value, LONG to nativeHandle, LONG to width.toLong(), LONG to height.toLong(), LONG to depth.toLong(), LONG to layers.toLong(), LONG to layeredType.value)
    TransferContext.callMethod(MethodBindings.textureCreateFromNativeHandlePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a 2-dimensional texture and adds it to the RenderingServer. It can be accessed with the
   * RID that is returned. This RID will be used in all `texture_drawable*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent resource is [DrawableTexture2D].
   */
  @JvmOverloads
  @JvmStatic
  public final fun textureDrawableCreate(
    width: Int,
    height: Int,
    format: TextureDrawableFormat,
    color: Color = Color(Color(1, 1, 1, 1)),
    withMipmaps: Boolean = false,
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to width.toLong(), LONG to height.toLong(), LONG to format.value, COLOR to color, BOOL to withMipmaps)
    TransferContext.callMethod(MethodBindings.textureDrawableCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Updates the texture specified by the [texture] [RID] with the data in [image]. A [layer] must
   * also be specified, which should be `0` when updating a single-layer texture ([Texture2D]).
   *
   * **Note:** The [image] must have the same width, height and format as the current [texture]
   * data. Otherwise, an error will be printed and the original texture won't be modified. If you need
   * to use different width, height or format, use [textureReplace] instead.
   */
  @JvmStatic
  public final fun texture2dUpdate(
    texture: RID,
    image: Image?,
    layer: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture, OBJECT to image, LONG to layer.toLong())
    TransferContext.callMethod(MethodBindings.texture2dUpdatePtr)
  }

  /**
   * Updates the texture specified by the [texture] [RID]'s data with the data in [data]. All the
   * texture's layers must be replaced at once.
   *
   * **Note:** The [texture] must have the same width, height, depth and format as the current
   * texture data. Otherwise, an error will be printed and the original texture won't be modified. If
   * you need to use different width, height, depth or format, use [textureReplace] instead.
   */
  @JvmStatic
  public final fun texture3dUpdate(texture: RID, `data`: VariantArray<Image>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture, ARRAY to data)
    TransferContext.callMethod(MethodBindings.texture3dUpdatePtr)
  }

  /**
   * This method does nothing.
   */
  @JvmStatic
  public final fun textureProxyUpdate(texture: RID, proxyTo: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture, _RID to proxyTo)
    TransferContext.callMethod(MethodBindings.textureProxyUpdatePtr)
  }

  /**
   * Draws to [rect] on up to 4 given Drawable [textures], using a TextureBlit Shader from
   * [material]. [modulate] and up to 4 [sourceTextures] are uniforms for the Shader to process with.
   * [toMipmap] can specify to perform this draw to a lower mipmap level.
   *
   * **Note:** All [textures] must be the same size and format.
   */
  @JvmOverloads
  @JvmStatic
  public final fun textureDrawableBlitRect(
    textures: VariantArray<RID>,
    rect: Rect2i,
    material: RID,
    modulate: Color,
    sourceTextures: VariantArray<RID>,
    toMipmap: Int = 0,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to textures, RECT2I to rect, _RID to material, COLOR to modulate, ARRAY to sourceTextures, LONG to toMipmap.toLong())
    TransferContext.callMethod(MethodBindings.textureDrawableBlitRectPtr)
  }

  /**
   * Creates a placeholder for a 2-dimensional layered texture and adds it to the RenderingServer.
   * It can be accessed with the RID that is returned. This RID will be used in all
   * `texture_2d_layered_*` RenderingServer functions, although it does nothing when used. See also
   * [texture2dLayeredPlaceholderCreate].
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent resource is [PlaceholderTexture2D].
   */
  @JvmStatic
  public final fun texture2dPlaceholderCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.texture2dPlaceholderCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a placeholder for a 2-dimensional layered texture and adds it to the RenderingServer.
   * It can be accessed with the RID that is returned. This RID will be used in all
   * `texture_2d_layered_*` RenderingServer functions, although it does nothing when used. See also
   * [texture2dPlaceholderCreate].
   *
   * **Note:** The equivalent resource is [PlaceholderTextureLayered].
   */
  @JvmStatic
  public final fun texture2dLayeredPlaceholderCreate(layeredType: TextureLayeredType): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to layeredType.value)
    TransferContext.callMethod(MethodBindings.texture2dLayeredPlaceholderCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a placeholder for a 3-dimensional texture and adds it to the RenderingServer. It can be
   * accessed with the RID that is returned. This RID will be used in all `texture_3d_*`
   * RenderingServer functions, although it does nothing when used.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent resource is [PlaceholderTexture3D].
   */
  @JvmStatic
  public final fun texture3dPlaceholderCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.texture3dPlaceholderCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns an [Image] instance from the given [texture] [RID].
   *
   * **Example:** Get the test texture from [getTestTexture] and apply it to a [Sprite2D] node:
   *
   * ```
   * var texture_rid = RenderingServer.get_test_texture()
   * var texture = ImageTexture.create_from_image(RenderingServer.texture_2d_get(texture_rid))
   * $Sprite2D.texture = texture
   * ```
   */
  @JvmStatic
  public final fun texture2dGet(texture: RID): Image? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture)
    TransferContext.callMethod(MethodBindings.texture2dGetPtr)
    return (TransferContext.readReturnValue(OBJECT) as Image?)
  }

  /**
   * Returns an [Image] instance from the given [texture] [RID] and [layer].
   */
  @JvmStatic
  public final fun texture2dLayerGet(texture: RID, layer: Int): Image? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture, LONG to layer.toLong())
    TransferContext.callMethod(MethodBindings.texture2dLayerGetPtr)
    return (TransferContext.readReturnValue(OBJECT) as Image?)
  }

  /**
   * Returns 3D texture data as an array of [Image]s for the specified texture [RID].
   */
  @JvmStatic
  public final fun texture3dGet(texture: RID): VariantArray<Image> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture)
    TransferContext.callMethod(MethodBindings.texture3dGetPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Image>)
  }

  /**
   * Calculates new MipMaps for the given Drawable [texture].
   */
  @JvmStatic
  public final fun textureDrawableGenerateMipmaps(texture: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture)
    TransferContext.callMethod(MethodBindings.textureDrawableGenerateMipmapsPtr)
  }

  /**
   * Returns a ShaderMaterial with the default texture_blit Shader.
   */
  @JvmStatic
  public final fun textureDrawableGetDefaultMaterial(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.textureDrawableGetDefaultMaterialPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Replaces [texture]'s texture data by the texture specified by the [byTexture] RID, without
   * changing [texture]'s RID.
   */
  @JvmStatic
  public final fun textureReplace(texture: RID, byTexture: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture, _RID to byTexture)
    TransferContext.callMethod(MethodBindings.textureReplacePtr)
  }

  /**
   * Sets the size at which the texture should be *displayed* in 2D, ignoring its original size.
   * This does not rescale the texture data itself, only how it is drawn in 2D. Set [width] and
   * [height] to 0 to disable the size override.
   */
  @JvmStatic
  public final fun textureSetSizeOverride(
    texture: RID,
    width: Int,
    height: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture, LONG to width.toLong(), LONG to height.toLong())
    TransferContext.callMethod(MethodBindings.textureSetSizeOverridePtr)
  }

  /**
   * Sets the resource path for this texture RID. See also [textureGetPath].
   *
   * **Note:** This is purely a hint and does not cause the texture to be automatically saved when
   * set to a `res://` path.
   */
  @JvmStatic
  public final fun textureSetPath(texture: RID, path: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture, STRING to path)
    TransferContext.callMethod(MethodBindings.textureSetPathPtr)
  }

  /**
   * Returns the resource path (starting with `res://` or `uid://`) for the specified texture RID.
   * Returns an empty [String] if the resource is built-in. See also [textureSetPath].
   */
  @JvmStatic
  public final fun textureGetPath(texture: RID): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture)
    TransferContext.callMethod(MethodBindings.textureGetPathPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the format for the texture.
   */
  @JvmStatic
  public final fun textureGetFormat(texture: RID): Image.Format {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture)
    TransferContext.callMethod(MethodBindings.textureGetFormatPtr)
    return Image.Format.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets whether the texture RID should force redrawing when it's visible on screen when
   * [OS.lowProcessorUsageMode] is `true`. This is used by [AnimatedTexture] to force redrawing.
   */
  @JvmStatic
  public final fun textureSetForceRedrawIfVisible(texture: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture, BOOL to enable)
    TransferContext.callMethod(MethodBindings.textureSetForceRedrawIfVisiblePtr)
  }

  /**
   * Creates a new texture object based on a texture created directly on the [RenderingDevice]. If
   * the texture contains layers, [layerType] is used to define the layer type.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The RenderingServer's [freeRid] won't free the underlying [rdTexture], you will want
   * to free the [rdTexture] using [RenderingDevice.freeRid].
   */
  @JvmOverloads
  @JvmStatic
  public final fun textureRdCreate(rdTexture: RID, layerType: TextureLayeredType =
      RenderingServer.TextureLayeredType.TEXTURE_LAYERED_2D_ARRAY): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to rdTexture, LONG to layerType.value)
    TransferContext.callMethod(MethodBindings.textureRdCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns a texture [RID] that can be used with [RenderingDevice].
   *
   * [srgb] should be `true` when the texture uses nonlinear sRGB encoding and `false` when the
   * texture uses linear encoding.
   */
  @JvmOverloads
  @JvmStatic
  public final fun textureGetRdTexture(texture: RID, srgb: Boolean = false): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture, BOOL to srgb)
    TransferContext.callMethod(MethodBindings.textureGetRdTexturePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the internal graphics handle for this texture object. For use when communicating with
   * third-party APIs mostly with GDExtension.
   *
   * [srgb] should be `true` when the texture uses nonlinear sRGB encoding and `false` when the
   * texture uses linear encoding.
   *
   * **Note:** This function returns a `uint64_t` which internally maps to a `GLuint` (OpenGL) or
   * `VkImage` (Vulkan).
   */
  @JvmOverloads
  @JvmStatic
  public final fun textureGetNativeHandle(texture: RID, srgb: Boolean = false): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to texture, BOOL to srgb)
    TransferContext.callMethod(MethodBindings.textureGetNativeHandlePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Creates an empty shader and adds it to the RenderingServer. It can be accessed with the RID
   * that is returned. This RID will be used in all `shader_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent resource is [Shader].
   */
  @JvmStatic
  public final fun shaderCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.shaderCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the shader's source code (which triggers recompilation after being changed).
   */
  @JvmStatic
  public final fun shaderSetCode(shader: RID, code: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shader, STRING to code)
    TransferContext.callMethod(MethodBindings.shaderSetCodePtr)
  }

  /**
   * Sets the path hint for the specified shader. This should generally match the [Shader]
   * resource's [Resource.resourcePath].
   */
  @JvmStatic
  public final fun shaderSetPathHint(shader: RID, path: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shader, STRING to path)
    TransferContext.callMethod(MethodBindings.shaderSetPathHintPtr)
  }

  /**
   * Returns a shader's source code as a string.
   */
  @JvmStatic
  public final fun shaderGetCode(shader: RID): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shader)
    TransferContext.callMethod(MethodBindings.shaderGetCodePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the parameters of a shader.
   */
  @JvmStatic
  public final fun getShaderParameterList(shader: RID): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shader)
    TransferContext.callMethod(MethodBindings.getShaderParameterListPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns the default value for the specified shader uniform. This is usually the value written
   * in the shader source code.
   */
  @JvmStatic
  public final fun shaderGetParameterDefault(shader: RID, name: StringName): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shader, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.shaderGetParameterDefaultPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Sets a shader's default texture. Overwrites the texture given by name.
   *
   * **Note:** If the sampler array is used use [index] to access the specified texture.
   */
  @JvmOverloads
  @JvmStatic
  public final fun shaderSetDefaultTextureParameter(
    shader: RID,
    name: StringName,
    texture: RID,
    index: Int = 0,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shader, STRING_NAME to name, _RID to texture, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.shaderSetDefaultTextureParameterPtr)
  }

  /**
   * Returns a default texture from a shader searched by name.
   *
   * **Note:** If the sampler array is used use [index] to access the specified texture.
   */
  @JvmOverloads
  @JvmStatic
  public final fun shaderGetDefaultTextureParameter(
    shader: RID,
    name: StringName,
    index: Int = 0,
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shader, STRING_NAME to name, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.shaderGetDefaultTextureParameterPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates an empty material and adds it to the RenderingServer. It can be accessed with the RID
   * that is returned. This RID will be used in all `material_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent resource is [Material].
   */
  @JvmStatic
  public final fun materialCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.materialCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets a shader material's shader.
   */
  @JvmStatic
  public final fun materialSetShader(shaderMaterial: RID, shader: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to shaderMaterial, _RID to shader)
    TransferContext.callMethod(MethodBindings.materialSetShaderPtr)
  }

  /**
   * Sets a material's parameter.
   */
  @JvmStatic
  public final fun materialSetParam(
    material: RID,
    parameter: StringName,
    `value`: Any?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to material, STRING_NAME to parameter, ANY to value)
    TransferContext.callMethod(MethodBindings.materialSetParamPtr)
  }

  /**
   * Returns the value of a certain material's parameter.
   */
  @JvmStatic
  public final fun materialGetParam(material: RID, parameter: StringName): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to material, STRING_NAME to parameter)
    TransferContext.callMethod(MethodBindings.materialGetParamPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Sets a material's render priority.
   */
  @JvmStatic
  public final fun materialSetRenderPriority(material: RID, priority: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to material, LONG to priority.toLong())
    TransferContext.callMethod(MethodBindings.materialSetRenderPriorityPtr)
  }

  /**
   * Sets an object's next material.
   */
  @JvmStatic
  public final fun materialSetNextPass(material: RID, nextMaterial: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to material, _RID to nextMaterial)
    TransferContext.callMethod(MethodBindings.materialSetNextPassPtr)
  }

  /**
   * When using the Mobile renderer, [materialSetUseDebanding] can be used to enable or disable the
   * debanding feature of 3D materials ([BaseMaterial3D] and [ShaderMaterial]).
   *
   * [materialSetUseDebanding] has no effect when using the Compatibility or Forward+ renderer. In
   * Forward+, [Viewport] debanding can be used instead.
   *
   * See also [ProjectSettings.rendering/antiAliasing/quality/useDebanding] and
   * [RenderingServer.viewportSetUseDebanding].
   */
  @JvmStatic
  public final fun materialSetUseDebanding(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.materialSetUseDebandingPtr)
  }

  /**
   * Creates a new mesh with predefined surfaces for it and adds the mesh to the RenderingServer. It
   * can be accessed with the RID that is returned. This RID will be used in all `mesh_*`
   * RenderingServer functions. This method is more efficient for creating meshes with multiple
   * surfaces compared to creating an empty mesh with [meshCreate] and adding surfaces one by one with
   * [meshAddSurface].
   *
   * Each element in the [surfaces] array must follow the same structure as described in
   * [meshAddSurface]. The [blendShapeCount] parameter must match the blend shape data defined in all
   * surfaces.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * To place in a scene, attach this mesh to an instance using [instanceSetBase] using the returned
   * RID.
   *
   * **Note:** The equivalent resource is [Mesh].
   */
  @JvmOverloads
  @JvmStatic
  public final fun meshCreateFromSurfaces(surfaces: VariantArray<Dictionary<Any?, Any?>>,
      blendShapeCount: Int = 0): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to surfaces, LONG to blendShapeCount.toLong())
    TransferContext.callMethod(MethodBindings.meshCreateFromSurfacesPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a new mesh and adds it to the RenderingServer. It can be accessed with the RID that is
   * returned. This RID will be used in all `mesh_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * To place in a scene, attach this mesh to an instance using [instanceSetBase] using the returned
   * RID.
   *
   * **Note:** The equivalent resource is [Mesh].
   */
  @JvmStatic
  public final fun meshCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.meshCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the offset of a given attribute by [arrayIndex] in the start of its respective buffer.
   */
  @JvmStatic
  public final fun meshSurfaceGetFormatOffset(
    format: ArrayFormat,
    vertexCount: Int,
    arrayIndex: Int,
  ): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to format.flag, LONG to vertexCount.toLong(), LONG to arrayIndex.toLong())
    TransferContext.callMethod(MethodBindings.meshSurfaceGetFormatOffsetPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the stride of the vertex positions for a mesh with given [format]. Note importantly
   * that vertex positions are stored consecutively and are not interleaved with the other attributes
   * in the vertex buffer (normals and tangents).
   */
  @JvmStatic
  public final fun meshSurfaceGetFormatVertexStride(format: ArrayFormat, vertexCount: Int): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to format.flag, LONG to vertexCount.toLong())
    TransferContext.callMethod(MethodBindings.meshSurfaceGetFormatVertexStridePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the stride of the combined normals and tangents for a mesh with given [format]. Note
   * importantly that, while normals and tangents are in the vertex buffer with vertices, they are only
   * interleaved with each other and so have a different stride than vertex positions.
   */
  @JvmStatic
  public final fun meshSurfaceGetFormatNormalTangentStride(format: ArrayFormat, vertexCount: Int):
      Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to format.flag, LONG to vertexCount.toLong())
    TransferContext.callMethod(MethodBindings.meshSurfaceGetFormatNormalTangentStridePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the stride of the attribute buffer for a mesh with given [format].
   */
  @JvmStatic
  public final fun meshSurfaceGetFormatAttributeStride(format: ArrayFormat, vertexCount: Int):
      Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to format.flag, LONG to vertexCount.toLong())
    TransferContext.callMethod(MethodBindings.meshSurfaceGetFormatAttributeStridePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the stride of the skin buffer for a mesh with given [format].
   */
  @JvmStatic
  public final fun meshSurfaceGetFormatSkinStride(format: ArrayFormat, vertexCount: Int): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to format.flag, LONG to vertexCount.toLong())
    TransferContext.callMethod(MethodBindings.meshSurfaceGetFormatSkinStridePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the stride of the index buffer for a mesh with the given [format].
   */
  @JvmStatic
  public final fun meshSurfaceGetFormatIndexStride(format: ArrayFormat, vertexCount: Int): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to format.flag, LONG to vertexCount.toLong())
    TransferContext.callMethod(MethodBindings.meshSurfaceGetFormatIndexStridePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Creates a new surface on the given [mesh]. Equivalent to [meshAddSurfaceFromArrays], but takes
   * a single [Dictionary] argument instead of separate arguments. The dictionary must follow this
   * structure:
   *
   * ```
   * {
   * 	# Required:
   *     "primitive": RenderingServer.PrimitiveType,
   *     "format": RenderingServer.ArrayFormat,
   *     "vertex_data": PackedByteArray,
   *     "vertex_count": int,
   *     "aabb": AABB,
   *
   * 	# Optional:
   * 	"attribute_data": PackedByteArray,
   * 	"skin_data": PackedByteArray,
   * 	"index_data": PackedByteArray,
   * 	"index_count": int, # Required if `index_data` is specified.
   * 	"uv_scale": Vector4,
   * 	"lods": [
   * 		# Both values are required for each LOD level.
   * 		{
   * 			"edge_length": float,
   * 			"index_data": PackedByteArray,
   * 		},
   * 	],
   * 	"bone_aabbs": Array[AABB],
   * 	"blend_shape_data": PackedByteArray,
   * 	"material": Material,
   * }
   * ```
   *
   * See also [meshGetSurface], which returns data in the same structure defined above.
   */
  @JvmStatic
  public final fun meshAddSurface(mesh: RID, surface: Dictionary<Any?, Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh, DICTIONARY to surface)
    TransferContext.callMethod(MethodBindings.meshAddSurfacePtr)
  }

  /**
   * Creates a new surface on the given [mesh]. [meshGetSurfaceCount] will become the surface index
   * for this new surface.
   *
   * Surfaces are created to be rendered using a [primitive], which may be any of the values defined
   * in [Mesh.PrimitiveType].
   *
   * The [arrays] argument is an array of arrays. Each of the [Mesh.ARRAY_MAX] elements contains an
   * array with some of the mesh data for this surface as described by the corresponding member of
   * [Mesh.ArrayType] or `null` if it is not used by the surface. For example, `arrays[0]` is the array
   * of vertices. That first vertex sub-array is always required; the others are optional. Adding an
   * index array puts this surface into "index mode" where the vertex and other arrays become the
   * sources of data and the index array defines the vertex order. All sub-arrays must have the same
   * length as the vertex array (or be an exact multiple of the vertex array's length, when multiple
   * elements of a sub-array correspond to a single vertex) or be empty, except for [Mesh.ARRAY_INDEX]
   * if it is used.
   *
   * The [blendShapes] argument is an array of vertex data for each blend shape. Each element is an
   * array of the same structure as [arrays], but [Mesh.ARRAY_VERTEX], [Mesh.ARRAY_NORMAL], and
   * [Mesh.ARRAY_TANGENT] are set if and only if they are set in [arrays] and all other entries are
   * `null`.
   *
   * The [lods] argument is a dictionary with [Double] keys and [PackedInt32Array] values. Each
   * entry in the dictionary represents an LOD level of the surface, where the value is the
   * [Mesh.ARRAY_INDEX] array to use for the LOD level and the key is roughly proportional to the
   * distance at which the LOD stats being used. I.e., increasing the key of an LOD also increases the
   * distance that the objects has to be from the camera before the LOD is used.
   *
   * The [compressFormat] argument is the bitwise OR of, as required: One value of [ArrayFormat]
   * left shifted by `ARRAY_FORMAT_CUSTOMn_SHIFT` for each custom channel in use,
   * [ARRAY_FLAG_USE_DYNAMIC_UPDATE], [ARRAY_FLAG_USE_8_BONE_WEIGHTS], or
   * [ARRAY_FLAG_USES_EMPTY_VERTEX_ARRAY].
   *
   * See [ArrayMesh.addSurfaceFromArrays] and [ImporterMesh.addSurface] for higher-level equivalents
   * of this method.
   *
   * **Note:** When using indices, it is recommended to only use points, lines, or triangles.
   */
  @JvmOverloads
  @JvmStatic
  public final fun meshAddSurfaceFromArrays(
    mesh: RID,
    primitive: PrimitiveType,
    arrays: VariantArray<Any?>,
    blendShapes: VariantArray<Any?> = godot.core.variantArrayOf(),
    lods: Dictionary<Any?, Any?> = Dictionary(),
    compressFormat: ArrayFormat = RenderingServer.ArrayFormat.FLAG_FORMAT_VERSION_1,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh, LONG to primitive.value, ARRAY to arrays, ARRAY to blendShapes, DICTIONARY to lods, LONG to compressFormat.flag)
    TransferContext.callMethod(MethodBindings.meshAddSurfaceFromArraysPtr)
  }

  /**
   * Returns a mesh's blend shape count.
   */
  @JvmStatic
  public final fun meshGetBlendShapeCount(mesh: RID): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh)
    TransferContext.callMethod(MethodBindings.meshGetBlendShapeCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets a mesh's blend shape mode.
   */
  @JvmStatic
  public final fun meshSetBlendShapeMode(mesh: RID, mode: BlendShapeMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.meshSetBlendShapeModePtr)
  }

  /**
   * Returns a mesh's blend shape mode.
   */
  @JvmStatic
  public final fun meshGetBlendShapeMode(mesh: RID): BlendShapeMode {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh)
    TransferContext.callMethod(MethodBindings.meshGetBlendShapeModePtr)
    return BlendShapeMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets a mesh's surface's material.
   */
  @JvmStatic
  public final fun meshSurfaceSetMaterial(
    mesh: RID,
    surface: Int,
    material: RID,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh, LONG to surface.toLong(), _RID to material)
    TransferContext.callMethod(MethodBindings.meshSurfaceSetMaterialPtr)
  }

  /**
   * Returns a mesh's surface's material.
   */
  @JvmStatic
  public final fun meshSurfaceGetMaterial(mesh: RID, surface: Int): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh, LONG to surface.toLong())
    TransferContext.callMethod(MethodBindings.meshSurfaceGetMaterialPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns a mesh's surface as a dictionary following the same structure as described in
   * [meshAddSurface].
   */
  @JvmStatic
  public final fun meshGetSurface(mesh: RID, surface: Int): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh, LONG to surface.toLong())
    TransferContext.callMethod(MethodBindings.meshGetSurfacePtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Returns a mesh's surface's buffer arrays.
   */
  @JvmStatic
  public final fun meshSurfaceGetArrays(mesh: RID, surface: Int): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh, LONG to surface.toLong())
    TransferContext.callMethod(MethodBindings.meshSurfaceGetArraysPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  /**
   * Returns a mesh's surface's arrays for blend shapes.
   */
  @JvmStatic
  public final fun meshSurfaceGetBlendShapeArrays(mesh: RID, surface: Int):
      VariantArray<VariantArray<Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh, LONG to surface.toLong())
    TransferContext.callMethod(MethodBindings.meshSurfaceGetBlendShapeArraysPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<VariantArray<Any?>>)
  }

  /**
   * Returns a mesh's number of surfaces.
   */
  @JvmStatic
  public final fun meshGetSurfaceCount(mesh: RID): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh)
    TransferContext.callMethod(MethodBindings.meshGetSurfaceCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets a mesh's custom aabb.
   */
  @JvmStatic
  public final fun meshSetCustomAabb(mesh: RID, aabb: AABB): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh, godot.core.VariantParser.AABB to aabb)
    TransferContext.callMethod(MethodBindings.meshSetCustomAabbPtr)
  }

  /**
   * Returns a mesh's custom aabb.
   */
  @JvmStatic
  public final fun meshGetCustomAabb(mesh: RID): AABB {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh)
    TransferContext.callMethod(MethodBindings.meshGetCustomAabbPtr)
    return (TransferContext.readReturnValue(godot.core.VariantParser.AABB) as AABB)
  }

  /**
   * Removes the surface at the given index from the Mesh, shifting surfaces with higher index down
   * by one.
   */
  @JvmStatic
  public final fun meshSurfaceRemove(mesh: RID, surface: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh, LONG to surface.toLong())
    TransferContext.callMethod(MethodBindings.meshSurfaceRemovePtr)
  }

  /**
   * Removes all surfaces from a mesh.
   */
  @JvmStatic
  public final fun meshClear(mesh: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh)
    TransferContext.callMethod(MethodBindings.meshClearPtr)
  }

  /**
   * Updates the vertex buffer of the mesh surface with the given [data]. The expected data per
   * vertex is 8 or 12 bytes (4 bytes per float, 2 floats per [Vector2], and 3 floats per [Vector3])
   * depending on if the mesh is using [Vector2] or [Vector3] vertices. This value can be determined
   * with [meshSurfaceGetFormatVertexStride] instead.
   *
   * The starting point of the updates can be changed with [offset]. The value of [offset] should be
   * a multiple of 12 bytes in most cases to align to each vertex.
   *
   * A [PackedVector3Array] of vertex locations can be converted into a [PackedByteArray] using
   * [PackedVector3Array.toByteArray] for use in [data].
   */
  @JvmStatic
  public final fun meshSurfaceUpdateVertexRegion(
    mesh: RID,
    surface: Int,
    offset: Int,
    `data`: PackedByteArray,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh, LONG to surface.toLong(), LONG to offset.toLong(), PACKED_BYTE_ARRAY to data)
    TransferContext.callMethod(MethodBindings.meshSurfaceUpdateVertexRegionPtr)
  }

  /**
   * Updates the attribute buffer of the mesh surface with the given [data]. The expected data per
   * attribute is 8 or 12 bytes (4 bytes per float, 2 floats per [Vector2], and 3 floats per [Vector3])
   * depending on if the mesh is using [Vector2] or [Vector3] vertices. This value can be determined
   * with [meshSurfaceGetFormatAttributeStride] instead.
   *
   * The starting point of the updates can be changed with [offset]. The value of [offset] should be
   * a multiple of 12 bytes in most cases to align to each attribute.
   *
   * A [PackedVector3Array] of attribute locations can be converted into a [PackedByteArray] using
   * [PackedVector3Array.toByteArray] for use in [data].
   */
  @JvmStatic
  public final fun meshSurfaceUpdateAttributeRegion(
    mesh: RID,
    surface: Int,
    offset: Int,
    `data`: PackedByteArray,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh, LONG to surface.toLong(), LONG to offset.toLong(), PACKED_BYTE_ARRAY to data)
    TransferContext.callMethod(MethodBindings.meshSurfaceUpdateAttributeRegionPtr)
  }

  /**
   * Updates the skin buffer of the mesh surface with the given [data]. The expected data per skin
   * is 8 or 12 bytes (4 bytes per float, 2 floats per [Vector2], and 3 floats per [Vector3]) depending
   * on if the mesh is using [Vector2] or [Vector3] vertices. This value can be determined with
   * [meshSurfaceGetFormatSkinStride] instead.
   *
   * The starting point of the updates can be changed with [offset]. The value of [offset] should be
   * a multiple of 12 bytes in most cases to align to each skin.
   *
   * A [PackedVector3Array] of skin locations can be converted into a [PackedByteArray] using
   * [PackedVector3Array.toByteArray] for use in [data].
   */
  @JvmStatic
  public final fun meshSurfaceUpdateSkinRegion(
    mesh: RID,
    surface: Int,
    offset: Int,
    `data`: PackedByteArray,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh, LONG to surface.toLong(), LONG to offset.toLong(), PACKED_BYTE_ARRAY to data)
    TransferContext.callMethod(MethodBindings.meshSurfaceUpdateSkinRegionPtr)
  }

  /**
   * Updates the index buffer of the mesh surface with the given [data]. The expected data are 16 or
   * 32-bit unsigned integers, which can be determined with [meshSurfaceGetFormatIndexStride].
   */
  @JvmStatic
  public final fun meshSurfaceUpdateIndexRegion(
    mesh: RID,
    surface: Int,
    offset: Int,
    `data`: PackedByteArray,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh, LONG to surface.toLong(), LONG to offset.toLong(), PACKED_BYTE_ARRAY to data)
    TransferContext.callMethod(MethodBindings.meshSurfaceUpdateIndexRegionPtr)
  }

  /**
   * Sets an optional second mesh which can be used for rendering shadows and the depth prepass. Can
   * be used to increase performance by supplying a mesh with fused vertices and only vertex position
   * data (without normals, UVs, colors, etc.).
   *
   * **Note:** This mesh must have exactly the same vertex positions as the source mesh (including
   * the source mesh's LODs, if present). If vertex positions differ, then the mesh will not draw
   * correctly.
   */
  @JvmStatic
  public final fun meshSetShadowMesh(mesh: RID, shadowMesh: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to mesh, _RID to shadowMesh)
    TransferContext.callMethod(MethodBindings.meshSetShadowMeshPtr)
  }

  /**
   * Creates a new multimesh on the RenderingServer and returns an [RID] handle. This RID will be
   * used in all `multimesh_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * To place in a scene, attach this multimesh to an instance using [instanceSetBase] using the
   * returned RID.
   *
   * **Note:** The equivalent resource is [MultiMesh].
   */
  @JvmStatic
  public final fun multimeshCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.multimeshCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets up the multimesh using the specified data. The number of instances is set by [instances].
   * The format of the instance transforms is set by [transformFormat], which should be set according
   * to whether the multimesh is meant to be rendered in 2D or 3D. If [colorFormat] is `true`, each
   * instance will have a color associated with it. If [customDataFormat] is `true`, each instance will
   * have a custom data vector associated with it. If [useIndirect] is `true`, an indirect command
   * buffer will be created for this multimesh, allowing the instance count to be modified directly on
   * the GPU. See also [multimeshGetCommandBufferRdRid].
   */
  @JvmOverloads
  @JvmStatic
  public final fun multimeshAllocateData(
    multimesh: RID,
    instances: Int,
    transformFormat: MultimeshTransformFormat,
    colorFormat: Boolean = false,
    customDataFormat: Boolean = false,
    useIndirect: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh, LONG to instances.toLong(), LONG to transformFormat.value, BOOL to colorFormat, BOOL to customDataFormat, BOOL to useIndirect)
    TransferContext.callMethod(MethodBindings.multimeshAllocateDataPtr)
  }

  /**
   * Returns the number of instances allocated for this multimesh.
   */
  @JvmStatic
  public final fun multimeshGetInstanceCount(multimesh: RID): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh)
    TransferContext.callMethod(MethodBindings.multimeshGetInstanceCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the mesh to be drawn by the multimesh. Equivalent to [MultiMesh.mesh].
   */
  @JvmStatic
  public final fun multimeshSetMesh(multimesh: RID, mesh: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh, _RID to mesh)
    TransferContext.callMethod(MethodBindings.multimeshSetMeshPtr)
  }

  /**
   * Sets the [Transform3D] for this instance. Equivalent to [MultiMesh.setInstanceTransform].
   */
  @JvmStatic
  public final fun multimeshInstanceSetTransform(
    multimesh: RID,
    index: Int,
    transform: Transform3D,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh, LONG to index.toLong(), TRANSFORM3D to transform)
    TransferContext.callMethod(MethodBindings.multimeshInstanceSetTransformPtr)
  }

  /**
   * Sets the [Transform2D] for this instance. For use when multimesh is used in 2D. Equivalent to
   * [MultiMesh.setInstanceTransform2d].
   */
  @JvmStatic
  public final fun multimeshInstanceSetTransform2d(
    multimesh: RID,
    index: Int,
    transform: Transform2D,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh, LONG to index.toLong(), TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.multimeshInstanceSetTransform2dPtr)
  }

  /**
   * Sets the color by which this instance will be modulated. Equivalent to
   * [MultiMesh.setInstanceColor].
   */
  @JvmStatic
  public final fun multimeshInstanceSetColor(
    multimesh: RID,
    index: Int,
    color: Color,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh, LONG to index.toLong(), COLOR to color)
    TransferContext.callMethod(MethodBindings.multimeshInstanceSetColorPtr)
  }

  /**
   * Sets the custom data for this instance. Custom data is passed as a [Color], but is interpreted
   * as a `vec4` in the shader. Equivalent to [MultiMesh.setInstanceCustomData].
   */
  @JvmStatic
  public final fun multimeshInstanceSetCustomData(
    multimesh: RID,
    index: Int,
    customData: Color,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh, LONG to index.toLong(), COLOR to customData)
    TransferContext.callMethod(MethodBindings.multimeshInstanceSetCustomDataPtr)
  }

  /**
   * Returns the RID of the mesh that will be used in drawing this multimesh.
   */
  @JvmStatic
  public final fun multimeshGetMesh(multimesh: RID): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh)
    TransferContext.callMethod(MethodBindings.multimeshGetMeshPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Calculates and returns the axis-aligned bounding box that encloses all instances within the
   * multimesh.
   */
  @JvmStatic
  public final fun multimeshGetAabb(multimesh: RID): AABB {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh)
    TransferContext.callMethod(MethodBindings.multimeshGetAabbPtr)
    return (TransferContext.readReturnValue(godot.core.VariantParser.AABB) as AABB)
  }

  /**
   * Sets the custom AABB for this MultiMesh resource.
   */
  @JvmStatic
  public final fun multimeshSetCustomAabb(multimesh: RID, aabb: AABB): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh, godot.core.VariantParser.AABB to aabb)
    TransferContext.callMethod(MethodBindings.multimeshSetCustomAabbPtr)
  }

  /**
   * Returns the custom AABB defined for this MultiMesh resource.
   */
  @JvmStatic
  public final fun multimeshGetCustomAabb(multimesh: RID): AABB {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh)
    TransferContext.callMethod(MethodBindings.multimeshGetCustomAabbPtr)
    return (TransferContext.readReturnValue(godot.core.VariantParser.AABB) as AABB)
  }

  /**
   * Returns the [Transform3D] of the specified instance.
   */
  @JvmStatic
  public final fun multimeshInstanceGetTransform(multimesh: RID, index: Int): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.multimeshInstanceGetTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  /**
   * Returns the [Transform2D] of the specified instance. For use when the multimesh is set to use
   * 2D transforms.
   */
  @JvmStatic
  public final fun multimeshInstanceGetTransform2d(multimesh: RID, index: Int): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.multimeshInstanceGetTransform2dPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Returns the color by which the specified instance will be modulated.
   */
  @JvmStatic
  public final fun multimeshInstanceGetColor(multimesh: RID, index: Int): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.multimeshInstanceGetColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  /**
   * Returns the custom data associated with the specified instance.
   */
  @JvmStatic
  public final fun multimeshInstanceGetCustomData(multimesh: RID, index: Int): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.multimeshInstanceGetCustomDataPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  /**
   * Sets the number of instances visible at a given time. If -1, all instances that have been
   * allocated are drawn. Equivalent to [MultiMesh.visibleInstanceCount].
   */
  @JvmStatic
  public final fun multimeshSetVisibleInstances(multimesh: RID, visible: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh, LONG to visible.toLong())
    TransferContext.callMethod(MethodBindings.multimeshSetVisibleInstancesPtr)
  }

  /**
   * Returns the number of visible instances for this multimesh.
   */
  @JvmStatic
  public final fun multimeshGetVisibleInstances(multimesh: RID): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh)
    TransferContext.callMethod(MethodBindings.multimeshGetVisibleInstancesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Set the entire data to use for drawing the [multimesh] at once to [buffer] (such as instance
   * transforms and colors). [buffer]'s size must match the number of instances multiplied by the
   * per-instance data size (which depends on the enabled MultiMesh fields). Otherwise, an error
   * message is printed and nothing is rendered. See also [multimeshGetBuffer].
   *
   * The per-instance data size and expected data order is:
   *
   * [codeblock lang=text]
   *
   * 2D:
   *
   *   - Position: 8 floats (8 floats for Transform2D)
   *
   *   - Position + Vertex color: 12 floats (8 floats for Transform2D, 4 floats for Color)
   *
   *   - Position + Custom data: 12 floats (8 floats for Transform2D, 4 floats of custom data)
   *
   *   - Position + Vertex color + Custom data: 16 floats (8 floats for Transform2D, 4 floats for
   * Color, 4 floats of custom data)
   *
   * 3D:
   *
   *   - Position: 12 floats (12 floats for Transform3D)
   *
   *   - Position + Vertex color: 16 floats (12 floats for Transform3D, 4 floats for Color)
   *
   *   - Position + Custom data: 16 floats (12 floats for Transform3D, 4 floats of custom data)
   *
   *   - Position + Vertex color + Custom data: 20 floats (12 floats for Transform3D, 4 floats for
   * Color, 4 floats of custom data)
   *
   * ```
   *
   * Instance transforms are in row-major order. Specifically:
   *
   * - For [Transform2D] the float-order is: `(x.x, y.x, padding_float, origin.x, x.y, y.y,
   * padding_float, origin.y)`.
   *
   * - For [Transform3D] the float-order is: `(basis.x.x, basis.y.x, basis.z.x, origin.x, basis.x.y,
   * basis.y.y, basis.z.y, origin.y, basis.x.z, basis.y.z, basis.z.z, origin.z)`.
   */
  @JvmStatic
  public final fun multimeshSetBuffer(multimesh: RID, buffer: PackedFloat32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh, PACKED_FLOAT_32_ARRAY to buffer)
    TransferContext.callMethod(MethodBindings.multimeshSetBufferPtr)
  }

  /**
   * Returns the [RenderingDevice] [RID] handle of the [MultiMesh] command buffer. This [RID] is
   * only valid if `use_indirect` is set to `true` when allocating data through
   * [multimeshAllocateData]. It can be used to directly modify the instance count via buffer.
   *
   * The data structure is dependent on both how many surfaces the mesh contains and whether it is
   * indexed or not, the buffer has 5 integers in it, with the last unused if the mesh is not indexed.
   *
   * Each of the values in the buffer correspond to these options:
   *
   * [codeblock lang=text]
   *
   * Indexed:
   *
   *   0 - indexCount;
   *
   *   1 - instanceCount;
   *
   *   2 - firstIndex;
   *
   *   3 - vertexOffset;
   *
   *   4 - firstInstance;
   *
   * Non-indexed:
   *
   *   0 - vertexCount;
   *
   *   1 - instanceCount;
   *
   *   2 - firstVertex;
   *
   *   3 - firstInstance;
   *
   *   4 - unused;
   *
   * ```
   */
  @JvmStatic
  public final fun multimeshGetCommandBufferRdRid(multimesh: RID): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh)
    TransferContext.callMethod(MethodBindings.multimeshGetCommandBufferRdRidPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the [RenderingDevice] [RID] handle of the [MultiMesh], which can be used as any other
   * buffer on the Rendering Device.
   */
  @JvmStatic
  public final fun multimeshGetBufferRdRid(multimesh: RID): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh)
    TransferContext.callMethod(MethodBindings.multimeshGetBufferRdRidPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the MultiMesh data (such as instance transforms, colors, etc.). See
   * [multimeshSetBuffer] for details on the returned data.
   *
   * **Note:** If the buffer is in the engine's internal cache, it will have to be fetched from GPU
   * memory and possibly decompressed. This means [multimeshGetBuffer] is potentially a slow operation
   * and should be avoided whenever possible.
   */
  @JvmStatic
  public final fun multimeshGetBuffer(multimesh: RID): PackedFloat32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh)
    TransferContext.callMethod(MethodBindings.multimeshGetBufferPtr)
    return (TransferContext.readReturnValue(PACKED_FLOAT_32_ARRAY) as PackedFloat32Array)
  }

  /**
   * Alternative version of [multimeshSetBuffer] for use with physics interpolation.
   *
   * Takes both an array of current data and an array of data for the previous physics tick.
   */
  @JvmStatic
  public final fun multimeshSetBufferInterpolated(
    multimesh: RID,
    buffer: PackedFloat32Array,
    bufferPrevious: PackedFloat32Array,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh, PACKED_FLOAT_32_ARRAY to buffer, PACKED_FLOAT_32_ARRAY to bufferPrevious)
    TransferContext.callMethod(MethodBindings.multimeshSetBufferInterpolatedPtr)
  }

  /**
   * Turns on and off physics interpolation for this MultiMesh resource.
   */
  @JvmStatic
  public final fun multimeshSetPhysicsInterpolated(multimesh: RID, interpolated: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh, BOOL to interpolated)
    TransferContext.callMethod(MethodBindings.multimeshSetPhysicsInterpolatedPtr)
  }

  /**
   * Sets the physics interpolation quality for the [MultiMesh].
   *
   * A value of [MULTIMESH_INTERP_QUALITY_FAST] gives fast but low quality interpolation, a value of
   * [MULTIMESH_INTERP_QUALITY_HIGH] gives slower but higher quality interpolation.
   */
  @JvmStatic
  public final fun multimeshSetPhysicsInterpolationQuality(multimesh: RID,
      quality: MultimeshPhysicsInterpolationQuality): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh, LONG to quality.value)
    TransferContext.callMethod(MethodBindings.multimeshSetPhysicsInterpolationQualityPtr)
  }

  /**
   * Prevents physics interpolation for the specified instance during the current physics tick.
   *
   * This is useful when moving an instance to a new location, to give an instantaneous change
   * rather than interpolation from the previous location.
   */
  @JvmStatic
  public final fun multimeshInstanceResetPhysicsInterpolation(multimesh: RID, index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.multimeshInstanceResetPhysicsInterpolationPtr)
  }

  /**
   * Prevents physics interpolation for all instances during the current physics tick.
   *
   * This is useful when moving all instances to new locations, to give instantaneous changes rather
   * than interpolation from the previous locations.
   */
  @JvmStatic
  public final fun multimeshInstancesResetPhysicsInterpolation(multimesh: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to multimesh)
    TransferContext.callMethod(MethodBindings.multimeshInstancesResetPhysicsInterpolationPtr)
  }

  /**
   * Creates a skeleton and adds it to the RenderingServer. It can be accessed with the RID that is
   * returned. This RID will be used in all `skeleton_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   */
  @JvmStatic
  public final fun skeletonCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.skeletonCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Allocates data for this skeleton using the number of bones specified in [bones]. If
   * [is2dSkeleton] is `true`, the skeleton will be treated as a 2D skeleton instead of a 3D skeleton.
   * See also [skeletonGetBoneCount].
   */
  @JvmOverloads
  @JvmStatic
  public final fun skeletonAllocateData(
    skeleton: RID,
    bones: Int,
    is2dSkeleton: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to skeleton, LONG to bones.toLong(), BOOL to is2dSkeleton)
    TransferContext.callMethod(MethodBindings.skeletonAllocateDataPtr)
  }

  /**
   * Returns the number of bones allocated for this skeleton. See also [skeletonAllocateData].
   */
  @JvmStatic
  public final fun skeletonGetBoneCount(skeleton: RID): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to skeleton)
    TransferContext.callMethod(MethodBindings.skeletonGetBoneCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the [Transform3D] for a specific bone of this skeleton.
   */
  @JvmStatic
  public final fun skeletonBoneSetTransform(
    skeleton: RID,
    bone: Int,
    transform: Transform3D,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to skeleton, LONG to bone.toLong(), TRANSFORM3D to transform)
    TransferContext.callMethod(MethodBindings.skeletonBoneSetTransformPtr)
  }

  /**
   * Returns the [Transform3D] set for a specific bone of this skeleton.
   */
  @JvmStatic
  public final fun skeletonBoneGetTransform(skeleton: RID, bone: Int): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to skeleton, LONG to bone.toLong())
    TransferContext.callMethod(MethodBindings.skeletonBoneGetTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  /**
   * Sets the [Transform2D] for a specific bone of this skeleton.
   */
  @JvmStatic
  public final fun skeletonBoneSetTransform2d(
    skeleton: RID,
    bone: Int,
    transform: Transform2D,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to skeleton, LONG to bone.toLong(), TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.skeletonBoneSetTransform2dPtr)
  }

  /**
   * Returns the [Transform2D] set for a specific bone of this skeleton.
   */
  @JvmStatic
  public final fun skeletonBoneGetTransform2d(skeleton: RID, bone: Int): Transform2D {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to skeleton, LONG to bone.toLong())
    TransferContext.callMethod(MethodBindings.skeletonBoneGetTransform2dPtr)
    return (TransferContext.readReturnValue(TRANSFORM2D) as Transform2D)
  }

  /**
   * Sets the base [Transform2D] to use for the specified skeleton.
   */
  @JvmStatic
  public final fun skeletonSetBaseTransform2d(skeleton: RID, baseTransform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to skeleton, TRANSFORM2D to baseTransform)
    TransferContext.callMethod(MethodBindings.skeletonSetBaseTransform2dPtr)
  }

  /**
   * Creates a directional light and adds it to the RenderingServer. It can be accessed with the RID
   * that is returned. This RID can be used in most `light_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * To place in a scene, attach this directional light to an instance using [instanceSetBase] using
   * the returned RID.
   *
   * **Note:** The equivalent node is [DirectionalLight3D].
   */
  @JvmStatic
  public final fun directionalLightCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.directionalLightCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a new omni light and adds it to the RenderingServer. It can be accessed with the RID
   * that is returned. This RID can be used in most `light_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * To place in a scene, attach this omni light to an instance using [instanceSetBase] using the
   * returned RID.
   *
   * **Note:** The equivalent node is [OmniLight3D].
   */
  @JvmStatic
  public final fun omniLightCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.omniLightCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a spot light and adds it to the RenderingServer. It can be accessed with the RID that
   * is returned. This RID can be used in most `light_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * To place in a scene, attach this spot light to an instance using [instanceSetBase] using the
   * returned RID.
   */
  @JvmStatic
  public final fun spotLightCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.spotLightCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a new area light and adds it to the RenderingServer. It can be accessed with the RID
   * that is returned. This RID can be used in most `light_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * To place in a scene, attach this area light to an instance using [instanceSetBase] using the
   * returned RID.
   *
   * **Note:** The equivalent node is [AreaLight3D].
   */
  @JvmStatic
  public final fun areaLightCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.areaLightCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the color of the light. Equivalent to [Light3D.lightColor].
   */
  @JvmStatic
  public final fun lightSetColor(light: RID, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, COLOR to color)
    TransferContext.callMethod(MethodBindings.lightSetColorPtr)
  }

  /**
   * Sets the specified 3D light parameter. Equivalent to [Light3D.setParam].
   */
  @JvmStatic
  public final fun lightSetParam(
    light: RID,
    `param`: LightParam,
    `value`: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, LONG to param.value, DOUBLE to value.toDouble())
    TransferContext.callMethod(MethodBindings.lightSetParamPtr)
  }

  /**
   * If `true`, light will cast shadows. Equivalent to [Light3D.shadowEnabled].
   */
  @JvmStatic
  public final fun lightSetShadow(light: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.lightSetShadowPtr)
  }

  /**
   * Sets the projector texture to use for the specified 3D light. Equivalent to
   * [Light3D.lightProjector].
   */
  @JvmStatic
  public final fun lightSetProjector(light: RID, texture: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, _RID to texture)
    TransferContext.callMethod(MethodBindings.lightSetProjectorPtr)
  }

  /**
   * If `true`, the 3D light will subtract light instead of adding light. Equivalent to
   * [Light3D.lightNegative].
   */
  @JvmStatic
  public final fun lightSetNegative(light: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, BOOL to enable)
    TransferContext.callMethod(MethodBindings.lightSetNegativePtr)
  }

  /**
   * Sets the cull mask for this 3D light. Lights only affect objects in the selected layers.
   * Equivalent to [Light3D.lightCullMask].
   */
  @JvmStatic
  public final fun lightSetCullMask(light: RID, mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, LONG to mask)
    TransferContext.callMethod(MethodBindings.lightSetCullMaskPtr)
  }

  /**
   * Sets the distance fade for this 3D light. This acts as a form of level of detail (LOD) and can
   * be used to improve performance. Equivalent to [Light3D.distanceFadeEnabled],
   * [Light3D.distanceFadeBegin], [Light3D.distanceFadeShadow], and [Light3D.distanceFadeLength].
   */
  @JvmStatic
  public final fun lightSetDistanceFade(
    decal: RID,
    enabled: Boolean,
    begin: Float,
    shadow: Float,
    length: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to decal, BOOL to enabled, DOUBLE to begin.toDouble(), DOUBLE to shadow.toDouble(), DOUBLE to length.toDouble())
    TransferContext.callMethod(MethodBindings.lightSetDistanceFadePtr)
  }

  /**
   * If `true`, reverses the backface culling of the mesh. This can be useful when you have a flat
   * mesh that has a light behind it. If you need to cast a shadow on both sides of the mesh, set the
   * mesh to use double-sided shadows with [instanceGeometrySetCastShadowsSetting]. Equivalent to
   * [Light3D.shadowReverseCullFace].
   */
  @JvmStatic
  public final fun lightSetReverseCullFaceMode(light: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.lightSetReverseCullFaceModePtr)
  }

  /**
   * Sets the shadow caster mask for this 3D light. Shadows will only be cast using objects in the
   * selected layers. Equivalent to [Light3D.shadowCasterMask].
   */
  @JvmStatic
  public final fun lightSetShadowCasterMask(light: RID, mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, LONG to mask)
    TransferContext.callMethod(MethodBindings.lightSetShadowCasterMaskPtr)
  }

  /**
   * Sets the bake mode to use for the specified 3D light. Equivalent to [Light3D.lightBakeMode].
   */
  @JvmStatic
  public final fun lightSetBakeMode(light: RID, bakeMode: LightBakeMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, LONG to bakeMode.value)
    TransferContext.callMethod(MethodBindings.lightSetBakeModePtr)
  }

  /**
   * Sets the maximum SDFGI cascade in which the 3D light's indirect lighting is rendered. Higher
   * values allow the light to be rendered in SDFGI further away from the camera.
   */
  @JvmStatic
  public final fun lightSetMaxSdfgiCascade(light: RID, cascade: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, LONG to cascade)
    TransferContext.callMethod(MethodBindings.lightSetMaxSdfgiCascadePtr)
  }

  /**
   * Sets whether to use a dual paraboloid or a cubemap for the shadow map. Dual paraboloid is
   * faster but may suffer from artifacts. Equivalent to [OmniLight3D.omniShadowMode].
   */
  @JvmStatic
  public final fun lightOmniSetShadowMode(light: RID, mode: LightOmniShadowMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.lightOmniSetShadowModePtr)
  }

  /**
   * Sets the shadow mode for this directional light. Equivalent to
   * [DirectionalLight3D.directionalShadowMode].
   */
  @JvmStatic
  public final fun lightDirectionalSetShadowMode(light: RID, mode: LightDirectionalShadowMode):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.lightDirectionalSetShadowModePtr)
  }

  /**
   * If `true`, this directional light will blend between shadow map splits resulting in a smoother
   * transition between them. Equivalent to [DirectionalLight3D.directionalShadowBlendSplits].
   */
  @JvmStatic
  public final fun lightDirectionalSetBlendSplits(light: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, BOOL to enable)
    TransferContext.callMethod(MethodBindings.lightDirectionalSetBlendSplitsPtr)
  }

  /**
   * If `true`, this light will not be used for anything except sky shaders. Use this for lights
   * that impact your sky shader that you may want to hide from affecting the rest of the scene. For
   * example, you may want to enable this when the sun in your sky shader falls below the horizon.
   */
  @JvmStatic
  public final fun lightDirectionalSetSkyMode(light: RID, mode: LightDirectionalSkyMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.lightDirectionalSetSkyModePtr)
  }

  /**
   * Sets the extents (width and height) in meters for this area light. Equivalent to
   * [AreaLight3D.areaSize].
   */
  @JvmStatic
  public final fun lightAreaSetSize(light: RID, size: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, VECTOR2 to size)
    TransferContext.callMethod(MethodBindings.lightAreaSetSizePtr)
  }

  /**
   * Defines whether the energy of an [AreaLight3D] is normalized (divided) by its area. If set to
   * `true`, changing the size does not affect the total energy output. Equivalent to
   * [AreaLight3D.areaNormalizeEnergy].
   */
  @JvmStatic
  public final fun lightAreaSetNormalizeEnergy(light: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, BOOL to enable)
    TransferContext.callMethod(MethodBindings.lightAreaSetNormalizeEnergyPtr)
  }

  /**
   * Sets the texture filter mode to use when rendering light projectors. This parameter is global
   * and cannot be set on a per-light basis.
   */
  @JvmStatic
  public final fun lightProjectorsSetFilter(filter: LightProjectorFilter): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to filter.value)
    TransferContext.callMethod(MethodBindings.lightProjectorsSetFilterPtr)
  }

  /**
   * Toggles whether a bicubic filter should be used when lightmaps are sampled. This smoothens
   * their appearance at a performance cost.
   */
  @JvmStatic
  public final fun lightmapsSetBicubicFilter(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.lightmapsSetBicubicFilterPtr)
  }

  /**
   * Sets the filter quality for omni and spot light shadows in 3D. See also
   * [ProjectSettings.rendering/lightsAndShadows/positionalShadow/softShadowFilterQuality]. This
   * parameter is global and cannot be set on a per-viewport basis.
   */
  @JvmStatic
  public final fun positionalSoftShadowFilterSetQuality(quality: ShadowQuality): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to quality.value)
    TransferContext.callMethod(MethodBindings.positionalSoftShadowFilterSetQualityPtr)
  }

  /**
   * Sets the filter [quality] for directional light shadows in 3D. See also
   * [ProjectSettings.rendering/lightsAndShadows/directionalShadow/softShadowFilterQuality]. This
   * parameter is global and cannot be set on a per-viewport basis.
   */
  @JvmStatic
  public final fun directionalSoftShadowFilterSetQuality(quality: ShadowQuality): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to quality.value)
    TransferContext.callMethod(MethodBindings.directionalSoftShadowFilterSetQualityPtr)
  }

  /**
   * Sets the [size] of the directional light shadows in 3D. See also
   * [ProjectSettings.rendering/lightsAndShadows/directionalShadow/size]. This parameter is global and
   * cannot be set on a per-viewport basis.
   */
  @JvmStatic
  public final fun directionalShadowAtlasSetSize(size: Int, is16bits: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to size.toLong(), BOOL to is16bits)
    TransferContext.callMethod(MethodBindings.directionalShadowAtlasSetSizePtr)
  }

  /**
   * Creates a reflection probe and adds it to the RenderingServer. It can be accessed with the RID
   * that is returned. This RID will be used in all `reflection_probe_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * To place in a scene, attach this reflection probe to an instance using [instanceSetBase] using
   * the returned RID.
   *
   * **Note:** The equivalent node is [ReflectionProbe].
   */
  @JvmStatic
  public final fun reflectionProbeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.reflectionProbeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets how often the reflection probe updates. Can either be once or every frame.
   */
  @JvmStatic
  public final fun reflectionProbeSetUpdateMode(probe: RID, mode: ReflectionProbeUpdateMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to probe, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.reflectionProbeSetUpdateModePtr)
  }

  /**
   * Sets the intensity of the reflection probe. Intensity modulates the strength of the reflection.
   * Equivalent to [ReflectionProbe.intensity].
   */
  @JvmStatic
  public final fun reflectionProbeSetIntensity(probe: RID, intensity: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to probe, DOUBLE to intensity.toDouble())
    TransferContext.callMethod(MethodBindings.reflectionProbeSetIntensityPtr)
  }

  /**
   * Sets the distance in meters over which a probe blends into the scene.
   */
  @JvmStatic
  public final fun reflectionProbeSetBlendDistance(probe: RID, blendDistance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to probe, DOUBLE to blendDistance.toDouble())
    TransferContext.callMethod(MethodBindings.reflectionProbeSetBlendDistancePtr)
  }

  /**
   * Sets the reflection probe's ambient light mode. Equivalent to [ReflectionProbe.ambientMode].
   */
  @JvmStatic
  public final fun reflectionProbeSetAmbientMode(probe: RID, mode: ReflectionProbeAmbientMode):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to probe, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.reflectionProbeSetAmbientModePtr)
  }

  /**
   * Sets the reflection probe's custom ambient light color. Equivalent to
   * [ReflectionProbe.ambientColor].
   */
  @JvmStatic
  public final fun reflectionProbeSetAmbientColor(probe: RID, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to probe, COLOR to color)
    TransferContext.callMethod(MethodBindings.reflectionProbeSetAmbientColorPtr)
  }

  /**
   * Sets the reflection probe's custom ambient light energy. Equivalent to
   * [ReflectionProbe.ambientColorEnergy].
   */
  @JvmStatic
  public final fun reflectionProbeSetAmbientEnergy(probe: RID, energy: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to probe, DOUBLE to energy.toDouble())
    TransferContext.callMethod(MethodBindings.reflectionProbeSetAmbientEnergyPtr)
  }

  /**
   * Sets the max distance away from the probe an object can be before it is culled. Equivalent to
   * [ReflectionProbe.maxDistance].
   */
  @JvmStatic
  public final fun reflectionProbeSetMaxDistance(probe: RID, distance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to probe, DOUBLE to distance.toDouble())
    TransferContext.callMethod(MethodBindings.reflectionProbeSetMaxDistancePtr)
  }

  /**
   * Sets the size of the area that the reflection probe will capture. Equivalent to
   * [ReflectionProbe.size].
   */
  @JvmStatic
  public final fun reflectionProbeSetSize(probe: RID, size: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to probe, VECTOR3 to size)
    TransferContext.callMethod(MethodBindings.reflectionProbeSetSizePtr)
  }

  /**
   * Sets the origin offset to be used when this reflection probe is in box project mode. Equivalent
   * to [ReflectionProbe.originOffset].
   */
  @JvmStatic
  public final fun reflectionProbeSetOriginOffset(probe: RID, offset: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to probe, VECTOR3 to offset)
    TransferContext.callMethod(MethodBindings.reflectionProbeSetOriginOffsetPtr)
  }

  /**
   * If `true`, reflections will ignore sky contribution. Equivalent to [ReflectionProbe.interior].
   */
  @JvmStatic
  public final fun reflectionProbeSetAsInterior(probe: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to probe, BOOL to enable)
    TransferContext.callMethod(MethodBindings.reflectionProbeSetAsInteriorPtr)
  }

  /**
   * If `true`, uses box projection. This can make reflections look more correct in certain
   * situations. Equivalent to [ReflectionProbe.boxProjection].
   */
  @JvmStatic
  public final fun reflectionProbeSetEnableBoxProjection(probe: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to probe, BOOL to enable)
    TransferContext.callMethod(MethodBindings.reflectionProbeSetEnableBoxProjectionPtr)
  }

  /**
   * If `true`, computes shadows in the reflection probe. This makes the reflection much slower to
   * compute. Equivalent to [ReflectionProbe.enableShadows].
   */
  @JvmStatic
  public final fun reflectionProbeSetEnableShadows(probe: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to probe, BOOL to enable)
    TransferContext.callMethod(MethodBindings.reflectionProbeSetEnableShadowsPtr)
  }

  /**
   * Sets the render cull mask for this reflection probe. Only instances with a matching layer will
   * be reflected by this probe. Equivalent to [ReflectionProbe.cullMask].
   */
  @JvmStatic
  public final fun reflectionProbeSetCullMask(probe: RID, layers: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to probe, LONG to layers)
    TransferContext.callMethod(MethodBindings.reflectionProbeSetCullMaskPtr)
  }

  /**
   * Sets the render reflection mask for this reflection probe. Only instances with a matching layer
   * will have reflections applied from this probe. Equivalent to [ReflectionProbe.reflectionMask].
   */
  @JvmStatic
  public final fun reflectionProbeSetReflectionMask(probe: RID, layers: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to probe, LONG to layers)
    TransferContext.callMethod(MethodBindings.reflectionProbeSetReflectionMaskPtr)
  }

  /**
   * Deprecated. This method does nothing.
   */
  @JvmStatic
  public final fun reflectionProbeSetResolution(probe: RID, resolution: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to probe, LONG to resolution.toLong())
    TransferContext.callMethod(MethodBindings.reflectionProbeSetResolutionPtr)
  }

  /**
   * Sets the mesh level of detail to use in the reflection probe rendering. Higher values will use
   * less detailed versions of meshes that have LOD variations generated, which can improve
   * performance. Equivalent to [ReflectionProbe.meshLodThreshold].
   */
  @JvmStatic
  public final fun reflectionProbeSetMeshLodThreshold(probe: RID, pixels: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to probe, DOUBLE to pixels.toDouble())
    TransferContext.callMethod(MethodBindings.reflectionProbeSetMeshLodThresholdPtr)
  }

  /**
   * Creates a decal and adds it to the RenderingServer. It can be accessed with the RID that is
   * returned. This RID will be used in all `decal_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * To place in a scene, attach this decal to an instance using [instanceSetBase] using the
   * returned RID.
   *
   * **Note:** The equivalent node is [Decal].
   */
  @JvmStatic
  public final fun decalCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.decalCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the [size] of the decal specified by the [decal] RID. Equivalent to [Decal.size].
   */
  @JvmStatic
  public final fun decalSetSize(decal: RID, size: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to decal, VECTOR3 to size)
    TransferContext.callMethod(MethodBindings.decalSetSizePtr)
  }

  /**
   * Sets the [texture] in the given texture [type] slot for the specified decal. Equivalent to
   * [Decal.setTexture].
   */
  @JvmStatic
  public final fun decalSetTexture(
    decal: RID,
    type: DecalTexture,
    texture: RID,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to decal, LONG to type.value, _RID to texture)
    TransferContext.callMethod(MethodBindings.decalSetTexturePtr)
  }

  /**
   * Sets the emission [energy] in the decal specified by the [decal] RID. Equivalent to
   * [Decal.emissionEnergy].
   */
  @JvmStatic
  public final fun decalSetEmissionEnergy(decal: RID, energy: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to decal, DOUBLE to energy.toDouble())
    TransferContext.callMethod(MethodBindings.decalSetEmissionEnergyPtr)
  }

  /**
   * Sets the [albedoMix] in the decal specified by the [decal] RID. Equivalent to
   * [Decal.albedoMix].
   */
  @JvmStatic
  public final fun decalSetAlbedoMix(decal: RID, albedoMix: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to decal, DOUBLE to albedoMix.toDouble())
    TransferContext.callMethod(MethodBindings.decalSetAlbedoMixPtr)
  }

  /**
   * Sets the color multiplier in the decal specified by the [decal] RID to [color]. Equivalent to
   * [Decal.modulate].
   */
  @JvmStatic
  public final fun decalSetModulate(decal: RID, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to decal, COLOR to color)
    TransferContext.callMethod(MethodBindings.decalSetModulatePtr)
  }

  /**
   * Sets the cull [mask] in the decal specified by the [decal] RID. Equivalent to [Decal.cullMask].
   */
  @JvmStatic
  public final fun decalSetCullMask(decal: RID, mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to decal, LONG to mask)
    TransferContext.callMethod(MethodBindings.decalSetCullMaskPtr)
  }

  /**
   * Sets the distance fade parameters in the decal specified by the [decal] RID. Equivalent to
   * [Decal.distanceFadeEnabled], [Decal.distanceFadeBegin] and [Decal.distanceFadeLength].
   */
  @JvmStatic
  public final fun decalSetDistanceFade(
    decal: RID,
    enabled: Boolean,
    begin: Float,
    length: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to decal, BOOL to enabled, DOUBLE to begin.toDouble(), DOUBLE to length.toDouble())
    TransferContext.callMethod(MethodBindings.decalSetDistanceFadePtr)
  }

  /**
   * Sets the upper fade ([above]) and lower fade ([below]) in the decal specified by the [decal]
   * RID. Equivalent to [Decal.upperFade] and [Decal.lowerFade].
   */
  @JvmStatic
  public final fun decalSetFade(
    decal: RID,
    above: Float,
    below: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to decal, DOUBLE to above.toDouble(), DOUBLE to below.toDouble())
    TransferContext.callMethod(MethodBindings.decalSetFadePtr)
  }

  /**
   * Sets the normal [fade] in the decal specified by the [decal] RID. Equivalent to
   * [Decal.normalFade].
   */
  @JvmStatic
  public final fun decalSetNormalFade(decal: RID, fade: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to decal, DOUBLE to fade.toDouble())
    TransferContext.callMethod(MethodBindings.decalSetNormalFadePtr)
  }

  /**
   * Sets the texture [filter] mode to use when rendering decals. This parameter is global and
   * cannot be set on a per-decal basis.
   */
  @JvmStatic
  public final fun decalsSetFilter(filter: DecalFilter): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to filter.value)
    TransferContext.callMethod(MethodBindings.decalsSetFilterPtr)
  }

  /**
   * If [halfResolution] is `true`, renders [VoxelGI] and SDFGI ([Environment.sdfgiEnabled]) buffers
   * at halved resolution on each axis (e.g. 960×540 when the viewport size is 1920×1080). This
   * improves performance significantly when VoxelGI or SDFGI is enabled, at the cost of artifacts that
   * may be visible on polygon edges. The loss in quality becomes less noticeable as the viewport
   * resolution increases. [LightmapGI] rendering is not affected by this setting. Equivalent to
   * [ProjectSettings.rendering/globalIllumination/gi/useHalfResolution].
   */
  @JvmStatic
  public final fun giSetUseHalfResolution(halfResolution: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to halfResolution)
    TransferContext.callMethod(MethodBindings.giSetUseHalfResolutionPtr)
  }

  /**
   * Creates a new voxel-based global illumination object and adds it to the RenderingServer. It can
   * be accessed with the RID that is returned. This RID will be used in all `voxel_gi_*`
   * RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent node is [VoxelGI].
   */
  @JvmStatic
  public final fun voxelGiCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.voxelGiCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Allocates and initializes the voxel GI data for the specified [voxelGi] RID. [octreeCells] must
   * be a multiple of 32. [octreeCells] must be double the size of [dataCells]. The allocated data can
   * be retrieved later using the various `voxel_gi_get_*` methods.
   */
  @JvmStatic
  public final fun voxelGiAllocateData(
    voxelGi: RID,
    toCellXform: Transform3D,
    aabb: AABB,
    octreeSize: Vector3i,
    octreeCells: PackedByteArray,
    dataCells: PackedByteArray,
    distanceField: PackedByteArray,
    levelCounts: PackedInt32Array,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to voxelGi, TRANSFORM3D to toCellXform, godot.core.VariantParser.AABB to aabb, VECTOR3I to octreeSize, PACKED_BYTE_ARRAY to octreeCells, PACKED_BYTE_ARRAY to dataCells, PACKED_BYTE_ARRAY to distanceField, PACKED_INT_32_ARRAY to levelCounts)
    TransferContext.callMethod(MethodBindings.voxelGiAllocateDataPtr)
  }

  /**
   * Returns the octree size for the specified voxel GI data instance, which corresponds to the
   * number of subdivisions per axis. This can be viewed in the editor by hovering the **Bake VoxelGI**
   * button at the top of the 3D editor viewport when a [VoxelGI] node is selected and looking at the
   * **Subdivisions** field in the tooltip.
   */
  @JvmStatic
  public final fun voxelGiGetOctreeSize(voxelGi: RID): Vector3i {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to voxelGi)
    TransferContext.callMethod(MethodBindings.voxelGiGetOctreeSizePtr)
    return (TransferContext.readReturnValue(VECTOR3I) as Vector3i)
  }

  /**
   * Returns the octree cell data for the specified voxel GI data instance. See also
   * [voxelGiAllocateData].
   */
  @JvmStatic
  public final fun voxelGiGetOctreeCells(voxelGi: RID): PackedByteArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to voxelGi)
    TransferContext.callMethod(MethodBindings.voxelGiGetOctreeCellsPtr)
    return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
  }

  /**
   * Returns the data cells for the specified voxel GI data instance. See also
   * [voxelGiAllocateData].
   */
  @JvmStatic
  public final fun voxelGiGetDataCells(voxelGi: RID): PackedByteArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to voxelGi)
    TransferContext.callMethod(MethodBindings.voxelGiGetDataCellsPtr)
    return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
  }

  /**
   * Returns the distance field data for the specified voxel GI data instance. See also
   * [voxelGiAllocateData].
   */
  @JvmStatic
  public final fun voxelGiGetDistanceField(voxelGi: RID): PackedByteArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to voxelGi)
    TransferContext.callMethod(MethodBindings.voxelGiGetDistanceFieldPtr)
    return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
  }

  /**
   * Returns the level counts for the specified voxel GI data instance. See also
   * [voxelGiAllocateData].
   */
  @JvmStatic
  public final fun voxelGiGetLevelCounts(voxelGi: RID): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to voxelGi)
    TransferContext.callMethod(MethodBindings.voxelGiGetLevelCountsPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Returns the transform to cell space for the specified voxel GI data instance. See also
   * [voxelGiAllocateData].
   */
  @JvmStatic
  public final fun voxelGiGetToCellXform(voxelGi: RID): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to voxelGi)
    TransferContext.callMethod(MethodBindings.voxelGiGetToCellXformPtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  /**
   * Sets the [VoxelGIData.dynamicRange] value to use on the specified [voxelGi]'s [RID].
   */
  @JvmStatic
  public final fun voxelGiSetDynamicRange(voxelGi: RID, range: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to voxelGi, DOUBLE to range.toDouble())
    TransferContext.callMethod(MethodBindings.voxelGiSetDynamicRangePtr)
  }

  /**
   * Sets the [VoxelGIData.propagation] value to use on the specified [voxelGi]'s [RID].
   */
  @JvmStatic
  public final fun voxelGiSetPropagation(voxelGi: RID, amount: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to voxelGi, DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.voxelGiSetPropagationPtr)
  }

  /**
   * Sets the [VoxelGIData.energy] value to use on the specified [voxelGi]'s [RID].
   */
  @JvmStatic
  public final fun voxelGiSetEnergy(voxelGi: RID, energy: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to voxelGi, DOUBLE to energy.toDouble())
    TransferContext.callMethod(MethodBindings.voxelGiSetEnergyPtr)
  }

  /**
   * Used to inform the renderer what exposure normalization value was used while baking the voxel
   * gi. This value will be used and modulated at run time to ensure that the voxel gi maintains a
   * consistent level of exposure even if the scene-wide exposure normalization is changed at run time.
   * For more information see [cameraAttributesSetExposure].
   */
  @JvmStatic
  public final fun voxelGiSetBakedExposureNormalization(voxelGi: RID, bakedExposure: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to voxelGi, DOUBLE to bakedExposure.toDouble())
    TransferContext.callMethod(MethodBindings.voxelGiSetBakedExposureNormalizationPtr)
  }

  /**
   * Sets the [VoxelGIData.bias] value to use on the specified [voxelGi]'s [RID].
   */
  @JvmStatic
  public final fun voxelGiSetBias(voxelGi: RID, bias: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to voxelGi, DOUBLE to bias.toDouble())
    TransferContext.callMethod(MethodBindings.voxelGiSetBiasPtr)
  }

  /**
   * Sets the [VoxelGIData.normalBias] value to use on the specified [voxelGi]'s [RID].
   */
  @JvmStatic
  public final fun voxelGiSetNormalBias(voxelGi: RID, bias: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to voxelGi, DOUBLE to bias.toDouble())
    TransferContext.callMethod(MethodBindings.voxelGiSetNormalBiasPtr)
  }

  /**
   * Sets the [VoxelGIData.interior] value to use on the specified [voxelGi]'s [RID].
   */
  @JvmStatic
  public final fun voxelGiSetInterior(voxelGi: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to voxelGi, BOOL to enable)
    TransferContext.callMethod(MethodBindings.voxelGiSetInteriorPtr)
  }

  /**
   * Sets the [VoxelGIData.useTwoBounces] value to use on the specified [voxelGi]'s [RID].
   */
  @JvmStatic
  public final fun voxelGiSetUseTwoBounces(voxelGi: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to voxelGi, BOOL to enable)
    TransferContext.callMethod(MethodBindings.voxelGiSetUseTwoBouncesPtr)
  }

  /**
   * Sets the [ProjectSettings.rendering/globalIllumination/voxelGi/quality] value to use when
   * rendering. This parameter is global and cannot be set on a per-VoxelGI basis.
   */
  @JvmStatic
  public final fun voxelGiSetQuality(quality: VoxelGIQuality): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to quality.value)
    TransferContext.callMethod(MethodBindings.voxelGiSetQualityPtr)
  }

  /**
   * Creates a new lightmap global illumination instance and adds it to the RenderingServer. It can
   * be accessed with the RID that is returned. This RID will be used in all `lightmap_*`
   * RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent node is [LightmapGI].
   */
  @JvmStatic
  public final fun lightmapCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.lightmapCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Set the textures on the given [lightmap] GI instance to the texture array pointed to by the
   * [light] RID. If the lightmap texture was baked with [LightmapGI.directional] set to `true`, then
   * [usesSh] must also be `true`.
   */
  @JvmStatic
  public final fun lightmapSetTextures(
    lightmap: RID,
    light: RID,
    usesSh: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to lightmap, _RID to light, BOOL to usesSh)
    TransferContext.callMethod(MethodBindings.lightmapSetTexturesPtr)
  }

  /**
   * Sets the bounds that this lightmap instance should visually affect, both in terms of static
   * lightmap baking and probe-based global illumination.
   */
  @JvmStatic
  public final fun lightmapSetProbeBounds(lightmap: RID, bounds: AABB): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to lightmap, godot.core.VariantParser.AABB to bounds)
    TransferContext.callMethod(MethodBindings.lightmapSetProbeBoundsPtr)
  }

  /**
   * Sets whether the lightmap instance should be considered as interior (when [interior] is
   * `true`). If the lightmap is marked as interior, environment lighting is ignored when baking
   * lightmaps.
   */
  @JvmStatic
  public final fun lightmapSetProbeInterior(lightmap: RID, interior: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to lightmap, BOOL to interior)
    TransferContext.callMethod(MethodBindings.lightmapSetProbeInteriorPtr)
  }

  /**
   * Sets the probe capture data for the given lightmap instance. See
   * [lightmapGetProbeCapturePoints], [lightmapGetProbeCaptureSh], [lightmapGetProbeCaptureTetrahedra],
   * and [lightmapGetProbeCaptureBspTree] for the expected data formats.
   */
  @JvmStatic
  public final fun lightmapSetProbeCaptureData(
    lightmap: RID,
    points: PackedVector3Array,
    pointSh: PackedColorArray,
    tetrahedra: PackedInt32Array,
    bspTree: PackedInt32Array,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to lightmap, PACKED_VECTOR3_ARRAY to points, PACKED_COLOR_ARRAY to pointSh, PACKED_INT_32_ARRAY to tetrahedra, PACKED_INT_32_ARRAY to bspTree)
    TransferContext.callMethod(MethodBindings.lightmapSetProbeCaptureDataPtr)
  }

  /**
   * Returns the *local space* positions of each lightmap probe capture point. Keep in mind the
   * lightmap instance may have a non-zero transform, which will affect the position of the probe
   * capture points. See also [lightmapSetProbeCaptureData].
   */
  @JvmStatic
  public final fun lightmapGetProbeCapturePoints(lightmap: RID): PackedVector3Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to lightmap)
    TransferContext.callMethod(MethodBindings.lightmapGetProbeCapturePointsPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR3_ARRAY) as PackedVector3Array)
  }

  /**
   * Returns the L0, L1, and L2 [url=https://en.wikipedia.org/wiki/Spherical_harmonics]spherical
   * harmonics[/url] data for each lightmap probe capture point. This is specified as 9 [Color] values
   * per probe, which means the size of the returned data is always 9 times the number of probe points.
   * See also [lightmapSetProbeCaptureData].
   */
  @JvmStatic
  public final fun lightmapGetProbeCaptureSh(lightmap: RID): PackedColorArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to lightmap)
    TransferContext.callMethod(MethodBindings.lightmapGetProbeCaptureShPtr)
    return (TransferContext.readReturnValue(PACKED_COLOR_ARRAY) as PackedColorArray)
  }

  /**
   * Returns the tetrahedralization data used for interpolating between lightmap probe capture
   * points. Each tetrahedron is specified as a series of 4 numbers, each being an index into the probe
   * capture points array returned by [lightmapGetProbeCapturePoints]. See also
   * [lightmapSetProbeCaptureData].
   */
  @JvmStatic
  public final fun lightmapGetProbeCaptureTetrahedra(lightmap: RID): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to lightmap)
    TransferContext.callMethod(MethodBindings.lightmapGetProbeCaptureTetrahedraPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Returns the BSP tree data used for accelerating probe lookups. The BSP data is structured as a
   * series of six signed 32-bit values per BSP node in this order: `float plane_x`, `float plane_y`,
   * `float plane_z`, `float plane_distance`, `int32_t over`, `int32_t under`. An empty leaf is denoted
   * by the value `-2147483648` (the minimum 32-bit signed integer). See also
   * [lightmapSetProbeCaptureData].
   */
  @JvmStatic
  public final fun lightmapGetProbeCaptureBspTree(lightmap: RID): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to lightmap)
    TransferContext.callMethod(MethodBindings.lightmapGetProbeCaptureBspTreePtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Used to inform the renderer what exposure normalization value was used while baking the
   * lightmap. This value will be used and modulated at run time to ensure that the lightmap maintains
   * a consistent level of exposure even if the scene-wide exposure normalization is changed at run
   * time. For more information see [cameraAttributesSetExposure].
   */
  @JvmStatic
  public final fun lightmapSetBakedExposureNormalization(lightmap: RID, bakedExposure: Float):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to lightmap, DOUBLE to bakedExposure.toDouble())
    TransferContext.callMethod(MethodBindings.lightmapSetBakedExposureNormalizationPtr)
  }

  /**
   * The framerate-independent update speed when representing dynamic object lighting from
   * [LightmapProbe]s. Higher values make dynamic object lighting update faster. Higher values can
   * prevent fast-moving objects from having "outdated" indirect lighting displayed on them, at the
   * cost of possible flickering when an object moves from a bright area to a shaded area. See also
   * [ProjectSettings.rendering/lightmapping/probeCapture/updateSpeed].
   */
  @JvmStatic
  public final fun lightmapSetProbeCaptureUpdateSpeed(speed: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to speed.toDouble())
    TransferContext.callMethod(MethodBindings.lightmapSetProbeCaptureUpdateSpeedPtr)
  }

  /**
   * Creates a GPU-based particle system and adds it to the RenderingServer. It can be accessed with
   * the RID that is returned. This RID will be used in all `particles_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * To place in a scene, attach these particles to an instance using [instanceSetBase] using the
   * returned RID.
   *
   * **Note:** The equivalent nodes are [GPUParticles2D] and [GPUParticles3D].
   *
   * **Note:** All `particles_*` methods only apply to GPU-based particles, not CPU-based particles.
   * [CPUParticles2D] and [CPUParticles3D] do not have equivalent RenderingServer functions available,
   * as these use [MultiMeshInstance2D] and [MultiMeshInstance3D] under the hood (see `multimesh_*`
   * methods).
   */
  @JvmStatic
  public final fun particlesCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.particlesCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets whether the GPU particles specified by the [particles] RID should be rendered in 2D or 3D
   * according to [mode].
   */
  @JvmStatic
  public final fun particlesSetMode(particles: RID, mode: ParticlesMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.particlesSetModePtr)
  }

  /**
   * If `true`, particles will emit over time. Setting to `false` does not reset the particles, but
   * only stops their emission. Equivalent to [GPUParticles3D.emitting].
   */
  @JvmStatic
  public final fun particlesSetEmitting(particles: RID, emitting: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, BOOL to emitting)
    TransferContext.callMethod(MethodBindings.particlesSetEmittingPtr)
  }

  /**
   * Returns `true` if particles are currently set to emitting.
   */
  @JvmStatic
  public final fun particlesGetEmitting(particles: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles)
    TransferContext.callMethod(MethodBindings.particlesGetEmittingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the number of particles to be drawn and allocates the memory for them. Equivalent to
   * [GPUParticles3D.amount].
   */
  @JvmStatic
  public final fun particlesSetAmount(particles: RID, amount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, LONG to amount.toLong())
    TransferContext.callMethod(MethodBindings.particlesSetAmountPtr)
  }

  /**
   * Sets the amount ratio for particles to be emitted. Equivalent to [GPUParticles3D.amountRatio].
   */
  @JvmStatic
  public final fun particlesSetAmountRatio(particles: RID, ratio: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, DOUBLE to ratio.toDouble())
    TransferContext.callMethod(MethodBindings.particlesSetAmountRatioPtr)
  }

  /**
   * Sets the lifetime of each particle in the system. Equivalent to [GPUParticles3D.lifetime].
   */
  @JvmStatic
  public final fun particlesSetLifetime(particles: RID, lifetime: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, DOUBLE to lifetime)
    TransferContext.callMethod(MethodBindings.particlesSetLifetimePtr)
  }

  /**
   * If `true`, particles will emit once and then stop. Equivalent to [GPUParticles3D.oneShot].
   */
  @JvmStatic
  public final fun particlesSetOneShot(particles: RID, oneShot: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, BOOL to oneShot)
    TransferContext.callMethod(MethodBindings.particlesSetOneShotPtr)
  }

  /**
   * Sets the preprocess time for the particles' animation. This lets you delay starting an
   * animation until after the particles have begun emitting. Equivalent to
   * [GPUParticles3D.preprocess].
   */
  @JvmStatic
  public final fun particlesSetPreProcessTime(particles: RID, time: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, DOUBLE to time)
    TransferContext.callMethod(MethodBindings.particlesSetPreProcessTimePtr)
  }

  /**
   * Requests the particles to process for extra process time during a single frame.
   *
   * [processTime] defines the time that the particles will process while emitting is on.
   * [processTimeResidual] defines the time that particles will process with emitting turned off for
   * the simulation. When combined with the particles' speed scale set to `0.0`, this is useful to be
   * able to seek a particle system timeline.
   */
  @JvmOverloads
  @JvmStatic
  public final fun particlesRequestProcessTime(
    particles: RID,
    processTime: Float,
    processTimeResidual: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, DOUBLE to processTime.toDouble(), DOUBLE to processTimeResidual.toDouble())
    TransferContext.callMethod(MethodBindings.particlesRequestProcessTimePtr)
  }

  /**
   * Sets the explosiveness ratio. Equivalent to [GPUParticles3D.explosiveness].
   */
  @JvmStatic
  public final fun particlesSetExplosivenessRatio(particles: RID, ratio: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, DOUBLE to ratio.toDouble())
    TransferContext.callMethod(MethodBindings.particlesSetExplosivenessRatioPtr)
  }

  /**
   * Sets the emission randomness ratio. This randomizes the emission of particles within their
   * phase. Equivalent to [GPUParticles3D.randomness].
   */
  @JvmStatic
  public final fun particlesSetRandomnessRatio(particles: RID, ratio: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, DOUBLE to ratio.toDouble())
    TransferContext.callMethod(MethodBindings.particlesSetRandomnessRatioPtr)
  }

  /**
   * Sets the value that informs a [ParticleProcessMaterial] to rush all particles towards the end
   * of their lifetime.
   */
  @JvmStatic
  public final fun particlesSetInterpToEnd(particles: RID, factor: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, DOUBLE to factor.toDouble())
    TransferContext.callMethod(MethodBindings.particlesSetInterpToEndPtr)
  }

  /**
   * Sets the velocity of a particle node, that will be used by
   * [ParticleProcessMaterial.inheritVelocityRatio].
   */
  @JvmStatic
  public final fun particlesSetEmitterVelocity(particles: RID, velocity: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, VECTOR3 to velocity)
    TransferContext.callMethod(MethodBindings.particlesSetEmitterVelocityPtr)
  }

  /**
   * Sets a custom axis-aligned bounding box for the particle system. Equivalent to
   * [GPUParticles3D.visibilityAabb].
   */
  @JvmStatic
  public final fun particlesSetCustomAabb(particles: RID, aabb: AABB): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, godot.core.VariantParser.AABB to aabb)
    TransferContext.callMethod(MethodBindings.particlesSetCustomAabbPtr)
  }

  /**
   * Sets the speed scale of the particle system. Equivalent to [GPUParticles3D.speedScale].
   */
  @JvmStatic
  public final fun particlesSetSpeedScale(particles: RID, scale: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, DOUBLE to scale)
    TransferContext.callMethod(MethodBindings.particlesSetSpeedScalePtr)
  }

  /**
   * If `true`, particles use local coordinates. If `false` they use global coordinates. Equivalent
   * to [GPUParticles3D.localCoords].
   */
  @JvmStatic
  public final fun particlesSetUseLocalCoordinates(particles: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, BOOL to enable)
    TransferContext.callMethod(MethodBindings.particlesSetUseLocalCoordinatesPtr)
  }

  /**
   * Sets the material for processing the particles.
   *
   * **Note:** This is not the material used to draw the materials. Equivalent to
   * [GPUParticles3D.processMaterial].
   */
  @JvmStatic
  public final fun particlesSetProcessMaterial(particles: RID, material: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, _RID to material)
    TransferContext.callMethod(MethodBindings.particlesSetProcessMaterialPtr)
  }

  /**
   * Sets the frame rate that the particle system rendering will be fixed to. Equivalent to
   * [GPUParticles3D.fixedFps].
   */
  @JvmStatic
  public final fun particlesSetFixedFps(particles: RID, fps: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, LONG to fps.toLong())
    TransferContext.callMethod(MethodBindings.particlesSetFixedFpsPtr)
  }

  /**
   * Sets whether particles should use interpolation between fixed steps. Equivalent to
   * [GPUParticles3D.interpolate].
   */
  @JvmStatic
  public final fun particlesSetInterpolate(particles: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, BOOL to enable)
    TransferContext.callMethod(MethodBindings.particlesSetInterpolatePtr)
  }

  /**
   * If `true`, uses fractional delta which smooths the movement of the particles. Equivalent to
   * [GPUParticles3D.fractDelta].
   */
  @JvmStatic
  public final fun particlesSetFractionalDelta(particles: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, BOOL to enable)
    TransferContext.callMethod(MethodBindings.particlesSetFractionalDeltaPtr)
  }

  /**
   * Sets the base size for particle collision. Equivalent to [GPUParticles3D.collisionBaseSize].
   */
  @JvmStatic
  public final fun particlesSetCollisionBaseSize(particles: RID, size: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, DOUBLE to size.toDouble())
    TransferContext.callMethod(MethodBindings.particlesSetCollisionBaseSizePtr)
  }

  /**
   * Sets the transform alignment for the particle system. Equivalent to
   * [GPUParticles3D.transformAlign].
   */
  @JvmStatic
  public final fun particlesSetTransformAlign(particles: RID, align: ParticlesTransformAlign):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, LONG to align.value)
    TransferContext.callMethod(MethodBindings.particlesSetTransformAlignPtr)
  }

  /**
   * When using Z-Billboarding, which CUSTOM channel to read from.
   */
  @JvmStatic
  public final fun particlesSetTransformAlignChannelFilter(particles: RID,
      channelFilter: ParticlesTransformAlignCustomSrc): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, LONG to channelFilter.value)
    TransferContext.callMethod(MethodBindings.particlesSetTransformAlignChannelFilterPtr)
  }

  /**
   * Sets which axis to use for transform alignment.
   */
  @JvmStatic
  public final fun particlesSetTransformAlignAxis(particles: RID,
      rotationAxis: ParticlesTransformAlignAxis): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, LONG to rotationAxis.value)
    TransferContext.callMethod(MethodBindings.particlesSetTransformAlignAxisPtr)
  }

  /**
   * If [enable] is `true`, enables trails for the [particles] with the specified [lengthSec] in
   * seconds. Equivalent to [GPUParticles3D.trailEnabled] and [GPUParticles3D.trailLifetime].
   */
  @JvmStatic
  public final fun particlesSetTrails(
    particles: RID,
    enable: Boolean,
    lengthSec: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, BOOL to enable, DOUBLE to lengthSec.toDouble())
    TransferContext.callMethod(MethodBindings.particlesSetTrailsPtr)
  }

  /**
   * Sets the trail bind poses for the particle system. This specified as an array of [Transform3D]s
   * representing the bind pose for each draw pass. See [GPUParticles3D.drawSkin], [Skin.getBindCount],
   * and [Skin.getBindPose]. Set the value for each draw pass to [Transform3D.IDENTITY] to use the
   * default behavior, which is what built-in trails use ([RibbonTrailMesh] and [TubeTrailMesh]).
   */
  @JvmStatic
  public final fun particlesSetTrailBindPoses(particles: RID, bindPoses: VariantArray<Transform3D>):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, ARRAY to bindPoses)
    TransferContext.callMethod(MethodBindings.particlesSetTrailBindPosesPtr)
  }

  /**
   * Returns `true` if particles are not emitting and particles are set to inactive.
   */
  @JvmStatic
  public final fun particlesIsInactive(particles: RID): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles)
    TransferContext.callMethod(MethodBindings.particlesIsInactivePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Add particle system to list of particle systems that need to be updated. Update will take place
   * on the next frame, or on the next call to [instancesCullAabb], [instancesCullConvex], or
   * [instancesCullRay].
   */
  @JvmStatic
  public final fun particlesRequestProcess(particles: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles)
    TransferContext.callMethod(MethodBindings.particlesRequestProcessPtr)
  }

  /**
   * Reset the particles on the next update. Equivalent to [GPUParticles3D.restart].
   */
  @JvmStatic
  public final fun particlesRestart(particles: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles)
    TransferContext.callMethod(MethodBindings.particlesRestartPtr)
  }

  /**
   * Sets the subemitter particles for the particle system. Equivalent to
   * [GPUParticles3D.subEmitter].
   */
  @JvmStatic
  public final fun particlesSetSubemitter(particles: RID, subemitterParticles: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, _RID to subemitterParticles)
    TransferContext.callMethod(MethodBindings.particlesSetSubemitterPtr)
  }

  /**
   * Manually emits particles from the [particles] instance.
   */
  @JvmStatic
  public final fun particlesEmit(
    particles: RID,
    transform: Transform3D,
    velocity: Vector3,
    color: Color,
    custom: Color,
    emitFlags: Long,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, TRANSFORM3D to transform, VECTOR3 to velocity, COLOR to color, COLOR to custom, LONG to emitFlags)
    TransferContext.callMethod(MethodBindings.particlesEmitPtr)
  }

  /**
   * Sets the draw order of the particles. Equivalent to [GPUParticles3D.drawOrder].
   */
  @JvmStatic
  public final fun particlesSetDrawOrder(particles: RID, order: ParticlesDrawOrder): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, LONG to order.value)
    TransferContext.callMethod(MethodBindings.particlesSetDrawOrderPtr)
  }

  /**
   * Sets the number of draw passes to use. Equivalent to [GPUParticles3D.drawPasses].
   */
  @JvmStatic
  public final fun particlesSetDrawPasses(particles: RID, count: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, LONG to count.toLong())
    TransferContext.callMethod(MethodBindings.particlesSetDrawPassesPtr)
  }

  /**
   * Sets the mesh to be used for the specified draw pass. Equivalent to [GPUParticles3D.drawPass1],
   * [GPUParticles3D.drawPass2], [GPUParticles3D.drawPass3], and [GPUParticles3D.drawPass4].
   */
  @JvmStatic
  public final fun particlesSetDrawPassMesh(
    particles: RID,
    pass: Int,
    mesh: RID,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, LONG to pass.toLong(), _RID to mesh)
    TransferContext.callMethod(MethodBindings.particlesSetDrawPassMeshPtr)
  }

  /**
   * Calculates and returns the axis-aligned bounding box that contains all the particles.
   * Equivalent to [GPUParticles3D.captureAabb].
   */
  @JvmStatic
  public final fun particlesGetCurrentAabb(particles: RID): AABB {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles)
    TransferContext.callMethod(MethodBindings.particlesGetCurrentAabbPtr)
    return (TransferContext.readReturnValue(godot.core.VariantParser.AABB) as AABB)
  }

  /**
   * Sets the [Transform3D] that will be used by the particles when they first emit.
   */
  @JvmStatic
  public final fun particlesSetEmissionTransform(particles: RID, transform: Transform3D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particles, TRANSFORM3D to transform)
    TransferContext.callMethod(MethodBindings.particlesSetEmissionTransformPtr)
  }

  /**
   * Creates a new 3D GPU particle collision or attractor and adds it to the RenderingServer. It can
   * be accessed with the RID that is returned. This RID can be used in most `particles_collision_*`
   * RenderingServer functions.
   *
   * **Note:** The equivalent nodes are [GPUParticlesCollision3D] and [GPUParticlesAttractor3D].
   */
  @JvmStatic
  public final fun particlesCollisionCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.particlesCollisionCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the collision or attractor shape [type] for the 3D GPU particles collision or attractor
   * specified by the [particlesCollision] RID.
   */
  @JvmStatic
  public final fun particlesCollisionSetCollisionType(particlesCollision: RID,
      type: ParticlesCollisionType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particlesCollision, LONG to type.value)
    TransferContext.callMethod(MethodBindings.particlesCollisionSetCollisionTypePtr)
  }

  /**
   * Sets the cull [mask] for the 3D GPU particles collision or attractor specified by the
   * [particlesCollision] RID. Equivalent to [GPUParticlesCollision3D.cullMask] or
   * [GPUParticlesAttractor3D.cullMask] depending on the [particlesCollision] type.
   */
  @JvmStatic
  public final fun particlesCollisionSetCullMask(particlesCollision: RID, mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particlesCollision, LONG to mask)
    TransferContext.callMethod(MethodBindings.particlesCollisionSetCullMaskPtr)
  }

  /**
   * Sets the [radius] for the 3D GPU particles sphere collision or attractor specified by the
   * [particlesCollision] RID. Equivalent to [GPUParticlesCollisionSphere3D.radius] or
   * [GPUParticlesAttractorSphere3D.radius] depending on the [particlesCollision] type.
   */
  @JvmStatic
  public final fun particlesCollisionSetSphereRadius(particlesCollision: RID, radius: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particlesCollision, DOUBLE to radius.toDouble())
    TransferContext.callMethod(MethodBindings.particlesCollisionSetSphereRadiusPtr)
  }

  /**
   * Sets the [extents] for the 3D GPU particles collision by the [particlesCollision] RID.
   * Equivalent to [GPUParticlesCollisionBox3D.size], [GPUParticlesCollisionSDF3D.size],
   * [GPUParticlesCollisionHeightField3D.size], [GPUParticlesAttractorBox3D.size] or
   * [GPUParticlesAttractorVectorField3D.size] depending on the [particlesCollision] type.
   */
  @JvmStatic
  public final fun particlesCollisionSetBoxExtents(particlesCollision: RID, extents: Vector3):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particlesCollision, VECTOR3 to extents)
    TransferContext.callMethod(MethodBindings.particlesCollisionSetBoxExtentsPtr)
  }

  /**
   * Sets the [strength] for the 3D GPU particles attractor specified by the [particlesCollision]
   * RID. Only used for attractors, not colliders. Equivalent to [GPUParticlesAttractor3D.strength].
   */
  @JvmStatic
  public final fun particlesCollisionSetAttractorStrength(particlesCollision: RID, strength: Float):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particlesCollision, DOUBLE to strength.toDouble())
    TransferContext.callMethod(MethodBindings.particlesCollisionSetAttractorStrengthPtr)
  }

  /**
   * Sets the directionality [amount] for the 3D GPU particles attractor specified by the
   * [particlesCollision] RID. Only used for attractors, not colliders. Equivalent to
   * [GPUParticlesAttractor3D.directionality].
   */
  @JvmStatic
  public final fun particlesCollisionSetAttractorDirectionality(particlesCollision: RID,
      amount: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particlesCollision, DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.particlesCollisionSetAttractorDirectionalityPtr)
  }

  /**
   * Sets the attenuation [curve] for the 3D GPU particles attractor specified by the
   * [particlesCollision] RID. Only used for attractors, not colliders. Equivalent to
   * [GPUParticlesAttractor3D.attenuation].
   */
  @JvmStatic
  public final fun particlesCollisionSetAttractorAttenuation(particlesCollision: RID, curve: Float):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particlesCollision, DOUBLE to curve.toDouble())
    TransferContext.callMethod(MethodBindings.particlesCollisionSetAttractorAttenuationPtr)
  }

  /**
   * Sets the signed distance field [texture] for the 3D GPU particles collision specified by the
   * [particlesCollision] RID. Equivalent to [GPUParticlesCollisionSDF3D.texture] or
   * [GPUParticlesAttractorVectorField3D.texture] depending on the [particlesCollision] type.
   */
  @JvmStatic
  public final fun particlesCollisionSetFieldTexture(particlesCollision: RID, texture: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particlesCollision, _RID to texture)
    TransferContext.callMethod(MethodBindings.particlesCollisionSetFieldTexturePtr)
  }

  /**
   * Requests an update for the 3D GPU particle collision heightfield. This may be automatically
   * called by the 3D GPU particle collision heightfield depending on its
   * [GPUParticlesCollisionHeightField3D.updateMode].
   */
  @JvmStatic
  public final fun particlesCollisionHeightFieldUpdate(particlesCollision: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particlesCollision)
    TransferContext.callMethod(MethodBindings.particlesCollisionHeightFieldUpdatePtr)
  }

  /**
   * Sets the heightmap [resolution] for the 3D GPU particles heightfield collision specified by the
   * [particlesCollision] RID. Equivalent to [GPUParticlesCollisionHeightField3D.resolution].
   */
  @JvmStatic
  public final fun particlesCollisionSetHeightFieldResolution(particlesCollision: RID,
      resolution: ParticlesCollisionHeightfieldResolution): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particlesCollision, LONG to resolution.value)
    TransferContext.callMethod(MethodBindings.particlesCollisionSetHeightFieldResolutionPtr)
  }

  /**
   * Sets the heightfield [mask] for the 3D GPU particles heightfield collision specified by the
   * [particlesCollision] RID. Equivalent to [GPUParticlesCollisionHeightField3D.heightfieldMask].
   */
  @JvmStatic
  public final fun particlesCollisionSetHeightFieldMask(particlesCollision: RID, mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to particlesCollision, LONG to mask)
    TransferContext.callMethod(MethodBindings.particlesCollisionSetHeightFieldMaskPtr)
  }

  /**
   * Creates a new fog volume and adds it to the RenderingServer. It can be accessed with the RID
   * that is returned. This RID will be used in all `fog_volume_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent node is [FogVolume].
   */
  @JvmStatic
  public final fun fogVolumeCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.fogVolumeCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the shape of the fog volume to either [RenderingServer.FOG_VOLUME_SHAPE_ELLIPSOID],
   * [RenderingServer.FOG_VOLUME_SHAPE_CONE], [RenderingServer.FOG_VOLUME_SHAPE_CYLINDER],
   * [RenderingServer.FOG_VOLUME_SHAPE_BOX] or [RenderingServer.FOG_VOLUME_SHAPE_WORLD].
   */
  @JvmStatic
  public final fun fogVolumeSetShape(fogVolume: RID, shape: FogVolumeShape): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fogVolume, LONG to shape.value)
    TransferContext.callMethod(MethodBindings.fogVolumeSetShapePtr)
  }

  /**
   * Sets the size of the fog volume when shape is [RenderingServer.FOG_VOLUME_SHAPE_ELLIPSOID],
   * [RenderingServer.FOG_VOLUME_SHAPE_CONE], [RenderingServer.FOG_VOLUME_SHAPE_CYLINDER] or
   * [RenderingServer.FOG_VOLUME_SHAPE_BOX].
   */
  @JvmStatic
  public final fun fogVolumeSetSize(fogVolume: RID, size: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fogVolume, VECTOR3 to size)
    TransferContext.callMethod(MethodBindings.fogVolumeSetSizePtr)
  }

  /**
   * Sets the [Material] of the fog volume. Can be either a [FogMaterial] or a custom
   * [ShaderMaterial].
   */
  @JvmStatic
  public final fun fogVolumeSetMaterial(fogVolume: RID, material: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to fogVolume, _RID to material)
    TransferContext.callMethod(MethodBindings.fogVolumeSetMaterialPtr)
  }

  /**
   * Creates a new 3D visibility notifier object and adds it to the RenderingServer. It can be
   * accessed with the RID that is returned. This RID will be used in all `visibility_notifier_*`
   * RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * To place in a scene, attach this notifier to an instance using [instanceSetBase] using the
   * returned RID.
   *
   * **Note:** The equivalent node is [VisibleOnScreenNotifier3D].
   */
  @JvmStatic
  public final fun visibilityNotifierCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.visibilityNotifierCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the AABB of the specified visibility notifier.
   */
  @JvmStatic
  public final fun visibilityNotifierSetAabb(notifier: RID, aabb: AABB): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to notifier, godot.core.VariantParser.AABB to aabb)
    TransferContext.callMethod(MethodBindings.visibilityNotifierSetAabbPtr)
  }

  /**
   * Sets the methods to be called when the notifier enters or exits the view.
   */
  @JvmStatic
  public final fun visibilityNotifierSetCallbacks(
    notifier: RID,
    enterCallable: Callable,
    exitCallable: Callable,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to notifier, CALLABLE to enterCallable, CALLABLE to exitCallable)
    TransferContext.callMethod(MethodBindings.visibilityNotifierSetCallbacksPtr)
  }

  /**
   * Creates an occluder instance and adds it to the RenderingServer. It can be accessed with the
   * RID that is returned. This RID will be used in all `occluder_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent resource is [Occluder3D] (not to be confused with the
   * [OccluderInstance3D] node).
   */
  @JvmStatic
  public final fun occluderCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.occluderCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the mesh data for the given occluder RID, which controls the shape of the occlusion
   * culling that will be performed.
   */
  @JvmStatic
  public final fun occluderSetMesh(
    occluder: RID,
    vertices: PackedVector3Array,
    indices: PackedInt32Array,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to occluder, PACKED_VECTOR3_ARRAY to vertices, PACKED_INT_32_ARRAY to indices)
    TransferContext.callMethod(MethodBindings.occluderSetMeshPtr)
  }

  /**
   * Creates a 3D camera and adds it to the RenderingServer. It can be accessed with the RID that is
   * returned. This RID will be used in all `camera_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent node is [Camera3D].
   */
  @JvmStatic
  public final fun cameraCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.cameraCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets camera to use perspective projection. Objects on the screen becomes smaller when they are
   * far away.
   */
  @JvmStatic
  public final fun cameraSetPerspective(
    camera: RID,
    fovyDegrees: Float,
    zNear: Float,
    zFar: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to camera, DOUBLE to fovyDegrees.toDouble(), DOUBLE to zNear.toDouble(), DOUBLE to zFar.toDouble())
    TransferContext.callMethod(MethodBindings.cameraSetPerspectivePtr)
  }

  /**
   * Sets camera to use orthogonal projection, also known as orthographic projection. Objects remain
   * the same size on the screen no matter how far away they are.
   */
  @JvmStatic
  public final fun cameraSetOrthogonal(
    camera: RID,
    size: Float,
    zNear: Float,
    zFar: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to camera, DOUBLE to size.toDouble(), DOUBLE to zNear.toDouble(), DOUBLE to zFar.toDouble())
    TransferContext.callMethod(MethodBindings.cameraSetOrthogonalPtr)
  }

  /**
   * Sets camera to use frustum projection. This mode allows adjusting the [offset] argument to
   * create "tilted frustum" effects.
   */
  @JvmStatic
  public final fun cameraSetFrustum(
    camera: RID,
    size: Float,
    offset: Vector2,
    zNear: Float,
    zFar: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to camera, DOUBLE to size.toDouble(), VECTOR2 to offset, DOUBLE to zNear.toDouble(), DOUBLE to zFar.toDouble())
    TransferContext.callMethod(MethodBindings.cameraSetFrustumPtr)
  }

  /**
   * Sets [Transform3D] of camera.
   */
  @JvmStatic
  public final fun cameraSetTransform(camera: RID, transform: Transform3D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to camera, TRANSFORM3D to transform)
    TransferContext.callMethod(MethodBindings.cameraSetTransformPtr)
  }

  /**
   * Sets the cull mask associated with this camera. The cull mask describes which 3D layers are
   * rendered by this camera. Equivalent to [Camera3D.cullMask].
   */
  @JvmStatic
  public final fun cameraSetCullMask(camera: RID, layers: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to camera, LONG to layers)
    TransferContext.callMethod(MethodBindings.cameraSetCullMaskPtr)
  }

  /**
   * Sets the environment used by this camera. Equivalent to [Camera3D.environment].
   */
  @JvmStatic
  public final fun cameraSetEnvironment(camera: RID, env: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to camera, _RID to env)
    TransferContext.callMethod(MethodBindings.cameraSetEnvironmentPtr)
  }

  /**
   * Sets the camera_attributes created with [cameraAttributesCreate] to the given camera.
   */
  @JvmStatic
  public final fun cameraSetCameraAttributes(camera: RID, effects: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to camera, _RID to effects)
    TransferContext.callMethod(MethodBindings.cameraSetCameraAttributesPtr)
  }

  /**
   * Sets the compositor used by this camera. Equivalent to [Camera3D.compositor].
   */
  @JvmStatic
  public final fun cameraSetCompositor(camera: RID, compositor: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to camera, _RID to compositor)
    TransferContext.callMethod(MethodBindings.cameraSetCompositorPtr)
  }

  /**
   * If `true`, preserves the horizontal aspect ratio which is equivalent to [Camera3D.KEEP_WIDTH].
   * If `false`, preserves the vertical aspect ratio which is equivalent to [Camera3D.KEEP_HEIGHT].
   */
  @JvmStatic
  public final fun cameraSetUseVerticalAspect(camera: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to camera, BOOL to enable)
    TransferContext.callMethod(MethodBindings.cameraSetUseVerticalAspectPtr)
  }

  /**
   * Creates an empty viewport and adds it to the RenderingServer. It can be accessed with the RID
   * that is returned. This RID will be used in all `viewport_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent node is [Viewport].
   */
  @JvmStatic
  public final fun viewportCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.viewportCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * If `true`, the viewport uses augmented or virtual reality technologies. See [XRInterface].
   */
  @JvmStatic
  public final fun viewportSetUseXr(viewport: RID, useXr: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, BOOL to useXr)
    TransferContext.callMethod(MethodBindings.viewportSetUseXrPtr)
  }

  /**
   * Sets the viewport's [width] and [height] in pixels. Optionally the [viewCount] can be set to
   * increase the number of view layers for stereo rendering.
   */
  @JvmOverloads
  @JvmStatic
  public final fun viewportSetSize(
    viewport: RID,
    width: Int,
    height: Int,
    viewCount: Int = 1,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to width.toLong(), LONG to height.toLong(), LONG to viewCount.toLong())
    TransferContext.callMethod(MethodBindings.viewportSetSizePtr)
  }

  /**
   * If `true`, sets the viewport active, else sets it inactive.
   */
  @JvmStatic
  public final fun viewportSetActive(viewport: RID, active: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, BOOL to active)
    TransferContext.callMethod(MethodBindings.viewportSetActivePtr)
  }

  /**
   * Sets the viewport's parent to the viewport specified by the [parentViewport] RID.
   */
  @JvmStatic
  public final fun viewportSetParentViewport(viewport: RID, parentViewport: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, _RID to parentViewport)
    TransferContext.callMethod(MethodBindings.viewportSetParentViewportPtr)
  }

  /**
   * Copies the viewport to a region of the screen specified by [rect]. If
   * [viewportSetRenderDirectToScreen] is `true`, then the viewport does not use a framebuffer and the
   * contents of the viewport are rendered directly to screen. However, note that the root viewport is
   * drawn last, therefore it will draw over the screen. Accordingly, you must set the root viewport to
   * an area that does not cover the area that you have attached this viewport to.
   *
   * For example, you can set the root viewport to not render at all with the following code:
   *
   * ```gdscript
   * //gdscript
   * func _ready():
   * 	RenderingServer.viewport_attach_to_screen(get_viewport().get_viewport_rid(), Rect2())
   * 	RenderingServer.viewport_attach_to_screen($Viewport.get_viewport_rid(), Rect2(0, 0, 600, 600))
   * ```
   *
   * Using this can result in significant optimization, especially on lower-end devices. However, it
   * comes at the cost of having to manage your viewports manually. For further optimization, see
   * [viewportSetRenderDirectToScreen].
   */
  @JvmOverloads
  @JvmStatic
  public final fun viewportAttachToScreen(
    viewport: RID,
    rect: Rect2 = Rect2(0.0, 0.0, 0.0, 0.0),
    screen: Int = 0,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, RECT2 to rect, LONG to screen.toLong())
    TransferContext.callMethod(MethodBindings.viewportAttachToScreenPtr)
  }

  /**
   * If `true`, render the contents of the viewport directly to screen. This allows a low-level
   * optimization where you can skip drawing a viewport to the root viewport. While this optimization
   * can result in a significant increase in speed (especially on older devices), it comes at a cost of
   * usability. When this is enabled, you cannot read from the viewport or from the screen_texture. You
   * also lose the benefit of certain window settings, such as the various stretch modes. Another
   * consequence to be aware of is that in 2D the rendering happens in window coordinates, so if you
   * have a viewport that is double the size of the window, and you set this, then only the portion
   * that fits within the window will be drawn, no automatic scaling is possible, even if your game
   * scene is significantly larger than the window size.
   */
  @JvmStatic
  public final fun viewportSetRenderDirectToScreen(viewport: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.viewportSetRenderDirectToScreenPtr)
  }

  /**
   * Sets the rendering mask associated with this [Viewport]. Only [CanvasItem] nodes with a
   * matching rendering visibility layer will be rendered by this [Viewport].
   */
  @JvmStatic
  public final fun viewportSetCanvasCullMask(viewport: RID, canvasCullMask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to canvasCullMask)
    TransferContext.callMethod(MethodBindings.viewportSetCanvasCullMaskPtr)
  }

  /**
   * Sets the 3D resolution scaling mode. Bilinear scaling renders at different resolution to either
   * undersample or supersample the viewport. FidelityFX Super Resolution 1.0, abbreviated to FSR, is
   * an upscaling technology that produces high quality images at fast framerates by using a spatially
   * aware upscaling algorithm. FSR is slightly more expensive than bilinear, but it produces
   * significantly higher image quality. FSR should be used where possible.
   */
  @JvmStatic
  public final fun viewportSetScaling3dMode(viewport: RID, scaling3dMode: ViewportScaling3DMode):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to scaling3dMode.value)
    TransferContext.callMethod(MethodBindings.viewportSetScaling3dModePtr)
  }

  /**
   * Scales the 3D render buffer based on the viewport size uses an image filter specified in
   * [ViewportScaling3DMode] to scale the output image to the full viewport size. Values lower than
   * `1.0` can be used to speed up 3D rendering at the cost of quality (undersampling). Values greater
   * than `1.0` are only valid for bilinear mode and can be used to improve 3D rendering quality at a
   * high performance cost (supersampling). See also [ViewportMSAA] for multi-sample antialiasing,
   * which is significantly cheaper but only smoothens the edges of polygons.
   *
   * When using FSR upscaling, AMD recommends exposing the following values as preset options to
   * users "Ultra Quality: 0.77", "Quality: 0.67", "Balanced: 0.59", "Performance: 0.5" instead of
   * exposing the entire scale.
   */
  @JvmStatic
  public final fun viewportSetScaling3dScale(viewport: RID, scale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, DOUBLE to scale.toDouble())
    TransferContext.callMethod(MethodBindings.viewportSetScaling3dScalePtr)
  }

  /**
   * Determines how sharp the upscaled image will be when using the FSR upscaling mode. Sharpness
   * halves with every whole number. Values go from 0.0 (sharpest) to 2.0. Values above 2.0 won't make
   * a visible difference.
   */
  @JvmStatic
  public final fun viewportSetFsrSharpness(viewport: RID, sharpness: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, DOUBLE to sharpness.toDouble())
    TransferContext.callMethod(MethodBindings.viewportSetFsrSharpnessPtr)
  }

  /**
   * Affects the final texture sharpness by reading from a lower or higher mipmap (also called
   * "texture LOD bias"). Negative values make mipmapped textures sharper but grainier when viewed at a
   * distance, while positive values make mipmapped textures blurrier (even when up close). To get
   * sharper textures at a distance without introducing too much graininess, set this between `-0.75`
   * and `0.0`. Enabling temporal antialiasing
   * ([ProjectSettings.rendering/antiAliasing/quality/useTaa]) can help reduce the graininess visible
   * when using negative mipmap bias.
   *
   * **Note:** When the 3D scaling mode is set to FSR 1.0, this value is used to adjust the
   * automatic mipmap bias which is calculated internally based on the scale factor. The formula for
   * this is `-log2(1.0 / scale) + mipmap_bias`.
   *
   * **Note:** This method is only supported in the Forward+ and Mobile renderers, not
   * Compatibility. In Compatibility, this method is always treated as if [mipmapBias] was set to
   * `0.0`.
   */
  @JvmStatic
  public final fun viewportSetTextureMipmapBias(viewport: RID, mipmapBias: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, DOUBLE to mipmapBias.toDouble())
    TransferContext.callMethod(MethodBindings.viewportSetTextureMipmapBiasPtr)
  }

  /**
   * Sets the maximum number of samples to take when using anisotropic filtering on textures (as a
   * power of two). A higher sample count will result in sharper textures at oblique angles, but is
   * more expensive to compute. A value of `0` forcibly disables anisotropic filtering, even on
   * materials where it is enabled.
   *
   * The anisotropic filtering level also affects decals and light projectors if they are configured
   * to use anisotropic filtering. See [ProjectSettings.rendering/textures/decals/filter] and
   * [ProjectSettings.rendering/textures/lightProjectors/filter].
   *
   * **Note:** In 3D, for this setting to have an effect, set [BaseMaterial3D.textureFilter] to
   * [BaseMaterial3D.TEXTURE_FILTER_LINEAR_WITH_MIPMAPS_ANISOTROPIC] or
   * [BaseMaterial3D.TEXTURE_FILTER_NEAREST_WITH_MIPMAPS_ANISOTROPIC] on materials.
   *
   * **Note:** In 2D, for this setting to have an effect, set [CanvasItem.textureFilter] to
   * [CanvasItem.TEXTURE_FILTER_LINEAR_WITH_MIPMAPS_ANISOTROPIC] or
   * [CanvasItem.TEXTURE_FILTER_NEAREST_WITH_MIPMAPS_ANISOTROPIC] on the [CanvasItem] node displaying
   * the texture (or in [CanvasTexture]). However, anisotropic filtering is rarely useful in 2D, so
   * only enable it for textures in 2D if it makes a meaningful visual difference.
   */
  @JvmStatic
  public final fun viewportSetAnisotropicFilteringLevel(viewport: RID,
      anisotropicFilteringLevel: ViewportAnisotropicFiltering): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to anisotropicFilteringLevel.value)
    TransferContext.callMethod(MethodBindings.viewportSetAnisotropicFilteringLevelPtr)
  }

  /**
   * Sets when the viewport should be updated.
   */
  @JvmStatic
  public final fun viewportSetUpdateMode(viewport: RID, updateMode: ViewportUpdateMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to updateMode.value)
    TransferContext.callMethod(MethodBindings.viewportSetUpdateModePtr)
  }

  /**
   * Returns the viewport's update mode.
   *
   * **Warning:** Calling this from any thread other than the rendering thread will be detrimental
   * to performance.
   */
  @JvmStatic
  public final fun viewportGetUpdateMode(viewport: RID): ViewportUpdateMode {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport)
    TransferContext.callMethod(MethodBindings.viewportGetUpdateModePtr)
    return ViewportUpdateMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the clear mode of a viewport.
   */
  @JvmStatic
  public final fun viewportSetClearMode(viewport: RID, clearMode: ViewportClearMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to clearMode.value)
    TransferContext.callMethod(MethodBindings.viewportSetClearModePtr)
  }

  /**
   * Returns the render target for the viewport.
   */
  @JvmStatic
  public final fun viewportGetRenderTarget(viewport: RID): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport)
    TransferContext.callMethod(MethodBindings.viewportGetRenderTargetPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the viewport's last rendered frame.
   */
  @JvmStatic
  public final fun viewportGetTexture(viewport: RID): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport)
    TransferContext.callMethod(MethodBindings.viewportGetTexturePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * If `true`, the viewport's 3D elements are not rendered.
   */
  @JvmStatic
  public final fun viewportSetDisable3d(viewport: RID, disable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, BOOL to disable)
    TransferContext.callMethod(MethodBindings.viewportSetDisable3dPtr)
  }

  /**
   * If `true`, the viewport's canvas (i.e. 2D and GUI elements) is not rendered.
   */
  @JvmStatic
  public final fun viewportSetDisable2d(viewport: RID, disable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, BOOL to disable)
    TransferContext.callMethod(MethodBindings.viewportSetDisable2dPtr)
  }

  /**
   * Sets the viewport's environment mode which allows enabling or disabling rendering of 3D
   * environment over 2D canvas. When disabled, 2D will not be affected by the environment. When
   * enabled, 2D will be affected by the environment if the environment background mode is
   * [ENV_BG_CANVAS]. The default behavior is to inherit the setting from the viewport's parent. If the
   * topmost parent is also set to [VIEWPORT_ENVIRONMENT_INHERIT], then the behavior will be the same
   * as if it was set to [VIEWPORT_ENVIRONMENT_ENABLED].
   */
  @JvmStatic
  public final fun viewportSetEnvironmentMode(viewport: RID, mode: ViewportEnvironmentMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.viewportSetEnvironmentModePtr)
  }

  /**
   * Sets a viewport's camera.
   */
  @JvmStatic
  public final fun viewportAttachCamera(viewport: RID, camera: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, _RID to camera)
    TransferContext.callMethod(MethodBindings.viewportAttachCameraPtr)
  }

  /**
   * Sets a viewport's scenario. The scenario contains information about environment information,
   * reflection atlas, etc.
   */
  @JvmStatic
  public final fun viewportSetScenario(viewport: RID, scenario: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, _RID to scenario)
    TransferContext.callMethod(MethodBindings.viewportSetScenarioPtr)
  }

  /**
   * Sets a viewport's canvas.
   */
  @JvmStatic
  public final fun viewportAttachCanvas(viewport: RID, canvas: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, _RID to canvas)
    TransferContext.callMethod(MethodBindings.viewportAttachCanvasPtr)
  }

  /**
   * Detaches a viewport from a canvas.
   */
  @JvmStatic
  public final fun viewportRemoveCanvas(viewport: RID, canvas: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, _RID to canvas)
    TransferContext.callMethod(MethodBindings.viewportRemoveCanvasPtr)
  }

  /**
   * If `true`, canvas item transforms (i.e. origin position) are snapped to the nearest pixel when
   * rendering. This can lead to a crisper appearance at the cost of less smooth movement, especially
   * when [Camera2D] smoothing is enabled. Equivalent to
   * [ProjectSettings.rendering/2d/snap/snap2dTransformsToPixel].
   */
  @JvmStatic
  public final fun viewportSetSnap2dTransformsToPixel(viewport: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.viewportSetSnap2dTransformsToPixelPtr)
  }

  /**
   * If `true`, canvas item vertices (i.e. polygon points) are snapped to the nearest pixel when
   * rendering. This can lead to a crisper appearance at the cost of less smooth movement, especially
   * when [Camera2D] smoothing is enabled. Equivalent to
   * [ProjectSettings.rendering/2d/snap/snap2dVerticesToPixel].
   */
  @JvmStatic
  public final fun viewportSetSnap2dVerticesToPixel(viewport: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.viewportSetSnap2dVerticesToPixelPtr)
  }

  /**
   * Sets the default texture filtering mode for the specified [viewport] RID.
   */
  @JvmStatic
  public final fun viewportSetDefaultCanvasItemTextureFilter(viewport: RID,
      filter: CanvasItemTextureFilter): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to filter.value)
    TransferContext.callMethod(MethodBindings.viewportSetDefaultCanvasItemTextureFilterPtr)
  }

  /**
   * Sets the default texture repeat mode for the specified [viewport] RID.
   */
  @JvmStatic
  public final fun viewportSetDefaultCanvasItemTextureRepeat(viewport: RID,
      repeat: CanvasItemTextureRepeat): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to repeat.value)
    TransferContext.callMethod(MethodBindings.viewportSetDefaultCanvasItemTextureRepeatPtr)
  }

  /**
   * Sets the transformation of a viewport's canvas.
   */
  @JvmStatic
  public final fun viewportSetCanvasTransform(
    viewport: RID,
    canvas: RID,
    offset: Transform2D,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, _RID to canvas, TRANSFORM2D to offset)
    TransferContext.callMethod(MethodBindings.viewportSetCanvasTransformPtr)
  }

  /**
   * Sets the stacking order for a viewport's canvas.
   *
   * [layer] is the actual canvas layer, while [sublayer] specifies the stacking order of the canvas
   * among those in the same layer.
   *
   * **Note:** [layer] should be between [CANVAS_LAYER_MIN] and [CANVAS_LAYER_MAX] (inclusive). Any
   * other value will wrap around.
   */
  @JvmStatic
  public final fun viewportSetCanvasStacking(
    viewport: RID,
    canvas: RID,
    layer: Int,
    sublayer: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, _RID to canvas, LONG to layer.toLong(), LONG to sublayer.toLong())
    TransferContext.callMethod(MethodBindings.viewportSetCanvasStackingPtr)
  }

  /**
   * If `true`, the viewport renders its background as transparent.
   */
  @JvmStatic
  public final fun viewportSetTransparentBackground(viewport: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.viewportSetTransparentBackgroundPtr)
  }

  /**
   * Sets the viewport's global transformation matrix.
   */
  @JvmStatic
  public final fun viewportSetGlobalCanvasTransform(viewport: RID, transform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.viewportSetGlobalCanvasTransformPtr)
  }

  /**
   * Sets the viewport's 2D signed distance field [ProjectSettings.rendering/2d/sdf/oversize] and
   * [ProjectSettings.rendering/2d/sdf/scale]. This is used when sampling the signed distance field in
   * [CanvasItem] shaders as well as [GPUParticles2D] collision. This is *not* used by SDFGI in 3D
   * rendering.
   */
  @JvmStatic
  public final fun viewportSetSdfOversizeAndScale(
    viewport: RID,
    oversize: ViewportSDFOversize,
    scale: ViewportSDFScale,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to oversize.value, LONG to scale.value)
    TransferContext.callMethod(MethodBindings.viewportSetSdfOversizeAndScalePtr)
  }

  /**
   * Sets the [size] of the shadow atlas's images (used for omni and spot lights) on the viewport
   * specified by the [viewport] RID. The value is rounded up to the nearest power of 2. If [use16Bits]
   * is `true`, use 16 bits for the omni/spot shadow depth map. Enabling this results in shadows having
   * less precision and may result in shadow acne, but can lead to performance improvements on some
   * devices.
   *
   * **Note:** If this is set to `0`, no positional shadows will be visible at all. This can improve
   * performance significantly on low-end systems by reducing both the CPU and GPU load (as fewer draw
   * calls are needed to draw the scene without shadows).
   */
  @JvmOverloads
  @JvmStatic
  public final fun viewportSetPositionalShadowAtlasSize(
    viewport: RID,
    size: Int,
    use16Bits: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to size.toLong(), BOOL to use16Bits)
    TransferContext.callMethod(MethodBindings.viewportSetPositionalShadowAtlasSizePtr)
  }

  /**
   * Sets the number of subdivisions to use in the specified shadow atlas [quadrant] for omni and
   * spot shadows. See also [Viewport.setPositionalShadowAtlasQuadrantSubdiv].
   */
  @JvmStatic
  public final fun viewportSetPositionalShadowAtlasQuadrantSubdivision(
    viewport: RID,
    quadrant: Int,
    subdivision: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to quadrant.toLong(), LONG to subdivision.toLong())
    TransferContext.callMethod(MethodBindings.viewportSetPositionalShadowAtlasQuadrantSubdivisionPtr)
  }

  /**
   * Sets the multisample antialiasing mode for 3D on the specified [viewport] RID. Equivalent to
   * [ProjectSettings.rendering/antiAliasing/quality/msaa3d] or [Viewport.msaa3d].
   */
  @JvmStatic
  public final fun viewportSetMsaa3d(viewport: RID, msaa: ViewportMSAA): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to msaa.value)
    TransferContext.callMethod(MethodBindings.viewportSetMsaa3dPtr)
  }

  /**
   * Sets the multisample antialiasing mode for 2D/Canvas on the specified [viewport] RID.
   * Equivalent to [ProjectSettings.rendering/antiAliasing/quality/msaa2d] or [Viewport.msaa2d].
   */
  @JvmStatic
  public final fun viewportSetMsaa2d(viewport: RID, msaa: ViewportMSAA): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to msaa.value)
    TransferContext.callMethod(MethodBindings.viewportSetMsaa2dPtr)
  }

  /**
   * If `true`, 2D rendering will use a high dynamic range (HDR) `RGBA16` format framebuffer.
   * Additionally, 2D rendering will be performed on linear values and will be converted using the
   * appropriate transfer function immediately before blitting to the screen (if the Viewport is
   * attached to the screen).
   *
   * Practically speaking, this means that the end result of the Viewport will not be clamped to the
   * `0-1` range and can be used in 3D rendering without color encoding adjustments. This allows 2D
   * rendering to take advantage of effects requiring high dynamic range (e.g. 2D glow) as well as
   * substantially improves the appearance of effects requiring highly detailed gradients. This setting
   * has the same effect as [Viewport.useHdr2d].
   */
  @JvmStatic
  public final fun viewportSetUseHdr2d(viewport: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.viewportSetUseHdr2dPtr)
  }

  /**
   * Sets the viewport's screen-space antialiasing mode. Equivalent to
   * [ProjectSettings.rendering/antiAliasing/quality/screenSpaceAa] or [Viewport.screenSpaceAa].
   */
  @JvmStatic
  public final fun viewportSetScreenSpaceAa(viewport: RID, mode: ViewportScreenSpaceAA): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.viewportSetScreenSpaceAaPtr)
  }

  /**
   * If `true`, use temporal antialiasing. Equivalent to
   * [ProjectSettings.rendering/antiAliasing/quality/useTaa] or [Viewport.useTaa].
   */
  @JvmStatic
  public final fun viewportSetUseTaa(viewport: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, BOOL to enable)
    TransferContext.callMethod(MethodBindings.viewportSetUseTaaPtr)
  }

  /**
   * Equivalent to [Viewport.useDebanding]. See also
   * [ProjectSettings.rendering/antiAliasing/quality/useDebanding].
   */
  @JvmStatic
  public final fun viewportSetUseDebanding(viewport: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, BOOL to enable)
    TransferContext.callMethod(MethodBindings.viewportSetUseDebandingPtr)
  }

  /**
   * If `true`, enables occlusion culling on the specified viewport. Equivalent to
   * [ProjectSettings.rendering/occlusionCulling/useOcclusionCulling].
   */
  @JvmStatic
  public final fun viewportSetUseOcclusionCulling(viewport: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, BOOL to enable)
    TransferContext.callMethod(MethodBindings.viewportSetUseOcclusionCullingPtr)
  }

  /**
   * Sets the [ProjectSettings.rendering/occlusionCulling/occlusionRaysPerThread] to use for
   * occlusion culling. This parameter is global and cannot be set on a per-viewport basis.
   */
  @JvmStatic
  public final fun viewportSetOcclusionRaysPerThread(raysPerThread: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to raysPerThread.toLong())
    TransferContext.callMethod(MethodBindings.viewportSetOcclusionRaysPerThreadPtr)
  }

  /**
   * Sets the [ProjectSettings.rendering/occlusionCulling/bvhBuildQuality] to use for occlusion
   * culling. This parameter is global and cannot be set on a per-viewport basis.
   */
  @JvmStatic
  public final
      fun viewportSetOcclusionCullingBuildQuality(quality: ViewportOcclusionCullingBuildQuality):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to quality.value)
    TransferContext.callMethod(MethodBindings.viewportSetOcclusionCullingBuildQualityPtr)
  }

  /**
   * Returns a statistic about the rendering engine which can be used for performance profiling.
   * This is separated into render pass [type]s, each of them having the same [info]s you can query
   * (different passes will return different values).
   *
   * See also [getRenderingInfo], which returns global information across all viewports.
   *
   * **Note:** Viewport rendering information is not available until at least 2 frames have been
   * rendered by the engine. If rendering information is not available, [viewportGetRenderInfo] returns
   * `0`. To print rendering information in `_ready()` successfully, use the following:
   *
   * ```
   * func _ready():
   * 	for _i in 2:
   * 		await get_tree().process_frame
   *
   * 	print(
   * 			RenderingServer.viewport_get_render_info(get_viewport().get_viewport_rid(),
   * 			RenderingServer.VIEWPORT_RENDER_INFO_TYPE_VISIBLE,
   * 			RenderingServer.VIEWPORT_RENDER_INFO_DRAW_CALLS_IN_FRAME)
   * 	)
   * ```
   */
  @JvmStatic
  public final fun viewportGetRenderInfo(
    viewport: RID,
    type: ViewportRenderInfoType,
    info: ViewportRenderInfo,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to type.value, LONG to info.value)
    TransferContext.callMethod(MethodBindings.viewportGetRenderInfoPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the debug draw mode of a viewport.
   */
  @JvmStatic
  public final fun viewportSetDebugDraw(viewport: RID, draw: ViewportDebugDraw): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to draw.value)
    TransferContext.callMethod(MethodBindings.viewportSetDebugDrawPtr)
  }

  /**
   * Sets the measurement for the given [viewport] RID (obtained using [Viewport.getViewportRid]).
   * Once enabled, [viewportGetMeasuredRenderTimeCpu] and [viewportGetMeasuredRenderTimeGpu] will
   * return values greater than `0.0` when queried with the given [viewport].
   */
  @JvmStatic
  public final fun viewportSetMeasureRenderTime(viewport: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, BOOL to enable)
    TransferContext.callMethod(MethodBindings.viewportSetMeasureRenderTimePtr)
  }

  /**
   * Returns the CPU time taken to render the last frame in milliseconds. This *only* includes time
   * spent in rendering-related operations; scripts' `_process` functions and other engine subsystems
   * are not included in this readout. To get a complete readout of CPU time spent to render the scene,
   * sum the render times of all viewports that are drawn every frame plus [getFrameSetupTimeCpu].
   * Unlike [Engine.getFramesPerSecond], this method will accurately reflect CPU utilization even if
   * framerate is capped via V-Sync or [Engine.maxFps]. See also [viewportGetMeasuredRenderTimeGpu].
   *
   * **Note:** Requires measurements to be enabled on the specified [viewport] using
   * [viewportSetMeasureRenderTime]. Otherwise, this method returns `0.0`.
   */
  @JvmStatic
  public final fun viewportGetMeasuredRenderTimeCpu(viewport: RID): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport)
    TransferContext.callMethod(MethodBindings.viewportGetMeasuredRenderTimeCpuPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Returns the GPU time taken to render the last frame in milliseconds. To get a complete readout
   * of GPU time spent to render the scene, sum the render times of all viewports that are drawn every
   * frame. Unlike [Engine.getFramesPerSecond], this method accurately reflects GPU utilization even if
   * framerate is capped via V-Sync or [Engine.maxFps]. See also [viewportGetMeasuredRenderTimeCpu].
   *
   * **Note:** Requires measurements to be enabled on the specified [viewport] using
   * [viewportSetMeasureRenderTime]. Otherwise, this method returns `0.0`.
   *
   * **Note:** When GPU utilization is low enough during a certain period of time, GPUs will
   * decrease their power state (which in turn decreases core and memory clock speeds). This can cause
   * the reported GPU time to increase if GPU utilization is kept low enough by a framerate cap
   * (compared to what it would be at the GPU's highest power state). Keep this in mind when
   * benchmarking using [viewportGetMeasuredRenderTimeGpu]. This behavior can be overridden in the
   * graphics driver settings at the cost of higher power usage.
   */
  @JvmStatic
  public final fun viewportGetMeasuredRenderTimeGpu(viewport: RID): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport)
    TransferContext.callMethod(MethodBindings.viewportGetMeasuredRenderTimeGpuPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Sets the Variable Rate Shading (VRS) mode for the viewport. If the GPU does not support VRS,
   * this property is ignored. Equivalent to [ProjectSettings.rendering/vrs/mode].
   */
  @JvmStatic
  public final fun viewportSetVrsMode(viewport: RID, mode: ViewportVRSMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.viewportSetVrsModePtr)
  }

  /**
   * Sets the update mode for Variable Rate Shading (VRS) for the viewport. VRS requires the input
   * texture to be converted to the format usable by the VRS method supported by the hardware. The
   * update mode defines how often this happens. If the GPU does not support VRS, or VRS is not
   * enabled, this property is ignored.
   *
   * If set to [RenderingServer.VIEWPORT_VRS_UPDATE_ONCE], the input texture is copied once and the
   * mode is changed to [RenderingServer.VIEWPORT_VRS_UPDATE_DISABLED].
   */
  @JvmStatic
  public final fun viewportSetVrsUpdateMode(viewport: RID, mode: ViewportVRSUpdateMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.viewportSetVrsUpdateModePtr)
  }

  /**
   * The texture to use when the VRS mode is set to [RenderingServer.VIEWPORT_VRS_TEXTURE].
   * Equivalent to [ProjectSettings.rendering/vrs/texture].
   */
  @JvmStatic
  public final fun viewportSetVrsTexture(viewport: RID, texture: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to viewport, _RID to texture)
    TransferContext.callMethod(MethodBindings.viewportSetVrsTexturePtr)
  }

  /**
   * Creates an empty sky and adds it to the RenderingServer. It can be accessed with the RID that
   * is returned. This RID will be used in all `sky_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   */
  @JvmStatic
  public final fun skyCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.skyCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the [radianceSize] of the sky specified by the [sky] RID (in pixels). Equivalent to
   * [Sky.radianceSize].
   */
  @JvmStatic
  public final fun skySetRadianceSize(sky: RID, radianceSize: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to sky, LONG to radianceSize.toLong())
    TransferContext.callMethod(MethodBindings.skySetRadianceSizePtr)
  }

  /**
   * Sets the process [mode] of the sky specified by the [sky] RID. Equivalent to [Sky.processMode].
   */
  @JvmStatic
  public final fun skySetMode(sky: RID, mode: SkyMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to sky, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.skySetModePtr)
  }

  /**
   * Sets the material that the sky uses to render the background, ambient and reflection maps.
   */
  @JvmStatic
  public final fun skySetMaterial(sky: RID, material: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to sky, _RID to material)
    TransferContext.callMethod(MethodBindings.skySetMaterialPtr)
  }

  /**
   * Generates and returns an [Image] containing the radiance map for the specified [sky] RID. This
   * supports built-in sky material and custom sky shaders. If [bakeIrradiance] is `true`, the
   * irradiance map is saved instead of the radiance map. The radiance map is used to render reflected
   * light, while the irradiance map is used to render ambient light. See also
   * [environmentBakePanorama].
   *
   * **Note:** The image is saved using linear encoding without any tonemapping performed, which
   * means it will look too dark if viewed directly in an image editor. [energy] values above `1.0` can
   * be used to brighten the resulting image.
   *
   * **Note:** [size] should be a 2:1 aspect ratio for the generated panorama to have square pixels.
   * For radiance maps, there is no point in using a height greater than [Sky.radianceSize], as it
   * won't increase detail. Irradiance maps only contain low-frequency data, so there is usually no
   * point in going past a size of 128×64 pixels when saving an irradiance map.
   */
  @JvmStatic
  public final fun skyBakePanorama(
    sky: RID,
    energy: Float,
    bakeIrradiance: Boolean,
    size: Vector2i,
  ): Image? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to sky, DOUBLE to energy.toDouble(), BOOL to bakeIrradiance, VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.skyBakePanoramaPtr)
    return (TransferContext.readReturnValue(OBJECT) as Image?)
  }

  /**
   * Creates a new rendering effect and adds it to the RenderingServer. It can be accessed with the
   * RID that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   */
  @JvmStatic
  public final fun compositorEffectCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.compositorEffectCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Enables/disables this rendering effect.
   */
  @JvmStatic
  public final fun compositorEffectSetEnabled(effect: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to effect, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.compositorEffectSetEnabledPtr)
  }

  /**
   * Sets the callback type ([callbackType]) and callback method([callback]) for this rendering
   * effect.
   */
  @JvmStatic
  public final fun compositorEffectSetCallback(
    effect: RID,
    callbackType: CompositorEffectCallbackType,
    callback: Callable,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to effect, LONG to callbackType.value, CALLABLE to callback)
    TransferContext.callMethod(MethodBindings.compositorEffectSetCallbackPtr)
  }

  /**
   * Sets the flag ([flag]) for this rendering effect to `true` or `false` ([set]).
   */
  @JvmStatic
  public final fun compositorEffectSetFlag(
    effect: RID,
    flag: CompositorEffectFlags,
    `set`: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to effect, LONG to flag.value, BOOL to set)
    TransferContext.callMethod(MethodBindings.compositorEffectSetFlagPtr)
  }

  /**
   * Creates a new compositor and adds it to the RenderingServer. It can be accessed with the RID
   * that is returned.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   */
  @JvmStatic
  public final fun compositorCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.compositorCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the compositor effects for the specified compositor RID. [effects] should be an array
   * containing RIDs created with [compositorEffectCreate].
   */
  @JvmStatic
  public final fun compositorSetCompositorEffects(compositor: RID, effects: VariantArray<RID>):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to compositor, ARRAY to effects)
    TransferContext.callMethod(MethodBindings.compositorSetCompositorEffectsPtr)
  }

  /**
   * Creates an environment and adds it to the RenderingServer. It can be accessed with the RID that
   * is returned. This RID will be used in all `environment_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent resource is [Environment].
   */
  @JvmStatic
  public final fun environmentCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.environmentCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the environment's background mode. Equivalent to [Environment.backgroundMode].
   */
  @JvmStatic
  public final fun environmentSetBackground(env: RID, bg: EnvironmentBG): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, LONG to bg.value)
    TransferContext.callMethod(MethodBindings.environmentSetBackgroundPtr)
  }

  /**
   * Sets the camera ID to be used as environment background.
   */
  @JvmStatic
  public final fun environmentSetCameraId(env: RID, id: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.environmentSetCameraIdPtr)
  }

  /**
   * Sets the [Sky] to be used as the environment's background when using *BGMode* sky. Equivalent
   * to [Environment.sky].
   */
  @JvmStatic
  public final fun environmentSetSky(env: RID, sky: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, _RID to sky)
    TransferContext.callMethod(MethodBindings.environmentSetSkyPtr)
  }

  /**
   * Sets a custom field of view for the background [Sky]. Equivalent to [Environment.skyCustomFov].
   */
  @JvmStatic
  public final fun environmentSetSkyCustomFov(env: RID, scale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, DOUBLE to scale.toDouble())
    TransferContext.callMethod(MethodBindings.environmentSetSkyCustomFovPtr)
  }

  /**
   * Sets the rotation of the background [Sky] expressed as a [Basis]. Equivalent to
   * [Environment.skyRotation], where the rotation vector is used to construct the [Basis].
   */
  @JvmStatic
  public final fun environmentSetSkyOrientation(env: RID, orientation: Basis): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, BASIS to orientation)
    TransferContext.callMethod(MethodBindings.environmentSetSkyOrientationPtr)
  }

  /**
   * Color displayed for clear areas of the scene. Only effective if using the [ENV_BG_COLOR]
   * background mode.
   */
  @JvmStatic
  public final fun environmentSetBgColor(env: RID, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, COLOR to color)
    TransferContext.callMethod(MethodBindings.environmentSetBgColorPtr)
  }

  /**
   * Sets the intensity of the background color.
   */
  @JvmStatic
  public final fun environmentSetBgEnergy(
    env: RID,
    multiplier: Float,
    exposureValue: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, DOUBLE to multiplier.toDouble(), DOUBLE to exposureValue.toDouble())
    TransferContext.callMethod(MethodBindings.environmentSetBgEnergyPtr)
  }

  /**
   * Sets the maximum layer to use if using Canvas background mode.
   */
  @JvmStatic
  public final fun environmentSetCanvasMaxLayer(env: RID, maxLayer: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, LONG to maxLayer.toLong())
    TransferContext.callMethod(MethodBindings.environmentSetCanvasMaxLayerPtr)
  }

  /**
   * Sets the values to be used for ambient light rendering. See [Environment] for more details.
   */
  @JvmOverloads
  @JvmStatic
  public final fun environmentSetAmbientLight(
    env: RID,
    color: Color,
    ambient: EnvironmentAmbientSource = RenderingServer.EnvironmentAmbientSource.BG,
    energy: Float = 1.0f,
    skyContribution: Float = 0.0f,
    reflectionSource: EnvironmentReflectionSource = RenderingServer.EnvironmentReflectionSource.BG,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, COLOR to color, LONG to ambient.value, DOUBLE to energy.toDouble(), DOUBLE to skyContribution.toDouble(), LONG to reflectionSource.value)
    TransferContext.callMethod(MethodBindings.environmentSetAmbientLightPtr)
  }

  /**
   * Configures glow for the specified environment RID. See `glow_*` properties in [Environment] for
   * more information.
   */
  @JvmStatic
  public final fun environmentSetGlow(
    env: RID,
    enable: Boolean,
    levels: PackedFloat32Array,
    intensity: Float,
    strength: Float,
    mix: Float,
    bloomThreshold: Float,
    blendMode: EnvironmentGlowBlendMode,
    hdrBleedThreshold: Float,
    hdrBleedScale: Float,
    hdrLuminanceCap: Float,
    glowMapStrength: Float,
    glowMap: RID,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, BOOL to enable, PACKED_FLOAT_32_ARRAY to levels, DOUBLE to intensity.toDouble(), DOUBLE to strength.toDouble(), DOUBLE to mix.toDouble(), DOUBLE to bloomThreshold.toDouble(), LONG to blendMode.value, DOUBLE to hdrBleedThreshold.toDouble(), DOUBLE to hdrBleedScale.toDouble(), DOUBLE to hdrLuminanceCap.toDouble(), DOUBLE to glowMapStrength.toDouble(), _RID to glowMap)
    TransferContext.callMethod(MethodBindings.environmentSetGlowPtr)
  }

  /**
   * Sets the variables to be used with the "tonemap" post-process effect. See [Environment] for
   * more details.
   */
  @JvmStatic
  public final fun environmentSetTonemap(
    env: RID,
    toneMapper: EnvironmentToneMapper,
    exposure: Float,
    white: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, LONG to toneMapper.value, DOUBLE to exposure.toDouble(), DOUBLE to white.toDouble())
    TransferContext.callMethod(MethodBindings.environmentSetTonemapPtr)
  }

  /**
   * See [Environment.tonemapAgxContrast] for more details.
   */
  @JvmStatic
  public final fun environmentSetTonemapAgxContrast(env: RID, agxContrast: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, DOUBLE to agxContrast.toDouble())
    TransferContext.callMethod(MethodBindings.environmentSetTonemapAgxContrastPtr)
  }

  /**
   * Sets the values to be used with the "adjustments" post-process effect. See [Environment] for
   * more details.
   */
  @JvmStatic
  public final fun environmentSetAdjustment(
    env: RID,
    enable: Boolean,
    brightness: Float,
    contrast: Float,
    saturation: Float,
    use1dColorCorrection: Boolean,
    colorCorrection: RID,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, BOOL to enable, DOUBLE to brightness.toDouble(), DOUBLE to contrast.toDouble(), DOUBLE to saturation.toDouble(), BOOL to use1dColorCorrection, _RID to colorCorrection)
    TransferContext.callMethod(MethodBindings.environmentSetAdjustmentPtr)
  }

  /**
   * Sets the variables to be used with the screen-space reflections (SSR) post-process effect. See
   * [Environment] for more details.
   */
  @JvmStatic
  public final fun environmentSetSsr(
    env: RID,
    enable: Boolean,
    maxSteps: Int,
    fadeIn: Float,
    fadeOut: Float,
    depthTolerance: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, BOOL to enable, LONG to maxSteps.toLong(), DOUBLE to fadeIn.toDouble(), DOUBLE to fadeOut.toDouble(), DOUBLE to depthTolerance.toDouble())
    TransferContext.callMethod(MethodBindings.environmentSetSsrPtr)
  }

  /**
   * Sets the variables to be used with the screen-space ambient occlusion (SSAO) post-process
   * effect. See [Environment] for more details.
   */
  @JvmStatic
  public final fun environmentSetSsao(
    env: RID,
    enable: Boolean,
    radius: Float,
    intensity: Float,
    power: Float,
    detail: Float,
    horizon: Float,
    sharpness: Float,
    lightAffect: Float,
    aoChannelAffect: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, BOOL to enable, DOUBLE to radius.toDouble(), DOUBLE to intensity.toDouble(), DOUBLE to power.toDouble(), DOUBLE to detail.toDouble(), DOUBLE to horizon.toDouble(), DOUBLE to sharpness.toDouble(), DOUBLE to lightAffect.toDouble(), DOUBLE to aoChannelAffect.toDouble())
    TransferContext.callMethod(MethodBindings.environmentSetSsaoPtr)
  }

  /**
   * Configures fog for the specified environment RID. See `fog_*` properties in [Environment] for
   * more information.
   */
  @JvmOverloads
  @JvmStatic
  public final fun environmentSetFog(
    env: RID,
    enable: Boolean,
    lightColor: Color,
    lightEnergy: Float,
    sunScatter: Float,
    density: Float,
    height: Float,
    heightDensity: Float,
    aerialPerspective: Float,
    skyAffect: Float,
    fogMode: EnvironmentFogMode = RenderingServer.EnvironmentFogMode.EXPONENTIAL,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, BOOL to enable, COLOR to lightColor, DOUBLE to lightEnergy.toDouble(), DOUBLE to sunScatter.toDouble(), DOUBLE to density.toDouble(), DOUBLE to height.toDouble(), DOUBLE to heightDensity.toDouble(), DOUBLE to aerialPerspective.toDouble(), DOUBLE to skyAffect.toDouble(), LONG to fogMode.value)
    TransferContext.callMethod(MethodBindings.environmentSetFogPtr)
  }

  /**
   * Configures fog depth for the specified environment RID. Only has an effect when the fog mode of
   * the environment is [ENV_FOG_MODE_DEPTH]. See `fog_depth_*` properties in [Environment] for more
   * information.
   */
  @JvmStatic
  public final fun environmentSetFogDepth(
    env: RID,
    curve: Float,
    begin: Float,
    end: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, DOUBLE to curve.toDouble(), DOUBLE to begin.toDouble(), DOUBLE to end.toDouble())
    TransferContext.callMethod(MethodBindings.environmentSetFogDepthPtr)
  }

  /**
   * Configures signed distance field global illumination for the specified environment RID. See
   * `sdfgi_*` properties in [Environment] for more information.
   */
  @JvmStatic
  public final fun environmentSetSdfgi(
    env: RID,
    enable: Boolean,
    cascades: Int,
    minCellSize: Float,
    yScale: EnvironmentSDFGIYScale,
    useOcclusion: Boolean,
    bounceFeedback: Float,
    readSky: Boolean,
    energy: Float,
    normalBias: Float,
    probeBias: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, BOOL to enable, LONG to cascades.toLong(), DOUBLE to minCellSize.toDouble(), LONG to yScale.value, BOOL to useOcclusion, DOUBLE to bounceFeedback.toDouble(), BOOL to readSky, DOUBLE to energy.toDouble(), DOUBLE to normalBias.toDouble(), DOUBLE to probeBias.toDouble())
    TransferContext.callMethod(MethodBindings.environmentSetSdfgiPtr)
  }

  /**
   * Sets the variables to be used with the volumetric fog post-process effect. See [Environment]
   * for more details.
   */
  @JvmStatic
  public final fun environmentSetVolumetricFog(
    env: RID,
    enable: Boolean,
    density: Float,
    albedo: Color,
    emission: Color,
    emissionEnergy: Float,
    anisotropy: Float,
    length: Float,
    detailSpread: Float,
    giInject: Float,
    temporalReprojection: Boolean,
    temporalReprojectionAmount: Float,
    ambientInject: Float,
    skyAffect: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to env, BOOL to enable, DOUBLE to density.toDouble(), COLOR to albedo, COLOR to emission, DOUBLE to emissionEnergy.toDouble(), DOUBLE to anisotropy.toDouble(), DOUBLE to length.toDouble(), DOUBLE to detailSpread.toDouble(), DOUBLE to giInject.toDouble(), BOOL to temporalReprojection, DOUBLE to temporalReprojectionAmount.toDouble(), DOUBLE to ambientInject.toDouble(), DOUBLE to skyAffect.toDouble())
    TransferContext.callMethod(MethodBindings.environmentSetVolumetricFogPtr)
  }

  /**
   * If [enable] is `true`, enables bicubic upscaling for glow which improves quality at the cost of
   * performance. Equivalent to [ProjectSettings.rendering/environment/glow/upscaleMode].
   *
   * **Note:** This setting is only effective when using the Forward+ or Mobile rendering methods,
   * as Compatibility uses a different glow implementation.
   */
  @JvmStatic
  public final fun environmentGlowSetUseBicubicUpscale(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.environmentGlowSetUseBicubicUpscalePtr)
  }

  /**
   * Sets whether screen-space reflections will be rendered at full or half size. Half size is
   * faster, but may look pixelated or cause flickering.
   */
  @JvmStatic
  public final fun environmentSetSsrHalfSize(halfSize: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to halfSize)
    TransferContext.callMethod(MethodBindings.environmentSetSsrHalfSizePtr)
  }

  @JvmStatic
  public final fun environmentSetSsrRoughnessQuality(quality: EnvironmentSSRRoughnessQuality):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to quality.value)
    TransferContext.callMethod(MethodBindings.environmentSetSsrRoughnessQualityPtr)
  }

  /**
   * Sets the quality level of the screen-space ambient occlusion (SSAO) post-process effect. See
   * [Environment] for more details.
   */
  @JvmStatic
  public final fun environmentSetSsaoQuality(
    quality: EnvironmentSSAOQuality,
    halfSize: Boolean,
    adaptiveTarget: Float,
    blurPasses: Int,
    fadeoutFrom: Float,
    fadeoutTo: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to quality.value, BOOL to halfSize, DOUBLE to adaptiveTarget.toDouble(), LONG to blurPasses.toLong(), DOUBLE to fadeoutFrom.toDouble(), DOUBLE to fadeoutTo.toDouble())
    TransferContext.callMethod(MethodBindings.environmentSetSsaoQualityPtr)
  }

  /**
   * Sets the quality level of the screen-space indirect lighting (SSIL) post-process effect. See
   * [Environment] for more details.
   */
  @JvmStatic
  public final fun environmentSetSsilQuality(
    quality: EnvironmentSSILQuality,
    halfSize: Boolean,
    adaptiveTarget: Float,
    blurPasses: Int,
    fadeoutFrom: Float,
    fadeoutTo: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to quality.value, BOOL to halfSize, DOUBLE to adaptiveTarget.toDouble(), LONG to blurPasses.toLong(), DOUBLE to fadeoutFrom.toDouble(), DOUBLE to fadeoutTo.toDouble())
    TransferContext.callMethod(MethodBindings.environmentSetSsilQualityPtr)
  }

  /**
   * Sets the number of rays to throw per frame when computing signed distance field global
   * illumination. Equivalent to [ProjectSettings.rendering/globalIllumination/sdfgi/probeRayCount].
   */
  @JvmStatic
  public final fun environmentSetSdfgiRayCount(rayCount: EnvironmentSDFGIRayCount): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to rayCount.value)
    TransferContext.callMethod(MethodBindings.environmentSetSdfgiRayCountPtr)
  }

  /**
   * Sets the number of frames to use for converging signed distance field global illumination.
   * Equivalent to [ProjectSettings.rendering/globalIllumination/sdfgi/framesToConverge].
   */
  @JvmStatic
  public final fun environmentSetSdfgiFramesToConverge(frames: EnvironmentSDFGIFramesToConverge):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to frames.value)
    TransferContext.callMethod(MethodBindings.environmentSetSdfgiFramesToConvergePtr)
  }

  /**
   * Sets the update speed for dynamic lights' indirect lighting when computing signed distance
   * field global illumination. Equivalent to
   * [ProjectSettings.rendering/globalIllumination/sdfgi/framesToUpdateLights].
   */
  @JvmStatic
  public final
      fun environmentSetSdfgiFramesToUpdateLight(frames: EnvironmentSDFGIFramesToUpdateLight):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to frames.value)
    TransferContext.callMethod(MethodBindings.environmentSetSdfgiFramesToUpdateLightPtr)
  }

  /**
   * Sets the resolution of the volumetric fog's froxel buffer. [size] is modified by the screen's
   * aspect ratio and then used to set the width and height of the buffer. While [depth] is directly
   * used to set the depth of the buffer.
   */
  @JvmStatic
  public final fun environmentSetVolumetricFogVolumeSize(size: Int, depth: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to size.toLong(), LONG to depth.toLong())
    TransferContext.callMethod(MethodBindings.environmentSetVolumetricFogVolumeSizePtr)
  }

  /**
   * Enables filtering of the volumetric fog scattering buffer. This results in much smoother
   * volumes with very few under-sampling artifacts.
   */
  @JvmStatic
  public final fun environmentSetVolumetricFogFilterActive(active: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to active)
    TransferContext.callMethod(MethodBindings.environmentSetVolumetricFogFilterActivePtr)
  }

  /**
   * Generates and returns an [Image] containing the radiance map for the specified [environment]
   * RID's sky. This supports built-in sky material and custom sky shaders. If [bakeIrradiance] is
   * `true`, the irradiance map is saved instead of the radiance map. The radiance map is used to
   * render reflected light, while the irradiance map is used to render ambient light. See also
   * [skyBakePanorama].
   *
   * **Note:** The image is saved using linear encoding without any tonemapping performed, which
   * means it will look too dark if viewed directly in an image editor.
   *
   * **Note:** [size] should be a 2:1 aspect ratio for the generated panorama to have square pixels.
   * For radiance maps, there is no point in using a height greater than [Sky.radianceSize], as it
   * won't increase detail. Irradiance maps only contain low-frequency data, so there is usually no
   * point in going past a size of 128×64 pixels when saving an irradiance map.
   */
  @JvmStatic
  public final fun environmentBakePanorama(
    environment: RID,
    bakeIrradiance: Boolean,
    size: Vector2i,
  ): Image? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to environment, BOOL to bakeIrradiance, VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.environmentBakePanoramaPtr)
    return (TransferContext.readReturnValue(OBJECT) as Image?)
  }

  /**
   * Sets the screen-space roughness limiter parameters, such as whether it should be enabled and
   * its thresholds. Equivalent to
   * [ProjectSettings.rendering/antiAliasing/screenSpaceRoughnessLimiter/enabled],
   * [ProjectSettings.rendering/antiAliasing/screenSpaceRoughnessLimiter/amount] and
   * [ProjectSettings.rendering/antiAliasing/screenSpaceRoughnessLimiter/limit].
   */
  @JvmStatic
  public final fun screenSpaceRoughnessLimiterSetActive(
    enable: Boolean,
    amount: Float,
    limit: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable, DOUBLE to amount.toDouble(), DOUBLE to limit.toDouble())
    TransferContext.callMethod(MethodBindings.screenSpaceRoughnessLimiterSetActivePtr)
  }

  /**
   * Sets [ProjectSettings.rendering/environment/subsurfaceScattering/subsurfaceScatteringQuality]
   * to use when rendering materials that have subsurface scattering enabled.
   */
  @JvmStatic
  public final fun subSurfaceScatteringSetQuality(quality: SubSurfaceScatteringQuality): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to quality.value)
    TransferContext.callMethod(MethodBindings.subSurfaceScatteringSetQualityPtr)
  }

  /**
   * Sets the [ProjectSettings.rendering/environment/subsurfaceScattering/subsurfaceScatteringScale]
   * and [ProjectSettings.rendering/environment/subsurfaceScattering/subsurfaceScatteringDepthScale] to
   * use when rendering materials that have subsurface scattering enabled.
   */
  @JvmStatic
  public final fun subSurfaceScatteringSetScale(scale: Float, depthScale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to scale.toDouble(), DOUBLE to depthScale.toDouble())
    TransferContext.callMethod(MethodBindings.subSurfaceScatteringSetScalePtr)
  }

  /**
   * Creates a camera attributes object and adds it to the RenderingServer. It can be accessed with
   * the RID that is returned. This RID will be used in all `camera_attributes_` RenderingServer
   * functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent resource is [CameraAttributes].
   */
  @JvmStatic
  public final fun cameraAttributesCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.cameraAttributesCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the quality level of the DOF blur effect to [quality]. [useJitter] can be used to jitter
   * samples taken during the blur pass to hide artifacts at the cost of looking more fuzzy.
   */
  @JvmStatic
  public final fun cameraAttributesSetDofBlurQuality(quality: DOFBlurQuality, useJitter: Boolean):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to quality.value, BOOL to useJitter)
    TransferContext.callMethod(MethodBindings.cameraAttributesSetDofBlurQualityPtr)
  }

  /**
   * Sets the shape of the DOF bokeh pattern to [shape]. Different shapes may be used to achieve
   * artistic effect, or to meet performance targets.
   */
  @JvmStatic
  public final fun cameraAttributesSetDofBlurBokehShape(shape: DOFBokehShape): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to shape.value)
    TransferContext.callMethod(MethodBindings.cameraAttributesSetDofBlurBokehShapePtr)
  }

  /**
   * Sets the parameters to use with the DOF blur effect. These parameters take on the same meaning
   * as their counterparts in [CameraAttributesPractical].
   */
  @JvmStatic
  public final fun cameraAttributesSetDofBlur(
    cameraAttributes: RID,
    farEnable: Boolean,
    farDistance: Float,
    farTransition: Float,
    nearEnable: Boolean,
    nearDistance: Float,
    nearTransition: Float,
    amount: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to cameraAttributes, BOOL to farEnable, DOUBLE to farDistance.toDouble(), DOUBLE to farTransition.toDouble(), BOOL to nearEnable, DOUBLE to nearDistance.toDouble(), DOUBLE to nearTransition.toDouble(), DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.cameraAttributesSetDofBlurPtr)
  }

  /**
   * Sets the exposure values that will be used by the renderers. The normalization amount is used
   * to bake a given Exposure Value (EV) into rendering calculations to reduce the dynamic range of the
   * scene.
   *
   * The normalization factor can be calculated from exposure value (EV100) as follows:
   *
   * ```
   * func get_exposure_normalization(ev100: float):
   * 	return 1.0 / (pow(2.0, ev100) * 1.2)
   * ```
   *
   * The exposure value can be calculated from aperture (in f-stops), shutter speed (in seconds),
   * and sensitivity (in ISO) as follows:
   *
   * ```
   * func get_exposure(aperture: float, shutter_speed: float, sensitivity: float):
   * 	return log((aperture * aperture) / shutter_speed * (100.0 / sensitivity)) / log(2)
   * ```
   */
  @JvmStatic
  public final fun cameraAttributesSetExposure(
    cameraAttributes: RID,
    multiplier: Float,
    normalization: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to cameraAttributes, DOUBLE to multiplier.toDouble(), DOUBLE to normalization.toDouble())
    TransferContext.callMethod(MethodBindings.cameraAttributesSetExposurePtr)
  }

  /**
   * Sets the parameters to use with the auto-exposure effect. These parameters take on the same
   * meaning as their counterparts in [CameraAttributes] and [CameraAttributesPractical].
   */
  @JvmStatic
  public final fun cameraAttributesSetAutoExposure(
    cameraAttributes: RID,
    enable: Boolean,
    minSensitivity: Float,
    maxSensitivity: Float,
    speed: Float,
    scale: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to cameraAttributes, BOOL to enable, DOUBLE to minSensitivity.toDouble(), DOUBLE to maxSensitivity.toDouble(), DOUBLE to speed.toDouble(), DOUBLE to scale.toDouble())
    TransferContext.callMethod(MethodBindings.cameraAttributesSetAutoExposurePtr)
  }

  /**
   * Creates a scenario and adds it to the RenderingServer. It can be accessed with the RID that is
   * returned. This RID will be used in all `scenario_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * The scenario is the 3D world that all the visual instances exist in.
   */
  @JvmStatic
  public final fun scenarioCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.scenarioCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the environment that will be used with this scenario. See also [Environment].
   */
  @JvmStatic
  public final fun scenarioSetEnvironment(scenario: RID, environment: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to scenario, _RID to environment)
    TransferContext.callMethod(MethodBindings.scenarioSetEnvironmentPtr)
  }

  /**
   * Sets the fallback environment to be used by this scenario. The fallback environment is used if
   * no environment is set. Internally, this is used by the editor to provide a default environment.
   */
  @JvmStatic
  public final fun scenarioSetFallbackEnvironment(scenario: RID, environment: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to scenario, _RID to environment)
    TransferContext.callMethod(MethodBindings.scenarioSetFallbackEnvironmentPtr)
  }

  /**
   * Sets the camera attributes ([effects]) that will be used with this scenario. See also
   * [CameraAttributes].
   */
  @JvmStatic
  public final fun scenarioSetCameraAttributes(scenario: RID, effects: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to scenario, _RID to effects)
    TransferContext.callMethod(MethodBindings.scenarioSetCameraAttributesPtr)
  }

  /**
   * Sets the compositor ([compositor]) that will be used with this scenario. See also [Compositor].
   */
  @JvmStatic
  public final fun scenarioSetCompositor(scenario: RID, compositor: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to scenario, _RID to compositor)
    TransferContext.callMethod(MethodBindings.scenarioSetCompositorPtr)
  }

  /**
   * Creates a visual instance, adds it to the RenderingServer, and sets both base and scenario. It
   * can be accessed with the RID that is returned. This RID will be used in all `instance_*`
   * RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method. This is a shorthand for using [instanceCreate] and setting the base and scenario
   * manually.
   */
  @JvmStatic
  public final fun instanceCreate2(base: RID, scenario: RID): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to base, _RID to scenario)
    TransferContext.callMethod(MethodBindings.instanceCreate2Ptr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Creates a visual instance and adds it to the RenderingServer. It can be accessed with the RID
   * that is returned. This RID will be used in all `instance_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * An instance is a way of placing a 3D object in the scenario. Objects like particles, meshes,
   * reflection probes and decals need to be associated with an instance to be visible in the scenario
   * using [instanceSetBase].
   *
   * **Note:** The equivalent node is [VisualInstance3D].
   */
  @JvmStatic
  public final fun instanceCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.instanceCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the base of the instance. A base can be any of the 3D objects that are created in the
   * RenderingServer that can be displayed. For example, any of the light types, mesh, multimesh,
   * particle system, reflection probe, decal, lightmap, voxel GI and visibility notifiers are all
   * types that can be set as the base of an instance in order to be displayed in the scenario.
   */
  @JvmStatic
  public final fun instanceSetBase(instance: RID, base: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, _RID to base)
    TransferContext.callMethod(MethodBindings.instanceSetBasePtr)
  }

  /**
   * Sets the scenario that the instance is in. The scenario is the 3D world that the objects will
   * be displayed in.
   */
  @JvmStatic
  public final fun instanceSetScenario(instance: RID, scenario: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, _RID to scenario)
    TransferContext.callMethod(MethodBindings.instanceSetScenarioPtr)
  }

  /**
   * Sets the render layers that this instance will be drawn to. Equivalent to
   * [VisualInstance3D.layers].
   */
  @JvmStatic
  public final fun instanceSetLayerMask(instance: RID, mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, LONG to mask)
    TransferContext.callMethod(MethodBindings.instanceSetLayerMaskPtr)
  }

  /**
   * Sets the sorting offset and switches between using the bounding box or instance origin for
   * depth sorting.
   */
  @JvmStatic
  public final fun instanceSetPivotData(
    instance: RID,
    sortingOffset: Float,
    useAabbCenter: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, DOUBLE to sortingOffset.toDouble(), BOOL to useAabbCenter)
    TransferContext.callMethod(MethodBindings.instanceSetPivotDataPtr)
  }

  /**
   * Sets the world space transform of the instance. Equivalent to [Node3D.globalTransform].
   */
  @JvmStatic
  public final fun instanceSetTransform(instance: RID, transform: Transform3D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, TRANSFORM3D to transform)
    TransferContext.callMethod(MethodBindings.instanceSetTransformPtr)
  }

  /**
   * Attaches a unique Object ID to instance. Object ID must be attached to instance for proper
   * culling with [instancesCullAabb], [instancesCullConvex], and [instancesCullRay].
   */
  @JvmStatic
  public final fun instanceAttachObjectInstanceId(instance: RID, id: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, LONG to id)
    TransferContext.callMethod(MethodBindings.instanceAttachObjectInstanceIdPtr)
  }

  /**
   * Sets the weight for a given blend shape associated with this instance.
   */
  @JvmStatic
  public final fun instanceSetBlendShapeWeight(
    instance: RID,
    shape: Int,
    weight: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, LONG to shape.toLong(), DOUBLE to weight.toDouble())
    TransferContext.callMethod(MethodBindings.instanceSetBlendShapeWeightPtr)
  }

  /**
   * Sets the override material of a specific surface. Equivalent to
   * [MeshInstance3D.setSurfaceOverrideMaterial].
   */
  @JvmStatic
  public final fun instanceSetSurfaceOverrideMaterial(
    instance: RID,
    surface: Int,
    material: RID,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, LONG to surface.toLong(), _RID to material)
    TransferContext.callMethod(MethodBindings.instanceSetSurfaceOverrideMaterialPtr)
  }

  /**
   * Sets whether an instance is drawn or not. Equivalent to [Node3D.visible].
   */
  @JvmStatic
  public final fun instanceSetVisible(instance: RID, visible: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, BOOL to visible)
    TransferContext.callMethod(MethodBindings.instanceSetVisiblePtr)
  }

  /**
   * Sets the transparency for the given geometry instance. Equivalent to
   * [GeometryInstance3D.transparency].
   *
   * A transparency of `0.0` is fully opaque, while `1.0` is fully transparent. Values greater than
   * `0.0` (exclusive) will force the geometry's materials to go through the transparent pipeline,
   * which is slower to render and can exhibit rendering issues due to incorrect transparency sorting.
   * However, unlike using a transparent material, setting [transparency] to a value greater than `0.0`
   * (exclusive) will *not* disable shadow rendering.
   *
   * In spatial shaders, `1.0 - transparency` is set as the default value of the `ALPHA` built-in.
   *
   * **Note:** [transparency] is clamped between `0.0` and `1.0`, so this property cannot be used to
   * make transparent materials more opaque than they originally are.
   */
  @JvmStatic
  public final fun instanceGeometrySetTransparency(instance: RID, transparency: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, DOUBLE to transparency.toDouble())
    TransferContext.callMethod(MethodBindings.instanceGeometrySetTransparencyPtr)
  }

  /**
   * Resets motion vectors and other interpolated values. Use this *after* teleporting a mesh from
   * one position to another to avoid ghosting artifacts.
   */
  @JvmStatic
  public final fun instanceTeleport(instance: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance)
    TransferContext.callMethod(MethodBindings.instanceTeleportPtr)
  }

  /**
   * Sets a custom AABB to use when culling objects from the view frustum. Equivalent to setting
   * [GeometryInstance3D.customAabb].
   */
  @JvmStatic
  public final fun instanceSetCustomAabb(instance: RID, aabb: AABB): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, godot.core.VariantParser.AABB to aabb)
    TransferContext.callMethod(MethodBindings.instanceSetCustomAabbPtr)
  }

  /**
   * Attaches a skeleton to an instance. Removes the previous skeleton from the instance.
   */
  @JvmStatic
  public final fun instanceAttachSkeleton(instance: RID, skeleton: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, _RID to skeleton)
    TransferContext.callMethod(MethodBindings.instanceAttachSkeletonPtr)
  }

  /**
   * Sets a margin to increase the size of the AABB when culling objects from the view frustum. This
   * allows you to avoid culling objects that fall outside the view frustum. Equivalent to
   * [GeometryInstance3D.extraCullMargin].
   */
  @JvmStatic
  public final fun instanceSetExtraVisibilityMargin(instance: RID, margin: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, DOUBLE to margin.toDouble())
    TransferContext.callMethod(MethodBindings.instanceSetExtraVisibilityMarginPtr)
  }

  /**
   * Sets the visibility parent for the given instance. Equivalent to [Node3D.visibilityParent].
   */
  @JvmStatic
  public final fun instanceSetVisibilityParent(instance: RID, parent: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, _RID to parent)
    TransferContext.callMethod(MethodBindings.instanceSetVisibilityParentPtr)
  }

  /**
   * If `true`, ignores all culling on the specified 3D geometry instance, including frustum
   * culling, occlusion culling, and layer culling. This is not the same as
   * [GeometryInstance3D.ignoreOcclusionCulling], which only ignores occlusion culling but leaves
   * frustum and layer culling intact.
   */
  @JvmStatic
  public final fun instanceSetIgnoreCulling(instance: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.instanceSetIgnoreCullingPtr)
  }

  /**
   * Sets the [flag] for a given [instance] to [enabled].
   */
  @JvmStatic
  public final fun instanceGeometrySetFlag(
    instance: RID,
    flag: InstanceFlags,
    enabled: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, LONG to flag.value, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.instanceGeometrySetFlagPtr)
  }

  /**
   * Sets the shadow casting setting. Equivalent to [GeometryInstance3D.castShadow].
   */
  @JvmStatic
  public final fun instanceGeometrySetCastShadowsSetting(instance: RID,
      shadowCastingSetting: ShadowCastingSetting): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, LONG to shadowCastingSetting.value)
    TransferContext.callMethod(MethodBindings.instanceGeometrySetCastShadowsSettingPtr)
  }

  /**
   * Sets a material that will override the material for all surfaces on the mesh associated with
   * this instance. Equivalent to [GeometryInstance3D.materialOverride].
   */
  @JvmStatic
  public final fun instanceGeometrySetMaterialOverride(instance: RID, material: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, _RID to material)
    TransferContext.callMethod(MethodBindings.instanceGeometrySetMaterialOverridePtr)
  }

  /**
   * Sets a material that will be rendered for all surfaces on top of active materials for the mesh
   * associated with this instance. Equivalent to [GeometryInstance3D.materialOverlay].
   */
  @JvmStatic
  public final fun instanceGeometrySetMaterialOverlay(instance: RID, material: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, _RID to material)
    TransferContext.callMethod(MethodBindings.instanceGeometrySetMaterialOverlayPtr)
  }

  /**
   * Sets the visibility range values for the given geometry instance. Equivalent to
   * [GeometryInstance3D.visibilityRangeBegin] and related properties.
   */
  @JvmStatic
  public final fun instanceGeometrySetVisibilityRange(
    instance: RID,
    min: Float,
    max: Float,
    minMargin: Float,
    maxMargin: Float,
    fadeMode: VisibilityRangeFadeMode,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, DOUBLE to min.toDouble(), DOUBLE to max.toDouble(), DOUBLE to minMargin.toDouble(), DOUBLE to maxMargin.toDouble(), LONG to fadeMode.value)
    TransferContext.callMethod(MethodBindings.instanceGeometrySetVisibilityRangePtr)
  }

  /**
   * Sets the lightmap GI instance to use for the specified 3D geometry instance. The lightmap UV
   * scale for the specified instance (equivalent to [GeometryInstance3D.giLightmapScale]) and lightmap
   * atlas slice must also be specified.
   */
  @JvmStatic
  public final fun instanceGeometrySetLightmap(
    instance: RID,
    lightmap: RID,
    lightmapUvScale: Rect2,
    lightmapSlice: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, _RID to lightmap, RECT2 to lightmapUvScale, LONG to lightmapSlice.toLong())
    TransferContext.callMethod(MethodBindings.instanceGeometrySetLightmapPtr)
  }

  /**
   * Sets the level of detail bias to use when rendering the specified 3D geometry instance. Higher
   * values result in higher detail from further away. Equivalent to [GeometryInstance3D.lodBias].
   */
  @JvmStatic
  public final fun instanceGeometrySetLodBias(instance: RID, lodBias: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, DOUBLE to lodBias.toDouble())
    TransferContext.callMethod(MethodBindings.instanceGeometrySetLodBiasPtr)
  }

  /**
   * Sets the per-instance shader uniform on the specified 3D geometry instance. Equivalent to
   * [GeometryInstance3D.setInstanceShaderParameter].
   */
  @JvmStatic
  public final fun instanceGeometrySetShaderParameter(
    instance: RID,
    parameter: StringName,
    `value`: Any?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, STRING_NAME to parameter, ANY to value)
    TransferContext.callMethod(MethodBindings.instanceGeometrySetShaderParameterPtr)
  }

  /**
   * Returns the value of the per-instance shader uniform from the specified 3D geometry instance.
   * Equivalent to [GeometryInstance3D.getInstanceShaderParameter].
   *
   * **Note:** Per-instance shader parameter names are case-sensitive.
   */
  @JvmStatic
  public final fun instanceGeometryGetShaderParameter(instance: RID, parameter: StringName): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, STRING_NAME to parameter)
    TransferContext.callMethod(MethodBindings.instanceGeometryGetShaderParameterPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns the default value of the per-instance shader uniform from the specified 3D geometry
   * instance. Equivalent to [GeometryInstance3D.getInstanceShaderParameter].
   */
  @JvmStatic
  public final fun instanceGeometryGetShaderParameterDefaultValue(instance: RID,
      parameter: StringName): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, STRING_NAME to parameter)
    TransferContext.callMethod(MethodBindings.instanceGeometryGetShaderParameterDefaultValuePtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns a dictionary of per-instance shader uniform names of the per-instance shader uniform
   * from the specified 3D geometry instance. The returned dictionary is in PropertyInfo format, with
   * the keys `name`, `class_name`, `type`, `hint`, `hint_string` and `usage`. Equivalent to
   * [GeometryInstance3D.getInstanceShaderParameter].
   */
  @JvmStatic
  public final fun instanceGeometryGetShaderParameterList(instance: RID):
      VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance)
    TransferContext.callMethod(MethodBindings.instanceGeometryGetShaderParameterListPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns an array of object IDs intersecting with the provided AABB. Only 3D nodes that inherit
   * from [VisualInstance3D] are considered, such as [MeshInstance3D] or [DirectionalLight3D]. Use
   * [@GlobalScope.instanceFromId] to obtain the actual nodes. A scenario RID must be provided, which
   * is available in the [World3D] you want to query. This forces an update for all resources queued to
   * update.
   *
   * **Warning:** This function is primarily intended for editor usage. For in-game use cases,
   * prefer physics collision.
   */
  @JvmOverloads
  @JvmStatic
  public final fun instancesCullAabb(aabb: AABB, scenario: RID = RID()): PackedInt64Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, godot.core.VariantParser.AABB to aabb, _RID to scenario)
    TransferContext.callMethod(MethodBindings.instancesCullAabbPtr)
    return (TransferContext.readReturnValue(PACKED_INT_64_ARRAY) as PackedInt64Array)
  }

  /**
   * Returns an array of object IDs intersecting with the provided 3D ray. Only 3D nodes that
   * inherit from [VisualInstance3D] are considered, such as [MeshInstance3D] or [DirectionalLight3D].
   * Use [@GlobalScope.instanceFromId] to obtain the actual nodes. A scenario RID must be provided,
   * which is available in the [World3D] you want to query. This forces an update for all resources
   * queued to update.
   *
   * **Warning:** This function is primarily intended for editor usage. For in-game use cases,
   * prefer physics collision.
   */
  @JvmOverloads
  @JvmStatic
  public final fun instancesCullRay(
    from: Vector3,
    to: Vector3,
    scenario: RID = RID(),
  ): PackedInt64Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to from, VECTOR3 to to, _RID to scenario)
    TransferContext.callMethod(MethodBindings.instancesCullRayPtr)
    return (TransferContext.readReturnValue(PACKED_INT_64_ARRAY) as PackedInt64Array)
  }

  /**
   * Returns an array of object IDs intersecting with the provided convex shape. Only 3D nodes that
   * inherit from [VisualInstance3D] are considered, such as [MeshInstance3D] or [DirectionalLight3D].
   * Use [@GlobalScope.instanceFromId] to obtain the actual nodes. A scenario RID must be provided,
   * which is available in the [World3D] you want to query. This forces an update for all resources
   * queued to update.
   *
   * **Warning:** This function is primarily intended for editor usage. For in-game use cases,
   * prefer physics collision.
   */
  @JvmOverloads
  @JvmStatic
  public final fun instancesCullConvex(convex: VariantArray<Plane>, scenario: RID = RID()):
      PackedInt64Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to convex, _RID to scenario)
    TransferContext.callMethod(MethodBindings.instancesCullConvexPtr)
    return (TransferContext.readReturnValue(PACKED_INT_64_ARRAY) as PackedInt64Array)
  }

  /**
   * Bakes the material data of the Mesh passed in the [base] parameter with optional
   * [materialOverrides] to a set of [Image]s of size [imageSize]. Returns an array of [Image]s
   * containing material properties as specified in [BakeChannels].
   */
  @JvmStatic
  public final fun bakeRenderUv2(
    base: RID,
    materialOverrides: VariantArray<RID>,
    imageSize: Vector2i,
  ): VariantArray<Image> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to base, ARRAY to materialOverrides, VECTOR2I to imageSize)
    TransferContext.callMethod(MethodBindings.bakeRenderUv2Ptr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Image>)
  }

  /**
   * Creates a canvas and returns the assigned [RID]. It can be accessed with the RID that is
   * returned. This RID will be used in all `canvas_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * Canvas has no [Resource] or [Node] equivalent.
   */
  @JvmStatic
  public final fun canvasCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.canvasCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * A copy of the canvas item will be drawn with a local offset of the [mirroring].
   *
   * **Note:** This is equivalent to calling [canvasSetItemRepeat] like
   * `canvas_set_item_repeat(item, mirroring, 1)`, with an additional check ensuring [canvas] is a
   * parent of [item].
   */
  @JvmStatic
  public final fun canvasSetItemMirroring(
    canvas: RID,
    item: RID,
    mirroring: Vector2,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to canvas, _RID to item, VECTOR2 to mirroring)
    TransferContext.callMethod(MethodBindings.canvasSetItemMirroringPtr)
  }

  /**
   * A copy of the canvas item will be drawn with a local offset of the [repeatSize] by the number
   * of times of the [repeatTimes]. As the [repeatTimes] increases, the copies will spread away from
   * the origin texture.
   */
  @JvmStatic
  public final fun canvasSetItemRepeat(
    item: RID,
    repeatSize: Vector2,
    repeatTimes: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, VECTOR2 to repeatSize, LONG to repeatTimes.toLong())
    TransferContext.callMethod(MethodBindings.canvasSetItemRepeatPtr)
  }

  /**
   * Modulates all colors in the given canvas.
   */
  @JvmStatic
  public final fun canvasSetModulate(canvas: RID, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to canvas, COLOR to color)
    TransferContext.callMethod(MethodBindings.canvasSetModulatePtr)
  }

  /**
   * If [disable] is `true`, makes 2D rendering ignore the canvas scale defined for each canvas
   * layer. This affects [CanvasLayer]s with the [CanvasLayer.followViewportEnabled] property set to
   * `true`.
   *
   * In the editor, this is set to `true` by default, and set to `false` when **View > Preview
   * Canvas Scale** is enabled at the top of the 2D editor viewport.
   *
   * **Note:** Setting this to `true` does not impact the behavior of [CanvasLayer.scale],
   * [Node2D.scale], or [Control.scale].
   */
  @JvmStatic
  public final fun canvasSetDisableScale(disable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to disable)
    TransferContext.callMethod(MethodBindings.canvasSetDisableScalePtr)
  }

  /**
   * Creates a canvas texture and adds it to the RenderingServer. It can be accessed with the RID
   * that is returned. This RID will be used in all `canvas_texture_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method. See also [texture2dCreate].
   *
   * **Note:** The equivalent resource is [CanvasTexture] and is only meant to be used in 2D
   * rendering, not 3D.
   */
  @JvmStatic
  public final fun canvasTextureCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.canvasTextureCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the [channel]'s [texture] for the canvas texture specified by the [canvasTexture] RID.
   * Equivalent to [CanvasTexture.diffuseTexture], [CanvasTexture.normalTexture] and
   * [CanvasTexture.specularTexture].
   */
  @JvmStatic
  public final fun canvasTextureSetChannel(
    canvasTexture: RID,
    channel: CanvasTextureChannel,
    texture: RID,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to canvasTexture, LONG to channel.value, _RID to texture)
    TransferContext.callMethod(MethodBindings.canvasTextureSetChannelPtr)
  }

  /**
   * Sets the [baseColor] and [shininess] to use for the canvas texture specified by the
   * [canvasTexture] RID. Equivalent to [CanvasTexture.specularColor] and
   * [CanvasTexture.specularShininess].
   */
  @JvmStatic
  public final fun canvasTextureSetShadingParameters(
    canvasTexture: RID,
    baseColor: Color,
    shininess: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to canvasTexture, COLOR to baseColor, DOUBLE to shininess.toDouble())
    TransferContext.callMethod(MethodBindings.canvasTextureSetShadingParametersPtr)
  }

  /**
   * Sets the texture [filter] mode to use for the canvas texture specified by the [canvasTexture]
   * RID.
   */
  @JvmStatic
  public final fun canvasTextureSetTextureFilter(canvasTexture: RID,
      filter: CanvasItemTextureFilter): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to canvasTexture, LONG to filter.value)
    TransferContext.callMethod(MethodBindings.canvasTextureSetTextureFilterPtr)
  }

  /**
   * Sets the texture [repeat] mode to use for the canvas texture specified by the [canvasTexture]
   * RID.
   */
  @JvmStatic
  public final fun canvasTextureSetTextureRepeat(canvasTexture: RID,
      repeat: CanvasItemTextureRepeat): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to canvasTexture, LONG to repeat.value)
    TransferContext.callMethod(MethodBindings.canvasTextureSetTextureRepeatPtr)
  }

  /**
   * Creates a new CanvasItem instance and returns its [RID]. It can be accessed with the RID that
   * is returned. This RID will be used in all `canvas_item_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent node is [CanvasItem].
   */
  @JvmStatic
  public final fun canvasItemCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.canvasItemCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets a parent [CanvasItem] to the [CanvasItem]. The item will inherit transform, modulation and
   * visibility from its parent, like [CanvasItem] nodes in the scene tree.
   */
  @JvmStatic
  public final fun canvasItemSetParent(item: RID, parent: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, _RID to parent)
    TransferContext.callMethod(MethodBindings.canvasItemSetParentPtr)
  }

  /**
   * Sets the default texture filter mode for the canvas item specified by the [item] RID.
   * Equivalent to [CanvasItem.textureFilter].
   */
  @JvmStatic
  public final fun canvasItemSetDefaultTextureFilter(item: RID, filter: CanvasItemTextureFilter):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, LONG to filter.value)
    TransferContext.callMethod(MethodBindings.canvasItemSetDefaultTextureFilterPtr)
  }

  /**
   * Sets the default texture repeat mode for the canvas item specified by the [item] RID.
   * Equivalent to [CanvasItem.textureRepeat].
   */
  @JvmStatic
  public final fun canvasItemSetDefaultTextureRepeat(item: RID, repeat: CanvasItemTextureRepeat):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, LONG to repeat.value)
    TransferContext.callMethod(MethodBindings.canvasItemSetDefaultTextureRepeatPtr)
  }

  /**
   * Sets the visibility of the [CanvasItem].
   */
  @JvmStatic
  public final fun canvasItemSetVisible(item: RID, visible: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, BOOL to visible)
    TransferContext.callMethod(MethodBindings.canvasItemSetVisiblePtr)
  }

  /**
   * Sets the light [mask] for the canvas item specified by the [item] RID. Equivalent to
   * [CanvasItem.lightMask].
   */
  @JvmStatic
  public final fun canvasItemSetLightMask(item: RID, mask: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, LONG to mask.toLong())
    TransferContext.callMethod(MethodBindings.canvasItemSetLightMaskPtr)
  }

  /**
   * Sets the rendering visibility layer associated with this [CanvasItem]. Only [Viewport] nodes
   * with a matching rendering mask will render this [CanvasItem].
   */
  @JvmStatic
  public final fun canvasItemSetVisibilityLayer(item: RID, visibilityLayer: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, LONG to visibilityLayer)
    TransferContext.callMethod(MethodBindings.canvasItemSetVisibilityLayerPtr)
  }

  /**
   * Sets the [transform] of the canvas item specified by the [item] RID. This affects where and how
   * the item will be drawn. Child canvas items' transforms are multiplied by their parent's transform.
   * Equivalent to [Node2D.transform].
   */
  @JvmStatic
  public final fun canvasItemSetTransform(item: RID, transform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.canvasItemSetTransformPtr)
  }

  /**
   * If [clip] is `true`, makes the canvas item specified by the [item] RID not draw anything
   * outside of its rect's coordinates. This clipping is fast, but works only with axis-aligned
   * rectangles. This means that rotation is ignored by the clipping rectangle. For more advanced
   * clipping shapes, use [canvasItemSetCanvasGroupMode] instead.
   *
   * **Note:** The equivalent node functionality is found in [Label.clipText], [RichTextLabel]
   * (always enabled) and more.
   */
  @JvmStatic
  public final fun canvasItemSetClip(item: RID, clip: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, BOOL to clip)
    TransferContext.callMethod(MethodBindings.canvasItemSetClipPtr)
  }

  /**
   * If [enabled] is `true`, enables multichannel signed distance field rendering mode for the
   * canvas item specified by the [item] RID. This is meant to be used for font rendering, or with
   * specially generated images using [url=https://github.com/Chlumsky/msdfgen]msdfgen[/url].
   */
  @JvmStatic
  public final fun canvasItemSetDistanceFieldMode(item: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.canvasItemSetDistanceFieldModePtr)
  }

  /**
   * If [useCustomRect] is `true`, sets the custom visibility rectangle (used for culling) to [rect]
   * for the canvas item specified by [item]. Setting a custom visibility rect can reduce CPU load when
   * drawing lots of 2D instances. If [useCustomRect] is `false`, automatically computes a visibility
   * rectangle based on the canvas item's draw commands.
   */
  @JvmOverloads
  @JvmStatic
  public final fun canvasItemSetCustomRect(
    item: RID,
    useCustomRect: Boolean,
    rect: Rect2 = Rect2(0.0, 0.0, 0.0, 0.0),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, BOOL to useCustomRect, RECT2 to rect)
    TransferContext.callMethod(MethodBindings.canvasItemSetCustomRectPtr)
  }

  /**
   * Multiplies the color of the canvas item specified by the [item] RID, while affecting its
   * children. See also [canvasItemSetSelfModulate]. Equivalent to [CanvasItem.modulate].
   */
  @JvmStatic
  public final fun canvasItemSetModulate(item: RID, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, COLOR to color)
    TransferContext.callMethod(MethodBindings.canvasItemSetModulatePtr)
  }

  /**
   * Multiplies the color of the canvas item specified by the [item] RID, without affecting its
   * children. See also [canvasItemSetModulate]. Equivalent to [CanvasItem.selfModulate].
   */
  @JvmStatic
  public final fun canvasItemSetSelfModulate(item: RID, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, COLOR to color)
    TransferContext.callMethod(MethodBindings.canvasItemSetSelfModulatePtr)
  }

  /**
   * If [enabled] is `true`, draws the canvas item specified by the [item] RID behind its parent.
   * Equivalent to [CanvasItem.showBehindParent].
   */
  @JvmStatic
  public final fun canvasItemSetDrawBehindParent(item: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.canvasItemSetDrawBehindParentPtr)
  }

  /**
   * If [interpolated] is `true`, turns on physics interpolation for the canvas item.
   */
  @JvmStatic
  public final fun canvasItemSetInterpolated(item: RID, interpolated: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, BOOL to interpolated)
    TransferContext.callMethod(MethodBindings.canvasItemSetInterpolatedPtr)
  }

  /**
   * Prevents physics interpolation for the current physics tick.
   *
   * This is useful when moving a canvas item to a new location, to give an instantaneous change
   * rather than interpolation from the previous location.
   */
  @JvmStatic
  public final fun canvasItemResetPhysicsInterpolation(item: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item)
    TransferContext.callMethod(MethodBindings.canvasItemResetPhysicsInterpolationPtr)
  }

  /**
   * Transforms both the current and previous stored transform for a canvas item.
   *
   * This allows transforming a canvas item without creating a "glitch" in the interpolation, which
   * is particularly useful for large worlds utilizing a shifting origin.
   */
  @JvmStatic
  public final fun canvasItemTransformPhysicsInterpolation(item: RID, transform: Transform2D):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.canvasItemTransformPhysicsInterpolationPtr)
  }

  /**
   * Draws a line on the [CanvasItem] pointed to by the [item] [RID]. See also
   * [CanvasItem.drawLine].
   */
  @JvmOverloads
  @JvmStatic
  public final fun canvasItemAddLine(
    item: RID,
    from: Vector2,
    to: Vector2,
    color: Color,
    width: Float = -1.0f,
    antialiased: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, VECTOR2 to from, VECTOR2 to to, COLOR to color, DOUBLE to width.toDouble(), BOOL to antialiased)
    TransferContext.callMethod(MethodBindings.canvasItemAddLinePtr)
  }

  /**
   * Draws a 2D polyline on the [CanvasItem] pointed to by the [item] [RID]. See also
   * [CanvasItem.drawPolyline] and [CanvasItem.drawPolylineColors].
   */
  @JvmOverloads
  @JvmStatic
  public final fun canvasItemAddPolyline(
    item: RID,
    points: PackedVector2Array,
    colors: PackedColorArray,
    width: Float = -1.0f,
    antialiased: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, PACKED_VECTOR2_ARRAY to points, PACKED_COLOR_ARRAY to colors, DOUBLE to width.toDouble(), BOOL to antialiased)
    TransferContext.callMethod(MethodBindings.canvasItemAddPolylinePtr)
  }

  /**
   * Draws a 2D multiline on the [CanvasItem] pointed to by the [item] [RID]. See also
   * [CanvasItem.drawMultiline] and [CanvasItem.drawMultilineColors].
   */
  @JvmOverloads
  @JvmStatic
  public final fun canvasItemAddMultiline(
    item: RID,
    points: PackedVector2Array,
    colors: PackedColorArray,
    width: Float = -1.0f,
    antialiased: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, PACKED_VECTOR2_ARRAY to points, PACKED_COLOR_ARRAY to colors, DOUBLE to width.toDouble(), BOOL to antialiased)
    TransferContext.callMethod(MethodBindings.canvasItemAddMultilinePtr)
  }

  /**
   * Draws a rectangle on the [CanvasItem] pointed to by the [item] [RID]. See also
   * [CanvasItem.drawRect].
   */
  @JvmOverloads
  @JvmStatic
  public final fun canvasItemAddRect(
    item: RID,
    rect: Rect2,
    color: Color,
    antialiased: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, RECT2 to rect, COLOR to color, BOOL to antialiased)
    TransferContext.callMethod(MethodBindings.canvasItemAddRectPtr)
  }

  /**
   * Draws a circle on the [CanvasItem] pointed to by the [item] [RID]. See also
   * [CanvasItem.drawCircle].
   */
  @JvmOverloads
  @JvmStatic
  public final fun canvasItemAddCircle(
    item: RID,
    pos: Vector2,
    radius: Float,
    color: Color,
    antialiased: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, VECTOR2 to pos, DOUBLE to radius.toDouble(), COLOR to color, BOOL to antialiased)
    TransferContext.callMethod(MethodBindings.canvasItemAddCirclePtr)
  }

  /**
   * Draws an ellipse with semi-major axis [major] and semi-minor axis [minor] on the [CanvasItem]
   * pointed to by the [item] [RID]. See also [CanvasItem.drawEllipse].
   */
  @JvmOverloads
  @JvmStatic
  public final fun canvasItemAddEllipse(
    item: RID,
    pos: Vector2,
    major: Float,
    minor: Float,
    color: Color,
    antialiased: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, VECTOR2 to pos, DOUBLE to major.toDouble(), DOUBLE to minor.toDouble(), COLOR to color, BOOL to antialiased)
    TransferContext.callMethod(MethodBindings.canvasItemAddEllipsePtr)
  }

  /**
   * Draws a 2D textured rectangle on the [CanvasItem] pointed to by the [item] [RID]. See also
   * [CanvasItem.drawTextureRect] and [Texture2D.drawRect].
   */
  @JvmOverloads
  @JvmStatic
  public final fun canvasItemAddTextureRect(
    item: RID,
    rect: Rect2,
    texture: RID,
    tile: Boolean = false,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    transpose: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, RECT2 to rect, _RID to texture, BOOL to tile, COLOR to modulate, BOOL to transpose)
    TransferContext.callMethod(MethodBindings.canvasItemAddTextureRectPtr)
  }

  /**
   * See also [CanvasItem.drawMsdfTextureRectRegion].
   */
  @JvmOverloads
  @JvmStatic
  public final fun canvasItemAddMsdfTextureRectRegion(
    item: RID,
    rect: Rect2,
    texture: RID,
    srcRect: Rect2,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    outlineSize: Int = 0,
    pxRange: Float = 1.0f,
    scale: Float = 1.0f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, RECT2 to rect, _RID to texture, RECT2 to srcRect, COLOR to modulate, LONG to outlineSize.toLong(), DOUBLE to pxRange.toDouble(), DOUBLE to scale.toDouble())
    TransferContext.callMethod(MethodBindings.canvasItemAddMsdfTextureRectRegionPtr)
  }

  /**
   * See also [CanvasItem.drawLcdTextureRectRegion].
   */
  @JvmStatic
  public final fun canvasItemAddLcdTextureRectRegion(
    item: RID,
    rect: Rect2,
    texture: RID,
    srcRect: Rect2,
    modulate: Color,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, RECT2 to rect, _RID to texture, RECT2 to srcRect, COLOR to modulate)
    TransferContext.callMethod(MethodBindings.canvasItemAddLcdTextureRectRegionPtr)
  }

  /**
   * Draws the specified region of a 2D textured rectangle on the [CanvasItem] pointed to by the
   * [item] [RID]. See also [CanvasItem.drawTextureRectRegion] and [Texture2D.drawRectRegion].
   */
  @JvmOverloads
  @JvmStatic
  public final fun canvasItemAddTextureRectRegion(
    item: RID,
    rect: Rect2,
    texture: RID,
    srcRect: Rect2,
    modulate: Color = Color(Color(1, 1, 1, 1)),
    transpose: Boolean = false,
    clipUv: Boolean = true,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, RECT2 to rect, _RID to texture, RECT2 to srcRect, COLOR to modulate, BOOL to transpose, BOOL to clipUv)
    TransferContext.callMethod(MethodBindings.canvasItemAddTextureRectRegionPtr)
  }

  /**
   * Draws a nine-patch rectangle on the [CanvasItem] pointed to by the [item] [RID].
   */
  @JvmOverloads
  @JvmStatic
  public final fun canvasItemAddNinePatch(
    item: RID,
    rect: Rect2,
    source: Rect2,
    texture: RID,
    topleft: Vector2,
    bottomright: Vector2,
    xAxisMode: NinePatchAxisMode = RenderingServer.NinePatchAxisMode.STRETCH,
    yAxisMode: NinePatchAxisMode = RenderingServer.NinePatchAxisMode.STRETCH,
    drawCenter: Boolean = true,
    modulate: Color = Color(Color(1, 1, 1, 1)),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, RECT2 to rect, RECT2 to source, _RID to texture, VECTOR2 to topleft, VECTOR2 to bottomright, LONG to xAxisMode.value, LONG to yAxisMode.value, BOOL to drawCenter, COLOR to modulate)
    TransferContext.callMethod(MethodBindings.canvasItemAddNinePatchPtr)
  }

  /**
   * Draws a 2D primitive on the [CanvasItem] pointed to by the [item] [RID]. See also
   * [CanvasItem.drawPrimitive].
   */
  @JvmStatic
  public final fun canvasItemAddPrimitive(
    item: RID,
    points: PackedVector2Array,
    colors: PackedColorArray,
    uvs: PackedVector2Array,
    texture: RID,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, PACKED_VECTOR2_ARRAY to points, PACKED_COLOR_ARRAY to colors, PACKED_VECTOR2_ARRAY to uvs, _RID to texture)
    TransferContext.callMethod(MethodBindings.canvasItemAddPrimitivePtr)
  }

  /**
   * Draws a 2D polygon on the [CanvasItem] pointed to by the [item] [RID]. If you need more
   * flexibility (such as being able to use bones), use [canvasItemAddTriangleArray] instead. See also
   * [CanvasItem.drawPolygon].
   *
   * **Note:** If you frequently redraw the same polygon with a large number of vertices, consider
   * pre-calculating the triangulation with [Geometry2D.triangulatePolygon] and using
   * [CanvasItem.drawMesh], [CanvasItem.drawMultimesh], or [canvasItemAddTriangleArray].
   */
  @JvmOverloads
  @JvmStatic
  public final fun canvasItemAddPolygon(
    item: RID,
    points: PackedVector2Array,
    colors: PackedColorArray,
    uvs: PackedVector2Array = PackedVector2Array(),
    texture: RID = RID(),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, PACKED_VECTOR2_ARRAY to points, PACKED_COLOR_ARRAY to colors, PACKED_VECTOR2_ARRAY to uvs, _RID to texture)
    TransferContext.callMethod(MethodBindings.canvasItemAddPolygonPtr)
  }

  /**
   * Draws a triangle array on the [CanvasItem] pointed to by the [item] [RID]. This is internally
   * used by [Line2D] and [StyleBoxFlat] for rendering. [canvasItemAddTriangleArray] is highly
   * flexible, but more complex to use than [canvasItemAddPolygon].
   *
   * **Note:** If [count] is set to a non-negative value, only the first `count * 3` indices
   * (corresponding to [code skip-lint]count[/code] triangles) will be drawn. Otherwise, all indices
   * are drawn.
   */
  @JvmOverloads
  @JvmStatic
  public final fun canvasItemAddTriangleArray(
    item: RID,
    indices: PackedInt32Array,
    points: PackedVector2Array,
    colors: PackedColorArray,
    uvs: PackedVector2Array = PackedVector2Array(),
    bones: PackedInt32Array = PackedInt32Array(),
    weights: PackedFloat32Array = PackedFloat32Array(),
    texture: RID = RID(),
    count: Int = -1,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, PACKED_INT_32_ARRAY to indices, PACKED_VECTOR2_ARRAY to points, PACKED_COLOR_ARRAY to colors, PACKED_VECTOR2_ARRAY to uvs, PACKED_INT_32_ARRAY to bones, PACKED_FLOAT_32_ARRAY to weights, _RID to texture, LONG to count.toLong())
    TransferContext.callMethod(MethodBindings.canvasItemAddTriangleArrayPtr)
  }

  /**
   * Draws a mesh created with [meshCreate] with given [transform], [modulate] color, and [texture].
   * This is used internally by [MeshInstance2D].
   */
  @JvmOverloads
  @JvmStatic
  public final fun canvasItemAddMesh(
    item: RID,
    mesh: RID,
    transform: Transform2D = Transform2D(),
    modulate: Color = Color(Color(1, 1, 1, 1)),
    texture: RID = RID(),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, _RID to mesh, TRANSFORM2D to transform, COLOR to modulate, _RID to texture)
    TransferContext.callMethod(MethodBindings.canvasItemAddMeshPtr)
  }

  /**
   * Draws a 2D [MultiMesh] on the [CanvasItem] pointed to by the [item] [RID]. See also
   * [CanvasItem.drawMultimesh].
   */
  @JvmOverloads
  @JvmStatic
  public final fun canvasItemAddMultimesh(
    item: RID,
    mesh: RID,
    texture: RID = RID(),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, _RID to mesh, _RID to texture)
    TransferContext.callMethod(MethodBindings.canvasItemAddMultimeshPtr)
  }

  /**
   * Draws particles on the [CanvasItem] pointed to by the [item] [RID].
   */
  @JvmStatic
  public final fun canvasItemAddParticles(
    item: RID,
    particles: RID,
    texture: RID,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, _RID to particles, _RID to texture)
    TransferContext.callMethod(MethodBindings.canvasItemAddParticlesPtr)
  }

  /**
   * Sets a [Transform2D] that will be used to transform subsequent canvas item commands.
   */
  @JvmStatic
  public final fun canvasItemAddSetTransform(item: RID, transform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.canvasItemAddSetTransformPtr)
  }

  /**
   * If [ignore] is `true`, ignore clipping on items drawn with this canvas item until this is
   * called again with [ignore] set to `false`.
   */
  @JvmStatic
  public final fun canvasItemAddClipIgnore(item: RID, ignore: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, BOOL to ignore)
    TransferContext.callMethod(MethodBindings.canvasItemAddClipIgnorePtr)
  }

  /**
   * Subsequent drawing commands will be ignored unless they fall within the specified animation
   * slice. This is a faster way to implement animations that loop on background rather than redrawing
   * constantly.
   */
  @JvmOverloads
  @JvmStatic
  public final fun canvasItemAddAnimationSlice(
    item: RID,
    animationLength: Double,
    sliceBegin: Double,
    sliceEnd: Double,
    offset: Double = 0.0,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, DOUBLE to animationLength, DOUBLE to sliceBegin, DOUBLE to sliceEnd, DOUBLE to offset)
    TransferContext.callMethod(MethodBindings.canvasItemAddAnimationSlicePtr)
  }

  /**
   * If [enabled] is `true`, child nodes with the lowest Y position are drawn before those with a
   * higher Y position. Y-sorting only affects children that inherit from the canvas item specified by
   * the [item] RID, not the canvas item itself. Equivalent to [CanvasItem.ySortEnabled].
   */
  @JvmStatic
  public final fun canvasItemSetSortChildrenByY(item: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.canvasItemSetSortChildrenByYPtr)
  }

  /**
   * Sets the [CanvasItem]'s Z index, i.e. its draw order (lower indexes are drawn first).
   */
  @JvmStatic
  public final fun canvasItemSetZIndex(item: RID, zIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, LONG to zIndex.toLong())
    TransferContext.callMethod(MethodBindings.canvasItemSetZIndexPtr)
  }

  /**
   * If this is enabled, the Z index of the parent will be added to the children's Z index.
   */
  @JvmStatic
  public final fun canvasItemSetZAsRelativeToParent(item: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.canvasItemSetZAsRelativeToParentPtr)
  }

  /**
   * Sets the [CanvasItem] to copy a rect to the backbuffer.
   */
  @JvmStatic
  public final fun canvasItemSetCopyToBackbuffer(
    item: RID,
    enabled: Boolean,
    rect: Rect2,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, BOOL to enabled, RECT2 to rect)
    TransferContext.callMethod(MethodBindings.canvasItemSetCopyToBackbufferPtr)
  }

  /**
   * Attaches a skeleton to the [CanvasItem]. Removes the previous skeleton.
   */
  @JvmStatic
  public final fun canvasItemAttachSkeleton(item: RID, skeleton: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, _RID to skeleton)
    TransferContext.callMethod(MethodBindings.canvasItemAttachSkeletonPtr)
  }

  /**
   * Clears the [CanvasItem] and removes all commands in it.
   */
  @JvmStatic
  public final fun canvasItemClear(item: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item)
    TransferContext.callMethod(MethodBindings.canvasItemClearPtr)
  }

  /**
   * Sets the index for the [CanvasItem].
   */
  @JvmStatic
  public final fun canvasItemSetDrawIndex(item: RID, index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.canvasItemSetDrawIndexPtr)
  }

  /**
   * Sets a new [material] to the canvas item specified by the [item] RID. Equivalent to
   * [CanvasItem.material].
   */
  @JvmStatic
  public final fun canvasItemSetMaterial(item: RID, material: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, _RID to material)
    TransferContext.callMethod(MethodBindings.canvasItemSetMaterialPtr)
  }

  /**
   * Sets if the [CanvasItem] uses its parent's material.
   */
  @JvmStatic
  public final fun canvasItemSetUseParentMaterial(item: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.canvasItemSetUseParentMaterialPtr)
  }

  /**
   * Sets the per-instance shader uniform on the specified canvas item instance. Equivalent to
   * [CanvasItem.setInstanceShaderParameter].
   */
  @JvmStatic
  public final fun canvasItemSetInstanceShaderParameter(
    instance: RID,
    parameter: StringName,
    `value`: Any?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, STRING_NAME to parameter, ANY to value)
    TransferContext.callMethod(MethodBindings.canvasItemSetInstanceShaderParameterPtr)
  }

  /**
   * Returns the value of the per-instance shader uniform from the specified canvas item instance.
   * Equivalent to [CanvasItem.getInstanceShaderParameter].
   */
  @JvmStatic
  public final fun canvasItemGetInstanceShaderParameter(instance: RID, parameter: StringName):
      Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, STRING_NAME to parameter)
    TransferContext.callMethod(MethodBindings.canvasItemGetInstanceShaderParameterPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns the default value of the per-instance shader uniform from the specified canvas item
   * instance. Equivalent to [CanvasItem.getInstanceShaderParameter].
   */
  @JvmStatic
  public final fun canvasItemGetInstanceShaderParameterDefaultValue(instance: RID,
      parameter: StringName): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance, STRING_NAME to parameter)
    TransferContext.callMethod(MethodBindings.canvasItemGetInstanceShaderParameterDefaultValuePtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns a dictionary of per-instance shader uniform names of the per-instance shader uniform
   * from the specified canvas item instance.
   *
   * The returned dictionary is in PropertyInfo format, with the keys `name`, `class_name`, `type`,
   * `hint`, `hint_string`, and `usage`.
   */
  @JvmStatic
  public final fun canvasItemGetInstanceShaderParameterList(instance: RID):
      VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to instance)
    TransferContext.callMethod(MethodBindings.canvasItemGetInstanceShaderParameterListPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Sets the given [CanvasItem] as visibility notifier. [area] defines the area of detecting
   * visibility. [enterCallable] is called when the [CanvasItem] enters the screen, [exitCallable] is
   * called when the [CanvasItem] exits the screen. If [enable] is `false`, the item will no longer
   * function as notifier.
   *
   * This method can be used to manually mimic [VisibleOnScreenNotifier2D].
   */
  @JvmStatic
  public final fun canvasItemSetVisibilityNotifier(
    item: RID,
    enable: Boolean,
    area: Rect2,
    enterCallable: Callable,
    exitCallable: Callable,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, BOOL to enable, RECT2 to area, CALLABLE to enterCallable, CALLABLE to exitCallable)
    TransferContext.callMethod(MethodBindings.canvasItemSetVisibilityNotifierPtr)
  }

  /**
   * Sets the canvas group mode used during 2D rendering for the canvas item specified by the [item]
   * RID. For faster but more limited clipping, use [canvasItemSetClip] instead.
   *
   * **Note:** The equivalent node functionality is found in [CanvasGroup] and
   * [CanvasItem.clipChildren].
   */
  @JvmOverloads
  @JvmStatic
  public final fun canvasItemSetCanvasGroupMode(
    item: RID,
    mode: CanvasGroupMode,
    clearMargin: Float = 5.0f,
    fitEmpty: Boolean = false,
    fitMargin: Float = 0.0f,
    blurMipmaps: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item, LONG to mode.value, DOUBLE to clearMargin.toDouble(), BOOL to fitEmpty, DOUBLE to fitMargin.toDouble(), BOOL to blurMipmaps)
    TransferContext.callMethod(MethodBindings.canvasItemSetCanvasGroupModePtr)
  }

  /**
   * Returns the bounding rectangle for a canvas item in local space, as calculated by the renderer.
   * This bound is used internally for culling.
   *
   * **Warning:** This function is intended for debugging in the editor, and will pass through and
   * return a zero [Rect2] in exported projects.
   */
  @JvmStatic
  public final fun debugCanvasItemGetRect(item: RID): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to item)
    TransferContext.callMethod(MethodBindings.debugCanvasItemGetRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  /**
   * Creates a canvas light and adds it to the RenderingServer. It can be accessed with the RID that
   * is returned. This RID will be used in all `canvas_light_*` RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent node is [Light2D].
   */
  @JvmStatic
  public final fun canvasLightCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.canvasLightCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Attaches the canvas light to the canvas. Removes it from its previous canvas.
   */
  @JvmStatic
  public final fun canvasLightAttachToCanvas(light: RID, canvas: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, _RID to canvas)
    TransferContext.callMethod(MethodBindings.canvasLightAttachToCanvasPtr)
  }

  /**
   * Enables or disables a canvas light.
   */
  @JvmStatic
  public final fun canvasLightSetEnabled(light: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.canvasLightSetEnabledPtr)
  }

  /**
   * Sets the scale factor of a [PointLight2D]'s texture. Equivalent to [PointLight2D.textureScale].
   */
  @JvmStatic
  public final fun canvasLightSetTextureScale(light: RID, scale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, DOUBLE to scale.toDouble())
    TransferContext.callMethod(MethodBindings.canvasLightSetTextureScalePtr)
  }

  /**
   * Sets the canvas light's [Transform2D].
   */
  @JvmStatic
  public final fun canvasLightSetTransform(light: RID, transform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.canvasLightSetTransformPtr)
  }

  /**
   * Sets the texture to be used by a [PointLight2D]. Equivalent to [PointLight2D.texture].
   */
  @JvmStatic
  public final fun canvasLightSetTexture(light: RID, texture: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, _RID to texture)
    TransferContext.callMethod(MethodBindings.canvasLightSetTexturePtr)
  }

  /**
   * Sets the offset of a [PointLight2D]'s texture. Equivalent to [PointLight2D.offset].
   */
  @JvmStatic
  public final fun canvasLightSetTextureOffset(light: RID, offset: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, VECTOR2 to offset)
    TransferContext.callMethod(MethodBindings.canvasLightSetTextureOffsetPtr)
  }

  /**
   * Sets the color for a light.
   */
  @JvmStatic
  public final fun canvasLightSetColor(light: RID, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, COLOR to color)
    TransferContext.callMethod(MethodBindings.canvasLightSetColorPtr)
  }

  /**
   * Sets a canvas light's height.
   */
  @JvmStatic
  public final fun canvasLightSetHeight(light: RID, height: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, DOUBLE to height.toDouble())
    TransferContext.callMethod(MethodBindings.canvasLightSetHeightPtr)
  }

  /**
   * Sets a canvas light's energy.
   */
  @JvmStatic
  public final fun canvasLightSetEnergy(light: RID, energy: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, DOUBLE to energy.toDouble())
    TransferContext.callMethod(MethodBindings.canvasLightSetEnergyPtr)
  }

  /**
   * Sets the Z range of objects that will be affected by this light. Equivalent to
   * [Light2D.rangeZMin] and [Light2D.rangeZMax].
   */
  @JvmStatic
  public final fun canvasLightSetZRange(
    light: RID,
    minZ: Int,
    maxZ: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, LONG to minZ.toLong(), LONG to maxZ.toLong())
    TransferContext.callMethod(MethodBindings.canvasLightSetZRangePtr)
  }

  /**
   * The layer range that gets rendered with this light.
   */
  @JvmStatic
  public final fun canvasLightSetLayerRange(
    light: RID,
    minLayer: Int,
    maxLayer: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, LONG to minLayer.toLong(), LONG to maxLayer.toLong())
    TransferContext.callMethod(MethodBindings.canvasLightSetLayerRangePtr)
  }

  /**
   * The light mask. See [LightOccluder2D] for more information on light masks.
   */
  @JvmStatic
  public final fun canvasLightSetItemCullMask(light: RID, mask: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, LONG to mask.toLong())
    TransferContext.callMethod(MethodBindings.canvasLightSetItemCullMaskPtr)
  }

  /**
   * The binary mask used to determine which layers this canvas light's shadows affects. See
   * [LightOccluder2D] for more information on light masks.
   */
  @JvmStatic
  public final fun canvasLightSetItemShadowCullMask(light: RID, mask: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, LONG to mask.toLong())
    TransferContext.callMethod(MethodBindings.canvasLightSetItemShadowCullMaskPtr)
  }

  /**
   * Sets the mode of the canvas light.
   */
  @JvmStatic
  public final fun canvasLightSetMode(light: RID, mode: CanvasLightMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.canvasLightSetModePtr)
  }

  /**
   * Enables or disables the canvas light's shadow.
   */
  @JvmStatic
  public final fun canvasLightSetShadowEnabled(light: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.canvasLightSetShadowEnabledPtr)
  }

  /**
   * Sets the canvas light's shadow's filter.
   */
  @JvmStatic
  public final fun canvasLightSetShadowFilter(light: RID, filter: CanvasLightShadowFilter): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, LONG to filter.value)
    TransferContext.callMethod(MethodBindings.canvasLightSetShadowFilterPtr)
  }

  /**
   * Sets the color of the canvas light's shadow.
   */
  @JvmStatic
  public final fun canvasLightSetShadowColor(light: RID, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, COLOR to color)
    TransferContext.callMethod(MethodBindings.canvasLightSetShadowColorPtr)
  }

  /**
   * Smoothens the shadow. The lower, the smoother.
   */
  @JvmStatic
  public final fun canvasLightSetShadowSmooth(light: RID, smooth: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, DOUBLE to smooth.toDouble())
    TransferContext.callMethod(MethodBindings.canvasLightSetShadowSmoothPtr)
  }

  /**
   * Sets the blend mode for the given canvas light to [mode]. Equivalent to [Light2D.blendMode].
   */
  @JvmStatic
  public final fun canvasLightSetBlendMode(light: RID, mode: CanvasLightBlendMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.canvasLightSetBlendModePtr)
  }

  /**
   * If [interpolated] is `true`, turns on physics interpolation for the canvas light.
   */
  @JvmStatic
  public final fun canvasLightSetInterpolated(light: RID, interpolated: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, BOOL to interpolated)
    TransferContext.callMethod(MethodBindings.canvasLightSetInterpolatedPtr)
  }

  /**
   * Prevents physics interpolation for the current physics tick.
   *
   * This is useful when moving a canvas item to a new location, to give an instantaneous change
   * rather than interpolation from the previous location.
   */
  @JvmStatic
  public final fun canvasLightResetPhysicsInterpolation(light: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light)
    TransferContext.callMethod(MethodBindings.canvasLightResetPhysicsInterpolationPtr)
  }

  /**
   * Transforms both the current and previous stored transform for a canvas light.
   *
   * This allows transforming a light without creating a "glitch" in the interpolation, which is
   * particularly useful for large worlds utilizing a shifting origin.
   */
  @JvmStatic
  public final fun canvasLightTransformPhysicsInterpolation(light: RID, transform: Transform2D):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to light, TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.canvasLightTransformPhysicsInterpolationPtr)
  }

  /**
   * Creates a light occluder and adds it to the RenderingServer. It can be accessed with the RID
   * that is returned. This RID will be used in all `canvas_light_occluder_*` RenderingServer
   * functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent node is [LightOccluder2D].
   */
  @JvmStatic
  public final fun canvasLightOccluderCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.canvasLightOccluderCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Attaches a light occluder to the canvas. Removes it from its previous canvas.
   */
  @JvmStatic
  public final fun canvasLightOccluderAttachToCanvas(occluder: RID, canvas: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to occluder, _RID to canvas)
    TransferContext.callMethod(MethodBindings.canvasLightOccluderAttachToCanvasPtr)
  }

  /**
   * Enables or disables light occluder.
   */
  @JvmStatic
  public final fun canvasLightOccluderSetEnabled(occluder: RID, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to occluder, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.canvasLightOccluderSetEnabledPtr)
  }

  /**
   * Sets a light occluder's polygon.
   */
  @JvmStatic
  public final fun canvasLightOccluderSetPolygon(occluder: RID, polygon: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to occluder, _RID to polygon)
    TransferContext.callMethod(MethodBindings.canvasLightOccluderSetPolygonPtr)
  }

  /**
   * Enables or disables using the light occluder as a signed distance field for 2D particle
   * collision.
   */
  @JvmStatic
  public final fun canvasLightOccluderSetAsSdfCollision(occluder: RID, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to occluder, BOOL to enable)
    TransferContext.callMethod(MethodBindings.canvasLightOccluderSetAsSdfCollisionPtr)
  }

  /**
   * Sets a light occluder's [Transform2D].
   */
  @JvmStatic
  public final fun canvasLightOccluderSetTransform(occluder: RID, transform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to occluder, TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.canvasLightOccluderSetTransformPtr)
  }

  /**
   * The light mask. See [LightOccluder2D] for more information on light masks.
   */
  @JvmStatic
  public final fun canvasLightOccluderSetLightMask(occluder: RID, mask: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to occluder, LONG to mask.toLong())
    TransferContext.callMethod(MethodBindings.canvasLightOccluderSetLightMaskPtr)
  }

  /**
   * If [interpolated] is `true`, turns on physics interpolation for the light occluder.
   */
  @JvmStatic
  public final fun canvasLightOccluderSetInterpolated(occluder: RID, interpolated: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to occluder, BOOL to interpolated)
    TransferContext.callMethod(MethodBindings.canvasLightOccluderSetInterpolatedPtr)
  }

  /**
   * Prevents physics interpolation for the current physics tick.
   *
   * This is useful when moving an occluder to a new location, to give an instantaneous change
   * rather than interpolation from the previous location.
   */
  @JvmStatic
  public final fun canvasLightOccluderResetPhysicsInterpolation(occluder: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to occluder)
    TransferContext.callMethod(MethodBindings.canvasLightOccluderResetPhysicsInterpolationPtr)
  }

  /**
   * Transforms both the current and previous stored transform for a light occluder.
   *
   * This allows transforming an occluder without creating a "glitch" in the interpolation, which is
   * particularly useful for large worlds utilizing a shifting origin.
   */
  @JvmStatic
  public final fun canvasLightOccluderTransformPhysicsInterpolation(occluder: RID,
      transform: Transform2D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to occluder, TRANSFORM2D to transform)
    TransferContext.callMethod(MethodBindings.canvasLightOccluderTransformPhysicsInterpolationPtr)
  }

  /**
   * Creates a new light occluder polygon and adds it to the RenderingServer. It can be accessed
   * with the RID that is returned. This RID will be used in all `canvas_occluder_polygon_*`
   * RenderingServer functions.
   *
   * Once finished with your RID, you will want to free the RID using the RenderingServer's
   * [freeRid] method.
   *
   * **Note:** The equivalent resource is [OccluderPolygon2D].
   */
  @JvmStatic
  public final fun canvasOccluderPolygonCreate(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.canvasOccluderPolygonCreatePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets the shape of the occluder polygon.
   */
  @JvmStatic
  public final fun canvasOccluderPolygonSetShape(
    occluderPolygon: RID,
    shape: PackedVector2Array,
    closed: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to occluderPolygon, PACKED_VECTOR2_ARRAY to shape, BOOL to closed)
    TransferContext.callMethod(MethodBindings.canvasOccluderPolygonSetShapePtr)
  }

  /**
   * Sets an occluder polygon's cull mode.
   */
  @JvmStatic
  public final fun canvasOccluderPolygonSetCullMode(occluderPolygon: RID,
      mode: CanvasOccluderPolygonCullMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to occluderPolygon, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.canvasOccluderPolygonSetCullModePtr)
  }

  /**
   * Sets the [ProjectSettings.rendering/2d/shadowAtlas/size] to use for [Light2D] shadow rendering
   * (in pixels). The value is rounded up to the nearest power of 2.
   */
  @JvmStatic
  public final fun canvasSetShadowTextureSize(size: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.canvasSetShadowTextureSizePtr)
  }

  /**
   * Creates a new global shader uniform.
   *
   * **Note:** Global shader parameter names are case-sensitive.
   */
  @JvmStatic
  public final fun globalShaderParameterAdd(
    name: StringName,
    type: GlobalShaderParameterType,
    defaultValue: Any?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, LONG to type.value, ANY to defaultValue)
    TransferContext.callMethod(MethodBindings.globalShaderParameterAddPtr)
  }

  /**
   * Removes the global shader uniform specified by [name].
   */
  @JvmStatic
  public final fun globalShaderParameterRemove(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.globalShaderParameterRemovePtr)
  }

  /**
   * Returns the list of global shader uniform names.
   *
   * **Note:** [globalShaderParameterGet] has a large performance penalty as the rendering thread
   * needs to synchronize with the calling thread, which is slow. Do not use this method during
   * gameplay to avoid stuttering. If you need to read values in a script after setting them, consider
   * creating an autoload where you store the values you need to query at the same time you're setting
   * them as global parameters.
   */
  @JvmStatic
  public final fun globalShaderParameterGetList(): VariantArray<StringName> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.globalShaderParameterGetListPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<StringName>)
  }

  /**
   * Sets the global shader uniform [name] to [value].
   */
  @JvmStatic
  public final fun globalShaderParameterSet(name: StringName, `value`: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, ANY to value)
    TransferContext.callMethod(MethodBindings.globalShaderParameterSetPtr)
  }

  /**
   * Overrides the global shader uniform [name] with [value]. Equivalent to the
   * [ShaderGlobalsOverride] node.
   */
  @JvmStatic
  public final fun globalShaderParameterSetOverride(name: StringName, `value`: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, ANY to value)
    TransferContext.callMethod(MethodBindings.globalShaderParameterSetOverridePtr)
  }

  /**
   * Returns the value of the global shader uniform specified by [name].
   *
   * **Note:** [globalShaderParameterGet] has a large performance penalty as the rendering thread
   * needs to synchronize with the calling thread, which is slow. Do not use this method during
   * gameplay to avoid stuttering. If you need to read values in a script after setting them, consider
   * creating an autoload where you store the values you need to query at the same time you're setting
   * them as global parameters.
   */
  @JvmStatic
  public final fun globalShaderParameterGet(name: StringName): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.globalShaderParameterGetPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns the type associated to the global shader uniform specified by [name].
   *
   * **Note:** [globalShaderParameterGet] has a large performance penalty as the rendering thread
   * needs to synchronize with the calling thread, which is slow. Do not use this method during
   * gameplay to avoid stuttering. If you need to read values in a script after setting them, consider
   * creating an autoload where you store the values you need to query at the same time you're setting
   * them as global parameters.
   */
  @JvmStatic
  public final fun globalShaderParameterGetType(name: StringName): GlobalShaderParameterType {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.globalShaderParameterGetTypePtr)
    return GlobalShaderParameterType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Tries to free an object in the RenderingServer. To avoid memory leaks, this should be called
   * after using an object as memory management does not occur automatically when using RenderingServer
   * directly.
   */
  @JvmStatic
  public final fun freeRid(rid: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to rid)
    TransferContext.callMethod(MethodBindings.freeRidPtr)
  }

  /**
   * Schedules a callback to the given callable after a frame has been drawn.
   */
  @JvmStatic
  public final fun requestFrameDrawnCallback(callable: Callable): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, CALLABLE to callable)
    TransferContext.callMethod(MethodBindings.requestFrameDrawnCallbackPtr)
  }

  /**
   * Returns `true` if changes have been made to the RenderingServer's data. [forceDraw] is usually
   * called if this happens.
   */
  @JvmStatic
  public final fun hasChanged(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasChangedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns a statistic about the rendering engine which can be used for performance profiling. See
   * also [viewportGetRenderInfo], which returns information specific to a viewport.
   *
   * **Note:** Only 3D rendering is currently taken into account by some of these values, such as
   * the number of draw calls.
   *
   * **Note:** Rendering information is not available until at least 2 frames have been rendered by
   * the engine. If rendering information is not available, [getRenderingInfo] returns `0`. To print
   * rendering information in `_ready()` successfully, use the following:
   *
   * ```
   * func _ready():
   * 	for _i in 2:
   * 		await get_tree().process_frame
   *
   * 	print(RenderingServer.get_rendering_info(RENDERING_INFO_TOTAL_DRAW_CALLS_IN_FRAME))
   * ```
   */
  @JvmStatic
  public final fun getRenderingInfo(info: RenderingInfo): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to info.value)
    TransferContext.callMethod(MethodBindings.getRenderingInfoPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the name of the video adapter (e.g. "GeForce GTX 1080/PCIe/SSE2").
   *
   * **Note:** When running a headless or server binary, this function returns an empty string.
   *
   * **Note:** On the web platform, some browsers such as Firefox may report a different, fixed GPU
   * name such as "GeForce GTX 980" (regardless of the user's actual GPU model). This is done to make
   * fingerprinting more difficult.
   */
  @JvmStatic
  public final fun getVideoAdapterName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVideoAdapterNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the vendor of the video adapter (e.g. "NVIDIA Corporation").
   *
   * **Note:** When running a headless or server binary, this function returns an empty string.
   */
  @JvmStatic
  public final fun getVideoAdapterVendor(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVideoAdapterVendorPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the type of the video adapter. Since dedicated graphics cards from a given generation
   * will *usually* be significantly faster than integrated graphics made in the same generation, the
   * device type can be used as a basis for automatic graphics settings adjustment. However, this is
   * not always true, so make sure to provide users with a way to manually override graphics settings.
   *
   * **Note:** When using the OpenGL rendering driver or when running in headless mode, this
   * function always returns [RenderingDevice.DEVICE_TYPE_OTHER].
   */
  @JvmStatic
  public final fun getVideoAdapterType(): RenderingDevice.DeviceType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVideoAdapterTypePtr)
    return RenderingDevice.DeviceType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the version of the graphics video adapter *currently in use* (e.g. "1.2.189" for
   * Vulkan, "3.3.0 NVIDIA 510.60.02" for OpenGL). This version may be different from the actual latest
   * version supported by the hardware, as Godot may not always request the latest version. See also
   * [OS.getVideoAdapterDriverInfo].
   *
   * **Note:** When running a headless or server binary, this function returns an empty string.
   */
  @JvmStatic
  public final fun getVideoAdapterApiVersion(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVideoAdapterApiVersionPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the name of the current rendering driver. This can be `vulkan`, `d3d12`, `metal`,
   * `opengl3`, `opengl3_es`, or `opengl3_angle`. See also [getCurrentRenderingMethod].
   *
   * When [ProjectSettings.rendering/renderer/renderingMethod] is `forward_plus` or `mobile`, the
   * rendering driver is determined by [ProjectSettings.rendering/renderingDevice/driver].
   *
   * When [ProjectSettings.rendering/renderer/renderingMethod] is `gl_compatibility`, the rendering
   * driver is determined by [ProjectSettings.rendering/glCompatibility/driver].
   *
   * The rendering driver is also determined by the `--rendering-driver` command line argument that
   * overrides this project setting, or an automatic fallback that is applied depending on the
   * hardware.
   */
  @JvmStatic
  public final fun getCurrentRenderingDriverName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentRenderingDriverNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the name of the current rendering method. This can be `forward_plus`, `mobile`, or
   * `gl_compatibility`. See also [getCurrentRenderingDriverName].
   *
   * The rendering method is determined by [ProjectSettings.rendering/renderer/renderingMethod], the
   * `--rendering-method` command line argument that overrides this project setting, or an automatic
   * fallback that is applied depending on the hardware.
   */
  @JvmStatic
  public final fun getCurrentRenderingMethod(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentRenderingMethodPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns a mesh of a sphere with the given number of horizontal subdivisions, vertical
   * subdivisions and radius. See also [getTestCube].
   */
  @JvmStatic
  public final fun makeSphereMesh(
    latitudes: Int,
    longitudes: Int,
    radius: Float,
  ): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to latitudes.toLong(), LONG to longitudes.toLong(), DOUBLE to radius.toDouble())
    TransferContext.callMethod(MethodBindings.makeSphereMeshPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the RID of the test cube. This mesh will be created and returned on the first call to
   * [getTestCube], then it will be cached for subsequent calls. See also [makeSphereMesh].
   */
  @JvmStatic
  public final fun getTestCube(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTestCubePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the RID of a 256×256 texture with a testing pattern on it (in [Image.FORMAT_RGB8]
   * format). This texture will be created and returned on the first call to [getTestTexture], then it
   * will be cached for subsequent calls. See also [getWhiteTexture].
   *
   * **Example:** Get the test texture and apply it to a [Sprite2D] node:
   *
   * ```
   * var texture_rid = RenderingServer.get_test_texture()
   * var texture = ImageTexture.create_from_image(RenderingServer.texture_2d_get(texture_rid))
   * $Sprite2D.texture = texture
   * ```
   */
  @JvmStatic
  public final fun getTestTexture(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTestTexturePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the ID of a 4×4 white texture (in [Image.FORMAT_RGB8] format). This texture will be
   * created and returned on the first call to [getWhiteTexture], then it will be cached for subsequent
   * calls. See also [getTestTexture].
   *
   * **Example:** Get the white texture and apply it to a [Sprite2D] node:
   *
   * ```
   * var texture_rid = RenderingServer.get_white_texture()
   * var texture = ImageTexture.create_from_image(RenderingServer.texture_2d_get(texture_rid))
   * $Sprite2D.texture = texture
   * ```
   */
  @JvmStatic
  public final fun getWhiteTexture(): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWhiteTexturePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Sets a boot image. The [color] defines the background color. The value of [stretchMode]
   * indicates how the image will be stretched (see [SplashStretchMode] for possible values). If
   * [useFilter] is `true`, the image will be scaled with linear interpolation. If [useFilter] is
   * `false`, the image will be scaled with nearest-neighbor interpolation.
   */
  @JvmOverloads
  @JvmStatic
  public final fun setBootImageWithStretch(
    image: Image?,
    color: Color,
    stretchMode: SplashStretchMode,
    useFilter: Boolean = true,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to image, COLOR to color, LONG to stretchMode.value, BOOL to useFilter)
    TransferContext.callMethod(MethodBindings.setBootImageWithStretchPtr)
  }

  /**
   * Sets a boot image. The [color] defines the background color. The value of [scale] indicates if
   * the image will be scaled to fit the screen size. If [useFilter] is `true`, the image will be
   * scaled with linear interpolation. If [useFilter] is `false`, the image will be scaled with
   * nearest-neighbor interpolation.
   */
  @JvmOverloads
  @JvmStatic
  public final fun setBootImage(
    image: Image?,
    color: Color,
    scale: Boolean,
    useFilter: Boolean = true,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to image, COLOR to color, BOOL to scale, BOOL to useFilter)
    TransferContext.callMethod(MethodBindings.setBootImagePtr)
  }

  /**
   * Returns the default clear color which is used when a specific clear color has not been
   * selected. See also [setDefaultClearColor].
   */
  @JvmStatic
  public final fun getDefaultClearColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDefaultClearColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  /**
   * Sets the default clear color which is used when a specific clear color has not been selected.
   * See also [getDefaultClearColor].
   */
  @JvmStatic
  public final fun setDefaultClearColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setDefaultClearColorPtr)
  }

  /**
   * Returns `true` if the OS supports a certain [feature]. Features might be `s3tc`, `etc`, and
   * `etc2`.
   */
  @JvmStatic
  public final fun hasOsFeature(feature: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to feature)
    TransferContext.callMethod(MethodBindings.hasOsFeaturePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If [generate] is `true`, generates debug wireframes for all meshes that are loaded when using
   * the Compatibility renderer. By default, the engine does not generate debug wireframes at runtime,
   * since they slow down loading of assets and take up VRAM.
   *
   * **Note:** You must call this method before loading any meshes when using the Compatibility
   * renderer. Otherwise, wireframes will not be used.
   */
  @JvmStatic
  public final fun setDebugGenerateWireframes(generate: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to generate)
    TransferContext.callMethod(MethodBindings.setDebugGenerateWireframesPtr)
  }

  @JvmStatic
  public final fun isRenderLoopEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isRenderLoopEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  @JvmStatic
  public final fun setRenderLoopEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setRenderLoopEnabledPtr)
  }

  /**
   * Returns the time taken to setup rendering on the CPU in milliseconds. This value is shared
   * across all viewports and does *not* require [viewportSetMeasureRenderTime] to be enabled on a
   * viewport to be queried. See also [viewportGetMeasuredRenderTimeCpu].
   */
  @JvmStatic
  public final fun getFrameSetupTimeCpu(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFrameSetupTimeCpuPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Forces a synchronization between the CPU and GPU, which may be required in certain cases. Only
   * call this when needed, as CPU-GPU synchronization has a performance cost.
   */
  @JvmStatic
  public final fun forceSync(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.forceSyncPtr)
  }

  /**
   * Forces redrawing of all viewports at once. Must be called from the main thread.
   */
  @JvmOverloads
  @JvmStatic
  public final fun forceDraw(swapBuffers: Boolean = true, frameStep: Double = 0.0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to swapBuffers, DOUBLE to frameStep)
    TransferContext.callMethod(MethodBindings.forceDrawPtr)
  }

  /**
   * Returns the global RenderingDevice.
   *
   * **Note:** When using the OpenGL rendering driver or when running in headless mode, this
   * function always returns `null`.
   */
  @JvmStatic
  public final fun getRenderingDevice(): RenderingDevice? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRenderingDevicePtr)
    return (TransferContext.readReturnValue(OBJECT) as RenderingDevice?)
  }

  /**
   * Creates a RenderingDevice that can be used to do draw and compute operations on a separate
   * thread. Cannot draw to the screen nor share data with the global RenderingDevice.
   *
   * **Note:** When using the OpenGL rendering driver or when running in headless mode, this
   * function always returns `null`.
   */
  @JvmStatic
  public final fun createLocalRenderingDevice(): RenderingDevice? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.createLocalRenderingDevicePtr)
    return (TransferContext.readReturnValue(OBJECT) as RenderingDevice?)
  }

  /**
   * Returns `true` if our code is currently executing on the rendering thread.
   */
  @JvmStatic
  public final fun isOnRenderThread(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOnRenderThreadPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * As the RenderingServer actual logic may run on a separate thread, accessing its internals from
   * the main (or any other) thread will result in errors. To make it easier to run code that can
   * safely access the rendering internals (such as [RenderingDevice] and similar RD classes), push a
   * callable via this function so it will be executed on the render thread.
   */
  @JvmStatic
  public final fun callOnRenderThread(callable: Callable): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, CALLABLE to callable)
    TransferContext.callMethod(MethodBindings.callOnRenderThreadPtr)
  }

  /**
   * This method does nothing and always returns `false`.
   */
  @JvmStatic
  public final fun hasFeature(feature: Features): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to feature.value)
    TransferContext.callMethod(MethodBindings.hasFeaturePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the default value for the specified shader uniform. This is usually the value written
   * in the shader source code.
   */
  @JvmStatic
  public final fun shaderGetParameterDefault(shader: RID, name: String): Any? =
      shaderGetParameterDefault(shader, name.asCachedStringName())

  /**
   * Sets a shader's default texture. Overwrites the texture given by name.
   *
   * **Note:** If the sampler array is used use [index] to access the specified texture.
   */
  @JvmOverloads
  @JvmStatic
  public final fun shaderSetDefaultTextureParameter(
    shader: RID,
    name: String,
    texture: RID,
    index: Int = 0,
  ) = shaderSetDefaultTextureParameter(shader, name.asCachedStringName(), texture, index)

  /**
   * Returns a default texture from a shader searched by name.
   *
   * **Note:** If the sampler array is used use [index] to access the specified texture.
   */
  @JvmOverloads
  @JvmStatic
  public final fun shaderGetDefaultTextureParameter(
    shader: RID,
    name: String,
    index: Int = 0,
  ): RID = shaderGetDefaultTextureParameter(shader, name.asCachedStringName(), index)

  /**
   * Sets a material's parameter.
   */
  @JvmStatic
  public final fun materialSetParam(
    material: RID,
    parameter: String,
    `value`: Any?,
  ) = materialSetParam(material, parameter.asCachedStringName(), value)

  /**
   * Returns the value of a certain material's parameter.
   */
  @JvmStatic
  public final fun materialGetParam(material: RID, parameter: String): Any? =
      materialGetParam(material, parameter.asCachedStringName())

  /**
   * Sets the per-instance shader uniform on the specified 3D geometry instance. Equivalent to
   * [GeometryInstance3D.setInstanceShaderParameter].
   */
  @JvmStatic
  public final fun instanceGeometrySetShaderParameter(
    instance: RID,
    parameter: String,
    `value`: Any?,
  ) = instanceGeometrySetShaderParameter(instance, parameter.asCachedStringName(), value)

  /**
   * Returns the value of the per-instance shader uniform from the specified 3D geometry instance.
   * Equivalent to [GeometryInstance3D.getInstanceShaderParameter].
   *
   * **Note:** Per-instance shader parameter names are case-sensitive.
   */
  @JvmStatic
  public final fun instanceGeometryGetShaderParameter(instance: RID, parameter: String): Any? =
      instanceGeometryGetShaderParameter(instance, parameter.asCachedStringName())

  /**
   * Returns the default value of the per-instance shader uniform from the specified 3D geometry
   * instance. Equivalent to [GeometryInstance3D.getInstanceShaderParameter].
   */
  @JvmStatic
  public final fun instanceGeometryGetShaderParameterDefaultValue(instance: RID, parameter: String):
      Any? =
      instanceGeometryGetShaderParameterDefaultValue(instance, parameter.asCachedStringName())

  /**
   * Sets the per-instance shader uniform on the specified canvas item instance. Equivalent to
   * [CanvasItem.setInstanceShaderParameter].
   */
  @JvmStatic
  public final fun canvasItemSetInstanceShaderParameter(
    instance: RID,
    parameter: String,
    `value`: Any?,
  ) = canvasItemSetInstanceShaderParameter(instance, parameter.asCachedStringName(), value)

  /**
   * Returns the value of the per-instance shader uniform from the specified canvas item instance.
   * Equivalent to [CanvasItem.getInstanceShaderParameter].
   */
  @JvmStatic
  public final fun canvasItemGetInstanceShaderParameter(instance: RID, parameter: String): Any? =
      canvasItemGetInstanceShaderParameter(instance, parameter.asCachedStringName())

  /**
   * Returns the default value of the per-instance shader uniform from the specified canvas item
   * instance. Equivalent to [CanvasItem.getInstanceShaderParameter].
   */
  @JvmStatic
  public final fun canvasItemGetInstanceShaderParameterDefaultValue(instance: RID,
      parameter: String): Any? =
      canvasItemGetInstanceShaderParameterDefaultValue(instance, parameter.asCachedStringName())

  /**
   * Creates a new global shader uniform.
   *
   * **Note:** Global shader parameter names are case-sensitive.
   */
  @JvmStatic
  public final fun globalShaderParameterAdd(
    name: String,
    type: GlobalShaderParameterType,
    defaultValue: Any?,
  ) = globalShaderParameterAdd(name.asCachedStringName(), type, defaultValue)

  /**
   * Removes the global shader uniform specified by [name].
   */
  @JvmStatic
  public final fun globalShaderParameterRemove(name: String) =
      globalShaderParameterRemove(name.asCachedStringName())

  /**
   * Sets the global shader uniform [name] to [value].
   */
  @JvmStatic
  public final fun globalShaderParameterSet(name: String, `value`: Any?) =
      globalShaderParameterSet(name.asCachedStringName(), value)

  /**
   * Overrides the global shader uniform [name] with [value]. Equivalent to the
   * [ShaderGlobalsOverride] node.
   */
  @JvmStatic
  public final fun globalShaderParameterSetOverride(name: String, `value`: Any?) =
      globalShaderParameterSetOverride(name.asCachedStringName(), value)

  /**
   * Returns the value of the global shader uniform specified by [name].
   *
   * **Note:** [globalShaderParameterGet] has a large performance penalty as the rendering thread
   * needs to synchronize with the calling thread, which is slow. Do not use this method during
   * gameplay to avoid stuttering. If you need to read values in a script after setting them, consider
   * creating an autoload where you store the values you need to query at the same time you're setting
   * them as global parameters.
   */
  @JvmStatic
  public final fun globalShaderParameterGet(name: String): Any? =
      globalShaderParameterGet(name.asCachedStringName())

  /**
   * Returns the type associated to the global shader uniform specified by [name].
   *
   * **Note:** [globalShaderParameterGet] has a large performance penalty as the rendering thread
   * needs to synchronize with the calling thread, which is slow. Do not use this method during
   * gameplay to avoid stuttering. If you need to read values in a script after setting them, consider
   * creating an autoload where you store the values you need to query at the same time you're setting
   * them as global parameters.
   */
  @JvmStatic
  public final fun globalShaderParameterGetType(name: String): GlobalShaderParameterType =
      globalShaderParameterGetType(name.asCachedStringName())

  public enum class TextureType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * 2D texture.
     */
    TEXTURE_TYPE_2D(0),
    /**
     * Layered texture.
     */
    LAYERED(1),
    /**
     * 3D texture.
     */
    TEXTURE_TYPE_3D(2),
    ;

    public companion object {
      public fun from(`value`: Long): TextureType = entries.single { it.`value` == `value` }
    }
  }

  public enum class TextureLayeredType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Array of 2-dimensional textures (see [Texture2DArray]).
     */
    TEXTURE_LAYERED_2D_ARRAY(0),
    /**
     * Cubemap texture (see [Cubemap]).
     */
    CUBEMAP(1),
    /**
     * Array of cubemap textures (see [CubemapArray]).
     */
    CUBEMAP_ARRAY(2),
    ;

    public companion object {
      public fun from(`value`: Long): TextureLayeredType = entries.single { it.`value` == `value` }
    }
  }

  public enum class CubeMapLayer(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Left face of a [Cubemap].
     */
    CUBEMAP_LAYER_LEFT(0),
    /**
     * Right face of a [Cubemap].
     */
    CUBEMAP_LAYER_RIGHT(1),
    /**
     * Bottom face of a [Cubemap].
     */
    CUBEMAP_LAYER_BOTTOM(2),
    /**
     * Top face of a [Cubemap].
     */
    CUBEMAP_LAYER_TOP(3),
    /**
     * Front face of a [Cubemap].
     */
    CUBEMAP_LAYER_FRONT(4),
    /**
     * Back face of a [Cubemap].
     */
    CUBEMAP_LAYER_BACK(5),
    ;

    public companion object {
      public fun from(`value`: Long): CubeMapLayer = entries.single { it.`value` == `value` }
    }
  }

  public enum class TextureDrawableFormat(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * OpenGL texture format RGBA with four components, each with a bitdepth of 8.
     */
    RGBA8(0),
    /**
     * OpenGL texture format RGBA with four components, each with a bitdepth of 8.
     *
     * When drawn to, an sRGB to linear color space conversion is performed.
     */
    RGBA8_SRGB(1),
    /**
     * OpenGL texture format GL_RGBA16F where there are four components, each a 16-bit
     * "half-precision" floating-point value.
     */
    RGBAH(2),
    /**
     * OpenGL texture format GL_RGBA32F where there are four components, each a 32-bit
     * floating-point value.
     */
    RGBAF(3),
    ;

    public companion object {
      public fun from(`value`: Long): TextureDrawableFormat =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class ShaderMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Shader is a 3D shader.
     */
    SPATIAL(0),
    /**
     * Shader is a 2D shader.
     */
    CANVAS_ITEM(1),
    /**
     * Shader is a particle shader (can be used in both 2D and 3D).
     */
    PARTICLES(2),
    /**
     * Shader is a 3D sky shader.
     */
    SKY(3),
    /**
     * Shader is a 3D fog shader.
     */
    FOG(4),
    /**
     * Shader is a texture_blit shader.
     */
    TEXTURE_BLIT(5),
    /**
     * Represents the size of the [ShaderMode] enum.
     */
    MAX(6),
    ;

    public companion object {
      public fun from(`value`: Long): ShaderMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class ArrayType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Array is a vertex position array.
     */
    VERTEX(0),
    /**
     * Array is a normal array.
     */
    NORMAL(1),
    /**
     * Array is a tangent array.
     */
    TANGENT(2),
    /**
     * Array is a vertex color array.
     */
    COLOR(3),
    /**
     * Array is a UV coordinates array.
     */
    TEX_UV(4),
    /**
     * Array is a UV coordinates array for the second set of UV coordinates.
     */
    TEX_UV2(5),
    /**
     * Array is a custom data array for the first set of custom data.
     */
    CUSTOM0(6),
    /**
     * Array is a custom data array for the second set of custom data.
     */
    CUSTOM1(7),
    /**
     * Array is a custom data array for the third set of custom data.
     */
    CUSTOM2(8),
    /**
     * Array is a custom data array for the fourth set of custom data.
     */
    CUSTOM3(9),
    /**
     * Array contains bone information.
     */
    BONES(10),
    /**
     * Array is weight information.
     */
    WEIGHTS(11),
    /**
     * Array is an index array.
     */
    INDEX(12),
    /**
     * Represents the size of the [ArrayType] enum.
     */
    MAX(13),
    ;

    public companion object {
      public fun from(`value`: Long): ArrayType = entries.single { it.`value` == `value` }
    }
  }

  public enum class ArrayCustomFormat(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Custom data array contains 8-bit-per-channel red/green/blue/alpha color data. Values are
     * normalized, unsigned floating-point in the `[0.0, 1.0]` range.
     */
    RGBA8_UNORM(0),
    /**
     * Custom data array contains 8-bit-per-channel red/green/blue/alpha color data. Values are
     * normalized, signed floating-point in the `[-1.0, 1.0]` range.
     */
    RGBA8_SNORM(1),
    /**
     * Custom data array contains 16-bit-per-channel red/green color data. Values are floating-point
     * in half precision.
     */
    RG_HALF(2),
    /**
     * Custom data array contains 16-bit-per-channel red/green/blue/alpha color data. Values are
     * floating-point in half precision.
     */
    RGBA_HALF(3),
    /**
     * Custom data array contains 32-bit-per-channel red color data. Values are floating-point in
     * single precision.
     */
    R_FLOAT(4),
    /**
     * Custom data array contains 32-bit-per-channel red/green color data. Values are floating-point
     * in single precision.
     */
    RG_FLOAT(5),
    /**
     * Custom data array contains 32-bit-per-channel red/green/blue color data. Values are
     * floating-point in single precision.
     */
    RGB_FLOAT(6),
    /**
     * Custom data array contains 32-bit-per-channel red/green/blue/alpha color data. Values are
     * floating-point in single precision.
     */
    RGBA_FLOAT(7),
    /**
     * Represents the size of the [ArrayCustomFormat] enum.
     */
    MAX(8),
    ;

    public companion object {
      public fun from(`value`: Long): ArrayCustomFormat = entries.single { it.`value` == `value` }
    }
  }

  public class ArrayFormat(
    flag: Long,
  ) : BitFieldBase<ArrayFormat>(flag) {
    protected override fun wrap(flag: Long): ArrayFormat = ArrayFormat(flag)

    public companion object {
      /**
       * Flag used to mark a vertex position array.
       */
      @JvmField
      public val VERTEX: ArrayFormat = ArrayFormat(1)

      /**
       * Flag used to mark a normal array.
       */
      @JvmField
      public val NORMAL: ArrayFormat = ArrayFormat(2)

      /**
       * Flag used to mark a tangent array.
       */
      @JvmField
      public val TANGENT: ArrayFormat = ArrayFormat(4)

      /**
       * Flag used to mark a vertex color array.
       */
      @JvmField
      public val COLOR: ArrayFormat = ArrayFormat(8)

      /**
       * Flag used to mark a UV coordinates array.
       */
      @JvmField
      public val TEX_UV: ArrayFormat = ArrayFormat(16)

      /**
       * Flag used to mark a UV coordinates array for the second UV coordinates.
       */
      @JvmField
      public val TEX_UV2: ArrayFormat = ArrayFormat(32)

      /**
       * Flag used to mark an array of custom per-vertex data for the first set of custom data.
       */
      @JvmField
      public val CUSTOM0: ArrayFormat = ArrayFormat(64)

      /**
       * Flag used to mark an array of custom per-vertex data for the second set of custom data.
       */
      @JvmField
      public val CUSTOM1: ArrayFormat = ArrayFormat(128)

      /**
       * Flag used to mark an array of custom per-vertex data for the third set of custom data.
       */
      @JvmField
      public val CUSTOM2: ArrayFormat = ArrayFormat(256)

      /**
       * Flag used to mark an array of custom per-vertex data for the fourth set of custom data.
       */
      @JvmField
      public val CUSTOM3: ArrayFormat = ArrayFormat(512)

      /**
       * Flag used to mark a bone information array.
       */
      @JvmField
      public val BONES: ArrayFormat = ArrayFormat(1024)

      /**
       * Flag used to mark a weights array.
       */
      @JvmField
      public val WEIGHTS: ArrayFormat = ArrayFormat(2048)

      /**
       * Flag used to mark an index array.
       */
      @JvmField
      public val INDEX: ArrayFormat = ArrayFormat(4096)

      /**
       * Mask of mesh channels permitted in blend shapes.
       */
      @JvmField
      public val BLEND_SHAPE_MASK: ArrayFormat = ArrayFormat(7)

      /**
       * Shift of first custom channel.
       */
      @JvmField
      public val CUSTOM_BASE: ArrayFormat = ArrayFormat(13)

      /**
       * Number of format bits per custom channel. See [ArrayCustomFormat].
       */
      @JvmField
      public val CUSTOM_BITS: ArrayFormat = ArrayFormat(3)

      /**
       * Amount to shift [ArrayCustomFormat] for custom channel index 0.
       */
      @JvmField
      public val CUSTOM0_SHIFT: ArrayFormat = ArrayFormat(13)

      /**
       * Amount to shift [ArrayCustomFormat] for custom channel index 1.
       */
      @JvmField
      public val CUSTOM1_SHIFT: ArrayFormat = ArrayFormat(16)

      /**
       * Amount to shift [ArrayCustomFormat] for custom channel index 2.
       */
      @JvmField
      public val CUSTOM2_SHIFT: ArrayFormat = ArrayFormat(19)

      /**
       * Amount to shift [ArrayCustomFormat] for custom channel index 3.
       */
      @JvmField
      public val CUSTOM3_SHIFT: ArrayFormat = ArrayFormat(22)

      /**
       * Mask of custom format bits per custom channel. Must be shifted by one of the SHIFT
       * constants. See [ArrayCustomFormat].
       */
      @JvmField
      public val CUSTOM_MASK: ArrayFormat = ArrayFormat(7)

      /**
       * Shift of first compress flag. Compress flags should be passed to
       * [ArrayMesh.addSurfaceFromArrays] and [SurfaceTool.commit].
       */
      @JvmField
      public val COMPRESS_FLAGS_BASE: ArrayFormat = ArrayFormat(25)

      /**
       * Flag used to mark that the array contains 2D vertices.
       */
      @JvmField
      public val FLAG_USE_2D_VERTICES: ArrayFormat = ArrayFormat(33554432)

      /**
       * Flag used to mark that the mesh data will use `GL_DYNAMIC_DRAW` on GLES. Unused on Vulkan.
       */
      @JvmField
      public val FLAG_USE_DYNAMIC_UPDATE: ArrayFormat = ArrayFormat(67108864)

      /**
       * Flag used to mark that the array uses 8 bone weights instead of 4.
       */
      @JvmField
      public val FLAG_USE_8_BONE_WEIGHTS: ArrayFormat = ArrayFormat(134217728)

      /**
       * Flag used to mark that the mesh does not have a vertex array and instead will infer vertex
       * positions in the shader using indices and other information.
       */
      @JvmField
      public val FLAG_USES_EMPTY_VERTEX_ARRAY: ArrayFormat = ArrayFormat(268435456)

      /**
       * Flag used to mark that a mesh is using compressed attributes (vertices, normals, tangents,
       * UVs). When this form of compression is enabled, vertex positions will be packed into an
       * RGBA16UNORM attribute and scaled in the vertex shader. The normal and tangent will be packed
       * into an RG16UNORM representing an axis, and a 16-bit float stored in the A-channel of the
       * vertex. UVs will use 16-bit normalized floats instead of full 32-bit signed floats. When using
       * this compression mode you must use either vertices, normals, and tangents or only vertices.
       * You cannot use normals without tangents. Importers will automatically enable this compression
       * if they can.
       */
      @JvmField
      public val FLAG_COMPRESS_ATTRIBUTES: ArrayFormat = ArrayFormat(536870912)

      /**
       * Flag used to mark the start of the bits used to store the mesh version.
       */
      @JvmField
      public val FLAG_FORMAT_VERSION_BASE: ArrayFormat = ArrayFormat(35)

      /**
       * Flag used to shift a mesh format int to bring the version into the lowest digits.
       */
      @JvmField
      public val FLAG_FORMAT_VERSION_SHIFT: ArrayFormat = ArrayFormat(35)

      /**
       * Flag used to record the format used by prior mesh versions before the introduction of a
       * version.
       */
      @JvmField
      public val FLAG_FORMAT_VERSION_1: ArrayFormat = ArrayFormat(0)

      /**
       * Flag used to record the second iteration of the mesh version flag. The primary difference
       * between this and [ARRAY_FLAG_FORMAT_VERSION_1] is that this version supports
       * [ARRAY_FLAG_COMPRESS_ATTRIBUTES] and in this version vertex positions are de-interleaved from
       * normals and tangents.
       */
      @JvmField
      public val FLAG_FORMAT_VERSION_2: ArrayFormat = ArrayFormat(34359738368)

      /**
       * Flag used to record the current version that the engine expects. Currently this is the same
       * as [ARRAY_FLAG_FORMAT_VERSION_2].
       */
      @JvmField
      public val FLAG_FORMAT_CURRENT_VERSION: ArrayFormat = ArrayFormat(34359738368)

      /**
       * Flag used to isolate the bits used for mesh version after using
       * [ARRAY_FLAG_FORMAT_VERSION_SHIFT] to shift them into place.
       */
      @JvmField
      public val FLAG_FORMAT_VERSION_MASK: ArrayFormat = ArrayFormat(255)
    }
  }

  public enum class PrimitiveType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Primitive to draw consists of points.
     */
    POINTS(0),
    /**
     * Primitive to draw consists of lines.
     */
    LINES(1),
    /**
     * Primitive to draw consists of a line strip from start to end.
     */
    LINE_STRIP(2),
    /**
     * Primitive to draw consists of triangles.
     */
    TRIANGLES(3),
    /**
     * Primitive to draw consists of a triangle strip (the last 3 vertices are always combined to
     * make a triangle).
     */
    TRIANGLE_STRIP(4),
    /**
     * Represents the size of the [PrimitiveType] enum.
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): PrimitiveType = entries.single { it.`value` == `value` }
    }
  }

  public enum class BlendShapeMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Blend shapes are normalized.
     */
    NORMALIZED(0),
    /**
     * Blend shapes are relative to base weight.
     */
    RELATIVE(1),
    ;

    public companion object {
      public fun from(`value`: Long): BlendShapeMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class MultimeshTransformFormat(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use [Transform2D] to store MultiMesh transform.
     */
    MULTIMESH_TRANSFORM_2D(0),
    /**
     * Use [Transform3D] to store MultiMesh transform.
     */
    MULTIMESH_TRANSFORM_3D(1),
    ;

    public companion object {
      public fun from(`value`: Long): MultimeshTransformFormat =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class MultimeshPhysicsInterpolationQuality(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * MultiMesh physics interpolation favors speed over quality.
     */
    INTERP_QUALITY_FAST(0),
    /**
     * MultiMesh physics interpolation favors quality over speed.
     */
    INTERP_QUALITY_HIGH(1),
    ;

    public companion object {
      public fun from(`value`: Long): MultimeshPhysicsInterpolationQuality =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class LightProjectorFilter(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Nearest-neighbor filter for light projectors (use for pixel art light projectors). No mipmaps
     * are used for rendering, which means light projectors at a distance will look sharp but grainy.
     * This has roughly the same performance cost as using mipmaps.
     */
    NEAREST(0),
    /**
     * Linear filter for light projectors (use for non-pixel art light projectors). No mipmaps are
     * used for rendering, which means light projectors at a distance will look smooth but blurry. This
     * has roughly the same performance cost as using mipmaps.
     */
    LINEAR(1),
    /**
     * Nearest-neighbor filter for light projectors (use for pixel art light projectors). Isotropic
     * mipmaps are used for rendering, which means light projectors at a distance will look smooth but
     * blurry. This has roughly the same performance cost as not using mipmaps.
     */
    NEAREST_MIPMAPS(2),
    /**
     * Linear filter for light projectors (use for non-pixel art light projectors). Isotropic
     * mipmaps are used for rendering, which means light projectors at a distance will look smooth but
     * blurry. This has roughly the same performance cost as not using mipmaps.
     */
    LINEAR_MIPMAPS(3),
    /**
     * Nearest-neighbor filter for light projectors (use for pixel art light projectors).
     * Anisotropic mipmaps are used for rendering, which means light projectors at a distance will look
     * smooth and sharp when viewed from oblique angles. This looks better compared to isotropic
     * mipmaps, but is slower. The level of anisotropic filtering is defined by
     * [ProjectSettings.rendering/textures/defaultFilters/anisotropicFilteringLevel].
     */
    NEAREST_MIPMAPS_ANISOTROPIC(4),
    /**
     * Linear filter for light projectors (use for non-pixel art light projectors). Anisotropic
     * mipmaps are used for rendering, which means light projectors at a distance will look smooth and
     * sharp when viewed from oblique angles. This looks better compared to isotropic mipmaps, but is
     * slower. The level of anisotropic filtering is defined by
     * [ProjectSettings.rendering/textures/defaultFilters/anisotropicFilteringLevel].
     */
    LINEAR_MIPMAPS_ANISOTROPIC(5),
    ;

    public companion object {
      public fun from(`value`: Long): LightProjectorFilter =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class LightType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Directional (sun/moon) light (see [DirectionalLight3D]).
     */
    DIRECTIONAL(0),
    /**
     * Omni light (see [OmniLight3D]).
     */
    OMNI(1),
    /**
     * Spot light (see [SpotLight3D]).
     */
    SPOT(2),
    /**
     * Area light (see [AreaLight3D]).
     */
    AREA(3),
    ;

    public companion object {
      public fun from(`value`: Long): LightType = entries.single { it.`value` == `value` }
    }
  }

  public enum class LightParam(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The light's energy multiplier.
     */
    ENERGY(0),
    /**
     * The light's indirect energy multiplier (final indirect energy is [LIGHT_PARAM_ENERGY] *
     * [LIGHT_PARAM_INDIRECT_ENERGY]).
     */
    INDIRECT_ENERGY(1),
    /**
     * The light's volumetric fog energy multiplier (final volumetric fog energy is
     * [LIGHT_PARAM_ENERGY] * [LIGHT_PARAM_VOLUMETRIC_FOG_ENERGY]).
     */
    VOLUMETRIC_FOG_ENERGY(2),
    /**
     * The light's influence on specularity.
     */
    SPECULAR(3),
    /**
     * The light's range.
     */
    RANGE(4),
    /**
     * The size of the light when using spot light or omni light. The angular size of the light when
     * using directional light.
     */
    SIZE(5),
    /**
     * The light's attenuation.
     */
    ATTENUATION(6),
    /**
     * The spotlight's angle.
     */
    SPOT_ANGLE(7),
    /**
     * The spotlight's attenuation.
     */
    SPOT_ATTENUATION(8),
    /**
     * The maximum distance for shadow splits. Increasing this value will make directional shadows
     * visible from further away, at the cost of lower overall shadow detail and performance (since
     * more objects need to be included in the directional shadow rendering).
     */
    SHADOW_MAX_DISTANCE(9),
    /**
     * Proportion of shadow atlas occupied by the first split.
     */
    SHADOW_SPLIT_1_OFFSET(10),
    /**
     * Proportion of shadow atlas occupied by the second split.
     */
    SHADOW_SPLIT_2_OFFSET(11),
    /**
     * Proportion of shadow atlas occupied by the third split. The fourth split occupies the rest.
     */
    SHADOW_SPLIT_3_OFFSET(12),
    /**
     * Proportion of shadow max distance where the shadow will start to fade out.
     */
    SHADOW_FADE_START(13),
    /**
     * Normal bias used to offset shadow lookup by object normal. Can be used to fix self-shadowing
     * artifacts.
     */
    SHADOW_NORMAL_BIAS(14),
    /**
     * Bias for the shadow lookup to fix self-shadowing artifacts.
     */
    SHADOW_BIAS(15),
    /**
     * Sets the size of the directional shadow pancake. The pancake offsets the start of the
     * shadow's camera frustum to provide a higher effective depth resolution for the shadow. However,
     * a high pancake size can cause artifacts in the shadows of large objects that are close to the
     * edge of the frustum. Reducing the pancake size can help. Setting the size to `0` turns off the
     * pancaking effect.
     */
    SHADOW_PANCAKE_SIZE(16),
    /**
     * The light's shadow opacity. Values lower than `1.0` make the light appear through shadows.
     * This can be used to fake global illumination at a low performance cost.
     */
    SHADOW_OPACITY(17),
    /**
     * Blurs the edges of the shadow. Can be used to hide pixel artifacts in low resolution shadow
     * maps. A high value can make shadows appear grainy and can cause other unwanted artifacts. Try to
     * keep as near default as possible.
     */
    SHADOW_BLUR(18),
    TRANSMITTANCE_BIAS(19),
    /**
     * Constant representing the intensity of the light, measured in Lumens when dealing with a
     * [SpotLight3D] or [OmniLight3D], or measured in Lux with a [DirectionalLight3D]. Only used when
     * [ProjectSettings.rendering/lightsAndShadows/usePhysicalLightUnits] is `true`.
     */
    INTENSITY(20),
    /**
     * Represents the size of the [LightParam] enum.
     */
    MAX(21),
    ;

    public companion object {
      public fun from(`value`: Long): LightParam = entries.single { it.`value` == `value` }
    }
  }

  public enum class LightBakeMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Light is ignored when baking. This is the fastest mode, but the light will be taken into
     * account when baking global illumination. This mode should generally be used for dynamic lights
     * that change quickly, as the effect of global illumination is less noticeable on those lights.
     */
    DISABLED(0),
    /**
     * Light is taken into account in static baking ([VoxelGI], [LightmapGI], SDFGI
     * ([Environment.sdfgiEnabled])). The light can be moved around or modified, but its global
     * illumination will not update in real-time. This is suitable for subtle changes (such as
     * flickering torches), but generally not large changes such as toggling a light on and off.
     */
    STATIC(1),
    /**
     * Light is taken into account in dynamic baking ([VoxelGI] and SDFGI
     * ([Environment.sdfgiEnabled]) only). The light can be moved around or modified with global
     * illumination updating in real-time. The light's global illumination appearance will be slightly
     * different compared to [LIGHT_BAKE_STATIC]. This has a greater performance cost compared to
     * [LIGHT_BAKE_STATIC]. When using SDFGI, the update speed of dynamic lights is affected by
     * [ProjectSettings.rendering/globalIllumination/sdfgi/framesToUpdateLights].
     */
    DYNAMIC(2),
    ;

    public companion object {
      public fun from(`value`: Long): LightBakeMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class LightOmniShadowMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use a dual paraboloid shadow map for omni lights.
     */
    DUAL_PARABOLOID(0),
    /**
     * Use a cubemap shadow map for omni lights. Slower but better quality than dual paraboloid.
     */
    CUBE(1),
    ;

    public companion object {
      public fun from(`value`: Long): LightOmniShadowMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class LightDirectionalShadowMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use orthogonal shadow projection for directional light.
     */
    ORTHOGONAL(0),
    /**
     * Use 2 splits for shadow projection when using directional light.
     */
    PARALLEL_2_SPLITS(1),
    /**
     * Use 4 splits for shadow projection when using directional light.
     */
    PARALLEL_4_SPLITS(2),
    ;

    public companion object {
      public fun from(`value`: Long): LightDirectionalShadowMode =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class LightDirectionalSkyMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use DirectionalLight3D in both sky rendering and scene lighting.
     */
    LIGHT_AND_SKY(0),
    /**
     * Only use DirectionalLight3D in scene lighting.
     */
    LIGHT_ONLY(1),
    /**
     * Only use DirectionalLight3D in sky rendering.
     */
    SKY_ONLY(2),
    ;

    public companion object {
      public fun from(`value`: Long): LightDirectionalSkyMode =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class ShadowQuality(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Lowest shadow filtering quality (fastest). Soft shadows are not available with this quality
     * setting, which means the [Light3D.shadowBlur] property is ignored if [Light3D.lightSize] and
     * [Light3D.lightAngularDistance] is `0.0`.
     *
     * **Note:** The variable shadow blur performed by [Light3D.lightSize] and
     * [Light3D.lightAngularDistance] is still effective when using hard shadow filtering. In this
     * case, [Light3D.shadowBlur] *is* taken into account. However, the results will not be blurred,
     * instead the blur amount is treated as a maximum radius for the penumbra.
     */
    HARD(0),
    /**
     * Very low shadow filtering quality (faster). When using this quality setting,
     * [Light3D.shadowBlur] is automatically multiplied by 0.75× to avoid introducing too much noise.
     * This division only applies to lights whose [Light3D.lightSize] or [Light3D.lightAngularDistance]
     * is `0.0`).
     */
    SOFT_VERY_LOW(1),
    /**
     * Low shadow filtering quality (fast).
     */
    SOFT_LOW(2),
    /**
     * Medium low shadow filtering quality (average).
     */
    SOFT_MEDIUM(3),
    /**
     * High low shadow filtering quality (slow). When using this quality setting,
     * [Light3D.shadowBlur] is automatically multiplied by 1.5× to better make use of the high sample
     * count. This increased blur also improves the stability of dynamic object shadows. This
     * multiplier only applies to lights whose [Light3D.lightSize] or [Light3D.lightAngularDistance] is
     * `0.0`).
     */
    SOFT_HIGH(4),
    /**
     * Highest low shadow filtering quality (slowest). When using this quality setting,
     * [Light3D.shadowBlur] is automatically multiplied by 2× to better make use of the high sample
     * count. This increased blur also improves the stability of dynamic object shadows. This
     * multiplier only applies to lights whose [Light3D.lightSize] or [Light3D.lightAngularDistance] is
     * `0.0`).
     */
    SOFT_ULTRA(5),
    /**
     * Represents the size of the [ShadowQuality] enum.
     */
    MAX(6),
    ;

    public companion object {
      public fun from(`value`: Long): ShadowQuality = entries.single { it.`value` == `value` }
    }
  }

  public enum class ReflectionProbeUpdateMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Reflection probe will update reflections once and then stop.
     */
    ONCE(0),
    /**
     * Reflection probe will update each frame. This mode is necessary to capture moving objects.
     */
    ALWAYS(1),
    ;

    public companion object {
      public fun from(`value`: Long): ReflectionProbeUpdateMode =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class ReflectionProbeAmbientMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Do not apply any ambient lighting inside the reflection probe's box defined by its size.
     */
    DISABLED(0),
    /**
     * Apply automatically-sourced environment lighting inside the reflection probe's box defined by
     * its size.
     */
    ENVIRONMENT(1),
    /**
     * Apply custom ambient lighting inside the reflection probe's box defined by its size. See
     * [reflectionProbeSetAmbientColor] and [reflectionProbeSetAmbientEnergy].
     */
    COLOR(2),
    ;

    public companion object {
      public fun from(`value`: Long): ReflectionProbeAmbientMode =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class DecalTexture(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Albedo texture slot in a decal ([Decal.textureAlbedo]).
     */
    ALBEDO(0),
    /**
     * Normal map texture slot in a decal ([Decal.textureNormal]).
     */
    NORMAL(1),
    /**
     * Occlusion/Roughness/Metallic texture slot in a decal ([Decal.textureOrm]).
     */
    ORM(2),
    /**
     * Emission texture slot in a decal ([Decal.textureEmission]).
     */
    EMISSION(3),
    /**
     * Represents the size of the [DecalTexture] enum.
     */
    MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): DecalTexture = entries.single { it.`value` == `value` }
    }
  }

  public enum class DecalFilter(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Nearest-neighbor filter for decals (use for pixel art decals). No mipmaps are used for
     * rendering, which means decals at a distance will look sharp but grainy. This has roughly the
     * same performance cost as using mipmaps.
     */
    NEAREST(0),
    /**
     * Linear filter for decals (use for non-pixel art decals). No mipmaps are used for rendering,
     * which means decals at a distance will look smooth but blurry. This has roughly the same
     * performance cost as using mipmaps.
     */
    LINEAR(1),
    /**
     * Nearest-neighbor filter for decals (use for pixel art decals). Isotropic mipmaps are used for
     * rendering, which means decals at a distance will look smooth but blurry. This has roughly the
     * same performance cost as not using mipmaps.
     */
    NEAREST_MIPMAPS(2),
    /**
     * Linear filter for decals (use for non-pixel art decals). Isotropic mipmaps are used for
     * rendering, which means decals at a distance will look smooth but blurry. This has roughly the
     * same performance cost as not using mipmaps.
     */
    LINEAR_MIPMAPS(3),
    /**
     * Nearest-neighbor filter for decals (use for pixel art decals). Anisotropic mipmaps are used
     * for rendering, which means decals at a distance will look smooth and sharp when viewed from
     * oblique angles. This looks better compared to isotropic mipmaps, but is slower. The level of
     * anisotropic filtering is defined by
     * [ProjectSettings.rendering/textures/defaultFilters/anisotropicFilteringLevel].
     */
    NEAREST_MIPMAPS_ANISOTROPIC(4),
    /**
     * Linear filter for decals (use for non-pixel art decals). Anisotropic mipmaps are used for
     * rendering, which means decals at a distance will look smooth and sharp when viewed from oblique
     * angles. This looks better compared to isotropic mipmaps, but is slower. The level of anisotropic
     * filtering is defined by
     * [ProjectSettings.rendering/textures/defaultFilters/anisotropicFilteringLevel].
     */
    LINEAR_MIPMAPS_ANISOTROPIC(5),
    ;

    public companion object {
      public fun from(`value`: Long): DecalFilter = entries.single { it.`value` == `value` }
    }
  }

  public enum class VoxelGIQuality(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Low [VoxelGI] rendering quality using 4 cones.
     */
    LOW(0),
    /**
     * High [VoxelGI] rendering quality using 6 cones.
     */
    HIGH(1),
    ;

    public companion object {
      public fun from(`value`: Long): VoxelGIQuality = entries.single { it.`value` == `value` }
    }
  }

  public enum class ParticlesMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * 2D particles.
     */
    PARTICLES_MODE_2D(0),
    /**
     * 3D particles.
     */
    PARTICLES_MODE_3D(1),
    ;

    public companion object {
      public fun from(`value`: Long): ParticlesMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class ParticlesTransformAlign(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Do not align particle transforms relative to the camera or velocity.
     */
    DISABLED(0),
    /**
     * Align each particle's Z axis to face the camera.
     */
    Z_BILLBOARD(1),
    /**
     * Align each particle's Y axis to the velocity vector.
     */
    Y_TO_VELOCITY(2),
    /**
     * Align each particle's Z axis to face the camera and Y axis to the velocity vector.
     */
    Z_BILLBOARD_Y_TO_VELOCITY(3),
    /**
     * Billboard each particles around a local axis.
     */
    LOCAL_BILLBOARD(4),
    ;

    public companion object {
      public fun from(`value`: Long): ParticlesTransformAlign =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class ParticlesTransformAlignCustomSrc(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Do not read from CUSTOM when performing billboarding.
     */
    ALIGN_CHANNEL_FILTER_DISABLED(0),
    /**
     * Read from `CUSTOM.x` when performing billboarding and use it as an angle, in radians.
     */
    ALIGN_CHANNEL_FILTER_X(1),
    /**
     * Read from `CUSTOM.y` when performing billboarding and use it as an angle, in radians.
     */
    ALIGN_CHANNEL_FILTER_Y(2),
    /**
     * Read from `CUSTOM.z` when performing billboarding and use it as an angle, in radians.
     */
    ALIGN_CHANNEL_FILTER_Z(3),
    /**
     * Read from `CUSTOM.w` when performing billboarding and use it as an angle, in radians.
     */
    ALIGN_CHANNEL_FILTER_W(4),
    ;

    public companion object {
      public fun from(`value`: Long): ParticlesTransformAlignCustomSrc =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class ParticlesTransformAlignAxis(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use the X axis for local billboarding.
     */
    ALIGN_AXIS_X(0),
    /**
     * Use the Y axis for local billboarding.
     */
    ALIGN_AXIS_Y(1),
    ;

    public companion object {
      public fun from(`value`: Long): ParticlesTransformAlignAxis =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class ParticlesDrawOrder(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Draw particles in the order that they appear in the particles array.
     */
    INDEX(0),
    /**
     * Sort particles based on their lifetime. In other words, the particle with the highest
     * lifetime is drawn at the front.
     */
    LIFETIME(1),
    /**
     * Sort particles based on the inverse of their lifetime. In other words, the particle with the
     * lowest lifetime is drawn at the front.
     */
    REVERSE_LIFETIME(2),
    /**
     * Sort particles based on their distance to the camera.
     */
    VIEW_DEPTH(3),
    ;

    public companion object {
      public fun from(`value`: Long): ParticlesDrawOrder = entries.single { it.`value` == `value` }
    }
  }

  public enum class ParticlesCollisionType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Sphere attractor type for [GPUParticles3D] (see [GPUParticlesAttractorSphere3D]).
     */
    SPHERE_ATTRACT(0),
    /**
     * Box attractor type for [GPUParticles3D] (see [GPUParticlesAttractorBox3D]).
     */
    BOX_ATTRACT(1),
    /**
     * Vector field attractor type for [GPUParticles3D] (see [GPUParticlesAttractorVectorField3D]).
     */
    VECTOR_FIELD_ATTRACT(2),
    /**
     * Sphere collision type for [GPUParticles3D] (see [GPUParticlesCollisionSphere3D]).
     */
    SPHERE_COLLIDE(3),
    /**
     * Box collision type for [GPUParticles3D] (see [GPUParticlesCollisionBox3D]).
     */
    BOX_COLLIDE(4),
    /**
     * Signed distance field collision type for [GPUParticles3D] (see [GPUParticlesCollisionSDF3D]).
     */
    SDF_COLLIDE(5),
    /**
     * Heightfield collision type for [GPUParticles3D] (see [GPUParticlesCollisionHeightField3D]).
     */
    HEIGHTFIELD_COLLIDE(6),
    ;

    public companion object {
      public fun from(`value`: Long): ParticlesCollisionType =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class ParticlesCollisionHeightfieldResolution(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * 256×256 heightfield resolution for [GPUParticlesCollisionHeightField3D].
     */
    PARTICLES_COLLISION_HEIGHTFIELD_RESOLUTION_256(0),
    /**
     * 512×512 heightfield resolution for [GPUParticlesCollisionHeightField3D].
     */
    PARTICLES_COLLISION_HEIGHTFIELD_RESOLUTION_512(1),
    /**
     * 1024×1024 heightfield resolution for [GPUParticlesCollisionHeightField3D].
     */
    PARTICLES_COLLISION_HEIGHTFIELD_RESOLUTION_1024(2),
    /**
     * 2048×2048 heightfield resolution for [GPUParticlesCollisionHeightField3D].
     */
    PARTICLES_COLLISION_HEIGHTFIELD_RESOLUTION_2048(3),
    /**
     * 4096×4096 heightfield resolution for [GPUParticlesCollisionHeightField3D].
     */
    PARTICLES_COLLISION_HEIGHTFIELD_RESOLUTION_4096(4),
    /**
     * 8192×8192 heightfield resolution for [GPUParticlesCollisionHeightField3D].
     */
    PARTICLES_COLLISION_HEIGHTFIELD_RESOLUTION_8192(5),
    /**
     * Represents the size of the [ParticlesCollisionHeightfieldResolution] enum.
     */
    MAX(6),
    ;

    public companion object {
      public fun from(`value`: Long): ParticlesCollisionHeightfieldResolution =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class FogVolumeShape(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * [FogVolume] will be shaped like an ellipsoid (stretched sphere).
     */
    ELLIPSOID(0),
    /**
     * [FogVolume] will be shaped like a cone pointing upwards (in local coordinates). The cone's
     * angle is set automatically to fill the size. The cone will be adjusted to fit within the size.
     * Rotate the [FogVolume] node to reorient the cone. Non-uniform scaling via size is not supported
     * (scale the [FogVolume] node instead).
     */
    CONE(1),
    /**
     * [FogVolume] will be shaped like an upright cylinder (in local coordinates). Rotate the
     * [FogVolume] node to reorient the cylinder. The cylinder will be adjusted to fit within the size.
     * Non-uniform scaling via size is not supported (scale the [FogVolume] node instead).
     */
    CYLINDER(2),
    /**
     * [FogVolume] will be shaped like a box.
     */
    BOX(3),
    /**
     * [FogVolume] will have no shape, will cover the whole world and will not be culled.
     */
    WORLD(4),
    /**
     * Represents the size of the [FogVolumeShape] enum.
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): FogVolumeShape = entries.single { it.`value` == `value` }
    }
  }

  public enum class ViewportScaling3DMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use bilinear scaling for the viewport's 3D buffer. The amount of scaling can be set using
     * [Viewport.scaling3dScale]. Values less than `1.0` will result in undersampling while values
     * greater than `1.0` will result in supersampling. A value of `1.0` disables scaling.
     */
    VIEWPORT_SCALING_3D_MODE_BILINEAR(0),
    /**
     * Use AMD FidelityFX Super Resolution 1.0 upscaling for the viewport's 3D buffer. The amount of
     * scaling can be set using [Viewport.scaling3dScale]. Values less than `1.0` will result in the
     * viewport being upscaled using FSR. Values greater than `1.0` are not supported and bilinear
     * downsampling will be used instead. A value of `1.0` disables scaling.
     */
    VIEWPORT_SCALING_3D_MODE_FSR(1),
    /**
     * Use AMD FidelityFX Super Resolution 2.2 upscaling for the viewport's 3D buffer. The amount of
     * scaling can be set using [Viewport.scaling3dScale]. Values less than `1.0` will result in the
     * viewport being upscaled using FSR2. Values greater than `1.0` are not supported and bilinear
     * downsampling will be used instead. A value of `1.0` will use FSR2 at native resolution as a TAA
     * solution.
     */
    VIEWPORT_SCALING_3D_MODE_FSR2(2),
    /**
     * Use MetalFX spatial upscaling for the viewport's 3D buffer. The amount of scaling can be set
     * using [Viewport.scaling3dScale]. Values less than `1.0` will result in the viewport being
     * upscaled using MetalFX. Values greater than `1.0` are not supported and bilinear downsampling
     * will be used instead. A value of `1.0` disables scaling.
     *
     * **Note:** Only supported when the Metal rendering driver is in use, which limits this scaling
     * mode to macOS and iOS.
     */
    VIEWPORT_SCALING_3D_MODE_METALFX_SPATIAL(3),
    /**
     * Use MetalFX temporal upscaling for the viewport's 3D buffer. The amount of scaling can be set
     * using [Viewport.scaling3dScale]. Values less than `1.0` will result in the viewport being
     * upscaled using MetalFX. Values greater than `1.0` are not supported and bilinear downsampling
     * will be used instead. A value of `1.0` will use MetalFX at native resolution as a TAA solution.
     *
     * **Note:** Only supported when the Metal rendering driver is in use, which limits this scaling
     * mode to macOS and iOS.
     */
    VIEWPORT_SCALING_3D_MODE_METALFX_TEMPORAL(4),
    /**
     * Use nearest-neighbor filtering for the viewport's 3D buffer. This looks crisper than
     * [VIEWPORT_SCALING_3D_MODE_BILINEAR] and has no additional rendering cost. The amount of scaling
     * can be set using [Viewport.scaling3dScale]. Values greater than `1.0` are not supported and
     * bilinear downsampling will be used instead. A value of `1.0` disables scaling.
     *
     * **Note:** When using the **Nearest** scaling mode, to avoid uneven pixel scaling, it's highly
     * recommended to use a value equal to an integer divisor with a dividend of `1`. For example, it's
     * best to use a scale of `0.5` (1/2), `0.3333` (1/3), `0.25` (1/4), `0.2` (1/5), and so on.
     */
    VIEWPORT_SCALING_3D_MODE_NEAREST(5),
    /**
     * Represents the size of the [ViewportScaling3DMode] enum.
     */
    VIEWPORT_SCALING_3D_MODE_MAX(6),
    ;

    public companion object {
      public fun from(`value`: Long): ViewportScaling3DMode =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class ViewportUpdateMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Do not update the viewport's render target.
     */
    DISABLED(0),
    /**
     * Update the viewport's render target once, then switch to [VIEWPORT_UPDATE_DISABLED].
     */
    ONCE(1),
    /**
     * Update the viewport's render target only when it is visible. This is the default value.
     */
    WHEN_VISIBLE(2),
    /**
     * Update the viewport's render target only when its parent is visible.
     */
    WHEN_PARENT_VISIBLE(3),
    /**
     * Always update the viewport's render target.
     */
    ALWAYS(4),
    ;

    public companion object {
      public fun from(`value`: Long): ViewportUpdateMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class ViewportClearMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Always clear the viewport's render target before drawing.
     */
    ALWAYS(0),
    /**
     * Never clear the viewport's render target.
     */
    NEVER(1),
    /**
     * Clear the viewport's render target on the next frame, then switch to [VIEWPORT_CLEAR_NEVER].
     */
    ONLY_NEXT_FRAME(2),
    ;

    public companion object {
      public fun from(`value`: Long): ViewportClearMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class ViewportEnvironmentMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Disable rendering of 3D environment over 2D canvas.
     */
    DISABLED(0),
    /**
     * Enable rendering of 3D environment over 2D canvas.
     */
    ENABLED(1),
    /**
     * Inherit enable/disable value from parent. If the topmost parent is also set to
     * [VIEWPORT_ENVIRONMENT_INHERIT], then this has the same behavior as
     * [VIEWPORT_ENVIRONMENT_ENABLED].
     */
    INHERIT(2),
    /**
     * Represents the size of the [ViewportEnvironmentMode] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): ViewportEnvironmentMode =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class ViewportSDFOversize(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Do not oversize the 2D signed distance field. Occluders may disappear when touching the
     * viewport's edges, and [GPUParticles3D] collision may stop working earlier than intended. This
     * has the lowest GPU requirements.
     */
    VIEWPORT_SDF_OVERSIZE_100_PERCENT(0),
    /**
     * 2D signed distance field covers 20&#37; of the viewport's size outside the viewport on each
     * side (top, right, bottom, left).
     */
    VIEWPORT_SDF_OVERSIZE_120_PERCENT(1),
    /**
     * 2D signed distance field covers 50&#37; of the viewport's size outside the viewport on each
     * side (top, right, bottom, left).
     */
    VIEWPORT_SDF_OVERSIZE_150_PERCENT(2),
    /**
     * 2D signed distance field covers 100&#37; of the viewport's size outside the viewport on each
     * side (top, right, bottom, left). This has the highest GPU requirements.
     */
    VIEWPORT_SDF_OVERSIZE_200_PERCENT(3),
    /**
     * Represents the size of the [ViewportSDFOversize] enum.
     */
    MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): ViewportSDFOversize = entries.single { it.`value` == `value` }
    }
  }

  public enum class ViewportSDFScale(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Full resolution 2D signed distance field scale. This has the highest GPU requirements.
     */
    VIEWPORT_SDF_SCALE_100_PERCENT(0),
    /**
     * Half resolution 2D signed distance field scale on each axis (25&#37; of the viewport pixel
     * count).
     */
    VIEWPORT_SDF_SCALE_50_PERCENT(1),
    /**
     * Quarter resolution 2D signed distance field scale on each axis (6.25&#37; of the viewport
     * pixel count). This has the lowest GPU requirements.
     */
    VIEWPORT_SDF_SCALE_25_PERCENT(2),
    /**
     * Represents the size of the [ViewportSDFScale] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): ViewportSDFScale = entries.single { it.`value` == `value` }
    }
  }

  public enum class ViewportMSAA(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Multisample antialiasing for 3D is disabled. This is the default value, and also the fastest
     * setting.
     */
    DISABLED(0),
    /**
     * Multisample antialiasing uses 2 samples per pixel for 3D. This has a moderate impact on
     * performance.
     */
    VIEWPORT_MSAA_2X(1),
    /**
     * Multisample antialiasing uses 4 samples per pixel for 3D. This has a high impact on
     * performance.
     */
    VIEWPORT_MSAA_4X(2),
    /**
     * Multisample antialiasing uses 8 samples per pixel for 3D. This has a very high impact on
     * performance. Likely unsupported on low-end and older hardware.
     */
    VIEWPORT_MSAA_8X(3),
    /**
     * Represents the size of the [ViewportMSAA] enum.
     */
    MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): ViewportMSAA = entries.single { it.`value` == `value` }
    }
  }

  public enum class ViewportAnisotropicFiltering(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Anisotropic filtering is disabled.
     */
    ANISOTROPY_DISABLED(0),
    /**
     * Use 2× anisotropic filtering.
     */
    ANISOTROPY_2X(1),
    /**
     * Use 4× anisotropic filtering. This is the default value.
     */
    ANISOTROPY_4X(2),
    /**
     * Use 8× anisotropic filtering.
     */
    ANISOTROPY_8X(3),
    /**
     * Use 16× anisotropic filtering.
     */
    ANISOTROPY_16X(4),
    /**
     * Represents the size of the [ViewportAnisotropicFiltering] enum.
     */
    ANISOTROPY_MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): ViewportAnisotropicFiltering =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class ViewportScreenSpaceAA(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Do not perform any antialiasing in the full screen post-process.
     */
    DISABLED(0),
    /**
     * Use fast approximate antialiasing. FXAA is a popular screen-space antialiasing method, which
     * is fast but will make the image look blurry, especially at lower resolutions. It can still work
     * relatively well at large resolutions such as 1440p and 4K.
     */
    FXAA(1),
    /**
     * Use subpixel morphological antialiasing. SMAA may produce clearer results than FXAA, but at a
     * slightly higher performance cost.
     */
    SMAA(2),
    /**
     * Represents the size of the [ViewportScreenSpaceAA] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): ViewportScreenSpaceAA =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class ViewportOcclusionCullingBuildQuality(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Low occlusion culling BVH build quality (as defined by Embree). Results in the lowest CPU
     * usage, but least effective culling.
     */
    BUILD_QUALITY_LOW(0),
    /**
     * Medium occlusion culling BVH build quality (as defined by Embree).
     */
    BUILD_QUALITY_MEDIUM(1),
    /**
     * High occlusion culling BVH build quality (as defined by Embree). Results in the highest CPU
     * usage, but most effective culling.
     */
    BUILD_QUALITY_HIGH(2),
    ;

    public companion object {
      public fun from(`value`: Long): ViewportOcclusionCullingBuildQuality =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class ViewportRenderInfo(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Number of objects drawn in a single frame.
     */
    OBJECTS_IN_FRAME(0),
    /**
     * Number of points, lines, or triangles drawn in a single frame.
     */
    PRIMITIVES_IN_FRAME(1),
    /**
     * Number of draw calls during this frame.
     */
    DRAW_CALLS_IN_FRAME(2),
    /**
     * Represents the size of the [ViewportRenderInfo] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): ViewportRenderInfo = entries.single { it.`value` == `value` }
    }
  }

  public enum class ViewportRenderInfoType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Visible render pass (excluding shadows).
     */
    VISIBLE(0),
    /**
     * Shadow render pass. Objects will be rendered several times depending on the number of amounts
     * of lights with shadows and the number of directional shadow splits.
     */
    SHADOW(1),
    /**
     * Canvas item rendering. This includes all 2D rendering.
     */
    CANVAS(2),
    /**
     * Represents the size of the [ViewportRenderInfoType] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): ViewportRenderInfoType =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class ViewportDebugDraw(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Debug draw is disabled. Default setting.
     */
    DISABLED(0),
    /**
     * Objects are displayed without light information.
     */
    UNSHADED(1),
    /**
     * Objects are displayed with only light information.
     *
     * **Note:** When using this debug draw mode, custom shaders are ignored since all materials in
     * the scene temporarily use a debug material. This means the result from custom shader functions
     * (such as vertex displacement) won't be visible anymore when using this debug draw mode.
     */
    LIGHTING(2),
    /**
     * Objects are displayed semi-transparent with additive blending so you can see where they are
     * drawing over top of one another. A higher overdraw (represented by brighter colors) means you
     * are wasting performance on drawing pixels that are being hidden behind others.
     *
     * **Note:** When using this debug draw mode, custom shaders are ignored since all materials in
     * the scene temporarily use a debug material. This means the result from custom shader functions
     * (such as vertex displacement) won't be visible anymore when using this debug draw mode.
     */
    OVERDRAW(3),
    /**
     * Debug draw draws objects in wireframe.
     *
     * **Note:** [setDebugGenerateWireframes] must be called before loading any meshes for
     * wireframes to be visible when using the Compatibility renderer.
     *
     * **Note:** In the Compatibility renderer, backfaces are always visible when using wireframe
     * rendering. In the Forward+ and Mobile renderers, wireframes follow the material's backface
     * culling properties instead.
     */
    WIREFRAME(4),
    /**
     * Normal buffer is drawn instead of regular scene so you can see the per-pixel normals that
     * will be used by post-processing effects.
     */
    NORMAL_BUFFER(5),
    /**
     * Objects are displayed with only the albedo value from [VoxelGI]s. Requires at least one
     * visible [VoxelGI] node that has been baked to have a visible effect.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    VOXEL_GI_ALBEDO(6),
    /**
     * Objects are displayed with only the lighting value from [VoxelGI]s. Requires at least one
     * visible [VoxelGI] node that has been baked to have a visible effect.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    VOXEL_GI_LIGHTING(7),
    /**
     * Objects are displayed with only the emission color from [VoxelGI]s. Requires at least one
     * visible [VoxelGI] node that has been baked to have a visible effect.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    VOXEL_GI_EMISSION(8),
    /**
     * Draws the shadow atlas that stores shadows from [OmniLight3D]s and [SpotLight3D]s in the
     * upper left quadrant of the [Viewport].
     */
    SHADOW_ATLAS(9),
    /**
     * Draws the shadow atlas that stores shadows from [DirectionalLight3D]s in the upper left
     * quadrant of the [Viewport].
     *
     * The slice of the camera frustum related to the shadow map cascade is superimposed to
     * visualize coverage. The color of each slice matches the colors used for
     * [VIEWPORT_DEBUG_DRAW_PSSM_SPLITS]. When shadow cascades are blended the overlap is taken into
     * account when drawing the frustum slices.
     *
     * The last cascade shows all frustum slices to illustrate the coverage of all slices.
     */
    DIRECTIONAL_SHADOW_ATLAS(10),
    /**
     * Draws the estimated scene luminance. This is a 1×1 texture that is generated when
     * autoexposure is enabled to control the scene's exposure.
     *
     * **Note:** Only supported when using the Forward+ or Mobile rendering methods.
     */
    SCENE_LUMINANCE(11),
    /**
     * Draws the screen space ambient occlusion texture instead of the scene so that you can clearly
     * see how it is affecting objects. In order for this display mode to work, you must have
     * [Environment.ssaoEnabled] set in your [WorldEnvironment].
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    SSAO(12),
    /**
     * Draws the screen space indirect lighting texture instead of the scene so that you can clearly
     * see how it is affecting objects. In order for this display mode to work, you must have
     * [Environment.ssilEnabled] set in your [WorldEnvironment].
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    SSIL(13),
    /**
     * Colors each PSSM split for the [DirectionalLight3D]s in the scene a different color so you
     * can see where the splits are. In order (from closest to furthest from the camera), they are
     * colored red, green, blue, and yellow.
     *
     * **Note:** When using this debug draw mode, custom shaders are ignored since all materials in
     * the scene temporarily use a debug material. This means the result from custom shader functions
     * (such as vertex displacement) won't be visible anymore when using this debug draw mode.
     *
     * **Note:** Only supported when using the Forward+ or Mobile rendering methods.
     */
    PSSM_SPLITS(14),
    /**
     * Draws the decal atlas that stores decal textures from [Decal]s.
     *
     * **Note:** Only supported when using the Forward+ or Mobile rendering methods.
     */
    DECAL_ATLAS(15),
    /**
     * Draws SDFGI cascade data. This is the data structure that is used to bounce lighting against
     * and create reflections.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    SDFGI(16),
    /**
     * Draws SDFGI probe data. This is the data structure that is used to give indirect lighting
     * dynamic objects moving within the scene.
     *
     * When in the editor, left-clicking a probe will display additional bright dots that show its
     * occlusion information. A white dot means the light is not occluded at all at the dot's position,
     * while a red dot means the light is fully occluded. Intermediate values are possible.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    SDFGI_PROBES(17),
    /**
     * Draws the global illumination buffer from [VoxelGI] or SDFGI. Requires [VoxelGI] (at least
     * one visible baked VoxelGI node) or SDFGI ([Environment.sdfgiEnabled]) to be enabled to have a
     * visible effect.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    GI_BUFFER(18),
    /**
     * Disable mesh LOD. All meshes are drawn with full detail, which can be used to compare
     * performance.
     */
    DISABLE_LOD(19),
    /**
     * Draws the [OmniLight3D] cluster. Clustering determines where lights are positioned in
     * screen-space, which allows the engine to only process these portions of the screen for lighting.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    CLUSTER_OMNI_LIGHTS(20),
    /**
     * Draws the [SpotLight3D] cluster. Clustering determines where lights are positioned in
     * screen-space, which allows the engine to only process these portions of the screen for lighting.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    CLUSTER_SPOT_LIGHTS(21),
    /**
     * Draws the [Decal] cluster. Clustering determines where decals are positioned in screen-space,
     * which allows the engine to only process these portions of the screen for decals.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    CLUSTER_DECALS(22),
    /**
     * Draws the [ReflectionProbe] cluster. Clustering determines where reflection probes are
     * positioned in screen-space, which allows the engine to only process these portions of the screen
     * for reflection probes.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    CLUSTER_REFLECTION_PROBES(23),
    /**
     * Draws the occlusion culling buffer. This low-resolution occlusion culling buffer is
     * rasterized on the CPU and is used to check whether instances are occluded by other objects.
     *
     * **Note:** Only supported when using the Forward+ or Mobile rendering methods.
     */
    OCCLUDERS(24),
    /**
     * Draws the motion vectors buffer. This is used by temporal antialiasing to correct for motion
     * that occurs during gameplay.
     *
     * **Note:** Only supported when using the Forward+ rendering method.
     */
    MOTION_VECTORS(25),
    /**
     * Internal buffer is drawn instead of regular scene so you can see the per-pixel output that
     * will be used by post-processing effects.
     *
     * **Note:** Only supported when using the Forward+ or Mobile rendering methods.
     */
    INTERNAL_BUFFER(26),
    ;

    public companion object {
      public fun from(`value`: Long): ViewportDebugDraw = entries.single { it.`value` == `value` }
    }
  }

  public enum class ViewportVRSMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Variable rate shading is disabled.
     */
    DISABLED(0),
    /**
     * Variable rate shading uses a texture. Note, for stereoscopic use a texture atlas with a
     * texture for each view.
     */
    TEXTURE(1),
    /**
     * Variable rate shading texture is supplied by the primary [XRInterface]. Note that this may
     * override the update mode.
     */
    XR(2),
    /**
     * Represents the size of the [ViewportVRSMode] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): ViewportVRSMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class ViewportVRSUpdateMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The input texture for variable rate shading will not be processed.
     */
    DISABLED(0),
    /**
     * The input texture for variable rate shading will be processed once.
     */
    ONCE(1),
    /**
     * The input texture for variable rate shading will be processed each frame.
     */
    ALWAYS(2),
    /**
     * Represents the size of the [ViewportVRSUpdateMode] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): ViewportVRSUpdateMode =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class SkyMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Automatically selects the appropriate process mode based on your sky shader. If your shader
     * uses `TIME` or `POSITION`, this will use [SKY_MODE_REALTIME]. If your shader uses any of the
     * `LIGHT_*` variables or any custom uniforms, this uses [SKY_MODE_INCREMENTAL]. Otherwise, this
     * defaults to [SKY_MODE_QUALITY].
     */
    AUTOMATIC(0),
    /**
     * Uses high quality importance sampling to process the radiance map. In general, this results
     * in much higher quality than [SKY_MODE_REALTIME] but takes much longer to generate. This should
     * not be used if you plan on changing the sky at runtime. If you are finding that the reflection
     * is not blurry enough and is showing sparkles or fireflies, try increasing
     * [ProjectSettings.rendering/reflections/skyReflections/ggxSamples].
     */
    QUALITY(1),
    /**
     * Uses the same high quality importance sampling to process the radiance map as
     * [SKY_MODE_QUALITY], but updates over several frames. The number of frames is determined by
     * [ProjectSettings.rendering/reflections/skyReflections/roughnessLayers]. Use this when you need
     * highest quality radiance maps, but have a sky that updates slowly.
     */
    INCREMENTAL(2),
    /**
     * Uses the fast filtering algorithm to process the radiance map. In general this results in
     * lower quality, but substantially faster run times. If you need better quality, but still need to
     * update the sky every frame, consider turning on
     * [ProjectSettings.rendering/reflections/skyReflections/fastFilterHighQuality].
     *
     * **Note:** The fast filtering algorithm is limited to 256×256 cubemaps, so
     * [skySetRadianceSize] must be set to `256`. Otherwise, a warning is printed and the overridden
     * radiance size is ignored.
     */
    REALTIME(3),
    ;

    public companion object {
      public fun from(`value`: Long): SkyMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class CompositorEffectFlags(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The rendering effect requires the color buffer to be resolved if MSAA is enabled.
     */
    ACCESS_RESOLVED_COLOR(1),
    /**
     * The rendering effect requires the depth buffer to be resolved if MSAA is enabled.
     */
    ACCESS_RESOLVED_DEPTH(2),
    /**
     * The rendering effect requires motion vectors to be produced.
     */
    NEEDS_MOTION_VECTORS(4),
    /**
     * The rendering effect requires normals and roughness g-buffer to be produced (Forward+ only).
     */
    NEEDS_ROUGHNESS(8),
    /**
     * The rendering effect requires specular data to be separated out (Forward+ only).
     */
    NEEDS_SEPARATE_SPECULAR(16),
    ;

    public companion object {
      public fun from(`value`: Long): CompositorEffectFlags =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class CompositorEffectCallbackType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The callback is called before our opaque rendering pass, but after depth prepass (if
     * applicable).
     */
    PRE_OPAQUE(0),
    /**
     * The callback is called after our opaque rendering pass, but before our sky is rendered.
     */
    POST_OPAQUE(1),
    /**
     * The callback is called after our sky is rendered, but before our back buffers are created
     * (and if enabled, before subsurface scattering and/or screen space reflections).
     */
    POST_SKY(2),
    /**
     * The callback is called before our transparent rendering pass, but after our sky is rendered
     * and we've created our back buffers.
     */
    PRE_TRANSPARENT(3),
    /**
     * The callback is called after our transparent rendering pass, but before any built-in
     * post-processing effects and output to our render target.
     */
    POST_TRANSPARENT(4),
    ANY(-1),
    ;

    public companion object {
      public fun from(`value`: Long): CompositorEffectCallbackType =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class EnvironmentBG(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use the clear color as background.
     */
    CLEAR_COLOR(0),
    /**
     * Use a specified color as the background.
     */
    COLOR(1),
    /**
     * Use a sky resource for the background.
     */
    SKY(2),
    /**
     * Use a specified canvas layer as the background. This can be useful for instantiating a 2D
     * scene in a 3D world.
     */
    CANVAS(3),
    /**
     * Do not clear the background, use whatever was rendered last frame as the background.
     */
    KEEP(4),
    /**
     * Displays a camera feed in the background.
     */
    CAMERA_FEED(5),
    /**
     * Represents the size of the [EnvironmentBG] enum.
     */
    MAX(6),
    ;

    public companion object {
      public fun from(`value`: Long): EnvironmentBG = entries.single { it.`value` == `value` }
    }
  }

  public enum class EnvironmentAmbientSource(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Gather ambient light from whichever source is specified as the background.
     */
    BG(0),
    /**
     * Disable ambient light.
     */
    DISABLED(1),
    /**
     * Specify a specific [Color] for ambient light.
     */
    COLOR(2),
    /**
     * Gather ambient light from the [Sky] regardless of what the background is.
     */
    SKY(3),
    ;

    public companion object {
      public fun from(`value`: Long): EnvironmentAmbientSource =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class EnvironmentReflectionSource(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use the background for reflections.
     */
    BG(0),
    /**
     * Disable reflections.
     */
    DISABLED(1),
    /**
     * Use the [Sky] for reflections regardless of what the background is.
     */
    SKY(2),
    ;

    public companion object {
      public fun from(`value`: Long): EnvironmentReflectionSource =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class EnvironmentGlowBlendMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Adds the glow effect to the scene.
     */
    ADDITIVE(0),
    /**
     * Adds the glow effect to the scene after modifying the glow influence based on the scene
     * value; dark values will be highly influenced by glow and bright values will not be influenced by
     * glow. This approach avoids bright values becoming overly bright from the glow effect.
     * [Environment.tonemapWhite] is used to determine the maximum scene value where the glow should
     * have no influence. When [Environment.tonemapMode] is set to [Environment.TONE_MAPPER_LINEAR] and
     * [Viewport.useHdr2d] is `true`, the parent window's [Window.getOutputMaxLinearValue] will be used
     * as the maximum scene value.
     */
    SCREEN(1),
    /**
     * Adds the glow effect to the tonemapped image after modifying the glow influence based on the
     * image value; dark values and bright values will not be influenced by glow and mid-range values
     * will be highly influenced by glow. This approach avoids bright values becoming overly bright
     * from the glow effect. The glow will have the largest influence on image values of `0.25` and
     * will have no influence when applied to image values greater than `1.0`.
     *
     * **Note:** This blend mode does not support HDR output because expects a maximum output value
     * of `1.0`. It is recommended to use a different blend mode when rendering to an HDR screen.
     */
    SOFTLIGHT(2),
    /**
     * Replaces all pixels' color by the glow effect. This can be used to simulate a full-screen
     * blur effect by tweaking the glow parameters to match the original image's brightness or to
     * preview glow configuration in the editor.
     */
    REPLACE(3),
    /**
     * Mixes the glow image with the scene image. Best used with [Environment.glowBloom] to avoid
     * darkening the scene.
     */
    MIX(4),
    ;

    public companion object {
      public fun from(`value`: Long): EnvironmentGlowBlendMode =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class EnvironmentFogMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use a physically-based fog model defined primarily by fog density.
     */
    EXPONENTIAL(0),
    /**
     * Use a simple fog model defined by start and end positions and a custom curve. While not
     * physically accurate, this model can be useful when you need more artistic control.
     */
    DEPTH(1),
    ;

    public companion object {
      public fun from(`value`: Long): EnvironmentFogMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class EnvironmentToneMapper(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Does not modify color data, resulting in a linear tonemapping curve which unnaturally clips
     * bright values, causing bright lighting to look blown out. The simplest and fastest tonemapper.
     */
    LINEAR(0),
    /**
     * A simple tonemapping curve that rolls off bright values to prevent clipping. This results in
     * an image that can appear dull and low contrast. Slower than [ENV_TONE_MAPPER_LINEAR].
     *
     * **Note:** When [Environment.tonemapWhite] is left at the default value of `1.0`,
     * [ENV_TONE_MAPPER_REINHARD] produces an identical image to [ENV_TONE_MAPPER_LINEAR].
     */
    REINHARD(1),
    /**
     * Uses a film-like tonemapping curve to prevent clipping of bright values and provide better
     * contrast than [ENV_TONE_MAPPER_REINHARD]. Slightly slower than [ENV_TONE_MAPPER_REINHARD].
     *
     * **Note:** This tonemapper does not support HDR output because it produces output in the SDR
     * range. It is recommended to use a different tonemapper when rendering to an HDR screen.
     */
    FILMIC(2),
    /**
     * Uses a high-contrast film-like tonemapping curve and desaturates bright values for a more
     * realistic appearance. Slightly slower than [ENV_TONE_MAPPER_FILMIC].
     *
     * **Note:** This tonemapping operator is called "ACES Fitted" in Godot 3.x.
     *
     * **Note:** This tonemapper does not support HDR output because it produces output in the SDR
     * range. It is recommended to use a different tonemapper when rendering to an HDR screen.
     */
    ACES(3),
    /**
     * Uses an adjustable film-like tonemapping curve and desaturates bright values for a more
     * realistic appearance. Better than other tonemappers at maintaining the hue of colors as they
     * become brighter. The slowest tonemapping option.
     */
    AGX(4),
    ;

    public companion object {
      public fun from(`value`: Long): EnvironmentToneMapper =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class EnvironmentSSRRoughnessQuality(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Lowest quality of roughness filter for screen-space reflections. Rough materials will not
     * have blurrier screen-space reflections compared to smooth (non-rough) materials. This is the
     * fastest option.
     */
    DISABLED(0),
    /**
     * Low quality of roughness filter for screen-space reflections.
     */
    LOW(1),
    /**
     * Medium quality of roughness filter for screen-space reflections.
     */
    MEDIUM(2),
    /**
     * High quality of roughness filter for screen-space reflections. This is the slowest option.
     */
    HIGH(3),
    ;

    public companion object {
      public fun from(`value`: Long): EnvironmentSSRRoughnessQuality =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class EnvironmentSSAOQuality(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Lowest quality of screen-space ambient occlusion.
     */
    VERY_LOW(0),
    /**
     * Low quality screen-space ambient occlusion.
     */
    LOW(1),
    /**
     * Medium quality screen-space ambient occlusion.
     */
    MEDIUM(2),
    /**
     * High quality screen-space ambient occlusion.
     */
    HIGH(3),
    /**
     * Highest quality screen-space ambient occlusion. Uses the adaptive target setting which can be
     * dynamically adjusted to smoothly balance performance and visual quality.
     */
    ULTRA(4),
    ;

    public companion object {
      public fun from(`value`: Long): EnvironmentSSAOQuality =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class EnvironmentSSILQuality(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Lowest quality of screen-space indirect lighting.
     */
    VERY_LOW(0),
    /**
     * Low quality screen-space indirect lighting.
     */
    LOW(1),
    /**
     * High quality screen-space indirect lighting.
     */
    MEDIUM(2),
    /**
     * High quality screen-space indirect lighting.
     */
    HIGH(3),
    /**
     * Highest quality screen-space indirect lighting. Uses the adaptive target setting which can be
     * dynamically adjusted to smoothly balance performance and visual quality.
     */
    ULTRA(4),
    ;

    public companion object {
      public fun from(`value`: Long): EnvironmentSSILQuality =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class EnvironmentSDFGIYScale(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use 50&#37; scale for SDFGI on the Y (vertical) axis. SDFGI cells will be twice as short as
     * they are wide. This allows providing increased GI detail and reduced light leaking with thin
     * floors and ceilings. This is usually the best choice for scenes that don't feature much
     * verticality.
     */
    Y_SCALE_50_PERCENT(0),
    /**
     * Use 75&#37; scale for SDFGI on the Y (vertical) axis. This is a balance between the 50&#37;
     * and 100&#37; SDFGI Y scales.
     */
    Y_SCALE_75_PERCENT(1),
    /**
     * Use 100&#37; scale for SDFGI on the Y (vertical) axis. SDFGI cells will be as tall as they
     * are wide. This is usually the best choice for highly vertical scenes. The downside is that light
     * leaking may become more noticeable with thin floors and ceilings.
     */
    Y_SCALE_100_PERCENT(2),
    ;

    public companion object {
      public fun from(`value`: Long): EnvironmentSDFGIYScale =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class EnvironmentSDFGIRayCount(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Throw 4 rays per frame when converging SDFGI. This has the lowest GPU requirements, but
     * creates the most noisy result.
     */
    ENV_SDFGI_RAY_COUNT_4(0),
    /**
     * Throw 8 rays per frame when converging SDFGI.
     */
    ENV_SDFGI_RAY_COUNT_8(1),
    /**
     * Throw 16 rays per frame when converging SDFGI.
     */
    ENV_SDFGI_RAY_COUNT_16(2),
    /**
     * Throw 32 rays per frame when converging SDFGI.
     */
    ENV_SDFGI_RAY_COUNT_32(3),
    /**
     * Throw 64 rays per frame when converging SDFGI.
     */
    ENV_SDFGI_RAY_COUNT_64(4),
    /**
     * Throw 96 rays per frame when converging SDFGI. This has high GPU requirements.
     */
    ENV_SDFGI_RAY_COUNT_96(5),
    /**
     * Throw 128 rays per frame when converging SDFGI. This has very high GPU requirements, but
     * creates the least noisy result.
     */
    ENV_SDFGI_RAY_COUNT_128(6),
    /**
     * Represents the size of the [EnvironmentSDFGIRayCount] enum.
     */
    MAX(7),
    ;

    public companion object {
      public fun from(`value`: Long): EnvironmentSDFGIRayCount =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class EnvironmentSDFGIFramesToConverge(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Converge SDFGI over 5 frames. This is the most responsive, but creates the most noisy result
     * with a given ray count.
     */
    CONVERGE_IN_5_FRAMES(0),
    /**
     * Configure SDFGI to fully converge over 10 frames.
     */
    CONVERGE_IN_10_FRAMES(1),
    /**
     * Configure SDFGI to fully converge over 15 frames.
     */
    CONVERGE_IN_15_FRAMES(2),
    /**
     * Configure SDFGI to fully converge over 20 frames.
     */
    CONVERGE_IN_20_FRAMES(3),
    /**
     * Configure SDFGI to fully converge over 25 frames.
     */
    CONVERGE_IN_25_FRAMES(4),
    /**
     * Configure SDFGI to fully converge over 30 frames. This is the least responsive, but creates
     * the least noisy result with a given ray count.
     */
    CONVERGE_IN_30_FRAMES(5),
    /**
     * Represents the size of the [EnvironmentSDFGIFramesToConverge] enum.
     */
    CONVERGE_MAX(6),
    ;

    public companion object {
      public fun from(`value`: Long): EnvironmentSDFGIFramesToConverge =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class EnvironmentSDFGIFramesToUpdateLight(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Update indirect light from dynamic lights in SDFGI over 1 frame. This is the most responsive,
     * but has the highest GPU requirements.
     */
    UPDATE_LIGHT_IN_1_FRAME(0),
    /**
     * Update indirect light from dynamic lights in SDFGI over 2 frames.
     */
    UPDATE_LIGHT_IN_2_FRAMES(1),
    /**
     * Update indirect light from dynamic lights in SDFGI over 4 frames.
     */
    UPDATE_LIGHT_IN_4_FRAMES(2),
    /**
     * Update indirect light from dynamic lights in SDFGI over 8 frames.
     */
    UPDATE_LIGHT_IN_8_FRAMES(3),
    /**
     * Update indirect light from dynamic lights in SDFGI over 16 frames. This is the least
     * responsive, but has the lowest GPU requirements.
     */
    UPDATE_LIGHT_IN_16_FRAMES(4),
    /**
     * Represents the size of the [EnvironmentSDFGIFramesToUpdateLight] enum.
     */
    UPDATE_LIGHT_MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): EnvironmentSDFGIFramesToUpdateLight =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class SubSurfaceScatteringQuality(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Disables subsurface scattering entirely, even on materials that have
     * [BaseMaterial3D.subsurfScatterEnabled] set to `true`. This has the lowest GPU requirements.
     */
    DISABLED(0),
    /**
     * Low subsurface scattering quality.
     */
    LOW(1),
    /**
     * Medium subsurface scattering quality.
     */
    MEDIUM(2),
    /**
     * High subsurface scattering quality. This has the highest GPU requirements.
     */
    HIGH(3),
    ;

    public companion object {
      public fun from(`value`: Long): SubSurfaceScatteringQuality =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class DOFBokehShape(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Calculate the DOF blur using a box filter. The fastest option, but results in obvious lines
     * in blur pattern.
     */
    BOX(0),
    /**
     * Calculates DOF blur using a hexagon shaped filter.
     */
    HEXAGON(1),
    /**
     * Calculates DOF blur using a circle shaped filter. Best quality and most realistic, but
     * slowest. Use only for areas where a lot of performance can be dedicated to post-processing (e.g.
     * cutscenes).
     */
    CIRCLE(2),
    ;

    public companion object {
      public fun from(`value`: Long): DOFBokehShape = entries.single { it.`value` == `value` }
    }
  }

  public enum class DOFBlurQuality(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Lowest quality DOF blur. This is the fastest setting, but you may be able to see filtering
     * artifacts.
     */
    VERY_LOW(0),
    /**
     * Low quality DOF blur.
     */
    LOW(1),
    /**
     * Medium quality DOF blur.
     */
    MEDIUM(2),
    /**
     * Highest quality DOF blur. Results in the smoothest looking blur by taking the most samples,
     * but is also significantly slower.
     */
    HIGH(3),
    ;

    public companion object {
      public fun from(`value`: Long): DOFBlurQuality = entries.single { it.`value` == `value` }
    }
  }

  public enum class InstanceType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The instance does not have a type.
     */
    NONE(0),
    /**
     * The instance is a mesh.
     */
    MESH(1),
    /**
     * The instance is a multimesh.
     */
    MULTIMESH(2),
    /**
     * The instance is a particle emitter.
     */
    PARTICLES(3),
    /**
     * The instance is a GPUParticles collision shape.
     */
    PARTICLES_COLLISION(4),
    /**
     * The instance is a light.
     */
    LIGHT(5),
    /**
     * The instance is a reflection probe.
     */
    REFLECTION_PROBE(6),
    /**
     * The instance is a decal.
     */
    DECAL(7),
    /**
     * The instance is a VoxelGI.
     */
    VOXEL_GI(8),
    /**
     * The instance is a lightmap.
     */
    LIGHTMAP(9),
    /**
     * The instance is an occlusion culling occluder.
     */
    OCCLUDER(10),
    /**
     * The instance is a visible on-screen notifier.
     */
    VISIBLITY_NOTIFIER(11),
    /**
     * The instance is a fog volume.
     */
    FOG_VOLUME(12),
    /**
     * Represents the size of the [InstanceType] enum.
     */
    MAX(13),
    /**
     * A combination of the flags of geometry instances (mesh, multimesh, immediate and particles).
     */
    GEOMETRY_MASK(14),
    ;

    public companion object {
      public fun from(`value`: Long): InstanceType = entries.single { it.`value` == `value` }
    }
  }

  public enum class InstanceFlags(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Allows the instance to be used in baked lighting.
     */
    USE_BAKED_LIGHT(0),
    /**
     * Allows the instance to be used with dynamic global illumination.
     */
    USE_DYNAMIC_GI(1),
    /**
     * When set, manually requests to draw geometry on next frame.
     */
    DRAW_NEXT_FRAME_IF_VISIBLE(2),
    /**
     * Always draw, even if the instance would be culled by occlusion culling. Does not affect view
     * frustum culling.
     */
    IGNORE_OCCLUSION_CULLING(3),
    /**
     * Represents the size of the [InstanceFlags] enum.
     */
    MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): InstanceFlags = entries.single { it.`value` == `value` }
    }
  }

  public enum class ShadowCastingSetting(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Disable shadows from this instance.
     */
    OFF(0),
    /**
     * Cast shadows from this instance.
     */
    ON(1),
    /**
     * Disable backface culling when rendering the shadow of the object. This is slightly slower but
     * may result in more correct shadows.
     */
    DOUBLE_SIDED(2),
    /**
     * Only render the shadows from the object. The object itself will not be drawn.
     */
    SHADOWS_ONLY(3),
    ;

    public companion object {
      public fun from(`value`: Long): ShadowCastingSetting =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class VisibilityRangeFadeMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Disable visibility range fading for the given instance.
     */
    DISABLED(0),
    /**
     * Fade-out the given instance when it approaches its visibility range limits.
     */
    SELF(1),
    /**
     * Fade-in the given instance's dependencies when reaching its visibility range limits.
     */
    DEPENDENCIES(2),
    ;

    public companion object {
      public fun from(`value`: Long): VisibilityRangeFadeMode =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class BakeChannels(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Index of [Image] in array of [Image]s returned by [bakeRenderUv2]. Image uses
     * [Image.FORMAT_RGBA8] and contains albedo color in the `.rgb` channels and alpha in the `.a`
     * channel.
     */
    ALBEDO_ALPHA(0),
    /**
     * Index of [Image] in array of [Image]s returned by [bakeRenderUv2]. Image uses
     * [Image.FORMAT_RGBA8] and contains the per-pixel normal of the object in the `.rgb` channels and
     * nothing in the `.a` channel. The per-pixel normal is encoded as `normal * 0.5 + 0.5`.
     */
    NORMAL(1),
    /**
     * Index of [Image] in array of [Image]s returned by [bakeRenderUv2]. Image uses
     * [Image.FORMAT_RGBA8] and contains ambient occlusion (from material and decals only) in the `.r`
     * channel, roughness in the `.g` channel, metallic in the `.b` channel and sub surface scattering
     * amount in the `.a` channel.
     */
    ORM(2),
    /**
     * Index of [Image] in array of [Image]s returned by [bakeRenderUv2]. Image uses
     * [Image.FORMAT_RGBAH] and contains emission color in the `.rgb` channels and nothing in the `.a`
     * channel.
     */
    EMISSION(3),
    ;

    public companion object {
      public fun from(`value`: Long): BakeChannels = entries.single { it.`value` == `value` }
    }
  }

  public enum class CanvasTextureChannel(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Diffuse canvas texture ([CanvasTexture.diffuseTexture]).
     */
    DIFFUSE(0),
    /**
     * Normal map canvas texture ([CanvasTexture.normalTexture]).
     */
    NORMAL(1),
    /**
     * Specular map canvas texture ([CanvasTexture.specularTexture]).
     */
    SPECULAR(2),
    ;

    public companion object {
      public fun from(`value`: Long): CanvasTextureChannel =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class NinePatchAxisMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The nine patch gets stretched where needed.
     */
    STRETCH(0),
    /**
     * The nine patch gets filled with tiles where needed.
     */
    TILE(1),
    /**
     * The nine patch gets filled with tiles where needed and stretches them a bit if needed.
     */
    TILE_FIT(2),
    ;

    public companion object {
      public fun from(`value`: Long): NinePatchAxisMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class CanvasItemTextureFilter(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Uses the default filter mode for this [Viewport].
     */
    DEFAULT(0),
    /**
     * The texture filter reads from the nearest pixel only. This makes the texture look pixelated
     * from up close, and grainy from a distance (due to mipmaps not being sampled).
     */
    NEAREST(1),
    /**
     * The texture filter blends between the nearest 4 pixels. This makes the texture look smooth
     * from up close, and grainy from a distance (due to mipmaps not being sampled).
     */
    LINEAR(2),
    /**
     * The texture filter reads from the nearest pixel and blends between the nearest 2 mipmaps (or
     * uses the nearest mipmap if
     * [ProjectSettings.rendering/textures/defaultFilters/useNearestMipmapFilter] is `true`). This
     * makes the texture look pixelated from up close, and smooth from a distance.
     *
     * Use this for non-pixel art textures that may be viewed at a low scale (e.g. due to [Camera2D]
     * zoom or sprite scaling), as mipmaps are important to smooth out pixels that are smaller than
     * on-screen pixels.
     */
    NEAREST_WITH_MIPMAPS(3),
    /**
     * The texture filter blends between the nearest 4 pixels and between the nearest 2 mipmaps (or
     * uses the nearest mipmap if
     * [ProjectSettings.rendering/textures/defaultFilters/useNearestMipmapFilter] is `true`). This
     * makes the texture look smooth from up close, and smooth from a distance.
     *
     * Use this for non-pixel art textures that may be viewed at a low scale (e.g. due to [Camera2D]
     * zoom or sprite scaling), as mipmaps are important to smooth out pixels that are smaller than
     * on-screen pixels.
     */
    LINEAR_WITH_MIPMAPS(4),
    /**
     * The texture filter reads from the nearest pixel and blends between 2 mipmaps (or uses the
     * nearest mipmap if [ProjectSettings.rendering/textures/defaultFilters/useNearestMipmapFilter] is
     * `true`) based on the angle between the surface and the camera view. This makes the texture look
     * pixelated from up close, and smooth from a distance. Anisotropic filtering improves texture
     * quality on surfaces that are almost in line with the camera, but is slightly slower. The
     * anisotropic filtering level can be changed by adjusting
     * [ProjectSettings.rendering/textures/defaultFilters/anisotropicFilteringLevel].
     *
     * **Note:** This texture filter is rarely useful in 2D projects.
     * [CANVAS_ITEM_TEXTURE_FILTER_NEAREST_WITH_MIPMAPS] is usually more appropriate in this case.
     */
    NEAREST_WITH_MIPMAPS_ANISOTROPIC(5),
    /**
     * The texture filter blends between the nearest 4 pixels and blends between 2 mipmaps (or uses
     * the nearest mipmap if [ProjectSettings.rendering/textures/defaultFilters/useNearestMipmapFilter]
     * is `true`) based on the angle between the surface and the camera view. This makes the texture
     * look smooth from up close, and smooth from a distance. Anisotropic filtering improves texture
     * quality on surfaces that are almost in line with the camera, but is slightly slower. The
     * anisotropic filtering level can be changed by adjusting
     * [ProjectSettings.rendering/textures/defaultFilters/anisotropicFilteringLevel].
     *
     * **Note:** This texture filter is rarely useful in 2D projects.
     * [CANVAS_ITEM_TEXTURE_FILTER_LINEAR_WITH_MIPMAPS] is usually more appropriate in this case.
     */
    LINEAR_WITH_MIPMAPS_ANISOTROPIC(6),
    /**
     * Max value for [CanvasItemTextureFilter] enum.
     */
    MAX(7),
    ;

    public companion object {
      public fun from(`value`: Long): CanvasItemTextureFilter =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class CanvasItemTextureRepeat(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Uses the default repeat mode for this [Viewport].
     */
    DEFAULT(0),
    /**
     * Disables textures repeating. Instead, when reading UVs outside the 0-1 range, the value will
     * be clamped to the edge of the texture, resulting in a stretched out look at the borders of the
     * texture.
     */
    DISABLED(1),
    /**
     * Enables the texture to repeat when UV coordinates are outside the 0-1 range. If using one of
     * the linear filtering modes, this can result in artifacts at the edges of a texture when the
     * sampler filters across the edges of the texture.
     */
    ENABLED(2),
    /**
     * Flip the texture when repeating so that the edge lines up instead of abruptly changing.
     */
    MIRROR(3),
    /**
     * Max value for [CanvasItemTextureRepeat] enum.
     */
    MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): CanvasItemTextureRepeat =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class CanvasGroupMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Child draws over parent and is not clipped.
     */
    DISABLED(0),
    /**
     * Parent is used for the purposes of clipping only. Child is clipped to the parent's visible
     * area, parent is not drawn.
     */
    CLIP_ONLY(1),
    /**
     * Parent is used for clipping child, but parent is also drawn underneath child as normal before
     * clipping child to its visible area.
     */
    CLIP_AND_DRAW(2),
    TRANSPARENT(3),
    ;

    public companion object {
      public fun from(`value`: Long): CanvasGroupMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class CanvasLightMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * 2D point light (see [PointLight2D]).
     */
    POINT(0),
    /**
     * 2D directional (sun/moon) light (see [DirectionalLight2D]).
     */
    DIRECTIONAL(1),
    ;

    public companion object {
      public fun from(`value`: Long): CanvasLightMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class CanvasLightBlendMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Adds light color additive to the canvas.
     */
    ADD(0),
    /**
     * Adds light color subtractive to the canvas.
     */
    SUB(1),
    /**
     * The light adds color depending on transparency.
     */
    MIX(2),
    ;

    public companion object {
      public fun from(`value`: Long): CanvasLightBlendMode =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class CanvasLightShadowFilter(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Do not apply a filter to canvas light shadows.
     */
    FILTER_NONE(0),
    /**
     * Use PCF5 filtering to filter canvas light shadows.
     */
    FILTER_PCF5(1),
    /**
     * Use PCF13 filtering to filter canvas light shadows.
     */
    FILTER_PCF13(2),
    /**
     * Max value of the [CanvasLightShadowFilter] enum.
     */
    FILTER_MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): CanvasLightShadowFilter =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class CanvasOccluderPolygonCullMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Culling of the canvas occluder is disabled.
     */
    DISABLED(0),
    /**
     * Culling of the canvas occluder is clockwise.
     */
    CLOCKWISE(1),
    /**
     * Culling of the canvas occluder is counterclockwise.
     */
    COUNTER_CLOCKWISE(2),
    ;

    public companion object {
      public fun from(`value`: Long): CanvasOccluderPolygonCullMode =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class GlobalShaderParameterType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Boolean global shader parameter (`global uniform bool ...`).
     */
    VAR_TYPE_BOOL(0),
    /**
     * 2-dimensional boolean vector global shader parameter (`global uniform bvec2 ...`).
     */
    VAR_TYPE_BVEC2(1),
    /**
     * 3-dimensional boolean vector global shader parameter (`global uniform bvec3 ...`).
     */
    VAR_TYPE_BVEC3(2),
    /**
     * 4-dimensional boolean vector global shader parameter (`global uniform bvec4 ...`).
     */
    VAR_TYPE_BVEC4(3),
    /**
     * Integer global shader parameter (`global uniform int ...`).
     */
    VAR_TYPE_INT(4),
    /**
     * 2-dimensional integer vector global shader parameter (`global uniform ivec2 ...`).
     */
    VAR_TYPE_IVEC2(5),
    /**
     * 3-dimensional integer vector global shader parameter (`global uniform ivec3 ...`).
     */
    VAR_TYPE_IVEC3(6),
    /**
     * 4-dimensional integer vector global shader parameter (`global uniform ivec4 ...`).
     */
    VAR_TYPE_IVEC4(7),
    /**
     * 2-dimensional integer rectangle global shader parameter (`global uniform ivec4 ...`).
     * Equivalent to [GLOBAL_VAR_TYPE_IVEC4] in shader code, but exposed as a [Rect2i] in the editor
     * UI.
     */
    VAR_TYPE_RECT2I(8),
    /**
     * Unsigned integer global shader parameter (`global uniform uint ...`).
     */
    VAR_TYPE_UINT(9),
    /**
     * 2-dimensional unsigned integer vector global shader parameter (`global uniform uvec2 ...`).
     */
    VAR_TYPE_UVEC2(10),
    /**
     * 3-dimensional unsigned integer vector global shader parameter (`global uniform uvec3 ...`).
     */
    VAR_TYPE_UVEC3(11),
    /**
     * 4-dimensional unsigned integer vector global shader parameter (`global uniform uvec4 ...`).
     */
    VAR_TYPE_UVEC4(12),
    /**
     * Single-precision floating-point global shader parameter (`global uniform float ...`).
     */
    VAR_TYPE_FLOAT(13),
    /**
     * 2-dimensional floating-point vector global shader parameter (`global uniform vec2 ...`).
     */
    VAR_TYPE_VEC2(14),
    /**
     * 3-dimensional floating-point vector global shader parameter (`global uniform vec3 ...`).
     */
    VAR_TYPE_VEC3(15),
    /**
     * 4-dimensional floating-point vector global shader parameter (`global uniform vec4 ...`).
     */
    VAR_TYPE_VEC4(16),
    /**
     * Color global shader parameter (`global uniform vec4 ...`). Equivalent to
     * [GLOBAL_VAR_TYPE_VEC4] in shader code, but exposed as a [Color] in the editor UI.
     */
    VAR_TYPE_COLOR(17),
    /**
     * 2-dimensional floating-point rectangle global shader parameter (`global uniform vec4 ...`).
     * Equivalent to [GLOBAL_VAR_TYPE_VEC4] in shader code, but exposed as a [Rect2] in the editor UI.
     */
    VAR_TYPE_RECT2(18),
    /**
     * 2×2 matrix global shader parameter (`global uniform mat2 ...`). Exposed as a
     * [PackedInt32Array] in the editor UI.
     */
    VAR_TYPE_MAT2(19),
    /**
     * 3×3 matrix global shader parameter (`global uniform mat3 ...`). Exposed as a [Basis] in the
     * editor UI.
     */
    VAR_TYPE_MAT3(20),
    /**
     * 4×4 matrix global shader parameter (`global uniform mat4 ...`). Exposed as a [Projection] in
     * the editor UI.
     */
    VAR_TYPE_MAT4(21),
    /**
     * 2-dimensional transform global shader parameter (`global uniform mat2x3 ...`). Exposed as a
     * [Transform2D] in the editor UI.
     */
    VAR_TYPE_TRANSFORM_2D(22),
    /**
     * 3-dimensional transform global shader parameter (`global uniform mat3x4 ...`). Exposed as a
     * [Transform3D] in the editor UI.
     */
    VAR_TYPE_TRANSFORM(23),
    /**
     * 2D sampler global shader parameter (`global uniform sampler2D ...`). Exposed as a [Texture2D]
     * in the editor UI.
     */
    VAR_TYPE_SAMPLER2D(24),
    /**
     * 2D sampler array global shader parameter (`global uniform sampler2DArray ...`). Exposed as a
     * [Texture2DArray] in the editor UI.
     */
    VAR_TYPE_SAMPLER2DARRAY(25),
    /**
     * 3D sampler global shader parameter (`global uniform sampler3D ...`). Exposed as a [Texture3D]
     * in the editor UI.
     */
    VAR_TYPE_SAMPLER3D(26),
    /**
     * Cubemap sampler global shader parameter (`global uniform samplerCube ...`). Exposed as a
     * [Cubemap] in the editor UI.
     */
    VAR_TYPE_SAMPLERCUBE(27),
    /**
     * External sampler global shader parameter (`global uniform samplerExternalOES ...`). Exposed
     * as an [ExternalTexture] in the editor UI.
     */
    VAR_TYPE_SAMPLEREXT(28),
    /**
     * Represents the size of the [GlobalShaderParameterType] enum.
     */
    VAR_TYPE_MAX(29),
    ;

    public companion object {
      public fun from(`value`: Long): GlobalShaderParameterType =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class RenderingInfo(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Number of objects rendered in the current 3D scene. This varies depending on camera position
     * and rotation.
     */
    TOTAL_OBJECTS_IN_FRAME(0),
    /**
     * Number of points, lines, or triangles rendered in the current 3D scene. This varies depending
     * on camera position and rotation.
     */
    TOTAL_PRIMITIVES_IN_FRAME(1),
    /**
     * Number of draw calls performed to render in the current 3D scene. This varies depending on
     * camera position and rotation.
     */
    TOTAL_DRAW_CALLS_IN_FRAME(2),
    /**
     * Texture memory used (in bytes).
     */
    TEXTURE_MEM_USED(3),
    /**
     * Buffer memory used (in bytes). This includes vertex data, uniform buffers, and many
     * miscellaneous buffer types used internally.
     */
    BUFFER_MEM_USED(4),
    /**
     * Video memory used (in bytes). When using the Forward+ or Mobile renderers, this is always
     * greater than the sum of [RENDERING_INFO_TEXTURE_MEM_USED] and [RENDERING_INFO_BUFFER_MEM_USED],
     * since there is miscellaneous data not accounted for by those two metrics. When using the
     * Compatibility renderer, this is equal to the sum of [RENDERING_INFO_TEXTURE_MEM_USED] and
     * [RENDERING_INFO_BUFFER_MEM_USED].
     */
    VIDEO_MEM_USED(5),
    /**
     * Number of pipeline compilations that were triggered by the 2D canvas renderer.
     */
    PIPELINE_COMPILATIONS_CANVAS(6),
    /**
     * Number of pipeline compilations that were triggered by loading meshes. These compilations
     * will show up as longer loading times the first time a user runs the game and the pipeline is
     * required.
     */
    PIPELINE_COMPILATIONS_MESH(7),
    /**
     * Number of pipeline compilations that were triggered by building the surface cache before
     * rendering the scene. These compilations will show up as a stutter when loading a scene the first
     * time a user runs the game and the pipeline is required.
     */
    PIPELINE_COMPILATIONS_SURFACE(8),
    /**
     * Number of pipeline compilations that were triggered while drawing the scene. These
     * compilations will show up as stutters during gameplay the first time a user runs the game and
     * the pipeline is required.
     */
    PIPELINE_COMPILATIONS_DRAW(9),
    /**
     * Number of pipeline compilations that were triggered to optimize the current scene. These
     * compilations are done in the background and should not cause any stutters whatsoever.
     */
    PIPELINE_COMPILATIONS_SPECIALIZATION(10),
    ;

    public companion object {
      public fun from(`value`: Long): RenderingInfo = entries.single { it.`value` == `value` }
    }
  }

  public enum class PipelineSource(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Pipeline compilation that was triggered by the 2D canvas renderer.
     */
    CANVAS(0),
    /**
     * Pipeline compilation that was triggered by loading a mesh.
     */
    MESH(1),
    /**
     * Pipeline compilation that was triggered by building the surface cache before rendering the
     * scene.
     */
    SURFACE(2),
    /**
     * Pipeline compilation that was triggered while drawing the scene.
     */
    DRAW(3),
    /**
     * Pipeline compilation that was triggered to optimize the current scene.
     */
    SPECIALIZATION(4),
    /**
     * Represents the size of the [PipelineSource] enum.
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): PipelineSource = entries.single { it.`value` == `value` }
    }
  }

  public enum class SplashStretchMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * No stretching is applied.
     */
    DISABLED(0),
    /**
     * Stretches image to fullscreen while preserving aspect ratio.
     */
    KEEP(1),
    /**
     * Stretches the height of the image based on the width of the screen.
     */
    KEEP_WIDTH(2),
    /**
     * Stretches the width of the image based on the height of the screen.
     */
    KEEP_HEIGHT(3),
    /**
     * Stretches the image to cover the entire screen while preserving aspect ratio.
     */
    COVER(4),
    /**
     * Stretches the image to cover the entire screen but doesn't preserve aspect ratio.
     */
    IGNORE(5),
    ;

    public companion object {
      public fun from(`value`: Long): SplashStretchMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class Features(
    public override val `value`: Long,
  ) : GodotEnum {
    SHADERS(0),
    MULTITHREADED(1),
    ;

    public companion object {
      public fun from(`value`: Long): Features = entries.single { it.`value` == `value` }
    }
  }

  public object MethodBindings {
    internal val texture2dCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_2d_create", 2010018390)

    internal val texture2dLayeredCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_2d_layered_create", 913689023)

    internal val texture3dCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_3d_create", 4036838706)

    internal val textureProxyCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_proxy_create", 41030802)

    internal val textureCreateFromNativeHandlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_create_from_native_handle", 1682977582)

    internal val textureDrawableCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_drawable_create", 1993613667)

    internal val texture2dUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_2d_update", 999539803)

    internal val texture3dUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_3d_update", 684822712)

    internal val textureProxyUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_proxy_update", 395945892)

    internal val textureDrawableBlitRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_drawable_blit_rect", 4077763890)

    internal val texture2dPlaceholderCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_2d_placeholder_create", 529393457)

    internal val texture2dLayeredPlaceholderCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_2d_layered_placeholder_create", 1394585590)

    internal val texture3dPlaceholderCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_3d_placeholder_create", 529393457)

    internal val texture2dGetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_2d_get", 4206205781)

    internal val texture2dLayerGetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_2d_layer_get", 2705440895)

    internal val texture3dGetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_3d_get", 2684255073)

    internal val textureDrawableGenerateMipmapsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_drawable_generate_mipmaps", 2722037293)

    internal val textureDrawableGetDefaultMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_drawable_get_default_material", 2944877500)

    internal val textureReplacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_replace", 395945892)

    internal val textureSetSizeOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_set_size_override", 4288446313)

    internal val textureSetPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_set_path", 2726140452)

    internal val textureGetPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_get_path", 642473191)

    internal val textureGetFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_get_format", 1932918979)

    internal val textureSetForceRedrawIfVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_set_force_redraw_if_visible", 1265174801)

    internal val textureRdCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_rd_create", 1434128712)

    internal val textureGetRdTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_get_rd_texture", 2790148051)

    internal val textureGetNativeHandlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "texture_get_native_handle", 1834114100)

    internal val shaderCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "shader_create", 529393457)

    internal val shaderSetCodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "shader_set_code", 2726140452)

    internal val shaderSetPathHintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "shader_set_path_hint", 2726140452)

    internal val shaderGetCodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "shader_get_code", 642473191)

    internal val getShaderParameterListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "get_shader_parameter_list", 2684255073)

    internal val shaderGetParameterDefaultPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "shader_get_parameter_default", 2621281810)

    internal val shaderSetDefaultTextureParameterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "shader_set_default_texture_parameter", 4094001817)

    internal val shaderGetDefaultTextureParameterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "shader_get_default_texture_parameter", 1464608890)

    internal val materialCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "material_create", 529393457)

    internal val materialSetShaderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "material_set_shader", 395945892)

    internal val materialSetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "material_set_param", 3477296213)

    internal val materialGetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "material_get_param", 2621281810)

    internal val materialSetRenderPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "material_set_render_priority", 3411492887)

    internal val materialSetNextPassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "material_set_next_pass", 395945892)

    internal val materialSetUseDebandingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "material_set_use_debanding", 2586408642)

    internal val meshCreateFromSurfacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_create_from_surfaces", 4291747531)

    internal val meshCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_create", 529393457)

    internal val meshSurfaceGetFormatOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_surface_get_format_offset", 2981368685)

    internal val meshSurfaceGetFormatVertexStridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_surface_get_format_vertex_stride", 3188363337)

    internal val meshSurfaceGetFormatNormalTangentStridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_surface_get_format_normal_tangent_stride", 3188363337)

    internal val meshSurfaceGetFormatAttributeStridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_surface_get_format_attribute_stride", 3188363337)

    internal val meshSurfaceGetFormatSkinStridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_surface_get_format_skin_stride", 3188363337)

    internal val meshSurfaceGetFormatIndexStridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_surface_get_format_index_stride", 3188363337)

    internal val meshAddSurfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_add_surface", 1217542888)

    internal val meshAddSurfaceFromArraysPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_add_surface_from_arrays", 2342446560)

    internal val meshGetBlendShapeCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_get_blend_shape_count", 2198884583)

    internal val meshSetBlendShapeModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_set_blend_shape_mode", 1294662092)

    internal val meshGetBlendShapeModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_get_blend_shape_mode", 4282291819)

    internal val meshSurfaceSetMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_surface_set_material", 2310537182)

    internal val meshSurfaceGetMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_surface_get_material", 1066463050)

    internal val meshGetSurfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_get_surface", 186674697)

    internal val meshSurfaceGetArraysPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_surface_get_arrays", 1778388067)

    internal val meshSurfaceGetBlendShapeArraysPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_surface_get_blend_shape_arrays", 1778388067)

    internal val meshGetSurfaceCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_get_surface_count", 2198884583)

    internal val meshSetCustomAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_set_custom_aabb", 3696536120)

    internal val meshGetCustomAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_get_custom_aabb", 974181306)

    internal val meshSurfaceRemovePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_surface_remove", 3411492887)

    internal val meshClearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_clear", 2722037293)

    internal val meshSurfaceUpdateVertexRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_surface_update_vertex_region", 2900195149)

    internal val meshSurfaceUpdateAttributeRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_surface_update_attribute_region", 2900195149)

    internal val meshSurfaceUpdateSkinRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_surface_update_skin_region", 2900195149)

    internal val meshSurfaceUpdateIndexRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_surface_update_index_region", 2900195149)

    internal val meshSetShadowMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "mesh_set_shadow_mesh", 395945892)

    internal val multimeshCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_create", 529393457)

    internal val multimeshAllocateDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_allocate_data", 557240154)

    internal val multimeshGetInstanceCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_get_instance_count", 2198884583)

    internal val multimeshSetMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_set_mesh", 395945892)

    internal val multimeshInstanceSetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_instance_set_transform", 675327471)

    internal val multimeshInstanceSetTransform2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_instance_set_transform_2d", 736082694)

    internal val multimeshInstanceSetColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_instance_set_color", 176975443)

    internal val multimeshInstanceSetCustomDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_instance_set_custom_data", 176975443)

    internal val multimeshGetMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_get_mesh", 3814569979)

    internal val multimeshGetAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_get_aabb", 974181306)

    internal val multimeshSetCustomAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_set_custom_aabb", 3696536120)

    internal val multimeshGetCustomAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_get_custom_aabb", 974181306)

    internal val multimeshInstanceGetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_instance_get_transform", 1050775521)

    internal val multimeshInstanceGetTransform2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_instance_get_transform_2d", 1324854622)

    internal val multimeshInstanceGetColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_instance_get_color", 2946315076)

    internal val multimeshInstanceGetCustomDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_instance_get_custom_data", 2946315076)

    internal val multimeshSetVisibleInstancesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_set_visible_instances", 3411492887)

    internal val multimeshGetVisibleInstancesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_get_visible_instances", 2198884583)

    internal val multimeshSetBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_set_buffer", 2960552364)

    internal val multimeshGetCommandBufferRdRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_get_command_buffer_rd_rid", 3814569979)

    internal val multimeshGetBufferRdRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_get_buffer_rd_rid", 3814569979)

    internal val multimeshGetBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_get_buffer", 3964669176)

    internal val multimeshSetBufferInterpolatedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_set_buffer_interpolated", 659844711)

    internal val multimeshSetPhysicsInterpolatedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_set_physics_interpolated", 1265174801)

    internal val multimeshSetPhysicsInterpolationQualityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_set_physics_interpolation_quality", 3934808223)

    internal val multimeshInstanceResetPhysicsInterpolationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_instance_reset_physics_interpolation", 3411492887)

    internal val multimeshInstancesResetPhysicsInterpolationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "multimesh_instances_reset_physics_interpolation", 2722037293)

    internal val skeletonCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "skeleton_create", 529393457)

    internal val skeletonAllocateDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "skeleton_allocate_data", 1904426712)

    internal val skeletonGetBoneCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "skeleton_get_bone_count", 2198884583)

    internal val skeletonBoneSetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "skeleton_bone_set_transform", 675327471)

    internal val skeletonBoneGetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "skeleton_bone_get_transform", 1050775521)

    internal val skeletonBoneSetTransform2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "skeleton_bone_set_transform_2d", 736082694)

    internal val skeletonBoneGetTransform2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "skeleton_bone_get_transform_2d", 1324854622)

    internal val skeletonSetBaseTransform2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "skeleton_set_base_transform_2d", 1246044741)

    internal val directionalLightCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "directional_light_create", 529393457)

    internal val omniLightCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "omni_light_create", 529393457)

    internal val spotLightCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "spot_light_create", 529393457)

    internal val areaLightCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "area_light_create", 529393457)

    internal val lightSetColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "light_set_color", 2948539648)

    internal val lightSetParamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "light_set_param", 501936875)

    internal val lightSetShadowPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "light_set_shadow", 1265174801)

    internal val lightSetProjectorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "light_set_projector", 395945892)

    internal val lightSetNegativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "light_set_negative", 1265174801)

    internal val lightSetCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "light_set_cull_mask", 3411492887)

    internal val lightSetDistanceFadePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "light_set_distance_fade", 1622292572)

    internal val lightSetReverseCullFaceModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "light_set_reverse_cull_face_mode", 1265174801)

    internal val lightSetShadowCasterMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "light_set_shadow_caster_mask", 3411492887)

    internal val lightSetBakeModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "light_set_bake_mode", 1048525260)

    internal val lightSetMaxSdfgiCascadePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "light_set_max_sdfgi_cascade", 3411492887)

    internal val lightOmniSetShadowModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "light_omni_set_shadow_mode", 2552677200)

    internal val lightDirectionalSetShadowModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "light_directional_set_shadow_mode", 380462970)

    internal val lightDirectionalSetBlendSplitsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "light_directional_set_blend_splits", 1265174801)

    internal val lightDirectionalSetSkyModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "light_directional_set_sky_mode", 2559740754)

    internal val lightAreaSetSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "light_area_set_size", 3201125042)

    internal val lightAreaSetNormalizeEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "light_area_set_normalize_energy", 1265174801)

    internal val lightProjectorsSetFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "light_projectors_set_filter", 43944325)

    internal val lightmapsSetBicubicFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "lightmaps_set_bicubic_filter", 2586408642)

    internal val positionalSoftShadowFilterSetQualityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "positional_soft_shadow_filter_set_quality", 3613045266)

    internal val directionalSoftShadowFilterSetQualityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "directional_soft_shadow_filter_set_quality", 3613045266)

    internal val directionalShadowAtlasSetSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "directional_shadow_atlas_set_size", 300928843)

    internal val reflectionProbeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "reflection_probe_create", 529393457)

    internal val reflectionProbeSetUpdateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "reflection_probe_set_update_mode", 3853670147)

    internal val reflectionProbeSetIntensityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "reflection_probe_set_intensity", 1794382983)

    internal val reflectionProbeSetBlendDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "reflection_probe_set_blend_distance", 1794382983)

    internal val reflectionProbeSetAmbientModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "reflection_probe_set_ambient_mode", 184163074)

    internal val reflectionProbeSetAmbientColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "reflection_probe_set_ambient_color", 2948539648)

    internal val reflectionProbeSetAmbientEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "reflection_probe_set_ambient_energy", 1794382983)

    internal val reflectionProbeSetMaxDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "reflection_probe_set_max_distance", 1794382983)

    internal val reflectionProbeSetSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "reflection_probe_set_size", 3227306858)

    internal val reflectionProbeSetOriginOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "reflection_probe_set_origin_offset", 3227306858)

    internal val reflectionProbeSetAsInteriorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "reflection_probe_set_as_interior", 1265174801)

    internal val reflectionProbeSetEnableBoxProjectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "reflection_probe_set_enable_box_projection", 1265174801)

    internal val reflectionProbeSetEnableShadowsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "reflection_probe_set_enable_shadows", 1265174801)

    internal val reflectionProbeSetCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "reflection_probe_set_cull_mask", 3411492887)

    internal val reflectionProbeSetReflectionMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "reflection_probe_set_reflection_mask", 3411492887)

    internal val reflectionProbeSetResolutionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "reflection_probe_set_resolution", 3411492887)

    internal val reflectionProbeSetMeshLodThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "reflection_probe_set_mesh_lod_threshold", 1794382983)

    internal val decalCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "decal_create", 529393457)

    internal val decalSetSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "decal_set_size", 3227306858)

    internal val decalSetTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "decal_set_texture", 3953344054)

    internal val decalSetEmissionEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "decal_set_emission_energy", 1794382983)

    internal val decalSetAlbedoMixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "decal_set_albedo_mix", 1794382983)

    internal val decalSetModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "decal_set_modulate", 2948539648)

    internal val decalSetCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "decal_set_cull_mask", 3411492887)

    internal val decalSetDistanceFadePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "decal_set_distance_fade", 2972769666)

    internal val decalSetFadePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "decal_set_fade", 2513314492)

    internal val decalSetNormalFadePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "decal_set_normal_fade", 1794382983)

    internal val decalsSetFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "decals_set_filter", 3519875702)

    internal val giSetUseHalfResolutionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "gi_set_use_half_resolution", 2586408642)

    internal val voxelGiCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "voxel_gi_create", 529393457)

    internal val voxelGiAllocateDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "voxel_gi_allocate_data", 4108223027)

    internal val voxelGiGetOctreeSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "voxel_gi_get_octree_size", 2607699645)

    internal val voxelGiGetOctreeCellsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "voxel_gi_get_octree_cells", 3348040486)

    internal val voxelGiGetDataCellsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "voxel_gi_get_data_cells", 3348040486)

    internal val voxelGiGetDistanceFieldPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "voxel_gi_get_distance_field", 3348040486)

    internal val voxelGiGetLevelCountsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "voxel_gi_get_level_counts", 788230395)

    internal val voxelGiGetToCellXformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "voxel_gi_get_to_cell_xform", 1128465797)

    internal val voxelGiSetDynamicRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "voxel_gi_set_dynamic_range", 1794382983)

    internal val voxelGiSetPropagationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "voxel_gi_set_propagation", 1794382983)

    internal val voxelGiSetEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "voxel_gi_set_energy", 1794382983)

    internal val voxelGiSetBakedExposureNormalizationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "voxel_gi_set_baked_exposure_normalization", 1794382983)

    internal val voxelGiSetBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "voxel_gi_set_bias", 1794382983)

    internal val voxelGiSetNormalBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "voxel_gi_set_normal_bias", 1794382983)

    internal val voxelGiSetInteriorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "voxel_gi_set_interior", 1265174801)

    internal val voxelGiSetUseTwoBouncesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "voxel_gi_set_use_two_bounces", 1265174801)

    internal val voxelGiSetQualityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "voxel_gi_set_quality", 1538689978)

    internal val lightmapCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "lightmap_create", 529393457)

    internal val lightmapSetTexturesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "lightmap_set_textures", 2646464759)

    internal val lightmapSetProbeBoundsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "lightmap_set_probe_bounds", 3696536120)

    internal val lightmapSetProbeInteriorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "lightmap_set_probe_interior", 1265174801)

    internal val lightmapSetProbeCaptureDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "lightmap_set_probe_capture_data", 3217845880)

    internal val lightmapGetProbeCapturePointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "lightmap_get_probe_capture_points", 808965560)

    internal val lightmapGetProbeCaptureShPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "lightmap_get_probe_capture_sh", 1569415609)

    internal val lightmapGetProbeCaptureTetrahedraPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "lightmap_get_probe_capture_tetrahedra", 788230395)

    internal val lightmapGetProbeCaptureBspTreePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "lightmap_get_probe_capture_bsp_tree", 788230395)

    internal val lightmapSetBakedExposureNormalizationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "lightmap_set_baked_exposure_normalization", 1794382983)

    internal val lightmapSetProbeCaptureUpdateSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "lightmap_set_probe_capture_update_speed", 373806689)

    internal val particlesCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_create", 529393457)

    internal val particlesSetModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_mode", 3492270028)

    internal val particlesSetEmittingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_emitting", 1265174801)

    internal val particlesGetEmittingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_get_emitting", 3521089500)

    internal val particlesSetAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_amount", 3411492887)

    internal val particlesSetAmountRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_amount_ratio", 1794382983)

    internal val particlesSetLifetimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_lifetime", 1794382983)

    internal val particlesSetOneShotPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_one_shot", 1265174801)

    internal val particlesSetPreProcessTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_pre_process_time", 1794382983)

    internal val particlesRequestProcessTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_request_process_time", 1515254041)

    internal val particlesSetExplosivenessRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_explosiveness_ratio", 1794382983)

    internal val particlesSetRandomnessRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_randomness_ratio", 1794382983)

    internal val particlesSetInterpToEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_interp_to_end", 1794382983)

    internal val particlesSetEmitterVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_emitter_velocity", 3227306858)

    internal val particlesSetCustomAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_custom_aabb", 3696536120)

    internal val particlesSetSpeedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_speed_scale", 1794382983)

    internal val particlesSetUseLocalCoordinatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_use_local_coordinates", 1265174801)

    internal val particlesSetProcessMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_process_material", 395945892)

    internal val particlesSetFixedFpsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_fixed_fps", 3411492887)

    internal val particlesSetInterpolatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_interpolate", 1265174801)

    internal val particlesSetFractionalDeltaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_fractional_delta", 1265174801)

    internal val particlesSetCollisionBaseSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_collision_base_size", 1794382983)

    internal val particlesSetTransformAlignPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_transform_align", 3264971368)

    internal val particlesSetTransformAlignChannelFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_transform_align_channel_filter", 1303285813)

    internal val particlesSetTransformAlignAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_transform_align_axis", 3065310065)

    internal val particlesSetTrailsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_trails", 2010054925)

    internal val particlesSetTrailBindPosesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_trail_bind_poses", 684822712)

    internal val particlesIsInactivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_is_inactive", 3521089500)

    internal val particlesRequestProcessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_request_process", 2722037293)

    internal val particlesRestartPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_restart", 2722037293)

    internal val particlesSetSubemitterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_subemitter", 395945892)

    internal val particlesEmitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_emit", 4043136117)

    internal val particlesSetDrawOrderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_draw_order", 935028487)

    internal val particlesSetDrawPassesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_draw_passes", 3411492887)

    internal val particlesSetDrawPassMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_draw_pass_mesh", 2310537182)

    internal val particlesGetCurrentAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_get_current_aabb", 3952830260)

    internal val particlesSetEmissionTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_set_emission_transform", 3935195649)

    internal val particlesCollisionCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_collision_create", 529393457)

    internal val particlesCollisionSetCollisionTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_collision_set_collision_type", 1497044930)

    internal val particlesCollisionSetCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_collision_set_cull_mask", 3411492887)

    internal val particlesCollisionSetSphereRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_collision_set_sphere_radius", 1794382983)

    internal val particlesCollisionSetBoxExtentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_collision_set_box_extents", 3227306858)

    internal val particlesCollisionSetAttractorStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_collision_set_attractor_strength", 1794382983)

    internal val particlesCollisionSetAttractorDirectionalityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_collision_set_attractor_directionality", 1794382983)

    internal val particlesCollisionSetAttractorAttenuationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_collision_set_attractor_attenuation", 1794382983)

    internal val particlesCollisionSetFieldTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_collision_set_field_texture", 395945892)

    internal val particlesCollisionHeightFieldUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_collision_height_field_update", 2722037293)

    internal val particlesCollisionSetHeightFieldResolutionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_collision_set_height_field_resolution", 962977297)

    internal val particlesCollisionSetHeightFieldMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "particles_collision_set_height_field_mask", 3411492887)

    internal val fogVolumeCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "fog_volume_create", 529393457)

    internal val fogVolumeSetShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "fog_volume_set_shape", 3818703106)

    internal val fogVolumeSetSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "fog_volume_set_size", 3227306858)

    internal val fogVolumeSetMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "fog_volume_set_material", 395945892)

    internal val visibilityNotifierCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "visibility_notifier_create", 529393457)

    internal val visibilityNotifierSetAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "visibility_notifier_set_aabb", 3696536120)

    internal val visibilityNotifierSetCallbacksPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "visibility_notifier_set_callbacks", 2689735388)

    internal val occluderCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "occluder_create", 529393457)

    internal val occluderSetMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "occluder_set_mesh", 3854404263)

    internal val cameraCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "camera_create", 529393457)

    internal val cameraSetPerspectivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "camera_set_perspective", 157498339)

    internal val cameraSetOrthogonalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "camera_set_orthogonal", 157498339)

    internal val cameraSetFrustumPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "camera_set_frustum", 1889878953)

    internal val cameraSetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "camera_set_transform", 3935195649)

    internal val cameraSetCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "camera_set_cull_mask", 3411492887)

    internal val cameraSetEnvironmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "camera_set_environment", 395945892)

    internal val cameraSetCameraAttributesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "camera_set_camera_attributes", 395945892)

    internal val cameraSetCompositorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "camera_set_compositor", 395945892)

    internal val cameraSetUseVerticalAspectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "camera_set_use_vertical_aspect", 1265174801)

    internal val viewportCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_create", 529393457)

    internal val viewportSetUseXrPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_use_xr", 1265174801)

    internal val viewportSetSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_size", 3313592705)

    internal val viewportSetActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_active", 1265174801)

    internal val viewportSetParentViewportPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_parent_viewport", 395945892)

    internal val viewportAttachToScreenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_attach_to_screen", 1062245816)

    internal val viewportSetRenderDirectToScreenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_render_direct_to_screen", 1265174801)

    internal val viewportSetCanvasCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_canvas_cull_mask", 3411492887)

    internal val viewportSetScaling3dModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_scaling_3d_mode", 2386524376)

    internal val viewportSetScaling3dScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_scaling_3d_scale", 1794382983)

    internal val viewportSetFsrSharpnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_fsr_sharpness", 1794382983)

    internal val viewportSetTextureMipmapBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_texture_mipmap_bias", 1794382983)

    internal val viewportSetAnisotropicFilteringLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_anisotropic_filtering_level", 3953214029)

    internal val viewportSetUpdateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_update_mode", 3161116010)

    internal val viewportGetUpdateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_get_update_mode", 3803901472)

    internal val viewportSetClearModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_clear_mode", 3628367896)

    internal val viewportGetRenderTargetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_get_render_target", 3814569979)

    internal val viewportGetTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_get_texture", 3814569979)

    internal val viewportSetDisable3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_disable_3d", 1265174801)

    internal val viewportSetDisable2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_disable_2d", 1265174801)

    internal val viewportSetEnvironmentModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_environment_mode", 2196892182)

    internal val viewportAttachCameraPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_attach_camera", 395945892)

    internal val viewportSetScenarioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_scenario", 395945892)

    internal val viewportAttachCanvasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_attach_canvas", 395945892)

    internal val viewportRemoveCanvasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_remove_canvas", 395945892)

    internal val viewportSetSnap2dTransformsToPixelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_snap_2d_transforms_to_pixel", 1265174801)

    internal val viewportSetSnap2dVerticesToPixelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_snap_2d_vertices_to_pixel", 1265174801)

    internal val viewportSetDefaultCanvasItemTextureFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_default_canvas_item_texture_filter", 1155129294)

    internal val viewportSetDefaultCanvasItemTextureRepeatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_default_canvas_item_texture_repeat", 1652956681)

    internal val viewportSetCanvasTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_canvas_transform", 3608606053)

    internal val viewportSetCanvasStackingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_canvas_stacking", 3713930247)

    internal val viewportSetTransparentBackgroundPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_transparent_background", 1265174801)

    internal val viewportSetGlobalCanvasTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_global_canvas_transform", 1246044741)

    internal val viewportSetSdfOversizeAndScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_sdf_oversize_and_scale", 1329198632)

    internal val viewportSetPositionalShadowAtlasSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_positional_shadow_atlas_size", 1904426712)

    internal val viewportSetPositionalShadowAtlasQuadrantSubdivisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_positional_shadow_atlas_quadrant_subdivision", 4288446313)

    internal val viewportSetMsaa3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_msaa_3d", 3764433340)

    internal val viewportSetMsaa2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_msaa_2d", 3764433340)

    internal val viewportSetUseHdr2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_use_hdr_2d", 1265174801)

    internal val viewportSetScreenSpaceAaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_screen_space_aa", 1447279591)

    internal val viewportSetUseTaaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_use_taa", 1265174801)

    internal val viewportSetUseDebandingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_use_debanding", 1265174801)

    internal val viewportSetUseOcclusionCullingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_use_occlusion_culling", 1265174801)

    internal val viewportSetOcclusionRaysPerThreadPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_occlusion_rays_per_thread", 1286410249)

    internal val viewportSetOcclusionCullingBuildQualityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_occlusion_culling_build_quality", 2069725696)

    internal val viewportGetRenderInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_get_render_info", 2041262392)

    internal val viewportSetDebugDrawPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_debug_draw", 2089420930)

    internal val viewportSetMeasureRenderTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_measure_render_time", 1265174801)

    internal val viewportGetMeasuredRenderTimeCpuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_get_measured_render_time_cpu", 866169185)

    internal val viewportGetMeasuredRenderTimeGpuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_get_measured_render_time_gpu", 866169185)

    internal val viewportSetVrsModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_vrs_mode", 398809874)

    internal val viewportSetVrsUpdateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_vrs_update_mode", 2696154815)

    internal val viewportSetVrsTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "viewport_set_vrs_texture", 395945892)

    internal val skyCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "sky_create", 529393457)

    internal val skySetRadianceSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "sky_set_radiance_size", 3411492887)

    internal val skySetModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "sky_set_mode", 3279019937)

    internal val skySetMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "sky_set_material", 395945892)

    internal val skyBakePanoramaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "sky_bake_panorama", 3875285818)

    internal val compositorEffectCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "compositor_effect_create", 529393457)

    internal val compositorEffectSetEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "compositor_effect_set_enabled", 1265174801)

    internal val compositorEffectSetCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "compositor_effect_set_callback", 487412485)

    internal val compositorEffectSetFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "compositor_effect_set_flag", 3659527075)

    internal val compositorCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "compositor_create", 529393457)

    internal val compositorSetCompositorEffectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "compositor_set_compositor_effects", 684822712)

    internal val environmentCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_create", 529393457)

    internal val environmentSetBackgroundPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_background", 3937328877)

    internal val environmentSetCameraIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_camera_id", 3411492887)

    internal val environmentSetSkyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_sky", 395945892)

    internal val environmentSetSkyCustomFovPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_sky_custom_fov", 1794382983)

    internal val environmentSetSkyOrientationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_sky_orientation", 1735850857)

    internal val environmentSetBgColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_bg_color", 2948539648)

    internal val environmentSetBgEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_bg_energy", 2513314492)

    internal val environmentSetCanvasMaxLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_canvas_max_layer", 3411492887)

    internal val environmentSetAmbientLightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_ambient_light", 1214961493)

    internal val environmentSetGlowPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_glow", 2421724940)

    internal val environmentSetTonemapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_tonemap", 2914312638)

    internal val environmentSetTonemapAgxContrastPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_tonemap_agx_contrast", 1794382983)

    internal val environmentSetAdjustmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_adjustment", 876799838)

    internal val environmentSetSsrPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_ssr", 3607294374)

    internal val environmentSetSsaoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_ssao", 3994732740)

    internal val environmentSetFogPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_fog", 105051629)

    internal val environmentSetFogDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_fog_depth", 157498339)

    internal val environmentSetSdfgiPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_sdfgi", 3519144388)

    internal val environmentSetVolumetricFogPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_volumetric_fog", 1553633833)

    internal val environmentGlowSetUseBicubicUpscalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_glow_set_use_bicubic_upscale", 2586408642)

    internal val environmentSetSsrHalfSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_ssr_half_size", 2586408642)

    internal val environmentSetSsrRoughnessQualityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_ssr_roughness_quality", 1190026788)

    internal val environmentSetSsaoQualityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_ssao_quality", 189753569)

    internal val environmentSetSsilQualityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_ssil_quality", 1713836683)

    internal val environmentSetSdfgiRayCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_sdfgi_ray_count", 340137951)

    internal val environmentSetSdfgiFramesToConvergePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_sdfgi_frames_to_converge", 2182444374)

    internal val environmentSetSdfgiFramesToUpdateLightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_sdfgi_frames_to_update_light", 1251144068)

    internal val environmentSetVolumetricFogVolumeSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_volumetric_fog_volume_size", 3937882851)

    internal val environmentSetVolumetricFogFilterActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_set_volumetric_fog_filter_active", 2586408642)

    internal val environmentBakePanoramaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "environment_bake_panorama", 2452908646)

    internal val screenSpaceRoughnessLimiterSetActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "screen_space_roughness_limiter_set_active", 916716790)

    internal val subSurfaceScatteringSetQualityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "sub_surface_scattering_set_quality", 64571803)

    internal val subSurfaceScatteringSetScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "sub_surface_scattering_set_scale", 1017552074)

    internal val cameraAttributesCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "camera_attributes_create", 529393457)

    internal val cameraAttributesSetDofBlurQualityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "camera_attributes_set_dof_blur_quality", 2220136795)

    internal val cameraAttributesSetDofBlurBokehShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "camera_attributes_set_dof_blur_bokeh_shape", 1205058394)

    internal val cameraAttributesSetDofBlurPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "camera_attributes_set_dof_blur", 316272616)

    internal val cameraAttributesSetExposurePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "camera_attributes_set_exposure", 2513314492)

    internal val cameraAttributesSetAutoExposurePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "camera_attributes_set_auto_exposure", 4266986332)

    internal val scenarioCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "scenario_create", 529393457)

    internal val scenarioSetEnvironmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "scenario_set_environment", 395945892)

    internal val scenarioSetFallbackEnvironmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "scenario_set_fallback_environment", 395945892)

    internal val scenarioSetCameraAttributesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "scenario_set_camera_attributes", 395945892)

    internal val scenarioSetCompositorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "scenario_set_compositor", 395945892)

    internal val instanceCreate2Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_create2", 746547085)

    internal val instanceCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_create", 529393457)

    internal val instanceSetBasePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_set_base", 395945892)

    internal val instanceSetScenarioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_set_scenario", 395945892)

    internal val instanceSetLayerMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_set_layer_mask", 3411492887)

    internal val instanceSetPivotDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_set_pivot_data", 1280615259)

    internal val instanceSetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_set_transform", 3935195649)

    internal val instanceAttachObjectInstanceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_attach_object_instance_id", 3411492887)

    internal val instanceSetBlendShapeWeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_set_blend_shape_weight", 1892459533)

    internal val instanceSetSurfaceOverrideMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_set_surface_override_material", 2310537182)

    internal val instanceSetVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_set_visible", 1265174801)

    internal val instanceGeometrySetTransparencyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_geometry_set_transparency", 1794382983)

    internal val instanceTeleportPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_teleport", 2722037293)

    internal val instanceSetCustomAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_set_custom_aabb", 3696536120)

    internal val instanceAttachSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_attach_skeleton", 395945892)

    internal val instanceSetExtraVisibilityMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_set_extra_visibility_margin", 1794382983)

    internal val instanceSetVisibilityParentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_set_visibility_parent", 395945892)

    internal val instanceSetIgnoreCullingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_set_ignore_culling", 1265174801)

    internal val instanceGeometrySetFlagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_geometry_set_flag", 1014989537)

    internal val instanceGeometrySetCastShadowsSettingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_geometry_set_cast_shadows_setting", 3768836020)

    internal val instanceGeometrySetMaterialOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_geometry_set_material_override", 395945892)

    internal val instanceGeometrySetMaterialOverlayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_geometry_set_material_overlay", 395945892)

    internal val instanceGeometrySetVisibilityRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_geometry_set_visibility_range", 4263925858)

    internal val instanceGeometrySetLightmapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_geometry_set_lightmap", 536974962)

    internal val instanceGeometrySetLodBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_geometry_set_lod_bias", 1794382983)

    internal val instanceGeometrySetShaderParameterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_geometry_set_shader_parameter", 3477296213)

    internal val instanceGeometryGetShaderParameterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_geometry_get_shader_parameter", 2621281810)

    internal val instanceGeometryGetShaderParameterDefaultValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_geometry_get_shader_parameter_default_value", 2621281810)

    internal val instanceGeometryGetShaderParameterListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instance_geometry_get_shader_parameter_list", 2684255073)

    internal val instancesCullAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instances_cull_aabb", 2570105777)

    internal val instancesCullRayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instances_cull_ray", 2208759584)

    internal val instancesCullConvexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "instances_cull_convex", 2488539944)

    internal val bakeRenderUv2Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "bake_render_uv2", 1904608558)

    internal val canvasCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_create", 529393457)

    internal val canvasSetItemMirroringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_set_item_mirroring", 2343975398)

    internal val canvasSetItemRepeatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_set_item_repeat", 1739512717)

    internal val canvasSetModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_set_modulate", 2948539648)

    internal val canvasSetDisableScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_set_disable_scale", 2586408642)

    internal val canvasTextureCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_texture_create", 529393457)

    internal val canvasTextureSetChannelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_texture_set_channel", 3822119138)

    internal val canvasTextureSetShadingParametersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_texture_set_shading_parameters", 2124967469)

    internal val canvasTextureSetTextureFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_texture_set_texture_filter", 1155129294)

    internal val canvasTextureSetTextureRepeatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_texture_set_texture_repeat", 1652956681)

    internal val canvasItemCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_create", 529393457)

    internal val canvasItemSetParentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_parent", 395945892)

    internal val canvasItemSetDefaultTextureFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_default_texture_filter", 1155129294)

    internal val canvasItemSetDefaultTextureRepeatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_default_texture_repeat", 1652956681)

    internal val canvasItemSetVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_visible", 1265174801)

    internal val canvasItemSetLightMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_light_mask", 3411492887)

    internal val canvasItemSetVisibilityLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_visibility_layer", 3411492887)

    internal val canvasItemSetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_transform", 1246044741)

    internal val canvasItemSetClipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_clip", 1265174801)

    internal val canvasItemSetDistanceFieldModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_distance_field_mode", 1265174801)

    internal val canvasItemSetCustomRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_custom_rect", 1333997032)

    internal val canvasItemSetModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_modulate", 2948539648)

    internal val canvasItemSetSelfModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_self_modulate", 2948539648)

    internal val canvasItemSetDrawBehindParentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_draw_behind_parent", 1265174801)

    internal val canvasItemSetInterpolatedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_interpolated", 1265174801)

    internal val canvasItemResetPhysicsInterpolationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_reset_physics_interpolation", 2722037293)

    internal val canvasItemTransformPhysicsInterpolationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_transform_physics_interpolation", 1246044741)

    internal val canvasItemAddLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_line", 1819681853)

    internal val canvasItemAddPolylinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_polyline", 3098767073)

    internal val canvasItemAddMultilinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_multiline", 3098767073)

    internal val canvasItemAddRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_rect", 3523446176)

    internal val canvasItemAddCirclePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_circle", 333077949)

    internal val canvasItemAddEllipsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_ellipse", 4188642757)

    internal val canvasItemAddTextureRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_texture_rect", 324864032)

    internal val canvasItemAddMsdfTextureRectRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_msdf_texture_rect_region", 97408773)

    internal val canvasItemAddLcdTextureRectRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_lcd_texture_rect_region", 359793297)

    internal val canvasItemAddTextureRectRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_texture_rect_region", 485157892)

    internal val canvasItemAddNinePatchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_nine_patch", 389957886)

    internal val canvasItemAddPrimitivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_primitive", 3731601077)

    internal val canvasItemAddPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_polygon", 3580000528)

    internal val canvasItemAddTriangleArrayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_triangle_array", 660261329)

    internal val canvasItemAddMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_mesh", 316450961)

    internal val canvasItemAddMultimeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_multimesh", 2131855138)

    internal val canvasItemAddParticlesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_particles", 2575754278)

    internal val canvasItemAddSetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_set_transform", 1246044741)

    internal val canvasItemAddClipIgnorePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_clip_ignore", 1265174801)

    internal val canvasItemAddAnimationSlicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_add_animation_slice", 2646834499)

    internal val canvasItemSetSortChildrenByYPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_sort_children_by_y", 1265174801)

    internal val canvasItemSetZIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_z_index", 3411492887)

    internal val canvasItemSetZAsRelativeToParentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_z_as_relative_to_parent", 1265174801)

    internal val canvasItemSetCopyToBackbufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_copy_to_backbuffer", 2429202503)

    internal val canvasItemAttachSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_attach_skeleton", 395945892)

    internal val canvasItemClearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_clear", 2722037293)

    internal val canvasItemSetDrawIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_draw_index", 3411492887)

    internal val canvasItemSetMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_material", 395945892)

    internal val canvasItemSetUseParentMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_use_parent_material", 1265174801)

    internal val canvasItemSetInstanceShaderParameterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_instance_shader_parameter", 3477296213)

    internal val canvasItemGetInstanceShaderParameterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_get_instance_shader_parameter", 2621281810)

    internal val canvasItemGetInstanceShaderParameterDefaultValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_get_instance_shader_parameter_default_value", 2621281810)

    internal val canvasItemGetInstanceShaderParameterListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_get_instance_shader_parameter_list", 2684255073)

    internal val canvasItemSetVisibilityNotifierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_visibility_notifier", 3568945579)

    internal val canvasItemSetCanvasGroupModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_item_set_canvas_group_mode", 3973586316)

    internal val debugCanvasItemGetRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "debug_canvas_item_get_rect", 624227424)

    internal val canvasLightCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_create", 529393457)

    internal val canvasLightAttachToCanvasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_attach_to_canvas", 395945892)

    internal val canvasLightSetEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_enabled", 1265174801)

    internal val canvasLightSetTextureScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_texture_scale", 1794382983)

    internal val canvasLightSetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_transform", 1246044741)

    internal val canvasLightSetTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_texture", 395945892)

    internal val canvasLightSetTextureOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_texture_offset", 3201125042)

    internal val canvasLightSetColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_color", 2948539648)

    internal val canvasLightSetHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_height", 1794382983)

    internal val canvasLightSetEnergyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_energy", 1794382983)

    internal val canvasLightSetZRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_z_range", 4288446313)

    internal val canvasLightSetLayerRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_layer_range", 4288446313)

    internal val canvasLightSetItemCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_item_cull_mask", 3411492887)

    internal val canvasLightSetItemShadowCullMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_item_shadow_cull_mask", 3411492887)

    internal val canvasLightSetModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_mode", 2957564891)

    internal val canvasLightSetShadowEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_shadow_enabled", 1265174801)

    internal val canvasLightSetShadowFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_shadow_filter", 393119659)

    internal val canvasLightSetShadowColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_shadow_color", 2948539648)

    internal val canvasLightSetShadowSmoothPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_shadow_smooth", 1794382983)

    internal val canvasLightSetBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_blend_mode", 804895945)

    internal val canvasLightSetInterpolatedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_set_interpolated", 1265174801)

    internal val canvasLightResetPhysicsInterpolationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_reset_physics_interpolation", 2722037293)

    internal val canvasLightTransformPhysicsInterpolationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_transform_physics_interpolation", 1246044741)

    internal val canvasLightOccluderCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_occluder_create", 529393457)

    internal val canvasLightOccluderAttachToCanvasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_occluder_attach_to_canvas", 395945892)

    internal val canvasLightOccluderSetEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_occluder_set_enabled", 1265174801)

    internal val canvasLightOccluderSetPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_occluder_set_polygon", 395945892)

    internal val canvasLightOccluderSetAsSdfCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_occluder_set_as_sdf_collision", 1265174801)

    internal val canvasLightOccluderSetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_occluder_set_transform", 1246044741)

    internal val canvasLightOccluderSetLightMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_occluder_set_light_mask", 3411492887)

    internal val canvasLightOccluderSetInterpolatedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_occluder_set_interpolated", 1265174801)

    internal val canvasLightOccluderResetPhysicsInterpolationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_occluder_reset_physics_interpolation", 2722037293)

    internal val canvasLightOccluderTransformPhysicsInterpolationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_light_occluder_transform_physics_interpolation", 1246044741)

    internal val canvasOccluderPolygonCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_occluder_polygon_create", 529393457)

    internal val canvasOccluderPolygonSetShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_occluder_polygon_set_shape", 2103882027)

    internal val canvasOccluderPolygonSetCullModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_occluder_polygon_set_cull_mode", 1839404663)

    internal val canvasSetShadowTextureSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "canvas_set_shadow_texture_size", 1286410249)

    internal val globalShaderParameterAddPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "global_shader_parameter_add", 463390080)

    internal val globalShaderParameterRemovePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "global_shader_parameter_remove", 3304788590)

    internal val globalShaderParameterGetListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "global_shader_parameter_get_list", 3995934104)

    internal val globalShaderParameterSetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "global_shader_parameter_set", 3776071444)

    internal val globalShaderParameterSetOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "global_shader_parameter_set_override", 3776071444)

    internal val globalShaderParameterGetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "global_shader_parameter_get", 2760726917)

    internal val globalShaderParameterGetTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "global_shader_parameter_get_type", 1601414142)

    internal val freeRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "free_rid", 2722037293)

    internal val requestFrameDrawnCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "request_frame_drawn_callback", 1611583062)

    internal val hasChangedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "has_changed", 36873697)

    internal val getRenderingInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "get_rendering_info", 3763192241)

    internal val getVideoAdapterNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "get_video_adapter_name", 201670096)

    internal val getVideoAdapterVendorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "get_video_adapter_vendor", 201670096)

    internal val getVideoAdapterTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "get_video_adapter_type", 3099547011)

    internal val getVideoAdapterApiVersionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "get_video_adapter_api_version", 201670096)

    internal val getCurrentRenderingDriverNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "get_current_rendering_driver_name", 201670096)

    internal val getCurrentRenderingMethodPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "get_current_rendering_method", 201670096)

    internal val makeSphereMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "make_sphere_mesh", 2251015897)

    internal val getTestCubePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "get_test_cube", 529393457)

    internal val getTestTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "get_test_texture", 529393457)

    internal val getWhiteTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "get_white_texture", 529393457)

    internal val setBootImageWithStretchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "set_boot_image_with_stretch", 1104470771)

    internal val setBootImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "set_boot_image", 3759744527)

    internal val getDefaultClearColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "get_default_clear_color", 3200896285)

    internal val setDefaultClearColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "set_default_clear_color", 2920490490)

    internal val hasOsFeaturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "has_os_feature", 3927539163)

    internal val setDebugGenerateWireframesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "set_debug_generate_wireframes", 2586408642)

    internal val isRenderLoopEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "is_render_loop_enabled", 36873697)

    internal val setRenderLoopEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "set_render_loop_enabled", 2586408642)

    internal val getFrameSetupTimeCpuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "get_frame_setup_time_cpu", 1740695150)

    internal val forceSyncPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "force_sync", 3218959716)

    internal val forceDrawPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "force_draw", 1076185472)

    internal val getRenderingDevicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "get_rendering_device", 1405107940)

    internal val createLocalRenderingDevicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "create_local_rendering_device", 1405107940)

    internal val isOnRenderThreadPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "is_on_render_thread", 2240911060)

    internal val callOnRenderThreadPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "call_on_render_thread", 1611583062)

    internal val hasFeaturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderingServer", "has_feature", 598462696)
  }
}
