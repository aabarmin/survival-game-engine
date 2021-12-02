package dev.abarmin.survival.demo.scene

import dev.abarmin.survival.demo.sprite.Sprite

/**
 * Layer which contains some dynamic sprites.
 *
 * @author Aleksandr Barmin
 */
class DynamicSceneLayer(private val sprites: List<Sprite>) : SceneLayer {
    override fun getColor(position: PixelPosition): PixelColor {
        /**
         * Should return totally transparent color if nothing to return.
         * First, it's necessary to find the first sprite which is in the given position.
         * I suppose, it's possible to implement it in the better way but right now
         * I need to make the solution working, nothing more.
         */
        for (sprite in sprites) {
            if (belongs(sprite, position)) {
                return sprite.getColor(position.minuxGiven(sprite.getTopLeft()))
            }
        }
        return PixelColor.TRANSPARENT
    }

    private fun belongs(sprite: Sprite, pixelPosition: PixelPosition): Boolean {
        val (x, y) = pixelPosition.minuxGiven(sprite.getTopLeft())
        return x >= 0 && y >= 0 && x < sprite.getWidth() && y < sprite.getHeight()
    }

    /**
     * Updating all the internal sprites.
     */
    override fun update(context: SceneUpdateContext) {
        sprites.forEach { it.update(context) }
    }
}