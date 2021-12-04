package dev.abarmin.survival.demo.data.repository

import dev.abarmin.survival.demo.data.model.SceneEntity
import org.springframework.data.repository.CrudRepository

/**
 * @author Aleksandr Barmin
 */
interface SceneRepository : CrudRepository<SceneEntity, Long> {
}