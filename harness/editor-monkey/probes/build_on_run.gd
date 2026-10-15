extends "common.gd"

# Building when the game starts: the Build on Run button cycling between never, when scripts changed and always,
# and the Shift+click (build when a script changed) and Ctrl+click or Cmd+click (always build) play buttons, which
# take priority over the button. A start that builds blocks the editor for the whole Gradle run, so its duration
# tells whether it built.

const PLAYER := "res://src/main/kotlin/game/Player.kt"
const MAIN := "res://main.tscn"
const BUILD_MS := 500

const NEVER := 0
const WHEN_CHANGED := 1
const ALWAYS := 2

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


func edit_player_outside(speed: int) -> void:
	OS.delay_msec(1100)
	write(PLAYER, player_source(speed))
	EditorInterface.get_resource_filesystem().scan_sources()


func speed_in_editor() -> String:
	return (load(PLAYER) as Script).source_code.get_slice("speed: Int = ", 1).get_slice("\n", 0)


func build_on_run_button() -> Button:
	for node in root.find_children("*", "Button", true, false):
		if (node as Button).tooltip_text.begins_with("Build on Run"):
			return node
	return null


func build_on_run_saved() -> int:
	return EditorInterface.get_editor_settings().get_project_metadata("godot_jvm", "build_on_run", NEVER)


func expect_build_on_run(mode: int, label: String) -> void:
	expect(build_on_run_saved() == mode, "Build on Run saved as %d, expected %d" % [build_on_run_saved(), mode])
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
		["start, nothing changed", func(): start_game(KEY_NONE), ""],
		["Shift+click, nothing changed", func(): start_game(KEY_SHIFT), ""],
		["build anyway click, nothing changed", func(): start_game(build_anyway_key()), ""],
		["edit Player.kt outside the editor", func(): edit_player_outside(2), ""],
		["start without modifier, script changed", func(): start_game(KEY_NONE), ""],
		["Shift+click, script changed", func(): start_game(KEY_SHIFT), ""],
		["Shift+click, built just before", func(): start_game(KEY_SHIFT), ""],
		["rewrite Player.kt outside the editor with the same content", func(): edit_player_outside(2), ""],
		["Shift+click, same content", func(): start_game(KEY_SHIFT), ""],
		["Shift+click after a build that left the jar untouched", func(): start_game(KEY_SHIFT), ""],
		["click Build on Run: when scripts changed", func(): build_on_run_button().pressed.emit(), ""],
		["edit Player.kt in the script editor and save", func():
			EditorInterface.edit_script(load(PLAYER))
			OS.delay_msec(1100)
			var code := EditorInterface.get_script_editor().get_current_editor().get_base_editor() as CodeEdit
			code.text = code.text.replace("speed: Int = 2", "speed: Int = 3")
			save_current_script()
			, ""],
		["start when scripts changed, script changed", func(): start_game(KEY_NONE), ""],
		["start when scripts changed, nothing changed", func(): start_game(KEY_NONE), ""],
		["click Build on Run: always", func(): build_on_run_button().pressed.emit(), ""],
		["start always, nothing changed", func(): start_game(KEY_NONE), ""],
		["Shift+click with always, nothing changed", func(): start_game(KEY_SHIFT), ""],
		["break Player.kt", func():
			close_current_script()
			OS.delay_msec(1100)
			write(PLAYER, player_source(4).replace("var speed: Int = 4", "var speed: Int ="))
			EditorInterface.get_resource_filesystem().scan_sources()
			, ""],
		["start always, compile error", func(): start_game(KEY_NONE), ""],
		["fix Player.kt and click Build on Run: never", func():
			find_dialog("Gradle Task Runner").hide()
			edit_player_outside(5)
			build_on_run_button().pressed.emit()
			, ""],
		["start never, script changed", func(): start_game(KEY_NONE), ""],
		["build anyway click with never, nothing changed", func(): start_game(build_anyway_key()), ""],
		["build anyway click while a toolbar Gradle task runs", func():
			run_gradle_task("Build")
			start_game(build_anyway_key())
			, ""],
		["wait for the toolbar Gradle task", func(): pass, "Build"],
	]


func report(_title: String) -> void:
	match phase_index:
		0:
			expect(gradle_succeeded(), "first build succeeds")
		1:
			expect(build_on_run_button() != null, "the toolbar has a Build on Run button")
			expect_build_on_run(NEVER, "never")
		2:
			expect_start(false, "a plain start with nothing changed")
		3:
			expect_start(false, "Shift+click with nothing changed")
		4:
			expect_start(true, "the build anyway click with nothing changed")
		5:
			expect(speed_in_editor() == "2", "the editor reloads Player.kt edited outside: speed %s" % speed_in_editor())
		6:
			expect_start(false, "a plain start after an outside edit with never")
		7:
			expect_start(true, "Shift+click after an outside edit")
		8:
			expect_start(false, "Shift+click right after that build")
		10:
			expect_start(true, "Shift+click after rewriting a script with the same content")
		11:
			expect_start(false, "Shift+click after a build that left the jar untouched")
		12:
			expect_build_on_run(WHEN_CHANGED, "when scripts changed")
		14:
			expect_start(true, "a start with when scripts changed after an edit saved in the script editor")
		15:
			expect_start(false, "a start with when scripts changed with nothing changed")
		16:
			expect_build_on_run(ALWAYS, "always")
		17:
			expect_start(true, "a start with always with nothing changed")
		18:
			expect_start(false, "Shift+click takes priority over always")
		20:
			expect(not EditorInterface.is_playing_scene(), "a failed build does not start the game")
			var dialog := find_dialog("Gradle Task Runner")
			expect(dialog != null and dialog.visible, "a failed build opens the Gradle window")
			expect("Gradle task failed." in gradle_task_dialog_text(), "the Gradle window shows the failure")
			EditorInterface.stop_playing_scene()
		21:
			expect_build_on_run(NEVER, "never")
		22:
			expect_start(false, "a start with never after an edit")
		23:
			expect_start(true, "the build anyway click takes priority over never")
		24:
			expect(last_start_ms < BUILD_MS, "a start while a toolbar task runs does not run a second build (start took %d ms)" % last_start_ms)
			expect(not EditorInterface.is_playing_scene(), "a start while a toolbar task runs does not start the game")
			expect(toasts().any(func(t): return "A Gradle task is running" in t), "a start while a toolbar task runs says why")
			EditorInterface.stop_playing_scene()
		25:
			expect(gradle_succeeded(), "the toolbar task finishes")
