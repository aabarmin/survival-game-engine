package dev.abarmin.survival.demo.json

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
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
class JsonReader(private val objectMapper: ObjectMapper) {
    fun <T: Any> read(source: Path, targetType: TypeReference<T>): T {
        if (!Files.exists(source)) {
            throw RuntimeException("File $source does not exist")
        }
        val sourceFile = source.toFile()
        return objectMapper.readValue(sourceFile, targetType)
    }
}

inline fun <reified T: Any> JsonReader.read(source: Path): T {
    return read(source, jacksonTypeRef<T>())
}