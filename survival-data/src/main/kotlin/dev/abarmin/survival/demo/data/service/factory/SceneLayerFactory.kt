package dev.abarmin.survival.demo.data.service.factory

import dev.abarmin.survival.demo.data.config.DefaultsConfiguration
import dev.abarmin.survival.demo.data.service.BinaryContentService
import dev.abarmin.survival.demo.scene.info.ContentType
import dev.abarmin.survival.demo.scene.info.SceneLayerInfo
import org.springframework.stereotype.Component

/**
 * This component creates scene layers.
 *
 * @author Aleksandr Barmin
 */
@Component
class SceneLayerFactory(
    private val defaults: DefaultsConfiguration,
    private val contentIdFactory: BinaryContentFactory,
    private val contentService: BinaryContentService,
    private val dummyContentFactory: DummyBinaryContentFactory,
    private val layerIdFactory: SceneLayerIdFactory
) {

    fun createLayer(): SceneLayerInfo {
        // generating dummy content id
        val layerId = layerIdFactory.generate()
        val contentId = contentIdFactory.generateId(ContentType.LAYER, layerId)

        // generating dummy content
        val dummyContent = dummyContentFactory.generate()
        contentService.write(contentId, dummyContent)

        // generating instance
        return SceneLayerInfo(
            layerId,
            defaults.layer.name,
            defaults.layer.type,
            contentId
        )
    }
}