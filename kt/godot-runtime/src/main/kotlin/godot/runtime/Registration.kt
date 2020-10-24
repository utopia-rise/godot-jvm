package godot.runtime

import godot.core.*
import godot.util.camelToSnakeCase
import kotlin.reflect.*

class KtPropertyInfoBuilderDsl {
    var type: KtVariant.Type? = null
    var name: String = ""
    var className: String? = null
    var hint: PropertyHint = PropertyHint.NONE
    var hintString: String = ""

    internal fun build() = KtPropertyInfo(checkNotNull(type), name, checkNotNull(className), hint, hintString)
}

data class KtFunctionArgument(
    val type: KtVariant.Type,
    val className: String,
    val name: String = "" //empty for return type
) {
    internal fun toKtPropertyInfo() = KtPropertyInfo(
        type,
        name,
        className,
        PropertyHint.NONE,
        "" //always empty. Only used for properties
    )
}


//class REF<T : KtReference>(var reference: T, val owner_instance: KtObject) {
//
//    fun updateReference(ref: T) {
//        reference = ref
//        TransferContext.updateREF(this)
//    }
//}

//class Test: KtObject() {
//    @RegisterProperty
//    var resource by refProperty(NavigationMesh())
//
//    override fun __new(): VoidPtr {
//        TODO("Not yet implemented")
//    }
//}

//open class REFHandler<T : KtObject, R: KtReference>(
//    private val property: KMutableProperty1<T, R>,
//    private val getValueConverter: (R) -> KtVariant,
//    private val setValueConverter: (KtVariant) -> R
//) {
//    private var ref: REF<R>? = null
//
//    open fun get(instance: T): KtVariant {
//        if (ref == null) {
//            ref = REF(property.get(instance), instance)
//        }
//        ref!!.reference = property.get(instance)
//        return getValueConverter(ref!!.reference)
//    }
//
//    open fun set(instance: T, ktVariant: KtVariant) {
//        val value = setValueConverter(ktVariant)
//        if (ref == null) {
//            ref = REF(value, instance)
//        }
//        property.set(instance, value)
//        ref?.reference = value
//        requireNotNull(ref).updateReference(value)
//    }
//}

class ClassBuilderDsl<T : KtObject>(
    @PublishedApi internal val name: String,
    private val superClass: String
) {
    private val constructors = mutableMapOf<Int, KtConstructor<T>>()

    private val functions = mutableMapOf<String, KtFunction<T, *>>()

    @PublishedApi
    internal val properties = mutableMapOf<String, KtProperty<T, *>>()

    private val signals = mutableMapOf<String, KtSignalInfo>()

    fun constructor(constructor: KtConstructor<T>) {
        require(!constructors.containsKey(constructor.parameterCount)) {
            "A constructor with ${constructor.parameterCount} argument(s) already exists."
        }
        constructors[constructor.parameterCount] = constructor
    }

    fun <P> property(
        kProperty: KMutableProperty1<T, P>,
        getValueConverter: (P) -> KtVariant,
        setValueConverter: ((KtVariant) -> P),
        type: KtVariant.Type,
        className: String,
        hint: PropertyHint = PropertyHint.NONE,
        hintString: String = "",
        defaultArgument: KtVariant = KtVariant(Unit),
        isRef: Boolean = false
    ) {
        val propertyName = kProperty.name.camelToSnakeCase()
        require(!properties.contains(propertyName)) {
            "Found two properties with name $propertyName for class $name"
        }
        properties[propertyName] = KtProperty(
            KtPropertyInfo(
                type,
                propertyName,
                className,
                hint,
                hintString
            ),
            kProperty,
            getValueConverter,
            setValueConverter,
            defaultArgument,
            isRef
        )
    }

    inline fun <reified P : Enum<P>> enumProperty(
        kProperty: KMutableProperty1<T, P>
    ) {
        val propertyName = kProperty.name.camelToSnakeCase()
        require(!properties.contains(propertyName)) {
            "Found two properties with name $propertyName for class $name"
        }

        properties[propertyName] = KtProperty(
            KtPropertyInfo(
                KtVariant.Type.LONG,
                propertyName,
                "Int",
                PropertyHint.ENUM,
                enumValues<P>().joinToString { it.name }
            ),
            kProperty,
            { enum -> KtVariant(enum.ordinal) },
            { ktVariant -> enumValues<P>()[ktVariant.asInt()] },
            KtVariant(Unit),
            false
        )
    }

    //TODO: uncomment and fixup once collections are supported in KtVariant
//    inline fun <reified P : Enum<P>> enumListProperty(
//        kProperty: KMutableProperty1<T, Collection<P>>
//    ) {
//        val propertyName = kProperty.name.camelToSnakeCase()
//        require(!properties.contains(propertyName)) {
//            "Found two properties with name $propertyName for class $name"
//        }
//
//        properties[propertyName] = KtProperty(
//            KtPropertyInfo(
//                KtVariant.Type.LONG,
//                propertyName,
//                "Int",
//                PropertyHint.ENUM,
//                "2/3:${enumValues<P>().joinToString(",") { it.name }}" //2 = KtVariant.Type.LONG.ordinal | 3 = PropertyHint.ENUM.ordinal
//            ),
//            kProperty,
//            { enumList ->
//                KtVariant(enumList.map { it.ordinal } as Collection)
//            },
//            { ktVariant -> enumValues<P>()[ktVariant.asInt()] }
//        )
//    }

    inline fun <reified P : Enum<P>> enumFlagProperty(
        kProperty: KMutableProperty1<T, Set<P>>
    ) {
        val propertyName = kProperty.name.camelToSnakeCase()
        require(!properties.contains(propertyName)) {
            "Found two properties with name $propertyName for class $name"
        }

        properties[propertyName] = KtProperty(
            KtPropertyInfo(
                KtVariant.Type.LONG,
                propertyName,
                "Int",
                PropertyHint.FLAGS,
                enumValues<P>().joinToString { it.name }
            ),
            kProperty,
            { enumSet ->
                var intFlag = 0
                enumSet.forEach { enum ->
                    intFlag += 1 shl enum.ordinal
                }
                KtVariant(intFlag)
            },
            { value ->
                val intFlag = value.asInt()

                val enums = mutableSetOf<P>()
                var bit = 1

                for (i in 0 until Int.SIZE_BITS) {
                    if ((intFlag and bit) > 0) {
                        val element = enumValues<P>().firstOrNull { it.ordinal == i }
                        if (element != null) {
                            enums.add(element)
                        }
                    }
                    bit = bit shl 1
                    if (bit > intFlag) break
                }

                enums
            },
            KtVariant(Unit),
            false
        )
    }

    fun <P> property(
        kProperty: KMutableProperty1<T, P>,
        getValueConverter: (P) -> KtVariant,
        setValueConverter: ((KtVariant) -> P),
        isRef: Boolean = false,
        pib: KtPropertyInfoBuilderDsl.() -> Unit
    ) {
        val builder = KtPropertyInfoBuilderDsl()
        builder.name = kProperty.name.camelToSnakeCase()
        builder.pib()
        val property = builder.build()
        require(!properties.contains(property.name)) {
            "Found two properties with name ${property.name} for class $name"
        }
        properties[property.name] = KtProperty(property, kProperty, getValueConverter, setValueConverter, KtVariant(Unit), isRef)
    }

    fun <R> function(
        func: KFunction1<T, R>,
        returnValueConverter: (R) -> KtVariant,
        returnType: KtFunctionArgument
    ) {
        appendFunction(
            KtFunction0(
                KtFunctionInfo(
                    func.name.camelToSnakeCase(),
                    listOf(),
                    KtPropertyInfo(
                        returnType.type,
                        "",
                        returnType.className,
                        PropertyHint.NONE,
                        ""
                    )
                ),
                func,
                returnValueConverter
            )
        )
    }

    fun <R> function(
        func: KFunction1<T, R>,
        returnValueConverter: (R) -> KtVariant,
        returns: KtPropertyInfoBuilderDsl.() -> Unit
    ) {
        val returnBuilder = KtPropertyInfoBuilderDsl()
        returnBuilder.returns()
        appendFunction(
            KtFunction0(
                KtFunctionInfo(func.name.camelToSnakeCase(), listOf(), returnBuilder.build()),
                func,
                returnValueConverter
            )
        )
    }

    fun <P0, R> function(
        func: KFunction2<T, P0, R>,
        returnValueConverter: (R) -> KtVariant,
        p0Converter: (KtVariant) -> P0,
        p0: KtFunctionArgument,
        returnType: KtFunctionArgument
    ) {
        appendFunction(
            KtFunction1(
                KtFunctionInfo(
                    func.name.camelToSnakeCase(),
                    listOf(
                        p0.toKtPropertyInfo()
                    ),
                    returnType.toKtPropertyInfo()
                ),
                func,
                returnValueConverter,
                p0Converter
            )
        )
    }

    fun <P0, R> function(
        func: KFunction2<T, P0, R>,
        returnValueConverter: (R) -> KtVariant,
        p0Converter: (KtVariant) -> P0,
        arg: KtPropertyInfoBuilderDsl.() -> Unit,
        returns: KtPropertyInfoBuilderDsl.() -> Unit
    ) {
        val (arguments, returnType) = argumentsAndReturnType(returns, arg)
        appendFunction(
            KtFunction1(
                KtFunctionInfo(func.name.camelToSnakeCase(), arguments, returnType),
                func,
                returnValueConverter,
                p0Converter
            )
        )
    }

    fun <P0, P1, R> function(
        func: KFunction3<T, P0, P1, R>,
        returnValueConverter: (R) -> KtVariant,
        p0Converter: (KtVariant) -> P0,
        p1Converter: (KtVariant) -> P1,
        p0: KtFunctionArgument,
        p1: KtFunctionArgument,
        returnType: KtFunctionArgument
    ) {
        appendFunction(
            KtFunction2(
                KtFunctionInfo(
                    func.name.camelToSnakeCase(),
                    listOf(
                        p0.toKtPropertyInfo(),
                        p1.toKtPropertyInfo(),
                    ),
                    returnType.toKtPropertyInfo()
                ),
                func,
                returnValueConverter,
                p0Converter,
                p1Converter
            )
        )
    }

    fun <P0, P1, R> function(
        func: KFunction3<T, P0, P1, R>,
        returnValueConverter: (R) -> KtVariant,
        p0Converter: (KtVariant) -> P0,
        p1Converter: (KtVariant) -> P1,
        args: Array<KtPropertyInfoBuilderDsl.() -> Unit>,
        returns: KtPropertyInfoBuilderDsl.() -> Unit
    ) {
        val (arguments, returnType) = argumentsAndReturnType(returns, *args)
        require(args.size == 2) {
            "Function ${func.name.camelToSnakeCase()} should have 2 arguments, found ${args.size}"
        }
        appendFunction(
            KtFunction2(
                KtFunctionInfo(func.name.camelToSnakeCase(), arguments, returnType),
                func,
                returnValueConverter,
                p0Converter,
                p1Converter
            )
        )
    }

    fun <P0, P1, P2, R> function(
        func: KFunction4<T, P0, P1, P2, R>,
        returnValueConverter: (R) -> KtVariant,
        p0Converter: (KtVariant) -> P0,
        p1Converter: (KtVariant) -> P1,
        p2Converter: (KtVariant) -> P2,
        p0: KtFunctionArgument,
        p1: KtFunctionArgument,
        p2: KtFunctionArgument,
        returnType: KtFunctionArgument
    ) {
        appendFunction(
            KtFunction3(
                KtFunctionInfo(
                    func.name.camelToSnakeCase(),
                    listOf(
                        p0.toKtPropertyInfo(),
                        p1.toKtPropertyInfo(),
                        p2.toKtPropertyInfo(),
                    ),
                    returnType.toKtPropertyInfo()
                ),
                func,
                returnValueConverter,
                p0Converter,
                p1Converter,
                p2Converter
            )
        )
    }

    fun <P0, P1, P2, R> function(
        func: KFunction4<T, P0, P1, P2, R>,
        returnValueConverter: (R) -> KtVariant,
        p0Converter: (KtVariant) -> P0,
        p1Converter: (KtVariant) -> P1,
        p2Converter: (KtVariant) -> P2,
        args: Array<KtPropertyInfoBuilderDsl.() -> Unit>,
        returns: KtPropertyInfoBuilderDsl.() -> Unit
    ) {
        val (arguments, returnType) = argumentsAndReturnType(returns, *args)
        require(args.size == 3) {
            "Function ${func.name.camelToSnakeCase()} should have 3 arguments, found ${args.size}"
        }
        appendFunction(
            KtFunction3(
                KtFunctionInfo(func.name.camelToSnakeCase(), arguments, returnType),
                func,
                returnValueConverter,
                p0Converter,
                p1Converter,
                p2Converter
            )
        )
    }

    fun <P0, P1, P2, P3, R> function(
        func: KFunction5<T, P0, P1, P2, P3, R>,
        returnValueConverter: (R) -> KtVariant,
        p0Converter: (KtVariant) -> P0,
        p1Converter: (KtVariant) -> P1,
        p2Converter: (KtVariant) -> P2,
        p3Converter: (KtVariant) -> P3,
        p0: KtFunctionArgument,
        p1: KtFunctionArgument,
        p2: KtFunctionArgument,
        p3: KtFunctionArgument,
        returnType: KtFunctionArgument
    ) {
        appendFunction(
            KtFunction4(
                KtFunctionInfo(
                    func.name.camelToSnakeCase(),
                    listOf(
                        p0.toKtPropertyInfo(),
                        p1.toKtPropertyInfo(),
                        p2.toKtPropertyInfo(),
                        p3.toKtPropertyInfo(),
                    ),
                    returnType.toKtPropertyInfo()
                ),
                func,
                returnValueConverter,
                p0Converter,
                p1Converter,
                p2Converter,
                p3Converter
            )
        )
    }

    fun <P0, P1, P2, P3, R> function(
        func: KFunction5<T, P0, P1, P2, P3, R>,
        returnValueConverter: (R) -> KtVariant,
        p0Converter: (KtVariant) -> P0,
        p1Converter: (KtVariant) -> P1,
        p2Converter: (KtVariant) -> P2,
        p3Converter: (KtVariant) -> P3,
        args: Array<KtPropertyInfoBuilderDsl.() -> Unit>,
        returns: KtPropertyInfoBuilderDsl.() -> Unit
    ) {
        val (arguments, returnType) = argumentsAndReturnType(returns, *args)
        require(args.size == 4) {
            "Function ${func.name.camelToSnakeCase()} should have 4 arguments, found ${args.size}"
        }
        appendFunction(
            KtFunction4(
                KtFunctionInfo(func.name.camelToSnakeCase(), arguments, returnType),
                func,
                returnValueConverter,
                p0Converter,
                p1Converter,
                p2Converter,
                p3Converter
            )
        )
    }

    fun <P0, P1, P2, P3, P4, R> function(
        func: KFunction6<T, P0, P1, P2, P3, P4, R>,
        returnValueConverter: (R) -> KtVariant,
        p0Converter: (KtVariant) -> P0,
        p1Converter: (KtVariant) -> P1,
        p2Converter: (KtVariant) -> P2,
        p3Converter: (KtVariant) -> P3,
        p4Converter: (KtVariant) -> P4,
        p0: KtFunctionArgument,
        p1: KtFunctionArgument,
        p2: KtFunctionArgument,
        p3: KtFunctionArgument,
        p4: KtFunctionArgument,
        returnType: KtFunctionArgument
    ) {
        appendFunction(
            KtFunction5(
                KtFunctionInfo(
                    func.name.camelToSnakeCase(),
                    listOf(
                        p0.toKtPropertyInfo(),
                        p1.toKtPropertyInfo(),
                        p2.toKtPropertyInfo(),
                        p3.toKtPropertyInfo(),
                        p4.toKtPropertyInfo()
                    ),
                    returnType.toKtPropertyInfo()
                ),
                func,
                returnValueConverter,
                p0Converter,
                p1Converter,
                p2Converter,
                p3Converter,
                p4Converter
            )
        )
    }

    fun <P0, P1, P2, P3, P4, R> function(
        func: KFunction6<T, P0, P1, P2, P3, P4, R>,
        returnValueConverter: (R) -> KtVariant,
        p0Converter: (KtVariant) -> P0,
        p1Converter: (KtVariant) -> P1,
        p2Converter: (KtVariant) -> P2,
        p3Converter: (KtVariant) -> P3,
        p4Converter: (KtVariant) -> P4,
        args: Array<KtPropertyInfoBuilderDsl.() -> Unit>,
        returns: KtPropertyInfoBuilderDsl.() -> Unit
    ) {
        val (arguments, returnType) = argumentsAndReturnType(returns, *args)
        require(args.size == 5) {
            "Function ${func.name.camelToSnakeCase()} should have 5 arguments, found ${args.size}"
        }
        appendFunction(
            KtFunction5(
                KtFunctionInfo(func.name.camelToSnakeCase(), arguments, returnType),
                func,
                returnValueConverter,
                p0Converter,
                p1Converter,
                p2Converter,
                p3Converter,
                p4Converter
            )
        )
    }

    fun <T> signal(kProperty: KProperty<T>) {
        appendSignal(
            KtSignalInfo(kProperty.name.removePrefix("signal").camelToSnakeCase(), listOf())
        )
    }

    fun <T> signal(
        kProperty: KProperty<T>,
        p0: KtFunctionArgument
    ) {
        appendSignal(
            KtSignalInfo(
                kProperty.name.removePrefix("signal").camelToSnakeCase(),
                listOf(
                    p0.toKtPropertyInfo()
                )
            )
        )
    }

    fun <T> signal(
        kProperty: KProperty<T>,
        p0: KtFunctionArgument,
        p1: KtFunctionArgument
    ) {
        appendSignal(
            KtSignalInfo(
                kProperty.name.removePrefix("signal").camelToSnakeCase(),
                listOf(
                    p0.toKtPropertyInfo(),
                    p1.toKtPropertyInfo()
                )
            )
        )
    }

    fun <T> signal(
        kProperty: KProperty<T>,
        p0: KtFunctionArgument,
        p1: KtFunctionArgument,
        p2: KtFunctionArgument
    ) {
        appendSignal(
            KtSignalInfo(
                kProperty.name.removePrefix("signal").camelToSnakeCase(),
                listOf(
                    p0.toKtPropertyInfo(),
                    p1.toKtPropertyInfo(),
                    p2.toKtPropertyInfo()
                )
            )
        )
    }

    fun <T> signal(
        kProperty: KProperty<T>,
        p0: KtFunctionArgument,
        p1: KtFunctionArgument,
        p2: KtFunctionArgument,
        p3: KtFunctionArgument
    ) {
        appendSignal(
            KtSignalInfo(
                kProperty.name.removePrefix("signal").camelToSnakeCase(),
                listOf(
                    p0.toKtPropertyInfo(),
                    p1.toKtPropertyInfo(),
                    p2.toKtPropertyInfo(),
                    p3.toKtPropertyInfo()
                )
            )
        )
    }

    fun <T> signal(
        kProperty: KProperty<T>,
        p0: KtFunctionArgument,
        p1: KtFunctionArgument,
        p2: KtFunctionArgument,
        p3: KtFunctionArgument,
        p4: KtFunctionArgument
    ) {
        appendSignal(
            KtSignalInfo(
                kProperty.name.removePrefix("signal").camelToSnakeCase(),
                listOf(
                    p0.toKtPropertyInfo(),
                    p1.toKtPropertyInfo(),
                    p2.toKtPropertyInfo(),
                    p3.toKtPropertyInfo(),
                    p4.toKtPropertyInfo()
                )
            )
        )
    }

    fun <T> signal(kProperty: KProperty<T>, args: Array<KtPropertyInfoBuilderDsl.() -> Unit> = arrayOf()) {
        appendSignal(
            KtSignalInfo(kProperty.name.removePrefix("signal").camelToSnakeCase(), args.applyArgumentsDsl())
        )
    }

    private fun argumentsAndReturnType(
        returns: KtPropertyInfoBuilderDsl.() -> Unit,
        vararg args: KtPropertyInfoBuilderDsl.() -> Unit
    ): Pair<List<KtPropertyInfo>, KtPropertyInfo> {
        val returnBuilder = KtPropertyInfoBuilderDsl()
        returnBuilder.returns()
        val returnInfo = returnBuilder.build()

        return args.applyArgumentsDsl() to returnInfo
    }

    private fun <R> appendFunction(function: KtFunction<T, R>) {
        require(!functions.containsKey(function.functionInfo.name)) {
            "A method with ${function.functionInfo.name} already exists."
        }
        functions[function.functionInfo.name] = function
    }

    @PublishedApi
    internal fun appendSignal(signalInfo: KtSignalInfo) {
        require(!signals.containsKey(signalInfo.name)) {
            "A signal with ${signalInfo.name} already exists."
        }
        signals[signalInfo.name] = signalInfo
    }

    internal fun build(): KtClass<T> {
        check(constructors.isNotEmpty()) { "Please provide at least one constructor." }
        return KtClass(name, superClass, constructors, properties, functions, signals)
    }

    @PublishedApi
    internal fun Array<out KtPropertyInfoBuilderDsl.() -> Unit>.applyArgumentsDsl(): List<KtPropertyInfo> {
        val argumentsCheckList = mutableSetOf<String>()
        return map {
            val builder = KtPropertyInfoBuilderDsl()
            builder.it()
            val propertyInfo = builder.build()
            require(!argumentsCheckList.contains(propertyInfo.name)) {
                "Cannot have two arguments with name ${propertyInfo.name}"
            }
            require(propertyInfo.name.isNotEmpty()) { "Function parameters should have names." }
            argumentsCheckList.add(propertyInfo.name)
            propertyInfo
        }
    }
}

class ClassRegistry {
    val classes = mutableListOf<KtClass<*>>()

    fun <T : KtObject> registerClass(name: String, superClass: String, isTool: Boolean = false, cb: ClassBuilderDsl<T>.() -> Unit) {
        val builder = ClassBuilderDsl<T>(name, superClass)
        builder.cb()
        TypeManager.registerUserType(name)
        registerClass(builder.build())
    }

    private fun <T : KtObject> registerClass(cls: KtClass<T>) {
        classes.add(cls)
    }
}
