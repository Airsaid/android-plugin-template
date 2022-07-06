package com.airsaid.template.plugin

import com.airsaid.template_plugin.BuildConfig
import com.github.jackchen.gradle.test.toolkit.GradlePluginTest
import com.github.jackchen.gradle.test.toolkit.ext.TestVersion
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * @author airsaid
 */
class TemplatePluginTest : GradlePluginTest() {
  private fun testProjectSetup(closure: TemplatePluginTest.() -> Unit) {
    kotlinAndroidTemplate {
      template {
        plugins {
          id(BuildConfig.PLUGIN_ID).version(BuildConfig.PLUGIN_VERSION)
        }
        dependencies {
          implementation("androidx.core:core-ktx:1.7.0")
          implementation("androidx.appcompat:appcompat:1.4.1")
        }
      }
    }
    apply(closure)
  }

  @Test
  @TestVersion(androidVersion = "7.2.0", gradleVersion = "7.3.3")
  fun buildTest() {
    testProjectSetup {
      build(":app:assembleDebug") {
        Assertions.assertEquals(TaskOutcome.SUCCESS, task(":app:assembleDebug")?.outcome)
        Assertions.assertTrue(output.contains("plugin isEnabled: true"))
      }
    }
  }
}