package dev.abarmin.survival.demo.scene.builder.controller.scene

import dev.abarmin.survival.demo.data.service.SceneService
import dev.abarmin.survival.demo.data.service.factory.SceneFactory
import dev.abarmin.survival.demo.scene.builder.model.scene.SceneRowModel
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * @author Aleksandr Barmin
 */
@RestController
class SaveSceneController(
    private val sceneService: SceneService,
    private val sceneFactory: SceneFactory) {

    @PostMapping("/scenes/{id}")
    fun createScene(
        @PathVariable("id") id: String,
        @RequestBody createRequest: SceneRowModel): SceneRowModel {

        val scene = sceneService.findById(id)
            .orElseGet { sceneFactory.createScene(createRequest.id, createRequest.name) }

        val savedScene = sceneService.save(scene)
        return createRequest
    }
}