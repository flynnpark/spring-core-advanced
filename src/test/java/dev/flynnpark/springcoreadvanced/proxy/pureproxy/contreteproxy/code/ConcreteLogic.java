package dev.flynnpark.springcoreadvanced.proxy.pureproxy.contreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteLogic {
    public String operation() {
        log.info("ConcreteLogic.operation() is called");
        return "ConcreteLogic.operation()";
    }
}
