package godot.tests.registration

import godot.annotation.Export
import godot.annotation.Script
import godot.annotation.Register
import godot.annotation.Visible
import godot.api.Node
import godot.api.Tween
import godot.core.Error
import godot.core.variantArrayOf

enum class RegistrationEnum {
    ENUM_1,
    ENUM_2,
}

// GH-835
@Script
class EnumRegistration: Node() {
    // do not test enums with ordinal 0 here! On the GDScript side, failed returns are returned as NULL which will equal ordinal 0 and thus tests might pass even if they should not

    @Export
    @Visible
    var enumValue = RegistrationEnum.ENUM_2

    @Export
    @Visible
    var godotErrorEnumValue = Error.BUG

    @Export
    @Visible
    var godotEnumValue = Tween.EaseType.IN_OUT

    @Visible
    var enumHistory = variantArrayOf(RegistrationEnum.ENUM_1.ordinal, RegistrationEnum.ENUM_2.ordinal)

    @Visible
    var bitFlagValue = 0b011

    // Registered through KtEnumListProperty: Godot sees an int array with enum hints, the JVM keeps the enum list.
    @Export
    @Visible
    var enumList: List<RegistrationEnum> = listOf(RegistrationEnum.ENUM_2, RegistrationEnum.ENUM_1)

    @Register
    fun enumListNames(): String = enumList.joinToString(",") { it.name }

    @Register
    fun setEnumListFromJvm() {
        enumList = listOf(RegistrationEnum.ENUM_1, RegistrationEnum.ENUM_1, RegistrationEnum.ENUM_2)
    }

    @Register
    fun provideEnumValue() = enumValue

    @Register
    fun provideGodotErrorEnumValue() = godotErrorEnumValue

    @Register
    fun provideGodotEnumValue() = godotEnumValue

    @Register
    fun storeEnumByOrdinal(ordinal: Int) {
        enumValue = RegistrationEnum.entries.first { it.ordinal == ordinal }
    }

    @Register
    fun appendEnumToHistory(ordinal: Int) {
        enumHistory.append(RegistrationEnum.entries.first { it.ordinal == ordinal }.ordinal)
    }

    @Register
    fun invalidEnumOrdinalHandled(ordinal: Int): Boolean {
        return RegistrationEnum.entries.none { it.ordinal == ordinal }
    }
}

