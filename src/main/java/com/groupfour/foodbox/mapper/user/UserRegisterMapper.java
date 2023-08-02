package com.groupfour.foodbox.mapper.user;

import com.groupfour.foodbox.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRegisterMapper {

    // 회원 가입
    int userRegister(UserDTO userDto);

}