
#ifdef TOOLS_ENABLED

#ifndef GODOT_JVM_BUILD_MANAGER_H
#define GODOT_JVM_BUILD_MANAGER_H

#include <classes/file_access.hpp>
#include <variant/string.hpp>

class GradleTaskRunner {
public:
    enum Task {
        BUILD_DEBUG,
        FAST_BUILD,
        BUILD_RELEASE,
        BUILD_ANDROID_DEBUG,
        BUILD_ANDROID_RELEASE,
        BUILD_GRAAL_NATIVE_IMAGE_DEBUG,
        BUILD_GRAAL_NATIVE_IMAGE_RELEASE,
        BUILD_IOS_DEBUG,
        BUILD_IOS_RELEASE,
        GENERATE_EMBEDDED_JVM
    };

private:
    godot::Ref<godot::FileAccess> stdio;
    godot::Ref<godot::FileAccess> stderr_io;
    int pid = -1;

    GradleTaskRunner() = default;

    void reset();

public:
    static GradleTaskRunner& get_instance();
    void cleanup();

    GradleTaskRunner(const GradleTaskRunner&) = delete;
    GradleTaskRunner& operator=(const GradleTaskRunner&) = delete;

    godot::Error run_task(int task_id, godot::String& log, bool blocking);
    bool is_task_started();
    bool is_task_terminated();
    void get_task_output(godot::String& log, godot::String& error);
};

#endif // GODOT_JVM_BUILD_MANAGER_H

#endif // TOOLS_ENABLED
