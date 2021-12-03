package dev.abarmin.survival.demo.scene.builder.controller

import dev.abarmin.survival.demo.scene.builder.service.SceneBuilderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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



    @PostMapping("")
    fun save(@RequestBody request: SaveRequest) {
        sceneService.save(request.name, request.data)
    }
}