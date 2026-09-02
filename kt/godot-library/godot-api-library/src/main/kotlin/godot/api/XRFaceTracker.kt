// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedFloat32Array
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.PACKED_FLOAT_32_ARRAY
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * An instance of this object represents a tracked face and its corresponding blend shapes. The
 * blend shapes come from the
 * [url=https://docs.vrcft.io/docs/tutorial-avatars/tutorial-avatars-extras/unified-blendshapes]Unified
 * Expressions[/url] standard, and contain extended details and visuals for each blend shape.
 * Additionally the
 * [url=https://docs.vrcft.io/docs/tutorial-avatars/tutorial-avatars-extras/compatibility/overview]Tracking
 * Standard Comparison[/url] page documents the relationship between Unified Expressions and other
 * standards.
 *
 * As face trackers are turned on they are registered with the [XRServer].
 */
@GodotBaseType
public open class XRFaceTracker : XRTracker() {
  /**
   * The array of face blend shape weights with indices corresponding to the [BlendShapeEntry] enum.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var blendShapes: PackedFloat32Array
    @JvmName("blendShapesProperty")
    get() = getBlendShapes()
    @JvmName("blendShapesProperty")
    set(`value`) {
      setBlendShapes(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(943, scriptPtr)
  }

  /**
   * This is a helper function for [blendShapes] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = xrfacetracker.blendShapes
   * //Your changes
   * xrfacetracker.blendShapes = myCoreType
   * ``````
   *
   * The array of face blend shape weights with indices corresponding to the [BlendShapeEntry] enum.
   */
  @CoreTypeHelper
  public final fun blendShapesMutate(block: PackedFloat32Array.() -> Unit): PackedFloat32Array =
      blendShapes.apply {
     block(this)
     blendShapes = this
  }

  /**
   * This is a helper function for [blendShapes] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The array of face blend shape weights with indices corresponding to the [BlendShapeEntry] enum.
   */
  @CoreTypeHelper
  public final fun blendShapesMutateEach(block: (index: Int, `value`: Float) -> Unit):
      PackedFloat32Array = blendShapes.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     blendShapes = this
  }

  /**
   * Returns the requested face blend shape weight.
   */
  public final fun getBlendShape(blendShape: BlendShapeEntry): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to blendShape.value)
    TransferContext.callMethod(MethodBindings.getBlendShapePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets a face blend shape weight.
   */
  public final fun setBlendShape(blendShape: BlendShapeEntry, weight: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to blendShape.value, DOUBLE to weight.toDouble())
    TransferContext.callMethod(MethodBindings.setBlendShapePtr)
  }

  public final fun getBlendShapes(): PackedFloat32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBlendShapesPtr)
    return (TransferContext.readReturnValue(PACKED_FLOAT_32_ARRAY) as PackedFloat32Array)
  }

  public final fun setBlendShapes(weights: PackedFloat32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_FLOAT_32_ARRAY to weights)
    TransferContext.callMethod(MethodBindings.setBlendShapesPtr)
  }

  public enum class BlendShapeEntry(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Right eye looks outwards.
     */
    FT_EYE_LOOK_OUT_RIGHT(0),
    /**
     * Right eye looks inwards.
     */
    FT_EYE_LOOK_IN_RIGHT(1),
    /**
     * Right eye looks upwards.
     */
    FT_EYE_LOOK_UP_RIGHT(2),
    /**
     * Right eye looks downwards.
     */
    FT_EYE_LOOK_DOWN_RIGHT(3),
    /**
     * Left eye looks outwards.
     */
    FT_EYE_LOOK_OUT_LEFT(4),
    /**
     * Left eye looks inwards.
     */
    FT_EYE_LOOK_IN_LEFT(5),
    /**
     * Left eye looks upwards.
     */
    FT_EYE_LOOK_UP_LEFT(6),
    /**
     * Left eye looks downwards.
     */
    FT_EYE_LOOK_DOWN_LEFT(7),
    /**
     * Closes the right eyelid.
     */
    FT_EYE_CLOSED_RIGHT(8),
    /**
     * Closes the left eyelid.
     */
    FT_EYE_CLOSED_LEFT(9),
    /**
     * Squeezes the right eye socket muscles.
     */
    FT_EYE_SQUINT_RIGHT(10),
    /**
     * Squeezes the left eye socket muscles.
     */
    FT_EYE_SQUINT_LEFT(11),
    /**
     * Right eyelid widens beyond relaxed.
     */
    FT_EYE_WIDE_RIGHT(12),
    /**
     * Left eyelid widens beyond relaxed.
     */
    FT_EYE_WIDE_LEFT(13),
    /**
     * Dilates the right eye pupil.
     */
    FT_EYE_DILATION_RIGHT(14),
    /**
     * Dilates the left eye pupil.
     */
    FT_EYE_DILATION_LEFT(15),
    /**
     * Constricts the right eye pupil.
     */
    FT_EYE_CONSTRICT_RIGHT(16),
    /**
     * Constricts the left eye pupil.
     */
    FT_EYE_CONSTRICT_LEFT(17),
    /**
     * Right eyebrow pinches in.
     */
    FT_BROW_PINCH_RIGHT(18),
    /**
     * Left eyebrow pinches in.
     */
    FT_BROW_PINCH_LEFT(19),
    /**
     * Outer right eyebrow pulls down.
     */
    FT_BROW_LOWERER_RIGHT(20),
    /**
     * Outer left eyebrow pulls down.
     */
    FT_BROW_LOWERER_LEFT(21),
    /**
     * Inner right eyebrow pulls up.
     */
    FT_BROW_INNER_UP_RIGHT(22),
    /**
     * Inner left eyebrow pulls up.
     */
    FT_BROW_INNER_UP_LEFT(23),
    /**
     * Outer right eyebrow pulls up.
     */
    FT_BROW_OUTER_UP_RIGHT(24),
    /**
     * Outer left eyebrow pulls up.
     */
    FT_BROW_OUTER_UP_LEFT(25),
    /**
     * Right side face sneers.
     */
    FT_NOSE_SNEER_RIGHT(26),
    /**
     * Left side face sneers.
     */
    FT_NOSE_SNEER_LEFT(27),
    /**
     * Right side nose canal dilates.
     */
    FT_NASAL_DILATION_RIGHT(28),
    /**
     * Left side nose canal dilates.
     */
    FT_NASAL_DILATION_LEFT(29),
    /**
     * Right side nose canal constricts.
     */
    FT_NASAL_CONSTRICT_RIGHT(30),
    /**
     * Left side nose canal constricts.
     */
    FT_NASAL_CONSTRICT_LEFT(31),
    /**
     * Raises the right side cheek.
     */
    FT_CHEEK_SQUINT_RIGHT(32),
    /**
     * Raises the left side cheek.
     */
    FT_CHEEK_SQUINT_LEFT(33),
    /**
     * Puffs the right side cheek.
     */
    FT_CHEEK_PUFF_RIGHT(34),
    /**
     * Puffs the left side cheek.
     */
    FT_CHEEK_PUFF_LEFT(35),
    /**
     * Sucks in the right side cheek.
     */
    FT_CHEEK_SUCK_RIGHT(36),
    /**
     * Sucks in the left side cheek.
     */
    FT_CHEEK_SUCK_LEFT(37),
    /**
     * Opens jawbone.
     */
    FT_JAW_OPEN(38),
    /**
     * Closes the mouth.
     */
    FT_MOUTH_CLOSED(39),
    /**
     * Pushes jawbone right.
     */
    FT_JAW_RIGHT(40),
    /**
     * Pushes jawbone left.
     */
    FT_JAW_LEFT(41),
    /**
     * Pushes jawbone forward.
     */
    FT_JAW_FORWARD(42),
    /**
     * Pushes jawbone backward.
     */
    FT_JAW_BACKWARD(43),
    /**
     * Flexes jaw muscles.
     */
    FT_JAW_CLENCH(44),
    /**
     * Raises the jawbone.
     */
    FT_JAW_MANDIBLE_RAISE(45),
    /**
     * Upper right lip part tucks in the mouth.
     */
    FT_LIP_SUCK_UPPER_RIGHT(46),
    /**
     * Upper left lip part tucks in the mouth.
     */
    FT_LIP_SUCK_UPPER_LEFT(47),
    /**
     * Lower right lip part tucks in the mouth.
     */
    FT_LIP_SUCK_LOWER_RIGHT(48),
    /**
     * Lower left lip part tucks in the mouth.
     */
    FT_LIP_SUCK_LOWER_LEFT(49),
    /**
     * Right lip corner folds into the mouth.
     */
    FT_LIP_SUCK_CORNER_RIGHT(50),
    /**
     * Left lip corner folds into the mouth.
     */
    FT_LIP_SUCK_CORNER_LEFT(51),
    /**
     * Upper right lip part pushes into a funnel.
     */
    FT_LIP_FUNNEL_UPPER_RIGHT(52),
    /**
     * Upper left lip part pushes into a funnel.
     */
    FT_LIP_FUNNEL_UPPER_LEFT(53),
    /**
     * Lower right lip part pushes into a funnel.
     */
    FT_LIP_FUNNEL_LOWER_RIGHT(54),
    /**
     * Lower left lip part pushes into a funnel.
     */
    FT_LIP_FUNNEL_LOWER_LEFT(55),
    /**
     * Upper right lip part pushes outwards.
     */
    FT_LIP_PUCKER_UPPER_RIGHT(56),
    /**
     * Upper left lip part pushes outwards.
     */
    FT_LIP_PUCKER_UPPER_LEFT(57),
    /**
     * Lower right lip part pushes outwards.
     */
    FT_LIP_PUCKER_LOWER_RIGHT(58),
    /**
     * Lower left lip part pushes outwards.
     */
    FT_LIP_PUCKER_LOWER_LEFT(59),
    /**
     * Upper right part of the lip pulls up.
     */
    FT_MOUTH_UPPER_UP_RIGHT(60),
    /**
     * Upper left part of the lip pulls up.
     */
    FT_MOUTH_UPPER_UP_LEFT(61),
    /**
     * Lower right part of the lip pulls up.
     */
    FT_MOUTH_LOWER_DOWN_RIGHT(62),
    /**
     * Lower left part of the lip pulls up.
     */
    FT_MOUTH_LOWER_DOWN_LEFT(63),
    /**
     * Upper right lip part pushes in the cheek.
     */
    FT_MOUTH_UPPER_DEEPEN_RIGHT(64),
    /**
     * Upper left lip part pushes in the cheek.
     */
    FT_MOUTH_UPPER_DEEPEN_LEFT(65),
    /**
     * Moves upper lip right.
     */
    FT_MOUTH_UPPER_RIGHT(66),
    /**
     * Moves upper lip left.
     */
    FT_MOUTH_UPPER_LEFT(67),
    /**
     * Moves lower lip right.
     */
    FT_MOUTH_LOWER_RIGHT(68),
    /**
     * Moves lower lip left.
     */
    FT_MOUTH_LOWER_LEFT(69),
    /**
     * Right lip corner pulls diagonally up and out.
     */
    FT_MOUTH_CORNER_PULL_RIGHT(70),
    /**
     * Left lip corner pulls diagonally up and out.
     */
    FT_MOUTH_CORNER_PULL_LEFT(71),
    /**
     * Right corner lip slants up.
     */
    FT_MOUTH_CORNER_SLANT_RIGHT(72),
    /**
     * Left corner lip slants up.
     */
    FT_MOUTH_CORNER_SLANT_LEFT(73),
    /**
     * Right corner lip pulls down.
     */
    FT_MOUTH_FROWN_RIGHT(74),
    /**
     * Left corner lip pulls down.
     */
    FT_MOUTH_FROWN_LEFT(75),
    /**
     * Mouth corner lip pulls out and down.
     */
    FT_MOUTH_STRETCH_RIGHT(76),
    /**
     * Mouth corner lip pulls out and down.
     */
    FT_MOUTH_STRETCH_LEFT(77),
    /**
     * Right lip corner is pushed backwards.
     */
    FT_MOUTH_DIMPLE_RIGHT(78),
    /**
     * Left lip corner is pushed backwards.
     */
    FT_MOUTH_DIMPLE_LEFT(79),
    /**
     * Raises and slightly pushes out the upper mouth.
     */
    FT_MOUTH_RAISER_UPPER(80),
    /**
     * Raises and slightly pushes out the lower mouth.
     */
    FT_MOUTH_RAISER_LOWER(81),
    /**
     * Right side lips press and flatten together vertically.
     */
    FT_MOUTH_PRESS_RIGHT(82),
    /**
     * Left side lips press and flatten together vertically.
     */
    FT_MOUTH_PRESS_LEFT(83),
    /**
     * Right side lips squeeze together horizontally.
     */
    FT_MOUTH_TIGHTENER_RIGHT(84),
    /**
     * Left side lips squeeze together horizontally.
     */
    FT_MOUTH_TIGHTENER_LEFT(85),
    /**
     * Tongue visibly sticks out of the mouth.
     */
    FT_TONGUE_OUT(86),
    /**
     * Tongue points upwards.
     */
    FT_TONGUE_UP(87),
    /**
     * Tongue points downwards.
     */
    FT_TONGUE_DOWN(88),
    /**
     * Tongue points right.
     */
    FT_TONGUE_RIGHT(89),
    /**
     * Tongue points left.
     */
    FT_TONGUE_LEFT(90),
    /**
     * Sides of the tongue funnel, creating a roll.
     */
    FT_TONGUE_ROLL(91),
    /**
     * Tongue arches up then down inside the mouth.
     */
    FT_TONGUE_BLEND_DOWN(92),
    /**
     * Tongue arches down then up inside the mouth.
     */
    FT_TONGUE_CURL_UP(93),
    /**
     * Tongue squishes together and thickens.
     */
    FT_TONGUE_SQUISH(94),
    /**
     * Tongue flattens and thins out.
     */
    FT_TONGUE_FLAT(95),
    /**
     * Tongue tip rotates clockwise, with the rest following gradually.
     */
    FT_TONGUE_TWIST_RIGHT(96),
    /**
     * Tongue tip rotates counter-clockwise, with the rest following gradually.
     */
    FT_TONGUE_TWIST_LEFT(97),
    /**
     * Inner mouth throat closes.
     */
    FT_SOFT_PALATE_CLOSE(98),
    /**
     * The Adam's apple visibly swallows.
     */
    FT_THROAT_SWALLOW(99),
    /**
     * Right side neck visibly flexes.
     */
    FT_NECK_FLEX_RIGHT(100),
    /**
     * Left side neck visibly flexes.
     */
    FT_NECK_FLEX_LEFT(101),
    /**
     * Closes both eye lids.
     */
    FT_EYE_CLOSED(102),
    /**
     * Widens both eye lids.
     */
    FT_EYE_WIDE(103),
    /**
     * Squints both eye lids.
     */
    FT_EYE_SQUINT(104),
    /**
     * Dilates both pupils.
     */
    FT_EYE_DILATION(105),
    /**
     * Constricts both pupils.
     */
    FT_EYE_CONSTRICT(106),
    /**
     * Pulls the right eyebrow down and in.
     */
    FT_BROW_DOWN_RIGHT(107),
    /**
     * Pulls the left eyebrow down and in.
     */
    FT_BROW_DOWN_LEFT(108),
    /**
     * Pulls both eyebrows down and in.
     */
    FT_BROW_DOWN(109),
    /**
     * Right brow appears worried.
     */
    FT_BROW_UP_RIGHT(110),
    /**
     * Left brow appears worried.
     */
    FT_BROW_UP_LEFT(111),
    /**
     * Both brows appear worried.
     */
    FT_BROW_UP(112),
    /**
     * Entire face sneers.
     */
    FT_NOSE_SNEER(113),
    /**
     * Both nose canals dilate.
     */
    FT_NASAL_DILATION(114),
    /**
     * Both nose canals constrict.
     */
    FT_NASAL_CONSTRICT(115),
    /**
     * Puffs both cheeks.
     */
    FT_CHEEK_PUFF(116),
    /**
     * Sucks in both cheeks.
     */
    FT_CHEEK_SUCK(117),
    /**
     * Raises both cheeks.
     */
    FT_CHEEK_SQUINT(118),
    /**
     * Tucks in the upper lips.
     */
    FT_LIP_SUCK_UPPER(119),
    /**
     * Tucks in the lower lips.
     */
    FT_LIP_SUCK_LOWER(120),
    /**
     * Tucks in both lips.
     */
    FT_LIP_SUCK(121),
    /**
     * Funnels in the upper lips.
     */
    FT_LIP_FUNNEL_UPPER(122),
    /**
     * Funnels in the lower lips.
     */
    FT_LIP_FUNNEL_LOWER(123),
    /**
     * Funnels in both lips.
     */
    FT_LIP_FUNNEL(124),
    /**
     * Upper lip part pushes outwards.
     */
    FT_LIP_PUCKER_UPPER(125),
    /**
     * Lower lip part pushes outwards.
     */
    FT_LIP_PUCKER_LOWER(126),
    /**
     * Lips push outwards.
     */
    FT_LIP_PUCKER(127),
    /**
     * Raises the upper lips.
     */
    FT_MOUTH_UPPER_UP(128),
    /**
     * Lowers the lower lips.
     */
    FT_MOUTH_LOWER_DOWN(129),
    /**
     * Mouth opens, revealing teeth.
     */
    FT_MOUTH_OPEN(130),
    /**
     * Moves mouth right.
     */
    FT_MOUTH_RIGHT(131),
    /**
     * Moves mouth left.
     */
    FT_MOUTH_LEFT(132),
    /**
     * Right side of the mouth smiles.
     */
    FT_MOUTH_SMILE_RIGHT(133),
    /**
     * Left side of the mouth smiles.
     */
    FT_MOUTH_SMILE_LEFT(134),
    /**
     * Mouth expresses a smile.
     */
    FT_MOUTH_SMILE(135),
    /**
     * Right side of the mouth expresses sadness.
     */
    FT_MOUTH_SAD_RIGHT(136),
    /**
     * Left side of the mouth expresses sadness.
     */
    FT_MOUTH_SAD_LEFT(137),
    /**
     * Mouth expresses sadness.
     */
    FT_MOUTH_SAD(138),
    /**
     * Mouth stretches.
     */
    FT_MOUTH_STRETCH(139),
    /**
     * Lip corners dimple.
     */
    FT_MOUTH_DIMPLE(140),
    /**
     * Mouth tightens.
     */
    FT_MOUTH_TIGHTENER(141),
    /**
     * Mouth presses together.
     */
    FT_MOUTH_PRESS(142),
    /**
     * Represents the size of the [BlendShapeEntry] enum.
     */
    FT_MAX(143),
    ;

    public companion object {
      public fun from(`value`: Long): BlendShapeEntry = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getBlendShapeName: MethodStringName1<XRFaceTracker, Float, BlendShapeEntry> =
        MethodStringName1<XRFaceTracker, Float, BlendShapeEntry>("get_blend_shape")

    @JvmField
    public val setBlendShapeName: MethodStringName2<XRFaceTracker, Unit, BlendShapeEntry, Float> =
        MethodStringName2<XRFaceTracker, Unit, BlendShapeEntry, Float>("set_blend_shape")

    @JvmField
    public val getBlendShapesName: MethodStringName0<XRFaceTracker, PackedFloat32Array> =
        MethodStringName0<XRFaceTracker, PackedFloat32Array>("get_blend_shapes")

    @JvmField
    public val setBlendShapesName: MethodStringName1<XRFaceTracker, Unit, PackedFloat32Array> =
        MethodStringName1<XRFaceTracker, Unit, PackedFloat32Array>("set_blend_shapes")
  }

  public object MethodBindings {
    internal val getBlendShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRFaceTracker", "get_blend_shape", 330010046)

    internal val setBlendShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRFaceTracker", "set_blend_shape", 2352588791)

    internal val getBlendShapesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRFaceTracker", "get_blend_shapes", 675695659)

    internal val setBlendShapesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRFaceTracker", "set_blend_shapes", 2899603908)
  }
}
