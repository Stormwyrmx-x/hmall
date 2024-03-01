package com.hmall.user.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class LoginFormDTO
{
    @NotNull(message = "用户名不能为空")
    private String username;
    @NotNull(message = "密码不能为空")
    private String password;
    private Boolean rememberMe = false;
}
