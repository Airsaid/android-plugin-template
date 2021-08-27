plugins {
    kotlin("jvm")
    id("java-gradle-plugin")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

gradlePlugin {
    plugins {
        create("com.airsaid.template.plugin") {
            id = "com.airsaid.template.plugin"
            implementationClass = "com.airsaid.template.plugin.TemplatePlugin"
            version = "1.0.0"
        }
    }
}