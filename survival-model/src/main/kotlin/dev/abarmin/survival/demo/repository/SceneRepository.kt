package dev.abarmin.survival.demo.repository

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
    fun findById(id: String): Optional<SceneInfo>

    /**
     * Save a scene.
     */
    fun save(info: SceneInfo): SceneInfo

    /**
     * Return all the found scenes.
     */
    fun findAll(): List<SceneInfo>
}