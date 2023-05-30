object Versions {
    const val material = "1.8.0"
    const val recyclerview = "1.2.1"
    const val constraintLayout = "2.1.4"
    const val coroutines = "1.6.4"
    const val coil = "2.2.2"
    const val navigationVersion = "2.5.3"
    const val coreKtxVersion = "1.9.0"
    const val lifecycle = "2.5.1"
    const val hilt = "2.45"
    const val retrofit = "2.9.0"
    const val okhttp = "4.10.0"
    const val moshiVersion = "1.14.0"
    const val room = "2.4.3"
    const val appCompat = "1.6.1"
    const val junit = "4.13.2"
    const val extJunit = "1.1.5"
    const val espresso = "3.5.1"
    const val turbine = "0.12.1"
    const val mockk = "1.13.4"
}

object Libraries {

    //Core
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    
    // Ui
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"

    // Lifecycle
    const val lifecycleViewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleViewModelSaveState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:1.0.0-alpha02"


    // Navigation
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUiKtx =
        "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"

    // Coroutines
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // Coil
    const val coil = "io.coil-kt:coil:${Versions.coil}"

    //hilt
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"

    //network
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConvertor = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    //moshi
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshiVersion}"

    //room
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    // Test
    const val junitTest = "junit:junit:${Versions.junit}"
    const val kotlinCoroutinesTest =  "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val mockWebServerTest = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"
    const val mockkTest = "io.mockk:mockk:${Versions.mockk}"
    const val turbineTest = "app.cash.turbine:turbine:${Versions.turbine}"

    // Android Test
    const val junitAndroidTest = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espressoAndroidTest = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val kotlinCoroutinesAndroidTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val mockkAndroidTest = "io.mockk:mockk:${Versions.mockk}"
    const val mockkAndroidAndroidTest = "io.mockk:mockk-android:${Versions.mockk}"
    const val turbineAndroidTest = "app.cash.turbine:turbine:${Versions.turbine}"
   }

object AnnotationProcessors {
    const val room = "androidx.room:room-compiler:${Versions.room}"
    const val hilt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val moshiConvertor = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}"
}