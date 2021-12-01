package dev.abarmin.survival.demo.scene.base

import dev.abarmin.survival.demo.controller.SceneController

/**
 * Basic scene.
 *
 * @author Aleksandr Barmin
 */
interface Scene {
    /**
     * Put some color to the particular point of the scene.
     */
    fun putValue(x: Int, y: Int, value: Int)

    /**
     * Get content of the scene.
     */
    fun getContent(): Array<IntArray>

    /**
     * Update the scene - some internals live.
     */
    fun update()

    /**
     * Some checker that this scene is done and it is necessary to move to another scene.
     */
    fun isDone(): Boolean

    /**
     * Get controller configured for the given scene.
     */
    fun getSceneController(): SceneController
}