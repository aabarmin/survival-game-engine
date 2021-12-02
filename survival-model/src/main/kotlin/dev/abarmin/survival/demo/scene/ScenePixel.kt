package dev.abarmin.survival.demo.scene

/**
 * One single piece of picture.
 *
 * @author Aleksandr Barmin
 */
data class ScenePixel(
    val x: Int,
    val y: Int,
    var color: PixelColor
)