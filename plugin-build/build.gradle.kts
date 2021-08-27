plugins {
  kotlin("jvm") version "1.4.32"
  id("com.gradle.plugin-publish") version "0.14.0"
}

allprojects {
  group = "com.airsaid"
  version = "1.0.0"

  repositories {
    google()
    mavenCentral()
    jcenter()
  }
}