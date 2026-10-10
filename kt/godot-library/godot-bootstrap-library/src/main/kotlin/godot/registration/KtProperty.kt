package godot.registration

import godot.common.interop.VariantConverter
import godot.core.*
import godot.internal.logging.GodotLogging
import godot.internal.memory.VariantBuffer

data class KtPropertyInfo(
    val _type: VariantConverter<*>,
    val name: String,
    val className: String,
    val _hint: PropertyHint,
    val hintString: String,
    val usage: Long = if (_type === VariantCaster.ANY) {
        PropertyUsageFlags.NIL_IS_VARIANT.flag
    } else {
        PropertyUsageFlags.NONE.flag
    }
) {
    constructor(
        type: VariantConverter<*>,
        className: String,
        name: String = ""
    ) : this(
        _type = type,
        name = name,
        className = className,
        _hint = PropertyHint.NONE,
        hintString = "",
    )

    val type: Int
        get() = _type.id

    val hint: Int
        get() = _hint.value.toInt()
}

class KtProperty<T : KtObject, P : Any?>(
    val ktPropertyInfo: KtPropertyInfo,
    private val getter: (T) -> P,
    private val setter: ((T, P) -> Unit)?,
    private val variantConverter: VariantConverter<*>,
) {
    fun callGet(instance: T) {
        try {
            VariantBuffer.transfer.writeRet(getter(instance), variantConverter)
        } catch (error: Throwable) {
            GodotLogging.error("Error calling JVM getter ${ktPropertyInfo.name} of script $instance from Godot:\n${error.stackTraceToString()}")
            VariantBuffer.transfer.writeRet(null, VariantParser.NIL)
        }
    }

    fun callSet(instance: T) {
        try {
            @Suppress("UNCHECKED_CAST")
            val value = VariantBuffer.transfer.readSetterArg(variantConverter) as P
            setter?.invoke(instance, value)
        } catch (error: Throwable) {
            GodotLogging.error("Error calling JVM setter ${ktPropertyInfo.name} of script $instance from Godot:\n${error.stackTraceToString()}")
        }
    }
}
