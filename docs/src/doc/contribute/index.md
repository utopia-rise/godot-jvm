---
description: Where Godot-JVM contributors discuss work, how issues get claimed, the Code Owners model, and the Kotlin and C++ style rules enforced in this repo.
---

# Contributing

We encourage you to contribute to the project if you want. Even if you don't have any idea how
the project works or if it seems overwhelming at first, we're here to help you getting started.

## In this section

- [Build from source](build-from-source.md) — compile the native extension and Kotlin/Gradle side yourself.
- [Build for Android](build-for-android.md) — cross-compile the native library for every Android ABI.
- [Run the tests](running-tests.md) — the Kotlin unit tests and the GUT-based integration harness.
- [Test a change from a branch](test-a-branch.md) — try an unreleased branch from a real Godot-JVM project.
- [The godot-cpp fork](godot-cpp-fork.md) — why Godot-JVM tracks a fork of godot-cpp, and how to keep it in sync.
- [Update the iOS JDK](update-ios-jdk.md) — moving Godot-JVM to a newer iOS JDK.
- [How it works](how-it-works/index.md) — the engineering reasoning behind Godot-JVM's internals.

## Keywords

The following keywords are used throughout the contribution documentation:

- `godot-root`: root dir in which the godot engine is cloned into
- `project-dir`: repository root

## Discussions

Most of our discussions are happening on Discord. So, if you have Discord or don't mind starting using it,
feel free to [join](https://discord.gg/zpb5Ru7v9x) our server. But don't worry if you don't have or want to use Discord.
Then the discussions are just in the corresponding issue. If you discuss on Discord though: don't forget to document all
relevant outcome in the corresponding issue.

If you have critique or an opinion on a discussed topic, please be kind and give valuable feedback. If you are on the
receiving end of the critique: don't take it personally. Many people are no native english speaker and it can happen that
something which is not rude at all in the language of the writer, might sound rude in english.

## Code ownership

We are working with the Code Owners feature of GitHub. This means each piece of code in this project has a maintainer who
is the "Owner" of said code.
This maintainer is usually the one who implemented it or has the most knowledge about that particular part of the project.
General code may not have a specific "Owner". In this case the fallback is: all Maintainers.

## Before contributing

Before you start to invest your precious time in writing code that you want to contribute, consider following these guidelines.
They are here to make the lives of all people involved easier.

- If you have an idea or a bug you want to fix, first look if an issue already exists that describes this Feature/Bug.
- If such a issue exists, and a person is already assigned, it means the assigned person is working on it. But don't go away yet! Maybe this person could need your help, or you have some valuable input for the topic.
- If the issue exists, but no one is assigned. You are free to state your interest in implementing/fixing the issue. But don't just start working. To prevent multiple people working on the same issue, we need to know you're working on it. Write in the issue, so we can assign it to you.
- If the issue does not yet exist, open one and describe as best as you can, what your idea/what the bug is you want to tackle. The provided templates are a good starting point.

## Code style

We enforce the code style to match the official Kotlin [coding conventions](https://kotlinlang.org/docs/reference/coding-conventions.html).
Read there on how to set those up for your IDE. We will enforce this later on through CI and linting.

For the native side, the repository root ships a `.clang-format` and a `.clang-tidy` file. `.clang-format` is an LLVM-based
style adjusted for this codebase, and `.clang-tidy` enables a small set of `clang-analyzer`, `cppcoreguidelines`,
`modernize`, and `readability` checks. Point your IDE or editor at those files, or run `clang-format` and `clang-tidy`
from the repository root, so C++ changes in `cpp/` come out consistent with the surrounding code.

## Branching

We do branching like described in `git-flow`.
