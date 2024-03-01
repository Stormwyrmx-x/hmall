package com.hmall.api.dto;

import lombok.Data;

/**
 * 其它模块引入api，所以在其它模块中，不需要定义ItemDTO，不然会发生导包冲突
 */
@Data
public class ItemDTO
{
    private Long id;
    private String name;
    private Integer price;
    private Integer stock;
    private String image;
    private String category;
    private String brand;
    private String spec;
    private Integer sold;
    private Integer commentCount;
    private Boolean isAD;
    private Integer status;
}
