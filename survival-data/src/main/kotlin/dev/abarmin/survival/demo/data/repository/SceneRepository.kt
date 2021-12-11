package dev.abarmin.survival.demo.data.repository

import dev.abarmin.survival.demo.data.model.SceneEntity
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
    fun findByName(name: String): Optional<SceneEntity>

    /**
     * Save an entity.
     */
    fun save(entity: SceneEntity): SceneEntity
}