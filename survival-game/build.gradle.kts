import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    id("org.springframework.boot") version "2.6.1"
    kotlin("plugin.spring") version "1.6.0"
    id("io.spring.dependency-management")
}

dependencies {
    implementation(project(":survival-model"))
    implementation("org.springframework.boot:spring-boot-starter")
}

tasks.withType<BootRun> {
    systemProperty("java.awt.headless", "false")
}