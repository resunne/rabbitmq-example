package com.example.mq.tips;

import java.text.MessageFormat;

public interface ResultTip {

    /**
     * 获取消息代码
     *
     * @return
     */
    String getCode();

    /**
     * 获取消息模板
     *
     * @return
     */
    String getTpl();

    default String getMsg(String... args) {
        return MessageFormat.format(this.getTpl(), args);
    }

}
