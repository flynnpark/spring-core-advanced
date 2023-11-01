package dev.flynnpark.springcoreadvanced.proxy.pureproxy.contreteproxy.code;

public class ConcreteClient {
    private ConcreteLogic concreteLogic;

    public ConcreteClient(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    public String execute() {
        return concreteLogic.operation();
    }
}
