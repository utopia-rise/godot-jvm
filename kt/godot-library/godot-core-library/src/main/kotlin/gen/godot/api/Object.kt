// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.BitFieldBase
import godot.core.Callable
import godot.core.Dictionary
import godot.core.Error
import godot.core.KtObject
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.NodePath
import godot.core.Signal
import godot.core.Signal0
import godot.core.StringName
import godot.core.VariantArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.CALLABLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.NODE_PATH
import godot.core.VariantParser.STRING
import godot.core.VariantParser.STRING_NAME
import godot.core.asCachedNodePath
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

public infix fun Long.or(other: Object.ConnectFlags): Long = this.or(other.flag)

public infix fun Long.xor(other: Object.ConnectFlags): Long = this.xor(other.flag)

public infix fun Long.and(other: Object.ConnectFlags): Long = this.and(other.flag)

/**
 * An advanced [Any] type. All classes in the engine inherit from Object. Each class may define new
 * properties, methods or signals, which are available to all inheriting classes. For example, a
 * [Sprite2D] instance is able to call [Node.addChild] because it inherits from [Node].
 *
 * You can create new instances, using `Object.new()` in GDScript, or `new GodotObject` in C#.
 *
 * To delete an Object instance, call [free]. This is necessary for most classes inheriting Object,
 * because they do not manage memory on their own, and will otherwise cause memory leaks when no longer
 * in use. There are a few classes that perform memory management. For example, [RefCounted] (and by
 * extension [Resource]) deletes itself when no longer referenced, and [Node] deletes its children when
 * freed.
 *
 * Objects can have a [Script] attached to them. Once the [Script] is instantiated, it effectively
 * acts as an extension to the base class, allowing it to define and inherit new properties, methods
 * and signals.
 *
 * Inside a [Script], [_getPropertyList] may be overridden to customize properties in several ways.
 * This allows them to be available to the editor, display as lists of options, sub-divide into groups,
 * save on disk, etc. Scripting languages offer easier ways to customize properties, such as with the
 * `@export` annotation.
 *
 * Godot is very dynamic. An object's script, and therefore its properties, methods and signals, can
 * be changed at run-time. Because of this, there can be occasions where, for example, a property
 * required by a method may not exist. To prevent run-time errors, see methods such as [set], [get],
 * [call], [hasMethod], [hasSignal], etc. Note that these methods are **much** slower than direct
 * references.
 *
 * In GDScript, you can also check if a given property, method, or signal name exists in an object
 * with the `in` operator:
 *
 * ```
 * var node = Node.new()
 * print("name" in node)         # Prints true
 * print("get_parent" in node)   # Prints true
 * print("tree_entered" in node) # Prints true
 * print("unknown" in node)      # Prints false
 * ```
 *
 * Notifications are [Long] constants commonly sent and received by objects. For example, on every
 * rendered frame, the [SceneTree] notifies nodes inside the tree with a [Node.NOTIFICATION_PROCESS].
 * The nodes receive it and may call [Node.Process] to update. To make use of notifications, see
 * [notification] and [_notification].
 *
 * Lastly, every object can also contain metadata (data about data). [setMeta] can be useful to
 * store information that the object itself does not depend on. To keep your code clean, making
 * excessive use of metadata is discouraged.
 *
 * **Note:** Unlike references to a [RefCounted], references to an object stored in a variable can
 * become invalid without being set to `null`. To check if an object has been deleted, do *not* compare
 * it against `null`. Instead, use [@GlobalScope.isInstanceValid]. It's also recommended to inherit
 * from [RefCounted] for classes storing data instead of [Object].
 *
 * **Note:** The `script` is not exposed like most properties. To set or get an object's [Script] in
 * code, use [setScript] and [getScript], respectively.
 *
 * **Note:** In a boolean context, an [Object] will evaluate to `false` if it is equal to `null` or
 * it has been freed. Otherwise, an [Object] will always evaluate to `true`. See also
 * [@GlobalScope.isInstanceValid].
 */
@GodotBaseType
public open class Object : KtObject() {
  /**
   * Emitted when the object's script is changed.
   *
   * **Note:** When this signal is emitted, the new script is not initialized yet. If you need to
   * access the new script, defer connections to this signal with [CONNECT_DEFERRED].
   */
  public val scriptChanged: Signal0 by Signal0

  /**
   * Emitted when [notifyPropertyListChanged] is called.
   */
  public val propertyListChanged: Signal0 by Signal0

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(0, scriptPtr)
  }

  /**
   * Returns the object's built-in class name, as a [String]. See also [isClass].
   *
   * **Note:** This method ignores `class_name` declarations. If this object's script has defined a
   * `class_name`, the base, built-in class name is returned instead.
   */
  public final fun getGodotClass(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getClassPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns `true` if the object inherits from the given [class]. See also [getClass].
   *
   * ```gdscript
   * //gdscript
   * var sprite2d = Sprite2D.new()
   * sprite2d.is_class("Sprite2D") # Returns true
   * sprite2d.is_class("Node")     # Returns true
   * sprite2d.is_class("Node3D")   # Returns false
   * ```
   *
   * ```csharp
   * //csharp
   * var sprite2D = new Sprite2D();
   * sprite2D.IsClass("Sprite2D"); // Returns true
   * sprite2D.IsClass("Node");     // Returns true
   * sprite2D.IsClass("Node3D");   // Returns false
   * ```
   *
   * **Note:** This method ignores `class_name` declarations in the object's script.
   */
  public final fun isClass(`class`: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to `class`)
    TransferContext.callMethod(MethodBindings.isClassPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Assigns [value] to the given [property]. If the property does not exist or the given [value]'s
   * type doesn't match, nothing happens.
   *
   * ```gdscript
   * //gdscript
   * var node = Node2D.new()
   * node.set("global_scale", Vector2(8, 2.5))
   * print(node.global_scale) # Prints (8.0, 2.5)
   * ```
   *
   * ```csharp
   * //csharp
   * var node = new Node2D();
   * node.Set(Node2D.PropertyName.GlobalScale, new Vector2(8, 2.5f));
   * GD.Print(node.GlobalScale); // Prints (8, 2.5)
   * ```
   *
   * **Note:** In C#, [property] must be in snake_case when referring to built-in Godot properties.
   * Prefer using the names exposed in the `PropertyName` class to avoid allocating a new [StringName]
   * on each call.
   */
  public final fun `set`(`property`: StringName, `value`: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to property, ANY to value)
    TransferContext.callMethod(MethodBindings.setPtr)
  }

  /**
   * Returns the [Any] value of the given [property]. If the [property] does not exist, this method
   * returns `null`.
   *
   * ```gdscript
   * //gdscript
   * var node = Node2D.new()
   * node.rotation = 1.5
   * var a = node.get("rotation") # a is 1.5
   * ```
   *
   * ```csharp
   * //csharp
   * var node = new Node2D();
   * node.Rotation = 1.5f;
   * var a = node.Get(Node2D.PropertyName.Rotation); // a is 1.5
   * ```
   *
   * **Note:** In C#, [property] must be in snake_case when referring to built-in Godot properties.
   * Prefer using the names exposed in the `PropertyName` class to avoid allocating a new [StringName]
   * on each call.
   */
  public final fun `get`(`property`: StringName): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to property)
    TransferContext.callMethod(MethodBindings.getPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Assigns a new [value] to the property identified by the [propertyPath]. The path should be a
   * [NodePath] relative to this object, and can use the colon character (`:`) to access nested
   * properties.
   *
   * ```gdscript
   * //gdscript
   * var node = Node2D.new()
   * node.set_indexed("position", Vector2(42, 0))
   * node.set_indexed("position:y", -10)
   * print(node.position) # Prints (42.0, -10.0)
   * ```
   *
   * ```csharp
   * //csharp
   * var node = new Node2D();
   * node.SetIndexed("position", new Vector2(42, 0));
   * node.SetIndexed("position:y", -10);
   * GD.Print(node.Position); // Prints (42, -10)
   * ```
   *
   * **Note:** In C#, [propertyPath] must be in snake_case when referring to built-in Godot
   * properties. Prefer using the names exposed in the `PropertyName` class to avoid allocating a new
   * [StringName] on each call.
   */
  public final fun setIndexed(propertyPath: NodePath, `value`: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, NODE_PATH to propertyPath, ANY to value)
    TransferContext.callMethod(MethodBindings.setIndexedPtr)
  }

  /**
   * Gets the object's property indexed by the given [propertyPath]. The path should be a [NodePath]
   * relative to the current object and can use the colon character (`:`) to access nested properties.
   *
   * **Examples:** `"position:x"` or `"material:next_pass:blend_mode"`.
   *
   * ```gdscript
   * //gdscript
   * var node = Node2D.new()
   * node.position = Vector2(5, -10)
   * var a = node.get_indexed("position")   # a is Vector2(5, -10)
   * var b = node.get_indexed("position:y") # b is -10
   * ```
   *
   * ```csharp
   * //csharp
   * var node = new Node2D();
   * node.Position = new Vector2(5, -10);
   * var a = node.GetIndexed("position");   // a is Vector2(5, -10)
   * var b = node.GetIndexed("position:y"); // b is -10
   * ```
   *
   * **Note:** In C#, [propertyPath] must be in snake_case when referring to built-in Godot
   * properties. Prefer using the names exposed in the `PropertyName` class to avoid allocating a new
   * [StringName] on each call.
   *
   * **Note:** This method does not support actual paths to nodes in the [SceneTree], only
   * sub-property paths. In the context of nodes, use [Node.getNodeAndResource] instead.
   */
  public final fun getIndexed(propertyPath: NodePath): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, NODE_PATH to propertyPath)
    TransferContext.callMethod(MethodBindings.getIndexedPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns the object's property list as an [VariantArray] of dictionaries. Each [Dictionary]
   * contains the following entries:
   *
   * - `name` is the property's name, as a [String];
   *
   * - `class_name` is an empty [StringName], unless the property is [TYPE_OBJECT] and it inherits
   * from a class;
   *
   * - `type` is the property's type, as an [Long] (see [Variant.Type]);
   *
   * - `hint` is *how* the property is meant to be edited (see [PropertyHint]);
   *
   * - `hint_string` depends on the hint (see [PropertyHint]);
   *
   * - `usage` is a combination of [PropertyUsageFlags].
   *
   * **Note:** In GDScript, all class members are treated as properties. In C# and GDExtension, it
   * may be necessary to explicitly mark class members as Godot properties using decorators or
   * attributes.
   */
  public final fun getPropertyList(): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPropertyListPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns this object's methods and their signatures as an [VariantArray] of dictionaries. Each
   * [Dictionary] contains the following entries:
   *
   * - `name` is the name of the method, as a [String];
   *
   * - `args` is an [VariantArray] of dictionaries representing the arguments;
   *
   * - `default_args` is the default arguments as an [VariantArray] of variants;
   *
   * - `flags` is a combination of [MethodFlags];
   *
   * - `id` is the method's internal identifier [Long];
   *
   * - `return` is the returned value, as a [Dictionary];
   *
   * **Note:** The dictionaries of `args` and `return` are formatted identically to the results of
   * [getPropertyList], although not all entries are used.
   */
  public final fun getMethodList(): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMethodListPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns `true` if the given [property] has a custom default value. Use [propertyGetRevert] to
   * get the [property]'s default value.
   *
   * **Note:** This method is used by the Inspector dock to display a revert icon. The object must
   * implement [_propertyCanRevert] to customize the default value. If [_propertyCanRevert] is not
   * implemented, this method returns `false`.
   */
  public final fun propertyCanRevert(`property`: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to property)
    TransferContext.callMethod(MethodBindings.propertyCanRevertPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the custom default value of the given [property]. Use [propertyCanRevert] to check if
   * the [property] has a custom default value.
   *
   * **Note:** This method is used by the Inspector dock to display a revert icon. The object must
   * implement [_propertyGetRevert] to customize the default value. If [_propertyGetRevert] is not
   * implemented, this method returns `null`.
   */
  public final fun propertyGetRevert(`property`: StringName): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to property)
    TransferContext.callMethod(MethodBindings.propertyGetRevertPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Sends the given [what] notification to all classes inherited by the object, triggering calls to
   * [_notification], starting from the highest ancestor (the [Object] class) and going down to the
   * object's script.
   *
   * If [reversed] is `true`, the call order is reversed.
   *
   * ```gdscript
   * //gdscript
   * var player = Node2D.new()
   * player.set_script(load("res://player.gd"))
   *
   * player.notification(NOTIFICATION_ENTER_TREE)
   * # The call order is Object -> Node -> Node2D -> player.gd.
   *
   * player.notification(NOTIFICATION_ENTER_TREE, true)
   * # The call order is player.gd -> Node2D -> Node -> Object.
   * ```
   *
   * ```csharp
   * //csharp
   * var player = new Node2D();
   * player.SetScript(GD.Load("res://player.gd"));
   *
   * player.Notification(NotificationEnterTree);
   * // The call order is GodotObject -> Node -> Node2D -> player.gd.
   *
   * player.Notification(NotificationEnterTree, true);
   * // The call order is player.gd -> Node2D -> Node -> GodotObject.
   * ```
   */
  @JvmOverloads
  public final fun notification(what: Int, reversed: Boolean = false): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to what.toLong(), BOOL to reversed)
    TransferContext.callMethod(MethodBindings.notificationPtr)
  }

  /**
   * Returns a [String] representing the object. Defaults to `"<ClassName#RID>"`. Override
   * [_toString] to customize the string representation of the object.
   */
  public final override fun toString(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.toStringPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the object's unique instance ID. This ID can be saved in [EncodedObjectAsID], and can
   * be used to retrieve this object instance with [@GlobalScope.instanceFromId].
   *
   * **Note:** This ID is only useful during the current session. It won't correspond to a similar
   * object if the ID is sent over a network, or loaded from a file at a later time.
   */
  public final fun getInstanceId(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInstanceIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Attaches [script] to the object, and instantiates it. As a result, the script's [_init] is
   * called. A [Script] is used to extend the object's functionality.
   *
   * If a script already exists, its instance is detached, and its property values and state are
   * lost. Built-in property values are still kept.
   */
  public final fun setScript(script: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ANY to script)
    TransferContext.callMethod(MethodBindings.setScriptPtr)
  }

  /**
   * Returns the object's [Script] instance, or `null` if no script is attached.
   */
  public final fun getScript(): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScriptPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Adds or changes the entry [name] inside the object's metadata. The metadata [value] can be any
   * [Any], although some types cannot be serialized correctly.
   *
   * If [value] is `null`, the entry is removed. This is the equivalent of using [removeMeta]. See
   * also [hasMeta] and [getMeta].
   *
   * **Note:** A metadata's name must be a valid identifier as per [StringName.isValidIdentifier]
   * method.
   *
   * **Note:** Metadata that has a name starting with an underscore (`_`) is considered editor-only.
   * Editor-only metadata is not displayed in the Inspector and should not be edited, although it can
   * still be found by this method.
   */
  public final fun setMeta(name: StringName, `value`: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, ANY to value)
    TransferContext.callMethod(MethodBindings.setMetaPtr)
  }

  /**
   * Removes the given entry [name] from the object's metadata. See also [hasMeta], [getMeta] and
   * [setMeta].
   *
   * **Note:** A metadata's name must be a valid identifier as per [StringName.isValidIdentifier]
   * method.
   *
   * **Note:** Metadata that has a name starting with an underscore (`_`) is considered editor-only.
   * Editor-only metadata is not displayed in the Inspector and should not be edited, although it can
   * still be found by this method.
   */
  public final fun removeMeta(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.removeMetaPtr)
  }

  /**
   * Returns the object's metadata value for the given entry [name]. If the entry does not exist,
   * returns [default]. If [default] is `null`, an error is also generated.
   *
   * **Note:** A metadata's name must be a valid identifier as per [StringName.isValidIdentifier]
   * method.
   *
   * **Note:** Metadata that has a name starting with an underscore (`_`) is considered editor-only.
   * Editor-only metadata is not displayed in the Inspector and should not be edited, although it can
   * still be found by this method.
   */
  @JvmOverloads
  public final fun getMeta(name: StringName, default: Any? = null): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name, ANY to default)
    TransferContext.callMethod(MethodBindings.getMetaPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns `true` if a metadata entry is found with the given [name]. See also [getMeta],
   * [setMeta] and [removeMeta].
   *
   * **Note:** A metadata's name must be a valid identifier as per [StringName.isValidIdentifier]
   * method.
   *
   * **Note:** Metadata that has a name starting with an underscore (`_`) is considered editor-only.
   * Editor-only metadata is not displayed in the Inspector and should not be edited, although it can
   * still be found by this method.
   */
  public final fun hasMeta(name: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.hasMetaPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the object's metadata entry names as an [VariantArray] of [StringName]s.
   */
  public final fun getMetaList(): VariantArray<StringName> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMetaListPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<StringName>)
  }

  /**
   * Adds a user-defined signal named [signal]. Optional arguments for the signal can be added as an
   * [VariantArray] of dictionaries, each defining a `name` [String] and a `type` [Long] (see
   * [Variant.Type]). See also [hasUserSignal] and [removeUserSignal].
   *
   * ```gdscript
   * //gdscript
   * add_user_signal("hurt", [
   * 	{ "name": "damage", "type": TYPE_INT },
   * 	{ "name": "source", "type": TYPE_OBJECT }
   * ])
   * ```
   *
   * ```csharp
   * //csharp
   * AddUserSignal("Hurt",
   * [
   * 	new Godot.Collections.Dictionary()
   * 	{
   * 		{ "name", "damage" },
   * 		{ "type", (int)Variant.Type.Int },
   * 	},
   * 	new Godot.Collections.Dictionary()
   * 	{
   * 		{ "name", "source" },
   * 		{ "type", (int)Variant.Type.Object },
   * 	},
   * ]);
   * ```
   */
  @JvmOverloads
  public final fun addUserSignal(signal: String, arguments: VariantArray<Any?> =
      godot.core.variantArrayOf()): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to signal, ARRAY to arguments)
    TransferContext.callMethod(MethodBindings.addUserSignalPtr)
  }

  /**
   * Returns `true` if the given user-defined [signal] name exists. Only signals added with
   * [addUserSignal] are included. See also [removeUserSignal].
   */
  public final fun hasUserSignal(signal: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to signal)
    TransferContext.callMethod(MethodBindings.hasUserSignalPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Removes the given user signal [signal] from the object. See also [addUserSignal] and
   * [hasUserSignal].
   */
  public final fun removeUserSignal(signal: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to signal)
    TransferContext.callMethod(MethodBindings.removeUserSignalPtr)
  }

  /**
   * Emits the given [signal] by name. The signal must exist, so it should be a built-in signal of
   * this class or one of its inherited classes, or a user-defined signal (see [addUserSignal]). This
   * method supports a variable number of arguments, so parameters can be passed as a comma separated
   * list.
   *
   * Returns [ERR_UNAVAILABLE] if [signal] does not exist or the parameters are invalid.
   *
   * ```gdscript
   * //gdscript
   * emit_signal("hit", "sword", 100)
   * emit_signal("game_over")
   * ```
   *
   * ```csharp
   * //csharp
   * EmitSignal(SignalName.Hit, "sword", 100);
   * EmitSignal(SignalName.GameOver);
   * ```
   *
   * **Note:** In C#, [signal] must be in snake_case when referring to built-in Godot signals.
   * Prefer using the names exposed in the `SignalName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun emitSignal(signal: StringName, vararg args: Any?): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to signal, *args.map { ANY to it }.toTypedArray())
    TransferContext.callMethod(MethodBindings.emitSignalPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Calls the [method] on the object and returns the result. This method supports a variable number
   * of arguments, so parameters can be passed as a comma separated list.
   *
   * ```gdscript
   * //gdscript
   * var node = Node3D.new()
   * node.call("rotate", Vector3(1.0, 0.0, 0.0), 1.571)
   * ```
   *
   * ```csharp
   * //csharp
   * var node = new Node3D();
   * node.Call(Node3D.MethodName.Rotate, new Vector3(1f, 0f, 0f), 1.571f);
   * ```
   *
   * **Note:** In C#, [method] must be in snake_case when referring to built-in Godot methods.
   * Prefer using the names exposed in the `MethodName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun call(method: StringName, vararg args: Any?): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to method, *args.map { ANY to it }.toTypedArray())
    TransferContext.callMethod(MethodBindings.callPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Calls the [method] on the object during idle time. Always returns `null`, **not** the method's
   * result.
   *
   * Idle time happens mainly at the end of process and physics frames. In it, deferred calls will
   * be run until there are none left, which means you can defer calls from other deferred calls and
   * they'll still be run in the current idle time cycle. This means you should not call a method
   * deferred from itself (or from a method called by it), as this causes infinite recursion the same
   * way as if you had called the method directly.
   *
   * This method supports a variable number of arguments, so parameters can be passed as a comma
   * separated list.
   *
   * ```gdscript
   * //gdscript
   * var node = Node3D.new()
   * node.call_deferred("rotate", Vector3(1.0, 0.0, 0.0), 1.571)
   * ```
   *
   * ```csharp
   * //csharp
   * var node = new Node3D();
   * node.CallDeferred(Node3D.MethodName.Rotate, new Vector3(1f, 0f, 0f), 1.571f);
   * ```
   *
   * For methods that are deferred from the same thread, the order of execution at idle time is
   * identical to the order in which [code skip-lint]call_deferred[/code] was called.
   *
   * See also [Callable.callDeferred].
   *
   * **Note:** In C#, [method] must be in snake_case when referring to built-in Godot methods.
   * Prefer using the names exposed in the `MethodName` class to avoid allocating a new [StringName] on
   * each call.
   *
   * **Note:** If you're looking to delay the function call by a frame, refer to the [signal
   * SceneTree.process_frame] and [signal SceneTree.physics_frame] signals.
   *
   * ```
   * var node = Node3D.new()
   * # Make a Callable and bind the arguments to the node's rotate() call.
   * var callable = node.rotate.bind(Vector3(1.0, 0.0, 0.0), 1.571)
   * # Connect the callable to the process_frame signal, so it gets called in the next process
   * frame.
   * # CONNECT_ONE_SHOT makes sure it only gets called once instead of every frame.
   * get_tree().process_frame.connect(callable, CONNECT_ONE_SHOT)
   * ```
   */
  public final fun callDeferred(method: StringName, vararg args: Any?): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to method, *args.map { ANY to it }.toTypedArray())
    TransferContext.callMethod(MethodBindings.callDeferredPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Assigns [value] to the given [property], at the end of the current frame. This is equivalent to
   * calling [set] through [callDeferred].
   *
   * ```gdscript
   * //gdscript
   * var node = Node2D.new()
   * add_child(node)
   *
   * node.rotation = 1.5
   * node.set_deferred("rotation", 3.0)
   * print(node.rotation) # Prints 1.5
   *
   * await get_tree().process_frame
   * print(node.rotation) # Prints 3.0
   * ```
   *
   * ```csharp
   * //csharp
   * var node = new Node2D();
   * node.Rotation = 1.5f;
   * node.SetDeferred(Node2D.PropertyName.Rotation, 3f);
   * GD.Print(node.Rotation); // Prints 1.5
   *
   * await ToSignal(GetTree(), SceneTree.SignalName.ProcessFrame);
   * GD.Print(node.Rotation); // Prints 3.0
   * ```
   *
   * **Note:** In C#, [property] must be in snake_case when referring to built-in Godot properties.
   * Prefer using the names exposed in the `PropertyName` class to avoid allocating a new [StringName]
   * on each call.
   */
  public final fun setDeferred(`property`: StringName, `value`: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to property, ANY to value)
    TransferContext.callMethod(MethodBindings.setDeferredPtr)
  }

  /**
   * Calls the [method] on the object and returns the result. Unlike [call], this method expects all
   * parameters to be contained inside [argArray].
   *
   * ```gdscript
   * //gdscript
   * var node = Node3D.new()
   * node.callv("rotate", [Vector3(1.0, 0.0, 0.0), 1.571])
   * ```
   *
   * ```csharp
   * //csharp
   * var node = new Node3D();
   * node.Callv(Node3D.MethodName.Rotate, [new Vector3(1f, 0f, 0f), 1.571f]);
   * ```
   *
   * **Note:** In C#, [method] must be in snake_case when referring to built-in Godot methods.
   * Prefer using the names exposed in the `MethodName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun callv(method: StringName, argArray: VariantArray<Any?>): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to method, ARRAY to argArray)
    TransferContext.callMethod(MethodBindings.callvPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns `true` if the given [method] name exists in the object.
   *
   * **Note:** In C#, [method] must be in snake_case when referring to built-in Godot methods.
   * Prefer using the names exposed in the `MethodName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun hasMethod(method: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to method)
    TransferContext.callMethod(MethodBindings.hasMethodPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the number of arguments of the given [method] by name.
   *
   * **Note:** In C#, [method] must be in snake_case when referring to built-in Godot methods.
   * Prefer using the names exposed in the `MethodName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun getMethodArgumentCount(method: StringName): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to method)
    TransferContext.callMethod(MethodBindings.getMethodArgumentCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns `true` if the given [signal] name exists in the object.
   *
   * **Note:** In C#, [signal] must be in snake_case when referring to built-in Godot signals.
   * Prefer using the names exposed in the `SignalName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun hasSignal(signal: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to signal)
    TransferContext.callMethod(MethodBindings.hasSignalPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the list of existing signals as an [VariantArray] of dictionaries.
   *
   * **Note:** Due to the implementation, each [Dictionary] is formatted very similarly to the
   * returned values of [getMethodList].
   */
  public final fun getSignalList(): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSignalListPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns an [VariantArray] of connections for the given [signal] name. Each connection is
   * represented as a [Dictionary] that contains three entries:
   *
   * - [code skip-lint]signal[/code] is a reference to the [Signal];
   *
   * - `callable` is a reference to the connected [Callable];
   *
   * - `flags` is a combination of [ConnectFlags].
   */
  public final fun getSignalConnectionList(signal: StringName):
      VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to signal)
    TransferContext.callMethod(MethodBindings.getSignalConnectionListPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns an [VariantArray] of signal connections received by this object. Each connection is
   * represented as a [Dictionary] that contains three entries:
   *
   * - `signal` is a reference to the [Signal];
   *
   * - `callable` is a reference to the [Callable];
   *
   * - `flags` is a combination of [ConnectFlags].
   */
  public final fun getIncomingConnections(): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIncomingConnectionsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Connects a [signal] by name to a [callable]. Optional [flags] can be also added to configure
   * the connection's behavior (see [ConnectFlags] constants).
   *
   * A signal can only be connected once to the same [Callable]. If the signal is already connected,
   * this method returns [ERR_INVALID_PARAMETER] and generates an error, unless the signal is connected
   * with [CONNECT_REFERENCE_COUNTED]. To prevent this, use [isConnected] first to check for existing
   * connections.
   *
   * **Note:** If the [callable]'s object is freed, the connection will be lost.
   *
   * **Note:** In GDScript, it is generally recommended to connect signals with [Signal.connect]
   * instead.
   *
   * **Note:** This method, and all other signal-related methods, are thread-safe.
   */
  @JvmOverloads
  public final fun connect(
    signal: StringName,
    callable: Callable,
    flags: ConnectFlags = Object.ConnectFlags.DEFAULT,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to signal, CALLABLE to callable, LONG to flags.flag)
    TransferContext.callMethod(MethodBindings.connectPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Disconnects a [signal] by name from a given [callable]. If the connection does not exist,
   * generates an error. Use [isConnected] to make sure that the connection exists.
   */
  public final fun disconnect(signal: StringName, callable: Callable): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to signal, CALLABLE to callable)
    TransferContext.callMethod(MethodBindings.disconnectPtr)
  }

  /**
   * Returns `true` if a connection exists between the given [signal] name and [callable].
   *
   * **Note:** In C#, [signal] must be in snake_case when referring to built-in Godot signals.
   * Prefer using the names exposed in the `SignalName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun isConnected(signal: StringName, callable: Callable): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to signal, CALLABLE to callable)
    TransferContext.callMethod(MethodBindings.isConnectedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if any connection exists on the given [signal] name.
   *
   * **Note:** In C#, [signal] must be in snake_case when referring to built-in Godot methods.
   * Prefer using the names exposed in the `SignalName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun hasConnections(signal: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to signal)
    TransferContext.callMethod(MethodBindings.hasConnectionsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If set to `true`, the object becomes unable to emit signals. As such, [emitSignal] and signal
   * connections will not work, until it is set to `false`.
   */
  public final fun setBlockSignals(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setBlockSignalsPtr)
  }

  /**
   * Returns `true` if the object is blocking its signals from being emitted. See [setBlockSignals].
   */
  public final fun isBlockingSignals(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isBlockingSignalsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Emits the [signal property_list_changed] signal. This is mainly used to refresh the editor, so
   * that the Inspector and editor plugins are properly updated.
   */
  public final fun notifyPropertyListChanged(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.notifyPropertyListChangedPtr)
  }

  /**
   * If set to `true`, allows the object to translate messages with [tr] and [trN]. Enabled by
   * default. See also [canTranslateMessages].
   */
  public final fun setMessageTranslation(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setMessageTranslationPtr)
  }

  /**
   * Returns `true` if the object is allowed to translate messages with [tr] and [trN]. See also
   * [setMessageTranslation].
   */
  public final fun canTranslateMessages(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.canTranslateMessagesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Translates a [message], using the translation catalogs configured in the Project Settings.
   * Further [context] can be specified to help with the translation. Note that most [Control] nodes
   * automatically translate their strings, so this method is mostly useful for formatted strings or
   * custom drawn text.
   *
   * If [canTranslateMessages] is `false`, or no translation is available, this method returns the
   * [message] without changes. See [setMessageTranslation].
   *
   * For detailed examples, see
   * [url=$DOCS_URL/tutorials/i18n/internationalizing_games.html]Internationalizing games[/url].
   *
   * **Note:** This method can't be used without an [Object] instance, as it requires the
   * [canTranslateMessages] method. To translate strings in a static context, use
   * [TranslationServer.translate].
   */
  public final fun tr(message: StringName, context: StringName = StringName("")): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to message, STRING_NAME to context)
    TransferContext.callMethod(MethodBindings.trPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Translates a [message] or [pluralMessage], using the translation catalogs configured in the
   * Project Settings. Further [context] can be specified to help with the translation.
   *
   * If [canTranslateMessages] is `false`, or no translation is available, this method returns
   * [message] or [pluralMessage], without changes. See [setMessageTranslation].
   *
   * The [n] is the number, or amount, of the message's subject. It is used by the translation
   * system to fetch the correct plural form for the current language.
   *
   * For detailed examples, see
   * [url=$DOCS_URL/tutorials/i18n/localization_using_gettext.html]Localization using gettext[/url].
   *
   * **Note:** Negative and [Double] numbers may not properly apply to some countable subjects. It's
   * recommended to handle these cases with [tr].
   *
   * **Note:** This method can't be used without an [Object] instance, as it requires the
   * [canTranslateMessages] method. To translate strings in a static context, use
   * [TranslationServer.translatePlural].
   */
  public final fun trN(
    message: StringName,
    pluralMessage: StringName,
    n: Int,
    context: StringName = StringName(""),
  ): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to message, STRING_NAME to pluralMessage, LONG to n.toLong(), STRING_NAME to context)
    TransferContext.callMethod(MethodBindings.trNPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the name of the translation domain used by [tr] and [trN]. See also
   * [TranslationServer].
   */
  public final fun getTranslationDomain(): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTranslationDomainPtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  /**
   * Sets the name of the translation domain used by [tr] and [trN]. See also [TranslationServer].
   */
  public final fun setTranslationDomain(domain: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to domain)
    TransferContext.callMethod(MethodBindings.setTranslationDomainPtr)
  }

  /**
   * Returns `true` if the methods [Node.queueFree] or [SceneTree.queueDelete] was called for the
   * object.
   *
   * **Note:** This method does not return `true` on children of the node that [Node.queueFree] has
   * been called on, even though they will be freed together with the parent.
   */
  public final fun isQueuedForDeletion(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isQueuedForDeletionPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If this method is called during [NOTIFICATION_PREDELETE], this object will reject being freed
   * and will remain allocated. This is mostly an internal function used for error handling to avoid
   * the user from freeing objects when they are not intended to.
   */
  public final fun cancelFree(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.cancelFreePtr)
  }

  /**
   * Returns `true` if the object inherits from the given [class]. See also [getClass].
   *
   * ```gdscript
   * //gdscript
   * var sprite2d = Sprite2D.new()
   * sprite2d.is_class("Sprite2D") # Returns true
   * sprite2d.is_class("Node")     # Returns true
   * sprite2d.is_class("Node3D")   # Returns false
   * ```
   *
   * ```csharp
   * //csharp
   * var sprite2D = new Sprite2D();
   * sprite2D.IsClass("Sprite2D"); // Returns true
   * sprite2D.IsClass("Node");     // Returns true
   * sprite2D.IsClass("Node3D");   // Returns false
   * ```
   *
   * **Note:** This method ignores `class_name` declarations in the object's script.
   */
  public final fun isClass(`class`: String): Boolean = isClass(`class`.asCachedStringName())

  /**
   * Assigns [value] to the given [property]. If the property does not exist or the given [value]'s
   * type doesn't match, nothing happens.
   *
   * ```gdscript
   * //gdscript
   * var node = Node2D.new()
   * node.set("global_scale", Vector2(8, 2.5))
   * print(node.global_scale) # Prints (8.0, 2.5)
   * ```
   *
   * ```csharp
   * //csharp
   * var node = new Node2D();
   * node.Set(Node2D.PropertyName.GlobalScale, new Vector2(8, 2.5f));
   * GD.Print(node.GlobalScale); // Prints (8, 2.5)
   * ```
   *
   * **Note:** In C#, [property] must be in snake_case when referring to built-in Godot properties.
   * Prefer using the names exposed in the `PropertyName` class to avoid allocating a new [StringName]
   * on each call.
   */
  public final fun `set`(`property`: String, `value`: Any?) =
      set(property.asCachedStringName(), value)

  /**
   * Returns the [Any] value of the given [property]. If the [property] does not exist, this method
   * returns `null`.
   *
   * ```gdscript
   * //gdscript
   * var node = Node2D.new()
   * node.rotation = 1.5
   * var a = node.get("rotation") # a is 1.5
   * ```
   *
   * ```csharp
   * //csharp
   * var node = new Node2D();
   * node.Rotation = 1.5f;
   * var a = node.Get(Node2D.PropertyName.Rotation); // a is 1.5
   * ```
   *
   * **Note:** In C#, [property] must be in snake_case when referring to built-in Godot properties.
   * Prefer using the names exposed in the `PropertyName` class to avoid allocating a new [StringName]
   * on each call.
   */
  public final fun `get`(`property`: String): Any? = get(property.asCachedStringName())

  /**
   * Assigns a new [value] to the property identified by the [propertyPath]. The path should be a
   * [NodePath] relative to this object, and can use the colon character (`:`) to access nested
   * properties.
   *
   * ```gdscript
   * //gdscript
   * var node = Node2D.new()
   * node.set_indexed("position", Vector2(42, 0))
   * node.set_indexed("position:y", -10)
   * print(node.position) # Prints (42.0, -10.0)
   * ```
   *
   * ```csharp
   * //csharp
   * var node = new Node2D();
   * node.SetIndexed("position", new Vector2(42, 0));
   * node.SetIndexed("position:y", -10);
   * GD.Print(node.Position); // Prints (42, -10)
   * ```
   *
   * **Note:** In C#, [propertyPath] must be in snake_case when referring to built-in Godot
   * properties. Prefer using the names exposed in the `PropertyName` class to avoid allocating a new
   * [StringName] on each call.
   */
  public final fun setIndexed(propertyPath: String, `value`: Any?) =
      setIndexed(propertyPath.asCachedNodePath(), value)

  /**
   * Gets the object's property indexed by the given [propertyPath]. The path should be a [NodePath]
   * relative to the current object and can use the colon character (`:`) to access nested properties.
   *
   * **Examples:** `"position:x"` or `"material:next_pass:blend_mode"`.
   *
   * ```gdscript
   * //gdscript
   * var node = Node2D.new()
   * node.position = Vector2(5, -10)
   * var a = node.get_indexed("position")   # a is Vector2(5, -10)
   * var b = node.get_indexed("position:y") # b is -10
   * ```
   *
   * ```csharp
   * //csharp
   * var node = new Node2D();
   * node.Position = new Vector2(5, -10);
   * var a = node.GetIndexed("position");   // a is Vector2(5, -10)
   * var b = node.GetIndexed("position:y"); // b is -10
   * ```
   *
   * **Note:** In C#, [propertyPath] must be in snake_case when referring to built-in Godot
   * properties. Prefer using the names exposed in the `PropertyName` class to avoid allocating a new
   * [StringName] on each call.
   *
   * **Note:** This method does not support actual paths to nodes in the [SceneTree], only
   * sub-property paths. In the context of nodes, use [Node.getNodeAndResource] instead.
   */
  public final fun getIndexed(propertyPath: String): Any? =
      getIndexed(propertyPath.asCachedNodePath())

  /**
   * Returns `true` if the given [property] has a custom default value. Use [propertyGetRevert] to
   * get the [property]'s default value.
   *
   * **Note:** This method is used by the Inspector dock to display a revert icon. The object must
   * implement [_propertyCanRevert] to customize the default value. If [_propertyCanRevert] is not
   * implemented, this method returns `false`.
   */
  public final fun propertyCanRevert(`property`: String): Boolean =
      propertyCanRevert(property.asCachedStringName())

  /**
   * Returns the custom default value of the given [property]. Use [propertyCanRevert] to check if
   * the [property] has a custom default value.
   *
   * **Note:** This method is used by the Inspector dock to display a revert icon. The object must
   * implement [_propertyGetRevert] to customize the default value. If [_propertyGetRevert] is not
   * implemented, this method returns `null`.
   */
  public final fun propertyGetRevert(`property`: String): Any? =
      propertyGetRevert(property.asCachedStringName())

  /**
   * Adds or changes the entry [name] inside the object's metadata. The metadata [value] can be any
   * [Any], although some types cannot be serialized correctly.
   *
   * If [value] is `null`, the entry is removed. This is the equivalent of using [removeMeta]. See
   * also [hasMeta] and [getMeta].
   *
   * **Note:** A metadata's name must be a valid identifier as per [StringName.isValidIdentifier]
   * method.
   *
   * **Note:** Metadata that has a name starting with an underscore (`_`) is considered editor-only.
   * Editor-only metadata is not displayed in the Inspector and should not be edited, although it can
   * still be found by this method.
   */
  public final fun setMeta(name: String, `value`: Any?) = setMeta(name.asCachedStringName(), value)

  /**
   * Removes the given entry [name] from the object's metadata. See also [hasMeta], [getMeta] and
   * [setMeta].
   *
   * **Note:** A metadata's name must be a valid identifier as per [StringName.isValidIdentifier]
   * method.
   *
   * **Note:** Metadata that has a name starting with an underscore (`_`) is considered editor-only.
   * Editor-only metadata is not displayed in the Inspector and should not be edited, although it can
   * still be found by this method.
   */
  public final fun removeMeta(name: String) = removeMeta(name.asCachedStringName())

  /**
   * Returns the object's metadata value for the given entry [name]. If the entry does not exist,
   * returns [default]. If [default] is `null`, an error is also generated.
   *
   * **Note:** A metadata's name must be a valid identifier as per [StringName.isValidIdentifier]
   * method.
   *
   * **Note:** Metadata that has a name starting with an underscore (`_`) is considered editor-only.
   * Editor-only metadata is not displayed in the Inspector and should not be edited, although it can
   * still be found by this method.
   */
  @JvmOverloads
  public final fun getMeta(name: String, default: Any? = null): Any? =
      getMeta(name.asCachedStringName(), default)

  /**
   * Returns `true` if a metadata entry is found with the given [name]. See also [getMeta],
   * [setMeta] and [removeMeta].
   *
   * **Note:** A metadata's name must be a valid identifier as per [StringName.isValidIdentifier]
   * method.
   *
   * **Note:** Metadata that has a name starting with an underscore (`_`) is considered editor-only.
   * Editor-only metadata is not displayed in the Inspector and should not be edited, although it can
   * still be found by this method.
   */
  public final fun hasMeta(name: String): Boolean = hasMeta(name.asCachedStringName())

  /**
   * Returns `true` if the given user-defined [signal] name exists. Only signals added with
   * [addUserSignal] are included. See also [removeUserSignal].
   */
  public final fun hasUserSignal(signal: String): Boolean =
      hasUserSignal(signal.asCachedStringName())

  /**
   * Removes the given user signal [signal] from the object. See also [addUserSignal] and
   * [hasUserSignal].
   */
  public final fun removeUserSignal(signal: String) = removeUserSignal(signal.asCachedStringName())

  /**
   * Emits the given [signal] by name. The signal must exist, so it should be a built-in signal of
   * this class or one of its inherited classes, or a user-defined signal (see [addUserSignal]). This
   * method supports a variable number of arguments, so parameters can be passed as a comma separated
   * list.
   *
   * Returns [ERR_UNAVAILABLE] if [signal] does not exist or the parameters are invalid.
   *
   * ```gdscript
   * //gdscript
   * emit_signal("hit", "sword", 100)
   * emit_signal("game_over")
   * ```
   *
   * ```csharp
   * //csharp
   * EmitSignal(SignalName.Hit, "sword", 100);
   * EmitSignal(SignalName.GameOver);
   * ```
   *
   * **Note:** In C#, [signal] must be in snake_case when referring to built-in Godot signals.
   * Prefer using the names exposed in the `SignalName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun emitSignal(signal: String, vararg args: Any?): Error =
      emitSignal(signal.asCachedStringName(), *args)

  /**
   * Calls the [method] on the object and returns the result. This method supports a variable number
   * of arguments, so parameters can be passed as a comma separated list.
   *
   * ```gdscript
   * //gdscript
   * var node = Node3D.new()
   * node.call("rotate", Vector3(1.0, 0.0, 0.0), 1.571)
   * ```
   *
   * ```csharp
   * //csharp
   * var node = new Node3D();
   * node.Call(Node3D.MethodName.Rotate, new Vector3(1f, 0f, 0f), 1.571f);
   * ```
   *
   * **Note:** In C#, [method] must be in snake_case when referring to built-in Godot methods.
   * Prefer using the names exposed in the `MethodName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun call(method: String, vararg args: Any?): Any? =
      call(method.asCachedStringName(), *args)

  /**
   * Calls the [method] on the object during idle time. Always returns `null`, **not** the method's
   * result.
   *
   * Idle time happens mainly at the end of process and physics frames. In it, deferred calls will
   * be run until there are none left, which means you can defer calls from other deferred calls and
   * they'll still be run in the current idle time cycle. This means you should not call a method
   * deferred from itself (or from a method called by it), as this causes infinite recursion the same
   * way as if you had called the method directly.
   *
   * This method supports a variable number of arguments, so parameters can be passed as a comma
   * separated list.
   *
   * ```gdscript
   * //gdscript
   * var node = Node3D.new()
   * node.call_deferred("rotate", Vector3(1.0, 0.0, 0.0), 1.571)
   * ```
   *
   * ```csharp
   * //csharp
   * var node = new Node3D();
   * node.CallDeferred(Node3D.MethodName.Rotate, new Vector3(1f, 0f, 0f), 1.571f);
   * ```
   *
   * For methods that are deferred from the same thread, the order of execution at idle time is
   * identical to the order in which [code skip-lint]call_deferred[/code] was called.
   *
   * See also [Callable.callDeferred].
   *
   * **Note:** In C#, [method] must be in snake_case when referring to built-in Godot methods.
   * Prefer using the names exposed in the `MethodName` class to avoid allocating a new [StringName] on
   * each call.
   *
   * **Note:** If you're looking to delay the function call by a frame, refer to the [signal
   * SceneTree.process_frame] and [signal SceneTree.physics_frame] signals.
   *
   * ```
   * var node = Node3D.new()
   * # Make a Callable and bind the arguments to the node's rotate() call.
   * var callable = node.rotate.bind(Vector3(1.0, 0.0, 0.0), 1.571)
   * # Connect the callable to the process_frame signal, so it gets called in the next process
   * frame.
   * # CONNECT_ONE_SHOT makes sure it only gets called once instead of every frame.
   * get_tree().process_frame.connect(callable, CONNECT_ONE_SHOT)
   * ```
   */
  public final fun callDeferred(method: String, vararg args: Any?): Any? =
      callDeferred(method.asCachedStringName(), *args)

  /**
   * Assigns [value] to the given [property], at the end of the current frame. This is equivalent to
   * calling [set] through [callDeferred].
   *
   * ```gdscript
   * //gdscript
   * var node = Node2D.new()
   * add_child(node)
   *
   * node.rotation = 1.5
   * node.set_deferred("rotation", 3.0)
   * print(node.rotation) # Prints 1.5
   *
   * await get_tree().process_frame
   * print(node.rotation) # Prints 3.0
   * ```
   *
   * ```csharp
   * //csharp
   * var node = new Node2D();
   * node.Rotation = 1.5f;
   * node.SetDeferred(Node2D.PropertyName.Rotation, 3f);
   * GD.Print(node.Rotation); // Prints 1.5
   *
   * await ToSignal(GetTree(), SceneTree.SignalName.ProcessFrame);
   * GD.Print(node.Rotation); // Prints 3.0
   * ```
   *
   * **Note:** In C#, [property] must be in snake_case when referring to built-in Godot properties.
   * Prefer using the names exposed in the `PropertyName` class to avoid allocating a new [StringName]
   * on each call.
   */
  public final fun setDeferred(`property`: String, `value`: Any?) =
      setDeferred(property.asCachedStringName(), value)

  /**
   * Calls the [method] on the object and returns the result. Unlike [call], this method expects all
   * parameters to be contained inside [argArray].
   *
   * ```gdscript
   * //gdscript
   * var node = Node3D.new()
   * node.callv("rotate", [Vector3(1.0, 0.0, 0.0), 1.571])
   * ```
   *
   * ```csharp
   * //csharp
   * var node = new Node3D();
   * node.Callv(Node3D.MethodName.Rotate, [new Vector3(1f, 0f, 0f), 1.571f]);
   * ```
   *
   * **Note:** In C#, [method] must be in snake_case when referring to built-in Godot methods.
   * Prefer using the names exposed in the `MethodName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun callv(method: String, argArray: VariantArray<Any?>): Any? =
      callv(method.asCachedStringName(), argArray)

  /**
   * Returns `true` if the given [method] name exists in the object.
   *
   * **Note:** In C#, [method] must be in snake_case when referring to built-in Godot methods.
   * Prefer using the names exposed in the `MethodName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun hasMethod(method: String): Boolean = hasMethod(method.asCachedStringName())

  /**
   * Returns the number of arguments of the given [method] by name.
   *
   * **Note:** In C#, [method] must be in snake_case when referring to built-in Godot methods.
   * Prefer using the names exposed in the `MethodName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun getMethodArgumentCount(method: String): Int =
      getMethodArgumentCount(method.asCachedStringName())

  /**
   * Returns `true` if the given [signal] name exists in the object.
   *
   * **Note:** In C#, [signal] must be in snake_case when referring to built-in Godot signals.
   * Prefer using the names exposed in the `SignalName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun hasSignal(signal: String): Boolean = hasSignal(signal.asCachedStringName())

  /**
   * Returns an [VariantArray] of connections for the given [signal] name. Each connection is
   * represented as a [Dictionary] that contains three entries:
   *
   * - [code skip-lint]signal[/code] is a reference to the [Signal];
   *
   * - `callable` is a reference to the connected [Callable];
   *
   * - `flags` is a combination of [ConnectFlags].
   */
  public final fun getSignalConnectionList(signal: String): VariantArray<Dictionary<Any?, Any?>> =
      getSignalConnectionList(signal.asCachedStringName())

  /**
   * Connects a [signal] by name to a [callable]. Optional [flags] can be also added to configure
   * the connection's behavior (see [ConnectFlags] constants).
   *
   * A signal can only be connected once to the same [Callable]. If the signal is already connected,
   * this method returns [ERR_INVALID_PARAMETER] and generates an error, unless the signal is connected
   * with [CONNECT_REFERENCE_COUNTED]. To prevent this, use [isConnected] first to check for existing
   * connections.
   *
   * **Note:** If the [callable]'s object is freed, the connection will be lost.
   *
   * **Note:** In GDScript, it is generally recommended to connect signals with [Signal.connect]
   * instead.
   *
   * **Note:** This method, and all other signal-related methods, are thread-safe.
   */
  @JvmOverloads
  public final fun connect(
    signal: String,
    callable: Callable,
    flags: ConnectFlags = Object.ConnectFlags.DEFAULT,
  ): Error = connect(signal.asCachedStringName(), callable, flags)

  /**
   * Disconnects a [signal] by name from a given [callable]. If the connection does not exist,
   * generates an error. Use [isConnected] to make sure that the connection exists.
   */
  public final fun disconnect(signal: String, callable: Callable) =
      disconnect(signal.asCachedStringName(), callable)

  /**
   * Returns `true` if a connection exists between the given [signal] name and [callable].
   *
   * **Note:** In C#, [signal] must be in snake_case when referring to built-in Godot signals.
   * Prefer using the names exposed in the `SignalName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun isConnected(signal: String, callable: Callable): Boolean =
      isConnected(signal.asCachedStringName(), callable)

  /**
   * Returns `true` if any connection exists on the given [signal] name.
   *
   * **Note:** In C#, [signal] must be in snake_case when referring to built-in Godot methods.
   * Prefer using the names exposed in the `SignalName` class to avoid allocating a new [StringName] on
   * each call.
   */
  public final fun hasConnections(signal: String): Boolean =
      hasConnections(signal.asCachedStringName())

  /**
   * Translates a [message], using the translation catalogs configured in the Project Settings.
   * Further [context] can be specified to help with the translation. Note that most [Control] nodes
   * automatically translate their strings, so this method is mostly useful for formatted strings or
   * custom drawn text.
   *
   * If [canTranslateMessages] is `false`, or no translation is available, this method returns the
   * [message] without changes. See [setMessageTranslation].
   *
   * For detailed examples, see
   * [url=$DOCS_URL/tutorials/i18n/internationalizing_games.html]Internationalizing games[/url].
   *
   * **Note:** This method can't be used without an [Object] instance, as it requires the
   * [canTranslateMessages] method. To translate strings in a static context, use
   * [TranslationServer.translate].
   */
  public final fun tr(message: String, context: String): String =
      tr(message.asCachedStringName(), context.asCachedStringName())

  /**
   * Translates a [message] or [pluralMessage], using the translation catalogs configured in the
   * Project Settings. Further [context] can be specified to help with the translation.
   *
   * If [canTranslateMessages] is `false`, or no translation is available, this method returns
   * [message] or [pluralMessage], without changes. See [setMessageTranslation].
   *
   * The [n] is the number, or amount, of the message's subject. It is used by the translation
   * system to fetch the correct plural form for the current language.
   *
   * For detailed examples, see
   * [url=$DOCS_URL/tutorials/i18n/localization_using_gettext.html]Localization using gettext[/url].
   *
   * **Note:** Negative and [Double] numbers may not properly apply to some countable subjects. It's
   * recommended to handle these cases with [tr].
   *
   * **Note:** This method can't be used without an [Object] instance, as it requires the
   * [canTranslateMessages] method. To translate strings in a static context, use
   * [TranslationServer.translatePlural].
   */
  public final fun trN(
    message: String,
    pluralMessage: String,
    n: Int,
    context: String,
  ): String =
      trN(message.asCachedStringName(), pluralMessage.asCachedStringName(), n, context.asCachedStringName())

  /**
   * Sets the name of the translation domain used by [tr] and [trN]. See also [TranslationServer].
   */
  public final fun setTranslationDomain(domain: String) =
      setTranslationDomain(domain.asCachedStringName())

  public class ConnectFlags(
    flag: Long,
  ) : BitFieldBase<ConnectFlags>(flag) {
    protected override fun wrap(flag: Long): ConnectFlags = ConnectFlags(flag)

    public companion object {
      /**
       * Default connections that are immediately emitted
       */
      @JvmField
      public val DEFAULT: ConnectFlags = ConnectFlags(0)

      /**
       * Deferred connections trigger their [Callable]s on idle time (at the end of the frame),
       * rather than instantly.
       */
      @JvmField
      public val DEFERRED: ConnectFlags = ConnectFlags(1)

      /**
       * Persisting connections are stored when the object is serialized (such as when using
       * [PackedScene.pack]). In the editor, connections created through the Signals dock are always
       * persisting.
       *
       * **Note:** Connections to lambda functions (that is, when the function code is embedded in
       * the [connect] call) cannot be made persistent.
       */
      @JvmField
      public val PERSIST: ConnectFlags = ConnectFlags(2)

      /**
       * One-shot connections disconnect themselves after emission.
       */
      @JvmField
      public val ONE_SHOT: ConnectFlags = ConnectFlags(4)

      /**
       * Reference-counted connections can be assigned to the same [Callable] multiple times. Each
       * disconnection decreases the internal counter. The signal fully disconnects only when the
       * counter reaches 0.
       */
      @JvmField
      public val REFERENCE_COUNTED: ConnectFlags = ConnectFlags(8)

      /**
       * On signal emission, the source object is automatically appended after the original
       * arguments of the signal, regardless of the connected [Callable]'s unbinds which affect only
       * the original arguments of the signal (see [Callable.unbind],
       * [Callable.getUnboundArgumentsCount]).
       *
       * ```
       * extends Object
       *
       * signal test_signal
       *
       * func test():
       * 	print(self) # Prints e.g. <Object#35332818393>
       * 	test_signal.connect(prints.unbind(1), CONNECT_APPEND_SOURCE_OBJECT)
       * 	test_signal.emit("emit_arg_1", "emit_arg_2") # Prints emit_arg_1 <Object#35332818393>
       * ```
       */
      @JvmField
      public val APPEND_SOURCE_OBJECT: ConnectFlags = ConnectFlags(16)
    }
  }

  public companion object {
    @JvmField
    public val getClassName: MethodStringName0<Object, String> =
        MethodStringName0<Object, String>("get_class")

    @JvmField
    public val isClassName: MethodStringName1<Object, Boolean, StringName> =
        MethodStringName1<Object, Boolean, StringName>("is_class")

    @JvmField
    public val setName: MethodStringName2<Object, Unit, StringName, Any?> =
        MethodStringName2<Object, Unit, StringName, Any?>("set")

    @JvmField
    public val getName: MethodStringName1<Object, Any?, StringName> =
        MethodStringName1<Object, Any?, StringName>("get")

    @JvmField
    public val setIndexedName: MethodStringName2<Object, Unit, NodePath, Any?> =
        MethodStringName2<Object, Unit, NodePath, Any?>("set_indexed")

    @JvmField
    public val getIndexedName: MethodStringName1<Object, Any?, NodePath> =
        MethodStringName1<Object, Any?, NodePath>("get_indexed")

    @JvmField
    public val getPropertyListName: MethodStringName0<Object, VariantArray<Dictionary<Any?, Any?>>>
        = MethodStringName0<Object, VariantArray<Dictionary<Any?, Any?>>>("get_property_list")

    @JvmField
    public val getMethodListName: MethodStringName0<Object, VariantArray<Dictionary<Any?, Any?>>> =
        MethodStringName0<Object, VariantArray<Dictionary<Any?, Any?>>>("get_method_list")

    @JvmField
    public val propertyCanRevertName: MethodStringName1<Object, Boolean, StringName> =
        MethodStringName1<Object, Boolean, StringName>("property_can_revert")

    @JvmField
    public val propertyGetRevertName: MethodStringName1<Object, Any?, StringName> =
        MethodStringName1<Object, Any?, StringName>("property_get_revert")

    @JvmField
    public val notificationName: MethodStringName2<Object, Unit, Int, Boolean> =
        MethodStringName2<Object, Unit, Int, Boolean>("notification")

    @JvmField
    public val toStringName: MethodStringName0<Object, String> =
        MethodStringName0<Object, String>("to_string")

    @JvmField
    public val getInstanceIdName: MethodStringName0<Object, Long> =
        MethodStringName0<Object, Long>("get_instance_id")

    @JvmField
    public val setScriptName: MethodStringName1<Object, Unit, Any?> =
        MethodStringName1<Object, Unit, Any?>("set_script")

    @JvmField
    public val getScriptName: MethodStringName0<Object, Any?> =
        MethodStringName0<Object, Any?>("get_script")

    @JvmField
    public val setMetaName: MethodStringName2<Object, Unit, StringName, Any?> =
        MethodStringName2<Object, Unit, StringName, Any?>("set_meta")

    @JvmField
    public val removeMetaName: MethodStringName1<Object, Unit, StringName> =
        MethodStringName1<Object, Unit, StringName>("remove_meta")

    @JvmField
    public val getMetaName: MethodStringName2<Object, Any?, StringName, Any?> =
        MethodStringName2<Object, Any?, StringName, Any?>("get_meta")

    @JvmField
    public val hasMetaName: MethodStringName1<Object, Boolean, StringName> =
        MethodStringName1<Object, Boolean, StringName>("has_meta")

    @JvmField
    public val getMetaListName: MethodStringName0<Object, VariantArray<StringName>> =
        MethodStringName0<Object, VariantArray<StringName>>("get_meta_list")

    @JvmField
    public val addUserSignalName: MethodStringName2<Object, Unit, String, VariantArray<Any?>> =
        MethodStringName2<Object, Unit, String, VariantArray<Any?>>("add_user_signal")

    @JvmField
    public val hasUserSignalName: MethodStringName1<Object, Boolean, StringName> =
        MethodStringName1<Object, Boolean, StringName>("has_user_signal")

    @JvmField
    public val removeUserSignalName: MethodStringName1<Object, Unit, StringName> =
        MethodStringName1<Object, Unit, StringName>("remove_user_signal")

    @JvmField
    public val setDeferredName: MethodStringName2<Object, Unit, StringName, Any?> =
        MethodStringName2<Object, Unit, StringName, Any?>("set_deferred")

    @JvmField
    public val callvName: MethodStringName2<Object, Any?, StringName, VariantArray<Any?>> =
        MethodStringName2<Object, Any?, StringName, VariantArray<Any?>>("callv")

    @JvmField
    public val hasMethodName: MethodStringName1<Object, Boolean, StringName> =
        MethodStringName1<Object, Boolean, StringName>("has_method")

    @JvmField
    public val getMethodArgumentCountName: MethodStringName1<Object, Int, StringName> =
        MethodStringName1<Object, Int, StringName>("get_method_argument_count")

    @JvmField
    public val hasSignalName: MethodStringName1<Object, Boolean, StringName> =
        MethodStringName1<Object, Boolean, StringName>("has_signal")

    @JvmField
    public val getSignalListName: MethodStringName0<Object, VariantArray<Dictionary<Any?, Any?>>> =
        MethodStringName0<Object, VariantArray<Dictionary<Any?, Any?>>>("get_signal_list")

    @JvmField
    public val getSignalConnectionListName:
        MethodStringName1<Object, VariantArray<Dictionary<Any?, Any?>>, StringName> =
        MethodStringName1<Object, VariantArray<Dictionary<Any?, Any?>>, StringName>("get_signal_connection_list")

    @JvmField
    public val getIncomingConnectionsName:
        MethodStringName0<Object, VariantArray<Dictionary<Any?, Any?>>> =
        MethodStringName0<Object, VariantArray<Dictionary<Any?, Any?>>>("get_incoming_connections")

    @JvmField
    public val connectName: MethodStringName3<Object, Error, StringName, Callable, ConnectFlags> =
        MethodStringName3<Object, Error, StringName, Callable, ConnectFlags>("connect")

    @JvmField
    public val disconnectName: MethodStringName2<Object, Unit, StringName, Callable> =
        MethodStringName2<Object, Unit, StringName, Callable>("disconnect")

    @JvmField
    public val isConnectedName: MethodStringName2<Object, Boolean, StringName, Callable> =
        MethodStringName2<Object, Boolean, StringName, Callable>("is_connected")

    @JvmField
    public val hasConnectionsName: MethodStringName1<Object, Boolean, StringName> =
        MethodStringName1<Object, Boolean, StringName>("has_connections")

    @JvmField
    public val setBlockSignalsName: MethodStringName1<Object, Unit, Boolean> =
        MethodStringName1<Object, Unit, Boolean>("set_block_signals")

    @JvmField
    public val isBlockingSignalsName: MethodStringName0<Object, Boolean> =
        MethodStringName0<Object, Boolean>("is_blocking_signals")

    @JvmField
    public val notifyPropertyListChangedName: MethodStringName0<Object, Unit> =
        MethodStringName0<Object, Unit>("notify_property_list_changed")

    @JvmField
    public val setMessageTranslationName: MethodStringName1<Object, Unit, Boolean> =
        MethodStringName1<Object, Unit, Boolean>("set_message_translation")

    @JvmField
    public val canTranslateMessagesName: MethodStringName0<Object, Boolean> =
        MethodStringName0<Object, Boolean>("can_translate_messages")

    @JvmField
    public val trName: MethodStringName2<Object, String, StringName, StringName> =
        MethodStringName2<Object, String, StringName, StringName>("tr")

    @JvmField
    public val trNName: MethodStringName4<Object, String, StringName, StringName, Int, StringName> =
        MethodStringName4<Object, String, StringName, StringName, Int, StringName>("tr_n")

    @JvmField
    public val getTranslationDomainName: MethodStringName0<Object, StringName> =
        MethodStringName0<Object, StringName>("get_translation_domain")

    @JvmField
    public val setTranslationDomainName: MethodStringName1<Object, Unit, StringName> =
        MethodStringName1<Object, Unit, StringName>("set_translation_domain")

    @JvmField
    public val isQueuedForDeletionName: MethodStringName0<Object, Boolean> =
        MethodStringName0<Object, Boolean>("is_queued_for_deletion")

    @JvmField
    public val cancelFreeName: MethodStringName0<Object, Unit> =
        MethodStringName0<Object, Unit>("cancel_free")

    /**
     * Notification received when the object is initialized, before its script is attached. Used
     * internally.
     */
    public final const val NOTIFICATION_POSTINITIALIZE: Long = 0

    /**
     * Notification received when the object is about to be deleted. Can be used like destructors in
     * object-oriented programming languages.
     *
     * This notification is sent in reversed order.
     */
    public final const val NOTIFICATION_PREDELETE: Long = 1

    /**
     * Notification received when the object finishes hot reloading. This notification is only sent
     * for extensions classes and derived.
     */
    public final const val NOTIFICATION_EXTENSION_RELOADED: Long = 2
  }

  public object MethodBindings {
    internal val getClassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "get_class", 201670096)

    internal val isClassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "is_class", 2619796661)

    internal val setPtr: VoidPtr = TypeManager.getMethodBindPtr("Object", "set", 3776071444)

    internal val getPtr: VoidPtr = TypeManager.getMethodBindPtr("Object", "get", 2760726917)

    internal val setIndexedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "set_indexed", 3500910842)

    internal val getIndexedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "get_indexed", 4006125091)

    internal val getPropertyListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "get_property_list", 3995934104)

    internal val getMethodListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "get_method_list", 3995934104)

    internal val propertyCanRevertPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "property_can_revert", 2619796661)

    internal val propertyGetRevertPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "property_get_revert", 2760726917)

    internal val notificationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "notification", 4023243586)

    internal val toStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "to_string", 2841200299)

    internal val getInstanceIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "get_instance_id", 3905245786)

    internal val setScriptPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "set_script", 1114965689)

    internal val getScriptPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "get_script", 1214101251)

    internal val setMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "set_meta", 3776071444)

    internal val removeMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "remove_meta", 3304788590)

    internal val getMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "get_meta", 3990617847)

    internal val hasMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "has_meta", 2619796661)

    internal val getMetaListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "get_meta_list", 3995934104)

    internal val addUserSignalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "add_user_signal", 85656714)

    internal val hasUserSignalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "has_user_signal", 2619796661)

    internal val removeUserSignalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "remove_user_signal", 3304788590)

    internal val emitSignalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "emit_signal", 4047867050)

    internal val callPtr: VoidPtr = TypeManager.getMethodBindPtr("Object", "call", 3400424181)

    internal val callDeferredPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "call_deferred", 3400424181)

    internal val setDeferredPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "set_deferred", 3776071444)

    internal val callvPtr: VoidPtr = TypeManager.getMethodBindPtr("Object", "callv", 1260104456)

    internal val hasMethodPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "has_method", 2619796661)

    internal val getMethodArgumentCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "get_method_argument_count", 2458036349)

    internal val hasSignalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "has_signal", 2619796661)

    internal val getSignalListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "get_signal_list", 3995934104)

    internal val getSignalConnectionListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "get_signal_connection_list", 3147814860)

    internal val getIncomingConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "get_incoming_connections", 3995934104)

    internal val connectPtr: VoidPtr = TypeManager.getMethodBindPtr("Object", "connect", 1518946055)

    internal val disconnectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "disconnect", 1874754934)

    internal val isConnectedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "is_connected", 768136979)

    internal val hasConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "has_connections", 2619796661)

    internal val setBlockSignalsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "set_block_signals", 2586408642)

    internal val isBlockingSignalsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "is_blocking_signals", 36873697)

    internal val notifyPropertyListChangedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "notify_property_list_changed", 3218959716)

    internal val setMessageTranslationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "set_message_translation", 2586408642)

    internal val canTranslateMessagesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "can_translate_messages", 36873697)

    internal val trPtr: VoidPtr = TypeManager.getMethodBindPtr("Object", "tr", 1195764410)

    internal val trNPtr: VoidPtr = TypeManager.getMethodBindPtr("Object", "tr_n", 162698058)

    internal val getTranslationDomainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "get_translation_domain", 2002593661)

    internal val setTranslationDomainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "set_translation_domain", 3304788590)

    internal val isQueuedForDeletionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "is_queued_for_deletion", 36873697)

    internal val cancelFreePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Object", "cancel_free", 3218959716)
  }
}
