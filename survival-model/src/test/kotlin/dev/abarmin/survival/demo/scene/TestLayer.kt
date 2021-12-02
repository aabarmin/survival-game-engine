package dev.abarmin.survival.demo.scene

/**
 * Layer just for testing purposes till other implementations are not ready.
 *
 * @author Aleksandr Barmin
 */
class TestLayer(private val defaultColor: PixelColor) : SceneLayer {
    /**
     * Always returns white color.
     */
    override fun getColor(x: Int, y: Int): PixelColor {
        return defaultColor
    }
}