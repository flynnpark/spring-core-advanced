package dev.flynnpark.springcoreadvanced;

import dev.flynnpark.springcoreadvanced.trace.logTrace.LogTrace;
import dev.flynnpark.springcoreadvanced.trace.logTrace.ThreadLocalTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {
    @Bean
    public LogTrace logTrace() {
    return new ThreadLocalTrace();
    }
}
