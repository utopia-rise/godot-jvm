package godot.common.interop

import java.nio.ByteBuffer

interface VariantConverter<out T> {
    val id: Int

    fun toKotlin(buffer: ByteBuffer): T
    fun toGodot(buffer: ByteBuffer, any: Any?)
}
