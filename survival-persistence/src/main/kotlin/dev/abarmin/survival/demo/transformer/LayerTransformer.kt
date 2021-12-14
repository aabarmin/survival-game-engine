package dev.abarmin.survival.demo.transformer

import dev.abarmin.survival.demo.entity.SceneLayerEntity
import dev.abarmin.survival.demo.scene.info.SceneLayerInfo
import org.springframework.stereotype.Component

/**
 * @author Aleksandr Barmin
 */
@Component
class LayerTransformer(val contentTransformer: BinaryContentTransformer) {
    fun toDomain(model: SceneLayerInfo): SceneLayerEntity {
        return SceneLayerEntity(
            model.id,
            model.name,
            model.type,
            contentTransformer.toDomain(model.content)
        )
    }

    fun toModel(domain: SceneLayerEntity): SceneLayerInfo {
        return SceneLayerInfo(
            domain.id,
            domain.name,
            domain.type,
            contentTransformer.toModel(domain.file)
        )
    }
}