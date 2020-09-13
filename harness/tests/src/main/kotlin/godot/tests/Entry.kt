package godot.tests

import godot.core.*

class Entry : godot.runtime.Entry() {
    override fun Context.init() {
        with(registry) {
            registerClass<Invocation>(Invocation::class.qualifiedName!!, "Spatial") {
                constructor(KtConstructor0(::Invocation))

                property(Invocation::x, ::KtVariant, KtVariant::asInt) {
                    type = KtVariant.Type.LONG
                    className = "Int"
                }
                property(Invocation::y, ::KtVariant, KtVariant::asDouble) {
                    type = KtVariant.Type.DOUBLE
                    className = "Double"
                }
                property(Invocation::z, ::KtVariant, KtVariant::asFloat) {
                    type = KtVariant.Type.DOUBLE
                    className = "Float"
                }
                property(Invocation::name, ::KtVariant, KtVariant::asString) {
                    type = KtVariant.Type.STRING
                    className = "String"
                }

                function("int_value", Invocation::intValue, ::KtVariant, KtVariant::asInt,
                        arg = {
                            name = "value"
                            type = KtVariant.Type.LONG
                            className = "Int"
                        },
                        returns = {
                            type = KtVariant.Type.LONG
                            className = "Int"
                        }
                )
                function("long_value", Invocation::longValue, ::KtVariant, KtVariant::asLong,
                        arg = {
                            name = "value"
                            type = KtVariant.Type.LONG
                            className = "Long"
                        },
                        returns = {
                            type = KtVariant.Type.LONG
                            className = "Long"
                        }
                )
                function("float_value", Invocation::floatValue, ::KtVariant, KtVariant::asFloat,
                        arg = {
                            name = "value"
                            type = KtVariant.Type.DOUBLE
                            className = "Float"
                        },
                        returns = {
                            type = KtVariant.Type.DOUBLE
                            className = "Float"
                        }
                )
                function("double_value", Invocation::doubleValue, ::KtVariant, KtVariant::asDouble,
                        arg = {
                            name = "value"
                            type = KtVariant.Type.DOUBLE
                            className = "Double"
                        },
                        returns = {
                            type = KtVariant.Type.DOUBLE
                            className = "Double"
                        }
                )
                function("boolean_value", Invocation::booleanValue, ::KtVariant, KtVariant::asBoolean,
                        arg = {
                            name = "value"
                            type = KtVariant.Type.BOOL
                            className = "Boolean"
                        },
                        returns = {
                            type = KtVariant.Type.BOOL
                            className = "Boolean"
                        }
                )
                function("string_value", Invocation::stringValue, ::KtVariant, KtVariant::asString,
                        arg = {
                            name = "value"
                            type = KtVariant.Type.STRING
                            className = "String"
                        },
                        returns = {
                            type = KtVariant.Type.STRING
                            className = "String"
                        }
                )

                function("int_addition", Invocation::intAddition, ::KtVariant, KtVariant::asInt, KtVariant::asInt,
                        args = arrayOf(
                                {
                                    name = "a"
                                    type = KtVariant.Type.LONG
                                    className = "Int"
                                },
                                {
                                    name = "b"
                                    type = KtVariant.Type.LONG
                                    className = "Int"
                                }
                        ),
                        returns = {
                            type = KtVariant.Type.LONG
                            className = "Int"
                        }
                )

                function("_enter_tree", Invocation::_enter_tree, ::KtVariant,
                        returns = {
                            type = KtVariant.Type.NIL
                            className = "Unit"
                        }
                )
            }
        }
    }
}
