package dev.abarmin.survival.demo.scene.base

import dev.abarmin.survival.demo.scene.PixelColor
import dev.abarmin.survival.demo.scene.PixelPosition
import dev.abarmin.survival.demo.scene.Scene
import dev.abarmin.survival.demo.viewpoint.ViewPoint
import org.springframework.stereotype.Component

/**
 * This component provides a color for the particular pixel inside the scene based on
 * a given view point.
 *
 * Technically, the scene can have many layers but currently it is not supported.
 *
 * TODO, this class is named incorrectly, it generates content based on the view point.
 *
 * @author Aleksandr Barmin
 */
@Component
class SceneColorProvider {
    fun getColor(scene: Scene, viewPoint: ViewPoint, request: PixelPosition): PixelColor {
        val target = request.plusGiven(viewPoint.position)
        return scene.getColor(target)
    }
}