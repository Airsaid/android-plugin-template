package com.airsaid.template.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

const val EXTENSION_NAME = "template"

/**
 * @author airsaid
 */
class TemplatePlugin : Plugin<Project> {
  override fun apply(target: Project) {
    target.logger.quiet("target: $target")
    val extension = target.extensions.create(EXTENSION_NAME, TemplateExtension::class.java)
    target.afterEvaluate {
      target.logger.quiet("plugin isEnabled: ${extension.isEnabled}")
    }
  }
}