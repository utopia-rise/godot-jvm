extends "common.gd"

# Jar reloading: every phase edits sources, runs a toolbar task, and checks what the editor shows afterwards.

const PLAYER := "res://src/main/kotlin/game/Player.kt"
const ENEMY := "res://src/main/java/game/Enemy.java"
const HUD := "res://src/main/scala/game/Hud.scala"
const COIN := "res://src/main/kotlin/game/Coin.kt"
const DOOR := "res://src/main/java/game/Door.java"

const PLAYER_MEMBERS := "    @Export\n    var speed: Int = 6\n\n    @Export\n    var jumpHeight: Double = 3.5\n\n    val hit by signal0()\n\n    val landed by signal0()\n\n    @Register\n    fun jump() = Unit\n\n    @Register\n    fun dash() = Unit\n"
const PLAYER_MEMBERS_ARMOR := "    @Export\n    var speed: Int = 6\n\n    @Export\n    var jumpHeight: Double = 3.5\n\n    @Export\n    var armor: Int = 4\n\n    val hit by signal0()\n\n    val landed by signal0()\n\n    @Register\n    fun jump() = Unit\n\n    @Register\n    fun dash() = Unit\n"


func player_source(base: String, members: String) -> String:
	return "package game\n\nimport godot.annotation.Export\nimport godot.annotation.Register\nimport godot.annotation.Script\nimport godot.api.%s\nimport godot.core.signal0\n\n@Script\nclass Player : %s() {\n%s}\n" % [base, base, members]


func enemy_source(hp: int, extra: String) -> String:
	return "package game;\n\nimport godot.annotation.Export;\nimport godot.annotation.Script;\nimport godot.api.Node;\n\n@Script\npublic class Enemy extends Node {\n    @Export\n    public int hp = %d;\n%s}\n" % [hp, extra]


func node_members(name: String) -> Dictionary:
	var node := EditorInterface.get_edited_scene_root().get_node(name)
	return script_members(node.get_script())


func expect_player(base: String, props: Array, methods: Array, signals: Array) -> void:
	var members := node_members("Player")
	expect(members.get("base") == base, "Player base %s, expected %s" % [members.get("base"), base])
	expect(members.get("props") == props, "Player props %s, expected %s" % [members.get("props"), props])
	expect(members.get("methods") == methods, "Player methods %s, expected %s" % [members.get("methods"), methods])
	expect(members.get("signals") == signals, "Player signals %s, expected %s" % [members.get("signals"), signals])
	var player := EditorInterface.get_edited_scene_root().get_node("Player")
	expect(player.get("speed") == 9, "Player speed set in the scene is %s, expected 9" % player.get("speed"))


func setup_phases() -> void:
	phases = [
		["first build", func():
			write(PLAYER, player_source("Node2D", "    @Export\n    var speed: Int = 1\n\n    @Export\n    var nickname: String = \"p\"\n\n    val hit by signal0()\n\n    @Register\n    fun jump() = Unit\n"))
			write(ENEMY, enemy_source(10, ""))
			write(HUD, "package game\n\nimport godot.annotation.Export\nimport godot.annotation.Script\nimport godot.api.Control\n\n@Script\nclass Hud extends Control {\n  @Export\n  var title: String = \"hud\"\n}\n")
			, "Build"],
		["scene with the three scripts", func():
			var main := Node2D.new()
			main.name = "Main"
			for entry in [["Player", "Node2D", PLAYER], ["Enemy", "Node", ENEMY], ["Hud", "Control", HUD]]:
				var node: Node = ClassDB.instantiate(entry[1])
				node.name = entry[0]
				main.add_child(node)
				node.owner = main
				node.set_script(load(entry[2]))
			main.get_node("Player").set("speed", 9)
			var packed := PackedScene.new()
			packed.pack(main)
			ResourceSaver.save(packed, "res://main.tscn")
			EditorInterface.open_scene_from_path("res://main.tscn")
			EditorInterface.inspect_object(EditorInterface.get_edited_scene_root().get_node("Player"))
			, ""],
		["player: new default, dropped property, new property, function and signal", func():
			write(PLAYER, player_source("Node2D", PLAYER_MEMBERS))
			, "Build"],
		["new scripts Coin.kt and Door.java", func():
			write(COIN, "package game\n\nimport godot.annotation.Export\nimport godot.annotation.Script\nimport godot.api.Area2D\n\n@Script\nclass Coin : Area2D() {\n    @Export\n    var value: Int = 1\n}\n")
			write(DOOR, "package game;\n\nimport godot.annotation.Export;\nimport godot.annotation.Script;\nimport godot.api.Node;\n\n@Script\npublic class Door extends Node {\n    @Export\n    public int width = 2;\n}\n")
			, "Build"],
		["delete Door.java and Hud.scala while Hud is in the scene", func():
			DirAccess.remove_absolute(ProjectSettings.globalize_path(DOOR))
			DirAccess.remove_absolute(ProjectSettings.globalize_path(HUD))
			, "Build"],
		["player base Node2D to CharacterBody2D", func():
			write(PLAYER, player_source("CharacterBody2D", PLAYER_MEMBERS))
			, "Build"],
		["compile error in player", func():
			write(PLAYER, player_source("CharacterBody2D", "    @Export\n    var speed: Int = \n"))
			, "Build"],
		["fix player and add armor", func():
			write(PLAYER, player_source("CharacterBody2D", PLAYER_MEMBERS_ARMOR))
			, "Build"],
		["fast build: enemy hp default 20", func():
			write(ENEMY, enemy_source(20, ""))
			, "Fast Build"],
		["build with no change", func(): pass, "Build"],
		["bootstrap change: coroutines off", func():
			write("res://build.gradle.kts", FileAccess.get_file_as_string("res://build.gradle.kts").replace("isGodotCoroutinesEnabled.set(true)", "isGodotCoroutinesEnabled.set(false)"))
			, "Build"],
		["save the scene", func():
			EditorInterface.save_scene()
			, ""],
	]


func report(title: String) -> void:
	match phase_index:
		0:
			expect(gradle_succeeded(), "first build succeeds")
			expect_classes({"Enemy": "Node", "HelloGodot": "Node", "Hud": "Control", "Player": "Node2D"})
		1:
			expect_player("Node2D", ["speed", "nickname"], ["jump"], ["hit"])
			expect(node_members("Enemy").get("props") == ["hp"], "Enemy exposes hp")
			expect(node_members("Hud").get("props") == ["title"], "Hud exposes title")
		2:
			expect(gradle_succeeded(), "build succeeds")
			expect_player("Node2D", ["speed", "jump_height"], ["jump", "dash"], ["hit", "landed"])
		3:
			expect_classes({"Coin": "Area2D", "Door": "Node", "Enemy": "Node", "HelloGodot": "Node", "Hud": "Control", "Player": "Node2D"})
		4:
			expect_classes({"Coin": "Area2D", "Enemy": "Node", "HelloGodot": "Node", "Player": "Node2D"})
			expect(node_members("Hud").get("props") == ["title"], "the Hud node keeps its script after the source is deleted")
		5:
			expect_classes({"Coin": "Area2D", "Enemy": "Node", "HelloGodot": "Node", "Player": "CharacterBody2D"})
			expect_player("CharacterBody2D", ["speed", "jump_height"], ["jump", "dash"], ["hit", "landed"])
		6:
			expect(not gradle_succeeded(), "a compile error fails the build")
			expect(jvm_status().ends_with("Ready"), "the JVM stays ready after a failed build: " + jvm_status())
			expect_player("CharacterBody2D", ["speed", "jump_height"], ["jump", "dash"], ["hit", "landed"])
		7:
			expect(gradle_succeeded(), "build succeeds after the fix")
			expect_player("CharacterBody2D", ["speed", "jump_height", "armor"], ["jump", "dash"], ["hit", "landed"])
		8:
			expect(gradle_succeeded(), "fast build succeeds")
			expect(EditorInterface.get_edited_scene_root().get_node("Enemy").get("hp") == 20, "fast build applies the new hp default")
		9:
			expect(gradle_succeeded(), "a build without change succeeds")
			expect(jvm_status().ends_with("Ready"), "status after an unchanged build: " + jvm_status())
		10:
			expect("Bootstrap modified" in jvm_status(), "status reports the bootstrap change: " + jvm_status())
			expect(toasts().any(func(t): return "bootstrap" in String(t).to_lower()), "a toast asks for a restart: %s" % [toasts()])
		11:
			var scene := FileAccess.get_file_as_string("res://main.tscn")
			expect("speed = 9" in scene, "the saved scene keeps the speed set in the editor")
			expect("armor" not in scene, "the saved scene does not store untouched defaults")
