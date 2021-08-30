package com.airsaid.template.plugin

import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author airsaid
 */
class TemplatePluginSpec extends Specification {

  @Unroll
  def "test the application of the plugin on Gradle #gradleVersion"() {
    given:
    def projectDir = TemplatePluginTestHelper.getTestProjectDir("testProjectAndroid")

    when:
    def result = GradleRunner.create()
        .withProjectDir(projectDir)
        .withArguments(':app:assembleDebug')
        .withGradleVersion(gradleVersion)
        .withPluginClasspath()
        .forwardOutput()
        .withDebug(true)
        .build()

    then:
    result.output.contains("target: project ':app'")
    result.task(":app:assembleDebug").outcome == TaskOutcome.SUCCESS

    where:
    gradleVersion << ['7.0.2', '7.1']
  }
}