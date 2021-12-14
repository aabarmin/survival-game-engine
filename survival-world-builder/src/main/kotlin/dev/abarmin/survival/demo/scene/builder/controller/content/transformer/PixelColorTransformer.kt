package dev.abarmin.survival.demo.scene.builder.controller.content.transformer

import dev.abarmin.survival.demo.scene.PixelColor
import dev.abarmin.survival.demo.scene.builder.controller.content.model.PixelColorModel
import org.springframework.stereotype.Component

/**
 * @author Aleksandr Barmin
 */
@Component
class PixelColorTransformer {
    fun toModel(color: PixelColor): PixelColorModel {
        return PixelColorModel(
            color.red,
            color.green,
            color.blue,
            color.transparency
        )
    }
}