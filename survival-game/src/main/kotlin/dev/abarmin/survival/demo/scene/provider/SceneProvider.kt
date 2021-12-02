package dev.abarmin.survival.demo.scene.provider

import dev.abarmin.survival.demo.scene.Scene
import dev.abarmin.survival.demo.scene.intro.IntroScene
import org.springframework.stereotype.Component

/**
 * Provides scenes based on their names.
 *
 * @author Aleksandr Barmin
 */
@Component
class SceneProvider(
    private val introScene: IntroScene
)  {
    private val scenes = mapOf(
        "intro" to introScene
    )

    fun getScene(name: String): Scene {
        if (scenes.containsKey(name)) {
            return scenes[name]!!
        }
        throw IllegalArgumentException(String.format(
            "No scene with name %s",
            name
        ))
    }
}