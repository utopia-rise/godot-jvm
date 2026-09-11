package godot.inspection

import godot.annotation.Register
import godot.annotation.Script
import godot.annotation.Visible
import godot.api.Node
import godot.core.Dictionary
import godot.core.VariantArray
import godot.core.VariantCaster
import godot.core.VariantParser
import godot.core.dictionaryOf
import godot.core.lambdaCallable1
import godot.core.variantArrayOf

// Container registration cases. Every declaration but the last callable
// reference is expected to be free of inspection problems.
@Script
class ContainerRegistrationFixture : Node() {
    // Expected no issue: star projections register as untyped containers.
    @Visible
    var starArray: VariantArray<*> = variantArrayOf<Any?>(1L, "two")

    @Visible
    var starDictionary: Dictionary<*, *> = dictionaryOf<Any?, Any?>("one" to 1L)

    // Expected no issue: element types narrower than Godot's builtins.
    @Visible
    var intArray: VariantArray<Int> = variantArrayOf(1, 2)

    @Visible
    var byteArray: VariantArray<Byte> = variantArrayOf(1.toByte())

    @Visible
    var byteFloatDictionary: Dictionary<Byte, Float> = dictionaryOf(1.toByte() to 1.5f)

    // Expected no issue: nested containers built from explicit converters.
    @Visible
    var nestedIntArray: VariantArray<VariantArray<Int>> =
        VariantArray<VariantArray<Int>>(VariantCaster.TYPED_ARRAY(VariantCaster.INT))

    @Visible
    var nestedDictionary: Dictionary<String, VariantArray<Int>> =
        Dictionary<String, VariantArray<Int>>(VariantParser.STRING, VariantCaster.TYPED_ARRAY(VariantCaster.INT))

    // Expected no issue: a callable built from explicit converters around a lambda.
    @Visible
    var sumNestedInts = lambdaCallable1<Int, VariantArray<VariantArray<Int>>>(
        VariantCaster.INT,
        VariantCaster.TYPED_ARRAY(VariantCaster.TYPED_ARRAY(VariantCaster.INT))
    ) { arrays -> arrays.sumOf { it.sum() } }

    @Register
    override fun _ready() {
        // Expected red on the callable reference: the converter-taking factory
        // still requires its target to be a registered function.
        lambdaCallable1<Int, VariantArray<Int>>(
            VariantCaster.INT,
            VariantCaster.TYPED_ARRAY(VariantCaster.INT),
            this::sumNotRegistered
        ).call(intArray)
    }

    // Expected red when referenced from `lambdaCallable1`: missing `@Register`.
    fun sumNotRegistered(values: VariantArray<Int>): Int = values.sum()
}
