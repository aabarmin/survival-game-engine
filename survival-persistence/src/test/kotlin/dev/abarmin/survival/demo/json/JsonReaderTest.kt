package dev.abarmin.survival.demo.json

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import dev.abarmin.survival.demo.ConfigurationForTests
import dev.abarmin.survival.demo.scene.PixelColor
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

/**
 * @author Aleksandr Barmin
 */
@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [
    JsonReader::class,
    ConfigurationForTests::class
])
internal class JsonReaderTest {
    @Autowired
    lateinit var jsonReader: JsonReader

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Value("classpath:/json/green_field.json")
    lateinit var greenFieldResource: Resource

    @Test
    internal fun `Check context starts`() {
        assertThat(jsonReader).isNotNull
    }

    @Test
    internal fun `Check if array of arrays is encoded correctly`() {
        val resourcePath = greenFieldResource.file
        val content = objectMapper.readValue<Array<Array<PixelColor>>>(resourcePath)

        assertThat(content).isNotNull
    }

    @Test
    internal fun `Reading content via JsonReader`() {
        val resourcePath = greenFieldResource.file.toPath()
        val content = jsonReader.read<Array<Array<PixelColor>>>(resourcePath)

        assertThat(content).isNotNull
    }
}