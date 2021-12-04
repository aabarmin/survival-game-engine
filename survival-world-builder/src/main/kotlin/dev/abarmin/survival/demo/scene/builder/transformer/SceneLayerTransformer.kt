package dev.abarmin.survival.demo.scene.builder.transformer

import dev.abarmin.survival.demo.scene.*
import dev.abarmin.survival.demo.scene.builder.model.scene.DynamicSceneLayerModel
import dev.abarmin.survival.demo.scene.builder.model.scene.SceneLayerModel
import dev.abarmin.survival.demo.scene.builder.model.scene.StaticSceneLayerModel
import dev.abarmin.survival.demo.scene.builder.model.sprite.SpriteModel
import dev.abarmin.survival.demo.sprite.Sprite
import org.springframework.stereotype.Component

/**
 * @author Aleksandr Barmin
 */
@Component
class SceneLayerTransformer(
    val dataTransformer: PixelDataTransformer,
    val spriteTransformer: SpriteTransformer
) {
    fun toModel(layer: SceneLayer): SceneLayerModel {
        return when(layer) {
            is StaticSceneLayer -> toModel(layer)
            is DynamicSceneLayer -> toModel(layer)
            else -> throw IllegalArgumentException()
        }
    }

    private fun toModel(layer: StaticSceneLayer): StaticSceneLayerModel {
        return StaticSceneLayerModel(data = dataTransformer.toModel(layer.data))
    }

    private fun toModel(layer: DynamicSceneLayer): DynamicSceneLayerModel {
        return DynamicSceneLayerModel(data = toModel(layer.sprites))
    }

    private fun toModel(sprites: Array<Sprite>): Array<SpriteModel> {
        return sprites.map { spriteTransformer.toModel(it) }.toTypedArray()
    }
}