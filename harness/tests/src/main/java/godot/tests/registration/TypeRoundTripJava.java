package godot.tests.registration;

import godot.annotation.Emit;
import godot.annotation.Export;
import godot.annotation.Register;
import godot.annotation.Script;
import godot.annotation.Visible;
import godot.api.Control;
import godot.api.Node;
import godot.core.BitField;
import godot.core.Callable;
import godot.core.LambdaCallable1;
import godot.core.Signal1;

import java.util.ArrayList;
import java.util.List;

@Script
public class TypeRoundTripJava extends Node {
    public enum Flag { FIRST, SECOND }

    @Export
    @Visible
    public List<Flag> flagList = new ArrayList<>(List.of(Flag.FIRST));

    @Visible
    public final int readOnlyCount = 7;

    @Visible
    public final List<Flag> readOnlyFlagList = List.of(Flag.SECOND);

    @Visible
    public final BitField<Flag> readOnlyBitField = new BitField<>(3);

    @Emit
    public final Signal1<BitField<Flag>> bitFieldSignal = Signal1.create(this, "bitFieldSignal");

    @Visible
    public final Callable bitFieldCallable = LambdaCallable1.create(Long.class, BitField.class, flags -> flags.getFlag());

    @Register
    public BitField<Flag> echoBitField(BitField<Flag> flags) {
        return flags;
    }

    @Register
    public boolean aliasedEngineEnumRoundTrips() {
        Control control = new Control();
        control.setLayoutDirection(Control.LayoutDirection.APPLICATION_LOCALE);
        boolean roundTrips = control.getLayoutDirection() == Control.LayoutDirection.APPLICATION_LOCALE;
        control.free();
        return roundTrips;
    }

    @Register
    public void emitBitField(long value) {
        bitFieldSignal.emit(new BitField<>(value));
    }
}
