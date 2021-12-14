package dev.abarmin.survival.demo.json

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component
import java.nio.file.Files
import java.nio.file.Path
import kotlin.reflect.KClass

/**
 * Abstraction layer to deal with JSON.
 *
 * @author Aleksandr Barmin
 */
@Component
class JsonReader(val objectMapper: ObjectMapper) {
    fun <T: Any> read(source: Path, targetType: KClass<T>): T {
        if (!Files.exists(source)) {
            throw RuntimeException("File $source does not exist")
        }
        val sourceFile = source.toFile()
        return objectMapper.readValue(sourceFile, targetType.java)
    }
}