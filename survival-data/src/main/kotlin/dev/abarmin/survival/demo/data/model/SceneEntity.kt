package dev.abarmin.survival.demo.data.model

/**
 * Top-level entity for scenes.
 *
 * @author Aleksandr Barmin
 */
data class SceneEntity(
    val id: String,
    var name: String,
    var type: String,
    val layers: List<SceneLayerEntity>
)