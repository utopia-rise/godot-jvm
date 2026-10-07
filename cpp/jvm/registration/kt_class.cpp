#include "kt_class.h"

#include "compiler.h"
#include "engine/godot_object.h"
#include "jvm/memory/variant_buffer.h"
#include "jvm/registration/kt_object.h"
#include "logging.h"

KtClass::KtClass(jni::Env& p_env, jni::JObject p_wrapped) :
    JvmInstanceWrapper(p_env, p_wrapped),
    kt_constructor(nullptr) {
    registered_class_name = get_registered_name(p_env);
    fqdn = get_fqdn(p_env);
    source_file_name = get_source_file_name(p_env);
    base_godot_class = get_base_godot_class(p_env);
    is_abstract = wrapped.call_boolean_method(p_env, IS_ABSTRACT);
    fetch_handled_notifications(p_env);
}

KtClass::~KtClass() {
    delete process;
    delete physics_process;
    delete_members(methods);
    for (KtProperty* property : property_list) {
        delete property;
    }
    delete_members(signal_infos);
    delete kt_constructor;
}

jni::JObject KtClass::construct(jni::Env& env, godot::GodotObject* p_owner) {
    jni::JObject jvm_instance = kt_constructor->construct(env, p_owner);
    JVM_DEV_VERBOSE("Instantiated a Jvm script: %s", registered_class_name);

    return jvm_instance;
}

JVM_FLATTEN KtFunction* KtClass::get_method(const godot::StringName& methodName) {
    KtFunction** method = methods.getptr(methodName);
    return method ? *method : nullptr;
}

KtProcess* KtClass::resolve_process(const godot::StringName& p_name) const {
    if (process && engine::same_name(p_name, process->name)) { return process; }
    if (physics_process && engine::same_name(p_name, physics_process->name)) { return physics_process; }
    return nullptr;
}

// Dispatches a call from the engine: the two per-frame virtuals are tested first and take their direct entry.
JVM_FLATTEN void KtClass::call(
    jni::Env& p_env,
    KtObject* p_instance,
    const godot::StringName& p_name,
    const godot::Variant** p_args,
    int p_argument_count,
    godot::Variant& r_ret,
    GDExtensionCallError& r_error
) {
    if (KtProcess* kt_process = resolve_process(p_name)) {
        JVM_DEV_ASSERT(p_argument_count == 1, "%s called with %s arguments.", p_name, p_argument_count);
        kt_process->invoke(p_env, p_instance, p_args[0]->operator double());
        r_error.error = GDEXTENSION_CALL_OK;
        return;
    }
    if (KtFunction* function = get_method(p_name)) {
        function->invoke(p_env, p_instance, p_args, p_argument_count, r_ret);
        r_error.error = GDEXTENSION_CALL_OK;
        return;
    }
    r_error.error = GDEXTENSION_CALL_ERROR_INVALID_METHOD;
}

bool KtClass::has_method(const godot::StringName& p_name) const {
    return resolve_process(p_name) || methods.has(p_name);
}

int KtClass::get_method_argument_count(const godot::StringName& p_name) const {
    if (resolve_process(p_name)) { return 1; }
    KtFunction* const* method = methods.getptr(p_name);
    return method ? (*method)->get_parameter_count() : -1;
}

bool KtClass::get_method_info(const godot::StringName& p_name, godot::MethodInfo& r_info) const {
    if (KtProcess* kt_process = resolve_process(p_name)) {
        r_info = kt_process->get_member_info();
        return true;
    }
    KtFunction* const* method = methods.getptr(p_name);
    if (!method) { return false; }
    r_info = (*method)->get_member_info();
    return true;
}

JVM_FLATTEN KtProperty* KtClass::get_property(const godot::StringName& p_property_name) {
    KtProperty** property = properties.getptr(p_property_name);
    return property ? *property : nullptr;
}

JVM_FLATTEN KtSignalInfo* KtClass::get_signal(const godot::StringName& p_signal_name) {
    KtSignalInfo** signal_info = signal_infos.getptr(p_signal_name);
    return signal_info ? *signal_info : nullptr;
}

godot::String KtClass::get_registered_name(jni::Env& env) {
    jni::JObject ret = wrapped.call_object_method(env, GET_REGISTERED_NAME);
    godot::String name = env.from_jstring(jni::JString((jstring) ret.obj));
    ret.delete_local_ref(env);
    return name;
}

godot::String KtClass::get_fqdn(jni::Env& env) {
    jni::JObject ret = wrapped.call_object_method(env, GET_FQDN);
    godot::String fqdn_value = env.from_jstring(jni::JString((jstring) ret.obj));
    ret.delete_local_ref(env);
    return fqdn_value;
}

godot::String KtClass::get_source_file_name(jni::Env& env) {
    jni::JObject ret = wrapped.call_object_method(env, GET_SOURCE_FILE_NAME);
    godot::String file_name = env.from_jstring(jni::JString((jstring) ret.obj));
    ret.delete_local_ref(env);
    return file_name;
}

bool KtClass::can_zero_init() const {
    return kt_constructor != nullptr;
}

godot::StringName KtClass::get_base_godot_class(jni::Env& env) {
    jni::JObject ret = wrapped.call_object_method(env, GET_BASE_GODOT_CLASS);
    godot::StringName class_name(env.from_jstring(jni::JString((jstring) ret.obj)));
    ret.delete_local_ref(env);
    return class_name;
}

void KtClass::fetch_handled_notifications(jni::Env& env) {
    jni::JIntArray notifications(wrapped.call_object_method(env, GET_HANDLED_NOTIFICATIONS));
    const int count = notifications.length(env);
    godot::Vector<jint> values;
    values.resize(count);
    notifications.get_array_elements(env, values.ptrw(), count);
    for (int i = 0; i < count; ++i) {
        handled_notifications.insert(values[i]);
    }
    notifications.delete_local_ref(env);
}

void KtClass::fetch_registered_supertypes(jni::Env& env) {
    jni::JObjectArray classesArray(wrapped.call_object_method(env, GET_REGISTERED_SUPERTYPES));
    for (int i = 0; i < classesArray.length(env); i++) {
        jni::JString parent(classesArray.get(env, i));
        godot::StringName parent_name = godot::StringName(env.from_jstring(parent));
        parent.delete_local_ref(env);
        registered_supertypes.append(parent_name);
        JVM_DEV_VERBOSE("%s user type is parent of %s.", parent_name, registered_class_name);
    }
    classesArray.delete_local_ref(env);
}

void KtClass::fetch_methods(jni::Env& env) {
    jni::JObjectArray functionsArray(wrapped.call_object_method(env, GET_FUNCTIONS));
    for (int i = 0; i < functionsArray.length(env); i++) {
        jni::JObject object = functionsArray.get(env, i);
        auto* ktFunction = new KtFunction(env, object);
        methods[ktFunction->get_name()] = ktFunction;
        JVM_DEV_VERBOSE("Fetched method %s for class %s", ktFunction->get_name(), registered_class_name);
    }
    functionsArray.delete_local_ref(env);

    process = fetch_process(env, GET_PROCESS);
    physics_process = fetch_process(env, GET_PHYSICS_PROCESS);
}

KtProcess* KtClass::fetch_process(jni::Env& env, jni::ObjectMethodID p_getter) {
    jni::JObject object = wrapped.call_object_method(env, p_getter);
    if (object.obj == nullptr) { return nullptr; }
    auto* kt_process = new KtProcess(env, object);
    JVM_DEV_VERBOSE("Fetched %s for class %s", kt_process->name, registered_class_name);
    return kt_process;
}

void KtClass::fetch_properties(jni::Env& env) {
    jni::JObjectArray propertiesArray(wrapped.call_object_method(env, GET_PROPERTIES));
    for (int i = 0; i < propertiesArray.length(env); i++) {
        auto* ktProperty = new KtProperty(env, propertiesArray.get(env, i));
        property_list.append(ktProperty);
        if (!ktProperty->is_property_list_marker()) { properties[ktProperty->get_name()] = ktProperty; }
        JVM_DEV_VERBOSE("Fetched property %s for class %s", ktProperty->get_name(), registered_class_name);
    }
    propertiesArray.delete_local_ref(env);
}

void KtClass::fetch_signals(jni::Env& env) {
    jni::JObjectArray signal_info_array(wrapped.call_object_method(env, GET_SIGNAL_INFOS));
    for (int i = 0; i < signal_info_array.length(env); i++) {
        auto* kt_signal_info = new KtSignalInfo(env, signal_info_array.get(env, i));
        signal_infos[kt_signal_info->name] = kt_signal_info;
        JVM_DEV_VERBOSE("Fetched signal %s for class %s", kt_signal_info->name, registered_class_name);
    }
    signal_info_array.delete_local_ref(env);
}

void KtClass::fetch_constructor(jni::Env& env) {
    jni::JObject constructor = wrapped.call_object_method(env, GET_CONSTRUCTOR);
    if (constructor.obj != nullptr) {
        kt_constructor = new KtConstructor(env, constructor);
        JVM_DEV_VERBOSE("Fetched constructor for class %s", registered_class_name);
    }
}

void KtClass::get_method_list(godot::List<godot::MethodInfo>* p_list) {
    get_member_list(p_list, methods);
    if (process) { p_list->push_back(process->get_member_info()); }
    if (physics_process) { p_list->push_back(physics_process->get_member_info()); }
}

void KtClass::get_property_list(godot::List<godot::PropertyInfo>* p_list) {
    for (KtProperty* property : property_list) {
        p_list->push_back(property->get_member_info());
    }
}

void KtClass::get_signal_list(godot::List<godot::MethodInfo>* p_list) {
    get_member_list(p_list, signal_infos);
}

const godot::Dictionary KtClass::get_rpc_config() {
    godot::Dictionary rpc_configs = godot::Dictionary();

    for (const godot::KeyValue<godot::StringName, KtFunction*>& E : methods) {
        rpc_configs[E.value->get_name()] = E.value->get_rpc_config()->toRpcConfigDictionary();
    }

    return rpc_configs;
}

void KtClass::do_notification(jni::Env& env, KtObject* p_instance, int p_notification, bool p_reversed) {
    if (p_instance->is_collected(env)) { return; }

    VariantBuffer::Transfer* transfer = VariantBuffer::get_transfer();

    godot::Variant notification = p_notification;
    godot::Variant reversed = p_reversed;
    const int arg_size = 2;
    const godot::Variant* args[arg_size] = {&notification, &reversed};

    transfer->encode_args(args, arg_size);

    jvalue call_args[1] = {jni::to_jni_arg(p_instance->get_wrapped())};
    wrapped.call_void_method(env, DO_NOTIFICATION, call_args);
}

void KtClass::fetch_members(jni::Env& env) {
    fetch_registered_supertypes(env);
    fetch_methods(env);
    fetch_properties(env);
    fetch_signals(env);
    fetch_constructor(env);
}
