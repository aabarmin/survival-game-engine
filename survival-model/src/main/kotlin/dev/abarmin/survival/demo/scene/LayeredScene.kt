package dev.abarmin.survival.demo.scene

/**
 * Simple basic implementation of the scene.
 *
 * @author Aleksandr Barmin
 */
abstract class LayeredScene(
    private val layers: List<SceneLayer>
) : Scene {

    /**
     * Getting color of the pixel. At the moment, the implementation is naive -
     * color of the latest layer is taken.
     */
    override fun getColor(x: Int, y: Int): PixelColor {
        val topLayer = layers[layers.size - 1]
        return topLayer.getColor(x, y)
    }

    /**
     * Update internal state of every layer.
     */
    override fun update(context: SceneUpdateContext) {
        layers.forEach {
            it.update(context)
        }
    }
}