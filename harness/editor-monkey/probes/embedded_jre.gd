extends "common.gd"

# Generating the embedded JRE from the toolbar: a first run, a run with nothing changed, a run over the existing JRE
# after a module was added, a run after the JRE was deleted by hand, which Gradle must not consider up to date, and a
# run over a leftover empty directory, which jlink refuses to write into.


func jre_directory() -> String:
	var arch := "arm64" if OS.has_feature("arm64") else "amd64"
	var os := "macos" if OS.has_feature("macos") else "windows" if OS.has_feature("windows") else "linux"
	return ProjectSettings.globalize_path("res://jvm/jre-%s-%s" % [arch, os])


func generate_jre_task() -> String:
	if OS.has_feature("macos"):
		return "Generate JRE (arm64)" if OS.has_feature("arm64") else "Generate JRE (x86_64)"
	return "Generate JRE"


func delete_directory(path: String) -> void:
	for directory in DirAccess.get_directories_at(path):
		delete_directory(path.path_join(directory))
	for file in DirAccess.get_files_at(path):
		DirAccess.remove_absolute(path.path_join(file))
	DirAccess.remove_absolute(path)


func release() -> String:
	return FileAccess.get_file_as_string(jre_directory().path_join("release"))


func expect_jre(description: String) -> void:
	expect(gradle_succeeded(), description + ": Generate JRE succeeds")
	expect("generateEmbeddedJre UP-TO-DATE" not in gradle_task_dialog_text(), description + ": the task runs")
	expect("JAVA_VERSION=\"17." in release(), "%s: the JRE comes from the JDK 17 toolchain: %s" % [description, release().get_slice("\n", 0)])


func setup_phases() -> void:
	phases = [
		["generate the JRE", func(): pass, generate_jre_task()],
		["generate it again, nothing changed", func(): find_dialog("Gradle Task Runner").hide(), generate_jre_task()],
		["add a module and generate it again over the existing JRE", func():
			find_dialog("Gradle Task Runner").hide()
			write("res://build.gradle.kts", FileAccess.get_file_as_string("res://build.gradle.kts")
				+ "\ntasks.withType<godot.gradle.tasks.GenerateEmbeddedJreTask> {\n    modules = arrayOf(\"java.base\", \"java.logging\", \"jdk.jdwp.agent\")\n}\n")
			, generate_jre_task()],
		["delete the JRE and generate it again", func():
			find_dialog("Gradle Task Runner").hide()
			delete_directory(jre_directory())
			, generate_jre_task()],
		["leave an empty JRE directory and generate it again", func():
			find_dialog("Gradle Task Runner").hide()
			delete_directory(jre_directory())
			DirAccess.make_dir_recursive_absolute(jre_directory())
			, generate_jre_task()],
	]


func report(title: String) -> void:
	match phase_index:
		1:
			expect(gradle_succeeded(), title + ": Generate JRE succeeds")
			expect("generateEmbeddedJre UP-TO-DATE" in gradle_task_dialog_text(), title + ": the task is up to date")
		2:
			expect_jre(title)
			expect("jdk.jdwp.agent" in release(), title + ": the JRE contains the added module")
		_:
			expect_jre(title)
