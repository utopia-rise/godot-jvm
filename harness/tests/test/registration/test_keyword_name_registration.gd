extends GdUnitTestSuite

func test_keyword_named_property():
	var script := KeywordNameRegistration.new()
	assert_that(script.object).is_equal(1)
	script.object = 3
	assert_that(script.object).is_equal(3)
	script.free()


func test_keyword_named_function():
	var script := KeywordNameRegistration.new()
	assert_that(script.throw(21)).is_equal(42)
	script.free()
