extends "common.gd"

# Building when the game starts: the Build on Run button switching between never and always, the Ctrl+click or
# Cmd+click play buttons that always build first, and the node warning about a script modified since the last build. A
# start that builds blocks the editor for the whole Gradle run, so its duration tells whether it built.

const PLAYER := "res://src/main/kotlin/game/Player.kt"
const ENEMY := "res://src/main/kotlin/game/Enemy.kt"
const MAIN := "res://main.tscn"
const BUILD_MS := 500

var last_start_ms := 0


func player_source(speed: int) -> String:
	return "package game\n\nimport godot.annotation.Export\nimport godot.annotation.Script\nimport godot.api.Node\n\n@Script\nclass Player : Node() {\n    @Export\n    var speed: Int = %d\n}\n" % speed


func build_anyway_key() -> Key:
	return KEY_META if OS.has_feature("macos") else KEY_CTRL


func hold(key: Key, pressed: bool) -> void:
	var event := InputEventKey.new()
	event.keycode = key
	event.pressed = pressed
	Input.parse_input_event(event)
	Input.flush_buffered_events()


func start_game(modifier: Key) -> void:
	if modifier != KEY_NONE:
		hold(modifier, true)
	var start := Time.get_ticks_msec()
	EditorInterface.play_custom_scene(MAIN)
	last_start_ms = Time.get_ticks_msec() - start
	if modifier != KEY_NONE:
		hold(modifier, false)


func write_outside(path: String, content: String) -> void:
	OS.delay_msec(1100)
	write(path, content)
	EditorInterface.get_resource_filesystem().scan_sources()
	root.propagate_notification(NOTIFICATION_APPLICATION_FOCUS_IN)


func edit_player_outside(speed: int) -> void:
	write_outside(PLAYER, player_source(speed))


func speed_in_editor() -> String:
	return (load(PLAYER) as Script).source_code.get_slice("speed: Int = ", 1).get_slice("\n", 0)


func expect_changed(shown: bool, description: String) -> void:
	var warnings: PackedStringArray = EditorInterface.get_edited_scene_root().call("_get_configuration_warnings")
	var modified: bool = Array(warnings).any(func(w): return "modified since" in w)
	expect(modified == shown, "%s: the node %s the modified warning" % [description, "shows" if modified else "does not show"])


func run_gradle_outside(task: String) -> int:
	var directory := ProjectSettings.globalize_path("res://")
	var output := []
	var exit_code: int
	if OS.has_feature("windows"):
		exit_code = OS.execute("cmd.exe", ["/c", directory.path_join("gradlew.bat").replace("/", "\\"), "-p", directory.replace("/", "\\"), task], output, true)
	else:
		exit_code = OS.execute(directory.path_join("gradlew"), ["-p", directory, task], output, true)
	if exit_code != 0:
		log_line("terminal gradle output: " + "".join(output).right(1500))
	return exit_code


func edit_open_script(from: String, to: String) -> void:
	var code := EditorInterface.get_script_editor().get_current_editor().get_base_editor() as CodeEdit
	code.text = code.text.replace(from, to)
	save_current_script()


func build_on_run_button() -> Button:
	for node in root.find_children("*", "Button", true, false):
		if (node as Button).tooltip_text.begins_with("Build on Run"):
			return node
	return null


func expect_build_on_run(always: bool) -> void:
	var saved: bool = EditorInterface.get_editor_settings().get_project_metadata("godot_jvm", "build_on_run", false)
	expect(saved == always, "Build on Run saved as %s, expected %s" % [saved, always])
	var label := "always" if always else "never"
	var tooltip := build_on_run_button().tooltip_text
	expect(tooltip.begins_with("Build on Run: " + label), "Build on Run tooltip starts with '%s'" % tooltip.get_slice("\n", 0))


func expect_start(built: bool, description: String) -> void:
	var did_build := last_start_ms >= BUILD_MS
	expect(did_build == built, "%s: %s (start took %d ms)" % [description, "built" if did_build else "did not build", last_start_ms])
	expect(EditorInterface.is_playing_scene(), description + ": the game is running")
	EditorInterface.stop_playing_scene()


func setup_phases() -> void:
	phases = [
		["first build", func(): write(PLAYER, player_source(1)), "Build"],
		["scene with Player", func():
			find_dialog("Gradle Task Runner").hide()
			var player := Node.new()
			player.name = "Player"
			player.set_script(load(PLAYER))
			var packed := PackedScene.new()
			packed.pack(player)
			ResourceSaver.save(packed, MAIN)
			EditorInterface.open_scene_from_path(MAIN)
			, ""],
		["start never, nothing changed", func(): start_game(KEY_NONE), ""],
		["build anyway click, nothing changed", func(): start_game(build_anyway_key()), ""],
		["edit Player.kt outside the editor", func(): edit_player_outside(2), ""],
		["start never, script changed", func(): start_game(KEY_NONE), ""],
		["build anyway click, script changed", func(): start_game(build_anyway_key()), ""],
		["click Build on Run: always", func(): build_on_run_button().pressed.emit(), ""],
		["start always, nothing changed", func(): start_game(KEY_NONE), ""],
		["open Player.kt in the script editor", func(): EditorInterface.edit_script(load(PLAYER)), ""],
		["edit Player.kt in the script editor and save", func():
			OS.delay_msec(1100)
			edit_open_script("speed: Int = 2", "speed: Int = 3")
			, ""],
		["start always, script changed", func(): start_game(KEY_NONE), ""],
		["break Player.kt", func():
			close_current_script()
			write_outside(PLAYER, player_source(4).replace("var speed: Int = 4", "var speed: Int ="))
			, ""],
		["start always, compile error", func(): start_game(KEY_NONE), ""],
		["fix Player.kt and click Build on Run: never", func():
			find_dialog("Gradle Task Runner").hide()
			edit_player_outside(5)
			build_on_run_button().pressed.emit()
			, ""],
		["start never after a failed build, script changed", func(): start_game(KEY_NONE), ""],
		["build anyway click while a toolbar Gradle task runs", func():
			run_gradle_task("Build")
			start_game(build_anyway_key())
			, ""],
		["wait for the toolbar Gradle task", func(): pass, "Build"],
		["edit Player.kt outside the editor and revert it", func():
			find_dialog("Gradle Task Runner").hide()
			edit_player_outside(6)
			edit_player_outside(5)
			, ""],
		["add a comment to Player.kt outside the editor", func():
			write_outside(PLAYER, player_source(5) + "// comment\n")
			, ""],
		["build the comment", func(): pass, "Build"],
		["open Player.kt in the script editor again", func():
			find_dialog("Gradle Task Runner").hide()
			EditorInterface.edit_script(load(PLAYER))
			, ""],
		["edit Player.kt again in the script editor and save", func():
			OS.delay_msec(1100)
			edit_open_script("speed: Int = 5", "speed: Int = 6")
			, ""],
		["build the script editor edit", func(): pass, "Build"],
		["edit Player.kt a third time in the script editor and save", func():
			find_dialog("Gradle Task Runner").hide()
			OS.delay_msec(1100)
			edit_open_script("speed: Int = 6", "speed: Int = 7")
			, ""],
		["edit Player.kt back to the built content in the script editor and save", func():
			OS.delay_msec(1100)
			edit_open_script("speed: Int = 7", "speed: Int = 6")
			, ""],
		["add a comment to Player.kt and build from a terminal", func():
			close_current_script()
			OS.delay_msec(1100)
			write(PLAYER, FileAccess.get_file_as_string(PLAYER) + "// terminal\n")
			EditorInterface.get_resource_filesystem().scan_sources()
			expect(run_gradle_outside("build") == 0, "the terminal build succeeds")
			root.propagate_notification(NOTIFICATION_APPLICATION_FOCUS_IN)
			, ""],
		["rewrite Player.kt outside the editor with the same content", func():
			write_outside(PLAYER, FileAccess.get_file_as_string(PLAYER))
			, ""],
		["add Enemy.kt and run a release build", func():
			write(ENEMY, "package game\n\nimport godot.annotation.Script\nimport godot.api.Node\n\n@Script\nclass Enemy : Node()\n")
			EditorInterface.get_resource_filesystem().scan_sources()
			, "Build Release"],
		["rescan the project", func():
			find_dialog("Gradle Task Runner").hide()
			EditorInterface.get_resource_filesystem().scan()
			, ""],
		["touch Player.kt without changing it and build from a terminal", func():
			OS.delay_msec(1100)
			write(PLAYER, FileAccess.get_file_as_string(PLAYER))
			EditorInterface.get_resource_filesystem().scan_sources()
			expect(run_gradle_outside("build") == 0, "the terminal build after a touch succeeds")
			root.propagate_notification(NOTIFICATION_APPLICATION_FOCUS_IN)
			, ""],
	]


func report(title: String) -> void:
	match title:
		"first build":
			expect(gradle_succeeded(), "first build succeeds")
		"scene with Player":
			expect(build_on_run_button() != null, "the toolbar has a Build on Run button")
			expect_build_on_run(false)
			expect_changed(false, "right after the first build")
		"start never, nothing changed":
			expect_start(false, "a start with never and nothing changed")
		"build anyway click, nothing changed":
			expect_start(true, "the build anyway click with nothing changed")
		"edit Player.kt outside the editor":
			expect(speed_in_editor() == "2", "the editor reloads Player.kt edited outside: speed %s" % speed_in_editor())
			expect_changed(true, "after an outside edit")
		"start never, script changed":
			expect_start(false, "a start with never after an outside edit")
		"build anyway click, script changed":
			expect_start(true, "the build anyway click after an outside edit")
		"click Build on Run: always":
			expect_build_on_run(true)
			expect_changed(false, "after the build anyway click")
		"rewrite Player.kt outside the editor with the same content":
			expect_changed(false, "after rewriting a script with the same content")
		"start always, nothing changed":
			expect_start(true, "a start with always and nothing changed")
		"edit Player.kt in the script editor and save":
			expect(speed_in_editor() == "3", "the script editor saves Player.kt: speed %s" % speed_in_editor())
			expect_changed(true, "after an edit saved in the script editor")
		"edit Player.kt again in the script editor and save":
			expect(speed_in_editor() == "6", "the script editor saves Player.kt again: speed %s" % speed_in_editor())
			expect_changed(true, "after another edit saved in the script editor")
		"start always, script changed":
			expect_start(true, "a start with always after an edit saved in the script editor")
		"start always, compile error":
			expect(not EditorInterface.is_playing_scene(), "a failed build does not start the game")
			var dialog := find_dialog("Gradle Task Runner")
			expect(dialog != null and dialog.visible, "a failed build opens the Gradle window")
			expect("Gradle task failed." in gradle_task_dialog_text(), "the Gradle window shows the failure")
			EditorInterface.stop_playing_scene()
		"fix Player.kt and click Build on Run: never":
			expect_build_on_run(false)
		"start never after a failed build, script changed":
			expect_start(false, "a start with never after an edit")
			expect_changed(true, "after a failed build")
		"build anyway click while a toolbar Gradle task runs":
			expect(last_start_ms < BUILD_MS, "a start while a toolbar task runs does not run a second build (start took %d ms)" % last_start_ms)
			expect(not EditorInterface.is_playing_scene(), "a start while a toolbar task runs does not start the game")
			expect(toasts().any(func(t): return "A Gradle task is running" in t), "a start while a toolbar task runs says why")
			EditorInterface.stop_playing_scene()
		"wait for the toolbar Gradle task":
			expect(gradle_succeeded(), "the toolbar task finishes")
			expect_changed(false, "after the toolbar build")
		"edit Player.kt outside the editor and revert it":
			expect(speed_in_editor() == "5", "the editor reloads Player.kt reverted outside: speed %s" % speed_in_editor())
			expect_changed(false, "after an outside edit reverted to the built content")
		"add a comment to Player.kt outside the editor":
			expect_changed(true, "after a comment added outside")
		"build the comment":
			expect(gradle_succeeded(), "the build of a comment succeeds")
			expect_changed(false, "after building a comment")
		"build the script editor edit":
			expect(gradle_succeeded(), "the build of a script editor edit succeeds")
			expect_changed(false, "after building an edit saved in the script editor")
		"edit Player.kt a third time in the script editor and save":
			expect_changed(true, "after a third edit saved in the script editor")
		"edit Player.kt back to the built content in the script editor and save":
			expect_changed(false, "after saving the built content back in the script editor")
		"add a comment to Player.kt and build from a terminal":
			expect_changed(false, "after a comment built from a terminal, once the editor gets the focus back")
		"add Enemy.kt and run a release build":
			expect(gradle_succeeded(), "the release build succeeds")
			expect_changed(false, "after a release build, which builds the debug jars first")
		"rescan the project":
			expect(global_classes().has("Enemy"), "a release build names Enemy in the global classes: %s" % [global_classes().keys()])
			expect_changed(false, "after a rescan")
		"touch Player.kt without changing it and build from a terminal":
			expect_changed(false, "after touching a script and building from a terminal")
