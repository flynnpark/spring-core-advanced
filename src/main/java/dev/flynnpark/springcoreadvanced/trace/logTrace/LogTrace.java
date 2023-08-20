package dev.flynnpark.springcoreadvanced.trace.logTrace;

import dev.flynnpark.springcoreadvanced.trace.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
