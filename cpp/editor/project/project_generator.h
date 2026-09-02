#ifndef GODOT_JVM_PROJECTGENERATOR_H
#define GODOT_JVM_PROJECTGENERATOR_H

#include "logging.h"
#include "templates.h"

namespace godot {
    class ProjectGenerator {
    public:
        static void generate_jvm_files(bool erase_existing);
    };
} // namespace godot
#endif // GODOT_JVM_PROJECTGENERATOR_H
