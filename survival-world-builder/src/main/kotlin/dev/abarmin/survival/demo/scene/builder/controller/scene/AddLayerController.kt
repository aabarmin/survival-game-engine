package dev.abarmin.survival.demo.scene.builder.controller.scene

import dev.abarmin.survival.demo.scene.builder.controller.scene.model.CreateLayerRequest
import dev.abarmin.survival.demo.scene.builder.controller.scene.model.SceneModel
import dev.abarmin.survival.demo.scene.builder.controller.scene.transformer.SceneRestTransformer
import dev.abarmin.survival.demo.service.LayerService
import dev.abarmin.survival.demo.service.SceneLayerFactory
import dev.abarmin.survival.demo.service.SceneService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * @author Aleksandr Barmin
 */
@RestController
class AddLayerController(
    private val layerFactory: SceneLayerFactory,
    private val layerService: LayerService,
    private val transformer: SceneRestTransformer,
    private val sceneService: SceneService) {

    @PostMapping("/scenes/{sceneId}/layers")
    fun addLayer(@PathVariable("sceneId") sceneId: String,
                 @RequestBody request: CreateLayerRequest): SceneModel {

        // find an existing scene
        val existingScene = sceneService.findById(sceneId).orElseThrow()

        // create a new layer
        val newLayer = layerFactory.createLayer(
            existingScene.width,
            existingScene.height,
            request.name,
            request.type
        )

        // adding one to another
        val updatedScene = layerService.addLayer(existingScene, newLayer)

        // all done
        return transformer.toModel(updatedScene)
    }
}