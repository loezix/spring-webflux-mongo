plugins {
  id("kotlin")
}

dependencies {
  implementation(platform("org.jetbrains.kotlin:kotlin-bom:${providers.systemProperty("kotlin.version").get()}"))
  implementation("org.jetbrains.kotlin:kotlin-stdlib")
}
