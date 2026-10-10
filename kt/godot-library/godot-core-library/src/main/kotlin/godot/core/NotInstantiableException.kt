package godot.core

class NotInstantiableException(className: String) : IllegalStateException("Godot can't instantiate $className.")
