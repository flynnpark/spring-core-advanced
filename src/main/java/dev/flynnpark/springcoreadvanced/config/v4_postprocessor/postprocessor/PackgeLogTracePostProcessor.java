package dev.flynnpark.springcoreadvanced.config.v4_postprocessor.postprocessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
public class PackgeLogTracePostProcessor implements BeanPostProcessor {
    private final String basePackageName;
    private final Advisor advisor;

    public PackgeLogTracePostProcessor(String basePackageName, Advisor advisor) {
        this.basePackageName = basePackageName;
        this.advisor = advisor;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("param beanName={}, bean={}", beanName, bean.getClass());

        // 프록시 적용 대상 여부 확인
        // 프록시 적용 대상이 아니면 원본을 그대로 반환
        String packageName = bean.getClass().getPackageName();
        if (!packageName.startsWith(basePackageName)) {
            return bean;
        }

        // 프록시 대상이면 프록시를 만들어서 반환
        ProxyFactory proxyFactory = new ProxyFactory(bean);
        proxyFactory.addAdvisor(advisor);

        Object proxy = proxyFactory.getProxy();
        log.info("create proxy: target={}, proxy={}", bean, proxy.getClass());
        return proxy;
    }
}
