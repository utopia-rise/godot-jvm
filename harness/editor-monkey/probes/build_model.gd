extends "common.gd"

# The build model: shared outputs (jvm/editor/, jvm/dependencies/), a debug and a release pipeline joined only by the
# toolbar tasks, a release build that brings the editor's debug files up to date without rewriting them when they are
# current, Fast Build touching only the user code jar, and the editor reading the source hashes only when it reloads
# the user code jar.

const PLAYER := "res://src/main/kotlin/game/Player.kt"
const ENEMY := "res://src/main/kotlin/game/Enemy.kt"
const MAIN := "res://main.tscn"
const BUILD_FILE := "res://build.gradle.kts"
const BOOTSTRAP := "res://jvm/debug/godot-bootstrap.jar"
const USER_CODE := "res://jvm/debug/usercode.jar"
const GAME := "res://jvm/release/game.jar"
const INDEX := "res://jvm/editor/script-classes.json"
const HASHES := "res://jvm/editor/source-hashes.json"
const SPLIT_JAR := "res://jvm/dependencies/commons-io-2.15.1.jar"
const SPLIT_LIST := "res://jvm/dependencies/split-dependencies.txt"
const EXTRA := "res://scripts/game/Extra.kt"
const SOURCE_DIRECTORY := "\nsourceSets.named(\"main\") { java.srcDir(\"scripts\") }\n"
const SPLIT_DEPENDENCY := "\ndependencies {\n    godotSplitImplementation(\"commons-io:commons-io:2.15.1\")\n}\n"

var times := {}
var last_start_ms := 0


func player_source(extra: String, body: String, uses_split: bool) -> String:
	var import_line := "import org.apache.commons.io.FilenameUtils\n" if uses_split else ""
	var call := "FilenameUtils.getExtension(\"a.b\")" if uses_split else "\"b\""
	return ("package game\n\nimport godot.annotation.Export\nimport godot.annotation.Register\nimport godot.annotation.Script\nimport godot.api.Node\n%s\n@Script\nclass Player : Node() {\n    @Export\n    var speed: Int = 1\n%s\n    @Register\n    fun extension(): String {\n        %s\n        return %s\n    }\n}\n"
		% [import_line, extra, body, call])


func modified_time(path: String) -> int:
	return FileAccess.get_modified_time(path) if FileAccess.file_exists(path) else 0


func remember(paths: Array) -> void:
	for path in paths:
		times[path] = modified_time(path)


func expect_rewritten(path: String, rewritten: bool, description: String) -> void:
	var changed: bool = modified_time(path) != times.get(path, -1)
	expect(changed == rewritten, "%s: %s %s" % [description, path, "was rewritten" if changed else "was not rewritten"])


func zip_files(path: String) -> PackedStringArray:
	var zip := ZIPReader.new()
	if zip.open(path) != OK:
		return PackedStringArray()
	var files := zip.get_files()
	zip.close()
	return files


func class_path(path: String) -> String:
	var zip := ZIPReader.new()
	if zip.open(path) != OK:
		return "<no jar>"
	var manifest := zip.read_file("META-INF/MANIFEST.MF").get_string_from_utf8().replace("\r\n ", "").replace("\n ", "")
	zip.close()
	for line in manifest.split("\n"):
		if line.begins_with("Class-Path:"):
			return line.trim_prefix("Class-Path:").strip_edges()
	return ""


func built_hash(path: String) -> String:
	var json = JSON.parse_string(FileAccess.get_file_as_string(HASHES))
	if typeof(json) != TYPE_DICTIONARY:
		return "<no hashes>"
	return String((json["sources"] as Dictionary).get(path, "<missing>"))


func built_roots() -> Array:
	var json = JSON.parse_string(FileAccess.get_file_as_string(HASHES))
	return json["roots"] if typeof(json) == TYPE_DICTIONARY else []


func expect_modified_warning(shown: bool, description: String) -> void:
	var warnings: PackedStringArray = EditorInterface.get_edited_scene_root().call("_get_configuration_warnings")
	var modified: bool = Array(warnings).any(func(w): return "modified since" in w)
	expect(modified == shown, "%s: the node %s the modified warning" % [description, "shows" if modified else "does not show"])


func expect_status_ready(description: String) -> void:
	expect(jvm_status().ends_with("Ready"), "%s: the JVM status is %s" % [description, jvm_status()])


func edit_player(extra: String, body: String, uses_split: bool) -> void:
	OS.delay_msec(1100)
	write(PLAYER, player_source(extra, body, uses_split))
	EditorInterface.get_resource_filesystem().scan_sources()


func shift_click_play() -> void:
	var event := InputEventKey.new()
	event.keycode = KEY_SHIFT
	event.pressed = true
	Input.parse_input_event(event)
	Input.flush_buffered_events()
	var start := Time.get_ticks_msec()
	EditorInterface.play_custom_scene(MAIN)
	last_start_ms = Time.get_ticks_msec() - start
	event.pressed = false
	Input.parse_input_event(event)
	Input.flush_buffered_events()


func expect_started_without_build(description: String) -> void:
	expect(last_start_ms < 500, "%s: Shift+click does not build (start took %d ms)" % [description, last_start_ms])
	expect(EditorInterface.is_playing_scene(), description + ": the game is running")
	EditorInterface.stop_playing_scene()


func hide_gradle_dialog() -> void:
	var dialog := find_dialog("Gradle Task Runner")
	if dialog != null:
		dialog.hide()


func setup_phases() -> void:
	phases = [
		["first build, with a split dependency", func():
			write(BUILD_FILE, FileAccess.get_file_as_string(BUILD_FILE) + SPLIT_DEPENDENCY)
			write(PLAYER, player_source("", "", true))
			, "Build"],
		["scene with Player", func():
			hide_gradle_dialog()
			var player := Node.new()
			player.name = "Player"
			player.set_script(load(PLAYER))
			var packed := PackedScene.new()
			packed.pack(player)
			ResourceSaver.save(packed, MAIN)
			EditorInterface.open_scene_from_path(MAIN)
			remember([BOOTSTRAP, USER_CODE, INDEX, HASHES, SPLIT_JAR])
			OS.delay_msec(1100)
			, ""],
		["Build Release after an unchanged debug build", func(): pass, "Build Release"],
		["Build Release again, nothing changed", func():
			hide_gradle_dialog()
			remember([GAME])
			OS.delay_msec(1100)
			, "Build Release"],
		["add a member to Player, then Build Release", func():
			hide_gradle_dialog()
			remember([BOOTSTRAP, USER_CODE, INDEX, HASHES, GAME])
			edit_player("    @Export\n    var health: Int = 10\n", "", true)
			write(ENEMY, "package game\n\nimport godot.annotation.Script\nimport godot.api.Node\n\n@Script\nclass Enemy : Node()\n")
			EditorInterface.get_resource_filesystem().scan_sources()
			, "Build Release"],
		["Shift+click after a release build of an edit", func():
			hide_gradle_dialog()
			shift_click_play()
			, ""],
		["change a method body, then Fast Build", func():
			hide_gradle_dialog()
			remember([BOOTSTRAP, USER_CODE, INDEX, HASHES, GAME])
			edit_player("    @Export\n    var health: Int = 10\n", "println(\"fast\")", true)
			, "Fast Build"],
		["Shift+click after Fast Build", func():
			hide_gradle_dialog()
			shift_click_play()
			, ""],
		["add a comment, then Build", func():
			hide_gradle_dialog()
			remember([BOOTSTRAP, USER_CODE, INDEX, HASHES])
			OS.delay_msec(1100)
			write(PLAYER, FileAccess.get_file_as_string(PLAYER) + "// comment\n")
			EditorInterface.get_resource_filesystem().scan_sources()
			, "Build"],
		["edit Player and rewrite the hashes by hand, without a build", func():
			hide_gradle_dialog()
			edit_player("    @Export\n    var health: Int = 11\n", "println(\"fast\")", true)
			var json: Dictionary = JSON.parse_string(FileAccess.get_file_as_string(HASHES))
			(json["sources"] as Dictionary)[PLAYER] = FileAccess.get_md5(PLAYER)
			write(HASHES, JSON.stringify(json, "    "))
			root.propagate_notification(NOTIFICATION_APPLICATION_FOCUS_IN)
			, ""],
		["Build after the hand-written hashes", func(): pass, "Build"],
		["load a script from a new directory, add the directory to the build, then Build", func():
			hide_gradle_dialog()
			write(EXTRA, "package game\n\nimport godot.annotation.Script\nimport godot.api.Node\n\n@Script\nclass Extra : Node()\n")
			load(EXTRA)
			write(BUILD_FILE, FileAccess.get_file_as_string(BUILD_FILE) + SOURCE_DIRECTORY)
			EditorInterface.get_resource_filesystem().scan_sources()
			, "Build"],
		["drop the split dependency and the new source directory, then Build", func():
			hide_gradle_dialog()
			remember([BOOTSTRAP, USER_CODE])
			write(BUILD_FILE, FileAccess.get_file_as_string(BUILD_FILE).replace(SPLIT_DEPENDENCY, "").replace(SOURCE_DIRECTORY, ""))
			edit_player("    @Export\n    var health: Int = 11\n", "println(\"fast\")", false)
			, "Build"],
		["delete jvm/editor/ and jvm/release/, then Build Release", func():
			hide_gradle_dialog()
			for path in [INDEX, HASHES, GAME]:
				DirAccess.remove_absolute(ProjectSettings.globalize_path(path))
			, "Build Release"],
	]


func report(_title: String) -> void:
	match phase_index:
		0:
			expect(gradle_succeeded(), "the first build succeeds")
			for path in [BOOTSTRAP, USER_CODE, INDEX, HASHES, SPLIT_JAR, "res://jvm/editor/.gdignore"]:
				expect(FileAccess.file_exists(path), "the first build writes " + path)
			for path in ["res://jvm/script-classes.json", "res://jvm/debug/dependencies", "res://jvm/release"]:
				expect(not FileAccess.file_exists(path) and not DirAccess.dir_exists_absolute(ProjectSettings.globalize_path(path)), "a debug build writes nothing at " + path)
			expect(not zip_files(USER_CODE).has("source-hashes.json"), "usercode.jar carries no source hashes")
			expect(class_path(BOOTSTRAP) == "../dependencies/commons-io-2.15.1.jar", "the bootstrap Class-Path lists the shared split jar: '%s'" % class_path(BOOTSTRAP))
			expect(FileAccess.get_file_as_string(SPLIT_LIST) == "commons-io-2.15.1.jar\n", "the split dependency list names the shared jar: '%s'" % FileAccess.get_file_as_string(SPLIT_LIST))
			expect(FileAccess.get_file_as_string(INDEX).contains("game.Player"), "the class index lists game.Player")
			expect(built_hash(PLAYER) == FileAccess.get_md5(PLAYER), "the source hashes list Player.kt as built")
			expect(EditorInterface.get_resource_filesystem().get_filesystem_path("res://jvm/editor") == null, "Godot does not index jvm/editor/")
			expect_classes({"HelloGodot": "Node", "Player": "Node"})
		1:
			expect_modified_warning(false, "right after the first build")
			expect_status_ready("after the first build of a project never built, which asks for no restart")
			expect(script_members(load(PLAYER))["methods"].has("extension"), "Player exposes extension(): %s" % [script_members(load(PLAYER))])
		2:
			expect(gradle_succeeded(), "Build Release after an unchanged debug build succeeds")
			expect(FileAccess.file_exists(GAME), "Build Release writes " + GAME)
			expect(class_path(GAME) == "../dependencies/commons-io-2.15.1.jar", "the game.jar Class-Path lists the shared split jar: '%s'" % class_path(GAME))
			var game_files := zip_files(GAME)
			expect(game_files.has("game/Player.class"), "game.jar holds the user classes")
			expect(game_files.has("META-INF/services/godot.registration.ClassRegistrar"), "game.jar holds the registrar service file")
			expect(not game_files.has("source-hashes.json"), "game.jar carries no source hashes")
			for path in [BOOTSTRAP, USER_CODE, INDEX, HASHES, SPLIT_JAR]:
				expect_rewritten(path, false, "a release build after an unchanged debug build")
			expect(not DirAccess.dir_exists_absolute(ProjectSettings.globalize_path("res://jvm/release/dependencies")), "a release build writes no jvm/release/dependencies/")
			expect_status_ready("after a release build that rewrites no debug jar")
		3:
			expect(gradle_succeeded(), "a second Build Release succeeds")
			expect_rewritten(GAME, false, "a second Build Release with nothing changed")
		4:
			expect(gradle_succeeded(), "Build Release after adding a member succeeds")
			expect(script_members(load(PLAYER))["props"].has("health"), "a release build reloads the debug jar: Player has health: %s" % [script_members(load(PLAYER))])
			expect_rewritten(USER_CODE, true, "a release build after adding a member")
			expect_rewritten(HASHES, true, "a release build after adding a member")
			expect_rewritten(GAME, true, "a release build after adding a member")
			expect_rewritten(BOOTSTRAP, false, "a release build after adding a member")
			expect(built_hash(PLAYER) == FileAccess.get_md5(PLAYER), "the hashes a release build writes describe Player.kt as built")
			expect_modified_warning(false, "after a release build of an edit")
			expect(FileAccess.get_file_as_string(INDEX).contains("game.Enemy"), "a release build adds game.Enemy to the class index")
			expect(global_classes().has("Enemy"), "a release build names Enemy in the global classes: %s" % [global_classes().keys()])
			expect(built_hash(ENEMY) == FileAccess.get_md5(ENEMY), "the hashes a release build writes list Enemy.kt as built")
			expect_status_ready("after a release build of an edit")
		5:
			expect_started_without_build("after a release build of an edit")
		6:
			expect(gradle_succeeded(), "Fast Build succeeds")
			expect_rewritten(USER_CODE, true, "Fast Build")
			expect_rewritten(HASHES, true, "Fast Build")
			for path in [BOOTSTRAP, INDEX, GAME]:
				expect_rewritten(path, false, "Fast Build")
			expect_modified_warning(false, "after Fast Build")
		7:
			expect_started_without_build("after Fast Build")
		8:
			expect(gradle_succeeded(), "a build after a comment succeeds")
			expect_rewritten(USER_CODE, true, "a build after a comment-only change")
			expect_rewritten(HASHES, true, "a build after a comment-only change")
			expect_rewritten(BOOTSTRAP, false, "a build after a comment-only change")
			expect_modified_warning(false, "after building a comment")
		9:
			expect_modified_warning(true, "after hashes rewritten by hand, which the editor reads only with the user code jar")
		10:
			expect(gradle_succeeded(), "the build after the hand-written hashes succeeds")
			expect_modified_warning(false, "after the build that reloads the user code jar")
			expect(script_members(load(PLAYER))["props"].has("health"), "Player still has health after the build")
		11:
			expect(gradle_succeeded(), "a build with a new source directory succeeds")
			expect(built_hash(EXTRA) == FileAccess.get_md5(EXTRA), "the source hashes list Extra.kt from the new directory")
			expect("Source directories added" in jvm_status(), "a new source directory asks for a restart: " + jvm_status())
		12:
			expect(gradle_succeeded(), "a build without the split dependency succeeds")
			expect(not FileAccess.file_exists(SPLIT_JAR) or OS.has_feature("windows"), "a dropped split dependency leaves jvm/dependencies/, unless the open Windows editor keeps it")
			expect(class_path(BOOTSTRAP) == "", "the bootstrap Class-Path is empty without split dependencies: '%s'" % class_path(BOOTSTRAP))
			expect(FileAccess.get_file_as_string(SPLIT_LIST) == "", "the split dependency list is empty without split dependencies, even when the editor keeps the jar: '%s'" % FileAccess.get_file_as_string(SPLIT_LIST))
			expect_rewritten(BOOTSTRAP, true, "a build after dropping a split dependency")
			expect(built_hash(EXTRA) == "<missing>", "the source hashes drop Extra.kt once its directory leaves the build")
			expect(not built_roots().has("res://scripts/"), "the source hashes drop a directory removed from the build: %s" % [built_roots()])
			expect(built_roots().has("res://src/main/kotlin/"), "the source hashes keep the main source directory: %s" % [built_roots()])
			expect("Bootstrap modified" in jvm_status(), "a changed bootstrap asks for a restart: " + jvm_status())
		13:
			expect(gradle_succeeded(), "Build Release after deleting its outputs succeeds")
			for path in [INDEX, HASHES, GAME]:
				expect(FileAccess.file_exists(path), "Build Release writes back " + path)
			expect(built_hash(PLAYER) == FileAccess.get_md5(PLAYER), "the rewritten hashes describe Player.kt as built")
