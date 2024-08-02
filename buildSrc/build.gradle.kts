plugins {
  `kotlin-dsl` //@BUG https://github.com/gradle/gradle/issues/23884
}

apply(from = rootProject.file("src/main/kotlin/properties.gradle.kts"))

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${providers.systemProperty("kotlin.version").get()}")
  implementation("org.openapitools:openapi-generator-gradle-plugin:${providers.systemProperty("openapi.generator.version").get()}")
}
