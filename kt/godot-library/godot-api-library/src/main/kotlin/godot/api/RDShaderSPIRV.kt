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
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedByteArray
import godot.core.VariantParser.LONG
import godot.core.VariantParser.PACKED_BYTE_ARRAY
import godot.core.VariantParser.STRING
import kotlin.Byte
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [RDShaderSPIRV] represents an [RDShaderFile]'s [url=https://www.khronos.org/spir/]SPIR-V[/url]
 * code for various shader stages, as well as possible compilation error messages. SPIR-V is a
 * low-level intermediate shader representation. This intermediate representation is not used directly
 * by GPUs for rendering, but it can be compiled into binary shaders that GPUs can understand. Unlike
 * compiled shaders, SPIR-V is portable across GPU models and driver versions.
 *
 * This object is used by [RenderingDevice].
 */
@GodotBaseType
public open class RDShaderSPIRV : Resource() {
  /**
   * The SPIR-V bytecode for the vertex shader stage.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var bytecodeVertex: PackedByteArray
    @JvmName("bytecodeVertexProperty")
    get() = getStageBytecode(RenderingDevice.ShaderStage.VERTEX)
    @JvmName("bytecodeVertexProperty")
    set(`value`) {
      setStageBytecode(RenderingDevice.ShaderStage.VERTEX, value)
    }

  /**
   * The SPIR-V bytecode for the fragment shader stage.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var bytecodeFragment: PackedByteArray
    @JvmName("bytecodeFragmentProperty")
    get() = getStageBytecode(RenderingDevice.ShaderStage.FRAGMENT)
    @JvmName("bytecodeFragmentProperty")
    set(`value`) {
      setStageBytecode(RenderingDevice.ShaderStage.FRAGMENT, value)
    }

  /**
   * The SPIR-V bytecode for the tessellation control shader stage.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var bytecodeTesselationControl: PackedByteArray
    @JvmName("bytecodeTesselationControlProperty")
    get() = getStageBytecode(RenderingDevice.ShaderStage.TESSELATION_CONTROL)
    @JvmName("bytecodeTesselationControlProperty")
    set(`value`) {
      setStageBytecode(RenderingDevice.ShaderStage.TESSELATION_CONTROL, value)
    }

  /**
   * The SPIR-V bytecode for the tessellation evaluation shader stage.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var bytecodeTesselationEvaluation: PackedByteArray
    @JvmName("bytecodeTesselationEvaluationProperty")
    get() = getStageBytecode(RenderingDevice.ShaderStage.TESSELATION_EVALUATION)
    @JvmName("bytecodeTesselationEvaluationProperty")
    set(`value`) {
      setStageBytecode(RenderingDevice.ShaderStage.TESSELATION_EVALUATION, value)
    }

  /**
   * The SPIR-V bytecode for the compute shader stage.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var bytecodeCompute: PackedByteArray
    @JvmName("bytecodeComputeProperty")
    get() = getStageBytecode(RenderingDevice.ShaderStage.COMPUTE)
    @JvmName("bytecodeComputeProperty")
    set(`value`) {
      setStageBytecode(RenderingDevice.ShaderStage.COMPUTE, value)
    }

  /**
   * The SPIR-V bytecode for the ray generation shader stage.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var bytecodeRaygen: PackedByteArray
    @JvmName("bytecodeRaygenProperty")
    get() = getStageBytecode(RenderingDevice.ShaderStage.RAYGEN)
    @JvmName("bytecodeRaygenProperty")
    set(`value`) {
      setStageBytecode(RenderingDevice.ShaderStage.RAYGEN, value)
    }

  /**
   * The SPIR-V bytecode for the any hit shader stage.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var bytecodeAnyHit: PackedByteArray
    @JvmName("bytecodeAnyHitProperty")
    get() = getStageBytecode(RenderingDevice.ShaderStage.ANY_HIT)
    @JvmName("bytecodeAnyHitProperty")
    set(`value`) {
      setStageBytecode(RenderingDevice.ShaderStage.ANY_HIT, value)
    }

  /**
   * The SPIR-V bytecode for the closest hit shader stage.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var bytecodeClosestHit: PackedByteArray
    @JvmName("bytecodeClosestHitProperty")
    get() = getStageBytecode(RenderingDevice.ShaderStage.CLOSEST_HIT)
    @JvmName("bytecodeClosestHitProperty")
    set(`value`) {
      setStageBytecode(RenderingDevice.ShaderStage.CLOSEST_HIT, value)
    }

  /**
   * The SPIR-V bytecode for the miss shader stage.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var bytecodeMiss: PackedByteArray
    @JvmName("bytecodeMissProperty")
    get() = getStageBytecode(RenderingDevice.ShaderStage.MISS)
    @JvmName("bytecodeMissProperty")
    set(`value`) {
      setStageBytecode(RenderingDevice.ShaderStage.MISS, value)
    }

  /**
   * The SPIR-V bytecode for the intersection shader stage.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var bytecodeIntersection: PackedByteArray
    @JvmName("bytecodeIntersectionProperty")
    get() = getStageBytecode(RenderingDevice.ShaderStage.INTERSECTION)
    @JvmName("bytecodeIntersectionProperty")
    set(`value`) {
      setStageBytecode(RenderingDevice.ShaderStage.INTERSECTION, value)
    }

  /**
   * The compilation error message for the vertex shader stage (set by the SPIR-V compiler and
   * Godot). If empty, shader compilation was successful.
   */
  public final inline var compileErrorVertex: String
    @JvmName("compileErrorVertexProperty")
    get() = getStageCompileError(RenderingDevice.ShaderStage.VERTEX)
    @JvmName("compileErrorVertexProperty")
    set(`value`) {
      setStageCompileError(RenderingDevice.ShaderStage.VERTEX, value)
    }

  /**
   * The compilation error message for the fragment shader stage (set by the SPIR-V compiler and
   * Godot). If empty, shader compilation was successful.
   */
  public final inline var compileErrorFragment: String
    @JvmName("compileErrorFragmentProperty")
    get() = getStageCompileError(RenderingDevice.ShaderStage.FRAGMENT)
    @JvmName("compileErrorFragmentProperty")
    set(`value`) {
      setStageCompileError(RenderingDevice.ShaderStage.FRAGMENT, value)
    }

  /**
   * The compilation error message for the tessellation control shader stage (set by the SPIR-V
   * compiler and Godot). If empty, shader compilation was successful.
   */
  public final inline var compileErrorTesselationControl: String
    @JvmName("compileErrorTesselationControlProperty")
    get() = getStageCompileError(RenderingDevice.ShaderStage.TESSELATION_CONTROL)
    @JvmName("compileErrorTesselationControlProperty")
    set(`value`) {
      setStageCompileError(RenderingDevice.ShaderStage.TESSELATION_CONTROL, value)
    }

  /**
   * The compilation error message for the tessellation evaluation shader stage (set by the SPIR-V
   * compiler and Godot). If empty, shader compilation was successful.
   */
  public final inline var compileErrorTesselationEvaluation: String
    @JvmName("compileErrorTesselationEvaluationProperty")
    get() = getStageCompileError(RenderingDevice.ShaderStage.TESSELATION_EVALUATION)
    @JvmName("compileErrorTesselationEvaluationProperty")
    set(`value`) {
      setStageCompileError(RenderingDevice.ShaderStage.TESSELATION_EVALUATION, value)
    }

  /**
   * The compilation error message for the compute shader stage (set by the SPIR-V compiler and
   * Godot). If empty, shader compilation was successful.
   */
  public final inline var compileErrorCompute: String
    @JvmName("compileErrorComputeProperty")
    get() = getStageCompileError(RenderingDevice.ShaderStage.COMPUTE)
    @JvmName("compileErrorComputeProperty")
    set(`value`) {
      setStageCompileError(RenderingDevice.ShaderStage.COMPUTE, value)
    }

  /**
   * The compilation error message for the ray generation shader stage (set by the SPIR-V compiler
   * and Godot). If empty, shader compilation was successful.
   */
  public final inline var compileErrorRaygen: String
    @JvmName("compileErrorRaygenProperty")
    get() = getStageCompileError(RenderingDevice.ShaderStage.RAYGEN)
    @JvmName("compileErrorRaygenProperty")
    set(`value`) {
      setStageCompileError(RenderingDevice.ShaderStage.RAYGEN, value)
    }

  /**
   * The compilation error message for the any hit shader stage (set by the SPIR-V compiler and
   * Godot). If empty, shader compilation was successful.
   */
  public final inline var compileErrorAnyHit: String
    @JvmName("compileErrorAnyHitProperty")
    get() = getStageCompileError(RenderingDevice.ShaderStage.ANY_HIT)
    @JvmName("compileErrorAnyHitProperty")
    set(`value`) {
      setStageCompileError(RenderingDevice.ShaderStage.ANY_HIT, value)
    }

  /**
   * The compilation error message for the closest hit shader stage (set by the SPIR-V compiler and
   * Godot). If empty, shader compilation was successful.
   */
  public final inline var compileErrorClosestHit: String
    @JvmName("compileErrorClosestHitProperty")
    get() = getStageCompileError(RenderingDevice.ShaderStage.CLOSEST_HIT)
    @JvmName("compileErrorClosestHitProperty")
    set(`value`) {
      setStageCompileError(RenderingDevice.ShaderStage.CLOSEST_HIT, value)
    }

  /**
   * The compilation error message for the miss shader stage (set by the SPIR-V compiler and Godot).
   * If empty, shader compilation was successful.
   */
  public final inline var compileErrorMiss: String
    @JvmName("compileErrorMissProperty")
    get() = getStageCompileError(RenderingDevice.ShaderStage.MISS)
    @JvmName("compileErrorMissProperty")
    set(`value`) {
      setStageCompileError(RenderingDevice.ShaderStage.MISS, value)
    }

  /**
   * The compilation error message for the intersection shader stage (set by the SPIR-V compiler and
   * Godot). If empty, shader compilation was successful.
   */
  public final inline var compileErrorIntersection: String
    @JvmName("compileErrorIntersectionProperty")
    get() = getStageCompileError(RenderingDevice.ShaderStage.INTERSECTION)
    @JvmName("compileErrorIntersectionProperty")
    set(`value`) {
      setStageCompileError(RenderingDevice.ShaderStage.INTERSECTION, value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(592, scriptPtr)
  }

  /**
   * This is a helper function for [bytecodeVertex] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = rdshaderspirv.bytecodeVertex
   * //Your changes
   * rdshaderspirv.bytecodeVertex = myCoreType
   * ``````
   *
   * The SPIR-V bytecode for the vertex shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeVertexMutate(block: PackedByteArray.() -> Unit): PackedByteArray =
      bytecodeVertex.apply {
     block(this)
     bytecodeVertex = this
  }

  /**
   * This is a helper function for [bytecodeVertex] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The SPIR-V bytecode for the vertex shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeVertexMutateEach(block: (index: Int, `value`: Byte) -> Unit):
      PackedByteArray = bytecodeVertex.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     bytecodeVertex = this
  }

  /**
   * This is a helper function for [bytecodeFragment] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = rdshaderspirv.bytecodeFragment
   * //Your changes
   * rdshaderspirv.bytecodeFragment = myCoreType
   * ``````
   *
   * The SPIR-V bytecode for the fragment shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeFragmentMutate(block: PackedByteArray.() -> Unit): PackedByteArray =
      bytecodeFragment.apply {
     block(this)
     bytecodeFragment = this
  }

  /**
   * This is a helper function for [bytecodeFragment] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The SPIR-V bytecode for the fragment shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeFragmentMutateEach(block: (index: Int, `value`: Byte) -> Unit):
      PackedByteArray = bytecodeFragment.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     bytecodeFragment = this
  }

  /**
   * This is a helper function for [bytecodeTesselationControl] to make dealing with local copies
   * easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = rdshaderspirv.bytecodeTesselationControl
   * //Your changes
   * rdshaderspirv.bytecodeTesselationControl = myCoreType
   * ``````
   *
   * The SPIR-V bytecode for the tessellation control shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeTesselationControlMutate(block: PackedByteArray.() -> Unit):
      PackedByteArray = bytecodeTesselationControl.apply {
     block(this)
     bytecodeTesselationControl = this
  }

  /**
   * This is a helper function for [bytecodeTesselationControl] to make dealing with local copies
   * easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The SPIR-V bytecode for the tessellation control shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeTesselationControlMutateEach(block: (index: Int, `value`: Byte) -> Unit):
      PackedByteArray = bytecodeTesselationControl.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     bytecodeTesselationControl = this
  }

  /**
   * This is a helper function for [bytecodeTesselationEvaluation] to make dealing with local copies
   * easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = rdshaderspirv.bytecodeTesselationEvaluation
   * //Your changes
   * rdshaderspirv.bytecodeTesselationEvaluation = myCoreType
   * ``````
   *
   * The SPIR-V bytecode for the tessellation evaluation shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeTesselationEvaluationMutate(block: PackedByteArray.() -> Unit):
      PackedByteArray = bytecodeTesselationEvaluation.apply {
     block(this)
     bytecodeTesselationEvaluation = this
  }

  /**
   * This is a helper function for [bytecodeTesselationEvaluation] to make dealing with local copies
   * easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The SPIR-V bytecode for the tessellation evaluation shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeTesselationEvaluationMutateEach(block: (index: Int,
      `value`: Byte) -> Unit): PackedByteArray = bytecodeTesselationEvaluation.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     bytecodeTesselationEvaluation = this
  }

  /**
   * This is a helper function for [bytecodeCompute] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = rdshaderspirv.bytecodeCompute
   * //Your changes
   * rdshaderspirv.bytecodeCompute = myCoreType
   * ``````
   *
   * The SPIR-V bytecode for the compute shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeComputeMutate(block: PackedByteArray.() -> Unit): PackedByteArray =
      bytecodeCompute.apply {
     block(this)
     bytecodeCompute = this
  }

  /**
   * This is a helper function for [bytecodeCompute] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The SPIR-V bytecode for the compute shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeComputeMutateEach(block: (index: Int, `value`: Byte) -> Unit):
      PackedByteArray = bytecodeCompute.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     bytecodeCompute = this
  }

  /**
   * This is a helper function for [bytecodeRaygen] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = rdshaderspirv.bytecodeRaygen
   * //Your changes
   * rdshaderspirv.bytecodeRaygen = myCoreType
   * ``````
   *
   * The SPIR-V bytecode for the ray generation shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeRaygenMutate(block: PackedByteArray.() -> Unit): PackedByteArray =
      bytecodeRaygen.apply {
     block(this)
     bytecodeRaygen = this
  }

  /**
   * This is a helper function for [bytecodeRaygen] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The SPIR-V bytecode for the ray generation shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeRaygenMutateEach(block: (index: Int, `value`: Byte) -> Unit):
      PackedByteArray = bytecodeRaygen.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     bytecodeRaygen = this
  }

  /**
   * This is a helper function for [bytecodeAnyHit] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = rdshaderspirv.bytecodeAnyHit
   * //Your changes
   * rdshaderspirv.bytecodeAnyHit = myCoreType
   * ``````
   *
   * The SPIR-V bytecode for the any hit shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeAnyHitMutate(block: PackedByteArray.() -> Unit): PackedByteArray =
      bytecodeAnyHit.apply {
     block(this)
     bytecodeAnyHit = this
  }

  /**
   * This is a helper function for [bytecodeAnyHit] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The SPIR-V bytecode for the any hit shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeAnyHitMutateEach(block: (index: Int, `value`: Byte) -> Unit):
      PackedByteArray = bytecodeAnyHit.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     bytecodeAnyHit = this
  }

  /**
   * This is a helper function for [bytecodeClosestHit] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = rdshaderspirv.bytecodeClosestHit
   * //Your changes
   * rdshaderspirv.bytecodeClosestHit = myCoreType
   * ``````
   *
   * The SPIR-V bytecode for the closest hit shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeClosestHitMutate(block: PackedByteArray.() -> Unit): PackedByteArray =
      bytecodeClosestHit.apply {
     block(this)
     bytecodeClosestHit = this
  }

  /**
   * This is a helper function for [bytecodeClosestHit] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The SPIR-V bytecode for the closest hit shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeClosestHitMutateEach(block: (index: Int, `value`: Byte) -> Unit):
      PackedByteArray = bytecodeClosestHit.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     bytecodeClosestHit = this
  }

  /**
   * This is a helper function for [bytecodeMiss] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = rdshaderspirv.bytecodeMiss
   * //Your changes
   * rdshaderspirv.bytecodeMiss = myCoreType
   * ``````
   *
   * The SPIR-V bytecode for the miss shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeMissMutate(block: PackedByteArray.() -> Unit): PackedByteArray =
      bytecodeMiss.apply {
     block(this)
     bytecodeMiss = this
  }

  /**
   * This is a helper function for [bytecodeMiss] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The SPIR-V bytecode for the miss shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeMissMutateEach(block: (index: Int, `value`: Byte) -> Unit):
      PackedByteArray = bytecodeMiss.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     bytecodeMiss = this
  }

  /**
   * This is a helper function for [bytecodeIntersection] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = rdshaderspirv.bytecodeIntersection
   * //Your changes
   * rdshaderspirv.bytecodeIntersection = myCoreType
   * ``````
   *
   * The SPIR-V bytecode for the intersection shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeIntersectionMutate(block: PackedByteArray.() -> Unit): PackedByteArray =
      bytecodeIntersection.apply {
     block(this)
     bytecodeIntersection = this
  }

  /**
   * This is a helper function for [bytecodeIntersection] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The SPIR-V bytecode for the intersection shader stage.
   */
  @CoreTypeHelper
  public final fun bytecodeIntersectionMutateEach(block: (index: Int, `value`: Byte) -> Unit):
      PackedByteArray = bytecodeIntersection.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     bytecodeIntersection = this
  }

  /**
   * Sets the SPIR-V [bytecode] for the given shader [stage]. Equivalent to setting one of
   * [bytecodeCompute], [bytecodeFragment], [bytecodeTesselationControl],
   * [bytecodeTesselationEvaluation], [bytecodeVertex].
   */
  public final fun setStageBytecode(stage: RenderingDevice.ShaderStage, bytecode: PackedByteArray):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to stage.value, PACKED_BYTE_ARRAY to bytecode)
    TransferContext.callMethod(MethodBindings.setStageBytecodePtr)
  }

  /**
   * Equivalent to getting one of [bytecodeCompute], [bytecodeFragment],
   * [bytecodeTesselationControl], [bytecodeTesselationEvaluation], [bytecodeVertex].
   */
  public final fun getStageBytecode(stage: RenderingDevice.ShaderStage): PackedByteArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to stage.value)
    TransferContext.callMethod(MethodBindings.getStageBytecodePtr)
    return (TransferContext.readReturnValue(PACKED_BYTE_ARRAY) as PackedByteArray)
  }

  /**
   * Sets the compilation error message for the given shader [stage] to [compileError]. Equivalent
   * to setting one of [compileErrorCompute], [compileErrorFragment], [compileErrorTesselationControl],
   * [compileErrorTesselationEvaluation], [compileErrorVertex].
   */
  public final fun setStageCompileError(stage: RenderingDevice.ShaderStage, compileError: String):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to stage.value, STRING to compileError)
    TransferContext.callMethod(MethodBindings.setStageCompileErrorPtr)
  }

  /**
   * Returns the compilation error message for the given shader [stage]. Equivalent to getting one
   * of [compileErrorCompute], [compileErrorFragment], [compileErrorTesselationControl],
   * [compileErrorTesselationEvaluation], [compileErrorVertex].
   */
  public final fun getStageCompileError(stage: RenderingDevice.ShaderStage): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to stage.value)
    TransferContext.callMethod(MethodBindings.getStageCompileErrorPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public companion object {
    @JvmField
    public val setStageBytecodeName:
        MethodStringName2<RDShaderSPIRV, Unit, RenderingDevice.ShaderStage, PackedByteArray> =
        MethodStringName2<RDShaderSPIRV, Unit, RenderingDevice.ShaderStage, PackedByteArray>("set_stage_bytecode")

    @JvmField
    public val getStageBytecodeName:
        MethodStringName1<RDShaderSPIRV, PackedByteArray, RenderingDevice.ShaderStage> =
        MethodStringName1<RDShaderSPIRV, PackedByteArray, RenderingDevice.ShaderStage>("get_stage_bytecode")

    @JvmField
    public val setStageCompileErrorName:
        MethodStringName2<RDShaderSPIRV, Unit, RenderingDevice.ShaderStage, String> =
        MethodStringName2<RDShaderSPIRV, Unit, RenderingDevice.ShaderStage, String>("set_stage_compile_error")

    @JvmField
    public val getStageCompileErrorName:
        MethodStringName1<RDShaderSPIRV, String, RenderingDevice.ShaderStage> =
        MethodStringName1<RDShaderSPIRV, String, RenderingDevice.ShaderStage>("get_stage_compile_error")
  }

  public object MethodBindings {
    internal val setStageBytecodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDShaderSPIRV", "set_stage_bytecode", 3514097977)

    internal val getStageBytecodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDShaderSPIRV", "get_stage_bytecode", 3816765404)

    internal val setStageCompileErrorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDShaderSPIRV", "set_stage_compile_error", 620821314)

    internal val getStageCompileErrorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDShaderSPIRV", "get_stage_compile_error", 3354920045)
  }
}
