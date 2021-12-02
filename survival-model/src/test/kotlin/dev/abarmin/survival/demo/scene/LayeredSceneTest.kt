package dev.abarmin.survival.demo.scene

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * @author Aleksandr Barmin
 */
internal class LayeredSceneTest {
    lateinit var uut: LayeredScene

    @BeforeEach
    internal fun setUp() {
        uut = TestLayeredScene(listOf(
            TestLayer(PixelColor(255, 255, 255, 0)),
            TestLayer(PixelColor(128, 128, 128, 0))
        ))
    }

    @Test
    internal fun `Check if the scene is created`() {
        assertNotNull(uut)
    }

    @Test
    internal fun `Check if the color is returned`() {
        val returnedColor = uut.getColor(0, 0)
        assertNotNull(returnedColor)
    }

    @Test
    internal fun `Check if the color of the latest layer is returned`() {
        val returnedColor = uut.getColor(0, 0)
        assertNotNull(returnedColor)
        assertEquals(128, returnedColor.red)
    }
}