package dev.abarmin.survival.demo.scene.intro

import dev.abarmin.survival.demo.controller.SceneController
import org.springframework.stereotype.Component

/**
 * @author Aleksandr Barmin
 */
@Component
class IntroSceneController : SceneController {
    lateinit var introScene: IntroScene

    override fun mousePress(x: Int, y: Int) {
        introScene.putValue(x, y, 1)
    }

    override fun keyPressed(key: Char) {

    }
}