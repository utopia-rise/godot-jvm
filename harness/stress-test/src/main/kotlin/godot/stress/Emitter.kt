package godot.stress

import godot.annotation.Emit
import godot.annotation.Script
import godot.api.Object
import godot.core.signal0

@Script
class Emitter : Object() {
    @Emit
    val tick by signal0()
}
