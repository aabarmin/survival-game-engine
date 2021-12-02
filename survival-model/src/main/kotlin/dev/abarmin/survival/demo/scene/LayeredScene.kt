package dev.abarmin.survival.demo.scene

/**
 * Simple basic implementation of the scene.
 *
 * @author Aleksandr Barmin
 */
abstract class LayeredScene : Scene {
    /**
     * Get layers of the scene.
     */
    abstract fun getLayers(): List<SceneLayer>

    /**
     * Getting color of the pixel. At the moment, the implementation is naive -
     * color of the latest layer is taken.
     */
    override fun getColor(x: Int, y: Int): PixelColor {
        for (layer in getLayers()) {
            val color = layer.getColor(x, y)
            if (!color.isTransparent()) {
                return color
            }
        }
        return PixelColor.TRANSPARENT
    }

    /**
     * Update internal state of every layer.
     */
    override fun update(context: SceneUpdateContext) {
        getLayers().forEach {
            it.update(context)
        }
    }
}