extends GdUnitTestSuite

var short_str: String = "Short String"

#A string of 511 character a so we obtain a 512 long string, the maximun size of the buffer.
#Change this value with the default value in LongStringQueue.kt and long_string_queue.cpp
var longest_short_str: String = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"

# Length of the previous string + 1
var shortest_long_str: String = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"

var long_str: String = """I'll pivot the lazy YAML middleware, that should abstraction the DAG virtual DOM!

The HTML stack is down, store the stateless Imagemagick so we can lazy eval the JSON Stack Overflow!

You can't mock the convention without gate-keeping the mobile YAML Kubernetes!

Try to pivot the YAML Slack, maybe it will sort the reliable service worker!

You can't transact the CS degree without gate-keeping the idiosyncratic UX website!

I'll optimize the object-oriented DOM state, that should open source the API abstraction!

So bubble-sorting the Stack Overflow won't do anything, we need to graph the minimum viable FIFO algorithm!

The OOP module is down, configure the behavior-driven context so we can inherit the DOM neck beard!

The SOAP middleware is down, f*** the serverless stream so we can circle back the LGTM constant!

You can't ship the continuous integration without blogging the junior IoT Stack Overflow!"""


func test_short_string() -> void:
    var script: Object = StringTest.new()
    assert_that(short_str).override_failure_message("String on JVM side should be same as gdscript one.").is_equal(script.get_short_string())
    assert_that(short_str).override_failure_message("String on JVM side should be same as gdscript one.").is_equal(script.identity(short_str))
    assert_that(script.fill_the_buffer(short_str, short_str, short_str, short_str, short_str)).override_failure_message("Should return true when buffer is filled").is_equal(true)
    assert_that(script.mix_string_and_variant(1, short_str, Vector2(1,1), short_str, 1.0)).override_failure_message("Should return true when buffer is filled").is_equal(true)
    script.free()
    
func test_longest_short_string() -> void:
    var script: Object = StringTest.new()
    assert_that(longest_short_str).override_failure_message("String on JVM side should be same as gdscript one.").is_equal(script.get_longest_short_string())
    assert_that(longest_short_str).override_failure_message("String on JVM side should be same as gdscript one.").is_equal(script.identity(longest_short_str))
    assert_that(script.fill_the_buffer(longest_short_str, longest_short_str, longest_short_str, longest_short_str, longest_short_str)).override_failure_message("Should return true when buffer is filled").is_equal(true)
    assert_that(script.mix_string_and_variant(1, longest_short_str, Vector2(1,1), longest_short_str, 1.0)).override_failure_message("Should return true when buffer is filled").is_equal(true)
    script.free()

func test_shortest_long_string() -> void:
    var script: Object = StringTest.new()
    assert_that(shortest_long_str).override_failure_message("String on JVM side should be same as gdscript one.").is_equal(script.get_shortest_long_string())
    assert_that(shortest_long_str).override_failure_message("String on JVM side should be same as gdscript one.").is_equal(script.identity(shortest_long_str))
    assert_that(script.fill_the_buffer(shortest_long_str, shortest_long_str, shortest_long_str, shortest_long_str, shortest_long_str)).override_failure_message("Should return true when buffer is filled").is_equal( true)
    assert_that(script.mix_string_and_variant(1, shortest_long_str, Vector2(1,1), shortest_long_str, 1.0)).override_failure_message("Should return true when buffer is filled").is_equal(true)
    script.free()

# TODO: enable again after fixed for windows!
#func test_long_string() -> void:
#	var script = StringTest.new()
#	assert_that(long_str).override_failure_message("String on JVM side should be same as gdscript one.").is_equal(script.get_long_string())
#	assert_that(long_str).override_failure_message("String on JVM side should be same as gdscript one.").is_equal(script.identity(long_str))
#	assert_that(script.fill_the_buffer(long_str).override_failure_message("Should return true when buffer is filled").is_equal(long_str, long_str, long_str, long_str), true)
#	assert_that(script.mix_string_and_variant(1).override_failure_message("Should return true when buffer is filled").is_equal(long_str, Vector2(1,1), long_str, 1.0), true)
#	script.free()

# U+1F600, built from the code point rather than written literally so the encoding of this file is not what the test
# measures. Four bytes in the standard UTF-8 Godot speaks; JNI's modified UTF-8 has no four byte form and encodes the
# UTF-16 surrogate pair as two three byte sequences instead.
var supplementary: String = char(0x1F600)

# Short enough to travel inline in the shared buffer as raw UTF-8 bytes, which never reaches a JNI string function.
func test_short_supplementary_character() -> void:
    var script: Object = StringTest.new()
    var expected: String = short_str + supplementary
    assert_that(expected.to_utf8_buffer().size()).override_failure_message("This string must stay under the inline limit to exercise the buffer path.").is_less_equal(512)
    assert_that(script.get_short_supplementary()).override_failure_message("A supplementary character should survive the JVM to Godot crossing.").is_equal(expected)
    assert_that(script.identity(expected)).override_failure_message("A supplementary character should survive a round trip through the JVM.").is_equal(expected)
    assert_that(script.get_length(expected)).override_failure_message("The JVM should see the character as one surrogate pair, so one more UTF-16 unit than Godot counts code points.").is_equal(expected.length() + 1)
    script.free()

# Past the inline limit, so it crosses through LongStringQueue and therefore through NewStringUTF/GetStringUTFChars.
func test_long_supplementary_character() -> void:
    var script: Object = StringTest.new()
    var expected: String = long_str + supplementary
    assert_that(expected.to_utf8_buffer().size()).override_failure_message("This string must exceed the inline limit to exercise the JNI string queue.").is_greater(512)
    assert_that(script.get_long_supplementary()).override_failure_message("A supplementary character should survive the JVM to Godot crossing in a long string.").is_equal(expected)
    assert_that(script.identity(expected)).override_failure_message("A supplementary character should survive a round trip through the JVM in a long string.").is_equal(expected)
    assert_that(script.get_length(expected)).override_failure_message("The JVM should see the character as one surrogate pair, so one more UTF-16 unit than Godot counts code points.").is_equal(expected.length() + 1)
    script.free()

func test_string_length() -> void:
    var script = StringTest.new()
    assert_that(script.get_length("")).override_failure_message("Should return the right size of the string").is_equal(0)
    assert_that(script.get_length("A")).override_failure_message("Should return the right size of the string").is_equal(1)
    assert_that(script.get_length("abcde")).override_failure_message("Should return the right size of the string").is_equal(5)
    assert_that("").override_failure_message("String on JVM side should be same as gdscript one.").is_equal(script.identity(""))
    assert_that("A").override_failure_message("String on JVM side should be same as gdscript one.").is_equal(script.identity("A"))
    script.free()

func test_string_as_string_name() -> void:
    var script = StringTest.new()
    assert_that(script.get_as_string_name("test1")).override_failure_message("Should return the same StringName instance").is_equal(script.get_as_string_name("test1"))
    assert_that(script.get_as_string_name("test1")).override_failure_message("Should return the different StringName instances").is_not_equal(script.get_as_string_name("test2"))
    script.free()
