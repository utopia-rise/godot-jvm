// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import kotlin.Suppress
import kotlin.Unit

/**
 * JavaScriptObject is used to interact with JavaScript objects retrieved or created via
 * [JavaScriptBridge.getInterface], [JavaScriptBridge.createObject], or
 * [JavaScriptBridge.createCallback].
 *
 * ```
 * extends Node
 *
 * var _my_js_callback = JavaScriptBridge.create_callback(myCallback) # This reference must be kept
 * var console = JavaScriptBridge.get_interface("console")
 *
 * func _init():
 * 	var buf = JavaScriptBridge.create_object("ArrayBuffer", 10) # new ArrayBuffer(10)
 * 	print(buf) # Prints [JavaScriptObject:OBJECT_ID]
 * 	var uint8arr = JavaScriptBridge.create_object("Uint8Array", buf) # new Uint8Array(buf)
 * 	uint8arr[1] = 255
 * 	prints(uint8arr[1], uint8arr.byteLength) # Prints "255 10"
 *
 * 	# Prints "Uint8Array(10) [ 0, 255, 0, 0, 0, 0, 0, 0, 0, 0 ]" in the browser's console.
 * 	console.log(uint8arr)
 *
 * 	# Equivalent of JavaScriptBridge: Array.from(uint8arr).forEach(myCallback)
 * 	JavaScriptBridge.get_interface("Array").from(uint8arr).forEach(_my_js_callback)
 *
 * func myCallback(args):
 * 	# Will be called with the parameters passed to the "forEach" callback
 * 	# [0, 0, [JavaScriptObject:1173]]
 * 	# [255, 1, [JavaScriptObject:1173]]
 * 	# ...
 * 	# [0, 9, [JavaScriptObject:1180]]
 * 	print(args)
 * ```
 *
 * **Note:** Only available in the Web platform.
 */
@GodotBaseType
public open class JavaScriptObject internal constructor() : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(339, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
