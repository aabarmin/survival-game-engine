package dev.abarmin.survival.demo

import dev.abarmin.survival.demo.canvas.MainCanvas
import dev.abarmin.survival.demo.canvas.PixelColorConverter
import dev.abarmin.survival.demo.controller.MainController
import dev.abarmin.survival.demo.scene.SceneUpdateContext
import dev.abarmin.survival.demo.scene.base.SceneColorProvider
import dev.abarmin.survival.demo.scene.main.MainGameScene
import dev.abarmin.survival.demo.viewpoint.ViewPoint
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.swing.JFrame
import javax.swing.WindowConstants

/**
 * Starting point into the application.
 *
 * @author Aleksandr Barmin
 */
@Component
class SurvivalGame(
    private val gameScene: MainGameScene,
    private val colorProvider: SceneColorProvider,
    private val colorConverter: PixelColorConverter
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        val jFrame = JFrame("Starting point")
        jFrame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        jFrame.isResizable = false
        /**
         * Running main components:
         * - main game scene, initialized by Spring to have dependencies inside
         * - view point to know where the user is looking at
         * - game canvas to display everything
         * - main controller
         *
         * Need to bind the main scene with the main controller because it has no own controllers.
         */
        val viewPoint = ViewPoint()
        val mainCanvas = MainCanvas(
            gameScene,
            viewPoint,
            colorProvider,
            colorConverter
        )
        val controller = MainController(mainCanvas, viewPoint)
        gameScene.setMainController(controller)
        gameScene.init()
        /**
         * Starting background tasks:
         * - prepare context
         * - redraw task
         * - scene liveness task
         */
        val context = SceneUpdateContext(viewPoint)
        val backgroundTask = Runnable {
            gameScene.update(context)
            gameScene.isDone(context)
            mainCanvas.repaint()
        }
        Executors.newSingleThreadScheduledExecutor()
            .scheduleWithFixedDelay(backgroundTask, 40, 40, TimeUnit.MILLISECONDS)
        /**
         * Setting up the scale.
         */
        val scaleValue = 8
        mainCanvas.setSize(viewPoint.width * scaleValue, viewPoint.height * scaleValue)
        jFrame.add(mainCanvas)
        jFrame.pack()
        jFrame.isVisible = true
    }
}