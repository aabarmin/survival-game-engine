package dev.abarmin.survival.demo.scene.builder.model.scene

import dev.abarmin.survival.demo.scene.builder.model.sprite.SpriteModel

/**
 *
 *
 * @author Aleksandr Barmin
 */
data class DynamicSceneLayerModel(
    val type: String = "dynamic",
    val data: Array<SpriteModel>
) : SceneLayerModel(type)