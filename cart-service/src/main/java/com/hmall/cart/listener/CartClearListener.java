package com.hmall.cart.listener;

import com.hmall.cart.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class CartClearListener {
    private final CartService cartService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "cart.clear.queue", durable = "true"),
            exchange = @Exchange(value = "trade.topic", type = "topic"),
            key = {"order.create"}
    ))
    public void listenCartClear(Collection<Long> itemIds) {
        cartService.removeByItemIds(itemIds);
    }

}
