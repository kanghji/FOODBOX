package com.groupfour.foodbox.service.user;

import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.mapper.admin.UserMapper;
import com.groupfour.foodbox.mapper.user.UserRegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    @Autowired
    private UserRegisterMapper userRegisterMapper;

    // 회원 가입
    @Override
    public int userRegister(UserDTO userDto) {
        int n = userRegisterMapper.userRegister(userDto);
        return n;
    }

}