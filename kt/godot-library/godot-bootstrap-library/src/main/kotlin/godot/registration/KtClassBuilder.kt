package godot.registration

import godot.annotation.RpcMode
import godot.annotation.TransferMode
import godot.common.extensions.convertToSnakeCase
import godot.common.interop.VariantConverter
import godot.core.*
import kotlin.reflect.KClass

class KtClassBuilder<T : KtObject>(
    @PublishedApi
    internal val registeredName: String,
    private val sourceFileName: String,
    private val registeredSupertypes: List<String>,
    private val baseGodotClass: String,
    private val isAbstract: Boolean,
    private val kClassField: KClass<T>,
) {
    private var constructorField: KtConstructor<T>? = null

    private val functions = mutableMapOf<String, KtFunction<T, *>>()
    private var process: KtProcess<T>? = null
    private var physicsProcess: KtProcess<T>? = null
    private val notifications = mutableListOf<KtNotification<T>>()

    @PublishedApi
    internal val properties = mutableListOf<KtProperty<T, *>>()
    @PublishedApi
    internal val propertyNames = mutableSetOf<String>()

    private val signals = mutableMapOf<String, KtSignalInfo>()

    fun constructor(constructor: () -> T) {
        constructorField = KtConstructor(constructor)
    }

    fun argument(
        type: VariantConverter<*>,
        className: String,
        name: String,
    ): KtPropertyInfo = KtPropertyInfo(type, className, name)

    fun returns(
        type: VariantConverter<*>,
        className: String,
    ): KtPropertyInfo = KtPropertyInfo(type, className)

    fun rpc(
        rpcMode: RpcMode,
        callLocal: Boolean,
        transferMode: TransferMode,
        channel: Int,
    ): KtRpcConfig = KtRpcConfig(rpcMode.toEngineValue(), callLocal, transferMode.toEngineValue(), channel)

    // The annotation enums are ordered like the GDScript documentation, not like the engine enums they map to.
    private fun RpcMode.toEngineValue(): Int = when (this) {
        RpcMode.DISABLED -> 0
        RpcMode.ANY -> 1
        RpcMode.AUTHORITY -> 2
    }

    private fun TransferMode.toEngineValue(): Int = when (this) {
        TransferMode.UNRELIABLE -> 0
        TransferMode.UNRELIABLE_ORDERED -> 1
        TransferMode.RELIABLE -> 2
    }

    fun <P : Any?> property(
        name: String,
        getter: (T) -> P,
        setter: ((T, P) -> Unit)? = null,
        variantType: VariantConverter<*>,
        className: String,
        hint: PropertyHint = PropertyHint.NONE,
        hintString: String = "",
        usage: PropertyUsageFlags
    ) {
        require(propertyNames.add(name)) {
            "Found two properties with name $name for class $registeredName"
        }
        properties += KtProperty(
            KtPropertyInfo(
                variantType,
                name,
                className,
                hint,
                hintString,
                propertyUsage(usage, setter != null, variantType)
            ),
            getter,
            setter,
            variantType
        )
    }

    fun group(name: String, prefix: String) {
        propertyListMarker(name, prefix, PropertyUsageFlags.GROUP)
    }

    fun subgroup(name: String, prefix: String) {
        propertyListMarker(name, prefix, PropertyUsageFlags.SUBGROUP)
    }

    fun category(name: String) {
        propertyListMarker(name, "", PropertyUsageFlags.CATEGORY)
    }

    private fun propertyListMarker(name: String, prefix: String, usage: PropertyUsageFlags) {
        properties += KtProperty(
            KtPropertyInfo(
                VariantParser.NIL,
                name,
                "",
                PropertyHint.NONE,
                prefix,
                usage.flag,
            ),
            { null },
            null,
            VariantParser.NIL,
        )
    }

    @PublishedApi
    internal fun propertyUsage(usage: PropertyUsageFlags, isMutable: Boolean, variantType: VariantConverter<*>): Long {
        var flags = usage.flag
        if (!isMutable) flags = flags or PropertyUsageFlags.READ_ONLY
        if (variantType === VariantCaster.ANY) flags = flags or PropertyUsageFlags.NIL_IS_VARIANT
        return flags
    }

    fun notification(
        notification: Int,
        function: (T) -> Unit,
    ) {
        notifications.add(KtNotification(notification, function))
    }

    fun function(
        name: String,
        function: (T, Array<Any?>) -> Any?,
        rpcConfig: KtRpcConfig,
        returnType: KtPropertyInfo,
        vararg arguments: KtPropertyInfo,
    ) {
        val functionInfo = KtFunctionInfo(
            name = name,
            _arguments = arguments.toList(),
            returnVal = returnType,
            rpcConfig = rpcConfig
        )
        require(!functions.containsKey(name)) { "A method with $name already exists." }
        functions[name] = KtFunction(functionInfo, function)
    }

    fun process(body: ProcessBody<T>) {
        require(process == null) { "_process is already registered." }
        process = KtProcess("_process", body)
    }

    fun physicsProcess(body: ProcessBody<T>) {
        require(physicsProcess == null) { "_physics_process is already registered." }
        physicsProcess = KtProcess("_physics_process", body)
    }

    fun signal(name: String, vararg parameters: KtPropertyInfo) {
        val signalInfo = KtSignalInfo(
            name.convertToSnakeCase(),
            parameters.toList()
        )
        require(!signals.containsKey(signalInfo.name)) {
            "A signal with ${signalInfo.name} already exists."
        }
        signals[signalInfo.name] = signalInfo
    }

    internal fun build(): KtClass<T> {
        val fqdn = requireNotNull(kClassField.qualifiedName) {
            "Registered class $registeredName must have a qualified name."
        }
        return KtClass(
            registeredName = registeredName,
            fqdn = fqdn,
            sourceFileName = sourceFileName,
            kClass = kClassField,
            registeredSupertypes = registeredSupertypes.toTypedArray(),
            constructor = constructorField,
            properties = properties.toTypedArray(),
            functions = functions.values.toTypedArray(),
            process = process,
            physicsProcess = physicsProcess,
            _notifications = notifications,
            signalInfos = signals.values.toTypedArray(),
            handledNotifications = notifications
                .map { notification -> notification.notification }
                .distinct()
                .toIntArray(),
            baseGodotClass = baseGodotClass,
            isAbstract = isAbstract,
        )
    }
}
