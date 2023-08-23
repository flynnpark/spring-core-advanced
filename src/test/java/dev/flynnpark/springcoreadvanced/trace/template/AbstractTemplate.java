package dev.flynnpark.springcoreadvanced.trace.template;

public abstract class AbstractTemplate {
    public void execute() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        doExecute();
        // 비즈니스 로직 종료
        long resultTime = System.currentTimeMillis() - startTime;
        System.out.println("resultTime = " + resultTime);
    }

    protected abstract void doExecute();
}
