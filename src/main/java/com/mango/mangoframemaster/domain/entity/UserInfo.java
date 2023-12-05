package com.mango.mangoframemaster.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户信息表，存储用户详细信息
 * @TableName user_info
 */
@TableName(value ="user_info")
@Data
public class UserInfo implements Serializable {
    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer user_id;

    /**
     * 用户名，唯一
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码哈希值
     */
    @TableField(value = "password_hash")
    private String password_hash;

    /**
     * 密码哈希的盐值
     */
    @TableField(value = "password_salt")
    private String password_salt;

    /**
     * 用户真实姓名
     */
    @TableField(value = "full_name")
    private String full_name;

    /**
     * 电子邮件地址
     */
    @TableField(value = "email")
    private String email;

    /**
     * 手机号码
     */
    @TableField(value = "phone_number")
    private String phone_number;

    /**
     * 用户角色，默认为普通用户
     */
    @TableField(value = "role")
    private Object role;

    /**
     * 用户权限
     */
    @TableField(value = "permissions")
    private String permissions;

    /**
     * 账户状态，ACTIVE表示激活状态，INACTIVE表示未激活状态，LOCKED表示被锁定
     */
    @TableField(value = "account_status")
    private Object account_status;

    /**
     * 注册时的IP地址
     */
    @TableField(value = "registration_ip")
    private String registration_ip;

    /**
     * 最后登录时的IP地址
     */
    @TableField(value = "last_login_ip")
    private String last_login_ip;

    /**
     * 头像URL
     */
    @TableField(value = "avatar_url")
    private String avatar_url;

    /**
     * 用户网名
     */
    @TableField(value = "net_name")
    private String net_name;

    /**
     * 注册时间
     */
    @TableField(value = "registration_time")
    private Date registration_time;

    /**
     * 最后登录时间
     */
    @TableField(value = "last_login_time")
    private Date last_login_time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserInfo other = (UserInfo) that;
        return (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword_hash() == null ? other.getPassword_hash() == null : this.getPassword_hash().equals(other.getPassword_hash()))
            && (this.getPassword_salt() == null ? other.getPassword_salt() == null : this.getPassword_salt().equals(other.getPassword_salt()))
            && (this.getFull_name() == null ? other.getFull_name() == null : this.getFull_name().equals(other.getFull_name()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPhone_number() == null ? other.getPhone_number() == null : this.getPhone_number().equals(other.getPhone_number()))
            && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()))
            && (this.getPermissions() == null ? other.getPermissions() == null : this.getPermissions().equals(other.getPermissions()))
            && (this.getAccount_status() == null ? other.getAccount_status() == null : this.getAccount_status().equals(other.getAccount_status()))
            && (this.getRegistration_ip() == null ? other.getRegistration_ip() == null : this.getRegistration_ip().equals(other.getRegistration_ip()))
            && (this.getLast_login_ip() == null ? other.getLast_login_ip() == null : this.getLast_login_ip().equals(other.getLast_login_ip()))
            && (this.getAvatar_url() == null ? other.getAvatar_url() == null : this.getAvatar_url().equals(other.getAvatar_url()))
            && (this.getNet_name() == null ? other.getNet_name() == null : this.getNet_name().equals(other.getNet_name()))
            && (this.getRegistration_time() == null ? other.getRegistration_time() == null : this.getRegistration_time().equals(other.getRegistration_time()))
            && (this.getLast_login_time() == null ? other.getLast_login_time() == null : this.getLast_login_time().equals(other.getLast_login_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword_hash() == null) ? 0 : getPassword_hash().hashCode());
        result = prime * result + ((getPassword_salt() == null) ? 0 : getPassword_salt().hashCode());
        result = prime * result + ((getFull_name() == null) ? 0 : getFull_name().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPhone_number() == null) ? 0 : getPhone_number().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        result = prime * result + ((getPermissions() == null) ? 0 : getPermissions().hashCode());
        result = prime * result + ((getAccount_status() == null) ? 0 : getAccount_status().hashCode());
        result = prime * result + ((getRegistration_ip() == null) ? 0 : getRegistration_ip().hashCode());
        result = prime * result + ((getLast_login_ip() == null) ? 0 : getLast_login_ip().hashCode());
        result = prime * result + ((getAvatar_url() == null) ? 0 : getAvatar_url().hashCode());
        result = prime * result + ((getNet_name() == null) ? 0 : getNet_name().hashCode());
        result = prime * result + ((getRegistration_time() == null) ? 0 : getRegistration_time().hashCode());
        result = prime * result + ((getLast_login_time() == null) ? 0 : getLast_login_time().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", user_id=").append(user_id);
        sb.append(", username=").append(username);
        sb.append(", password_hash=").append(password_hash);
        sb.append(", password_salt=").append(password_salt);
        sb.append(", full_name=").append(full_name);
        sb.append(", email=").append(email);
        sb.append(", phone_number=").append(phone_number);
        sb.append(", role=").append(role);
        sb.append(", permissions=").append(permissions);
        sb.append(", account_status=").append(account_status);
        sb.append(", registration_ip=").append(registration_ip);
        sb.append(", last_login_ip=").append(last_login_ip);
        sb.append(", avatar_url=").append(avatar_url);
        sb.append(", net_name=").append(net_name);
        sb.append(", registration_time=").append(registration_time);
        sb.append(", last_login_time=").append(last_login_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}