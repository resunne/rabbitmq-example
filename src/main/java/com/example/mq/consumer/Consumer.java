package com.example.mq.consumer;

import com.example.mq.exception.MqMsgRTException;
import com.example.mq.tips.MqMsgTip;

public interface Consumer {

    default void recv(String message) {
        throw new MqMsgRTException(MqMsgTip.TIP_MQ_SEND_006);
    }

}
