#ifndef GODOT_JVM_KT_RPC_CONFIG_H
#define GODOT_JVM_KT_RPC_CONFIG_H

#include "jvm/jni/types.h"
#include "jvm/wrapper/jvm_instance_wrapper.h"

#include <classes/multiplayer_api.hpp>
#include <classes/multiplayer_peer.hpp>
#include <variant/dictionary.hpp>

JVM_INSTANCE_WRAPPER(KtRpcConfig, "godot.registration.KtRpcConfig") {
    JVM_CLASS(KtRpcConfig)

    // clang-format off
    JNI_INT_METHOD(GET_RPC_MODE_ID)
    JNI_BOOLEAN_METHOD(GET_RPC_CALL_LOCAL)
    JNI_INT_METHOD(GET_RPC_TRANSFER_MODE_ID)
    JNI_INT_METHOD(GET_RPC_CHANNEL)

    INIT_JNI_BINDINGS(
        INIT_JNI_METHOD(GET_RPC_MODE_ID, "getRpcModeId", "()I")
        INIT_JNI_METHOD(GET_RPC_CALL_LOCAL, "getRpcCallLocal", "()Z")
        INIT_JNI_METHOD(GET_RPC_TRANSFER_MODE_ID, "getRpcTransferModeId", "()I")
        INIT_JNI_METHOD(GET_RPC_CHANNEL, "getRpcChannel", "()I")
    )
    // clang-format on

public:
    explicit KtRpcConfig(jni::Env & p_env, jni::JObject p_wrapped);
    ~KtRpcConfig() = default;

    godot::MultiplayerAPI::RPCMode rpc_mode;
    godot::MultiplayerPeer::TransferMode rpc_transfer_mode;
    bool rpc_call_local;
    int rpc_channel;

    godot::Dictionary toRpcConfigDictionary();
};

#endif // GODOT_JVM_KT_RPC_CONFIG_H
