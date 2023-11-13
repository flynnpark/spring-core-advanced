package dev.flynnpark.springcoreadvanced.proxy.cglib.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor {
    private final Object target;

    public TimeMethodInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info("START: {}", method.getName());
        long startTime = System.currentTimeMillis();

        Object result = method.invoke(target, args);

        long resultTime = System.currentTimeMillis() - startTime;
        log.info("END: {} {}ms", method.getName(), resultTime);

        return result;
    }
}
