// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
  alias(libs.plugins.android.application).apply(false)
  alias(libs.plugins.android.library).apply(false)
  alias(libs.plugins.kotlin.android).apply(false)
  alias(libs.plugins.kotlin.jvm).apply(false)
  alias(libs.plugins.buildconfig).apply(false)
  alias(libs.plugins.gradle.plugin.publish).apply(false)
//  alias(libs.plugins.template).apply(false)
}

val pluginVersion = libs.versions.template.get()
allprojects {
  group = "com.airsaid"
  version = pluginVersion
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}