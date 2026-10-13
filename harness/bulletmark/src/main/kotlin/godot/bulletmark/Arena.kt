package godot.bulletmark

import godot.annotation.Register
import godot.annotation.Script
import godot.api.CircleShape2D
import godot.api.DisplayServer
import godot.api.Engine
import godot.api.Label
import godot.api.Node
import godot.api.Node2D
import godot.api.RandomNumberGenerator
import godot.api.Texture2D
import godot.core.Dictionary
import godot.core.HorizontalAlignment
import godot.core.Rect2
import godot.core.Vector2
import godot.core.asStringName
import godot.core.dictionaryOf

/**
 * Two turret lines face each other across the arena and fire into partly shared lanes: in a shared lane a bullet meets
 * an oncoming one and both die on the hit, in a lane only one side fires into it crosses the arena and expires.
 * Drones patrol the middle of the arena, soak up bullets, react to every hit, split and respawn after dying. Spawning,
 * moving, hitting, reacting and freeing therefore all happen every frame at a steady rate once the arena fills, which is
 * the workload the runner measures.
 *
 * The switches passed to [configure] each remove one part of that workload, so a change can be traced to the
 * subsystem it touches. Every random choice comes from one generator seeded by the runner, so two runs of a build with
 * the same switches play the same game.
 */
@Script
class Arena : Node2D() {
    /** Whether bullets and drones connect `area_entered`. Off, nothing ever hits: bullets only expire. */
    var hits = true
        private set

    /** Whether a hit starts a `Tween` and a death a `SceneTreeTimer`. Off, respawns are counted down here instead. */
    var reactions = true
        private set

    /** Whether the scene is queried and recorded through the engine: groups, `getNode`, scans and the score. */
    var bookkeeping = true
        private set

    /** Whether the run has a window to show effects in. Headless, measured runs leave them out of the workload. */
    var effects = false
        private set

    private val random = RandomNumberGenerator()
    // One shape per kind of body, shared as a scene would share its sub-resource.
    private val bulletShape = CircleShape2D()
    val droneShape = CircleShape2D()
    val sensorShape = CircleShape2D()
    // Filled only when bullets are nodes, one texture per team; otherwise the arena draws them.
    private val bulletTextures = arrayOfNulls<Texture2D>(2)
    lateinit var droneLook: DroneLook
        private set
    private lateinit var bulletContainer: Node
    private lateinit var droneContainer: Node
    private lateinit var status: Label
    private lateinit var framesPerSecond: Label
    private var framesUntilStatus = 0
    private var drawBullets = false
    // Only filled when the arena draws the bullets itself.
    private val drawnBullets = LinkedHashSet<Bullet>()
    // Kills recorded through the engine, by originals and by the children of splits; only kept with bookkeeping on.
    private val score = Dictionary<String, Long>()
    // The physics frames at which respawns fall due when reactions are off, in order.
    private val pendingRespawns = ArrayDeque<Long>()

    private var bulletsPerFrame = 0
    private var lifetimeFrames = 0
    private var maxLive = 0
    private var physicsFrame = 0L

    private var live = 0
    private var liveDrones = 0
    private var spawned = 0L
    private var bulletHits = 0L
    private var droneStrikes = 0L
    private var expired = 0L
    private var skipped = 0L
    private var droneHits = 0L
    private var kills = 0L
    private var childKills = 0L
    private var splits = 0L
    private var respawns = 0L
    private var scans = 0L
    private var scannedBullets = 0L
    private var scannedDrones = 0L

    @Register
    fun configure(
        seed: Long,
        bulletsPerFrame: Int,
        lifetimeFrames: Int,
        maxLive: Int,
        render: String,
        hits: Boolean,
        reactions: Boolean,
        bookkeeping: Boolean,
    ) {
        random.seed = seed
        bulletShape.radius = BULLET_RADIUS
        droneShape.radius = DRONE_RADIUS
        sensorShape.radius = Drone.SENSOR_RADIUS
        this.bulletsPerFrame = bulletsPerFrame
        this.lifetimeFrames = lifetimeFrames
        this.maxLive = maxLive
        this.hits = hits
        this.reactions = reactions
        this.bookkeeping = bookkeeping
        effects = DisplayServer.getName() != "headless"
        // Shifted right to leave room for the turrets outside the play field. Every body moves by the same amount, so the
        // physics, and so the game, are unchanged.
        position = Vector2(TURRET_MARGIN, 0.0)
        drawBullets = render == "draw"
        if (!drawBullets) {
            bulletTextures[0] = Art.disc(BULLET_DRAWN_RADIUS.toInt(), Art.TEAM_A)
            bulletTextures[1] = Art.disc(BULLET_DRAWN_RADIUS.toInt(), Art.TEAM_B)
        }
        val droneRadius = DRONE_DRAWN_RADIUS.toInt()
        droneLook = DroneLook(
            hollow = Art.disc(droneRadius, Art.HOLLOW),
            fill = Art.disc(droneRadius, Art.DRONE),
            face = Art.droneFace(droneRadius, Art.DRONE),
            sensor = Art.ring(Drone.SENSOR_RADIUS.toInt(), 2, Art.SENSOR),
        )
        if (bookkeeping) {
            score[ORIGINALS] = 0L
            score[CHILDREN] = 0L
        }

        bulletContainer = Node2D().also { it.name = BULLETS.asStringName() }
        droneContainer = Node2D().also { it.name = DRONES.asStringName() }
        addChild(bulletContainer)
        addChild(droneContainer)
        val teams = Label()
        val drones = Label()
        status = Label()
        teams.text = "Blue turrets fire right, orange turrets fire left. Bullets that meet destroy each other; " +
            "the rest fly off the far edge."
        drones.text = "Drones patrol the middle and drain as they are hit; the ring is the sensor each one scans. " +
            "A drone splits in two when it dies, then respawns."
        val hud = listOf(teams, drones, status)
        for ((line, label) in hud.withIndex()) {
            label.setPosition(Vector2(8.0 - TURRET_MARGIN, HUD_TOP + line * HUD_LINE_HEIGHT))
        }
        // Bottom right, on the row of the live counts: the one corner nothing else uses.
        framesPerSecond = Label()
        framesPerSecond.horizontalAlignment = HorizontalAlignment.RIGHT
        framesPerSecond.setPosition(Vector2(WIDTH + TURRET_MARGIN - 8 - FPS_LABEL_WIDTH, HUD_TOP + 2 * HUD_LINE_HEIGHT))
        framesPerSecond.setSize(Vector2(FPS_LABEL_WIDTH, HUD_LINE_HEIGHT))
        for (label in hud + framesPerSecond) {
            label.addThemeFontSizeOverride("font_size", 13)
            label.addThemeColorOverride("font_color", Art.TEXT)
            addChild(label)
        }
        // The lanes and the turret lines are drawn here once; in draw mode every frame redraws them with the bullets.
        queueRedraw()

        repeat(DRONE_COUNT) {
            spawnDrone(randomMiddleX(), randomY(), original = true)
        }
    }

    @Register
    override fun _physicsProcess(delta: Double) {
        ScriptCalls.count++
        physicsFrame++
        while (pendingRespawns.isNotEmpty() && pendingRespawns.first() <= physicsFrame) {
            pendingRespawns.removeFirst()
            respawn()
        }

        // Looked up by name every frame, as game code that does not cache its nodes does.
        val bullets = if (bookkeeping) getNode(BULLETS)!! else bulletContainer
        for (i in 0 until bulletsPerFrame) {
            if (live >= maxLive) {
                skipped++
                continue
            }
            val team = i % 2
            val firstLane = if (team == 0) 0 else LANES - LANES_PER_TEAM
            val lane = random.randiRange(firstLane, firstLane + LANES_PER_TEAM - 1)
            val bullet = Bullet()
            bullet.launch(
                arena = this,
                team = team,
                x = if (team == 0) 0.0 else WIDTH,
                y = TOP + lane * LANE_SPACING,
                velocityX = if (team == 0) BULLET_SPEED else -BULLET_SPEED,
                lifetimeFrames = lifetimeFrames,
                shape = bulletShape,
                texture = bulletTextures[team],
            )
            bullets.addChild(bullet)
            if (drawBullets) drawnBullets.add(bullet)
            live++
            spawned++
        }
        if (drawBullets) queueRedraw()
        // The live counts are only for a viewer, so a headless run does not build them. In a measured run the window
        // plays as fast as it can, so the FPS shown is how fast frames are computed.
        if (effects && --framesUntilStatus <= 0) {
            framesUntilStatus = STATUS_INTERVAL_FRAMES
            status.text = "Live bullets $live   bullet hits $bulletHits   drone hits $droneHits   kills $kills   " +
                "splits $splits   respawns $respawns   expired $expired"
            framesPerSecond.text = "%.0f FPS".format(Engine.getFramesPerSecond())
        }
    }

    @Register
    override fun _draw() {
        ScriptCalls.count++
        for (lane in 0 until LANES) {
            val y = TOP + lane * LANE_SPACING
            drawLine(Vector2(0.0, y), Vector2(WIDTH, y), Art.LANE, 1f)
        }
        // Each team's turrets stand on a base strip outside the play field, one at the start of every lane it fires
        // into, the barrel pointing into the lane where the bullets leave it.
        val baseHeight = LANES_PER_TEAM * LANE_SPACING
        val firstLaneB = LANES - LANES_PER_TEAM
        drawRect(Rect2(-TURRET_MARGIN, TOP - LANE_SPACING / 2, TURRET_MARGIN, baseHeight), Art.TEAM_A_BASE)
        drawRect(Rect2(WIDTH, TOP + (firstLaneB - 0.5) * LANE_SPACING, TURRET_MARGIN, baseHeight), Art.TEAM_B_BASE)
        // Each body sits TURRET_INSET from the outer edge, its barrel reaching to just short of the play field.
        val bodyA = -TURRET_MARGIN + TURRET_INSET
        val bodyB = WIDTH + TURRET_MARGIN - TURRET_INSET - TURRET_BODY
        for (lane in 0 until LANES_PER_TEAM) {
            val yA = TOP + lane * LANE_SPACING
            val yB = TOP + (firstLaneB + lane) * LANE_SPACING
            drawRect(Rect2(bodyA, yA - TURRET_HALF_HEIGHT, TURRET_BODY, 2 * TURRET_HALF_HEIGHT), Art.TEAM_A)
            drawLine(Vector2(bodyA + TURRET_BODY, yA), Vector2(-BARREL_GAP, yA), Art.TEAM_A, TURRET_BARREL)
            drawRect(Rect2(bodyB, yB - TURRET_HALF_HEIGHT, TURRET_BODY, 2 * TURRET_HALF_HEIGHT), Art.TEAM_B)
            drawLine(Vector2(bodyB, yB), Vector2(WIDTH + BARREL_GAP, yB), Art.TEAM_B, TURRET_BARREL)
        }
        for (bullet in drawnBullets) {
            drawCircle(bullet.position, BULLET_DRAWN_RADIUS, if (bullet.team == 0) Art.TEAM_A else Art.TEAM_B)
        }
    }

    fun recordBulletHit(bullet: Bullet, hitDrone: Boolean) {
        if (hitDrone) droneStrikes++ else bulletHits++
        removeBullet(bullet)
    }

    fun recordExpired(bullet: Bullet) {
        expired++
        removeBullet(bullet)
    }

    private fun removeBullet(bullet: Bullet) {
        live--
        if (drawBullets) drawnBullets.remove(bullet)
    }

    fun recordDroneHit() {
        droneHits++
    }

    fun recordKill(original: Boolean) {
        kills++
        liveDrones--
        if (!original) childKills++
        if (bookkeeping) {
            val key = if (original) ORIGINALS else CHILDREN
            score[key] = score[key] + 1
        }
    }

    fun recordScan(bulletsNearby: Int, drones: Int) {
        scans++
        scannedBullets += bulletsNearby
        scannedDrones += drones
    }

    /** The respawn of a dead drone when reactions are off: the same delay, counted in physics frames by the arena. */
    fun scheduleRespawn() {
        pendingRespawns.addLast(physicsFrame + RESPAWN_FRAMES)
    }

    fun respawn() {
        respawns++
        spawnDrone(randomMiddleX(), randomY(), original = true)
    }

    /** Two children where an original died, deferred to here because the engine refuses new areas in a collision. */
    @Register
    fun split(x: Double, y: Double) {
        ScriptCalls.count++
        if (liveDrones + 2 > MAX_DRONES) return
        splits++
        spawnDrone((x - SPLIT_OFFSET).coerceIn(MIDDLE_LEFT, MIDDLE_RIGHT), y, original = false)
        spawnDrone((x + SPLIT_OFFSET).coerceIn(MIDDLE_LEFT, MIDDLE_RIGHT), y, original = false)
    }

    private fun spawnDrone(x: Double, y: Double, original: Boolean) {
        val drone = Drone()
        drone.place(this, x, y, randomDirection() * DRONE_SPEED_X, randomDirection() * DRONE_SPEED_Y, original)
        val drones = if (bookkeeping) getNode(DRONES)!! else droneContainer
        drones.addChild(drone)
        liveDrones++
    }

    private fun randomDirection() = if (random.randiRange(0, 1) == 0) -1.0 else 1.0

    private fun randomMiddleX() = random.randfRange(MIDDLE_LEFT.toFloat(), MIDDLE_RIGHT.toFloat()).toDouble()

    private fun randomY() = random.randfRange(TOP.toFloat(), BOTTOM.toFloat()).toDouble()

    @Register
    fun liveBullets(): Int = live

    @Register
    fun jvmCounters(): Dictionary<String, Long> = Dictionary<String, Long>().also { counters ->
        for ((name, value) in JvmCounters.snapshot()) {
            counters[name] = value
        }
    }

    @Register
    fun garbageCollectors(): String = JvmCounters.collectorNames()

    @Register
    fun stats(): Dictionary<String, Long> = dictionaryOf(
        "spawned" to spawned,
        "bullet_hits" to bulletHits,
        "drone_strikes" to droneStrikes,
        "expired" to expired,
        "skipped" to skipped,
        "live" to live.toLong(),
        "drone_hits" to droneHits,
        "kills" to kills,
        "child_kills" to childKills,
        "splits" to splits,
        "respawns" to respawns,
        "live_drones" to liveDrones.toLong(),
        "scans" to scans,
        "scanned_bullets" to scannedBullets,
        "scanned_drones" to scannedDrones,
    )

    companion object {
        const val WIDTH = 960.0
        const val LANES = 24
        // Each team fires into 18 of the 24 lanes, offset from the other's: the middle 12 are shared and their bullets
        // meet head-on, the outer 6 on each side carry one team only and their bullets cross the arena and expire.
        const val LANES_PER_TEAM = 18
        const val TOP = 20.0
        const val LANE_SPACING = 24.0
        const val BOTTOM = TOP + (LANES - 1) * LANE_SPACING
        const val MIDDLE_LEFT = 300.0
        const val MIDDLE_RIGHT = 660.0

        private const val BULLETS = "Bullets"
        private const val DRONES = "Drones"
        private const val BULLET_SPEED = 400.0
        // Two bullets close in at 2 x 400 px/s, about 13 px per frame at 60 fps; radii summing past that keep a
        // head-on pair from passing through each other between two physics steps.
        private const val BULLET_RADIUS = 8f
        // Drawn smaller than it collides, so the lanes read as streams of separate shots rather than solid bands.
        private const val BULLET_DRAWN_RADIUS = 4f
        private const val DRONE_RADIUS = 14f
        // Drawn larger than it collides, so the faces read; the game only sees the collision radius.
        const val DRONE_DRAWN_RADIUS = 18.0
        // Width of each turret column outside the play field, and the turrets drawn in it.
        const val TURRET_MARGIN = 40.0
        private const val TURRET_INSET = 6.0
        private const val TURRET_BODY = 18.0
        private const val BARREL_GAP = 2.0
        private const val TURRET_HALF_HEIGHT = 7.0
        private const val TURRET_BARREL = 4f
        private const val HUD_TOP = 588.0
        private const val HUD_LINE_HEIGHT = 19.0
        private const val FPS_LABEL_WIDTH = 120.0
        private const val STATUS_INTERVAL_FRAMES = 15

        private const val DRONE_COUNT = 12
        // Drones only split while the arena holds fewer than this, so children cannot pile up.
        private const val MAX_DRONES = 24
        private const val SPLIT_OFFSET = 30.0
        private const val DRONE_SPEED_X = 60.0
        private const val DRONE_SPEED_Y = 120.0
        private const val ORIGINALS = "originals"
        private const val CHILDREN = "children"
        // Half a second at 60 physics frames per second, the same delay as the timer a reaction would start.
        private const val RESPAWN_FRAMES = 30L
    }
}
