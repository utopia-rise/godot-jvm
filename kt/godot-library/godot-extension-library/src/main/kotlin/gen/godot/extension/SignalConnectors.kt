@file:JvmName("SignalConnectors")
@file:Suppress(
  "PackageDirectoryMismatch", "UNCHECKED_CAST",
  "unused",
  "NOTHING_TO_INLINE",
)

package godot.extension

import godot.api.Object
import godot.core.ConnectFlags
import godot.core.JvmAction0
import godot.core.JvmAction1
import godot.core.JvmAction10
import godot.core.JvmAction11
import godot.core.JvmAction12
import godot.core.JvmAction13
import godot.core.JvmAction14
import godot.core.JvmAction15
import godot.core.JvmAction16
import godot.core.JvmAction2
import godot.core.JvmAction3
import godot.core.JvmAction4
import godot.core.JvmAction5
import godot.core.JvmAction6
import godot.core.JvmAction7
import godot.core.JvmAction8
import godot.core.JvmAction9
import godot.core.LambdaCallable0
import godot.core.LambdaCallable1
import godot.core.LambdaCallable10
import godot.core.LambdaCallable11
import godot.core.LambdaCallable12
import godot.core.LambdaCallable13
import godot.core.LambdaCallable14
import godot.core.LambdaCallable15
import godot.core.LambdaCallable16
import godot.core.LambdaCallable2
import godot.core.LambdaCallable3
import godot.core.LambdaCallable4
import godot.core.LambdaCallable5
import godot.core.LambdaCallable6
import godot.core.LambdaCallable7
import godot.core.LambdaCallable8
import godot.core.LambdaCallable9
import godot.core.LambdaContainer0
import godot.core.LambdaContainer1
import godot.core.LambdaContainer10
import godot.core.LambdaContainer11
import godot.core.LambdaContainer12
import godot.core.LambdaContainer13
import godot.core.LambdaContainer14
import godot.core.LambdaContainer15
import godot.core.LambdaContainer16
import godot.core.LambdaContainer2
import godot.core.LambdaContainer3
import godot.core.LambdaContainer4
import godot.core.LambdaContainer5
import godot.core.LambdaContainer6
import godot.core.LambdaContainer7
import godot.core.LambdaContainer8
import godot.core.LambdaContainer9
import godot.core.MethodCallable
import godot.core.MethodCallable0
import godot.core.MethodCallable1
import godot.core.MethodCallable10
import godot.core.MethodCallable11
import godot.core.MethodCallable12
import godot.core.MethodCallable13
import godot.core.MethodCallable14
import godot.core.MethodCallable15
import godot.core.MethodCallable16
import godot.core.MethodCallable2
import godot.core.MethodCallable3
import godot.core.MethodCallable4
import godot.core.MethodCallable5
import godot.core.MethodCallable6
import godot.core.MethodCallable7
import godot.core.MethodCallable8
import godot.core.MethodCallable9
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName10
import godot.core.MethodStringName11
import godot.core.MethodStringName12
import godot.core.MethodStringName13
import godot.core.MethodStringName14
import godot.core.MethodStringName15
import godot.core.MethodStringName16
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.MethodStringName6
import godot.core.MethodStringName7
import godot.core.MethodStringName8
import godot.core.MethodStringName9
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
import godot.core.VariantParser.NIL
import godot.core.asCallable
import godot.core.getVariantConverter
import godot.core.toGodotName
import java.lang.Class
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmSynthetic
import kotlin.reflect.KCallable

public inline fun Signal0.connectLambda(flags: ConnectFlags = ConnectFlags.DEFAULT, noinline
    method: () -> Unit): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      method.asCallable()
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectLambda0")
public fun Signal0._connectLambda0Java(flags: ConnectFlags = ConnectFlags.DEFAULT,
    action: JvmAction0): SignalConnector {
  val connector = SignalConnector.createUnsafe(
    this,
    LambdaCallable0._createJava(action)
  )
  connector.connect(flags)
  return connector
}

@JvmSynthetic
public fun <T : Object> Signal0.connectMethod(
  target: T,
  method: T.() -> Unit,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      MethodCallable(target, (method as KCallable<*>).name.toGodotName())
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectMethod0")
public fun <T : Object, R> Signal0._connectMethod0Java(
  target: T,
  method: MethodStringName0<T, R>,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this,
      MethodCallable0._createJava(target, method)
  )
  connector.connect(flags)
  return connector
}

public inline fun Signal0.promise(noinline method: () -> Unit, noinline cancel: () -> Unit): Unit {
  LambdaContainer0<Unit>(NIL, arrayOf(), method).setAsCancellable(this, cancel)
}

public inline fun <reified P0> Signal1<P0>.connectLambda(flags: ConnectFlags = ConnectFlags.DEFAULT,
    noinline method: (p0: P0) -> Unit): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      method.asCallable()
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectLambda1")
public fun <P0> Signal1<P0>._connectLambda1Java(
  flags: ConnectFlags = ConnectFlags.DEFAULT,
  p0Type: Class<P0>,
  action: JvmAction1<P0>,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
    this,
    LambdaCallable1._createJava(p0Type, action)
  )
  connector.connect(flags)
  return connector
}

@JvmSynthetic
public fun <T : Object, P0> Signal1<P0>.connectMethod(
  target: T,
  method: T.(p0: P0) -> Unit,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      MethodCallable(target, (method as KCallable<*>).name.toGodotName())
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectMethod1")
public fun <T : Object, R, P0> Signal1<P0>._connectMethod1Java(
  target: T,
  method: MethodStringName1<T, R, P0>,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this,
      MethodCallable1._createJava(target, method)
  )
  connector.connect(flags)
  return connector
}

public inline fun <reified P0> Signal1<P0>.promise(noinline method: (p0: P0) -> Unit, noinline
    cancel: () -> Unit): Unit {
  LambdaContainer1<Unit, P0>(NIL, arrayOf(getVariantConverter(P0::class)!!), method).setAsCancellable(this, cancel)
}

public inline fun <reified P0, reified P1> Signal2<P0, P1>.connectLambda(flags: ConnectFlags =
    ConnectFlags.DEFAULT, noinline method: (p0: P0, p1: P1) -> Unit): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      method.asCallable()
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectLambda2")
public fun <P0, P1> Signal2<P0, P1>._connectLambda2Java(
  flags: ConnectFlags = ConnectFlags.DEFAULT,
  p0Type: Class<P0>,
  p1Type: Class<P1>,
  action: JvmAction2<P0, P1>,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
    this,
    LambdaCallable2._createJava(p0Type, p1Type, action)
  )
  connector.connect(flags)
  return connector
}

@JvmSynthetic
public fun <T : Object, P0, P1> Signal2<P0, P1>.connectMethod(
  target: T,
  method: T.(p0: P0, p1: P1) -> Unit,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      MethodCallable(target, (method as KCallable<*>).name.toGodotName())
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectMethod2")
public fun <T : Object, R, P0, P1> Signal2<P0, P1>._connectMethod2Java(
  target: T,
  method: MethodStringName2<T, R, P0, P1>,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this,
      MethodCallable2._createJava(target, method)
  )
  connector.connect(flags)
  return connector
}

public inline fun <reified P0, reified P1> Signal2<P0, P1>.promise(noinline method: (p0: P0,
    p1: P1) -> Unit, noinline cancel: () -> Unit): Unit {
  LambdaContainer2<Unit, P0, P1>(NIL, arrayOf(getVariantConverter(P0::class)!!, getVariantConverter(P1::class)!!), method).setAsCancellable(this, cancel)
}

public inline fun <reified P0, reified P1, reified P2>
    Signal3<P0, P1, P2>.connectLambda(flags: ConnectFlags = ConnectFlags.DEFAULT, noinline method: (
  p0: P0,
  p1: P1,
  p2: P2,
) -> Unit): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      method.asCallable()
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectLambda3")
public fun <P0, P1, P2> Signal3<P0, P1, P2>._connectLambda3Java(
  flags: ConnectFlags = ConnectFlags.DEFAULT,
  p0Type: Class<P0>,
  p1Type: Class<P1>,
  p2Type: Class<P2>,
  action: JvmAction3<P0, P1, P2>,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
    this,
    LambdaCallable3._createJava(p0Type, p1Type, p2Type, action)
  )
  connector.connect(flags)
  return connector
}

@JvmSynthetic
public fun <T : Object, P0, P1, P2> Signal3<P0, P1, P2>.connectMethod(
  target: T,
  method: T.(
    p0: P0,
    p1: P1,
    p2: P2,
  ) -> Unit,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      MethodCallable(target, (method as KCallable<*>).name.toGodotName())
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectMethod3")
public fun <T : Object, R, P0, P1, P2> Signal3<P0, P1, P2>._connectMethod3Java(
  target: T,
  method: MethodStringName3<T, R, P0, P1, P2>,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this,
      MethodCallable3._createJava(target, method)
  )
  connector.connect(flags)
  return connector
}

public inline fun <reified P0, reified P1, reified P2> Signal3<P0, P1, P2>.promise(noinline
    method: (
  p0: P0,
  p1: P1,
  p2: P2,
) -> Unit, noinline cancel: () -> Unit): Unit {
  LambdaContainer3<Unit, P0, P1, P2>(NIL, arrayOf(getVariantConverter(P0::class)!!, getVariantConverter(P1::class)!!, getVariantConverter(P2::class)!!), method).setAsCancellable(this, cancel)
}

public inline fun <reified P0, reified P1, reified P2, reified P3>
    Signal4<P0, P1, P2, P3>.connectLambda(flags: ConnectFlags = ConnectFlags.DEFAULT, noinline
    method: (
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
) -> Unit): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      method.asCallable()
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectLambda4")
public fun <P0, P1, P2, P3> Signal4<P0, P1, P2, P3>._connectLambda4Java(
  flags: ConnectFlags = ConnectFlags.DEFAULT,
  p0Type: Class<P0>,
  p1Type: Class<P1>,
  p2Type: Class<P2>,
  p3Type: Class<P3>,
  action: JvmAction4<P0, P1, P2, P3>,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
    this,
    LambdaCallable4._createJava(p0Type, p1Type, p2Type, p3Type, action)
  )
  connector.connect(flags)
  return connector
}

@JvmSynthetic
public fun <T : Object, P0, P1, P2, P3> Signal4<P0, P1, P2, P3>.connectMethod(
  target: T,
  method: T.(
    p0: P0,
    p1: P1,
    p2: P2,
    p3: P3,
  ) -> Unit,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      MethodCallable(target, (method as KCallable<*>).name.toGodotName())
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectMethod4")
public fun <T : Object, R, P0, P1, P2, P3> Signal4<P0, P1, P2, P3>._connectMethod4Java(
  target: T,
  method: MethodStringName4<T, R, P0, P1, P2, P3>,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this,
      MethodCallable4._createJava(target, method)
  )
  connector.connect(flags)
  return connector
}

public inline fun <reified P0, reified P1, reified P2, reified P3>
    Signal4<P0, P1, P2, P3>.promise(noinline method: (
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
) -> Unit, noinline cancel: () -> Unit): Unit {
  LambdaContainer4<Unit, P0, P1, P2, P3>(NIL, arrayOf(getVariantConverter(P0::class)!!, getVariantConverter(P1::class)!!, getVariantConverter(P2::class)!!, getVariantConverter(P3::class)!!), method).setAsCancellable(this, cancel)
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4>
    Signal5<P0, P1, P2, P3, P4>.connectLambda(flags: ConnectFlags = ConnectFlags.DEFAULT, noinline
    method: (
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
) -> Unit): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      method.asCallable()
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectLambda5")
public fun <P0, P1, P2, P3, P4> Signal5<P0, P1, P2, P3, P4>._connectLambda5Java(
  flags: ConnectFlags = ConnectFlags.DEFAULT,
  p0Type: Class<P0>,
  p1Type: Class<P1>,
  p2Type: Class<P2>,
  p3Type: Class<P3>,
  p4Type: Class<P4>,
  action: JvmAction5<P0, P1, P2, P3, P4>,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
    this,
    LambdaCallable5._createJava(p0Type, p1Type, p2Type, p3Type, p4Type, action)
  )
  connector.connect(flags)
  return connector
}

@JvmSynthetic
public fun <T : Object, P0, P1, P2, P3, P4> Signal5<P0, P1, P2, P3, P4>.connectMethod(
  target: T,
  method: T.(
    p0: P0,
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
  ) -> Unit,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      MethodCallable(target, (method as KCallable<*>).name.toGodotName())
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectMethod5")
public fun <T : Object, R, P0, P1, P2, P3, P4> Signal5<P0, P1, P2, P3, P4>._connectMethod5Java(
  target: T,
  method: MethodStringName5<T, R, P0, P1, P2, P3, P4>,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this,
      MethodCallable5._createJava(target, method)
  )
  connector.connect(flags)
  return connector
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4>
    Signal5<P0, P1, P2, P3, P4>.promise(noinline method: (
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
) -> Unit, noinline cancel: () -> Unit): Unit {
  LambdaContainer5<Unit, P0, P1, P2, P3, P4>(NIL, arrayOf(getVariantConverter(P0::class)!!, getVariantConverter(P1::class)!!, getVariantConverter(P2::class)!!, getVariantConverter(P3::class)!!, getVariantConverter(P4::class)!!), method).setAsCancellable(this, cancel)
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5>
    Signal6<P0, P1, P2, P3, P4, P5>.connectLambda(flags: ConnectFlags = ConnectFlags.DEFAULT,
    noinline method: (
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
  p5: P5,
) -> Unit): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      method.asCallable()
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectLambda6")
public fun <P0, P1, P2, P3, P4, P5> Signal6<P0, P1, P2, P3, P4, P5>._connectLambda6Java(
  flags: ConnectFlags = ConnectFlags.DEFAULT,
  p0Type: Class<P0>,
  p1Type: Class<P1>,
  p2Type: Class<P2>,
  p3Type: Class<P3>,
  p4Type: Class<P4>,
  p5Type: Class<P5>,
  action: JvmAction6<P0, P1, P2, P3, P4, P5>,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
    this,
    LambdaCallable6._createJava(p0Type, p1Type, p2Type, p3Type, p4Type, p5Type, action)
  )
  connector.connect(flags)
  return connector
}

@JvmSynthetic
public fun <T : Object, P0, P1, P2, P3, P4, P5> Signal6<P0, P1, P2, P3, P4, P5>.connectMethod(
  target: T,
  method: T.(
    p0: P0,
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
  ) -> Unit,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      MethodCallable(target, (method as KCallable<*>).name.toGodotName())
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectMethod6")
public fun <T : Object, R, P0, P1, P2, P3, P4, P5>
    Signal6<P0, P1, P2, P3, P4, P5>._connectMethod6Java(
  target: T,
  method: MethodStringName6<T, R, P0, P1, P2, P3, P4, P5>,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this,
      MethodCallable6._createJava(target, method)
  )
  connector.connect(flags)
  return connector
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5>
    Signal6<P0, P1, P2, P3, P4, P5>.promise(noinline method: (
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
  p5: P5,
) -> Unit, noinline cancel: () -> Unit): Unit {
  LambdaContainer6<Unit, P0, P1, P2, P3, P4, P5>(NIL, arrayOf(getVariantConverter(P0::class)!!, getVariantConverter(P1::class)!!, getVariantConverter(P2::class)!!, getVariantConverter(P3::class)!!, getVariantConverter(P4::class)!!, getVariantConverter(P5::class)!!), method).setAsCancellable(this, cancel)
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6> Signal7<P0, P1, P2, P3, P4, P5, P6>.connectLambda(flags: ConnectFlags =
    ConnectFlags.DEFAULT, noinline method: (
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
  p5: P5,
  p6: P6,
) -> Unit): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      method.asCallable()
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectLambda7")
public fun <P0, P1, P2, P3, P4, P5, P6> Signal7<P0, P1, P2, P3, P4, P5, P6>._connectLambda7Java(
  flags: ConnectFlags = ConnectFlags.DEFAULT,
  p0Type: Class<P0>,
  p1Type: Class<P1>,
  p2Type: Class<P2>,
  p3Type: Class<P3>,
  p4Type: Class<P4>,
  p5Type: Class<P5>,
  p6Type: Class<P6>,
  action: JvmAction7<P0, P1, P2, P3, P4, P5, P6>,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
    this,
    LambdaCallable7._createJava(p0Type, p1Type, p2Type, p3Type, p4Type, p5Type, p6Type, action)
  )
  connector.connect(flags)
  return connector
}

@JvmSynthetic
public fun <T : Object, P0, P1, P2, P3, P4, P5, P6>
    Signal7<P0, P1, P2, P3, P4, P5, P6>.connectMethod(
  target: T,
  method: T.(
    p0: P0,
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
  ) -> Unit,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      MethodCallable(target, (method as KCallable<*>).name.toGodotName())
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectMethod7")
public fun <T : Object, R, P0, P1, P2, P3, P4, P5, P6>
    Signal7<P0, P1, P2, P3, P4, P5, P6>._connectMethod7Java(
  target: T,
  method: MethodStringName7<T, R, P0, P1, P2, P3, P4, P5, P6>,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this,
      MethodCallable7._createJava(target, method)
  )
  connector.connect(flags)
  return connector
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6> Signal7<P0, P1, P2, P3, P4, P5, P6>.promise(noinline method: (
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
  p5: P5,
  p6: P6,
) -> Unit, noinline cancel: () -> Unit): Unit {
  LambdaContainer7<Unit, P0, P1, P2, P3, P4, P5, P6>(NIL, arrayOf(getVariantConverter(P0::class)!!, getVariantConverter(P1::class)!!, getVariantConverter(P2::class)!!, getVariantConverter(P3::class)!!, getVariantConverter(P4::class)!!, getVariantConverter(P5::class)!!, getVariantConverter(P6::class)!!), method).setAsCancellable(this, cancel)
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6, reified P7> Signal8<P0, P1, P2, P3, P4, P5, P6, P7>.connectLambda(flags: ConnectFlags =
    ConnectFlags.DEFAULT, noinline method: (
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
  p5: P5,
  p6: P6,
  p7: P7,
) -> Unit): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      method.asCallable()
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectLambda8")
public fun <P0, P1, P2, P3, P4, P5, P6, P7>
    Signal8<P0, P1, P2, P3, P4, P5, P6, P7>._connectLambda8Java(
  flags: ConnectFlags = ConnectFlags.DEFAULT,
  p0Type: Class<P0>,
  p1Type: Class<P1>,
  p2Type: Class<P2>,
  p3Type: Class<P3>,
  p4Type: Class<P4>,
  p5Type: Class<P5>,
  p6Type: Class<P6>,
  p7Type: Class<P7>,
  action: JvmAction8<P0, P1, P2, P3, P4, P5, P6, P7>,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
    this,
    LambdaCallable8._createJava(p0Type, p1Type, p2Type, p3Type, p4Type, p5Type, p6Type, p7Type, action)
  )
  connector.connect(flags)
  return connector
}

@JvmSynthetic
public fun <T : Object, P0, P1, P2, P3, P4, P5, P6, P7>
    Signal8<P0, P1, P2, P3, P4, P5, P6, P7>.connectMethod(
  target: T,
  method: T.(
    p0: P0,
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
  ) -> Unit,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      MethodCallable(target, (method as KCallable<*>).name.toGodotName())
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectMethod8")
public fun <T : Object, R, P0, P1, P2, P3, P4, P5, P6, P7>
    Signal8<P0, P1, P2, P3, P4, P5, P6, P7>._connectMethod8Java(
  target: T,
  method: MethodStringName8<T, R, P0, P1, P2, P3, P4, P5, P6, P7>,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this,
      MethodCallable8._createJava(target, method)
  )
  connector.connect(flags)
  return connector
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6, reified P7> Signal8<P0, P1, P2, P3, P4, P5, P6, P7>.promise(noinline method: (
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
  p5: P5,
  p6: P6,
  p7: P7,
) -> Unit, noinline cancel: () -> Unit): Unit {
  LambdaContainer8<Unit, P0, P1, P2, P3, P4, P5, P6, P7>(NIL, arrayOf(getVariantConverter(P0::class)!!, getVariantConverter(P1::class)!!, getVariantConverter(P2::class)!!, getVariantConverter(P3::class)!!, getVariantConverter(P4::class)!!, getVariantConverter(P5::class)!!, getVariantConverter(P6::class)!!, getVariantConverter(P7::class)!!), method).setAsCancellable(this, cancel)
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6, reified P7, reified P8>
    Signal9<P0, P1, P2, P3, P4, P5, P6, P7, P8>.connectLambda(flags: ConnectFlags =
    ConnectFlags.DEFAULT, noinline method: (
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
  p5: P5,
  p6: P6,
  p7: P7,
  p8: P8,
) -> Unit): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      method.asCallable()
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectLambda9")
public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8>
    Signal9<P0, P1, P2, P3, P4, P5, P6, P7, P8>._connectLambda9Java(
  flags: ConnectFlags = ConnectFlags.DEFAULT,
  p0Type: Class<P0>,
  p1Type: Class<P1>,
  p2Type: Class<P2>,
  p3Type: Class<P3>,
  p4Type: Class<P4>,
  p5Type: Class<P5>,
  p6Type: Class<P6>,
  p7Type: Class<P7>,
  p8Type: Class<P8>,
  action: JvmAction9<P0, P1, P2, P3, P4, P5, P6, P7, P8>,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
    this,
    LambdaCallable9._createJava(p0Type, p1Type, p2Type, p3Type, p4Type, p5Type, p6Type, p7Type, p8Type, action)
  )
  connector.connect(flags)
  return connector
}

@JvmSynthetic
public fun <T : Object, P0, P1, P2, P3, P4, P5, P6, P7, P8>
    Signal9<P0, P1, P2, P3, P4, P5, P6, P7, P8>.connectMethod(
  target: T,
  method: T.(
    p0: P0,
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
  ) -> Unit,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      MethodCallable(target, (method as KCallable<*>).name.toGodotName())
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectMethod9")
public fun <T : Object, R, P0, P1, P2, P3, P4, P5, P6, P7, P8>
    Signal9<P0, P1, P2, P3, P4, P5, P6, P7, P8>._connectMethod9Java(
  target: T,
  method: MethodStringName9<T, R, P0, P1, P2, P3, P4, P5, P6, P7, P8>,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this,
      MethodCallable9._createJava(target, method)
  )
  connector.connect(flags)
  return connector
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6, reified P7, reified P8> Signal9<P0, P1, P2, P3, P4, P5, P6, P7, P8>.promise(noinline
    method: (
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
  p5: P5,
  p6: P6,
  p7: P7,
  p8: P8,
) -> Unit, noinline cancel: () -> Unit): Unit {
  LambdaContainer9<Unit, P0, P1, P2, P3, P4, P5, P6, P7, P8>(NIL, arrayOf(getVariantConverter(P0::class)!!, getVariantConverter(P1::class)!!, getVariantConverter(P2::class)!!, getVariantConverter(P3::class)!!, getVariantConverter(P4::class)!!, getVariantConverter(P5::class)!!, getVariantConverter(P6::class)!!, getVariantConverter(P7::class)!!, getVariantConverter(P8::class)!!), method).setAsCancellable(this, cancel)
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6, reified P7, reified P8, reified P9>
    Signal10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>.connectLambda(flags: ConnectFlags =
    ConnectFlags.DEFAULT, noinline method: (
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
) -> Unit): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      method.asCallable()
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectLambda10")
public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>
    Signal10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>._connectLambda10Java(
  flags: ConnectFlags = ConnectFlags.DEFAULT,
  p0Type: Class<P0>,
  p1Type: Class<P1>,
  p2Type: Class<P2>,
  p3Type: Class<P3>,
  p4Type: Class<P4>,
  p5Type: Class<P5>,
  p6Type: Class<P6>,
  p7Type: Class<P7>,
  p8Type: Class<P8>,
  p9Type: Class<P9>,
  action: JvmAction10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
    this,
    LambdaCallable10._createJava(p0Type, p1Type, p2Type, p3Type, p4Type, p5Type, p6Type, p7Type, p8Type, p9Type, action)
  )
  connector.connect(flags)
  return connector
}

@JvmSynthetic
public fun <T : Object, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>
    Signal10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>.connectMethod(
  target: T,
  method: T.(
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
  ) -> Unit,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      MethodCallable(target, (method as KCallable<*>).name.toGodotName())
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectMethod10")
public fun <T : Object, R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>
    Signal10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>._connectMethod10Java(
  target: T,
  method: MethodStringName10<T, R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this,
      MethodCallable10._createJava(target, method)
  )
  connector.connect(flags)
  return connector
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6, reified P7, reified P8, reified P9>
    Signal10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>.promise(noinline method: (
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
) -> Unit, noinline cancel: () -> Unit): Unit {
  LambdaContainer10<Unit, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(NIL, arrayOf(getVariantConverter(P0::class)!!, getVariantConverter(P1::class)!!, getVariantConverter(P2::class)!!, getVariantConverter(P3::class)!!, getVariantConverter(P4::class)!!, getVariantConverter(P5::class)!!, getVariantConverter(P6::class)!!, getVariantConverter(P7::class)!!, getVariantConverter(P8::class)!!, getVariantConverter(P9::class)!!), method).setAsCancellable(this, cancel)
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6, reified P7, reified P8, reified P9, reified P10>
    Signal11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>.connectLambda(flags: ConnectFlags =
    ConnectFlags.DEFAULT, noinline method: (
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
) -> Unit): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      method.asCallable()
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectLambda11")
public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>
    Signal11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>._connectLambda11Java(
  flags: ConnectFlags = ConnectFlags.DEFAULT,
  p0Type: Class<P0>,
  p1Type: Class<P1>,
  p2Type: Class<P2>,
  p3Type: Class<P3>,
  p4Type: Class<P4>,
  p5Type: Class<P5>,
  p6Type: Class<P6>,
  p7Type: Class<P7>,
  p8Type: Class<P8>,
  p9Type: Class<P9>,
  p10Type: Class<P10>,
  action: JvmAction11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
    this,
    LambdaCallable11._createJava(p0Type, p1Type, p2Type, p3Type, p4Type, p5Type, p6Type, p7Type, p8Type, p9Type, p10Type, action)
  )
  connector.connect(flags)
  return connector
}

@JvmSynthetic
public fun <T : Object, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>
    Signal11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>.connectMethod(
  target: T,
  method: T.(
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
  ) -> Unit,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      MethodCallable(target, (method as KCallable<*>).name.toGodotName())
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectMethod11")
public fun <T : Object, R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>
    Signal11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>._connectMethod11Java(
  target: T,
  method: MethodStringName11<T, R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this,
      MethodCallable11._createJava(target, method)
  )
  connector.connect(flags)
  return connector
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6, reified P7, reified P8, reified P9, reified P10>
    Signal11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>.promise(noinline method: (
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
) -> Unit, noinline cancel: () -> Unit): Unit {
  LambdaContainer11<Unit, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(NIL, arrayOf(getVariantConverter(P0::class)!!, getVariantConverter(P1::class)!!, getVariantConverter(P2::class)!!, getVariantConverter(P3::class)!!, getVariantConverter(P4::class)!!, getVariantConverter(P5::class)!!, getVariantConverter(P6::class)!!, getVariantConverter(P7::class)!!, getVariantConverter(P8::class)!!, getVariantConverter(P9::class)!!, getVariantConverter(P10::class)!!), method).setAsCancellable(this, cancel)
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6, reified P7, reified P8, reified P9, reified P10, reified P11>
    Signal12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>.connectLambda(flags: ConnectFlags =
    ConnectFlags.DEFAULT, noinline method: (
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
) -> Unit): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      method.asCallable()
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectLambda12")
public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>
    Signal12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>._connectLambda12Java(
  flags: ConnectFlags = ConnectFlags.DEFAULT,
  p0Type: Class<P0>,
  p1Type: Class<P1>,
  p2Type: Class<P2>,
  p3Type: Class<P3>,
  p4Type: Class<P4>,
  p5Type: Class<P5>,
  p6Type: Class<P6>,
  p7Type: Class<P7>,
  p8Type: Class<P8>,
  p9Type: Class<P9>,
  p10Type: Class<P10>,
  p11Type: Class<P11>,
  action: JvmAction12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
    this,
    LambdaCallable12._createJava(p0Type, p1Type, p2Type, p3Type, p4Type, p5Type, p6Type, p7Type, p8Type, p9Type, p10Type, p11Type, action)
  )
  connector.connect(flags)
  return connector
}

@JvmSynthetic
public fun <T : Object, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>
    Signal12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>.connectMethod(
  target: T,
  method: T.(
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
  ) -> Unit,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      MethodCallable(target, (method as KCallable<*>).name.toGodotName())
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectMethod12")
public fun <T : Object, R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>
    Signal12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>._connectMethod12Java(
  target: T,
  method: MethodStringName12<T, R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this,
      MethodCallable12._createJava(target, method)
  )
  connector.connect(flags)
  return connector
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6, reified P7, reified P8, reified P9, reified P10, reified P11>
    Signal12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>.promise(noinline method: (
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
) -> Unit, noinline cancel: () -> Unit): Unit {
  LambdaContainer12<Unit, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(NIL, arrayOf(getVariantConverter(P0::class)!!, getVariantConverter(P1::class)!!, getVariantConverter(P2::class)!!, getVariantConverter(P3::class)!!, getVariantConverter(P4::class)!!, getVariantConverter(P5::class)!!, getVariantConverter(P6::class)!!, getVariantConverter(P7::class)!!, getVariantConverter(P8::class)!!, getVariantConverter(P9::class)!!, getVariantConverter(P10::class)!!, getVariantConverter(P11::class)!!), method).setAsCancellable(this, cancel)
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12>
    Signal13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>.connectLambda(flags: ConnectFlags
    = ConnectFlags.DEFAULT, noinline method: (
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
) -> Unit): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      method.asCallable()
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectLambda13")
public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>
    Signal13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>._connectLambda13Java(
  flags: ConnectFlags = ConnectFlags.DEFAULT,
  p0Type: Class<P0>,
  p1Type: Class<P1>,
  p2Type: Class<P2>,
  p3Type: Class<P3>,
  p4Type: Class<P4>,
  p5Type: Class<P5>,
  p6Type: Class<P6>,
  p7Type: Class<P7>,
  p8Type: Class<P8>,
  p9Type: Class<P9>,
  p10Type: Class<P10>,
  p11Type: Class<P11>,
  p12Type: Class<P12>,
  action: JvmAction13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
    this,
    LambdaCallable13._createJava(p0Type, p1Type, p2Type, p3Type, p4Type, p5Type, p6Type, p7Type, p8Type, p9Type, p10Type, p11Type, p12Type, action)
  )
  connector.connect(flags)
  return connector
}

@JvmSynthetic
public fun <T : Object, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>
    Signal13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>.connectMethod(
  target: T,
  method: T.(
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
  ) -> Unit,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      MethodCallable(target, (method as KCallable<*>).name.toGodotName())
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectMethod13")
public fun <T : Object, R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>
    Signal13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>._connectMethod13Java(
  target: T,
  method: MethodStringName13<T, R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this,
      MethodCallable13._createJava(target, method)
  )
  connector.connect(flags)
  return connector
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12>
    Signal13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>.promise(noinline method: (
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
) -> Unit, noinline cancel: () -> Unit): Unit {
  LambdaContainer13<Unit, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>(NIL, arrayOf(getVariantConverter(P0::class)!!, getVariantConverter(P1::class)!!, getVariantConverter(P2::class)!!, getVariantConverter(P3::class)!!, getVariantConverter(P4::class)!!, getVariantConverter(P5::class)!!, getVariantConverter(P6::class)!!, getVariantConverter(P7::class)!!, getVariantConverter(P8::class)!!, getVariantConverter(P9::class)!!, getVariantConverter(P10::class)!!, getVariantConverter(P11::class)!!, getVariantConverter(P12::class)!!), method).setAsCancellable(this, cancel)
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12, reified P13>
    Signal14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>.connectLambda(flags: ConnectFlags
    = ConnectFlags.DEFAULT, noinline method: (
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
) -> Unit): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      method.asCallable()
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectLambda14")
public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>
    Signal14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>._connectLambda14Java(
  flags: ConnectFlags = ConnectFlags.DEFAULT,
  p0Type: Class<P0>,
  p1Type: Class<P1>,
  p2Type: Class<P2>,
  p3Type: Class<P3>,
  p4Type: Class<P4>,
  p5Type: Class<P5>,
  p6Type: Class<P6>,
  p7Type: Class<P7>,
  p8Type: Class<P8>,
  p9Type: Class<P9>,
  p10Type: Class<P10>,
  p11Type: Class<P11>,
  p12Type: Class<P12>,
  p13Type: Class<P13>,
  action: JvmAction14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
    this,
    LambdaCallable14._createJava(p0Type, p1Type, p2Type, p3Type, p4Type, p5Type, p6Type, p7Type, p8Type, p9Type, p10Type, p11Type, p12Type, p13Type, action)
  )
  connector.connect(flags)
  return connector
}

@JvmSynthetic
public fun <T : Object, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>
    Signal14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>.connectMethod(
  target: T,
  method: T.(
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
  ) -> Unit,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      MethodCallable(target, (method as KCallable<*>).name.toGodotName())
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectMethod14")
public fun <T : Object, R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>
    Signal14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>._connectMethod14Java(
  target: T,
  method: MethodStringName14<T, R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this,
      MethodCallable14._createJava(target, method)
  )
  connector.connect(flags)
  return connector
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12, reified P13>
    Signal14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>.promise(noinline method: (
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
) -> Unit, noinline cancel: () -> Unit): Unit {
  LambdaContainer14<Unit, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>(NIL, arrayOf(getVariantConverter(P0::class)!!, getVariantConverter(P1::class)!!, getVariantConverter(P2::class)!!, getVariantConverter(P3::class)!!, getVariantConverter(P4::class)!!, getVariantConverter(P5::class)!!, getVariantConverter(P6::class)!!, getVariantConverter(P7::class)!!, getVariantConverter(P8::class)!!, getVariantConverter(P9::class)!!, getVariantConverter(P10::class)!!, getVariantConverter(P11::class)!!, getVariantConverter(P12::class)!!, getVariantConverter(P13::class)!!), method).setAsCancellable(this, cancel)
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12, reified P13,
    reified P14>
    Signal15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>.connectLambda(flags: ConnectFlags
    = ConnectFlags.DEFAULT, noinline method: (
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
) -> Unit): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      method.asCallable()
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectLambda15")
public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>
    Signal15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>._connectLambda15Java(
  flags: ConnectFlags = ConnectFlags.DEFAULT,
  p0Type: Class<P0>,
  p1Type: Class<P1>,
  p2Type: Class<P2>,
  p3Type: Class<P3>,
  p4Type: Class<P4>,
  p5Type: Class<P5>,
  p6Type: Class<P6>,
  p7Type: Class<P7>,
  p8Type: Class<P8>,
  p9Type: Class<P9>,
  p10Type: Class<P10>,
  p11Type: Class<P11>,
  p12Type: Class<P12>,
  p13Type: Class<P13>,
  p14Type: Class<P14>,
  action: JvmAction15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
    this,
    LambdaCallable15._createJava(p0Type, p1Type, p2Type, p3Type, p4Type, p5Type, p6Type, p7Type, p8Type, p9Type, p10Type, p11Type, p12Type, p13Type, p14Type, action)
  )
  connector.connect(flags)
  return connector
}

@JvmSynthetic
public fun <T : Object, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>
    Signal15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>.connectMethod(
  target: T,
  method: T.(
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
  ) -> Unit,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      MethodCallable(target, (method as KCallable<*>).name.toGodotName())
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectMethod15")
public fun <T : Object, R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>
    Signal15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>._connectMethod15Java(
  target: T,
  method: MethodStringName15<T, R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this,
      MethodCallable15._createJava(target, method)
  )
  connector.connect(flags)
  return connector
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12, reified P13,
    reified P14>
    Signal15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>.promise(noinline
    method: (
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
) -> Unit, noinline cancel: () -> Unit): Unit {
  LambdaContainer15<Unit, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>(NIL, arrayOf(getVariantConverter(P0::class)!!, getVariantConverter(P1::class)!!, getVariantConverter(P2::class)!!, getVariantConverter(P3::class)!!, getVariantConverter(P4::class)!!, getVariantConverter(P5::class)!!, getVariantConverter(P6::class)!!, getVariantConverter(P7::class)!!, getVariantConverter(P8::class)!!, getVariantConverter(P9::class)!!, getVariantConverter(P10::class)!!, getVariantConverter(P11::class)!!, getVariantConverter(P12::class)!!, getVariantConverter(P13::class)!!, getVariantConverter(P14::class)!!), method).setAsCancellable(this, cancel)
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12, reified P13,
    reified P14, reified P15>
    Signal16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>.connectLambda(flags: ConnectFlags
    = ConnectFlags.DEFAULT, noinline method: (
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
) -> Unit): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      method.asCallable()
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectLambda16")
public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>
    Signal16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>._connectLambda16Java(
  flags: ConnectFlags = ConnectFlags.DEFAULT,
  p0Type: Class<P0>,
  p1Type: Class<P1>,
  p2Type: Class<P2>,
  p3Type: Class<P3>,
  p4Type: Class<P4>,
  p5Type: Class<P5>,
  p6Type: Class<P6>,
  p7Type: Class<P7>,
  p8Type: Class<P8>,
  p9Type: Class<P9>,
  p10Type: Class<P10>,
  p11Type: Class<P11>,
  p12Type: Class<P12>,
  p13Type: Class<P13>,
  p14Type: Class<P14>,
  p15Type: Class<P15>,
  action: JvmAction16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
    this,
    LambdaCallable16._createJava(p0Type, p1Type, p2Type, p3Type, p4Type, p5Type, p6Type, p7Type, p8Type, p9Type, p10Type, p11Type, p12Type, p13Type, p14Type, p15Type, action)
  )
  connector.connect(flags)
  return connector
}

@JvmSynthetic
public fun <T : Object, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>
    Signal16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>.connectMethod(
  target: T,
  method: T.(
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
  ) -> Unit,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this, 
      MethodCallable(target, (method as KCallable<*>).name.toGodotName())
  )
  connector.connect(flags)
  return connector
}

@JvmOverloads
@JvmName("connectMethod16")
public fun <T : Object, R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>
    Signal16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>._connectMethod16Java(
  target: T,
  method: MethodStringName16<T, R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>,
  flags: ConnectFlags = ConnectFlags.DEFAULT,
): SignalConnector {
  val connector = SignalConnector.createUnsafe(
      this,
      MethodCallable16._createJava(target, method)
  )
  connector.connect(flags)
  return connector
}

public inline fun <reified P0, reified P1, reified P2, reified P3, reified P4, reified P5, reified
    P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12, reified P13,
    reified P14, reified P15>
    Signal16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>.promise(noinline
    method: (
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
) -> Unit, noinline cancel: () -> Unit): Unit {
  LambdaContainer16<Unit, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>(NIL, arrayOf(getVariantConverter(P0::class)!!, getVariantConverter(P1::class)!!, getVariantConverter(P2::class)!!, getVariantConverter(P3::class)!!, getVariantConverter(P4::class)!!, getVariantConverter(P5::class)!!, getVariantConverter(P6::class)!!, getVariantConverter(P7::class)!!, getVariantConverter(P8::class)!!, getVariantConverter(P9::class)!!, getVariantConverter(P10::class)!!, getVariantConverter(P11::class)!!, getVariantConverter(P12::class)!!, getVariantConverter(P13::class)!!, getVariantConverter(P14::class)!!, getVariantConverter(P15::class)!!), method).setAsCancellable(this, cancel)
}
