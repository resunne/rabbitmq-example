package com.example.mq.tips;

import lombok.Getter;

@Getter
public enum MqMsgTip implements ResultTip {

    TIP_MQ_SEND_001("TIP_MQ_SEND_001", "消息发送失败！{0}"),
    TIP_MQ_SEND_002("TIP_MQ_SEND_002", "消息发送失败！队列名为空！"),
    TIP_MQ_SEND_003("TIP_MQ_SEND_003", "消息发送失败！消息内容为空！"),
    TIP_MQ_SEND_004("TIP_MQ_SEND_004", "消息发送失败！发生异常：{0}"),
    TIP_MQ_SEND_005("TIP_MQ_SEND_005", "消息发送失败！交换机为空！"),
    TIP_MQ_SEND_006("TIP_MQ_SEND_006", "不受支持的操作！"),
    ;

    /**
     * 代码
     */
    private final String code;
    /**
     * 内容
     */
    private final String tpl;

    MqMsgTip(String code, String tpl) {
        this.code = code;
        this.tpl = tpl;
    }

    /**
     * 获取消息代码
     *
     * @return
     */
    @Override
    public String getCode() {
        return this.code;
    }

    /**
     * 获取消息模板
     *
     * @return
     */
    @Override
    public String getTpl() {
        return this.tpl;
    }

}
