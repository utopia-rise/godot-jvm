package godot.registration

import godot.common.interop.VariantConverter
import godot.core.*
import godot.internal.logging.GodotLogging
import godot.internal.memory.TransferContext

data class KtPropertyInfo(
    val _type: VariantConverter,
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
        type: VariantConverter,
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

open class KtProperty<T : KtObject, P : Any?>(
    @Suppress("unused") val ktPropertyInfo: KtPropertyInfo,
    protected val getter: (T) -> P,
    protected val setter: ((T, P) -> Unit)?,
    protected val variantConverter: VariantConverter,
) {
    open fun callGet(instance: T) {
        try {
            TransferContext.writeReturnValue(getter(instance), variantConverter)
        } catch (t: Throwable) {
            GodotLogging.error("Error calling JVM getter ${ktPropertyInfo.name} of script $instance from Godot\n:" + t.stackTraceToString())
            TransferContext.writeReturnValue(null, VariantParser.NIL)
        }
    }

    open fun callSet(instance: T) {
        val arg = extractSetterArgument<P>()
        val setter = setter ?: return
        try {
            setter(instance, arg)
        } catch (t: Throwable) {
            GodotLogging.error("Error calling JVM setter ${ktPropertyInfo.name} of script $instance from Godot:\n" + t.stackTraceToString())
        }
    }

    protected fun <P> extractSetterArgument(): P {
        //TODO: manage nullable argument of enum setter (only for objects)
        val arg = TransferContext.readSetterArgument(variantConverter)
        @Suppress("UNCHECKED_CAST")
        return arg as P
    }
}

class KtBitFieldProperty<T : KtObject, P : BitFieldBase<*>>(
    ktPropertyInfo: KtPropertyInfo,
    getter: (T) -> P,
    setter: ((T, P) -> Unit)?,
    val getValueConverter: (P?) -> Int,
    val setValueConverter: (Int) -> P
) : KtProperty<T, P>(
    ktPropertyInfo,
    getter,
    setter,
    VariantCaster.INT
) {
    override fun callGet(instance: T) {
        TransferContext.writeReturnValue(getValueConverter(getter(instance)), VariantCaster.INT)
    }

    override fun callSet(instance: T) {
        val arg = extractSetterArgument<Int>()
        setter?.invoke(instance, setValueConverter(arg))
    }
}

class KtEnumListProperty<T : KtObject, P : Enum<P>, L : Collection<P>>(
    ktPropertyInfo: KtPropertyInfo,
    getter: (T) -> L,
    setter: ((T, L) -> Unit)?,
    val getValueConverter: (L?) -> VariantArray<Long>,
    val setValueConverter: (VariantArray<Long>) -> L
) : KtProperty<T, L>(
    ktPropertyInfo,
    getter,
    setter,
    VariantCaster.TYPED_ARRAY(VariantParser.LONG)
) {
    override fun callGet(instance: T) {
        TransferContext.writeReturnValue(getValueConverter(getter(instance)), variantConverter)
    }

    override fun callSet(instance: T) {
        val arg = extractSetterArgument<VariantArray<Long>>()
        setter?.invoke(instance, setValueConverter(arg))
    }
}
