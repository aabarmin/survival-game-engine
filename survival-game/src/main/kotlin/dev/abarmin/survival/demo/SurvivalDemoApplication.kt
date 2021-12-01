package dev.abarmin.survival.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SurvivalDemoApplication

fun main(args: Array<String>) {
	System.setProperty("java.awt.headless", "false")

	runApplication<SurvivalDemoApplication>(*args)
}
