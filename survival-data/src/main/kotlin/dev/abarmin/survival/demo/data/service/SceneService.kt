package dev.abarmin.survival.demo.data.service

import dev.abarmin.survival.demo.data.repository.SceneRepository
import dev.abarmin.survival.demo.data.transformer.SceneTransformer
import dev.abarmin.survival.demo.scene.info.SceneInfo
import org.springframework.stereotype.Service

/**
 * @author Aleksandr Barmin
 */
@Service
class SceneService(
    val repository: SceneRepository,
    val transformer: SceneTransformer
) {

    fun save(scene: SceneInfo): SceneInfo {
        val domain = transformer.toDomain(scene)
        val saved = repository.save(domain)
        return transformer.toModel(saved)
    }

    fun findScene(sceneName: String): SceneInfo {
        val domain = repository.findByName(sceneName)
            .orElseThrow()
        return transformer.toModel(domain)
    }
}