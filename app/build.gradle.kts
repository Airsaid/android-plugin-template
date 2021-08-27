plugins {
  id("com.android.application")
  kotlin("android")
  id("com.airsaid.template.plugin")
}

android {
  compileSdk = 31

  defaultConfig {
    applicationId = "com.airsaid.template"
    minSdk = 21
    targetSdk = 31
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {
  implementation(Dependencies.AndroidX.KTX)
  implementation(Dependencies.AndroidX.APPCOMPAT)
  implementation(Dependencies.MATERIAL)
  implementation(Dependencies.AndroidX.CONSTRAINTLAYOUT)
  testImplementation(Dependencies.Test.JUNIT)
  androidTestImplementation(Dependencies.Test.ANDROIDX_JUNIT)
  androidTestImplementation(Dependencies.Test.ESPRESSO)
}