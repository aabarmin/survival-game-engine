package dev.abarmin.survival.demo.scene.builder.controller

import dev.abarmin.survival.demo.data.service.SceneService
import dev.abarmin.survival.demo.scene.builder.model.scene.SceneRowModel
import dev.abarmin.survival.demo.scene.builder.service.SceneBuilderService
import org.springframework.web.bind.annotation.*

/**
 * The controller responsible for dealing with scenes. Right now it is just as simple
 * as possible - no unnecessary capabilities or functions.
 *
 * @author Aleksandr Barmin
 */
@RestController
@RequestMapping("/scenes")
class SceneController(
    val sceneBuilderService: SceneBuilderService,
    val sceneService: SceneService
) {
    /**
     * This endpoint should return all names of registered scenes.
     */
    @GetMapping("")
    fun list(): List<SceneRowModel> {
        return sceneService.findAll().map {
            return@map SceneRowModel(
                it.id,
                it.name
            )
        }
    }


    @PostMapping("")
    fun save(@RequestBody request: SaveRequest) {
        sceneBuilderService.save(request.name, request.data)
    }
}