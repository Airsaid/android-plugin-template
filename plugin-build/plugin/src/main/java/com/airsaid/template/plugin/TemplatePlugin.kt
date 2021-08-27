package com.airsaid.template.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author airsaid
 */
class TemplatePlugin : Plugin<Project> {
  override fun apply(target: Project) {
    target.logger.quiet("target: $target")
  }
}