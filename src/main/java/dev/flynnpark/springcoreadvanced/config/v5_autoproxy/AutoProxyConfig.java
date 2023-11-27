package dev.flynnpark.springcoreadvanced.config.v5_autoproxy;

import dev.flynnpark.springcoreadvanced.config.AppV1Config;
import dev.flynnpark.springcoreadvanced.config.AppV2Config;
import dev.flynnpark.springcoreadvanced.config.v3_proxyfactory.advice.LogTraceAdvice;
import dev.flynnpark.springcoreadvanced.trace.logtrace.LogTrace;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AutoProxyConfig {
//    @Bean
    public Advisor advisor1(LogTrace trace) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");
        LogTraceAdvice advice = new LogTraceAdvice(trace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }

//    @Bean
    public Advisor advisor2(LogTrace trace) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* dev.flynnpark.springcoreadvanced.app..*(..))");
        LogTraceAdvice advice = new LogTraceAdvice(trace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }

    @Bean
    public Advisor advisor3(LogTrace trace) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* dev.flynnpark.springcoreadvanced.app..*(..)) && !execution(* dev.flynnpark.springcoreadvanced.app..noLog(..))");
        LogTraceAdvice advice = new LogTraceAdvice(trace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}

