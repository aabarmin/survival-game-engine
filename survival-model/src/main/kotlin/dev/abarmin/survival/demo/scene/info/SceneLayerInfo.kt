package dev.abarmin.survival.demo.scene.info

/**
 * Information about a layer of any scene.
 *
 * @author Aleksandr Barmin
 */
data class SceneLayerInfo(
    val id: String,
    val name: String,
    val type: SceneLayerType,
    val content: BinaryContent
)