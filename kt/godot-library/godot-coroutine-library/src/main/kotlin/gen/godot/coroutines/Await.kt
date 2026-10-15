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
import godot.extension.promise
import kotlin.Suppress
import kotlin.Unit
import kotlin.coroutines.resume
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.suspendCancellableCoroutine

public suspend inline fun Signal0.await(): Unit = suspendCancellableCoroutine {
    cont: CancellableContinuation<Unit> ->
    var pending: CancellableContinuation<Unit>? = cont
    promise(
    {  -> pending?.resume(Unit) },
    { pending?.cancel() },
    )
    cont.invokeOnCancellation { pending = null }
}

public suspend inline fun <reified P0> Signal1<P0>.await(): P0 = suspendCancellableCoroutine {
    cont: CancellableContinuation<P0> ->
    var pending: CancellableContinuation<P0>? = cont
    promise(
    { p0: P0 -> pending?.resume(p0) },
    { pending?.cancel() },
    )
    cont.invokeOnCancellation { pending = null }
}

public data class SignalArguments2<P0, P1>(
    public val p0: P0,
    public val p1: P1,
)

public suspend inline fun <reified P0, reified P1> Signal2<P0, P1>.await(): SignalArguments2<P0, P1>
        = suspendCancellableCoroutine {
    cont: CancellableContinuation<SignalArguments2<P0, P1>> ->
    var pending: CancellableContinuation<SignalArguments2<P0, P1>>? = cont
    promise(
    { p0: P0, p1: P1 -> pending?.resume(SignalArguments2(p0, p1)) },
    { pending?.cancel() },
    )
    cont.invokeOnCancellation { pending = null }
}

public data class SignalArguments3<P0, P1, P2>(
    public val p0: P0,
    public val p1: P1,
    public val p2: P2,
)

public suspend inline fun <reified P0, reified P1, reified P2> Signal3<P0, P1, P2>.await():
        SignalArguments3<P0, P1, P2> = suspendCancellableCoroutine {
    cont: CancellableContinuation<SignalArguments3<P0, P1, P2>> ->
    var pending: CancellableContinuation<SignalArguments3<P0, P1, P2>>? = cont
    promise(
    { p0: P0, p1: P1, p2: P2 -> pending?.resume(SignalArguments3(p0, p1, p2)) },
    { pending?.cancel() },
    )
    cont.invokeOnCancellation { pending = null }
}

public data class SignalArguments4<P0, P1, P2, P3>(
    public val p0: P0,
    public val p1: P1,
    public val p2: P2,
    public val p3: P3,
)

public suspend inline fun <reified P0, reified P1, reified P2, reified P3>
        Signal4<P0, P1, P2, P3>.await(): SignalArguments4<P0, P1, P2, P3> =
        suspendCancellableCoroutine {
    cont: CancellableContinuation<SignalArguments4<P0, P1, P2, P3>> ->
    var pending: CancellableContinuation<SignalArguments4<P0, P1, P2, P3>>? = cont
    promise(
    { p0: P0, p1: P1, p2: P2, p3: P3 -> pending?.resume(SignalArguments4(p0, p1, p2, p3)) },
    { pending?.cancel() },
    )
    cont.invokeOnCancellation { pending = null }
}

public data class SignalArguments5<P0, P1, P2, P3, P4>(
    public val p0: P0,
    public val p1: P1,
    public val p2: P2,
    public val p3: P3,
    public val p4: P4,
)

public suspend inline fun <reified P0, reified P1, reified P2, reified P3, reified P4>
        Signal5<P0, P1, P2, P3, P4>.await(): SignalArguments5<P0, P1, P2, P3, P4> =
        suspendCancellableCoroutine {
    cont: CancellableContinuation<SignalArguments5<P0, P1, P2, P3, P4>> ->
    var pending: CancellableContinuation<SignalArguments5<P0, P1, P2, P3, P4>>? = cont
    promise(
    { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4 -> pending?.resume(SignalArguments5(p0, p1, p2, p3, p4)) },
    { pending?.cancel() },
    )
    cont.invokeOnCancellation { pending = null }
}

public data class SignalArguments6<P0, P1, P2, P3, P4, P5>(
    public val p0: P0,
    public val p1: P1,
    public val p2: P2,
    public val p3: P3,
    public val p4: P4,
    public val p5: P5,
)

public suspend inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5>
        Signal6<P0, P1, P2, P3, P4, P5>.await(): SignalArguments6<P0, P1, P2, P3, P4, P5> =
        suspendCancellableCoroutine {
    cont: CancellableContinuation<SignalArguments6<P0, P1, P2, P3, P4, P5>> ->
    var pending: CancellableContinuation<SignalArguments6<P0, P1, P2, P3, P4, P5>>? = cont
    promise(
    { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5 -> pending?.resume(SignalArguments6(p0, p1, p2, p3, p4, p5)) },
    { pending?.cancel() },
    )
    cont.invokeOnCancellation { pending = null }
}

public data class SignalArguments7<P0, P1, P2, P3, P4, P5, P6>(
    public val p0: P0,
    public val p1: P1,
    public val p2: P2,
    public val p3: P3,
    public val p4: P4,
    public val p5: P5,
    public val p6: P6,
)

public suspend inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5,
        reified P6> Signal7<P0, P1, P2, P3, P4, P5, P6>.await():
        SignalArguments7<P0, P1, P2, P3, P4, P5, P6> = suspendCancellableCoroutine {
    cont: CancellableContinuation<SignalArguments7<P0, P1, P2, P3, P4, P5, P6>> ->
    var pending: CancellableContinuation<SignalArguments7<P0, P1, P2, P3, P4, P5, P6>>? = cont
    promise(
    { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6 -> pending?.resume(SignalArguments7(p0, p1, p2, p3, p4, p5, p6)) },
    { pending?.cancel() },
    )
    cont.invokeOnCancellation { pending = null }
}

public data class SignalArguments8<P0, P1, P2, P3, P4, P5, P6, P7>(
    public val p0: P0,
    public val p1: P1,
    public val p2: P2,
    public val p3: P3,
    public val p4: P4,
    public val p5: P5,
    public val p6: P6,
    public val p7: P7,
)

public suspend inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5,
        reified P6, reified P7> Signal8<P0, P1, P2, P3, P4, P5, P6, P7>.await():
        SignalArguments8<P0, P1, P2, P3, P4, P5, P6, P7> = suspendCancellableCoroutine {
    cont: CancellableContinuation<SignalArguments8<P0, P1, P2, P3, P4, P5, P6, P7>> ->
    var pending: CancellableContinuation<SignalArguments8<P0, P1, P2, P3, P4, P5, P6, P7>>? = cont
    promise(
    { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7 -> pending?.resume(SignalArguments8(p0, p1, p2, p3, p4, p5, p6, p7)) },
    { pending?.cancel() },
    )
    cont.invokeOnCancellation { pending = null }
}

public data class SignalArguments9<P0, P1, P2, P3, P4, P5, P6, P7, P8>(
    public val p0: P0,
    public val p1: P1,
    public val p2: P2,
    public val p3: P3,
    public val p4: P4,
    public val p5: P5,
    public val p6: P6,
    public val p7: P7,
    public val p8: P8,
)

public suspend inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5,
        reified P6, reified P7, reified P8> Signal9<P0, P1, P2, P3, P4, P5, P6, P7, P8>.await():
        SignalArguments9<P0, P1, P2, P3, P4, P5, P6, P7, P8> = suspendCancellableCoroutine {
    cont: CancellableContinuation<SignalArguments9<P0, P1, P2, P3, P4, P5, P6, P7, P8>> ->
    var pending: CancellableContinuation<SignalArguments9<P0, P1, P2, P3, P4, P5, P6, P7, P8>>? = cont
    promise(
    { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8 -> pending?.resume(SignalArguments9(p0, p1, p2, p3, p4, p5, p6, p7, p8)) },
    { pending?.cancel() },
    )
    cont.invokeOnCancellation { pending = null }
}

public data class SignalArguments10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(
    public val p0: P0,
    public val p1: P1,
    public val p2: P2,
    public val p3: P3,
    public val p4: P4,
    public val p5: P5,
    public val p6: P6,
    public val p7: P7,
    public val p8: P8,
    public val p9: P9,
)

public suspend inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5,
        reified P6, reified P7, reified P8, reified P9>
        Signal10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>.await():
        SignalArguments10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> = suspendCancellableCoroutine {
    cont: CancellableContinuation<SignalArguments10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>> ->
    var pending: CancellableContinuation<SignalArguments10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>>? = cont
    promise(
    { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9 -> pending?.resume(SignalArguments10(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9)) },
    { pending?.cancel() },
    )
    cont.invokeOnCancellation { pending = null }
}

public data class SignalArguments11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(
    public val p0: P0,
    public val p1: P1,
    public val p2: P2,
    public val p3: P3,
    public val p4: P4,
    public val p5: P5,
    public val p6: P6,
    public val p7: P7,
    public val p8: P8,
    public val p9: P9,
    public val p10: P10,
)

public suspend inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5,
        reified P6, reified P7, reified P8, reified P9, reified P10>
        Signal11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>.await():
        SignalArguments11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> =
        suspendCancellableCoroutine {
    cont: CancellableContinuation<SignalArguments11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>> ->
    var pending: CancellableContinuation<SignalArguments11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>>? = cont
    promise(
    { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10 -> pending?.resume(SignalArguments11(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10)) },
    { pending?.cancel() },
    )
    cont.invokeOnCancellation { pending = null }
}

public data class SignalArguments12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(
    public val p0: P0,
    public val p1: P1,
    public val p2: P2,
    public val p3: P3,
    public val p4: P4,
    public val p5: P5,
    public val p6: P6,
    public val p7: P7,
    public val p8: P8,
    public val p9: P9,
    public val p10: P10,
    public val p11: P11,
)

public suspend inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5,
        reified P6, reified P7, reified P8, reified P9, reified P10, reified P11>
        Signal12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>.await():
        SignalArguments12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> =
        suspendCancellableCoroutine {
    cont: CancellableContinuation<SignalArguments12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>> ->
    var pending: CancellableContinuation<SignalArguments12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>>? = cont
    promise(
    { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11 -> pending?.resume(SignalArguments12(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)) },
    { pending?.cancel() },
    )
    cont.invokeOnCancellation { pending = null }
}

public data class SignalArguments13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>(
    public val p0: P0,
    public val p1: P1,
    public val p2: P2,
    public val p3: P3,
    public val p4: P4,
    public val p5: P5,
    public val p6: P6,
    public val p7: P7,
    public val p8: P8,
    public val p9: P9,
    public val p10: P10,
    public val p11: P11,
    public val p12: P12,
)

public suspend inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5,
        reified P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12>
        Signal13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>.await():
        SignalArguments13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> =
        suspendCancellableCoroutine {
    cont: CancellableContinuation<SignalArguments13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>> ->
    var pending: CancellableContinuation<SignalArguments13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>>? = cont
    promise(
    { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11, p12: P12 -> pending?.resume(SignalArguments13(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12)) },
    { pending?.cancel() },
    )
    cont.invokeOnCancellation { pending = null }
}

public data class SignalArguments14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>(
    public val p0: P0,
    public val p1: P1,
    public val p2: P2,
    public val p3: P3,
    public val p4: P4,
    public val p5: P5,
    public val p6: P6,
    public val p7: P7,
    public val p8: P8,
    public val p9: P9,
    public val p10: P10,
    public val p11: P11,
    public val p12: P12,
    public val p13: P13,
)

public suspend inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5,
        reified P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12,
        reified P13> Signal14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>.await():
        SignalArguments14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> =
        suspendCancellableCoroutine {
    cont: CancellableContinuation<SignalArguments14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>> ->
    var pending: CancellableContinuation<SignalArguments14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>>? = cont
    promise(
    { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11, p12: P12, p13: P13 -> pending?.resume(SignalArguments14(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13)) },
    { pending?.cancel() },
    )
    cont.invokeOnCancellation { pending = null }
}

public data class SignalArguments15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13,
        P14>(
    public val p0: P0,
    public val p1: P1,
    public val p2: P2,
    public val p3: P3,
    public val p4: P4,
    public val p5: P5,
    public val p6: P6,
    public val p7: P7,
    public val p8: P8,
    public val p9: P9,
    public val p10: P10,
    public val p11: P11,
    public val p12: P12,
    public val p13: P13,
    public val p14: P14,
)

public suspend inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5,
        reified P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12,
        reified P13, reified P14>
        Signal15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>.await():
        SignalArguments15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> =
        suspendCancellableCoroutine {
    cont: CancellableContinuation<SignalArguments15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>> ->
    var pending: CancellableContinuation<SignalArguments15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>>? = cont
    promise(
    { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11, p12: P12, p13: P13, p14: P14 -> pending?.resume(SignalArguments15(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14)) },
    { pending?.cancel() },
    )
    cont.invokeOnCancellation { pending = null }
}

public data class SignalArguments16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14,
        P15>(
    public val p0: P0,
    public val p1: P1,
    public val p2: P2,
    public val p3: P3,
    public val p4: P4,
    public val p5: P5,
    public val p6: P6,
    public val p7: P7,
    public val p8: P8,
    public val p9: P9,
    public val p10: P10,
    public val p11: P11,
    public val p12: P12,
    public val p13: P13,
    public val p14: P14,
    public val p15: P15,
)

public suspend inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5,
        reified P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12,
        reified P13, reified P14, reified P15>
        Signal16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>.await():
        SignalArguments16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> =
        suspendCancellableCoroutine {
    cont: CancellableContinuation<SignalArguments16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>> ->
    var pending: CancellableContinuation<SignalArguments16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>>? = cont
    promise(
    { p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11, p12: P12, p13: P13, p14: P14, p15: P15 -> pending?.resume(SignalArguments16(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15)) },
    { pending?.cancel() },
    )
    cont.invokeOnCancellation { pending = null }
}
