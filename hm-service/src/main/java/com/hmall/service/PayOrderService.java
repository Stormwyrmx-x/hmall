package com.hmall.service;

import com.hmall.model.dto.PayApplyDTO;
import com.hmall.model.dto.PayOrderFormDTO;
import com.hmall.model.entity.PayOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 支付订单 服务类
 * </p>
 *
 * @author 虎哥
 * @since 2023-05-16
 */
public interface PayOrderService extends IService<PayOrder> {

    String applyPayOrder(PayApplyDTO applyDTO);

    void tryPayOrderByBalance(PayOrderFormDTO payOrderFormDTO);
}
