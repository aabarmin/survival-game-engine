package dev.abarmin.survival.demo.scene.builder.controller.content

import dev.abarmin.survival.demo.scene.builder.controller.content.model.PixelColorModel
import dev.abarmin.survival.demo.scene.builder.controller.content.transformer.PixelDataTransformer
import dev.abarmin.survival.demo.scene.info.BinaryContent
import dev.abarmin.survival.demo.scene.info.ContentType
import dev.abarmin.survival.demo.service.BinaryContentService
import org.springframework.web.bind.annotation.*

/**
 * @author Aleksandr Barmin
 */
@RestController
class ContentWriteHandler(private val transformer: PixelDataTransformer,
                          private val service: BinaryContentService) {

    @PostMapping("/content/{type}/{id}")
    fun writeContent(@PathVariable("type") type: ContentType,
                     @PathVariable("id") name: String,
                     @RequestBody content: Array<Array<PixelColorModel>>): Array<Array<PixelColorModel>> {

        val preparedContent = transformer.toDomain(content)
        val contentId = BinaryContent(type, name)

        service.write(contentId, preparedContent)

        return content
    }
}