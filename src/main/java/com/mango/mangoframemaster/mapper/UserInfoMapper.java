package com.mango.mangoframemaster.mapper;

import com.mango.mangoframemaster.domain.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author heliting
* @description 针对表【user_info(用户信息表，存储用户详细信息)】的数据库操作Mapper
* @createDate 2023-12-05 10:43:28
* @Entity com.mango.mangoframemaster.domain.entity.UserInfo
*/
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}




