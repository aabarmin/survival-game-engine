package dev.abarmin.survival.demo.scene.builder.service

import com.fasterxml.jackson.databind.ObjectMapper
import dev.abarmin.survival.demo.scene.builder.controller.SceneCellValue
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.nio.file.Files
import java.nio.file.Path
import javax.annotation.PostConstruct

/**
 * Very simplistic service to deal with scenes.
 *
 * @author Aleksandr Barmin
 */
@Service
@Deprecated("Use SceneService from the data module")
class SceneBuilderService(
    val mapper: ObjectMapper
) {
    @Value("\${base.folder}")
    lateinit var baseFolder: String

    @PostConstruct
    fun init() {
        val baseContainer = Path.of(this.baseFolder)
        if (!Files.exists(baseContainer)) {
            Files.createDirectories(baseContainer)
        }
    }

    fun save(name: String, data: Array<SceneCellValue>) {
        val fileStorage = Path.of(this.baseFolder).resolve(name + ".json")
        Files.deleteIfExists(fileStorage)
        Files.createFile(fileStorage)

        val outputStream = Files.newOutputStream(fileStorage)
        outputStream.use {
            mapper.writeValue(outputStream, data)
        }
    }
}