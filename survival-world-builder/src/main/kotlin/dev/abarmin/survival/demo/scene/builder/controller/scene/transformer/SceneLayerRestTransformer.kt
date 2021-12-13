package dev.abarmin.survival.demo.scene.builder.controller.scene.transformer

import dev.abarmin.survival.demo.scene.builder.controller.scene.model.SceneLayerModel
import dev.abarmin.survival.demo.scene.info.SceneLayerInfo
import org.springframework.stereotype.Component

/**
 * @author Aleksandr Barmin
 */
@Component
class SceneLayerRestTransformer {
    fun toModel(layer: SceneLayerInfo): SceneLayerModel {
        return SceneLayerModel(
            layer.id,
            layer.name,
            layer.type,
            layer.content
        )
    }
}