package com.mango.mangoframemaster.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mango.mangoframemaster.domain.dto.RegistrationDTO;
import com.mango.mangoframemaster.domain.entity.UserInfo;
import com.mango.mangoframemaster.service.UserInfoService;
import com.mango.mangoframemaster.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

/**
* @author heliting
* @description 针对表【user_info(用户信息表，存储用户详细信息)】的数据库操作Service实现
* @createDate 2023-12-05 10:43:28
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService {

    public UserInfoServiceImpl() {
        // 这里不再需要构造函数注入
    }
    /**
     * 验证密码
     *
     * @param inputUsername 输入的用户名
     * @param inputPassword 输入密码
     * @return boolean  如果密码匹配，返回 true；否则返回 false
     */
    @Override
    public boolean validatePassword(String inputUsername, String inputPassword) {
        // 创建查询条件，使用 lambda 表达式构建查询条件
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserInfo::getUsername, inputUsername);

        // 查询数据库，获取用户信息
        UserInfo user = getOne(queryWrapper);

        if (user == null) {
            // 用户不存在
            return false;
        }

        // 创建 BCryptPasswordEncoder 实例
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // 获取数据库中存储的密码哈希值
        String storedPasswordHash = user.getPassword_hash();

        // 比较哈希值，验证密码
        return passwordEncoder.matches(inputPassword, storedPasswordHash);
    }

    public ResponseEntity<String> validateRegisterUser(@Valid RegistrationDTO registrationDTO) {
        // 验证密码和确认密码是否一致
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            throw new RuntimeException("密码和确认密码不一致");
        }

        // 其他注册逻辑，比如检查用户名是否已经存在，检查邮箱是否已经被注册等
        // 验证注册数据
        if (!isValidRegistration(registrationDTO)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("无效的注册数据");
        }

        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(UserInfo::getUsername, registrationDTO.getUsername());

        // 检查用户名是否已被占用
        if (getOne(updateWrapper) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("用户名已被占用");
        }
        // 创建 BCryptPasswordEncoder 实例
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // 创建用户实体并设置相关信息
        UserInfo newUser = new UserInfo();
        newUser.setUsername(registrationDTO.getUsername());
        newUser.setPassword_hash(passwordEncoder.encode(registrationDTO.getPassword()));
        newUser.setEmail(registrationDTO.getEmail());
        newUser.setFull_name(registrationDTO.getFullName());
        newUser.setPhone_number(registrationDTO.getPhoneNumber());
        newUser.setRegistration_time(new java.util.Date());
        newUser.setLast_login_time(new java.util.Date());
        newUser.setAccount_status(1);
        newUser.setRole(1);
        newUser.setPermissions("user");

        // 保存用户到数据库
        save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body("用户注册成功");

    }

    // 用于验证注册数据的附加方法
    private boolean isValidRegistration(RegistrationDTO registrationDTO) {
        // 根据需求添加更多的验证逻辑
        return registrationDTO != null
                && registrationDTO.getUsername() != null
                && registrationDTO.getPassword() != null;
    }

}




