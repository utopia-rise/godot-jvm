#ifndef GODOT_JVM_KTCLASS_H
#define GODOT_JVM_KTCLASS_H

#include "engine/internal.h"
#include "jvm/jni/wrapper.h"
#include "jvm/jvm_instance_wrapper.h"
#include "kt_constructor.h"
#include "kt_function.h"
#include "kt_object.h"
#include "kt_process.h"
#include "kt_signal_info.h"

#include <core/defs.hpp>
#include <templates/hash_set.hpp>
#include <templates/vector.hpp>

namespace godot {
    class JvmScript;
} // namespace godot

JVM_INSTANCE_WRAPPER(KtClass, "godot.registration.KtClass") {
    JVM_CLASS(KtClass)

    // clang-format off
    JNI_OBJECT_METHOD(GET_REGISTERED_NAME)
    JNI_OBJECT_METHOD(GET_FQDN)
    JNI_OBJECT_METHOD(GET_SOURCE_FILE_NAME)
    JNI_OBJECT_METHOD(GET_REGISTERED_SUPERTYPES)
    JNI_BOOLEAN_METHOD(IS_ABSTRACT)
    JNI_OBJECT_METHOD(GET_BASE_GODOT_CLASS)
    JNI_OBJECT_METHOD(GET_FUNCTIONS)
    JNI_OBJECT_METHOD(GET_PROCESS)
    JNI_OBJECT_METHOD(GET_PHYSICS_PROCESS)
    JNI_OBJECT_METHOD(GET_PROPERTIES)
    JNI_OBJECT_METHOD(GET_SIGNAL_INFOS)
    JNI_OBJECT_METHOD(GET_CONSTRUCTOR)
    JNI_OBJECT_METHOD(GET_HANDLED_NOTIFICATIONS)
    JNI_VOID_METHOD(DO_NOTIFICATION)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(GET_REGISTERED_NAME, "getRegisteredName", "()Ljava/lang/String;")
        INIT_JNI_METHOD(GET_FQDN, "getFqdn", "()Ljava/lang/String;")
        INIT_JNI_METHOD(GET_SOURCE_FILE_NAME, "getSourceFileName", "()Ljava/lang/String;")
        INIT_JNI_METHOD(GET_REGISTERED_SUPERTYPES, "getRegisteredSupertypes", "()[Ljava/lang/String;")
        INIT_JNI_METHOD(IS_ABSTRACT, "isAbstract", "()Z")
        INIT_JNI_METHOD(GET_BASE_GODOT_CLASS, "getBaseGodotClass", "()Ljava/lang/String;")
        INIT_JNI_METHOD(GET_FUNCTIONS, "getFunctions", "()[Lgodot/registration/KtFunction;")
        INIT_JNI_METHOD(GET_PROCESS, "getProcess", "()Lgodot/registration/KtProcess;")
        INIT_JNI_METHOD(GET_PHYSICS_PROCESS, "getPhysicsProcess", "()Lgodot/registration/KtProcess;")
        INIT_JNI_METHOD(GET_PROPERTIES, "getProperties", "()[Lgodot/registration/KtProperty;")
        INIT_JNI_METHOD(GET_SIGNAL_INFOS, "getSignalInfos", "()[Lgodot/registration/KtSignalInfo;")
        INIT_JNI_METHOD(GET_CONSTRUCTOR, "getConstructor", "()Lgodot/registration/KtConstructor;")
        INIT_JNI_METHOD(GET_HANDLED_NOTIFICATIONS, "getHandledNotifications", "()[I")
        INIT_JNI_METHOD(DO_NOTIFICATION, "doNotification", "(Lgodot/core/KtObject;)V")
    )

    friend class godot::JvmScript;
    // clang-format on

public:
    godot::StringName registered_class_name;
    godot::StringName fqdn;
    godot::String source_file_name;
    godot::Vector<godot::StringName> registered_supertypes;
    godot::StringName base_godot_class;
    bool is_abstract;

    explicit KtClass(jni::Env& p_env, jni::JObject p_wrapped);

    ~KtClass();

    jni::JObject construct(jni::Env& env, godot::GodotObject* p_owner);
    bool can_zero_init() const;

    KtFunction* get_method(const godot::StringName& methodName);

    bool has_method(const godot::StringName& p_name) const;
    int get_method_argument_count(const godot::StringName& p_name) const;
    bool get_method_info(const godot::StringName& p_name, godot::MethodInfo& r_info) const;

    KtProperty* get_property(const godot::StringName& p_property_name);

    KtSignalInfo* get_signal(const godot::StringName& p_signal_name);

    void get_method_list(godot::List<godot::MethodInfo>* p_list);

    void get_property_list(godot::List<godot::PropertyInfo>* p_list);

    void get_signal_list(godot::List<godot::MethodInfo>* p_list);

    void fetch_members(jni::Env& env);

    const godot::Dictionary get_rpc_config();

    _FORCE_INLINE_ bool handles_notification(int p_notification) const {
        return !handled_notifications.is_empty() && handled_notifications.has(p_notification);
    }

    _NO_INLINE_ void do_notification(jni::Env& env, KtObject* p_instance, int p_notification, bool p_reversed);

    void call(
        jni::Env& p_env,
        KtObject* p_instance,
        const godot::StringName& p_name,
        const godot::Variant** p_args,
        int p_argument_count,
        godot::Variant& r_ret,
        GDExtensionCallError& r_error
    );

private:
    KtProcess* process = nullptr;
    KtProcess* physics_process = nullptr;

    engine::IdentityMap<KtFunction*> methods;
    engine::IdentityMap<KtProperty*> properties;
    engine::IdentityMap<KtSignalInfo*> signal_infos;
    godot::Vector<KtProperty*> property_list;

    KtConstructor* kt_constructor;
    godot::HashSet<int> handled_notifications;

    godot::String get_registered_name(jni::Env& env);

    godot::String get_fqdn(jni::Env& env);

    godot::String get_source_file_name(jni::Env& env);

    godot::StringName get_base_godot_class(jni::Env& env);

    void fetch_handled_notifications(jni::Env& env);

    void fetch_registered_supertypes(jni::Env& env);

    void fetch_methods(jni::Env& env);

    KtProcess* fetch_process(jni::Env& env, jni::ObjectMethodID p_getter);

    void fetch_properties(jni::Env& env);

    void fetch_signals(jni::Env& env);

    void fetch_constructor(jni::Env& env);

    KtProcess* resolve_process(const godot::StringName& p_name) const;

    template<typename F, typename M>
    void get_member_list(godot::List<F>* p_list, M& members) {
        for (const auto& E : members) {
            p_list->push_back(E.value->get_member_info());
        }
    }

    template<class M>
    void delete_members(M& members) {
        for (const auto& E : members) {
            delete E.value;
        }
        members.clear();
    }
};

#endif // GODOT_JVM_KTCLASS_H
