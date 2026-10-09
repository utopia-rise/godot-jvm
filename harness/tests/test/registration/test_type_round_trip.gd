extends GdUnitTestSuite


func _assert_round_trips(script: Node) -> void:
    assert_that(script.echo_bit_field(5)).override_failure_message("A BitField argument and return value should round-trip").is_equal(5)
    assert_that(script.echo_bit_field(1 << 40)).override_failure_message("A BitField argument should keep all 64 bits").is_equal(1 << 40)
    assert_that(script.bit_field_callable.call(6)).override_failure_message("A lambda with a BitField parameter should receive the flags").is_equal(6)

    var received := []
    script.bit_field_signal.connect(func(value): received.append(value))
    script.emit_bit_field(7)
    assert_that(received).override_failure_message("A BitField signal argument should be emitted as its flags").is_equal([7])

    script.flag_list = [1, 0, 1]
    assert_that(str(script.flag_list)).override_failure_message("An enum List property should keep order and duplicates").is_equal("[1, 0, 1]")

    assert_that(script.read_only_count).override_failure_message("A read-only property should be readable").is_equal(7)
    assert_that(str(script.read_only_flag_list)).override_failure_message("A read-only enum List property should be readable").is_equal("[1]")
    assert_that(script.read_only_bit_field).override_failure_message("A read-only BitField property should be readable").is_equal(3)

    assert_bool(script.aliased_engine_enum_round_trips()).override_failure_message("An engine enum value shared by two entries should decode to the first one").is_true()

    script.free()


func test_kotlin_type_round_trip() -> void:
    _assert_round_trips(TypeRoundTripKotlin.new())


func test_java_type_round_trip() -> void:
    _assert_round_trips(TypeRoundTripJava.new())


func test_scala_type_round_trip() -> void:
    _assert_round_trips(TypeRoundTripScala.new())
