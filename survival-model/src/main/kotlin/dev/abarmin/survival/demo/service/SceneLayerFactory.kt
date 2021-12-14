package dev.abarmin.survival.demo.service

import dev.abarmin.survival.demo.config.DefaultsConfiguration
import dev.abarmin.survival.demo.scene.info.ContentType
import dev.abarmin.survival.demo.scene.info.SceneLayerInfo
import dev.abarmin.survival.demo.scene.info.SceneLayerType
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

    fun createLayer(width: Int, height: Int, name: String, type: SceneLayerType): SceneLayerInfo {
        // generating dummy content id
        val layerId = layerIdFactory.generate()
        val contentId = contentIdFactory.generateId(ContentType.LAYER, layerId)

        // generating dummy content
        val dummyContent = dummyContentFactory.generate(width, height)
        contentService.write(contentId, dummyContent)

        // generating instance
        return SceneLayerInfo(
            layerId,
            name,
            type,
            contentId
        )
    }

    fun createLayer(width: Int, height: Int): SceneLayerInfo {
        return createLayer(width, height, defaults.layer.name, defaults.layer.type)
    }
}