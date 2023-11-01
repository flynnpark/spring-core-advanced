package dev.flynnpark.springcoreadvanced.proxy.pureproxy.contreteproxy;

import dev.flynnpark.springcoreadvanced.proxy.pureproxy.contreteproxy.code.ConcreteClient;
import dev.flynnpark.springcoreadvanced.proxy.pureproxy.contreteproxy.code.ConcreteLogic;
import dev.flynnpark.springcoreadvanced.proxy.pureproxy.contreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {
    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient concreteClient = new ConcreteClient(concreteLogic);
        concreteClient.execute();
    }

    @Test
    void addProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient concreteClient = new ConcreteClient(timeProxy);
        concreteClient.execute();
    }
}
