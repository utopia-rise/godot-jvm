package godot.stress

import godot.annotation.Script
import godot.api.Resource

@Script
class Payload : Resource() {
    init {
        Tracked.track(this)
    }
}
