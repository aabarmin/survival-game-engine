package dev.abarmin.survival.demo.repository

import dev.abarmin.survival.demo.config.StorageConfiguration
import dev.abarmin.survival.demo.json.JsonReader
import dev.abarmin.survival.demo.json.JsonWriter
import dev.abarmin.survival.demo.entity.SceneEntity
import dev.abarmin.survival.demo.json.read
import dev.abarmin.survival.demo.transformer.SceneTransformer
import dev.abarmin.survival.demo.scene.info.ContentType
import dev.abarmin.survival.demo.scene.info.SceneInfo
import org.springframework.stereotype.Component
import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import kotlin.io.path.name
import kotlin.streams.toList

/**
 * @author Aleksandr Barmin
 */
@Component
class SceneJsonRepository(
    private val configuration: StorageConfiguration,
    private val jsonReader: JsonReader,
    private val transformer: SceneTransformer,
    private val jsonWriter: JsonWriter) : SceneRepository {

    override fun findById(id: String): Optional<SceneInfo> {
        val filePath = getPath(id)
        if (!Files.exists(filePath)) {
            return Optional.empty()
        }
        return Optional.of(jsonReader.read<SceneEntity>(filePath))
            .map { transformer.toModel(it) }
    }

    override fun save(info: SceneInfo): SceneInfo {
        val filePath = getPath(info.id)
        Files.deleteIfExists(filePath)

        val entity = transformer.toDomain(info)
        jsonWriter.write(entity, filePath)

        return transformer.toModel(entity)
    }

    override fun findAll(): List<SceneInfo> {
        val scenesFolderPath = configuration.getStorage(ContentType.SCENE)
        return Files.list(scenesFolderPath)
            .filter { path -> path.fileName.name.endsWith(".json") }
            .map { path -> jsonReader.read<SceneEntity>(path) }
            .map { entity -> transformer.toModel(entity) }
            .toList()
    }

    private fun getPath(id: String): Path {
        return configuration.getStorage(ContentType.SCENE)
            .resolve("$id.json")
    }
}