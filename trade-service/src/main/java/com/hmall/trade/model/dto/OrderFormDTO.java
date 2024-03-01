package com.hmall.trade.model.dto;

import com.hmall.api.dto.OrderDetailDTO;
import lombok.Data;

import java.util.List;

@Data
public class OrderFormDTO {
    private Long addressId;
    private Integer paymentType;
    private List<OrderDetailDTO> details;
}
