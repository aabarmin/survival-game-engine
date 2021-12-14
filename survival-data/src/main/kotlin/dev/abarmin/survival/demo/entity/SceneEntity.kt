package dev.abarmin.survival.demo.entity

import dev.abarmin.survival.demo.scene.info.SceneType

/**
 * Top-level entity for scenes.
 *
 * @author Aleksandr Barmin
 */
data class SceneEntity(
    val id: String,
    val name: String,
    val type: SceneType,
    val width: Int,
    val height: Int,
    val layers: List<SceneLayerEntity>
)