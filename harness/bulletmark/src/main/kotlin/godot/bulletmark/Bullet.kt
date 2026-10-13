package godot.bulletmark

import godot.annotation.Register
import godot.annotation.Script
import godot.api.Area2D
import godot.api.CollisionShape2D
import godot.api.Shape2D
import godot.api.Sprite2D
import godot.api.Texture2D
import godot.core.Vector2
import godot.extension.connectMethod

/**
 * One bullet: an Area2D with its own script, moved in its own `_physics_process` and told about hits through the
 * engine's `area_entered` signal, the way a game written one script per entity does it. It frees itself on its first
 * hit, on another bullet or a drone, or when its lifetime runs out, whichever comes first.
 *
 * With a texture it carries its own Sprite2D, as a bullet scene would; without one the arena draws it.
 */
@Script
class Bullet : Area2D() {
    private lateinit var arena: Arena
    var team = 0
        private set
    private var velocityX = 0.0
    private var framesLeft = 0
    private var finished = false

    fun launch(
        arena: Arena,
        team: Int,
        x: Double,
        y: Double,
        velocityX: Double,
        lifetimeFrames: Int,
        shape: Shape2D,
        texture: Texture2D?,
    ) {
        this.arena = arena
        this.team = team
        this.velocityX = velocityX
        framesLeft = lifetimeFrames
        position = Vector2(x, y)
        // Each team sits on its own layer and scans the other team and the drones, never its own bullets.
        collisionLayer = if (team == 0) Layers.TEAM_A else Layers.TEAM_B
        collisionMask = (if (team == 0) Layers.TEAM_B else Layers.TEAM_A) or Layers.DRONE
        addChild(CollisionShape2D().also { it.shape = shape })
        if (texture != null) addChild(Sprite2D().also { it.texture = texture })
        // Without hits the bullet neither detects nor is detected, so the engine tracks no overlaps for it either.
        if (arena.hits) areaEntered.connectMethod(this, Bullet::onAreaEntered) else monitoring = false
        monitorable = arena.hits
    }
    override fun _physicsProcess(delta: Double) {
        ScriptCalls.count++
        if (finished) return
        if (--framesLeft <= 0) {
            finish()
            arena.recordExpired(this)
            return
        }
        val moved = position
        moved.x += velocityX * delta
        position = moved
    }

    @Register
    fun onAreaEntered(other: Area2D) {
        ScriptCalls.count++
        if (finished) return
        finish()
        arena.recordBulletHit(this, hitDrone = other is Drone)
    }

    private fun finish() {
        finished = true
        queueFree()
    }
}
