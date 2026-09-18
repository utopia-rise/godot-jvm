// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import godot.core.BitFieldBase
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

public infix fun Long.or(other: ImageFormatLoader.LoaderFlags): Long = this.or(other.flag)

public infix fun Long.xor(other: ImageFormatLoader.LoaderFlags): Long = this.xor(other.flag)

public infix fun Long.and(other: ImageFormatLoader.LoaderFlags): Long = this.and(other.flag)

/**
 * The engine supports multiple image formats out of the box (PNG, SVG, JPEG, WebP to name a few),
 * but you can choose to implement support for additional image formats by extending
 * [ImageFormatLoaderExtension].
 */
@GodotBaseType
public open class ImageFormatLoader internal constructor() : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(299, scriptPtr)
  }

  public class LoaderFlags(
    flag: Long,
  ) : BitFieldBase<LoaderFlags>(flag) {
    protected override fun wrap(flag: Long): LoaderFlags = LoaderFlags(flag)

    public companion object {
      /**
       * Default loading behavior. No processing is applied to the image.
       */
      @JvmField
      public val FLAG_NONE: LoaderFlags = LoaderFlags(0)

      /**
       * If set, the image is converted from sRGB to linear encoding.
       */
      @JvmField
      public val FLAG_FORCE_LINEAR: LoaderFlags = LoaderFlags(1)

      /**
       * If set, a predefined color map is applied to the image. Used when
       * [ResourceImporterTexture.editor/convertColorsWithEditorTheme] is `true`.
       */
      @JvmField
      public val FLAG_CONVERT_COLORS: LoaderFlags = LoaderFlags(2)
    }
  }

  public companion object

  public object MethodBindings
}
