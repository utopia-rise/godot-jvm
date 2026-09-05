#include "kt_class.h"

#include "jvm/wrapper/memory/transfer_context.h"
#include "logging.h"

KtClass::KtClass(jni::Env& p_env, jni::JObject p_wrapped) :
  JvmInstanceWrapper(p_env, p_wrapped),
  kt_constructor(nullptr) {
    LOCAL_FRAME(5);
    registered_class_name = get_registered_name(p_env);
    fqdn = get_fqdn(p_env);
    source_file_name = get_source_file_name(p_env);
    base_godot_class = get_base_godot_class(p_env);
    is_abstract = wrapped.call_boolean_method(p_env, IS_ABSTRACT);
    fetch_handled_notifications(p_env);
}

KtClass::~KtClass() {
    delete_members(methods);
    delete_members(properties);
    delete_members(signal_infos);
    delete kt_constructor;
}

KtObject* KtClass::create_instance(jni::Env& env, godot::GodotObject* p_owner) {
    KtObject* jvm_instance = kt_constructor->create_instance(env, p_owner);
    JVM_DEV_VERBOSE("Instantiated a Jvm script: %s", registered_class_name);

    return jvm_instance;
}

KtFunction* KtClass::get_method(const godot::StringName& methodName) {
    KtFunction** method = methods.getptr(methodName);
    return method ? *method : nullptr;
}

KtProperty* KtClass::get_property(const godot::StringName& p_property_name) {
    KtProperty** property = properties.getptr(p_property_name);
    return property ? *property : nullptr;
}

KtSignalInfo* KtClass::get_signal(const godot::StringName& p_signal_name) {
    KtSignalInfo** signal_info = signal_infos.getptr(p_signal_name);
    return signal_info ? *signal_info : nullptr;
}

godot::String KtClass::get_registered_name(jni::Env& env) {
    jni::JObject ret = wrapped.call_object_method(env, GET_REGISTERED_NAME);
    return env.from_jstring(jni::JString((jstring) ret.obj));
}

godot::String KtClass::get_fqdn(jni::Env& env) {
    jni::JObject ret = wrapped.call_object_method(env, GET_FQDN);
    return env.from_jstring(jni::JString((jstring) ret.obj));
}

godot::String KtClass::get_source_file_name(jni::Env& env) {
    jni::JObject ret = wrapped.call_object_method(env, GET_SOURCE_FILE_NAME);
    return env.from_jstring(jni::JString((jstring) ret.obj));
}

bool KtClass::can_zero_init() const {
    return kt_constructor != nullptr;
}

godot::StringName KtClass::get_base_godot_class(jni::Env& env) {
    jni::JObject ret = wrapped.call_object_method(env, GET_BASE_GODOT_CLASS);
    return {env.from_jstring(jni::JString((jstring) ret.obj))};
}

void KtClass::fetch_handled_notifications(jni::Env& env) {
    jni::JIntArray notifications = jni::JIntArray(wrapped.call_object_method(env, GET_HANDLED_NOTIFICATIONS));
    const int count = notifications.length(env);
    godot::Vector<jint> values;
    values.resize(count);
    notifications.get_array_elements(env, values.ptrw(), count);
    for (int i = 0; i < count; ++i) { handled_notifications.insert(values[i]); }
    notifications.delete_local_ref(env);
}

void KtClass::fetch_registered_supertypes(jni::Env& env) {
    jni::JObjectArray classesArray = jni::JObjectArray(wrapped.call_object_method(env, GET_REGISTERED_SUPERTYPES));
    for (int i = 0; i < classesArray.length(env); i++) {
        godot::StringName parent_name = godot::StringName(env.from_jstring(jni::JString(classesArray.get(env, i))));
        registered_supertypes.append(parent_name);
        JVM_DEV_VERBOSE("%s user type is parent of %s.", parent_name, registered_class_name);
    }
    classesArray.delete_local_ref(env);
}

void KtClass::fetch_methods(jni::Env& env) {
    jni::JObjectArray functionsArray = jni::JObjectArray(wrapped.call_object_method(env, GET_FUNCTIONS));
    for (int i = 0; i < functionsArray.length(env); i++) {
        jni::JObject object = functionsArray.get(env, i);
        auto* ktFunction = new KtFunction(env, object);
        methods[ktFunction->get_name()] = ktFunction;
        JVM_DEV_VERBOSE("Fetched method %s for class %s", ktFunction->get_name(), registered_class_name);
    }
    functionsArray.delete_local_ref(env);
}

void KtClass::fetch_properties(jni::Env& env) {
    jni::JObjectArray propertiesArray = jni::JObjectArray(wrapped.call_object_method(env, GET_PROPERTIES));
    for (int i = 0; i < propertiesArray.length(env); i++) {
        auto* ktProperty = new KtProperty(env, propertiesArray.get(env, i));
        properties[ktProperty->get_name()] = ktProperty;
        JVM_DEV_VERBOSE("Fetched property %s for class %s", ktProperty->get_name(), registered_class_name);
    }
    propertiesArray.delete_local_ref(env);
}

void KtClass::fetch_signals(jni::Env& env) {
    jni::JObjectArray signal_info_array = jni::JObjectArray(wrapped.call_object_method(env, GET_SIGNAL_INFOS));
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
}

void KtClass::get_property_list(godot::List<godot::PropertyInfo>* p_list) {
    get_member_list(p_list, properties);
}

void KtClass::get_signal_list(godot::List<godot::MethodInfo>* p_list) {
    get_member_list(p_list, signal_infos);
}

const godot::Dictionary KtClass::get_rpc_config() {
    godot::Dictionary rpc_configs = godot::Dictionary();

    for (const godot::KeyValue<godot::StringName, KtFunction*>& E : methods) {
        rpc_configs[E.key] = E.value->get_rpc_config()->toRpcConfigDictionary();
    }

    return rpc_configs;
}

void KtClass::do_notification(jni::Env& env, KtObject* p_instance, int p_notification, bool p_reversed) {
    if (!handled_notifications.has(p_notification)) { return; }

    godot::Variant notification = p_notification;
    godot::Variant reversed = p_reversed;
    const int arg_size = 2;
    const godot::Variant* args[arg_size] = {&notification, &reversed};

    TransferContext::get_instance().write_args(env, args, arg_size);

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
