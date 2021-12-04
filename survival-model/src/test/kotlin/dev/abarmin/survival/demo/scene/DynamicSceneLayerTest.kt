package dev.abarmin.survival.demo.scene

import dev.abarmin.survival.demo.TestUtils
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * @author Aleksandr Barmin
 */
internal class DynamicSceneLayerTest {
    lateinit var uut: SceneLayer

    @BeforeEach
    internal fun setUp() {
        uut = DynamicSceneLayer(arrayOf(
            TestUtils.randomSprite(20, 20, PixelPosition(0, 0)),
            TestUtils.randomSprite(20, 20, PixelPosition(20, 20))
        ))
    }

    @Test
    internal fun `Try to get color out of the scene`() {
        val color = uut.getColor(PixelPosition(1000, 1000))

        assertNotNull(color)
        assertEquals(100, color.transparency)
    }

    @Test
    internal fun `Getting color of scene`() {
        // belongs to the first sprite
        assertFalse(isTransparent(uut.getColor(PixelPosition(0, 0))))
        assertFalse(isTransparent(uut.getColor(PixelPosition(0, 19))))
        assertFalse(isTransparent(uut.getColor(PixelPosition(19, 0))))
        assertFalse(isTransparent(uut.getColor(PixelPosition(19, 19))))
        // belongs to the second sprite
        assertFalse(isTransparent(uut.getColor(PixelPosition(20, 20))))
        assertFalse(isTransparent(uut.getColor(PixelPosition(20, 39))))
        assertFalse(isTransparent(uut.getColor(PixelPosition(39, 20))))
        assertFalse(isTransparent(uut.getColor(PixelPosition(39, 39))))
        // outside
        assertTrue(isTransparent(uut.getColor(PixelPosition(0, 20))))
        assertTrue(isTransparent(uut.getColor(PixelPosition(20, 0))))
    }

    private fun isTransparent(color: PixelColor): Boolean {
        return color == PixelColor.TRANSPARENT
    }
}