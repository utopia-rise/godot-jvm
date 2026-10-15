# Spec format

The grammar `check_specs.py` enforces, with the conventions it does not. Start a spec from [_template.md](_template.md).

## Spec files

A spec lives in `<Letter>-<slug>/<Letter>.<NNN>-<slug>.md`, where `NNN` is the spec number padded to three digits for sorting (`A.002-script-members.md` holds `A.2`). A slug is lowercase ASCII words joined by `-`.

```markdown
# A.2: Script members                                  <- line 1: "# <SpecID>: <Title>"

A script exposes functions, properties and signals     <- the lead: first paragraph is the summary
to Godot, under the names a Godot user expects.

What Godot sees of a script (A.1) is its members ...   <- context: why it exists, what it is not

How the Inspector shows properties is A.3, ...         <- references to related specs and categories

## Capabilities                                        <- required
- **A.2.1**: Scripts expose functions that the engine, the editor and scripts in other languages can call.

## Rules                                               <- optional
- **A.2.R1**: Exposed member names follow Godot's `snake_case` convention.
  - Except: <cases the rule does not cover>
  - Why: <rationale, when the lead does not give it>

## Non-goals                                           <- optional
- **A.2.N1**: <what Godot-JVM deliberately does not offer>
  - Why: <the decision>
  - Reopen if: <the condition that would change it>
```

- **Structure:** the title, the lead, then `## Capabilities`, `## Rules` and `## Non-goals` in this order. No other heading; fenced code only in the lead.
- **Lead:** at least one block. Its first block is a paragraph (not starting with `-`, `*`, `#`, `>`, a number and `.`, or a fence): the summary, which `--summary` prints. Keep the summary to one or two sentences and the context to at most two more paragraphs: why the concept exists, what it deliberately is not, where related concepts live. How something is built belongs in the code.
- **Items:** one line each, `- **<ID>**: <text>`, IDs unique and ascending within a section. Sub-items are indented by two or more spaces (no tabs), each at most once, in the order shown. Rules take `Except:` and `Why:`, both optional; non-goals require `Why:` and may add `Reopen if:`. Capabilities have no sub-items.
- **References:** cite related items by ID (`B.6`, `A.2.R1`, `§4`) and categories as `category C`, never a bare letter. Every reference must resolve to a live item.

## Capabilities

One active-voice, present-tense sentence whose subject names who or what acts: "Scripts expose …", "Game code frees …", "A player runs …". Name the actor when it is not the game developer. Add "so that <benefit>" only when the benefit is not obvious and does not restate §2 or §3. The sentence becomes true when the capability is `done`. No acceptance criteria.

## Rules

One sentence that always or never holds. `Except:` lists cases, never modality: a weakening such as "best effort" or "where possible" goes into `Why:`.

## Non-goals

A deliberate decision not to offer something that could reasonably be wanted, as a present-tense negative statement. A negated invariant ("never crashes") is a rule, not a non-goal.

- `Why:` states the decision, not a claim about the state of the industry.
- A non-goal never relaxes a rule and never contradicts a capability of the same spec.
- A non-goal that narrows an article is legal only when it falls under that article's `Except:`, and it cites the article.
- Non-goals are not tracked while they live; a deleted one leaves an `abandoned` tracker line.

## Constitution

```markdown
# Constitution

<preamble: paragraphs only>

## §4: Kotlin, Java and Scala are equal in capability
- Every capability offered to scripts in one of Kotlin, Java or Scala is offered to the other two.
  - Except: a capability built on a Kotlin-only language feature, such as coroutines.
  - Why: <rationale>
```

- The constitution holds articles only. Each is a `## §<n>: <Title>` heading (numbers unique and ascending) followed by exactly one rule bullet without ID and its sub-items, with the rule grammar; `Why:` is required.
- The bar for an article is high: a global rule that shapes many specs. A rule only one theme cares about is a spec rule.
- Adding, changing or deleting an article needs the maintainer's approval.

## Categories

Each `<Letter>-<slug>/` directory holds a `_category.md`: line 1 is `# <Letter>: <Title>`, followed by a scope paragraph.
