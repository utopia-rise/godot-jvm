---
description: Godot-JVM tracks a fork of godot-cpp on a dedicated branch to customize generated-binding behavior for its own object-tracking model, and the four steps to keep it in sync.
---

# The godot-cpp fork

Godot-JVM vendors [`godot-cpp`](https://github.com/godotengine/godot-cpp) as a git submodule, but
the submodule does not point at upstream `godotengine/godot-cpp`. It points at
[`utopia-rise/godot-cpp`](https://github.com/utopia-rise/godot-cpp), on the `godot-jvm` branch —
not that fork's `master` branch either.

## Why a fork

The `godot-jvm` branch exists to customize how godot-cpp generates and behaves for Godot-JVM's own
needs — not to carry bug fixes for upstream. Godot-JVM tracks its own object bindings (see
[How it works](how-it-works/index.md)), and some parts of godot-cpp's default generated behavior
don't fit that model as-is, so the branch changes them deliberately.

For the current list of changes on the branch — commit hashes and what each one changes and why —
see [`godot-cpp-divergence.md`](https://github.com/utopia-rise/godot-jvm/blob/master/godot-cpp-divergence.md)
at the repository root.

## Keeping the fork in sync

Whenever a commit is added to the `godot-jvm` branch of `utopia-rise/godot-cpp`, do all four of
the following:

1. **Push the commit** to `utopia-rise/godot-cpp` on the `godot-jvm` branch.
2. **Update the submodule pointer** in this repository: check out the new commit inside the
   `godot-cpp` submodule directory, then `git add godot-cpp` in the main repository.
3. **Log the change** by appending an entry to `godot-cpp-divergence.md`, with the commit hash and
   a brief explanation of what it does and why it was needed.
4. **Re-read the relevant section of `CLAUDE.md`** and update it if it has drifted — for example,
   if the branch is ever rebased onto a newer upstream Godot tag, that tag name needs updating
   there too.

Skipping any of these steps leaves the submodule pointer, the divergence log, or the project's own
contributor guidance out of sync with what is actually checked out.
