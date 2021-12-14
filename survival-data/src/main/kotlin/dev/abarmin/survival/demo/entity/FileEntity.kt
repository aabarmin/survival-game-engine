package dev.abarmin.survival.demo.entity

import dev.abarmin.survival.demo.scene.info.ContentType

/**
 * Some file in the file system.
 *
 * @author Aleksandr Barmin
 */
data class FileEntity(
    val type: ContentType,
    val name: String
)