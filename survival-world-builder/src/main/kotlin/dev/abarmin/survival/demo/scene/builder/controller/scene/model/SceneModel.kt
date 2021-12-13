package dev.abarmin.survival.demo.scene.builder.controller.scene.model

import dev.abarmin.survival.demo.scene.info.SceneType

/**
 * A model for REST which describes a scene.
 *
 * @author Aleksandr Barmin
 */
data class SceneModel(
    val id: String,
    val name: String,
    val type: SceneType,
    val layers: List<SceneLayerModel>
)