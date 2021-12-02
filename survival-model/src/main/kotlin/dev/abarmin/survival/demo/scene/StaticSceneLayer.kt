package dev.abarmin.survival.demo.scene

/**
 * Scene with the static content.
 *
 * @author Aleksandr Barmin
 */
class StaticSceneLayer(
    val data: Array<Array<PixelColor>>
) : SceneLayer {

    override fun getColor(position: PixelPosition): PixelColor {
        return data[position.y][position.x]
    }
}