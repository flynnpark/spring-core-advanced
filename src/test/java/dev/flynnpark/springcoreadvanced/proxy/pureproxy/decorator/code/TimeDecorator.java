package dev.flynnpark.springcoreadvanced.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator implements Component {
    private Component component;

    public TimeDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("TimeDecorator.operation() called");
        long start = System.currentTimeMillis();
        String result = component.operation();
        long end = System.currentTimeMillis();
        log.info("TimeDecorator.operation() took {} ms", end - start);
        return result;
    }
}
