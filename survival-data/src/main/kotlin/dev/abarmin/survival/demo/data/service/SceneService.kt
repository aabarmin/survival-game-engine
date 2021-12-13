package dev.abarmin.survival.demo.data.service

import dev.abarmin.survival.demo.data.repository.SceneRepository
import dev.abarmin.survival.demo.data.transformer.SceneTransformer
import dev.abarmin.survival.demo.scene.info.SceneInfo
import org.springframework.stereotype.Service
import java.util.*

/**
 * @author Aleksandr Barmin
 */
@Service
class SceneService(
    private val repository: SceneRepository,
    private val transformer: SceneTransformer
) {

    fun findAll(): List<SceneInfo> {
        return repository.findAll()
            .map { transformer.toModel(it) }
    }

    fun save(scene: SceneInfo): SceneInfo {
        val domain = transformer.toDomain(scene)
        val saved = repository.save(domain)
        return transformer.toModel(saved)
    }

    fun findById(sceneId: String): Optional<SceneInfo> {
        return repository.findById(sceneId)
            .map { transformer.toModel(it) }
    }
}