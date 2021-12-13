package dev.abarmin.survival.demo.service

import dev.abarmin.survival.demo.config.DefaultsConfiguration
import dev.abarmin.survival.demo.repository.BinaryContentRepository
import dev.abarmin.survival.demo.repository.SceneRepository
import dev.abarmin.survival.demo.scene.info.SceneInfo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.kotlin.anyOrNull
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

/**
 * @author Aleksandr Barmin
 */
@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [
    SceneFactory::class,
    DefaultsConfiguration::class,
    SceneLayerFactory::class,
    BinaryContentFactory::class,
    DummyBinaryContentFactory::class,
    BinaryContentService::class,
    SceneLayerIdFactory::class
])
internal class SceneFactoryTest {
    @Autowired
    lateinit var uut: SceneFactory

    @MockBean
    lateinit var repository: SceneRepository

    @MockBean
    lateinit var binaryRepository: BinaryContentRepository

    @Test
    internal fun `Check context starts`() {
        assertThat(uut).isNotNull
    }

    @Test
    internal fun `Check if a new scene is created`() {
        whenever(repository.save(anyOrNull())).thenAnswer { inv ->
            return@thenAnswer inv.getArgument(0)
        }
        whenever(binaryRepository.exists(anyOrNull())).thenReturn(false)

        val scene: SceneInfo = uut.createScene("test-scene", "Test Scene")

        assertThat(scene).isNotNull()
            .extracting("name")
            .isEqualTo("Test Scene")
    }
}