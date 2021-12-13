package dev.abarmin.survival.demo.data.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.validation.annotation.Validated

/**
 * @author Aleksandr Barmin
 */
@Validated
@Configuration
@ConfigurationProperties(prefix = "defaults")
data class DefaultsConfiguration(
    var scene: SceneDefaultsConfiguration = SceneDefaultsConfiguration(),
    var layer: LayerDefaultsConfiguration = LayerDefaultsConfiguration()
)