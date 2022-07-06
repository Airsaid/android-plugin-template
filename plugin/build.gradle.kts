@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
  alias(pluginLibs.plugins.kotlin.jvm).apply(false)
  alias(pluginLibs.plugins.gradle.plugin.publish).apply(false)
  alias(pluginLibs.plugins.buildconfig).apply(false)
}

val pluginVersion = pluginLibs.versions.template
allprojects {
  group = PluginConfig.GROUP
  version = pluginVersion
}