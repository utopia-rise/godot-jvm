package com.utopiarise.godotjvm

import org.godotengine.godot.Godot
import org.godotengine.godot.plugin.GodotPlugin

class GodotJvmPlugin(godot: Godot) : GodotPlugin(godot) {
    init {
        nativeInitialize()
    }

    override fun getPluginName() = "GodotJvm"

    override fun getPluginGDExtensionLibrariesPaths() = setOf("res://addons/jvm/jvm.gdextension")

    private external fun nativeInitialize()

    companion object {
        init {
            System.loadLibrary("godot_jvm")
        }
    }
}
