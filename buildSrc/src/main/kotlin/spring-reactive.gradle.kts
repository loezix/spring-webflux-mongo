plugins {
  id("spring")
}

dependencies {
  api("org.springframework.boot:spring-boot-starter-webflux")
  testImplementation("io.projectreactor:reactor-test")
}
