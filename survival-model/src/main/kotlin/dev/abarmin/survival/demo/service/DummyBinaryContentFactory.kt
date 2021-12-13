package dev.abarmin.survival.demo.service

import dev.abarmin.survival.demo.scene.PixelColor
import org.springframework.stereotype.Component

/**
 * Generates dummy content, may be useful for anything.
 *
 * @author Aleksandr Barmin
 */
@Component
class DummyBinaryContentFactory {
    fun generate(): Array<Array<PixelColor>> {
        return Array(0) { _ -> Array(0) { _ -> PixelColor.TRANSPARENT} }
    }
}