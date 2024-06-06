plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    //alias(libs.plugins.androidPublish)
    id("maven-publish")
}

android {
    namespace = "mx.com.iqsec.sumdouble"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    kotlinOptions {
        jvmTarget = "19"
    }

    afterEvaluate {

        publishing {

            publications {
                create<MavenPublication>("release") {
                    from(components["release"])
                    groupId = "com.github.AlbertoMarinFa"
                    artifactId = "SumNumbers"
                    version = "0.0.1"
                }
                repositories {
                    mavenLocal()
                }
            }
        }
    }
}

dependencies {
}