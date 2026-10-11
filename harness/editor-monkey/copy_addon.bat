@echo off
rem Copies the Godot-JVM addon built into harness\tests into this project, without the mobile libraries.
setlocal

set "here=%~dp0"
set "here=%here:~0,-1%"

if exist "%here%\addons" rmdir /s /q "%here%\addons"
xcopy /e /i /q "%here%\..\tests\addons\jvm" "%here%\addons\jvm" >nul
if exist "%here%\addons\jvm\libs\android" rmdir /s /q "%here%\addons\jvm\libs\android"
if exist "%here%\addons\jvm\libs\ios" rmdir /s /q "%here%\addons\jvm\libs\ios"
