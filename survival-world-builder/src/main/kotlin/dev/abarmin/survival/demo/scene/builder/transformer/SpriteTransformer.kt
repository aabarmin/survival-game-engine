package dev.abarmin.survival.demo.scene.builder.transformer

import dev.abarmin.survival.demo.scene.builder.model.sprite.SpriteModel
import dev.abarmin.survival.demo.sprite.DefaultSprite
import dev.abarmin.survival.demo.sprite.Sprite
import org.springframework.stereotype.Component

/**
 * @author Aleksandr Barmin
 */
@Component
class SpriteTransformer(val dataTransformer: PixelDataTransformer) {
    fun toModel(sprite: Sprite): SpriteModel {
        return when(sprite) {
            is DefaultSprite -> toModel(sprite)
        }
    }

    private fun toModel(sprite: DefaultSprite): SpriteModel {
        return SpriteModel(
            "unknown",
            dataTransformer.toModel(sprite.data)
        )
    }
}