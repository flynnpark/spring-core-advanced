package dev.flynnpark.springcoreadvanced.trace.strategy;

import dev.flynnpark.springcoreadvanced.trace.strategy.code.strategy.ContextV2;
import dev.flynnpark.springcoreadvanced.trace.strategy.code.strategy.Strategy;
import dev.flynnpark.springcoreadvanced.trace.strategy.code.strategy.StrategyLogic1;
import dev.flynnpark.springcoreadvanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {
    /**
     * 전략 패턴 적용
     */
    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }

    /**
     * 전략 패턴 익명 내부 클래스
     */
    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("logic1 starts");
            }
        });
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("logic2 starts");
            }
        });
    }

    /**
     * 전략 패턴 익명 내부 클래스 람다
     */
    @Test
    void strategyV3() {
        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("logic1 starts"));
        context.execute(() -> log.info("logic2 starts"));
    }
}
