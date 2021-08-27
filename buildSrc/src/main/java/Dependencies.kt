/**
 * @author airsaid
 */
object Dependencies {
  const val ANDROID_GRADLE_PLUGIN = "com.android.tools.build:gradle:7.0.1"
  const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20"

  const val MATERIAL = "com.google.android.material:material:1.3.0"

  object AndroidX {
    const val KTX = "androidx.core:core-ktx:1.3.2"
    const val APPCOMPAT = "androidx.appcompat:appcompat:1.2.0"
    const val CONSTRAINTLAYOUT = "androidx.constraintlayout:constraintlayout:2.0.4"
  }

  object Test {
    const val JUNIT = "junit:junit:4.13.2"
    const val ANDROIDX_JUNIT = "androidx.test.ext:junit:1.1.2"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:3.3.0"
  }
}