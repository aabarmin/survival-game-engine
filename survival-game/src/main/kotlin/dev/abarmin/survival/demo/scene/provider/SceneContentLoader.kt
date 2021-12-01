package dev.abarmin.survival.demo.scene.provider

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import dev.abarmin.survival.demo.config.ApplicationConfiguration
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.nio.file.Files
import java.nio.file.Path

/**
 * This is a temporary class to load scenes from files. Currently, this works
 * as simple as possible - will make it more complicated later on.
 *
 * @author Aleksandr Barmin
 */
@Service
class SceneContentLoader(
    val config: ApplicationConfiguration,
    val mapper: ObjectMapper
) {
    companion object {
        val logger = LoggerFactory.getLogger(SceneContentLoader::class.java)
    }

    fun loadContent(fileName: String): Array<IntArray> {
        logger.info("Loading scene from file {}", fileName)

        val filepath = Path.of(config.sceneStorage).resolve("$fileName.json")
        val inputStream = Files.newInputStream(filepath)
        inputStream.use {
            val data = mapper.readValue(inputStream, object : TypeReference<Array<SceneCellValue>>() {})
            /**
             * Let's assume, right now I know the size of the scene and so on,
             * will rewrite it later on.
             *
             * TODO: fix the deserialization.
             */
            val result = Array(128) { _ -> IntArray(96) }
            for (item in data) {
                result[item.cellNumber][item.rowNumber] = item.cellValue
            }
            return result
        }
    }
}

data class SceneCellValue(
    val rowNumber: Int,
    val cellNumber: Int,
    val cellValue: Int
)