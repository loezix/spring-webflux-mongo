plugins {
  id("spring")
}

dependencies {
  api("org.springframework.boot:spring-boot-starter-webflux")
  testFixturesApi("io.projectreactor:reactor-test")
}
