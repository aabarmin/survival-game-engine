package dev.abarmin.survival.demo.scene

/**
 * At this moment, this is a class which is responsible for string some content of the scene.
 *
 * @author Aleksandr Barmin
 */
sealed interface SceneLayer {
    /**
     * Get color of the particular pixel of the layer.
     */
    fun getColor(position: PixelPosition): PixelColor

    /**
     * Update the state if necessary.
     */
    fun update(context: SceneUpdateContext) {
        // do nothing by default.
    }
}