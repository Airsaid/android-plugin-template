pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
  }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
  versionCatalogs {
    create("pluginLibs") {
      from(files("../gradle/libs.versions.toml"))
    }
  }
}

rootProject.name = ("plugin")
include(":template-plugin")