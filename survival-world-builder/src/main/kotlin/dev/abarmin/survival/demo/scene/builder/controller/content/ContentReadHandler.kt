package dev.abarmin.survival.demo.scene.builder.controller.content

import dev.abarmin.survival.demo.scene.builder.controller.content.transformer.PixelDataTransformer
import dev.abarmin.survival.demo.scene.builder.controller.content.model.PixelColorModel
import dev.abarmin.survival.demo.scene.info.BinaryContent
import dev.abarmin.survival.demo.scene.info.ContentType
import dev.abarmin.survival.demo.service.BinaryContentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * @author Aleksandr Barmin
 */
@RestController
class ContentReadHandler(
    private val transformer: PixelDataTransformer,
    private val service: BinaryContentService) {

    @GetMapping("/content/{type}/{id}")
    fun readContent(@PathVariable("type") type: ContentType,
                    @PathVariable("id") name: String): Array<Array<PixelColorModel>> {

        val contentId = BinaryContent(type, name)
        val content = service.read(contentId).orElseThrow()
        return transformer.toModel(content)
    }
}