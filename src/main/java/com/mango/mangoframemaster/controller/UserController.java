package com.mango.mangoframemaster.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mango.mangoframemaster.domain.dto.RegistrationDTO;
import com.mango.mangoframemaster.domain.entity.UserInfo;
import com.mango.mangoframemaster.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author heliting
 */
@RestController
@RequestMapping("/api/users")
@Controller
public class UserController {

    private final UserInfoService userInfoService;

    @Autowired
    public UserController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    /**
     * 登录用户
     *
     * @param username 用户名
     * @param password 密码
     * @return {@link ResponseEntity}<{@link String}>
     */
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String username, @RequestParam String password) {
        // 验证用户名和密码
        if (userInfoService.validatePassword(username, password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationDTO registrationDTO) {

        // 执行用户注册
        try {
            //            userInfoService.validateRegisterUser(registrationDTO);
            return userInfoService.validateRegisterUser(registrationDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("注册失败");
        }
    }

}
