plugins {
  id("binary")
  id("openapi")
}

dependencies {
  implementation(project(":lib:reactive-web"))
  testImplementation(testFixtures(project(":lib:reactive-web")))
}

openApiValidate {
    inputSpec = "$rootDir/wishlist-v1.yaml"
    recommend = true
}
