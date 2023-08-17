package dev.flynnpark.springcoreadvanced.v2;

import dev.flynnpark.springcoreadvanced.trace.TraceStatus;
import dev.flynnpark.springcoreadvanced.trace.flynnTrace.FlynnTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {
    private final OrderServiceV2 orderService;
    private final FlynnTraceV2 trace;

    @GetMapping("/v2/request")
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderControllerV1.request()");

            orderService.orderItem(status.getTraceId(), itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
        return "ok";
    }
}
