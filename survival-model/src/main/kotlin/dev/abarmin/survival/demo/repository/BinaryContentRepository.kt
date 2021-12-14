package dev.abarmin.survival.demo.repository

import dev.abarmin.survival.demo.scene.PixelColor
import dev.abarmin.survival.demo.scene.info.BinaryContent

/**
 * Abstraction layer for the binary content.
 *
 * @author Aleksandr Barmin
 */
interface BinaryContentRepository {
    /**
     * Write data to the given content object.
     */
    fun write(content: BinaryContent, data: Array<Array<PixelColor>>)

    /**
     * Checking if a given data item exists.
     */
    fun exists(content: BinaryContent): Boolean
}