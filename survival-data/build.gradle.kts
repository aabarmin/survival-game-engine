import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks.withType<BootJar> {
    enabled = false
}

dependencies {
    implementation(project(":survival-model"))
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    runtimeOnly("com.h2database:h2")
    implementation("org.flywaydb:flyway-core")
}