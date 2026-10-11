#!/usr/bin/env bash
# Copies the Godot-JVM addon built into harness/tests into this project, without the mobile libraries.
set -euo pipefail

here="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

rm -rf "$here/addons"
mkdir -p "$here/addons/jvm"
cp -R "$here/../tests/addons/jvm/." "$here/addons/jvm/"
rm -rf "$here/addons/jvm/libs/android" "$here/addons/jvm/libs/ios"
