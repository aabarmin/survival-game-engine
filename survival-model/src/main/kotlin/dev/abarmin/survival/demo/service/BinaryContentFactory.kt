package dev.abarmin.survival.demo.service

import dev.abarmin.survival.demo.scene.info.BinaryContent
import dev.abarmin.survival.demo.scene.info.ContentType
import org.springframework.stereotype.Component

/**
 * @author Aleksandr Barmin
 */
@Component
class BinaryContentFactory {
    fun generateId(type: ContentType, name: String): BinaryContent {
        return BinaryContent(type, name)
    }
}