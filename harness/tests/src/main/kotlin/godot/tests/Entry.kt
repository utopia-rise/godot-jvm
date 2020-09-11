package godot.tests

import godot.core.*

class Entry : godot.runtime.Entry() {
    override fun Context.init() {
        with(registry) {
            registerClass<Invocation>(Invocation::class.qualifiedName!!, "Spatial") {
                constructor(KtConstructor0(::Invocation))

                property {
                    name = "x"
                    type = KtVariant.Type.LONG
                    className = "Int"
                }
                property {
                    name = "y"
                    type = KtVariant.Type.DOUBLE
                    className = "Double"
                }
                property {
                    name = "z"
                    type = KtVariant.Type.DOUBLE
                    className = "Float"
                }
                property {
                    name = "name"
                    type = KtVariant.Type.STRING
                    className = "String"
                }

                function("intValue", Invocation::intValue, ::KtVariant, KtVariant::asInt,
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
                function("longValue", Invocation::longValue, ::KtVariant, KtVariant::asLong,
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
                function("floatValue", Invocation::floatValue, ::KtVariant, KtVariant::asFloat,
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
                function("doubleValue", Invocation::doubleValue, ::KtVariant, KtVariant::asDouble,
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
                function("booleanValue", Invocation::booleanValue, ::KtVariant, KtVariant::asBoolean,
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
                function("stringValue", Invocation::stringValue, ::KtVariant, KtVariant::asString,
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

                function("intAddition", Invocation::intAddition, ::KtVariant, KtVariant::asInt, KtVariant::asInt,
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
