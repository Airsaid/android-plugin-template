@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
  alias(pluginLibs.plugins.kotlin.jvm).apply(false)
  alias(pluginLibs.plugins.gradle.plugin.publish).apply(false)
}

allprojects {
  group = PluginConfig.GROUP
  version = PluginConfig.VERSION

  repositories {
    google()
    mavenCentral()
  }
}