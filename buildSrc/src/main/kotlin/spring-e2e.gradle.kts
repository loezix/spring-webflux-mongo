plugins {
  id("spring")
}

dependencies {
  testFixturesApi("io.cucumber:cucumber-java:${providers.gradleProperty("cucumber.version").get()}")
  testFixturesApi("io.cucumber:cucumber-junit:${providers.gradleProperty("cucumber.version").get()}")
  testFixturesApi("io.cucumber:cucumber-spring:${providers.gradleProperty("cucumber.version").get()}")
}
