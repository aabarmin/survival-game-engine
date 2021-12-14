package dev.abarmin.survival.demo.scene.builder.controller.scene.model

import dev.abarmin.survival.demo.scene.info.SceneLayerType

/**
 * @author Aleksandr Barmin
 */
data class CreateLayerRequest(
    val name: String,
    val type: SceneLayerType
)