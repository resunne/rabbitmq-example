package com.example.mq.consumer;

import com.example.mq.constant.FanoutMqConstant;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutConsumer implements Consumer {

    /**
     * @param message
     */
    // 当前注解方式，当队列不存在时，会自动创建
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "#{T(com.example.mq.constant.FanoutMqConstant).QUEUE_A}", durable = "true")
            , exchange = @Exchange(value = "#{T(com.example.mq.constant.FanoutMqConstant).EXCHANGE}", type = "fanout")))
    // 这种注解方式，当队列不存在时，会报错
    // @RabbitListener(queues = "#{T(com.example.mq.constant.FanoutMqConstant).QUEUE_A}")
    public void recvFromA(String message) {
        System.out.printf("消费消息：队列[%s]——消息内容“%s”%n", FanoutMqConstant.QUEUE_A, message);
    }

    /**
     * @param message
     */
    // 当前注解方式，当队列不存在时，会自动创建
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "#{T(com.example.mq.constant.FanoutMqConstant).QUEUE_B}", durable = "true")
            , exchange = @Exchange(value = "#{T(com.example.mq.constant.FanoutMqConstant).EXCHANGE}", type = "fanout")))
    // 这种注解方式，当队列不存在时，会报错
    // @RabbitListener(queues = "#{T(com.example.mq.constant.FanoutMqConstant).QUEUE_B}")
    public void recvFromB(String message) {
        System.out.printf("消费消息：队列[%s]——消息内容“%s”%n", FanoutMqConstant.QUEUE_B, message);
    }

    /**
     * @param message
     */
    // 当前注解方式，当队列不存在时，会自动创建
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "#{T(com.example.mq.constant.FanoutMqConstant).QUEUE_C}", durable = "true")
            , exchange = @Exchange(value = "#{T(com.example.mq.constant.FanoutMqConstant).EXCHANGE}", type = "fanout")))
    // 这种注解方式，当队列不存在时，会报错
    // @RabbitListener(queues = "#{T(com.example.mq.constant.FanoutMqConstant).QUEUE_C}")
    public void recvFromC(String message) {
        System.out.printf("消费消息：队列[%s]——消息内容“%s”%n", FanoutMqConstant.QUEUE_C, message);
    }
}
