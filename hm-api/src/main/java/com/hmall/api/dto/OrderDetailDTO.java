package com.hmall.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 其它模块引入api，所以在其它模块中，不需要定义OrderDetailDTO，不然会发生导包冲突
 */
@Data
@Accessors(chain = true)
public class OrderDetailDTO
{
    private Long itemId;
    private Integer num;
}
