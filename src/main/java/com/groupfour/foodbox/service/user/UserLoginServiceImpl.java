package com.groupfour.foodbox.service.user;

import com.groupfour.foodbox.domain.UserDTO;
import com.groupfour.foodbox.mapper.user.UserLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    UserLoginMapper userLoginMapper;

    @Override
    public boolean userLogin(UserDTO userDto, HttpServletRequest req) {
        HttpSession session = req.getSession();

        // 아이디와 일치하는 회원정보를 DTO에 담아서 가져옴
        UserDTO userLoginDto = userLoginMapper.userLogin(userDto);

        if(userLoginDto != null){ // 일치하는 아이디가 있는 경우
            String inputPw= userDto.getUser_pw(); // 사용자가 입력한 비번
            String dbPw = userLoginDto.getUser_pw(); // DB 비번

            if(inputPw.equals(dbPw)){ // 비번 일치
                session.setAttribute("userLoginDto", userLoginDto);
                System.out.println("로그인 성공");
                return true;
            }else{ // 비번 불일치
                System.out.println("로그인 실패");
                return false;
            }
        }
        return false;
    }
}

