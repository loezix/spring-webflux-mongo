plugins {
  id("library")
  id("library-kotlin")
  id("spring-reactive")
}

dependencies {
  api("org.springframework.boot:spring-boot-starter-webflux")
  api("com.fasterxml.jackson.module:jackson-module-kotlin")
  //@TODO
  api("com.atlassian.oai:swagger-request-validator-core:2.41.0")
}

