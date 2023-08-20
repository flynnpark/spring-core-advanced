package dev.flynnpark.springcoreadvanced;

import dev.flynnpark.springcoreadvanced.trace.logTrace.FieldLogTrace;
import dev.flynnpark.springcoreadvanced.trace.logTrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {
    @Bean
    public LogTrace logTrace() {
    return new FieldLogTrace();
    }
}
