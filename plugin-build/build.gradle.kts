plugins {
  kotlin("jvm") version PluginVersions.KOTLIN
  id("com.gradle.plugin-publish") version PluginVersions.PLUGIN_PUBLISH
}

allprojects {
  group = PluginConfig.GROUP
  version = PluginConfig.VERSION

  repositories {
    google()
    mavenCentral()
    jcenter()
  }
}