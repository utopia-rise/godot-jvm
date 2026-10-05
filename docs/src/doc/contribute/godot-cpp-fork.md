---
description: Why Godot-JVM tracks a fork of godot-cpp on a dedicated branch, and the three steps that keep the submodule and divergence log in sync.
---

# The godot-cpp fork

The `godot-cpp` submodule tracks the `godot-jvm` branch of [utopia-rise/godot-cpp](https://github.com/utopia-rise/godot-cpp). Use this branch when making changes for Godot-JVM.

## Why a fork

Godot-JVM manages its own object bindings. The fork adapts godot-cpp's generated behavior to that ownership model. The later internals chapters explain the object lifecycle in detail.

For the current list of changes on the branch, including commit hashes and what each one changes and why,
see [`godot-cpp-divergence.md`](https://github.com/utopia-rise/godot-cpp/blob/godot-jvm/godot-cpp-divergence.md)
at the root of the fork.

## Keeping the fork in sync

Whenever a commit is added to the `godot-jvm` branch of `utopia-rise/godot-cpp`, do all three of
the following:

1. **Push the commit** to `utopia-rise/godot-cpp` on the `godot-jvm` branch.
2. **Update the submodule pointer** in this repository: check out the new commit inside the
   `godot-cpp` submodule directory, then `git add godot-cpp` in the main repository.
3. **Log the change** by appending an entry to the fork's `godot-cpp-divergence.md`, in the same
   fork commit, with the commit hash and a brief explanation of what it does and why it was needed.
   The log lives in the fork so that it travels with the commits it describes.
