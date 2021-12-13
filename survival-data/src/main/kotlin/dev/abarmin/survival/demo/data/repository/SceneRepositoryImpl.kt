package dev.abarmin.survival.demo.data.repository

import dev.abarmin.survival.demo.data.config.StorageConfiguration
import dev.abarmin.survival.demo.data.json.JsonReader
import dev.abarmin.survival.demo.data.json.JsonWriter
import dev.abarmin.survival.demo.data.model.SceneEntity
import dev.abarmin.survival.demo.scene.info.ContentType
import org.springframework.stereotype.Component
import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import kotlin.io.path.name

/**
 * @author Aleksandr Barmin
 */
@Component
class SceneRepositoryImpl(
    private val configuration: StorageConfiguration,
    private val filenameSanitizer: FilenameSanitizer,
    private val jsonReader: JsonReader,
    private val jsonWriter: JsonWriter) : SceneRepository {

    override fun findById(id: String): Optional<SceneEntity> {
        val filePath = getPath(id)
        if (!Files.exists(filePath)) {
            return Optional.empty()
        }
        return Optional.of(jsonReader.read(filePath, SceneEntity::class))
    }

    override fun save(entity: SceneEntity): SceneEntity {
        val filePath = getPath(entity.id)
        Files.deleteIfExists(filePath)
        jsonWriter.write(entity, filePath)
        return entity
    }

    override fun findAll(): List<SceneEntity> {
        val scenesFolderPath = configuration.getStorage(ContentType.SCENE)
        return Files.list(scenesFolderPath)
            .filter { path -> path.fileName.name.endsWith(".json") }
            .map { path -> jsonReader.read(path, SceneEntity::class) }
            .toList()
    }

    private fun getPath(id: String): Path {
        return configuration.getStorage(ContentType.SCENE)
            .resolve("$id.json")
    }
}