package dev.abarmin.survival.demo.sprite

import dev.abarmin.survival.demo.scene.PixelColor
import dev.abarmin.survival.demo.scene.PixelPosition

/**
 * Basic implementation of the sprite.
 *
 * @author Aleksandr Barmin
 */
open class DefaultSprite(
    private var data: Array<Array<PixelColor>>,
    private var position: PixelPosition
) : Sprite {
    override fun getWidth(): Int {
        return data[0].size
    }

    override fun getHeight(): Int {
        return data.size
    }

    override fun getTopLeft(): PixelPosition {
        return position
    }

    override fun getColor(coordinate: PixelPosition): PixelColor {
        return data[coordinate.y][coordinate.x]
    }
}