plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    compileSdk = Ver.compileSdk

    defaultConfig {
        minSdk = Ver.minSdk
        targetSdk = Ver.targetSdk
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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

    api("androidx.annotation:annotation:1.3.0")
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.zyc.wrench"
            artifactId = "wrench"
            version = "1.0.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
