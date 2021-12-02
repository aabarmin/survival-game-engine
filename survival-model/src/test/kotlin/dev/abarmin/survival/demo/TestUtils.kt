package dev.abarmin.survival.demo

import dev.abarmin.survival.demo.scene.PixelColor
import dev.abarmin.survival.demo.scene.PixelPosition
import dev.abarmin.survival.demo.sprite.DefaultSprite
import dev.abarmin.survival.demo.sprite.Sprite
import java.util.*

/**
 * Methods useful for testing.
 *
 * @author Aleksandr Barmin
 */
object TestUtils {
    private val random = Random()

    fun randomSprite(width: Int, height: Int, topLeft: PixelPosition): Sprite {
        return DefaultSprite(randomColorData(width, height), topLeft)
    }

    fun randomColor(): PixelColor {
        return PixelColor(
            randomInt(255),
            randomInt(255),
            randomInt(255),
            randomInt(100)
        )
    }

    fun randomColorData(width: Int, height: Int): Array<Array<PixelColor>> {
        return Array(height) { _ -> Array(width) { _ -> randomColor()} }
    }

    fun randomInt(boundary: Int): Int {
        return random.nextInt(boundary)
    }
}