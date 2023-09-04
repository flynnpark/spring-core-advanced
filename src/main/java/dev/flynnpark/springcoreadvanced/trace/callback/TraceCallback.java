package dev.flynnpark.springcoreadvanced.trace.callback;

public interface TraceCallback<T> {
    T call();
}
