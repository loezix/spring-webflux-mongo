plugins {
  id("java")
  id("java-test-fixtures")
  id("maven-publish")
}

group = providers.gradleProperty("project.group").get()
version = providers.gradleProperty("project.version").get()

repositories {
  mavenLocal()
  mavenCentral()
}

dependencies {
  testRuntimeOnly("org.junit.platform:junit-platform-launcher:${providers.gradleProperty("junit.platform.version").get()}")
}

java {
  sourceCompatibility = JavaVersion.valueOf(providers.gradleProperty("java.version").get())
}

tasks.withType<Test> {
  useJUnitPlatform()
}
