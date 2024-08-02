plugins {
  id("spring")
}

dependencies {
  api("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
  testFixturesApi("io.projectreactor:reactor-test")
}
