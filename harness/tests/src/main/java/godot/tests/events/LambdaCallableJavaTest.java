package godot.tests.events;

import godot.annotation.Script;
import godot.annotation.Register;
import godot.annotation.Visible;
import godot.api.Node;
import godot.core.Callable;
import godot.core.LambdaCallable0;
import godot.core.LambdaCallable1;

@Script
public class LambdaCallableJavaTest extends Node {
    @Visible
    public boolean callableNoParamTriggered = false;

    @Visible
    public boolean callableWithParamTriggered = false;

    @Visible
    public String callableString = "";

    @Visible
    public Callable callableProperty = LambdaCallable1.create(String.class, value -> callableString = value);

    @Register
    public void markCallableNoParamTriggered() {
        callableNoParamTriggered = true;
    }

    @Register
    public void callCallableNoParam() {
        LambdaCallable0.create(this::markCallableNoParamTriggered).call();
    }

    @Register
    public void callCallableNoParamDeferred() {
        LambdaCallable0.create(this::markCallableNoParamTriggered).callDeferred();
    }

    @Register
    public void markCallableWithParamTriggered(Boolean flag) {
        callableWithParamTriggered = flag;
    }

    @Register
    public void callCallableWithParam() {
        LambdaCallable1.create(Boolean.class, this::markCallableWithParamTriggered).call(true);
    }

    @Register
    public void callCallableWithParamDeferred() {
        LambdaCallable1.create(Boolean.class, this::markCallableWithParamTriggered).callDeferred(true);
    }

    @Register
    public int callPrimitiveReturnCallable() {
        return LambdaCallable0.create(int.class, () -> 7).call();
    }

    @Register
    public boolean callVoidReturnCallable() {
        LambdaCallable0.create(void.class, () -> {
            markCallableNoParamTriggered();
            return null;
        }).call();
        return callableNoParamTriggered;
    }
}
