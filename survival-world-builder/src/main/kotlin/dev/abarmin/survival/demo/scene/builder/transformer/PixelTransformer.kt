package dev.abarmin.survival.demo.scene.builder.transformer

import dev.abarmin.survival.demo.scene.ScenePixel
import dev.abarmin.survival.demo.scene.builder.model.pixel.PixelModel
import org.springframework.stereotype.Component

/**
 * @author Aleksandr Barmin
 */
@Component
class PixelTransformer(val colorTransformer: PixelColorTransformer) {
    fun toModel(pixel: ScenePixel): PixelModel {
        return PixelModel(
            pixel.x,
            pixel.y,
            colorTransformer.toModel(pixel.color)
        )
    }
}