package dev.abarmin.survival.demo.repository

import dev.abarmin.survival.demo.config.StorageConfiguration
import dev.abarmin.survival.demo.json.JsonReader
import dev.abarmin.survival.demo.json.JsonWriter
import dev.abarmin.survival.demo.json.read
import dev.abarmin.survival.demo.scene.PixelColor
import dev.abarmin.survival.demo.scene.info.BinaryContent
import org.springframework.stereotype.Component
import java.nio.file.Files
import java.nio.file.Path
import java.util.*

/**
 * @author Aleksandr Barmin
 */
@Component
class BinaryContentJsonRepository(
    private val jsonWriter: JsonWriter,
    private val jsonReader: JsonReader,
    private val configuration: StorageConfiguration) : BinaryContentRepository {

    override fun write(content: BinaryContent, data: Array<Array<PixelColor>>) {
        val targetFilePath = getPath(content)
        Files.deleteIfExists(targetFilePath)
        jsonWriter.write(data, targetFilePath)
    }

    override fun read(content: BinaryContent): Optional<Array<Array<PixelColor>>> {
        val targetFilePath = getPath(content)
        if (!Files.exists(targetFilePath)) {
            return Optional.empty()
        }
        val readContent = jsonReader.read<Array<Array<PixelColor>>>(targetFilePath)
        val processedContent = readContent.map { row -> processRow(row) }.toTypedArray()
        return Optional.of(processedContent)
    }

    override fun exists(content: BinaryContent): Boolean {
        return Files.exists(getPath(content))
    }

    private fun getPath(content: BinaryContent): Path {
        return configuration.getStorage(content.type)
            .resolve(content.name)
    }

    private fun processRow(row: Array<PixelColor>): Array<PixelColor> {
        return row.map { color ->
            if (color.isTransparent()) {
                return@map PixelColor.TRANSPARENT
            }
            return@map color
        }.toTypedArray()
    }
}