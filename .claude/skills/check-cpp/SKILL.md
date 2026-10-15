---
name: check-cpp
description: Verify a C++ change before committing - clang-format the touched files and build the editor, template_debug and template_release targets, which compile different #ifdef branches. Use after any edit under cpp/.
---

# Check a C++ change

1. **Format.** Run `clang-format -i` (version 20 or newer; the repo's `.clang-format` uses recent options) on every `.cpp`, `.h` and `.mm` you touched under `cpp/`. Never format `cpp/editor/project/templates.h`, which is generated and carries `// clang-format off`.
   ```bash
   git diff --name-only HEAD -- 'cpp/*.cpp' 'cpp/*.h' 'cpp/*.mm' | grep -v templates.h | xargs clang-format -i
   ```
2. **Build the three targets** for the host platform, in this order, each one to completion:
   ```bash
   scons platform=<host> target=editor -j<cores>
   scons platform=<host> target=template_debug -j<cores>
   scons platform=<host> target=template_release -j<cores>
   ```
   `TOOLS_ENABLED` and `DEBUG_ENABLED` code only compiles in some of them, so an include or a symbol missing from one branch only shows in that target.
3. **Review against the rules** in the root `CLAUDE.md` (Engineering Principles, General and C++): includes are exactly what the file uses, no anonymous namespaces, the `godot`/`engine` namespace conventions, the initialization style, no comment that restates the code.

Report each target's result. A warning introduced by the change counts as a problem to fix.
