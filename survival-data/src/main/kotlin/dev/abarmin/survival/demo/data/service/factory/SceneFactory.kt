package dev.abarmin.survival.demo.data.service.factory

import dev.abarmin.survival.demo.data.config.DefaultsConfiguration
import dev.abarmin.survival.demo.scene.info.SceneInfo
import org.springframework.stereotype.Component

/**
 * A component for creation of scenes.
 *
 * @author Aleksandr Barmin
 */
@Component
class SceneFactory(
    val defaults: DefaultsConfiguration,
    val layerFactory: SceneLayerFactory
) {
    /**
     * Creates a new empty scene.
     */
    fun createScene(id: String, name: String): SceneInfo {
        return SceneInfo(
            id,
            name,
            listOf(layerFactory.createLayer()),
            defaults.scene.type
        )
    }
}