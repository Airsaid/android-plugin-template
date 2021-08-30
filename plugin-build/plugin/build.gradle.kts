plugins {
  groovy
  kotlin("jvm")
  id("java-gradle-plugin")
  id("com.gradle.plugin-publish")
}

dependencies {
  implementation(kotlin("stdlib-jdk8"))
  compileOnly(PluginDependencies.ANDROID_GRADLE_PLUGIN)
  testImplementation(PluginDependencies.SPOCK)
  testImplementation(PluginDependencies.ANDROID_GRADLE_PLUGIN)
  testImplementation(PluginDependencies.COMMONS)
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