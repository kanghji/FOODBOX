package com.groupfour.foodbox.service;

import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.mapper.UserMapper;
import com.groupfour.foodbox.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    // 회원 가입
    public int userRegister(UserDTO userDto) {
        int n = userMapper.userRegister(userDto);
        return n;
    }

    // 회원 리스트
    public List<UserDTO> userList() {
        List<UserDTO> userList = userMapper.userList();
        return userList;
    }

    // 회원 삭제
    public int userDelete(String user_no){
        int n = userMapper.userDelete(user_no);
        return n;
    }

    // 회원 선택 삭제
    public int usersDelete(List<String> chkList) {
        int n = userMapper.usersDelete(chkList);
        return n;
    }




//    // 회원 정보
//    public int userInfo(String user_name){
//        int n = userMapper.userInfo(user_name);
//        return n;
//    }


}
