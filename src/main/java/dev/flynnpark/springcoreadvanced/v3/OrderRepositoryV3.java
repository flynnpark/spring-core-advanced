package dev.flynnpark.springcoreadvanced.v3;

import dev.flynnpark.springcoreadvanced.trace.TraceId;
import dev.flynnpark.springcoreadvanced.trace.TraceStatus;
import dev.flynnpark.springcoreadvanced.trace.flynnTrace.FlynnTraceV2;
import dev.flynnpark.springcoreadvanced.trace.logTrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {
    private final LogTrace trace;

    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepositoryV1.save()");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
