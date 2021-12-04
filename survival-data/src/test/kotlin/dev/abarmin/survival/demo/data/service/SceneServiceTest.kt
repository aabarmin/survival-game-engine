package dev.abarmin.survival.demo.data.service

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest

/**
 * @author Aleksandr Barmin
 */
@DataJdbcTest
internal class SceneServiceTest {
    @Autowired
    lateinit var uut: SceneService

    @Test
    internal fun `Check context starts`() {
        assertNotNull(uut)
    }
}