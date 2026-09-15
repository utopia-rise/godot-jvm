package godot.stress

import godot.annotation.Register
import godot.annotation.Script
import godot.api.RefCounted

@Script
class Item : RefCounted() {
    var value = 0

    init {
        Tracked.track(this)
    }

    @Register
    fun poke(): Int = ++value

    @Register
    fun onTick() {
        value++
    }
}
