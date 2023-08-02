package com.groupfour.foodbox.mapper.admin;

import com.groupfour.foodbox.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    // 회원 리스트
    List<UserDTO> userList();

    // 회원 삭제
    int userDelete(int user_no);

    // 회원 선택삭제
    int usersDelete(List<String> chkList);

    // 회원 검색
    List<UserDTO> userSearch(String user_name, String user_gender);

    // 회원 정보
    UserDTO userInfo(int user_no);

    // 회원 수정
    void userModify(UserDTO userDto);


}
