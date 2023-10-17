package dev.flynnpark.springcoreadvanced.proxy.pureproxy.decorator;

import dev.flynnpark.springcoreadvanced.proxy.pureproxy.decorator.code.Component;
import dev.flynnpark.springcoreadvanced.proxy.pureproxy.decorator.code.DecoratorPatternClient;
import dev.flynnpark.springcoreadvanced.proxy.pureproxy.decorator.code.MessageDecorator;
import dev.flynnpark.springcoreadvanced.proxy.pureproxy.decorator.code.RealComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    void decoratorTest1() {
        Component realComponent = new RealComponent();
        Component decorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(decorator);
        client.execute();
    }
}
