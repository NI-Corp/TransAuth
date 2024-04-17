plugins {
    id("com.android.library")
    id("com.github.ben-manes.versions") version "0.47.0"
}

android {
    namespace = "com.nicorp.transauth"
    compileSdk = 34
    setPublishNonDefault(true)

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    packagingOptions {
        exclude("META-INF/INDEX.LIST")
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/io.netty.versions.properties")
    }
}

dependencies {
    // https://mvnrepository.com/artifact/io.appwrite/sdk-for-android
    implementation("com.github.parse-community.Parse-SDK-Android:parse:4.3.0")
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
