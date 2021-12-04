package dev.abarmin.survival.demo.data.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.MappedCollection
import org.springframework.data.relational.core.mapping.Table

/**
 * Top-level entity for scenes.
 *
 * @author Aleksandr Barmin
 */
@Table("SCENES")
data class SceneEntity(
    @Column("SCENE_ID") @Id var id: Long? = null,
    @Column("SCENE_NAME") var name: String,
    @Column("SCENE_TYPE") var type: String,
    @MappedCollection(idColumn = "LAYER_ID", keyColumn = "SCENE_ID") val layers: Set<SceneLayerEntity>
)