package dev.flynnpark.springcoreadvanced.config.v6_aop;

import dev.flynnpark.springcoreadvanced.config.AppV2Config;
import dev.flynnpark.springcoreadvanced.config.v6_aop.aspect.LogTraceAspect;
import dev.flynnpark.springcoreadvanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppV2Config.class, AppV2Config.class})
public class AopConfig {
    @Bean
    public LogTraceAspect logTraceAspect(LogTrace logTrace) {
        return new LogTraceAspect(logTrace);
    }
}
