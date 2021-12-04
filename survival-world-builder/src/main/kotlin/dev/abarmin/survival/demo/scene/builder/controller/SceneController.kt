package dev.abarmin.survival.demo.scene.builder.controller

import dev.abarmin.survival.demo.scene.builder.service.SceneBuilderService
import org.springframework.web.bind.annotation.*

/**
 * The controller responsible for dealing with scenes. Right now it is just as simple
 * as possible - no unnecessary capabilities or functions.
 *
 * @author Aleksandr Barmin
 */
@RestController
@RequestMapping("/scene")
class SceneController(
    val sceneService: SceneBuilderService
) {
    @GetMapping("/list")
    fun list(): Array<String> {
        TODO("Not implemented yet")
    }


    @PostMapping("")
    fun save(@RequestBody request: SaveRequest) {
        sceneService.save(request.name, request.data)
    }
}