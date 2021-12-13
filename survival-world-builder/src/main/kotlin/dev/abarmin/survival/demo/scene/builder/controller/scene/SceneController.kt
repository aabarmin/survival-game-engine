package dev.abarmin.survival.demo.scene.builder.controller.scene

import dev.abarmin.survival.demo.data.service.SceneService
import dev.abarmin.survival.demo.scene.builder.controller.SaveRequest
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
@Deprecated("Nothing to do here, just remove")
class SceneController(
    val sceneBuilderService: SceneBuilderService
) {

    @PostMapping("")
    fun save(@RequestBody request: SaveRequest) {
        sceneBuilderService.save(request.name, request.data)
    }
}