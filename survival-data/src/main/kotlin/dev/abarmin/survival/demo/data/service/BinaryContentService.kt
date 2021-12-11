package dev.abarmin.survival.demo.data.service

import dev.abarmin.survival.demo.data.config.StorageConfiguration
import dev.abarmin.survival.demo.data.repository.FilenameSanitizer
import dev.abarmin.survival.demo.scene.info.BinaryContent
import org.springframework.stereotype.Service
import java.io.InputStream
import java.io.OutputStream
import java.lang.RuntimeException
import java.nio.file.Files
import java.nio.file.Path

/**
 * Service to deal with saved data.
 *
 * @author Aleksandr Barmin
 */
@Service
class BinaryContentService(
    val configuration: StorageConfiguration,
    val filenameSanitizer: FilenameSanitizer
) {
    fun read(content: BinaryContent): InputStream {
        val targetPath = getPath(content)
        if (!Files.exists(targetPath)) {
            throw RuntimeException("No file with name $targetPath exist")
        }
        return Files.newInputStream(targetPath)
    }

    fun write(content: BinaryContent): OutputStream {
        val targetPath = getPath(content)
        Files.deleteIfExists(targetPath)
        Files.createFile(targetPath)
        return Files.newOutputStream(targetPath)
    }

    fun delete(content: BinaryContent) {
        val targetPath = getPath(content)
        Files.deleteIfExists(targetPath)
    }

    private fun getPath(content: BinaryContent): Path {
        val sanitizedName = filenameSanitizer.sanitize(content.name)
        return configuration.getStorage(content.type)
            .resolve("$sanitizedName.json")
    }
}