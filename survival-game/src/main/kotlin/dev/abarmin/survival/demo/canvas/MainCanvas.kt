package dev.abarmin.survival.demo.canvas

import dev.abarmin.survival.demo.scene.PixelColor
import dev.abarmin.survival.demo.scene.base.SceneColorProvider
import dev.abarmin.survival.demo.scene.Scene
import dev.abarmin.survival.demo.viewpoint.ViewPoint
import java.awt.Canvas
import java.awt.Color
import java.awt.Graphics

/**
 * Canvas which is responsible for drawing the content of the GameScene in accordance with the
 * given ViewPoint.
 *
 * @author Aleksandr Barmin
 */
class MainCanvas(
    private val scene: Scene,
    private val viewPoint: ViewPoint,
    private val colorProvider: SceneColorProvider,
    private val colorConverter: PixelColorConverter
) : Canvas() {
    // this is the current state of the canvas - what is actually displayed
    // required not to draw everything every time
    private val currentState: Array<Array<PixelColor>> =
        Array(viewPoint.height) { _ -> Array(viewPoint.width) { _ -> PixelColor.TRANSPARENT} }

    override fun paint(g: Graphics) {
        draw(g, false)
    }

    override fun update(g: Graphics) {
        draw(g)
    }

    private fun draw(graphics: Graphics, conditionalDrawing: Boolean = true) {
        for (rowNum in 0 until viewPoint.width) {
            for (colNum in 0 until viewPoint.height) {
                val pixelColor = colorProvider.getColor(scene, viewPoint, rowNum, colNum)
                if (!conditionalDrawing) {
                    drawPixel(rowNum, colNum, pixelColor, graphics)
                } else if (shouldDraw(rowNum, colNum, pixelColor)) {
                    drawPixel(rowNum, colNum, pixelColor, graphics)
                }
            }
        }
    }

    private fun drawPixel(
        rowNumber: Int, columnNumber: Int, color: PixelColor, graphics: Graphics) {
        // save the state
        currentState[columnNumber][rowNumber] = color

        // TODO, this is the scale value, extract it somewhere
        val x = rowNumber * 8
        val y = columnNumber * 8

        // TODO: fix colors here
        graphics.color = Color.BLACK
        graphics.drawRect(x, y, 8, 8)
        graphics.color = colorConverter.convert(color)
        graphics.fillRect(x, y, 8, 8)
    }

    private fun shouldDraw(rowNumber: Int, columnNumber: Int, color: PixelColor): Boolean {
        val currentColor = currentState[columnNumber][rowNumber]
        return currentColor != color
    }
}