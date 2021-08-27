plugins {
  kotlin("jvm")
  id("java-gradle-plugin")
  id("com.gradle.plugin-publish")
}

dependencies {
  implementation(kotlin("stdlib-jdk8"))
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

gradlePlugin {
  plugins {
    create(PluginConfig.ID) {
      id = PluginConfig.ID
      implementationClass = PluginConfig.IMPLEMENTATION_CLASS
    }
  }
}