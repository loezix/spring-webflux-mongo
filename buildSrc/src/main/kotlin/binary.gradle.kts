plugins {
  id("commons")
  id("application")
}

application {
  mainClass = "${project.group}.${project.name}.Main".replace("-",".")
}


