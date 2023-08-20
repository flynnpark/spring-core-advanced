package dev.flynnpark.springcoreadvanced.v3;

import dev.flynnpark.springcoreadvanced.trace.TraceId;
import dev.flynnpark.springcoreadvanced.trace.TraceStatus;
import dev.flynnpark.springcoreadvanced.trace.flynnTrace.FlynnTraceV2;
import dev.flynnpark.springcoreadvanced.trace.logTrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderServiceV1.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
