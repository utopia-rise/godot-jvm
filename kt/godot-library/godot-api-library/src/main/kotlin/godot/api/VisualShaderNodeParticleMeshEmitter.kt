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
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [VisualShaderNodeParticleEmitter] that makes the particles emitted in a shape of the assigned
 * [mesh]. It will emit from the mesh's surfaces, either all or only the specified one.
 */
@GodotBaseType
public open class VisualShaderNodeParticleMeshEmitter : VisualShaderNodeParticleEmitter() {
  /**
   * The [Mesh] that defines emission shape.
   */
  public final inline var mesh: Mesh?
    @JvmName("meshProperty")
    get() = getMesh()
    @JvmName("meshProperty")
    set(`value`) {
      setMesh(value)
    }

  /**
   * If `true`, the particles will emit from all surfaces of the mesh.
   */
  public final inline var useAllSurfaces: Boolean
    @JvmName("useAllSurfacesProperty")
    get() = isUseAllSurfaces()
    @JvmName("useAllSurfacesProperty")
    set(`value`) {
      setUseAllSurfaces(value)
    }

  /**
   * Index of the surface that emits particles. [useAllSurfaces] must be `false` for this to take
   * effect.
   */
  public final inline var surfaceIndex: Int
    @JvmName("surfaceIndexProperty")
    get() = getSurfaceIndex()
    @JvmName("surfaceIndexProperty")
    set(`value`) {
      setSurfaceIndex(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(855, scriptPtr)
  }

  public final fun setMesh(mesh: Mesh?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, mesh)
    TransferContext.callMethod(MethodBindings.setMeshPtr)
  }

  public final fun getMesh(): Mesh? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMeshPtr)
    return (TransferContext.readReturnValue_OBJECT() as Mesh?)
  }

  public final fun setUseAllSurfaces(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setUseAllSurfacesPtr)
  }

  public final fun isUseAllSurfaces(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUseAllSurfacesPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setSurfaceIndex(surfaceIndex: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, surfaceIndex.toLong())
    TransferContext.callMethod(MethodBindings.setSurfaceIndexPtr)
  }

  public final fun getSurfaceIndex(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSurfaceIndexPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public companion object {
    @JvmField
    public val setMeshName: MethodStringName1<VisualShaderNodeParticleMeshEmitter, Unit, Mesh?> =
        MethodStringName1<VisualShaderNodeParticleMeshEmitter, Unit, Mesh?>("set_mesh")

    @JvmField
    public val getMeshName: MethodStringName0<VisualShaderNodeParticleMeshEmitter, Mesh?> =
        MethodStringName0<VisualShaderNodeParticleMeshEmitter, Mesh?>("get_mesh")

    @JvmField
    public val setUseAllSurfacesName:
        MethodStringName1<VisualShaderNodeParticleMeshEmitter, Unit, Boolean> =
        MethodStringName1<VisualShaderNodeParticleMeshEmitter, Unit, Boolean>("set_use_all_surfaces")

    @JvmField
    public val isUseAllSurfacesName: MethodStringName0<VisualShaderNodeParticleMeshEmitter, Boolean>
        = MethodStringName0<VisualShaderNodeParticleMeshEmitter, Boolean>("is_use_all_surfaces")

    @JvmField
    public val setSurfaceIndexName:
        MethodStringName1<VisualShaderNodeParticleMeshEmitter, Unit, Int> =
        MethodStringName1<VisualShaderNodeParticleMeshEmitter, Unit, Int>("set_surface_index")

    @JvmField
    public val getSurfaceIndexName: MethodStringName0<VisualShaderNodeParticleMeshEmitter, Int> =
        MethodStringName0<VisualShaderNodeParticleMeshEmitter, Int>("get_surface_index")
  }

  public object MethodBindings {
    internal val setMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParticleMeshEmitter", "set_mesh", 194775623)

    internal val getMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParticleMeshEmitter", "get_mesh", 1808005922)

    internal val setUseAllSurfacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParticleMeshEmitter", "set_use_all_surfaces", 2586408642)

    internal val isUseAllSurfacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParticleMeshEmitter", "is_use_all_surfaces", 36873697)

    internal val setSurfaceIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParticleMeshEmitter", "set_surface_index", 1286410249)

    internal val getSurfaceIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParticleMeshEmitter", "get_surface_index", 3905245786)
  }
}
