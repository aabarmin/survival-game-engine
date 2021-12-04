package dev.abarmin.survival.demo.scene.builder.transformer

import dev.abarmin.survival.demo.scene.PixelColor
import dev.abarmin.survival.demo.scene.ScenePixel
import dev.abarmin.survival.demo.scene.builder.model.pixel.PixelModel
import org.springframework.stereotype.Component

/**
 * @author Aleksandr Barmin
 */
@Component
class PixelDataTransformer(val pixelTransformer: PixelTransformer) {
    fun toModel(data: Array<Array<PixelColor>>): Array<PixelModel> {
        return data.flatMapIndexed { rowNumber, row ->
            row.mapIndexed { colNumber, color ->
                pixelTransformer.toModel(ScenePixel(colNumber, rowNumber, color))
            }
        }.toTypedArray()
    }
}