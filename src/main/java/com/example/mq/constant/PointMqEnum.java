package com.example.mq.constant;

import lombok.Getter;

@Getter
public enum PointMqEnum {

    SIMPLE("简易", "sun.exchange.point.simple", "simple", "sun.queue.point.simple"),
    ;

    /**
     * 服务
     */
    private final String service;
    /**
     * 交换机
     */
    private final String exchange;
    /**
     * 路由标识
     */
    private final String routingKey;
    /**
     * 队列
     */
    private final String queue;

    PointMqEnum(String service, String exchange, String routeKey, String queue) {
        this.service = service;
        this.exchange = exchange;
        this.routingKey = routeKey;
        this.queue = queue;
    }

}
