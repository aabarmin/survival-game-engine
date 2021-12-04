package dev.abarmin.survival.demo.data.service

import dev.abarmin.survival.demo.scene.info.SceneInfo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

/**
 * @author Aleksandr Barmin
 */
@SpringJUnitConfig(classes = [SceneFactory::class])
internal class SceneFactoryTest {
    @Autowired
    lateinit var uut: SceneFactory

    @Test
    internal fun `Check context starts`() {
        assertThat(uut).isNotNull
    }

    @Test
    internal fun `Check if a new scene is created`() {
        val scene: SceneInfo = uut.createScene("Test scene")

        assertThat(scene).isNotNull()
            .extracting("name")
            .isEqualTo("Test scene")
    }
}