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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
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
 * This class generates noise using the FastNoiseLite library, which is a collection of several
 * noise algorithms including Cellular, Perlin, Value, and more.
 *
 * Most generated noise values are in the range of `[-1, 1]`, but not always. Some of the cellular
 * noise algorithms return results above `1`.
 */
@GodotBaseType
public open class FastNoiseLite : Noise() {
  /**
   * The noise algorithm used.
   */
  public final inline var noiseType: NoiseType
    @JvmName("noiseTypeProperty")
    get() = getNoiseType()
    @JvmName("noiseTypeProperty")
    set(`value`) {
      setNoiseType(value)
    }

  /**
   * The random number seed for all noise types.
   */
  public final inline var seed: Int
    @JvmName("seedProperty")
    get() = getSeed()
    @JvmName("seedProperty")
    set(`value`) {
      setSeed(value)
    }

  /**
   * The frequency for all noise types. Low frequency results in smooth noise while high frequency
   * results in rougher, more granular noise.
   */
  public final inline var frequency: Float
    @JvmName("frequencyProperty")
    get() = getFrequency()
    @JvmName("frequencyProperty")
    set(`value`) {
      setFrequency(value)
    }

  /**
   * Translate the noise input coordinates by the given [Vector3].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var offset: Vector3
    @JvmName("offsetProperty")
    get() = getOffset()
    @JvmName("offsetProperty")
    set(`value`) {
      setOffset(value)
    }

  /**
   * The method for combining octaves into a fractal.
   */
  public final inline var fractalType: FractalType
    @JvmName("fractalTypeProperty")
    get() = getFractalType()
    @JvmName("fractalTypeProperty")
    set(`value`) {
      setFractalType(value)
    }

  /**
   * The number of noise layers that are sampled to get the final value for fractal noise types.
   */
  public final inline var fractalOctaves: Int
    @JvmName("fractalOctavesProperty")
    get() = getFractalOctaves()
    @JvmName("fractalOctavesProperty")
    set(`value`) {
      setFractalOctaves(value)
    }

  /**
   * Frequency multiplier between subsequent octaves. Increasing this value results in higher
   * octaves producing noise with finer details and a rougher appearance.
   */
  public final inline var fractalLacunarity: Float
    @JvmName("fractalLacunarityProperty")
    get() = getFractalLacunarity()
    @JvmName("fractalLacunarityProperty")
    set(`value`) {
      setFractalLacunarity(value)
    }

  /**
   * Determines the strength of each subsequent layer of noise in fractal noise.
   *
   * A low value places more emphasis on the lower frequency base layers, while a high value puts
   * more emphasis on the higher frequency layers.
   */
  public final inline var fractalGain: Float
    @JvmName("fractalGainProperty")
    get() = getFractalGain()
    @JvmName("fractalGainProperty")
    set(`value`) {
      setFractalGain(value)
    }

  /**
   * Higher weighting means higher octaves have less impact if lower octaves have a large impact.
   */
  public final inline var fractalWeightedStrength: Float
    @JvmName("fractalWeightedStrengthProperty")
    get() = getFractalWeightedStrength()
    @JvmName("fractalWeightedStrengthProperty")
    set(`value`) {
      setFractalWeightedStrength(value)
    }

  /**
   * Sets the strength of the fractal ping pong type.
   */
  public final inline var fractalPingPongStrength: Float
    @JvmName("fractalPingPongStrengthProperty")
    get() = getFractalPingPongStrength()
    @JvmName("fractalPingPongStrengthProperty")
    set(`value`) {
      setFractalPingPongStrength(value)
    }

  /**
   * Determines how the distance to the nearest/second-nearest point is computed.
   */
  public final inline var cellularDistanceFunction: CellularDistanceFunction
    @JvmName("cellularDistanceFunctionProperty")
    get() = getCellularDistanceFunction()
    @JvmName("cellularDistanceFunctionProperty")
    set(`value`) {
      setCellularDistanceFunction(value)
    }

  /**
   * Maximum distance a point can move off of its grid position. Set to `0` for an even grid.
   */
  public final inline var cellularJitter: Float
    @JvmName("cellularJitterProperty")
    get() = getCellularJitter()
    @JvmName("cellularJitterProperty")
    set(`value`) {
      setCellularJitter(value)
    }

  /**
   * Return type from cellular noise calculations.
   */
  public final inline var cellularReturnType: CellularReturnType
    @JvmName("cellularReturnTypeProperty")
    get() = getCellularReturnType()
    @JvmName("cellularReturnTypeProperty")
    set(`value`) {
      setCellularReturnType(value)
    }

  /**
   * If enabled, another FastNoiseLite instance is used to warp the space, resulting in a distortion
   * of the noise.
   */
  public final inline var domainWarpEnabled: Boolean
    @JvmName("domainWarpEnabledProperty")
    get() = isDomainWarpEnabled()
    @JvmName("domainWarpEnabledProperty")
    set(`value`) {
      setDomainWarpEnabled(value)
    }

  /**
   * The warp algorithm.
   */
  public final inline var domainWarpType: DomainWarpType
    @JvmName("domainWarpTypeProperty")
    get() = getDomainWarpType()
    @JvmName("domainWarpTypeProperty")
    set(`value`) {
      setDomainWarpType(value)
    }

  /**
   * Sets the maximum warp distance from the origin.
   */
  public final inline var domainWarpAmplitude: Float
    @JvmName("domainWarpAmplitudeProperty")
    get() = getDomainWarpAmplitude()
    @JvmName("domainWarpAmplitudeProperty")
    set(`value`) {
      setDomainWarpAmplitude(value)
    }

  /**
   * Frequency of the noise which warps the space. Low frequency results in smooth noise while high
   * frequency results in rougher, more granular noise.
   */
  public final inline var domainWarpFrequency: Float
    @JvmName("domainWarpFrequencyProperty")
    get() = getDomainWarpFrequency()
    @JvmName("domainWarpFrequencyProperty")
    set(`value`) {
      setDomainWarpFrequency(value)
    }

  /**
   * The method for combining octaves into a fractal which is used to warp the space.
   */
  public final inline var domainWarpFractalType: DomainWarpFractalType
    @JvmName("domainWarpFractalTypeProperty")
    get() = getDomainWarpFractalType()
    @JvmName("domainWarpFractalTypeProperty")
    set(`value`) {
      setDomainWarpFractalType(value)
    }

  /**
   * The number of noise layers that are sampled to get the final value for the fractal noise which
   * warps the space.
   */
  public final inline var domainWarpFractalOctaves: Int
    @JvmName("domainWarpFractalOctavesProperty")
    get() = getDomainWarpFractalOctaves()
    @JvmName("domainWarpFractalOctavesProperty")
    set(`value`) {
      setDomainWarpFractalOctaves(value)
    }

  /**
   * The change in frequency between octaves, also known as "lacunarity", of the fractal noise which
   * warps the space. Increasing this value results in higher octaves, producing noise with finer
   * details and a rougher appearance.
   */
  public final inline var domainWarpFractalLacunarity: Float
    @JvmName("domainWarpFractalLacunarityProperty")
    get() = getDomainWarpFractalLacunarity()
    @JvmName("domainWarpFractalLacunarityProperty")
    set(`value`) {
      setDomainWarpFractalLacunarity(value)
    }

  /**
   * Determines the strength of each subsequent layer of the noise which is used to warp the space.
   *
   * A low value places more emphasis on the lower frequency base layers, while a high value puts
   * more emphasis on the higher frequency layers.
   */
  public final inline var domainWarpFractalGain: Float
    @JvmName("domainWarpFractalGainProperty")
    get() = getDomainWarpFractalGain()
    @JvmName("domainWarpFractalGainProperty")
    set(`value`) {
      setDomainWarpFractalGain(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(225, scriptPtr)
  }

  /**
   * This is a helper function for [offset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = fastnoiselite.offset
   * //Your changes
   * fastnoiselite.offset = myCoreType
   * ``````
   *
   * Translate the noise input coordinates by the given [Vector3].
   */
  @CoreTypeHelper
  public final fun offsetMutate(block: Vector3.() -> Unit): Vector3 = offset.apply {
     block(this)
     offset = this
  }

  public final fun setNoiseType(type: NoiseType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value)
    TransferContext.callMethod(MethodBindings.setNoiseTypePtr)
  }

  public final fun getNoiseType(): NoiseType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNoiseTypePtr)
    return NoiseType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSeed(seed: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to seed.toLong())
    TransferContext.callMethod(MethodBindings.setSeedPtr)
  }

  public final fun getSeed(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSeedPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setFrequency(freq: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to freq.toDouble())
    TransferContext.callMethod(MethodBindings.setFrequencyPtr)
  }

  public final fun getFrequency(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFrequencyPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setOffset(offset: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to offset)
    TransferContext.callMethod(MethodBindings.setOffsetPtr)
  }

  public final fun getOffset(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOffsetPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setFractalType(type: FractalType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value)
    TransferContext.callMethod(MethodBindings.setFractalTypePtr)
  }

  public final fun getFractalType(): FractalType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFractalTypePtr)
    return FractalType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setFractalOctaves(octaveCount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to octaveCount.toLong())
    TransferContext.callMethod(MethodBindings.setFractalOctavesPtr)
  }

  public final fun getFractalOctaves(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFractalOctavesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setFractalLacunarity(lacunarity: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to lacunarity.toDouble())
    TransferContext.callMethod(MethodBindings.setFractalLacunarityPtr)
  }

  public final fun getFractalLacunarity(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFractalLacunarityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFractalGain(gain: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to gain.toDouble())
    TransferContext.callMethod(MethodBindings.setFractalGainPtr)
  }

  public final fun getFractalGain(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFractalGainPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFractalWeightedStrength(weightedStrength: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to weightedStrength.toDouble())
    TransferContext.callMethod(MethodBindings.setFractalWeightedStrengthPtr)
  }

  public final fun getFractalWeightedStrength(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFractalWeightedStrengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFractalPingPongStrength(pingPongStrength: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to pingPongStrength.toDouble())
    TransferContext.callMethod(MethodBindings.setFractalPingPongStrengthPtr)
  }

  public final fun getFractalPingPongStrength(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFractalPingPongStrengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setCellularDistanceFunction(func: CellularDistanceFunction): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to func.value)
    TransferContext.callMethod(MethodBindings.setCellularDistanceFunctionPtr)
  }

  public final fun getCellularDistanceFunction(): CellularDistanceFunction {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCellularDistanceFunctionPtr)
    return CellularDistanceFunction.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setCellularJitter(jitter: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to jitter.toDouble())
    TransferContext.callMethod(MethodBindings.setCellularJitterPtr)
  }

  public final fun getCellularJitter(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCellularJitterPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setCellularReturnType(ret: CellularReturnType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to ret.value)
    TransferContext.callMethod(MethodBindings.setCellularReturnTypePtr)
  }

  public final fun getCellularReturnType(): CellularReturnType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCellularReturnTypePtr)
    return CellularReturnType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setDomainWarpEnabled(domainWarpEnabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to domainWarpEnabled)
    TransferContext.callMethod(MethodBindings.setDomainWarpEnabledPtr)
  }

  public final fun isDomainWarpEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDomainWarpEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDomainWarpType(domainWarpType: DomainWarpType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to domainWarpType.value)
    TransferContext.callMethod(MethodBindings.setDomainWarpTypePtr)
  }

  public final fun getDomainWarpType(): DomainWarpType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDomainWarpTypePtr)
    return DomainWarpType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setDomainWarpAmplitude(domainWarpAmplitude: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to domainWarpAmplitude.toDouble())
    TransferContext.callMethod(MethodBindings.setDomainWarpAmplitudePtr)
  }

  public final fun getDomainWarpAmplitude(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDomainWarpAmplitudePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setDomainWarpFrequency(domainWarpFrequency: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to domainWarpFrequency.toDouble())
    TransferContext.callMethod(MethodBindings.setDomainWarpFrequencyPtr)
  }

  public final fun getDomainWarpFrequency(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDomainWarpFrequencyPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setDomainWarpFractalType(domainWarpFractalType: DomainWarpFractalType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to domainWarpFractalType.value)
    TransferContext.callMethod(MethodBindings.setDomainWarpFractalTypePtr)
  }

  public final fun getDomainWarpFractalType(): DomainWarpFractalType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDomainWarpFractalTypePtr)
    return DomainWarpFractalType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setDomainWarpFractalOctaves(domainWarpOctaveCount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to domainWarpOctaveCount.toLong())
    TransferContext.callMethod(MethodBindings.setDomainWarpFractalOctavesPtr)
  }

  public final fun getDomainWarpFractalOctaves(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDomainWarpFractalOctavesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setDomainWarpFractalLacunarity(domainWarpLacunarity: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to domainWarpLacunarity.toDouble())
    TransferContext.callMethod(MethodBindings.setDomainWarpFractalLacunarityPtr)
  }

  public final fun getDomainWarpFractalLacunarity(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDomainWarpFractalLacunarityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setDomainWarpFractalGain(domainWarpGain: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to domainWarpGain.toDouble())
    TransferContext.callMethod(MethodBindings.setDomainWarpFractalGainPtr)
  }

  public final fun getDomainWarpFractalGain(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDomainWarpFractalGainPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public enum class NoiseType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * A lattice of points are assigned random values then interpolated based on neighboring values.
     */
    TYPE_VALUE(5),
    /**
     * Similar to value noise ([TYPE_VALUE]), but slower. Has more variance in peaks and valleys.
     *
     * Cubic noise can be used to avoid certain artifacts when using value noise to create a
     * bumpmap. In general, you should always use this mode if the value noise is being used for a
     * heightmap or bumpmap.
     */
    TYPE_VALUE_CUBIC(4),
    /**
     * A lattice of random gradients. Their dot products are interpolated to obtain values in
     * between the lattices.
     */
    TYPE_PERLIN(3),
    /**
     * Cellular includes both Worley noise and Voronoi diagrams which creates various regions of the
     * same value.
     */
    TYPE_CELLULAR(2),
    /**
     * As opposed to [TYPE_PERLIN], gradients exist in a simplex lattice rather than a grid lattice,
     * avoiding directional artifacts. Internally uses FastNoiseLite's OpenSimplex2 noise type.
     */
    TYPE_SIMPLEX(0),
    /**
     * Modified, higher quality version of [TYPE_SIMPLEX], but slower. Internally uses
     * FastNoiseLite's OpenSimplex2S noise type.
     */
    TYPE_SIMPLEX_SMOOTH(1),
    ;

    public companion object {
      public fun from(`value`: Long): NoiseType = entries.single { it.`value` == `value` }
    }
  }

  public enum class FractalType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * No fractal noise.
     */
    NONE(0),
    /**
     * Method using Fractional Brownian Motion to combine octaves into a fractal.
     */
    FBM(1),
    /**
     * Method of combining octaves into a fractal resulting in a "ridged" look.
     */
    RIDGED(2),
    /**
     * Method of combining octaves into a fractal with a ping pong effect.
     */
    PING_PONG(3),
    ;

    public companion object {
      public fun from(`value`: Long): FractalType = entries.single { it.`value` == `value` }
    }
  }

  public enum class CellularDistanceFunction(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Euclidean distance to the nearest point.
     */
    DISTANCE_EUCLIDEAN(0),
    /**
     * Squared Euclidean distance to the nearest point.
     */
    DISTANCE_EUCLIDEAN_SQUARED(1),
    /**
     * Manhattan distance (taxicab metric) to the nearest point.
     */
    DISTANCE_MANHATTAN(2),
    /**
     * Blend of [DISTANCE_EUCLIDEAN] and [DISTANCE_MANHATTAN] to give curved cell boundaries.
     */
    DISTANCE_HYBRID(3),
    ;

    public companion object {
      public fun from(`value`: Long): CellularDistanceFunction =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class CellularReturnType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The cellular distance function will return the same value for all points within a cell.
     */
    RETURN_CELL_VALUE(0),
    /**
     * The cellular distance function will return a value determined by the distance to the nearest
     * point.
     */
    RETURN_DISTANCE(1),
    /**
     * The cellular distance function returns the distance to the second-nearest point.
     */
    RETURN_DISTANCE2(2),
    /**
     * The distance to the nearest point is added to the distance to the second-nearest point.
     */
    RETURN_DISTANCE2_ADD(3),
    /**
     * The distance to the nearest point is subtracted from the distance to the second-nearest
     * point.
     */
    RETURN_DISTANCE2_SUB(4),
    /**
     * The distance to the nearest point is multiplied with the distance to the second-nearest
     * point.
     */
    RETURN_DISTANCE2_MUL(5),
    /**
     * The distance to the nearest point is divided by the distance to the second-nearest point.
     */
    RETURN_DISTANCE2_DIV(6),
    ;

    public companion object {
      public fun from(`value`: Long): CellularReturnType = entries.single { it.`value` == `value` }
    }
  }

  public enum class DomainWarpType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The domain is warped using the simplex noise algorithm.
     */
    SIMPLEX(0),
    /**
     * The domain is warped using a simplified version of the simplex noise algorithm.
     */
    SIMPLEX_REDUCED(1),
    /**
     * The domain is warped using a simple noise grid (not as smooth as the other methods, but more
     * performant).
     */
    BASIC_GRID(2),
    ;

    public companion object {
      public fun from(`value`: Long): DomainWarpType = entries.single { it.`value` == `value` }
    }
  }

  public enum class DomainWarpFractalType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * No fractal noise for warping the space.
     */
    NONE(0),
    /**
     * Warping the space progressively, octave for octave, resulting in a more "liquified"
     * distortion.
     */
    PROGRESSIVE(1),
    /**
     * Warping the space independently for each octave, resulting in a more chaotic distortion.
     */
    INDEPENDENT(2),
    ;

    public companion object {
      public fun from(`value`: Long): DomainWarpFractalType =
          entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setNoiseTypeName: MethodStringName1<FastNoiseLite, Unit, NoiseType> =
        MethodStringName1<FastNoiseLite, Unit, NoiseType>("set_noise_type")

    @JvmField
    public val getNoiseTypeName: MethodStringName0<FastNoiseLite, NoiseType> =
        MethodStringName0<FastNoiseLite, NoiseType>("get_noise_type")

    @JvmField
    public val setSeedName: MethodStringName1<FastNoiseLite, Unit, Int> =
        MethodStringName1<FastNoiseLite, Unit, Int>("set_seed")

    @JvmField
    public val getSeedName: MethodStringName0<FastNoiseLite, Int> =
        MethodStringName0<FastNoiseLite, Int>("get_seed")

    @JvmField
    public val setFrequencyName: MethodStringName1<FastNoiseLite, Unit, Float> =
        MethodStringName1<FastNoiseLite, Unit, Float>("set_frequency")

    @JvmField
    public val getFrequencyName: MethodStringName0<FastNoiseLite, Float> =
        MethodStringName0<FastNoiseLite, Float>("get_frequency")

    @JvmField
    public val setOffsetName: MethodStringName1<FastNoiseLite, Unit, Vector3> =
        MethodStringName1<FastNoiseLite, Unit, Vector3>("set_offset")

    @JvmField
    public val getOffsetName: MethodStringName0<FastNoiseLite, Vector3> =
        MethodStringName0<FastNoiseLite, Vector3>("get_offset")

    @JvmField
    public val setFractalTypeName: MethodStringName1<FastNoiseLite, Unit, FractalType> =
        MethodStringName1<FastNoiseLite, Unit, FractalType>("set_fractal_type")

    @JvmField
    public val getFractalTypeName: MethodStringName0<FastNoiseLite, FractalType> =
        MethodStringName0<FastNoiseLite, FractalType>("get_fractal_type")

    @JvmField
    public val setFractalOctavesName: MethodStringName1<FastNoiseLite, Unit, Int> =
        MethodStringName1<FastNoiseLite, Unit, Int>("set_fractal_octaves")

    @JvmField
    public val getFractalOctavesName: MethodStringName0<FastNoiseLite, Int> =
        MethodStringName0<FastNoiseLite, Int>("get_fractal_octaves")

    @JvmField
    public val setFractalLacunarityName: MethodStringName1<FastNoiseLite, Unit, Float> =
        MethodStringName1<FastNoiseLite, Unit, Float>("set_fractal_lacunarity")

    @JvmField
    public val getFractalLacunarityName: MethodStringName0<FastNoiseLite, Float> =
        MethodStringName0<FastNoiseLite, Float>("get_fractal_lacunarity")

    @JvmField
    public val setFractalGainName: MethodStringName1<FastNoiseLite, Unit, Float> =
        MethodStringName1<FastNoiseLite, Unit, Float>("set_fractal_gain")

    @JvmField
    public val getFractalGainName: MethodStringName0<FastNoiseLite, Float> =
        MethodStringName0<FastNoiseLite, Float>("get_fractal_gain")

    @JvmField
    public val setFractalWeightedStrengthName: MethodStringName1<FastNoiseLite, Unit, Float> =
        MethodStringName1<FastNoiseLite, Unit, Float>("set_fractal_weighted_strength")

    @JvmField
    public val getFractalWeightedStrengthName: MethodStringName0<FastNoiseLite, Float> =
        MethodStringName0<FastNoiseLite, Float>("get_fractal_weighted_strength")

    @JvmField
    public val setFractalPingPongStrengthName: MethodStringName1<FastNoiseLite, Unit, Float> =
        MethodStringName1<FastNoiseLite, Unit, Float>("set_fractal_ping_pong_strength")

    @JvmField
    public val getFractalPingPongStrengthName: MethodStringName0<FastNoiseLite, Float> =
        MethodStringName0<FastNoiseLite, Float>("get_fractal_ping_pong_strength")

    @JvmField
    public val setCellularDistanceFunctionName:
        MethodStringName1<FastNoiseLite, Unit, CellularDistanceFunction> =
        MethodStringName1<FastNoiseLite, Unit, CellularDistanceFunction>("set_cellular_distance_function")

    @JvmField
    public val getCellularDistanceFunctionName:
        MethodStringName0<FastNoiseLite, CellularDistanceFunction> =
        MethodStringName0<FastNoiseLite, CellularDistanceFunction>("get_cellular_distance_function")

    @JvmField
    public val setCellularJitterName: MethodStringName1<FastNoiseLite, Unit, Float> =
        MethodStringName1<FastNoiseLite, Unit, Float>("set_cellular_jitter")

    @JvmField
    public val getCellularJitterName: MethodStringName0<FastNoiseLite, Float> =
        MethodStringName0<FastNoiseLite, Float>("get_cellular_jitter")

    @JvmField
    public val setCellularReturnTypeName: MethodStringName1<FastNoiseLite, Unit, CellularReturnType>
        = MethodStringName1<FastNoiseLite, Unit, CellularReturnType>("set_cellular_return_type")

    @JvmField
    public val getCellularReturnTypeName: MethodStringName0<FastNoiseLite, CellularReturnType> =
        MethodStringName0<FastNoiseLite, CellularReturnType>("get_cellular_return_type")

    @JvmField
    public val setDomainWarpEnabledName: MethodStringName1<FastNoiseLite, Unit, Boolean> =
        MethodStringName1<FastNoiseLite, Unit, Boolean>("set_domain_warp_enabled")

    @JvmField
    public val isDomainWarpEnabledName: MethodStringName0<FastNoiseLite, Boolean> =
        MethodStringName0<FastNoiseLite, Boolean>("is_domain_warp_enabled")

    @JvmField
    public val setDomainWarpTypeName: MethodStringName1<FastNoiseLite, Unit, DomainWarpType> =
        MethodStringName1<FastNoiseLite, Unit, DomainWarpType>("set_domain_warp_type")

    @JvmField
    public val getDomainWarpTypeName: MethodStringName0<FastNoiseLite, DomainWarpType> =
        MethodStringName0<FastNoiseLite, DomainWarpType>("get_domain_warp_type")

    @JvmField
    public val setDomainWarpAmplitudeName: MethodStringName1<FastNoiseLite, Unit, Float> =
        MethodStringName1<FastNoiseLite, Unit, Float>("set_domain_warp_amplitude")

    @JvmField
    public val getDomainWarpAmplitudeName: MethodStringName0<FastNoiseLite, Float> =
        MethodStringName0<FastNoiseLite, Float>("get_domain_warp_amplitude")

    @JvmField
    public val setDomainWarpFrequencyName: MethodStringName1<FastNoiseLite, Unit, Float> =
        MethodStringName1<FastNoiseLite, Unit, Float>("set_domain_warp_frequency")

    @JvmField
    public val getDomainWarpFrequencyName: MethodStringName0<FastNoiseLite, Float> =
        MethodStringName0<FastNoiseLite, Float>("get_domain_warp_frequency")

    @JvmField
    public val setDomainWarpFractalTypeName:
        MethodStringName1<FastNoiseLite, Unit, DomainWarpFractalType> =
        MethodStringName1<FastNoiseLite, Unit, DomainWarpFractalType>("set_domain_warp_fractal_type")

    @JvmField
    public val getDomainWarpFractalTypeName: MethodStringName0<FastNoiseLite, DomainWarpFractalType>
        = MethodStringName0<FastNoiseLite, DomainWarpFractalType>("get_domain_warp_fractal_type")

    @JvmField
    public val setDomainWarpFractalOctavesName: MethodStringName1<FastNoiseLite, Unit, Int> =
        MethodStringName1<FastNoiseLite, Unit, Int>("set_domain_warp_fractal_octaves")

    @JvmField
    public val getDomainWarpFractalOctavesName: MethodStringName0<FastNoiseLite, Int> =
        MethodStringName0<FastNoiseLite, Int>("get_domain_warp_fractal_octaves")

    @JvmField
    public val setDomainWarpFractalLacunarityName: MethodStringName1<FastNoiseLite, Unit, Float> =
        MethodStringName1<FastNoiseLite, Unit, Float>("set_domain_warp_fractal_lacunarity")

    @JvmField
    public val getDomainWarpFractalLacunarityName: MethodStringName0<FastNoiseLite, Float> =
        MethodStringName0<FastNoiseLite, Float>("get_domain_warp_fractal_lacunarity")

    @JvmField
    public val setDomainWarpFractalGainName: MethodStringName1<FastNoiseLite, Unit, Float> =
        MethodStringName1<FastNoiseLite, Unit, Float>("set_domain_warp_fractal_gain")

    @JvmField
    public val getDomainWarpFractalGainName: MethodStringName0<FastNoiseLite, Float> =
        MethodStringName0<FastNoiseLite, Float>("get_domain_warp_fractal_gain")
  }

  public object MethodBindings {
    internal val setNoiseTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_noise_type", 2624461392)

    internal val getNoiseTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_noise_type", 1458108610)

    internal val setSeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_seed", 1286410249)

    internal val getSeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_seed", 3905245786)

    internal val setFrequencyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_frequency", 373806689)

    internal val getFrequencyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_frequency", 1740695150)

    internal val setOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_offset", 3460891852)

    internal val getOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_offset", 3360562783)

    internal val setFractalTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_fractal_type", 4132731174)

    internal val getFractalTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_fractal_type", 1036889279)

    internal val setFractalOctavesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_fractal_octaves", 1286410249)

    internal val getFractalOctavesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_fractal_octaves", 3905245786)

    internal val setFractalLacunarityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_fractal_lacunarity", 373806689)

    internal val getFractalLacunarityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_fractal_lacunarity", 1740695150)

    internal val setFractalGainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_fractal_gain", 373806689)

    internal val getFractalGainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_fractal_gain", 1740695150)

    internal val setFractalWeightedStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_fractal_weighted_strength", 373806689)

    internal val getFractalWeightedStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_fractal_weighted_strength", 1740695150)

    internal val setFractalPingPongStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_fractal_ping_pong_strength", 373806689)

    internal val getFractalPingPongStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_fractal_ping_pong_strength", 1740695150)

    internal val setCellularDistanceFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_cellular_distance_function", 1006013267)

    internal val getCellularDistanceFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_cellular_distance_function", 2021274088)

    internal val setCellularJitterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_cellular_jitter", 373806689)

    internal val getCellularJitterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_cellular_jitter", 1740695150)

    internal val setCellularReturnTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_cellular_return_type", 2654169698)

    internal val getCellularReturnTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_cellular_return_type", 3699796343)

    internal val setDomainWarpEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_domain_warp_enabled", 2586408642)

    internal val isDomainWarpEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "is_domain_warp_enabled", 36873697)

    internal val setDomainWarpTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_domain_warp_type", 3629692980)

    internal val getDomainWarpTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_domain_warp_type", 2980162020)

    internal val setDomainWarpAmplitudePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_domain_warp_amplitude", 373806689)

    internal val getDomainWarpAmplitudePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_domain_warp_amplitude", 1740695150)

    internal val setDomainWarpFrequencyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_domain_warp_frequency", 373806689)

    internal val getDomainWarpFrequencyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_domain_warp_frequency", 1740695150)

    internal val setDomainWarpFractalTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_domain_warp_fractal_type", 3999408287)

    internal val getDomainWarpFractalTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_domain_warp_fractal_type", 407716934)

    internal val setDomainWarpFractalOctavesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_domain_warp_fractal_octaves", 1286410249)

    internal val getDomainWarpFractalOctavesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_domain_warp_fractal_octaves", 3905245786)

    internal val setDomainWarpFractalLacunarityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_domain_warp_fractal_lacunarity", 373806689)

    internal val getDomainWarpFractalLacunarityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_domain_warp_fractal_lacunarity", 1740695150)

    internal val setDomainWarpFractalGainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "set_domain_warp_fractal_gain", 373806689)

    internal val getDomainWarpFractalGainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("FastNoiseLite", "get_domain_warp_fractal_gain", 1740695150)
  }
}
