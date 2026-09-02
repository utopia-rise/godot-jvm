---
description: Creating the per-platform embedded JRE required for desktop exports, including optional modules and the generateEmbeddedJre Gradle task.
---

# Desktop

To export your game, create an embedded JRE from your project's root:

```shell
./gradlew generateEmbeddedJre
```

The task generates a JRE for the current host OS. Use it for the normal case. If you need a custom JRE or need to prepare platform-specific output manually, use `jlink` instead:

- amd64 systems:
    ```shell
    jlink --add-modules java.base,java.logging --output jvm/jre-amd64-linux
    ```
- arm64 systems:
    ```shell
    jlink --add-modules java.base,java.logging --output jvm/jre-arm64-macos
    ```

!!! info
    As the jre is platform dependent, you need to create a jre for each platform. Adjust the above command on a per-platform basis:    
    - For Linux: `jvm/jre-amd64-linux`  
    - For Windows: `jvm/jre-amd64-windows`    
    - For MacOS:  
        - `jvm/jre-amd64-macos`  
        - `jvm/jre-arm64-macos`    
    - For iOS and Android, no embedded JRE is needed

The above command will create a very minimal JVM, if you need extra features you can include the following modules:

- `jdk.jdwp.agent` to enable remote debugging
- `jdk.management.agent` to enable JMX.

*Special note for MacOS*: To create a universal app, you'll need both amd64 and arm64 JRE. You can create an amd64 JRE
by using `jlink` with rosetta and an amd64 JDK on an arm64 MacOS.

!!! warning "Correct JRE for desktops"
    For desktop exports you need to make exports based on the platform you're on, as exporting will copy the generated jre folder to
    your export. An MacOS JRE will not work on Windows, so you'll need a Windows host to export for Windows.

The Gradle task can be configured like so:
```kotlin
tasks.withType<GenerateEmbeddedJreTask> {
    // the values in this example are the default values of the task
    // defaults to JAVA_HOME, falling back to the JVM running Gradle. Must point to a JDK (jlink is required).
    this.javaHome = System.getenv("JAVA_HOME")
    this.arguments = arrayOf(
        "--strip-debug",
        "--no-header-files",
        "--no-man-pages",
    ) // arguments to pass to the jlink command
    this.modules = arrayOf(
        "java.base",
        "java.logging",
    ) // java module to include in the jre
}
```
