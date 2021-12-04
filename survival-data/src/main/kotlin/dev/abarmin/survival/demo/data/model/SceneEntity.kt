package dev.abarmin.survival.demo.data.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

/**
 * Top-level entity for scenes.
 *
 * @author Aleksandr Barmin
 */
@Table("SCENES")
data class SceneEntity(
    @Column("SCENE_ID") @Id val id: Long,
    @Column("SCENE_NAME") val name: String,
    @Column("SCENE_TYPE") val type: String
)