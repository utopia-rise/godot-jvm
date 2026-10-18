package godot.tests.events;

import godot.annotation.Script;
import godot.annotation.Register;
import godot.annotation.Visible;
import godot.annotation.Emit;
import godot.api.Node;
import godot.core.MethodCallable1;
import godot.core.MethodCallable2;
import godot.core.MethodStringName1;
import godot.core.MethodStringName2;
import godot.core.Signal1;
import godot.core.Signal2;

@Script
public class SignalJavaTest extends Node {
    @Emit
    public final Signal1<Boolean> readySignal = Signal1.create(this, "readySignal");

    @Emit
    public final Signal2<String, Integer> payloadSignal = Signal2.create(this, "payloadSignal");

    @Visible
    public boolean methodSignalTriggered = false;

    @Visible
    public boolean lambdaSignalTriggered = false;

    @Visible
    public String payloadString = "";

    @Visible
    public int payloadInt = Integer.MIN_VALUE;

    @Emit
    public final Signal1<Node> nullableNodeSignal = Signal1.create(this, "nullableNodeSignal");

    @Visible
    public boolean nullableNodeSignalDelivered = false;

    @Visible
    public boolean nullableNodeSignalPayloadWasNull = false;

    @Register
    @Override
    public void _ready() {
        readySignal.connect(MethodCallable1.create(
            this,
            new MethodStringName1<SignalJavaTest, Void, Boolean>("on_ready_signal")
        ));
        payloadSignal.connect(MethodCallable2.create(
            this,
            new MethodStringName2<SignalJavaTest, Void, String, Integer>("on_payload_signal")
        ));

        nullableNodeSignal.connect(MethodCallable1.create(
            this,
            new MethodStringName1<SignalJavaTest, Void, Node>("on_nullable_node_signal")
        ));

        readySignal.emit(true);
        payloadSignal.emit("java-events", 17);
    }

    @Register
    public void emitNullableNodeSignal() {
        nullableNodeSignalDelivered = false;
        nullableNodeSignalPayloadWasNull = false;
        nullableNodeSignal.emit(null);
    }

    @Register
    public void onNullableNodeSignal(Node node) {
        nullableNodeSignalDelivered = true;
        nullableNodeSignalPayloadWasNull = node == null;
    }

    @Register
    public void onReadySignal(Boolean value) {
        methodSignalTriggered = value;
    }

    @Register
    public void onPayloadSignal(String text, Integer value) {
        lambdaSignalTriggered = true;
        payloadString = text;
        payloadInt = value;
    }
}

