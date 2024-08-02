plugins {
  id("library")
  id("binary")
}

dependencies {
  api(project(":lib:reactive-data"))
  testImplementation(testFixtures(project(":lib:reactive-data")))
}
