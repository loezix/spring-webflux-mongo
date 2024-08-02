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
  testFixturesApi(platform("org.junit:junit-bom:${providers.gradleProperty("junit.version").get()}"))
  testFixturesApi("org.junit.platform:junit-platform-suite")
  testFixturesApi("org.junit.jupiter:junit-jupiter")
}

java {
  sourceCompatibility = JavaVersion.valueOf(providers.gradleProperty("java.version").get())
}

tasks.withType<Test> {
  useJUnitPlatform()
  systemProperty("cucumber.junit-platform.naming-strategy", "long")
}
