package godot.tests.core

import godot.api.Node
import godot.annotation.Script
import godot.annotation.Register
import godot.core.asStringName
import godot.core.Vector2

@Script
class StringTest : Node() {

    private val _shortString = "Short String"

    /**
     * A string of 511 character a so we obtain a 512 long string, the maximun size of the buffer.
     * Change this value with the default value in LongStringQueue.kt and long_string_queue.cpp
     */
    private val _longestShortString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"

    /**
    Length of the previous string + 1
    */
    private val _shortestLongString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"

    private val _longString = """
        I'll pivot the lazy YAML middleware, that should abstraction the DAG virtual DOM!
        
        The HTML stack is down, store the stateless Imagemagick so we can lazy eval the JSON Stack Overflow!
        
        You can't mock the convention without gate-keeping the mobile YAML Kubernetes!
        
        Try to pivot the YAML Slack, maybe it will sort the reliable service worker!
        
        You can't transact the CS degree without gate-keeping the idiosyncratic UX website!
        
        I'll optimize the object-oriented DOM state, that should open source the API abstraction!
        
        So bubble-sorting the Stack Overflow won't do anything, we need to graph the minimum viable FIFO algorithm!
        
        The OOP module is down, configure the behavior-driven context so we can inherit the DOM neck beard!
        
        The SOAP middleware is down, f*** the serverless stream so we can circle back the LGTM constant!
        
        You can't ship the continuous integration without blogging the junior IoT Stack Overflow!
        """.trimIndent()


    /**
     * U+1F600. Four bytes in the standard UTF-8 Godot speaks, and a surrogate pair in UTF-16, which JNI's modified
     * UTF-8 encodes as two three-byte sequences. Built from the code point so the encoding of this file is not what
     * the test ends up measuring.
     */
    private val _supplementary = String(Character.toChars(0x1F600))

    private val _shortSupplementary = _shortString + _supplementary

    /** Padded past LongStringQueue's limit, so it crosses through the JNI string queue instead of the buffer. */
    private val _longSupplementary = _longString + _supplementary

    @Register
    fun identity(str: String) = str

    @Register
    fun fillTheBuffer(str1: String, str2: String, str3: String, str4: String, str5: String): Boolean {
        return true
    }

    @Register
    fun mixStringAndVariant(i1: Int, str1: String, vec: Vector2, str2: String, f1: Float): Boolean {
        return true
    }

    @Register
    fun getShortString() = _shortString

    @Register
    fun getLongestShortString() = _longestShortString

    @Register
    fun getShortestLongString() = _shortestLongString

    @Register
    fun getLongString() = _longString
  
    @Register
    fun getShortSupplementary() = _shortSupplementary

    @Register
    fun getLongSupplementary() = _longSupplementary

    @Register
    fun getLength(str: String) = str.length

    @Register
    fun getAsStringName(str: String) = str.asStringName()

}



