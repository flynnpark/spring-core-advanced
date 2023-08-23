package dev.flynnpark.springcoreadvanced.trace.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {
    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("logic1 starts");
        // 비즈니스 로직 종료
        long resultTime = System.currentTimeMillis() - startTime;
        log.info("logic1 ends: {}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("logic2 starts");
        // 비즈니스 로직 종료
        long resultTime = System.currentTimeMillis() - startTime;
        log.info("logic2 ends: {}", resultTime);
    }

    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        AbstractTemplate template2 = new SubClassLogic2();

        template1.execute();
        template2.execute();
    }

    @Test
    void templateMethodV2() {
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void doExecute() {
                log.info("logic1 starts");
            }
        };
        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void doExecute() {
                log.info("logic2 starts");
            }
        };

        log.info("클래스 이름1={}", template1.getClass().getName());
        log.info("클래스 이름2={}", template2.getClass().getName());

        template1.execute();
        template2.execute();
    }
}
