package com.hmall.user.model.vo;

import lombok.Data;

@Data
public class UserLoginVO
{
    private String token;
    private Long userId;
    private String username;
    private Integer balance;
}
