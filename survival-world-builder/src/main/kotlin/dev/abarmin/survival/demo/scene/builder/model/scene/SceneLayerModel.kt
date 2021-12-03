package dev.abarmin.survival.demo.scene.builder.model.scene

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import dev.abarmin.survival.demo.scene.builder.model.scene.StaticSceneLayerModel

/**
 * REST layer model.
 *
 * @author Aleksandr Barmin
 */
@JsonTypeInfo(
    property = "type",
    include = JsonTypeInfo.As.PROPERTY,
    use = JsonTypeInfo.Id.NAME
)
@JsonSubTypes(
    JsonSubTypes.Type(value = StaticSceneLayerModel::class, name = "static"),
    JsonSubTypes.Type(value = DynamicSceneLayerModel::class, name = "dynamic")
)
abstract class SceneLayerModel(
    type: String
)