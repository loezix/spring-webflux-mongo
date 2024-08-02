plugins {
  id("library")
}

dependencies {
  api(platform("org.springframework.boot:spring-boot-dependencies:${providers.gradleProperty("spring.boot.version").get()}"))
  api("org.springframework.boot:spring-boot-starter")
  api("org.springframework.boot:spring-boot-starter-actuator")
  testFixturesApi("org.springframework.boot:spring-boot-starter-test")
  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:${providers.gradleProperty("spring.boot.version").get()}")
}
