package dev.flynnpark.springcoreadvanced.config.v4_postprocessor;

import dev.flynnpark.springcoreadvanced.config.AppV1Config;
import dev.flynnpark.springcoreadvanced.config.AppV2Config;
import dev.flynnpark.springcoreadvanced.config.v3_proxyfactory.advice.LogTraceAdvice;
import dev.flynnpark.springcoreadvanced.config.v4_postprocessor.postprocessor.PackgeLogTracePostProcessor;
import dev.flynnpark.springcoreadvanced.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class BeanPostProcessorConfig {
    @Bean
    public PackgeLogTracePostProcessor logTracePostProcessor(LogTrace trace) {
        return new PackgeLogTracePostProcessor("dev.flynnpark.springcoreadvanced.app", getAdvisor(trace));
    }

    private Advisor getAdvisor(LogTrace trace) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");
        LogTraceAdvice advice = new LogTraceAdvice(trace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}
