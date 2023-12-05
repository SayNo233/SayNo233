package com.mango.mangoframemaster.service;

import com.mango.mangoframemaster.domain.dto.RegistrationDTO;
import com.mango.mangoframemaster.domain.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;

/**
* @author heliting
* @description 针对表【user_info(用户信息表，存储用户详细信息)】的数据库操作Service
* @createDate 2023-12-05 10:43:28
*/
public interface UserInfoService extends IService<UserInfo> {
    boolean validatePassword(String inputUsername, String inputPassword);

    ResponseEntity<String> validateRegisterUser(RegistrationDTO registrationDTO);
}
