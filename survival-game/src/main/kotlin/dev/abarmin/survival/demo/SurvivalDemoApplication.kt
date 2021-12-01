package dev.abarmin.survival.demo

import dev.abarmin.survival.demo.config.ApplicationConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfiguration::class)
class SurvivalDemoApplication

fun main(args: Array<String>) {
	System.setProperty("java.awt.headless", "false")

	runApplication<SurvivalDemoApplication>(*args)
}
