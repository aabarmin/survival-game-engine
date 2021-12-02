package dev.abarmin.survival.demo.scene

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

/**
 * @author Aleksandr Barmin
 */
internal class PixelPositionTest {
    @Test
    internal fun `Given minus current`() {
        val first = PixelPosition(70, 70)
        val second = PixelPosition(75, 80)

        val extractionResult = second.minuxGiven(first)

        assertNotNull(extractionResult)
        assertEquals(5, extractionResult.x)
        assertEquals(10, extractionResult.y)
    }

    @Test
    internal fun `Given plus current`() {
        val first = PixelPosition(10, 10)
        val second = PixelPosition(20, 20)

        val result = second.plusGiven(first)

        assertNotNull(result)
        assertEquals(30, result.x)
        assertEquals(30, result.y)
    }
}