package dev.flynnpark.springcoreadvanced.app.v2;

import dev.flynnpark.springcoreadvanced.app.v1.OrderServiceV1;

public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepository;

    public OrderServiceV2(OrderRepositoryV2 orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
