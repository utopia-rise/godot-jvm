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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantParser.LONG
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Utility class which holds a reference to the internal identifier of an [Object] instance, as
 * given by [Object.getInstanceId]. This ID can then be used to retrieve the object instance with
 * [@GlobalScope.instanceFromId].
 *
 * This class is used internally by the editor inspector and script debugger, but can also be used
 * in plugins to pass and display objects as their IDs.
 */
@GodotBaseType
public open class EncodedObjectAsID : RefCounted() {
  /**
   * The [Object] identifier stored in this [EncodedObjectAsID] instance. The object instance can be
   * retrieved with [@GlobalScope.instanceFromId].
   */
  public final inline var objectId: Long
    @JvmName("objectIdProperty")
    get() = getObjectId()
    @JvmName("objectIdProperty")
    set(`value`) {
      setObjectId(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(213, scriptPtr)
  }

  public final fun setObjectId(id: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id)
    TransferContext.callMethod(MethodBindings.setObjectIdPtr)
  }

  public final fun getObjectId(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getObjectIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public companion object {
    @JvmField
    public val setObjectIdName: MethodStringName1<EncodedObjectAsID, Unit, Long> =
        MethodStringName1<EncodedObjectAsID, Unit, Long>("set_object_id")

    @JvmField
    public val getObjectIdName: MethodStringName0<EncodedObjectAsID, Long> =
        MethodStringName0<EncodedObjectAsID, Long>("get_object_id")
  }

  public object MethodBindings {
    internal val setObjectIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EncodedObjectAsID", "set_object_id", 1286410249)

    internal val getObjectIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("EncodedObjectAsID", "get_object_id", 3905245786)
  }
}
