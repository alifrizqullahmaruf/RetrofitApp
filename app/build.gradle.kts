// Plugins yang digunakan untuk konfigurasi aplikasi Android dan Kotlin
plugins {
    id("com.android.application")  // Plugin untuk aplikasi Android
    id("org.jetbrains.kotlin.android")  // Plugin untuk pengembangan dengan Kotlin di Android
}

// Konfigurasi Android aplikasi
android {
    namespace = "com.example.retrofitapp"
    compileSdk = 34


    // Konfigurasi default aplikasi
    defaultConfig {
        applicationId = "com.example.retrofitapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        // Runner untuk tes instrumentasi
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    // Konfigurasi jenis build
    buildTypes {
        release {
            isMinifyEnabled = false  // Tidak melakukan minifikasi kode pada release build
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // Konfigurasi opsi kompilasi
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    // Konfigurasi Kotlin
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

// Dependencies atau dependensi yang digunakan dalam proyek
dependencies {

    // AndroidX library untuk Kotlin
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Library untuk pengujian
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Library Retrofit untuk komunikasi dengan API
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Library Glide untuk memuat gambar
    implementation("com.github.bumptech.glide:glide:4.15.1")

    implementation ("com.github.bumptech.glide:glide:4.12.0")

}
