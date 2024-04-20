package com.example.mq.producer;

import com.example.mq.exception.MqMsgRTException;
import com.example.mq.tips.MqMsgTip;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class FanoutProducer implements Producer {


    private final RabbitTemplate rabbitTemplate;

    public FanoutProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * 发送消息
     *
     * @param exchange 交换机
     * @param msg      消息体
     */
    @Override
    public void send(String exchange, String msg) {
        if (!StringUtils.hasText(exchange)) {
            throw new MqMsgRTException(MqMsgTip.TIP_MQ_SEND_005);
        }
        if (!StringUtils.hasText(msg)) {
            throw new MqMsgRTException(MqMsgTip.TIP_MQ_SEND_003);
        }

        try {
            rabbitTemplate.convertAndSend(exchange, "", msg);
        } catch (Exception e) {
            log.error(MqMsgTip.TIP_MQ_SEND_004.getMsg(e.getMessage()), e);
            throw new MqMsgRTException(MqMsgTip.TIP_MQ_SEND_004, e.getMessage());
        }
    }

}
