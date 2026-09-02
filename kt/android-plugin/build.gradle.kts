plugins {
    alias(libs.plugins.kotlin.jvm)
}

kotlin {
    jvmToolchain(17)
}

val godotVersion = "${libs.versions.godot.get()}.stable"
val nativeLibrariesDir = providers.gradleProperty("nativeLibrariesDir")
    .map(::file)
    .orElse(file("../../build/android"))

val godotAndroid by configurations.creating

dependencies {
    godotAndroid("org.godotengine:godot:$godotVersion@aar")
    compileOnly(files(layout.buildDirectory.file("godot-android/classes.jar")))
}

val extractGodotAndroid by tasks.registering(Sync::class) {
    from({ godotAndroid.map(::zipTree) })
    include("classes.jar")
    into(layout.buildDirectory.dir("godot-android"))
}

tasks.compileKotlin {
    dependsOn(extractGodotAndroid)
}

tasks.jar {
    archiveFileName = "classes.jar"
    destinationDirectory = layout.buildDirectory.dir("android-plugin")
}

fun registerAar(variant: String) = tasks.register<Zip>("package${variant.replaceFirstChar(Char::uppercase)}Aar") {
    val nativeVariantDir = nativeLibrariesDir.map { it.resolve(variant) }
    val supportedAbis = listOf("arm64-v8a", "x86_64")
    val requiredLibraries = supportedAbis.map { abi ->
        nativeVariantDir.map { it.resolve("$abi/libgodot_jvm.so") }
    }

    dependsOn(tasks.jar)
    inputs.files(requiredLibraries)

    from("src/main/AndroidManifest.xml")
    from("src/main/proguard-rules.pro") {
        rename { "proguard.txt" }
    }
    from(tasks.jar)
    from("../../harness/tests/addons/jvm/jvm.gdextension") {
        into("assets/addons/jvm")
    }
    requiredLibraries.zip(supportedAbis).forEach { (library, abi) ->
        from(library) {
            into("jni/$abi")
        }
    }

    doFirst {
        requiredLibraries.forEach { library ->
            check(library.get().isFile) { "Missing Android native library: ${library.get()}" }
        }
    }

    archiveFileName = "godot-jvm-$variant.aar"
    destinationDirectory = layout.buildDirectory.dir("outputs/aar")
}

val packageDebugAar = registerAar("debug")
val packageReleaseAar = registerAar("release")

tasks.assemble {
    dependsOn(packageDebugAar, packageReleaseAar)
}
