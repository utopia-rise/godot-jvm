#include "editor/strings.h"
#include "gradle_task_runner.h"
#include "logging.h"

#include <classes/project_settings.hpp>

using namespace godot;

String get_build_gradle_path() {
    ProjectSettings* project_settings = ProjectSettings::get_singleton();
    String gradle_wrapper_path = project_settings->globalize_path(project_settings->get_setting(GRADLE_DIR));
    return gradle_wrapper_path.path_join("build.gradle.kts");
}

String get_gradlew_path() {
#if defined _WIN32 || defined _WIN64
    String gradle_wrapper = "gradlew.bat";
#else
    String gradle_wrapper = "gradlew";
#endif
    ProjectSettings* project_settings = ProjectSettings::get_singleton();
    String gradle_wrapper_path = project_settings->globalize_path(project_settings->get_setting(GRADLE_DIR));
    return gradle_wrapper_path.path_join(gradle_wrapper);
}

Error GradleTaskRunner::run_task(int task_id, String& log, bool blocking) {
    JVM_ERR_FAIL_COND_V_MSG(!FileAccess::file_exists(get_build_gradle_path()), Error::ERR_FILE_NOT_FOUND, missing_gradle_project);

    PackedStringArray args = PackedStringArray();
    switch (task_id) {
        case Task::BUILD_DEBUG:
            args.push_back("build");
            break;
        case Task::FAST_BUILD:
            args.push_back("fastBuild");
            break;
        case Task::BUILD_RELEASE:
            args.push_back("buildRelease");
            break;
        case Task::BUILD_ANDROID_DEBUG:
            args.push_back("buildAndroid");
            break;
        case Task::BUILD_ANDROID_RELEASE:
            args.push_back("buildAndroidRelease");
            break;
        case Task::BUILD_GRAAL_NATIVE_IMAGE_DEBUG:
            args.push_back("buildGraalNativeImage");
            break;
        case Task::BUILD_GRAAL_NATIVE_IMAGE_RELEASE:
            args.push_back("buildGraalNativeImageRelease");
            break;
        case Task::BUILD_IOS_DEBUG:
            args.push_back("buildIOS");
            break;
        case Task::BUILD_IOS_RELEASE:
            args.push_back("buildIOSRelease");
            break;
        case Task::GENERATE_EMBEDDED_JVM:
            args.push_back("generateEmbeddedJre");
            break;
        default:
            return Error::ERR_INVALID_PARAMETER;
    }

    String gradlew_path = get_gradlew_path();

    if (blocking) {
        Array output;
        int exit_code = OS::get_singleton()->execute(gradlew_path, args, output, true, false);
        for (int i = 0; i < output.size(); ++i) {
            String line = output[i];
            log += line + "\n";
        }
        if (exit_code == -1) { return Error::ERR_BUG; }
        return Error::OK;
    }

    Dictionary info = OS::get_singleton()->execute_with_pipe(gradlew_path, args, /*blocking=*/false);
    if (info.is_empty()) { JVM_ERR_FAIL_V_MSG(Error::ERR_CANT_CREATE, "Failed to start process"); }
    log = vformat("Running gradle task: %s", args.get(0));
    stdio = info["stdio"];
    stderr_io = info["stderr"];
    pid = info["pid"];
    return Error::OK;
}

GradleTaskRunner& GradleTaskRunner::get_instance() {
    static GradleTaskRunner instance;
    return instance;
}

bool GradleTaskRunner::is_task_started() {
    return pid > -1;
}

bool GradleTaskRunner::is_task_terminated() {
    bool ret = !OS::get_singleton()->is_process_running(pid);
    if (ret) { reset(); }
    return ret;
}

void GradleTaskRunner::get_task_output(String& log, String& error) {
    if (stdio.is_valid()) {
        // keep reading until no full line is available
        Error err;
        do {
            String line = stdio->get_line();
            err = stdio->get_error();
            if (!line.is_empty()) { log += line + "\n"; }
        } while (err == OK);
    }

    if (stderr_io.is_valid()) {
        // keep reading until no full line is available
        Error err;
        do {
            String line = stderr_io->get_line();
            err = stderr_io->get_error();
            if (!line.is_empty()) { error += line + "\n"; }
        } while (err == OK);
    }
}

void GradleTaskRunner::reset() {
    stdio.unref();
    stderr_io.unref();
    pid = -1;
}

void GradleTaskRunner::cleanup() {
    reset();
}
