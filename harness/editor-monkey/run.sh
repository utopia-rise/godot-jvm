#!/usr/bin/env bash
# Usage: run.sh [--editor <path>] [probe...]
# Runs every editor probe (or the ones named as arguments) in the official Godot editor and fails on the first
# probe that reports a failure. Each probe starts from a bare Godot project holding only the addon and generates the
# JVM project itself. Needs the native GDExtension built into harness/tests/addons/jvm/libs. The editor is the
# --editor path, absolute or relative to the current directory, or else the absolute path in GODOT_EDITOR.
set -euo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

if [ "${1:-}" = "--editor" ]; then
    if [ -z "${2:-}" ]; then
        echo "--editor needs the path to the Godot editor executable" >&2
        exit 2
    fi
    editor="$2"
    shift 2
    if [ -f "$editor" ]; then
        editor="$(cd "$(dirname "$editor")" && pwd)/$(basename "$editor")"
    fi
else
    editor="${GODOT_EDITOR:-}"
    case "$editor" in
        /* | [A-Za-z]:[\\/]*) ;;
        *)
            echo "Pass --editor <path> or set GODOT_EDITOR to the absolute path of the Godot editor executable" >&2
            exit 2
            ;;
    esac
fi
if [ ! -x "$editor" ]; then
    echo "The Godot editor executable does not exist: $editor" >&2
    exit 2
fi

probes=("$@")
if [ ${#probes[@]} -eq 0 ]; then
    probes=(reload rename)
fi

cd "$here"
status=0
for probe in "${probes[@]}"; do
    # Back to a bare Godot project: only the addon stays, the probe generates the JVM project from the editor.
    rm -rf .godot .gradle .kotlin build jvm gdj src addons gradle gradlew gradlew.bat build.gradle.kts settings.gradle.kts gradle.properties .gitattributes godot_jvm_configuration.json main.tscn
    "$here/copy_addon.sh"

    log="$probe.log"
    echo "== $probe"
    "$editor" -e --path "$here" -s "res://probes/$probe.gd" > "$log" 2>&1 || true
    grep -E '^\[MONKEY\]|ERROR: Godot-JVM|SCRIPT ERROR|Exception' "$log" || true
    if ! grep -q '^\[MONKEY\] DONE with 0 failure' "$log" || grep -qE 'SCRIPT ERROR|Exception' "$log"; then
        echo "== $probe FAILED (see $here/$log)"
        status=1
    fi
done
exit $status
