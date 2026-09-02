#include "kt_rpc_config.h"

KtRpcConfig::KtRpcConfig(jni::Env& p_env, jni::JObject p_wrapped) : JvmInstanceWrapper(p_env, p_wrapped) {
    jni::Env env {jni::Jvm::current_env()};

    rpc_mode = static_cast<godot::MultiplayerAPI::RPCMode>(wrapped.call_int_method(env, GET_RPC_MODE_ID));
    rpc_call_local = wrapped.call_boolean_method(env, GET_RPC_CALL_LOCAL);
    rpc_transfer_mode = static_cast<godot::MultiplayerPeer::TransferMode>(wrapped.call_int_method(env, GET_RPC_TRANSFER_MODE_ID));
    rpc_channel = wrapped.call_int_method(env, GET_RPC_CHANNEL);
}

godot::Dictionary KtRpcConfig::toRpcConfigDictionary() {
    godot::Dictionary rpc_config {};

    // for key's to set, take a look at SceneRPCInterface::_parse_rpc_config and/or GDScriptParser::rpc_annotation
    rpc_config["rpc_mode"] = rpc_mode;
    rpc_config["transfer_mode"] = rpc_transfer_mode;
    rpc_config["call_local"] = rpc_call_local;
    rpc_config["channel"] = rpc_channel;

    return rpc_config;
}
