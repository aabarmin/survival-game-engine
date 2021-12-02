package dev.abarmin.survival.demo.scene

/**
 * Something like a coordinate.
 *
 * @author Aleksandr Barmin
 */
data class PixelPosition(val x: Int, val y: Int) {
    /**
     * Return a new position where (given - current).
     */
    fun minuxGiven(given: PixelPosition): PixelPosition {
        return PixelPosition(
            x - given.x,
            y - given.y
        )
    }

    /**
     * Return a sum of given positions.
     */
    fun plusGiven(given: PixelPosition): PixelPosition {
        return PixelPosition(
            given.x + x,
            given.y + y
        )
    }
}