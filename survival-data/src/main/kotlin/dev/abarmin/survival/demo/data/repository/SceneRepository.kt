package dev.abarmin.survival.demo.data.repository

import dev.abarmin.survival.demo.data.model.SceneEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

/**
 * Repository for dealing with scenes.
 *
 * @author Aleksandr Barmin
 */
interface SceneRepository : CrudRepository<SceneEntity, Long> {
    /**
     * Find a scene by its name.
     */
    fun findByName(name: String): Optional<SceneEntity>
}