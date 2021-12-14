package dev.abarmin.survival.demo.data.repository

import dev.abarmin.survival.demo.ConfigurationForTests
import dev.abarmin.survival.demo.config.StorageConfiguration
import dev.abarmin.survival.demo.json.JsonReader
import dev.abarmin.survival.demo.json.JsonWriter
import dev.abarmin.survival.demo.repository.BinaryContentJsonRepository
import dev.abarmin.survival.demo.repository.SceneJsonRepository
import dev.abarmin.survival.demo.repository.SceneRepository
import dev.abarmin.survival.demo.transformer.BinaryContentTransformer
import dev.abarmin.survival.demo.transformer.LayerTransformer
import dev.abarmin.survival.demo.transformer.SceneTransformer
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
@ContextConfiguration(classes = [
    ConfigurationForTests::class,
    JsonWriter::class,
    JsonReader::class,
    SceneTransformer::class,
    LayerTransformer::class,
    BinaryContentTransformer::class,
    StorageConfiguration::class,
    SceneJsonRepository::class
])
internal class SceneJsonRepositoryTest {
    @Autowired
    lateinit var repository: SceneRepository

    @Test
    internal fun `Check that context starts`() {
        assertThat(repository).isNotNull
    }
}