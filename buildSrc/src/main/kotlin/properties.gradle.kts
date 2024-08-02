import java.util.Properties
import java.io.FileInputStream

val properties = Properties()
val input = FileInputStream(file("../gradle.properties"))
properties.load(input)
input.close()

properties.stringPropertyNames().forEach { key ->
  System.setProperty(key,properties.getProperty(key))
}

