# C.4: JVM status in the editor

The editor shows whether the JVM side is running and ready, and says what to do when it is not.

The JVM side of a project starts in steps: a JVM must be found, the Godot-JVM runtime loaded, then the user code. When one step fails or a file changes in a way that needs a restart, the user must see it in the editor and know the next action, instead of discovering it when a script does not work.

The version rule between the addon and the JVM libraries is D.5.

## Capabilities
- **C.4.1**: The editor shows at a glance whether the JVM is running and the code is loaded, and which step is missing when it is not.
- **C.4.2**: The editor tells why the JVM side could not start and how to fix it, for example a missing build or a version mismatch between the addon and the build, so that game developers solve it without reading native logs.
- **C.4.3**: The editor tells when a change, such as a new addon or a new runtime archive, takes effect only after restarting the editor, so that outdated Godot-JVM code never runs unnoticed.

## Rules
- **C.4.R1**: An editor opened on a project that was never built shows no error, only that user code is not loaded.
