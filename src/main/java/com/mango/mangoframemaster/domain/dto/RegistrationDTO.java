package com.mango.mangoframemaster.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author heliting
 */
@Data
public class RegistrationDTO {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "确认密码不能为空")
    private String confirmPassword;

    @NotBlank(message = "真实姓名不能为空")
    private String fullName;

    @NotBlank(message = "电子邮件地址不能为空")
    @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", message = "请输入有效的电子邮件地址")
    private String email;

    @NotBlank(message = "手机号码不能为空")
    @Pattern(regexp = "^1[3456789]\\d{9}$", message = "请输入有效的手机号码")
    private String phoneNumber;

    // 其他字段...

    // Getters and Setters

    // 构造函数...

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                // 其他字段...
                '}';
    }
}
