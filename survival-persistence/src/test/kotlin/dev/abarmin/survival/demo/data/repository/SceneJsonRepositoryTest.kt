package dev.abarmin.survival.demo.data.repository

import dev.abarmin.survival.demo.ConfigurationForTests
import dev.abarmin.survival.demo.repository.SceneRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

/**
 * @author Aleksandr Barmin
 */
@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [ConfigurationForTests::class])
internal class SceneJsonRepositoryTest {
    @Autowired
    lateinit var repository: SceneRepository

    @Test
    internal fun `Check that context starts`() {
        assertThat(repository).isNotNull
    }
}