import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


class CommonModulePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        //    apply commonPlugin to all project
        project.plugins.apply(BuildPlugins.ANDROID_LIBRARY)
        project.plugins.apply(BuildPlugins.KOTLIN_ANDROID)
        project.plugins.apply(BuildPlugins.MAVEN_PUBLISH)
        project.plugins.apply(BuildPlugins.KOTLIN_KAPT)

        //configure the android block
        val androidExtensions = project.extensions.getByName("android")
        if (androidExtensions is BaseExtension) {
            androidExtensions.apply {

                compileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION)
                buildToolsVersion(BuildAndroidConfig.BUILD_TOOLS_VERSION)
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_11
                    targetCompatibility = JavaVersion.VERSION_11
                }
                project.tasks.withType(KotlinCompile::class.java).configureEach {
                    kotlinOptions {
                        jvmTarget = JavaVersion.VERSION_11.toString()
                        freeCompilerArgs = listOf("-Xjvm-default=all")

                    }
                }
                defaultConfig {
                    minSdk = BuildAndroidConfig.MIN_SDK_VERSION
                    targetSdk = BuildAndroidConfig.TARGET_SDK_VERSION
                    versionCode = generateVersionCode()
                    versionName = generateVersionName()
                    vectorDrawables.useSupportLibrary =
                        BuildAndroidConfig.SUPPORT_LIBRARY_VECTOR_DRAWABLES
                    testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
                    consumerProguardFiles("proguard-rules.pro")

                }
            }
            // dependencies common to all projects
            with(project) {
                dependencies {
                    add("implementation", "androidx.core:core-ktx:1.7.0")
                    add("implementation","androidx.appcompat:appcompat:1.6.1")
                }

            }

        }
    }
}

