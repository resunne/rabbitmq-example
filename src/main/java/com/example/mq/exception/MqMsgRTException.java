package com.example.mq.exception;

import com.example.mq.tips.ResultTip;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MqMsgRTException extends RuntimeException {

    /**
     * 错误信息代码
     */
    private String code;
    /**
     * 错误信息内容
     */
    private String msg;

    public MqMsgRTException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public MqMsgRTException(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public MqMsgRTException(ResultTip tip) {
        this.code = tip.getCode();
        this.msg = tip.getMsg();
    }

    public MqMsgRTException(ResultTip tip, String... args) {
        this.code = tip.getCode();
        this.msg = tip.getMsg(args);
    }

}
