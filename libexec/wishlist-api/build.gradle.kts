plugins {
  id("binary")
  id("openapi")
}

dependencies {
  implementation(project(":libexec:wishlist-svc"))
  implementation(project(":lib:reactive-web"))
  testImplementation(testFixtures(project(":lib:reactive-web")))
}

openApiValidate {
    inputSpec = "$projectDir/docs/wishlist-v0.yaml"
    recommend = true
}

tasks.register<Copy>("deployOpenApiSpec") {
  from(layout.projectDirectory.dir("docs"))
  include("**/*.*")
  into(layout.projectDirectory.dir("src/main/resources/public"))
}

tasks.named("processResources") { dependsOn("deployOpenApiSpec")}
