package dev.flynnpark.springcoreadvanced.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject {
    private Subject target;
    private String cachedValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("프록시 호출");
        if (cachedValue == null) {
            log.info("캐시에 값이 없음");
            cachedValue = target.operation();
        } else {
            log.info("캐시에 값이 있음");
        }
        return cachedValue;
    }
}
