package dev.flynnpark.springcoreadvanced.trace.flynnTrace;

import dev.flynnpark.springcoreadvanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

public class FlynnTraceV2Test {
    @Test
    void beginEnd() {
        FlynnTraceV2 trace = new FlynnTraceV2();
        TraceStatus status1 = trace.begin("hello");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void beginException() {
        FlynnTraceV2 trace = new FlynnTraceV2();
        TraceStatus status1 = trace.begin("hello");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }
}
