package dev.abarmin.survival.demo.scene.builder.controller.content.transformer

import dev.abarmin.survival.demo.scene.PixelColor
import dev.abarmin.survival.demo.scene.builder.controller.content.model.PixelColorModel
import org.springframework.stereotype.Component

/**
 * @author Aleksandr Barmin
 */
@Component
class PixelDataTransformer(private val colorTransformer: PixelColorTransformer) {
    fun toModel(data: Array<Array<PixelColor>>): Array<Array<PixelColorModel>> {
        return data.map { row -> convertRow(row) }.toTypedArray()
    }

    fun toDomain(data: Array<Array<PixelColorModel>>): Array<Array<PixelColor>> {
        return data.map { row -> convertRow(row) }.toTypedArray()
    }

    private fun convertRow(row: Array<PixelColor>): Array<PixelColorModel> {
        return row.map { cell -> colorTransformer.toModel(cell) }.toTypedArray()
    }

    private fun convertRow(row: Array<PixelColorModel>): Array<PixelColor> {
        return row.map { cell -> colorTransformer.toDomain(cell) }.toTypedArray()
    }
}