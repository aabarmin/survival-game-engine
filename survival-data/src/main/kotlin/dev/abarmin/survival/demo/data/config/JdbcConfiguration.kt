package dev.abarmin.survival.demo.data.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.context.annotation.PropertySource
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

/**
 * Configuration for
 *
 * @author Aleksandr Barmin
 */
@Configuration
@DependsOn("storageConfiguration")
class JdbcConfiguration : AbstractJdbcConfiguration() {
    @Value("\${database.connection.url}")
    lateinit var databaseUrl: String

    @Bean
    @LiquibaseDataSource
    fun dataSource(): DataSource {
        return DriverManagerDataSource(databaseUrl)
    }
}