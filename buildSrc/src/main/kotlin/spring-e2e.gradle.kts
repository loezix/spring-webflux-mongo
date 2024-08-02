plugins {
  id("spring")
}

dependencies {

  testFixturesApi(platform("io.cucumber:cucumber-bom:${providers.gradleProperty("cucumber.version").get()}"))
  testFixturesApi("io.cucumber:cucumber-java")
  testFixturesApi("io.cucumber:cucumber-junit-platform-engine")
  testFixturesApi("io.cucumber:cucumber-spring")
}
