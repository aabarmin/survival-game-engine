package dev.abarmin.survival.demo.scene.intro.sprite

import dev.abarmin.survival.demo.scene.PixelColor
import dev.abarmin.survival.demo.scene.PixelPosition
import dev.abarmin.survival.demo.scene.SceneUpdateContext
import dev.abarmin.survival.demo.sprite.DefaultSprite
import dev.abarmin.survival.demo.sprite.Sprite
import java.lang.Math.abs

/**
 * This is the sprite with packman.
 *
 * @author Aleksandr Barmin
 */
class JumpingPackmanSprite(
    data: Array<Array<PixelColor>>,
    var position: PixelPosition
) : DefaultSprite(data, position) {
    private var moveTop: Boolean = false
    private val original: PixelPosition = position

    override fun update(context: SceneUpdateContext) {
        if (abs(original.minuxGiven(position).y) > 20) {
            moveTop = !moveTop
        } else if (abs(original.minuxGiven(position).y) == 0) {
            moveTop = !moveTop
        }
        val direction = if (moveTop) -1 else 1
        this.position = position.plusGiven(PixelPosition(1, direction))
    }

    override fun getTopLeft(): PixelPosition {
        return this.position
    }
}