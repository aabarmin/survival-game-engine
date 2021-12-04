package dev.abarmin.survival.demo.scene.intro

import dev.abarmin.survival.demo.controller.SceneController
import dev.abarmin.survival.demo.scene.*
import dev.abarmin.survival.demo.scene.intro.sprite.JumpingPackmanSprite
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
    private val packmanSprite = JumpingPackmanSprite(
        createPackman(),
        PixelPosition(0, 50)
    )
    private val layers: List<SceneLayer> = listOf(
        StaticSceneLayer(contentLoader.loadContent("introScene")),
        DynamicSceneLayer(arrayOf(
            packmanSprite
        ))
    )

    private fun createPackman(): Array<Array<PixelColor>> {
        return Array(20) { _ -> Array(20) { _ -> PixelColor(0, 255, 0, 0) } }
    }

    override fun getLayers(): List<SceneLayer> {
        return layers
    }

    override fun isDone(context: SceneUpdateContext): Boolean {
        return packmanSprite.getTopLeft().x > 128
    }

    override fun getSceneController(): SceneController {
        return this.sceneController
    }
}