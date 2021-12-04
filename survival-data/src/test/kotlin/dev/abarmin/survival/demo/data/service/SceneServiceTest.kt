package dev.abarmin.survival.demo.data.service

import org.assertj.core.api.Assertions.assertThat
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

    @Autowired
    lateinit var factory: SceneFactory

    @Test
    internal fun `Check context starts`() {
        assertThat(uut).isNotNull
    }

    @Test
    internal fun `Created scene is saved and loaded`() {
        val scene = factory.createScene("Temporary scene")
        val savedScene = uut.save(scene)
        assertThat(savedScene).isNotNull
            .extracting("name")
            .isEqualTo("Temporary scene")

        val loadedScene = uut.findScene("Temporary scene")
        assertThat(loadedScene).isNotNull
            .extracting("name")
            .isEqualTo("Temporary scene")
    }
}