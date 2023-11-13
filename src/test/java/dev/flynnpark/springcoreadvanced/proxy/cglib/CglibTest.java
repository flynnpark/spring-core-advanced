package dev.flynnpark.springcoreadvanced.proxy.cglib;

import dev.flynnpark.springcoreadvanced.proxy.cglib.code.TimeMethodInterceptor;
import dev.flynnpark.springcoreadvanced.proxy.common.service.ConcreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CglibTest {
    @Test
    void cglib() {
        ConcreteService target = new ConcreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));
        ConcreteService proxy = (ConcreteService) enhancer.create();
        log.info("target: {}", target.getClass());
        log.info("proxy: {}", proxy.getClass());

        proxy.call();
    }
}
