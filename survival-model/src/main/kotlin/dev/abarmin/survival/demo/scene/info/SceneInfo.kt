package dev.abarmin.survival.demo.scene.info

/**
 * Information about a scene.
 *
 * @author Aleksandr Barmin
 */
data class SceneInfo(
    val id: String,
    val name: String,
    val layers: List<SceneLayerInfo>,
    val type: SceneType = SceneType.LAYERED
)