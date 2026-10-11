extends SceneTree

# Base of every probe: runs inside the real editor (`godot -e --path . -s probes/<probe>.gd`), drives it
# through EditorInterface and the editor's own controls, and prints `[MONKEY]` lines the run script checks.
# A probe fills `phases` with [title, action, gradle task label or ""]. Each phase runs the action, runs the
# task when one is given and waits for its dialog, then calls `report`.

var phases: Array = []
var phase_index := -1
var state := "next"
var frame := 0
var wait_until := 0
var build_started := 0
var failures := 0
var done := false
var generated := false


func log_line(text: String) -> void:
	print("[MONKEY] ", text)


func expect(condition: bool, description: String) -> void:
	if not condition:
		failures += 1
		log_line("FAIL " + description)


func write(path: String, content: String) -> void:
	DirAccess.make_dir_recursive_absolute(ProjectSettings.globalize_path(path.get_base_dir()))
	var file := FileAccess.open(path, FileAccess.WRITE)
	file.store_string(content)
	file.close()


func find_dialog(title: String) -> AcceptDialog:
	for node in root.find_children("*", "AcceptDialog", true, false):
		if (node as AcceptDialog).title == title:
			return node
	return null


func find_button(text: String) -> Button:
	for node in root.find_children("*", "Button", true, false):
		if (node as Button).text == text:
			return node
	return null


func jvm_status() -> String:
	for node in root.find_children("*", "TextureRect", true, false):
		var tooltip: String = (node as TextureRect).tooltip_text
		if tooltip.begins_with("JVM status"):
			return tooltip
	return "no status light"


func toasts() -> Array:
	var result := []
	for toaster in root.find_children("*", "EditorToaster", true, false):
		for label in toaster.find_children("*", "Label", true, false):
			if (label as Label).text != "":
				result.append((label as Label).text)
		for label in toaster.find_children("*", "RichTextLabel", true, false):
			if (label as RichTextLabel).get_parsed_text() != "":
				result.append((label as RichTextLabel).get_parsed_text())
	return result


func gradle_task_dialog_text() -> String:
	var dialog := find_dialog("Gradle Task Runner")
	if dialog == null:
		return ""
	var text := ""
	for label in dialog.find_children("*", "Label", true, false):
		text += (label as Label).text
	return text


func run_gradle_task(label: String) -> void:
	for node in root.find_children("*", "OptionButton", true, false):
		var option := node as OptionButton
		if option.item_count == 0 or option.get_item_text(0) != "Build":
			continue
		for i in option.item_count:
			if option.get_item_text(i) == label:
				option.select(i)
				find_button("Run Gradle").pressed.emit()
				return
	expect(false, "gradle task not found in the toolbar: " + label)


func gradle_running() -> bool:
	var text := gradle_task_dialog_text()
	return not ("succeeded" in text or "failed" in text)


func gradle_succeeded() -> bool:
	return "succeeded" in gradle_task_dialog_text()


func global_classes() -> Dictionary:
	var result := {}
	for entry in ProjectSettings.get_global_class_list():
		if String(entry["path"]).begins_with("res://src"):
			result[String(entry["class"])] = {"base": String(entry["base"]), "path": String(entry["path"])}
	return result


func expect_classes(expected: Dictionary) -> void:
	var actual := global_classes()
	var actual_names := actual.keys()
	var expected_names := expected.keys()
	actual_names.sort()
	expected_names.sort()
	expect(actual_names == expected_names, "global classes %s, expected %s" % [actual_names, expected_names])
	for name in expected:
		if actual.has(name):
			expect(actual[name]["base"] == expected[name], "%s inherits %s, expected %s" % [name, actual[name]["base"], expected[name]])


func script_members(script: Script) -> Dictionary:
	if script == null:
		return {}
	return {
		"base": script.get_instance_base_type(),
		"props": script.get_script_property_list().filter(func(p): return p["usage"] & PROPERTY_USAGE_SCRIPT_VARIABLE).map(func(p): return p["name"]),
		"methods": script.get_script_method_list().map(func(m): return m["name"]).filter(func(n): return not String(n).begins_with("_")),
		"signals": script.get_script_signal_list().map(func(s): return s["name"]),
	}


func close_current_script() -> void:
	for node in EditorInterface.get_script_editor().find_children("*", "MenuButton", true, false):
		var popup := (node as MenuButton).get_popup()
		for i in popup.item_count:
			if popup.get_item_text(i) == "Close":
				popup.id_pressed.emit(popup.get_item_id(i))
				return
	expect(false, "no Close item in the script editor")


func save_current_script() -> void:
	for node in EditorInterface.get_script_editor().find_children("*", "MenuButton", true, false):
		var popup := (node as MenuButton).get_popup()
		for i in popup.item_count:
			if popup.get_item_text(i) == "Save":
				popup.id_pressed.emit(popup.get_item_id(i))
				return
	expect(false, "no Save item in the script editor")


func wait(frames: int) -> void:
	wait_until = frame + frames


# The project starts without any JVM file: the editor offers to generate them, the probe accepts, then points the
# generated build at the repository sources like every harness project. The configuration cache cannot hold a Kotlin
# plugin that comes from an included build, so it is turned off like in the other harness projects.
func generate_project() -> bool:
	if not FileAccess.file_exists("res://build.gradle.kts"):
		var dialog := find_dialog("JVM project generation")
		if dialog == null:
			return false
		if not dialog.visible:
			dialog.popup_centered()
		dialog.get_ok_button().pressed.emit()
		return false
	expect(FileAccess.file_exists("res://src/main/kotlin/godot/HelloGodot.kt"), "the generated project contains HelloGodot.kt")
	expect(FileAccess.file_exists("res://gradlew"), "the generated project contains the Gradle wrapper")
	write("res://settings.gradle.kts", FileAccess.get_file_as_string("res://settings.gradle.kts") + "\napply(from = \"../godot-jvm-builds.settings.gradle.kts\")\n")
	write("res://gradle.properties", FileAccess.get_file_as_string("res://gradle.properties").replace("org.gradle.configuration-cache=true", "org.gradle.configuration-cache=false") + "\norg.gradle.daemon=false\nkotlin.compiler.execution.strategy=in-process\n")
	return true


func setup_phases() -> void:
	pass


func report(_title: String) -> void:
	pass


func finish() -> void:
	pass


func _process(_delta: float) -> bool:
	frame += 1
	if done or frame < 90 or frame < wait_until:
		return false
	if not generated:
		generated = generate_project()
		if generated:
			log_line("JVM project generated")
			EditorInterface.get_resource_filesystem().scan()
			wait(120)
		else:
			wait(30)
		return false
	if phases.is_empty():
		setup_phases()
	match state:
		"next":
			phase_index += 1
			if phase_index >= phases.size():
				finish()
				done = true
				log_line("DONE with %d failure(s)" % failures)
				quit(1 if failures > 0 else 0)
				return false
			var phase: Array = phases[phase_index]
			log_line("===== phase %d: %s" % [phase_index, phase[0]])
			(phase[1] as Callable).call()
			if phase[2] != "":
				run_gradle_task(phase[2])
				build_started = frame
				state = "building"
				wait(60)
			else:
				state = "report"
				wait(120)
		"building":
			if gradle_running() and frame - build_started < 20000:
				wait(60)
				return false
			log_line("gradle: " + gradle_task_dialog_text().strip_edges().right(100).replace("\n", " / "))
			state = "report"
			wait(300)
		"report":
			log_line("status: %s | toasts: %s | classes: %s" % [jvm_status(), toasts(), global_classes().keys()])
			report(phases[phase_index][0])
			state = "next"
			wait(30)
	return false
