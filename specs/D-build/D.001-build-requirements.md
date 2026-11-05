# D.1: Build requirements

What a user project needs before it can be built: a JDK 17 and nothing else to configure.

Every requirement on the user's machine or in their build script is a reason not to try Godot-JVM, or to stay on an old version of it. The floor is kept low and the defaults complete.

## Capabilities
- **D.1.1**: Game developers build their project with JDK 17, without being forced onto a newer JDK.
- **D.1.2**: A new project builds without any configuration.

## Rules
- **D.1.R1**: Nothing Godot-JVM ships into a user project requires a JDK newer than 17.
- **D.1.R2**: Every setting is optional, and the defaults produce a working project.
- **D.1.R3**: A JDK or compiler version below Godot-JVM's minimum is rejected when the build is configured, with a message naming the setting and the minimum.
