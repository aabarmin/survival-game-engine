package dev.abarmin.survival.demo.scene.builder.controller

import dev.abarmin.survival.demo.data.service.SceneService
import dev.abarmin.survival.demo.scene.builder.service.SceneBuilderService
import dev.abarmin.survival.demo.scene.info.SceneInfo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

/**
 * @author Aleksandr Barmin
 */
@WebMvcTest(controllers = [SceneController::class])
internal class SceneControllerTest {
    lateinit var mockMvc: MockMvc
    @Autowired
    lateinit var contenxt: WebApplicationContext
    @MockBean
    lateinit var sceneBuilderService: SceneBuilderService
    @MockBean
    lateinit var sceneService: SceneService

    @BeforeEach
    internal fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(contenxt).build()
    }

    @Test
    internal fun `Check if list all endpoint is available`() {
        `when`(sceneService.findAll()).thenReturn(listOf(
            createScene(),
            createScene()
        ))

        mockMvc.get("/scenes")
            .andExpect {
                status().isOk
                content {
                    contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                }
            }
    }

    private fun createScene(): SceneInfo {
        return SceneInfo(
            "temporary-name",
            "temporary name",
            listOf()
        )
    }
}