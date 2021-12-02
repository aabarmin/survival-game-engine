package dev.abarmin.survival.demo.scene.intro

import dev.abarmin.survival.demo.controller.SceneController
import dev.abarmin.survival.demo.scene.PixelColor
import dev.abarmin.survival.demo.scene.Scene
import dev.abarmin.survival.demo.scene.SceneUpdateContext
import dev.abarmin.survival.demo.scene.provider.SceneContentLoader
import org.springframework.stereotype.Component

/**
 * Intro scene for the game. Something like a title and so on.
 *
 * @author Aleksandr Barmin
 */
@Component
class IntroScene(
    private val introController: IntroSceneController,
    private val sceneLoader: SceneContentLoader
) : Scene {
    private val content: Array<IntArray> = sceneLoader.loadContent("introScene")
    init {
        introController.introScene = this
    }

    override fun putValue(x: Int, y: Int, value: Int) {
        content[x][y] = value
    }

    override fun getContent(): Array<IntArray> {
        return content
    }

    override fun update(context: SceneUpdateContext) {

    }

    override fun isDone(): Boolean {
        return false
    }

    override fun getSceneController(): SceneController {
        return introController
    }

    override fun getColor(x: Int, y: Int): PixelColor {
        TODO("Not yet implemented")
    }
}