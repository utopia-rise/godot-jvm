
#ifdef TOOLS_ENABLED

#ifndef GODOT_JVM_BUILD_MANAGER_H
#define GODOT_JVM_BUILD_MANAGER_H

#include <classes/file_access.hpp>
#include <variant/string.hpp>

namespace godot {
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
        Ref<FileAccess> stdio;
        Ref<FileAccess> stderr_io;
        int pid = -1;

        GradleTaskRunner() = default;

        void reset();

    public:
        static GradleTaskRunner& get_instance();
        void cleanup();

        GradleTaskRunner(const GradleTaskRunner&) = delete;
        GradleTaskRunner& operator=(const GradleTaskRunner&) = delete;

        Error run_task(int task_id, String& log, bool blocking);
        bool is_task_started();
        bool is_task_running();
        int finish_task();
        void get_task_output(String& log, String& error);
    };
} // namespace godot

#endif // GODOT_JVM_BUILD_MANAGER_H

#endif // TOOLS_ENABLED
