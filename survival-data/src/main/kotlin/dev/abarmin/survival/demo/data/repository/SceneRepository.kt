package dev.abarmin.survival.demo.data.repository

import dev.abarmin.survival.demo.data.model.SceneEntity
import dev.abarmin.survival.demo.scene.info.SceneInfo
import java.util.*

/**
 * Repository for dealing with scenes.
 *
 * @author Aleksandr Barmin
 */
interface SceneRepository {
    /**
     * Find a scene by its name.
     */
    fun findById(id: String): Optional<SceneEntity>

    /**
     * Save an entity.
     */
    fun save(entity: SceneEntity): SceneEntity

    /**
     * Return all the found scenes.
     */
    fun findAll(): List<SceneEntity>
}