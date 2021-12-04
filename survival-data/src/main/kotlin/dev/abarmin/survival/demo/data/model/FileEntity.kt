package dev.abarmin.survival.demo.data.model

import org.springframework.data.relational.core.mapping.Column

/**
 * Some file in the file system.
 *
 * @author Aleksandr Barmin
 */
data class FileEntity(
    @Column("FILE_TYPE") val type: String,
    @Column("FILE_NAME") val name: String
)