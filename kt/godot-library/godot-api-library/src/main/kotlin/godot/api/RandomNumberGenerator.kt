// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_DOUBLE_DOUBLE_ret_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_LONG_ret_LONG
import godot.callPtrMethod_PACKED_FLOAT_32_ARRAY_ret_LONG
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedFloat32Array
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * RandomNumberGenerator is a class for generating pseudo-random numbers. It currently uses
 * [url=https://www.pcg-random.org/]PCG32[/url].
 *
 * **Note:** The underlying algorithm is an implementation detail and should not be depended upon.
 *
 * To generate a random float number (within a given range) based on a time-dependent seed:
 *
 * ```
 * var rng = RandomNumberGenerator.new()
 * func _ready():
 * 	var my_random_number = rng.randf_range(-10.0, 10.0)
 * ```
 */
@GodotBaseType
public open class RandomNumberGenerator : RefCounted() {
  /**
   * Initializes the random number generator state based on the given seed value. A given seed will
   * give a reproducible sequence of pseudo-random numbers.
   *
   * **Note:** The RNG does not have an avalanche effect, and can output similar random streams
   * given similar seeds. Consider using a hash function to improve your seed quality if they're
   * sourced externally.
   *
   * **Note:** The default value of this property is pseudo-random, and changes when calling
   * [randomize]. The `0` value documented here is a placeholder, and not the actual default seed.
   *
   * **Note:** Setting this property produces a side effect of changing the internal [state], so
   * make sure to initialize the seed *before* modifying the [state]:
   *
   * ```
   * var rng = RandomNumberGenerator.new()
   * rng.seed = hash("Godot")
   * rng.state = 100 # Restore to some previously saved state.
   * ```
   */
  public final inline var seed: Long
    @JvmName("seedProperty")
    get() = getSeed()
    @JvmName("seedProperty")
    set(`value`) {
      setSeed(value)
    }

  /**
   * The current state of the random number generator. Save and restore this property to restore the
   * generator to a previous state:
   *
   * ```
   * var rng = RandomNumberGenerator.new()
   * print(rng.randf())
   * var saved_state = rng.state # Store current state.
   * print(rng.randf()) # Advance internal state.
   * rng.state = saved_state # Restore the state.
   * print(rng.randf()) # Prints the same value as previously.
   * ```
   *
   * **Note:** Do not set state to arbitrary values, since the random number generator requires the
   * state to have certain qualities to behave properly. It should only be set to values that came from
   * the state property itself. To initialize the random number generator with arbitrary input, use
   * [seed] instead.
   *
   * **Note:** The default value of this property is pseudo-random, and changes when calling
   * [randomize]. The `0` value documented here is a placeholder, and not the actual default state.
   */
  public final inline var state: Long
    @JvmName("stateProperty")
    get() = getState()
    @JvmName("stateProperty")
    set(`value`) {
      setState(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(597, scriptPtr)
  }

  public final fun setSeed(seed: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setSeedPtr, seed)
  }

  public final fun getSeed(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getSeedPtr)

  public final fun setState(state: Long): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setStatePtr, state)
  }

  public final fun getState(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getStatePtr)

  /**
   * Returns a pseudo-random 32-bit unsigned integer between `0` and `4294967295` (inclusive).
   */
  public final fun randi(): Long =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.randiPtr)

  /**
   * Returns a pseudo-random float between `0.0` and `1.0` (inclusive).
   */
  public final fun randf(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.randfPtr).toFloat()

  /**
   * Returns a [url=https://en.wikipedia.org/wiki/Normal_distribution]normally-distributed[/url],
   * pseudo-random floating-point number from the specified [mean] and a standard [deviation]. This is
   * also known as a Gaussian distribution.
   *
   * **Note:** This method uses the
   * [url=https://en.wikipedia.org/wiki/Box&#37;E2&#37;80&#37;93Muller_transform]Box-Muller
   * transform[/url] algorithm.
   */
  @JvmOverloads
  public final fun randfn(mean: Float = 0.0f, deviation: Float = 1.0f): Float =
      TransferContext.callPtrMethod_DOUBLE_DOUBLE_ret_DOUBLE(ptr, objectID.id, MethodBindings.randfnPtr, mean.toDouble(), deviation.toDouble()).toFloat()

  /**
   * Returns a pseudo-random float between [from] and [to] (inclusive).
   */
  public final fun randfRange(from: Float, to: Float): Float =
      TransferContext.callPtrMethod_DOUBLE_DOUBLE_ret_DOUBLE(ptr, objectID.id, MethodBindings.randfRangePtr, from.toDouble(), to.toDouble()).toFloat()

  /**
   * Returns a pseudo-random 32-bit signed integer between [from] and [to] (inclusive).
   */
  public final fun randiRange(from: Int, to: Int): Int =
      TransferContext.callPtrMethod_LONG_LONG_ret_LONG(ptr, objectID.id, MethodBindings.randiRangePtr, from.toLong(), to.toLong()).toInt()

  /**
   * Returns a random integer between `0` and the size of the array that is passed as a parameter.
   * Each value in the array should be a non-negative floating-point number that represents the
   * relative likelihood that it will be returned as an index. A higher value means the value is more
   * likely to be returned as an index, while a value of `0` means it will never be returned as an
   * index.
   *
   * For example, if [code skip-lint][0.5, 1, 1, 2][/code] is passed as a parameter, then the method
   * is twice as likely to return `3` (the index of the value `2`) and twice as unlikely to return `0`
   * (the index of the value `0.5`) compared to the indices `1` and `2`.
   *
   * Prints an error and returns `-1` if the array is empty or contains any negative values.
   *
   * ```gdscript
   * //gdscript
   * var rng = RandomNumberGenerator.new()
   *
   * var my_array = ["one", "two", "three", "four"]
   * var weights = PackedFloat32Array([0.5, 1, 1, 2])
   *
   * # Prints one of the four elements in `my_array`.
   * # It is more likely to print "four", and less likely to print "one".
   * print(my_array[rng.rand_weighted(weights)])
   * ```
   */
  public final fun randWeighted(weights: PackedFloat32Array): Long =
      TransferContext.callPtrMethod_PACKED_FLOAT_32_ARRAY_ret_LONG(ptr, objectID.id, MethodBindings.randWeightedPtr, weights)

  /**
   * Sets up a time-based seed for this [RandomNumberGenerator] instance. Unlike the [@GlobalScope]
   * random number generation functions, different [RandomNumberGenerator] instances can use different
   * seeds.
   */
  public final fun randomize(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.randomizePtr)
  }

  public companion object {
    @JvmField
    public val setSeedName: MethodStringName1<RandomNumberGenerator, Unit, Long> =
        MethodStringName1<RandomNumberGenerator, Unit, Long>("set_seed")

    @JvmField
    public val getSeedName: MethodStringName0<RandomNumberGenerator, Long> =
        MethodStringName0<RandomNumberGenerator, Long>("get_seed")

    @JvmField
    public val setStateName: MethodStringName1<RandomNumberGenerator, Unit, Long> =
        MethodStringName1<RandomNumberGenerator, Unit, Long>("set_state")

    @JvmField
    public val getStateName: MethodStringName0<RandomNumberGenerator, Long> =
        MethodStringName0<RandomNumberGenerator, Long>("get_state")

    @JvmField
    public val randiName: MethodStringName0<RandomNumberGenerator, Long> =
        MethodStringName0<RandomNumberGenerator, Long>("randi")

    @JvmField
    public val randfName: MethodStringName0<RandomNumberGenerator, Float> =
        MethodStringName0<RandomNumberGenerator, Float>("randf")

    @JvmField
    public val randfnName: MethodStringName2<RandomNumberGenerator, Float, Float, Float> =
        MethodStringName2<RandomNumberGenerator, Float, Float, Float>("randfn")

    @JvmField
    public val randfRangeName: MethodStringName2<RandomNumberGenerator, Float, Float, Float> =
        MethodStringName2<RandomNumberGenerator, Float, Float, Float>("randf_range")

    @JvmField
    public val randiRangeName: MethodStringName2<RandomNumberGenerator, Int, Int, Int> =
        MethodStringName2<RandomNumberGenerator, Int, Int, Int>("randi_range")

    @JvmField
    public val randWeightedName: MethodStringName1<RandomNumberGenerator, Long, PackedFloat32Array>
        = MethodStringName1<RandomNumberGenerator, Long, PackedFloat32Array>("rand_weighted")

    @JvmField
    public val randomizeName: MethodStringName0<RandomNumberGenerator, Unit> =
        MethodStringName0<RandomNumberGenerator, Unit>("randomize")
  }

  public object MethodBindings {
    internal val setSeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RandomNumberGenerator", "set_seed", 1286410249)

    internal val getSeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RandomNumberGenerator", "get_seed", 2455072627)

    internal val setStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RandomNumberGenerator", "set_state", 1286410249)

    internal val getStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RandomNumberGenerator", "get_state", 3905245786)

    internal val randiPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RandomNumberGenerator", "randi", 2455072627)

    internal val randfPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RandomNumberGenerator", "randf", 191475506)

    internal val randfnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RandomNumberGenerator", "randfn", 837325100)

    internal val randfRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RandomNumberGenerator", "randf_range", 4269894367)

    internal val randiRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RandomNumberGenerator", "randi_range", 50157827)

    internal val randWeightedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RandomNumberGenerator", "rand_weighted", 4189642986)

    internal val randomizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RandomNumberGenerator", "randomize", 3218959716)
  }
}
