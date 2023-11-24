package dev.flynnpark.springcoreadvanced;

import dev.flynnpark.springcoreadvanced.config.v5_autoproxy.AutoProxyConfig;
import dev.flynnpark.springcoreadvanced.trace.logtrace.LogTrace;
import dev.flynnpark.springcoreadvanced.trace.logtrace.ThreadLocalLogTrace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(AutoProxyConfig.class)
@SpringBootApplication(scanBasePackages = "dev.flynnpark.springcoreadvanced.app.v3")
public class ProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
