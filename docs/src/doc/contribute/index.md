---
description: Where Godot-JVM contributors discuss work, how issues get claimed, the Code Owners model, and the Kotlin and C++ style rules enforced in this repo.
---

# Contributing

Contributions are welcome, from documentation fixes to binding improvements. You don't need to know the whole codebase to get started; discuss the change in an issue and we can help you find the relevant code.

## How to Build

- [Build from source](build-from-source.md): compile the native extension and Kotlin/Gradle side yourself.
- [Build for Android](build-for-android.md): cross-compile the native library for every Android ABI.
- [Run the tests](running-tests.md): the Kotlin unit tests and the gdUnit4-based integration harness.
- [Test a change from a branch](test-a-branch.md): try an unreleased branch from a real Godot-JVM project.
- [The godot-cpp fork](godot-cpp-fork.md): why Godot-JVM tracks a fork of godot-cpp, and how to keep it in sync.
- [Update the iOS JDK](update-ios-jdk.md): moving Godot-JVM to a newer iOS JDK.

## How it works

- [Where to start](how-it-works/index.md): the engineering reasoning behind Godot-JVM's internals.

## Discussions

Discuss changes in the relevant GitHub issue or on [Discord](https://discord.gg/zpb5Ru7v9x). If a decision is made on Discord, record it in the issue so everyone can follow the outcome.

Keep feedback specific and respectful. Contributors have different backgrounds and levels of English fluency; ask for clarification when a comment's intent is unclear.

## Code ownership

GitHub Code Owners identifies the maintainers responsible for each part of the codebase. They review changes in their areas. Code without a specific owner falls to the maintainer team.

## Before contributing

Coordinate work through issues before starting a substantial change:

- Search for an existing issue describing the bug or feature.
- If someone is assigned, ask whether they need help or share your findings.
- If the issue is unassigned, comment that you'd like to work on it so a maintainer can assign it to you.
- If no issue exists, open one using the relevant template and describe the problem or proposed change.

## Code style

Follow Kotlin's official [coding conventions](https://kotlinlang.org/docs/reference/coding-conventions.html) and configure your IDE accordingly.

For C++, use the repository's `.clang-format` and `.clang-tidy` settings. They define formatting and a focused set of static checks. Configure your editor to use them, or run the tools from the repository root.

## Branching

The project follows the `git-flow` branching model.
