import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks.withType<BootJar> {
    enabled = false
}

/**
 * Removing the data folder because it's created by tests.
 */
tasks.withType<Delete> {
    delete("data")
}

dependencies {
    implementation(project(":survival-model"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    // temporarily, all the data will be stored in json
    // no need to deal with H2 or anything like this right now
    // will not remove migrations and all the written code but
    // will comment it for now
//    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
//    runtimeOnly("com.h2database:h2")
//    implementation("org.flywaydb:flyway-core")
}