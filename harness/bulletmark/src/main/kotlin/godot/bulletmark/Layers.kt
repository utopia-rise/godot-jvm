package godot.bulletmark

/** Physics layers: each bullet team scans the other team and the drones; drones scan both teams. */
object Layers {
    const val TEAM_A = 1L
    const val TEAM_B = 2L
    const val DRONE = 4L
}
