plugins {
  id("library")
}

dependencies {
  api(project(":lib:reactive-data"))
  testImplementation(testFixtures(project(":lib:reactive-data")))
}
