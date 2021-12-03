package dev.abarmin.survival.demo.scene.builder.model.sprite

import dev.abarmin.survival.demo.scene.builder.model.pixel.PixelModel

/**
 * A single sprite.
 *
 * @author Aleksandr Barmin
 */
data class SpriteModel(
    val name: String,
    val data: Array<PixelModel>
)