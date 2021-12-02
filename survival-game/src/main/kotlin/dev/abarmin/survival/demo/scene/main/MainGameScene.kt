package dev.abarmin.survival.demo.scene.main

import dev.abarmin.survival.demo.controller.MainController
import dev.abarmin.survival.demo.controller.SceneController
import dev.abarmin.survival.demo.scene.PixelColor
import dev.abarmin.survival.demo.scene.Scene
import dev.abarmin.survival.demo.scene.SceneUpdateContext
import dev.abarmin.survival.demo.scene.provider.SceneProvider
import org.springframework.stereotype.Component

/**
 * @author Aleksandr Barmin
 */
@Component
class MainGameScene(
    private val sceneProvider: SceneProvider
) : Scene {
    private val sceneSequence = listOf("intro")
    private var sceneNumber = 0
    private lateinit var currentScene: Scene
    private lateinit var currentController: SceneController
    private lateinit var mainController: MainController

    /**
     * Shoule be invoked before the game starts.
     */
    fun init() {
        /**
         * Init components:
         * - get the first scene
         * - get its controller
         * - set the delegate in the main controller
         */
        currentScene = sceneProvider.getScene(sceneSequence[sceneNumber])
        currentController = currentScene.getSceneController()
        mainController.setControllerDelegate(currentController)
    }

    override fun update(context: SceneUpdateContext) {
        currentScene.update(context)
    }

    override fun isDone(): Boolean {
        /**
         * Checking if the current scene is done and if necessary, loading the following scene.
         */
        if (currentScene.isDone()) {
            sceneNumber++
            if (sceneNumber > sceneSequence.size - 1) {
                /**
                 * Starting for the beginning if nothing more to demonstrate.
                 */
                sceneNumber = 0
            }
            currentScene = sceneProvider.getScene(sceneSequence[sceneNumber])
            currentController = currentScene.getSceneController()
            mainController.setControllerDelegate(currentController)
        }
        return false
    }

    override fun getSceneController(): SceneController {
        return this.currentController
    }

    fun setMainController(controller: MainController) {
        this.mainController = controller
    }

    override fun getColor(x: Int, y: Int): PixelColor {
        return currentScene.getColor(x, y)
    }
}