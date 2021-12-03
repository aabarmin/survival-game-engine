package dev.abarmin.survival.demo.scene.builder.model.scene

/**
 * A model for REST which describes a scene.
 *
 * @author Aleksandr Barmin
 */
data class SceneModel(
    val name: String,
    val layers: Array<SceneLayerModel>
)