plugins {
  id("binary")
  id("openapi")
}

dependencies {
  implementation(project(":lib:reactive-web"))
  testImplementation(testFixtures(project(":lib:reactive-web")))
}

openApiValidate {
    inputSpec = "$projectDir/docs/wishlist-v0.yaml"
    recommend = true
}
