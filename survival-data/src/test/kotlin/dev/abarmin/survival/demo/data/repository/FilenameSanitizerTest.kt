package dev.abarmin.survival.demo.data.repository

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

/**
 * @author Aleksandr Barmin
 */
@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [FilenameSanitizer::class])
internal class FilenameSanitizerTest {
    @Autowired
    lateinit var uut: FilenameSanitizer

    @ParameterizedTest
    @CsvSource(
        "InPuT,input",
        "in put,in_put"
    )
    internal fun `Check name is sanitized correctly`(input: String, expected: String) {
        val result = uut.sanitize(input)

        assertThat(result).isEqualTo(expected)
    }
}