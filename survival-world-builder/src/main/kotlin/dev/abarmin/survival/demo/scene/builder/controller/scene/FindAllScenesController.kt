package dev.abarmin.survival.demo.scene.builder.controller.scene

import dev.abarmin.survival.demo.data.service.SceneService
import dev.abarmin.survival.demo.scene.builder.controller.scene.model.SceneRowModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Aleksandr Barmin
 */
@RestController
class FindAllScenesController(private val sceneService: SceneService) {
    /**
     * This endpoint should return all names of registered scenes.
     */
    @GetMapping("/scenes")
    fun list(): List<SceneRowModel> {
        return sceneService.findAll().map {
            return@map SceneRowModel(
                it.id,
                it.name
            )
        }
    }
}