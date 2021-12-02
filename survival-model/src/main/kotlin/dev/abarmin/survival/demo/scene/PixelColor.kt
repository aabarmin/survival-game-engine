package dev.abarmin.survival.demo.scene

/**
 * Color of one single piece of scene.
 *
 * @author Aleksandr Barmin
 */
data class PixelColor(
    val red: Int,
    val green: Int,
    var blue: Int,
    var transparency: Int
) {
    companion object {
        val TRANSPARENT = PixelColor(255, 255, 255, 100)
    }

    fun isTransparent(): Boolean {
        return transparency == 100
    }
}