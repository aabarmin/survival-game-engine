import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks.withType<BootJar> {
    enabled = false
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
}