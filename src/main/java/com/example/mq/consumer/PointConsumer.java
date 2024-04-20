package com.example.mq.consumer;

import com.example.mq.constant.PointMqEnum;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
// 存在多个消费者监听同一队列时，会轮询消费，不会重复消费
// 当前注解方式，当队列不存在时，会自动创建
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "#{T(com.example.mq.constant.PointMqEnum).SIMPLE.getQueue()}", durable = "true")
        , exchange = @Exchange("#{T(com.example.mq.constant.PointMqEnum).SIMPLE.getExchange()}")
        , key = "#{T(com.example.mq.constant.PointMqEnum).SIMPLE.getRoutingKey()}"))
// 这种注解方式，当队列不存在时，会报错
// @RabbitListener(queues = "#{T(com.example.mq.constant.PointMqEnum).SIMPLE.getQueue()}")
public class PointConsumer implements Consumer {

    // @RabbitListener 也可以直接注解在方法上，就不需要 @RabbitHandler 了。
    // @RabbitListener 注解在方法上时，此类中可以存在多个被 @RabbitListener 注解的方法
    // @RabbitHandler 建议加上参数 isDefault。当消费者找不到任何一个消费实现时，会寻找isDefault = true 的 handler，类似一个兜底策略。
    @Override
    @RabbitHandler(isDefault = true)
    public void recv(String message) {
        System.out.printf("消费消息：队列[%s]——消息内容“%s”%n", PointMqEnum.SIMPLE.getQueue(), message);
    }

}
