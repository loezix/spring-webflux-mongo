plugins {
  id("library")
  id("org.springframework.boot")
}

dependencies {
  api(platform("org.springframework.boot:spring-boot-dependencies:${providers.gradleProperty("spring.boot.version").get()}"))
  api("org.springframework.boot:spring-boot-starter")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}
