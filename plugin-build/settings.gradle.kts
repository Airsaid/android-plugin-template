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

rootProject.name = ("com.airsaid.template.plugin")
include(":plugin")