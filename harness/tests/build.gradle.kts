
plugins {
    kotlin("jvm") version "1.5.10"
    application
    id("com.utopia-rise.godot-kotlin-jvm")
}

repositories {
    mavenCentral()
}

godot {
    //uncomment to test android
//    isAndroidExportEnabled.set(true)
//    dxToolPath.set("${System.getenv("ANDROID_SDK_ROOT")}/build-tools/30.0.3/dx")
}

application {
    mainClass.set("godot.GraalFakeMainKt")
    mainClassName = "godot.GraalFakeMainKt"
}

dependencies {
    implementation("joda-time:joda-time:2.10.6") //external dependency to test dependency inclusion in dummyCompilation
}


kotlin.sourceSets.main {
    kotlin.srcDirs("scripts")
}
