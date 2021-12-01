package dev.abarmin.survival.demo.controller

/**
 * Game controller which is the main entry point for all actions.
 *
 * @author Aleksandr Barmin
 */
interface SceneController {
    /**
     * Mouse is pressed the pixel with the given coordinates.
     */
    fun mousePress(x: Int, y: Int)

    /**
     * Handle the keypress event.
     */
    fun keyPressed(key: Char)
}