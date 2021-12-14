package dev.abarmin.survival.demo.scene.builder.model.pixel

import dev.abarmin.survival.demo.scene.builder.controller.content.model.PixelColorModel

/**
 * @author Aleksandr Barmin
 */
data class PixelModel(
    val x: Int,
    val y: Int,
    val color: PixelColorModel
)