package dev.abarmin.survival.demo.data.repository

import dev.abarmin.survival.demo.data.model.SceneEntity
import org.springframework.data.repository.CrudRepository

/**
 * Repository for dealing with scenes.
 *
 * @author Aleksandr Barmin
 */
interface SceneRepository : CrudRepository<SceneEntity, Long> {
}