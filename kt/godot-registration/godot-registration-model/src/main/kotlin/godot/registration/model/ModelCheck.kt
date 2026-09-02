package godot.registration.model

import godot.registration.model.checks.BitFieldEntryCountCheck
import godot.registration.model.checks.FunctionArgCountCheck
import godot.registration.model.checks.FunctionTypeCheck
import godot.registration.model.checks.LateinitPropertyCheck
import godot.registration.model.checks.NotificationFunctionCheck
import godot.registration.model.checks.NullablePropertyCheck
import godot.registration.model.checks.PropertyHintCheck
import godot.registration.model.checks.PropertyHintCountCheck
import godot.registration.model.checks.PropertyTypeCheck
import godot.registration.model.checks.RegisteredNameUniquenessCheck
import godot.registration.model.checks.RpcCheck
import godot.registration.model.checks.SignalTypeCheck
import godot.registration.model.checks.SourceClassCheck
import godot.registration.model.logging.Logger
import godot.registration.model.types.ScriptClass

/**
 * Runs every sanity check against the registration model.
 *
 * All checks are executed (so every issue is logged, not just the first), then the result is collapsed:
 * returns `true` when the model is sane and `false` when at least one check failed.
 */
object ModelCheck {
    fun check(
        registeredClasses: List<ScriptClass>,
        logger: Logger,
        registeredNameProvider: ((ScriptClass) -> String)? = null,
    ): Boolean {
        val hasIssue = listOf(
            FunctionArgCountCheck(logger, registeredClasses).execute(),
            FunctionTypeCheck(logger, registeredClasses).execute(),
            NotificationFunctionCheck(logger, registeredClasses).execute(),
            registeredNameProvider?.let { provider ->
                RegisteredNameUniquenessCheck(logger, registeredClasses, provider).execute()
            } ?: false,

            SignalTypeCheck(logger, registeredClasses).execute(),
            SourceClassCheck(logger, registeredClasses).execute(),

            PropertyTypeCheck(logger, registeredClasses).execute(),
            PropertyHintCountCheck(logger, registeredClasses).execute(),
            PropertyHintCheck(logger, registeredClasses).execute(),
            BitFieldEntryCountCheck(logger, registeredClasses).execute(),
            LateinitPropertyCheck(logger, registeredClasses).execute(),
            NullablePropertyCheck(logger, registeredClasses).execute(),

            RpcCheck(logger, registeredClasses).execute(),
        ).any { issueFound -> issueFound }

        return !hasIssue
    }
}
