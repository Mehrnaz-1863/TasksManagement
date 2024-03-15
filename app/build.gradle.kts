
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.tasksmanagement"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tasksmanagement"
        minSdk = 33
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

//add Room
    val roomVersion = ("2.5.1")



    implementation ("androidx.room:room-ktx:$roomVersion")

    implementation ("androidx.room:room-runtime:$roomVersion")

    implementation ("androidx.room:room-rxjava3:$roomVersion")

    kapt ("androidx.room:room-compiler:$roomVersion")

    //RXJava
    implementation ("io.reactivex.rxjava3:rxandroid:3.0.2")

    //Live Data
    val  lifecycle_version = ("2.6.1")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")


}