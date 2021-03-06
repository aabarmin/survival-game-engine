package dev.abarmin.survival.demo.json

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component
import java.nio.file.Files
import java.nio.file.Path

/**
 * Abstraction level to write Json.
 *
 * @author Aleksandr Barmin
 */
@Component
class JsonWriter(val objectMapper: ObjectMapper) {
    fun write(content: Any, target: Path) {
        if (!Files.exists(target)) {
            Files.createFile(target)
        }
        val targetFile = target.toFile()
        objectMapper.writerWithDefaultPrettyPrinter()
            .writeValue(targetFile, content)
    }
}