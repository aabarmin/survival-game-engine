package dev.abarmin.survival.demo.config

import dev.abarmin.survival.demo.scene.info.SceneType

/**
 * @author Aleksandr Barmin
 */
data class SceneDefaultsConfiguration(
    var type: SceneType = SceneType.LAYERED,
    var width: Int = 128,
    var height: Int = 96
)