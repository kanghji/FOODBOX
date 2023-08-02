package com.groupfour.foodbox.service.admin;

import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.mapper.admin.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    // 회원 리스트
    @Override
    public List<UserDTO> userList() {
        List<UserDTO> userList = userMapper.userList();
        return userList;
    }

    // 회원 삭제
    @Override
    public int userDelete(int user_no){
        int n = userMapper.userDelete(user_no);
        return n;
    }

    // 회원 선택 삭제
    @Override
    public int usersDelete(List<String> chkList) {
        int n = userMapper.usersDelete(chkList);
        return n;
    }

    // 회원 검색
    @Override
    public List<UserDTO> userSearch(String user_name, String user_gender) {
        List<UserDTO> list = userMapper.userSearch(user_name, user_gender);
        return list;
    }

    // 회원 정보
    @Override
    public UserDTO userInfo(int user_no){
        return userMapper.userInfo(user_no);
    }

    // 회원 수정
    @Override
    public void userModify(UserDTO userDto){
        userMapper.userModify(userDto);
    }


}