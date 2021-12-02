package dev.abarmin.survival.demo.sprite

import dev.abarmin.survival.demo.TestUtils
import dev.abarmin.survival.demo.scene.PixelPosition
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * @author Aleksandr Barmin
 */
internal class DefaultSpriteTest {
    lateinit var uut: Sprite

    @BeforeEach
    internal fun setUp() {
        uut = createSprite(16, 16)
    }

    @Test
    internal fun `Check if sprite is created, it's possible to get data`() {
        assertNotNull(uut)

        val color = uut.getColor(PixelPosition(0, 0))
        assertNotNull(color)
    }

    private fun createSprite(width: Int, height: Int): Sprite {
        return DefaultSprite(
            TestUtils.randomColorData(width, height),
            PixelPosition(0, 0)
        )
    }
}