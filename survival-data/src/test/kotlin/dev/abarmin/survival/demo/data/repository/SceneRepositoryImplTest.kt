package dev.abarmin.survival.demo.data.repository

import dev.abarmin.survival.demo.data.ConfigurationForTests
import dev.abarmin.survival.demo.data.config.StorageConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
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
internal class SceneRepositoryImplTest {
    @Autowired
    lateinit var repository: SceneRepository

    @Test
    internal fun `Check that context starts`() {
        assertThat(repository).isNotNull
    }
}