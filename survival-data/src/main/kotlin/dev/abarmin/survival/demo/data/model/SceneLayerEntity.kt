package dev.abarmin.survival.demo.data.model

/**
 * Entity for layers.
 *
 * @author Aleksandr Barmin
 */
data class SceneLayerEntity(
    val type: String,
    val sceneId: Long,
    val file: FileEntity
)