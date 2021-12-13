package dev.abarmin.survival.demo.scene.builder.controller.scene

import dev.abarmin.survival.demo.scene.builder.controller.scene.model.SceneRowModel
import dev.abarmin.survival.demo.service.SceneFactory
import dev.abarmin.survival.demo.service.SceneService
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
    private val sceneFactory: SceneFactory
) {

    @PostMapping("/scenes/{id}")
    fun createScene(
        @PathVariable("id") id: String,
        @RequestBody createRequest: SceneRowModel
    ): SceneRowModel {

        sceneService.findById(id)
            .orElseGet { sceneFactory.createScene(createRequest.id, createRequest.name) }

        return createRequest
    }
}