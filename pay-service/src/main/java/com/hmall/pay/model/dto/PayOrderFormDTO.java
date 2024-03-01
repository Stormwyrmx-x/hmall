package com.hmall.pay.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PayOrderFormDTO {
    @NotNull(message = "支付订单id不能为空")
    private Long id;
    @NotNull(message = "支付密码")
    private String pw;
}