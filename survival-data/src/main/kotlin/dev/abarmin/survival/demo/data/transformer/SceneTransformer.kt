package dev.abarmin.survival.demo.data.transformer

import dev.abarmin.survival.demo.data.model.SceneEntity
import dev.abarmin.survival.demo.data.repository.SceneRepository
import dev.abarmin.survival.demo.scene.info.SceneInfo
import org.springframework.stereotype.Component

/**
 * @author Aleksandr Barmin
 */
@Component
class SceneTransformer(val layerTransformer: LayerTransformer) {
    fun toModel(domain: SceneEntity): SceneInfo {
        return SceneInfo(
            domain.name,
            domain.layers.map { layerTransformer.toModel(it) },
            domain.type
        )
    }

    fun toDomain(model: SceneInfo): SceneEntity {
        return SceneEntity(
            model.name,
            model.type,
            model.layers.map { layerTransformer.toDomain(it) }
        )
    }
}