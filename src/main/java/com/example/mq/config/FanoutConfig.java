package com.example.mq.config;

import com.example.mq.constant.FanoutMqConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    @Bean
    public Queue queueA() {
        return new Queue(FanoutMqConstant.QUEUE_A, true);
    }

    @Bean
    public Queue queueB() {
        return new Queue(FanoutMqConstant.QUEUE_B, true);
    }

    @Bean
    public Queue queueC() {
        return new Queue(FanoutMqConstant.QUEUE_C, true);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FanoutMqConstant.EXCHANGE, true, false);
    }

    @Bean
    public Binding bindingA(Queue queueA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueA).to(fanoutExchange);
    }

    @Bean
    public Binding bindingB(Queue queueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueB).to(fanoutExchange);
    }

    @Bean
    public Binding bindingC(Queue queueC, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueC).to(fanoutExchange);
    }
}
