package dev.abarmin.survival.demo.data.model

import dev.abarmin.survival.demo.scene.info.SceneType

/**
 * Top-level entity for scenes.
 *
 * @author Aleksandr Barmin
 */
data class SceneEntity(
    val id: String,
    var name: String,
    var type: SceneType,
    val layers: List<SceneLayerEntity>
)