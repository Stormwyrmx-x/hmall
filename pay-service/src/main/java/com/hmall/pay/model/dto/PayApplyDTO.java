package com.hmall.pay.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PayApplyDTO {
    @NotNull(message = "业务订单id不能为空")
    private Long bizOrderNo;
    @Min(value = 1, message = "支付金额必须为正数")
    private Integer amount;
    @NotNull(message = "支付渠道编码不能为空")
    private String payChannelCode;
    @NotNull(message = "支付方式不能为空")
    private Integer payType;
    @NotNull(message = "订单中的商品信息不能为空")
    private String orderInfo;
}