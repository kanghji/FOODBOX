package com.groupfour.foodbox.service.user;

import com.groupfour.foodbox.domain.UserDTO;

import javax.servlet.http.HttpServletResponse;

public interface MypageService {

    UserDTO infoUpdateChk(String user_id);

    int pwModify(UserDTO userDTO);

    UserDTO infoList(String user_id);

    void infoModify(UserDTO userDTO);
}
