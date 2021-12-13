package dev.abarmin.survival.demo.scene.builder.controller

/**
 * @author Aleksandr Barmin
 */
@Deprecated("For removal")
data class SaveRequest(
    val name: String,
    val data: Array<SceneCellValue>
) {
}