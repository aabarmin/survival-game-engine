package dev.abarmin.survival.demo.scene.builder.controller.scene.transformer

import dev.abarmin.survival.demo.scene.builder.controller.scene.model.SceneModel
import dev.abarmin.survival.demo.scene.info.SceneInfo
import org.springframework.stereotype.Component

/**
 * @author Aleksandr Barmin
 */
@Component
class SceneRestTransformer(private val layerTransformer: SceneLayerRestTransformer) {
    fun toModel(info: SceneInfo): SceneModel {
        return SceneModel(
            info.id,
            info.name,
            info.type,
            info.layers.map { layerTransformer.toModel(it) }
        )
    }
}