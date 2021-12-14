package dev.abarmin.survival.demo.service

import dev.abarmin.survival.demo.repository.SceneRepository
import dev.abarmin.survival.demo.scene.info.SceneInfo
import dev.abarmin.survival.demo.scene.info.SceneLayerInfo
import dev.abarmin.survival.demo.utils.addFirst
import org.springframework.stereotype.Service

/**
 * Service with special methods for dealing with layers.
 *
 * @author Aleksandr Barmin
 */
@Service
class LayerService(private val repository: SceneRepository) {
    /**
     * Add a new scene on top of existing ones.
     */
    fun addLayer(scene: SceneInfo, layer: SceneLayerInfo): SceneInfo {
        // looks like, I need to create a copy of the object.
        // this looks meaningful however it's a waste of resources still
        val newScene = SceneInfo(
            scene.id,
            scene.name,
            addFirst(layer, scene.layers),
            scene.width,
            scene.height
        )
        return repository.save(newScene)
    }
}