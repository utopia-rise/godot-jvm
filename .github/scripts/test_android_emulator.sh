#!/usr/bin/env bash
set -euo pipefail

adb install -r harness/tests/export/tests.apk
adb logcat -c
adb logcat -v threadtime > android-emulator.log 2>&1 &
logcat_pid=$!
trap 'kill "$logcat_pid" 2>/dev/null || true' EXIT
timeout 60s adb shell monkey -p com.utopiarise.godotjvm.tests 1 >/dev/null

expected_cases="$(grep -RhoE '^[[:space:]]*func test_[A-Za-z0-9_]+[[:space:]]*\(' harness/tests/test --include='*.gd' | wc -l | tr -d ' ')"
if [[ "$expected_cases" -lt 1 ]]; then
    echo "Could not determine the expected test count." >&2
    exit 1
fi

for attempt in $(seq 1 36); do
    log="$(timeout 5s adb logcat -d -v brief || true)"
    result="$(printf '%s\n' "$log" | grep 'GODOT_JVM_TEST_RESULT:' | tail -n 1 || true)"
    if [[ -n "$result" ]]; then
        summary="$(printf '%s\n' "$log" | grep -E '[0-9]+ test cases \| [0-9]+ errors \| [0-9]+ failures' | tail -n 1 || true)"
        actual_cases="$(printf '%s\n' "$summary" | sed -E 's/.* ([0-9]+) test cases.*/\1/')"
        echo "$result ($summary; expected $expected_cases test cases)"
        if [[ "$result" == *PASS* && "$actual_cases" == "$expected_cases" && "$summary" == *'| 0 errors | 0 failures'* ]]; then
            exit 0
        fi
        printf '%s\n' "$log"
        exit 1
    fi
    sleep 5
done

timeout 30s adb logcat -d -v brief || true
adb shell dumpsys activity activities | tail -n 80 || true
echo "Timed out waiting for the exported test result after 3 minutes." >&2
exit 1
