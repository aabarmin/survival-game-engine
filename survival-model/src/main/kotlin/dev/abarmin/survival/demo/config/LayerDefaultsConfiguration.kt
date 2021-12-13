package dev.abarmin.survival.demo.config

import dev.abarmin.survival.demo.scene.info.SceneLayerType

/**
 * @author Aleksandr Barmin
 */
data class LayerDefaultsConfiguration(
    val type: SceneLayerType = SceneLayerType.STATIC,
    val name: String = "Automatically created layer"
)