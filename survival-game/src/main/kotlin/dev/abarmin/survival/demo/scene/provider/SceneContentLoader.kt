package dev.abarmin.survival.demo.scene.provider

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import dev.abarmin.survival.demo.config.ApplicationConfiguration
import dev.abarmin.survival.demo.scene.PixelColor
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

    fun loadContent(fileName: String): Array<Array<PixelColor>> {
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
            val result: Array<Array<PixelColor>> =
                Array(128) { _ -> Array(96) { _ -> PixelColor.TRANSPARENT} }
            val whiteColor = PixelColor.TRANSPARENT
            val blackColor = PixelColor(0, 0, 0, 0)
            for (item in data) {
                if (item.cellValue == 0) {
                    result[item.cellNumber][item.rowNumber] = whiteColor
                } else {
                    result[item.cellNumber][item.rowNumber] = blackColor
                }
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