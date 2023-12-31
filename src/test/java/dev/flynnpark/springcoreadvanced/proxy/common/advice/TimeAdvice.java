package dev.flynnpark.springcoreadvanced.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("START: {}", invocation.getMethod().getName());
        long startTime = System.currentTimeMillis();

        Object result = invocation.proceed();

        long resultTime = System.currentTimeMillis() - startTime;
        log.info("END: {} {}ms", invocation.getMethod().getName(), resultTime);
        return result;
    }
}
