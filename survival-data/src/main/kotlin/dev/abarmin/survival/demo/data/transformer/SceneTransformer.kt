package dev.abarmin.survival.demo.data.transformer

import dev.abarmin.survival.demo.data.model.SceneEntity
import dev.abarmin.survival.demo.data.repository.SceneRepository
import dev.abarmin.survival.demo.scene.info.SceneInfo
import org.springframework.stereotype.Component

/**
 * @author Aleksandr Barmin
 */
@Component
class SceneTransformer(val repository: SceneRepository) {
    fun toModel(domain: SceneEntity): SceneInfo {
        return SceneInfo(
            name = domain.name,
            type = domain.type,
            layers = listOf()
        )
    }

    fun toDomain(model: SceneInfo): SceneEntity {
        var domain = repository.findByName(model.name)
            .orElse(
                SceneEntity(
                    name = model.name,
                    type = model.type,
                    layers = setOf() // TODO, fix implementation
                )
            )
        return domain
    }
}