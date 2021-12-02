package dev.abarmin.survival.demo.scene.intro

import dev.abarmin.survival.demo.controller.SceneController
import dev.abarmin.survival.demo.scene.*
import dev.abarmin.survival.demo.scene.provider.SceneContentLoader
import org.springframework.stereotype.Component

/**
 * Intro scene for the game. Something like a title and so on.
 *
 * @author Aleksandr Barmin
 */
@Component
class IntroScene(
    private val sceneController: SceneController,
    private val contentLoader: SceneContentLoader
) : LayeredScene() {
    private val layers: List<SceneLayer> = listOf(
        StaticSceneLayer(contentLoader.loadContent("introScene")),
        DynamicSceneLayer(listOf(JumpingPackmanSprite(
            createPackman(),
            PixelPosition(0, 50)
        )))
    )

    private fun createPackman(): Array<Array<PixelColor>> {
        return Array(20) { _ -> Array(20) { _ -> PixelColor(0, 255, 0, 0) } }
    }

    override fun getLayers(): List<SceneLayer> {
        return layers
    }

    override fun isDone(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getSceneController(): SceneController {
        return this.sceneController
    }
}