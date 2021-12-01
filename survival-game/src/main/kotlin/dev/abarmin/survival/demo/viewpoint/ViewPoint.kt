package dev.abarmin.survival.demo.viewpoint

/**
 * A view point, piece of the whole scene which is visible for the player. At this moment,
 * it will be the position of top-left corner.
 *
 * @author Aleksandr Barmin
 */
data class ViewPoint(
    var x: Int = 0,
    var y: Int = 0
) {

    val width: Int = 128
    val height: Int = 96
}