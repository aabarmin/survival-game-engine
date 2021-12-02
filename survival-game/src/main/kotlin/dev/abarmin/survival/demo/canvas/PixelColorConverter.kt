package dev.abarmin.survival.demo.canvas

import dev.abarmin.survival.demo.scene.PixelColor
import org.springframework.stereotype.Component
import java.awt.Color

/**
 * Converts PixelColor to Canva's colors.
 *
 * @author Aleksandr Barmin
 */
@Component
class PixelColorConverter {
    private val colorsMap = mutableMapOf<PixelColor, Color>(
        PixelColor.TRANSPARENT to Color.WHITE
    )

    fun convert(color: PixelColor): Color {
        // TODO, alpha channel is not supported now
        return colorsMap.computeIfAbsent(color) {
            Color(it.red, it.green, it.blue)
        }
    }
}