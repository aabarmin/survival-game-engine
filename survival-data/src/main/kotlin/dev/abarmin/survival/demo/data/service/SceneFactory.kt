package dev.abarmin.survival.demo.data.service

import dev.abarmin.survival.demo.scene.info.SceneInfo
import org.springframework.stereotype.Component

/**
 * A component for creation of scenes.
 *
 * @author Aleksandr Barmin
 */
@Component
class SceneFactory {
    /**
     * Creates a new empty scene.
     */
    fun createScene(name: String): SceneInfo {
        return SceneInfo(name, mutableListOf())
    }
}