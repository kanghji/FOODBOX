package com.groupfour.foodbox.service.user;

import com.groupfour.foodbox.domain.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserRegisterService {

    // 회원 가입
    int userRegister(UserDTO userDto);

    // 아이디 중복체크
    UserDTO checkUser_id(String user_id);

}