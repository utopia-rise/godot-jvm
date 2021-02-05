#include "kt_class.h"
#include "gd_kotlin.h"
#include "logging.h"

JNI_INIT_STATICS_FOR_CLASS(KtClass)

KtClass::KtClass(jni::JObject p_wrapped, jni::JObject& p_class_loader) :
    JavaInstanceWrapper("godot.core.KtClass", p_wrapped, p_class_loader) {
    jni::Env env { jni::Jvm::current_env() };
    name = get_name(env);
    registered_class_name = get_registered_name(env);
    super_class = get_super_class(env);
    base_godot_class = get_base_godot_class(env);
    fetch_methods(env);
    fetch_properties(env);
    fetch_signals(env);
}

KtClass::~KtClass() {
    delete_members(methods);
    delete_members(properties);
    delete_members(signal_infos);
}

KtObject* KtClass::create_instance(jni::Env& env, const Variant** p_args, int p_arg_count, Object* p_owner) {
    jni::MethodId new_method { get_method_id(env, jni_methods.NEW) };
    // TODO: send args
    jvalue args[3] = {
            jni::to_jni_arg(p_owner),
            jni::to_jni_arg(p_owner->get_instance_id()),
            jni::to_jni_arg(p_arg_count)
    };
    jni::JObject j_kt_object{wrapped.call_object_method(env, new_method, args)};
    logging::verbose(vformat("Instantiated an object of type %s", name));
    return new KtObject(j_kt_object, class_loader, name);
}

KtFunction* KtClass::get_method(const StringName& methodName) {
    KtFunction** method = methods.getptr(methodName);
    return method ? *method : nullptr;
}

KtProperty* KtClass::get_property(const StringName& p_property_name) {
    KtProperty** property = properties.getptr(p_property_name);
    return property ? *property : nullptr;
}

KtSignalInfo* KtClass::get_signal(const StringName& p_signal_name) {
    KtSignalInfo** signal_info {signal_infos.getptr(p_signal_name)};
    return signal_info ? *signal_info : nullptr;
}

StringName KtClass::get_name(jni::Env& env) {
    jni::MethodId getter { get_method_id(env, jni_methods.GET_NAME) };
    jni::JObject ret { wrapped.call_object_method(env, getter) };
    return StringName(env.from_jstring(jni::JString((jstring) ret.obj)));
}

String KtClass::get_registered_name(jni::Env& env) {
    jni::MethodId getter{get_method_id(env, jni_methods.GET_REGISTERED_NAME)};
    jni::JObject ret{wrapped.call_object_method(env, getter)};
    return env.from_jstring(jni::JString((jstring) ret.obj));
}

StringName KtClass::get_super_class(jni::Env& env) {
    jni::MethodId getter { get_method_id(env, jni_methods.GET_SUPER_CLASS) };
    jni::JObject ret { wrapped.call_object_method(env, getter) };
    return StringName(env.from_jstring(jni::JString((jstring) ret.obj)));
}

StringName KtClass::get_base_godot_class(jni::Env& env) {
    jni::MethodId getter{get_method_id(env, jni_methods.GET_BASE_GODOT_CLASS)};
    jni::JObject ret{wrapped.call_object_method(env, getter)};
    return StringName(env.from_jstring(jni::JString((jstring) ret.obj)));
}

void KtClass::fetch_methods(jni::Env& env) {
    jni::MethodId getFunctionsMethod { get_method_id(env, jni_methods.GET_FUNCTIONS) };
    jni::JObjectArray functionsArray { wrapped.call_object_method(env, getFunctionsMethod) };
    for (int i = 0; i < functionsArray.length(env); i++) {
        auto* ktFunction { new KtFunction(functionsArray.get(env, i), GDKotlin::get_instance().get_class_loader()) };
        methods[ktFunction->get_name()] = ktFunction;
        logging::verbose(vformat("Fetched method %s for class %s", ktFunction->get_name(), name));
    }
}

void KtClass::fetch_properties(jni::Env& env) {
    jni::MethodId getPropertiesMethod { get_method_id(env, jni_methods.GET_PROPERTIES) };
    jni::JObjectArray propertiesArray { wrapped.call_object_method(env, getPropertiesMethod) };
    for (int i = 0; i < propertiesArray.length(env); i++) {
        auto* ktProperty { new KtProperty(propertiesArray.get(env, i), GDKotlin::get_instance().get_class_loader()) };
        properties[ktProperty->get_name()] = ktProperty;
        logging::verbose(vformat("Fetched property %s for class %s", ktProperty->get_name(), name));
    }
}

void KtClass::fetch_signals(jni::Env& env) {
    jni::MethodId get_signal_infos_method{get_method_id(env, jni_methods.GET_SIGNAL_INFOS)};
    jni::JObjectArray signal_info_array{wrapped.call_object_method(env, get_signal_infos_method)};
    for (int i = 0; i < signal_info_array.length(env); i++) {
        auto* kt_signal_info{
            new KtSignalInfo(signal_info_array.get(env, i), GDKotlin::get_instance().get_class_loader())
        };
        signal_infos[kt_signal_info->name] = kt_signal_info;
        logging::verbose(vformat("Fetched signal %s for class %s", kt_signal_info->name, name));
    }
}

void KtClass::get_method_list(List<MethodInfo>* p_list) {
    get_member_list(p_list, methods);
}

void KtClass::get_property_list(List<PropertyInfo>* p_list) {
    get_member_list(p_list, properties);
}

void KtClass::get_signal_list(List<MethodInfo>* p_list) {
    get_member_list(p_list, signal_infos);
}
