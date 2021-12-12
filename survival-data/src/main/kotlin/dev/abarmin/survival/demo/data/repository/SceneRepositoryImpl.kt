package dev.abarmin.survival.demo.data.repository

import dev.abarmin.survival.demo.data.config.StorageConfiguration
import dev.abarmin.survival.demo.data.json.JsonReader
import dev.abarmin.survival.demo.data.json.JsonWriter
import dev.abarmin.survival.demo.data.model.SceneEntity
import dev.abarmin.survival.demo.scene.info.SceneInfo
import org.springframework.stereotype.Component
import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import java.util.stream.Collectors
import kotlin.io.path.name
import kotlin.streams.toList

/**
 * @author Aleksandr Barmin
 */
@Component
class SceneRepositoryImpl(
    val configuration: StorageConfiguration,
    val filenameSanitizer: FilenameSanitizer,
    val jsonReader: JsonReader,
    val jsonWriter: JsonWriter
) : SceneRepository {
    override fun findByName(name: String): Optional<SceneEntity> {
        val filePath = getPath(name)
        if (!Files.exists(filePath)) {
            return Optional.empty()
        }
        return Optional.of(jsonReader.read(filePath, SceneEntity::class))
    }

    override fun save(entity: SceneEntity): SceneEntity {
        val filePath = getPath(entity.name)
        Files.deleteIfExists(filePath)
        jsonWriter.write(entity, filePath)
        return entity
    }

    override fun findAll(): List<SceneEntity> {
        val scenesFolderPath = Path.of(configuration.scenesFolder)
        return Files.list(scenesFolderPath)
            .filter { path -> path.fileName.name.endsWith(".json") }
            .map { path -> jsonReader.read(path, SceneEntity::class) }
            .toList()
    }

    private fun getPath(name: String): Path {
        return Path.of(configuration.scenesFolder)
            .resolve(getFilename(name))
    }

    private fun getFilename(name: String): String {
        return filenameSanitizer.sanitize(name) + ".json"
    }
}