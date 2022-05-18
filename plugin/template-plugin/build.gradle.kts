plugins {
  groovy
  `maven-publish`
  `java-gradle-plugin`
  id("org.jetbrains.kotlin.jvm")
  id("com.gradle.plugin-publish")
}

// fix: https://youtrack.jetbrains.com/issue/IDEA-276365
configurations.compileOnly.configure {
  isCanBeResolved = true
}

tasks.withType<PluginUnderTestMetadata>().configureEach {
  pluginClasspath.from(configurations.compileOnly)
}

dependencies {
  compileOnly(gradleApi())
  compileOnly(pluginLibs.kotlin.stdlib)
  compileOnly(pluginLibs.android.gradle.plugin)

  testImplementation(gradleTestKit())
  testImplementation(pluginLibs.spock)
  testImplementation(pluginLibs.commonsio)
}

tasks.named("test").configure {
  dependsOn("publishToMavenLocal")
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

gradlePlugin {
  plugins {
    register("TemplatePlugin") {
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
  maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
  doFirst {
    logger.lifecycle("maxParallelForks for '$path' is $maxParallelForks")
  }
  testLogging {
    events(
        org.gradle.api.tasks.testing.logging.TestLogEvent.STARTED,
        org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
        org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED,
        org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED
    )
    exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    showExceptions = true
    showCauses = true
    showStackTraces = true
  }
}