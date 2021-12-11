package dev.abarmin.survival.demo.data.model

/**
 * Top-level entity for scenes.
 *
 * @author Aleksandr Barmin
 */
data class SceneEntity(
    var name: String,
    var type: String,
    val layers: Set<SceneLayerEntity>
)