package dev.abarmin.survival.demo.service

import dev.abarmin.survival.demo.config.DefaultsConfiguration
import dev.abarmin.survival.demo.repository.SceneRepository
import dev.abarmin.survival.demo.scene.info.SceneInfo
import org.springframework.stereotype.Component

/**
 * A component for creation of scenes.
 *
 * @author Aleksandr Barmin
 */
@Component
class SceneFactory(
    private val defaults: DefaultsConfiguration,
    private val sceneRepository: SceneRepository,
    private val layerFactory: SceneLayerFactory
) {
    fun createScene(id: String, name: String, width: Int, height: Int): SceneInfo {
        val newScene = SceneInfo(
            id,
            name,
            listOf(layerFactory.createLayer(width, height)),
            width,
            height,
            defaults.scene.type
        )
        return sceneRepository.save(newScene)
    }

    /**
     * Creates a new empty scene.
     */
    fun createScene(id: String, name: String): SceneInfo {
        return createScene(
            id,
            name,
            defaults.scene.width,
            defaults.scene.height
        )
    }
}