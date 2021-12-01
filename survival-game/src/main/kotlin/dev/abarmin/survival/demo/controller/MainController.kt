package dev.abarmin.survival.demo.controller

import dev.abarmin.survival.demo.canvas.MainCanvas
import dev.abarmin.survival.demo.scene.base.Scene
import dev.abarmin.survival.demo.viewpoint.ViewPoint
import java.awt.event.*

/**
 * This is something like a controller, obviously.
 *
 * TODO: the controller should be rewritten because it is to low-level, there should be
 * a collection of game-specific controllers which are responsible for dealing with exact
 * events like mouse clicks, key presses and so on. This is AWS-specific controller.
 *
 * @author Aleksandr Barmin
 */
class MainController(
    private val view: MainCanvas,
    private val viewPoint: ViewPoint
) : MouseListener, MouseMotionListener, KeyListener
{
    init {
        view.addMouseListener(this)
        view.addMouseMotionListener(this)
        view.addKeyListener(this)
    }

    private lateinit var controllerDelegate: SceneController

    fun setControllerDelegate(controller: SceneController) {
        this.controllerDelegate = controller
    }

    var mouseHold: Boolean = false

    private fun paint(e: MouseEvent) {
        val x = (e.x / 8) + viewPoint.x
        val y = (e.y / 8) + viewPoint.y
        controllerDelegate.mousePress(x, y)
    }

    override fun mouseClicked(e: MouseEvent) {

    }

    override fun mousePressed(e: MouseEvent?) {
        mouseHold = true
    }

    override fun mouseReleased(e: MouseEvent?) {
        mouseHold = false
    }

    override fun mouseEntered(e: MouseEvent?) {

    }

    override fun mouseExited(e: MouseEvent?) {

    }

    override fun mouseDragged(e: MouseEvent) {
        paint(e)
    }

    override fun mouseMoved(e: MouseEvent) {
        if (mouseHold) {
            paint(e)
        }
    }

    override fun keyTyped(e: KeyEvent) {

    }

    override fun keyPressed(e: KeyEvent) {
        controllerDelegate.keyPressed(e.keyChar)
    }

    override fun keyReleased(e: KeyEvent?) {

    }
}