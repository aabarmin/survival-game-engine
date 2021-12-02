package dev.abarmin.survival.demo.scene

import dev.abarmin.survival.demo.controller.SceneController

class TestLayeredScene(private val layers: List<SceneLayer>) : LayeredScene() {
    override fun getLayers(): List<SceneLayer> {
        return layers
    }

    override fun isDone(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getSceneController(): SceneController {
        TODO("Not yet implemented")
    }

}