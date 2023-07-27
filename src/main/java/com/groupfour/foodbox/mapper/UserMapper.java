package com.groupfour.foodbox.mapper;

import com.groupfour.foodbox.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

   // 회원 가입
   int userRegister(UserDTO userDto);

   // 회원 리스트
   List<UserDTO> userList();

   // 회원 삭제
   int userDelete(String user_no);

   // 회원 선택삭제
   int usersDelete(List<String> chkList);

//   // 회원 정보
//   UserDTO userInfo(String user_no);
}
