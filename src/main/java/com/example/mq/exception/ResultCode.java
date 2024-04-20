package com.example.mq.exception;

import com.example.mq.tips.ResultTip;
import lombok.Getter;

@Getter
public abstract class ResultCode {

    /**
     * 错误信息代码
     */
    private final String code;
    /**
     * 错误信息内容
     */
    private final String msg;

    public ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 此构造主要用于自定义异常抛出的 Code 和 msg 对象
     *
     * @param tip
     */
    public ResultCode(ResultTip tip) {
        this.code = tip.getCode();
        this.msg = tip.getMsg();
    }

}
