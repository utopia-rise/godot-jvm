package godot.bulletmark

import godot.api.Image
import godot.api.ImageTexture
import godot.api.Texture2D
import godot.core.Color
import kotlin.math.sqrt

/**
 * The scene's look, generated once at startup so the project ships no image files. Every texture here is built once
 * and shared by every body that shows it, so only the startup pays for it.
 */
object Art {
    val TEAM_A = Color(0.35, 0.8, 1.0, 1.0)
    val TEAM_B = Color(1.0, 0.6, 0.25, 1.0)
    val TEAM_A_BASE = Color(0.35, 0.8, 1.0, 0.14)
    val TEAM_B_BASE = Color(1.0, 0.6, 0.25, 0.14)
    val DRONE = Color(0.95, 0.3, 0.35, 1.0)
    val SENSOR = Color(0.95, 0.3, 0.35, 0.3)
    val LANE = Color(1.0, 1.0, 1.0, 0.07)
    val TEXT = Color(0.9, 0.9, 0.9, 1.0)
    private val FEATURE = Color(1.0, 0.97, 0.9, 1.0)
    /** The dark inside of a drone, which shows where its body has drained. */
    val HOLLOW = Color(0.08, 0.08, 0.1, 0.92)
    private const val TEETH = 6

    fun disc(radius: Int, color: Color): Texture2D {
        val image = blank(radius)
        fillDisc(image, centre(radius), centre(radius), radius.toDouble(), color)
        return texture(image)
    }

    /** A circle outline [thickness] pixels wide. */
    fun ring(radius: Int, thickness: Int, color: Color): Texture2D {
        val image = blank(radius)
        strokeRing(image, centre(radius), centre(radius), radius.toDouble(), thickness.toDouble(), color)
        return texture(image)
    }

    /**
     * A drone's outline and evil face, drawn over its fill: transparent inside, so the fill below shows how much of the
     * drone is left.
     */
    fun droneFace(radius: Int, color: Color): Texture2D {
        val image = blank(radius)
        val r = radius.toDouble()
        val c = centre(radius)
        strokeRing(image, c, c, r, 3.0, color)
        // Brows slanting down towards the nose read as anger at any size.
        line(image, c - 0.62 * r, c - 0.5 * r, c - 0.12 * r, c - 0.22 * r, 2.4, FEATURE)
        line(image, c + 0.62 * r, c - 0.5 * r, c + 0.12 * r, c - 0.22 * r, 2.4, FEATURE)
        fillDisc(image, c - 0.34 * r, c - 0.05 * r, 0.13 * r, FEATURE)
        fillDisc(image, c + 0.34 * r, c - 0.05 * r, 0.13 * r, FEATURE)
        // A jagged grin: a zigzag of teeth across the lower face.
        for (tooth in 0 until TEETH) {
            val x0 = c - 0.5 * r + tooth * r / TEETH
            val upFirst = tooth % 2 == 0
            line(image, x0, c + (if (upFirst) 0.32 else 0.5) * r, x0 + r / TEETH, c + (if (upFirst) 0.5 else 0.32) * r, 1.8, FEATURE)
        }
        return texture(image)
    }

    private fun centre(radius: Int) = radius - 0.5

    private fun blank(radius: Int): Image = Image.create(radius * 2, radius * 2, false, Image.Format.RGBA8)!!

    private fun texture(image: Image): Texture2D = ImageTexture.createFromImage(image)!!

    private fun fillDisc(image: Image, cx: Double, cy: Double, discRadius: Double, color: Color) {
        val size = image.getWidth()
        for (y in 0 until size) {
            for (x in 0 until size) {
                if (distance(x - cx, y - cy) <= discRadius) image.setPixel(x, y, color)
            }
        }
    }

    private fun strokeRing(image: Image, cx: Double, cy: Double, ringRadius: Double, thickness: Double, color: Color) {
        val size = image.getWidth()
        for (y in 0 until size) {
            for (x in 0 until size) {
                val d = distance(x - cx, y - cy)
                if (d <= ringRadius && d > ringRadius - thickness) image.setPixel(x, y, color)
            }
        }
    }

    /** A line of [thickness] pixels from (x0, y0) to (x1, y1). */
    private fun line(image: Image, x0: Double, y0: Double, x1: Double, y1: Double, thickness: Double, color: Color) {
        val dx = x1 - x0
        val dy = y1 - y0
        val lengthSquared = dx * dx + dy * dy
        val size = image.getWidth()
        for (y in 0 until size) {
            for (x in 0 until size) {
                val t = if (lengthSquared == 0.0) 0.0 else (((x - x0) * dx + (y - y0) * dy) / lengthSquared).coerceIn(0.0, 1.0)
                if (distance(x - (x0 + t * dx), y - (y0 + t * dy)) <= thickness / 2) image.setPixel(x, y, color)
            }
        }
    }

    private fun distance(dx: Double, dy: Double) = sqrt(dx * dx + dy * dy)
}
