package dev.abarmin.survival.demo.scene

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * @author Aleksandr Barmin
 */
internal class LayeredStaticSceneTest {
    lateinit var uut: Scene

    @BeforeEach
    internal fun setUp() {
        uut = TestLayeredScene(listOf(
            randomLayer(255, 255),
            randomLayer(255, 255)
        ))
    }

    @Test
    internal fun `Check if scene is created`() {
        assertNotNull(uut)
    }

    private fun randomLayer(width: Int, height: Int): SceneLayer {
        return createLayer(
            Array(height) { _ -> Array(width) { _ -> defaultColor()} }
        )
    }

    private fun defaultColor(): PixelColor {
        return PixelColor(255, 255, 255, 0)
    }

    private fun createLayer(data: Array<Array<PixelColor>>): SceneLayer {
        return StaticSceneLayer(data)
    }
}