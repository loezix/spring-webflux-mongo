plugins {
  `kotlin-dsl` //@BUG https://github.com/gradle/gradle/issues/23884
}

apply(from = rootProject.file("src/main/kotlin/properties.gradle.kts"))

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-gradle-plugin:${providers.systemProperty("spring.boot.version").get()}")
}
