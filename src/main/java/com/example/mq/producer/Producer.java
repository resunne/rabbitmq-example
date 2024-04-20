package com.example.mq.producer;

import com.example.mq.exception.MqMsgRTException;
import com.example.mq.tips.MqMsgTip;

public interface Producer {

    /**
     * 发送消息
     *
     * @param exchange 交换机
     * @param msg      消息体
     */
    default void send(String exchange, String msg) {
        throw new MqMsgRTException(MqMsgTip.TIP_MQ_SEND_006);
    }

    /**
     * 发送消息
     *
     * @param exchange   交换机
     * @param routingKey 消息路由标识
     * @param msg        消息体
     */
    default void send(String exchange, String routingKey, String msg) {
        throw new MqMsgRTException(MqMsgTip.TIP_MQ_SEND_006);
    }

}
