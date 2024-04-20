package com.example.mq.config;

import com.example.mq.constant.PointMqEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PointConfig {

    @Bean
    public Queue pointQueue() {
        return new Queue(PointMqEnum.SIMPLE.getQueue(), true);
    }

    @Bean
    public DirectExchange pointExchange() {
        return new DirectExchange(PointMqEnum.SIMPLE.getExchange(), true, false);
    }

    @Bean
    public Binding bindingPoint(Queue pointQueue, DirectExchange pointExchange) {
        return BindingBuilder.bind(pointQueue).to(pointExchange).with(PointMqEnum.SIMPLE.getRoutingKey());
    }

}
