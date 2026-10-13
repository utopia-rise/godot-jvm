package godot.bulletmark

import godot.annotation.Register
import godot.annotation.Script
import godot.api.Area2D
import godot.api.CollisionShape2D
import godot.api.Sprite2D
import godot.api.Texture2D
import godot.core.Color
import godot.core.Rect2
import godot.core.Vector2
import godot.extension.connectLambda
import godot.extension.connectMethod
import kotlin.math.min
import kotlin.math.sqrt

/**
 * The arena's only enemy. It patrols the middle of the arena across the lanes, scans its surroundings, reacts to every
 * hit and, when it dies, splits in two and respawns. Each of those reaches the engine through a different path:
 *
 * - patrolling is a per-entity `_physics_process`, like the bullets';
 * - scanning walks the bullets inside its sensor (`getOverlappingAreas`) and the drones in its group
 *   (`getNodesInGroup`), each element delivered to the JVM as an object, then reads the nearby drones' positions: the
 *   drone steers away from them, so the drones spread out, and moves faster the more bullets its sensor holds;
 * - a hit arrives through `area_entered`, as it does for the bullet, and starts a two-step `Tween` flash;
 * - a death splits through `callDeferred`, since the engine refuses new areas while it dispatches a collision signal,
 *   and respawns through a `SceneTreeTimer` whose timeout runs a lambda.
 *
 * The two drones a split leaves behind have fewer hit points and neither split nor respawn, so the population is
 * bounded.
 */
@Script
class Drone : Area2D() {
    private lateinit var arena: Arena
    private lateinit var fill: Sprite2D
    private lateinit var sensor: Area2D
    private var original = true
    private var maxHitPoints = 0
    private var hitPoints = 0
    private var velocityX = 0.0
    private var velocityY = 0.0
    private var framesUntilScan = SCAN_INTERVAL_FRAMES
    private var dead = false

    fun place(arena: Arena, x: Double, y: Double, velocityX: Double, velocityY: Double, original: Boolean) {
        this.arena = arena
        this.original = original
        this.velocityX = velocityX
        this.velocityY = velocityY
        maxHitPoints = if (original) ORIGINAL_HIT_POINTS else CHILD_HIT_POINTS
        hitPoints = maxHitPoints
        position = Vector2(x, y)
        collisionLayer = Layers.DRONE
        collisionMask = Layers.TEAM_A or Layers.TEAM_B
        addChild(CollisionShape2D().also { it.shape = arena.droneShape })

        // Three layers: the dark inside, the body's colour filling it as high as the hit points left, the face on top.
        val look = arena.droneLook
        addChild(Sprite2D().also { it.texture = look.hollow })
        fill = Sprite2D().also {
            it.texture = look.fill
            it.centered = false
            it.regionEnabled = true
        }
        addChild(fill)
        showHitPoints()
        addChild(Sprite2D().also { it.texture = look.face })

        // The sensor is a wider area that only watches bullets: nothing scans its layer, so bullets fly through it and
        // live long enough to be listed, unlike the ones that touch the drone's body.
        sensor = Area2D()
        sensor.collisionLayer = 0L
        sensor.collisionMask = Layers.TEAM_A or Layers.TEAM_B
        sensor.monitorable = false
        sensor.addChild(CollisionShape2D().also { it.shape = arena.sensorShape })
        addChild(sensor)
        addChild(Sprite2D().also { it.texture = look.sensor })

        if (arena.bookkeeping) addToGroup(GROUP)
        if (arena.hits) areaEntered.connectMethod(this, Drone::onAreaEntered) else monitoring = false
    }
    override fun _physicsProcess(delta: Double) {
        ScriptCalls.count++
        if (dead) return
        patrol(delta)
        if (arena.bookkeeping && --framesUntilScan <= 0) {
            framesUntilScan = SCAN_INTERVAL_FRAMES
            scan()
        }
    }

    /** Moves diagonally, bouncing off the edges of the middle of the arena. */
    private fun patrol(delta: Double) {
        val moved = position
        moved.x += velocityX * delta
        moved.y += velocityY * delta
        if (moved.x < Arena.MIDDLE_LEFT || moved.x > Arena.MIDDLE_RIGHT) {
            velocityX = -velocityX
            moved.x = moved.x.coerceIn(Arena.MIDDLE_LEFT, Arena.MIDDLE_RIGHT)
        }
        if (moved.y < Arena.TOP || moved.y > Arena.BOTTOM) {
            velocityY = -velocityY
            moved.y = moved.y.coerceIn(Arena.TOP, Arena.BOTTOM)
        }
        position = moved
    }

    // Each element read is delivered to the JVM as an object, as it is when game code walks a query result. What the
    // scan finds steers the drone until the next one.
    private fun scan() {
        var bulletsNearby = 0
        for (area in sensor.getOverlappingAreas()) {
            if (area is Bullet) bulletsNearby++
        }

        // Flocking: a push away from every drone closer than SEPARATION_RADIUS, stronger the closer it is.
        val here = position
        var pushX = 0.0
        var pushY = 0.0
        var drones = 0
        for (node in getTree()!!.getNodesInGroup(GROUP)) {
            if (node !is Drone) continue
            drones++
            if (node === this) continue
            val there = node.position
            val dx = here.x - there.x
            val dy = here.y - there.y
            val distance = sqrt(dx * dx + dy * dy)
            if (distance > 0.0 && distance < SEPARATION_RADIUS) {
                val weight = (1.0 - distance / SEPARATION_RADIUS) / distance
                pushX += dx * weight
                pushY += dy * weight
            }
        }
        velocityX += pushX * SEPARATION_STEER
        velocityY += pushY * SEPARATION_STEER

        // Panic: the more bullets in the sensor, the faster the drone moves, up to twice its calm speed.
        val panic = min(bulletsNearby, PANIC_BULLETS).toDouble() / PANIC_BULLETS
        val speed = CALM_SPEED * (1.0 + panic)
        val length = sqrt(velocityX * velocityX + velocityY * velocityY)
        if (length > 0.0) {
            velocityX *= speed / length
            velocityY *= speed / length
        }
        arena.recordScan(bulletsNearby, drones)
    }

    @Register
    fun onAreaEntered(other: Area2D) {
        ScriptCalls.count++
        if (dead) return
        arena.recordDroneHit()
        if (arena.reactions) {
            val flash = createTween()
            flash.tweenProperty(this, "modulate", HIT_COLOR, FLASH_SECONDS)
            flash.tweenProperty(this, "modulate", REST_COLOR, FLASH_SECONDS)
        }
        hitPoints--
        // Only a run with a window shows the drain: a headless run skips the extra engine call per hit.
        if (arena.effects) showHitPoints()
        if (hitPoints > 0) return

        dead = true
        arena.recordKill(original)
        if (original) {
            val at = position
            arena.callDeferred("split", at.x, at.y)
            // Copied out so the lambda holds the arena, not this drone, which is freed before the timer fires.
            val arena = arena
            if (arena.reactions) {
                getTree()!!.createTimer(RESPAWN_SECONDS).timeout.connectLambda {
                    ScriptCalls.count++
                    arena.respawn()
                }
            } else {
                arena.scheduleRespawn()
            }
        }
        queueFree()
    }

    /** Crops the fill from the top, so the body empties as the hit points drop. */
    private fun showHitPoints() {
        val size = 2 * Arena.DRONE_DRAWN_RADIUS
        val top = size * (1.0 - hitPoints.coerceAtLeast(0).toDouble() / maxHitPoints)
        fill.regionRect = Rect2(0.0, top, size, size - top)
        fill.offset = Vector2(-Arena.DRONE_DRAWN_RADIUS, top - Arena.DRONE_DRAWN_RADIUS)
    }

    companion object {
        const val GROUP = "drones"
        const val SENSOR_RADIUS = 64f
        private const val ORIGINAL_HIT_POINTS = 30
        private const val CHILD_HIT_POINTS = 10
        private const val SCAN_INTERVAL_FRAMES = 15
        private const val SEPARATION_RADIUS = 90.0
        // How hard a neighbour pushes, in pixels per second of velocity at zero distance.
        private const val SEPARATION_STEER = 600.0
        private const val CALM_SPEED = 130.0
        private const val PANIC_BULLETS = 80
        private const val FLASH_SECONDS = 0.05
        private const val RESPAWN_SECONDS = 0.5
        private val HIT_COLOR = Color(1.3, 1.3, 1.3, 1.0)
        private val REST_COLOR = Color(1.0, 1.0, 1.0, 1.0)
    }
}

/** How a drone looks: its dark inside, the fill that drains with its hit points, its face and its sensor ring. */
class DroneLook(val hollow: Texture2D, val fill: Texture2D, val face: Texture2D, val sensor: Texture2D)
