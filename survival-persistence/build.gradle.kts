import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks.withType<BootJar> {
    enabled = false
}

/**
 * Removing the data folder because it's created by tests.
 */
tasks.withType<Delete> {
    delete("survival-data")
}

dependencies {
    implementation(project(":survival-model"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}