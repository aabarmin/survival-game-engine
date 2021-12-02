package dev.abarmin.survival.demo.scene.intro.sprite

import dev.abarmin.survival.demo.scene.PixelColor
import dev.abarmin.survival.demo.scene.PixelPosition
import dev.abarmin.survival.demo.sprite.DefaultSprite
import dev.abarmin.survival.demo.sprite.Sprite

/**
 * This is the sprite with packman.
 *
 * @author Aleksandr Barmin
 */
class JumpingPackmanSprite(
    data: Array<Array<PixelColor>>,
    position: PixelPosition
) : DefaultSprite(data, position)