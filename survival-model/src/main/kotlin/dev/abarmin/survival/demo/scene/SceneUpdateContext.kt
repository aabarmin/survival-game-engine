package dev.abarmin.survival.demo.scene

import dev.abarmin.survival.demo.viewpoint.ViewPoint

/**
 * DTO which stores information about current context, which can be used
 * to update scenes, layers, etc.
 *
 * @author Aleksandr Barmin
 */
data class SceneUpdateContext(
    val viewPoint: ViewPoint
)