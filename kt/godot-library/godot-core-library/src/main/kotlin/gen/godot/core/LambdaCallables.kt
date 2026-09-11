@file:Suppress(
  "PackageDirectoryMismatch", "UNCHECKED_CAST",
  "unused",
  "RedundantVisibilityModifier",
)

package godot.core

import godot.common.interop.VariantConverter
import java.lang.Class
import java.lang.Void
import kotlin.Any
import kotlin.Array
import kotlin.PublishedApi
import kotlin.Suppress
import kotlin.jvm.JvmName
import kotlin.jvm.JvmStatic

public class LambdaCallable0<R> @PublishedApi internal constructor(
  container: LambdaContainer<R>,
  boundArgs: Array<Any?> = emptyArray(),
) : LambdaCallable<R>(container, boundArgs), Callable0<R> {
  public companion object {
    @JvmStatic
    @JvmName("create")
    public fun <R> _createJava(returnType: Class<R>, function: JvmFunction0<R>): LambdaCallable0<R>
        = LambdaCallable0<R>(LambdaContainer0<R>(getVariantConverter(returnType)!!, arrayOf(),
        function))

    @JvmStatic
    @JvmName("create")
    public fun _createJava(action: JvmAction0): LambdaCallable0<Void?> =
        LambdaCallable0<Void?>(LambdaContainer0<Void?>(getVariantConverter(Void::class.java)!!,
        arrayOf(), object : JvmFunction0<Void?> {
      override fun invoke(): Void? {
        action.invoke()
        return null
      }
    }
    ))

    @JvmStatic
    @JvmName("create")
    public fun <R> _createJava(returnConverter: VariantConverter, function: JvmFunction0<R>):
        LambdaCallable0<R> = LambdaCallable0<R>(LambdaContainer0<R>(returnConverter, arrayOf(),
        function))
  }
}

public inline fun <reified R> lambdaCallable0(noinline function: () -> R) =
    LambdaCallable0<R>(LambdaContainer0<R>(getVariantConverter<R>()!!, arrayOf(), function))

public fun <R> lambdaCallable0(returnConverter: VariantConverter, function: () -> R) =
    LambdaCallable0<R>(LambdaContainer0<R>(returnConverter, arrayOf(), function))

public inline fun <reified R> (() -> R).asCallable() = lambdaCallable0(this)

public class LambdaCallable1<R, P0> @PublishedApi internal constructor(
  container: LambdaContainer<R>,
  boundArgs: Array<Any?> = emptyArray(),
) : LambdaCallable<R>(container, boundArgs), Callable1<R, P0> {
  public override fun bind(p0: P0) = LambdaCallable0<R>(container, arrayOf<Any?>(p0, *boundArgs))

  public companion object {
    @JvmStatic
    @JvmName("create")
    public fun <R, P0> _createJava(
      returnType: Class<R>,
      p0Type: Class<P0>,
      function: JvmFunction1<R, P0>,
    ): LambdaCallable1<R, P0> =
        LambdaCallable1<R, P0>(LambdaContainer1<R, P0>(getVariantConverter(returnType)!!,
        arrayOf(getVariantConverter(p0Type)!!), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0> _createJava(p0Type: Class<P0>, action: JvmAction1<P0>):
        LambdaCallable1<Void?, P0> =
        LambdaCallable1<Void?, P0>(LambdaContainer1<Void?, P0>(getVariantConverter(Void::class.java)!!,
        arrayOf(getVariantConverter(p0Type)!!), object : JvmFunction1<Void?, P0> {
      override fun invoke(p0: P0): Void? {
        action.invoke(p0)
        return null
      }
    }
    ))

    @JvmStatic
    @JvmName("create")
    public fun <R, P0> _createJava(
      returnConverter: VariantConverter,
      p0Converter: VariantConverter,
      function: JvmFunction1<R, P0>,
    ): LambdaCallable1<R, P0> = LambdaCallable1<R, P0>(LambdaContainer1<R, P0>(returnConverter,
        arrayOf(p0Converter), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0> _createJava(p0Converter: VariantConverter, action: JvmAction1<P0>):
        LambdaCallable1<Void?, P0> =
        LambdaCallable1<Void?, P0>(LambdaContainer1<Void?, P0>(getVariantConverter(Void::class.java)!!,
        arrayOf(p0Converter), object : JvmFunction1<Void?, P0> {
      override fun invoke(p0: P0): Void? {
        action.invoke(p0)
        return null
      }
    }
    ))
  }
}

public inline fun <reified R, reified P0> lambdaCallable1(noinline function: (p0: P0) -> R) =
    LambdaCallable1<R, P0>(LambdaContainer1<R, P0>(getVariantConverter<R>()!!, arrayOf(getVariantConverter<P0>()!!), function))

public fun <R, P0> lambdaCallable1(
  returnConverter: VariantConverter,
  p0Converter: VariantConverter,
  function: (p0: P0) -> R,
) = LambdaCallable1<R, P0>(LambdaContainer1<R, P0>(returnConverter, arrayOf(p0Converter), function))

public inline fun <reified R, reified P0> ((p0: P0) -> R).asCallable() = lambdaCallable1(this)

public class LambdaCallable2<R, P0, P1> @PublishedApi internal constructor(
  container: LambdaContainer<R>,
  boundArgs: Array<Any?> = emptyArray(),
) : LambdaCallable<R>(container, boundArgs), Callable2<R, P0, P1> {
  public override fun bind(p1: P1) = LambdaCallable1<R, P0>(container, arrayOf<Any?>(p1,
      *boundArgs))

  public override fun bind(p0: P0, p1: P1) = LambdaCallable0<R>(container, arrayOf<Any?>(p0, p1,
      *boundArgs))

  public companion object {
    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1> _createJava(
      returnType: Class<R>,
      p0Type: Class<P0>,
      p1Type: Class<P1>,
      function: JvmFunction2<R, P0, P1>,
    ): LambdaCallable2<R, P0, P1> =
        LambdaCallable2<R, P0, P1>(LambdaContainer2<R, P0, P1>(getVariantConverter(returnType)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1> _createJava(
      p0Type: Class<P0>,
      p1Type: Class<P1>,
      action: JvmAction2<P0, P1>,
    ): LambdaCallable2<Void?, P0, P1> =
        LambdaCallable2<Void?, P0, P1>(LambdaContainer2<Void?, P0, P1>(getVariantConverter(Void::class.java)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!), object :
        JvmFunction2<Void?, P0, P1> {
      override fun invoke(p0: P0, p1: P1): Void? {
        action.invoke(p0, p1)
        return null
      }
    }
    ))

    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1> _createJava(
      returnConverter: VariantConverter,
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      function: JvmFunction2<R, P0, P1>,
    ): LambdaCallable2<R, P0, P1> =
        LambdaCallable2<R, P0, P1>(LambdaContainer2<R, P0, P1>(returnConverter, arrayOf(p0Converter,
        p1Converter), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1> _createJava(
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      action: JvmAction2<P0, P1>,
    ): LambdaCallable2<Void?, P0, P1> =
        LambdaCallable2<Void?, P0, P1>(LambdaContainer2<Void?, P0, P1>(getVariantConverter(Void::class.java)!!,
        arrayOf(p0Converter, p1Converter), object : JvmFunction2<Void?, P0, P1> {
      override fun invoke(p0: P0, p1: P1): Void? {
        action.invoke(p0, p1)
        return null
      }
    }
    ))
  }
}

public inline fun <reified R, reified P0, reified P1> lambdaCallable2(noinline function: (p0: P0,
    p1: P1) -> R) =
    LambdaCallable2<R, P0, P1>(LambdaContainer2<R, P0, P1>(getVariantConverter<R>()!!, arrayOf(getVariantConverter<P0>()!!, getVariantConverter<P1>()!!), function))

public fun <R, P0, P1> lambdaCallable2(
  returnConverter: VariantConverter,
  p0Converter: VariantConverter,
  p1Converter: VariantConverter,
  function: (p0: P0, p1: P1) -> R,
) = LambdaCallable2<R, P0, P1>(LambdaContainer2<R, P0, P1>(returnConverter, arrayOf(p0Converter,
    p1Converter), function))

public inline fun <reified R, reified P0, reified P1> ((p0: P0, p1: P1) -> R).asCallable() =
    lambdaCallable2(this)

public class LambdaCallable3<R, P0, P1, P2> @PublishedApi internal constructor(
  container: LambdaContainer<R>,
  boundArgs: Array<Any?> = emptyArray(),
) : LambdaCallable<R>(container, boundArgs), Callable3<R, P0, P1, P2> {
  public override fun bind(p2: P2) = LambdaCallable2<R, P0, P1>(container, arrayOf<Any?>(p2,
      *boundArgs))

  public override fun bind(p1: P1, p2: P2) = LambdaCallable1<R, P0>(container, arrayOf<Any?>(p1, p2,
      *boundArgs))

  public override fun bind(
    p0: P0,
    p1: P1,
    p2: P2,
  ) = LambdaCallable0<R>(container, arrayOf<Any?>(p0, p1, p2, *boundArgs))

  public companion object {
    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2> _createJava(
      returnType: Class<R>,
      p0Type: Class<P0>,
      p1Type: Class<P1>,
      p2Type: Class<P2>,
      function: JvmFunction3<R, P0, P1, P2>,
    ): LambdaCallable3<R, P0, P1, P2> =
        LambdaCallable3<R, P0, P1, P2>(LambdaContainer3<R, P0, P1, P2>(getVariantConverter(returnType)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2> _createJava(
      p0Type: Class<P0>,
      p1Type: Class<P1>,
      p2Type: Class<P2>,
      action: JvmAction3<P0, P1, P2>,
    ): LambdaCallable3<Void?, P0, P1, P2> =
        LambdaCallable3<Void?, P0, P1, P2>(LambdaContainer3<Void?, P0, P1, P2>(getVariantConverter(Void::class.java)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!), object : JvmFunction3<Void?, P0, P1, P2> {
      override fun invoke(p0: P0, p1: P1, p2: P2): Void? {
        action.invoke(p0, p1, p2)
        return null
      }
    }
    ))

    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2> _createJava(
      returnConverter: VariantConverter,
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      function: JvmFunction3<R, P0, P1, P2>,
    ): LambdaCallable3<R, P0, P1, P2> =
        LambdaCallable3<R, P0, P1, P2>(LambdaContainer3<R, P0, P1, P2>(returnConverter,
        arrayOf(p0Converter, p1Converter, p2Converter), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2> _createJava(
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      action: JvmAction3<P0, P1, P2>,
    ): LambdaCallable3<Void?, P0, P1, P2> =
        LambdaCallable3<Void?, P0, P1, P2>(LambdaContainer3<Void?, P0, P1, P2>(getVariantConverter(Void::class.java)!!,
        arrayOf(p0Converter, p1Converter, p2Converter), object : JvmFunction3<Void?, P0, P1, P2> {
      override fun invoke(p0: P0, p1: P1, p2: P2): Void? {
        action.invoke(p0, p1, p2)
        return null
      }
    }
    ))
  }
}

public inline fun <reified R, reified P0, reified P1, reified P2> lambdaCallable3(noinline
    function: (
  p0: P0,
  p1: P1,
  p2: P2,
) -> R) =
    LambdaCallable3<R, P0, P1, P2>(LambdaContainer3<R, P0, P1, P2>(getVariantConverter<R>()!!, arrayOf(getVariantConverter<P0>()!!, getVariantConverter<P1>()!!, getVariantConverter<P2>()!!), function))

public fun <R, P0, P1, P2> lambdaCallable3(
  returnConverter: VariantConverter,
  p0Converter: VariantConverter,
  p1Converter: VariantConverter,
  p2Converter: VariantConverter,
  function: (
    p0: P0,
    p1: P1,
    p2: P2,
  ) -> R,
) =
    LambdaCallable3<R, P0, P1, P2>(LambdaContainer3<R, P0, P1, P2>(returnConverter, arrayOf(p0Converter,
    p1Converter, p2Converter), function))

public inline fun <reified R, reified P0, reified P1, reified P2> ((
  p0: P0,
  p1: P1,
  p2: P2,
) -> R).asCallable() = lambdaCallable3(this)

public class LambdaCallable4<R, P0, P1, P2, P3> @PublishedApi internal constructor(
  container: LambdaContainer<R>,
  boundArgs: Array<Any?> = emptyArray(),
) : LambdaCallable<R>(container, boundArgs), Callable4<R, P0, P1, P2, P3> {
  public override fun bind(p3: P3) = LambdaCallable3<R, P0, P1, P2>(container, arrayOf<Any?>(p3,
      *boundArgs))

  public override fun bind(p2: P2, p3: P3) = LambdaCallable2<R, P0, P1>(container,
      arrayOf<Any?>(p2, p3, *boundArgs))

  public override fun bind(
    p1: P1,
    p2: P2,
    p3: P3,
  ) = LambdaCallable1<R, P0>(container, arrayOf<Any?>(p1, p2, p3, *boundArgs))

  public override fun bind(
    p0: P0,
    p1: P1,
    p2: P2,
    p3: P3,
  ) = LambdaCallable0<R>(container, arrayOf<Any?>(p0, p1, p2, p3, *boundArgs))

  public companion object {
    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3> _createJava(
      returnType: Class<R>,
      p0Type: Class<P0>,
      p1Type: Class<P1>,
      p2Type: Class<P2>,
      p3Type: Class<P3>,
      function: JvmFunction4<R, P0, P1, P2, P3>,
    ): LambdaCallable4<R, P0, P1, P2, P3> =
        LambdaCallable4<R, P0, P1, P2, P3>(LambdaContainer4<R, P0, P1, P2, P3>(getVariantConverter(returnType)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3> _createJava(
      p0Type: Class<P0>,
      p1Type: Class<P1>,
      p2Type: Class<P2>,
      p3Type: Class<P3>,
      action: JvmAction4<P0, P1, P2, P3>,
    ): LambdaCallable4<Void?, P0, P1, P2, P3> =
        LambdaCallable4<Void?, P0, P1, P2, P3>(LambdaContainer4<Void?, P0, P1, P2, P3>(getVariantConverter(Void::class.java)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!), object :
        JvmFunction4<Void?, P0, P1, P2, P3> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3): Void? {
        action.invoke(p0, p1, p2, p3)
        return null
      }
    }
    ))

    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3> _createJava(
      returnConverter: VariantConverter,
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      function: JvmFunction4<R, P0, P1, P2, P3>,
    ): LambdaCallable4<R, P0, P1, P2, P3> =
        LambdaCallable4<R, P0, P1, P2, P3>(LambdaContainer4<R, P0, P1, P2, P3>(returnConverter,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3> _createJava(
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      action: JvmAction4<P0, P1, P2, P3>,
    ): LambdaCallable4<Void?, P0, P1, P2, P3> =
        LambdaCallable4<Void?, P0, P1, P2, P3>(LambdaContainer4<Void?, P0, P1, P2, P3>(getVariantConverter(Void::class.java)!!,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter), object :
        JvmFunction4<Void?, P0, P1, P2, P3> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3): Void? {
        action.invoke(p0, p1, p2, p3)
        return null
      }
    }
    ))
  }
}

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3>
    lambdaCallable4(noinline function: (
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
) -> R) =
    LambdaCallable4<R, P0, P1, P2, P3>(LambdaContainer4<R, P0, P1, P2, P3>(getVariantConverter<R>()!!, arrayOf(getVariantConverter<P0>()!!, getVariantConverter<P1>()!!, getVariantConverter<P2>()!!, getVariantConverter<P3>()!!), function))

public fun <R, P0, P1, P2, P3> lambdaCallable4(
  returnConverter: VariantConverter,
  p0Converter: VariantConverter,
  p1Converter: VariantConverter,
  p2Converter: VariantConverter,
  p3Converter: VariantConverter,
  function: (
    p0: P0,
    p1: P1,
    p2: P2,
    p3: P3,
  ) -> R,
) =
    LambdaCallable4<R, P0, P1, P2, P3>(LambdaContainer4<R, P0, P1, P2, P3>(returnConverter, arrayOf(p0Converter,
    p1Converter, p2Converter, p3Converter), function))

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3> ((
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
) -> R).asCallable() = lambdaCallable4(this)

public class LambdaCallable5<R, P0, P1, P2, P3, P4> @PublishedApi internal constructor(
  container: LambdaContainer<R>,
  boundArgs: Array<Any?> = emptyArray(),
) : LambdaCallable<R>(container, boundArgs), Callable5<R, P0, P1, P2, P3, P4> {
  public override fun bind(p4: P4) = LambdaCallable4<R, P0, P1, P2, P3>(container, arrayOf<Any?>(p4,
      *boundArgs))

  public override fun bind(p3: P3, p4: P4) = LambdaCallable3<R, P0, P1, P2>(container,
      arrayOf<Any?>(p3, p4, *boundArgs))

  public override fun bind(
    p2: P2,
    p3: P3,
    p4: P4,
  ) = LambdaCallable2<R, P0, P1>(container, arrayOf<Any?>(p2, p3, p4, *boundArgs))

  public override fun bind(
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
  ) = LambdaCallable1<R, P0>(container, arrayOf<Any?>(p1, p2, p3, p4, *boundArgs))

  public override fun bind(
    p0: P0,
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
  ) = LambdaCallable0<R>(container, arrayOf<Any?>(p0, p1, p2, p3, p4, *boundArgs))

  public companion object {
    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4> _createJava(
      returnType: Class<R>,
      p0Type: Class<P0>,
      p1Type: Class<P1>,
      p2Type: Class<P2>,
      p3Type: Class<P3>,
      p4Type: Class<P4>,
      function: JvmFunction5<R, P0, P1, P2, P3, P4>,
    ): LambdaCallable5<R, P0, P1, P2, P3, P4> =
        LambdaCallable5<R, P0, P1, P2, P3, P4>(LambdaContainer5<R, P0, P1, P2, P3, P4>(getVariantConverter(returnType)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!,
        getVariantConverter(p4Type)!!), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4> _createJava(
      p0Type: Class<P0>,
      p1Type: Class<P1>,
      p2Type: Class<P2>,
      p3Type: Class<P3>,
      p4Type: Class<P4>,
      action: JvmAction5<P0, P1, P2, P3, P4>,
    ): LambdaCallable5<Void?, P0, P1, P2, P3, P4> =
        LambdaCallable5<Void?, P0, P1, P2, P3, P4>(LambdaContainer5<Void?, P0, P1, P2, P3, P4>(getVariantConverter(Void::class.java)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!,
        getVariantConverter(p4Type)!!), object : JvmFunction5<Void?, P0, P1, P2, P3, P4> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4): Void? {
        action.invoke(p0, p1, p2, p3, p4)
        return null
      }
    }
    ))

    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4> _createJava(
      returnConverter: VariantConverter,
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      function: JvmFunction5<R, P0, P1, P2, P3, P4>,
    ): LambdaCallable5<R, P0, P1, P2, P3, P4> =
        LambdaCallable5<R, P0, P1, P2, P3, P4>(LambdaContainer5<R, P0, P1, P2, P3, P4>(returnConverter,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4> _createJava(
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      action: JvmAction5<P0, P1, P2, P3, P4>,
    ): LambdaCallable5<Void?, P0, P1, P2, P3, P4> =
        LambdaCallable5<Void?, P0, P1, P2, P3, P4>(LambdaContainer5<Void?, P0, P1, P2, P3, P4>(getVariantConverter(Void::class.java)!!,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter), object :
        JvmFunction5<Void?, P0, P1, P2, P3, P4> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4): Void? {
        action.invoke(p0, p1, p2, p3, p4)
        return null
      }
    }
    ))
  }
}

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4>
    lambdaCallable5(noinline function: (
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
) -> R) =
    LambdaCallable5<R, P0, P1, P2, P3, P4>(LambdaContainer5<R, P0, P1, P2, P3, P4>(getVariantConverter<R>()!!, arrayOf(getVariantConverter<P0>()!!, getVariantConverter<P1>()!!, getVariantConverter<P2>()!!, getVariantConverter<P3>()!!, getVariantConverter<P4>()!!), function))

public fun <R, P0, P1, P2, P3, P4> lambdaCallable5(
  returnConverter: VariantConverter,
  p0Converter: VariantConverter,
  p1Converter: VariantConverter,
  p2Converter: VariantConverter,
  p3Converter: VariantConverter,
  p4Converter: VariantConverter,
  function: (
    p0: P0,
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
  ) -> R,
) =
    LambdaCallable5<R, P0, P1, P2, P3, P4>(LambdaContainer5<R, P0, P1, P2, P3, P4>(returnConverter, arrayOf(p0Converter,
    p1Converter, p2Converter, p3Converter, p4Converter), function))

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4> ((
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
) -> R).asCallable() = lambdaCallable5(this)

public class LambdaCallable6<R, P0, P1, P2, P3, P4, P5> @PublishedApi internal constructor(
  container: LambdaContainer<R>,
  boundArgs: Array<Any?> = emptyArray(),
) : LambdaCallable<R>(container, boundArgs), Callable6<R, P0, P1, P2, P3, P4, P5> {
  public override fun bind(p5: P5) = LambdaCallable5<R, P0, P1, P2, P3, P4>(container,
      arrayOf<Any?>(p5, *boundArgs))

  public override fun bind(p4: P4, p5: P5) = LambdaCallable4<R, P0, P1, P2, P3>(container,
      arrayOf<Any?>(p4, p5, *boundArgs))

  public override fun bind(
    p3: P3,
    p4: P4,
    p5: P5,
  ) = LambdaCallable3<R, P0, P1, P2>(container, arrayOf<Any?>(p3, p4, p5, *boundArgs))

  public override fun bind(
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
  ) = LambdaCallable2<R, P0, P1>(container, arrayOf<Any?>(p2, p3, p4, p5, *boundArgs))

  public override fun bind(
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
  ) = LambdaCallable1<R, P0>(container, arrayOf<Any?>(p1, p2, p3, p4, p5, *boundArgs))

  public override fun bind(
    p0: P0,
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
  ) = LambdaCallable0<R>(container, arrayOf<Any?>(p0, p1, p2, p3, p4, p5, *boundArgs))

  public companion object {
    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5> _createJava(
      returnType: Class<R>,
      p0Type: Class<P0>,
      p1Type: Class<P1>,
      p2Type: Class<P2>,
      p3Type: Class<P3>,
      p4Type: Class<P4>,
      p5Type: Class<P5>,
      function: JvmFunction6<R, P0, P1, P2, P3, P4, P5>,
    ): LambdaCallable6<R, P0, P1, P2, P3, P4, P5> =
        LambdaCallable6<R, P0, P1, P2, P3, P4, P5>(LambdaContainer6<R, P0, P1, P2, P3, P4, P5>(getVariantConverter(returnType)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5> _createJava(
      p0Type: Class<P0>,
      p1Type: Class<P1>,
      p2Type: Class<P2>,
      p3Type: Class<P3>,
      p4Type: Class<P4>,
      p5Type: Class<P5>,
      action: JvmAction6<P0, P1, P2, P3, P4, P5>,
    ): LambdaCallable6<Void?, P0, P1, P2, P3, P4, P5> =
        LambdaCallable6<Void?, P0, P1, P2, P3, P4, P5>(LambdaContainer6<Void?, P0, P1, P2, P3, P4, P5>(getVariantConverter(Void::class.java)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!), object : JvmFunction6<Void?, P0, P1, P2, P3, P4, P5> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5)
        return null
      }
    }
    ))

    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5> _createJava(
      returnConverter: VariantConverter,
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      function: JvmFunction6<R, P0, P1, P2, P3, P4, P5>,
    ): LambdaCallable6<R, P0, P1, P2, P3, P4, P5> =
        LambdaCallable6<R, P0, P1, P2, P3, P4, P5>(LambdaContainer6<R, P0, P1, P2, P3, P4, P5>(returnConverter,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter),
        function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5> _createJava(
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      action: JvmAction6<P0, P1, P2, P3, P4, P5>,
    ): LambdaCallable6<Void?, P0, P1, P2, P3, P4, P5> =
        LambdaCallable6<Void?, P0, P1, P2, P3, P4, P5>(LambdaContainer6<Void?, P0, P1, P2, P3, P4, P5>(getVariantConverter(Void::class.java)!!,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter),
        object : JvmFunction6<Void?, P0, P1, P2, P3, P4, P5> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5)
        return null
      }
    }
    ))
  }
}

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5> lambdaCallable6(noinline function: (
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
  p5: P5,
) -> R) =
    LambdaCallable6<R, P0, P1, P2, P3, P4, P5>(LambdaContainer6<R, P0, P1, P2, P3, P4, P5>(getVariantConverter<R>()!!, arrayOf(getVariantConverter<P0>()!!, getVariantConverter<P1>()!!, getVariantConverter<P2>()!!, getVariantConverter<P3>()!!, getVariantConverter<P4>()!!, getVariantConverter<P5>()!!), function))

public fun <R, P0, P1, P2, P3, P4, P5> lambdaCallable6(
  returnConverter: VariantConverter,
  p0Converter: VariantConverter,
  p1Converter: VariantConverter,
  p2Converter: VariantConverter,
  p3Converter: VariantConverter,
  p4Converter: VariantConverter,
  p5Converter: VariantConverter,
  function: (
    p0: P0,
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
  ) -> R,
) =
    LambdaCallable6<R, P0, P1, P2, P3, P4, P5>(LambdaContainer6<R, P0, P1, P2, P3, P4, P5>(returnConverter, arrayOf(p0Converter,
    p1Converter, p2Converter, p3Converter, p4Converter, p5Converter), function))

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5> ((
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
  p5: P5,
) -> R).asCallable() = lambdaCallable6(this)

public class LambdaCallable7<R, P0, P1, P2, P3, P4, P5, P6> @PublishedApi internal constructor(
  container: LambdaContainer<R>,
  boundArgs: Array<Any?> = emptyArray(),
) : LambdaCallable<R>(container, boundArgs), Callable7<R, P0, P1, P2, P3, P4, P5, P6> {
  public override fun bind(p6: P6) = LambdaCallable6<R, P0, P1, P2, P3, P4, P5>(container,
      arrayOf<Any?>(p6, *boundArgs))

  public override fun bind(p5: P5, p6: P6) = LambdaCallable5<R, P0, P1, P2, P3, P4>(container,
      arrayOf<Any?>(p5, p6, *boundArgs))

  public override fun bind(
    p4: P4,
    p5: P5,
    p6: P6,
  ) = LambdaCallable4<R, P0, P1, P2, P3>(container, arrayOf<Any?>(p4, p5, p6, *boundArgs))

  public override fun bind(
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
  ) = LambdaCallable3<R, P0, P1, P2>(container, arrayOf<Any?>(p3, p4, p5, p6, *boundArgs))

  public override fun bind(
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
  ) = LambdaCallable2<R, P0, P1>(container, arrayOf<Any?>(p2, p3, p4, p5, p6, *boundArgs))

  public override fun bind(
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
  ) = LambdaCallable1<R, P0>(container, arrayOf<Any?>(p1, p2, p3, p4, p5, p6, *boundArgs))

  public override fun bind(
    p0: P0,
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
  ) = LambdaCallable0<R>(container, arrayOf<Any?>(p0, p1, p2, p3, p4, p5, p6, *boundArgs))

  public companion object {
    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6> _createJava(
      returnType: Class<R>,
      p0Type: Class<P0>,
      p1Type: Class<P1>,
      p2Type: Class<P2>,
      p3Type: Class<P3>,
      p4Type: Class<P4>,
      p5Type: Class<P5>,
      p6Type: Class<P6>,
      function: JvmFunction7<R, P0, P1, P2, P3, P4, P5, P6>,
    ): LambdaCallable7<R, P0, P1, P2, P3, P4, P5, P6> =
        LambdaCallable7<R, P0, P1, P2, P3, P4, P5, P6>(LambdaContainer7<R, P0, P1, P2, P3, P4, P5, P6>(getVariantConverter(returnType)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6> _createJava(
      p0Type: Class<P0>,
      p1Type: Class<P1>,
      p2Type: Class<P2>,
      p3Type: Class<P3>,
      p4Type: Class<P4>,
      p5Type: Class<P5>,
      p6Type: Class<P6>,
      action: JvmAction7<P0, P1, P2, P3, P4, P5, P6>,
    ): LambdaCallable7<Void?, P0, P1, P2, P3, P4, P5, P6> =
        LambdaCallable7<Void?, P0, P1, P2, P3, P4, P5, P6>(LambdaContainer7<Void?, P0, P1, P2, P3, P4, P5, P6>(getVariantConverter(Void::class.java)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!), object :
        JvmFunction7<Void?, P0, P1, P2, P3, P4, P5, P6> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6)
        return null
      }
    }
    ))

    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6> _createJava(
      returnConverter: VariantConverter,
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      function: JvmFunction7<R, P0, P1, P2, P3, P4, P5, P6>,
    ): LambdaCallable7<R, P0, P1, P2, P3, P4, P5, P6> =
        LambdaCallable7<R, P0, P1, P2, P3, P4, P5, P6>(LambdaContainer7<R, P0, P1, P2, P3, P4, P5, P6>(returnConverter,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6> _createJava(
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      action: JvmAction7<P0, P1, P2, P3, P4, P5, P6>,
    ): LambdaCallable7<Void?, P0, P1, P2, P3, P4, P5, P6> =
        LambdaCallable7<Void?, P0, P1, P2, P3, P4, P5, P6>(LambdaContainer7<Void?, P0, P1, P2, P3, P4, P5, P6>(getVariantConverter(Void::class.java)!!,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter), object : JvmFunction7<Void?, P0, P1, P2, P3, P4, P5, P6> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6)
        return null
      }
    }
    ))
  }
}

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6> lambdaCallable7(noinline function: (
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
  p5: P5,
  p6: P6,
) -> R) =
    LambdaCallable7<R, P0, P1, P2, P3, P4, P5, P6>(LambdaContainer7<R, P0, P1, P2, P3, P4, P5, P6>(getVariantConverter<R>()!!, arrayOf(getVariantConverter<P0>()!!, getVariantConverter<P1>()!!, getVariantConverter<P2>()!!, getVariantConverter<P3>()!!, getVariantConverter<P4>()!!, getVariantConverter<P5>()!!, getVariantConverter<P6>()!!), function))

public fun <R, P0, P1, P2, P3, P4, P5, P6> lambdaCallable7(
  returnConverter: VariantConverter,
  p0Converter: VariantConverter,
  p1Converter: VariantConverter,
  p2Converter: VariantConverter,
  p3Converter: VariantConverter,
  p4Converter: VariantConverter,
  p5Converter: VariantConverter,
  p6Converter: VariantConverter,
  function: (
    p0: P0,
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
  ) -> R,
) =
    LambdaCallable7<R, P0, P1, P2, P3, P4, P5, P6>(LambdaContainer7<R, P0, P1, P2, P3, P4, P5, P6>(returnConverter, arrayOf(p0Converter,
    p1Converter, p2Converter, p3Converter, p4Converter, p5Converter, p6Converter), function))

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6> ((
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
  p5: P5,
  p6: P6,
) -> R).asCallable() = lambdaCallable7(this)

public class LambdaCallable8<R, P0, P1, P2, P3, P4, P5, P6, P7> @PublishedApi internal constructor(
  container: LambdaContainer<R>,
  boundArgs: Array<Any?> = emptyArray(),
) : LambdaCallable<R>(container, boundArgs), Callable8<R, P0, P1, P2, P3, P4, P5, P6, P7> {
  public override fun bind(p7: P7) = LambdaCallable7<R, P0, P1, P2, P3, P4, P5, P6>(container,
      arrayOf<Any?>(p7, *boundArgs))

  public override fun bind(p6: P6, p7: P7) = LambdaCallable6<R, P0, P1, P2, P3, P4, P5>(container,
      arrayOf<Any?>(p6, p7, *boundArgs))

  public override fun bind(
    p5: P5,
    p6: P6,
    p7: P7,
  ) = LambdaCallable5<R, P0, P1, P2, P3, P4>(container, arrayOf<Any?>(p5, p6, p7, *boundArgs))

  public override fun bind(
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
  ) = LambdaCallable4<R, P0, P1, P2, P3>(container, arrayOf<Any?>(p4, p5, p6, p7, *boundArgs))

  public override fun bind(
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
  ) = LambdaCallable3<R, P0, P1, P2>(container, arrayOf<Any?>(p3, p4, p5, p6, p7, *boundArgs))

  public override fun bind(
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
  ) = LambdaCallable2<R, P0, P1>(container, arrayOf<Any?>(p2, p3, p4, p5, p6, p7, *boundArgs))

  public override fun bind(
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
  ) = LambdaCallable1<R, P0>(container, arrayOf<Any?>(p1, p2, p3, p4, p5, p6, p7, *boundArgs))

  public override fun bind(
    p0: P0,
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
  ) = LambdaCallable0<R>(container, arrayOf<Any?>(p0, p1, p2, p3, p4, p5, p6, p7, *boundArgs))

  public companion object {
    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6, P7> _createJava(
      returnType: Class<R>,
      p0Type: Class<P0>,
      p1Type: Class<P1>,
      p2Type: Class<P2>,
      p3Type: Class<P3>,
      p4Type: Class<P4>,
      p5Type: Class<P5>,
      p6Type: Class<P6>,
      p7Type: Class<P7>,
      function: JvmFunction8<R, P0, P1, P2, P3, P4, P5, P6, P7>,
    ): LambdaCallable8<R, P0, P1, P2, P3, P4, P5, P6, P7> =
        LambdaCallable8<R, P0, P1, P2, P3, P4, P5, P6, P7>(LambdaContainer8<R, P0, P1, P2, P3, P4, P5, P6, P7>(getVariantConverter(returnType)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!,
        getVariantConverter(p7Type)!!), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6, P7> _createJava(
      p0Type: Class<P0>,
      p1Type: Class<P1>,
      p2Type: Class<P2>,
      p3Type: Class<P3>,
      p4Type: Class<P4>,
      p5Type: Class<P5>,
      p6Type: Class<P6>,
      p7Type: Class<P7>,
      action: JvmAction8<P0, P1, P2, P3, P4, P5, P6, P7>,
    ): LambdaCallable8<Void?, P0, P1, P2, P3, P4, P5, P6, P7> =
        LambdaCallable8<Void?, P0, P1, P2, P3, P4, P5, P6, P7>(LambdaContainer8<Void?, P0, P1, P2, P3, P4, P5, P6, P7>(getVariantConverter(Void::class.java)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!,
        getVariantConverter(p7Type)!!), object : JvmFunction8<Void?, P0, P1, P2, P3, P4, P5, P6, P7>
        {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6, p7)
        return null
      }
    }
    ))

    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6, P7> _createJava(
      returnConverter: VariantConverter,
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      p7Converter: VariantConverter,
      function: JvmFunction8<R, P0, P1, P2, P3, P4, P5, P6, P7>,
    ): LambdaCallable8<R, P0, P1, P2, P3, P4, P5, P6, P7> =
        LambdaCallable8<R, P0, P1, P2, P3, P4, P5, P6, P7>(LambdaContainer8<R, P0, P1, P2, P3, P4, P5, P6, P7>(returnConverter,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter, p7Converter), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6, P7> _createJava(
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      p7Converter: VariantConverter,
      action: JvmAction8<P0, P1, P2, P3, P4, P5, P6, P7>,
    ): LambdaCallable8<Void?, P0, P1, P2, P3, P4, P5, P6, P7> =
        LambdaCallable8<Void?, P0, P1, P2, P3, P4, P5, P6, P7>(LambdaContainer8<Void?, P0, P1, P2, P3, P4, P5, P6, P7>(getVariantConverter(Void::class.java)!!,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter, p7Converter), object : JvmFunction8<Void?, P0, P1, P2, P3, P4, P5, P6, P7> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6, p7)
        return null
      }
    }
    ))
  }
}

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6, reified P7> lambdaCallable8(noinline function: (
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
  p5: P5,
  p6: P6,
  p7: P7,
) -> R) =
    LambdaCallable8<R, P0, P1, P2, P3, P4, P5, P6, P7>(LambdaContainer8<R, P0, P1, P2, P3, P4, P5, P6, P7>(getVariantConverter<R>()!!, arrayOf(getVariantConverter<P0>()!!, getVariantConverter<P1>()!!, getVariantConverter<P2>()!!, getVariantConverter<P3>()!!, getVariantConverter<P4>()!!, getVariantConverter<P5>()!!, getVariantConverter<P6>()!!, getVariantConverter<P7>()!!), function))

public fun <R, P0, P1, P2, P3, P4, P5, P6, P7> lambdaCallable8(
  returnConverter: VariantConverter,
  p0Converter: VariantConverter,
  p1Converter: VariantConverter,
  p2Converter: VariantConverter,
  p3Converter: VariantConverter,
  p4Converter: VariantConverter,
  p5Converter: VariantConverter,
  p6Converter: VariantConverter,
  p7Converter: VariantConverter,
  function: (
    p0: P0,
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
  ) -> R,
) =
    LambdaCallable8<R, P0, P1, P2, P3, P4, P5, P6, P7>(LambdaContainer8<R, P0, P1, P2, P3, P4, P5, P6, P7>(returnConverter, arrayOf(p0Converter,
    p1Converter, p2Converter, p3Converter, p4Converter, p5Converter, p6Converter,
    p7Converter), function))

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6, reified P7> ((
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
  p5: P5,
  p6: P6,
  p7: P7,
) -> R).asCallable() = lambdaCallable8(this)

public class LambdaCallable9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8> @PublishedApi internal
    constructor(
  container: LambdaContainer<R>,
  boundArgs: Array<Any?> = emptyArray(),
) : LambdaCallable<R>(container, boundArgs), Callable9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8> {
  public override fun bind(p8: P8) = LambdaCallable8<R, P0, P1, P2, P3, P4, P5, P6, P7>(container,
      arrayOf<Any?>(p8, *boundArgs))

  public override fun bind(p7: P7, p8: P8) =
      LambdaCallable7<R, P0, P1, P2, P3, P4, P5, P6>(container, arrayOf<Any?>(p7, p8, *boundArgs))

  public override fun bind(
    p6: P6,
    p7: P7,
    p8: P8,
  ) = LambdaCallable6<R, P0, P1, P2, P3, P4, P5>(container, arrayOf<Any?>(p6, p7, p8, *boundArgs))

  public override fun bind(
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
  ) = LambdaCallable5<R, P0, P1, P2, P3, P4>(container, arrayOf<Any?>(p5, p6, p7, p8, *boundArgs))

  public override fun bind(
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
  ) = LambdaCallable4<R, P0, P1, P2, P3>(container, arrayOf<Any?>(p4, p5, p6, p7, p8, *boundArgs))

  public override fun bind(
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
  ) = LambdaCallable3<R, P0, P1, P2>(container, arrayOf<Any?>(p3, p4, p5, p6, p7, p8, *boundArgs))

  public override fun bind(
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
  ) = LambdaCallable2<R, P0, P1>(container, arrayOf<Any?>(p2, p3, p4, p5, p6, p7, p8, *boundArgs))

  public override fun bind(
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
  ) = LambdaCallable1<R, P0>(container, arrayOf<Any?>(p1, p2, p3, p4, p5, p6, p7, p8, *boundArgs))

  public override fun bind(
    p0: P0,
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
  ) = LambdaCallable0<R>(container, arrayOf<Any?>(p0, p1, p2, p3, p4, p5, p6, p7, p8, *boundArgs))

  public companion object {
    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8> _createJava(
      returnType: Class<R>,
      p0Type: Class<P0>,
      p1Type: Class<P1>,
      p2Type: Class<P2>,
      p3Type: Class<P3>,
      p4Type: Class<P4>,
      p5Type: Class<P5>,
      p6Type: Class<P6>,
      p7Type: Class<P7>,
      p8Type: Class<P8>,
      function: JvmFunction9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>,
    ): LambdaCallable9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8> =
        LambdaCallable9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>(LambdaContainer9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>(getVariantConverter(returnType)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!, getVariantConverter(p7Type)!!,
        getVariantConverter(p8Type)!!), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8> _createJava(
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
    ): LambdaCallable9<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8> =
        LambdaCallable9<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8>(LambdaContainer9<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8>(getVariantConverter(Void::class.java)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!, getVariantConverter(p7Type)!!,
        getVariantConverter(p8Type)!!), object :
        JvmFunction9<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8):
          Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6, p7, p8)
        return null
      }
    }
    ))

    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8> _createJava(
      returnConverter: VariantConverter,
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      p7Converter: VariantConverter,
      p8Converter: VariantConverter,
      function: JvmFunction9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>,
    ): LambdaCallable9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8> =
        LambdaCallable9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>(LambdaContainer9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>(returnConverter,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter, p7Converter, p8Converter), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8> _createJava(
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      p7Converter: VariantConverter,
      p8Converter: VariantConverter,
      action: JvmAction9<P0, P1, P2, P3, P4, P5, P6, P7, P8>,
    ): LambdaCallable9<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8> =
        LambdaCallable9<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8>(LambdaContainer9<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8>(getVariantConverter(Void::class.java)!!,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter, p7Converter, p8Converter), object :
        JvmFunction9<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8):
          Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6, p7, p8)
        return null
      }
    }
    ))
  }
}

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6, reified P7, reified P8> lambdaCallable9(noinline function: (
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
  p5: P5,
  p6: P6,
  p7: P7,
  p8: P8,
) -> R) =
    LambdaCallable9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>(LambdaContainer9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>(getVariantConverter<R>()!!, arrayOf(getVariantConverter<P0>()!!, getVariantConverter<P1>()!!, getVariantConverter<P2>()!!, getVariantConverter<P3>()!!, getVariantConverter<P4>()!!, getVariantConverter<P5>()!!, getVariantConverter<P6>()!!, getVariantConverter<P7>()!!, getVariantConverter<P8>()!!), function))

public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8> lambdaCallable9(
  returnConverter: VariantConverter,
  p0Converter: VariantConverter,
  p1Converter: VariantConverter,
  p2Converter: VariantConverter,
  p3Converter: VariantConverter,
  p4Converter: VariantConverter,
  p5Converter: VariantConverter,
  p6Converter: VariantConverter,
  p7Converter: VariantConverter,
  p8Converter: VariantConverter,
  function: (
    p0: P0,
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
  ) -> R,
) =
    LambdaCallable9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>(LambdaContainer9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>(returnConverter, arrayOf(p0Converter,
    p1Converter, p2Converter, p3Converter, p4Converter, p5Converter, p6Converter, p7Converter,
    p8Converter), function))

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6, reified P7, reified P8> ((
  p0: P0,
  p1: P1,
  p2: P2,
  p3: P3,
  p4: P4,
  p5: P5,
  p6: P6,
  p7: P7,
  p8: P8,
) -> R).asCallable() = lambdaCallable9(this)

public class LambdaCallable10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> @PublishedApi internal
    constructor(
  container: LambdaContainer<R>,
  boundArgs: Array<Any?> = emptyArray(),
) : LambdaCallable<R>(container, boundArgs), Callable10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> {
  public override fun bind(p9: P9) =
      LambdaCallable9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>(container, arrayOf<Any?>(p9,
      *boundArgs))

  public override fun bind(p8: P8, p9: P9) =
      LambdaCallable8<R, P0, P1, P2, P3, P4, P5, P6, P7>(container, arrayOf<Any?>(p8, p9,
      *boundArgs))

  public override fun bind(
    p7: P7,
    p8: P8,
    p9: P9,
  ) = LambdaCallable7<R, P0, P1, P2, P3, P4, P5, P6>(container, arrayOf<Any?>(p7, p8, p9,
      *boundArgs))

  public override fun bind(
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
  ) = LambdaCallable6<R, P0, P1, P2, P3, P4, P5>(container, arrayOf<Any?>(p6, p7, p8, p9,
      *boundArgs))

  public override fun bind(
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
  ) = LambdaCallable5<R, P0, P1, P2, P3, P4>(container, arrayOf<Any?>(p5, p6, p7, p8, p9,
      *boundArgs))

  public override fun bind(
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
  ) = LambdaCallable4<R, P0, P1, P2, P3>(container, arrayOf<Any?>(p4, p5, p6, p7, p8, p9,
      *boundArgs))

  public override fun bind(
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
  ) = LambdaCallable3<R, P0, P1, P2>(container, arrayOf<Any?>(p3, p4, p5, p6, p7, p8, p9,
      *boundArgs))

  public override fun bind(
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
  ) = LambdaCallable2<R, P0, P1>(container, arrayOf<Any?>(p2, p3, p4, p5, p6, p7, p8, p9,
      *boundArgs))

  public override fun bind(
    p1: P1,
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
  ) = LambdaCallable1<R, P0>(container, arrayOf<Any?>(p1, p2, p3, p4, p5, p6, p7, p8, p9,
      *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable0<R>(container, arrayOf<Any?>(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9,
      *boundArgs))

  public companion object {
    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> _createJava(
      returnType: Class<R>,
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
      function: JvmFunction10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>,
    ): LambdaCallable10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> =
        LambdaCallable10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(LambdaContainer10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(getVariantConverter(returnType)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!, getVariantConverter(p7Type)!!,
        getVariantConverter(p8Type)!!, getVariantConverter(p9Type)!!), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> _createJava(
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
    ): LambdaCallable10<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> =
        LambdaCallable10<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(LambdaContainer10<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(getVariantConverter(Void::class.java)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!, getVariantConverter(p7Type)!!,
        getVariantConverter(p8Type)!!, getVariantConverter(p9Type)!!), object :
        JvmFunction10<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8,
          p9: P9): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9)
        return null
      }
    }
    ))

    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> _createJava(
      returnConverter: VariantConverter,
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      p7Converter: VariantConverter,
      p8Converter: VariantConverter,
      p9Converter: VariantConverter,
      function: JvmFunction10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>,
    ): LambdaCallable10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> =
        LambdaCallable10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(LambdaContainer10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(returnConverter,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter, p7Converter, p8Converter, p9Converter), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> _createJava(
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      p7Converter: VariantConverter,
      p8Converter: VariantConverter,
      p9Converter: VariantConverter,
      action: JvmAction10<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>,
    ): LambdaCallable10<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> =
        LambdaCallable10<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(LambdaContainer10<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(getVariantConverter(Void::class.java)!!,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter, p7Converter, p8Converter, p9Converter), object :
        JvmFunction10<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8,
          p9: P9): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9)
        return null
      }
    }
    ))
  }
}

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6, reified P7, reified P8, reified P9> lambdaCallable10(noinline function: (
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
) -> R) =
    LambdaCallable10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(LambdaContainer10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(getVariantConverter<R>()!!, arrayOf(getVariantConverter<P0>()!!, getVariantConverter<P1>()!!, getVariantConverter<P2>()!!, getVariantConverter<P3>()!!, getVariantConverter<P4>()!!, getVariantConverter<P5>()!!, getVariantConverter<P6>()!!, getVariantConverter<P7>()!!, getVariantConverter<P8>()!!, getVariantConverter<P9>()!!), function))

public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9> lambdaCallable10(
  returnConverter: VariantConverter,
  p0Converter: VariantConverter,
  p1Converter: VariantConverter,
  p2Converter: VariantConverter,
  p3Converter: VariantConverter,
  p4Converter: VariantConverter,
  p5Converter: VariantConverter,
  p6Converter: VariantConverter,
  p7Converter: VariantConverter,
  p8Converter: VariantConverter,
  p9Converter: VariantConverter,
  function: (
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
  ) -> R,
) =
    LambdaCallable10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(LambdaContainer10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(returnConverter, arrayOf(p0Converter,
    p1Converter, p2Converter, p3Converter, p4Converter, p5Converter, p6Converter, p7Converter,
    p8Converter, p9Converter), function))

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6, reified P7, reified P8, reified P9> ((
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
) -> R).asCallable() = lambdaCallable10(this)

public class LambdaCallable11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> @PublishedApi internal
    constructor(
  container: LambdaContainer<R>,
  boundArgs: Array<Any?> = emptyArray(),
) : LambdaCallable<R>(container, boundArgs),
    Callable11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> {
  public override fun bind(p10: P10) =
      LambdaCallable10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(container, arrayOf<Any?>(p10,
      *boundArgs))

  public override fun bind(p9: P9, p10: P10) =
      LambdaCallable9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>(container, arrayOf<Any?>(p9, p10,
      *boundArgs))

  public override fun bind(
    p8: P8,
    p9: P9,
    p10: P10,
  ) = LambdaCallable8<R, P0, P1, P2, P3, P4, P5, P6, P7>(container, arrayOf<Any?>(p8, p9, p10,
      *boundArgs))

  public override fun bind(
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
  ) = LambdaCallable7<R, P0, P1, P2, P3, P4, P5, P6>(container, arrayOf<Any?>(p7, p8, p9, p10,
      *boundArgs))

  public override fun bind(
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
  ) = LambdaCallable6<R, P0, P1, P2, P3, P4, P5>(container, arrayOf<Any?>(p6, p7, p8, p9, p10,
      *boundArgs))

  public override fun bind(
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
  ) = LambdaCallable5<R, P0, P1, P2, P3, P4>(container, arrayOf<Any?>(p5, p6, p7, p8, p9, p10,
      *boundArgs))

  public override fun bind(
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
  ) = LambdaCallable4<R, P0, P1, P2, P3>(container, arrayOf<Any?>(p4, p5, p6, p7, p8, p9, p10,
      *boundArgs))

  public override fun bind(
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
  ) = LambdaCallable3<R, P0, P1, P2>(container, arrayOf<Any?>(p3, p4, p5, p6, p7, p8, p9, p10,
      *boundArgs))

  public override fun bind(
    p2: P2,
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
  ) = LambdaCallable2<R, P0, P1>(container, arrayOf<Any?>(p2, p3, p4, p5, p6, p7, p8, p9, p10,
      *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable1<R, P0>(container, arrayOf<Any?>(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
      *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable0<R>(container, arrayOf<Any?>(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
      *boundArgs))

  public companion object {
    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> _createJava(
      returnType: Class<R>,
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
      function: JvmFunction11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>,
    ): LambdaCallable11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> =
        LambdaCallable11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(LambdaContainer11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(getVariantConverter(returnType)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!, getVariantConverter(p7Type)!!,
        getVariantConverter(p8Type)!!, getVariantConverter(p9Type)!!,
        getVariantConverter(p10Type)!!), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> _createJava(
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
    ): LambdaCallable11<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> =
        LambdaCallable11<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(LambdaContainer11<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(getVariantConverter(Void::class.java)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!, getVariantConverter(p7Type)!!,
        getVariantConverter(p8Type)!!, getVariantConverter(p9Type)!!,
        getVariantConverter(p10Type)!!), object :
        JvmFunction11<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8,
          p9: P9, p10: P10): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10)
        return null
      }
    }
    ))

    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> _createJava(
      returnConverter: VariantConverter,
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      p7Converter: VariantConverter,
      p8Converter: VariantConverter,
      p9Converter: VariantConverter,
      p10Converter: VariantConverter,
      function: JvmFunction11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>,
    ): LambdaCallable11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> =
        LambdaCallable11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(LambdaContainer11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(returnConverter,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter, p7Converter, p8Converter, p9Converter, p10Converter), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> _createJava(
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      p7Converter: VariantConverter,
      p8Converter: VariantConverter,
      p9Converter: VariantConverter,
      p10Converter: VariantConverter,
      action: JvmAction11<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>,
    ): LambdaCallable11<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> =
        LambdaCallable11<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(LambdaContainer11<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(getVariantConverter(Void::class.java)!!,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter, p7Converter, p8Converter, p9Converter, p10Converter), object :
        JvmFunction11<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8,
          p9: P9, p10: P10): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10)
        return null
      }
    }
    ))
  }
}

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6, reified P7, reified P8, reified P9, reified P10> lambdaCallable11(noinline
    function: (
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
) -> R) =
    LambdaCallable11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(LambdaContainer11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(getVariantConverter<R>()!!, arrayOf(getVariantConverter<P0>()!!, getVariantConverter<P1>()!!, getVariantConverter<P2>()!!, getVariantConverter<P3>()!!, getVariantConverter<P4>()!!, getVariantConverter<P5>()!!, getVariantConverter<P6>()!!, getVariantConverter<P7>()!!, getVariantConverter<P8>()!!, getVariantConverter<P9>()!!, getVariantConverter<P10>()!!), function))

public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> lambdaCallable11(
  returnConverter: VariantConverter,
  p0Converter: VariantConverter,
  p1Converter: VariantConverter,
  p2Converter: VariantConverter,
  p3Converter: VariantConverter,
  p4Converter: VariantConverter,
  p5Converter: VariantConverter,
  p6Converter: VariantConverter,
  p7Converter: VariantConverter,
  p8Converter: VariantConverter,
  p9Converter: VariantConverter,
  p10Converter: VariantConverter,
  function: (
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
  ) -> R,
) =
    LambdaCallable11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(LambdaContainer11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(returnConverter, arrayOf(p0Converter,
    p1Converter, p2Converter, p3Converter, p4Converter, p5Converter, p6Converter, p7Converter,
    p8Converter, p9Converter, p10Converter), function))

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6, reified P7, reified P8, reified P9, reified P10> ((
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
) -> R).asCallable() = lambdaCallable11(this)

public class LambdaCallable12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> @PublishedApi
    internal constructor(
  container: LambdaContainer<R>,
  boundArgs: Array<Any?> = emptyArray(),
) : LambdaCallable<R>(container, boundArgs),
    Callable12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> {
  public override fun bind(p11: P11) =
      LambdaCallable11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(container, arrayOf<Any?>(p11,
      *boundArgs))

  public override fun bind(p10: P10, p11: P11) =
      LambdaCallable10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(container, arrayOf<Any?>(p10, p11,
      *boundArgs))

  public override fun bind(
    p9: P9,
    p10: P10,
    p11: P11,
  ) = LambdaCallable9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>(container, arrayOf<Any?>(p9, p10, p11,
      *boundArgs))

  public override fun bind(
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
  ) = LambdaCallable8<R, P0, P1, P2, P3, P4, P5, P6, P7>(container, arrayOf<Any?>(p8, p9, p10, p11,
      *boundArgs))

  public override fun bind(
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
  ) = LambdaCallable7<R, P0, P1, P2, P3, P4, P5, P6>(container, arrayOf<Any?>(p7, p8, p9, p10, p11,
      *boundArgs))

  public override fun bind(
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
  ) = LambdaCallable6<R, P0, P1, P2, P3, P4, P5>(container, arrayOf<Any?>(p6, p7, p8, p9, p10, p11,
      *boundArgs))

  public override fun bind(
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
  ) = LambdaCallable5<R, P0, P1, P2, P3, P4>(container, arrayOf<Any?>(p5, p6, p7, p8, p9, p10, p11,
      *boundArgs))

  public override fun bind(
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
  ) = LambdaCallable4<R, P0, P1, P2, P3>(container, arrayOf<Any?>(p4, p5, p6, p7, p8, p9, p10, p11,
      *boundArgs))

  public override fun bind(
    p3: P3,
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
  ) = LambdaCallable3<R, P0, P1, P2>(container, arrayOf<Any?>(p3, p4, p5, p6, p7, p8, p9, p10, p11,
      *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable2<R, P0, P1>(container, arrayOf<Any?>(p2, p3, p4, p5, p6, p7, p8, p9, p10, p11,
      *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable1<R, P0>(container, arrayOf<Any?>(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11,
      *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable0<R>(container, arrayOf<Any?>(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11,
      *boundArgs))

  public companion object {
    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> _createJava(
      returnType: Class<R>,
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
      function: JvmFunction12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>,
    ): LambdaCallable12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> =
        LambdaCallable12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(LambdaContainer12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(getVariantConverter(returnType)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!, getVariantConverter(p7Type)!!,
        getVariantConverter(p8Type)!!, getVariantConverter(p9Type)!!,
        getVariantConverter(p10Type)!!, getVariantConverter(p11Type)!!), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> _createJava(
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
    ): LambdaCallable12<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> =
        LambdaCallable12<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(LambdaContainer12<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(getVariantConverter(Void::class.java)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!, getVariantConverter(p7Type)!!,
        getVariantConverter(p8Type)!!, getVariantConverter(p9Type)!!,
        getVariantConverter(p10Type)!!, getVariantConverter(p11Type)!!), object :
        JvmFunction12<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8,
          p9: P9, p10: P10, p11: P11): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)
        return null
      }
    }
    ))

    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> _createJava(
      returnConverter: VariantConverter,
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      p7Converter: VariantConverter,
      p8Converter: VariantConverter,
      p9Converter: VariantConverter,
      p10Converter: VariantConverter,
      p11Converter: VariantConverter,
      function: JvmFunction12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>,
    ): LambdaCallable12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> =
        LambdaCallable12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(LambdaContainer12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(returnConverter,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter, p7Converter, p8Converter, p9Converter, p10Converter, p11Converter), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> _createJava(
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      p7Converter: VariantConverter,
      p8Converter: VariantConverter,
      p9Converter: VariantConverter,
      p10Converter: VariantConverter,
      p11Converter: VariantConverter,
      action: JvmAction12<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>,
    ): LambdaCallable12<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> =
        LambdaCallable12<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(LambdaContainer12<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(getVariantConverter(Void::class.java)!!,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter, p7Converter, p8Converter, p9Converter, p10Converter, p11Converter), object :
        JvmFunction12<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8,
          p9: P9, p10: P10, p11: P11): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)
        return null
      }
    }
    ))
  }
}

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6, reified P7, reified P8, reified P9, reified P10, reified P11>
    lambdaCallable12(noinline function: (
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
) -> R) =
    LambdaCallable12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(LambdaContainer12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(getVariantConverter<R>()!!, arrayOf(getVariantConverter<P0>()!!, getVariantConverter<P1>()!!, getVariantConverter<P2>()!!, getVariantConverter<P3>()!!, getVariantConverter<P4>()!!, getVariantConverter<P5>()!!, getVariantConverter<P6>()!!, getVariantConverter<P7>()!!, getVariantConverter<P8>()!!, getVariantConverter<P9>()!!, getVariantConverter<P10>()!!, getVariantConverter<P11>()!!), function))

public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> lambdaCallable12(
  returnConverter: VariantConverter,
  p0Converter: VariantConverter,
  p1Converter: VariantConverter,
  p2Converter: VariantConverter,
  p3Converter: VariantConverter,
  p4Converter: VariantConverter,
  p5Converter: VariantConverter,
  p6Converter: VariantConverter,
  p7Converter: VariantConverter,
  p8Converter: VariantConverter,
  p9Converter: VariantConverter,
  p10Converter: VariantConverter,
  p11Converter: VariantConverter,
  function: (
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
  ) -> R,
) =
    LambdaCallable12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(LambdaContainer12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(returnConverter, arrayOf(p0Converter,
    p1Converter, p2Converter, p3Converter, p4Converter, p5Converter, p6Converter, p7Converter,
    p8Converter, p9Converter, p10Converter, p11Converter), function))

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6, reified P7, reified P8, reified P9, reified P10, reified P11> ((
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
) -> R).asCallable() = lambdaCallable12(this)

public class LambdaCallable13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>
    @PublishedApi internal constructor(
  container: LambdaContainer<R>,
  boundArgs: Array<Any?> = emptyArray(),
) : LambdaCallable<R>(container, boundArgs),
    Callable13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> {
  public override fun bind(p12: P12) =
      LambdaCallable12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(container,
      arrayOf<Any?>(p12, *boundArgs))

  public override fun bind(p11: P11, p12: P12) =
      LambdaCallable11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(container,
      arrayOf<Any?>(p11, p12, *boundArgs))

  public override fun bind(
    p10: P10,
    p11: P11,
    p12: P12,
  ) = LambdaCallable10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(container,
      arrayOf<Any?>(p10, p11, p12, *boundArgs))

  public override fun bind(
    p9: P9,
    p10: P10,
    p11: P11,
    p12: P12,
  ) = LambdaCallable9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>(container,
      arrayOf<Any?>(p9, p10, p11, p12, *boundArgs))

  public override fun bind(
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
    p12: P12,
  ) = LambdaCallable8<R, P0, P1, P2, P3, P4, P5, P6, P7>(container,
      arrayOf<Any?>(p8, p9, p10, p11, p12, *boundArgs))

  public override fun bind(
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
    p12: P12,
  ) = LambdaCallable7<R, P0, P1, P2, P3, P4, P5, P6>(container,
      arrayOf<Any?>(p7, p8, p9, p10, p11, p12, *boundArgs))

  public override fun bind(
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
    p12: P12,
  ) = LambdaCallable6<R, P0, P1, P2, P3, P4, P5>(container,
      arrayOf<Any?>(p6, p7, p8, p9, p10, p11, p12, *boundArgs))

  public override fun bind(
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
    p12: P12,
  ) = LambdaCallable5<R, P0, P1, P2, P3, P4>(container,
      arrayOf<Any?>(p5, p6, p7, p8, p9, p10, p11, p12, *boundArgs))

  public override fun bind(
    p4: P4,
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
    p12: P12,
  ) = LambdaCallable4<R, P0, P1, P2, P3>(container,
      arrayOf<Any?>(p4, p5, p6, p7, p8, p9, p10, p11, p12, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable3<R, P0, P1, P2>(container,
      arrayOf<Any?>(p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable2<R, P0, P1>(container,
      arrayOf<Any?>(p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable1<R, P0>(container,
      arrayOf<Any?>(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable0<R>(container,
      arrayOf<Any?>(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, *boundArgs))

  public companion object {
    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> _createJava(
      returnType: Class<R>,
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
      function: JvmFunction13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>,
    ): LambdaCallable13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> =
        LambdaCallable13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>(LambdaContainer13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>(getVariantConverter(returnType)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!, getVariantConverter(p7Type)!!,
        getVariantConverter(p8Type)!!, getVariantConverter(p9Type)!!,
        getVariantConverter(p10Type)!!, getVariantConverter(p11Type)!!,
        getVariantConverter(p12Type)!!), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> _createJava(
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
    ): LambdaCallable13<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> =
        LambdaCallable13<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>(LambdaContainer13<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>(getVariantConverter(Void::class.java)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!, getVariantConverter(p7Type)!!,
        getVariantConverter(p8Type)!!, getVariantConverter(p9Type)!!,
        getVariantConverter(p10Type)!!, getVariantConverter(p11Type)!!,
        getVariantConverter(p12Type)!!), object :
        JvmFunction13<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8,
          p9: P9, p10: P10, p11: P11, p12: P12): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12)
        return null
      }
    }
    ))

    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> _createJava(
      returnConverter: VariantConverter,
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      p7Converter: VariantConverter,
      p8Converter: VariantConverter,
      p9Converter: VariantConverter,
      p10Converter: VariantConverter,
      p11Converter: VariantConverter,
      p12Converter: VariantConverter,
      function: JvmFunction13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>,
    ): LambdaCallable13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> =
        LambdaCallable13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>(LambdaContainer13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>(returnConverter,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter, p7Converter, p8Converter, p9Converter, p10Converter, p11Converter,
        p12Converter), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> _createJava(
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      p7Converter: VariantConverter,
      p8Converter: VariantConverter,
      p9Converter: VariantConverter,
      p10Converter: VariantConverter,
      p11Converter: VariantConverter,
      p12Converter: VariantConverter,
      action: JvmAction13<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>,
    ): LambdaCallable13<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> =
        LambdaCallable13<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>(LambdaContainer13<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>(getVariantConverter(Void::class.java)!!,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter, p7Converter, p8Converter, p9Converter, p10Converter, p11Converter,
        p12Converter), object :
        JvmFunction13<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8,
          p9: P9, p10: P10, p11: P11, p12: P12): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12)
        return null
      }
    }
    ))
  }
}

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12>
    lambdaCallable13(noinline function: (
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
) -> R) =
    LambdaCallable13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>(LambdaContainer13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>(getVariantConverter<R>()!!, arrayOf(getVariantConverter<P0>()!!, getVariantConverter<P1>()!!, getVariantConverter<P2>()!!, getVariantConverter<P3>()!!, getVariantConverter<P4>()!!, getVariantConverter<P5>()!!, getVariantConverter<P6>()!!, getVariantConverter<P7>()!!, getVariantConverter<P8>()!!, getVariantConverter<P9>()!!, getVariantConverter<P10>()!!, getVariantConverter<P11>()!!, getVariantConverter<P12>()!!), function))

public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> lambdaCallable13(
  returnConverter: VariantConverter,
  p0Converter: VariantConverter,
  p1Converter: VariantConverter,
  p2Converter: VariantConverter,
  p3Converter: VariantConverter,
  p4Converter: VariantConverter,
  p5Converter: VariantConverter,
  p6Converter: VariantConverter,
  p7Converter: VariantConverter,
  p8Converter: VariantConverter,
  p9Converter: VariantConverter,
  p10Converter: VariantConverter,
  p11Converter: VariantConverter,
  p12Converter: VariantConverter,
  function: (
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
  ) -> R,
) =
    LambdaCallable13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>(LambdaContainer13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>(returnConverter, arrayOf(p0Converter,
    p1Converter, p2Converter, p3Converter, p4Converter, p5Converter, p6Converter, p7Converter,
    p8Converter, p9Converter, p10Converter, p11Converter, p12Converter), function))

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12> ((
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
) -> R).asCallable() = lambdaCallable13(this)

public class LambdaCallable14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>
    @PublishedApi internal constructor(
  container: LambdaContainer<R>,
  boundArgs: Array<Any?> = emptyArray(),
) : LambdaCallable<R>(container, boundArgs),
    Callable14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> {
  public override fun bind(p13: P13) =
      LambdaCallable13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>(container,
      arrayOf<Any?>(p13, *boundArgs))

  public override fun bind(p12: P12, p13: P13) =
      LambdaCallable12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(container,
      arrayOf<Any?>(p12, p13, *boundArgs))

  public override fun bind(
    p11: P11,
    p12: P12,
    p13: P13,
  ) = LambdaCallable11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(container,
      arrayOf<Any?>(p11, p12, p13, *boundArgs))

  public override fun bind(
    p10: P10,
    p11: P11,
    p12: P12,
    p13: P13,
  ) = LambdaCallable10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(container,
      arrayOf<Any?>(p10, p11, p12, p13, *boundArgs))

  public override fun bind(
    p9: P9,
    p10: P10,
    p11: P11,
    p12: P12,
    p13: P13,
  ) = LambdaCallable9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>(container,
      arrayOf<Any?>(p9, p10, p11, p12, p13, *boundArgs))

  public override fun bind(
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
    p12: P12,
    p13: P13,
  ) = LambdaCallable8<R, P0, P1, P2, P3, P4, P5, P6, P7>(container,
      arrayOf<Any?>(p8, p9, p10, p11, p12, p13, *boundArgs))

  public override fun bind(
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
    p12: P12,
    p13: P13,
  ) = LambdaCallable7<R, P0, P1, P2, P3, P4, P5, P6>(container,
      arrayOf<Any?>(p7, p8, p9, p10, p11, p12, p13, *boundArgs))

  public override fun bind(
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
    p12: P12,
    p13: P13,
  ) = LambdaCallable6<R, P0, P1, P2, P3, P4, P5>(container,
      arrayOf<Any?>(p6, p7, p8, p9, p10, p11, p12, p13, *boundArgs))

  public override fun bind(
    p5: P5,
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
    p12: P12,
    p13: P13,
  ) = LambdaCallable5<R, P0, P1, P2, P3, P4>(container,
      arrayOf<Any?>(p5, p6, p7, p8, p9, p10, p11, p12, p13, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable4<R, P0, P1, P2, P3>(container,
      arrayOf<Any?>(p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable3<R, P0, P1, P2>(container,
      arrayOf<Any?>(p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable2<R, P0, P1>(container,
      arrayOf<Any?>(p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable1<R, P0>(container,
      arrayOf<Any?>(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable0<R>(container,
      arrayOf<Any?>(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, *boundArgs))

  public companion object {
    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> _createJava(
      returnType: Class<R>,
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
      function: JvmFunction14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>,
    ): LambdaCallable14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> =
        LambdaCallable14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>(LambdaContainer14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>(getVariantConverter(returnType)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!, getVariantConverter(p7Type)!!,
        getVariantConverter(p8Type)!!, getVariantConverter(p9Type)!!,
        getVariantConverter(p10Type)!!, getVariantConverter(p11Type)!!,
        getVariantConverter(p12Type)!!, getVariantConverter(p13Type)!!), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> _createJava(
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
    ): LambdaCallable14<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> =
        LambdaCallable14<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>(LambdaContainer14<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>(getVariantConverter(Void::class.java)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!, getVariantConverter(p7Type)!!,
        getVariantConverter(p8Type)!!, getVariantConverter(p9Type)!!,
        getVariantConverter(p10Type)!!, getVariantConverter(p11Type)!!,
        getVariantConverter(p12Type)!!, getVariantConverter(p13Type)!!), object :
        JvmFunction14<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8,
          p9: P9, p10: P10, p11: P11, p12: P12, p13: P13): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13)
        return null
      }
    }
    ))

    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> _createJava(
      returnConverter: VariantConverter,
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      p7Converter: VariantConverter,
      p8Converter: VariantConverter,
      p9Converter: VariantConverter,
      p10Converter: VariantConverter,
      p11Converter: VariantConverter,
      p12Converter: VariantConverter,
      p13Converter: VariantConverter,
      function: JvmFunction14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>,
    ): LambdaCallable14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> =
        LambdaCallable14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>(LambdaContainer14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>(returnConverter,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter, p7Converter, p8Converter, p9Converter, p10Converter, p11Converter,
        p12Converter, p13Converter), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> _createJava(
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      p7Converter: VariantConverter,
      p8Converter: VariantConverter,
      p9Converter: VariantConverter,
      p10Converter: VariantConverter,
      p11Converter: VariantConverter,
      p12Converter: VariantConverter,
      p13Converter: VariantConverter,
      action: JvmAction14<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>,
    ): LambdaCallable14<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> =
        LambdaCallable14<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>(LambdaContainer14<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>(getVariantConverter(Void::class.java)!!,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter, p7Converter, p8Converter, p9Converter, p10Converter, p11Converter,
        p12Converter, p13Converter), object :
        JvmFunction14<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8,
          p9: P9, p10: P10, p11: P11, p12: P12, p13: P13): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13)
        return null
      }
    }
    ))
  }
}

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12,
    reified P13> lambdaCallable14(noinline function: (
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
) -> R) =
    LambdaCallable14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>(LambdaContainer14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>(getVariantConverter<R>()!!, arrayOf(getVariantConverter<P0>()!!, getVariantConverter<P1>()!!, getVariantConverter<P2>()!!, getVariantConverter<P3>()!!, getVariantConverter<P4>()!!, getVariantConverter<P5>()!!, getVariantConverter<P6>()!!, getVariantConverter<P7>()!!, getVariantConverter<P8>()!!, getVariantConverter<P9>()!!, getVariantConverter<P10>()!!, getVariantConverter<P11>()!!, getVariantConverter<P12>()!!, getVariantConverter<P13>()!!), function))

public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> lambdaCallable14(
  returnConverter: VariantConverter,
  p0Converter: VariantConverter,
  p1Converter: VariantConverter,
  p2Converter: VariantConverter,
  p3Converter: VariantConverter,
  p4Converter: VariantConverter,
  p5Converter: VariantConverter,
  p6Converter: VariantConverter,
  p7Converter: VariantConverter,
  p8Converter: VariantConverter,
  p9Converter: VariantConverter,
  p10Converter: VariantConverter,
  p11Converter: VariantConverter,
  p12Converter: VariantConverter,
  p13Converter: VariantConverter,
  function: (
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
  ) -> R,
) =
    LambdaCallable14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>(LambdaContainer14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>(returnConverter, arrayOf(p0Converter,
    p1Converter, p2Converter, p3Converter, p4Converter, p5Converter, p6Converter, p7Converter,
    p8Converter, p9Converter, p10Converter, p11Converter, p12Converter, p13Converter), function))

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12,
    reified P13> ((
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
) -> R).asCallable() = lambdaCallable14(this)

public class LambdaCallable15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>
    @PublishedApi internal constructor(
  container: LambdaContainer<R>,
  boundArgs: Array<Any?> = emptyArray(),
) : LambdaCallable<R>(container, boundArgs),
    Callable15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> {
  public override fun bind(p14: P14) =
      LambdaCallable14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>(container,
      arrayOf<Any?>(p14, *boundArgs))

  public override fun bind(p13: P13, p14: P14) =
      LambdaCallable13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>(container,
      arrayOf<Any?>(p13, p14, *boundArgs))

  public override fun bind(
    p12: P12,
    p13: P13,
    p14: P14,
  ) = LambdaCallable12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(container,
      arrayOf<Any?>(p12, p13, p14, *boundArgs))

  public override fun bind(
    p11: P11,
    p12: P12,
    p13: P13,
    p14: P14,
  ) = LambdaCallable11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(container,
      arrayOf<Any?>(p11, p12, p13, p14, *boundArgs))

  public override fun bind(
    p10: P10,
    p11: P11,
    p12: P12,
    p13: P13,
    p14: P14,
  ) = LambdaCallable10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(container,
      arrayOf<Any?>(p10, p11, p12, p13, p14, *boundArgs))

  public override fun bind(
    p9: P9,
    p10: P10,
    p11: P11,
    p12: P12,
    p13: P13,
    p14: P14,
  ) = LambdaCallable9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>(container,
      arrayOf<Any?>(p9, p10, p11, p12, p13, p14, *boundArgs))

  public override fun bind(
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
    p12: P12,
    p13: P13,
    p14: P14,
  ) = LambdaCallable8<R, P0, P1, P2, P3, P4, P5, P6, P7>(container,
      arrayOf<Any?>(p8, p9, p10, p11, p12, p13, p14, *boundArgs))

  public override fun bind(
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
    p12: P12,
    p13: P13,
    p14: P14,
  ) = LambdaCallable7<R, P0, P1, P2, P3, P4, P5, P6>(container,
      arrayOf<Any?>(p7, p8, p9, p10, p11, p12, p13, p14, *boundArgs))

  public override fun bind(
    p6: P6,
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
    p12: P12,
    p13: P13,
    p14: P14,
  ) = LambdaCallable6<R, P0, P1, P2, P3, P4, P5>(container,
      arrayOf<Any?>(p6, p7, p8, p9, p10, p11, p12, p13, p14, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable5<R, P0, P1, P2, P3, P4>(container,
      arrayOf<Any?>(p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable4<R, P0, P1, P2, P3>(container,
      arrayOf<Any?>(p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable3<R, P0, P1, P2>(container,
      arrayOf<Any?>(p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable2<R, P0, P1>(container,
      arrayOf<Any?>(p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable1<R, P0>(container,
      arrayOf<Any?>(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable0<R>(container,
      arrayOf<Any?>(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, *boundArgs))

  public companion object {
    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> _createJava(
      returnType: Class<R>,
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
      function: JvmFunction15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>,
    ): LambdaCallable15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> =
        LambdaCallable15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>(LambdaContainer15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>(getVariantConverter(returnType)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!, getVariantConverter(p7Type)!!,
        getVariantConverter(p8Type)!!, getVariantConverter(p9Type)!!,
        getVariantConverter(p10Type)!!, getVariantConverter(p11Type)!!,
        getVariantConverter(p12Type)!!, getVariantConverter(p13Type)!!,
        getVariantConverter(p14Type)!!), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> _createJava(
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
    ): LambdaCallable15<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> =
        LambdaCallable15<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>(LambdaContainer15<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>(getVariantConverter(Void::class.java)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!, getVariantConverter(p7Type)!!,
        getVariantConverter(p8Type)!!, getVariantConverter(p9Type)!!,
        getVariantConverter(p10Type)!!, getVariantConverter(p11Type)!!,
        getVariantConverter(p12Type)!!, getVariantConverter(p13Type)!!,
        getVariantConverter(p14Type)!!), object :
        JvmFunction15<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8,
          p9: P9, p10: P10, p11: P11, p12: P12, p13: P13, p14: P14): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14)
        return null
      }
    }
    ))

    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> _createJava(
      returnConverter: VariantConverter,
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      p7Converter: VariantConverter,
      p8Converter: VariantConverter,
      p9Converter: VariantConverter,
      p10Converter: VariantConverter,
      p11Converter: VariantConverter,
      p12Converter: VariantConverter,
      p13Converter: VariantConverter,
      p14Converter: VariantConverter,
      function: JvmFunction15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>,
    ): LambdaCallable15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> =
        LambdaCallable15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>(LambdaContainer15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>(returnConverter,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter, p7Converter, p8Converter, p9Converter, p10Converter, p11Converter,
        p12Converter, p13Converter, p14Converter), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> _createJava(
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      p7Converter: VariantConverter,
      p8Converter: VariantConverter,
      p9Converter: VariantConverter,
      p10Converter: VariantConverter,
      p11Converter: VariantConverter,
      p12Converter: VariantConverter,
      p13Converter: VariantConverter,
      p14Converter: VariantConverter,
      action: JvmAction15<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>,
    ): LambdaCallable15<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> =
        LambdaCallable15<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>(LambdaContainer15<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>(getVariantConverter(Void::class.java)!!,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter, p7Converter, p8Converter, p9Converter, p10Converter, p11Converter,
        p12Converter, p13Converter, p14Converter), object :
        JvmFunction15<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8,
          p9: P9, p10: P10, p11: P11, p12: P12, p13: P13, p14: P14): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14)
        return null
      }
    }
    ))
  }
}

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12,
    reified P13, reified P14> lambdaCallable15(noinline function: (
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
) -> R) =
    LambdaCallable15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>(LambdaContainer15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>(getVariantConverter<R>()!!, arrayOf(getVariantConverter<P0>()!!, getVariantConverter<P1>()!!, getVariantConverter<P2>()!!, getVariantConverter<P3>()!!, getVariantConverter<P4>()!!, getVariantConverter<P5>()!!, getVariantConverter<P6>()!!, getVariantConverter<P7>()!!, getVariantConverter<P8>()!!, getVariantConverter<P9>()!!, getVariantConverter<P10>()!!, getVariantConverter<P11>()!!, getVariantConverter<P12>()!!, getVariantConverter<P13>()!!, getVariantConverter<P14>()!!), function))

public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> lambdaCallable15(
  returnConverter: VariantConverter,
  p0Converter: VariantConverter,
  p1Converter: VariantConverter,
  p2Converter: VariantConverter,
  p3Converter: VariantConverter,
  p4Converter: VariantConverter,
  p5Converter: VariantConverter,
  p6Converter: VariantConverter,
  p7Converter: VariantConverter,
  p8Converter: VariantConverter,
  p9Converter: VariantConverter,
  p10Converter: VariantConverter,
  p11Converter: VariantConverter,
  p12Converter: VariantConverter,
  p13Converter: VariantConverter,
  p14Converter: VariantConverter,
  function: (
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
  ) -> R,
) =
    LambdaCallable15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>(LambdaContainer15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>(returnConverter, arrayOf(p0Converter,
    p1Converter, p2Converter, p3Converter, p4Converter, p5Converter, p6Converter, p7Converter,
    p8Converter, p9Converter, p10Converter, p11Converter, p12Converter, p13Converter,
    p14Converter), function))

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12,
    reified P13, reified P14> ((
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
) -> R).asCallable() = lambdaCallable15(this)

public class LambdaCallable16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14,
    P15> @PublishedApi internal constructor(
  container: LambdaContainer<R>,
  boundArgs: Array<Any?> = emptyArray(),
) : LambdaCallable<R>(container, boundArgs),
    Callable16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> {
  public override fun bind(p15: P15) =
      LambdaCallable15<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14>(container,
      arrayOf<Any?>(p15, *boundArgs))

  public override fun bind(p14: P14, p15: P15) =
      LambdaCallable14<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13>(container,
      arrayOf<Any?>(p14, p15, *boundArgs))

  public override fun bind(
    p13: P13,
    p14: P14,
    p15: P15,
  ) = LambdaCallable13<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12>(container,
      arrayOf<Any?>(p13, p14, p15, *boundArgs))

  public override fun bind(
    p12: P12,
    p13: P13,
    p14: P14,
    p15: P15,
  ) = LambdaCallable12<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11>(container,
      arrayOf<Any?>(p12, p13, p14, p15, *boundArgs))

  public override fun bind(
    p11: P11,
    p12: P12,
    p13: P13,
    p14: P14,
    p15: P15,
  ) = LambdaCallable11<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10>(container,
      arrayOf<Any?>(p11, p12, p13, p14, p15, *boundArgs))

  public override fun bind(
    p10: P10,
    p11: P11,
    p12: P12,
    p13: P13,
    p14: P14,
    p15: P15,
  ) = LambdaCallable10<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9>(container,
      arrayOf<Any?>(p10, p11, p12, p13, p14, p15, *boundArgs))

  public override fun bind(
    p9: P9,
    p10: P10,
    p11: P11,
    p12: P12,
    p13: P13,
    p14: P14,
    p15: P15,
  ) = LambdaCallable9<R, P0, P1, P2, P3, P4, P5, P6, P7, P8>(container,
      arrayOf<Any?>(p9, p10, p11, p12, p13, p14, p15, *boundArgs))

  public override fun bind(
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
    p12: P12,
    p13: P13,
    p14: P14,
    p15: P15,
  ) = LambdaCallable8<R, P0, P1, P2, P3, P4, P5, P6, P7>(container,
      arrayOf<Any?>(p8, p9, p10, p11, p12, p13, p14, p15, *boundArgs))

  public override fun bind(
    p7: P7,
    p8: P8,
    p9: P9,
    p10: P10,
    p11: P11,
    p12: P12,
    p13: P13,
    p14: P14,
    p15: P15,
  ) = LambdaCallable7<R, P0, P1, P2, P3, P4, P5, P6>(container,
      arrayOf<Any?>(p7, p8, p9, p10, p11, p12, p13, p14, p15, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable6<R, P0, P1, P2, P3, P4, P5>(container,
      arrayOf<Any?>(p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable5<R, P0, P1, P2, P3, P4>(container,
      arrayOf<Any?>(p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable4<R, P0, P1, P2, P3>(container,
      arrayOf<Any?>(p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable3<R, P0, P1, P2>(container,
      arrayOf<Any?>(p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable2<R, P0, P1>(container,
      arrayOf<Any?>(p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable1<R, P0>(container,
      arrayOf<Any?>(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, *boundArgs))

  public override fun bind(
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
  ) = LambdaCallable0<R>(container,
      arrayOf<Any?>(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15,
      *boundArgs))

  public companion object {
    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>
        _createJava(
      returnType: Class<R>,
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
      function: JvmFunction16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>,
    ): LambdaCallable16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> =
        LambdaCallable16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>(LambdaContainer16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>(getVariantConverter(returnType)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!, getVariantConverter(p7Type)!!,
        getVariantConverter(p8Type)!!, getVariantConverter(p9Type)!!,
        getVariantConverter(p10Type)!!, getVariantConverter(p11Type)!!,
        getVariantConverter(p12Type)!!, getVariantConverter(p13Type)!!,
        getVariantConverter(p14Type)!!, getVariantConverter(p15Type)!!), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> _createJava(
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
    ): LambdaCallable16<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>
        =
        LambdaCallable16<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>(LambdaContainer16<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>(getVariantConverter(Void::class.java)!!,
        arrayOf(getVariantConverter(p0Type)!!, getVariantConverter(p1Type)!!,
        getVariantConverter(p2Type)!!, getVariantConverter(p3Type)!!, getVariantConverter(p4Type)!!,
        getVariantConverter(p5Type)!!, getVariantConverter(p6Type)!!, getVariantConverter(p7Type)!!,
        getVariantConverter(p8Type)!!, getVariantConverter(p9Type)!!,
        getVariantConverter(p10Type)!!, getVariantConverter(p11Type)!!,
        getVariantConverter(p12Type)!!, getVariantConverter(p13Type)!!,
        getVariantConverter(p14Type)!!, getVariantConverter(p15Type)!!), object :
        JvmFunction16<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8,
          p9: P9, p10: P10, p11: P11, p12: P12, p13: P13, p14: P14, p15: P15): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15)
        return null
      }
    }
    ))

    @JvmStatic
    @JvmName("create")
    public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>
        _createJava(
      returnConverter: VariantConverter,
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      p7Converter: VariantConverter,
      p8Converter: VariantConverter,
      p9Converter: VariantConverter,
      p10Converter: VariantConverter,
      p11Converter: VariantConverter,
      p12Converter: VariantConverter,
      p13Converter: VariantConverter,
      p14Converter: VariantConverter,
      p15Converter: VariantConverter,
      function: JvmFunction16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>,
    ): LambdaCallable16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> =
        LambdaCallable16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>(LambdaContainer16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>(returnConverter,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter, p7Converter, p8Converter, p9Converter, p10Converter, p11Converter,
        p12Converter, p13Converter, p14Converter, p15Converter), function))

    @JvmStatic
    @JvmName("create")
    public fun <P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> _createJava(
      p0Converter: VariantConverter,
      p1Converter: VariantConverter,
      p2Converter: VariantConverter,
      p3Converter: VariantConverter,
      p4Converter: VariantConverter,
      p5Converter: VariantConverter,
      p6Converter: VariantConverter,
      p7Converter: VariantConverter,
      p8Converter: VariantConverter,
      p9Converter: VariantConverter,
      p10Converter: VariantConverter,
      p11Converter: VariantConverter,
      p12Converter: VariantConverter,
      p13Converter: VariantConverter,
      p14Converter: VariantConverter,
      p15Converter: VariantConverter,
      action: JvmAction16<P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>,
    ): LambdaCallable16<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>
        =
        LambdaCallable16<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>(LambdaContainer16<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>(getVariantConverter(Void::class.java)!!,
        arrayOf(p0Converter, p1Converter, p2Converter, p3Converter, p4Converter, p5Converter,
        p6Converter, p7Converter, p8Converter, p9Converter, p10Converter, p11Converter,
        p12Converter, p13Converter, p14Converter, p15Converter), object :
        JvmFunction16<Void?, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> {
      override fun invoke(p0: P0, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8,
          p9: P9, p10: P10, p11: P11, p12: P12, p13: P13, p14: P14, p15: P15): Void? {
        action.invoke(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15)
        return null
      }
    }
    ))
  }
}

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12,
    reified P13, reified P14, reified P15> lambdaCallable16(noinline function: (
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
) -> R) =
    LambdaCallable16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>(LambdaContainer16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>(getVariantConverter<R>()!!, arrayOf(getVariantConverter<P0>()!!, getVariantConverter<P1>()!!, getVariantConverter<P2>()!!, getVariantConverter<P3>()!!, getVariantConverter<P4>()!!, getVariantConverter<P5>()!!, getVariantConverter<P6>()!!, getVariantConverter<P7>()!!, getVariantConverter<P8>()!!, getVariantConverter<P9>()!!, getVariantConverter<P10>()!!, getVariantConverter<P11>()!!, getVariantConverter<P12>()!!, getVariantConverter<P13>()!!, getVariantConverter<P14>()!!, getVariantConverter<P15>()!!), function))

public fun <R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>
    lambdaCallable16(
  returnConverter: VariantConverter,
  p0Converter: VariantConverter,
  p1Converter: VariantConverter,
  p2Converter: VariantConverter,
  p3Converter: VariantConverter,
  p4Converter: VariantConverter,
  p5Converter: VariantConverter,
  p6Converter: VariantConverter,
  p7Converter: VariantConverter,
  p8Converter: VariantConverter,
  p9Converter: VariantConverter,
  p10Converter: VariantConverter,
  p11Converter: VariantConverter,
  p12Converter: VariantConverter,
  p13Converter: VariantConverter,
  p14Converter: VariantConverter,
  p15Converter: VariantConverter,
  function: (
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
  ) -> R,
) =
    LambdaCallable16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>(LambdaContainer16<R, P0, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15>(returnConverter, arrayOf(p0Converter,
    p1Converter, p2Converter, p3Converter, p4Converter, p5Converter, p6Converter, p7Converter,
    p8Converter, p9Converter, p10Converter, p11Converter, p12Converter, p13Converter, p14Converter,
    p15Converter), function))

public inline fun <reified R, reified P0, reified P1, reified P2, reified P3, reified P4, reified
    P5, reified P6, reified P7, reified P8, reified P9, reified P10, reified P11, reified P12,
    reified P13, reified P14, reified P15> ((
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
) -> R).asCallable() = lambdaCallable16(this)
