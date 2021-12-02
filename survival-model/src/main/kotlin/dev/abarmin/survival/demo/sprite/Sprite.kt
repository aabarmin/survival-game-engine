package dev.abarmin.survival.demo.sprite

import dev.abarmin.survival.demo.scene.PixelColor
import dev.abarmin.survival.demo.scene.PixelPosition
import dev.abarmin.survival.demo.scene.SceneUpdateContext

/**
 * Technically - it can be anything which is displayed at the particular piece of the scene
 * but the position or behaviour is calculated based on some conditions.
 *
 * @author Aleksandr Barmin
 */
sealed interface Sprite {
    /**
     * Get width of the sprite.
     */
    fun getWidth(): Int

    /**
     * Get height of the sprite.
     */
    fun getHeight(): Int

    /**
     * Coordinate of the top-left corner.
     */
    fun getTopLeft(): PixelPosition

    /**
     * Get color of the sprite.
     */
    fun getColor(coordinate: PixelPosition): PixelColor

    /**
     * Update the sprite's state.
     */
    fun update(context: SceneUpdateContext) {
        // do nothing by default
    }
}