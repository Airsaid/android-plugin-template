dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
    jcenter() // Warning: this repository is going to shut down soon
  }
}
rootProject.name = "android-plugin-template"
include(":app")
includeBuild("plugin-build")