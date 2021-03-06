#ifndef GODOT_JVM_GD_KOTLIN_H
#define GODOT_JVM_GD_KOTLIN_H

#include "jni/wrapper.h"
#include "bootstrap.h"
#include "kt_class.h"
#include "core/map.h"
#include "core/ustring.h"
#include "transfer_context.h"
#include "modules/kotlin_jvm/src/bridges/memory_bridge.h"
#include "kotlin_script.h"

class GDKotlin {
private:
    GDKotlin();

    ~GDKotlin() = default;

    Map<StringName, KtClass*> classes;

    Bootstrap* bootstrap;

    bool is_gc_started;

    Error split_jvm_debug_argument(const String& cmd_arg, String& result);

    static void check_and_copy_jar(const String& jar_name);

public:
    TransferContext* transfer_context;
    Vector<StringName> engine_type_names;
    Vector<MethodBind*> engine_type_method;
    Vector<String> engine_singleton_names;

    Vector<Ref<KotlinScript>> user_scripts;

    GDKotlin(const GDKotlin&) = delete;

    static GDKotlin& get_instance();

    GDKotlin& operator=(const GDKotlin&) = delete;

    void init();

    void finish();

    void register_classes(jni::Env& p_env, jni::JObjectArray p_classes);

    void register_members(jni::Env& p_env);

    void unregister_classes(jni::Env& p_env, jni::JObjectArray p_classes);

    KtClass* find_class(const StringName& p_script_path);
};


#endif //GODOT_JVM_GD_KOTLIN_H
