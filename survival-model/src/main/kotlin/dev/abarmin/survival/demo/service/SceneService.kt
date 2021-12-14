package dev.abarmin.survival.demo.service

import dev.abarmin.survival.demo.repository.SceneRepository
import dev.abarmin.survival.demo.scene.info.SceneInfo
import dev.abarmin.survival.demo.scene.info.SceneLayerInfo
import org.springframework.stereotype.Service
import java.util.*

/**
 * @author Aleksandr Barmin
 */
@Service
class SceneService(
    private val repository: SceneRepository
) {

    fun findAll(): List<SceneInfo> {
        return repository.findAll()
    }

    fun findById(sceneId: String): Optional<SceneInfo> {
        return repository.findById(sceneId)
    }
}