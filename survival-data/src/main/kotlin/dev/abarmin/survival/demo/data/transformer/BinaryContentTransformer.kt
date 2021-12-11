package dev.abarmin.survival.demo.data.transformer

import dev.abarmin.survival.demo.data.model.FileEntity
import dev.abarmin.survival.demo.scene.info.BinaryContent
import org.springframework.stereotype.Component

/**
 * @author Aleksandr Barmin
 */
@Component
class BinaryContentTransformer {
    fun toDomain(model: BinaryContent): FileEntity {
        return FileEntity(
            model.type,
            model.name
        )
    }

    fun toModel(domain: FileEntity): BinaryContent {
        return BinaryContent(
            domain.type,
            domain.name
        )
    }
}