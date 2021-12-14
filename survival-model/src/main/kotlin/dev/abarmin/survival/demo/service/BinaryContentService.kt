package dev.abarmin.survival.demo.service

import dev.abarmin.survival.demo.repository.BinaryContentRepository
import dev.abarmin.survival.demo.scene.PixelColor
import dev.abarmin.survival.demo.scene.info.BinaryContent
import org.springframework.stereotype.Service

/**
 * Service to deal with saved data.
 *
 * @author Aleksandr Barmin
 */
@Service
class BinaryContentService(
    private val repository: BinaryContentRepository
) {
    fun write(content: BinaryContent, data: Array<Array<PixelColor>>) {
        repository.write(content, data)
    }

    fun exists(content: BinaryContent): Boolean {
        return repository.exists(content)
    }
}