package com.hmall.cart.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 订单详情表
 * </p>
 *
 * @author 虎哥
 * @since 2023-05-05
 */
@Data
public class CartVO
{
    private Long id;
    private Long itemId;
    private Integer num;
    private String name;
    private String spec;
    private Integer price;
    private Integer newPrice;
    private Integer status = 1;
    private Integer stock = 10;
    private String image;
    private LocalDateTime createTime;

}
