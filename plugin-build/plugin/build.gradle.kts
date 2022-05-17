plugins {
  groovy
  id("java-gradle-plugin")
  id("org.jetbrains.kotlin.jvm")
  id("com.gradle.plugin-publish")
}

dependencies {
  implementation(pluginLibs.kotlin.stdlib)
  compileOnly(pluginLibs.android.gradle.plugin)
  testImplementation(pluginLibs.spock)
  testImplementation(pluginLibs.android.gradle.plugin)
  testImplementation(pluginLibs.commonsio)
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

gradlePlugin {
  plugins {
    create(PluginConfig.ID) {
      id = PluginConfig.ID
      displayName = PluginConfig.DISPLAY_NAME
      description = PluginConfig.DESCRIPTION
      implementationClass = PluginConfig.IMPLEMENTATION_CLASS
    }
  }
}

pluginBundle {
  website = PluginBundle.WEBSITE
  vcsUrl = PluginBundle.VCS_URL
  tags = PluginBundle.TAGS
}

tasks.withType<Test>().configureEach {
  // Using JUnitPlatform for running tests
  useJUnitPlatform()
}