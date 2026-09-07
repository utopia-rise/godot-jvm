package godot.registration

import godot.core.KtObject
import godot.core.VariantParser
import godot.internal.memory.TransferContext
import kotlin.reflect.KClass
import kotlin.reflect.KFunction1

data class KtNotification<T : KtObject>(
    val notification: Int,
    val function: KFunction1<T, Unit>,
)

@Suppress("unused")
data class KtClass<T : KtObject>(
    val registeredName: String,
    val fqdn: String,
    val sourceFileName: String,
    val kClass: KClass<out KtObject>,
    val registeredSupertypes: Array<String>,
    val constructor: KtConstructor<T>?,
    val properties: Array<KtProperty<T, *>>,
    val functions: Array<KtFunction<T, *>>,
    private val _notifications: List<KtNotification<T>>,
    val signalInfos: Array<KtSignalInfo>,
    val handledNotifications: IntArray,
    val baseGodotClass: String,
    val isAbstract: Boolean,
) {
    fun doNotification(instance: T) {
        val parameters = arrayOfNulls<Any>(2)
        TransferContext.readArguments(
            arrayOf(VariantParser.LONG, VariantParser.BOOL),
            parameters
        )

        val notification = parameters[0]
        val reversed = parameters[1]

        require(notification is Long)
        require(reversed is Boolean)

        if (reversed) {
            for (registeredNotification in _notifications) {
                doNotification(registeredNotification, instance, notification.toInt())
            }
            return
        }

        for (i in _notifications.size - 1 downTo 0) {
            doNotification(_notifications[i], instance, notification.toInt())
        }
    }

    private fun doNotification(
        registeredNotification: KtNotification<T>,
        instance: T,
        notification: Int
    ) {
        if (registeredNotification.notification == notification) {
            registeredNotification.function(instance)
        }
    }
}
