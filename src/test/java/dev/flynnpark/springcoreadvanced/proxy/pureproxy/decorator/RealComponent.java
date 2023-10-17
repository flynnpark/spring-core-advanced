package dev.flynnpark.springcoreadvanced.proxy.pureproxy.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealComponent implements Component {
    @Override
    public String operation() {
        log.info("RealComponent.operation() called");
        return "RealComponent.operation() result";
    }
}
