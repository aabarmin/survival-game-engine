package dev.abarmin.survival.demo.data.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Embedded
import org.springframework.data.relational.core.mapping.Table

/**
 * Entity for layers.
 *
 * @author Aleksandr Barmin
 */
@Table("SCENE_LAYERS")
data class SceneLayerEntity(
    @Column("LAYER_ID") @Id val id: Long,
    @Column("LAYER_TYPE") val type: String,
    @Column("SCENE_ID") val sceneId: Long,
    @Embedded(prefix = "LAYER_", onEmpty = Embedded.OnEmpty.USE_EMPTY) val file: FileEntity
)