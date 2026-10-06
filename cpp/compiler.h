#ifndef GODOT_JVM_COMPILER_H
#define GODOT_JVM_COMPILER_H

// Opts a function out of the compiler's stack-smashing guard.
//
// A function holding a local array gets a cookie written below its return address on entry and validated on the way
// out, which on MSVC is a call to __security_check_cookie. GCC and Clang do the same under -fstack-protector, which
// godot-cpp does not pass but several Linux distributions, Apple's toolchain and the Android NDK enable by default.
//
// Only for a function whose local buffers are written under a bound that holds by construction rather than by luck,
// on a path hot enough for the check to matter. Anything added to such a function that writes into a local buffer has
// to re-establish that bound, because nothing is watching any more.
#if defined(_MSC_VER)
#define JVM_NO_STACK_PROTECTOR __declspec(safebuffers)
#elif defined(__has_attribute)
#if __has_attribute(no_stack_protector)
#define JVM_NO_STACK_PROTECTOR __attribute__((no_stack_protector))
#else
#define JVM_NO_STACK_PROTECTOR
#endif
#else
#define JVM_NO_STACK_PROTECTOR
#endif

// Inlines every call made inside the function, transitively, overriding the compiler's size heuristics.
//
// For a short function whose whole point is a lookup through a header-only container: the probe loop is the function,
// and left to its heuristics the compiler emits it out of line behind a prologue that saves half the registers, which
// costs more than the probe itself. Only for a function that is called from a hot path and whose body is small by
// construction; flattening a large function duplicates everything it calls.
#if defined(_MSC_VER)
#define JVM_FLATTEN [[msvc::flatten]]
#elif defined(__has_attribute)
#if __has_attribute(flatten)
#define JVM_FLATTEN __attribute__((flatten))
#else
#define JVM_FLATTEN
#endif
#else
#define JVM_FLATTEN
#endif

#endif // GODOT_JVM_COMPILER_H
