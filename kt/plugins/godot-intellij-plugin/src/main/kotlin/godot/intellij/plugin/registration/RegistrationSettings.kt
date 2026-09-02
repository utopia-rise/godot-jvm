package godot.intellij.plugin.registration

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.StoragePathMacros

@State(
    name = "GodotJvmRegistrationSettings",
    storages = [Storage(StoragePathMacros.WORKSPACE_FILE)]
)
class RegistrationSettings : PersistentStateComponent<RegistrationSettings.SettingsState> {
    private var state = SettingsState()

    override fun getState(): SettingsState = state

    override fun loadState(state: SettingsState) {
        this.state = state
    }

    class SettingsState {
        var mode: RegistrationMode = RegistrationMode.Inferred
        var registrationHighlightsEnabled: Boolean = true
    }
}
