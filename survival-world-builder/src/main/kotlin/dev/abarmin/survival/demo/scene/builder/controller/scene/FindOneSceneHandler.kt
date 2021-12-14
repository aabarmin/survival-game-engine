package dev.abarmin.survival.demo.scene.builder.controller.scene

import dev.abarmin.survival.demo.service.SceneService
import dev.abarmin.survival.demo.scene.builder.controller.scene.model.SceneModel
import dev.abarmin.survival.demo.scene.builder.controller.scene.transformer.SceneRestTransformer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * @author Aleksandr Barmin
 */
@RestController
class FindOneSceneHandler(
    private val transformer: SceneRestTransformer,
    private val sceneService: SceneService) {

    @GetMapping("/scenes/{id}")
    fun findScene(@PathVariable("id") id: String): SceneModel {
        return sceneService.findById(id)
            .map { transformer.toModel(it) }
            .orElseThrow()
    }
}