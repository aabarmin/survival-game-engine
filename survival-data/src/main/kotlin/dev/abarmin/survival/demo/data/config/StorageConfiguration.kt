package dev.abarmin.survival.demo.data.config

import dev.abarmin.survival.demo.scene.info.ContentType
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import java.lang.RuntimeException
import java.nio.file.Files
import java.nio.file.Path
import javax.annotation.PostConstruct

/**
 * Creates necessary folders for the storage.
 *
 * @author Aleksandr Barmin
 */
@Configuration
@PropertySource("classpath:./storage-configuration.properties")
class StorageConfiguration {
    @Value("\${data.storage}")
    private lateinit var storageFolder: String

    @Value("\${data.storage.sprites}")
    private lateinit var spritesFolder: String

    @Value("\${data.storage.scenes}")
    private lateinit var scenesFolder: String

    @Value("\${data.storage.layers}")
    private lateinit var layersFolder: String

    @PostConstruct
    private fun init() {
        val storage = Path.of(storageFolder)
        if (!Files.exists(storage)) {
            Files.createDirectories(storage)
        }
        val sprites = Path.of(spritesFolder)
        if (!Files.exists(sprites)) {
            Files.createDirectories(sprites)
        }
        val scenes = Path.of(scenesFolder)
        if (!Files.exists(scenes)) {
            Files.createDirectories(scenes)
        }
        val layers = Path.of(layersFolder)
        if (!Files.exists(layers)) {
            Files.createDirectories(layers)
        }
    }

    fun getStorage(type: ContentType): Path {
        return when(type) {
            ContentType.SCENE -> Path.of(scenesFolder)
            ContentType.LAYER -> Path.of(layersFolder)
            else -> throw RuntimeException("Unsupported type $type")
        }
    }
}