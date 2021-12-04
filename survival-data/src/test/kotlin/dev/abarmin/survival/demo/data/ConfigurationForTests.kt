package dev.abarmin.survival.demo.data

import dev.abarmin.survival.demo.data.repository.SceneRepository
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Primary
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import javax.sql.DataSource

/**
 * @author Aleksandr Barmin
 */
@ComponentScan
@SpringBootConfiguration
@EnableJdbcRepositories(basePackageClasses = [SceneRepository::class])
class ConfigurationForTests {
    @Bean
    @Primary
    @FlywayDataSource
    fun testDataSource(): DataSource {
        val builder = EmbeddedDatabaseBuilder()
        builder.setType(EmbeddedDatabaseType.H2)
        return builder.build();
    }
}