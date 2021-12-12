package dev.abarmin.survival.demo.data.service

import dev.abarmin.survival.demo.data.ConfigurationForTests
import dev.abarmin.survival.demo.data.model.SceneEntity
import dev.abarmin.survival.demo.data.repository.SceneRepository
import dev.abarmin.survival.demo.scene.info.SceneInfo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.*
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
@ContextConfiguration(classes = [ConfigurationForTests::class])
internal class SceneServiceTest {
    @Autowired
    lateinit var uut: SceneService

    @Autowired
    lateinit var factory: SceneFactory

    @MockBean
    lateinit var repository: SceneRepository

    @Test
    internal fun `Check context starts`() {
        assertThat(uut).isNotNull
    }

    @Test
    internal fun `Find all should return all from repo`() {
        `when`(repository.findAll()).thenReturn(listOf(
            SceneEntity(
                "test-scene",
                "test scene",
                "layered",
                listOf()
            )
        ))

        val allScenes = uut.findAll()

        assertThat(allScenes)
            .isNotNull
            .isNotEmpty
    }

    @Test
    internal fun `Created scene is saved and loaded`() {
        val temporaryStorage = mutableMapOf<String, SceneEntity>()

        whenever(repository.save(anyOrNull())).thenAnswer { invocation ->
            val entity = invocation.getArgument<SceneEntity>(0)
            temporaryStorage.put(entity.name, entity)

            return@thenAnswer entity
        }
        whenever(repository.findByName(anyString())).thenAnswer { invocation ->
            val name = invocation.getArgument<String>(0)
            val sceneEntity = temporaryStorage.get(name)
            return@thenAnswer Optional.ofNullable(sceneEntity)
        }

        val scene = factory.createScene("Temporary scene", "temporary-scene")
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