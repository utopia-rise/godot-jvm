@file:Suppress("PackageDirectoryMismatch", "unused")

package godot.coroutines

import godot.core.Signal0
import godot.core.Signal1
import godot.core.Signal10
import godot.core.Signal11
import godot.core.Signal12
import godot.core.Signal13
import godot.core.Signal14
import godot.core.Signal15
import godot.core.Signal16
import godot.core.Signal2
import godot.core.Signal3
import godot.core.Signal4
import godot.core.Signal5
import godot.core.Signal6
import godot.core.Signal7
import godot.core.Signal8
import godot.core.Signal9
import godot.core.asCallable
import kotlin.Suppress
import kotlin.Unit
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

public inline fun Signal0.asFlow(): Flow<Unit> = callbackFlow {
    val callable = {  -> trySend(Unit); Unit }.asCallable()
    connectUnsafe(callable)
    awaitClose { if (isValid() && isConnected(callable)) disconnectUnsafe(callable) }
}

public inline fun <reified P0> Signal1<P0>.asFlow(): Flow<P0> = callbackFlow {
    val callable = { p0: P0 -> trySend(p0); Unit }.asCallable()
    connectUnsafe(callable)
    awaitClose { if (isValid() && isConnected(callable)) disconnectUnsafe(callable) }
}

public inline fun <reified P0, reified P1> Signal2<P0, P1>.asFlow(): Flow<SignalArguments2<P0, P1>>
        = callbackFlow {
    val callable = { p0: P0, p1: P1 -> trySend(SignalArguments2(p0, p1)); Unit }.asCallable()
    connectUnsafe(callable)
    awaitClose { if (isValid() && isConnected(callable)) disconnectUnsafe(callable) }
}

public inline fun <reified P0, reified P1, reified P2> Signal3<P0, P1, P2>.asFlow():
        Flow<SignalArguments3<P0, P1, P2>> = callbackFlow {
    val callable = { p0: P0, p1: P1, p2: P2 -> trySend(SignalArguments3(p0, p1, p2)); Unit
            }.asCallable()
    connectUnsafe(callable)
    awaitClose { if (isValid() && isConnected(callable)) disconnectUnsafe(callable) }
}

public inline fun <reified P0, reified P1, reified P2, reified P3> Signal4<P0, P1, P2, P3>.asFlow():
        Flow<SignalArguments4<P0, P1, P2, P3>> = callbackFlow {
    val callable = { p0: P0, p1: P1, p2: P2, p3: P3 -> trySend(SignalArguments4(p0, p1, p2, p3));
            Unit }.asCallable()
    connectUnsafe(callable)
    awaitClose { if (isValid() && isConnected(callable)) disconnectUnsafe(callable) }
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4>
        Signal5<P0, P1, P2, P3, P4>.asFlow(): Flow<SignalArguments5<P0, P1, P2, P3, P4>> =
        callbackFlow {
    val callable = { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4 -> trySend(SignalArguments5(p0, p1, p2,
            p3, p4)); Unit }.asCallable()
    connectUnsafe(callable)
    awaitClose { if (isValid() && isConnected(callable)) disconnectUnsafe(callable) }
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5>
        Signal6<P0, P1, P2, P3, P4, P5>.asFlow(): Flow<SignalArguments6<P0, P1, P2, P3, P4, P5>> =
        callbackFlow {
    val callable = { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5 -> trySend(SignalArguments6(p0,
            p1, p2, p3, p4, p5)); Unit }.asCallable()
    connectUnsafe(callable)
    awaitClose { if (isValid() && isConnected(callable)) disconnectUnsafe(callable) }
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
        P6> Signal7<P0, P1, P2, P3, P4, P5, P6>.asFlow():
        Flow<SignalArguments7<P0, P1, P2, P3, P4, P5, P6>> = callbackFlow {
    val callable = { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6 ->
            trySend(SignalArguments7(p0, p1, p2, p3, p4, p5, p6)); Unit }.asCallable()
    connectUnsafe(callable)
    awaitClose { if (isValid() && isConnected(callable)) disconnectUnsafe(callable) }
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
        P6, reified P7> Signal8<P0, P1, P2, P3, P4, P5, P6, P7>.asFlow():
        Flow<SignalArguments8<P0, P1, P2, P3, P4, P5, P6, P7>> = callbackFlow {
    val callable = { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7 ->
            trySend(SignalArguments8(p0, p1, p2, p3, p4, p5, p6, p7)); Unit }.asCallable()
    connectUnsafe(callable)
    awaitClose { if (isValid() && isConnected(callable)) disconnectUnsafe(callable) }
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
        P6, reified P7, reified P8> Signal9<P0, P1, P2, P3, P4, P5, P6, P7, P8>.asFlow():
        Flow<SignalArguments9<P0, P1, P2, P3, P4, P5, P6, P7, P8>> = callbackFlow {
    val callable = { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8 ->
            trySend(SignalArguments9(p0, p1, p2, p3, p4, p5, p6, p7, p8)); Unit }.asCallable()
    connectUnsafe(callable)
    awaitClose { if (isValid() && isConnected(callable)) disconnectUnsafe(callable) }
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
        P6, reified P7, reified P8, reified P9>
        Signal10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>.asFlow():
        Flow<SignalArguments10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>> = callbackFlow {
    val callable = { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9:
            P9 -> trySend(SignalArguments10(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9)); Unit
            }.asCallable()
    connectUnsafe(callable)
    awaitClose { if (isValid() && isConnected(callable)) disconnectUnsafe(callable) }
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
        P6, reified P7, reified P8, reified P9, reified P10>
        Signal11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>.asFlow():
        Flow<SignalArguments11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>> = callbackFlow {
    val callable = { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9,
            p10: P10 -> trySend(SignalArguments11(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
            Unit }.asCallable()
    connectUnsafe(callable)
    awaitClose { if (isValid() && isConnected(callable)) disconnectUnsafe(callable) }
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
        P6, reified P7, reified P8, reified P9, reified P10, reified P11>
        Signal12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>.asFlow():
        Flow<SignalArguments12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>> = callbackFlow {
    val callable = { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9,
            p10: P10, p11: P11 -> trySend(SignalArguments12(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9,
            p10, p11)); Unit }.asCallable()
    connectUnsafe(callable)
    awaitClose { if (isValid() && isConnected(callable)) disconnectUnsafe(callable) }
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
        P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12>
        Signal13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>.asFlow():
        Flow<SignalArguments13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>> =
        callbackFlow {
    val callable = { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9,
            p10: P10, p11: P11, p12: P12 -> trySend(SignalArguments13(p0, p1, p2, p3, p4, p5, p6,
            p7, p8, p9, p10, p11, p12)); Unit }.asCallable()
    connectUnsafe(callable)
    awaitClose { if (isValid() && isConnected(callable)) disconnectUnsafe(callable) }
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
        P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12, reified P13>
        Signal14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>.asFlow():
        Flow<SignalArguments14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>> =
        callbackFlow {
    val callable = { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9,
            p10: P10, p11: P11, p12: P12, p13: P13 -> trySend(SignalArguments14(p0, p1, p2, p3, p4,
            p5, p6, p7, p8, p9, p10, p11, p12, p13)); Unit }.asCallable()
    connectUnsafe(callable)
    awaitClose { if (isValid() && isConnected(callable)) disconnectUnsafe(callable) }
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
        P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12, reified P13,
        reified P14>
        Signal15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>.asFlow():
        Flow<SignalArguments15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>> =
        callbackFlow {
    val callable = { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9,
            p10: P10, p11: P11, p12: P12, p13: P13, p14: P14 -> trySend(SignalArguments15(p0, p1,
            p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14)); Unit }.asCallable()
    connectUnsafe(callable)
    awaitClose { if (isValid() && isConnected(callable)) disconnectUnsafe(callable) }
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
        P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12, reified P13,
        reified P14, reified P15>
        Signal16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>.asFlow():
        Flow<SignalArguments16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>>
        = callbackFlow {
    val callable = { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9,
            p10: P10, p11: P11, p12: P12, p13: P13, p14: P14, p15: P15 ->
            trySend(SignalArguments16(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13,
            p14, p15)); Unit }.asCallable()
    connectUnsafe(callable)
    awaitClose { if (isValid() && isConnected(callable)) disconnectUnsafe(callable) }
}
