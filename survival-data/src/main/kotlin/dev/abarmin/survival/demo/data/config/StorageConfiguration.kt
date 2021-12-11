package dev.abarmin.survival.demo.data.config

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
    lateinit var storageFolder: String

    @Value("\${data.storage.sprites}")
    lateinit var spritesFolder: String

    @Value("\${data.storage.scenes}")
    lateinit var scenesFolder: String

    @PostConstruct
    fun init() {
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
    }

    fun getStorage(type: String): Path {
        return when(type) {
            "scene" -> Path.of(scenesFolder)
            "sprite" -> Path.of(spritesFolder)
            else -> throw RuntimeException("Unsupported type $type")
        }
    }
}