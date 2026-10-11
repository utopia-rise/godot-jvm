extends "common.gd"

# Global class list after a class is renamed in the script editor while its tab is open, and after its file is moved.

const COIN := "res://src/main/kotlin/game/Coin.kt"
const COIN_MOVED := "res://src/main/kotlin/moved/Coin.kt"


func setup_phases() -> void:
	phases = [
		["first build", func():
			write(COIN, "package game\n\nimport godot.annotation.Export\nimport godot.annotation.Script\nimport godot.api.Area2D\n\n@Script\nclass Coin : Area2D() {\n    @Export\n    var value: Int = 1\n}\n")
			, "Build"],
		["open Coin.kt", func():
			EditorInterface.edit_script(load(COIN))
			, ""],
		["change its package in the script editor and save", func():
			var code := EditorInterface.get_script_editor().get_current_editor().get_base_editor() as CodeEdit
			code.text = code.text.replace("package game", "package loot")
			save_current_script()
			, ""],
		["close the tab", func(): close_current_script(), ""],
		["build after the rename", func(): pass, "Build"],
		["move Coin.kt to another folder", func():
			DirAccess.make_dir_recursive_absolute(ProjectSettings.globalize_path(COIN_MOVED.get_base_dir()))
			DirAccess.rename_absolute(ProjectSettings.globalize_path(COIN), ProjectSettings.globalize_path(COIN_MOVED))
			EditorInterface.get_resource_filesystem().scan()
			, ""],
		["build after the move", func(): pass, "Build"],
	]


func report(_title: String) -> void:
	var open_scripts := EditorInterface.get_script_editor().get_open_scripts().map(func(s): return s.resource_path)
	match phase_index:
		0:
			expect(gradle_succeeded(), "first build succeeds")
			expect_classes({"Coin": "Area2D", "HelloGodot": "Node"})
		1:
			expect(COIN in open_scripts, "Coin.kt is open: %s" % [open_scripts])
		2:
			expect(not global_classes().has("Coin"), "the renamed class leaves the list until the next build: %s" % [global_classes().keys()])
		3:
			expect(open_scripts.is_empty(), "the tab is closed: %s" % [open_scripts])
		4:
			expect(gradle_succeeded(), "build succeeds after the rename")
			expect_classes({"Coin": "Area2D", "HelloGodot": "Node"})
			expect(global_classes().get("Coin", {}).get("path") == COIN, "Coin is listed at its file")
		5:
			expect(global_classes().get("Coin", {}).get("path") == COIN_MOVED, "Coin is listed at its new path: %s" % global_classes().get("Coin"))
		6:
			expect(gradle_succeeded(), "build succeeds after the move")
			expect(global_classes().get("Coin", {}).get("path") == COIN_MOVED, "Coin stays at its new path after the build: %s" % global_classes().get("Coin"))
