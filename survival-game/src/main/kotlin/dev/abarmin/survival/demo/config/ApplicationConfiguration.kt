package dev.abarmin.survival.demo.config

import org.springframework.boot.context.properties.ConfigurationProperties
import javax.validation.constraints.NotBlank

/**
 * This class is primarily used for generating autocompletes for application.yaml
 *
 * @author Aleksandr Barmin
 */
@ConfigurationProperties(prefix = "survival")
class ApplicationConfiguration {
    @NotBlank
    lateinit var sceneStorage: String
}