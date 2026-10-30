@echo off
rem Usage: run.bat [--editor <path>] [probe...]
rem Runs every editor probe (or the ones named as arguments) in the official Godot editor and fails on the first
rem probe that reports a failure. Each probe starts from a bare Godot project holding only the addon and generates the
rem JVM project itself. Needs the native GDExtension built into harness\tests\addons\jvm\libs. The editor is the
rem --editor path, absolute or relative to the current directory, or else the absolute path in GODOT_EDITOR.
setlocal enabledelayedexpansion

set "here=%~dp0"
set "here=%here:~0,-1%"

if "%~1"=="--editor" goto editor_argument
set "editor=%GODOT_EDITOR%"
if "!editor:~1,1!"==":" goto editor_found
if "!editor:~0,2!"=="\\" goto editor_found
echo Pass --editor ^<path^> or set GODOT_EDITOR to the absolute path of the Godot editor executable 1>&2
exit /b 2

:editor_argument
if "%~2"=="" (
    echo --editor needs the path to the Godot editor executable 1>&2
    exit /b 2
)
set "editor=%~f2"
shift
shift

:editor_found
if not exist "%editor%" (
    echo The Godot editor executable does not exist: %editor% 1>&2
    exit /b 2
)

set "probes="
:collect_probes
if not "%~1"=="" (
    set "probes=!probes! %~1"
    shift
    goto collect_probes
)
if "%probes%"=="" set "probes=reload rename build_on_run embedded_jre"

cd /d "%here%"
set status=0
for %%p in (%probes%) do (
    rem Back to a bare Godot project: only the addon stays, the probe generates the JVM project from the editor.
    for %%d in (.godot .gradle .kotlin build jvm gdj src addons gradle) do if exist "%%d" rmdir /s /q "%%d"
    for %%f in (gradlew gradlew.bat build.gradle.kts settings.gradle.kts gradle.properties .gitattributes godot_jvm_configuration.json main.tscn) do if exist "%%f" del /q "%%f"
    call "%here%\copy_addon.bat"

    echo == %%p
    "%editor%" -e --path "%here%" -s "res://probes/%%p.gd" > "%%p.log" 2>&1
    findstr /r /c:"^\[MONKEY\]" /c:"ERROR: Godot-JVM" /c:"SCRIPT ERROR" /c:"Exception" "%%p.log"
    findstr /c:"[MONKEY] DONE with 0 failure" "%%p.log" >nul || set status=1
    findstr /c:"SCRIPT ERROR" /c:"Exception" "%%p.log" >nul && set status=1
    if !status! neq 0 echo == %%p FAILED ^(see %here%\%%p.log^)
)
exit /b %status%
