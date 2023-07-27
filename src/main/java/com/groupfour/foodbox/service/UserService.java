package com.groupfour.foodbox.service;

import com.groupfour.foodbox.domain.UserDTO;

import java.util.List;

public interface UserService {

    // 회원 가입
    int userRegister(UserDTO userDto);

    // 회원 리스트
    List<UserDTO> userList();

    // 회원 삭제
    int userDelete(String user_no);

    // 회원 선택 삭제
    int usersDelete(List<String> chkList);

//    // 회원 정보
//    int userInfo(String user_name);
}
