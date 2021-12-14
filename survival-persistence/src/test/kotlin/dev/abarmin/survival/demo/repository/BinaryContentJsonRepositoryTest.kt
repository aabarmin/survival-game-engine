package dev.abarmin.survival.demo.repository

import dev.abarmin.survival.demo.ConfigurationForTests
import dev.abarmin.survival.demo.config.StorageConfiguration
import dev.abarmin.survival.demo.json.JsonReader
import dev.abarmin.survival.demo.json.JsonWriter
import dev.abarmin.survival.demo.scene.PixelColor
import dev.abarmin.survival.demo.scene.info.BinaryContent
import dev.abarmin.survival.demo.scene.info.ContentType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.core.io.Resource
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
    BinaryContentJsonRepository::class
])
internal class BinaryContentJsonRepositoryTest {
    @Autowired
    lateinit var repository: BinaryContentJsonRepository

    @MockBean
    lateinit var storageConfiguration: StorageConfiguration

    @Value("classpath:/json/green_field.json")
    lateinit var greenFieldResource: Resource

    @Test
    internal fun `Check context starts`() {
        assertThat(repository).isNotNull
    }

    @Test
    internal fun `Check if transparent colors are the same`() {
        val parentFolder = greenFieldResource.file.toPath().parent
        whenever(storageConfiguration.getStorage(ContentType.LAYER)).thenReturn(parentFolder)

        val readContent = repository.read(BinaryContent(ContentType.LAYER, "green_field.json"))
        val content = readContent.get()

        for (row in content) {
            for (cell in row) {
                if (cell.isTransparent()) {
                    assertThat(cell).isSameAs(PixelColor.TRANSPARENT)
                }
            }
        }
    }
}