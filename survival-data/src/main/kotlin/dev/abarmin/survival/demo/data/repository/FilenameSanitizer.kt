package dev.abarmin.survival.demo.data.repository

import org.springframework.stereotype.Component

/**
 * Get rid of unnecessary characters in the file names.
 *
 * @author Aleksandr Barmin
 */
@Component
class FilenameSanitizer {
    fun sanitize(input: String): String {
        return input.lowercase()
            .replace(" ", "_")
    }
}