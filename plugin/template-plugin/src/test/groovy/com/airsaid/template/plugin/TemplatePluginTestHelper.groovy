package com.airsaid.template.plugin

import groovy.transform.CompileDynamic
import org.apache.commons.io.FileUtils

/**
 * Utility class.
 *
 * @author airsaid
 */
@CompileDynamic
final class TemplatePluginTestHelper {

  private TemplatePluginTestHelper() {
    // do not instantiate
  }

  static File getTestProjectDir(String projectName) {
    File userDir = new File(System.getProperty("user.dir"))
    File projectDir = new File(userDir, 'build/tests/' + projectName)
    FileUtils.deleteDirectory(projectDir)
    FileUtils.forceMkdir(projectDir)
    FileUtils.copyDirectory(new File(userDir.parent, projectName), projectDir)
    return projectDir
  }
}