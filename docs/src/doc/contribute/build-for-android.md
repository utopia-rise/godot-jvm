---
description: Building the Godot-JVM native library for every Android ABI and packaging it into the debug and release Godot Android v2 plugin AARs.
---

# Build for Android

Android uses a Godot Android v2 plugin AAR because a GDExtension cannot access Godot's engine-internal JNI helpers. The Java plugin loads the native library and passes Android's existing `JavaVM` to the extension.

Install the Android SDK and NDK, then set `ANDROID_HOME` or `ANDROID_NDK_ROOT`. The two build systems read different
variables, so set all three if you run both: the SCons build resolves the SDK from `ANDROID_HOME` (falling back to
`ANDROID_SDK_ROOT`) and the NDK from `ANDROID_HOME/ndk/<ndk_version>` or `ANDROID_NDK_ROOT`, while the Gradle plugin's
Android export tasks locate `d8` and the compile SDK through `ANDROID_SDK_ROOT`.

Build both targets for every supported ABI:

```bash
scons platform=android target=template_debug arch=arm64
scons platform=android target=template_release arch=arm64
scons platform=android target=template_debug arch=x86_64
scons platform=android target=template_release arch=x86_64
```

The libraries are written under `build/android/<debug|release>/<android-abi>`. Package them into the debug and release AARs with:

```bash
./kt/gradlew -p kt :android-plugin:assemble
```

The AARs are written to `kt/android-plugin/build/outputs/aar`. For a device test, copy them to `harness/tests/addons/jvm/libs/android/debug` and `harness/tests/addons/jvm/libs/android/release`, install Godot's Android build template, and enable **Use Gradle Build** in the export preset.

The harness has a `tests_android` export preset. After placing the debug AAR in the addon and installing the Android build template, export it with `./gradlew -p harness/tests exportAndroidDebug`, then install `harness/tests/export/tests.apk` on an emulator or device. The exported test runner reports `GODOT_JVM_TEST_RESULT:PASS` or `FAIL` to logcat.
