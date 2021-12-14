package dev.abarmin.survival.demo.service

import dev.abarmin.survival.demo.scene.info.BinaryContent
import dev.abarmin.survival.demo.scene.info.ContentType
import org.springframework.stereotype.Component

/**
 * A separate factory to generate scene layer ids. Technically, it generates sequential id to
 * make sure they are unique.
 *
 * @author Aleksandr Barmin
 */
@Component
class SceneLayerIdFactory(private val service: BinaryContentService) {
    fun generate(): String {
        var index = 0
        while (fileExists(generateFilename(index))) {
            index++
        }
        return generateFilename(index)
    }

    private fun fileExists(filename: String): Boolean {
        return service.exists(BinaryContent(
            ContentType.LAYER,
            filename
        ))
    }

    private fun generateFilename(index: Int): String {
        return "data_$index.json"
    }
}