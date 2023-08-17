package dev.flynnpark.springcoreadvanced.trace.flynnTrace;

import dev.flynnpark.springcoreadvanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

public class FlynnTraceV1Test {
    @Test
    void beginEnd() {
        FlynnTraceV1 trace = new FlynnTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.end(status);
    }

    @Test
    void beginException() {
        FlynnTraceV1 trace = new FlynnTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalStateException());
    }
}
