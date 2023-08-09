package com.groupfour.foodbox.mapper.user;

import com.groupfour.foodbox.domain.UserDTO;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import javax.servlet.http.HttpServletResponse;

@Mapper
public interface MypageMapper {

    UserDTO infoUpdateChk(String user_id);

    int pwUpdate(UserDTO userDTO);

    UserDTO infoList(String user_id);

    void infoUpdate(UserDTO userDTO);
}
