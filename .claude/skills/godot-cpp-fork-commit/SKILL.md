---
name: godot-cpp-fork-commit
description: Add a commit to Godot-JVM's godot-cpp fork (utopia-rise/godot-cpp, branch godot-jvm) and keep the submodule and the fork's divergence log in sync. Use whenever godot-cpp itself must change.
---

# Commit to the godot-cpp fork

The `godot-cpp` submodule tracks `utopia-rise/godot-cpp`, branch `godot-jvm`: not upstream `godotengine/godot-cpp`, and not the fork's `master`. The branch adapts godot-cpp's generated bindings to Godot-JVM's object-tracking model; it is not a collection of upstream fixes.

1. **Commit in the submodule,** on `godot-jvm`, and in the same commit append an entry to the fork's `godot-cpp-divergence.md`: what the change does and why Godot-JVM needs it. Add the commit hash to the entry with an amend once it is known, or in the next fork commit.
2. **Push** to `utopia-rise/godot-cpp`, branch `godot-jvm`. This is an outward action: confirm with the maintainer first.
3. **Update the pointer** in this repository: `git -C godot-cpp checkout <new commit>`, then `git add godot-cpp`, committed with the change that needs it.
4. **Re-read** the "godot-cpp fork" section of the root `CLAUDE.md` and `docs/src/doc/contribute/godot-cpp-fork.md`; update them if the branch moved onto a newer upstream tag.

Then rebuild the native library (`check-cpp` skill): godot-cpp changes affect every target.
