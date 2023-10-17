package dev.flynnpark.springcoreadvanced.proxy.pureproxy.proxy;

import dev.flynnpark.springcoreadvanced.proxy.pureproxy.proxy.code.ProxyPatternClient;
import dev.flynnpark.springcoreadvanced.proxy.pureproxy.proxy.code.RealSubject;
import dev.flynnpark.springcoreadvanced.proxy.pureproxy.proxy.code.CacheProxy;
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

    @Test
    void cacheProxyTest() {
        RealSubject subject = new RealSubject();
        CacheProxy proxy = new CacheProxy(subject);
        ProxyPatternClient client = new ProxyPatternClient(proxy);
        client.execute();
        client.execute();
        client.execute();
    }
}
