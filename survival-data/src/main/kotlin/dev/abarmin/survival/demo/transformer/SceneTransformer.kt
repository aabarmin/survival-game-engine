package dev.abarmin.survival.demo.transformer

import dev.abarmin.survival.demo.entity.SceneEntity
import dev.abarmin.survival.demo.scene.info.SceneInfo
import org.springframework.stereotype.Component

/**
 * @author Aleksandr Barmin
 */
@Component
class SceneTransformer(val layerTransformer: LayerTransformer) {
    fun toModel(domain: SceneEntity): SceneInfo {
        return SceneInfo(
            domain.id,
            domain.name,
            domain.layers.map { layerTransformer.toModel(it) },
            domain.type
        )
    }

    fun toDomain(model: SceneInfo): SceneEntity {
        return SceneEntity(
            model.id,
            model.name,
            model.type,
            model.layers.map { layerTransformer.toDomain(it) }
        )
    }
}