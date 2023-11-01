package dev.flynnpark.springcoreadvanced.proxy.pureproxy.contreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic {
    private ConcreteLogic concreteLogic;

    public TimeProxy(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    @Override
    public String operation() {
        long start = System.currentTimeMillis();
        String result = concreteLogic.operation();
        long end = System.currentTimeMillis();
        System.out.println("TimeProxy.operation() took " + (end - start) + " nanoseconds");
        return result;
    }
}
