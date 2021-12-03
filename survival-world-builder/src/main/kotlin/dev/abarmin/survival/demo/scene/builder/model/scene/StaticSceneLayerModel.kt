package dev.abarmin.survival.demo.scene.builder.model.scene

import dev.abarmin.survival.demo.scene.builder.model.pixel.PixelModel

/**
 * @author Aleksandr Barmin
 */
class StaticSceneLayerModel(
    type: String,
    val data: Array<PixelModel>
) : SceneLayerModel(type)