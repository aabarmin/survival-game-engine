package dev.abarmin.survival.demo.service

import dev.abarmin.survival.demo.config.DefaultsConfiguration
import dev.abarmin.survival.demo.repository.BinaryContentRepository
import dev.abarmin.survival.demo.repository.SceneRepository
import dev.abarmin.survival.demo.scene.info.SceneInfo
import dev.abarmin.survival.demo.scene.info.SceneType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.anyString
import org.mockito.kotlin.anyOrNull
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

/**
 * @author Aleksandr Barmin
 */
@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [
    SceneService::class,
    SceneFactory::class,
    DefaultsConfiguration::class,
    SceneLayerFactory::class,
    BinaryContentFactory::class,
    DummyBinaryContentFactory::class,
    BinaryContentService::class,
    SceneLayerIdFactory::class
])
internal class SceneServiceTest {
    @Autowired
    lateinit var uut: SceneService

    @Autowired
    lateinit var factory: SceneFactory

    @MockBean
    lateinit var repository: SceneRepository

    @MockBean
    lateinit var binaryRepository: BinaryContentRepository

    @Test
    internal fun `Check context starts`() {
        assertThat(uut).isNotNull
    }

    @Test
    internal fun `Find all should return all from repo`() {
        whenever(repository.findAll()).thenReturn(listOf(
            SceneInfo(
                "test-scene",
                "test scene",
                listOf(),
                480,
                240,
                SceneType.LAYERED,
            )
        ))

        val allScenes = uut.findAll()

        assertThat(allScenes)
            .isNotNull
            .isNotEmpty
    }

    @Test
    internal fun `Created scene is saved and loaded`() {
        val temporaryStorage = mutableMapOf<String, SceneInfo>()

        whenever(repository.save(anyOrNull())).thenAnswer { invocation ->
            val entity = invocation.getArgument<SceneInfo>(0)
            temporaryStorage.put(entity.name, entity)

            return@thenAnswer entity
        }
        whenever(repository.findById(anyString())).thenAnswer { invocation ->
            val name = invocation.getArgument<String>(0)
            val sceneEntity = temporaryStorage.get(name)
            return@thenAnswer Optional.ofNullable(sceneEntity)
        }

        val scene = factory.createScene("temporary-scene", "Temporary scene")
        assertThat(scene).isNotNull
            .extracting("name")
            .isEqualTo("Temporary scene")

        val sceneOptional = uut.findById("Temporary scene")

        assertThat(sceneOptional).isNotNull
        assertThat(sceneOptional.isPresent).isTrue

        val loadedScene = sceneOptional.get()

        assertThat(loadedScene).isNotNull
            .extracting("name")
            .isEqualTo("Temporary scene")
    }
}