package dev.flynnpark.springcoreadvanced.pureproxy;

import dev.flynnpark.springcoreadvanced.pureproxy.code.ProxyPatternClient;
import dev.flynnpark.springcoreadvanced.pureproxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {
    @Test
    void noProxyText() {
        RealSubject subject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(subject);
        client.execute();
        client.execute();
        client.execute();
    }
}
