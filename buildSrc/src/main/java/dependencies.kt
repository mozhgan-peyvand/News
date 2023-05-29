object Versions {
    const val material = "1.8.0"
    const val recyclerview = "1.2.1"
    const val constraintLayout = "2.1.4"
    const val coroutines = "1.6.4"
    const val coil = "2.2.2"
    const val extJunit = "1.1.5"
    const val espresso = "3.5.1"
    const val turbine = "0.12.1"
    const val mockk = "1.13.4"
    const val navigationVersion = "2.5.3"
    const val coreKtxVersion = "1.9.0"
    const val lifecycleRtKtxVersion = "2.5.1"
    const val lifecycleExtensions = "2.2.0"
    const val lifecycle = "2.5.1"
    const val junit = "4.13.2"
    const val testExtJunit = "1.1.5"
    const val testEspresso = "3.5.1"
    const val accompanist = "0.27.0"
    const val hilt = "2.45"
    const val hiltCompiler = "2.43.2"
    const val retrofit = "2.9.0"
    const val okhttp = "4.10.0"
    const val moshiVersion = "1.14.0"
    const val room = "2.4.3"
    const val appCompat = "1.6.1"
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
    const val navigationRuntime = "androidx.navigation:navigation-runtime-ktx:${Versions.navigationVersion}"
    const val navigationCommonKtx = "androidx.navigation:navigation-common-ktx:${Versions.navigationVersion}"

    // Coroutines
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // Coil
    const val coil = "io.coil-kt:coil:${Versions.coil}"

    // Test
    const val junitTest = "junit:junit:${Versions.junit}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val turbine = "app.cash.turbine:turbine:${Versions.turbine}"

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

    //test
    const val junit = "junit:junit:${Versions.junit}"
    const val testExtJunit = "androidx.test.ext:junit:${Versions.testExtJunit}"
    const val testEspresso = "androidx.test.espresso:espresso-core:${Versions.testEspresso}"
}

object AnnotationProcessors {
    const val room = "androidx.room:room-compiler:${Versions.room}"
    const val hilt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val moshiConvertor = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}"
}