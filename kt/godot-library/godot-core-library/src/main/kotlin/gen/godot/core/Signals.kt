@file:Suppress(
    "PackageDirectoryMismatch",
    "NOTHING_TO_INLINE",
    "UNUSED_PARAMETER",
    "unused",
)

package godot.core

import kotlin.Any
import kotlin.PublishedApi
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

public class Signal0 @PublishedApi internal constructor(
    instance: GodotObject,
    name: StringName,
) : Signal(instance, name) {
    public fun emit(): Unit {
        emitUnsafe()
    }

    @JvmOverloads
    public fun connect(callable: Callable0<*>, flags: ConnectFlags = ConnectFlags.DEFAULT): Unit {
        connectUnsafe(callable, flags)
    }

    public fun disconnect(callable: Callable0<*>): Unit {
        disconnectUnsafe(callable)
    }

    public companion object {
        @PublishedApi
        internal val `delegate`: ReadOnlyProperty<GodotObject, Signal0> =
                ReadOnlyProperty { thisRef, property -> getValue(thisRef, property) }

        public inline operator fun getValue(thisRef: GodotObject, `property`: KProperty<*>): Signal0
                = Signal0(thisRef, property.toGodotName())

        @JvmStatic
        @JvmName("create")
        public fun _createJava(godotObject: GodotObject, signalName: String): Signal0 =
                Signal0(godotObject, signalName.toGodotName())
    }
}

@Suppress("FUNCTION_NAME")
public inline fun GodotObject.Signal0(signalName: String) = Signal0(this, signalName.toGodotName())

public inline fun GodotObject.signal0() = Signal0.delegate

public class Signal1<P0> @PublishedApi internal constructor(
    instance: GodotObject,
    name: StringName,
) : Signal(instance, name) {
    public fun emit(p0: P0): Unit {
        emitUnsafe(p0)
    }

    @JvmOverloads
    public fun connect(callable: Callable1<*, P0>, flags: ConnectFlags = ConnectFlags.DEFAULT):
            Unit {
        connectUnsafe(callable, flags)
    }

    public fun disconnect(callable: Callable1<*, P0>): Unit {
        disconnectUnsafe(callable)
    }

    public companion object {
        @PublishedApi
        internal val `delegate`: ReadOnlyProperty<GodotObject, Signal1<Any>> =
                ReadOnlyProperty { thisRef, property -> getValue(thisRef, property) }

        public inline operator fun <P0> getValue(thisRef: GodotObject, `property`: KProperty<*>):
                Signal1<P0> = Signal1(thisRef, property.toGodotName())

        @JvmStatic
        @JvmName("create")
        public fun <P0> _createJava(godotObject: GodotObject, signalName: String): Signal1<P0> =
                Signal1(godotObject, signalName.toGodotName())
    }
}

@Suppress("FUNCTION_NAME")
public inline fun <P0> GodotObject.Signal1(signalName: String) =
        Signal1<P0>(this, signalName.toGodotName())

@Suppress("UNCHECKED_CAST")
public inline fun <P0> GodotObject.signal1() =
        Signal1.delegate as ReadOnlyProperty<GodotObject, Signal1<P0>>

public class Signal2<P0, P1> @PublishedApi internal constructor(
    instance: GodotObject,
    name: StringName,
) : Signal(instance, name) {
    public fun emit(p0: P0, p1: P1): Unit {
        emitUnsafe(p0, p1)
    }

    @JvmOverloads
    public fun connect(callable: Callable2<*, P0, P1>, flags: ConnectFlags = ConnectFlags.DEFAULT):
            Unit {
        connectUnsafe(callable, flags)
    }

    public fun disconnect(callable: Callable2<*, P0, P1>): Unit {
        disconnectUnsafe(callable)
    }

    public companion object {
        @PublishedApi
        internal val `delegate`: ReadOnlyProperty<GodotObject, Signal2<Any, Any>> =
                ReadOnlyProperty { thisRef, property -> getValue(thisRef, property) }

        public inline operator fun <P0, P1> getValue(thisRef: GodotObject,
                `property`: KProperty<*>): Signal2<P0, P1> =
                Signal2(thisRef, property.toGodotName())

        @JvmStatic
        @JvmName("create")
        public fun <P0, P1> _createJava(godotObject: GodotObject, signalName: String):
                Signal2<P0, P1> = Signal2(godotObject, signalName.toGodotName())
    }
}

@Suppress("FUNCTION_NAME")
public inline fun <P0, P1> GodotObject.Signal2(signalName: String) =
        Signal2<P0, P1>(this, signalName.toGodotName())

@Suppress("UNCHECKED_CAST")
public inline fun <P0, P1> GodotObject.signal2() =
        Signal2.delegate as ReadOnlyProperty<GodotObject, Signal2<P0, P1>>

public class Signal3<P0, P1, P2> @PublishedApi internal constructor(
    instance: GodotObject,
    name: StringName,
) : Signal(instance, name) {
    public fun emit(
        p0: P0,
        p1: P1,
        p2: P2,
    ): Unit {
        emitUnsafe(p0, p1, p2)
    }

    @JvmOverloads
    public fun connect(callable: Callable3<*, P0, P1, P2>, flags: ConnectFlags =
            ConnectFlags.DEFAULT): Unit {
        connectUnsafe(callable, flags)
    }

    public fun disconnect(callable: Callable3<*, P0, P1, P2>): Unit {
        disconnectUnsafe(callable)
    }

    public companion object {
        @PublishedApi
        internal val `delegate`: ReadOnlyProperty<GodotObject, Signal3<Any, Any, Any>> =
                ReadOnlyProperty { thisRef, property -> getValue(thisRef, property) }

        public inline operator fun <P0, P1, P2> getValue(thisRef: GodotObject,
                `property`: KProperty<*>): Signal3<P0, P1, P2> =
                Signal3(thisRef, property.toGodotName())

        @JvmStatic
        @JvmName("create")
        public fun <P0, P1, P2> _createJava(godotObject: GodotObject, signalName: String):
                Signal3<P0, P1, P2> = Signal3(godotObject, signalName.toGodotName())
    }
}

@Suppress("FUNCTION_NAME")
public inline fun <P0, P1, P2> GodotObject.Signal3(signalName: String) =
        Signal3<P0, P1, P2>(this, signalName.toGodotName())

@Suppress("UNCHECKED_CAST")
public inline fun <P0, P1, P2> GodotObject.signal3() =
        Signal3.delegate as ReadOnlyProperty<GodotObject, Signal3<P0, P1, P2>>

public class Signal4<P0, P1, P2, P3> @PublishedApi internal constructor(
    instance: GodotObject,
    name: StringName,
) : Signal(instance, name) {
    public fun emit(
        p0: P0,
        p1: P1,
        p2: P2,
        p3: P3,
    ): Unit {
        emitUnsafe(p0, p1, p2, p3)
    }

    @JvmOverloads
    public fun connect(callable: Callable4<*, P0, P1, P2, P3>, flags: ConnectFlags =
            ConnectFlags.DEFAULT): Unit {
        connectUnsafe(callable, flags)
    }

    public fun disconnect(callable: Callable4<*, P0, P1, P2, P3>): Unit {
        disconnectUnsafe(callable)
    }

    public companion object {
        @PublishedApi
        internal val `delegate`: ReadOnlyProperty<GodotObject, Signal4<Any, Any, Any, Any>> =
                ReadOnlyProperty { thisRef, property -> getValue(thisRef, property) }

        public inline operator fun <P0, P1, P2, P3> getValue(thisRef: GodotObject,
                `property`: KProperty<*>): Signal4<P0, P1, P2, P3> =
                Signal4(thisRef, property.toGodotName())

        @JvmStatic
        @JvmName("create")
        public fun <P0, P1, P2, P3> _createJava(godotObject: GodotObject, signalName: String):
                Signal4<P0, P1, P2, P3> = Signal4(godotObject, signalName.toGodotName())
    }
}

@Suppress("FUNCTION_NAME")
public inline fun <P0, P1, P2, P3> GodotObject.Signal4(signalName: String) =
        Signal4<P0, P1, P2, P3>(this, signalName.toGodotName())

@Suppress("UNCHECKED_CAST")
public inline fun <P0, P1, P2, P3> GodotObject.signal4() =
        Signal4.delegate as ReadOnlyProperty<GodotObject, Signal4<P0, P1, P2, P3>>

public class Signal5<P0, P1, P2, P3, P4> @PublishedApi internal constructor(
    instance: GodotObject,
    name: StringName,
) : Signal(instance, name) {
    public fun emit(
        p0: P0,
        p1: P1,
        p2: P2,
        p3: P3,
        p4: P4,
    ): Unit {
        emitUnsafe(p0, p1, p2, p3, p4)
    }

    @JvmOverloads
    public fun connect(callable: Callable5<*, P0, P1, P2, P3, P4>, flags: ConnectFlags =
            ConnectFlags.DEFAULT): Unit {
        connectUnsafe(callable, flags)
    }

    public fun disconnect(callable: Callable5<*, P0, P1, P2, P3, P4>): Unit {
        disconnectUnsafe(callable)
    }

    public companion object {
        @PublishedApi
        internal val `delegate`: ReadOnlyProperty<GodotObject, Signal5<Any, Any, Any, Any, Any>> =
                ReadOnlyProperty { thisRef, property -> getValue(thisRef, property) }

        public inline operator fun <P0, P1, P2, P3, P4> getValue(thisRef: GodotObject,
                `property`: KProperty<*>): Signal5<P0, P1, P2, P3, P4> =
                Signal5(thisRef, property.toGodotName())

        @JvmStatic
        @JvmName("create")
        public fun <P0, P1, P2, P3, P4> _createJava(godotObject: GodotObject, signalName: String):
                Signal5<P0, P1, P2, P3, P4> = Signal5(godotObject, signalName.toGodotName())
    }
}

@Suppress("FUNCTION_NAME")
public inline fun <P0, P1, P2, P3, P4> GodotObject.Signal5(signalName: String) =
        Signal5<P0, P1, P2, P3, P4>(this, signalName.toGodotName())

@Suppress("UNCHECKED_CAST")
public inline fun <P0, P1, P2, P3, P4> GodotObject.signal5() =
        Signal5.delegate as ReadOnlyProperty<GodotObject, Signal5<P0, P1, P2, P3, P4>>

public class Signal6<P0, P1, P2, P3, P4, P5> @PublishedApi internal constructor(
    instance: GodotObject,
    name: StringName,
) : Signal(instance, name) {
    public fun emit(
        p0: P0,
        p1: P1,
        p2: P2,
        p3: P3,
        p4: P4,
        p5: P5,
    ): Unit {
        emitUnsafe(p0, p1, p2, p3, p4, p5)
    }

    @JvmOverloads
    public fun connect(callable: Callable6<*, P0, P1, P2, P3, P4, P5>, flags: ConnectFlags =
            ConnectFlags.DEFAULT): Unit {
        connectUnsafe(callable, flags)
    }

    public fun disconnect(callable: Callable6<*, P0, P1, P2, P3, P4, P5>): Unit {
        disconnectUnsafe(callable)
    }

    public companion object {
        @PublishedApi
        internal val `delegate`:
                ReadOnlyProperty<GodotObject, Signal6<Any, Any, Any, Any, Any, Any>> =
                ReadOnlyProperty { thisRef, property -> getValue(thisRef, property) }

        public inline operator fun <P0, P1, P2, P3, P4, P5> getValue(thisRef: GodotObject,
                `property`: KProperty<*>): Signal6<P0, P1, P2, P3, P4, P5> =
                Signal6(thisRef, property.toGodotName())

        @JvmStatic
        @JvmName("create")
        public fun <P0, P1, P2, P3, P4, P5> _createJava(godotObject: GodotObject,
                signalName: String): Signal6<P0, P1, P2, P3, P4, P5> =
                Signal6(godotObject, signalName.toGodotName())
    }
}

@Suppress("FUNCTION_NAME")
public inline fun <P0, P1, P2, P3, P4, P5> GodotObject.Signal6(signalName: String) =
        Signal6<P0, P1, P2, P3, P4, P5>(this, signalName.toGodotName())

@Suppress("UNCHECKED_CAST")
public inline fun <P0, P1, P2, P3, P4, P5> GodotObject.signal6() =
        Signal6.delegate as ReadOnlyProperty<GodotObject, Signal6<P0, P1, P2, P3, P4, P5>>

public class Signal7<P0, P1, P2, P3, P4, P5, P6> @PublishedApi internal constructor(
    instance: GodotObject,
    name: StringName,
) : Signal(instance, name) {
    public fun emit(
        p0: P0,
        p1: P1,
        p2: P2,
        p3: P3,
        p4: P4,
        p5: P5,
        p6: P6,
    ): Unit {
        emitUnsafe(p0, p1, p2, p3, p4, p5, p6)
    }

    @JvmOverloads
    public fun connect(callable: Callable7<*, P0, P1, P2, P3, P4, P5, P6>, flags: ConnectFlags =
            ConnectFlags.DEFAULT): Unit {
        connectUnsafe(callable, flags)
    }

    public fun disconnect(callable: Callable7<*, P0, P1, P2, P3, P4, P5, P6>): Unit {
        disconnectUnsafe(callable)
    }

    public companion object {
        @PublishedApi
        internal val `delegate`:
                ReadOnlyProperty<GodotObject, Signal7<Any, Any, Any, Any, Any, Any, Any>> =
                ReadOnlyProperty { thisRef, property -> getValue(thisRef, property) }

        public inline operator fun <P0, P1, P2, P3, P4, P5, P6> getValue(thisRef: GodotObject,
                `property`: KProperty<*>): Signal7<P0, P1, P2, P3, P4, P5, P6> =
                Signal7(thisRef, property.toGodotName())

        @JvmStatic
        @JvmName("create")
        public fun <P0, P1, P2, P3, P4, P5, P6> _createJava(godotObject: GodotObject,
                signalName: String): Signal7<P0, P1, P2, P3, P4, P5, P6> =
                Signal7(godotObject, signalName.toGodotName())
    }
}

@Suppress("FUNCTION_NAME")
public inline fun <P0, P1, P2, P3, P4, P5, P6> GodotObject.Signal7(signalName: String) =
        Signal7<P0, P1, P2, P3, P4, P5, P6>(this, signalName.toGodotName())

@Suppress("UNCHECKED_CAST")
public inline fun <P0, P1, P2, P3, P4, P5, P6> GodotObject.signal7() =
        Signal7.delegate as ReadOnlyProperty<GodotObject, Signal7<P0, P1, P2, P3, P4, P5, P6>>

public class Signal8<P0, P1, P2, P3, P4, P5, P6, P7> @PublishedApi internal constructor(
    instance: GodotObject,
    name: StringName,
) : Signal(instance, name) {
    public fun emit(
        p0: P0,
        p1: P1,
        p2: P2,
        p3: P3,
        p4: P4,
        p5: P5,
        p6: P6,
        p7: P7,
    ): Unit {
        emitUnsafe(p0, p1, p2, p3, p4, p5, p6, p7)
    }

    @JvmOverloads
    public fun connect(callable: Callable8<*, P0, P1, P2, P3, P4, P5, P6, P7>, flags: ConnectFlags =
            ConnectFlags.DEFAULT): Unit {
        connectUnsafe(callable, flags)
    }

    public fun disconnect(callable: Callable8<*, P0, P1, P2, P3, P4, P5, P6, P7>): Unit {
        disconnectUnsafe(callable)
    }

    public companion object {
        @PublishedApi
        internal val `delegate`:
                ReadOnlyProperty<GodotObject, Signal8<Any, Any, Any, Any, Any, Any, Any, Any>> =
                ReadOnlyProperty { thisRef, property -> getValue(thisRef, property) }

        public inline operator fun <P0, P1, P2, P3, P4, P5, P6, P7> getValue(thisRef: GodotObject,
                `property`: KProperty<*>): Signal8<P0, P1, P2, P3, P4, P5, P6, P7> =
                Signal8(thisRef, property.toGodotName())

        @JvmStatic
        @JvmName("create")
        public fun <P0, P1, P2, P3, P4, P5, P6, P7> _createJava(godotObject: GodotObject,
                signalName: String): Signal8<P0, P1, P2, P3, P4, P5, P6, P7> =
                Signal8(godotObject, signalName.toGodotName())
    }
}

@Suppress("FUNCTION_NAME")
public inline fun <P0, P1, P2, P3, P4, P5, P6, P7> GodotObject.Signal8(signalName: String) =
        Signal8<P0, P1, P2, P3, P4, P5, P6, P7>(this, signalName.toGodotName())

@Suppress("UNCHECKED_CAST")
public inline fun <P0, P1, P2, P3, P4, P5, P6, P7> GodotObject.signal8() =
        Signal8.delegate as ReadOnlyProperty<GodotObject, Signal8<P0, P1, P2, P3, P4, P5, P6, P7>>

public class Signal9<P0, P1, P2, P3, P4, P5, P6, P7, P8> @PublishedApi internal constructor(
    instance: GodotObject,
    name: StringName,
) : Signal(instance, name) {
    public fun emit(
        p0: P0,
        p1: P1,
        p2: P2,
        p3: P3,
        p4: P4,
        p5: P5,
        p6: P6,
        p7: P7,
        p8: P8,
    ): Unit {
        emitUnsafe(p0, p1, p2, p3, p4, p5, p6, p7, p8)
    }

    @JvmOverloads
    public fun connect(callable: Callable9<*, P0, P1, P2, P3, P4, P5, P6, P7, P8>,
            flags: ConnectFlags = ConnectFlags.DEFAULT): Unit {
        connectUnsafe(callable, flags)
    }

    public fun disconnect(callable: Callable9<*, P0, P1, P2, P3, P4, P5, P6, P7, P8>): Unit {
        disconnectUnsafe(callable)
    }

    public companion object {
        @PublishedApi
        internal val `delegate`:
                ReadOnlyProperty<GodotObject, Signal9<Any, Any, Any, Any, Any, Any, Any, Any, Any>>
                = ReadOnlyProperty { thisRef, property -> getValue(thisRef, property) }

        public inline operator fun <P0, P1, P2, P3, P4, P5, P6, P7, P8>
                getValue(thisRef: GodotObject, `property`: KProperty<*>):
                Signal9<P0, P1, P2, P3, P4, P5, P6, P7, P8> =
                Signal9(thisRef, property.toGodotName())

        @JvmStatic
        @JvmName("create")
        public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8> _createJava(godotObject: GodotObject,
                signalName: String): Signal9<P0, P1, P2, P3, P4, P5, P6, P7, P8> =
                Signal9(godotObject, signalName.toGodotName())
    }
}

@Suppress("FUNCTION_NAME")
public inline fun <P0, P1, P2, P3, P4, P5, P6, P7, P8> GodotObject.Signal9(signalName: String) =
        Signal9<P0, P1, P2, P3, P4, P5, P6, P7, P8>(this, signalName.toGodotName())

@Suppress("UNCHECKED_CAST")
public inline fun <P0, P1, P2, P3, P4, P5, P6, P7, P8> GodotObject.signal9() =
        Signal9.delegate as ReadOnlyProperty<GodotObject, Signal9<P0, P1, P2, P3, P4, P5, P6, P7, P8>>

public class Signal10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> @PublishedApi internal constructor(
    instance: GodotObject,
    name: StringName,
) : Signal(instance, name) {
    public fun emit(
        p0: P0,
        p1: P1,
        p2: P2,
        p3: P3,
        p4: P4,
        p5: P5,
        p6: P6,
        p7: P7,
        p8: P8,
        p9: P9,
    ): Unit {
        emitUnsafe(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9)
    }

    @JvmOverloads
    public fun connect(callable: Callable10<*, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>,
            flags: ConnectFlags = ConnectFlags.DEFAULT): Unit {
        connectUnsafe(callable, flags)
    }

    public fun disconnect(callable: Callable10<*, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>): Unit {
        disconnectUnsafe(callable)
    }

    public companion object {
        @PublishedApi
        internal val `delegate`:
                ReadOnlyProperty<GodotObject, Signal10<Any, Any, Any, Any, Any, Any, Any, Any, Any, Any>>
                = ReadOnlyProperty { thisRef, property -> getValue(thisRef, property) }

        public inline operator fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>
                getValue(thisRef: GodotObject, `property`: KProperty<*>):
                Signal10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> =
                Signal10(thisRef, property.toGodotName())

        @JvmStatic
        @JvmName("create")
        public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> _createJava(godotObject: GodotObject,
                signalName: String): Signal10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> =
                Signal10(godotObject, signalName.toGodotName())
    }
}

@Suppress("FUNCTION_NAME")
public inline fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> GodotObject.Signal10(signalName: String)
        = Signal10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(this, signalName.toGodotName())

@Suppress("UNCHECKED_CAST")
public inline fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> GodotObject.signal10() =
        Signal10.delegate as ReadOnlyProperty<GodotObject, Signal10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>>

public class Signal11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> @PublishedApi internal
        constructor(
    instance: GodotObject,
    name: StringName,
) : Signal(instance, name) {
    public fun emit(
        p0: P0,
        p1: P1,
        p2: P2,
        p3: P3,
        p4: P4,
        p5: P5,
        p6: P6,
        p7: P7,
        p8: P8,
        p9: P9,
        p10: P10,
    ): Unit {
        emitUnsafe(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10)
    }

    @JvmOverloads
    public fun connect(callable: Callable11<*, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>,
            flags: ConnectFlags = ConnectFlags.DEFAULT): Unit {
        connectUnsafe(callable, flags)
    }

    public fun disconnect(callable: Callable11<*, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>):
            Unit {
        disconnectUnsafe(callable)
    }

    public companion object {
        @PublishedApi
        internal val `delegate`:
                ReadOnlyProperty<GodotObject, Signal11<Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any>>
                = ReadOnlyProperty { thisRef, property -> getValue(thisRef, property) }

        public inline operator fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>
                getValue(thisRef: GodotObject, `property`: KProperty<*>):
                Signal11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> =
                Signal11(thisRef, property.toGodotName())

        @JvmStatic
        @JvmName("create")
        public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>
                _createJava(godotObject: GodotObject, signalName: String):
                Signal11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> =
                Signal11(godotObject, signalName.toGodotName())
    }
}

@Suppress("FUNCTION_NAME")
public inline fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>
        GodotObject.Signal11(signalName: String) =
        Signal11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(this, signalName.toGodotName())

@Suppress("UNCHECKED_CAST")
public inline fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> GodotObject.signal11() =
        Signal11.delegate as ReadOnlyProperty<GodotObject, Signal11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>>

public class Signal12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> @PublishedApi internal
        constructor(
    instance: GodotObject,
    name: StringName,
) : Signal(instance, name) {
    public fun emit(
        p0: P0,
        p1: P1,
        p2: P2,
        p3: P3,
        p4: P4,
        p5: P5,
        p6: P6,
        p7: P7,
        p8: P8,
        p9: P9,
        p10: P10,
        p11: P11,
    ): Unit {
        emitUnsafe(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)
    }

    @JvmOverloads
    public fun connect(callable: Callable12<*, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>,
            flags: ConnectFlags = ConnectFlags.DEFAULT): Unit {
        connectUnsafe(callable, flags)
    }

    public
            fun disconnect(callable: Callable12<*, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>):
            Unit {
        disconnectUnsafe(callable)
    }

    public companion object {
        @PublishedApi
        internal val `delegate`:
                ReadOnlyProperty<GodotObject, Signal12<Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any>>
                = ReadOnlyProperty { thisRef, property -> getValue(thisRef, property) }

        public inline operator fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>
                getValue(thisRef: GodotObject, `property`: KProperty<*>):
                Signal12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> =
                Signal12(thisRef, property.toGodotName())

        @JvmStatic
        @JvmName("create")
        public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>
                _createJava(godotObject: GodotObject, signalName: String):
                Signal12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> =
                Signal12(godotObject, signalName.toGodotName())
    }
}

@Suppress("FUNCTION_NAME")
public inline fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>
        GodotObject.Signal12(signalName: String) =
        Signal12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(this, signalName.toGodotName())

@Suppress("UNCHECKED_CAST")
public inline fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> GodotObject.signal12() =
        Signal12.delegate as ReadOnlyProperty<GodotObject, Signal12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>>

public class Signal13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> @PublishedApi internal
        constructor(
    instance: GodotObject,
    name: StringName,
) : Signal(instance, name) {
    public fun emit(
        p0: P0,
        p1: P1,
        p2: P2,
        p3: P3,
        p4: P4,
        p5: P5,
        p6: P6,
        p7: P7,
        p8: P8,
        p9: P9,
        p10: P10,
        p11: P11,
        p12: P12,
    ): Unit {
        emitUnsafe(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12)
    }

    @JvmOverloads
    public
            fun connect(callable: Callable13<*, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>,
            flags: ConnectFlags = ConnectFlags.DEFAULT): Unit {
        connectUnsafe(callable, flags)
    }

    public
            fun disconnect(callable: Callable13<*, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>):
            Unit {
        disconnectUnsafe(callable)
    }

    public companion object {
        @PublishedApi
        internal val `delegate`:
                ReadOnlyProperty<GodotObject, Signal13<Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any>>
                = ReadOnlyProperty { thisRef, property -> getValue(thisRef, property) }

        public inline operator fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>
                getValue(thisRef: GodotObject, `property`: KProperty<*>):
                Signal13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> =
                Signal13(thisRef, property.toGodotName())

        @JvmStatic
        @JvmName("create")
        public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>
                _createJava(godotObject: GodotObject, signalName: String):
                Signal13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> =
                Signal13(godotObject, signalName.toGodotName())
    }
}

@Suppress("FUNCTION_NAME")
public inline fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>
        GodotObject.Signal13(signalName: String) =
        Signal13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>(this, signalName.toGodotName())

@Suppress("UNCHECKED_CAST")
public inline fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> GodotObject.signal13() =
        Signal13.delegate as ReadOnlyProperty<GodotObject, Signal13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>>

public class Signal14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> @PublishedApi
        internal constructor(
    instance: GodotObject,
    name: StringName,
) : Signal(instance, name) {
    public fun emit(
        p0: P0,
        p1: P1,
        p2: P2,
        p3: P3,
        p4: P4,
        p5: P5,
        p6: P6,
        p7: P7,
        p8: P8,
        p9: P9,
        p10: P10,
        p11: P11,
        p12: P12,
        p13: P13,
    ): Unit {
        emitUnsafe(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13)
    }

    @JvmOverloads
    public
            fun connect(callable: Callable14<*, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>,
            flags: ConnectFlags = ConnectFlags.DEFAULT): Unit {
        connectUnsafe(callable, flags)
    }

    public
            fun disconnect(callable: Callable14<*, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>):
            Unit {
        disconnectUnsafe(callable)
    }

    public companion object {
        @PublishedApi
        internal val `delegate`:
                ReadOnlyProperty<GodotObject, Signal14<Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any>>
                = ReadOnlyProperty { thisRef, property -> getValue(thisRef, property) }

        public inline operator fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>
                getValue(thisRef: GodotObject, `property`: KProperty<*>):
                Signal14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> =
                Signal14(thisRef, property.toGodotName())

        @JvmStatic
        @JvmName("create")
        public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>
                _createJava(godotObject: GodotObject, signalName: String):
                Signal14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> =
                Signal14(godotObject, signalName.toGodotName())
    }
}

@Suppress("FUNCTION_NAME")
public inline fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>
        GodotObject.Signal14(signalName: String) =
        Signal14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>(this, signalName.toGodotName())

@Suppress("UNCHECKED_CAST")
public inline fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>
        GodotObject.signal14() =
        Signal14.delegate as ReadOnlyProperty<GodotObject, Signal14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>>

public class Signal15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> @PublishedApi
        internal constructor(
    instance: GodotObject,
    name: StringName,
) : Signal(instance, name) {
    public fun emit(
        p0: P0,
        p1: P1,
        p2: P2,
        p3: P3,
        p4: P4,
        p5: P5,
        p6: P6,
        p7: P7,
        p8: P8,
        p9: P9,
        p10: P10,
        p11: P11,
        p12: P12,
        p13: P13,
        p14: P14,
    ): Unit {
        emitUnsafe(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14)
    }

    @JvmOverloads
    public
            fun connect(callable: Callable15<*, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>,
            flags: ConnectFlags = ConnectFlags.DEFAULT): Unit {
        connectUnsafe(callable, flags)
    }

    public
            fun disconnect(callable: Callable15<*, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>):
            Unit {
        disconnectUnsafe(callable)
    }

    public companion object {
        @PublishedApi
        internal val `delegate`:
                ReadOnlyProperty<GodotObject, Signal15<Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any>>
                = ReadOnlyProperty { thisRef, property -> getValue(thisRef, property) }

        public inline operator fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>
                getValue(thisRef: GodotObject, `property`: KProperty<*>):
                Signal15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> =
                Signal15(thisRef, property.toGodotName())

        @JvmStatic
        @JvmName("create")
        public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>
                _createJava(godotObject: GodotObject, signalName: String):
                Signal15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> =
                Signal15(godotObject, signalName.toGodotName())
    }
}

@Suppress("FUNCTION_NAME")
public inline fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>
        GodotObject.Signal15(signalName: String) =
        Signal15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>(this, signalName.toGodotName())

@Suppress("UNCHECKED_CAST")
public inline fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>
        GodotObject.signal15() =
        Signal15.delegate as ReadOnlyProperty<GodotObject, Signal15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>>

public class Signal16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>
        @PublishedApi internal constructor(
    instance: GodotObject,
    name: StringName,
) : Signal(instance, name) {
    public fun emit(
        p0: P0,
        p1: P1,
        p2: P2,
        p3: P3,
        p4: P4,
        p5: P5,
        p6: P6,
        p7: P7,
        p8: P8,
        p9: P9,
        p10: P10,
        p11: P11,
        p12: P12,
        p13: P13,
        p14: P14,
        p15: P15,
    ): Unit {
        emitUnsafe(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15)
    }

    @JvmOverloads
    public
            fun connect(callable: Callable16<*, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>,
            flags: ConnectFlags = ConnectFlags.DEFAULT): Unit {
        connectUnsafe(callable, flags)
    }

    public
            fun disconnect(callable: Callable16<*, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>):
            Unit {
        disconnectUnsafe(callable)
    }

    public companion object {
        @PublishedApi
        internal val `delegate`:
                ReadOnlyProperty<GodotObject, Signal16<Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any>>
                = ReadOnlyProperty { thisRef, property -> getValue(thisRef, property) }

        public inline operator fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14,
                P15> getValue(thisRef: GodotObject, `property`: KProperty<*>):
                Signal16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> =
                Signal16(thisRef, property.toGodotName())

        @JvmStatic
        @JvmName("create")
        public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>
                _createJava(godotObject: GodotObject, signalName: String):
                Signal16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> =
                Signal16(godotObject, signalName.toGodotName())
    }
}

@Suppress("FUNCTION_NAME")
public inline fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>
        GodotObject.Signal16(signalName: String) =
        Signal16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>(this, signalName.toGodotName())

@Suppress("UNCHECKED_CAST")
public inline fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>
        GodotObject.signal16() =
        Signal16.delegate as ReadOnlyProperty<GodotObject, Signal16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>>
