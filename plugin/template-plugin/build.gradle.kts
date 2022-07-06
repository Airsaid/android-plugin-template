plugins {
  groovy
  `maven-publish`
  `java-gradle-plugin`
  id("org.jetbrains.kotlin.jvm")
  id("com.gradle.plugin-publish")
  id("com.github.gmazzo.buildconfig")
}

val versionCatalog = extensions.getByType<VersionCatalogsExtension>().named("pluginLibs")
val pluginVersion: String = versionCatalog.findVersion("template").get().requiredVersion
val pluginId: String = versionCatalog.findPlugin("template").get().get().pluginId

buildConfig {
  sourceSets.getByName("test") {
    buildConfig {
      buildConfigField("String", "PLUGIN_VERSION", "\"${pluginVersion}\"")
      buildConfigField("String", "PLUGIN_ID", "\"${pluginId}\"")
    }
  }
}

gradlePlugin {
  plugins {
    register("TemplatePlugin") {
      id = pluginId
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

java {
  sourceCompatibility = JavaVersion.VERSION_14
  targetCompatibility = JavaVersion.VERSION_14
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
  kotlinOptions {
    jvmTarget = "14"
  }
}

configurations.compileOnly.configure {
  // fix: https://youtrack.jetbrains.com/issue/IDEA-276365
  isCanBeResolved = true
}

tasks.withType<PluginUnderTestMetadata>().configureEach {
  pluginClasspath.from(configurations.compileOnly)
}

// Test tasks load plugin from local maven repository
tasks.named("test").configure {
  dependsOn("publishToMavenLocal")
}

tasks.withType<Test>().configureEach {
  useJUnitPlatform()
  testLogging {
    showStandardStreams = true
  }
}

dependencies {
  compileOnly(gradleApi())
  compileOnly(pluginLibs.kotlin.stdlib)
  compileOnly(pluginLibs.android.gradle.plugin)

  testImplementation(gradleTestKit())
  testImplementation(pluginLibs.junit.jupiter)
  testImplementation(pluginLibs.gradle.test.toolkit)
}