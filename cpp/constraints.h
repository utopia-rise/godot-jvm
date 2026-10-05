#ifndef GODOT_JVM_CONSTRAINTS_H
#define GODOT_JVM_CONSTRAINTS_H

// The ceiling on how many arguments cross in either direction: a call's, and a signal's, which have to agree because
// a signal is delivered through a Callable of the same arity.
// when changed, also update godot.common.constants.Constraints.MAX_ARGUMENT_COUNT!
static constexpr const int MAX_ARGUMENT_COUNT = 16;

#endif // GODOT_JVM_CONSTRAINTS_H
