package dev.abarmin.survival.demo.scene.base

import dev.abarmin.survival.demo.scene.Scene

/**
 * The listener is called when the scene is changed.
 *
 * @author Aleksandr Barmin
 */
interface SceneChangeListener {
    fun onChange(scene: Scene)
}