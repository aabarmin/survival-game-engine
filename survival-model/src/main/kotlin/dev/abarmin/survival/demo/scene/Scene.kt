package dev.abarmin.survival.demo.scene

import dev.abarmin.survival.demo.controller.SceneController

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