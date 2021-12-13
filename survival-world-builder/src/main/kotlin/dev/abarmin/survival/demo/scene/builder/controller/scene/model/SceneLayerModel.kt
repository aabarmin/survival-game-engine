package dev.abarmin.survival.demo.scene.builder.controller.scene.model

import dev.abarmin.survival.demo.scene.info.BinaryContent
import dev.abarmin.survival.demo.scene.info.SceneLayerType

/**
 * REST layer model.
 *
 * @author Aleksandr Barmin
 */
data class SceneLayerModel(
    val id: String,
    val name: String,
    val type: SceneLayerType,
    val content: BinaryContent
)