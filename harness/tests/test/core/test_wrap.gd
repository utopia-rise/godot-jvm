extends GdUnitTestSuite

# GD.wrapi and GD.wrapf are reimplemented on the JVM, so the engine's own wrapi and wrapf are the oracle.
# Each case is [value, min, max]. The ranges deliberately avoid min = 0 and symmetric ranges, where the
# shift of the former "value + min" bug was a multiple of the range and therefore invisible.
const INT_CASES := [
    [-6, -5, -1], # the example from the engine documentation, expected -2
    [5, 3, 10], # already inside the range
    [3, 3, 10], # on the inclusive lower bound
    [10, 3, 10], # on the exclusive upper bound
    [13, 1, 13],
    [-14, 1, 13],
    [7, 0, 3],
    [-1, 0, 3],
    [4, -5, 5],
    [12, 10, 25],
    [0, 7, 7], # empty range
    [5, 10, 3], # reversed bounds
    [-9, -3, 2],
]

const FLOAT_CASES := [
    [-6.0, -5.0, -1.0],
    [5.5, 3.0, 10.0],
    [3.0, 3.0, 10.0],
    [10.0, 3.0, 10.0],
    [12.0, 10.0, 25.0],
    [26.0, 6.0, 30.0],
    [-14.5, 1.0, 13.0],
    [-1.0e-9, 0.0, 1.0], # the result lands next to max and must snap back to min like the engine does
    [4.0, -PI, PI],
    [-7.25, -3.0, 2.0],
    [1.0, 7.0, 7.0], # empty range
    [5.0, 10.0, 3.0], # reversed bounds
]


func test_wrapi_matches_engine() -> void:
    var instance := WrapTest.new()
    for case in INT_CASES:
        var expected: int = wrapi(case[0], case[1], case[2])
        assert_int(instance.wrap_int(case[0], case[1], case[2])) \
            .override_failure_message("wrapi(Int)%s should match the engine" % [case]) \
            .is_equal(expected)
        assert_int(instance.wrap_long(case[0], case[1], case[2])) \
            .override_failure_message("wrapi(Long)%s should match the engine" % [case]) \
            .is_equal(expected)
    instance.free()


func test_wrapf_matches_engine() -> void:
    var instance := WrapTest.new()
    for case in FLOAT_CASES:
        var expected: float = wrapf(case[0], case[1], case[2])
        assert_float(instance.wrap_double(case[0], case[1], case[2])) \
            .override_failure_message("wrapf(Double)%s should match the engine" % [case]) \
            .is_equal_approx(expected, 1.0e-9)
        assert_float(instance.wrap_float(case[0], case[1], case[2])) \
            .override_failure_message("wrapf(Float)%s should match the engine" % [case]) \
            .is_equal_approx(expected, 1.0e-5)
    instance.free()
