package dev.abarmin.survival.demo.service

import dev.abarmin.survival.demo.repository.BinaryContentRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

/**
 * @author Aleksandr Barmin
 */
@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [
    SceneLayerIdFactory::class,
    BinaryContentService::class
])
internal class SceneLayerIdFactoryTest {
    @Autowired
    lateinit var uut: SceneLayerIdFactory

    @MockBean
    lateinit var repository: BinaryContentRepository

    @Test
    internal fun `Check context starts`() {
        assertThat(uut).isNotNull
    }

    @Test
    internal fun `Check if value is returned`() {
        val generated = uut.generate()
        assertThat(generated).isNotEmpty
    }
}