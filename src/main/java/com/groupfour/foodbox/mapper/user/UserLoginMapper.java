package com.groupfour.foodbox.mapper.user;

import com.groupfour.foodbox.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLoginMapper {

    // 로그인
     UserDTO userLogin(UserDTO userDto);


}
