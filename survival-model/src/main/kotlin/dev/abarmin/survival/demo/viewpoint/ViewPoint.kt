package dev.abarmin.survival.demo.viewpoint

import dev.abarmin.survival.demo.scene.PixelPosition

/**
 * A view point, piece of the whole scene which is visible for the player. At this moment,
 * it will be the position of top-left corner.
 *
 * @author Aleksandr Barmin
 */
data class ViewPoint(
    val position: PixelPosition = PixelPosition(0, 0)
) {

    val width: Int = 128
    val height: Int = 96
}