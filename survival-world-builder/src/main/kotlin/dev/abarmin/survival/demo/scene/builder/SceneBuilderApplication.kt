package dev.abarmin.survival.demo.scene.builder

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Main class of the app which is used for building scenes.
 *
 * @author Aleksandr Barmin
 */
@SpringBootApplication
class SceneBuilderApplication

fun main(args: Array<String>) {
    runApplication<SceneBuilderApplication>(*args)
}