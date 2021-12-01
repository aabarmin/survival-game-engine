package dev.abarmin.survival.demo.scene.builder.controller

/**
 * @author Aleksandr Barmin
 */
data class SaveRequest(
    val name: String,
    val data: Array<SceneCellValue>
) {
}