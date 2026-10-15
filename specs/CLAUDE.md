# Specs

This directory is the guidance of the project: what Godot-JVM offers its users, the rules every implementation follows, and what it deliberately does not do.

- Writing or editing a spec or the constitution: read [FORMAT.md](FORMAT.md).
- IDs, statuses, hashes, adding or dropping items: read [TRACKER.md](TRACKER.md).

## Principles

- **A spec is the target the code aims at.** It describes the current intended state of the product; nothing dead appears in a spec file. Specs change in the same change as the code. When code and spec disagree, either the tracker says the work is not done yet (`todo`, `partial`), or the spec is outdated and gets updated in that change. The record of what changed is the git history of `specs/`; the tracker keeps only the IDs of deleted items, so they are never reused.
- **A spec states a lasting concept of the product, in the present tense:** capabilities that hold for users, rules that always or never hold, and non-goals (what is deliberately not offered, and why). Details stay in the code: a helper, an option or a small convenience needs no spec.
- **A capability describes the product only when the tracker says `done`.** Check `python specs/check_specs.py --summary <ID>` before relying on one. Specs are never quoted as user documentation.
- **Scope:** Godot-JVM as its users meet it: the extension, its runtime libraries and its tooling. Releases, CI, documentation and contributing are out of scope. Benchmarks (F.5) are the exception: they back F.1's performance claims.
- **Usual actors** in capability sentences: game developer (implied when no actor is named), player, app developer (embeds Godot in an Android app), library author.
- **Spec IDs appear only in `specs/` and in commit messages**, never in code, comments, docs or CI files, so the checker resolves every in-repo reference.

## Layout

```
specs/
├── CLAUDE.md          this file
├── FORMAT.md          grammar of specs, the constitution, _category.md and the template
├── TRACKER.md         IDs, tracker syntax, statuses, notes, hashes, commands
├── CONSTITUTION.md    global rules
├── tracker.toml       statuses, dead IDs and file hashes
├── check_specs.py     validator and tools (Python 3.11+, no dependency)
├── _template.md       starting point for a spec
└── <Letter>-<slug>/   one directory per category
    ├── _category.md
    └── <Letter>.<NNN>-<slug>.md   e.g. A.002-script-members.md
```

## Everyday sequences

| Task | Steps | Files |
|---|---|---|
| Implement a `todo` capability | implement; set its status to `done` (or `partial` with a note); run the checker | code, tracker.toml |
| Fix a typo in a lead or heading | edit; run the checker | spec |
| Reword a capability, rule or non-goal (same or new intent) | edit the line in place; run the checker (hash fails); re-judge the capability statuses it affects; `--accept <SpecID>` | spec, tracker.toml |
| Add a capability | `--next <SpecID>`; add the line; `--fix` (adds `todo`); `--accept <SpecID>` | spec, tracker.toml |
| Add a rule or non-goal | `--next <SpecID>.R` or `.N`; add the line; re-judge statuses the rule affects; `--accept <SpecID>` | spec, tracker.toml |
| Drop a capability | delete its line; set its entry to `abandoned` (optional note); optionally add a non-goal (`--next <SpecID>.N`); `--accept <SpecID>` | spec, tracker.toml |
| Drop a rule or non-goal | delete its line; add `"<ID>" = { status = "abandoned" }`; re-judge statuses that relied on it; `--accept <SpecID>` | spec, tracker.toml |
| Merge parallel branches | resolve the spec; resolve the hash line by taking either side; run the checker; review; `--accept <SpecID>` | spec, tracker.toml |

Commands are `python specs/check_specs.py [--summary [PREFIX] | --fix | --accept <ID>... | --next <target>]`.

## Working rules

- Read the relevant specs, non-goals included, before implementing or changing a feature, and the constitution before any technical choice.
- Spec text, tracker statuses and hashes change in the same change as the code they concern.
- Claude may create, reword and delete specs, capabilities, rules and non-goals, and change statuses. For CONSTITUTION.md, Claude drafts the change and edits the file only when the maintainer asked for it or approved it in chat.
- Do not propose or implement what a non-goal excludes unless its `Reopen if:` holds; raise it with the maintainer instead.
- When two articles pull in different directions, ask the maintainer.
- Run the checker after every edit under `specs/`. CI runs it on every pull request.
- Before committing a change to `cpp/` or `kt/`, or opening a pull request, run `/spec-review`: it checks the change against the specs, which the checker cannot do.
