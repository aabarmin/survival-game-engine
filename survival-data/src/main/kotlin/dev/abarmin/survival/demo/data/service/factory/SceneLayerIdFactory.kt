package dev.abarmin.survival.demo.data.service.factory

import dev.abarmin.survival.demo.data.config.StorageConfiguration
import dev.abarmin.survival.demo.scene.info.ContentType
import org.springframework.stereotype.Component
import java.nio.file.Files

/**
 * A separate factory to generate scene layer ids. Technically, it generates sequential id to
 * make sure they are unique.
 *
 * @author Aleksandr Barmin
 */
@Component
class SceneLayerIdFactory(private val configuration: StorageConfiguration) {
    fun generate(): String {
        var index = 0
        while (fileExists(generateFilename(index))) {
            index++
        }
        return generateFilename(index)
    }

    private fun fileExists(filename: String): Boolean {
        val dataFolder = configuration.getStorage(ContentType.LAYER)
        val targetFile = dataFolder.resolve(filename)
        return Files.exists(targetFile)
    }

    private fun generateFilename(index: Int): String {
        return "data_$index.json"
    }
}