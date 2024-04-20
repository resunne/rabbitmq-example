package com.example.mq.controller;

import com.example.mq.constant.FanoutMqConstant;
import com.example.mq.constant.PointMqEnum;
import com.example.mq.producer.PointProducer;
import com.example.mq.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    private final Producer pointProducer;
    private final Producer fanoutProducer;

    public ProductController(PointProducer pointProducer, Producer fanoutProducer) {
        this.pointProducer = pointProducer;
        this.fanoutProducer = fanoutProducer;
    }

    @PostMapping("/point/send")
    public void sendPoint(@RequestParam String msg) {
        pointProducer.send(PointMqEnum.SIMPLE.getExchange(), PointMqEnum.SIMPLE.getRoutingKey(), msg);
    }

    @PostMapping("/fanout/send")
    public void sendFanout(@RequestParam String msg) {
        fanoutProducer.send(FanoutMqConstant.EXCHANGE, msg);
    }
}
