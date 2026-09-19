#!/usr/bin/env bash
set -e
for bench in BunnymarkV2 BunnymarkV1Sprites BunnymarkV1DrawTexture BunnymarkV3; do
    for lang in gd kt; do
        "$GODOT_EDITOR" --path . -- --bench=$bench --lang=$lang
    done
done
