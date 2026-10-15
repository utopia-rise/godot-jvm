"""Validates and maintains the specs directory. Formats: specs/FORMAT.md and specs/TRACKER.md.

Usage:
  python specs/check_specs.py                     run every check
  python specs/check_specs.py --summary [PREFIX]  live categories, specs, capabilities and non-goals
  python specs/check_specs.py --fix               add missing todo entries and sort tracker.toml
  python specs/check_specs.py --accept ID [ID...] record the reviewed hash of specs (or §)
  python specs/check_specs.py --next TARGET       print the next free ID (category, A, A.2, A.2.R, A.2.N, §)

Checks, each problem printed as `path:line: message`:
  1. root: only the known files and <Letter>-<slug>/ directories; unique category letters
  2. category: _category.md, spec file names, unique spec numbers
  3. constitution: preamble, articles, one rule bullet each, Except/Why sub-items, Why required
  4. spec: title, lead, ## Capabilities, ## Rules and ## Non-goals grammar and order
  5. tracker entries: line format, sort order, key kinds, statuses, notes
  6. liveness: every live item and file has its entry, every entry its item, no abandoned ID reused
  7. hashes: item lines unchanged since the last --accept
  8. references: every cited ID resolves to a live item
"""
import hashlib
import re
import sys
import tomllib
from pathlib import Path

STATUSES = {
    "todo": "The sentence is not true yet, even if some code exists.",
    "partial": "The sentence is true in part, or true while breaking a rule or an article; the note says which.",
    "done": "The sentence is true: users can rely on it on every platform it names, following every rule that applies.",
    "abandoned": "The ID belonged to an item that was deleted; it is never reused.",
}
LIVE_STATUSES = ("todo", "partial", "done")

SPECS_DIR = Path(__file__).resolve().parent
REPO_DIR = SPECS_DIR.parent
TRACKER = SPECS_DIR / "tracker.toml"
CONSTITUTION = SPECS_DIR / "CONSTITUTION.md"
ROOT_FILES = {"CLAUDE.md", "FORMAT.md", "TRACKER.md", "CONSTITUTION.md", "tracker.toml", "check_specs.py", "_template.md"}
TRACKER_HEADER = "# Statuses, dead IDs and file hashes; sorted; one entry per line. Format: specs/TRACKER.md."

# (heading, item ID prefix, model key, allowed sub-items in order, required sub-items)
SECTIONS = [
    ("Capabilities", "", "capabilities", (), ()),
    ("Rules", "R", "rules", ("Except", "Why"), ()),
    ("Non-goals", "N", "nongoals", ("Why", "Reopen if"), ("Why",)),
]
ARTICLE_SUB_ITEMS = ("Except", "Why")

SLUG = r"[a-z0-9]+(?:-[a-z0-9]+)*"
CATEGORY_DIR = re.compile(rf"([A-Z])-{SLUG}")
SPEC_FILE = re.compile(rf"([A-Z])\.(\d{{3}})-{SLUG}\.md")
FENCE = re.compile(r"\s*(```|~~~)")
NOT_PARAGRAPH = re.compile(r"[-*#>]|\d+\.|```|~~~")
SUB_ITEM = re.compile(r" {2,}- (Except|Why|Reopen if): (\S.*)")
ARTICLE_HEADING = re.compile(r"## §([1-9]\d*): (\S.*)")
ID = r"(?:§\d+|[A-Z]\.\d+(?:\.[RN]?\d+)?)"
REFERENCE = re.compile(r"§\d+|\b[A-Z]\.\d+(?:\.[RN]?\d+)?\b|\bcategory [A-Z]\b")
BREAKS = re.compile(r"\bbreaks\b", re.IGNORECASE)
BREAKS_NOTE = re.compile(rf"breaks {ID}(?:, {ID})*: \S")
TRACKER_ENTRY = re.compile(r'"([^"]*)" = \{.*\}')
HASH_VALUE = re.compile(r"[0-9a-f]{12}")
KEY_KINDS = [
    ("constitution", re.compile(r"§")),
    ("article", re.compile(r"§([1-9]\d*)")),
    ("category", re.compile(r"([A-Z])")),
    ("spec", re.compile(r"([A-Z])\.([1-9]\d*)")),
    ("capability", re.compile(r"([A-Z])\.([1-9]\d*)\.([1-9]\d*)")),
    ("rule", re.compile(r"([A-Z])\.([1-9]\d*)\.R([1-9]\d*)")),
    ("nongoal", re.compile(r"([A-Z])\.([1-9]\d*)\.N([1-9]\d*)")),
]


def error(errors, path, line, message):
    errors.append((path.relative_to(REPO_DIR).as_posix(), line, message))


def read_lines(path):
    return path.read_text(encoding="utf-8").splitlines()


def blocks(numbered_lines):
    """Maximal runs of non-blank lines, as lists of (line number, text)."""
    result = []
    current = []
    for line_no, line in numbered_lines:
        if line.strip():
            current.append((line_no, line))
        elif current:
            result.append(current)
            current = []
    if current:
        result.append(current)
    return result


def item_hash(lines):
    normalized = []
    for line in lines:
        line = line.rstrip()
        normalized.append("  " + line.lstrip() if SUB_ITEM.fullmatch(line) else line)
    return hashlib.sha256("\n".join(normalized).encode("utf-8")).hexdigest()[:12]


def key_kind(key):
    for kind, pattern in KEY_KINDS:
        match = pattern.fullmatch(key)
        if match:
            return kind, match.groups()
    return None, ()


def tracker_sort_key(key):
    kind, groups = key_kind(key)
    if kind == "constitution":
        return (0, "", 0, 0, 0)
    if kind == "article":
        return (0, "", int(groups[0]), 0, 0)
    if kind == "category":
        return (1, groups[0], 0, 0, 0)
    if kind == "spec":
        return (1, groups[0], int(groups[1]), 0, 0)
    if kind in ("capability", "rule", "nongoal"):
        order = {"capability": 1, "rule": 2, "nongoal": 3}[kind]
        return (1, groups[0], int(groups[1]), order, int(groups[2]))
    return (2, key, 0, 0, 0)


def check_sub_item(errors, path, line_no, name, seen, allowed):
    if name not in allowed:
        error(errors, path, line_no, f'"{name}:" is not allowed here, expected {" then ".join(allowed)}')
    elif seen and allowed.index(name) <= allowed.index(seen[-1]):
        error(errors, path, line_no, f'sub-items appear at most once, in the order {", ".join(allowed)}')
    else:
        seen.append(name)


def parse_constitution(errors):
    lines = read_lines(CONSTITUTION)
    model = {"articles": {}, "hash_lines": [], "text_lines": []}
    if not lines or lines[0] != "# Constitution":
        error(errors, CONSTITUTION, 1, 'line 1 must be "# Constitution"')
    first_heading = next((i for i, line in enumerate(lines) if line.startswith("#") and i > 0), len(lines))
    preamble = list(enumerate(lines[1:first_heading], 2))
    for block in blocks(preamble):
        if NOT_PARAGRAPH.match(block[0][1].lstrip()):
            error(errors, CONSTITUTION, block[0][0], "the preamble holds paragraphs only")
    model["text_lines"].extend(preamble)

    article = None
    for line_no, line in enumerate(lines[first_heading:], first_heading + 1):
        model["text_lines"].append((line_no, line))
        if line.startswith("#"):
            match = ARTICLE_HEADING.fullmatch(line)
            if not match:
                error(errors, CONSTITUTION, line_no, 'article headings are "## §<n>: <title>"')
                article = None
                continue
            number = int(match[1])
            if model["articles"] and number <= max(model["articles"]):
                error(errors, CONSTITUTION, line_no, f"§{number} is out of order or duplicated; numbers are unique and ascending")
            article = {"line": line_no, "rule": False, "subs": []}
            model["articles"][number] = article
            continue
        if article is None or not line.strip():
            continue
        sub = SUB_ITEM.fullmatch(line.rstrip())
        if sub and article["rule"]:
            check_sub_item(errors, CONSTITUTION, line_no, sub[1], article["subs"], ARTICLE_SUB_ITEMS)
            model["hash_lines"].append(line)
        elif line.startswith("- ") and line[2:].strip() and not article["rule"]:
            article["rule"] = True
            model["hash_lines"].append(line)
        else:
            error(errors, CONSTITUTION, line_no, "an article is one rule bullet \"- <rule>\" followed by indented Except:/Why: sub-items")
    for number, article in model["articles"].items():
        if not article["rule"]:
            error(errors, CONSTITUTION, article["line"], f"§{number} has no rule bullet")
        elif "Why" not in article["subs"]:
            error(errors, CONSTITUTION, article["line"], f"§{number} needs a Why: sub-item")
    model["hash"] = item_hash(model["hash_lines"])
    return model


def parse_spec(path, spec_id, errors):
    """Returns the spec, or None when its title cannot be read."""
    lines = read_lines(path)
    if lines and lines[0] == "+++":
        error(errors, path, 1, "leftover +++ header: a spec starts with its title")
        return None
    title_prefix = f"# {spec_id}: "
    if not lines or not lines[0].startswith(title_prefix) or not lines[0][len(title_prefix):].strip():
        error(errors, path, 1, f'line 1 must be "{title_prefix}<title>"')
        return None
    spec = {"id": spec_id, "path": path, "title": lines[0][len(title_prefix):].strip(), "summary": "",
            "capabilities": [], "rules": [], "nongoals": [], "hash_lines": [], "text_lines": [(1, lines[0])]}
    headings = [name for name, *_ in SECTIONS]
    section = None
    seen_sections = []
    lead = []
    item = None
    in_fence = False
    for line_no, line in enumerate(lines[1:], 2):
        if FENCE.match(line):
            if section is not None:
                error(errors, path, line_no, "fenced code is only allowed in the lead")
            in_fence = not in_fence
        if in_fence or FENCE.match(line):
            if section is None:
                lead.append((line_no, line))
            continue
        spec["text_lines"].append((line_no, line))
        if line.startswith("#"):
            name = line[3:] if line.startswith("## ") else None
            if name == "Out of scope":
                error(errors, path, line_no, "## Out of scope no longer exists: move pointers into the lead and decisions into ## Non-goals")
                section = "skipped"
            elif name not in headings:
                error(errors, path, line_no, f'unexpected heading; a spec only has {", ".join("## " + h for h in headings)}')
            elif name in seen_sections:
                error(errors, path, line_no, f'duplicate section "## {name}"')
            else:
                if seen_sections and headings.index(name) < headings.index(seen_sections[-1]):
                    error(errors, path, line_no, f'sections appear in this order: {", ".join(headings)}')
                seen_sections.append(name)
                section = SECTIONS[headings.index(name)]
            item = None
            continue
        if section is None:
            lead.append((line_no, line))
            continue
        if section == "skipped" or not line.strip():
            continue
        heading, prefix, key, sub_items, _ = section
        match = re.fullmatch(rf"- \*\*{re.escape(spec_id)}\.{prefix}([1-9]\d*)\*\*: (\S.*)", line.rstrip())
        if match:
            number = int(match[1])
            if spec[key] and number <= spec[key][-1]["number"]:
                error(errors, path, line_no, f"{spec_id}.{prefix}{number} is out of order or duplicated; IDs are unique and ascending")
            item = {"number": number, "id": f"{spec_id}.{prefix}{number}", "text": match[2], "line": line_no, "subs": []}
            spec[key].append(item)
            spec["hash_lines"].append(line)
            continue
        sub = SUB_ITEM.fullmatch(line.rstrip())
        if sub and sub_items and item:
            check_sub_item(errors, path, line_no, sub[1], item["subs"], sub_items)
            spec["hash_lines"].append(line)
            continue
        expected = f'"- **{spec_id}.{prefix}<n>**: <text>"'
        if sub_items:
            expected += f' with sub-items indented by two spaces ({", ".join(sub_items)})'
        error(errors, path, line_no, f'"## {heading}" lines are {expected}')
    if in_fence:
        error(errors, path, len(lines), "fenced code is never closed")

    lead_blocks = blocks(lead)
    if not lead_blocks:
        error(errors, path, 1, "a summary paragraph must follow the title")
    elif NOT_PARAGRAPH.match(lead_blocks[0][0][1].lstrip()):
        error(errors, path, lead_blocks[0][0][0], "the lead starts with a summary paragraph")
    else:
        spec["summary"] = " ".join(line.strip() for _, line in lead_blocks[0])
    if "Capabilities" not in seen_sections:
        error(errors, path, 1, 'missing section "## Capabilities"')
    elif not spec["capabilities"]:
        error(errors, path, 1, '"## Capabilities" needs at least one capability')
    for heading, _, key, _, required in SECTIONS:
        for entry in spec[key]:
            for name in required:
                if name not in entry["subs"]:
                    error(errors, path, entry["line"], f"{entry['id']} needs a {name}: sub-item")
    spec["hash"] = item_hash(spec["hash_lines"])
    return spec


def parse_categories(errors):
    """Returns (categories, specs, unparsed spec IDs)."""
    categories = {}
    specs = {}
    unparsed = set()
    for entry in sorted(SPECS_DIR.iterdir()):
        if entry.name.startswith((".", "__")) or (entry.is_file() and entry.name in ROOT_FILES):
            continue
        match = CATEGORY_DIR.fullmatch(entry.name)
        if not entry.is_dir() or not match:
            error(errors, entry, 1, "unexpected entry: specs/ holds its seven root files and <Letter>-<slug>/ directories")
            continue
        letter = match[1]
        if letter in categories:
            error(errors, entry, 1, f"category letter {letter} is used twice")
            continue
        category_file = entry / "_category.md"
        lines = read_lines(category_file) if category_file.is_file() else []
        prefix = f"# {letter}: "
        if not lines or not lines[0].startswith(prefix) or not lines[0][len(prefix):].strip():
            error(errors, category_file, 1, f'_category.md starts with "{prefix}<title>"')
            categories[letter] = {"title": "", "path": category_file, "text_lines": []}
        else:
            if not any(line.strip() for line in lines[1:]):
                error(errors, category_file, 2, "describe the category's scope under its title")
            categories[letter] = {"title": lines[0][len(prefix):].strip(), "path": category_file,
                                  "text_lines": list(enumerate(lines, 1))}

        numbers = set()
        for spec_path in sorted(entry.iterdir()):
            if spec_path.name == "_category.md":
                continue
            spec_match = SPEC_FILE.fullmatch(spec_path.name)
            if not spec_path.is_file() or not spec_match or spec_match[1] != letter or int(spec_match[2]) == 0:
                error(errors, spec_path, 1, f"spec files are named {letter}.<3-digit number from 001>-<slug>.md")
                continue
            number = int(spec_match[2])
            spec_id = f"{letter}.{number}"
            if number in numbers:
                error(errors, spec_path, 1, f"spec number {spec_id} is used twice")
                continue
            numbers.add(number)
            spec = parse_spec(spec_path, spec_id, spec_errors := [])
            errors.extend(spec_errors)
            if spec is None:
                unparsed.add(spec_id)
            else:
                spec["errors"] = spec_errors
                specs[spec_id] = spec
    return categories, specs, unparsed


def read_tracker(errors):
    """Returns (header lines, entries, whether the line format allows rewriting the file)."""
    header = []
    entries = {}
    rewritable = True
    for line_no, line in enumerate(read_lines(TRACKER), 1):
        if not entries and (not line.strip() or line.lstrip().startswith("#")):
            header.append(line)
            continue
        match = TRACKER_ENTRY.fullmatch(line)
        if not match:
            error(errors, TRACKER, line_no, 'after the leading comments, every line is one inline entry: "<ID>" = { ... }')
            rewritable = False
            continue
        try:
            fields = tomllib.loads(line)[match[1]]
        except (tomllib.TOMLDecodeError, KeyError) as exception:
            error(errors, TRACKER, line_no, f"invalid entry: {exception}")
            rewritable = False
            continue
        if match[1] in entries:
            error(errors, TRACKER, line_no, f"{match[1]} has two entries")
            continue
        entries[match[1]] = {"fields": fields, "line": line_no, "text": line}
    return header, entries, rewritable


def check_tracker_entries(errors, entries):
    for key, entry in entries.items():
        fields = entry["fields"]
        line_no = entry["line"]
        kind, _ = key_kind(key)
        if kind is None:
            error(errors, TRACKER, line_no, f'"{key}" is not an ID; keys are §, §<n>, <Letter>, <SpecID> or item IDs')
            continue
        if not isinstance(fields, dict):
            error(errors, TRACKER, line_no, f"{key} must be an inline table")
            continue
        status = fields.get("status")
        if kind == "constitution" or (kind == "spec" and "hash" in fields):
            if set(fields) != {"hash"} or not isinstance(fields["hash"], str) or not HASH_VALUE.fullmatch(fields["hash"]):
                error(errors, TRACKER, line_no, f'{key} holds only hash = "<12 hex digits>", written by --accept')
        elif kind == "capability":
            if set(fields) - {"status", "note"} or status not in STATUSES:
                error(errors, TRACKER, line_no, f'{key} holds status ({", ".join(STATUSES)}) and an optional note')
                continue
            note = fields.get("note")
            if note is not None and (not isinstance(note, str) or not note.strip()):
                error(errors, TRACKER, line_no, f"{key} note must be non-empty text")
            elif status == "partial" and not note:
                error(errors, TRACKER, line_no, f"{key} is partial: its note says what is missing or which rule it breaks")
            elif note and BREAKS.search(note) and (status != "partial" or not BREAKS_NOTE.match(note)):
                error(errors, TRACKER, line_no, f'{key} mentions "breaks": the entry is partial and its note starts with "breaks <ID>[, <ID>]: "')
        elif fields != {"status": "abandoned"}:
            error(errors, TRACKER, line_no, f'{key} can only be {{ status = "abandoned" }}')

    keys = list(entries)
    expected = sorted(keys, key=tracker_sort_key)
    for actual, wanted in zip(keys, expected):
        if actual != wanted:
            error(errors, TRACKER, entries[actual]["line"], f"entries are not sorted here (expected {wanted}); run --fix")
            break

    for key, entry in entries.items():
        kind, groups = key_kind(key)
        if kind not in ("spec", "capability", "rule", "nongoal"):
            continue
        parents = [groups[0]] + ([f"{groups[0]}.{groups[1]}"] if kind != "spec" else [])
        for parent in parents:
            if entries.get(parent, {}).get("fields", {}).get("status") == "abandoned":
                error(errors, TRACKER, entry["line"], f"{key} sits under abandoned {parent}: delete this entry")


def check_references(errors, path, numbered_lines, live, abandoned, allow_abandoned=False):
    in_fence = False
    for line_no, line in numbered_lines:
        if FENCE.match(line):
            in_fence = not in_fence
            continue
        if in_fence:
            continue
        for match in REFERENCE.finditer(line):
            reference = match[0][-1] if match[0].startswith("category ") else match[0]
            if reference in live or (allow_abandoned and reference in abandoned):
                continue
            message = f"cites abandoned {reference}" if reference in abandoned else f"unknown reference {reference}"
            error(errors, path, line_no, message)


def load():
    errors = []
    for path in (CONSTITUTION, TRACKER):
        if not path.is_file():
            error(errors, path, 1, "missing file")
    if errors:
        return {"errors": errors}
    model = {"errors": errors}
    model["constitution"] = parse_constitution(errors)
    model["categories"], model["specs"], model["unparsed"] = parse_categories(errors)
    model["header"], model["entries"], model["rewritable"] = read_tracker(errors)
    return model


def live_items(model):
    live = {f"§{number}" for number in model["constitution"]["articles"]}
    live.update(model["categories"])
    for spec in model["specs"].values():
        live.add(spec["id"])
        for _, _, key, _, _ in SECTIONS:
            live.update(item["id"] for item in spec[key])
    return live


def in_unparsed_spec(model, key):
    _, groups = key_kind(key)
    return len(groups) >= 2 and f"{groups[0]}.{groups[1]}" in model["unparsed"]


def check(model):
    errors = model["errors"]
    entries = model["entries"]
    specs = model["specs"]
    constitution = model["constitution"]
    check_tracker_entries(errors, entries)
    live = live_items(model)
    abandoned = {key for key, entry in entries.items() if entry["fields"].get("status") == "abandoned"}
    capabilities = {item["id"]: (spec, item) for spec in specs.values() for item in spec["capabilities"]}
    for capability_id, (spec, item) in capabilities.items():
        if entries.get(capability_id, {}).get("fields", {}).get("status") not in LIVE_STATUSES and capability_id not in abandoned:
            error(errors, spec["path"], item["line"], f"{capability_id} has no tracker entry; run --fix")
    for key, entry in entries.items():
        kind, _ = key_kind(key)
        fields = entry["fields"]
        if key in abandoned and key in live:
            error(errors, TRACKER, entry["line"], f"abandoned ID reused: {key} is live in a file; take --next")
        elif kind == "capability" and fields.get("status") in LIVE_STATUSES and key not in capabilities and not in_unparsed_spec(model, key):
            error(errors, TRACKER, entry["line"], f"deleted capability {key}: mark it abandoned or restore it")
        elif kind == "spec" and "hash" in fields and key not in specs and key not in model["unparsed"]:
            error(errors, TRACKER, entry["line"], f"deleted spec {key}: mark it abandoned")

    hashed = [("§", CONSTITUTION, constitution["hash"])]
    hashed += [(spec["id"], spec["path"], spec["hash"]) for spec in specs.values()]
    for key, path, current in hashed:
        recorded = entries.get(key, {}).get("fields", {}).get("hash")
        if recorded is None:
            error(errors, path, 1, f"{key} has no hash in tracker.toml: review its statuses, then run check_specs.py --accept {key}")
        elif recorded != current:
            error(errors, path, 1, f"{key} changed since its statuses were last reviewed: review them, then run check_specs.py --accept {key}")

    check_references(errors, CONSTITUTION, constitution["text_lines"], live, abandoned)
    for category in model["categories"].values():
        check_references(errors, category["path"], category["text_lines"], live, abandoned)
    for spec in specs.values():
        check_references(errors, spec["path"], spec["text_lines"], live, abandoned)
    for key, entry in entries.items():
        note = entry["fields"].get("note")
        if isinstance(note, str):
            allow = entry["fields"].get("status") == "abandoned"
            check_references(errors, TRACKER, [(entry["line"], note)], live, abandoned, allow)


def report(model):
    errors = sorted(set(model["errors"]))
    for path, line, message in errors:
        print(f"{path}:{line}: {message}")
    return 1 if errors else 0


def counts_line(model):
    specs = model["specs"].values()
    capabilities = sum(len(spec["capabilities"]) for spec in specs)
    nongoals = sum(len(spec["nongoals"]) for spec in specs)
    return (f"OK: {len(model['constitution']['articles'])} articles, {len(model['categories'])} categories, "
            f"{len(model['specs'])} specs, {capabilities} capabilities, {nongoals} non-goals")


def under(item_id, prefix):
    return not prefix or item_id == prefix or item_id.startswith(prefix + ".")


def summary(model, prefix):
    entries = model["entries"]
    printed = False
    for letter, category in model["categories"].items():
        specs = [spec for spec in model["specs"].values() if spec["id"].startswith(letter + ".")]
        matching = [spec for spec in specs if under(spec["id"], prefix) or under(letter, prefix)
                    or any(under(item["id"], prefix) for key in ("capabilities", "nongoals") for item in spec[key])]
        if not matching and not under(letter, prefix):
            continue
        printed = True
        print(f"{letter}: {category['title']}")
        for spec in matching:
            statuses = [entries[item["id"]]["fields"].get("status") for item in spec["capabilities"] if item["id"] in entries]
            counts = ", ".join(f"{statuses.count(status)} {status}" for status in LIVE_STATUSES if status in statuses)
            print(f"  {spec['id']}: {spec['title']} ({counts})")
            print(f"    {spec['summary']}")
            whole_spec = under(spec["id"], prefix) or under(letter, prefix)
            for item in spec["capabilities"]:
                if whole_spec or under(item["id"], prefix):
                    fields = entries[item["id"]]["fields"]
                    print(f"    {item['id']:<10}{fields['status']:<12}{item['text']}")
                    if fields.get("note"):
                        print(f"    {'':<22}note: {fields['note']}")
            for item in spec["nongoals"]:
                if whole_spec or under(item["id"], prefix):
                    print(f"    {item['id']:<10}{'not offered':<12}{item['text']}")
    if not printed:
        print(f"nothing matches {prefix}")
        return 1
    return 0


def write_tracker(model):
    entries = model["entries"]
    header = model["header"] or [TRACKER_HEADER]
    while header and not header[-1].strip():
        header.pop()
    lines = header + [entries[key]["text"] for key in sorted(entries, key=tracker_sort_key)]
    TRACKER.write_text("\n".join(lines) + "\n", encoding="utf-8")


def fix(model):
    if not model["rewritable"]:
        print("tracker.toml has lines --fix cannot rewrite; fix them first")
        return report(model)
    for spec in model["specs"].values():
        for item in spec["capabilities"]:
            if item["id"] not in model["entries"]:
                model["entries"][item["id"]] = {"fields": {"status": "todo"}, "line": 0, "text": f'"{item["id"]}" = {{ status = "todo" }}'}
                print(f"added {item['id']} as todo")
    write_tracker(model)
    return run_check()


def accept(model, keys):
    entries = model["entries"]
    targets = []
    for key in keys:
        if key == "§":
            if any(path == "specs/CONSTITUTION.md" for path, _, _ in model["errors"]):
                print("CONSTITUTION.md has format errors; fix them before accepting it")
                return report(model)
            targets.append((key, model["constitution"]["hash"], None))
        elif key in model["specs"]:
            spec = model["specs"][key]
            if spec["errors"]:
                print(f"{key} has format errors; fix them before accepting it")
                for path, line, message in spec["errors"]:
                    print(f"{path}:{line}: {message}")
                return 1
            targets.append((key, spec["hash"], spec))
        else:
            print(f"{key} is neither a live spec nor §")
            return 1
    if not model["rewritable"]:
        print("tracker.toml has lines that cannot be rewritten; fix them first")
        return report(model)

    live = live_items(model)
    for key, current, spec in targets:
        print(f"== {key}")
        if spec is not None:
            for item in spec["capabilities"]:
                fields = entries.get(item["id"], {}).get("fields", {})
                note = f"  ({fields['note']})" if fields.get("note") else ""
                print(f"  {item['id']:<10}{fields.get('status', 'NO ENTRY'):<10}{item['text']}{note}")
            under_key = [k for k, entry in entries.items() if k.startswith(key + ".")
                         and entry["fields"].get("status") != "abandoned" and k not in live]
        else:
            under_key = [k for k, entry in entries.items() if key_kind(k)[0] == "article"
                         and entry["fields"].get("status") != "abandoned" and k not in live]
        for missing in under_key:
            print(f"  {missing} is in tracker.toml but no longer in the file: mark it abandoned or restore it")
        print("  reminder: add { status = \"abandoned\" } entries for every rule, non-goal or article this change deleted")
        entries[key] = {"fields": {"hash": current}, "line": 0, "text": f'"{key}" = {{ hash = "{current}" }}'}
    write_tracker(model)
    return run_check()


def next_id(model, target):
    keys = list(model["entries"])
    if target == "category":
        letters = set(model["categories"]) | {key[0] for key in keys if key[0].isupper()}
        print(chr(max(map(ord, letters)) + 1) if letters else "A")
        return 0
    if target == "§":
        numbers = set(model["constitution"]["articles"])
        numbers |= {int(groups[0]) for kind, groups in map(key_kind, keys) if kind == "article"}
        print(f"§{max(numbers, default=0) + 1}")
        return 0
    if re.fullmatch(r"[A-Z]", target):
        numbers = {int(spec_id.split(".")[1]) for spec_id in model["specs"] | dict.fromkeys(model["unparsed"]) if spec_id[0] == target}
        numbers |= {int(groups[1]) for kind, groups in map(key_kind, keys) if kind in ("spec", "capability", "rule", "nongoal") and groups[0] == target}
        number = max(numbers, default=0) + 1
        print(f"{target}.{number} (file {target}.{number:03}-<slug>.md)")
        return 0
    match = re.fullmatch(r"([A-Z]\.[1-9]\d*)(?:\.([RN]))?", target)
    if not match:
        print("targets: category, <Letter>, <SpecID>, <SpecID>.R, <SpecID>.N, §")
        return 1
    spec_id, prefix = match[1], match[2] or ""
    kind = {"": "capability", "R": "rule", "N": "nongoal"}[prefix]
    key = {"": "capabilities", "R": "rules", "N": "nongoals"}[prefix]
    spec = model["specs"].get(spec_id)
    numbers = {item["number"] for item in spec[key]} if spec else set()
    numbers |= {int(groups[2]) for k, groups in map(key_kind, keys) if k == kind and f"{groups[0]}.{groups[1]}" == spec_id}
    print(f"{spec_id}.{prefix}{max(numbers, default=0) + 1}")
    return 0


def run_check():
    model = load()
    if "entries" in model:
        check(model)
    status = report(model)
    if status == 0:
        print(counts_line(model))
    return status


def main():
    sys.stdout.reconfigure(encoding="utf-8")
    arguments = sys.argv[1:]
    command = arguments[0] if arguments else None
    if command is None:
        return run_check()
    model = load()
    if "entries" not in model:
        return report(model)
    if command == "--fix":
        return fix(model)
    if command == "--accept" and len(arguments) > 1:
        return accept(model, arguments[1:])
    if command == "--next" and len(arguments) == 2:
        return next_id(model, arguments[1])
    if command == "--summary" and len(arguments) <= 2:
        check(model)
        if report(model):
            return 1
        return summary(model, arguments[1] if len(arguments) == 2 else "")
    print(__doc__)
    return 1


if __name__ == "__main__":
    sys.exit(main())
