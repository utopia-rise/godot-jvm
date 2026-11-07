@file:Suppress("RemoveRedundantBackticks")

package godot.core

import godot.common.util.PI
import godot.common.util.SQRT12
import godot.common.util.TAU
import godot.common.util.isEqualApprox
import org.junit.Test

class TestTransform2D {
    private fun degToRad(s: Double) = s * TAU / 360

    private fun createDummyTransform(): Transform2D {
        return Transform2D(Vector2(1, 2), Vector2(3, 4), Vector2(5, 6))
    }

    private fun identity(): Transform2D {
        return Transform2D()
    }

    @Test
    fun `Default valructor`() {
        val defaultConstructor = Transform2D()
        check(defaultConstructor == Transform2D(Vector2(1, 0), Vector2(0, 1), Vector2(0, 0)))
    }

    @Test
    fun `Copy valructor`() {
        val defaultConstructor = createDummyTransform()
        val copyConstructor = Transform2D(defaultConstructor)
        check(defaultConstructor == copyConstructor)
    }

    @Test
    fun `Constructor from angle and position`() {
        val rotation = PI / 4
        val translation = Vector2(20, -20)

        val test = Transform2D(rotation, translation)
        val expected = Transform2D().rotated(rotation).translated(translation)
        check(test == expected)
    }

    @Test
    fun `Constructor from angle, scale, skew and position`() {
        val rotation = PI / 2
        val scale = Vector2(2, 0.5)
        val skew = PI / 4
        val translation = Vector2(30, 0)

        val test = Transform2D(rotation, scale, skew, translation)
        val expected = Transform2D().scaled(scale).rotated(rotation).translated(translation)
        expected.setSkew(skew)

        check(test.isEqualApprox(expected))
    }

    @Test
    fun `Constructor from raw values`() {
        val test = Transform2D(1, 2, 3, 4, 5, 6)
        val expected = Transform2D(Vector2(1, 2), Vector2(3, 4), Vector2(5, 6))
        check(test == expected)
    }

    @Test
    fun `xform`() {
        val v = Vector2(2, 3)
        val T = Transform2D(Vector2(1, 2), Vector2(3, 4), Vector2(5, 6))
        val expected = Vector2(1 * 2 + 3 * 3 + 5 * 1, 2 * 2 + 4 * 3 + 6 * 1)
        check(T.xform(v) == expected)
    }

    @Test
    fun `Basis xform`() {
        val v = Vector2(2, 2)
        val T1 = Transform2D(Vector2(1, 2), Vector2(3, 4), Vector2(0, 0))

        // Both versions should be the same when the origin is (0,0).
        check(T1.basisXform(v) == T1.xform(v))

        val T2 = Transform2D(Vector2(1, 2), Vector2(3, 4), Vector2(5, 6))

        // Each version should be different when the origin is not (0,0).
        checkFalse(T2.basisXform(v) == T2.xform(v))
    }

    @Test
    fun `Affine inverse`() {
        val orig = createDummyTransform()
        val affineInverted = orig.affineInverse()
        val affineInvertedAgain = affineInverted.affineInverse()
        check(affineInvertedAgain == orig);
    }

    @Test
    fun `Orthonormalized`() {
        val T = createDummyTransform()
        val orthonormalized_T = T.orthonormalized()

        // Check each basis has length 1.
        check(orthonormalized_T._x.lengthSquared().isEqualApprox(1.0))
        check(orthonormalized_T._y.lengthSquared().isEqualApprox(1.0))

        val  vx = Vector2(orthonormalized_T._x.x, orthonormalized_T._y.x)
        val  vy = Vector2(orthonormalized_T._x.y, orthonormalized_T._y.y)

        // Check the basis are orthogonal.
        check(orthonormalized_T.tdotx(vx).isEqualApprox( 1.0))
        check(orthonormalized_T.tdotx(vy).isEqualApprox( 0.0))
        check(orthonormalized_T.tdoty(vx).isEqualApprox( 0.0))
        check(orthonormalized_T.tdoty(vy).isEqualApprox( 1.0))
    }

    @Test
    fun `Translation`() {
        val offset = Vector2(1, 2)

        // Both versions should give the same result applied to identity.
        check(identity().translated(offset) == identity().translatedLocal(offset))

        // Check both versions against left and right multiplications.
        val orig = createDummyTransform()
        val T = identity().translated(offset)
        check(orig.translated(offset) == T * orig)
        check(orig.translatedLocal(offset) == orig * T)
    }

    @Test
    fun `Scaling`() {
        val scaling = Vector2(1, 2)

        // Both versions should give the same result applied to identity.
        check(identity().scaled(scaling) == identity().scaledLocal(scaling))

        // Check both versions against left and right multiplications.
        val orig = createDummyTransform()
        val S = identity().scaled(scaling)
        check(orig.scaled(scaling) == S * orig)
        check(orig.scaledLocal(scaling) == orig * S)
    }

    @Test
    fun `Rotation`() {
        val phi = 1.0

        // Both versions should give the same result applied to identity.
        check(identity().rotated(phi) == identity().rotatedLocal(phi))

        // Check both versions against left and right multiplications.
        val orig = createDummyTransform()
        val R = identity().rotated(phi)
        check(orig.rotated(phi) == R * orig)
        check(orig.rotatedLocal(phi) == orig * R)
    }

    @Test
    fun `Interpolation`() {
        val rotateScaleSkewPos = Transform2D(
            degToRad(170.0),
            Vector2(3.6, 8.0),
            degToRad(20.0),
            Vector2(2.4, 6.8)
        )
        val rotateScaleSkewPosHalfway = Transform2D(
            degToRad(85.0),
            Vector2(2.3, 4.5),
            degToRad(10.0),
            Vector2(1.2, 3.4)
        )
        val interpolated = Transform2D().interpolateWith(rotateScaleSkewPos, 0.5)
        check(interpolated.origin.isEqualApprox(rotateScaleSkewPosHalfway.origin))
        check(interpolated.getRotation().isEqualApprox(rotateScaleSkewPosHalfway.getRotation()))
        check(interpolated.getScale().isEqualApprox(rotateScaleSkewPosHalfway.getScale()))
        check(interpolated.getSkew().isEqualApprox(rotateScaleSkewPosHalfway.getSkew()))
        check(interpolated.isEqualApprox(rotateScaleSkewPosHalfway))
        val interpolated2 = rotateScaleSkewPos.interpolateWith(Transform2D(), 0.5)
        check(interpolated2.isEqualApprox(rotateScaleSkewPosHalfway))
    }

    @Test
    fun `Finite number checks`() {
        val x = Vector2(0, 1)
        val infinite = Vector2(Double.NaN, Double.NaN)

        check(Transform2D(x, x, x).isFinite())
        checkFalse(Transform2D(infinite, x, x).isFinite())
        checkFalse(Transform2D(x, infinite, x).isFinite())
        checkFalse(Transform2D(x, x, infinite).isFinite())
        checkFalse(Transform2D(infinite, infinite, x).isFinite())
        checkFalse(Transform2D(infinite, x, infinite).isFinite())
        checkFalse(Transform2D(x, infinite, infinite).isFinite())
        checkFalse(Transform2D(infinite, infinite, infinite).isFinite())
    }


    @Test
    fun `Is conformal checks`() {
        checkMessage(
            Transform2D().isConformal()
        )
        { "Identity Transform2D should be conformal." }

        checkMessage(
            Transform2D(1.2, Vector2()).isConformal()
        ) { "Transform2D with only rotation should be conformal." }

        checkMessage(
            Transform2D(Vector2(1, 0), Vector2(0, -1), Vector2()).isConformal()
        ) { "Transform2D with only a flip should be conformal." }

        checkMessage(
            Transform2D(Vector2(1.2, 0), Vector2(0, 1.2), Vector2()).isConformal()
        ) { "Transform2D with only uniform scale should be conformal." }

        checkMessage(
            Transform2D(Vector2(1.2, 3.4), Vector2(3.4, -1.2), Vector2()).isConformal()
        ) { "Transform2D with a flip, rotation, and uniform scale should be conformal." }

        checkFalseMessage(
            Transform2D(Vector2(1.2, 0), Vector2(0, 3.4), Vector2()).isConformal()
        ) { "Transform2D with non-uniform scale should not be conformal." }

        checkFalseMessage(
            Transform2D(Vector2(SQRT12, SQRT12), Vector2(0, 1), Vector2()).isConformal()
        ) { "Transform2D with the X axis skewed 45 degrees should not be conformal." }
    }

    @Test
    fun `getScale only signs the y component for a flipped basis`() {
        val scale = Transform2D(Vector2(2, 0), Vector2(0, -3), Vector2()).getScale()
        checkMessage(scale == Vector2(2, -3)) { "Scale of a flipped basis should be (2, -3) but was $scale." }
    }

    @Test
    fun `getScale of a degenerate basis has a zero y component`() {
        val scale = Transform2D(Vector2(2, 0), Vector2(4, 0), Vector2()).getScale()
        checkMessage(scale == Vector2(2, 0)) { "Scale of a zero determinant basis should be (2, 0) but was $scale." }
    }

    @Test
    fun `isEqualApprox tolerance depends on the receiver`() {
        val a = Transform2D(Vector2(1, 0), Vector2(0, 1), Vector2(1000000.0, 0))
        val b = Transform2D(Vector2(1, 0), Vector2(0, 1), Vector2(1000010.00005, 0))
        checkFalseMessage(a.isEqualApprox(b)) { "Tolerance should come from the receiver origin." }
    }

    @Test
    fun `get returns copies`() {
        val t = createDummyTransform()
        t[0].x = 100.0
        t[1].x = 100.0
        t[2].x = 100.0
        checkMessage(t == createDummyTransform()) { "Mutating a vector returned by get should not change the transform." }
    }

    @Test
    fun `lookingAt rotates towards the target`() {
        val t = Transform2D(0.0, Vector2(1, 1)).lookingAt(Vector2(1, 3))
        val expected = Transform2D(Vector2(0, 1), Vector2(-1, 0), Vector2(1, 1))
        checkMessage(t.isEqualApprox(expected)) { "lookingAt should face (1, 3) but was $t." }
    }

    @Test
    fun `affineInverse accepts a small non zero determinant`() {
        val inverse = Transform2D().scaled(Vector2(0.002, 0.002)).affineInverse()
        checkMessage(inverse.getScale().isEqualApprox(Vector2(500, 500))) { "affineInverse scale should be 500 but was ${inverse.getScale()}." }
    }

    @Test
    fun `affineInverse of a singular transform returns an unchanged copy in debug`() {
        val singular = Transform2D(Vector2(2, 0), Vector2(4, 0), Vector2(5, 6))
        val inverse = singular.affineInverse()
        checkMessage(inverse == Transform2D(Vector2(2, 0), Vector2(4, 0), Vector2(5, 6))) { "affineInverse of a zero determinant transform should be unchanged but was $inverse." }
        checkMessage(inverse !== singular) { "affineInverse should return a copy." }
    }

    @Test
    fun `lookingAt of a singular transform does not throw in debug`() {
        Transform2D(Vector2(2, 0), Vector2(4, 0), Vector2()).lookingAt(Vector2(1, 1))
    }

    @Test
    fun `determinant is x cross y`() {
        checkMessage(createDummyTransform().determinant().isEqualApprox(-2.0)) { "determinant of (1, 2), (3, 4) should be -2." }
        checkMessage(identity().determinant().isEqualApprox(1.0)) { "determinant of identity should be 1." }
    }

    @Test
    fun `getSkew clamps acos when the unit dot rounds above one`() {
        val skew = Transform2D(Vector2(0.3, 0.9), Vector2(0.3, 0.9000000000000002), Vector2()).getSkew()
        checkMessage(skew == -PI * 0.5) { "getSkew should be -PI/2 but was $skew." }
    }

    @Test
    fun `lookingAt defaults to the origin of the coordinate system`() {
        val t = Transform2D(0.3, Vector2(1, 1))
        checkMessage(t.lookingAt() == t.lookingAt(Vector2())) { "lookingAt() should equal lookingAt(Vector2())." }
    }
}
