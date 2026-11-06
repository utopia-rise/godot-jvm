@file:Suppress("RemoveRedundantBackticks")

package godot.core

import godot.common.util.isEqualApprox
import org.junit.Test

class TestAABB {

    @Test
    fun `Constructor methods`() {
        val aabb = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0))
        val aabbCopy = AABB(aabb)

        checkMessage(aabb == aabbCopy) { "AABBs created with the same dimensions but by different methods should be equal." }
    }

    @Test
    fun `String conversion`() {
        val aabbString = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0)).toString()
        checkMessage(aabbString == "[P: (-1.5, 2.0, -2.5), S: (4.0, 5.0, 6.0)]") { "The string representation should match the expected value." }
    }

    @Test
    fun `Basic getters`() {
        val aabb = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0))
        checkMessage(
            aabb.position.isEqualApprox(
                Vector3(
                    -1.5,
                    2.0,
                    -2.5
                )
            )
        ) { "get_position() should return the expected value." }
        checkMessage(aabb.size.isEqualApprox(Vector3(4.0, 5.0, 6.0))) { "get_size() should return the expected value." }
        checkMessage(aabb.end.isEqualApprox(Vector3(2.5, 7.0, 3.5))) { "get_end() should return the expected value." }
        checkMessage(
            aabb.getCenter().isEqualApprox(Vector3(0.5, 4.5, 0.5))
        ) { "get_center() should return the expected value." }
    }

    @Test
    fun `Basic setters`() {
        var aabb = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0))
        aabb.end = Vector3(100.0, 0.0, 100.0)
        checkMessage(
            aabb.isEqualApprox(
                AABB(
                    Vector3(-1.5, 2.0, -2.5),
                    Vector3(101.5, -2.0, 102.5)
                )
            )
        ) { "set_end() should result in the expected AABB." }

        aabb = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0))
        aabb.position = Vector3(-1000.0, -2000.0, -3000.0)
        checkMessage(
            aabb.isEqualApprox(
                AABB(
                    Vector3(-1000.0, -2000.0, -3000.0),
                    Vector3(4.0, 5.0, 6.0)
                )
            )
        ) { "set_position() should result in the expected AABB." }

        aabb = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0))
        aabb.size = Vector3(0.0, 0.0, -50.0)
        checkMessage(
            aabb.isEqualApprox(
                AABB(
                    Vector3(-1.5, 2.0, -2.5),
                    Vector3(0.0, 0.0, -50.0)
                )
            )
        ) { "set_size() should result in the expected AABB." }
    }

    @Test
    fun `Volume getters`() {
        val aabb = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0))
        checkMessage(aabb.getVolume().isEqualApprox(120.0)) { "get_volume() should return the expected value with positive size." }
        checkMessage(aabb.hasVolume()) { "Non-empty volumetric AABB should have a volume." }

        val aabbNegativeX = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(-4.0, 5.0, 6.0))
        checkMessage(aabbNegativeX.getVolume().isEqualApprox(-120.0)) { "get_volume() should return the expected value with negative size (1 component)." }

        val aabbNegativeXY = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(-4.0, -5.0, 6.0))
        checkMessage(aabbNegativeXY.getVolume().isEqualApprox(120.0)) { "get_volume() should return the expected value with negative size (2 components)." }

        val aabbNegativeXYZ = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(-4.0, -5.0, -6.0))
        checkMessage(aabbNegativeXYZ.getVolume().isEqualApprox(-120.0)) { "get_volume() should return the expected value with negative size (3 components)." }

        val aabbFlat = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 0.0, 6.0))
        checkMessage(!aabbFlat.hasVolume()) { "Non-empty flat AABB should not have a volume." }

        checkMessage(!AABB().hasVolume()) { "Empty AABB should not have a volume." }
    }

    @Test
    fun `Surface getters`() {
        val aabb = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0))
        checkMessage(aabb.hasSurface()) { "Non-empty volumetric AABB should have a surface." }

        val aabbFlatY = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 0.0, 6.0))
        checkMessage(aabbFlatY.hasSurface()) { "Non-empty flat AABB should have a surface." }

        val aabbFlatXZ = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 0.0, 0.0))
        checkMessage(aabbFlatXZ.hasSurface()) { "Non-empty linear AABB should have a surface." }

        checkMessage(!AABB().hasSurface()) { "Empty AABB should not have a surface." }
    }

    @Test
    fun `Intersection`() {
        val aabbBig = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0))

        val aabbSmall1 = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(1.0, 1.0, 1.0))
        checkMessage(aabbBig.intersects(aabbSmall1)) { "intersects() with fully contained AABB (touching the edge) should return the expected result." }

        val aabbSmall2 = AABB(Vector3(0.5, 1.5, -2.0), Vector3(1.0, 1.0, 1.0))
        checkMessage(aabbBig.intersects(aabbSmall2)) { "intersects() with partially contained AABB (overflowing on Y axis) should return the expected result." }

        val aabbSmall3 = AABB(Vector3(10.0, -10.0, -10.0), Vector3(1.0, 1.0, 1.0))
        checkMessage(!aabbBig.intersects(aabbSmall3)) { "intersects() with non-contained AABB should return the expected result." }

        checkMessage(
            aabbBig.intersection(aabbSmall1).isEqualApprox(aabbSmall1)
        ) { "intersection() with fully contained AABB (touching the edge) should return the expected result." }

        val expectedAabb = AABB(Vector3(0.5, 2.0, -2.0), Vector3(1.0, 0.5, 1.0))
        checkMessage(
            aabbBig.intersection(aabbSmall2).isEqualApprox(expectedAabb)
        ) { "intersection() with partially contained AABB (overflowing on Y axis) should return the expected result." }

        val aabbSmall4 = AABB(Vector3(10.0, -10.0, -10.0), Vector3(1.0, 1.0, 1.0))
        checkMessage(
            aabbBig.intersection(aabbSmall4).isEqualApprox(AABB())
        ) { "intersection() with non-contained AABB should return the expected result." }

        checkMessage(
            aabbBig.intersectsPlane(
                Plane(
                    Vector3(0.0, 1.0, 0.0),
                    4.0
                )
            )
        ) { "intersects_plane() should return the expected result." }
        checkMessage(
            aabbBig.intersectsPlane(
                Plane(
                    Vector3(0.0, -1.0, 0.0),
                    -4.0
                )
            )
        ) { "intersects_plane() should return the expected result." }

        checkMessage(
            !aabbBig.intersectsPlane(
                Plane(
                    Vector3(0.0, 1.0, 0.0),
                    200.0
                )
            )
        ) { "intersects_plane() should return the expected result." }

        checkMessage(
            aabbBig.intersectsSegment(
                Vector3(1.0, 3.0, 0.0),
                Vector3(0.0, 3.0, 0.0)
            ) != null
        ) { "intersects_segment() should return the expected result." }

        checkMessage(
            aabbBig.intersectsSegment(
                Vector3(0.0, 3.0, 0.0),
                Vector3(0.0, -300.0, 0.0)
            ) != null
        ) { "intersects_segment() should return the expected result." }

        checkMessage(
            aabbBig.intersectsSegment(
                Vector3(-50.0, 3.0, -50.0),
                Vector3(50.0, 3.0, 50.0)
            ) != null
        ) { "intersects_segment() should return the expected result." }

        checkMessage(
            aabbBig.intersectsSegment(
                Vector3(-50.0, 25.0, -50.0),
                Vector3(50.0, 25.0, 50.0)
            ) == null
        ) { "intersects_segment() should return the expected result." }

        checkMessage(
            aabbBig.intersectsSegment(
                Vector3(0.0, 3.0, 0.0),
                Vector3(0.0, 3.0, 0.0)
            ) != null
        ) { "intersects_segment() should return the expected result with a segment of length 0." }

        checkMessage(
            aabbBig.intersectsSegment(
                Vector3(0.0, 300.0, 0.0),
                Vector3(0.0, 300.0, 0.0)
            ) == null
        ) { "intersects_segment() should return the expected result with a segment of length 0." }

        // Simple ray intersection test.
        checkMessage(aabbBig.intersectsRay(Vector3(-100, 3, 0), Vector3(1, 0, 0)) != null)
        { "intersectsRay() should return true when ray points directly to AABB from outside." }
        // Ray parallel to an edge.
        checkMessage(aabbBig.intersectsRay(Vector3(10, 10, 0), Vector3(0, 1, 0)) == null)
        { "intersectsRay() should return false for ray parallel and outside of AABB." }
        // Ray origin inside aabb.
        checkMessage(aabbBig.intersectsRay(Vector3(1, 1, 1), Vector3(0, 1, 0)) != null)
        { "intersectsRay() should return true for rays originating inside the AABB." }
        // Ray pointing away from aabb.
        checkMessage(aabbBig.intersectsRay(Vector3(-10, 0, 0), Vector3(-1, 0, 0)) == null)
        { "intersectsRay() should return false when ray points away from AABB." }
        // Ray along a diagonal of aabb.
        checkMessage(aabbBig.intersectsRay(Vector3(0, 0, 0), Vector3(1, 1, 1)) != null)
        { "intersectsRay() should return true for rays along the AABB diagonal." }
        // Ray originating at aabb edge.
        checkMessage(aabbBig.intersectsRay(aabbBig.position, Vector3(-1, 0, 0)) != null)
        { "intersectsRay() should return true for rays starting on AABB's edge." }
        // Ray with zero direction inside.
        checkMessage(aabbBig.intersectsRay(Vector3(-1, 3, -2), Vector3(0, 0, 0)) != null)
        { "intersectsRay() should return true because its inside." }
        // Ray with zero direction outside.
        checkMessage(aabbBig.intersectsRay(Vector3(-1000, 3, -2), Vector3(0, 0, 0)) == null)
        { "intersectsRay() should return false for being outside." }

        // Finding ray intersections.
        val aabbSimple = AABB(Vector3(), Vector3(1, 1, 1))

        // Borders.
        var intersectionPoint = aabbSimple.intersectsRay(Vector3(0.5, 0, 0.5), Vector3(0, 1, 0))!!
        checkMessage(intersectionPoint.isEqualApprox(Vector3(0.5, 0, 0.5))) { "find_intersectsRay() border intersection point incorrect." }

        intersectionPoint = aabbSimple.intersectsRay(Vector3(0.5, 1, 0.5), Vector3(0, -1, 0))!!
        checkMessage(intersectionPoint.isEqualApprox(Vector3(0.5, 1, 0.5))) { "find_intersectsRay() border intersection point incorrect." }

        // Inside.
        intersectionPoint = aabbSimple.intersectsRay(Vector3(0.5, 0, 0.5), Vector3(0, 1, 0))!!
        checkMessage(intersectionPoint.isEqualApprox(Vector3(0.5, 0, 0.5))) { "find_intersectsRay() inside backtracking intersection point incorrect." }

        // Zero sized AABB.
        val aabbZero = AABB(Vector3(), Vector3(1, 0, 1));

        intersectionPoint = aabbZero.intersectsRay(Vector3(0.5, 0, 0.5), Vector3(0, 1, 0))!!
        checkMessage(intersectionPoint.isEqualApprox(Vector3(0.5, 0, 0.5))) { "find_intersectsRay() border intersection point incorrect for zero sized AABB." }

        intersectionPoint = aabbZero.intersectsRay(Vector3(0.5, 0, 0.5), Vector3(0, -1, 0))!!
        checkMessage(intersectionPoint.isEqualApprox(Vector3(0.5, 0, 0.5))) { "find_intersectsRay() border intersection point incorrect for zero sized AABB." }

        intersectionPoint = aabbZero.intersectsRay(Vector3(0.5, -1, 0.5), Vector3(0, 1, 0))!!
        checkMessage(intersectionPoint.isEqualApprox(Vector3(0.5, 0, 0.5))) { "find_intersectsRay() border intersection point incorrect for zero sized AABB." }
    }

    @Test
    fun `Merging`() {
        val aabbBig = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0))

        val aabbSmall1 = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(1.0, 1.0, 1.0))
        checkMessage(
            aabbBig.merge(aabbSmall1).isEqualApprox(aabbBig)
        ) { "merge() with fully contained AABB (touching the edge) should return the expected result." }

        val aabbSmall2 = AABB(Vector3(0.5, 1.5, -2.0), Vector3(1.0, 1.0, 1.0))
        val expectedMergedAabb = AABB(Vector3(-1.5, 1.5, -2.5), Vector3(4.0, 5.5, 6.0))
        checkMessage(
            aabbBig.merge(aabbSmall2).isEqualApprox(expectedMergedAabb)
        ) { "merge() with partially contained AABB (overflowing on Y axis) should return the expected result." }

        val aabbSmall3 = AABB(Vector3(10.0, -10.0, -10.0), Vector3(1.0, 1.0, 1.0))
        val expectedMergedAabb2 = AABB(Vector3(-1.5, -10.0, -10.0), Vector3(12.5, 17.0, 13.5))
        checkMessage(
            aabbBig.merge(aabbSmall3).isEqualApprox(expectedMergedAabb2)
        ) { "merge() with non-contained AABB should return the expected result." }
    }


    @Test
    fun `Encloses`() {
        val aabbBig = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0))

        checkMessage(aabbBig.encloses(aabbBig)) {
            "encloses() with itself should return the expected result."
        }


        var aabbSmall1 = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(1.0, 1.0, 1.0))
        checkMessage(aabbBig.encloses(aabbSmall1)) { "encloses() with fully contained AABB (touching the edge) should return the expected result." }

        aabbSmall1 = AABB(Vector3(1.5, 6, 2.5), Vector3(1, 1, 1));
        checkMessage(aabbBig.encloses(aabbSmall1)) {
            "encloses() with fully contained AABB (touching the edge) should return the expected result."
        }


        val aabbSmall2 = AABB(Vector3(0.5, 1.5, -2.0), Vector3(1.0, 1.0, 1.0))
        checkMessage(!aabbBig.encloses(aabbSmall2)) { "encloses() with partially contained AABB (overflowing on Y axis) should return the expected result." }

        val aabbSmall3 = AABB(Vector3(10.0, -10.0, -10.0), Vector3(1.0, 1.0, 1.0))
        checkMessage(!aabbBig.encloses(aabbSmall3)) { "encloses() with non-contained AABB should return the expected result." }
    }


    @Test
    fun `Get endpoints`() {
        val aabb = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0))
        checkMessage(aabb.getEndpoint(0).isEqualApprox(Vector3(-1.5, 2.0, -2.5))) { "The endpoint at index 0 should match the expected value." }
        checkMessage(aabb.getEndpoint(1).isEqualApprox(Vector3(-1.5, 2.0, 3.5))) { "The endpoint at index 1 should match the expected value." }
        checkMessage(aabb.getEndpoint(2).isEqualApprox(Vector3(-1.5, 7.0, -2.5))) { "The endpoint at index 2 should match the expected value." }
        checkMessage(aabb.getEndpoint(3).isEqualApprox(Vector3(-1.5, 7.0, 3.5))) { "The endpoint at index 3 should match the expected value." }
        checkMessage(aabb.getEndpoint(4).isEqualApprox(Vector3(2.5, 2.0, -2.5))) { "The endpoint at index 4 should match the expected value." }
        checkMessage(aabb.getEndpoint(5).isEqualApprox(Vector3(2.5, 2.0, 3.5))) { "The endpoint at index 5 should match the expected value." }
        checkMessage(aabb.getEndpoint(6).isEqualApprox(Vector3(2.5, 7.0, -2.5))) { "The endpoint at index 6 should match the expected value." }
        checkMessage(aabb.getEndpoint(7).isEqualApprox(Vector3(2.5, 7.0, 3.5))) { "The endpoint at index 7 should match the expected value." }
        checkMessage(aabb.getEndpoint(8).isEqualApprox(Vector3())) { "The endpoint at invalid index 8 should match the expected value." }
        checkMessage(aabb.getEndpoint(-1).isEqualApprox(Vector3())) { "The endpoint at invalid index -1 should match the expected value." }
    }

    @Test
    fun `Get longest and shortest axis`() {
        val aabb = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0))
        checkMessage(aabb.getLongestAxisVector() == (Vector3(0.0, 0.0, 1.0))) { "get_longest_axis() should return the expected value." }
        checkMessage(aabb.getLongestAxis() == Vector3.Axis.Z) { "get_longest_axis_index() should return the expected value." }
        checkMessage(aabb.getLongestAxisSize() == 6.0) { "get_longest_axis_size() should return the expected value." }

        checkMessage(aabb.getShortestAxisVector() == (Vector3(1.0, 0.0, 0.0))) { "get_shortest_axis() should return the expected value." }
        checkMessage(aabb.getShortestAxis() == Vector3.Axis.X) { "get_shortest_axis_index() should return the expected value." }
        checkMessage(aabb.getShortestAxisSize() == 4.0) { "get_shortest_axis_size() should return the expected value." }
    }

    @Test
    fun `Get support`() {
        val aabb = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0))
        checkMessage(aabb.getSupport(Vector3(1.0, 0.0, 0.0)).isEqualApprox(Vector3(2.5, 2.0, -2.5))) { "get_support() should return the expected value." }
        checkMessage(aabb.getSupport(Vector3(0.5, 1.0, 0.0)).isEqualApprox(Vector3(2.5, 7.0, -2.5))) { "get_support() should return the expected value." }
        checkMessage(aabb.getSupport(Vector3(0.5, 1.0, -400.0)).isEqualApprox(Vector3(2.5, 7.0, -2.5))) { "get_support() should return the expected value." }
        checkMessage(aabb.getSupport(Vector3(0.0, -1.0, 0.0)).isEqualApprox(Vector3(-1.5, 2.0, -2.5))) { "get_support() should return the expected value." }
        checkMessage(aabb.getSupport(Vector3(0.0, -0.1, 0.0)).isEqualApprox(Vector3(-1.5, 2.0, -2.5))) { "get_support() should return the expected value." }
        checkMessage(
            aabb.getSupport(Vector3()).isEqualApprox(Vector3(-1.5, 2.0, -2.5))
        ) { "get_support() should return the expected value with a null vector." }
    }

    @Test
    fun `Grow`() {
        val aabb = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0))
        checkMessage(
            aabb.grow(0.25).isEqualApprox(AABB(Vector3(-1.75, 1.75, -2.75), Vector3(4.5, 5.5, 6.5)))
        ) { "grow() with positive value should return the expected AABB." }
        checkMessage(
            aabb.grow(-0.25).isEqualApprox(AABB(Vector3(-1.25, 2.25, -2.25), Vector3(3.5, 4.5, 5.5)))
        ) { "grow() with negative value should return the expected AABB." }
        checkMessage(
            aabb.grow(-10.0).isEqualApprox(AABB(Vector3(8.5, 12.0, 7.5), Vector3(-16.0, -15.0, -14.0)))
        ) { "grow() with large negative value should return the expected AABB." }
    }

    @Test
    fun `Has point`() {
        val aabb = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0))
        checkMessage(aabb.hasPoint(Vector3(-1.0, 3.0, 0.0))) { "hasPoint() with contained point should return the expected value." }
        checkMessage(aabb.hasPoint(Vector3(2.0, 3.0, 0.0))) { "hasPoint() with contained point should return the expected value." }
        checkMessage(!aabb.hasPoint(Vector3(-20.0, 0.0, 0.0))) { "hasPoint() with non-contained point should return the expected value." }

        checkMessage(aabb.hasPoint(Vector3(-1.5, 3.0, 0.0))) { "hasPoint() with positive size should include point on the near face (X axis)." }
        checkMessage(aabb.hasPoint(Vector3(2.5, 3.0, 0.0))) { "hasPoint() with positive size should include point on the far face (X axis)." }
        checkMessage(aabb.hasPoint(Vector3(0.0, 2.0, 0.0))) { "hasPoint() with positive size should include point on the near face (Y axis)." }
        checkMessage(aabb.hasPoint(Vector3(0.0, 7.0, 0.0))) { "hasPoint() with positive size should include point on the far face (Y axis)." }
        checkMessage(aabb.hasPoint(Vector3(0.0, 3.0, -2.5))) { "hasPoint() with positive size should include point on the near face (Z axis)." }
        checkMessage(aabb.hasPoint(Vector3(0.0, 3.0, 3.5))) { "hasPoint() with positive size should include point on the far face (Z axis)." }
    }

    @Test
    fun `Expanding`() {
        val aabb = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0))
        checkMessage(aabb.expand(Vector3(-1.0, 3.0, 0.0)).isEqualApprox(aabb)) { "expand() with contained point should return the expected AABB." }
        checkMessage(aabb.expand(Vector3(2.0, 3.0, 0.0)).isEqualApprox(aabb)) { "expand() with contained point should return the expected AABB." }
        checkMessage(
            aabb.expand(Vector3(-1.5, 3.0, 0.0)).isEqualApprox(aabb)
        ) { "expand() with contained point on negative edge should return the expected AABB." }
        checkMessage(
            aabb.expand(Vector3(2.5, 3.0, 0.0)).isEqualApprox(aabb)
        ) { "expand() with contained point on positive edge should return the expected AABB." }
        checkMessage(aabb.expand(Vector3(-20.0, 0.0, 0.0)).isEqualApprox(AABB(Vector3(-20.0, 0.0, -2.5), Vector3(22.5, 7.0, 6.0)))) {
            "expand() with non-contained point should return the expected AABB."
        }
    }

    @Test
    fun `Finite number checks`() {
        val x = Vector3(0.0, 1.0, 2.0)
        val infinite = Vector3(Double.NaN, Double.NaN, Double.NaN)

        checkMessage(AABB(x, x).isFinite()) { "AABB with all components finite should be finite" }
        checkFalseMessage(AABB(infinite, x).isFinite()) { "AABB with one component infinite should not be finite." }
        checkFalseMessage(AABB(x, infinite).isFinite()) { "AABB with one component infinite should not be finite." }
        checkFalseMessage(AABB(infinite, infinite).isFinite()) { "AABB with two components infinite should not be finite." }
    }

    @Test
    fun `Ray origin inside returns the origin`() {
        val aabb = AABB(Vector3(), Vector3(2, 2, 2))
        val from = Vector3(1, 1, 1)
        val hit = aabb.intersectsRay(from, Vector3(0, 1, 0))!!
        checkMessage(hit == Vector3(1, 1, 1)) { "intersectsRay() from inside should return the ray origin, not the backtracked point." }
        checkMessage(hit !== from) { "intersectsRay() should not return its argument." }
    }

    @Test
    fun `Invalid endpoint index returns the fallback`() {
        val aabb = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0))
        checkMessage(aabb.getEndpoint(8) == Vector3()) { "getEndpoint() with index 8 should return Vector3()." }
        checkMessage(aabb.getEndpoint(-1) == Vector3()) { "getEndpoint() with index -1 should return Vector3()." }
    }

    @Test
    fun `Negative size still computes the normal result`() {
        val negative = AABB(Vector3(0, 0, 0), Vector3(-1, 1, 1))
        val unit = AABB(Vector3(0, 0, 0), Vector3(1, 1, 1))

        checkFalseMessage(negative.hasPoint(Vector3(-0.5, 0.5, 0.5))) { "hasPoint() should still return its normal result." }
        checkFalseMessage(negative.intersects(unit)) { "intersects() should still return its normal result." }
        checkFalseMessage(negative.encloses(unit)) { "encloses() should still return its normal result." }
        checkMessage(negative.intersection(unit) == AABB()) { "intersection() should still return its normal result." }
        checkMessage(negative.merge(unit) == unit) { "merge() should still return its normal result." }
        checkMessage(
            negative.expand(Vector3(2.0, 0.5, 0.5)) == AABB(Vector3(0, 0, 0), Vector3(2, 1, 1))
        ) { "expand() should still return its normal result." }
        checkMessage(
            negative.intersectsRay(Vector3(-5.0, 0.5, 0.5), Vector3(1, 0, 0)) == Vector3(0.0, 0.5, 0.5)
        ) { "intersectsRay() should still return its normal result." }
        checkMessage(
            negative.intersectsSegment(Vector3(-5.0, 0.5, 0.5), Vector3(5.0, 0.5, 0.5)) == null
        ) { "intersectsSegment() should still return its normal result." }
    }

    @Test
    fun `Longest and shortest axis index`() {
        val aabb = AABB(Vector3(-1.5, 2.0, -2.5), Vector3(4.0, 5.0, 6.0))
        checkMessage(aabb.getLongestAxisIndex() == 2) { "get_longest_axis_index() should return 2." }
        checkMessage(aabb.getShortestAxisIndex() == 0) { "get_shortest_axis_index() should return 0." }
    }

}
