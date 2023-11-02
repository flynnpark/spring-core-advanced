package dev.flynnpark.springcoreadvanced;

import dev.flynnpark.springcoreadvanced.config.v1_proxy.ConcreteProxyConfig;
import dev.flynnpark.springcoreadvanced.config.v1_proxy.InterfaceProxyConfig;
import dev.flynnpark.springcoreadvanced.trace.logtrace.LogTrace;
import dev.flynnpark.springcoreadvanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(ConcreteProxyConfig.class)
@SpringBootApplication(scanBasePackages = "dev.flynnpark.springcoreadvanced.app.v1")
public class ProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
