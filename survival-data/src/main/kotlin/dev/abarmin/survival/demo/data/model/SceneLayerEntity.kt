package dev.abarmin.survival.demo.data.model

import dev.abarmin.survival.demo.scene.info.SceneLayerType

/**
 * Entity for layers.
 *
 * @author Aleksandr Barmin
 */
data class SceneLayerEntity(
    val id: String,
    val name: String,
    val type: SceneLayerType,
    val file: FileEntity
)