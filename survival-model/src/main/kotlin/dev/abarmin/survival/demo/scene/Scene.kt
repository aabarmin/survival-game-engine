package dev.abarmin.survival.demo.scene

import dev.abarmin.survival.demo.controller.SceneController
import java.lang.RuntimeException

/**
 * Basic scene.
 *
 * @author Aleksandr Barmin
 */
interface Scene {
    /**
     * Get color of a particular pixel of the scene.
     */
    fun getColor(x: Int, y: Int): PixelColor
    /**
     * Put some color to the particular point of the scene.
     */
    @Deprecated("For removal")
    fun putValue(x: Int, y: Int, value: Int) {
        throw RuntimeException("This method is not supported anymore")
    }

    /**
     * Get content of the scene.
     */
    @Deprecated("For removal")
    fun getContent(): Array<IntArray> {
        throw RuntimeException("This method is not supported anymore")
    }

    /**
     * Update the scene - some internals live.
     */
    fun update(context: SceneUpdateContext)

    /**
     * Some checker that this scene is done and it is necessary to move to another scene.
     */
    fun isDone(): Boolean

    /**
     * Get controller configured for the given scene.
     */
    fun getSceneController(): SceneController
}