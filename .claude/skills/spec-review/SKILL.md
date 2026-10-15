---
name: spec-review
description: Review a code change against the specs in specs/ - contradicted rules, non-goals or constitution articles, capability statuses the change should move, missing capabilities, and spec/tracker updates left out. Use before committing or opening a PR, or when asked to check a change against the specs.
argument-hint: "[git range or PR number; default: uncommitted changes plus the branch's commits since master]"
---

# Spec review

Review a change against `specs/` and report what it implies. This is read-only: do not edit any file unless the user then asks for the fixes.

## Keep it in proportion

Specs are broad guidelines: what Godot-JVM should offer, what it deliberately does not, and the rules an implementation must respect. They are not an inventory of the code. Details and implementation choices live in the code, and most changes, such as a fix, a refactor, a new helper, an option or a small convenience, have nothing to do with a spec. That is the normal case, not a gap.

So report only what matters at the level of the specs: a rule or article the change breaks, a non-goal it goes against, a capability whose status it really changes, or a new capability large enough that a user would describe it as one. Never report "no spec covers this" for a trivial change or a small feature, and never suggest a spec for something a sentence in an existing spec's lead already covers in spirit. When in doubt, it is not a finding. "No spec impact" is the expected answer for most changes.

## 1. Get the change

- With an argument: a git range (`master..HEAD`, `HEAD~3..HEAD`) or a PR number (`gh pr diff <n>`).
- Without one: `git diff $(git merge-base HEAD master)` (the branch's commits) plus uncommitted changes.

Ignore pure formatting and test-only refactors; they cannot affect a spec. Spec and tracker edits inside the change are claims to verify against the code, not the baseline.

## 2. Find the specs it touches

Read `specs/CLAUDE.md`, then `specs/CONSTITUTION.md`. List the categories and specs with `python specs/check_specs.py --summary`, pick every spec whose concept the changed code serves, and read those spec files whole (lead, capabilities, rules, non-goals) with their tracker lines (`--summary <SpecID>`). When unsure whether a spec is concerned, read it.

## 3. Check

For each concerned spec, against the actual code after the change:

1. **Rules, articles, non-goals.** Does the change break a spec rule or a constitution article (taking each `Except:` into account), or implement something a non-goal excludes without its `Reopen if:` holding?
2. **Statuses.** Does it make a `todo` or `partial` capability's sentence true, or a `done` one false or true only in part? Apply the status definitions of `specs/TRACKER.md`: untested paths are a caveat, only user-visible leftovers make a capability `partial`. A capability moved to `done` needs a test that would fail without the change; otherwise say it is untested.
3. **Missing capability.** Does it add or remove a whole capability, something a user would name as a feature of Godot-JVM, that no spec states even broadly? Helpers, options, small conveniences and refinements of an existing capability are not findings.
4. **Spec edits in the change.** If `specs/` changed: does `python specs/check_specs.py` pass, were rewordings and deletions followed by `--accept`, and do deleted IDs have `abandoned` tracker lines? A rule rewording or a new `Except:` that clears a `breaks` note without any code change needs the maintainer's confirmation: flag it.
5. **IDs outside specs.** Spec IDs must not appear in code, comments, docs or CI files.
6. **Doc drift.** User docs or API docs touched by the change must not contradict a spec rule.

## 4. Report

One table, most important first:

| Kind | Spec ID | Finding | Where (file:line) | Suggested fix |
|---|---|---|---|---|

Kinds: `breaks rule`, `breaks article`, `against non-goal`, `status`, `missing capability`, `spec edit`, `ID outside specs`, `doc drift`. Suggested fixes are concrete: the tracker line to write, the capability sentence to add, or the code to change. When nothing applies, say "No spec impact" and name the specs you checked.
