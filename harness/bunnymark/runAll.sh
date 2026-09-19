#!/usr/bin/env bash
set -e
for bench in BunnymarkSceneTree BunnymarkSprites BunnymarkDrawTexture BunnymarkScripts BunnymarkComputation; do
    for lang in gd kt; do
        "$GODOT_EDITOR" --path . -- --bench=$bench --lang=$lang
    done
done
