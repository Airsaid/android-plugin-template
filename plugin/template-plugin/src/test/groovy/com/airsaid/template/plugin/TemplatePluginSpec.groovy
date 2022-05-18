package com.airsaid.template.plugin

import groovy.transform.CompileDynamic
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author airsaid
 */
@CompileDynamic
class TemplatePluginSpec extends Specification {

  def "test the application of the plugin on Gradle #gradleVersion"() {
    given:
    def projectDir = TemplatePluginTestHelper.getTestProjectDir("testProjectAndroid")

    when:
    def result = GradleRunner.create()
        .withProjectDir(projectDir)
        .withArguments(':app:assembleDebug')
        .withGradleVersion(gradleVersion)
        .forwardOutput()
        .withDebug(true)
        .build()

    then:
    result.output.contains("target: project ':app'")
    result.output.contains("plugin isEnabled: false")
    result.task(":app:assembleDebug").outcome == TaskOutcome.SUCCESS

    where:
    gradleVersion << ['7.0.2', '7.1']
  }
}