package dev.flynnpark.springcoreadvanced.v3;

import dev.flynnpark.springcoreadvanced.trace.TraceStatus;
import dev.flynnpark.springcoreadvanced.trace.flynnTrace.FlynnTraceV2;
import dev.flynnpark.springcoreadvanced.trace.logTrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {
    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderControllerV1.request()");

            orderService.orderItem(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
        return "ok";
    }
}
