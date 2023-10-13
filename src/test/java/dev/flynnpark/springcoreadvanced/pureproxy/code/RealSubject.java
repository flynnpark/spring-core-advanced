package dev.flynnpark.springcoreadvanced.pureproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject {
    @Override
    public String operation() {
        log.info("RealSubject.operation() called");
        sleep(1000);
        return "RealSubject.operation() result";
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.error("Interrupted", e);
        }
    }
}
