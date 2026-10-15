# IDs and tracker

`tracker.toml` records the status of every live capability, the IDs of deleted items, and the reviewed hash of every spec file. `check_specs.py` holds the exact checks and the `STATUSES` table.

## IDs

| Item | ID | Defined by |
|---|---|---|
| Article | `§4` | `## §4: …` heading in CONSTITUTION.md |
| Category | `A` | directory name |
| Spec | `A.2` | file name and `#` title |
| Capability | `A.2.9` | `## Capabilities` line |
| Spec rule | `A.2.R1` | `## Rules` line |
| Non-goal | `A.2.N1` | `## Non-goals` line |

- **Never reused, always incremented.** A new item takes the highest number ever seen for its parent and kind, in the files or as any tracker key, plus 1: `check_specs.py --next <target>` prints it. Gaps left by deleted items are normal.
- **A change of intent rewords the item in place** and keeps its ID; the spec's hash then forces a status review.

## Adding, changing and dropping

| Situation | Spec files | tracker.toml |
|---|---|---|
| New capability | add the line with `--next <SpecID>` | `--fix` adds `todo` |
| New rule or non-goal | add the line with `--next <SpecID>.R` or `.N` | — |
| Any edit to an item line or sub-item | — | review the statuses of that spec's capabilities, add `abandoned` lines for every ID the change deleted, then `--accept <SpecID>` |
| Edit to the lead or a heading only | — | nothing: the hash does not cover them |
| Capability dropped | delete its line; add a non-goal if the reason matters | its entry becomes `{ status = "abandoned" }`, optional note |
| Rule or non-goal dropped | delete its line | add `"<ID>" = { status = "abandoned" }` |
| Non-goal now wanted | delete it, add a capability with a new ID | the non-goal becomes `abandoned`; `--fix` adds the capability |
| Spec dropped | delete the file; add one non-goal to the closest spec if the reason matters | its hash line becomes `{ status = "abandoned" }`; delete every other line under that spec |
| Category dropped | delete its directory | add `"<Letter>" = { status = "abandoned" }`; delete every line under that letter |
| Article added, changed or dropped | only with the maintainer's approval | dropped: add `"§<n>" = { status = "abandoned" }`; always: review affected statuses, then `--accept §` |
| A rule or article is broken by the code | — | mark the closest capability `partial` with `breaks <ID>: …`; if none fits, the spec lacks a capability: add it |

- Deleting an item that something still cites fails the reference check: fix the citations in the same change.
- The children of a deleted spec or category need no lines: the parent's ID is never reused, so theirs cannot come back.
- A capability added for a broken rule names something a user does that the rule protects ("Game code upgrades Godot-JVM within a major version without changes"), never the rule restated.
- **Accepted gap:** the checker cannot see a deleted rule, non-goal or article. `--accept` is the moment to add an `abandoned` line for every ID the change deleted; it lists the differences between file and tracker to help. A forgotten line lets `--next` hand that ID out again if it was the highest of its kind.
- **Parallel branches** editing the same spec conflict on its hash line: merge the spec, keep either hash, review, then `--accept` again. After any merge or rebase touching `specs/`, run the checker: two branches that took the same `--next` fail the uniqueness check.

## Entries

```toml
"§" = { hash = "9c1f04aa37d2" }
"§10" = { status = "abandoned" }
"A.2" = { hash = "3fa81c0b9e44" }
"A.2.1" = { status = "partial", note = "breaks §2: at most 16 parameters" }
"A.2.11" = { status = "abandoned", note = "folded into A.2.3" }
"A.2.R5" = { status = "abandoned" }
"G" = { status = "abandoned" }
```

| Key | Fields | Meaning |
|---|---|---|
| `"§"` | `hash` | CONSTITUTION.md as last reviewed |
| `"§<n>"`, `"<Letter>"` | `status = "abandoned"` | deleted article or category |
| `"<SpecID>"` | `hash`, or `status = "abandoned"` | live spec as last reviewed, or deleted spec |
| `"<SpecID>.<n>"` | `status` (`todo`, `partial`, `done`, `abandoned`), optional `note` | capability |
| `"<SpecID>.R<n>"`, `"<SpecID>.N<n>"` | `status = "abandoned"` only | deleted rule or non-goal |

- Comment and blank lines only before the first entry; then one inline entry per line. `--fix` adds missing `todo` entries and sorts: `"§"`, articles, then by category, each spec followed by its capabilities, rules and non-goals.
- **`hash`** is the first 12 hex digits of SHA-256 over the file's item lines only (capability, rule and non-goal lines and their sub-items; for CONSTITUTION.md, the rule bullets and sub-items), with trailing whitespace stripped and sub-items re-indented to two spaces. Editing the lead or a heading never changes it. Only `--accept` writes it.

## Statuses and notes

- `todo`: the sentence is not true yet, even if some code exists.
- `partial`: true in part, or true while breaking a rule or an article; a note is required.
- `done`: the sentence is true for users on every platform it names, following every rule that applies.
- `abandoned`: the ID belonged to a deleted item and is never reused.

Rules for statuses and notes:

- **Untested and cosmetic gaps.** A path no harness test or CI job exercises is a caveat in a `done` note, not a reason for `partial`. Only a leftover a user can see makes a capability `partial`, such as wording in the editor UI or a setting name in Project Settings.
- **Broken rules.** A broken rule or article goes on the closest capability, whose note starts with `breaks <ID>[, <ID>…]: `.
- **Note length.** One sentence, no measurements, no list of more than about three items. Figures live in the benchmark READMEs, and the note names the file.
- **Reviewing a hash.** Before `--accept`, re-judge the status of every capability whose line changed, and of any capability a changed rule or article affects. A change of intent usually means `todo`.

## Commands

- `python specs/check_specs.py`: every check; problems as `path:line: message`.
- `--summary [PREFIX]`: live categories, specs, capabilities with statuses and notes, and non-goals under `PREFIX`.
- `--fix`: adds `todo` entries for new capabilities and sorts tracker.toml; never deletes, abandons or hashes.
- `--accept <SpecID|§>...`: shows the statuses and file/tracker differences, then records the current hash.
- `--next <category|Letter|SpecID|SpecID.R|SpecID.N|§>`: prints the next free ID.
